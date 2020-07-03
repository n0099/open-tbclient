package com.baidu.turbonet.net;

import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.annotations.JNINamespace;
import com.baidu.turbonet.base.annotations.NativeClassQualifiedName;
import com.baidu.turbonet.net.TurbonetEngine;
import com.baidu.turbonet.net.UrlRequest;
import com.baidu.webkit.internal.ETAG;
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
/* loaded from: classes.dex */
public final class CronetUrlRequest implements UrlRequest {
    private static final TurbonetEngine.UrlRequestMetrics mzy = new TurbonetEngine.UrlRequestMetrics(null, null, null, null);
    private boolean mAa;
    private int mAb;
    private int mAc;
    private int mAd;
    private int mAe;
    private String mAf;
    private String mAg;
    private CronetUploadDataStream mAh;
    private a mAi;
    private final Executor mExecutor;
    private final int mPriority;
    private Object mTag;
    private final CronetUrlRequestContext myQ;
    private final String myS;
    private String myT;
    @GuardedBy("mUrlRequestAdapterLock")
    @Nullable
    private final b mzC;
    private long mzF;
    private final UrlRequest.Callback mzG;
    private String mzH;
    private String mzI;
    private String mzJ;
    private String mzK;
    private String mzL;
    private String mzM;
    private String mzN;
    private long mzO;
    private long mzP;
    private long mzQ;
    private long mzR;
    private long mzS;
    private RequestTimeInfo mzT;
    private final Collection<Object> mzV;
    private final boolean mzW;
    private final boolean mzX;
    private final boolean mzY;
    private boolean mzZ;
    private UrlResponseInfo mzc;
    private Runnable mze;
    @GuardedBy("mUrlRequestAdapterLock")
    private long mzz;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mStarted = false;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mzA = false;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mzB = false;
    private final Object mzD = new Object();
    private final List<String> mzE = new ArrayList();
    private final HeadersList mzU = new HeadersList();

    /* loaded from: classes.dex */
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
    /* loaded from: classes.dex */
    public static final class HeadersList extends ArrayList<Map.Entry<String, String>> {
        private HeadersList() {
        }
    }

    /* loaded from: classes.dex */
    private final class a implements Runnable {
        ByteBuffer mByteBuffer;

        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ByteBuffer byteBuffer = this.mByteBuffer;
            this.mByteBuffer = null;
            try {
                synchronized (CronetUrlRequest.this.mzD) {
                    if (!CronetUrlRequest.this.duV()) {
                        CronetUrlRequest.this.mzB = true;
                        CronetUrlRequest.this.mzG.a(CronetUrlRequest.this, CronetUrlRequest.this.mzc, byteBuffer);
                    }
                }
            } catch (Exception e) {
                CronetUrlRequest.this.u(e);
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
        this.myQ = cronetUrlRequestContext;
        this.myS = str;
        this.mzE.add(str);
        this.mPriority = Hl(i);
        this.mzG = callback;
        this.mExecutor = executor;
        this.mzV = collection;
        this.mzC = z ? new b() : null;
        this.mzW = z2;
        this.mzX = z3;
        this.mzY = z4;
        this.mzZ = false;
        this.mAa = false;
        this.mAb = 0;
        this.mAc = 0;
        this.mAd = 0;
        this.mAe = 0;
        this.mTag = null;
        this.mAf = null;
        this.mAg = null;
        this.mzc = new UrlResponseInfo(new ArrayList(this.mzE), 0, "", new HeadersList(), false, "", "");
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Pw(String str) {
        dvh();
        if (str == null) {
            throw new NullPointerException("Method is required.");
        }
        this.myT = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void addHeader(String str, String str2) {
        dvh();
        if (str == null) {
            throw new NullPointerException("Invalid header name.");
        }
        if (str2 == null) {
            throw new NullPointerException("Invalid header value.");
        }
        this.mzU.add(new AbstractMap.SimpleImmutableEntry(str, str2));
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void a(UploadDataProvider uploadDataProvider, Executor executor) {
        if (uploadDataProvider == null) {
            throw new NullPointerException("Invalid UploadDataProvider.");
        }
        if (this.myT == null) {
            this.myT = "POST";
        }
        this.mAh = new CronetUploadDataStream(uploadDataProvider, executor, this);
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void start() {
        synchronized (this.mzD) {
            com.baidu.turbonet.base.a.g("ChromiumNetwork", "****** Request start, url is: %s", this.myS);
            dvh();
            try {
                this.mzz = nativeCreateRequestAdapter(this.myQ.dvm(), this.myS, this.mPriority, this.mzW, this.mzX, this.mzY);
                this.myQ.dvi();
                if (this.myT != null && !nativeSetHttpMethod(this.mzz, this.myT)) {
                    throw new IllegalArgumentException("Invalid http method " + this.myT);
                }
                if (this.mTag != null) {
                    this.myQ.a(this);
                }
                if (this.mzZ) {
                    nativeDisableResponseAutoUngzip(this.mzz);
                }
                if (this.mAa) {
                    nativeEnableBrotliByRequest(this.mzz);
                }
                if (this.mAb > 0) {
                    nativeSetTimeout(this.mzz, this.mAb);
                }
                if (this.mAc > 0) {
                    nativeSetTCPConnectTimeout(this.mzz, this.mAc);
                }
                if (this.mAd > 0) {
                    nativeSetResponseHeaderRecvTimeout(this.mzz, this.mAd);
                }
                if (this.mAe > 0) {
                    nativeSetResponseBodyReadTimeout(this.mzz, this.mAe);
                }
                if (!TextUtils.isEmpty(this.mAf)) {
                    nativeSetDestinationAddress(this.mzz, this.mAf);
                }
                if (!TextUtils.isEmpty(this.mAg)) {
                    nativeSetRequestTag(this.mzz, this.mAg);
                }
                Iterator<Map.Entry<String, String>> it = this.mzU.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    boolean z2 = (!next.getKey().equalsIgnoreCase("Content-Type") || next.getValue().isEmpty()) ? z : true;
                    if (!nativeAddRequestHeader(this.mzz, next.getKey(), next.getValue())) {
                        throw new IllegalArgumentException("Invalid header " + next.getKey() + ETAG.EQUAL + next.getValue());
                    }
                    z = z2;
                }
                if (this.mAh != null) {
                    if (!z) {
                        throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
                    }
                    this.mStarted = true;
                    this.mAh.C(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CronetUrlRequest.this.mAh.dvc();
                            synchronized (CronetUrlRequest.this.mzD) {
                                if (!CronetUrlRequest.this.duV()) {
                                    CronetUrlRequest.this.mAh.fC(CronetUrlRequest.this.mzz);
                                    CronetUrlRequest.this.dvd();
                                }
                            }
                        }
                    });
                    return;
                }
                this.mStarted = true;
                dvd();
            } catch (RuntimeException e) {
                we(false);
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public void dvd() {
        if (this.mzC != null) {
            this.mzC.dvi();
        }
        nativeStart(this.mzz);
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void dve() {
        synchronized (this.mzD) {
            if (!this.mzA) {
                throw new IllegalStateException("No redirect to follow.");
            }
            this.mzA = false;
            if (!duV()) {
                nativeFollowDeferredRedirect(this.mzz);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void m(ByteBuffer byteBuffer) {
        com.baidu.turbonet.net.b.o(byteBuffer);
        com.baidu.turbonet.net.b.n(byteBuffer);
        synchronized (this.mzD) {
            if (!this.mzB) {
                throw new IllegalStateException("Unexpected read attempt.");
            }
            this.mzB = false;
            if (!duV()) {
                if (!nativeReadData(this.mzz, byteBuffer, byteBuffer.position(), byteBuffer.limit())) {
                    this.mzB = true;
                    throw new IllegalArgumentException("Unable to call native read");
                }
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void cancel() {
        synchronized (this.mzD) {
            com.baidu.turbonet.base.a.g("ChromiumNetwork", "****** Request cancel, url is: %s", this.myS);
            if (!duV() && this.mStarted) {
                we(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public boolean duV() {
        return this.mStarted && this.mzz == 0;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void dvf() {
        dvh();
        this.mzZ = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void dvg() {
        dvh();
        this.mAa = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setTimeout(int i) {
        dvh();
        this.mAb = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Hi(int i) {
        dvh();
        this.mAc = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Hj(int i) {
        dvh();
        this.mAd = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Hk(int i) {
        dvh();
        this.mAe = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setTag(Object obj) {
        dvh();
        this.mTag = obj;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Px(String str) {
        dvh();
        this.mAf = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Py(String str) {
        dvh();
        this.mAg = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public Object getTag() {
        return this.mTag;
    }

    @CalledByNative
    public static RequestTimeInfo createObject(long j, long j2, long j3, long j4, long j5) {
        return new RequestTimeInfo(j, j2, j3, j4, j5);
    }

    private void C(Runnable runnable) {
        try {
            this.mExecutor.execute(runnable);
        } catch (RejectedExecutionException e) {
            com.baidu.turbonet.base.a.h("ChromiumNetwork", "Exception posting task to executor", e);
            we(false);
        }
    }

    private static int Hl(int i) {
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
        return new UrlResponseInfo(new ArrayList(this.mzE), i, str, headersList, z, str2, str3);
    }

    private void dvh() {
        synchronized (this.mzD) {
            if (this.mStarted || duV()) {
                throw new IllegalStateException("Request is already started.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void we(boolean z) {
        synchronized (this.mzD) {
            if (this.mzz != 0) {
                String nativeGetDNSNameServers = nativeGetDNSNameServers(this.mzz);
                if (!nativeGetDNSNameServers.isEmpty()) {
                    this.mzI = nativeGetDNSNameServers;
                }
                String nativeGetDNSResults = nativeGetDNSResults(this.mzz);
                if (!nativeGetDNSResults.isEmpty()) {
                    this.mzH = nativeGetDNSResults;
                }
                String nativeGetDNSErrorCode = nativeGetDNSErrorCode(this.mzz);
                if (!nativeGetDNSErrorCode.isEmpty()) {
                    this.mzJ = nativeGetDNSErrorCode;
                }
                String nativeGetConnectionAttempts = nativeGetConnectionAttempts(this.mzz, false);
                if (!nativeGetConnectionAttempts.isEmpty()) {
                    this.mzK = nativeGetConnectionAttempts;
                }
                String nativeGetConnectionAttempts2 = nativeGetConnectionAttempts(this.mzz, true);
                if (!nativeGetConnectionAttempts2.isEmpty()) {
                    this.mzL = nativeGetConnectionAttempts2;
                }
                String nativeGetRemoteEndpoint = nativeGetRemoteEndpoint(this.mzz);
                if (!nativeGetRemoteEndpoint.isEmpty()) {
                    this.mzM = nativeGetRemoteEndpoint;
                }
                String nativeGetSuperPipeInfo = nativeGetSuperPipeInfo(this.mzz);
                if (!nativeGetSuperPipeInfo.isEmpty()) {
                    this.mzN = nativeGetSuperPipeInfo;
                }
                long nativeRequestTimeGap = nativeRequestTimeGap(this.mzz, 1);
                if (nativeRequestTimeGap >= 0) {
                    this.mzO = nativeRequestTimeGap;
                }
                long nativeRequestTimeGap2 = nativeRequestTimeGap(this.mzz, 2);
                if (nativeRequestTimeGap2 >= 0) {
                    this.mzP = nativeRequestTimeGap2;
                }
                long nativeRequestTimeGap3 = nativeRequestTimeGap(this.mzz, 3);
                if (nativeRequestTimeGap3 >= 0) {
                    this.mzQ = nativeRequestTimeGap3;
                }
                long nativeRequestTimeGap4 = nativeRequestTimeGap(this.mzz, 4);
                if (nativeRequestTimeGap4 >= 0) {
                    this.mzR = nativeRequestTimeGap4;
                }
                long nativeRequestTimeGap5 = nativeRequestTimeGap(this.mzz, 5);
                if (nativeRequestTimeGap5 >= 0) {
                    this.mzS = nativeRequestTimeGap5;
                }
                this.mzT = nativeGetRequestTimeInfo(this.mzz);
                if (this.mzT == null) {
                    this.mzT = new RequestTimeInfo();
                }
                if (this.mzC != null) {
                    this.mzC.dvj();
                }
                nativeDestroy(this.mzz, z);
                if (this.mTag != null) {
                    this.myQ.b(this);
                }
                this.myQ.dvl();
                this.mzz = 0L;
                if (this.mze != null) {
                    this.mze.run();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Exception exc) {
        UrlRequestException urlRequestException = new UrlRequestException("Exception received from UrlRequest.Callback", exc);
        com.baidu.turbonet.base.a.h("ChromiumNetwork", "Exception in CalledByNative method", exc);
        synchronized (this.mzD) {
            if (!duV()) {
                we(false);
                try {
                    this.mzG.a(this, this.mzc, urlRequestException);
                } catch (Exception e) {
                    com.baidu.turbonet.base.a.h("ChromiumNetwork", "Exception notifying of failed request", e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(Throwable th) {
        UrlRequestException urlRequestException = new UrlRequestException("Exception received from UploadDataProvider", th);
        com.baidu.turbonet.base.a.h("ChromiumNetwork", "Exception in upload method", th);
        a(urlRequestException);
    }

    private void a(final UrlRequestException urlRequestException) {
        C(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.mzD) {
                    if (!CronetUrlRequest.this.duV()) {
                        CronetUrlRequest.this.we(false);
                        try {
                            CronetUrlRequest.this.mzG.a(CronetUrlRequest.this, CronetUrlRequest.this.mzc, urlRequestException);
                        } catch (Exception e) {
                            com.baidu.turbonet.base.a.h("ChromiumNetwork", "Exception in onError method", e);
                        }
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onRedirectReceived(final String str, int i, String str2, String[] strArr, boolean z, String str3, String str4, long j) {
        final UrlResponseInfo a2 = a(i, str2, strArr, z, str3, str4);
        this.mzF += j;
        a2.fE(this.mzF);
        this.mzE.add(str);
        C(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.mzD) {
                    if (!CronetUrlRequest.this.duV()) {
                        CronetUrlRequest.this.mzA = true;
                        try {
                            CronetUrlRequest.this.mzG.a(CronetUrlRequest.this, a2, str);
                        } catch (Exception e) {
                            CronetUrlRequest.this.u(e);
                        }
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onResponseStarted(int i, String str, String[] strArr, boolean z, String str2, String str3) {
        this.mzc = a(i, str, strArr, z, str2, str3);
        C(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.mzD) {
                    if (!CronetUrlRequest.this.duV()) {
                        if (CronetUrlRequest.this.mzC != null) {
                            CronetUrlRequest.this.mzC.dvk();
                        }
                        CronetUrlRequest.this.mzB = true;
                        try {
                            CronetUrlRequest.this.mzG.a(CronetUrlRequest.this, CronetUrlRequest.this.mzc);
                        } catch (Exception e) {
                            CronetUrlRequest.this.u(e);
                        }
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onReadCompleted(ByteBuffer byteBuffer, int i, int i2, int i3, long j) {
        this.mzc.fE(this.mzF + j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            a(new UrlRequestException("ByteBuffer modified externally during read", null));
            return;
        }
        if (this.mAi == null) {
            this.mAi = new a();
        }
        byteBuffer.position(i2 + i);
        this.mAi.mByteBuffer = byteBuffer;
        C(this.mAi);
    }

    @CalledByNative
    private void onSucceeded(long j) {
        this.mzc.fE(this.mzF + j);
        C(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.mzD) {
                    if (!CronetUrlRequest.this.duV()) {
                        CronetUrlRequest.this.we(false);
                        try {
                            CronetUrlRequest.this.mzG.b(CronetUrlRequest.this, CronetUrlRequest.this.mzc);
                        } catch (Exception e) {
                            com.baidu.turbonet.base.a.h("ChromiumNetwork", "Exception in onComplete method", e);
                        }
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onError(int i, int i2, int i3, String str, long j) {
        if (this.mzc != null) {
            this.mzc.fE(this.mzF + j);
        }
        a(new UrlRequestException("Exception in CronetUrlRequest: " + str, i, i2));
    }

    @CalledByNative
    private void onCanceled() {
        C(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.turbonet.base.a.h("ChromiumNetwork", "****** onCanceled, url is: %s", CronetUrlRequest.this.mzc.getUrl());
                    CronetUrlRequest.this.mzG.c(CronetUrlRequest.this, CronetUrlRequest.this.mzc);
                } catch (Exception e) {
                    com.baidu.turbonet.base.a.h("ChromiumNetwork", "Exception in onCanceled method", e);
                }
            }
        });
    }

    @CalledByNative
    private void onStatus(final UrlRequest.StatusListener statusListener, final int i) {
        C(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.7
            @Override // java.lang.Runnable
            public void run() {
                statusListener.HB(UrlRequest.Status.HA(i));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class b {
        @Nullable
        private Long mAp;
        @Nullable
        private Long mAq;
        @Nullable
        private Long mAr;

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dvi() {
            if (this.mAp != null) {
                throw new IllegalStateException("onRequestStarted called repeatedly");
            }
            this.mAp = Long.valueOf(SystemClock.elapsedRealtime());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dvj() {
            if (this.mAp != null && this.mAr == null) {
                this.mAr = Long.valueOf(SystemClock.elapsedRealtime() - this.mAp.longValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dvk() {
            if (this.mAp != null && this.mAq == null) {
                this.mAq = Long.valueOf(SystemClock.elapsedRealtime() - this.mAp.longValue());
            }
        }
    }
}
