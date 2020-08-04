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
/* loaded from: classes19.dex */
public interface UrlRequest {

    /* loaded from: classes19.dex */
    public static abstract class StatusListener {
        public abstract void HW(int i);
    }

    void HD(int i);

    void HE(int i);

    void HF(int i);

    void Qi(String str);

    void Qj(String str);

    void Qk(String str);

    void a(UploadDataProvider uploadDataProvider, Executor executor);

    void addHeader(String str, String str2);

    void cancel();

    void dyw();

    void dyx();

    void dyy();

    Object getTag();

    void m(ByteBuffer byteBuffer);

    void setTag(Object obj);

    void setTimeout(int i);

    void start();

    /* loaded from: classes19.dex */
    public static final class Builder {
        String dfN;
        final Executor mExecutor;
        final Callback mHQ;
        boolean mIh;
        boolean mIi;
        boolean mIj;
        boolean mIl;
        int mIm;
        int mIn;
        int mIo;
        int mIq;
        String mIr;
        String mIt;
        final TurbonetEngine mJG;
        UploadDataProvider mKu;
        Executor mKv;
        boolean mKw;
        Object mTag;
        final String mUrl;
        final ArrayList<Pair<String, String>> mKt = new ArrayList<>();
        int mPriority = 3;
        Collection<Object> mIg = Collections.emptyList();

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes19.dex */
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
            this.mHQ = callback;
            this.mExecutor = executor;
            this.mJG = turbonetEngine;
            this.mKw = false;
            this.mIl = false;
            this.mIm = 0;
            this.mIn = 0;
            this.mIo = 0;
            this.mIq = 0;
            this.mTag = null;
            this.mIr = null;
            this.mIt = null;
        }

        public Builder Qu(String str) {
            if (str == null) {
                throw new NullPointerException("Method is required.");
            }
            this.dfN = str;
            return this;
        }

        public Builder fR(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("Invalid header name.");
            }
            if (str2 == null) {
                throw new NullPointerException("Invalid header value.");
            }
            if (Headers.ACCEPT_ENCODING.equalsIgnoreCase(str)) {
                Log.w("cronet", "It's not necessary to set Accept-Encoding on requests - cronet will do this automatically for you, and setting it yourself has no effect. See https://crbug.com/581399 for details.", new Exception());
            } else {
                this.mKt.add(Pair.create(str, str2));
            }
            return this;
        }

        public Builder dzq() {
            this.mIh = true;
            return this;
        }

        public Builder dzr() {
            this.mKw = true;
            return this;
        }

        public Builder dzs() {
            this.mIj = true;
            return this;
        }

        public Builder HS(int i) {
            this.mIm = i;
            return this;
        }

        public Builder HT(int i) {
            this.mIn = i;
            return this;
        }

        public Builder HU(int i) {
            this.mIo = i;
            return this;
        }

        public Builder Qv(String str) {
            this.mIr = str;
            return this;
        }

        public Builder Qw(String str) {
            this.mIt = str;
            return this;
        }

        public Builder b(UploadDataProvider uploadDataProvider, Executor executor) {
            if (uploadDataProvider == null) {
                throw new NullPointerException("Invalid UploadDataProvider.");
            }
            if (executor == null) {
                throw new NullPointerException("Invalid UploadDataProvider Executor.");
            }
            if (this.dfN == null) {
                this.dfN = "POST";
            }
            this.mKu = uploadDataProvider;
            this.mKv = executor;
            return this;
        }

        public UrlRequest dzt() {
            UrlRequest a = this.mJG.a(this.mUrl, this.mHQ, this.mExecutor, this.mPriority, this.mIg, this.mIh, this.mIi, this.mIj);
            if (this.dfN != null) {
                a.Qi(this.dfN);
            }
            Iterator<Pair<String, String>> it = this.mKt.iterator();
            while (it.hasNext()) {
                Pair<String, String> next = it.next();
                a.addHeader((String) next.first, (String) next.second);
            }
            if (this.mKu != null) {
                a.a(this.mKu, this.mKv);
            }
            if (this.mKw) {
                a.dyx();
            }
            if (this.mIl) {
                a.dyy();
            }
            if (this.mIm > 0) {
                a.setTimeout(this.mIm);
            }
            if (this.mIn > 0) {
                a.HD(this.mIn);
            }
            if (this.mIo > 0) {
                a.HE(this.mIo);
            }
            if (this.mIq > 0) {
                a.HF(this.mIq);
            }
            if (this.mTag != null) {
                a.setTag(this.mTag);
            }
            if (!TextUtils.isEmpty(this.mIr)) {
                a.Qj(this.mIr);
            }
            if (!TextUtils.isEmpty(this.mIt)) {
                a.Qk(this.mIt);
            }
            return a;
        }
    }

    /* loaded from: classes19.dex */
    public static abstract class Callback {
        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) throws Exception;

        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException);

        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) throws Exception;

        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) throws Exception;

        public abstract void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo);

        public void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        }
    }

    /* loaded from: classes19.dex */
    public static class Status {
        static final /* synthetic */ boolean $assertionsDisabled;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes19.dex */
        public @interface StatusValues {
        }

        static {
            $assertionsDisabled = !UrlRequest.class.desiredAssertionStatus();
        }

        private Status() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int HV(int i) {
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
