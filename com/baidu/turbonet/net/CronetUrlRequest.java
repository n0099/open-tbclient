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
/* loaded from: classes6.dex */
public final class CronetUrlRequest implements UrlRequest {
    private static final TurbonetEngine.UrlRequestMetrics oPs = new TurbonetEngine.UrlRequestMetrics(null, null, null, null);
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
    private String oPA;
    private String oPB;
    private String oPC;
    private long oPD;
    private long oPE;
    private long oPF;
    private long oPG;
    private long oPH;
    private RequestTimeInfo oPI;
    private final boolean oPK;
    private boolean oPL;
    private boolean oPM;
    private int oPN;
    private int oPO;
    private int oPP;
    private String oPQ;
    private String oPR;
    private CronetUploadDataStream oPS;
    private a oPT;
    private final CronetUrlRequestContext oPd;
    private UrlResponseInfo oPh;
    @Nullable
    @GuardedBy("mUrlRequestAdapterLock")
    private final b oPt;
    private long oPu;
    private final UrlRequest.Callback oPv;
    private String oPw;
    private String oPx;
    private String oPy;
    private String oPz;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mStarted = false;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mWaitingOnRedirect = false;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mWaitingOnRead = false;
    private final Object mUrlRequestAdapterLock = new Object();
    private final List<String> mUrlChain = new ArrayList();
    private final HeadersList oPJ = new HeadersList();

    /* loaded from: classes6.dex */
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
    /* loaded from: classes6.dex */
    public static final class HeadersList extends ArrayList<Map.Entry<String, String>> {
        private HeadersList() {
        }
    }

    /* loaded from: classes6.dex */
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
                        CronetUrlRequest.this.oPv.a(CronetUrlRequest.this, CronetUrlRequest.this.oPh, byteBuffer);
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
        this.oPd = cronetUrlRequestContext;
        this.mInitialUrl = str;
        this.mUrlChain.add(str);
        this.mPriority = MP(i);
        this.oPv = callback;
        this.mExecutor = executor;
        this.mRequestAnnotations = collection;
        this.oPt = z ? new b() : null;
        this.mDisableCache = z2;
        this.mDisableConnectionMigration = z3;
        this.oPK = z4;
        this.oPL = false;
        this.oPM = false;
        this.mTimeout = 0;
        this.oPN = 0;
        this.oPO = 0;
        this.oPP = 0;
        this.mTag = null;
        this.oPQ = null;
        this.oPR = null;
        this.oPh = new UrlResponseInfo(new ArrayList(this.mUrlChain), 0, "", new HeadersList(), false, "", "");
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
        this.oPJ.add(new AbstractMap.SimpleImmutableEntry(str, str2));
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void a(UploadDataProvider uploadDataProvider, Executor executor) {
        if (uploadDataProvider == null) {
            throw new NullPointerException("Invalid UploadDataProvider.");
        }
        if (this.mInitialMethod == null) {
            this.mInitialMethod = "POST";
        }
        this.oPS = new CronetUploadDataStream(uploadDataProvider, executor, this);
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void start() {
        synchronized (this.mUrlRequestAdapterLock) {
            com.baidu.turbonet.base.a.i("ChromiumNetwork", "****** Request start, url is: %s", this.mInitialUrl);
            checkNotStarted();
            try {
                this.mUrlRequestAdapter = nativeCreateRequestAdapter(this.oPd.getUrlRequestContextAdapter(), this.mInitialUrl, this.mPriority, this.mDisableCache, this.mDisableConnectionMigration, this.oPK);
                this.oPd.onRequestStarted();
                if (this.mInitialMethod != null && !nativeSetHttpMethod(this.mUrlRequestAdapter, this.mInitialMethod)) {
                    throw new IllegalArgumentException("Invalid http method " + this.mInitialMethod);
                }
                if (this.mTag != null) {
                    this.oPd.a(this);
                }
                if (this.oPL) {
                    nativeDisableResponseAutoUngzip(this.mUrlRequestAdapter);
                }
                if (this.oPM) {
                    nativeEnableBrotliByRequest(this.mUrlRequestAdapter);
                }
                if (this.mTimeout > 0) {
                    nativeSetTimeout(this.mUrlRequestAdapter, this.mTimeout);
                }
                if (this.oPN > 0) {
                    nativeSetTCPConnectTimeout(this.mUrlRequestAdapter, this.oPN);
                }
                if (this.oPO > 0) {
                    nativeSetResponseHeaderRecvTimeout(this.mUrlRequestAdapter, this.oPO);
                }
                if (this.oPP > 0) {
                    nativeSetResponseBodyReadTimeout(this.mUrlRequestAdapter, this.oPP);
                }
                if (!TextUtils.isEmpty(this.oPQ)) {
                    nativeSetDestinationAddress(this.mUrlRequestAdapter, this.oPQ);
                }
                if (!TextUtils.isEmpty(this.oPR)) {
                    nativeSetRequestTag(this.mUrlRequestAdapter, this.oPR);
                }
                Iterator<Map.Entry<String, String>> it = this.oPJ.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    boolean z2 = (!next.getKey().equalsIgnoreCase("Content-Type") || next.getValue().isEmpty()) ? z : true;
                    if (!nativeAddRequestHeader(this.mUrlRequestAdapter, next.getKey(), next.getValue())) {
                        throw new IllegalArgumentException("Invalid header " + next.getKey() + "=" + next.getValue());
                    }
                    z = z2;
                }
                if (this.oPS != null) {
                    if (!z) {
                        throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
                    }
                    this.mStarted = true;
                    this.oPS.postTaskToExecutor(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CronetUrlRequest.this.oPS.initializeWithRequest();
                            synchronized (CronetUrlRequest.this.mUrlRequestAdapterLock) {
                                if (!CronetUrlRequest.this.isDoneLocked()) {
                                    CronetUrlRequest.this.oPS.attachNativeAdapterToRequest(CronetUrlRequest.this.mUrlRequestAdapter);
                                    CronetUrlRequest.this.egc();
                                }
                            }
                        }
                    });
                    return;
                }
                this.mStarted = true;
                egc();
            } catch (RuntimeException e) {
                At(false);
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public void egc() {
        if (this.oPt != null) {
            this.oPt.onRequestStarted();
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
                At(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public boolean isDoneLocked() {
        return this.mStarted && this.mUrlRequestAdapter == 0;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void egd() {
        checkNotStarted();
        this.oPL = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void ege() {
        checkNotStarted();
        this.oPM = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setTimeout(int i) {
        checkNotStarted();
        this.mTimeout = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void MM(int i) {
        checkNotStarted();
        this.oPN = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void MN(int i) {
        checkNotStarted();
        this.oPO = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void MO(int i) {
        checkNotStarted();
        this.oPP = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setTag(Object obj) {
        checkNotStarted();
        this.mTag = obj;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void WM(String str) {
        checkNotStarted();
        this.oPQ = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void WN(String str) {
        checkNotStarted();
        this.oPR = str;
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
            At(false);
        }
    }

    private static int MP(int i) {
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
    public void At(boolean z) {
        synchronized (this.mUrlRequestAdapterLock) {
            if (this.mUrlRequestAdapter != 0) {
                String nativeGetDNSNameServers = nativeGetDNSNameServers(this.mUrlRequestAdapter);
                if (!nativeGetDNSNameServers.isEmpty()) {
                    this.oPx = nativeGetDNSNameServers;
                }
                String nativeGetDNSResults = nativeGetDNSResults(this.mUrlRequestAdapter);
                if (!nativeGetDNSResults.isEmpty()) {
                    this.oPw = nativeGetDNSResults;
                }
                String nativeGetDNSErrorCode = nativeGetDNSErrorCode(this.mUrlRequestAdapter);
                if (!nativeGetDNSErrorCode.isEmpty()) {
                    this.oPy = nativeGetDNSErrorCode;
                }
                String nativeGetConnectionAttempts = nativeGetConnectionAttempts(this.mUrlRequestAdapter, false);
                if (!nativeGetConnectionAttempts.isEmpty()) {
                    this.oPz = nativeGetConnectionAttempts;
                }
                String nativeGetConnectionAttempts2 = nativeGetConnectionAttempts(this.mUrlRequestAdapter, true);
                if (!nativeGetConnectionAttempts2.isEmpty()) {
                    this.oPA = nativeGetConnectionAttempts2;
                }
                String nativeGetRemoteEndpoint = nativeGetRemoteEndpoint(this.mUrlRequestAdapter);
                if (!nativeGetRemoteEndpoint.isEmpty()) {
                    this.oPB = nativeGetRemoteEndpoint;
                }
                String nativeGetSuperPipeInfo = nativeGetSuperPipeInfo(this.mUrlRequestAdapter);
                if (!nativeGetSuperPipeInfo.isEmpty()) {
                    this.oPC = nativeGetSuperPipeInfo;
                }
                long nativeRequestTimeGap = nativeRequestTimeGap(this.mUrlRequestAdapter, 1);
                if (nativeRequestTimeGap >= 0) {
                    this.oPD = nativeRequestTimeGap;
                }
                long nativeRequestTimeGap2 = nativeRequestTimeGap(this.mUrlRequestAdapter, 2);
                if (nativeRequestTimeGap2 >= 0) {
                    this.oPE = nativeRequestTimeGap2;
                }
                long nativeRequestTimeGap3 = nativeRequestTimeGap(this.mUrlRequestAdapter, 3);
                if (nativeRequestTimeGap3 >= 0) {
                    this.oPF = nativeRequestTimeGap3;
                }
                long nativeRequestTimeGap4 = nativeRequestTimeGap(this.mUrlRequestAdapter, 4);
                if (nativeRequestTimeGap4 >= 0) {
                    this.oPG = nativeRequestTimeGap4;
                }
                long nativeRequestTimeGap5 = nativeRequestTimeGap(this.mUrlRequestAdapter, 5);
                if (nativeRequestTimeGap5 >= 0) {
                    this.oPH = nativeRequestTimeGap5;
                }
                this.oPI = nativeGetRequestTimeInfo(this.mUrlRequestAdapter);
                if (this.oPI == null) {
                    this.oPI = new RequestTimeInfo();
                }
                if (this.oPt != null) {
                    this.oPt.egf();
                }
                nativeDestroy(this.mUrlRequestAdapter, z);
                if (this.mTag != null) {
                    this.oPd.b(this);
                }
                this.oPd.onRequestDestroyed();
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
                At(false);
                try {
                    this.oPv.a(this, this.oPh, urlRequestException);
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
                        CronetUrlRequest.this.At(false);
                        try {
                            CronetUrlRequest.this.oPv.a(CronetUrlRequest.this, CronetUrlRequest.this.oPh, urlRequestException);
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
        this.oPu += j;
        a2.hT(this.oPu);
        this.mUrlChain.add(str);
        postTaskToExecutor(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.mUrlRequestAdapterLock) {
                    if (!CronetUrlRequest.this.isDoneLocked()) {
                        CronetUrlRequest.this.mWaitingOnRedirect = true;
                        try {
                            CronetUrlRequest.this.oPv.a(CronetUrlRequest.this, a2, str);
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
        this.oPh = a(i, str, strArr, z, str2, str3);
        postTaskToExecutor(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.mUrlRequestAdapterLock) {
                    if (!CronetUrlRequest.this.isDoneLocked()) {
                        if (CronetUrlRequest.this.oPt != null) {
                            CronetUrlRequest.this.oPt.egg();
                        }
                        CronetUrlRequest.this.mWaitingOnRead = true;
                        try {
                            CronetUrlRequest.this.oPv.a(CronetUrlRequest.this, CronetUrlRequest.this.oPh);
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
        this.oPh.hT(this.oPu + j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            a(new UrlRequestException("ByteBuffer modified externally during read", null));
            return;
        }
        if (this.oPT == null) {
            this.oPT = new a();
        }
        byteBuffer.position(i2 + i);
        this.oPT.mByteBuffer = byteBuffer;
        postTaskToExecutor(this.oPT);
    }

    @CalledByNative
    private void onSucceeded(long j) {
        this.oPh.hT(this.oPu + j);
        postTaskToExecutor(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.mUrlRequestAdapterLock) {
                    if (!CronetUrlRequest.this.isDoneLocked()) {
                        CronetUrlRequest.this.At(false);
                        try {
                            CronetUrlRequest.this.oPv.b(CronetUrlRequest.this, CronetUrlRequest.this.oPh);
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
        if (this.oPh != null) {
            this.oPh.hT(this.oPu + j);
        }
        a(new UrlRequestException("Exception in CronetUrlRequest: " + str, i, i2));
    }

    @CalledByNative
    private void onCanceled() {
        postTaskToExecutor(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.turbonet.base.a.e("ChromiumNetwork", "****** onCanceled, url is: %s", CronetUrlRequest.this.oPh.getUrl());
                    CronetUrlRequest.this.oPv.c(CronetUrlRequest.this, CronetUrlRequest.this.oPh);
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
                statusListener.onStatus(UrlRequest.Status.Nb(i));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public final class b {
        @Nullable
        private Long oPY;
        @Nullable
        private Long oPZ;
        @Nullable
        private Long oQa;

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onRequestStarted() {
            if (this.oPY != null) {
                throw new IllegalStateException("onRequestStarted called repeatedly");
            }
            this.oPY = Long.valueOf(SystemClock.elapsedRealtime());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void egf() {
            if (this.oPY != null && this.oQa == null) {
                this.oQa = Long.valueOf(SystemClock.elapsedRealtime() - this.oPY.longValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void egg() {
            if (this.oPY != null && this.oPZ == null) {
                this.oPZ = Long.valueOf(SystemClock.elapsedRealtime() - this.oPY.longValue());
            }
        }
    }
}
