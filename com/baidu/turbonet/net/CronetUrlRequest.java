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
    private static final TurbonetEngine.UrlRequestMetrics lJe = new TurbonetEngine.UrlRequestMetrics(null, null, null, null);
    private UrlResponseInfo lII;
    private Runnable lIK;
    private final CronetUrlRequestContext lIw;
    private final String lIy;
    private String lIz;
    private final Collection<Object> lJB;
    private final boolean lJC;
    private final boolean lJD;
    private final boolean lJE;
    private boolean lJF;
    private boolean lJG;
    private int lJH;
    private int lJI;
    private int lJJ;
    private int lJK;
    private String lJL;
    private String lJM;
    private CronetUploadDataStream lJN;
    private a lJO;
    @GuardedBy("mUrlRequestAdapterLock")
    private long lJf;
    @GuardedBy("mUrlRequestAdapterLock")
    @Nullable
    private final b lJi;
    private long lJl;
    private final UrlRequest.Callback lJm;
    private String lJn;
    private String lJo;
    private String lJp;
    private String lJq;
    private String lJr;
    private String lJs;
    private String lJt;
    private long lJu;
    private long lJv;
    private long lJw;
    private long lJx;
    private long lJy;
    private RequestTimeInfo lJz;
    private final Executor mExecutor;
    private final int mPriority;
    private Object mTag;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mStarted = false;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean lJg = false;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean lJh = false;
    private final Object lJj = new Object();
    private final List<String> lJk = new ArrayList();
    private final HeadersList lJA = new HeadersList();

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
                synchronized (CronetUrlRequest.this.lJj) {
                    if (!CronetUrlRequest.this.diO()) {
                        CronetUrlRequest.this.lJh = true;
                        CronetUrlRequest.this.lJm.a(CronetUrlRequest.this, CronetUrlRequest.this.lII, byteBuffer);
                    }
                }
            } catch (Exception e) {
                CronetUrlRequest.this.m(e);
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
        this.lIw = cronetUrlRequestContext;
        this.lIy = str;
        this.lJk.add(str);
        this.mPriority = Fp(i);
        this.lJm = callback;
        this.mExecutor = executor;
        this.lJB = collection;
        this.lJi = z ? new b() : null;
        this.lJC = z2;
        this.lJD = z3;
        this.lJE = z4;
        this.lJF = false;
        this.lJG = false;
        this.lJH = 0;
        this.lJI = 0;
        this.lJJ = 0;
        this.lJK = 0;
        this.mTag = null;
        this.lJL = null;
        this.lJM = null;
        this.lII = new UrlResponseInfo(new ArrayList(this.lJk), 0, "", new HeadersList(), false, "", "");
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void MT(String str) {
        dja();
        if (str == null) {
            throw new NullPointerException("Method is required.");
        }
        this.lIz = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void addHeader(String str, String str2) {
        dja();
        if (str == null) {
            throw new NullPointerException("Invalid header name.");
        }
        if (str2 == null) {
            throw new NullPointerException("Invalid header value.");
        }
        this.lJA.add(new AbstractMap.SimpleImmutableEntry(str, str2));
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void a(UploadDataProvider uploadDataProvider, Executor executor) {
        if (uploadDataProvider == null) {
            throw new NullPointerException("Invalid UploadDataProvider.");
        }
        if (this.lIz == null) {
            this.lIz = "POST";
        }
        this.lJN = new CronetUploadDataStream(uploadDataProvider, executor, this);
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void start() {
        synchronized (this.lJj) {
            com.baidu.turbonet.base.a.g("ChromiumNetwork", "****** Request start, url is: %s", this.lIy);
            dja();
            try {
                this.lJf = nativeCreateRequestAdapter(this.lIw.djf(), this.lIy, this.mPriority, this.lJC, this.lJD, this.lJE);
                this.lIw.djb();
                if (this.lIz != null && !nativeSetHttpMethod(this.lJf, this.lIz)) {
                    throw new IllegalArgumentException("Invalid http method " + this.lIz);
                }
                if (this.mTag != null) {
                    this.lIw.a(this);
                }
                if (this.lJF) {
                    nativeDisableResponseAutoUngzip(this.lJf);
                }
                if (this.lJG) {
                    nativeEnableBrotliByRequest(this.lJf);
                }
                if (this.lJH > 0) {
                    nativeSetTimeout(this.lJf, this.lJH);
                }
                if (this.lJI > 0) {
                    nativeSetTCPConnectTimeout(this.lJf, this.lJI);
                }
                if (this.lJJ > 0) {
                    nativeSetResponseHeaderRecvTimeout(this.lJf, this.lJJ);
                }
                if (this.lJK > 0) {
                    nativeSetResponseBodyReadTimeout(this.lJf, this.lJK);
                }
                if (!TextUtils.isEmpty(this.lJL)) {
                    nativeSetDestinationAddress(this.lJf, this.lJL);
                }
                if (!TextUtils.isEmpty(this.lJM)) {
                    nativeSetRequestTag(this.lJf, this.lJM);
                }
                Iterator<Map.Entry<String, String>> it = this.lJA.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    boolean z2 = (!next.getKey().equalsIgnoreCase("Content-Type") || next.getValue().isEmpty()) ? z : true;
                    if (!nativeAddRequestHeader(this.lJf, next.getKey(), next.getValue())) {
                        throw new IllegalArgumentException("Invalid header " + next.getKey() + ETAG.EQUAL + next.getValue());
                    }
                    z = z2;
                }
                if (this.lJN != null) {
                    if (!z) {
                        throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
                    }
                    this.mStarted = true;
                    this.lJN.A(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CronetUrlRequest.this.lJN.diV();
                            synchronized (CronetUrlRequest.this.lJj) {
                                if (!CronetUrlRequest.this.diO()) {
                                    CronetUrlRequest.this.lJN.fx(CronetUrlRequest.this.lJf);
                                    CronetUrlRequest.this.diW();
                                }
                            }
                        }
                    });
                    return;
                }
                this.mStarted = true;
                diW();
            } catch (RuntimeException e) {
                vi(false);
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public void diW() {
        if (this.lJi != null) {
            this.lJi.djb();
        }
        nativeStart(this.lJf);
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void diX() {
        synchronized (this.lJj) {
            if (!this.lJg) {
                throw new IllegalStateException("No redirect to follow.");
            }
            this.lJg = false;
            if (!diO()) {
                nativeFollowDeferredRedirect(this.lJf);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void h(ByteBuffer byteBuffer) {
        com.baidu.turbonet.net.b.j(byteBuffer);
        com.baidu.turbonet.net.b.i(byteBuffer);
        synchronized (this.lJj) {
            if (!this.lJh) {
                throw new IllegalStateException("Unexpected read attempt.");
            }
            this.lJh = false;
            if (!diO()) {
                if (!nativeReadData(this.lJf, byteBuffer, byteBuffer.position(), byteBuffer.limit())) {
                    this.lJh = true;
                    throw new IllegalArgumentException("Unable to call native read");
                }
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void cancel() {
        synchronized (this.lJj) {
            com.baidu.turbonet.base.a.g("ChromiumNetwork", "****** Request cancel, url is: %s", this.lIy);
            if (!diO() && this.mStarted) {
                vi(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public boolean diO() {
        return this.mStarted && this.lJf == 0;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void diY() {
        dja();
        this.lJF = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void diZ() {
        dja();
        this.lJG = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setTimeout(int i) {
        dja();
        this.lJH = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Fm(int i) {
        dja();
        this.lJI = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Fn(int i) {
        dja();
        this.lJJ = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Fo(int i) {
        dja();
        this.lJK = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setTag(Object obj) {
        dja();
        this.mTag = obj;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void MU(String str) {
        dja();
        this.lJL = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void MV(String str) {
        dja();
        this.lJM = str;
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
        return new UrlResponseInfo(new ArrayList(this.lJk), i, str, headersList, z, str2, str3);
    }

    private void dja() {
        synchronized (this.lJj) {
            if (this.mStarted || diO()) {
                throw new IllegalStateException("Request is already started.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vi(boolean z) {
        synchronized (this.lJj) {
            if (this.lJf != 0) {
                String nativeGetDNSNameServers = nativeGetDNSNameServers(this.lJf);
                if (!nativeGetDNSNameServers.isEmpty()) {
                    this.lJo = nativeGetDNSNameServers;
                }
                String nativeGetDNSResults = nativeGetDNSResults(this.lJf);
                if (!nativeGetDNSResults.isEmpty()) {
                    this.lJn = nativeGetDNSResults;
                }
                String nativeGetDNSErrorCode = nativeGetDNSErrorCode(this.lJf);
                if (!nativeGetDNSErrorCode.isEmpty()) {
                    this.lJp = nativeGetDNSErrorCode;
                }
                String nativeGetConnectionAttempts = nativeGetConnectionAttempts(this.lJf, false);
                if (!nativeGetConnectionAttempts.isEmpty()) {
                    this.lJq = nativeGetConnectionAttempts;
                }
                String nativeGetConnectionAttempts2 = nativeGetConnectionAttempts(this.lJf, true);
                if (!nativeGetConnectionAttempts2.isEmpty()) {
                    this.lJr = nativeGetConnectionAttempts2;
                }
                String nativeGetRemoteEndpoint = nativeGetRemoteEndpoint(this.lJf);
                if (!nativeGetRemoteEndpoint.isEmpty()) {
                    this.lJs = nativeGetRemoteEndpoint;
                }
                String nativeGetSuperPipeInfo = nativeGetSuperPipeInfo(this.lJf);
                if (!nativeGetSuperPipeInfo.isEmpty()) {
                    this.lJt = nativeGetSuperPipeInfo;
                }
                long nativeRequestTimeGap = nativeRequestTimeGap(this.lJf, 1);
                if (nativeRequestTimeGap >= 0) {
                    this.lJu = nativeRequestTimeGap;
                }
                long nativeRequestTimeGap2 = nativeRequestTimeGap(this.lJf, 2);
                if (nativeRequestTimeGap2 >= 0) {
                    this.lJv = nativeRequestTimeGap2;
                }
                long nativeRequestTimeGap3 = nativeRequestTimeGap(this.lJf, 3);
                if (nativeRequestTimeGap3 >= 0) {
                    this.lJw = nativeRequestTimeGap3;
                }
                long nativeRequestTimeGap4 = nativeRequestTimeGap(this.lJf, 4);
                if (nativeRequestTimeGap4 >= 0) {
                    this.lJx = nativeRequestTimeGap4;
                }
                long nativeRequestTimeGap5 = nativeRequestTimeGap(this.lJf, 5);
                if (nativeRequestTimeGap5 >= 0) {
                    this.lJy = nativeRequestTimeGap5;
                }
                this.lJz = nativeGetRequestTimeInfo(this.lJf);
                if (this.lJz == null) {
                    this.lJz = new RequestTimeInfo();
                }
                if (this.lJi != null) {
                    this.lJi.djc();
                }
                nativeDestroy(this.lJf, z);
                if (this.mTag != null) {
                    this.lIw.b(this);
                }
                this.lIw.dje();
                this.lJf = 0L;
                if (this.lIK != null) {
                    this.lIK.run();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Exception exc) {
        UrlRequestException urlRequestException = new UrlRequestException("Exception received from UrlRequest.Callback", exc);
        com.baidu.turbonet.base.a.h("ChromiumNetwork", "Exception in CalledByNative method", exc);
        synchronized (this.lJj) {
            if (!diO()) {
                vi(false);
                try {
                    this.lJm.a(this, this.lII, urlRequestException);
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
                synchronized (CronetUrlRequest.this.lJj) {
                    if (!CronetUrlRequest.this.diO()) {
                        CronetUrlRequest.this.vi(false);
                        try {
                            CronetUrlRequest.this.lJm.a(CronetUrlRequest.this, CronetUrlRequest.this.lII, urlRequestException);
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
        this.lJl += j;
        a2.fz(this.lJl);
        this.lJk.add(str);
        A(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.lJj) {
                    if (!CronetUrlRequest.this.diO()) {
                        CronetUrlRequest.this.lJg = true;
                        try {
                            CronetUrlRequest.this.lJm.a(CronetUrlRequest.this, a2, str);
                        } catch (Exception e) {
                            CronetUrlRequest.this.m(e);
                        }
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onResponseStarted(int i, String str, String[] strArr, boolean z, String str2, String str3) {
        this.lII = a(i, str, strArr, z, str2, str3);
        A(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.lJj) {
                    if (!CronetUrlRequest.this.diO()) {
                        if (CronetUrlRequest.this.lJi != null) {
                            CronetUrlRequest.this.lJi.djd();
                        }
                        CronetUrlRequest.this.lJh = true;
                        try {
                            CronetUrlRequest.this.lJm.a(CronetUrlRequest.this, CronetUrlRequest.this.lII);
                        } catch (Exception e) {
                            CronetUrlRequest.this.m(e);
                        }
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onReadCompleted(ByteBuffer byteBuffer, int i, int i2, int i3, long j) {
        this.lII.fz(this.lJl + j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            a(new UrlRequestException("ByteBuffer modified externally during read", null));
            return;
        }
        if (this.lJO == null) {
            this.lJO = new a();
        }
        byteBuffer.position(i2 + i);
        this.lJO.mByteBuffer = byteBuffer;
        A(this.lJO);
    }

    @CalledByNative
    private void onSucceeded(long j) {
        this.lII.fz(this.lJl + j);
        A(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.lJj) {
                    if (!CronetUrlRequest.this.diO()) {
                        CronetUrlRequest.this.vi(false);
                        try {
                            CronetUrlRequest.this.lJm.b(CronetUrlRequest.this, CronetUrlRequest.this.lII);
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
        if (this.lII != null) {
            this.lII.fz(this.lJl + j);
        }
        a(new UrlRequestException("Exception in CronetUrlRequest: " + str, i, i2));
    }

    @CalledByNative
    private void onCanceled() {
        A(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.turbonet.base.a.h("ChromiumNetwork", "****** onCanceled, url is: %s", CronetUrlRequest.this.lII.getUrl());
                    CronetUrlRequest.this.lJm.c(CronetUrlRequest.this, CronetUrlRequest.this.lII);
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
        private Long lJV;
        @Nullable
        private Long lJW;
        @Nullable
        private Long lJX;

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void djb() {
            if (this.lJV != null) {
                throw new IllegalStateException("onRequestStarted called repeatedly");
            }
            this.lJV = Long.valueOf(SystemClock.elapsedRealtime());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void djc() {
            if (this.lJV != null && this.lJX == null) {
                this.lJX = Long.valueOf(SystemClock.elapsedRealtime() - this.lJV.longValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void djd() {
            if (this.lJV != null && this.lJW == null) {
                this.lJW = Long.valueOf(SystemClock.elapsedRealtime() - this.lJV.longValue());
            }
        }
    }
}
