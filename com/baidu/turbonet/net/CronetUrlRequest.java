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
    private static final TurbonetEngine.UrlRequestMetrics ocW = new TurbonetEngine.UrlRequestMetrics(null, null, null, null);
    private final Executor mExecutor;
    private final int mPriority;
    private Object mTag;
    private UrlResponseInfo ocA;
    private Runnable ocC;
    @GuardedBy("mUrlRequestAdapterLock")
    private long ocX;
    private final CronetUrlRequestContext ocn;
    private final String ocp;
    private String ocq;
    private int odA;
    private int odB;
    private int odC;
    private String odD;
    private String odE;
    private CronetUploadDataStream odF;
    private a odG;
    @GuardedBy("mUrlRequestAdapterLock")
    @Nullable
    private final b oda;
    private long odd;
    private final UrlRequest.Callback ode;
    private String odf;
    private String odg;
    private String odh;
    private String odi;
    private String odj;
    private String odk;
    private String odl;
    private long odm;
    private long odn;
    private long odo;
    private long odp;
    private long odq;
    private RequestTimeInfo odr;
    private final Collection<Object> odt;
    private final boolean odu;
    private final boolean odv;
    private final boolean odw;
    private boolean odx;
    private boolean ody;
    private int odz;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mStarted = false;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean ocY = false;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean ocZ = false;
    private final Object odb = new Object();
    private final List<String> odc = new ArrayList();
    private final HeadersList ods = new HeadersList();

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
                synchronized (CronetUrlRequest.this.odb) {
                    if (!CronetUrlRequest.this.dXL()) {
                        CronetUrlRequest.this.ocZ = true;
                        CronetUrlRequest.this.ode.a(CronetUrlRequest.this, CronetUrlRequest.this.ocA, byteBuffer);
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
        this.ocn = cronetUrlRequestContext;
        this.ocp = str;
        this.odc.add(str);
        this.mPriority = Mt(i);
        this.ode = callback;
        this.mExecutor = executor;
        this.odt = collection;
        this.oda = z ? new b() : null;
        this.odu = z2;
        this.odv = z3;
        this.odw = z4;
        this.odx = false;
        this.ody = false;
        this.odz = 0;
        this.odA = 0;
        this.odB = 0;
        this.odC = 0;
        this.mTag = null;
        this.odD = null;
        this.odE = null;
        this.ocA = new UrlResponseInfo(new ArrayList(this.odc), 0, "", new HeadersList(), false, "", "");
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void VI(String str) {
        dXX();
        if (str == null) {
            throw new NullPointerException("Method is required.");
        }
        this.ocq = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void addHeader(String str, String str2) {
        dXX();
        if (str == null) {
            throw new NullPointerException("Invalid header name.");
        }
        if (str2 == null) {
            throw new NullPointerException("Invalid header value.");
        }
        this.ods.add(new AbstractMap.SimpleImmutableEntry(str, str2));
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void a(UploadDataProvider uploadDataProvider, Executor executor) {
        if (uploadDataProvider == null) {
            throw new NullPointerException("Invalid UploadDataProvider.");
        }
        if (this.ocq == null) {
            this.ocq = "POST";
        }
        this.odF = new CronetUploadDataStream(uploadDataProvider, executor, this);
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void start() {
        synchronized (this.odb) {
            com.baidu.turbonet.base.a.f("ChromiumNetwork", "****** Request start, url is: %s", this.ocp);
            dXX();
            try {
                this.ocX = nativeCreateRequestAdapter(this.ocn.dYc(), this.ocp, this.mPriority, this.odu, this.odv, this.odw);
                this.ocn.dXY();
                if (this.ocq != null && !nativeSetHttpMethod(this.ocX, this.ocq)) {
                    throw new IllegalArgumentException("Invalid http method " + this.ocq);
                }
                if (this.mTag != null) {
                    this.ocn.a(this);
                }
                if (this.odx) {
                    nativeDisableResponseAutoUngzip(this.ocX);
                }
                if (this.ody) {
                    nativeEnableBrotliByRequest(this.ocX);
                }
                if (this.odz > 0) {
                    nativeSetTimeout(this.ocX, this.odz);
                }
                if (this.odA > 0) {
                    nativeSetTCPConnectTimeout(this.ocX, this.odA);
                }
                if (this.odB > 0) {
                    nativeSetResponseHeaderRecvTimeout(this.ocX, this.odB);
                }
                if (this.odC > 0) {
                    nativeSetResponseBodyReadTimeout(this.ocX, this.odC);
                }
                if (!TextUtils.isEmpty(this.odD)) {
                    nativeSetDestinationAddress(this.ocX, this.odD);
                }
                if (!TextUtils.isEmpty(this.odE)) {
                    nativeSetRequestTag(this.ocX, this.odE);
                }
                Iterator<Map.Entry<String, String>> it = this.ods.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    boolean z2 = (!next.getKey().equalsIgnoreCase("Content-Type") || next.getValue().isEmpty()) ? z : true;
                    if (!nativeAddRequestHeader(this.ocX, next.getKey(), next.getValue())) {
                        throw new IllegalArgumentException("Invalid header " + next.getKey() + ETAG.EQUAL + next.getValue());
                    }
                    z = z2;
                }
                if (this.odF != null) {
                    if (!z) {
                        throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
                    }
                    this.mStarted = true;
                    this.odF.z(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CronetUrlRequest.this.odF.dXS();
                            synchronized (CronetUrlRequest.this.odb) {
                                if (!CronetUrlRequest.this.dXL()) {
                                    CronetUrlRequest.this.odF.gQ(CronetUrlRequest.this.ocX);
                                    CronetUrlRequest.this.dXT();
                                }
                            }
                        }
                    });
                    return;
                }
                this.mStarted = true;
                dXT();
            } catch (RuntimeException e) {
                zh(false);
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public void dXT() {
        if (this.oda != null) {
            this.oda.dXY();
        }
        nativeStart(this.ocX);
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void dXU() {
        synchronized (this.odb) {
            if (!this.ocY) {
                throw new IllegalStateException("No redirect to follow.");
            }
            this.ocY = false;
            if (!dXL()) {
                nativeFollowDeferredRedirect(this.ocX);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void n(ByteBuffer byteBuffer) {
        com.baidu.turbonet.net.b.p(byteBuffer);
        com.baidu.turbonet.net.b.o(byteBuffer);
        synchronized (this.odb) {
            if (!this.ocZ) {
                throw new IllegalStateException("Unexpected read attempt.");
            }
            this.ocZ = false;
            if (!dXL()) {
                if (!nativeReadData(this.ocX, byteBuffer, byteBuffer.position(), byteBuffer.limit())) {
                    this.ocZ = true;
                    throw new IllegalArgumentException("Unable to call native read");
                }
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void cancel() {
        synchronized (this.odb) {
            com.baidu.turbonet.base.a.f("ChromiumNetwork", "****** Request cancel, url is: %s", this.ocp);
            if (!dXL() && this.mStarted) {
                zh(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public boolean dXL() {
        return this.mStarted && this.ocX == 0;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void dXV() {
        dXX();
        this.odx = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void dXW() {
        dXX();
        this.ody = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setTimeout(int i) {
        dXX();
        this.odz = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Mq(int i) {
        dXX();
        this.odA = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Mr(int i) {
        dXX();
        this.odB = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Ms(int i) {
        dXX();
        this.odC = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setTag(Object obj) {
        dXX();
        this.mTag = obj;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void VJ(String str) {
        dXX();
        this.odD = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void VK(String str) {
        dXX();
        this.odE = str;
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
            zh(false);
        }
    }

    private static int Mt(int i) {
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
        return new UrlResponseInfo(new ArrayList(this.odc), i, str, headersList, z, str2, str3);
    }

    private void dXX() {
        synchronized (this.odb) {
            if (this.mStarted || dXL()) {
                throw new IllegalStateException("Request is already started.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zh(boolean z) {
        synchronized (this.odb) {
            if (this.ocX != 0) {
                String nativeGetDNSNameServers = nativeGetDNSNameServers(this.ocX);
                if (!nativeGetDNSNameServers.isEmpty()) {
                    this.odg = nativeGetDNSNameServers;
                }
                String nativeGetDNSResults = nativeGetDNSResults(this.ocX);
                if (!nativeGetDNSResults.isEmpty()) {
                    this.odf = nativeGetDNSResults;
                }
                String nativeGetDNSErrorCode = nativeGetDNSErrorCode(this.ocX);
                if (!nativeGetDNSErrorCode.isEmpty()) {
                    this.odh = nativeGetDNSErrorCode;
                }
                String nativeGetConnectionAttempts = nativeGetConnectionAttempts(this.ocX, false);
                if (!nativeGetConnectionAttempts.isEmpty()) {
                    this.odi = nativeGetConnectionAttempts;
                }
                String nativeGetConnectionAttempts2 = nativeGetConnectionAttempts(this.ocX, true);
                if (!nativeGetConnectionAttempts2.isEmpty()) {
                    this.odj = nativeGetConnectionAttempts2;
                }
                String nativeGetRemoteEndpoint = nativeGetRemoteEndpoint(this.ocX);
                if (!nativeGetRemoteEndpoint.isEmpty()) {
                    this.odk = nativeGetRemoteEndpoint;
                }
                String nativeGetSuperPipeInfo = nativeGetSuperPipeInfo(this.ocX);
                if (!nativeGetSuperPipeInfo.isEmpty()) {
                    this.odl = nativeGetSuperPipeInfo;
                }
                long nativeRequestTimeGap = nativeRequestTimeGap(this.ocX, 1);
                if (nativeRequestTimeGap >= 0) {
                    this.odm = nativeRequestTimeGap;
                }
                long nativeRequestTimeGap2 = nativeRequestTimeGap(this.ocX, 2);
                if (nativeRequestTimeGap2 >= 0) {
                    this.odn = nativeRequestTimeGap2;
                }
                long nativeRequestTimeGap3 = nativeRequestTimeGap(this.ocX, 3);
                if (nativeRequestTimeGap3 >= 0) {
                    this.odo = nativeRequestTimeGap3;
                }
                long nativeRequestTimeGap4 = nativeRequestTimeGap(this.ocX, 4);
                if (nativeRequestTimeGap4 >= 0) {
                    this.odp = nativeRequestTimeGap4;
                }
                long nativeRequestTimeGap5 = nativeRequestTimeGap(this.ocX, 5);
                if (nativeRequestTimeGap5 >= 0) {
                    this.odq = nativeRequestTimeGap5;
                }
                this.odr = nativeGetRequestTimeInfo(this.ocX);
                if (this.odr == null) {
                    this.odr = new RequestTimeInfo();
                }
                if (this.oda != null) {
                    this.oda.dXZ();
                }
                nativeDestroy(this.ocX, z);
                if (this.mTag != null) {
                    this.ocn.b(this);
                }
                this.ocn.dYb();
                this.ocX = 0L;
                if (this.ocC != null) {
                    this.ocC.run();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Exception exc) {
        UrlRequestException urlRequestException = new UrlRequestException("Exception received from UrlRequest.Callback", exc);
        com.baidu.turbonet.base.a.g("ChromiumNetwork", "Exception in CalledByNative method", exc);
        synchronized (this.odb) {
            if (!dXL()) {
                zh(false);
                try {
                    this.ode.a(this, this.ocA, urlRequestException);
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
                synchronized (CronetUrlRequest.this.odb) {
                    if (!CronetUrlRequest.this.dXL()) {
                        CronetUrlRequest.this.zh(false);
                        try {
                            CronetUrlRequest.this.ode.a(CronetUrlRequest.this, CronetUrlRequest.this.ocA, urlRequestException);
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
        this.odd += j;
        a2.gS(this.odd);
        this.odc.add(str);
        z(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.odb) {
                    if (!CronetUrlRequest.this.dXL()) {
                        CronetUrlRequest.this.ocY = true;
                        try {
                            CronetUrlRequest.this.ode.a(CronetUrlRequest.this, a2, str);
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
        this.ocA = a(i, str, strArr, z, str2, str3);
        z(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.odb) {
                    if (!CronetUrlRequest.this.dXL()) {
                        if (CronetUrlRequest.this.oda != null) {
                            CronetUrlRequest.this.oda.dYa();
                        }
                        CronetUrlRequest.this.ocZ = true;
                        try {
                            CronetUrlRequest.this.ode.a(CronetUrlRequest.this, CronetUrlRequest.this.ocA);
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
        this.ocA.gS(this.odd + j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            a(new UrlRequestException("ByteBuffer modified externally during read", null));
            return;
        }
        if (this.odG == null) {
            this.odG = new a();
        }
        byteBuffer.position(i2 + i);
        this.odG.mByteBuffer = byteBuffer;
        z(this.odG);
    }

    @CalledByNative
    private void onSucceeded(long j) {
        this.ocA.gS(this.odd + j);
        z(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.odb) {
                    if (!CronetUrlRequest.this.dXL()) {
                        CronetUrlRequest.this.zh(false);
                        try {
                            CronetUrlRequest.this.ode.b(CronetUrlRequest.this, CronetUrlRequest.this.ocA);
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
        if (this.ocA != null) {
            this.ocA.gS(this.odd + j);
        }
        a(new UrlRequestException("Exception in CronetUrlRequest: " + str, i, i2));
    }

    @CalledByNative
    private void onCanceled() {
        z(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.turbonet.base.a.g("ChromiumNetwork", "****** onCanceled, url is: %s", CronetUrlRequest.this.ocA.getUrl());
                    CronetUrlRequest.this.ode.c(CronetUrlRequest.this, CronetUrlRequest.this.ocA);
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
                statusListener.MJ(UrlRequest.Status.MI(i));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public final class b {
        @Nullable
        private Long odN;
        @Nullable
        private Long odO;
        @Nullable
        private Long odP;

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dXY() {
            if (this.odN != null) {
                throw new IllegalStateException("onRequestStarted called repeatedly");
            }
            this.odN = Long.valueOf(SystemClock.elapsedRealtime());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dXZ() {
            if (this.odN != null && this.odP == null) {
                this.odP = Long.valueOf(SystemClock.elapsedRealtime() - this.odN.longValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dYa() {
            if (this.odN != null && this.odO == null) {
                this.odO = Long.valueOf(SystemClock.elapsedRealtime() - this.odN.longValue());
            }
        }
    }
}
