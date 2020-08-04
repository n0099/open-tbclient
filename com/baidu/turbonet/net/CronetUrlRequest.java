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
/* loaded from: classes19.dex */
public final class CronetUrlRequest implements UrlRequest {
    private static final TurbonetEngine.UrlRequestMetrics mHI = new TurbonetEngine.UrlRequestMetrics(null, null, null, null);
    private final Executor mExecutor;
    @GuardedBy("mUrlRequestAdapterLock")
    private long mHJ;
    @GuardedBy("mUrlRequestAdapterLock")
    @Nullable
    private final b mHM;
    private long mHP;
    private final UrlRequest.Callback mHQ;
    private String mHR;
    private String mHS;
    private String mHT;
    private String mHU;
    private String mHV;
    private String mHW;
    private String mHX;
    private long mHY;
    private long mHZ;
    private final CronetUrlRequestContext mHa;
    private final String mHc;
    private String mHd;
    private UrlResponseInfo mHm;
    private Runnable mHo;
    private long mIa;
    private long mIb;
    private long mIc;
    private RequestTimeInfo mIe;
    private final Collection<Object> mIg;
    private final boolean mIh;
    private final boolean mIi;
    private final boolean mIj;
    private boolean mIk;
    private boolean mIl;
    private int mIm;
    private int mIn;
    private int mIo;
    private int mIq;
    private String mIr;
    private String mIt;
    private CronetUploadDataStream mIu;
    private a mIv;
    private final int mPriority;
    private Object mTag;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mStarted = false;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mHK = false;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mHL = false;
    private final Object mHN = new Object();
    private final List<String> mHO = new ArrayList();
    private final HeadersList mIf = new HeadersList();

    /* loaded from: classes19.dex */
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
    /* loaded from: classes19.dex */
    public static final class HeadersList extends ArrayList<Map.Entry<String, String>> {
        private HeadersList() {
        }
    }

    /* loaded from: classes19.dex */
    private final class a implements Runnable {
        ByteBuffer mByteBuffer;

        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ByteBuffer byteBuffer = this.mByteBuffer;
            this.mByteBuffer = null;
            try {
                synchronized (CronetUrlRequest.this.mHN) {
                    if (!CronetUrlRequest.this.dyn()) {
                        CronetUrlRequest.this.mHL = true;
                        CronetUrlRequest.this.mHQ.a(CronetUrlRequest.this, CronetUrlRequest.this.mHm, byteBuffer);
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
        this.mHa = cronetUrlRequestContext;
        this.mHc = str;
        this.mHO.add(str);
        this.mPriority = HG(i);
        this.mHQ = callback;
        this.mExecutor = executor;
        this.mIg = collection;
        this.mHM = z ? new b() : null;
        this.mIh = z2;
        this.mIi = z3;
        this.mIj = z4;
        this.mIk = false;
        this.mIl = false;
        this.mIm = 0;
        this.mIn = 0;
        this.mIo = 0;
        this.mIq = 0;
        this.mTag = null;
        this.mIr = null;
        this.mIt = null;
        this.mHm = new UrlResponseInfo(new ArrayList(this.mHO), 0, "", new HeadersList(), false, "", "");
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Qi(String str) {
        dyz();
        if (str == null) {
            throw new NullPointerException("Method is required.");
        }
        this.mHd = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void addHeader(String str, String str2) {
        dyz();
        if (str == null) {
            throw new NullPointerException("Invalid header name.");
        }
        if (str2 == null) {
            throw new NullPointerException("Invalid header value.");
        }
        this.mIf.add(new AbstractMap.SimpleImmutableEntry(str, str2));
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void a(UploadDataProvider uploadDataProvider, Executor executor) {
        if (uploadDataProvider == null) {
            throw new NullPointerException("Invalid UploadDataProvider.");
        }
        if (this.mHd == null) {
            this.mHd = "POST";
        }
        this.mIu = new CronetUploadDataStream(uploadDataProvider, executor, this);
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void start() {
        synchronized (this.mHN) {
            com.baidu.turbonet.base.a.g("ChromiumNetwork", "****** Request start, url is: %s", this.mHc);
            dyz();
            try {
                this.mHJ = nativeCreateRequestAdapter(this.mHa.dyE(), this.mHc, this.mPriority, this.mIh, this.mIi, this.mIj);
                this.mHa.dyA();
                if (this.mHd != null && !nativeSetHttpMethod(this.mHJ, this.mHd)) {
                    throw new IllegalArgumentException("Invalid http method " + this.mHd);
                }
                if (this.mTag != null) {
                    this.mHa.a(this);
                }
                if (this.mIk) {
                    nativeDisableResponseAutoUngzip(this.mHJ);
                }
                if (this.mIl) {
                    nativeEnableBrotliByRequest(this.mHJ);
                }
                if (this.mIm > 0) {
                    nativeSetTimeout(this.mHJ, this.mIm);
                }
                if (this.mIn > 0) {
                    nativeSetTCPConnectTimeout(this.mHJ, this.mIn);
                }
                if (this.mIo > 0) {
                    nativeSetResponseHeaderRecvTimeout(this.mHJ, this.mIo);
                }
                if (this.mIq > 0) {
                    nativeSetResponseBodyReadTimeout(this.mHJ, this.mIq);
                }
                if (!TextUtils.isEmpty(this.mIr)) {
                    nativeSetDestinationAddress(this.mHJ, this.mIr);
                }
                if (!TextUtils.isEmpty(this.mIt)) {
                    nativeSetRequestTag(this.mHJ, this.mIt);
                }
                Iterator<Map.Entry<String, String>> it = this.mIf.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    boolean z2 = (!next.getKey().equalsIgnoreCase("Content-Type") || next.getValue().isEmpty()) ? z : true;
                    if (!nativeAddRequestHeader(this.mHJ, next.getKey(), next.getValue())) {
                        throw new IllegalArgumentException("Invalid header " + next.getKey() + ETAG.EQUAL + next.getValue());
                    }
                    z = z2;
                }
                if (this.mIu != null) {
                    if (!z) {
                        throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
                    }
                    this.mStarted = true;
                    this.mIu.B(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CronetUrlRequest.this.mIu.dyu();
                            synchronized (CronetUrlRequest.this.mHN) {
                                if (!CronetUrlRequest.this.dyn()) {
                                    CronetUrlRequest.this.mIu.fP(CronetUrlRequest.this.mHJ);
                                    CronetUrlRequest.this.dyv();
                                }
                            }
                        }
                    });
                    return;
                }
                this.mStarted = true;
                dyv();
            } catch (RuntimeException e) {
                wJ(false);
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public void dyv() {
        if (this.mHM != null) {
            this.mHM.dyA();
        }
        nativeStart(this.mHJ);
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void dyw() {
        synchronized (this.mHN) {
            if (!this.mHK) {
                throw new IllegalStateException("No redirect to follow.");
            }
            this.mHK = false;
            if (!dyn()) {
                nativeFollowDeferredRedirect(this.mHJ);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void m(ByteBuffer byteBuffer) {
        com.baidu.turbonet.net.b.o(byteBuffer);
        com.baidu.turbonet.net.b.n(byteBuffer);
        synchronized (this.mHN) {
            if (!this.mHL) {
                throw new IllegalStateException("Unexpected read attempt.");
            }
            this.mHL = false;
            if (!dyn()) {
                if (!nativeReadData(this.mHJ, byteBuffer, byteBuffer.position(), byteBuffer.limit())) {
                    this.mHL = true;
                    throw new IllegalArgumentException("Unable to call native read");
                }
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void cancel() {
        synchronized (this.mHN) {
            com.baidu.turbonet.base.a.g("ChromiumNetwork", "****** Request cancel, url is: %s", this.mHc);
            if (!dyn() && this.mStarted) {
                wJ(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public boolean dyn() {
        return this.mStarted && this.mHJ == 0;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void dyx() {
        dyz();
        this.mIk = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void dyy() {
        dyz();
        this.mIl = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setTimeout(int i) {
        dyz();
        this.mIm = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void HD(int i) {
        dyz();
        this.mIn = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void HE(int i) {
        dyz();
        this.mIo = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void HF(int i) {
        dyz();
        this.mIq = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setTag(Object obj) {
        dyz();
        this.mTag = obj;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Qj(String str) {
        dyz();
        this.mIr = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Qk(String str) {
        dyz();
        this.mIt = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public Object getTag() {
        return this.mTag;
    }

    @CalledByNative
    public static RequestTimeInfo createObject(long j, long j2, long j3, long j4, long j5) {
        return new RequestTimeInfo(j, j2, j3, j4, j5);
    }

    private void B(Runnable runnable) {
        try {
            this.mExecutor.execute(runnable);
        } catch (RejectedExecutionException e) {
            com.baidu.turbonet.base.a.h("ChromiumNetwork", "Exception posting task to executor", e);
            wJ(false);
        }
    }

    private static int HG(int i) {
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
        return new UrlResponseInfo(new ArrayList(this.mHO), i, str, headersList, z, str2, str3);
    }

    private void dyz() {
        synchronized (this.mHN) {
            if (this.mStarted || dyn()) {
                throw new IllegalStateException("Request is already started.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wJ(boolean z) {
        synchronized (this.mHN) {
            if (this.mHJ != 0) {
                String nativeGetDNSNameServers = nativeGetDNSNameServers(this.mHJ);
                if (!nativeGetDNSNameServers.isEmpty()) {
                    this.mHS = nativeGetDNSNameServers;
                }
                String nativeGetDNSResults = nativeGetDNSResults(this.mHJ);
                if (!nativeGetDNSResults.isEmpty()) {
                    this.mHR = nativeGetDNSResults;
                }
                String nativeGetDNSErrorCode = nativeGetDNSErrorCode(this.mHJ);
                if (!nativeGetDNSErrorCode.isEmpty()) {
                    this.mHT = nativeGetDNSErrorCode;
                }
                String nativeGetConnectionAttempts = nativeGetConnectionAttempts(this.mHJ, false);
                if (!nativeGetConnectionAttempts.isEmpty()) {
                    this.mHU = nativeGetConnectionAttempts;
                }
                String nativeGetConnectionAttempts2 = nativeGetConnectionAttempts(this.mHJ, true);
                if (!nativeGetConnectionAttempts2.isEmpty()) {
                    this.mHV = nativeGetConnectionAttempts2;
                }
                String nativeGetRemoteEndpoint = nativeGetRemoteEndpoint(this.mHJ);
                if (!nativeGetRemoteEndpoint.isEmpty()) {
                    this.mHW = nativeGetRemoteEndpoint;
                }
                String nativeGetSuperPipeInfo = nativeGetSuperPipeInfo(this.mHJ);
                if (!nativeGetSuperPipeInfo.isEmpty()) {
                    this.mHX = nativeGetSuperPipeInfo;
                }
                long nativeRequestTimeGap = nativeRequestTimeGap(this.mHJ, 1);
                if (nativeRequestTimeGap >= 0) {
                    this.mHY = nativeRequestTimeGap;
                }
                long nativeRequestTimeGap2 = nativeRequestTimeGap(this.mHJ, 2);
                if (nativeRequestTimeGap2 >= 0) {
                    this.mHZ = nativeRequestTimeGap2;
                }
                long nativeRequestTimeGap3 = nativeRequestTimeGap(this.mHJ, 3);
                if (nativeRequestTimeGap3 >= 0) {
                    this.mIa = nativeRequestTimeGap3;
                }
                long nativeRequestTimeGap4 = nativeRequestTimeGap(this.mHJ, 4);
                if (nativeRequestTimeGap4 >= 0) {
                    this.mIb = nativeRequestTimeGap4;
                }
                long nativeRequestTimeGap5 = nativeRequestTimeGap(this.mHJ, 5);
                if (nativeRequestTimeGap5 >= 0) {
                    this.mIc = nativeRequestTimeGap5;
                }
                this.mIe = nativeGetRequestTimeInfo(this.mHJ);
                if (this.mIe == null) {
                    this.mIe = new RequestTimeInfo();
                }
                if (this.mHM != null) {
                    this.mHM.dyB();
                }
                nativeDestroy(this.mHJ, z);
                if (this.mTag != null) {
                    this.mHa.b(this);
                }
                this.mHa.dyD();
                this.mHJ = 0L;
                if (this.mHo != null) {
                    this.mHo.run();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Exception exc) {
        UrlRequestException urlRequestException = new UrlRequestException("Exception received from UrlRequest.Callback", exc);
        com.baidu.turbonet.base.a.h("ChromiumNetwork", "Exception in CalledByNative method", exc);
        synchronized (this.mHN) {
            if (!dyn()) {
                wJ(false);
                try {
                    this.mHQ.a(this, this.mHm, urlRequestException);
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
        B(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.mHN) {
                    if (!CronetUrlRequest.this.dyn()) {
                        CronetUrlRequest.this.wJ(false);
                        try {
                            CronetUrlRequest.this.mHQ.a(CronetUrlRequest.this, CronetUrlRequest.this.mHm, urlRequestException);
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
        this.mHP += j;
        a2.fR(this.mHP);
        this.mHO.add(str);
        B(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.mHN) {
                    if (!CronetUrlRequest.this.dyn()) {
                        CronetUrlRequest.this.mHK = true;
                        try {
                            CronetUrlRequest.this.mHQ.a(CronetUrlRequest.this, a2, str);
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
        this.mHm = a(i, str, strArr, z, str2, str3);
        B(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.mHN) {
                    if (!CronetUrlRequest.this.dyn()) {
                        if (CronetUrlRequest.this.mHM != null) {
                            CronetUrlRequest.this.mHM.dyC();
                        }
                        CronetUrlRequest.this.mHL = true;
                        try {
                            CronetUrlRequest.this.mHQ.a(CronetUrlRequest.this, CronetUrlRequest.this.mHm);
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
        this.mHm.fR(this.mHP + j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            a(new UrlRequestException("ByteBuffer modified externally during read", null));
            return;
        }
        if (this.mIv == null) {
            this.mIv = new a();
        }
        byteBuffer.position(i2 + i);
        this.mIv.mByteBuffer = byteBuffer;
        B(this.mIv);
    }

    @CalledByNative
    private void onSucceeded(long j) {
        this.mHm.fR(this.mHP + j);
        B(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.mHN) {
                    if (!CronetUrlRequest.this.dyn()) {
                        CronetUrlRequest.this.wJ(false);
                        try {
                            CronetUrlRequest.this.mHQ.b(CronetUrlRequest.this, CronetUrlRequest.this.mHm);
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
        if (this.mHm != null) {
            this.mHm.fR(this.mHP + j);
        }
        a(new UrlRequestException("Exception in CronetUrlRequest: " + str, i, i2));
    }

    @CalledByNative
    private void onCanceled() {
        B(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.turbonet.base.a.h("ChromiumNetwork", "****** onCanceled, url is: %s", CronetUrlRequest.this.mHm.getUrl());
                    CronetUrlRequest.this.mHQ.c(CronetUrlRequest.this, CronetUrlRequest.this.mHm);
                } catch (Exception e) {
                    com.baidu.turbonet.base.a.h("ChromiumNetwork", "Exception in onCanceled method", e);
                }
            }
        });
    }

    @CalledByNative
    private void onStatus(final UrlRequest.StatusListener statusListener, final int i) {
        B(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.7
            @Override // java.lang.Runnable
            public void run() {
                statusListener.HW(UrlRequest.Status.HV(i));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public final class b {
        @Nullable
        private Long mIC;
        @Nullable
        private Long mIE;
        @Nullable
        private Long mIF;

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dyA() {
            if (this.mIC != null) {
                throw new IllegalStateException("onRequestStarted called repeatedly");
            }
            this.mIC = Long.valueOf(SystemClock.elapsedRealtime());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dyB() {
            if (this.mIC != null && this.mIF == null) {
                this.mIF = Long.valueOf(SystemClock.elapsedRealtime() - this.mIC.longValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dyC() {
            if (this.mIC != null && this.mIE == null) {
                this.mIE = Long.valueOf(SystemClock.elapsedRealtime() - this.mIC.longValue());
            }
        }
    }
}
