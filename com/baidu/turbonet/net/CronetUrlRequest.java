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
/* loaded from: classes17.dex */
public final class CronetUrlRequest implements UrlRequest {
    private static final TurbonetEngine.UrlRequestMetrics nAv = new TurbonetEngine.UrlRequestMetrics(null, null, null, null);
    private final Executor mExecutor;
    private final int mPriority;
    private Object mTag;
    private long nAC;
    private final UrlRequest.Callback nAD;
    private String nAE;
    private String nAF;
    private String nAG;
    private String nAH;
    private String nAI;
    private String nAJ;
    private String nAK;
    private long nAL;
    private long nAM;
    private long nAN;
    private long nAO;
    private long nAP;
    private RequestTimeInfo nAQ;
    private final Collection<Object> nAS;
    private final boolean nAT;
    private final boolean nAU;
    private final boolean nAV;
    private boolean nAW;
    private boolean nAX;
    private int nAY;
    private int nAZ;
    private Runnable nAb;
    @GuardedBy("mUrlRequestAdapterLock")
    private long nAw;
    @GuardedBy("mUrlRequestAdapterLock")
    @Nullable
    private final b nAz;
    private int nBa;
    private int nBb;
    private String nBc;
    private String nBd;
    private CronetUploadDataStream nBe;
    private a nBf;
    private final CronetUrlRequestContext nzN;
    private final String nzP;
    private String nzQ;
    private UrlResponseInfo nzZ;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mStarted = false;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean nAx = false;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean nAy = false;
    private final Object nAA = new Object();
    private final List<String> nAB = new ArrayList();
    private final HeadersList nAR = new HeadersList();

    /* loaded from: classes17.dex */
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
    /* loaded from: classes17.dex */
    public static final class HeadersList extends ArrayList<Map.Entry<String, String>> {
        private HeadersList() {
        }
    }

    /* loaded from: classes17.dex */
    private final class a implements Runnable {
        ByteBuffer mByteBuffer;

        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ByteBuffer byteBuffer = this.mByteBuffer;
            this.mByteBuffer = null;
            try {
                synchronized (CronetUrlRequest.this.nAA) {
                    if (!CronetUrlRequest.this.dRT()) {
                        CronetUrlRequest.this.nAy = true;
                        CronetUrlRequest.this.nAD.a(CronetUrlRequest.this, CronetUrlRequest.this.nzZ, byteBuffer);
                    }
                }
            } catch (Exception e) {
                CronetUrlRequest.this.y(e);
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
        this.nzN = cronetUrlRequestContext;
        this.nzP = str;
        this.nAB.add(str);
        this.mPriority = Lr(i);
        this.nAD = callback;
        this.mExecutor = executor;
        this.nAS = collection;
        this.nAz = z ? new b() : null;
        this.nAT = z2;
        this.nAU = z3;
        this.nAV = z4;
        this.nAW = false;
        this.nAX = false;
        this.nAY = 0;
        this.nAZ = 0;
        this.nBa = 0;
        this.nBb = 0;
        this.mTag = null;
        this.nBc = null;
        this.nBd = null;
        this.nzZ = new UrlResponseInfo(new ArrayList(this.nAB), 0, "", new HeadersList(), false, "", "");
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Uu(String str) {
        dSf();
        if (str == null) {
            throw new NullPointerException("Method is required.");
        }
        this.nzQ = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void addHeader(String str, String str2) {
        dSf();
        if (str == null) {
            throw new NullPointerException("Invalid header name.");
        }
        if (str2 == null) {
            throw new NullPointerException("Invalid header value.");
        }
        this.nAR.add(new AbstractMap.SimpleImmutableEntry(str, str2));
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void a(UploadDataProvider uploadDataProvider, Executor executor) {
        if (uploadDataProvider == null) {
            throw new NullPointerException("Invalid UploadDataProvider.");
        }
        if (this.nzQ == null) {
            this.nzQ = "POST";
        }
        this.nBe = new CronetUploadDataStream(uploadDataProvider, executor, this);
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void start() {
        synchronized (this.nAA) {
            com.baidu.turbonet.base.a.f("ChromiumNetwork", "****** Request start, url is: %s", this.nzP);
            dSf();
            try {
                this.nAw = nativeCreateRequestAdapter(this.nzN.dSk(), this.nzP, this.mPriority, this.nAT, this.nAU, this.nAV);
                this.nzN.dSg();
                if (this.nzQ != null && !nativeSetHttpMethod(this.nAw, this.nzQ)) {
                    throw new IllegalArgumentException("Invalid http method " + this.nzQ);
                }
                if (this.mTag != null) {
                    this.nzN.a(this);
                }
                if (this.nAW) {
                    nativeDisableResponseAutoUngzip(this.nAw);
                }
                if (this.nAX) {
                    nativeEnableBrotliByRequest(this.nAw);
                }
                if (this.nAY > 0) {
                    nativeSetTimeout(this.nAw, this.nAY);
                }
                if (this.nAZ > 0) {
                    nativeSetTCPConnectTimeout(this.nAw, this.nAZ);
                }
                if (this.nBa > 0) {
                    nativeSetResponseHeaderRecvTimeout(this.nAw, this.nBa);
                }
                if (this.nBb > 0) {
                    nativeSetResponseBodyReadTimeout(this.nAw, this.nBb);
                }
                if (!TextUtils.isEmpty(this.nBc)) {
                    nativeSetDestinationAddress(this.nAw, this.nBc);
                }
                if (!TextUtils.isEmpty(this.nBd)) {
                    nativeSetRequestTag(this.nAw, this.nBd);
                }
                Iterator<Map.Entry<String, String>> it = this.nAR.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    boolean z2 = (!next.getKey().equalsIgnoreCase("Content-Type") || next.getValue().isEmpty()) ? z : true;
                    if (!nativeAddRequestHeader(this.nAw, next.getKey(), next.getValue())) {
                        throw new IllegalArgumentException("Invalid header " + next.getKey() + ETAG.EQUAL + next.getValue());
                    }
                    z = z2;
                }
                if (this.nBe != null) {
                    if (!z) {
                        throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
                    }
                    this.mStarted = true;
                    this.nBe.y(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CronetUrlRequest.this.nBe.dSa();
                            synchronized (CronetUrlRequest.this.nAA) {
                                if (!CronetUrlRequest.this.dRT()) {
                                    CronetUrlRequest.this.nBe.gJ(CronetUrlRequest.this.nAw);
                                    CronetUrlRequest.this.dSb();
                                }
                            }
                        }
                    });
                    return;
                }
                this.mStarted = true;
                dSb();
            } catch (RuntimeException e) {
                yr(false);
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public void dSb() {
        if (this.nAz != null) {
            this.nAz.dSg();
        }
        nativeStart(this.nAw);
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void dSc() {
        synchronized (this.nAA) {
            if (!this.nAx) {
                throw new IllegalStateException("No redirect to follow.");
            }
            this.nAx = false;
            if (!dRT()) {
                nativeFollowDeferredRedirect(this.nAw);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void o(ByteBuffer byteBuffer) {
        com.baidu.turbonet.net.b.q(byteBuffer);
        com.baidu.turbonet.net.b.p(byteBuffer);
        synchronized (this.nAA) {
            if (!this.nAy) {
                throw new IllegalStateException("Unexpected read attempt.");
            }
            this.nAy = false;
            if (!dRT()) {
                if (!nativeReadData(this.nAw, byteBuffer, byteBuffer.position(), byteBuffer.limit())) {
                    this.nAy = true;
                    throw new IllegalArgumentException("Unable to call native read");
                }
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void cancel() {
        synchronized (this.nAA) {
            com.baidu.turbonet.base.a.f("ChromiumNetwork", "****** Request cancel, url is: %s", this.nzP);
            if (!dRT() && this.mStarted) {
                yr(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public boolean dRT() {
        return this.mStarted && this.nAw == 0;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void dSd() {
        dSf();
        this.nAW = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void dSe() {
        dSf();
        this.nAX = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setTimeout(int i) {
        dSf();
        this.nAY = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Lo(int i) {
        dSf();
        this.nAZ = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Lp(int i) {
        dSf();
        this.nBa = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Lq(int i) {
        dSf();
        this.nBb = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setTag(Object obj) {
        dSf();
        this.mTag = obj;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Uv(String str) {
        dSf();
        this.nBc = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Uw(String str) {
        dSf();
        this.nBd = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public Object getTag() {
        return this.mTag;
    }

    @CalledByNative
    public static RequestTimeInfo createObject(long j, long j2, long j3, long j4, long j5) {
        return new RequestTimeInfo(j, j2, j3, j4, j5);
    }

    private void y(Runnable runnable) {
        try {
            this.mExecutor.execute(runnable);
        } catch (RejectedExecutionException e) {
            com.baidu.turbonet.base.a.g("ChromiumNetwork", "Exception posting task to executor", e);
            yr(false);
        }
    }

    private static int Lr(int i) {
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
        return new UrlResponseInfo(new ArrayList(this.nAB), i, str, headersList, z, str2, str3);
    }

    private void dSf() {
        synchronized (this.nAA) {
            if (this.mStarted || dRT()) {
                throw new IllegalStateException("Request is already started.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yr(boolean z) {
        synchronized (this.nAA) {
            if (this.nAw != 0) {
                String nativeGetDNSNameServers = nativeGetDNSNameServers(this.nAw);
                if (!nativeGetDNSNameServers.isEmpty()) {
                    this.nAF = nativeGetDNSNameServers;
                }
                String nativeGetDNSResults = nativeGetDNSResults(this.nAw);
                if (!nativeGetDNSResults.isEmpty()) {
                    this.nAE = nativeGetDNSResults;
                }
                String nativeGetDNSErrorCode = nativeGetDNSErrorCode(this.nAw);
                if (!nativeGetDNSErrorCode.isEmpty()) {
                    this.nAG = nativeGetDNSErrorCode;
                }
                String nativeGetConnectionAttempts = nativeGetConnectionAttempts(this.nAw, false);
                if (!nativeGetConnectionAttempts.isEmpty()) {
                    this.nAH = nativeGetConnectionAttempts;
                }
                String nativeGetConnectionAttempts2 = nativeGetConnectionAttempts(this.nAw, true);
                if (!nativeGetConnectionAttempts2.isEmpty()) {
                    this.nAI = nativeGetConnectionAttempts2;
                }
                String nativeGetRemoteEndpoint = nativeGetRemoteEndpoint(this.nAw);
                if (!nativeGetRemoteEndpoint.isEmpty()) {
                    this.nAJ = nativeGetRemoteEndpoint;
                }
                String nativeGetSuperPipeInfo = nativeGetSuperPipeInfo(this.nAw);
                if (!nativeGetSuperPipeInfo.isEmpty()) {
                    this.nAK = nativeGetSuperPipeInfo;
                }
                long nativeRequestTimeGap = nativeRequestTimeGap(this.nAw, 1);
                if (nativeRequestTimeGap >= 0) {
                    this.nAL = nativeRequestTimeGap;
                }
                long nativeRequestTimeGap2 = nativeRequestTimeGap(this.nAw, 2);
                if (nativeRequestTimeGap2 >= 0) {
                    this.nAM = nativeRequestTimeGap2;
                }
                long nativeRequestTimeGap3 = nativeRequestTimeGap(this.nAw, 3);
                if (nativeRequestTimeGap3 >= 0) {
                    this.nAN = nativeRequestTimeGap3;
                }
                long nativeRequestTimeGap4 = nativeRequestTimeGap(this.nAw, 4);
                if (nativeRequestTimeGap4 >= 0) {
                    this.nAO = nativeRequestTimeGap4;
                }
                long nativeRequestTimeGap5 = nativeRequestTimeGap(this.nAw, 5);
                if (nativeRequestTimeGap5 >= 0) {
                    this.nAP = nativeRequestTimeGap5;
                }
                this.nAQ = nativeGetRequestTimeInfo(this.nAw);
                if (this.nAQ == null) {
                    this.nAQ = new RequestTimeInfo();
                }
                if (this.nAz != null) {
                    this.nAz.dSh();
                }
                nativeDestroy(this.nAw, z);
                if (this.mTag != null) {
                    this.nzN.b(this);
                }
                this.nzN.dSj();
                this.nAw = 0L;
                if (this.nAb != null) {
                    this.nAb.run();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Exception exc) {
        UrlRequestException urlRequestException = new UrlRequestException("Exception received from UrlRequest.Callback", exc);
        com.baidu.turbonet.base.a.g("ChromiumNetwork", "Exception in CalledByNative method", exc);
        synchronized (this.nAA) {
            if (!dRT()) {
                yr(false);
                try {
                    this.nAD.a(this, this.nzZ, urlRequestException);
                } catch (Exception e) {
                    com.baidu.turbonet.base.a.g("ChromiumNetwork", "Exception notifying of failed request", e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(Throwable th) {
        UrlRequestException urlRequestException = new UrlRequestException("Exception received from UploadDataProvider", th);
        com.baidu.turbonet.base.a.g("ChromiumNetwork", "Exception in upload method", th);
        a(urlRequestException);
    }

    private void a(final UrlRequestException urlRequestException) {
        y(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.nAA) {
                    if (!CronetUrlRequest.this.dRT()) {
                        CronetUrlRequest.this.yr(false);
                        try {
                            CronetUrlRequest.this.nAD.a(CronetUrlRequest.this, CronetUrlRequest.this.nzZ, urlRequestException);
                        } catch (Exception e) {
                            com.baidu.turbonet.base.a.g("ChromiumNetwork", "Exception in onError method", e);
                        }
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onRedirectReceived(final String str, int i, String str2, String[] strArr, boolean z, String str3, String str4, long j) {
        final UrlResponseInfo a2 = a(i, str2, strArr, z, str3, str4);
        this.nAC += j;
        a2.gL(this.nAC);
        this.nAB.add(str);
        y(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.nAA) {
                    if (!CronetUrlRequest.this.dRT()) {
                        CronetUrlRequest.this.nAx = true;
                        try {
                            CronetUrlRequest.this.nAD.a(CronetUrlRequest.this, a2, str);
                        } catch (Exception e) {
                            CronetUrlRequest.this.y(e);
                        }
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onResponseStarted(int i, String str, String[] strArr, boolean z, String str2, String str3) {
        this.nzZ = a(i, str, strArr, z, str2, str3);
        y(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.nAA) {
                    if (!CronetUrlRequest.this.dRT()) {
                        if (CronetUrlRequest.this.nAz != null) {
                            CronetUrlRequest.this.nAz.dSi();
                        }
                        CronetUrlRequest.this.nAy = true;
                        try {
                            CronetUrlRequest.this.nAD.a(CronetUrlRequest.this, CronetUrlRequest.this.nzZ);
                        } catch (Exception e) {
                            CronetUrlRequest.this.y(e);
                        }
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onReadCompleted(ByteBuffer byteBuffer, int i, int i2, int i3, long j) {
        this.nzZ.gL(this.nAC + j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            a(new UrlRequestException("ByteBuffer modified externally during read", null));
            return;
        }
        if (this.nBf == null) {
            this.nBf = new a();
        }
        byteBuffer.position(i2 + i);
        this.nBf.mByteBuffer = byteBuffer;
        y(this.nBf);
    }

    @CalledByNative
    private void onSucceeded(long j) {
        this.nzZ.gL(this.nAC + j);
        y(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.nAA) {
                    if (!CronetUrlRequest.this.dRT()) {
                        CronetUrlRequest.this.yr(false);
                        try {
                            CronetUrlRequest.this.nAD.b(CronetUrlRequest.this, CronetUrlRequest.this.nzZ);
                        } catch (Exception e) {
                            com.baidu.turbonet.base.a.g("ChromiumNetwork", "Exception in onComplete method", e);
                        }
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onError(int i, int i2, int i3, String str, long j) {
        if (this.nzZ != null) {
            this.nzZ.gL(this.nAC + j);
        }
        a(new UrlRequestException("Exception in CronetUrlRequest: " + str, i, i2));
    }

    @CalledByNative
    private void onCanceled() {
        y(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.turbonet.base.a.g("ChromiumNetwork", "****** onCanceled, url is: %s", CronetUrlRequest.this.nzZ.getUrl());
                    CronetUrlRequest.this.nAD.c(CronetUrlRequest.this, CronetUrlRequest.this.nzZ);
                } catch (Exception e) {
                    com.baidu.turbonet.base.a.g("ChromiumNetwork", "Exception in onCanceled method", e);
                }
            }
        });
    }

    @CalledByNative
    private void onStatus(final UrlRequest.StatusListener statusListener, final int i) {
        y(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.7
            @Override // java.lang.Runnable
            public void run() {
                statusListener.LH(UrlRequest.Status.LG(i));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public final class b {
        @Nullable
        private Long nBm;
        @Nullable
        private Long nBn;
        @Nullable
        private Long nBo;

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dSg() {
            if (this.nBm != null) {
                throw new IllegalStateException("onRequestStarted called repeatedly");
            }
            this.nBm = Long.valueOf(SystemClock.elapsedRealtime());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dSh() {
            if (this.nBm != null && this.nBo == null) {
                this.nBo = Long.valueOf(SystemClock.elapsedRealtime() - this.nBm.longValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dSi() {
            if (this.nBm != null && this.nBn == null) {
                this.nBn = Long.valueOf(SystemClock.elapsedRealtime() - this.nBm.longValue());
            }
        }
    }
}
