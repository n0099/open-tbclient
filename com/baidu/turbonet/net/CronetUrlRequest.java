package com.baidu.turbonet.net;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.annotations.JNINamespace;
import com.baidu.turbonet.base.annotations.NativeClassQualifiedName;
import com.baidu.turbonet.net.TurbonetEngine;
import com.baidu.turbonet.net.UrlRequest;
import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import javax.annotation.concurrent.GuardedBy;
/* JADX INFO: Access modifiers changed from: package-private */
@JNINamespace
/* loaded from: classes5.dex */
public final class CronetUrlRequest implements UrlRequest {
    private static final TurbonetEngine.UrlRequestMetrics oJN = new TurbonetEngine.UrlRequestMetrics(null, null, null, null);
    private final boolean mDisableCache;
    private final boolean mDisableConnectionMigration;
    private final Executor mExecutor;
    private String mInitialMethod;
    private final String mInitialUrl;
    private Runnable mOnDestroyedCallbackForTesting;
    private final int mPriority;
    private final Collection<Object> mRequestAnnotations;
    private Object mTag;
    @GuardedBy("mUrlRequestAdapterLock")
    private long mUrlRequestAdapter;
    private UrlResponseInfo oJC;
    @Nullable
    @GuardedBy("mUrlRequestAdapterLock")
    private final b oJO;
    private long oJP;
    private final UrlRequest.Callback oJQ;
    private String oJR;
    private String oJS;
    private String oJT;
    private String oJU;
    private String oJV;
    private String oJW;
    private String oJX;
    private long oJY;
    private long oJZ;
    private final CronetUrlRequestContext oJy;
    private long oKa;
    private long oKb;
    private long oKc;
    private RequestTimeInfo oKd;
    private final boolean oKf;
    private boolean oKg;
    private boolean oKh;
    private int oKi;
    private int oKj;
    private int oKk;
    private int oKl;
    private String oKm;
    private String oKn;
    private CronetUploadDataStream oKo;
    private a oKp;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mStarted = false;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mWaitingOnRedirect = false;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mWaitingOnRead = false;
    private final Object mUrlRequestAdapterLock = new Object();
    private final List<String> mUrlChain = new ArrayList();
    private final HeadersList oKe = new HeadersList();

    /* loaded from: classes5.dex */
    public static class SpendTimeType {
    }

    @NativeClassQualifiedName
    private native boolean nativeAddRequestHeader(long j, String str, String str2);

    private native long nativeCreateRequestAdapter(long j, String str, int i, boolean z, boolean z2, boolean z3);

    @NativeClassQualifiedName
    private native void nativeDestroy(long j, boolean z);

    @NativeClassQualifiedName
    private native void nativeDisableResponseAutoUngzip(long j);

    @NativeClassQualifiedName
    private native void nativeEnableBrotliByRequest(long j);

    @NativeClassQualifiedName
    private native void nativeFollowDeferredRedirect(long j);

    @NativeClassQualifiedName
    private native String nativeGetConnectionAttempts(long j, boolean z);

    @NativeClassQualifiedName
    private native String nativeGetDNSErrorCode(long j);

    @NativeClassQualifiedName
    private native String nativeGetDNSNameServers(long j);

    @NativeClassQualifiedName
    private native String nativeGetDNSResults(long j);

    @NativeClassQualifiedName
    private native String nativeGetRemoteEndpoint(long j);

    @NativeClassQualifiedName
    private native RequestTimeInfo nativeGetRequestTimeInfo(long j);

    @NativeClassQualifiedName
    private native void nativeGetStatus(long j, UrlRequest.StatusListener statusListener);

    @NativeClassQualifiedName
    private native String nativeGetSuperPipeInfo(long j);

    @NativeClassQualifiedName
    private native boolean nativeReadData(long j, ByteBuffer byteBuffer, int i, int i2);

    @NativeClassQualifiedName
    private native long nativeRequestTimeGap(long j, int i);

    @NativeClassQualifiedName
    private native void nativeSetDestinationAddress(long j, String str);

    @NativeClassQualifiedName
    private native boolean nativeSetHttpMethod(long j, String str);

    @NativeClassQualifiedName
    private native void nativeSetRequestTag(long j, String str);

    @NativeClassQualifiedName
    private native void nativeSetResponseBodyReadTimeout(long j, int i);

    @NativeClassQualifiedName
    private native void nativeSetResponseHeaderRecvTimeout(long j, int i);

    @NativeClassQualifiedName
    private native void nativeSetTCPConnectTimeout(long j, int i);

    @NativeClassQualifiedName
    private native void nativeSetTimeout(long j, int i);

    @NativeClassQualifiedName
    private native void nativeStart(long j);

    @NativeClassQualifiedName
    private native int nativeSynGetStatus(long j);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class HeadersList extends ArrayList<Map.Entry<String, String>> {
        private HeadersList() {
        }
    }

    /* loaded from: classes5.dex */
    private final class a implements Runnable {
        ByteBuffer mByteBuffer;

        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ByteBuffer byteBuffer = this.mByteBuffer;
            this.mByteBuffer = null;
            try {
                synchronized (CronetUrlRequest.this.mUrlRequestAdapterLock) {
                    if (!CronetUrlRequest.this.isDoneLocked()) {
                        CronetUrlRequest.this.mWaitingOnRead = true;
                        CronetUrlRequest.this.oJQ.a(CronetUrlRequest.this, CronetUrlRequest.this.oJC, byteBuffer);
                    }
                }
            } catch (Exception e) {
                CronetUrlRequest.this.onCallbackException(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CronetUrlRequest(CronetUrlRequestContext cronetUrlRequestContext, String str, int i, UrlRequest.Callback callback, Executor executor, Collection<Object> collection, boolean z, boolean z2, boolean z3, boolean z4) {
        if (str == null) {
            throw new NullPointerException("URL is required");
        }
        if (callback == null) {
            throw new NullPointerException("Listener is required");
        }
        if (executor == null) {
            throw new NullPointerException("Executor is required");
        }
        if (collection == null) {
            throw new NullPointerException("requestAnnotations is required");
        }
        this.oJy = cronetUrlRequestContext;
        this.mInitialUrl = str;
        this.mUrlChain.add(str);
        this.mPriority = Oa(i);
        this.oJQ = callback;
        this.mExecutor = executor;
        this.mRequestAnnotations = collection;
        this.oJO = z ? new b() : null;
        this.mDisableCache = z2;
        this.mDisableConnectionMigration = z3;
        this.oKf = z4;
        this.oKg = false;
        this.oKh = false;
        this.oKi = 0;
        this.oKj = 0;
        this.oKk = 0;
        this.oKl = 0;
        this.mTag = null;
        this.oKm = null;
        this.oKn = null;
        this.oJC = new UrlResponseInfo(new ArrayList(this.mUrlChain), 0, "", new HeadersList(), false, "", "");
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setHttpMethod(String str) {
        checkNotStarted();
        if (str == null) {
            throw new NullPointerException("Method is required.");
        }
        this.mInitialMethod = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void addHeader(String str, String str2) {
        checkNotStarted();
        if (str == null) {
            throw new NullPointerException("Invalid header name.");
        }
        if (str2 == null) {
            throw new NullPointerException("Invalid header value.");
        }
        this.oKe.add(new AbstractMap.SimpleImmutableEntry(str, str2));
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void a(UploadDataProvider uploadDataProvider, Executor executor) {
        if (uploadDataProvider == null) {
            throw new NullPointerException("Invalid UploadDataProvider.");
        }
        if (this.mInitialMethod == null) {
            this.mInitialMethod = "POST";
        }
        this.oKo = new CronetUploadDataStream(uploadDataProvider, executor, this);
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void start() {
        synchronized (this.mUrlRequestAdapterLock) {
            com.baidu.turbonet.base.a.i("ChromiumNetwork", "****** Request start, url is: %s", this.mInitialUrl);
            checkNotStarted();
            try {
                this.mUrlRequestAdapter = nativeCreateRequestAdapter(this.oJy.getUrlRequestContextAdapter(), this.mInitialUrl, this.mPriority, this.mDisableCache, this.mDisableConnectionMigration, this.oKf);
                this.oJy.onRequestStarted();
                if (this.mInitialMethod != null && !nativeSetHttpMethod(this.mUrlRequestAdapter, this.mInitialMethod)) {
                    throw new IllegalArgumentException("Invalid http method " + this.mInitialMethod);
                }
                if (this.mTag != null) {
                    this.oJy.a(this);
                }
                if (this.oKg) {
                    nativeDisableResponseAutoUngzip(this.mUrlRequestAdapter);
                }
                if (this.oKh) {
                    nativeEnableBrotliByRequest(this.mUrlRequestAdapter);
                }
                if (this.oKi > 0) {
                    nativeSetTimeout(this.mUrlRequestAdapter, this.oKi);
                }
                if (this.oKj > 0) {
                    nativeSetTCPConnectTimeout(this.mUrlRequestAdapter, this.oKj);
                }
                if (this.oKk > 0) {
                    nativeSetResponseHeaderRecvTimeout(this.mUrlRequestAdapter, this.oKk);
                }
                if (this.oKl > 0) {
                    nativeSetResponseBodyReadTimeout(this.mUrlRequestAdapter, this.oKl);
                }
                if (!TextUtils.isEmpty(this.oKm)) {
                    nativeSetDestinationAddress(this.mUrlRequestAdapter, this.oKm);
                }
                if (!TextUtils.isEmpty(this.oKn)) {
                    nativeSetRequestTag(this.mUrlRequestAdapter, this.oKn);
                }
                Iterator<Map.Entry<String, String>> it = this.oKe.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    boolean z2 = (!next.getKey().equalsIgnoreCase("Content-Type") || next.getValue().isEmpty()) ? z : true;
                    if (!nativeAddRequestHeader(this.mUrlRequestAdapter, next.getKey(), next.getValue())) {
                        throw new IllegalArgumentException("Invalid header " + next.getKey() + "=" + next.getValue());
                    }
                    z = z2;
                }
                if (this.oKo != null) {
                    if (!z) {
                        throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
                    }
                    this.mStarted = true;
                    this.oKo.postTaskToExecutor(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CronetUrlRequest.this.oKo.initializeWithRequest();
                            synchronized (CronetUrlRequest.this.mUrlRequestAdapterLock) {
                                if (!CronetUrlRequest.this.isDoneLocked()) {
                                    CronetUrlRequest.this.oKo.attachNativeAdapterToRequest(CronetUrlRequest.this.mUrlRequestAdapter);
                                    CronetUrlRequest.this.ehC();
                                }
                            }
                        }
                    });
                    return;
                }
                this.mStarted = true;
                ehC();
            } catch (RuntimeException e) {
                Ae(false);
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public void ehC() {
        if (this.oJO != null) {
            this.oJO.onRequestStarted();
        }
        nativeStart(this.mUrlRequestAdapter);
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void followRedirect() {
        synchronized (this.mUrlRequestAdapterLock) {
            if (!this.mWaitingOnRedirect) {
                throw new IllegalStateException("No redirect to follow.");
            }
            this.mWaitingOnRedirect = false;
            if (!isDoneLocked()) {
                nativeFollowDeferredRedirect(this.mUrlRequestAdapter);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void read(ByteBuffer byteBuffer) {
        com.baidu.turbonet.net.b.o(byteBuffer);
        com.baidu.turbonet.net.b.n(byteBuffer);
        synchronized (this.mUrlRequestAdapterLock) {
            if (!this.mWaitingOnRead) {
                throw new IllegalStateException("Unexpected read attempt.");
            }
            this.mWaitingOnRead = false;
            if (!isDoneLocked()) {
                if (!nativeReadData(this.mUrlRequestAdapter, byteBuffer, byteBuffer.position(), byteBuffer.limit())) {
                    this.mWaitingOnRead = true;
                    throw new IllegalArgumentException("Unable to call native read");
                }
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void cancel() {
        synchronized (this.mUrlRequestAdapterLock) {
            com.baidu.turbonet.base.a.i("ChromiumNetwork", "****** Request cancel, url is: %s", this.mInitialUrl);
            if (!isDoneLocked() && this.mStarted) {
                Ae(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public boolean isDoneLocked() {
        return this.mStarted && this.mUrlRequestAdapter == 0;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void ehD() {
        checkNotStarted();
        this.oKg = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void ehE() {
        checkNotStarted();
        this.oKh = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setTimeout(int i) {
        checkNotStarted();
        this.oKi = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void NX(int i) {
        checkNotStarted();
        this.oKj = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void NY(int i) {
        checkNotStarted();
        this.oKk = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void NZ(int i) {
        checkNotStarted();
        this.oKl = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setTag(Object obj) {
        checkNotStarted();
        this.mTag = obj;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void WU(String str) {
        checkNotStarted();
        this.oKm = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void WV(String str) {
        checkNotStarted();
        this.oKn = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public Object getTag() {
        return this.mTag;
    }

    @CalledByNative
    public static RequestTimeInfo createObject(long j, long j2, long j3, long j4, long j5) {
        return new RequestTimeInfo(j, j2, j3, j4, j5);
    }

    private void postTaskToExecutor(Runnable runnable) {
        try {
            this.mExecutor.execute(runnable);
        } catch (RejectedExecutionException e) {
            com.baidu.turbonet.base.a.e("ChromiumNetwork", "Exception posting task to executor", e);
            Ae(false);
        }
    }

    private static int Oa(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
            default:
                return 3;
            case 4:
                return 4;
        }
    }

    private UrlResponseInfo a(int i, String str, String[] strArr, boolean z, String str2, String str3) {
        HeadersList headersList = new HeadersList();
        for (int i2 = 0; i2 < strArr.length; i2 += 2) {
            headersList.add(new AbstractMap.SimpleImmutableEntry(strArr[i2], strArr[i2 + 1]));
        }
        return new UrlResponseInfo(new ArrayList(this.mUrlChain), i, str, headersList, z, str2, str3);
    }

    private void checkNotStarted() {
        synchronized (this.mUrlRequestAdapterLock) {
            if (this.mStarted || isDoneLocked()) {
                throw new IllegalStateException("Request is already started.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ae(boolean z) {
        synchronized (this.mUrlRequestAdapterLock) {
            if (this.mUrlRequestAdapter != 0) {
                String nativeGetDNSNameServers = nativeGetDNSNameServers(this.mUrlRequestAdapter);
                if (!nativeGetDNSNameServers.isEmpty()) {
                    this.oJS = nativeGetDNSNameServers;
                }
                String nativeGetDNSResults = nativeGetDNSResults(this.mUrlRequestAdapter);
                if (!nativeGetDNSResults.isEmpty()) {
                    this.oJR = nativeGetDNSResults;
                }
                String nativeGetDNSErrorCode = nativeGetDNSErrorCode(this.mUrlRequestAdapter);
                if (!nativeGetDNSErrorCode.isEmpty()) {
                    this.oJT = nativeGetDNSErrorCode;
                }
                String nativeGetConnectionAttempts = nativeGetConnectionAttempts(this.mUrlRequestAdapter, false);
                if (!nativeGetConnectionAttempts.isEmpty()) {
                    this.oJU = nativeGetConnectionAttempts;
                }
                String nativeGetConnectionAttempts2 = nativeGetConnectionAttempts(this.mUrlRequestAdapter, true);
                if (!nativeGetConnectionAttempts2.isEmpty()) {
                    this.oJV = nativeGetConnectionAttempts2;
                }
                String nativeGetRemoteEndpoint = nativeGetRemoteEndpoint(this.mUrlRequestAdapter);
                if (!nativeGetRemoteEndpoint.isEmpty()) {
                    this.oJW = nativeGetRemoteEndpoint;
                }
                String nativeGetSuperPipeInfo = nativeGetSuperPipeInfo(this.mUrlRequestAdapter);
                if (!nativeGetSuperPipeInfo.isEmpty()) {
                    this.oJX = nativeGetSuperPipeInfo;
                }
                long nativeRequestTimeGap = nativeRequestTimeGap(this.mUrlRequestAdapter, 1);
                if (nativeRequestTimeGap >= 0) {
                    this.oJY = nativeRequestTimeGap;
                }
                long nativeRequestTimeGap2 = nativeRequestTimeGap(this.mUrlRequestAdapter, 2);
                if (nativeRequestTimeGap2 >= 0) {
                    this.oJZ = nativeRequestTimeGap2;
                }
                long nativeRequestTimeGap3 = nativeRequestTimeGap(this.mUrlRequestAdapter, 3);
                if (nativeRequestTimeGap3 >= 0) {
                    this.oKa = nativeRequestTimeGap3;
                }
                long nativeRequestTimeGap4 = nativeRequestTimeGap(this.mUrlRequestAdapter, 4);
                if (nativeRequestTimeGap4 >= 0) {
                    this.oKb = nativeRequestTimeGap4;
                }
                long nativeRequestTimeGap5 = nativeRequestTimeGap(this.mUrlRequestAdapter, 5);
                if (nativeRequestTimeGap5 >= 0) {
                    this.oKc = nativeRequestTimeGap5;
                }
                this.oKd = nativeGetRequestTimeInfo(this.mUrlRequestAdapter);
                if (this.oKd == null) {
                    this.oKd = new RequestTimeInfo();
                }
                if (this.oJO != null) {
                    this.oJO.ehF();
                }
                nativeDestroy(this.mUrlRequestAdapter, z);
                if (this.mTag != null) {
                    this.oJy.b(this);
                }
                this.oJy.onRequestDestroyed();
                this.mUrlRequestAdapter = 0L;
                if (this.mOnDestroyedCallbackForTesting != null) {
                    this.mOnDestroyedCallbackForTesting.run();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCallbackException(Exception exc) {
        UrlRequestException urlRequestException = new UrlRequestException("Exception received from UrlRequest.Callback", exc);
        com.baidu.turbonet.base.a.e("ChromiumNetwork", "Exception in CalledByNative method", exc);
        synchronized (this.mUrlRequestAdapterLock) {
            if (!isDoneLocked()) {
                Ae(false);
                try {
                    this.oJQ.a(this, this.oJC, urlRequestException);
                } catch (Exception e) {
                    com.baidu.turbonet.base.a.e("ChromiumNetwork", "Exception notifying of failed request", e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onUploadException(Throwable th) {
        UrlRequestException urlRequestException = new UrlRequestException("Exception received from UploadDataProvider", th);
        com.baidu.turbonet.base.a.e("ChromiumNetwork", "Exception in upload method", th);
        a(urlRequestException);
    }

    private void a(final UrlRequestException urlRequestException) {
        postTaskToExecutor(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.mUrlRequestAdapterLock) {
                    if (!CronetUrlRequest.this.isDoneLocked()) {
                        CronetUrlRequest.this.Ae(false);
                        try {
                            CronetUrlRequest.this.oJQ.a(CronetUrlRequest.this, CronetUrlRequest.this.oJC, urlRequestException);
                        } catch (Exception e) {
                            com.baidu.turbonet.base.a.e("ChromiumNetwork", "Exception in onError method", e);
                        }
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onRedirectReceived(final String str, int i, String str2, String[] strArr, boolean z, String str3, String str4, long j) {
        final UrlResponseInfo a2 = a(i, str2, strArr, z, str3, str4);
        this.oJP += j;
        a2.hQ(this.oJP);
        this.mUrlChain.add(str);
        postTaskToExecutor(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.mUrlRequestAdapterLock) {
                    if (!CronetUrlRequest.this.isDoneLocked()) {
                        CronetUrlRequest.this.mWaitingOnRedirect = true;
                        try {
                            CronetUrlRequest.this.oJQ.a(CronetUrlRequest.this, a2, str);
                        } catch (Exception e) {
                            CronetUrlRequest.this.onCallbackException(e);
                        }
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onResponseStarted(int i, String str, String[] strArr, boolean z, String str2, String str3) {
        this.oJC = a(i, str, strArr, z, str2, str3);
        postTaskToExecutor(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.mUrlRequestAdapterLock) {
                    if (!CronetUrlRequest.this.isDoneLocked()) {
                        if (CronetUrlRequest.this.oJO != null) {
                            CronetUrlRequest.this.oJO.ehG();
                        }
                        CronetUrlRequest.this.mWaitingOnRead = true;
                        try {
                            CronetUrlRequest.this.oJQ.a(CronetUrlRequest.this, CronetUrlRequest.this.oJC);
                        } catch (Exception e) {
                            CronetUrlRequest.this.onCallbackException(e);
                        }
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onReadCompleted(ByteBuffer byteBuffer, int i, int i2, int i3, long j) {
        this.oJC.hQ(this.oJP + j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            a(new UrlRequestException("ByteBuffer modified externally during read", null));
            return;
        }
        if (this.oKp == null) {
            this.oKp = new a();
        }
        byteBuffer.position(i2 + i);
        this.oKp.mByteBuffer = byteBuffer;
        postTaskToExecutor(this.oKp);
    }

    @CalledByNative
    private void onSucceeded(long j) {
        this.oJC.hQ(this.oJP + j);
        postTaskToExecutor(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.mUrlRequestAdapterLock) {
                    if (!CronetUrlRequest.this.isDoneLocked()) {
                        CronetUrlRequest.this.Ae(false);
                        try {
                            CronetUrlRequest.this.oJQ.b(CronetUrlRequest.this, CronetUrlRequest.this.oJC);
                        } catch (Exception e) {
                            com.baidu.turbonet.base.a.e("ChromiumNetwork", "Exception in onComplete method", e);
                        }
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onError(int i, int i2, int i3, String str, long j) {
        if (this.oJC != null) {
            this.oJC.hQ(this.oJP + j);
        }
        a(new UrlRequestException("Exception in CronetUrlRequest: " + str, i, i2));
    }

    @CalledByNative
    private void onCanceled() {
        postTaskToExecutor(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.turbonet.base.a.e("ChromiumNetwork", "****** onCanceled, url is: %s", CronetUrlRequest.this.oJC.getUrl());
                    CronetUrlRequest.this.oJQ.c(CronetUrlRequest.this, CronetUrlRequest.this.oJC);
                } catch (Exception e) {
                    com.baidu.turbonet.base.a.e("ChromiumNetwork", "Exception in onCanceled method", e);
                }
            }
        });
    }

    @CalledByNative
    private void onStatus(final UrlRequest.StatusListener statusListener, final int i) {
        postTaskToExecutor(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.7
            @Override // java.lang.Runnable
            public void run() {
                statusListener.onStatus(UrlRequest.Status.Om(i));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class b {
        @Nullable
        private Long oKu;
        @Nullable
        private Long oKv;
        @Nullable
        private Long oKw;

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onRequestStarted() {
            if (this.oKu != null) {
                throw new IllegalStateException("onRequestStarted called repeatedly");
            }
            this.oKu = Long.valueOf(SystemClock.elapsedRealtime());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ehF() {
            if (this.oKu != null && this.oKw == null) {
                this.oKw = Long.valueOf(SystemClock.elapsedRealtime() - this.oKu.longValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ehG() {
            if (this.oKu != null && this.oKv == null) {
                this.oKv = Long.valueOf(SystemClock.elapsedRealtime() - this.oKu.longValue());
            }
        }
    }
}
