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
/* loaded from: classes15.dex */
public final class CronetUrlRequest implements UrlRequest {
    private static final TurbonetEngine.UrlRequestMetrics nkY = new TurbonetEngine.UrlRequestMetrics(null, null, null, null);
    private final Executor mExecutor;
    private final int mPriority;
    private Object mTag;
    private UrlResponseInfo nkC;
    private Runnable nkE;
    @GuardedBy("mUrlRequestAdapterLock")
    private long nkZ;
    private final CronetUrlRequestContext nkq;
    private final String nks;
    private String nkt;
    private boolean nlA;
    private int nlB;
    private int nlC;
    private int nlD;
    private int nlE;
    private String nlF;
    private String nlG;
    private CronetUploadDataStream nlH;
    private a nlI;
    @GuardedBy("mUrlRequestAdapterLock")
    @Nullable
    private final b nlc;
    private long nlf;
    private final UrlRequest.Callback nlg;
    private String nlh;
    private String nli;
    private String nlj;
    private String nlk;
    private String nll;
    private String nlm;
    private String nln;
    private long nlo;
    private long nlp;
    private long nlq;
    private long nlr;
    private long nls;
    private RequestTimeInfo nlt;
    private final Collection<Object> nlv;
    private final boolean nlw;
    private final boolean nlx;
    private final boolean nly;
    private boolean nlz;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mStarted = false;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean nla = false;
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean nlb = false;
    private final Object nld = new Object();
    private final List<String> nle = new ArrayList();
    private final HeadersList nlu = new HeadersList();

    /* loaded from: classes15.dex */
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
    /* loaded from: classes15.dex */
    public static final class HeadersList extends ArrayList<Map.Entry<String, String>> {
        private HeadersList() {
        }
    }

    /* loaded from: classes15.dex */
    private final class a implements Runnable {
        ByteBuffer mByteBuffer;

        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ByteBuffer byteBuffer = this.mByteBuffer;
            this.mByteBuffer = null;
            try {
                synchronized (CronetUrlRequest.this.nld) {
                    if (!CronetUrlRequest.this.dOh()) {
                        CronetUrlRequest.this.nlb = true;
                        CronetUrlRequest.this.nlg.a(CronetUrlRequest.this, CronetUrlRequest.this.nkC, byteBuffer);
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
        this.nkq = cronetUrlRequestContext;
        this.nks = str;
        this.nle.add(str);
        this.mPriority = KL(i);
        this.nlg = callback;
        this.mExecutor = executor;
        this.nlv = collection;
        this.nlc = z ? new b() : null;
        this.nlw = z2;
        this.nlx = z3;
        this.nly = z4;
        this.nlz = false;
        this.nlA = false;
        this.nlB = 0;
        this.nlC = 0;
        this.nlD = 0;
        this.nlE = 0;
        this.mTag = null;
        this.nlF = null;
        this.nlG = null;
        this.nkC = new UrlResponseInfo(new ArrayList(this.nle), 0, "", new HeadersList(), false, "", "");
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void TG(String str) {
        dOt();
        if (str == null) {
            throw new NullPointerException("Method is required.");
        }
        this.nkt = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void addHeader(String str, String str2) {
        dOt();
        if (str == null) {
            throw new NullPointerException("Invalid header name.");
        }
        if (str2 == null) {
            throw new NullPointerException("Invalid header value.");
        }
        this.nlu.add(new AbstractMap.SimpleImmutableEntry(str, str2));
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void a(UploadDataProvider uploadDataProvider, Executor executor) {
        if (uploadDataProvider == null) {
            throw new NullPointerException("Invalid UploadDataProvider.");
        }
        if (this.nkt == null) {
            this.nkt = "POST";
        }
        this.nlH = new CronetUploadDataStream(uploadDataProvider, executor, this);
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void start() {
        synchronized (this.nld) {
            com.baidu.turbonet.base.a.f("ChromiumNetwork", "****** Request start, url is: %s", this.nks);
            dOt();
            try {
                this.nkZ = nativeCreateRequestAdapter(this.nkq.dOy(), this.nks, this.mPriority, this.nlw, this.nlx, this.nly);
                this.nkq.dOu();
                if (this.nkt != null && !nativeSetHttpMethod(this.nkZ, this.nkt)) {
                    throw new IllegalArgumentException("Invalid http method " + this.nkt);
                }
                if (this.mTag != null) {
                    this.nkq.a(this);
                }
                if (this.nlz) {
                    nativeDisableResponseAutoUngzip(this.nkZ);
                }
                if (this.nlA) {
                    nativeEnableBrotliByRequest(this.nkZ);
                }
                if (this.nlB > 0) {
                    nativeSetTimeout(this.nkZ, this.nlB);
                }
                if (this.nlC > 0) {
                    nativeSetTCPConnectTimeout(this.nkZ, this.nlC);
                }
                if (this.nlD > 0) {
                    nativeSetResponseHeaderRecvTimeout(this.nkZ, this.nlD);
                }
                if (this.nlE > 0) {
                    nativeSetResponseBodyReadTimeout(this.nkZ, this.nlE);
                }
                if (!TextUtils.isEmpty(this.nlF)) {
                    nativeSetDestinationAddress(this.nkZ, this.nlF);
                }
                if (!TextUtils.isEmpty(this.nlG)) {
                    nativeSetRequestTag(this.nkZ, this.nlG);
                }
                Iterator<Map.Entry<String, String>> it = this.nlu.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    boolean z2 = (!next.getKey().equalsIgnoreCase("Content-Type") || next.getValue().isEmpty()) ? z : true;
                    if (!nativeAddRequestHeader(this.nkZ, next.getKey(), next.getValue())) {
                        throw new IllegalArgumentException("Invalid header " + next.getKey() + ETAG.EQUAL + next.getValue());
                    }
                    z = z2;
                }
                if (this.nlH != null) {
                    if (!z) {
                        throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
                    }
                    this.mStarted = true;
                    this.nlH.y(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CronetUrlRequest.this.nlH.dOo();
                            synchronized (CronetUrlRequest.this.nld) {
                                if (!CronetUrlRequest.this.dOh()) {
                                    CronetUrlRequest.this.nlH.gr(CronetUrlRequest.this.nkZ);
                                    CronetUrlRequest.this.dOp();
                                }
                            }
                        }
                    });
                    return;
                }
                this.mStarted = true;
                dOp();
            } catch (RuntimeException e) {
                xK(false);
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public void dOp() {
        if (this.nlc != null) {
            this.nlc.dOu();
        }
        nativeStart(this.nkZ);
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void dOq() {
        synchronized (this.nld) {
            if (!this.nla) {
                throw new IllegalStateException("No redirect to follow.");
            }
            this.nla = false;
            if (!dOh()) {
                nativeFollowDeferredRedirect(this.nkZ);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void m(ByteBuffer byteBuffer) {
        com.baidu.turbonet.net.b.o(byteBuffer);
        com.baidu.turbonet.net.b.n(byteBuffer);
        synchronized (this.nld) {
            if (!this.nlb) {
                throw new IllegalStateException("Unexpected read attempt.");
            }
            this.nlb = false;
            if (!dOh()) {
                if (!nativeReadData(this.nkZ, byteBuffer, byteBuffer.position(), byteBuffer.limit())) {
                    this.nlb = true;
                    throw new IllegalArgumentException("Unable to call native read");
                }
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void cancel() {
        synchronized (this.nld) {
            com.baidu.turbonet.base.a.f("ChromiumNetwork", "****** Request cancel, url is: %s", this.nks);
            if (!dOh() && this.mStarted) {
                xK(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public boolean dOh() {
        return this.mStarted && this.nkZ == 0;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void dOr() {
        dOt();
        this.nlz = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void dOs() {
        dOt();
        this.nlA = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setTimeout(int i) {
        dOt();
        this.nlB = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void KI(int i) {
        dOt();
        this.nlC = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void KJ(int i) {
        dOt();
        this.nlD = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void KK(int i) {
        dOt();
        this.nlE = i;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void setTag(Object obj) {
        dOt();
        this.mTag = obj;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void TH(String str) {
        dOt();
        this.nlF = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void TI(String str) {
        dOt();
        this.nlG = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public Object getTag() {
        return this.mTag;
    }

    @CalledByNative
    public static RequestTimeInfo createObject(long j, long j2, long j3, long j4, long j5) {
        return new RequestTimeInfo(j, j2, j3, j4, j5);
    }

    private void y(Runnable runnable) {
        try {
            this.mExecutor.execute(runnable);
        } catch (RejectedExecutionException e) {
            com.baidu.turbonet.base.a.g("ChromiumNetwork", "Exception posting task to executor", e);
            xK(false);
        }
    }

    private static int KL(int i) {
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
        return new UrlResponseInfo(new ArrayList(this.nle), i, str, headersList, z, str2, str3);
    }

    private void dOt() {
        synchronized (this.nld) {
            if (this.mStarted || dOh()) {
                throw new IllegalStateException("Request is already started.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xK(boolean z) {
        synchronized (this.nld) {
            if (this.nkZ != 0) {
                String nativeGetDNSNameServers = nativeGetDNSNameServers(this.nkZ);
                if (!nativeGetDNSNameServers.isEmpty()) {
                    this.nli = nativeGetDNSNameServers;
                }
                String nativeGetDNSResults = nativeGetDNSResults(this.nkZ);
                if (!nativeGetDNSResults.isEmpty()) {
                    this.nlh = nativeGetDNSResults;
                }
                String nativeGetDNSErrorCode = nativeGetDNSErrorCode(this.nkZ);
                if (!nativeGetDNSErrorCode.isEmpty()) {
                    this.nlj = nativeGetDNSErrorCode;
                }
                String nativeGetConnectionAttempts = nativeGetConnectionAttempts(this.nkZ, false);
                if (!nativeGetConnectionAttempts.isEmpty()) {
                    this.nlk = nativeGetConnectionAttempts;
                }
                String nativeGetConnectionAttempts2 = nativeGetConnectionAttempts(this.nkZ, true);
                if (!nativeGetConnectionAttempts2.isEmpty()) {
                    this.nll = nativeGetConnectionAttempts2;
                }
                String nativeGetRemoteEndpoint = nativeGetRemoteEndpoint(this.nkZ);
                if (!nativeGetRemoteEndpoint.isEmpty()) {
                    this.nlm = nativeGetRemoteEndpoint;
                }
                String nativeGetSuperPipeInfo = nativeGetSuperPipeInfo(this.nkZ);
                if (!nativeGetSuperPipeInfo.isEmpty()) {
                    this.nln = nativeGetSuperPipeInfo;
                }
                long nativeRequestTimeGap = nativeRequestTimeGap(this.nkZ, 1);
                if (nativeRequestTimeGap >= 0) {
                    this.nlo = nativeRequestTimeGap;
                }
                long nativeRequestTimeGap2 = nativeRequestTimeGap(this.nkZ, 2);
                if (nativeRequestTimeGap2 >= 0) {
                    this.nlp = nativeRequestTimeGap2;
                }
                long nativeRequestTimeGap3 = nativeRequestTimeGap(this.nkZ, 3);
                if (nativeRequestTimeGap3 >= 0) {
                    this.nlq = nativeRequestTimeGap3;
                }
                long nativeRequestTimeGap4 = nativeRequestTimeGap(this.nkZ, 4);
                if (nativeRequestTimeGap4 >= 0) {
                    this.nlr = nativeRequestTimeGap4;
                }
                long nativeRequestTimeGap5 = nativeRequestTimeGap(this.nkZ, 5);
                if (nativeRequestTimeGap5 >= 0) {
                    this.nls = nativeRequestTimeGap5;
                }
                this.nlt = nativeGetRequestTimeInfo(this.nkZ);
                if (this.nlt == null) {
                    this.nlt = new RequestTimeInfo();
                }
                if (this.nlc != null) {
                    this.nlc.dOv();
                }
                nativeDestroy(this.nkZ, z);
                if (this.mTag != null) {
                    this.nkq.b(this);
                }
                this.nkq.dOx();
                this.nkZ = 0L;
                if (this.nkE != null) {
                    this.nkE.run();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Exception exc) {
        UrlRequestException urlRequestException = new UrlRequestException("Exception received from UrlRequest.Callback", exc);
        com.baidu.turbonet.base.a.g("ChromiumNetwork", "Exception in CalledByNative method", exc);
        synchronized (this.nld) {
            if (!dOh()) {
                xK(false);
                try {
                    this.nlg.a(this, this.nkC, urlRequestException);
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
        y(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.nld) {
                    if (!CronetUrlRequest.this.dOh()) {
                        CronetUrlRequest.this.xK(false);
                        try {
                            CronetUrlRequest.this.nlg.a(CronetUrlRequest.this, CronetUrlRequest.this.nkC, urlRequestException);
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
        this.nlf += j;
        a2.gt(this.nlf);
        this.nle.add(str);
        y(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.nld) {
                    if (!CronetUrlRequest.this.dOh()) {
                        CronetUrlRequest.this.nla = true;
                        try {
                            CronetUrlRequest.this.nlg.a(CronetUrlRequest.this, a2, str);
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
        this.nkC = a(i, str, strArr, z, str2, str3);
        y(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.nld) {
                    if (!CronetUrlRequest.this.dOh()) {
                        if (CronetUrlRequest.this.nlc != null) {
                            CronetUrlRequest.this.nlc.dOw();
                        }
                        CronetUrlRequest.this.nlb = true;
                        try {
                            CronetUrlRequest.this.nlg.a(CronetUrlRequest.this, CronetUrlRequest.this.nkC);
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
        this.nkC.gt(this.nlf + j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            a(new UrlRequestException("ByteBuffer modified externally during read", null));
            return;
        }
        if (this.nlI == null) {
            this.nlI = new a();
        }
        byteBuffer.position(i2 + i);
        this.nlI.mByteBuffer = byteBuffer;
        y(this.nlI);
    }

    @CalledByNative
    private void onSucceeded(long j) {
        this.nkC.gt(this.nlf + j);
        y(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.nld) {
                    if (!CronetUrlRequest.this.dOh()) {
                        CronetUrlRequest.this.xK(false);
                        try {
                            CronetUrlRequest.this.nlg.b(CronetUrlRequest.this, CronetUrlRequest.this.nkC);
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
        if (this.nkC != null) {
            this.nkC.gt(this.nlf + j);
        }
        a(new UrlRequestException("Exception in CronetUrlRequest: " + str, i, i2));
    }

    @CalledByNative
    private void onCanceled() {
        y(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.turbonet.base.a.g("ChromiumNetwork", "****** onCanceled, url is: %s", CronetUrlRequest.this.nkC.getUrl());
                    CronetUrlRequest.this.nlg.c(CronetUrlRequest.this, CronetUrlRequest.this.nkC);
                } catch (Exception e) {
                    com.baidu.turbonet.base.a.g("ChromiumNetwork", "Exception in onCanceled method", e);
                }
            }
        });
    }

    @CalledByNative
    private void onStatus(final UrlRequest.StatusListener statusListener, final int i) {
        y(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequest.7
            @Override // java.lang.Runnable
            public void run() {
                statusListener.Lb(UrlRequest.Status.La(i));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public final class b {
        @Nullable
        private Long nlP;
        @Nullable
        private Long nlQ;
        @Nullable
        private Long nlR;

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dOu() {
            if (this.nlP != null) {
                throw new IllegalStateException("onRequestStarted called repeatedly");
            }
            this.nlP = Long.valueOf(SystemClock.elapsedRealtime());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dOv() {
            if (this.nlP != null && this.nlR == null) {
                this.nlR = Long.valueOf(SystemClock.elapsedRealtime() - this.nlP.longValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dOw() {
            if (this.nlP != null && this.nlQ == null) {
                this.nlQ = Long.valueOf(SystemClock.elapsedRealtime() - this.nlP.longValue());
            }
        }
    }
}
