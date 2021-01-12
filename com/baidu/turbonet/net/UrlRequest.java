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
/* loaded from: classes4.dex */
public interface UrlRequest {

    /* loaded from: classes4.dex */
    public static abstract class StatusListener {
        public abstract void onStatus(int i);
    }

    void Mq(int i);

    void Mr(int i);

    void Ms(int i);

    void VM(String str);

    void VN(String str);

    void a(UploadDataProvider uploadDataProvider, Executor executor);

    void addHeader(String str, String str2);

    void cancel();

    void edL();

    void edM();

    void followRedirect();

    Object getTag();

    void read(ByteBuffer byteBuffer);

    void setHttpMethod(String str);

    void setTag(Object obj);

    void setTimeout(int i);

    void start();

    /* loaded from: classes4.dex */
    public static final class Builder {
        boolean mDisableCache;
        boolean mDisableConnectionMigration;
        final Executor mExecutor;
        String mMethod;
        Object mTag;
        Executor mUploadDataProviderExecutor;
        final String mUrl;
        boolean oFA;
        boolean oFC;
        int oFD;
        int oFE;
        int oFF;
        int oFG;
        String oFH;
        String oFI;
        final Callback oFl;
        final TurbonetEngine oGA;
        UploadDataProvider oHe;
        boolean oHf;
        final ArrayList<Pair<String, String>> mRequestHeaders = new ArrayList<>();
        int mPriority = 3;
        Collection<Object> mRequestAnnotations = Collections.emptyList();

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes4.dex */
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
            this.oFl = callback;
            this.mExecutor = executor;
            this.oGA = turbonetEngine;
            this.oHf = false;
            this.oFC = false;
            this.oFD = 0;
            this.oFE = 0;
            this.oFF = 0;
            this.oFG = 0;
            this.mTag = null;
            this.oFH = null;
            this.oFI = null;
        }

        public Builder VX(String str) {
            if (str == null) {
                throw new NullPointerException("Method is required.");
            }
            this.mMethod = str;
            return this;
        }

        public Builder gS(String str, String str2) {
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

        public Builder eew() {
            this.mDisableCache = true;
            return this;
        }

        public Builder eex() {
            this.oHf = true;
            return this;
        }

        public Builder eey() {
            this.oFA = true;
            return this;
        }

        public Builder MC(int i) {
            this.oFD = i;
            return this;
        }

        public Builder MD(int i) {
            this.oFE = i;
            return this;
        }

        public Builder ME(int i) {
            this.oFF = i;
            return this;
        }

        public Builder VY(String str) {
            this.oFH = str;
            return this;
        }

        public Builder VZ(String str) {
            this.oFI = str;
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
            this.oHe = uploadDataProvider;
            this.mUploadDataProviderExecutor = executor;
            return this;
        }

        public UrlRequest eez() {
            UrlRequest a2 = this.oGA.a(this.mUrl, this.oFl, this.mExecutor, this.mPriority, this.mRequestAnnotations, this.mDisableCache, this.mDisableConnectionMigration, this.oFA);
            if (this.mMethod != null) {
                a2.setHttpMethod(this.mMethod);
            }
            Iterator<Pair<String, String>> it = this.mRequestHeaders.iterator();
            while (it.hasNext()) {
                Pair<String, String> next = it.next();
                a2.addHeader((String) next.first, (String) next.second);
            }
            if (this.oHe != null) {
                a2.a(this.oHe, this.mUploadDataProviderExecutor);
            }
            if (this.oHf) {
                a2.edL();
            }
            if (this.oFC) {
                a2.edM();
            }
            if (this.oFD > 0) {
                a2.setTimeout(this.oFD);
            }
            if (this.oFE > 0) {
                a2.Mq(this.oFE);
            }
            if (this.oFF > 0) {
                a2.Mr(this.oFF);
            }
            if (this.oFG > 0) {
                a2.Ms(this.oFG);
            }
            if (this.mTag != null) {
                a2.setTag(this.mTag);
            }
            if (!TextUtils.isEmpty(this.oFH)) {
                a2.VM(this.oFH);
            }
            if (!TextUtils.isEmpty(this.oFI)) {
                a2.VN(this.oFI);
            }
            return a2;
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class Callback {
        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) throws Exception;

        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException);

        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) throws Exception;

        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) throws Exception;

        public abstract void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo);

        public void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        }
    }

    /* loaded from: classes4.dex */
    public static class Status {
        static final /* synthetic */ boolean $assertionsDisabled;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes4.dex */
        public @interface StatusValues {
        }

        static {
            $assertionsDisabled = !UrlRequest.class.desiredAssertionStatus();
        }

        private Status() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int MF(int i) {
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
