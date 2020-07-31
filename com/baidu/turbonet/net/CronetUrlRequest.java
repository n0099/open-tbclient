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
    private static final TurbonetEngine.UrlRequestMetrics mHG = new TurbonetEngine.UrlRequestMetrics(null, null, null, null);
    private final Executor mExecutor;
    private final CronetUrlRequestContext mGY;
    @GuardedBy("mUrlRequestAdapterLock")
    private long mHH;
    @GuardedBy("mUrlRequestAdapterLock")
    @Nullable
    private final b mHK;
    private long mHN;
    private final UrlRequest.Callback mHO;
    private String mHP;
    private String mHQ;
    private String mHR;
    private String mHS;
    private String mHT;
    private String mHU;
    private String mHV;
    private long mHW;
    private long mHX;
    private long mHY;
    private long mHZ;
    private final String mHa;
    private String mHb;
    private UrlResponseInfo mHk;
    private Runnable mHm;
    private long mIa;
    private RequestTimeInfo mIb;
    private final Collection<Object> mIe;
    private final boolean mIf;
    private final boolean mIg;
    private final boolean mIh;
    private boolean mIi;
    private boolean mIj;
    private int mIk;
    private int mIl;
    private int mIm;
    private int mIn;
    private String mIo;
    private String mIq;
    private CronetUploadDataStream mIr;
    private a mIt;
    private final int mPriority;
    private Object mTag;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mStarted = false;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mHI = false;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mHJ = false;
    private final Object mHL = new Object();
    private final List<String> mHM = new ArrayList();
    private final HeadersList mIc = new HeadersList();

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
                synchronized (CronetUrlRequest.this.mHL) {
                    if (!CronetUrlRequest.this.dym()) {
                        CronetUrlRequest.this.mHJ = true;
                        CronetUrlRequest.this.mHO.a(CronetUrlRequest.this, CronetUrlRequest.this.mHk, byteBuffer);
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
        this.mGY = cronetUrlRequestContext;
        this.mHa = str;
        this.mHM.add(str);
        this.mPriority = HG(i);
        this.mHO = callback;
        this.mExecutor = executor;
        this.mIe = collection;
        this.mHK = z ? new b() : null;
        this.mIf = z2;
        this.mIg = z3;
        this.mIh = z4;
        this.mIi = false;
        this.mIj = false;
        this.mIk = 0;
        this.mIl = 0;
        this.mIm = 0;
        this.mIn = 0;
        this.mTag = null;
        this.mIo = null;
        this.mIq = null;
        this.mHk = new UrlResponseInfo(new ArrayList(this.mHM), 0, "", new HeadersList(), false, "", "");
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Qi(String str) {
        dyy();
        if (str == null) {
            throw new NullPointerException("Method is required.");
        }
        this.mHb = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void addHeader(String str, String str2) {
        dyy();
        if (str == null) {
            throw new NullPointerException("Invalid header name.");
        }
        if (str2 == null) {
            throw new NullPointerException("Invalid header value.");
        }
        this.mIc.add(new AbstractMap.SimpleImmutableEntry(str, str2));
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void a(UploadDataProvider uploadDataProvider, Executor executor) {
        if (uploadDataProvider == null) {
            throw new NullPointerException("Invalid UploadDataProvider.");
        }
        if (this.mHb == null) {
            this.mHb = "POST";
        }
        this.mIr = new CronetUploadDataStream(uploadDataProvider, executor, this);
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void start() {
        synchronized (this.mHL) {
            com.baidu.turbonet.base.a.g("ChromiumNetwork", "****** Request start, url is: %s", this.mHa);
            dyy();
            try {
                this.mHH = nativeCreateRequestAdapter(this.mGY.dyD(), this.mHa, this.mPriority, this.mIf, this.mIg, this.mIh);
                this.mGY.dyz();
                if (this.mHb != null && !nativeSetHttpMethod(this.mHH, this.mHb)) {
                    throw new IllegalArgumentException("Invalid http method " + this.mHb);
                }
                if (this.mTag != null) {
                    this.mGY.a(this);
                }
                if (this.mIi) {
                    nativeDisableResponseAutoUngzip(this.mHH);
                }
                if (this.mIj) {
                    nativeEnableBrotliByRequest(this.mHH);
                }
                if (this.mIk > 0) {
                    nativeSetTimeout(this.mHH, this.mIk);
                }
                if (this.mIl > 0) {
                    nativeSetTCPConnectTimeout(this.mHH, this.mIl);
                }
                if (this.mIm > 0) {
                    nativeSetResponseHeaderRecvTimeout(this.mHH, this.mIm);
                }
                if (this.mIn > 0) {
                    nativeSetResponseBodyReadTimeout(this.mHH, this.mIn);
                }
                if (!TextUtils.isEmpty(this.mIo)) {
                    nativeSetDestinationAddress(this.mHH, this.mIo);
                }
                if (!TextUtils.isEmpty(this.mIq)) {
                    nativeSetRequestTag(this.mHH, this.mIq);
                }
                Iterator<Map.Entry<String, String>> it = this.mIc.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    boolean z2 = (!next.getKey().equalsIgnoreCase("Content-Type") || next.getValue().isEmpty()) ? z : true;
                    if (!nativeAddRequestHeader(this.mHH, next.getKey(), next.getValue())) {
                        throw new IllegalArgumentException("Invalid header " + next.getKey() + ETAG.EQUAL + next.getValue());
                    }
                    z = z2;
                }
                if (this.mIr != null) {
                    if (!z) {
                        throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
                    }
                    this.mStarted = true;
                    this.mIr.B(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CronetUrlRequest.this.mIr.dyt();
                            synchronized (CronetUrlRequest.this.mHL) {
                                if (!CronetUrlRequest.this.dym()) {
                                    CronetUrlRequest.this.mIr.fP(CronetUrlRequest.this.mHH);
                                    CronetUrlRequest.this.dyu();
                                }
                            }
                        }
                    });
                    return;
                }
                this.mStarted = true;
                dyu();
            } catch (RuntimeException e) {
                wJ(false);
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public void dyu() {
        if (this.mHK != null) {
            this.mHK.dyz();
        }
        nativeStart(this.mHH);
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void dyv() {
        synchronized (this.mHL) {
            if (!this.mHI) {
                throw new IllegalStateException("No redirect to follow.");
            }
            this.mHI = false;
            if (!dym()) {
                nativeFollowDeferredRedirect(this.mHH);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void m(ByteBuffer byteBuffer) {
        com.baidu.turbonet.net.b.o(byteBuffer);
        com.baidu.turbonet.net.b.n(byteBuffer);
        synchronized (this.mHL) {
            if (!this.mHJ) {
                throw new IllegalStateException("Unexpected read attempt.");
            }
            this.mHJ = false;
            if (!dym()) {
                if (!nativeReadData(this.mHH, byteBuffer, byteBuffer.position(), byteBuffer.limit())) {
                    this.mHJ = true;
                    throw new IllegalArgumentException("Unable to call native read");
                }
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void cancel() {
        synchronized (this.mHL) {
            com.baidu.turbonet.base.a.g("ChromiumNetwork", "****** Request cancel, url is: %s", this.mHa);
            if (!dym() && this.mStarted) {
                wJ(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public boolean dym() {
        return this.mStarted && this.mHH == 0;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void dyw() {
        dyy();
        this.mIi = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void dyx() {
        dyy();
        this.mIj = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setTimeout(int i) {
        dyy();
        this.mIk = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void HD(int i) {
        dyy();
        this.mIl = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void HE(int i) {
        dyy();
        this.mIm = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void HF(int i) {
        dyy();
        this.mIn = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setTag(Object obj) {
        dyy();
        this.mTag = obj;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Qj(String str) {
        dyy();
        this.mIo = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void Qk(String str) {
        dyy();
        this.mIq = str;
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
        return new UrlResponseInfo(new ArrayList(this.mHM), i, str, headersList, z, str2, str3);
    }

    private void dyy() {
        synchronized (this.mHL) {
            if (this.mStarted || dym()) {
                throw new IllegalStateException("Request is already started.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wJ(boolean z) {
        synchronized (this.mHL) {
            if (this.mHH != 0) {
                String nativeGetDNSNameServers = nativeGetDNSNameServers(this.mHH);
                if (!nativeGetDNSNameServers.isEmpty()) {
                    this.mHQ = nativeGetDNSNameServers;
                }
                String nativeGetDNSResults = nativeGetDNSResults(this.mHH);
                if (!nativeGetDNSResults.isEmpty()) {
                    this.mHP = nativeGetDNSResults;
                }
                String nativeGetDNSErrorCode = nativeGetDNSErrorCode(this.mHH);
                if (!nativeGetDNSErrorCode.isEmpty()) {
                    this.mHR = nativeGetDNSErrorCode;
                }
                String nativeGetConnectionAttempts = nativeGetConnectionAttempts(this.mHH, false);
                if (!nativeGetConnectionAttempts.isEmpty()) {
                    this.mHS = nativeGetConnectionAttempts;
                }
                String nativeGetConnectionAttempts2 = nativeGetConnectionAttempts(this.mHH, true);
                if (!nativeGetConnectionAttempts2.isEmpty()) {
                    this.mHT = nativeGetConnectionAttempts2;
                }
                String nativeGetRemoteEndpoint = nativeGetRemoteEndpoint(this.mHH);
                if (!nativeGetRemoteEndpoint.isEmpty()) {
                    this.mHU = nativeGetRemoteEndpoint;
                }
                String nativeGetSuperPipeInfo = nativeGetSuperPipeInfo(this.mHH);
                if (!nativeGetSuperPipeInfo.isEmpty()) {
                    this.mHV = nativeGetSuperPipeInfo;
                }
                long nativeRequestTimeGap = nativeRequestTimeGap(this.mHH, 1);
                if (nativeRequestTimeGap >= 0) {
                    this.mHW = nativeRequestTimeGap;
                }
                long nativeRequestTimeGap2 = nativeRequestTimeGap(this.mHH, 2);
                if (nativeRequestTimeGap2 >= 0) {
                    this.mHX = nativeRequestTimeGap2;
                }
                long nativeRequestTimeGap3 = nativeRequestTimeGap(this.mHH, 3);
                if (nativeRequestTimeGap3 >= 0) {
                    this.mHY = nativeRequestTimeGap3;
                }
                long nativeRequestTimeGap4 = nativeRequestTimeGap(this.mHH, 4);
                if (nativeRequestTimeGap4 >= 0) {
                    this.mHZ = nativeRequestTimeGap4;
                }
                long nativeRequestTimeGap5 = nativeRequestTimeGap(this.mHH, 5);
                if (nativeRequestTimeGap5 >= 0) {
                    this.mIa = nativeRequestTimeGap5;
                }
                this.mIb = nativeGetRequestTimeInfo(this.mHH);
                if (this.mIb == null) {
                    this.mIb = new RequestTimeInfo();
                }
                if (this.mHK != null) {
                    this.mHK.dyA();
                }
                nativeDestroy(this.mHH, z);
                if (this.mTag != null) {
                    this.mGY.b(this);
                }
                this.mGY.dyC();
                this.mHH = 0L;
                if (this.mHm != null) {
                    this.mHm.run();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Exception exc) {
        UrlRequestException urlRequestException = new UrlRequestException("Exception received from UrlRequest.Callback", exc);
        com.baidu.turbonet.base.a.h("ChromiumNetwork", "Exception in CalledByNative method", exc);
        synchronized (this.mHL) {
            if (!dym()) {
                wJ(false);
                try {
                    this.mHO.a(this, this.mHk, urlRequestException);
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
                synchronized (CronetUrlRequest.this.mHL) {
                    if (!CronetUrlRequest.this.dym()) {
                        CronetUrlRequest.this.wJ(false);
                        try {
                            CronetUrlRequest.this.mHO.a(CronetUrlRequest.this, CronetUrlRequest.this.mHk, urlRequestException);
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
        this.mHN += j;
        a2.fR(this.mHN);
        this.mHM.add(str);
        B(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.mHL) {
                    if (!CronetUrlRequest.this.dym()) {
                        CronetUrlRequest.this.mHI = true;
                        try {
                            CronetUrlRequest.this.mHO.a(CronetUrlRequest.this, a2, str);
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
        this.mHk = a(i, str, strArr, z, str2, str3);
        B(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.mHL) {
                    if (!CronetUrlRequest.this.dym()) {
                        if (CronetUrlRequest.this.mHK != null) {
                            CronetUrlRequest.this.mHK.dyB();
                        }
                        CronetUrlRequest.this.mHJ = true;
                        try {
                            CronetUrlRequest.this.mHO.a(CronetUrlRequest.this, CronetUrlRequest.this.mHk);
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
        this.mHk.fR(this.mHN + j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            a(new UrlRequestException("ByteBuffer modified externally during read", null));
            return;
        }
        if (this.mIt == null) {
            this.mIt = new a();
        }
        byteBuffer.position(i2 + i);
        this.mIt.mByteBuffer = byteBuffer;
        B(this.mIt);
    }

    @CalledByNative
    private void onSucceeded(long j) {
        this.mHk.fR(this.mHN + j);
        B(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.mHL) {
                    if (!CronetUrlRequest.this.dym()) {
                        CronetUrlRequest.this.wJ(false);
                        try {
                            CronetUrlRequest.this.mHO.b(CronetUrlRequest.this, CronetUrlRequest.this.mHk);
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
        if (this.mHk != null) {
            this.mHk.fR(this.mHN + j);
        }
        a(new UrlRequestException("Exception in CronetUrlRequest: " + str, i, i2));
    }

    @CalledByNative
    private void onCanceled() {
        B(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.turbonet.base.a.h("ChromiumNetwork", "****** onCanceled, url is: %s", CronetUrlRequest.this.mHk.getUrl());
                    CronetUrlRequest.this.mHO.c(CronetUrlRequest.this, CronetUrlRequest.this.mHk);
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
        private Long mIA;
        @Nullable
        private Long mIB;
        @Nullable
        private Long mIC;

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dyz() {
            if (this.mIA != null) {
                throw new IllegalStateException("onRequestStarted called repeatedly");
            }
            this.mIA = Long.valueOf(SystemClock.elapsedRealtime());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dyA() {
            if (this.mIA != null && this.mIC == null) {
                this.mIC = Long.valueOf(SystemClock.elapsedRealtime() - this.mIA.longValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dyB() {
            if (this.mIA != null && this.mIB == null) {
                this.mIB = Long.valueOf(SystemClock.elapsedRealtime() - this.mIA.longValue());
            }
        }
    }
}
