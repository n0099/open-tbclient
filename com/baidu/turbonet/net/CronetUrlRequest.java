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
/* loaded from: classes12.dex */
public final class CronetUrlRequest implements UrlRequest {
    private static final TurbonetEngine.UrlRequestMetrics onE = new TurbonetEngine.UrlRequestMetrics(null, null, null, null);
    private final Executor mExecutor;
    private final int mPriority;
    private Object mTag;
    private final CronetUrlRequestContext omV;
    private final String omX;
    private String omY;
    @GuardedBy("mUrlRequestAdapterLock")
    private long onF;
    @GuardedBy("mUrlRequestAdapterLock")
    @Nullable
    private final b onI;
    private long onL;
    private final UrlRequest.Callback onM;
    private String onN;
    private String onO;
    private String onP;
    private String onQ;
    private String onR;
    private String onS;
    private String onT;
    private long onU;
    private long onV;
    private long onW;
    private long onX;
    private long onY;
    private RequestTimeInfo onZ;
    private UrlResponseInfo oni;
    private Runnable onk;
    private final Collection<Object> oob;
    private final boolean ooc;
    private final boolean ood;
    private final boolean ooe;
    private boolean oof;
    private boolean oog;
    private int ooh;
    private int ooi;
    private int ooj;
    private int ook;
    private String ool;
    private String oom;
    private CronetUploadDataStream oon;
    private a ooo;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mStarted = false;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean onG = false;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean onH = false;
    private final Object onJ = new Object();
    private final List<String> onK = new ArrayList();
    private final HeadersList ooa = new HeadersList();

    /* loaded from: classes12.dex */
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
    /* loaded from: classes12.dex */
    public static final class HeadersList extends ArrayList<Map.Entry<String, String>> {
        private HeadersList() {
        }
    }

    /* loaded from: classes12.dex */
    private final class a implements Runnable {
        ByteBuffer mByteBuffer;

        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ByteBuffer byteBuffer = this.mByteBuffer;
            this.mByteBuffer = null;
            try {
                synchronized (CronetUrlRequest.this.onJ) {
                    if (!CronetUrlRequest.this.ebs()) {
                        CronetUrlRequest.this.onH = true;
                        CronetUrlRequest.this.onM.a(CronetUrlRequest.this, CronetUrlRequest.this.oni, byteBuffer);
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
        this.omV = cronetUrlRequestContext;
        this.omX = str;
        this.onK.add(str);
        this.mPriority = Np(i);
        this.onM = callback;
        this.mExecutor = executor;
        this.oob = collection;
        this.onI = z ? new b() : null;
        this.ooc = z2;
        this.ood = z3;
        this.ooe = z4;
        this.oof = false;
        this.oog = false;
        this.ooh = 0;
        this.ooi = 0;
        this.ooj = 0;
        this.ook = 0;
        this.mTag = null;
        this.ool = null;
        this.oom = null;
        this.oni = new UrlResponseInfo(new ArrayList(this.onK), 0, "", new HeadersList(), false, "", "");
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void VW(String str) {
        ebE();
        if (str == null) {
            throw new NullPointerException("Method is required.");
        }
        this.omY = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void addHeader(String str, String str2) {
        ebE();
        if (str == null) {
            throw new NullPointerException("Invalid header name.");
        }
        if (str2 == null) {
            throw new NullPointerException("Invalid header value.");
        }
        this.ooa.add(new AbstractMap.SimpleImmutableEntry(str, str2));
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void a(UploadDataProvider uploadDataProvider, Executor executor) {
        if (uploadDataProvider == null) {
            throw new NullPointerException("Invalid UploadDataProvider.");
        }
        if (this.omY == null) {
            this.omY = "POST";
        }
        this.oon = new CronetUploadDataStream(uploadDataProvider, executor, this);
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void start() {
        synchronized (this.onJ) {
            com.baidu.turbonet.base.a.f("ChromiumNetwork", "****** Request start, url is: %s", this.omX);
            ebE();
            try {
                this.onF = nativeCreateRequestAdapter(this.omV.ebJ(), this.omX, this.mPriority, this.ooc, this.ood, this.ooe);
                this.omV.ebF();
                if (this.omY != null && !nativeSetHttpMethod(this.onF, this.omY)) {
                    throw new IllegalArgumentException("Invalid http method " + this.omY);
                }
                if (this.mTag != null) {
                    this.omV.a(this);
                }
                if (this.oof) {
                    nativeDisableResponseAutoUngzip(this.onF);
                }
                if (this.oog) {
                    nativeEnableBrotliByRequest(this.onF);
                }
                if (this.ooh > 0) {
                    nativeSetTimeout(this.onF, this.ooh);
                }
                if (this.ooi > 0) {
                    nativeSetTCPConnectTimeout(this.onF, this.ooi);
                }
                if (this.ooj > 0) {
                    nativeSetResponseHeaderRecvTimeout(this.onF, this.ooj);
                }
                if (this.ook > 0) {
                    nativeSetResponseBodyReadTimeout(this.onF, this.ook);
                }
                if (!TextUtils.isEmpty(this.ool)) {
                    nativeSetDestinationAddress(this.onF, this.ool);
                }
                if (!TextUtils.isEmpty(this.oom)) {
                    nativeSetRequestTag(this.onF, this.oom);
                }
                Iterator<Map.Entry<String, String>> it = this.ooa.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    boolean z2 = (!next.getKey().equalsIgnoreCase("Content-Type") || next.getValue().isEmpty()) ? z : true;
                    if (!nativeAddRequestHeader(this.onF, next.getKey(), next.getValue())) {
                        throw new IllegalArgumentException("Invalid header " + next.getKey() + ETAG.EQUAL + next.getValue());
                    }
                    z = z2;
                }
                if (this.oon != null) {
                    if (!z) {
                        throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
                    }
                    this.mStarted = true;
                    this.oon.z(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CronetUrlRequest.this.oon.ebz();
                            synchronized (CronetUrlRequest.this.onJ) {
                                if (!CronetUrlRequest.this.ebs()) {
                                    CronetUrlRequest.this.oon.hp(CronetUrlRequest.this.onF);
                                    CronetUrlRequest.this.ebA();
                                }
                            }
                        }
                    });
                    return;
                }
                this.mStarted = true;
                ebA();
            } catch (RuntimeException e) {
                zz(false);
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public void ebA() {
        if (this.onI != null) {
            this.onI.ebF();
        }
        nativeStart(this.onF);
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void ebB() {
        synchronized (this.onJ) {
            if (!this.onG) {
                throw new IllegalStateException("No redirect to follow.");
            }
            this.onG = false;
            if (!ebs()) {
                nativeFollowDeferredRedirect(this.onF);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void n(ByteBuffer byteBuffer) {
        com.baidu.turbonet.net.b.p(byteBuffer);
        com.baidu.turbonet.net.b.o(byteBuffer);
        synchronized (this.onJ) {
            if (!this.onH) {
                throw new IllegalStateException("Unexpected read attempt.");
            }
            this.onH = false;
            if (!ebs()) {
                if (!nativeReadData(this.onF, byteBuffer, byteBuffer.position(), byteBuffer.limit())) {
                    this.onH = true;
                    throw new IllegalArgumentException("Unable to call native read");
                }
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void cancel() {
        synchronized (this.onJ) {
            com.baidu.turbonet.base.a.f("ChromiumNetwork", "****** Request cancel, url is: %s", this.omX);
            if (!ebs() && this.mStarted) {
                zz(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public boolean ebs() {
        return this.mStarted && this.onF == 0;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void ebC() {
        ebE();
        this.oof = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void ebD() {
        ebE();
        this.oog = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setTimeout(int i) {
        ebE();
        this.ooh = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Nm(int i) {
        ebE();
        this.ooi = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Nn(int i) {
        ebE();
        this.ooj = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void No(int i) {
        ebE();
        this.ook = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setTag(Object obj) {
        ebE();
        this.mTag = obj;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void VX(String str) {
        ebE();
        this.ool = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void VY(String str) {
        ebE();
        this.oom = str;
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
            zz(false);
        }
    }

    private static int Np(int i) {
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
        return new UrlResponseInfo(new ArrayList(this.onK), i, str, headersList, z, str2, str3);
    }

    private void ebE() {
        synchronized (this.onJ) {
            if (this.mStarted || ebs()) {
                throw new IllegalStateException("Request is already started.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zz(boolean z) {
        synchronized (this.onJ) {
            if (this.onF != 0) {
                String nativeGetDNSNameServers = nativeGetDNSNameServers(this.onF);
                if (!nativeGetDNSNameServers.isEmpty()) {
                    this.onO = nativeGetDNSNameServers;
                }
                String nativeGetDNSResults = nativeGetDNSResults(this.onF);
                if (!nativeGetDNSResults.isEmpty()) {
                    this.onN = nativeGetDNSResults;
                }
                String nativeGetDNSErrorCode = nativeGetDNSErrorCode(this.onF);
                if (!nativeGetDNSErrorCode.isEmpty()) {
                    this.onP = nativeGetDNSErrorCode;
                }
                String nativeGetConnectionAttempts = nativeGetConnectionAttempts(this.onF, false);
                if (!nativeGetConnectionAttempts.isEmpty()) {
                    this.onQ = nativeGetConnectionAttempts;
                }
                String nativeGetConnectionAttempts2 = nativeGetConnectionAttempts(this.onF, true);
                if (!nativeGetConnectionAttempts2.isEmpty()) {
                    this.onR = nativeGetConnectionAttempts2;
                }
                String nativeGetRemoteEndpoint = nativeGetRemoteEndpoint(this.onF);
                if (!nativeGetRemoteEndpoint.isEmpty()) {
                    this.onS = nativeGetRemoteEndpoint;
                }
                String nativeGetSuperPipeInfo = nativeGetSuperPipeInfo(this.onF);
                if (!nativeGetSuperPipeInfo.isEmpty()) {
                    this.onT = nativeGetSuperPipeInfo;
                }
                long nativeRequestTimeGap = nativeRequestTimeGap(this.onF, 1);
                if (nativeRequestTimeGap >= 0) {
                    this.onU = nativeRequestTimeGap;
                }
                long nativeRequestTimeGap2 = nativeRequestTimeGap(this.onF, 2);
                if (nativeRequestTimeGap2 >= 0) {
                    this.onV = nativeRequestTimeGap2;
                }
                long nativeRequestTimeGap3 = nativeRequestTimeGap(this.onF, 3);
                if (nativeRequestTimeGap3 >= 0) {
                    this.onW = nativeRequestTimeGap3;
                }
                long nativeRequestTimeGap4 = nativeRequestTimeGap(this.onF, 4);
                if (nativeRequestTimeGap4 >= 0) {
                    this.onX = nativeRequestTimeGap4;
                }
                long nativeRequestTimeGap5 = nativeRequestTimeGap(this.onF, 5);
                if (nativeRequestTimeGap5 >= 0) {
                    this.onY = nativeRequestTimeGap5;
                }
                this.onZ = nativeGetRequestTimeInfo(this.onF);
                if (this.onZ == null) {
                    this.onZ = new RequestTimeInfo();
                }
                if (this.onI != null) {
                    this.onI.ebG();
                }
                nativeDestroy(this.onF, z);
                if (this.mTag != null) {
                    this.omV.b(this);
                }
                this.omV.ebI();
                this.onF = 0L;
                if (this.onk != null) {
                    this.onk.run();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Exception exc) {
        UrlRequestException urlRequestException = new UrlRequestException("Exception received from UrlRequest.Callback", exc);
        com.baidu.turbonet.base.a.g("ChromiumNetwork", "Exception in CalledByNative method", exc);
        synchronized (this.onJ) {
            if (!ebs()) {
                zz(false);
                try {
                    this.onM.a(this, this.oni, urlRequestException);
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
                synchronized (CronetUrlRequest.this.onJ) {
                    if (!CronetUrlRequest.this.ebs()) {
                        CronetUrlRequest.this.zz(false);
                        try {
                            CronetUrlRequest.this.onM.a(CronetUrlRequest.this, CronetUrlRequest.this.oni, urlRequestException);
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
        this.onL += j;
        a2.hr(this.onL);
        this.onK.add(str);
        z(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.onJ) {
                    if (!CronetUrlRequest.this.ebs()) {
                        CronetUrlRequest.this.onG = true;
                        try {
                            CronetUrlRequest.this.onM.a(CronetUrlRequest.this, a2, str);
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
        this.oni = a(i, str, strArr, z, str2, str3);
        z(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.onJ) {
                    if (!CronetUrlRequest.this.ebs()) {
                        if (CronetUrlRequest.this.onI != null) {
                            CronetUrlRequest.this.onI.ebH();
                        }
                        CronetUrlRequest.this.onH = true;
                        try {
                            CronetUrlRequest.this.onM.a(CronetUrlRequest.this, CronetUrlRequest.this.oni);
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
        this.oni.hr(this.onL + j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            a(new UrlRequestException("ByteBuffer modified externally during read", null));
            return;
        }
        if (this.ooo == null) {
            this.ooo = new a();
        }
        byteBuffer.position(i2 + i);
        this.ooo.mByteBuffer = byteBuffer;
        z(this.ooo);
    }

    @CalledByNative
    private void onSucceeded(long j) {
        this.oni.hr(this.onL + j);
        z(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.onJ) {
                    if (!CronetUrlRequest.this.ebs()) {
                        CronetUrlRequest.this.zz(false);
                        try {
                            CronetUrlRequest.this.onM.b(CronetUrlRequest.this, CronetUrlRequest.this.oni);
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
        if (this.oni != null) {
            this.oni.hr(this.onL + j);
        }
        a(new UrlRequestException("Exception in CronetUrlRequest: " + str, i, i2));
    }

    @CalledByNative
    private void onCanceled() {
        z(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.turbonet.base.a.g("ChromiumNetwork", "****** onCanceled, url is: %s", CronetUrlRequest.this.oni.getUrl());
                    CronetUrlRequest.this.onM.c(CronetUrlRequest.this, CronetUrlRequest.this.oni);
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
                statusListener.NF(UrlRequest.Status.NE(i));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public final class b {
        @Nullable
        private Long oov;
        @Nullable
        private Long oow;
        @Nullable
        private Long oox;

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ebF() {
            if (this.oov != null) {
                throw new IllegalStateException("onRequestStarted called repeatedly");
            }
            this.oov = Long.valueOf(SystemClock.elapsedRealtime());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ebG() {
            if (this.oov != null && this.oox == null) {
                this.oox = Long.valueOf(SystemClock.elapsedRealtime() - this.oov.longValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ebH() {
            if (this.oov != null && this.oow == null) {
                this.oow = Long.valueOf(SystemClock.elapsedRealtime() - this.oov.longValue());
            }
        }
    }
}
