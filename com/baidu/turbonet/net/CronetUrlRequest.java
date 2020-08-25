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
/* loaded from: classes10.dex */
public final class CronetUrlRequest implements UrlRequest {
    private static final TurbonetEngine.UrlRequestMetrics naH = new TurbonetEngine.UrlRequestMetrics(null, null, null, null);
    private final Executor mExecutor;
    private final int mPriority;
    private Object mTag;
    private final CronetUrlRequestContext mZZ;
    @GuardedBy("mUrlRequestAdapterLock")
    private long naI;
    @GuardedBy("mUrlRequestAdapterLock")
    @Nullable
    private final b naL;
    private long naO;
    private final UrlRequest.Callback naP;
    private String naQ;
    private String naR;
    private String naS;
    private String naT;
    private String naU;
    private String naV;
    private String naW;
    private long naX;
    private long naY;
    private long naZ;
    private final String nab;
    private String nac;
    private UrlResponseInfo nal;
    private Runnable nan;
    private long nba;
    private long nbb;
    private RequestTimeInfo nbc;
    private final Collection<Object> nbe;
    private final boolean nbf;
    private final boolean nbg;
    private final boolean nbh;
    private boolean nbi;
    private boolean nbj;
    private int nbk;
    private int nbl;
    private int nbm;
    private int nbn;
    private String nbo;
    private String nbp;
    private CronetUploadDataStream nbq;
    private a nbr;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mStarted = false;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean naJ = false;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean naK = false;
    private final Object naM = new Object();
    private final List<String> naN = new ArrayList();
    private final HeadersList nbd = new HeadersList();

    /* loaded from: classes10.dex */
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
    /* loaded from: classes10.dex */
    public static final class HeadersList extends ArrayList<Map.Entry<String, String>> {
        private HeadersList() {
        }
    }

    /* loaded from: classes10.dex */
    private final class a implements Runnable {
        ByteBuffer mByteBuffer;

        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ByteBuffer byteBuffer = this.mByteBuffer;
            this.mByteBuffer = null;
            try {
                synchronized (CronetUrlRequest.this.naM) {
                    if (!CronetUrlRequest.this.dKa()) {
                        CronetUrlRequest.this.naK = true;
                        CronetUrlRequest.this.naP.a(CronetUrlRequest.this, CronetUrlRequest.this.nal, byteBuffer);
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
        this.mZZ = cronetUrlRequestContext;
        this.nab = str;
        this.naN.add(str);
        this.mPriority = Kg(i);
        this.naP = callback;
        this.mExecutor = executor;
        this.nbe = collection;
        this.naL = z ? new b() : null;
        this.nbf = z2;
        this.nbg = z3;
        this.nbh = z4;
        this.nbi = false;
        this.nbj = false;
        this.nbk = 0;
        this.nbl = 0;
        this.nbm = 0;
        this.nbn = 0;
        this.mTag = null;
        this.nbo = null;
        this.nbp = null;
        this.nal = new UrlResponseInfo(new ArrayList(this.naN), 0, "", new HeadersList(), false, "", "");
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Th(String str) {
        dKm();
        if (str == null) {
            throw new NullPointerException("Method is required.");
        }
        this.nac = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void addHeader(String str, String str2) {
        dKm();
        if (str == null) {
            throw new NullPointerException("Invalid header name.");
        }
        if (str2 == null) {
            throw new NullPointerException("Invalid header value.");
        }
        this.nbd.add(new AbstractMap.SimpleImmutableEntry(str, str2));
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void a(UploadDataProvider uploadDataProvider, Executor executor) {
        if (uploadDataProvider == null) {
            throw new NullPointerException("Invalid UploadDataProvider.");
        }
        if (this.nac == null) {
            this.nac = "POST";
        }
        this.nbq = new CronetUploadDataStream(uploadDataProvider, executor, this);
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void start() {
        synchronized (this.naM) {
            com.baidu.turbonet.base.a.f("ChromiumNetwork", "****** Request start, url is: %s", this.nab);
            dKm();
            try {
                this.naI = nativeCreateRequestAdapter(this.mZZ.dKr(), this.nab, this.mPriority, this.nbf, this.nbg, this.nbh);
                this.mZZ.dKn();
                if (this.nac != null && !nativeSetHttpMethod(this.naI, this.nac)) {
                    throw new IllegalArgumentException("Invalid http method " + this.nac);
                }
                if (this.mTag != null) {
                    this.mZZ.a(this);
                }
                if (this.nbi) {
                    nativeDisableResponseAutoUngzip(this.naI);
                }
                if (this.nbj) {
                    nativeEnableBrotliByRequest(this.naI);
                }
                if (this.nbk > 0) {
                    nativeSetTimeout(this.naI, this.nbk);
                }
                if (this.nbl > 0) {
                    nativeSetTCPConnectTimeout(this.naI, this.nbl);
                }
                if (this.nbm > 0) {
                    nativeSetResponseHeaderRecvTimeout(this.naI, this.nbm);
                }
                if (this.nbn > 0) {
                    nativeSetResponseBodyReadTimeout(this.naI, this.nbn);
                }
                if (!TextUtils.isEmpty(this.nbo)) {
                    nativeSetDestinationAddress(this.naI, this.nbo);
                }
                if (!TextUtils.isEmpty(this.nbp)) {
                    nativeSetRequestTag(this.naI, this.nbp);
                }
                Iterator<Map.Entry<String, String>> it = this.nbd.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    boolean z2 = (!next.getKey().equalsIgnoreCase("Content-Type") || next.getValue().isEmpty()) ? z : true;
                    if (!nativeAddRequestHeader(this.naI, next.getKey(), next.getValue())) {
                        throw new IllegalArgumentException("Invalid header " + next.getKey() + ETAG.EQUAL + next.getValue());
                    }
                    z = z2;
                }
                if (this.nbq != null) {
                    if (!z) {
                        throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
                    }
                    this.mStarted = true;
                    this.nbq.y(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CronetUrlRequest.this.nbq.dKh();
                            synchronized (CronetUrlRequest.this.naM) {
                                if (!CronetUrlRequest.this.dKa()) {
                                    CronetUrlRequest.this.nbq.gb(CronetUrlRequest.this.naI);
                                    CronetUrlRequest.this.dKi();
                                }
                            }
                        }
                    });
                    return;
                }
                this.mStarted = true;
                dKi();
            } catch (RuntimeException e) {
                xz(false);
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public void dKi() {
        if (this.naL != null) {
            this.naL.dKn();
        }
        nativeStart(this.naI);
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void dKj() {
        synchronized (this.naM) {
            if (!this.naJ) {
                throw new IllegalStateException("No redirect to follow.");
            }
            this.naJ = false;
            if (!dKa()) {
                nativeFollowDeferredRedirect(this.naI);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void m(ByteBuffer byteBuffer) {
        com.baidu.turbonet.net.b.o(byteBuffer);
        com.baidu.turbonet.net.b.n(byteBuffer);
        synchronized (this.naM) {
            if (!this.naK) {
                throw new IllegalStateException("Unexpected read attempt.");
            }
            this.naK = false;
            if (!dKa()) {
                if (!nativeReadData(this.naI, byteBuffer, byteBuffer.position(), byteBuffer.limit())) {
                    this.naK = true;
                    throw new IllegalArgumentException("Unable to call native read");
                }
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void cancel() {
        synchronized (this.naM) {
            com.baidu.turbonet.base.a.f("ChromiumNetwork", "****** Request cancel, url is: %s", this.nab);
            if (!dKa() && this.mStarted) {
                xz(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public boolean dKa() {
        return this.mStarted && this.naI == 0;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void dKk() {
        dKm();
        this.nbi = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void dKl() {
        dKm();
        this.nbj = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setTimeout(int i) {
        dKm();
        this.nbk = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Kd(int i) {
        dKm();
        this.nbl = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Ke(int i) {
        dKm();
        this.nbm = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Kf(int i) {
        dKm();
        this.nbn = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setTag(Object obj) {
        dKm();
        this.mTag = obj;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Ti(String str) {
        dKm();
        this.nbo = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Tj(String str) {
        dKm();
        this.nbp = str;
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
            xz(false);
        }
    }

    private static int Kg(int i) {
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
        return new UrlResponseInfo(new ArrayList(this.naN), i, str, headersList, z, str2, str3);
    }

    private void dKm() {
        synchronized (this.naM) {
            if (this.mStarted || dKa()) {
                throw new IllegalStateException("Request is already started.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xz(boolean z) {
        synchronized (this.naM) {
            if (this.naI != 0) {
                String nativeGetDNSNameServers = nativeGetDNSNameServers(this.naI);
                if (!nativeGetDNSNameServers.isEmpty()) {
                    this.naR = nativeGetDNSNameServers;
                }
                String nativeGetDNSResults = nativeGetDNSResults(this.naI);
                if (!nativeGetDNSResults.isEmpty()) {
                    this.naQ = nativeGetDNSResults;
                }
                String nativeGetDNSErrorCode = nativeGetDNSErrorCode(this.naI);
                if (!nativeGetDNSErrorCode.isEmpty()) {
                    this.naS = nativeGetDNSErrorCode;
                }
                String nativeGetConnectionAttempts = nativeGetConnectionAttempts(this.naI, false);
                if (!nativeGetConnectionAttempts.isEmpty()) {
                    this.naT = nativeGetConnectionAttempts;
                }
                String nativeGetConnectionAttempts2 = nativeGetConnectionAttempts(this.naI, true);
                if (!nativeGetConnectionAttempts2.isEmpty()) {
                    this.naU = nativeGetConnectionAttempts2;
                }
                String nativeGetRemoteEndpoint = nativeGetRemoteEndpoint(this.naI);
                if (!nativeGetRemoteEndpoint.isEmpty()) {
                    this.naV = nativeGetRemoteEndpoint;
                }
                String nativeGetSuperPipeInfo = nativeGetSuperPipeInfo(this.naI);
                if (!nativeGetSuperPipeInfo.isEmpty()) {
                    this.naW = nativeGetSuperPipeInfo;
                }
                long nativeRequestTimeGap = nativeRequestTimeGap(this.naI, 1);
                if (nativeRequestTimeGap >= 0) {
                    this.naX = nativeRequestTimeGap;
                }
                long nativeRequestTimeGap2 = nativeRequestTimeGap(this.naI, 2);
                if (nativeRequestTimeGap2 >= 0) {
                    this.naY = nativeRequestTimeGap2;
                }
                long nativeRequestTimeGap3 = nativeRequestTimeGap(this.naI, 3);
                if (nativeRequestTimeGap3 >= 0) {
                    this.naZ = nativeRequestTimeGap3;
                }
                long nativeRequestTimeGap4 = nativeRequestTimeGap(this.naI, 4);
                if (nativeRequestTimeGap4 >= 0) {
                    this.nba = nativeRequestTimeGap4;
                }
                long nativeRequestTimeGap5 = nativeRequestTimeGap(this.naI, 5);
                if (nativeRequestTimeGap5 >= 0) {
                    this.nbb = nativeRequestTimeGap5;
                }
                this.nbc = nativeGetRequestTimeInfo(this.naI);
                if (this.nbc == null) {
                    this.nbc = new RequestTimeInfo();
                }
                if (this.naL != null) {
                    this.naL.dKo();
                }
                nativeDestroy(this.naI, z);
                if (this.mTag != null) {
                    this.mZZ.b(this);
                }
                this.mZZ.dKq();
                this.naI = 0L;
                if (this.nan != null) {
                    this.nan.run();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Exception exc) {
        UrlRequestException urlRequestException = new UrlRequestException("Exception received from UrlRequest.Callback", exc);
        com.baidu.turbonet.base.a.g("ChromiumNetwork", "Exception in CalledByNative method", exc);
        synchronized (this.naM) {
            if (!dKa()) {
                xz(false);
                try {
                    this.naP.a(this, this.nal, urlRequestException);
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
                synchronized (CronetUrlRequest.this.naM) {
                    if (!CronetUrlRequest.this.dKa()) {
                        CronetUrlRequest.this.xz(false);
                        try {
                            CronetUrlRequest.this.naP.a(CronetUrlRequest.this, CronetUrlRequest.this.nal, urlRequestException);
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
        this.naO += j;
        a2.gd(this.naO);
        this.naN.add(str);
        y(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.naM) {
                    if (!CronetUrlRequest.this.dKa()) {
                        CronetUrlRequest.this.naJ = true;
                        try {
                            CronetUrlRequest.this.naP.a(CronetUrlRequest.this, a2, str);
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
        this.nal = a(i, str, strArr, z, str2, str3);
        y(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.naM) {
                    if (!CronetUrlRequest.this.dKa()) {
                        if (CronetUrlRequest.this.naL != null) {
                            CronetUrlRequest.this.naL.dKp();
                        }
                        CronetUrlRequest.this.naK = true;
                        try {
                            CronetUrlRequest.this.naP.a(CronetUrlRequest.this, CronetUrlRequest.this.nal);
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
        this.nal.gd(this.naO + j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            a(new UrlRequestException("ByteBuffer modified externally during read", null));
            return;
        }
        if (this.nbr == null) {
            this.nbr = new a();
        }
        byteBuffer.position(i2 + i);
        this.nbr.mByteBuffer = byteBuffer;
        y(this.nbr);
    }

    @CalledByNative
    private void onSucceeded(long j) {
        this.nal.gd(this.naO + j);
        y(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.naM) {
                    if (!CronetUrlRequest.this.dKa()) {
                        CronetUrlRequest.this.xz(false);
                        try {
                            CronetUrlRequest.this.naP.b(CronetUrlRequest.this, CronetUrlRequest.this.nal);
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
        if (this.nal != null) {
            this.nal.gd(this.naO + j);
        }
        a(new UrlRequestException("Exception in CronetUrlRequest: " + str, i, i2));
    }

    @CalledByNative
    private void onCanceled() {
        y(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.turbonet.base.a.g("ChromiumNetwork", "****** onCanceled, url is: %s", CronetUrlRequest.this.nal.getUrl());
                    CronetUrlRequest.this.naP.c(CronetUrlRequest.this, CronetUrlRequest.this.nal);
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
                statusListener.Kw(UrlRequest.Status.Kv(i));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public final class b {
        @Nullable
        private Long nbA;
        @Nullable
        private Long nby;
        @Nullable
        private Long nbz;

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dKn() {
            if (this.nby != null) {
                throw new IllegalStateException("onRequestStarted called repeatedly");
            }
            this.nby = Long.valueOf(SystemClock.elapsedRealtime());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dKo() {
            if (this.nby != null && this.nbA == null) {
                this.nbA = Long.valueOf(SystemClock.elapsedRealtime() - this.nby.longValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dKp() {
            if (this.nby != null && this.nbz == null) {
                this.nbz = Long.valueOf(SystemClock.elapsedRealtime() - this.nby.longValue());
            }
        }
    }
}
