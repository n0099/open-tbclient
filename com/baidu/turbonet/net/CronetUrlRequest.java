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
    private static final TurbonetEngine.UrlRequestMetrics mcz = new TurbonetEngine.UrlRequestMetrics(null, null, null, null);
    private final Executor mExecutor;
    private final int mPriority;
    private Object mTag;
    private final CronetUrlRequestContext mbR;
    private final String mbT;
    private String mbU;
    @GuardedBy("mUrlRequestAdapterLock")
    private long mcA;
    @GuardedBy("mUrlRequestAdapterLock")
    @Nullable
    private final b mcD;
    private long mcG;
    private final UrlRequest.Callback mcH;
    private String mcI;
    private String mcJ;
    private String mcK;
    private String mcL;
    private String mcM;
    private String mcN;
    private String mcO;
    private long mcP;
    private long mcQ;
    private long mcR;
    private long mcS;
    private long mcT;
    private RequestTimeInfo mcU;
    private final Collection<Object> mcW;
    private final boolean mcX;
    private final boolean mcY;
    private final boolean mcZ;
    private UrlResponseInfo mcd;
    private Runnable mcf;
    private boolean mda;
    private boolean mdb;
    private int mdc;
    private int mdd;
    private int mde;
    private int mdf;
    private String mdg;
    private String mdh;
    private CronetUploadDataStream mdi;
    private a mdj;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mStarted = false;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mcB = false;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mcC = false;
    private final Object mcE = new Object();
    private final List<String> mcF = new ArrayList();
    private final HeadersList mcV = new HeadersList();

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
                synchronized (CronetUrlRequest.this.mcE) {
                    if (!CronetUrlRequest.this.dqc()) {
                        CronetUrlRequest.this.mcC = true;
                        CronetUrlRequest.this.mcH.a(CronetUrlRequest.this, CronetUrlRequest.this.mcd, byteBuffer);
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
        this.mbR = cronetUrlRequestContext;
        this.mbT = str;
        this.mcF.add(str);
        this.mPriority = Gc(i);
        this.mcH = callback;
        this.mExecutor = executor;
        this.mcW = collection;
        this.mcD = z ? new b() : null;
        this.mcX = z2;
        this.mcY = z3;
        this.mcZ = z4;
        this.mda = false;
        this.mdb = false;
        this.mdc = 0;
        this.mdd = 0;
        this.mde = 0;
        this.mdf = 0;
        this.mTag = null;
        this.mdg = null;
        this.mdh = null;
        this.mcd = new UrlResponseInfo(new ArrayList(this.mcF), 0, "", new HeadersList(), false, "", "");
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void OJ(String str) {
        dqo();
        if (str == null) {
            throw new NullPointerException("Method is required.");
        }
        this.mbU = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void addHeader(String str, String str2) {
        dqo();
        if (str == null) {
            throw new NullPointerException("Invalid header name.");
        }
        if (str2 == null) {
            throw new NullPointerException("Invalid header value.");
        }
        this.mcV.add(new AbstractMap.SimpleImmutableEntry(str, str2));
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void a(UploadDataProvider uploadDataProvider, Executor executor) {
        if (uploadDataProvider == null) {
            throw new NullPointerException("Invalid UploadDataProvider.");
        }
        if (this.mbU == null) {
            this.mbU = "POST";
        }
        this.mdi = new CronetUploadDataStream(uploadDataProvider, executor, this);
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void start() {
        synchronized (this.mcE) {
            com.baidu.turbonet.base.a.g("ChromiumNetwork", "****** Request start, url is: %s", this.mbT);
            dqo();
            try {
                this.mcA = nativeCreateRequestAdapter(this.mbR.dqt(), this.mbT, this.mPriority, this.mcX, this.mcY, this.mcZ);
                this.mbR.dqp();
                if (this.mbU != null && !nativeSetHttpMethod(this.mcA, this.mbU)) {
                    throw new IllegalArgumentException("Invalid http method " + this.mbU);
                }
                if (this.mTag != null) {
                    this.mbR.a(this);
                }
                if (this.mda) {
                    nativeDisableResponseAutoUngzip(this.mcA);
                }
                if (this.mdb) {
                    nativeEnableBrotliByRequest(this.mcA);
                }
                if (this.mdc > 0) {
                    nativeSetTimeout(this.mcA, this.mdc);
                }
                if (this.mdd > 0) {
                    nativeSetTCPConnectTimeout(this.mcA, this.mdd);
                }
                if (this.mde > 0) {
                    nativeSetResponseHeaderRecvTimeout(this.mcA, this.mde);
                }
                if (this.mdf > 0) {
                    nativeSetResponseBodyReadTimeout(this.mcA, this.mdf);
                }
                if (!TextUtils.isEmpty(this.mdg)) {
                    nativeSetDestinationAddress(this.mcA, this.mdg);
                }
                if (!TextUtils.isEmpty(this.mdh)) {
                    nativeSetRequestTag(this.mcA, this.mdh);
                }
                Iterator<Map.Entry<String, String>> it = this.mcV.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    boolean z2 = (!next.getKey().equalsIgnoreCase("Content-Type") || next.getValue().isEmpty()) ? z : true;
                    if (!nativeAddRequestHeader(this.mcA, next.getKey(), next.getValue())) {
                        throw new IllegalArgumentException("Invalid header " + next.getKey() + ETAG.EQUAL + next.getValue());
                    }
                    z = z2;
                }
                if (this.mdi != null) {
                    if (!z) {
                        throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
                    }
                    this.mStarted = true;
                    this.mdi.C(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CronetUrlRequest.this.mdi.dqj();
                            synchronized (CronetUrlRequest.this.mcE) {
                                if (!CronetUrlRequest.this.dqc()) {
                                    CronetUrlRequest.this.mdi.fx(CronetUrlRequest.this.mcA);
                                    CronetUrlRequest.this.dqk();
                                }
                            }
                        }
                    });
                    return;
                }
                this.mStarted = true;
                dqk();
            } catch (RuntimeException e) {
                vG(false);
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public void dqk() {
        if (this.mcD != null) {
            this.mcD.dqp();
        }
        nativeStart(this.mcA);
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void dql() {
        synchronized (this.mcE) {
            if (!this.mcB) {
                throw new IllegalStateException("No redirect to follow.");
            }
            this.mcB = false;
            if (!dqc()) {
                nativeFollowDeferredRedirect(this.mcA);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void m(ByteBuffer byteBuffer) {
        com.baidu.turbonet.net.b.o(byteBuffer);
        com.baidu.turbonet.net.b.n(byteBuffer);
        synchronized (this.mcE) {
            if (!this.mcC) {
                throw new IllegalStateException("Unexpected read attempt.");
            }
            this.mcC = false;
            if (!dqc()) {
                if (!nativeReadData(this.mcA, byteBuffer, byteBuffer.position(), byteBuffer.limit())) {
                    this.mcC = true;
                    throw new IllegalArgumentException("Unable to call native read");
                }
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void cancel() {
        synchronized (this.mcE) {
            com.baidu.turbonet.base.a.g("ChromiumNetwork", "****** Request cancel, url is: %s", this.mbT);
            if (!dqc() && this.mStarted) {
                vG(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public boolean dqc() {
        return this.mStarted && this.mcA == 0;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void dqm() {
        dqo();
        this.mda = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void dqn() {
        dqo();
        this.mdb = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setTimeout(int i) {
        dqo();
        this.mdc = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void FZ(int i) {
        dqo();
        this.mdd = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Ga(int i) {
        dqo();
        this.mde = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Gb(int i) {
        dqo();
        this.mdf = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setTag(Object obj) {
        dqo();
        this.mTag = obj;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void OK(String str) {
        dqo();
        this.mdg = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void OL(String str) {
        dqo();
        this.mdh = str;
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
            vG(false);
        }
    }

    private static int Gc(int i) {
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
        return new UrlResponseInfo(new ArrayList(this.mcF), i, str, headersList, z, str2, str3);
    }

    private void dqo() {
        synchronized (this.mcE) {
            if (this.mStarted || dqc()) {
                throw new IllegalStateException("Request is already started.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vG(boolean z) {
        synchronized (this.mcE) {
            if (this.mcA != 0) {
                String nativeGetDNSNameServers = nativeGetDNSNameServers(this.mcA);
                if (!nativeGetDNSNameServers.isEmpty()) {
                    this.mcJ = nativeGetDNSNameServers;
                }
                String nativeGetDNSResults = nativeGetDNSResults(this.mcA);
                if (!nativeGetDNSResults.isEmpty()) {
                    this.mcI = nativeGetDNSResults;
                }
                String nativeGetDNSErrorCode = nativeGetDNSErrorCode(this.mcA);
                if (!nativeGetDNSErrorCode.isEmpty()) {
                    this.mcK = nativeGetDNSErrorCode;
                }
                String nativeGetConnectionAttempts = nativeGetConnectionAttempts(this.mcA, false);
                if (!nativeGetConnectionAttempts.isEmpty()) {
                    this.mcL = nativeGetConnectionAttempts;
                }
                String nativeGetConnectionAttempts2 = nativeGetConnectionAttempts(this.mcA, true);
                if (!nativeGetConnectionAttempts2.isEmpty()) {
                    this.mcM = nativeGetConnectionAttempts2;
                }
                String nativeGetRemoteEndpoint = nativeGetRemoteEndpoint(this.mcA);
                if (!nativeGetRemoteEndpoint.isEmpty()) {
                    this.mcN = nativeGetRemoteEndpoint;
                }
                String nativeGetSuperPipeInfo = nativeGetSuperPipeInfo(this.mcA);
                if (!nativeGetSuperPipeInfo.isEmpty()) {
                    this.mcO = nativeGetSuperPipeInfo;
                }
                long nativeRequestTimeGap = nativeRequestTimeGap(this.mcA, 1);
                if (nativeRequestTimeGap >= 0) {
                    this.mcP = nativeRequestTimeGap;
                }
                long nativeRequestTimeGap2 = nativeRequestTimeGap(this.mcA, 2);
                if (nativeRequestTimeGap2 >= 0) {
                    this.mcQ = nativeRequestTimeGap2;
                }
                long nativeRequestTimeGap3 = nativeRequestTimeGap(this.mcA, 3);
                if (nativeRequestTimeGap3 >= 0) {
                    this.mcR = nativeRequestTimeGap3;
                }
                long nativeRequestTimeGap4 = nativeRequestTimeGap(this.mcA, 4);
                if (nativeRequestTimeGap4 >= 0) {
                    this.mcS = nativeRequestTimeGap4;
                }
                long nativeRequestTimeGap5 = nativeRequestTimeGap(this.mcA, 5);
                if (nativeRequestTimeGap5 >= 0) {
                    this.mcT = nativeRequestTimeGap5;
                }
                this.mcU = nativeGetRequestTimeInfo(this.mcA);
                if (this.mcU == null) {
                    this.mcU = new RequestTimeInfo();
                }
                if (this.mcD != null) {
                    this.mcD.dqq();
                }
                nativeDestroy(this.mcA, z);
                if (this.mTag != null) {
                    this.mbR.b(this);
                }
                this.mbR.dqs();
                this.mcA = 0L;
                if (this.mcf != null) {
                    this.mcf.run();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Exception exc) {
        UrlRequestException urlRequestException = new UrlRequestException("Exception received from UrlRequest.Callback", exc);
        com.baidu.turbonet.base.a.h("ChromiumNetwork", "Exception in CalledByNative method", exc);
        synchronized (this.mcE) {
            if (!dqc()) {
                vG(false);
                try {
                    this.mcH.a(this, this.mcd, urlRequestException);
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
                synchronized (CronetUrlRequest.this.mcE) {
                    if (!CronetUrlRequest.this.dqc()) {
                        CronetUrlRequest.this.vG(false);
                        try {
                            CronetUrlRequest.this.mcH.a(CronetUrlRequest.this, CronetUrlRequest.this.mcd, urlRequestException);
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
        this.mcG += j;
        a2.fz(this.mcG);
        this.mcF.add(str);
        C(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.mcE) {
                    if (!CronetUrlRequest.this.dqc()) {
                        CronetUrlRequest.this.mcB = true;
                        try {
                            CronetUrlRequest.this.mcH.a(CronetUrlRequest.this, a2, str);
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
        this.mcd = a(i, str, strArr, z, str2, str3);
        C(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.mcE) {
                    if (!CronetUrlRequest.this.dqc()) {
                        if (CronetUrlRequest.this.mcD != null) {
                            CronetUrlRequest.this.mcD.dqr();
                        }
                        CronetUrlRequest.this.mcC = true;
                        try {
                            CronetUrlRequest.this.mcH.a(CronetUrlRequest.this, CronetUrlRequest.this.mcd);
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
        this.mcd.fz(this.mcG + j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            a(new UrlRequestException("ByteBuffer modified externally during read", null));
            return;
        }
        if (this.mdj == null) {
            this.mdj = new a();
        }
        byteBuffer.position(i2 + i);
        this.mdj.mByteBuffer = byteBuffer;
        C(this.mdj);
    }

    @CalledByNative
    private void onSucceeded(long j) {
        this.mcd.fz(this.mcG + j);
        C(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.mcE) {
                    if (!CronetUrlRequest.this.dqc()) {
                        CronetUrlRequest.this.vG(false);
                        try {
                            CronetUrlRequest.this.mcH.b(CronetUrlRequest.this, CronetUrlRequest.this.mcd);
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
        if (this.mcd != null) {
            this.mcd.fz(this.mcG + j);
        }
        a(new UrlRequestException("Exception in CronetUrlRequest: " + str, i, i2));
    }

    @CalledByNative
    private void onCanceled() {
        C(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.turbonet.base.a.h("ChromiumNetwork", "****** onCanceled, url is: %s", CronetUrlRequest.this.mcd.getUrl());
                    CronetUrlRequest.this.mcH.c(CronetUrlRequest.this, CronetUrlRequest.this.mcd);
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
                statusListener.Gs(UrlRequest.Status.Gr(i));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class b {
        @Nullable
        private Long mdq;
        @Nullable
        private Long mdr;
        @Nullable
        private Long mds;

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dqp() {
            if (this.mdq != null) {
                throw new IllegalStateException("onRequestStarted called repeatedly");
            }
            this.mdq = Long.valueOf(SystemClock.elapsedRealtime());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dqq() {
            if (this.mdq != null && this.mds == null) {
                this.mds = Long.valueOf(SystemClock.elapsedRealtime() - this.mdq.longValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dqr() {
            if (this.mdq != null && this.mdr == null) {
                this.mdr = Long.valueOf(SystemClock.elapsedRealtime() - this.mdq.longValue());
            }
        }
    }
}
