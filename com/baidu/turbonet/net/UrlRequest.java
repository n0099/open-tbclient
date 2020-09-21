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
/* loaded from: classes15.dex */
public interface UrlRequest {

    /* loaded from: classes15.dex */
    public static abstract class StatusListener {
        public abstract void Lb(int i);
    }

    void KI(int i);

    void KJ(int i);

    void KK(int i);

    void TG(String str);

    void TH(String str);

    void TI(String str);

    void a(UploadDataProvider uploadDataProvider, Executor executor);

    void addHeader(String str, String str2);

    void cancel();

    void dOq();

    void dOr();

    void dOs();

    Object getTag();

    void m(ByteBuffer byteBuffer);

    void setTag(Object obj);

    void setTimeout(int i);

    void start();

    /* loaded from: classes15.dex */
    public static final class Builder {
        String dsc;
        final Executor mExecutor;
        Object mTag;
        final String mUrl;
        boolean nlA;
        int nlB;
        int nlC;
        int nlD;
        int nlE;
        String nlF;
        String nlG;
        final Callback nlg;
        boolean nlw;
        boolean nlx;
        boolean nly;
        final TurbonetEngine nmS;
        UploadDataProvider nnG;
        Executor nnH;
        boolean nnI;
        final ArrayList<Pair<String, String>> nnF = new ArrayList<>();
        int mPriority = 3;
        Collection<Object> nlv = Collections.emptyList();

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes15.dex */
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
            this.nlg = callback;
            this.mExecutor = executor;
            this.nmS = turbonetEngine;
            this.nnI = false;
            this.nlA = false;
            this.nlB = 0;
            this.nlC = 0;
            this.nlD = 0;
            this.nlE = 0;
            this.mTag = null;
            this.nlF = null;
            this.nlG = null;
        }

        public Builder TS(String str) {
            if (str == null) {
                throw new NullPointerException("Method is required.");
            }
            this.dsc = str;
            return this;
        }

        public Builder gv(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("Invalid header name.");
            }
            if (str2 == null) {
                throw new NullPointerException("Invalid header value.");
            }
            if (Headers.ACCEPT_ENCODING.equalsIgnoreCase(str)) {
                Log.w("cronet", "It's not necessary to set Accept-Encoding on requests - cronet will do this automatically for you, and setting it yourself has no effect. See https://crbug.com/581399 for details.", new Exception());
            } else {
                this.nnF.add(Pair.create(str, str2));
            }
            return this;
        }

        public Builder dPk() {
            this.nlw = true;
            return this;
        }

        public Builder dPl() {
            this.nnI = true;
            return this;
        }

        public Builder dPm() {
            this.nly = true;
            return this;
        }

        public Builder KX(int i) {
            this.nlB = i;
            return this;
        }

        public Builder KY(int i) {
            this.nlC = i;
            return this;
        }

        public Builder KZ(int i) {
            this.nlD = i;
            return this;
        }

        public Builder TT(String str) {
            this.nlF = str;
            return this;
        }

        public Builder TU(String str) {
            this.nlG = str;
            return this;
        }

        public Builder b(UploadDataProvider uploadDataProvider, Executor executor) {
            if (uploadDataProvider == null) {
                throw new NullPointerException("Invalid UploadDataProvider.");
            }
            if (executor == null) {
                throw new NullPointerException("Invalid UploadDataProvider Executor.");
            }
            if (this.dsc == null) {
                this.dsc = "POST";
            }
            this.nnG = uploadDataProvider;
            this.nnH = executor;
            return this;
        }

        public UrlRequest dPn() {
            UrlRequest a = this.nmS.a(this.mUrl, this.nlg, this.mExecutor, this.mPriority, this.nlv, this.nlw, this.nlx, this.nly);
            if (this.dsc != null) {
                a.TG(this.dsc);
            }
            Iterator<Pair<String, String>> it = this.nnF.iterator();
            while (it.hasNext()) {
                Pair<String, String> next = it.next();
                a.addHeader((String) next.first, (String) next.second);
            }
            if (this.nnG != null) {
                a.a(this.nnG, this.nnH);
            }
            if (this.nnI) {
                a.dOr();
            }
            if (this.nlA) {
                a.dOs();
            }
            if (this.nlB > 0) {
                a.setTimeout(this.nlB);
            }
            if (this.nlC > 0) {
                a.KI(this.nlC);
            }
            if (this.nlD > 0) {
                a.KJ(this.nlD);
            }
            if (this.nlE > 0) {
                a.KK(this.nlE);
            }
            if (this.mTag != null) {
                a.setTag(this.mTag);
            }
            if (!TextUtils.isEmpty(this.nlF)) {
                a.TH(this.nlF);
            }
            if (!TextUtils.isEmpty(this.nlG)) {
                a.TI(this.nlG);
            }
            return a;
        }
    }

    /* loaded from: classes15.dex */
    public static abstract class Callback {
        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) throws Exception;

        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException);

        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) throws Exception;

        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) throws Exception;

        public abstract void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo);

        public void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        }
    }

    /* loaded from: classes15.dex */
    public static class Status {
        static final /* synthetic */ boolean $assertionsDisabled;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes15.dex */
        public @interface StatusValues {
        }

        static {
            $assertionsDisabled = !UrlRequest.class.desiredAssertionStatus();
        }

        private Status() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int La(int i) {
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
