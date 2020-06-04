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
    private static final TurbonetEngine.UrlRequestMetrics mdJ = new TurbonetEngine.UrlRequestMetrics(null, null, null, null);
    private final Executor mExecutor;
    private final int mPriority;
    private Object mTag;
    @GuardedBy("mUrlRequestAdapterLock")
    private long mdK;
    @GuardedBy("mUrlRequestAdapterLock")
    @Nullable
    private final b mdN;
    private long mdQ;
    private final UrlRequest.Callback mdR;
    private String mdS;
    private String mdT;
    private String mdU;
    private String mdV;
    private String mdW;
    private String mdX;
    private String mdY;
    private long mdZ;
    private final CronetUrlRequestContext mdb;
    private final String mdd;
    private String mde;
    private UrlResponseInfo mdn;
    private Runnable mdp;
    private long mea;
    private long meb;
    private long mec;
    private long med;
    private RequestTimeInfo mee;
    private final Collection<Object> meg;
    private final boolean meh;
    private final boolean mei;
    private final boolean mej;
    private boolean mek;
    private boolean mel;
    private int mem;
    private int men;
    private int meo;
    private int mep;
    private String meq;
    private String mer;
    private CronetUploadDataStream mes;
    private a met;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mStarted = false;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mdL = false;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mdM = false;
    private final Object mdO = new Object();
    private final List<String> mdP = new ArrayList();
    private final HeadersList mef = new HeadersList();

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
                synchronized (CronetUrlRequest.this.mdO) {
                    if (!CronetUrlRequest.this.dqq()) {
                        CronetUrlRequest.this.mdM = true;
                        CronetUrlRequest.this.mdR.a(CronetUrlRequest.this, CronetUrlRequest.this.mdn, byteBuffer);
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
        this.mdb = cronetUrlRequestContext;
        this.mdd = str;
        this.mdP.add(str);
        this.mPriority = Ge(i);
        this.mdR = callback;
        this.mExecutor = executor;
        this.meg = collection;
        this.mdN = z ? new b() : null;
        this.meh = z2;
        this.mei = z3;
        this.mej = z4;
        this.mek = false;
        this.mel = false;
        this.mem = 0;
        this.men = 0;
        this.meo = 0;
        this.mep = 0;
        this.mTag = null;
        this.meq = null;
        this.mer = null;
        this.mdn = new UrlResponseInfo(new ArrayList(this.mdP), 0, "", new HeadersList(), false, "", "");
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void OK(String str) {
        dqC();
        if (str == null) {
            throw new NullPointerException("Method is required.");
        }
        this.mde = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void addHeader(String str, String str2) {
        dqC();
        if (str == null) {
            throw new NullPointerException("Invalid header name.");
        }
        if (str2 == null) {
            throw new NullPointerException("Invalid header value.");
        }
        this.mef.add(new AbstractMap.SimpleImmutableEntry(str, str2));
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void a(UploadDataProvider uploadDataProvider, Executor executor) {
        if (uploadDataProvider == null) {
            throw new NullPointerException("Invalid UploadDataProvider.");
        }
        if (this.mde == null) {
            this.mde = "POST";
        }
        this.mes = new CronetUploadDataStream(uploadDataProvider, executor, this);
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void start() {
        synchronized (this.mdO) {
            com.baidu.turbonet.base.a.g("ChromiumNetwork", "****** Request start, url is: %s", this.mdd);
            dqC();
            try {
                this.mdK = nativeCreateRequestAdapter(this.mdb.dqH(), this.mdd, this.mPriority, this.meh, this.mei, this.mej);
                this.mdb.dqD();
                if (this.mde != null && !nativeSetHttpMethod(this.mdK, this.mde)) {
                    throw new IllegalArgumentException("Invalid http method " + this.mde);
                }
                if (this.mTag != null) {
                    this.mdb.a(this);
                }
                if (this.mek) {
                    nativeDisableResponseAutoUngzip(this.mdK);
                }
                if (this.mel) {
                    nativeEnableBrotliByRequest(this.mdK);
                }
                if (this.mem > 0) {
                    nativeSetTimeout(this.mdK, this.mem);
                }
                if (this.men > 0) {
                    nativeSetTCPConnectTimeout(this.mdK, this.men);
                }
                if (this.meo > 0) {
                    nativeSetResponseHeaderRecvTimeout(this.mdK, this.meo);
                }
                if (this.mep > 0) {
                    nativeSetResponseBodyReadTimeout(this.mdK, this.mep);
                }
                if (!TextUtils.isEmpty(this.meq)) {
                    nativeSetDestinationAddress(this.mdK, this.meq);
                }
                if (!TextUtils.isEmpty(this.mer)) {
                    nativeSetRequestTag(this.mdK, this.mer);
                }
                Iterator<Map.Entry<String, String>> it = this.mef.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    boolean z2 = (!next.getKey().equalsIgnoreCase("Content-Type") || next.getValue().isEmpty()) ? z : true;
                    if (!nativeAddRequestHeader(this.mdK, next.getKey(), next.getValue())) {
                        throw new IllegalArgumentException("Invalid header " + next.getKey() + ETAG.EQUAL + next.getValue());
                    }
                    z = z2;
                }
                if (this.mes != null) {
                    if (!z) {
                        throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
                    }
                    this.mStarted = true;
                    this.mes.C(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CronetUrlRequest.this.mes.dqx();
                            synchronized (CronetUrlRequest.this.mdO) {
                                if (!CronetUrlRequest.this.dqq()) {
                                    CronetUrlRequest.this.mes.fx(CronetUrlRequest.this.mdK);
                                    CronetUrlRequest.this.dqy();
                                }
                            }
                        }
                    });
                    return;
                }
                this.mStarted = true;
                dqy();
            } catch (RuntimeException e) {
                vI(false);
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public void dqy() {
        if (this.mdN != null) {
            this.mdN.dqD();
        }
        nativeStart(this.mdK);
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void dqz() {
        synchronized (this.mdO) {
            if (!this.mdL) {
                throw new IllegalStateException("No redirect to follow.");
            }
            this.mdL = false;
            if (!dqq()) {
                nativeFollowDeferredRedirect(this.mdK);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void m(ByteBuffer byteBuffer) {
        com.baidu.turbonet.net.b.o(byteBuffer);
        com.baidu.turbonet.net.b.n(byteBuffer);
        synchronized (this.mdO) {
            if (!this.mdM) {
                throw new IllegalStateException("Unexpected read attempt.");
            }
            this.mdM = false;
            if (!dqq()) {
                if (!nativeReadData(this.mdK, byteBuffer, byteBuffer.position(), byteBuffer.limit())) {
                    this.mdM = true;
                    throw new IllegalArgumentException("Unable to call native read");
                }
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void cancel() {
        synchronized (this.mdO) {
            com.baidu.turbonet.base.a.g("ChromiumNetwork", "****** Request cancel, url is: %s", this.mdd);
            if (!dqq() && this.mStarted) {
                vI(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public boolean dqq() {
        return this.mStarted && this.mdK == 0;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void dqA() {
        dqC();
        this.mek = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void dqB() {
        dqC();
        this.mel = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setTimeout(int i) {
        dqC();
        this.mem = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Gb(int i) {
        dqC();
        this.men = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Gc(int i) {
        dqC();
        this.meo = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Gd(int i) {
        dqC();
        this.mep = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setTag(Object obj) {
        dqC();
        this.mTag = obj;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void OL(String str) {
        dqC();
        this.meq = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void OM(String str) {
        dqC();
        this.mer = str;
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
            vI(false);
        }
    }

    private static int Ge(int i) {
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
        return new UrlResponseInfo(new ArrayList(this.mdP), i, str, headersList, z, str2, str3);
    }

    private void dqC() {
        synchronized (this.mdO) {
            if (this.mStarted || dqq()) {
                throw new IllegalStateException("Request is already started.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vI(boolean z) {
        synchronized (this.mdO) {
            if (this.mdK != 0) {
                String nativeGetDNSNameServers = nativeGetDNSNameServers(this.mdK);
                if (!nativeGetDNSNameServers.isEmpty()) {
                    this.mdT = nativeGetDNSNameServers;
                }
                String nativeGetDNSResults = nativeGetDNSResults(this.mdK);
                if (!nativeGetDNSResults.isEmpty()) {
                    this.mdS = nativeGetDNSResults;
                }
                String nativeGetDNSErrorCode = nativeGetDNSErrorCode(this.mdK);
                if (!nativeGetDNSErrorCode.isEmpty()) {
                    this.mdU = nativeGetDNSErrorCode;
                }
                String nativeGetConnectionAttempts = nativeGetConnectionAttempts(this.mdK, false);
                if (!nativeGetConnectionAttempts.isEmpty()) {
                    this.mdV = nativeGetConnectionAttempts;
                }
                String nativeGetConnectionAttempts2 = nativeGetConnectionAttempts(this.mdK, true);
                if (!nativeGetConnectionAttempts2.isEmpty()) {
                    this.mdW = nativeGetConnectionAttempts2;
                }
                String nativeGetRemoteEndpoint = nativeGetRemoteEndpoint(this.mdK);
                if (!nativeGetRemoteEndpoint.isEmpty()) {
                    this.mdX = nativeGetRemoteEndpoint;
                }
                String nativeGetSuperPipeInfo = nativeGetSuperPipeInfo(this.mdK);
                if (!nativeGetSuperPipeInfo.isEmpty()) {
                    this.mdY = nativeGetSuperPipeInfo;
                }
                long nativeRequestTimeGap = nativeRequestTimeGap(this.mdK, 1);
                if (nativeRequestTimeGap >= 0) {
                    this.mdZ = nativeRequestTimeGap;
                }
                long nativeRequestTimeGap2 = nativeRequestTimeGap(this.mdK, 2);
                if (nativeRequestTimeGap2 >= 0) {
                    this.mea = nativeRequestTimeGap2;
                }
                long nativeRequestTimeGap3 = nativeRequestTimeGap(this.mdK, 3);
                if (nativeRequestTimeGap3 >= 0) {
                    this.meb = nativeRequestTimeGap3;
                }
                long nativeRequestTimeGap4 = nativeRequestTimeGap(this.mdK, 4);
                if (nativeRequestTimeGap4 >= 0) {
                    this.mec = nativeRequestTimeGap4;
                }
                long nativeRequestTimeGap5 = nativeRequestTimeGap(this.mdK, 5);
                if (nativeRequestTimeGap5 >= 0) {
                    this.med = nativeRequestTimeGap5;
                }
                this.mee = nativeGetRequestTimeInfo(this.mdK);
                if (this.mee == null) {
                    this.mee = new RequestTimeInfo();
                }
                if (this.mdN != null) {
                    this.mdN.dqE();
                }
                nativeDestroy(this.mdK, z);
                if (this.mTag != null) {
                    this.mdb.b(this);
                }
                this.mdb.dqG();
                this.mdK = 0L;
                if (this.mdp != null) {
                    this.mdp.run();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Exception exc) {
        UrlRequestException urlRequestException = new UrlRequestException("Exception received from UrlRequest.Callback", exc);
        com.baidu.turbonet.base.a.h("ChromiumNetwork", "Exception in CalledByNative method", exc);
        synchronized (this.mdO) {
            if (!dqq()) {
                vI(false);
                try {
                    this.mdR.a(this, this.mdn, urlRequestException);
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
                synchronized (CronetUrlRequest.this.mdO) {
                    if (!CronetUrlRequest.this.dqq()) {
                        CronetUrlRequest.this.vI(false);
                        try {
                            CronetUrlRequest.this.mdR.a(CronetUrlRequest.this, CronetUrlRequest.this.mdn, urlRequestException);
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
        this.mdQ += j;
        a2.fz(this.mdQ);
        this.mdP.add(str);
        C(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.mdO) {
                    if (!CronetUrlRequest.this.dqq()) {
                        CronetUrlRequest.this.mdL = true;
                        try {
                            CronetUrlRequest.this.mdR.a(CronetUrlRequest.this, a2, str);
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
        this.mdn = a(i, str, strArr, z, str2, str3);
        C(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.mdO) {
                    if (!CronetUrlRequest.this.dqq()) {
                        if (CronetUrlRequest.this.mdN != null) {
                            CronetUrlRequest.this.mdN.dqF();
                        }
                        CronetUrlRequest.this.mdM = true;
                        try {
                            CronetUrlRequest.this.mdR.a(CronetUrlRequest.this, CronetUrlRequest.this.mdn);
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
        this.mdn.fz(this.mdQ + j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            a(new UrlRequestException("ByteBuffer modified externally during read", null));
            return;
        }
        if (this.met == null) {
            this.met = new a();
        }
        byteBuffer.position(i2 + i);
        this.met.mByteBuffer = byteBuffer;
        C(this.met);
    }

    @CalledByNative
    private void onSucceeded(long j) {
        this.mdn.fz(this.mdQ + j);
        C(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.mdO) {
                    if (!CronetUrlRequest.this.dqq()) {
                        CronetUrlRequest.this.vI(false);
                        try {
                            CronetUrlRequest.this.mdR.b(CronetUrlRequest.this, CronetUrlRequest.this.mdn);
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
        if (this.mdn != null) {
            this.mdn.fz(this.mdQ + j);
        }
        a(new UrlRequestException("Exception in CronetUrlRequest: " + str, i, i2));
    }

    @CalledByNative
    private void onCanceled() {
        C(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.turbonet.base.a.h("ChromiumNetwork", "****** onCanceled, url is: %s", CronetUrlRequest.this.mdn.getUrl());
                    CronetUrlRequest.this.mdR.c(CronetUrlRequest.this, CronetUrlRequest.this.mdn);
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
                statusListener.Gu(UrlRequest.Status.Gt(i));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class b {
        @Nullable
        private Long meA;
        @Nullable
        private Long meB;
        @Nullable
        private Long meC;

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dqD() {
            if (this.meA != null) {
                throw new IllegalStateException("onRequestStarted called repeatedly");
            }
            this.meA = Long.valueOf(SystemClock.elapsedRealtime());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dqE() {
            if (this.meA != null && this.meC == null) {
                this.meC = Long.valueOf(SystemClock.elapsedRealtime() - this.meA.longValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dqF() {
            if (this.meA != null && this.meB == null) {
                this.meB = Long.valueOf(SystemClock.elapsedRealtime() - this.meA.longValue());
            }
        }
    }
}
