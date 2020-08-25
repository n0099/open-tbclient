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
/* loaded from: classes10.dex */
public interface UrlRequest {

    /* loaded from: classes10.dex */
    public static abstract class StatusListener {
        public abstract void Kw(int i);
    }

    void Kd(int i);

    void Ke(int i);

    void Kf(int i);

    void Th(String str);

    void Ti(String str);

    void Tj(String str);

    void a(UploadDataProvider uploadDataProvider, Executor executor);

    void addHeader(String str, String str2);

    void cancel();

    void dKj();

    void dKk();

    void dKl();

    Object getTag();

    void m(ByteBuffer byteBuffer);

    void setTag(Object obj);

    void setTimeout(int i);

    void start();

    /* loaded from: classes10.dex */
    public static final class Builder {
        String dpW;
        final Executor mExecutor;
        Object mTag;
        final String mUrl;
        final Callback naP;
        boolean nbf;
        boolean nbg;
        boolean nbh;
        boolean nbj;
        int nbk;
        int nbl;
        int nbm;
        int nbn;
        String nbo;
        String nbp;
        final TurbonetEngine ncB;
        UploadDataProvider ndp;
        Executor ndq;
        boolean ndr;
        final ArrayList<Pair<String, String>> ndo = new ArrayList<>();
        int mPriority = 3;
        Collection<Object> nbe = Collections.emptyList();

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes10.dex */
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
            this.naP = callback;
            this.mExecutor = executor;
            this.ncB = turbonetEngine;
            this.ndr = false;
            this.nbj = false;
            this.nbk = 0;
            this.nbl = 0;
            this.nbm = 0;
            this.nbn = 0;
            this.mTag = null;
            this.nbo = null;
            this.nbp = null;
        }

        public Builder Tt(String str) {
            if (str == null) {
                throw new NullPointerException("Method is required.");
            }
            this.dpW = str;
            return this;
        }

        public Builder gi(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("Invalid header name.");
            }
            if (str2 == null) {
                throw new NullPointerException("Invalid header value.");
            }
            if (Headers.ACCEPT_ENCODING.equalsIgnoreCase(str)) {
                Log.w("cronet", "It's not necessary to set Accept-Encoding on requests - cronet will do this automatically for you, and setting it yourself has no effect. See https://crbug.com/581399 for details.", new Exception());
            } else {
                this.ndo.add(Pair.create(str, str2));
            }
            return this;
        }

        public Builder dLd() {
            this.nbf = true;
            return this;
        }

        public Builder dLe() {
            this.ndr = true;
            return this;
        }

        public Builder dLf() {
            this.nbh = true;
            return this;
        }

        public Builder Ks(int i) {
            this.nbk = i;
            return this;
        }

        public Builder Kt(int i) {
            this.nbl = i;
            return this;
        }

        public Builder Ku(int i) {
            this.nbm = i;
            return this;
        }

        public Builder Tu(String str) {
            this.nbo = str;
            return this;
        }

        public Builder Tv(String str) {
            this.nbp = str;
            return this;
        }

        public Builder b(UploadDataProvider uploadDataProvider, Executor executor) {
            if (uploadDataProvider == null) {
                throw new NullPointerException("Invalid UploadDataProvider.");
            }
            if (executor == null) {
                throw new NullPointerException("Invalid UploadDataProvider Executor.");
            }
            if (this.dpW == null) {
                this.dpW = "POST";
            }
            this.ndp = uploadDataProvider;
            this.ndq = executor;
            return this;
        }

        public UrlRequest dLg() {
            UrlRequest a = this.ncB.a(this.mUrl, this.naP, this.mExecutor, this.mPriority, this.nbe, this.nbf, this.nbg, this.nbh);
            if (this.dpW != null) {
                a.Th(this.dpW);
            }
            Iterator<Pair<String, String>> it = this.ndo.iterator();
            while (it.hasNext()) {
                Pair<String, String> next = it.next();
                a.addHeader((String) next.first, (String) next.second);
            }
            if (this.ndp != null) {
                a.a(this.ndp, this.ndq);
            }
            if (this.ndr) {
                a.dKk();
            }
            if (this.nbj) {
                a.dKl();
            }
            if (this.nbk > 0) {
                a.setTimeout(this.nbk);
            }
            if (this.nbl > 0) {
                a.Kd(this.nbl);
            }
            if (this.nbm > 0) {
                a.Ke(this.nbm);
            }
            if (this.nbn > 0) {
                a.Kf(this.nbn);
            }
            if (this.mTag != null) {
                a.setTag(this.mTag);
            }
            if (!TextUtils.isEmpty(this.nbo)) {
                a.Ti(this.nbo);
            }
            if (!TextUtils.isEmpty(this.nbp)) {
                a.Tj(this.nbp);
            }
            return a;
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class Callback {
        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) throws Exception;

        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException);

        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) throws Exception;

        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) throws Exception;

        public abstract void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo);

        public void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        }
    }

    /* loaded from: classes10.dex */
    public static class Status {
        static final /* synthetic */ boolean $assertionsDisabled;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes10.dex */
        public @interface StatusValues {
        }

        static {
            $assertionsDisabled = !UrlRequest.class.desiredAssertionStatus();
        }

        private Status() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int Kv(int i) {
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
