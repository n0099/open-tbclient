package com.baidu.turbonet.net;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidubce.http.Headers;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.Executor;
/* loaded from: classes17.dex */
public interface UrlRequest {

    /* loaded from: classes17.dex */
    public static abstract class StatusListener {
        public abstract void MJ(int i);
    }

    void Mq(int i);

    void Mr(int i);

    void Ms(int i);

    void VI(String str);

    void VJ(String str);

    void VK(String str);

    void a(UploadDataProvider uploadDataProvider, Executor executor);

    void addHeader(String str, String str2);

    void cancel();

    void dXU();

    void dXV();

    void dXW();

    Object getTag();

    void n(ByteBuffer byteBuffer);

    void setTag(Object obj);

    void setTimeout(int i);

    void start();

    /* loaded from: classes17.dex */
    public static final class Builder {
        String dMC;
        final Executor mExecutor;
        Object mTag;
        final String mUrl;
        int odA;
        int odB;
        int odC;
        String odD;
        String odE;
        final Callback ode;
        boolean odu;
        boolean odv;
        boolean odw;
        boolean ody;
        int odz;
        final TurbonetEngine oeQ;
        UploadDataProvider ofE;
        Executor ofF;
        boolean ofG;
        final ArrayList<Pair<String, String>> ofD = new ArrayList<>();
        int mPriority = 3;
        Collection<Object> odt = Collections.emptyList();

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes17.dex */
        public @interface RequestPriority {
        }

        public Builder(String str, Callback callback, Executor executor, TurbonetEngine turbonetEngine) {
            if (str == null) {
                throw new NullPointerException("URL is required.");
            }
            if (callback == null) {
                throw new NullPointerException("Callback is required.");
            }
            if (executor == null) {
                throw new NullPointerException("Executor is required.");
            }
            if (turbonetEngine == null) {
                throw new NullPointerException("TurbonetEngine is required.");
            }
            this.mUrl = str;
            this.ode = callback;
            this.mExecutor = executor;
            this.oeQ = turbonetEngine;
            this.ofG = false;
            this.ody = false;
            this.odz = 0;
            this.odA = 0;
            this.odB = 0;
            this.odC = 0;
            this.mTag = null;
            this.odD = null;
            this.odE = null;
        }

        public Builder VU(String str) {
            if (str == null) {
                throw new NullPointerException("Method is required.");
            }
            this.dMC = str;
            return this;
        }

        public Builder gO(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("Invalid header name.");
            }
            if (str2 == null) {
                throw new NullPointerException("Invalid header value.");
            }
            if (Headers.ACCEPT_ENCODING.equalsIgnoreCase(str)) {
                Log.w("cronet", "It's not necessary to set Accept-Encoding on requests - cronet will do this automatically for you, and setting it yourself has no effect. See https://crbug.com/581399 for details.", new Exception());
            } else {
                this.ofD.add(Pair.create(str, str2));
            }
            return this;
        }

        public Builder dYN() {
            this.odu = true;
            return this;
        }

        public Builder dYO() {
            this.ofG = true;
            return this;
        }

        public Builder dYP() {
            this.odw = true;
            return this;
        }

        public Builder MF(int i) {
            this.odz = i;
            return this;
        }

        public Builder MG(int i) {
            this.odA = i;
            return this;
        }

        public Builder MH(int i) {
            this.odB = i;
            return this;
        }

        public Builder VV(String str) {
            this.odD = str;
            return this;
        }

        public Builder VW(String str) {
            this.odE = str;
            return this;
        }

        public Builder b(UploadDataProvider uploadDataProvider, Executor executor) {
            if (uploadDataProvider == null) {
                throw new NullPointerException("Invalid UploadDataProvider.");
            }
            if (executor == null) {
                throw new NullPointerException("Invalid UploadDataProvider Executor.");
            }
            if (this.dMC == null) {
                this.dMC = "POST";
            }
            this.ofE = uploadDataProvider;
            this.ofF = executor;
            return this;
        }

        public UrlRequest dYQ() {
            UrlRequest a2 = this.oeQ.a(this.mUrl, this.ode, this.mExecutor, this.mPriority, this.odt, this.odu, this.odv, this.odw);
            if (this.dMC != null) {
                a2.VI(this.dMC);
            }
            Iterator<Pair<String, String>> it = this.ofD.iterator();
            while (it.hasNext()) {
                Pair<String, String> next = it.next();
                a2.addHeader((String) next.first, (String) next.second);
            }
            if (this.ofE != null) {
                a2.a(this.ofE, this.ofF);
            }
            if (this.ofG) {
                a2.dXV();
            }
            if (this.ody) {
                a2.dXW();
            }
            if (this.odz > 0) {
                a2.setTimeout(this.odz);
            }
            if (this.odA > 0) {
                a2.Mq(this.odA);
            }
            if (this.odB > 0) {
                a2.Mr(this.odB);
            }
            if (this.odC > 0) {
                a2.Ms(this.odC);
            }
            if (this.mTag != null) {
                a2.setTag(this.mTag);
            }
            if (!TextUtils.isEmpty(this.odD)) {
                a2.VJ(this.odD);
            }
            if (!TextUtils.isEmpty(this.odE)) {
                a2.VK(this.odE);
            }
            return a2;
        }
    }

    /* loaded from: classes17.dex */
    public static abstract class Callback {
        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) throws Exception;

        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException);

        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) throws Exception;

        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) throws Exception;

        public abstract void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo);

        public void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        }
    }

    /* loaded from: classes17.dex */
    public static class Status {
        static final /* synthetic */ boolean $assertionsDisabled;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes17.dex */
        public @interface StatusValues {
        }

        static {
            $assertionsDisabled = !UrlRequest.class.desiredAssertionStatus();
        }

        private Status() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int MI(int i) {
            if ($assertionsDisabled || (i >= 0 && i <= 15)) {
                switch (i) {
                    case 0:
                        return 0;
                    case 1:
                        return 1;
                    case 2:
                        return 2;
                    case 3:
                        return 3;
                    case 4:
                        return 4;
                    case 5:
                    default:
                        throw new IllegalArgumentException("No request status found.");
                    case 6:
                        return 5;
                    case 7:
                        return 6;
                    case 8:
                        return 7;
                    case 9:
                        return 8;
                    case 10:
                        return 9;
                    case 11:
                        return 10;
                    case 12:
                        return 11;
                    case 13:
                        return 12;
                    case 14:
                        return 13;
                    case 15:
                        return 14;
                }
            }
            throw new AssertionError();
        }
    }
}
