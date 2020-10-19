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
        public abstract void LH(int i);
    }

    void Lo(int i);

    void Lp(int i);

    void Lq(int i);

    void Uu(String str);

    void Uv(String str);

    void Uw(String str);

    void a(UploadDataProvider uploadDataProvider, Executor executor);

    void addHeader(String str, String str2);

    void cancel();

    void dSc();

    void dSd();

    void dSe();

    Object getTag();

    void o(ByteBuffer byteBuffer);

    void setTag(Object obj);

    void setTimeout(int i);

    void start();

    /* loaded from: classes17.dex */
    public static final class Builder {
        String dEf;
        final Executor mExecutor;
        Object mTag;
        final String mUrl;
        final Callback nAD;
        boolean nAT;
        boolean nAU;
        boolean nAV;
        boolean nAX;
        int nAY;
        int nAZ;
        int nBa;
        int nBb;
        String nBc;
        String nBd;
        final TurbonetEngine nCp;
        UploadDataProvider nDc;
        Executor nDd;
        boolean nDe;
        final ArrayList<Pair<String, String>> nDb = new ArrayList<>();
        int mPriority = 3;
        Collection<Object> nAS = Collections.emptyList();

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
            this.nAD = callback;
            this.mExecutor = executor;
            this.nCp = turbonetEngine;
            this.nDe = false;
            this.nAX = false;
            this.nAY = 0;
            this.nAZ = 0;
            this.nBa = 0;
            this.nBb = 0;
            this.mTag = null;
            this.nBc = null;
            this.nBd = null;
        }

        public Builder UG(String str) {
            if (str == null) {
                throw new NullPointerException("Method is required.");
            }
            this.dEf = str;
            return this;
        }

        public Builder gC(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("Invalid header name.");
            }
            if (str2 == null) {
                throw new NullPointerException("Invalid header value.");
            }
            if (Headers.ACCEPT_ENCODING.equalsIgnoreCase(str)) {
                Log.w("cronet", "It's not necessary to set Accept-Encoding on requests - cronet will do this automatically for you, and setting it yourself has no effect. See https://crbug.com/581399 for details.", new Exception());
            } else {
                this.nDb.add(Pair.create(str, str2));
            }
            return this;
        }

        public Builder dSV() {
            this.nAT = true;
            return this;
        }

        public Builder dSW() {
            this.nDe = true;
            return this;
        }

        public Builder dSX() {
            this.nAV = true;
            return this;
        }

        public Builder LD(int i) {
            this.nAY = i;
            return this;
        }

        public Builder LE(int i) {
            this.nAZ = i;
            return this;
        }

        public Builder LF(int i) {
            this.nBa = i;
            return this;
        }

        public Builder UH(String str) {
            this.nBc = str;
            return this;
        }

        public Builder UI(String str) {
            this.nBd = str;
            return this;
        }

        public Builder b(UploadDataProvider uploadDataProvider, Executor executor) {
            if (uploadDataProvider == null) {
                throw new NullPointerException("Invalid UploadDataProvider.");
            }
            if (executor == null) {
                throw new NullPointerException("Invalid UploadDataProvider Executor.");
            }
            if (this.dEf == null) {
                this.dEf = "POST";
            }
            this.nDc = uploadDataProvider;
            this.nDd = executor;
            return this;
        }

        public UrlRequest dSY() {
            UrlRequest a2 = this.nCp.a(this.mUrl, this.nAD, this.mExecutor, this.mPriority, this.nAS, this.nAT, this.nAU, this.nAV);
            if (this.dEf != null) {
                a2.Uu(this.dEf);
            }
            Iterator<Pair<String, String>> it = this.nDb.iterator();
            while (it.hasNext()) {
                Pair<String, String> next = it.next();
                a2.addHeader((String) next.first, (String) next.second);
            }
            if (this.nDc != null) {
                a2.a(this.nDc, this.nDd);
            }
            if (this.nDe) {
                a2.dSd();
            }
            if (this.nAX) {
                a2.dSe();
            }
            if (this.nAY > 0) {
                a2.setTimeout(this.nAY);
            }
            if (this.nAZ > 0) {
                a2.Lo(this.nAZ);
            }
            if (this.nBa > 0) {
                a2.Lp(this.nBa);
            }
            if (this.nBb > 0) {
                a2.Lq(this.nBb);
            }
            if (this.mTag != null) {
                a2.setTag(this.mTag);
            }
            if (!TextUtils.isEmpty(this.nBc)) {
                a2.Uv(this.nBc);
            }
            if (!TextUtils.isEmpty(this.nBd)) {
                a2.Uw(this.nBd);
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
        public static int LG(int i) {
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
