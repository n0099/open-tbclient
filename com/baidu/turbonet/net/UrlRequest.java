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

    void MW(String str);

    void MX(String str);

    void MY(String str);

    void a(UploadDataProvider uploadDataProvider, Executor executor);

    void addHeader(String str, String str2);

    void cancel();

    void diV();

    void diW();

    void diX();

    Object getTag();

    void h(ByteBuffer byteBuffer);

    void setTag(Object obj);

    void setTimeout(int i);

    void start();

    /* loaded from: classes.dex */
    public static final class Builder {
        boolean lJG;
        boolean lJH;
        boolean lJI;
        boolean lJK;
        int lJL;
        int lJM;
        int lJN;
        int lJO;
        String lJP;
        String lJQ;
        final Callback lJq;
        String lKA;
        UploadDataProvider lLR;
        Executor lLS;
        boolean lLT;
        final TurbonetEngine lLe;
        final Executor mExecutor;
        Object mTag;
        final String mUrl;
        final ArrayList<Pair<String, String>> lLQ = new ArrayList<>();
        int mPriority = 3;
        Collection<Object> lJF = Collections.emptyList();

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
            this.lJq = callback;
            this.mExecutor = executor;
            this.lLe = turbonetEngine;
            this.lLT = false;
            this.lJK = false;
            this.lJL = 0;
            this.lJM = 0;
            this.lJN = 0;
            this.lJO = 0;
            this.mTag = null;
            this.lJP = null;
            this.lJQ = null;
        }

        public Builder Ni(String str) {
            if (str == null) {
                throw new NullPointerException("Method is required.");
            }
            this.lKA = str;
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
                this.lLQ.add(Pair.create(str, str2));
            }
            return this;
        }

        public Builder djP() {
            this.lJG = true;
            return this;
        }

        public Builder djQ() {
            this.lLT = true;
            return this;
        }

        public Builder djR() {
            this.lJI = true;
            return this;
        }

        public Builder FB(int i) {
            this.lJL = i;
            return this;
        }

        public Builder FC(int i) {
            this.lJM = i;
            return this;
        }

        public Builder FD(int i) {
            this.lJN = i;
            return this;
        }

        public Builder Nj(String str) {
            this.lJP = str;
            return this;
        }

        public Builder Nk(String str) {
            this.lJQ = str;
            return this;
        }

        public Builder b(UploadDataProvider uploadDataProvider, Executor executor) {
            if (uploadDataProvider == null) {
                throw new NullPointerException("Invalid UploadDataProvider.");
            }
            if (executor == null) {
                throw new NullPointerException("Invalid UploadDataProvider Executor.");
            }
            if (this.lKA == null) {
                this.lKA = "POST";
            }
            this.lLR = uploadDataProvider;
            this.lLS = executor;
            return this;
        }

        public UrlRequest djS() {
            UrlRequest a = this.lLe.a(this.mUrl, this.lJq, this.mExecutor, this.mPriority, this.lJF, this.lJG, this.lJH, this.lJI);
            if (this.lKA != null) {
                a.MW(this.lKA);
            }
            Iterator<Pair<String, String>> it = this.lLQ.iterator();
            while (it.hasNext()) {
                Pair<String, String> next = it.next();
                a.addHeader((String) next.first, (String) next.second);
            }
            if (this.lLR != null) {
                a.a(this.lLR, this.lLS);
            }
            if (this.lLT) {
                a.diW();
            }
            if (this.lJK) {
                a.diX();
            }
            if (this.lJL > 0) {
                a.setTimeout(this.lJL);
            }
            if (this.lJM > 0) {
                a.Fm(this.lJM);
            }
            if (this.lJN > 0) {
                a.Fn(this.lJN);
            }
            if (this.lJO > 0) {
                a.Fo(this.lJO);
            }
            if (this.mTag != null) {
                a.setTag(this.mTag);
            }
            if (!TextUtils.isEmpty(this.lJP)) {
                a.MX(this.lJP);
            }
            if (!TextUtils.isEmpty(this.lJQ)) {
                a.MY(this.lJQ);
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
