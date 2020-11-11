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
    private static final TurbonetEngine.UrlRequestMetrics oma = new TurbonetEngine.UrlRequestMetrics(null, null, null, null);
    private final Executor mExecutor;
    private final int mPriority;
    private Object mTag;
    private UrlResponseInfo olE;
    private Runnable olG;
    private final CronetUrlRequestContext ols;
    private final String olu;
    private String olv;
    private final boolean omA;
    private boolean omB;
    private boolean omC;
    private int omD;
    private int omE;
    private int omF;
    private int omG;
    private String omH;
    private String omI;
    private CronetUploadDataStream omJ;
    private a omK;
    @GuardedBy("mUrlRequestAdapterLock")
    private long omb;
    @GuardedBy("mUrlRequestAdapterLock")
    @Nullable
    private final b ome;
    private long omh;
    private final UrlRequest.Callback omi;
    private String omj;
    private String omk;
    private String oml;
    private String omm;
    private String omn;
    private String omo;
    private String omp;
    private long omq;
    private long omr;
    private long oms;
    private long omt;
    private long omu;
    private RequestTimeInfo omv;
    private final Collection<Object> omx;
    private final boolean omy;
    private final boolean omz;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mStarted = false;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean omc = false;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean omd = false;
    private final Object omf = new Object();
    private final List<String> omg = new ArrayList();
    private final HeadersList omw = new HeadersList();

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
                synchronized (CronetUrlRequest.this.omf) {
                    if (!CronetUrlRequest.this.ebt()) {
                        CronetUrlRequest.this.omd = true;
                        CronetUrlRequest.this.omi.a(CronetUrlRequest.this, CronetUrlRequest.this.olE, byteBuffer);
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
        this.ols = cronetUrlRequestContext;
        this.olu = str;
        this.omg.add(str);
        this.mPriority = MM(i);
        this.omi = callback;
        this.mExecutor = executor;
        this.omx = collection;
        this.ome = z ? new b() : null;
        this.omy = z2;
        this.omz = z3;
        this.omA = z4;
        this.omB = false;
        this.omC = false;
        this.omD = 0;
        this.omE = 0;
        this.omF = 0;
        this.omG = 0;
        this.mTag = null;
        this.omH = null;
        this.omI = null;
        this.olE = new UrlResponseInfo(new ArrayList(this.omg), 0, "", new HeadersList(), false, "", "");
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Wl(String str) {
        ebF();
        if (str == null) {
            throw new NullPointerException("Method is required.");
        }
        this.olv = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void addHeader(String str, String str2) {
        ebF();
        if (str == null) {
            throw new NullPointerException("Invalid header name.");
        }
        if (str2 == null) {
            throw new NullPointerException("Invalid header value.");
        }
        this.omw.add(new AbstractMap.SimpleImmutableEntry(str, str2));
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void a(UploadDataProvider uploadDataProvider, Executor executor) {
        if (uploadDataProvider == null) {
            throw new NullPointerException("Invalid UploadDataProvider.");
        }
        if (this.olv == null) {
            this.olv = "POST";
        }
        this.omJ = new CronetUploadDataStream(uploadDataProvider, executor, this);
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void start() {
        synchronized (this.omf) {
            com.baidu.turbonet.base.a.f("ChromiumNetwork", "****** Request start, url is: %s", this.olu);
            ebF();
            try {
                this.omb = nativeCreateRequestAdapter(this.ols.ebK(), this.olu, this.mPriority, this.omy, this.omz, this.omA);
                this.ols.ebG();
                if (this.olv != null && !nativeSetHttpMethod(this.omb, this.olv)) {
                    throw new IllegalArgumentException("Invalid http method " + this.olv);
                }
                if (this.mTag != null) {
                    this.ols.a(this);
                }
                if (this.omB) {
                    nativeDisableResponseAutoUngzip(this.omb);
                }
                if (this.omC) {
                    nativeEnableBrotliByRequest(this.omb);
                }
                if (this.omD > 0) {
                    nativeSetTimeout(this.omb, this.omD);
                }
                if (this.omE > 0) {
                    nativeSetTCPConnectTimeout(this.omb, this.omE);
                }
                if (this.omF > 0) {
                    nativeSetResponseHeaderRecvTimeout(this.omb, this.omF);
                }
                if (this.omG > 0) {
                    nativeSetResponseBodyReadTimeout(this.omb, this.omG);
                }
                if (!TextUtils.isEmpty(this.omH)) {
                    nativeSetDestinationAddress(this.omb, this.omH);
                }
                if (!TextUtils.isEmpty(this.omI)) {
                    nativeSetRequestTag(this.omb, this.omI);
                }
                Iterator<Map.Entry<String, String>> it = this.omw.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    boolean z2 = (!next.getKey().equalsIgnoreCase("Content-Type") || next.getValue().isEmpty()) ? z : true;
                    if (!nativeAddRequestHeader(this.omb, next.getKey(), next.getValue())) {
                        throw new IllegalArgumentException("Invalid header " + next.getKey() + ETAG.EQUAL + next.getValue());
                    }
                    z = z2;
                }
                if (this.omJ != null) {
                    if (!z) {
                        throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
                    }
                    this.mStarted = true;
                    this.omJ.z(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CronetUrlRequest.this.omJ.ebA();
                            synchronized (CronetUrlRequest.this.omf) {
                                if (!CronetUrlRequest.this.ebt()) {
                                    CronetUrlRequest.this.omJ.hm(CronetUrlRequest.this.omb);
                                    CronetUrlRequest.this.ebB();
                                }
                            }
                        }
                    });
                    return;
                }
                this.mStarted = true;
                ebB();
            } catch (RuntimeException e) {
                zs(false);
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public void ebB() {
        if (this.ome != null) {
            this.ome.ebG();
        }
        nativeStart(this.omb);
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void ebC() {
        synchronized (this.omf) {
            if (!this.omc) {
                throw new IllegalStateException("No redirect to follow.");
            }
            this.omc = false;
            if (!ebt()) {
                nativeFollowDeferredRedirect(this.omb);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void n(ByteBuffer byteBuffer) {
        com.baidu.turbonet.net.b.p(byteBuffer);
        com.baidu.turbonet.net.b.o(byteBuffer);
        synchronized (this.omf) {
            if (!this.omd) {
                throw new IllegalStateException("Unexpected read attempt.");
            }
            this.omd = false;
            if (!ebt()) {
                if (!nativeReadData(this.omb, byteBuffer, byteBuffer.position(), byteBuffer.limit())) {
                    this.omd = true;
                    throw new IllegalArgumentException("Unable to call native read");
                }
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void cancel() {
        synchronized (this.omf) {
            com.baidu.turbonet.base.a.f("ChromiumNetwork", "****** Request cancel, url is: %s", this.olu);
            if (!ebt() && this.mStarted) {
                zs(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public boolean ebt() {
        return this.mStarted && this.omb == 0;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void ebD() {
        ebF();
        this.omB = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void ebE() {
        ebF();
        this.omC = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setTimeout(int i) {
        ebF();
        this.omD = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void MJ(int i) {
        ebF();
        this.omE = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void MK(int i) {
        ebF();
        this.omF = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void ML(int i) {
        ebF();
        this.omG = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setTag(Object obj) {
        ebF();
        this.mTag = obj;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Wm(String str) {
        ebF();
        this.omH = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Wn(String str) {
        ebF();
        this.omI = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public Object getTag() {
        return this.mTag;
    }

    @CalledByNative
    public static RequestTimeInfo createObject(long j, long j2, long j3, long j4, long j5) {
        return new RequestTimeInfo(j, j2, j3, j4, j5);
    }

    private void z(Runnable runnable) {
        try {
            this.mExecutor.execute(runnable);
        } catch (RejectedExecutionException e) {
            com.baidu.turbonet.base.a.g("ChromiumNetwork", "Exception posting task to executor", e);
            zs(false);
        }
    }

    private static int MM(int i) {
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
        return new UrlResponseInfo(new ArrayList(this.omg), i, str, headersList, z, str2, str3);
    }

    private void ebF() {
        synchronized (this.omf) {
            if (this.mStarted || ebt()) {
                throw new IllegalStateException("Request is already started.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zs(boolean z) {
        synchronized (this.omf) {
            if (this.omb != 0) {
                String nativeGetDNSNameServers = nativeGetDNSNameServers(this.omb);
                if (!nativeGetDNSNameServers.isEmpty()) {
                    this.omk = nativeGetDNSNameServers;
                }
                String nativeGetDNSResults = nativeGetDNSResults(this.omb);
                if (!nativeGetDNSResults.isEmpty()) {
                    this.omj = nativeGetDNSResults;
                }
                String nativeGetDNSErrorCode = nativeGetDNSErrorCode(this.omb);
                if (!nativeGetDNSErrorCode.isEmpty()) {
                    this.oml = nativeGetDNSErrorCode;
                }
                String nativeGetConnectionAttempts = nativeGetConnectionAttempts(this.omb, false);
                if (!nativeGetConnectionAttempts.isEmpty()) {
                    this.omm = nativeGetConnectionAttempts;
                }
                String nativeGetConnectionAttempts2 = nativeGetConnectionAttempts(this.omb, true);
                if (!nativeGetConnectionAttempts2.isEmpty()) {
                    this.omn = nativeGetConnectionAttempts2;
                }
                String nativeGetRemoteEndpoint = nativeGetRemoteEndpoint(this.omb);
                if (!nativeGetRemoteEndpoint.isEmpty()) {
                    this.omo = nativeGetRemoteEndpoint;
                }
                String nativeGetSuperPipeInfo = nativeGetSuperPipeInfo(this.omb);
                if (!nativeGetSuperPipeInfo.isEmpty()) {
                    this.omp = nativeGetSuperPipeInfo;
                }
                long nativeRequestTimeGap = nativeRequestTimeGap(this.omb, 1);
                if (nativeRequestTimeGap >= 0) {
                    this.omq = nativeRequestTimeGap;
                }
                long nativeRequestTimeGap2 = nativeRequestTimeGap(this.omb, 2);
                if (nativeRequestTimeGap2 >= 0) {
                    this.omr = nativeRequestTimeGap2;
                }
                long nativeRequestTimeGap3 = nativeRequestTimeGap(this.omb, 3);
                if (nativeRequestTimeGap3 >= 0) {
                    this.oms = nativeRequestTimeGap3;
                }
                long nativeRequestTimeGap4 = nativeRequestTimeGap(this.omb, 4);
                if (nativeRequestTimeGap4 >= 0) {
                    this.omt = nativeRequestTimeGap4;
                }
                long nativeRequestTimeGap5 = nativeRequestTimeGap(this.omb, 5);
                if (nativeRequestTimeGap5 >= 0) {
                    this.omu = nativeRequestTimeGap5;
                }
                this.omv = nativeGetRequestTimeInfo(this.omb);
                if (this.omv == null) {
                    this.omv = new RequestTimeInfo();
                }
                if (this.ome != null) {
                    this.ome.ebH();
                }
                nativeDestroy(this.omb, z);
                if (this.mTag != null) {
                    this.ols.b(this);
                }
                this.ols.ebJ();
                this.omb = 0L;
                if (this.olG != null) {
                    this.olG.run();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Exception exc) {
        UrlRequestException urlRequestException = new UrlRequestException("Exception received from UrlRequest.Callback", exc);
        com.baidu.turbonet.base.a.g("ChromiumNetwork", "Exception in CalledByNative method", exc);
        synchronized (this.omf) {
            if (!ebt()) {
                zs(false);
                try {
                    this.omi.a(this, this.olE, urlRequestException);
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
        z(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.omf) {
                    if (!CronetUrlRequest.this.ebt()) {
                        CronetUrlRequest.this.zs(false);
                        try {
                            CronetUrlRequest.this.omi.a(CronetUrlRequest.this, CronetUrlRequest.this.olE, urlRequestException);
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
        this.omh += j;
        a2.ho(this.omh);
        this.omg.add(str);
        z(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.omf) {
                    if (!CronetUrlRequest.this.ebt()) {
                        CronetUrlRequest.this.omc = true;
                        try {
                            CronetUrlRequest.this.omi.a(CronetUrlRequest.this, a2, str);
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
        this.olE = a(i, str, strArr, z, str2, str3);
        z(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.omf) {
                    if (!CronetUrlRequest.this.ebt()) {
                        if (CronetUrlRequest.this.ome != null) {
                            CronetUrlRequest.this.ome.ebI();
                        }
                        CronetUrlRequest.this.omd = true;
                        try {
                            CronetUrlRequest.this.omi.a(CronetUrlRequest.this, CronetUrlRequest.this.olE);
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
        this.olE.ho(this.omh + j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            a(new UrlRequestException("ByteBuffer modified externally during read", null));
            return;
        }
        if (this.omK == null) {
            this.omK = new a();
        }
        byteBuffer.position(i2 + i);
        this.omK.mByteBuffer = byteBuffer;
        z(this.omK);
    }

    @CalledByNative
    private void onSucceeded(long j) {
        this.olE.ho(this.omh + j);
        z(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.omf) {
                    if (!CronetUrlRequest.this.ebt()) {
                        CronetUrlRequest.this.zs(false);
                        try {
                            CronetUrlRequest.this.omi.b(CronetUrlRequest.this, CronetUrlRequest.this.olE);
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
        if (this.olE != null) {
            this.olE.ho(this.omh + j);
        }
        a(new UrlRequestException("Exception in CronetUrlRequest: " + str, i, i2));
    }

    @CalledByNative
    private void onCanceled() {
        z(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.turbonet.base.a.g("ChromiumNetwork", "****** onCanceled, url is: %s", CronetUrlRequest.this.olE.getUrl());
                    CronetUrlRequest.this.omi.c(CronetUrlRequest.this, CronetUrlRequest.this.olE);
                } catch (Exception e) {
                    com.baidu.turbonet.base.a.g("ChromiumNetwork", "Exception in onCanceled method", e);
                }
            }
        });
    }

    @CalledByNative
    private void onStatus(final UrlRequest.StatusListener statusListener, final int i) {
        z(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.7
            @Override // java.lang.Runnable
            public void run() {
                statusListener.Nc(UrlRequest.Status.Nb(i));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public final class b {
        @Nullable
        private Long omR;
        @Nullable
        private Long omS;
        @Nullable
        private Long omT;

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ebG() {
            if (this.omR != null) {
                throw new IllegalStateException("onRequestStarted called repeatedly");
            }
            this.omR = Long.valueOf(SystemClock.elapsedRealtime());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ebH() {
            if (this.omR != null && this.omT == null) {
                this.omT = Long.valueOf(SystemClock.elapsedRealtime() - this.omR.longValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ebI() {
            if (this.omR != null && this.omS == null) {
                this.omS = Long.valueOf(SystemClock.elapsedRealtime() - this.omR.longValue());
            }
        }
    }
}
