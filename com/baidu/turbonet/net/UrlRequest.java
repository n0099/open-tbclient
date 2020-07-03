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

    void Pw(String str);

    void Px(String str);

    void Py(String str);

    void a(UploadDataProvider uploadDataProvider, Executor executor);

    void addHeader(String str, String str2);

    void cancel();

    void dve();

    void dvf();

    void dvg();

    Object getTag();

    void m(ByteBuffer byteBuffer);

    void setTag(Object obj);

    void setTimeout(int i);

    void start();

    /* loaded from: classes.dex */
    public static final class Builder {
        String dac;
        boolean mAa;
        int mAb;
        int mAc;
        int mAd;
        int mAe;
        String mAf;
        String mAg;
        final TurbonetEngine mBt;
        UploadDataProvider mCh;
        Executor mCi;
        boolean mCj;
        final Executor mExecutor;
        Object mTag;
        final String mUrl;
        final Callback mzG;
        boolean mzW;
        boolean mzX;
        boolean mzY;
        final ArrayList<Pair<String, String>> mCg = new ArrayList<>();
        int mPriority = 3;
        Collection<Object> mzV = Collections.emptyList();

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
            this.mzG = callback;
            this.mExecutor = executor;
            this.mBt = turbonetEngine;
            this.mCj = false;
            this.mAa = false;
            this.mAb = 0;
            this.mAc = 0;
            this.mAd = 0;
            this.mAe = 0;
            this.mTag = null;
            this.mAf = null;
            this.mAg = null;
        }

        public Builder PI(String str) {
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
                this.mCg.add(Pair.create(str, str2));
            }
            return this;
        }

        public Builder dvY() {
            this.mzW = true;
            return this;
        }

        public Builder dvZ() {
            this.mCj = true;
            return this;
        }

        public Builder dwa() {
            this.mzY = true;
            return this;
        }

        public Builder Hx(int i) {
            this.mAb = i;
            return this;
        }

        public Builder Hy(int i) {
            this.mAc = i;
            return this;
        }

        public Builder Hz(int i) {
            this.mAd = i;
            return this;
        }

        public Builder PJ(String str) {
            this.mAf = str;
            return this;
        }

        public Builder PK(String str) {
            this.mAg = str;
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
            this.mCh = uploadDataProvider;
            this.mCi = executor;
            return this;
        }

        public UrlRequest dwb() {
            UrlRequest a = this.mBt.a(this.mUrl, this.mzG, this.mExecutor, this.mPriority, this.mzV, this.mzW, this.mzX, this.mzY);
            if (this.dac != null) {
                a.Pw(this.dac);
            }
            Iterator<Pair<String, String>> it = this.mCg.iterator();
            while (it.hasNext()) {
                Pair<String, String> next = it.next();
                a.addHeader((String) next.first, (String) next.second);
            }
            if (this.mCh != null) {
                a.a(this.mCh, this.mCi);
            }
            if (this.mCj) {
                a.dvf();
            }
            if (this.mAa) {
                a.dvg();
            }
            if (this.mAb > 0) {
                a.setTimeout(this.mAb);
            }
            if (this.mAc > 0) {
                a.Hi(this.mAc);
            }
            if (this.mAd > 0) {
                a.Hj(this.mAd);
            }
            if (this.mAe > 0) {
                a.Hk(this.mAe);
            }
            if (this.mTag != null) {
                a.setTag(this.mTag);
            }
            if (!TextUtils.isEmpty(this.mAf)) {
                a.Px(this.mAf);
            }
            if (!TextUtils.isEmpty(this.mAg)) {
                a.Py(this.mAg);
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
