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
    private static final TurbonetEngine.UrlRequestMetrics naZ = new TurbonetEngine.UrlRequestMetrics(null, null, null, null);
    private final Executor mExecutor;
    private final int mPriority;
    private Object mTag;
    private UrlResponseInfo naD;
    private Runnable naF;
    private final CronetUrlRequestContext nar;
    private final String nat;
    private String nau;
    private boolean nbA;
    private boolean nbB;
    private int nbC;
    private int nbD;
    private int nbE;
    private int nbF;
    private String nbG;
    private String nbH;
    private CronetUploadDataStream nbI;
    private a nbJ;
    @GuardedBy("mUrlRequestAdapterLock")
    private long nba;
    @GuardedBy("mUrlRequestAdapterLock")
    @Nullable
    private final b nbd;
    private long nbg;
    private final UrlRequest.Callback nbh;
    private String nbi;
    private String nbj;
    private String nbk;
    private String nbl;
    private String nbm;
    private String nbn;
    private String nbo;
    private long nbp;
    private long nbq;
    private long nbr;
    private long nbs;
    private long nbt;
    private RequestTimeInfo nbu;
    private final Collection<Object> nbw;
    private final boolean nbx;
    private final boolean nby;
    private final boolean nbz;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mStarted = false;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean nbb = false;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean nbc = false;
    private final Object nbe = new Object();
    private final List<String> nbf = new ArrayList();
    private final HeadersList nbv = new HeadersList();

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
                synchronized (CronetUrlRequest.this.nbe) {
                    if (!CronetUrlRequest.this.dKj()) {
                        CronetUrlRequest.this.nbc = true;
                        CronetUrlRequest.this.nbh.a(CronetUrlRequest.this, CronetUrlRequest.this.naD, byteBuffer);
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
        this.nar = cronetUrlRequestContext;
        this.nat = str;
        this.nbf.add(str);
        this.mPriority = Kg(i);
        this.nbh = callback;
        this.mExecutor = executor;
        this.nbw = collection;
        this.nbd = z ? new b() : null;
        this.nbx = z2;
        this.nby = z3;
        this.nbz = z4;
        this.nbA = false;
        this.nbB = false;
        this.nbC = 0;
        this.nbD = 0;
        this.nbE = 0;
        this.nbF = 0;
        this.mTag = null;
        this.nbG = null;
        this.nbH = null;
        this.naD = new UrlResponseInfo(new ArrayList(this.nbf), 0, "", new HeadersList(), false, "", "");
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Th(String str) {
        dKv();
        if (str == null) {
            throw new NullPointerException("Method is required.");
        }
        this.nau = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void addHeader(String str, String str2) {
        dKv();
        if (str == null) {
            throw new NullPointerException("Invalid header name.");
        }
        if (str2 == null) {
            throw new NullPointerException("Invalid header value.");
        }
        this.nbv.add(new AbstractMap.SimpleImmutableEntry(str, str2));
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void a(UploadDataProvider uploadDataProvider, Executor executor) {
        if (uploadDataProvider == null) {
            throw new NullPointerException("Invalid UploadDataProvider.");
        }
        if (this.nau == null) {
            this.nau = "POST";
        }
        this.nbI = new CronetUploadDataStream(uploadDataProvider, executor, this);
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void start() {
        synchronized (this.nbe) {
            com.baidu.turbonet.base.a.f("ChromiumNetwork", "****** Request start, url is: %s", this.nat);
            dKv();
            try {
                this.nba = nativeCreateRequestAdapter(this.nar.dKA(), this.nat, this.mPriority, this.nbx, this.nby, this.nbz);
                this.nar.dKw();
                if (this.nau != null && !nativeSetHttpMethod(this.nba, this.nau)) {
                    throw new IllegalArgumentException("Invalid http method " + this.nau);
                }
                if (this.mTag != null) {
                    this.nar.a(this);
                }
                if (this.nbA) {
                    nativeDisableResponseAutoUngzip(this.nba);
                }
                if (this.nbB) {
                    nativeEnableBrotliByRequest(this.nba);
                }
                if (this.nbC > 0) {
                    nativeSetTimeout(this.nba, this.nbC);
                }
                if (this.nbD > 0) {
                    nativeSetTCPConnectTimeout(this.nba, this.nbD);
                }
                if (this.nbE > 0) {
                    nativeSetResponseHeaderRecvTimeout(this.nba, this.nbE);
                }
                if (this.nbF > 0) {
                    nativeSetResponseBodyReadTimeout(this.nba, this.nbF);
                }
                if (!TextUtils.isEmpty(this.nbG)) {
                    nativeSetDestinationAddress(this.nba, this.nbG);
                }
                if (!TextUtils.isEmpty(this.nbH)) {
                    nativeSetRequestTag(this.nba, this.nbH);
                }
                Iterator<Map.Entry<String, String>> it = this.nbv.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    boolean z2 = (!next.getKey().equalsIgnoreCase("Content-Type") || next.getValue().isEmpty()) ? z : true;
                    if (!nativeAddRequestHeader(this.nba, next.getKey(), next.getValue())) {
                        throw new IllegalArgumentException("Invalid header " + next.getKey() + ETAG.EQUAL + next.getValue());
                    }
                    z = z2;
                }
                if (this.nbI != null) {
                    if (!z) {
                        throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
                    }
                    this.mStarted = true;
                    this.nbI.y(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CronetUrlRequest.this.nbI.dKq();
                            synchronized (CronetUrlRequest.this.nbe) {
                                if (!CronetUrlRequest.this.dKj()) {
                                    CronetUrlRequest.this.nbI.gd(CronetUrlRequest.this.nba);
                                    CronetUrlRequest.this.dKr();
                                }
                            }
                        }
                    });
                    return;
                }
                this.mStarted = true;
                dKr();
            } catch (RuntimeException e) {
                xB(false);
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public void dKr() {
        if (this.nbd != null) {
            this.nbd.dKw();
        }
        nativeStart(this.nba);
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void dKs() {
        synchronized (this.nbe) {
            if (!this.nbb) {
                throw new IllegalStateException("No redirect to follow.");
            }
            this.nbb = false;
            if (!dKj()) {
                nativeFollowDeferredRedirect(this.nba);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void m(ByteBuffer byteBuffer) {
        com.baidu.turbonet.net.b.o(byteBuffer);
        com.baidu.turbonet.net.b.n(byteBuffer);
        synchronized (this.nbe) {
            if (!this.nbc) {
                throw new IllegalStateException("Unexpected read attempt.");
            }
            this.nbc = false;
            if (!dKj()) {
                if (!nativeReadData(this.nba, byteBuffer, byteBuffer.position(), byteBuffer.limit())) {
                    this.nbc = true;
                    throw new IllegalArgumentException("Unable to call native read");
                }
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void cancel() {
        synchronized (this.nbe) {
            com.baidu.turbonet.base.a.f("ChromiumNetwork", "****** Request cancel, url is: %s", this.nat);
            if (!dKj() && this.mStarted) {
                xB(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public boolean dKj() {
        return this.mStarted && this.nba == 0;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void dKt() {
        dKv();
        this.nbA = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void dKu() {
        dKv();
        this.nbB = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setTimeout(int i) {
        dKv();
        this.nbC = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Kd(int i) {
        dKv();
        this.nbD = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Ke(int i) {
        dKv();
        this.nbE = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Kf(int i) {
        dKv();
        this.nbF = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setTag(Object obj) {
        dKv();
        this.mTag = obj;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Ti(String str) {
        dKv();
        this.nbG = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Tj(String str) {
        dKv();
        this.nbH = str;
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
            xB(false);
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
        return new UrlResponseInfo(new ArrayList(this.nbf), i, str, headersList, z, str2, str3);
    }

    private void dKv() {
        synchronized (this.nbe) {
            if (this.mStarted || dKj()) {
                throw new IllegalStateException("Request is already started.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xB(boolean z) {
        synchronized (this.nbe) {
            if (this.nba != 0) {
                String nativeGetDNSNameServers = nativeGetDNSNameServers(this.nba);
                if (!nativeGetDNSNameServers.isEmpty()) {
                    this.nbj = nativeGetDNSNameServers;
                }
                String nativeGetDNSResults = nativeGetDNSResults(this.nba);
                if (!nativeGetDNSResults.isEmpty()) {
                    this.nbi = nativeGetDNSResults;
                }
                String nativeGetDNSErrorCode = nativeGetDNSErrorCode(this.nba);
                if (!nativeGetDNSErrorCode.isEmpty()) {
                    this.nbk = nativeGetDNSErrorCode;
                }
                String nativeGetConnectionAttempts = nativeGetConnectionAttempts(this.nba, false);
                if (!nativeGetConnectionAttempts.isEmpty()) {
                    this.nbl = nativeGetConnectionAttempts;
                }
                String nativeGetConnectionAttempts2 = nativeGetConnectionAttempts(this.nba, true);
                if (!nativeGetConnectionAttempts2.isEmpty()) {
                    this.nbm = nativeGetConnectionAttempts2;
                }
                String nativeGetRemoteEndpoint = nativeGetRemoteEndpoint(this.nba);
                if (!nativeGetRemoteEndpoint.isEmpty()) {
                    this.nbn = nativeGetRemoteEndpoint;
                }
                String nativeGetSuperPipeInfo = nativeGetSuperPipeInfo(this.nba);
                if (!nativeGetSuperPipeInfo.isEmpty()) {
                    this.nbo = nativeGetSuperPipeInfo;
                }
                long nativeRequestTimeGap = nativeRequestTimeGap(this.nba, 1);
                if (nativeRequestTimeGap >= 0) {
                    this.nbp = nativeRequestTimeGap;
                }
                long nativeRequestTimeGap2 = nativeRequestTimeGap(this.nba, 2);
                if (nativeRequestTimeGap2 >= 0) {
                    this.nbq = nativeRequestTimeGap2;
                }
                long nativeRequestTimeGap3 = nativeRequestTimeGap(this.nba, 3);
                if (nativeRequestTimeGap3 >= 0) {
                    this.nbr = nativeRequestTimeGap3;
                }
                long nativeRequestTimeGap4 = nativeRequestTimeGap(this.nba, 4);
                if (nativeRequestTimeGap4 >= 0) {
                    this.nbs = nativeRequestTimeGap4;
                }
                long nativeRequestTimeGap5 = nativeRequestTimeGap(this.nba, 5);
                if (nativeRequestTimeGap5 >= 0) {
                    this.nbt = nativeRequestTimeGap5;
                }
                this.nbu = nativeGetRequestTimeInfo(this.nba);
                if (this.nbu == null) {
                    this.nbu = new RequestTimeInfo();
                }
                if (this.nbd != null) {
                    this.nbd.dKx();
                }
                nativeDestroy(this.nba, z);
                if (this.mTag != null) {
                    this.nar.b(this);
                }
                this.nar.dKz();
                this.nba = 0L;
                if (this.naF != null) {
                    this.naF.run();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Exception exc) {
        UrlRequestException urlRequestException = new UrlRequestException("Exception received from UrlRequest.Callback", exc);
        com.baidu.turbonet.base.a.g("ChromiumNetwork", "Exception in CalledByNative method", exc);
        synchronized (this.nbe) {
            if (!dKj()) {
                xB(false);
                try {
                    this.nbh.a(this, this.naD, urlRequestException);
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
                synchronized (CronetUrlRequest.this.nbe) {
                    if (!CronetUrlRequest.this.dKj()) {
                        CronetUrlRequest.this.xB(false);
                        try {
                            CronetUrlRequest.this.nbh.a(CronetUrlRequest.this, CronetUrlRequest.this.naD, urlRequestException);
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
        this.nbg += j;
        a2.gf(this.nbg);
        this.nbf.add(str);
        y(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.nbe) {
                    if (!CronetUrlRequest.this.dKj()) {
                        CronetUrlRequest.this.nbb = true;
                        try {
                            CronetUrlRequest.this.nbh.a(CronetUrlRequest.this, a2, str);
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
        this.naD = a(i, str, strArr, z, str2, str3);
        y(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.nbe) {
                    if (!CronetUrlRequest.this.dKj()) {
                        if (CronetUrlRequest.this.nbd != null) {
                            CronetUrlRequest.this.nbd.dKy();
                        }
                        CronetUrlRequest.this.nbc = true;
                        try {
                            CronetUrlRequest.this.nbh.a(CronetUrlRequest.this, CronetUrlRequest.this.naD);
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
        this.naD.gf(this.nbg + j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            a(new UrlRequestException("ByteBuffer modified externally during read", null));
            return;
        }
        if (this.nbJ == null) {
            this.nbJ = new a();
        }
        byteBuffer.position(i2 + i);
        this.nbJ.mByteBuffer = byteBuffer;
        y(this.nbJ);
    }

    @CalledByNative
    private void onSucceeded(long j) {
        this.naD.gf(this.nbg + j);
        y(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.nbe) {
                    if (!CronetUrlRequest.this.dKj()) {
                        CronetUrlRequest.this.xB(false);
                        try {
                            CronetUrlRequest.this.nbh.b(CronetUrlRequest.this, CronetUrlRequest.this.naD);
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
        if (this.naD != null) {
            this.naD.gf(this.nbg + j);
        }
        a(new UrlRequestException("Exception in CronetUrlRequest: " + str, i, i2));
    }

    @CalledByNative
    private void onCanceled() {
        y(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.turbonet.base.a.g("ChromiumNetwork", "****** onCanceled, url is: %s", CronetUrlRequest.this.naD.getUrl());
                    CronetUrlRequest.this.nbh.c(CronetUrlRequest.this, CronetUrlRequest.this.naD);
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
        private Long nbQ;
        @Nullable
        private Long nbR;
        @Nullable
        private Long nbS;

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dKw() {
            if (this.nbQ != null) {
                throw new IllegalStateException("onRequestStarted called repeatedly");
            }
            this.nbQ = Long.valueOf(SystemClock.elapsedRealtime());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dKx() {
            if (this.nbQ != null && this.nbS == null) {
                this.nbS = Long.valueOf(SystemClock.elapsedRealtime() - this.nbQ.longValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dKy() {
            if (this.nbQ != null && this.nbR == null) {
                this.nbR = Long.valueOf(SystemClock.elapsedRealtime() - this.nbQ.longValue());
            }
        }
    }
}
