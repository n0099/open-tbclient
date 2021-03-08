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
/* loaded from: classes5.dex */
public interface UrlRequest {

    /* loaded from: classes5.dex */
    public static abstract class StatusListener {
        public abstract void onStatus(int i);
    }

    void MR(int i);

    void MS(int i);

    void MT(int i);

    void Xf(String str);

    void Xg(String str);

    void a(UploadDataProvider uploadDataProvider, Executor executor);

    void addHeader(String str, String str2);

    void cancel();

    void egt();

    void egu();

    void followRedirect();

    Object getTag();

    void read(ByteBuffer byteBuffer);

    void setHttpMethod(String str);

    void setTag(Object obj);

    void setTimeout(int i);

    void start();

    /* loaded from: classes5.dex */
    public static final class Builder {
        boolean mDisableCache;
        boolean mDisableConnectionMigration;
        final Executor mExecutor;
        String mMethod;
        Object mTag;
        int mTimeout;
        Executor mUploadDataProviderExecutor;
        final String mUrl;
        final Callback oSa;
        boolean oSp;
        boolean oSr;
        int oSs;
        int oSt;
        int oSu;
        String oSv;
        String oSw;
        UploadDataProvider oTS;
        boolean oTT;
        final TurbonetEngine oTo;
        final ArrayList<Pair<String, String>> mRequestHeaders = new ArrayList<>();
        int mPriority = 3;
        Collection<Object> mRequestAnnotations = Collections.emptyList();

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes5.dex */
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
            this.oSa = callback;
            this.mExecutor = executor;
            this.oTo = turbonetEngine;
            this.oTT = false;
            this.oSr = false;
            this.mTimeout = 0;
            this.oSs = 0;
            this.oSt = 0;
            this.oSu = 0;
            this.mTag = null;
            this.oSv = null;
            this.oSw = null;
        }

        public Builder Xq(String str) {
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

        public Builder ehe() {
            this.mDisableCache = true;
            return this;
        }

        public Builder ehf() {
            this.oTT = true;
            return this;
        }

        public Builder ehg() {
            this.oSp = true;
            return this;
        }

        public Builder Nd(int i) {
            this.mTimeout = i;
            return this;
        }

        public Builder Ne(int i) {
            this.oSs = i;
            return this;
        }

        public Builder Nf(int i) {
            this.oSt = i;
            return this;
        }

        public Builder Xr(String str) {
            this.oSv = str;
            return this;
        }

        public Builder Xs(String str) {
            this.oSw = str;
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
            this.oTS = uploadDataProvider;
            this.mUploadDataProviderExecutor = executor;
            return this;
        }

        public UrlRequest ehh() {
            UrlRequest a2 = this.oTo.a(this.mUrl, this.oSa, this.mExecutor, this.mPriority, this.mRequestAnnotations, this.mDisableCache, this.mDisableConnectionMigration, this.oSp);
            if (this.mMethod != null) {
                a2.setHttpMethod(this.mMethod);
            }
            Iterator<Pair<String, String>> it = this.mRequestHeaders.iterator();
            while (it.hasNext()) {
                Pair<String, String> next = it.next();
                a2.addHeader((String) next.first, (String) next.second);
            }
            if (this.oTS != null) {
                a2.a(this.oTS, this.mUploadDataProviderExecutor);
            }
            if (this.oTT) {
                a2.egt();
            }
            if (this.oSr) {
                a2.egu();
            }
            if (this.mTimeout > 0) {
                a2.setTimeout(this.mTimeout);
            }
            if (this.oSs > 0) {
                a2.MR(this.oSs);
            }
            if (this.oSt > 0) {
                a2.MS(this.oSt);
            }
            if (this.oSu > 0) {
                a2.MT(this.oSu);
            }
            if (this.mTag != null) {
                a2.setTag(this.mTag);
            }
            if (!TextUtils.isEmpty(this.oSv)) {
                a2.Xf(this.oSv);
            }
            if (!TextUtils.isEmpty(this.oSw)) {
                a2.Xg(this.oSw);
            }
            return a2;
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class Callback {
        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) throws Exception;

        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException);

        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) throws Exception;

        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) throws Exception;

        public abstract void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo);

        public void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        }
    }

    /* loaded from: classes5.dex */
    public static class Status {
        static final /* synthetic */ boolean $assertionsDisabled;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes5.dex */
        public @interface StatusValues {
        }

        static {
            $assertionsDisabled = !UrlRequest.class.desiredAssertionStatus();
        }

        private Status() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int Ng(int i) {
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
