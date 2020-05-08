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
    private static final TurbonetEngine.UrlRequestMetrics lJi = new TurbonetEngine.UrlRequestMetrics(null, null, null, null);
    private final CronetUrlRequestContext lIA;
    private final String lIC;
    private String lID;
    private UrlResponseInfo lIM;
    private Runnable lIO;
    private long lJA;
    private long lJB;
    private long lJC;
    private RequestTimeInfo lJD;
    private final Collection<Object> lJF;
    private final boolean lJG;
    private final boolean lJH;
    private final boolean lJI;
    private boolean lJJ;
    private boolean lJK;
    private int lJL;
    private int lJM;
    private int lJN;
    private int lJO;
    private String lJP;
    private String lJQ;
    private CronetUploadDataStream lJR;
    private a lJS;
    @GuardedBy("mUrlRequestAdapterLock")
    private long lJj;
    @GuardedBy("mUrlRequestAdapterLock")
    @Nullable
    private final b lJm;
    private long lJp;
    private final UrlRequest.Callback lJq;
    private String lJr;
    private String lJs;
    private String lJt;
    private String lJu;
    private String lJv;
    private String lJw;
    private String lJx;
    private long lJy;
    private long lJz;
    private final Executor mExecutor;
    private final int mPriority;
    private Object mTag;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mStarted = false;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean lJk = false;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean lJl = false;
    private final Object lJn = new Object();
    private final List<String> lJo = new ArrayList();
    private final HeadersList lJE = new HeadersList();

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
                synchronized (CronetUrlRequest.this.lJn) {
                    if (!CronetUrlRequest.this.diL()) {
                        CronetUrlRequest.this.lJl = true;
                        CronetUrlRequest.this.lJq.a(CronetUrlRequest.this, CronetUrlRequest.this.lIM, byteBuffer);
                    }
                }
            } catch (Exception e) {
                CronetUrlRequest.this.n(e);
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
        this.lIA = cronetUrlRequestContext;
        this.lIC = str;
        this.lJo.add(str);
        this.mPriority = Fp(i);
        this.lJq = callback;
        this.mExecutor = executor;
        this.lJF = collection;
        this.lJm = z ? new b() : null;
        this.lJG = z2;
        this.lJH = z3;
        this.lJI = z4;
        this.lJJ = false;
        this.lJK = false;
        this.lJL = 0;
        this.lJM = 0;
        this.lJN = 0;
        this.lJO = 0;
        this.mTag = null;
        this.lJP = null;
        this.lJQ = null;
        this.lIM = new UrlResponseInfo(new ArrayList(this.lJo), 0, "", new HeadersList(), false, "", "");
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void MW(String str) {
        diX();
        if (str == null) {
            throw new NullPointerException("Method is required.");
        }
        this.lID = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void addHeader(String str, String str2) {
        diX();
        if (str == null) {
            throw new NullPointerException("Invalid header name.");
        }
        if (str2 == null) {
            throw new NullPointerException("Invalid header value.");
        }
        this.lJE.add(new AbstractMap.SimpleImmutableEntry(str, str2));
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void a(UploadDataProvider uploadDataProvider, Executor executor) {
        if (uploadDataProvider == null) {
            throw new NullPointerException("Invalid UploadDataProvider.");
        }
        if (this.lID == null) {
            this.lID = "POST";
        }
        this.lJR = new CronetUploadDataStream(uploadDataProvider, executor, this);
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void start() {
        synchronized (this.lJn) {
            com.baidu.turbonet.base.a.g("ChromiumNetwork", "****** Request start, url is: %s", this.lIC);
            diX();
            try {
                this.lJj = nativeCreateRequestAdapter(this.lIA.djc(), this.lIC, this.mPriority, this.lJG, this.lJH, this.lJI);
                this.lIA.diY();
                if (this.lID != null && !nativeSetHttpMethod(this.lJj, this.lID)) {
                    throw new IllegalArgumentException("Invalid http method " + this.lID);
                }
                if (this.mTag != null) {
                    this.lIA.a(this);
                }
                if (this.lJJ) {
                    nativeDisableResponseAutoUngzip(this.lJj);
                }
                if (this.lJK) {
                    nativeEnableBrotliByRequest(this.lJj);
                }
                if (this.lJL > 0) {
                    nativeSetTimeout(this.lJj, this.lJL);
                }
                if (this.lJM > 0) {
                    nativeSetTCPConnectTimeout(this.lJj, this.lJM);
                }
                if (this.lJN > 0) {
                    nativeSetResponseHeaderRecvTimeout(this.lJj, this.lJN);
                }
                if (this.lJO > 0) {
                    nativeSetResponseBodyReadTimeout(this.lJj, this.lJO);
                }
                if (!TextUtils.isEmpty(this.lJP)) {
                    nativeSetDestinationAddress(this.lJj, this.lJP);
                }
                if (!TextUtils.isEmpty(this.lJQ)) {
                    nativeSetRequestTag(this.lJj, this.lJQ);
                }
                Iterator<Map.Entry<String, String>> it = this.lJE.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    boolean z2 = (!next.getKey().equalsIgnoreCase("Content-Type") || next.getValue().isEmpty()) ? z : true;
                    if (!nativeAddRequestHeader(this.lJj, next.getKey(), next.getValue())) {
                        throw new IllegalArgumentException("Invalid header " + next.getKey() + ETAG.EQUAL + next.getValue());
                    }
                    z = z2;
                }
                if (this.lJR != null) {
                    if (!z) {
                        throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
                    }
                    this.mStarted = true;
                    this.lJR.A(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CronetUrlRequest.this.lJR.diS();
                            synchronized (CronetUrlRequest.this.lJn) {
                                if (!CronetUrlRequest.this.diL()) {
                                    CronetUrlRequest.this.lJR.fx(CronetUrlRequest.this.lJj);
                                    CronetUrlRequest.this.diT();
                                }
                            }
                        }
                    });
                    return;
                }
                this.mStarted = true;
                diT();
            } catch (RuntimeException e) {
                vi(false);
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public void diT() {
        if (this.lJm != null) {
            this.lJm.diY();
        }
        nativeStart(this.lJj);
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void diU() {
        synchronized (this.lJn) {
            if (!this.lJk) {
                throw new IllegalStateException("No redirect to follow.");
            }
            this.lJk = false;
            if (!diL()) {
                nativeFollowDeferredRedirect(this.lJj);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void h(ByteBuffer byteBuffer) {
        com.baidu.turbonet.net.b.j(byteBuffer);
        com.baidu.turbonet.net.b.i(byteBuffer);
        synchronized (this.lJn) {
            if (!this.lJl) {
                throw new IllegalStateException("Unexpected read attempt.");
            }
            this.lJl = false;
            if (!diL()) {
                if (!nativeReadData(this.lJj, byteBuffer, byteBuffer.position(), byteBuffer.limit())) {
                    this.lJl = true;
                    throw new IllegalArgumentException("Unable to call native read");
                }
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void cancel() {
        synchronized (this.lJn) {
            com.baidu.turbonet.base.a.g("ChromiumNetwork", "****** Request cancel, url is: %s", this.lIC);
            if (!diL() && this.mStarted) {
                vi(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public boolean diL() {
        return this.mStarted && this.lJj == 0;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void diV() {
        diX();
        this.lJJ = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void diW() {
        diX();
        this.lJK = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setTimeout(int i) {
        diX();
        this.lJL = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Fm(int i) {
        diX();
        this.lJM = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Fn(int i) {
        diX();
        this.lJN = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Fo(int i) {
        diX();
        this.lJO = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setTag(Object obj) {
        diX();
        this.mTag = obj;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void MX(String str) {
        diX();
        this.lJP = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void MY(String str) {
        diX();
        this.lJQ = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public Object getTag() {
        return this.mTag;
    }

    @CalledByNative
    public static RequestTimeInfo createObject(long j, long j2, long j3, long j4, long j5) {
        return new RequestTimeInfo(j, j2, j3, j4, j5);
    }

    private void A(Runnable runnable) {
        try {
            this.mExecutor.execute(runnable);
        } catch (RejectedExecutionException e) {
            com.baidu.turbonet.base.a.h("ChromiumNetwork", "Exception posting task to executor", e);
            vi(false);
        }
    }

    private static int Fp(int i) {
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
        return new UrlResponseInfo(new ArrayList(this.lJo), i, str, headersList, z, str2, str3);
    }

    private void diX() {
        synchronized (this.lJn) {
            if (this.mStarted || diL()) {
                throw new IllegalStateException("Request is already started.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vi(boolean z) {
        synchronized (this.lJn) {
            if (this.lJj != 0) {
                String nativeGetDNSNameServers = nativeGetDNSNameServers(this.lJj);
                if (!nativeGetDNSNameServers.isEmpty()) {
                    this.lJs = nativeGetDNSNameServers;
                }
                String nativeGetDNSResults = nativeGetDNSResults(this.lJj);
                if (!nativeGetDNSResults.isEmpty()) {
                    this.lJr = nativeGetDNSResults;
                }
                String nativeGetDNSErrorCode = nativeGetDNSErrorCode(this.lJj);
                if (!nativeGetDNSErrorCode.isEmpty()) {
                    this.lJt = nativeGetDNSErrorCode;
                }
                String nativeGetConnectionAttempts = nativeGetConnectionAttempts(this.lJj, false);
                if (!nativeGetConnectionAttempts.isEmpty()) {
                    this.lJu = nativeGetConnectionAttempts;
                }
                String nativeGetConnectionAttempts2 = nativeGetConnectionAttempts(this.lJj, true);
                if (!nativeGetConnectionAttempts2.isEmpty()) {
                    this.lJv = nativeGetConnectionAttempts2;
                }
                String nativeGetRemoteEndpoint = nativeGetRemoteEndpoint(this.lJj);
                if (!nativeGetRemoteEndpoint.isEmpty()) {
                    this.lJw = nativeGetRemoteEndpoint;
                }
                String nativeGetSuperPipeInfo = nativeGetSuperPipeInfo(this.lJj);
                if (!nativeGetSuperPipeInfo.isEmpty()) {
                    this.lJx = nativeGetSuperPipeInfo;
                }
                long nativeRequestTimeGap = nativeRequestTimeGap(this.lJj, 1);
                if (nativeRequestTimeGap >= 0) {
                    this.lJy = nativeRequestTimeGap;
                }
                long nativeRequestTimeGap2 = nativeRequestTimeGap(this.lJj, 2);
                if (nativeRequestTimeGap2 >= 0) {
                    this.lJz = nativeRequestTimeGap2;
                }
                long nativeRequestTimeGap3 = nativeRequestTimeGap(this.lJj, 3);
                if (nativeRequestTimeGap3 >= 0) {
                    this.lJA = nativeRequestTimeGap3;
                }
                long nativeRequestTimeGap4 = nativeRequestTimeGap(this.lJj, 4);
                if (nativeRequestTimeGap4 >= 0) {
                    this.lJB = nativeRequestTimeGap4;
                }
                long nativeRequestTimeGap5 = nativeRequestTimeGap(this.lJj, 5);
                if (nativeRequestTimeGap5 >= 0) {
                    this.lJC = nativeRequestTimeGap5;
                }
                this.lJD = nativeGetRequestTimeInfo(this.lJj);
                if (this.lJD == null) {
                    this.lJD = new RequestTimeInfo();
                }
                if (this.lJm != null) {
                    this.lJm.diZ();
                }
                nativeDestroy(this.lJj, z);
                if (this.mTag != null) {
                    this.lIA.b(this);
                }
                this.lIA.djb();
                this.lJj = 0L;
                if (this.lIO != null) {
                    this.lIO.run();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Exception exc) {
        UrlRequestException urlRequestException = new UrlRequestException("Exception received from UrlRequest.Callback", exc);
        com.baidu.turbonet.base.a.h("ChromiumNetwork", "Exception in CalledByNative method", exc);
        synchronized (this.lJn) {
            if (!diL()) {
                vi(false);
                try {
                    this.lJq.a(this, this.lIM, urlRequestException);
                } catch (Exception e) {
                    com.baidu.turbonet.base.a.h("ChromiumNetwork", "Exception notifying of failed request", e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(Throwable th) {
        UrlRequestException urlRequestException = new UrlRequestException("Exception received from UploadDataProvider", th);
        com.baidu.turbonet.base.a.h("ChromiumNetwork", "Exception in upload method", th);
        a(urlRequestException);
    }

    private void a(final UrlRequestException urlRequestException) {
        A(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.lJn) {
                    if (!CronetUrlRequest.this.diL()) {
                        CronetUrlRequest.this.vi(false);
                        try {
                            CronetUrlRequest.this.lJq.a(CronetUrlRequest.this, CronetUrlRequest.this.lIM, urlRequestException);
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
        this.lJp += j;
        a2.fz(this.lJp);
        this.lJo.add(str);
        A(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.lJn) {
                    if (!CronetUrlRequest.this.diL()) {
                        CronetUrlRequest.this.lJk = true;
                        try {
                            CronetUrlRequest.this.lJq.a(CronetUrlRequest.this, a2, str);
                        } catch (Exception e) {
                            CronetUrlRequest.this.n(e);
                        }
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onResponseStarted(int i, String str, String[] strArr, boolean z, String str2, String str3) {
        this.lIM = a(i, str, strArr, z, str2, str3);
        A(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.lJn) {
                    if (!CronetUrlRequest.this.diL()) {
                        if (CronetUrlRequest.this.lJm != null) {
                            CronetUrlRequest.this.lJm.dja();
                        }
                        CronetUrlRequest.this.lJl = true;
                        try {
                            CronetUrlRequest.this.lJq.a(CronetUrlRequest.this, CronetUrlRequest.this.lIM);
                        } catch (Exception e) {
                            CronetUrlRequest.this.n(e);
                        }
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onReadCompleted(ByteBuffer byteBuffer, int i, int i2, int i3, long j) {
        this.lIM.fz(this.lJp + j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            a(new UrlRequestException("ByteBuffer modified externally during read", null));
            return;
        }
        if (this.lJS == null) {
            this.lJS = new a();
        }
        byteBuffer.position(i2 + i);
        this.lJS.mByteBuffer = byteBuffer;
        A(this.lJS);
    }

    @CalledByNative
    private void onSucceeded(long j) {
        this.lIM.fz(this.lJp + j);
        A(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.lJn) {
                    if (!CronetUrlRequest.this.diL()) {
                        CronetUrlRequest.this.vi(false);
                        try {
                            CronetUrlRequest.this.lJq.b(CronetUrlRequest.this, CronetUrlRequest.this.lIM);
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
        if (this.lIM != null) {
            this.lIM.fz(this.lJp + j);
        }
        a(new UrlRequestException("Exception in CronetUrlRequest: " + str, i, i2));
    }

    @CalledByNative
    private void onCanceled() {
        A(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.turbonet.base.a.h("ChromiumNetwork", "****** onCanceled, url is: %s", CronetUrlRequest.this.lIM.getUrl());
                    CronetUrlRequest.this.lJq.c(CronetUrlRequest.this, CronetUrlRequest.this.lIM);
                } catch (Exception e) {
                    com.baidu.turbonet.base.a.h("ChromiumNetwork", "Exception in onCanceled method", e);
                }
            }
        });
    }

    @CalledByNative
    private void onStatus(final UrlRequest.StatusListener statusListener, final int i) {
        A(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.7
            @Override // java.lang.Runnable
            public void run() {
                statusListener.FF(UrlRequest.Status.FE(i));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class b {
        @Nullable
        private Long lJZ;
        @Nullable
        private Long lKa;
        @Nullable
        private Long lKb;

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void diY() {
            if (this.lJZ != null) {
                throw new IllegalStateException("onRequestStarted called repeatedly");
            }
            this.lJZ = Long.valueOf(SystemClock.elapsedRealtime());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void diZ() {
            if (this.lJZ != null && this.lKb == null) {
                this.lKb = Long.valueOf(SystemClock.elapsedRealtime() - this.lJZ.longValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dja() {
            if (this.lJZ != null && this.lKa == null) {
                this.lKa = Long.valueOf(SystemClock.elapsedRealtime() - this.lJZ.longValue());
            }
        }
    }
}
