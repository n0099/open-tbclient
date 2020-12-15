package com.baidu.turbonet.net;

import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.annotations.JNINamespace;
import com.baidu.turbonet.base.annotations.NativeClassQualifiedName;
import com.baidu.turbonet.net.TurbonetEngine;
import com.baidu.turbonet.net.UrlRequest;
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
/* loaded from: classes14.dex */
public final class CronetUrlRequest implements UrlRequest {
    private static final TurbonetEngine.UrlRequestMetrics oCE = new TurbonetEngine.UrlRequestMetrics(null, null, null, null);
    private final Executor mExecutor;
    private final int mPriority;
    private Object mTag;
    private final CronetUrlRequestContext oBW;
    private final String oBY;
    private String oBZ;
    @GuardedBy("mUrlRequestAdapterLock")
    private long oCF;
    @GuardedBy("mUrlRequestAdapterLock")
    @Nullable
    private final b oCI;
    private long oCL;
    private final UrlRequest.Callback oCM;
    private String oCN;
    private String oCO;
    private String oCP;
    private String oCQ;
    private String oCR;
    private String oCS;
    private String oCT;
    private long oCU;
    private long oCV;
    private long oCW;
    private long oCX;
    private long oCY;
    private RequestTimeInfo oCZ;
    private UrlResponseInfo oCi;
    private Runnable oCk;
    private final Collection<Object> oDb;
    private final boolean oDc;
    private final boolean oDd;
    private final boolean oDe;
    private boolean oDf;
    private boolean oDg;
    private int oDh;
    private int oDi;
    private int oDj;
    private int oDk;
    private String oDl;
    private String oDm;
    private CronetUploadDataStream oDn;
    private a oDo;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mStarted = false;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean oCG = false;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean oCH = false;
    private final Object oCJ = new Object();
    private final List<String> oCK = new ArrayList();
    private final HeadersList oDa = new HeadersList();

    /* loaded from: classes14.dex */
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
    /* loaded from: classes14.dex */
    public static final class HeadersList extends ArrayList<Map.Entry<String, String>> {
        private HeadersList() {
        }
    }

    /* loaded from: classes14.dex */
    private final class a implements Runnable {
        ByteBuffer mByteBuffer;

        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ByteBuffer byteBuffer = this.mByteBuffer;
            this.mByteBuffer = null;
            try {
                synchronized (CronetUrlRequest.this.oCJ) {
                    if (!CronetUrlRequest.this.egY()) {
                        CronetUrlRequest.this.oCH = true;
                        CronetUrlRequest.this.oCM.a(CronetUrlRequest.this, CronetUrlRequest.this.oCi, byteBuffer);
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
        this.oBW = cronetUrlRequestContext;
        this.oBY = str;
        this.oCK.add(str);
        this.mPriority = Oh(i);
        this.oCM = callback;
        this.mExecutor = executor;
        this.oDb = collection;
        this.oCI = z ? new b() : null;
        this.oDc = z2;
        this.oDd = z3;
        this.oDe = z4;
        this.oDf = false;
        this.oDg = false;
        this.oDh = 0;
        this.oDi = 0;
        this.oDj = 0;
        this.oDk = 0;
        this.mTag = null;
        this.oDl = null;
        this.oDm = null;
        this.oCi = new UrlResponseInfo(new ArrayList(this.oCK), 0, "", new HeadersList(), false, "", "");
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Xl(String str) {
        ehk();
        if (str == null) {
            throw new NullPointerException("Method is required.");
        }
        this.oBZ = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void addHeader(String str, String str2) {
        ehk();
        if (str == null) {
            throw new NullPointerException("Invalid header name.");
        }
        if (str2 == null) {
            throw new NullPointerException("Invalid header value.");
        }
        this.oDa.add(new AbstractMap.SimpleImmutableEntry(str, str2));
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void a(UploadDataProvider uploadDataProvider, Executor executor) {
        if (uploadDataProvider == null) {
            throw new NullPointerException("Invalid UploadDataProvider.");
        }
        if (this.oBZ == null) {
            this.oBZ = "POST";
        }
        this.oDn = new CronetUploadDataStream(uploadDataProvider, executor, this);
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void start() {
        synchronized (this.oCJ) {
            com.baidu.turbonet.base.a.f("ChromiumNetwork", "****** Request start, url is: %s", this.oBY);
            ehk();
            try {
                this.oCF = nativeCreateRequestAdapter(this.oBW.ehp(), this.oBY, this.mPriority, this.oDc, this.oDd, this.oDe);
                this.oBW.ehl();
                if (this.oBZ != null && !nativeSetHttpMethod(this.oCF, this.oBZ)) {
                    throw new IllegalArgumentException("Invalid http method " + this.oBZ);
                }
                if (this.mTag != null) {
                    this.oBW.a(this);
                }
                if (this.oDf) {
                    nativeDisableResponseAutoUngzip(this.oCF);
                }
                if (this.oDg) {
                    nativeEnableBrotliByRequest(this.oCF);
                }
                if (this.oDh > 0) {
                    nativeSetTimeout(this.oCF, this.oDh);
                }
                if (this.oDi > 0) {
                    nativeSetTCPConnectTimeout(this.oCF, this.oDi);
                }
                if (this.oDj > 0) {
                    nativeSetResponseHeaderRecvTimeout(this.oCF, this.oDj);
                }
                if (this.oDk > 0) {
                    nativeSetResponseBodyReadTimeout(this.oCF, this.oDk);
                }
                if (!TextUtils.isEmpty(this.oDl)) {
                    nativeSetDestinationAddress(this.oCF, this.oDl);
                }
                if (!TextUtils.isEmpty(this.oDm)) {
                    nativeSetRequestTag(this.oCF, this.oDm);
                }
                Iterator<Map.Entry<String, String>> it = this.oDa.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    boolean z2 = (!next.getKey().equalsIgnoreCase("Content-Type") || next.getValue().isEmpty()) ? z : true;
                    if (!nativeAddRequestHeader(this.oCF, next.getKey(), next.getValue())) {
                        throw new IllegalArgumentException("Invalid header " + next.getKey() + "=" + next.getValue());
                    }
                    z = z2;
                }
                if (this.oDn != null) {
                    if (!z) {
                        throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
                    }
                    this.mStarted = true;
                    this.oDn.z(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CronetUrlRequest.this.oDn.ehf();
                            synchronized (CronetUrlRequest.this.oCJ) {
                                if (!CronetUrlRequest.this.egY()) {
                                    CronetUrlRequest.this.oDn.hU(CronetUrlRequest.this.oCF);
                                    CronetUrlRequest.this.ehg();
                                }
                            }
                        }
                    });
                    return;
                }
                this.mStarted = true;
                ehg();
            } catch (RuntimeException e) {
                Ad(false);
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public void ehg() {
        if (this.oCI != null) {
            this.oCI.ehl();
        }
        nativeStart(this.oCF);
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void ehh() {
        synchronized (this.oCJ) {
            if (!this.oCG) {
                throw new IllegalStateException("No redirect to follow.");
            }
            this.oCG = false;
            if (!egY()) {
                nativeFollowDeferredRedirect(this.oCF);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void n(ByteBuffer byteBuffer) {
        com.baidu.turbonet.net.b.p(byteBuffer);
        com.baidu.turbonet.net.b.o(byteBuffer);
        synchronized (this.oCJ) {
            if (!this.oCH) {
                throw new IllegalStateException("Unexpected read attempt.");
            }
            this.oCH = false;
            if (!egY()) {
                if (!nativeReadData(this.oCF, byteBuffer, byteBuffer.position(), byteBuffer.limit())) {
                    this.oCH = true;
                    throw new IllegalArgumentException("Unable to call native read");
                }
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void cancel() {
        synchronized (this.oCJ) {
            com.baidu.turbonet.base.a.f("ChromiumNetwork", "****** Request cancel, url is: %s", this.oBY);
            if (!egY() && this.mStarted) {
                Ad(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public boolean egY() {
        return this.mStarted && this.oCF == 0;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void ehi() {
        ehk();
        this.oDf = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void ehj() {
        ehk();
        this.oDg = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setTimeout(int i) {
        ehk();
        this.oDh = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Oe(int i) {
        ehk();
        this.oDi = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Of(int i) {
        ehk();
        this.oDj = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Og(int i) {
        ehk();
        this.oDk = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setTag(Object obj) {
        ehk();
        this.mTag = obj;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Xm(String str) {
        ehk();
        this.oDl = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Xn(String str) {
        ehk();
        this.oDm = str;
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
            Ad(false);
        }
    }

    private static int Oh(int i) {
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
        return new UrlResponseInfo(new ArrayList(this.oCK), i, str, headersList, z, str2, str3);
    }

    private void ehk() {
        synchronized (this.oCJ) {
            if (this.mStarted || egY()) {
                throw new IllegalStateException("Request is already started.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ad(boolean z) {
        synchronized (this.oCJ) {
            if (this.oCF != 0) {
                String nativeGetDNSNameServers = nativeGetDNSNameServers(this.oCF);
                if (!nativeGetDNSNameServers.isEmpty()) {
                    this.oCO = nativeGetDNSNameServers;
                }
                String nativeGetDNSResults = nativeGetDNSResults(this.oCF);
                if (!nativeGetDNSResults.isEmpty()) {
                    this.oCN = nativeGetDNSResults;
                }
                String nativeGetDNSErrorCode = nativeGetDNSErrorCode(this.oCF);
                if (!nativeGetDNSErrorCode.isEmpty()) {
                    this.oCP = nativeGetDNSErrorCode;
                }
                String nativeGetConnectionAttempts = nativeGetConnectionAttempts(this.oCF, false);
                if (!nativeGetConnectionAttempts.isEmpty()) {
                    this.oCQ = nativeGetConnectionAttempts;
                }
                String nativeGetConnectionAttempts2 = nativeGetConnectionAttempts(this.oCF, true);
                if (!nativeGetConnectionAttempts2.isEmpty()) {
                    this.oCR = nativeGetConnectionAttempts2;
                }
                String nativeGetRemoteEndpoint = nativeGetRemoteEndpoint(this.oCF);
                if (!nativeGetRemoteEndpoint.isEmpty()) {
                    this.oCS = nativeGetRemoteEndpoint;
                }
                String nativeGetSuperPipeInfo = nativeGetSuperPipeInfo(this.oCF);
                if (!nativeGetSuperPipeInfo.isEmpty()) {
                    this.oCT = nativeGetSuperPipeInfo;
                }
                long nativeRequestTimeGap = nativeRequestTimeGap(this.oCF, 1);
                if (nativeRequestTimeGap >= 0) {
                    this.oCU = nativeRequestTimeGap;
                }
                long nativeRequestTimeGap2 = nativeRequestTimeGap(this.oCF, 2);
                if (nativeRequestTimeGap2 >= 0) {
                    this.oCV = nativeRequestTimeGap2;
                }
                long nativeRequestTimeGap3 = nativeRequestTimeGap(this.oCF, 3);
                if (nativeRequestTimeGap3 >= 0) {
                    this.oCW = nativeRequestTimeGap3;
                }
                long nativeRequestTimeGap4 = nativeRequestTimeGap(this.oCF, 4);
                if (nativeRequestTimeGap4 >= 0) {
                    this.oCX = nativeRequestTimeGap4;
                }
                long nativeRequestTimeGap5 = nativeRequestTimeGap(this.oCF, 5);
                if (nativeRequestTimeGap5 >= 0) {
                    this.oCY = nativeRequestTimeGap5;
                }
                this.oCZ = nativeGetRequestTimeInfo(this.oCF);
                if (this.oCZ == null) {
                    this.oCZ = new RequestTimeInfo();
                }
                if (this.oCI != null) {
                    this.oCI.ehm();
                }
                nativeDestroy(this.oCF, z);
                if (this.mTag != null) {
                    this.oBW.b(this);
                }
                this.oBW.eho();
                this.oCF = 0L;
                if (this.oCk != null) {
                    this.oCk.run();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Exception exc) {
        UrlRequestException urlRequestException = new UrlRequestException("Exception received from UrlRequest.Callback", exc);
        com.baidu.turbonet.base.a.g("ChromiumNetwork", "Exception in CalledByNative method", exc);
        synchronized (this.oCJ) {
            if (!egY()) {
                Ad(false);
                try {
                    this.oCM.a(this, this.oCi, urlRequestException);
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
                synchronized (CronetUrlRequest.this.oCJ) {
                    if (!CronetUrlRequest.this.egY()) {
                        CronetUrlRequest.this.Ad(false);
                        try {
                            CronetUrlRequest.this.oCM.a(CronetUrlRequest.this, CronetUrlRequest.this.oCi, urlRequestException);
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
        this.oCL += j;
        a2.hW(this.oCL);
        this.oCK.add(str);
        z(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.oCJ) {
                    if (!CronetUrlRequest.this.egY()) {
                        CronetUrlRequest.this.oCG = true;
                        try {
                            CronetUrlRequest.this.oCM.a(CronetUrlRequest.this, a2, str);
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
        this.oCi = a(i, str, strArr, z, str2, str3);
        z(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.oCJ) {
                    if (!CronetUrlRequest.this.egY()) {
                        if (CronetUrlRequest.this.oCI != null) {
                            CronetUrlRequest.this.oCI.ehn();
                        }
                        CronetUrlRequest.this.oCH = true;
                        try {
                            CronetUrlRequest.this.oCM.a(CronetUrlRequest.this, CronetUrlRequest.this.oCi);
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
        this.oCi.hW(this.oCL + j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            a(new UrlRequestException("ByteBuffer modified externally during read", null));
            return;
        }
        if (this.oDo == null) {
            this.oDo = new a();
        }
        byteBuffer.position(i2 + i);
        this.oDo.mByteBuffer = byteBuffer;
        z(this.oDo);
    }

    @CalledByNative
    private void onSucceeded(long j) {
        this.oCi.hW(this.oCL + j);
        z(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.oCJ) {
                    if (!CronetUrlRequest.this.egY()) {
                        CronetUrlRequest.this.Ad(false);
                        try {
                            CronetUrlRequest.this.oCM.b(CronetUrlRequest.this, CronetUrlRequest.this.oCi);
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
        if (this.oCi != null) {
            this.oCi.hW(this.oCL + j);
        }
        a(new UrlRequestException("Exception in CronetUrlRequest: " + str, i, i2));
    }

    @CalledByNative
    private void onCanceled() {
        z(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.turbonet.base.a.g("ChromiumNetwork", "****** onCanceled, url is: %s", CronetUrlRequest.this.oCi.getUrl());
                    CronetUrlRequest.this.oCM.c(CronetUrlRequest.this, CronetUrlRequest.this.oCi);
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
                statusListener.Ox(UrlRequest.Status.Ow(i));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public final class b {
        @Nullable
        private Long oDv;
        @Nullable
        private Long oDw;
        @Nullable
        private Long oDx;

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ehl() {
            if (this.oDv != null) {
                throw new IllegalStateException("onRequestStarted called repeatedly");
            }
            this.oDv = Long.valueOf(SystemClock.elapsedRealtime());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ehm() {
            if (this.oDv != null && this.oDx == null) {
                this.oDx = Long.valueOf(SystemClock.elapsedRealtime() - this.oDv.longValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ehn() {
            if (this.oDv != null && this.oDw == null) {
                this.oDw = Long.valueOf(SystemClock.elapsedRealtime() - this.oDv.longValue());
            }
        }
    }
}
