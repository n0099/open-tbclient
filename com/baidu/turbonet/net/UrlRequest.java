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
        public abstract void HB(int i);
    }

    void Hi(int i);

    void Hj(int i);

    void Hk(int i);

    void Px(String str);

    void Py(String str);

    void Pz(String str);

    void a(UploadDataProvider uploadDataProvider, Executor executor);

    void addHeader(String str, String str2);

    void cancel();

    void dvi();

    void dvj();

    void dvk();

    Object getTag();

    void m(ByteBuffer byteBuffer);

    void setTag(Object obj);

    void setTimeout(int i);

    void start();

    /* loaded from: classes.dex */
    public static final class Builder {
        String dac;
        boolean mAa;
        boolean mAb;
        boolean mAd;
        int mAe;
        int mAf;
        int mAg;
        int mAh;
        String mAi;
        String mAj;
        final TurbonetEngine mBw;
        UploadDataProvider mCk;
        Executor mCl;
        boolean mCm;
        final Executor mExecutor;
        Object mTag;
        final String mUrl;
        final Callback mzJ;
        boolean mzZ;
        final ArrayList<Pair<String, String>> mCj = new ArrayList<>();
        int mPriority = 3;
        Collection<Object> mzY = Collections.emptyList();

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
            this.mzJ = callback;
            this.mExecutor = executor;
            this.mBw = turbonetEngine;
            this.mCm = false;
            this.mAd = false;
            this.mAe = 0;
            this.mAf = 0;
            this.mAg = 0;
            this.mAh = 0;
            this.mTag = null;
            this.mAi = null;
            this.mAj = null;
        }

        public Builder PJ(String str) {
            if (str == null) {
                throw new NullPointerException("Method is required.");
            }
            this.dac = str;
            return this;
        }

        public Builder fP(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("Invalid header name.");
            }
            if (str2 == null) {
                throw new NullPointerException("Invalid header value.");
            }
            if (Headers.ACCEPT_ENCODING.equalsIgnoreCase(str)) {
                Log.w("cronet", "It's not necessary to set Accept-Encoding on requests - cronet will do this automatically for you, and setting it yourself has no effect. See https://crbug.com/581399 for details.", new Exception());
            } else {
                this.mCj.add(Pair.create(str, str2));
            }
            return this;
        }

        public Builder dwc() {
            this.mzZ = true;
            return this;
        }

        public Builder dwd() {
            this.mCm = true;
            return this;
        }

        public Builder dwe() {
            this.mAb = true;
            return this;
        }

        public Builder Hx(int i) {
            this.mAe = i;
            return this;
        }

        public Builder Hy(int i) {
            this.mAf = i;
            return this;
        }

        public Builder Hz(int i) {
            this.mAg = i;
            return this;
        }

        public Builder PK(String str) {
            this.mAi = str;
            return this;
        }

        public Builder PL(String str) {
            this.mAj = str;
            return this;
        }

        public Builder b(UploadDataProvider uploadDataProvider, Executor executor) {
            if (uploadDataProvider == null) {
                throw new NullPointerException("Invalid UploadDataProvider.");
            }
            if (executor == null) {
                throw new NullPointerException("Invalid UploadDataProvider Executor.");
            }
            if (this.dac == null) {
                this.dac = "POST";
            }
            this.mCk = uploadDataProvider;
            this.mCl = executor;
            return this;
        }

        public UrlRequest dwf() {
            UrlRequest a = this.mBw.a(this.mUrl, this.mzJ, this.mExecutor, this.mPriority, this.mzY, this.mzZ, this.mAa, this.mAb);
            if (this.dac != null) {
                a.Px(this.dac);
            }
            Iterator<Pair<String, String>> it = this.mCj.iterator();
            while (it.hasNext()) {
                Pair<String, String> next = it.next();
                a.addHeader((String) next.first, (String) next.second);
            }
            if (this.mCk != null) {
                a.a(this.mCk, this.mCl);
            }
            if (this.mCm) {
                a.dvj();
            }
            if (this.mAd) {
                a.dvk();
            }
            if (this.mAe > 0) {
                a.setTimeout(this.mAe);
            }
            if (this.mAf > 0) {
                a.Hi(this.mAf);
            }
            if (this.mAg > 0) {
                a.Hj(this.mAg);
            }
            if (this.mAh > 0) {
                a.Hk(this.mAh);
            }
            if (this.mTag != null) {
                a.setTag(this.mTag);
            }
            if (!TextUtils.isEmpty(this.mAi)) {
                a.Py(this.mAi);
            }
            if (!TextUtils.isEmpty(this.mAj)) {
                a.Pz(this.mAj);
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
        public static int HA(int i) {
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
