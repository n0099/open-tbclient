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
    private static final TurbonetEngine.UrlRequestMetrics oRX = new TurbonetEngine.UrlRequestMetrics(null, null, null, null);
    private final boolean mDisableCache;
    private final boolean mDisableConnectionMigration;
    private final Executor mExecutor;
    private String mInitialMethod;
    private final String mInitialUrl;
    private Runnable mOnDestroyedCallbackForTesting;
    private final int mPriority;
    private final Collection<Object> mRequestAnnotations;
    private Object mTag;
    private int mTimeout;
    @GuardedBy("mUrlRequestAdapterLock")
    private long mUrlRequestAdapter;
    private final CronetUrlRequestContext oRI;
    private UrlResponseInfo oRM;
    @Nullable
    @GuardedBy("mUrlRequestAdapterLock")
    private final b oRY;
    private long oRZ;
    private final UrlRequest.Callback oSa;
    private String oSb;
    private String oSc;
    private String oSd;
    private String oSe;
    private String oSf;
    private String oSg;
    private String oSh;
    private long oSi;
    private long oSj;
    private long oSk;
    private long oSl;
    private long oSm;
    private RequestTimeInfo oSn;
    private final boolean oSp;
    private boolean oSq;
    private boolean oSr;
    private int oSs;
    private int oSt;
    private int oSu;
    private String oSv;
    private String oSw;
    private CronetUploadDataStream oSx;
    private a oSy;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mStarted = false;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mWaitingOnRedirect = false;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mWaitingOnRead = false;
    private final Object mUrlRequestAdapterLock = new Object();
    private final List<String> mUrlChain = new ArrayList();
    private final HeadersList oSo = new HeadersList();

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
                        CronetUrlRequest.this.oSa.a(CronetUrlRequest.this, CronetUrlRequest.this.oRM, byteBuffer);
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
        this.oRI = cronetUrlRequestContext;
        this.mInitialUrl = str;
        this.mUrlChain.add(str);
        this.mPriority = MU(i);
        this.oSa = callback;
        this.mExecutor = executor;
        this.mRequestAnnotations = collection;
        this.oRY = z ? new b() : null;
        this.mDisableCache = z2;
        this.mDisableConnectionMigration = z3;
        this.oSp = z4;
        this.oSq = false;
        this.oSr = false;
        this.mTimeout = 0;
        this.oSs = 0;
        this.oSt = 0;
        this.oSu = 0;
        this.mTag = null;
        this.oSv = null;
        this.oSw = null;
        this.oRM = new UrlResponseInfo(new ArrayList(this.mUrlChain), 0, "", new HeadersList(), false, "", "");
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
        this.oSo.add(new AbstractMap.SimpleImmutableEntry(str, str2));
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void a(UploadDataProvider uploadDataProvider, Executor executor) {
        if (uploadDataProvider == null) {
            throw new NullPointerException("Invalid UploadDataProvider.");
        }
        if (this.mInitialMethod == null) {
            this.mInitialMethod = "POST";
        }
        this.oSx = new CronetUploadDataStream(uploadDataProvider, executor, this);
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void start() {
        synchronized (this.mUrlRequestAdapterLock) {
            com.baidu.turbonet.base.a.i("ChromiumNetwork", "****** Request start, url is: %s", this.mInitialUrl);
            checkNotStarted();
            try {
                this.mUrlRequestAdapter = nativeCreateRequestAdapter(this.oRI.getUrlRequestContextAdapter(), this.mInitialUrl, this.mPriority, this.mDisableCache, this.mDisableConnectionMigration, this.oSp);
                this.oRI.onRequestStarted();
                if (this.mInitialMethod != null && !nativeSetHttpMethod(this.mUrlRequestAdapter, this.mInitialMethod)) {
                    throw new IllegalArgumentException("Invalid http method " + this.mInitialMethod);
                }
                if (this.mTag != null) {
                    this.oRI.a(this);
                }
                if (this.oSq) {
                    nativeDisableResponseAutoUngzip(this.mUrlRequestAdapter);
                }
                if (this.oSr) {
                    nativeEnableBrotliByRequest(this.mUrlRequestAdapter);
                }
                if (this.mTimeout > 0) {
                    nativeSetTimeout(this.mUrlRequestAdapter, this.mTimeout);
                }
                if (this.oSs > 0) {
                    nativeSetTCPConnectTimeout(this.mUrlRequestAdapter, this.oSs);
                }
                if (this.oSt > 0) {
                    nativeSetResponseHeaderRecvTimeout(this.mUrlRequestAdapter, this.oSt);
                }
                if (this.oSu > 0) {
                    nativeSetResponseBodyReadTimeout(this.mUrlRequestAdapter, this.oSu);
                }
                if (!TextUtils.isEmpty(this.oSv)) {
                    nativeSetDestinationAddress(this.mUrlRequestAdapter, this.oSv);
                }
                if (!TextUtils.isEmpty(this.oSw)) {
                    nativeSetRequestTag(this.mUrlRequestAdapter, this.oSw);
                }
                Iterator<Map.Entry<String, String>> it = this.oSo.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    boolean z2 = (!next.getKey().equalsIgnoreCase("Content-Type") || next.getValue().isEmpty()) ? z : true;
                    if (!nativeAddRequestHeader(this.mUrlRequestAdapter, next.getKey(), next.getValue())) {
                        throw new IllegalArgumentException("Invalid header " + next.getKey() + "=" + next.getValue());
                    }
                    z = z2;
                }
                if (this.oSx != null) {
                    if (!z) {
                        throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
                    }
                    this.mStarted = true;
                    this.oSx.postTaskToExecutor(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CronetUrlRequest.this.oSx.initializeWithRequest();
                            synchronized (CronetUrlRequest.this.mUrlRequestAdapterLock) {
                                if (!CronetUrlRequest.this.isDoneLocked()) {
                                    CronetUrlRequest.this.oSx.attachNativeAdapterToRequest(CronetUrlRequest.this.mUrlRequestAdapter);
                                    CronetUrlRequest.this.egs();
                                }
                            }
                        }
                    });
                    return;
                }
                this.mStarted = true;
                egs();
            } catch (RuntimeException e) {
                As(false);
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public void egs() {
        if (this.oRY != null) {
            this.oRY.onRequestStarted();
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
                As(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public boolean isDoneLocked() {
        return this.mStarted && this.mUrlRequestAdapter == 0;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void egt() {
        checkNotStarted();
        this.oSq = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void egu() {
        checkNotStarted();
        this.oSr = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setTimeout(int i) {
        checkNotStarted();
        this.mTimeout = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void MR(int i) {
        checkNotStarted();
        this.oSs = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void MS(int i) {
        checkNotStarted();
        this.oSt = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void MT(int i) {
        checkNotStarted();
        this.oSu = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setTag(Object obj) {
        checkNotStarted();
        this.mTag = obj;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Xf(String str) {
        checkNotStarted();
        this.oSv = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Xg(String str) {
        checkNotStarted();
        this.oSw = str;
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
            As(false);
        }
    }

    private static int MU(int i) {
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
    public void As(boolean z) {
        synchronized (this.mUrlRequestAdapterLock) {
            if (this.mUrlRequestAdapter != 0) {
                String nativeGetDNSNameServers = nativeGetDNSNameServers(this.mUrlRequestAdapter);
                if (!nativeGetDNSNameServers.isEmpty()) {
                    this.oSc = nativeGetDNSNameServers;
                }
                String nativeGetDNSResults = nativeGetDNSResults(this.mUrlRequestAdapter);
                if (!nativeGetDNSResults.isEmpty()) {
                    this.oSb = nativeGetDNSResults;
                }
                String nativeGetDNSErrorCode = nativeGetDNSErrorCode(this.mUrlRequestAdapter);
                if (!nativeGetDNSErrorCode.isEmpty()) {
                    this.oSd = nativeGetDNSErrorCode;
                }
                String nativeGetConnectionAttempts = nativeGetConnectionAttempts(this.mUrlRequestAdapter, false);
                if (!nativeGetConnectionAttempts.isEmpty()) {
                    this.oSe = nativeGetConnectionAttempts;
                }
                String nativeGetConnectionAttempts2 = nativeGetConnectionAttempts(this.mUrlRequestAdapter, true);
                if (!nativeGetConnectionAttempts2.isEmpty()) {
                    this.oSf = nativeGetConnectionAttempts2;
                }
                String nativeGetRemoteEndpoint = nativeGetRemoteEndpoint(this.mUrlRequestAdapter);
                if (!nativeGetRemoteEndpoint.isEmpty()) {
                    this.oSg = nativeGetRemoteEndpoint;
                }
                String nativeGetSuperPipeInfo = nativeGetSuperPipeInfo(this.mUrlRequestAdapter);
                if (!nativeGetSuperPipeInfo.isEmpty()) {
                    this.oSh = nativeGetSuperPipeInfo;
                }
                long nativeRequestTimeGap = nativeRequestTimeGap(this.mUrlRequestAdapter, 1);
                if (nativeRequestTimeGap >= 0) {
                    this.oSi = nativeRequestTimeGap;
                }
                long nativeRequestTimeGap2 = nativeRequestTimeGap(this.mUrlRequestAdapter, 2);
                if (nativeRequestTimeGap2 >= 0) {
                    this.oSj = nativeRequestTimeGap2;
                }
                long nativeRequestTimeGap3 = nativeRequestTimeGap(this.mUrlRequestAdapter, 3);
                if (nativeRequestTimeGap3 >= 0) {
                    this.oSk = nativeRequestTimeGap3;
                }
                long nativeRequestTimeGap4 = nativeRequestTimeGap(this.mUrlRequestAdapter, 4);
                if (nativeRequestTimeGap4 >= 0) {
                    this.oSl = nativeRequestTimeGap4;
                }
                long nativeRequestTimeGap5 = nativeRequestTimeGap(this.mUrlRequestAdapter, 5);
                if (nativeRequestTimeGap5 >= 0) {
                    this.oSm = nativeRequestTimeGap5;
                }
                this.oSn = nativeGetRequestTimeInfo(this.mUrlRequestAdapter);
                if (this.oSn == null) {
                    this.oSn = new RequestTimeInfo();
                }
                if (this.oRY != null) {
                    this.oRY.egv();
                }
                nativeDestroy(this.mUrlRequestAdapter, z);
                if (this.mTag != null) {
                    this.oRI.b(this);
                }
                this.oRI.onRequestDestroyed();
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
                As(false);
                try {
                    this.oSa.a(this, this.oRM, urlRequestException);
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
                        CronetUrlRequest.this.As(false);
                        try {
                            CronetUrlRequest.this.oSa.a(CronetUrlRequest.this, CronetUrlRequest.this.oRM, urlRequestException);
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
        this.oRZ += j;
        a2.hT(this.oRZ);
        this.mUrlChain.add(str);
        postTaskToExecutor(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.mUrlRequestAdapterLock) {
                    if (!CronetUrlRequest.this.isDoneLocked()) {
                        CronetUrlRequest.this.mWaitingOnRedirect = true;
                        try {
                            CronetUrlRequest.this.oSa.a(CronetUrlRequest.this, a2, str);
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
        this.oRM = a(i, str, strArr, z, str2, str3);
        postTaskToExecutor(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.mUrlRequestAdapterLock) {
                    if (!CronetUrlRequest.this.isDoneLocked()) {
                        if (CronetUrlRequest.this.oRY != null) {
                            CronetUrlRequest.this.oRY.egw();
                        }
                        CronetUrlRequest.this.mWaitingOnRead = true;
                        try {
                            CronetUrlRequest.this.oSa.a(CronetUrlRequest.this, CronetUrlRequest.this.oRM);
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
        this.oRM.hT(this.oRZ + j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            a(new UrlRequestException("ByteBuffer modified externally during read", null));
            return;
        }
        if (this.oSy == null) {
            this.oSy = new a();
        }
        byteBuffer.position(i2 + i);
        this.oSy.mByteBuffer = byteBuffer;
        postTaskToExecutor(this.oSy);
    }

    @CalledByNative
    private void onSucceeded(long j) {
        this.oRM.hT(this.oRZ + j);
        postTaskToExecutor(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.mUrlRequestAdapterLock) {
                    if (!CronetUrlRequest.this.isDoneLocked()) {
                        CronetUrlRequest.this.As(false);
                        try {
                            CronetUrlRequest.this.oSa.b(CronetUrlRequest.this, CronetUrlRequest.this.oRM);
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
        if (this.oRM != null) {
            this.oRM.hT(this.oRZ + j);
        }
        a(new UrlRequestException("Exception in CronetUrlRequest: " + str, i, i2));
    }

    @CalledByNative
    private void onCanceled() {
        postTaskToExecutor(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.turbonet.base.a.e("ChromiumNetwork", "****** onCanceled, url is: %s", CronetUrlRequest.this.oRM.getUrl());
                    CronetUrlRequest.this.oSa.c(CronetUrlRequest.this, CronetUrlRequest.this.oRM);
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
                statusListener.onStatus(UrlRequest.Status.Ng(i));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class b {
        @Nullable
        private Long oSD;
        @Nullable
        private Long oSE;
        @Nullable
        private Long oSF;

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onRequestStarted() {
            if (this.oSD != null) {
                throw new IllegalStateException("onRequestStarted called repeatedly");
            }
            this.oSD = Long.valueOf(SystemClock.elapsedRealtime());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void egv() {
            if (this.oSD != null && this.oSF == null) {
                this.oSF = Long.valueOf(SystemClock.elapsedRealtime() - this.oSD.longValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void egw() {
            if (this.oSD != null && this.oSE == null) {
                this.oSE = Long.valueOf(SystemClock.elapsedRealtime() - this.oSD.longValue());
            }
        }
    }
}
