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
/* loaded from: classes.dex */
public interface UrlRequest {

    /* loaded from: classes.dex */
    public static abstract class StatusListener {
        public abstract void FF(int i);
    }

    void Fm(int i);

    void Fn(int i);

    void Fo(int i);

    void MT(String str);

    void MU(String str);

    void MV(String str);

    void a(UploadDataProvider uploadDataProvider, Executor executor);

    void addHeader(String str, String str2);

    void cancel();

    void diX();

    void diY();

    void diZ();

    Object getTag();

    void h(ByteBuffer byteBuffer);

    void setTag(Object obj);

    void setTimeout(int i);

    void start();

    /* loaded from: classes.dex */
    public static final class Builder {
        boolean lJC;
        boolean lJD;
        boolean lJE;
        boolean lJG;
        int lJH;
        int lJI;
        int lJJ;
        int lJK;
        String lJL;
        String lJM;
        final Callback lJm;
        String lKw;
        UploadDataProvider lLN;
        Executor lLO;
        boolean lLP;
        final TurbonetEngine lLa;
        final Executor mExecutor;
        Object mTag;
        final String mUrl;
        final ArrayList<Pair<String, String>> lLM = new ArrayList<>();
        int mPriority = 3;
        Collection<Object> lJB = Collections.emptyList();

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
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
            this.lJm = callback;
            this.mExecutor = executor;
            this.lLa = turbonetEngine;
            this.lLP = false;
            this.lJG = false;
            this.lJH = 0;
            this.lJI = 0;
            this.lJJ = 0;
            this.lJK = 0;
            this.mTag = null;
            this.lJL = null;
            this.lJM = null;
        }

        public Builder Nf(String str) {
            if (str == null) {
                throw new NullPointerException("Method is required.");
            }
            this.lKw = str;
            return this;
        }

        public Builder fe(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("Invalid header name.");
            }
            if (str2 == null) {
                throw new NullPointerException("Invalid header value.");
            }
            if (Headers.ACCEPT_ENCODING.equalsIgnoreCase(str)) {
                Log.w("cronet", "It's not necessary to set Accept-Encoding on requests - cronet will do this automatically for you, and setting it yourself has no effect. See https://crbug.com/581399 for details.", new Exception());
            } else {
                this.lLM.add(Pair.create(str, str2));
            }
            return this;
        }

        public Builder djR() {
            this.lJC = true;
            return this;
        }

        public Builder djS() {
            this.lLP = true;
            return this;
        }

        public Builder djT() {
            this.lJE = true;
            return this;
        }

        public Builder FB(int i) {
            this.lJH = i;
            return this;
        }

        public Builder FC(int i) {
            this.lJI = i;
            return this;
        }

        public Builder FD(int i) {
            this.lJJ = i;
            return this;
        }

        public Builder Ng(String str) {
            this.lJL = str;
            return this;
        }

        public Builder Nh(String str) {
            this.lJM = str;
            return this;
        }

        public Builder b(UploadDataProvider uploadDataProvider, Executor executor) {
            if (uploadDataProvider == null) {
                throw new NullPointerException("Invalid UploadDataProvider.");
            }
            if (executor == null) {
                throw new NullPointerException("Invalid UploadDataProvider Executor.");
            }
            if (this.lKw == null) {
                this.lKw = "POST";
            }
            this.lLN = uploadDataProvider;
            this.lLO = executor;
            return this;
        }

        public UrlRequest djU() {
            UrlRequest a = this.lLa.a(this.mUrl, this.lJm, this.mExecutor, this.mPriority, this.lJB, this.lJC, this.lJD, this.lJE);
            if (this.lKw != null) {
                a.MT(this.lKw);
            }
            Iterator<Pair<String, String>> it = this.lLM.iterator();
            while (it.hasNext()) {
                Pair<String, String> next = it.next();
                a.addHeader((String) next.first, (String) next.second);
            }
            if (this.lLN != null) {
                a.a(this.lLN, this.lLO);
            }
            if (this.lLP) {
                a.diY();
            }
            if (this.lJG) {
                a.diZ();
            }
            if (this.lJH > 0) {
                a.setTimeout(this.lJH);
            }
            if (this.lJI > 0) {
                a.Fm(this.lJI);
            }
            if (this.lJJ > 0) {
                a.Fn(this.lJJ);
            }
            if (this.lJK > 0) {
                a.Fo(this.lJK);
            }
            if (this.mTag != null) {
                a.setTag(this.mTag);
            }
            if (!TextUtils.isEmpty(this.lJL)) {
                a.MU(this.lJL);
            }
            if (!TextUtils.isEmpty(this.lJM)) {
                a.MV(this.lJM);
            }
            return a;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Callback {
        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) throws Exception;

        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException);

        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) throws Exception;

        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) throws Exception;

        public abstract void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo);

        public void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        }
    }

    /* loaded from: classes.dex */
    public static class Status {
        static final /* synthetic */ boolean $assertionsDisabled;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        public @interface StatusValues {
        }

        static {
            $assertionsDisabled = !UrlRequest.class.desiredAssertionStatus();
        }

        private Status() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int FE(int i) {
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
