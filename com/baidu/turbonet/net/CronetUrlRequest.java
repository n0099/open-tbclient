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
    private static final TurbonetEngine.UrlRequestMetrics mzB = new TurbonetEngine.UrlRequestMetrics(null, null, null, null);
    private final boolean mAa;
    private final boolean mAb;
    private boolean mAc;
    private boolean mAd;
    private int mAe;
    private int mAf;
    private int mAg;
    private int mAh;
    private String mAi;
    private String mAj;
    private CronetUploadDataStream mAk;
    private a mAl;
    private final Executor mExecutor;
    private final int mPriority;
    private Object mTag;
    private final CronetUrlRequestContext myT;
    private final String myV;
    private String myW;
    @GuardedBy("mUrlRequestAdapterLock")
    private long mzC;
    @GuardedBy("mUrlRequestAdapterLock")
    @Nullable
    private final b mzF;
    private long mzI;
    private final UrlRequest.Callback mzJ;
    private String mzK;
    private String mzL;
    private String mzM;
    private String mzN;
    private String mzO;
    private String mzP;
    private String mzQ;
    private long mzR;
    private long mzS;
    private long mzT;
    private long mzU;
    private long mzV;
    private RequestTimeInfo mzW;
    private final Collection<Object> mzY;
    private final boolean mzZ;
    private UrlResponseInfo mzf;
    private Runnable mzh;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mStarted = false;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mzD = false;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mzE = false;
    private final Object mzG = new Object();
    private final List<String> mzH = new ArrayList();
    private final HeadersList mzX = new HeadersList();

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
                synchronized (CronetUrlRequest.this.mzG) {
                    if (!CronetUrlRequest.this.duZ()) {
                        CronetUrlRequest.this.mzE = true;
                        CronetUrlRequest.this.mzJ.a(CronetUrlRequest.this, CronetUrlRequest.this.mzf, byteBuffer);
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
        this.myT = cronetUrlRequestContext;
        this.myV = str;
        this.mzH.add(str);
        this.mPriority = Hl(i);
        this.mzJ = callback;
        this.mExecutor = executor;
        this.mzY = collection;
        this.mzF = z ? new b() : null;
        this.mzZ = z2;
        this.mAa = z3;
        this.mAb = z4;
        this.mAc = false;
        this.mAd = false;
        this.mAe = 0;
        this.mAf = 0;
        this.mAg = 0;
        this.mAh = 0;
        this.mTag = null;
        this.mAi = null;
        this.mAj = null;
        this.mzf = new UrlResponseInfo(new ArrayList(this.mzH), 0, "", new HeadersList(), false, "", "");
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Px(String str) {
        dvl();
        if (str == null) {
            throw new NullPointerException("Method is required.");
        }
        this.myW = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void addHeader(String str, String str2) {
        dvl();
        if (str == null) {
            throw new NullPointerException("Invalid header name.");
        }
        if (str2 == null) {
            throw new NullPointerException("Invalid header value.");
        }
        this.mzX.add(new AbstractMap.SimpleImmutableEntry(str, str2));
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void a(UploadDataProvider uploadDataProvider, Executor executor) {
        if (uploadDataProvider == null) {
            throw new NullPointerException("Invalid UploadDataProvider.");
        }
        if (this.myW == null) {
            this.myW = "POST";
        }
        this.mAk = new CronetUploadDataStream(uploadDataProvider, executor, this);
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void start() {
        synchronized (this.mzG) {
            com.baidu.turbonet.base.a.g("ChromiumNetwork", "****** Request start, url is: %s", this.myV);
            dvl();
            try {
                this.mzC = nativeCreateRequestAdapter(this.myT.dvq(), this.myV, this.mPriority, this.mzZ, this.mAa, this.mAb);
                this.myT.dvm();
                if (this.myW != null && !nativeSetHttpMethod(this.mzC, this.myW)) {
                    throw new IllegalArgumentException("Invalid http method " + this.myW);
                }
                if (this.mTag != null) {
                    this.myT.a(this);
                }
                if (this.mAc) {
                    nativeDisableResponseAutoUngzip(this.mzC);
                }
                if (this.mAd) {
                    nativeEnableBrotliByRequest(this.mzC);
                }
                if (this.mAe > 0) {
                    nativeSetTimeout(this.mzC, this.mAe);
                }
                if (this.mAf > 0) {
                    nativeSetTCPConnectTimeout(this.mzC, this.mAf);
                }
                if (this.mAg > 0) {
                    nativeSetResponseHeaderRecvTimeout(this.mzC, this.mAg);
                }
                if (this.mAh > 0) {
                    nativeSetResponseBodyReadTimeout(this.mzC, this.mAh);
                }
                if (!TextUtils.isEmpty(this.mAi)) {
                    nativeSetDestinationAddress(this.mzC, this.mAi);
                }
                if (!TextUtils.isEmpty(this.mAj)) {
                    nativeSetRequestTag(this.mzC, this.mAj);
                }
                Iterator<Map.Entry<String, String>> it = this.mzX.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    boolean z2 = (!next.getKey().equalsIgnoreCase("Content-Type") || next.getValue().isEmpty()) ? z : true;
                    if (!nativeAddRequestHeader(this.mzC, next.getKey(), next.getValue())) {
                        throw new IllegalArgumentException("Invalid header " + next.getKey() + ETAG.EQUAL + next.getValue());
                    }
                    z = z2;
                }
                if (this.mAk != null) {
                    if (!z) {
                        throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
                    }
                    this.mStarted = true;
                    this.mAk.C(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CronetUrlRequest.this.mAk.dvg();
                            synchronized (CronetUrlRequest.this.mzG) {
                                if (!CronetUrlRequest.this.duZ()) {
                                    CronetUrlRequest.this.mAk.fC(CronetUrlRequest.this.mzC);
                                    CronetUrlRequest.this.dvh();
                                }
                            }
                        }
                    });
                    return;
                }
                this.mStarted = true;
                dvh();
            } catch (RuntimeException e) {
                we(false);
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public void dvh() {
        if (this.mzF != null) {
            this.mzF.dvm();
        }
        nativeStart(this.mzC);
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void dvi() {
        synchronized (this.mzG) {
            if (!this.mzD) {
                throw new IllegalStateException("No redirect to follow.");
            }
            this.mzD = false;
            if (!duZ()) {
                nativeFollowDeferredRedirect(this.mzC);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void m(ByteBuffer byteBuffer) {
        com.baidu.turbonet.net.b.o(byteBuffer);
        com.baidu.turbonet.net.b.n(byteBuffer);
        synchronized (this.mzG) {
            if (!this.mzE) {
                throw new IllegalStateException("Unexpected read attempt.");
            }
            this.mzE = false;
            if (!duZ()) {
                if (!nativeReadData(this.mzC, byteBuffer, byteBuffer.position(), byteBuffer.limit())) {
                    this.mzE = true;
                    throw new IllegalArgumentException("Unable to call native read");
                }
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void cancel() {
        synchronized (this.mzG) {
            com.baidu.turbonet.base.a.g("ChromiumNetwork", "****** Request cancel, url is: %s", this.myV);
            if (!duZ() && this.mStarted) {
                we(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public boolean duZ() {
        return this.mStarted && this.mzC == 0;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void dvj() {
        dvl();
        this.mAc = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void dvk() {
        dvl();
        this.mAd = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setTimeout(int i) {
        dvl();
        this.mAe = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Hi(int i) {
        dvl();
        this.mAf = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Hj(int i) {
        dvl();
        this.mAg = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Hk(int i) {
        dvl();
        this.mAh = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setTag(Object obj) {
        dvl();
        this.mTag = obj;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Py(String str) {
        dvl();
        this.mAi = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Pz(String str) {
        dvl();
        this.mAj = str;
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
        return new UrlResponseInfo(new ArrayList(this.mzH), i, str, headersList, z, str2, str3);
    }

    private void dvl() {
        synchronized (this.mzG) {
            if (this.mStarted || duZ()) {
                throw new IllegalStateException("Request is already started.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void we(boolean z) {
        synchronized (this.mzG) {
            if (this.mzC != 0) {
                String nativeGetDNSNameServers = nativeGetDNSNameServers(this.mzC);
                if (!nativeGetDNSNameServers.isEmpty()) {
                    this.mzL = nativeGetDNSNameServers;
                }
                String nativeGetDNSResults = nativeGetDNSResults(this.mzC);
                if (!nativeGetDNSResults.isEmpty()) {
                    this.mzK = nativeGetDNSResults;
                }
                String nativeGetDNSErrorCode = nativeGetDNSErrorCode(this.mzC);
                if (!nativeGetDNSErrorCode.isEmpty()) {
                    this.mzM = nativeGetDNSErrorCode;
                }
                String nativeGetConnectionAttempts = nativeGetConnectionAttempts(this.mzC, false);
                if (!nativeGetConnectionAttempts.isEmpty()) {
                    this.mzN = nativeGetConnectionAttempts;
                }
                String nativeGetConnectionAttempts2 = nativeGetConnectionAttempts(this.mzC, true);
                if (!nativeGetConnectionAttempts2.isEmpty()) {
                    this.mzO = nativeGetConnectionAttempts2;
                }
                String nativeGetRemoteEndpoint = nativeGetRemoteEndpoint(this.mzC);
                if (!nativeGetRemoteEndpoint.isEmpty()) {
                    this.mzP = nativeGetRemoteEndpoint;
                }
                String nativeGetSuperPipeInfo = nativeGetSuperPipeInfo(this.mzC);
                if (!nativeGetSuperPipeInfo.isEmpty()) {
                    this.mzQ = nativeGetSuperPipeInfo;
                }
                long nativeRequestTimeGap = nativeRequestTimeGap(this.mzC, 1);
                if (nativeRequestTimeGap >= 0) {
                    this.mzR = nativeRequestTimeGap;
                }
                long nativeRequestTimeGap2 = nativeRequestTimeGap(this.mzC, 2);
                if (nativeRequestTimeGap2 >= 0) {
                    this.mzS = nativeRequestTimeGap2;
                }
                long nativeRequestTimeGap3 = nativeRequestTimeGap(this.mzC, 3);
                if (nativeRequestTimeGap3 >= 0) {
                    this.mzT = nativeRequestTimeGap3;
                }
                long nativeRequestTimeGap4 = nativeRequestTimeGap(this.mzC, 4);
                if (nativeRequestTimeGap4 >= 0) {
                    this.mzU = nativeRequestTimeGap4;
                }
                long nativeRequestTimeGap5 = nativeRequestTimeGap(this.mzC, 5);
                if (nativeRequestTimeGap5 >= 0) {
                    this.mzV = nativeRequestTimeGap5;
                }
                this.mzW = nativeGetRequestTimeInfo(this.mzC);
                if (this.mzW == null) {
                    this.mzW = new RequestTimeInfo();
                }
                if (this.mzF != null) {
                    this.mzF.dvn();
                }
                nativeDestroy(this.mzC, z);
                if (this.mTag != null) {
                    this.myT.b(this);
                }
                this.myT.dvp();
                this.mzC = 0L;
                if (this.mzh != null) {
                    this.mzh.run();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Exception exc) {
        UrlRequestException urlRequestException = new UrlRequestException("Exception received from UrlRequest.Callback", exc);
        com.baidu.turbonet.base.a.h("ChromiumNetwork", "Exception in CalledByNative method", exc);
        synchronized (this.mzG) {
            if (!duZ()) {
                we(false);
                try {
                    this.mzJ.a(this, this.mzf, urlRequestException);
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
                synchronized (CronetUrlRequest.this.mzG) {
                    if (!CronetUrlRequest.this.duZ()) {
                        CronetUrlRequest.this.we(false);
                        try {
                            CronetUrlRequest.this.mzJ.a(CronetUrlRequest.this, CronetUrlRequest.this.mzf, urlRequestException);
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
        this.mzI += j;
        a2.fE(this.mzI);
        this.mzH.add(str);
        C(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.mzG) {
                    if (!CronetUrlRequest.this.duZ()) {
                        CronetUrlRequest.this.mzD = true;
                        try {
                            CronetUrlRequest.this.mzJ.a(CronetUrlRequest.this, a2, str);
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
        this.mzf = a(i, str, strArr, z, str2, str3);
        C(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.mzG) {
                    if (!CronetUrlRequest.this.duZ()) {
                        if (CronetUrlRequest.this.mzF != null) {
                            CronetUrlRequest.this.mzF.dvo();
                        }
                        CronetUrlRequest.this.mzE = true;
                        try {
                            CronetUrlRequest.this.mzJ.a(CronetUrlRequest.this, CronetUrlRequest.this.mzf);
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
        this.mzf.fE(this.mzI + j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            a(new UrlRequestException("ByteBuffer modified externally during read", null));
            return;
        }
        if (this.mAl == null) {
            this.mAl = new a();
        }
        byteBuffer.position(i2 + i);
        this.mAl.mByteBuffer = byteBuffer;
        C(this.mAl);
    }

    @CalledByNative
    private void onSucceeded(long j) {
        this.mzf.fE(this.mzI + j);
        C(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.mzG) {
                    if (!CronetUrlRequest.this.duZ()) {
                        CronetUrlRequest.this.we(false);
                        try {
                            CronetUrlRequest.this.mzJ.b(CronetUrlRequest.this, CronetUrlRequest.this.mzf);
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
        if (this.mzf != null) {
            this.mzf.fE(this.mzI + j);
        }
        a(new UrlRequestException("Exception in CronetUrlRequest: " + str, i, i2));
    }

    @CalledByNative
    private void onCanceled() {
        C(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.turbonet.base.a.h("ChromiumNetwork", "****** onCanceled, url is: %s", CronetUrlRequest.this.mzf.getUrl());
                    CronetUrlRequest.this.mzJ.c(CronetUrlRequest.this, CronetUrlRequest.this.mzf);
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
        private Long mAs;
        @Nullable
        private Long mAt;
        @Nullable
        private Long mAu;

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dvm() {
            if (this.mAs != null) {
                throw new IllegalStateException("onRequestStarted called repeatedly");
            }
            this.mAs = Long.valueOf(SystemClock.elapsedRealtime());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dvn() {
            if (this.mAs != null && this.mAu == null) {
                this.mAu = Long.valueOf(SystemClock.elapsedRealtime() - this.mAs.longValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dvo() {
            if (this.mAs != null && this.mAt == null) {
                this.mAt = Long.valueOf(SystemClock.elapsedRealtime() - this.mAs.longValue());
            }
        }
    }
}
