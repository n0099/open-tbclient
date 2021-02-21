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
/* loaded from: classes6.dex */
public interface UrlRequest {

    /* loaded from: classes6.dex */
    public static abstract class StatusListener {
        public abstract void onStatus(int i);
    }

    void MN(int i);

    void MO(int i);

    void MP(int i);

    void WY(String str);

    void WZ(String str);

    void a(UploadDataProvider uploadDataProvider, Executor executor);

    void addHeader(String str, String str2);

    void cancel();

    void egl();

    void egm();

    void followRedirect();

    Object getTag();

    void read(ByteBuffer byteBuffer);

    void setHttpMethod(String str);

    void setTag(Object obj);

    void setTimeout(int i);

    void start();

    /* loaded from: classes6.dex */
    public static final class Builder {
        boolean mDisableCache;
        boolean mDisableConnectionMigration;
        final Executor mExecutor;
        String mMethod;
        Object mTag;
        int mTimeout;
        Executor mUploadDataProviderExecutor;
        final String mUrl;
        final Callback oPV;
        boolean oQk;
        boolean oQm;
        int oQn;
        int oQo;
        int oQp;
        String oQq;
        String oQr;
        UploadDataProvider oRN;
        boolean oRO;
        final TurbonetEngine oRj;
        final ArrayList<Pair<String, String>> mRequestHeaders = new ArrayList<>();
        int mPriority = 3;
        Collection<Object> mRequestAnnotations = Collections.emptyList();

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes6.dex */
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
            this.oPV = callback;
            this.mExecutor = executor;
            this.oRj = turbonetEngine;
            this.oRO = false;
            this.oQm = false;
            this.mTimeout = 0;
            this.oQn = 0;
            this.oQo = 0;
            this.oQp = 0;
            this.mTag = null;
            this.oQq = null;
            this.oQr = null;
        }

        public Builder Xj(String str) {
            if (str == null) {
                throw new NullPointerException("Method is required.");
            }
            this.mMethod = str;
            return this;
        }

        public Builder hb(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("Invalid header name.");
            }
            if (str2 == null) {
                throw new NullPointerException("Invalid header value.");
            }
            if (Headers.ACCEPT_ENCODING.equalsIgnoreCase(str)) {
                Log.w("cronet", "It's not necessary to set Accept-Encoding on requests - cronet will do this automatically for you, and setting it yourself has no effect. See https://crbug.com/581399 for details.", new Exception());
            } else {
                this.mRequestHeaders.add(Pair.create(str, str2));
            }
            return this;
        }

        public Builder egW() {
            this.mDisableCache = true;
            return this;
        }

        public Builder egX() {
            this.oRO = true;
            return this;
        }

        public Builder egY() {
            this.oQk = true;
            return this;
        }

        public Builder MZ(int i) {
            this.mTimeout = i;
            return this;
        }

        public Builder Na(int i) {
            this.oQn = i;
            return this;
        }

        public Builder Nb(int i) {
            this.oQo = i;
            return this;
        }

        public Builder Xk(String str) {
            this.oQq = str;
            return this;
        }

        public Builder Xl(String str) {
            this.oQr = str;
            return this;
        }

        public Builder b(UploadDataProvider uploadDataProvider, Executor executor) {
            if (uploadDataProvider == null) {
                throw new NullPointerException("Invalid UploadDataProvider.");
            }
            if (executor == null) {
                throw new NullPointerException("Invalid UploadDataProvider Executor.");
            }
            if (this.mMethod == null) {
                this.mMethod = "POST";
            }
            this.oRN = uploadDataProvider;
            this.mUploadDataProviderExecutor = executor;
            return this;
        }

        public UrlRequest egZ() {
            UrlRequest a2 = this.oRj.a(this.mUrl, this.oPV, this.mExecutor, this.mPriority, this.mRequestAnnotations, this.mDisableCache, this.mDisableConnectionMigration, this.oQk);
            if (this.mMethod != null) {
                a2.setHttpMethod(this.mMethod);
            }
            Iterator<Pair<String, String>> it = this.mRequestHeaders.iterator();
            while (it.hasNext()) {
                Pair<String, String> next = it.next();
                a2.addHeader((String) next.first, (String) next.second);
            }
            if (this.oRN != null) {
                a2.a(this.oRN, this.mUploadDataProviderExecutor);
            }
            if (this.oRO) {
                a2.egl();
            }
            if (this.oQm) {
                a2.egm();
            }
            if (this.mTimeout > 0) {
                a2.setTimeout(this.mTimeout);
            }
            if (this.oQn > 0) {
                a2.MN(this.oQn);
            }
            if (this.oQo > 0) {
                a2.MO(this.oQo);
            }
            if (this.oQp > 0) {
                a2.MP(this.oQp);
            }
            if (this.mTag != null) {
                a2.setTag(this.mTag);
            }
            if (!TextUtils.isEmpty(this.oQq)) {
                a2.WY(this.oQq);
            }
            if (!TextUtils.isEmpty(this.oQr)) {
                a2.WZ(this.oQr);
            }
            return a2;
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class Callback {
        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) throws Exception;

        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException);

        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) throws Exception;

        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) throws Exception;

        public abstract void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo);

        public void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        }
    }

    /* loaded from: classes6.dex */
    public static class Status {
        static final /* synthetic */ boolean $assertionsDisabled;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes6.dex */
        public @interface StatusValues {
        }

        static {
            $assertionsDisabled = !UrlRequest.class.desiredAssertionStatus();
        }

        private Status() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int Nc(int i) {
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
