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

    void dKs();

    void dKt();

    void dKu();

    Object getTag();

    void m(ByteBuffer byteBuffer);

    void setTag(Object obj);

    void setTimeout(int i);

    void start();

    /* loaded from: classes10.dex */
    public static final class Builder {
        String dqa;
        final Executor mExecutor;
        Object mTag;
        final String mUrl;
        boolean nbB;
        int nbC;
        int nbD;
        int nbE;
        int nbF;
        String nbG;
        String nbH;
        final Callback nbh;
        boolean nbx;
        boolean nby;
        boolean nbz;
        final TurbonetEngine ncT;
        UploadDataProvider ndH;
        Executor ndI;
        boolean ndJ;
        final ArrayList<Pair<String, String>> ndG = new ArrayList<>();
        int mPriority = 3;
        Collection<Object> nbw = Collections.emptyList();

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
            this.nbh = callback;
            this.mExecutor = executor;
            this.ncT = turbonetEngine;
            this.ndJ = false;
            this.nbB = false;
            this.nbC = 0;
            this.nbD = 0;
            this.nbE = 0;
            this.nbF = 0;
            this.mTag = null;
            this.nbG = null;
            this.nbH = null;
        }

        public Builder Tt(String str) {
            if (str == null) {
                throw new NullPointerException("Method is required.");
            }
            this.dqa = str;
            return this;
        }

        public Builder gj(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("Invalid header name.");
            }
            if (str2 == null) {
                throw new NullPointerException("Invalid header value.");
            }
            if (Headers.ACCEPT_ENCODING.equalsIgnoreCase(str)) {
                Log.w("cronet", "It's not necessary to set Accept-Encoding on requests - cronet will do this automatically for you, and setting it yourself has no effect. See https://crbug.com/581399 for details.", new Exception());
            } else {
                this.ndG.add(Pair.create(str, str2));
            }
            return this;
        }

        public Builder dLm() {
            this.nbx = true;
            return this;
        }

        public Builder dLn() {
            this.ndJ = true;
            return this;
        }

        public Builder dLo() {
            this.nbz = true;
            return this;
        }

        public Builder Ks(int i) {
            this.nbC = i;
            return this;
        }

        public Builder Kt(int i) {
            this.nbD = i;
            return this;
        }

        public Builder Ku(int i) {
            this.nbE = i;
            return this;
        }

        public Builder Tu(String str) {
            this.nbG = str;
            return this;
        }

        public Builder Tv(String str) {
            this.nbH = str;
            return this;
        }

        public Builder b(UploadDataProvider uploadDataProvider, Executor executor) {
            if (uploadDataProvider == null) {
                throw new NullPointerException("Invalid UploadDataProvider.");
            }
            if (executor == null) {
                throw new NullPointerException("Invalid UploadDataProvider Executor.");
            }
            if (this.dqa == null) {
                this.dqa = "POST";
            }
            this.ndH = uploadDataProvider;
            this.ndI = executor;
            return this;
        }

        public UrlRequest dLp() {
            UrlRequest a = this.ncT.a(this.mUrl, this.nbh, this.mExecutor, this.mPriority, this.nbw, this.nbx, this.nby, this.nbz);
            if (this.dqa != null) {
                a.Th(this.dqa);
            }
            Iterator<Pair<String, String>> it = this.ndG.iterator();
            while (it.hasNext()) {
                Pair<String, String> next = it.next();
                a.addHeader((String) next.first, (String) next.second);
            }
            if (this.ndH != null) {
                a.a(this.ndH, this.ndI);
            }
            if (this.ndJ) {
                a.dKt();
            }
            if (this.nbB) {
                a.dKu();
            }
            if (this.nbC > 0) {
                a.setTimeout(this.nbC);
            }
            if (this.nbD > 0) {
                a.Kd(this.nbD);
            }
            if (this.nbE > 0) {
                a.Ke(this.nbE);
            }
            if (this.nbF > 0) {
                a.Kf(this.nbF);
            }
            if (this.mTag != null) {
                a.setTag(this.mTag);
            }
            if (!TextUtils.isEmpty(this.nbG)) {
                a.Ti(this.nbG);
            }
            if (!TextUtils.isEmpty(this.nbH)) {
                a.Tj(this.nbH);
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
