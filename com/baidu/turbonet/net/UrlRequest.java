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
/* loaded from: classes14.dex */
public interface UrlRequest {

    /* loaded from: classes14.dex */
    public static abstract class StatusListener {
        public abstract void Ox(int i);
    }

    void Oe(int i);

    void Of(int i);

    void Og(int i);

    void Xl(String str);

    void Xm(String str);

    void Xn(String str);

    void a(UploadDataProvider uploadDataProvider, Executor executor);

    void addHeader(String str, String str2);

    void cancel();

    void ehg();

    void ehh();

    void ehi();

    Object getTag();

    void n(ByteBuffer byteBuffer);

    void setTag(Object obj);

    void setTimeout(int i);

    void start();

    /* loaded from: classes14.dex */
    public static final class Builder {
        String dXK;
        final Executor mExecutor;
        Object mTag;
        final String mUrl;
        final Callback oCK;
        boolean oDa;
        boolean oDb;
        boolean oDc;
        boolean oDe;
        int oDf;
        int oDg;
        int oDh;
        int oDi;
        String oDj;
        String oDk;
        final TurbonetEngine oEw;
        UploadDataProvider oFi;
        Executor oFj;
        boolean oFk;
        final ArrayList<Pair<String, String>> oFh = new ArrayList<>();
        int mPriority = 3;
        Collection<Object> oCZ = Collections.emptyList();

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes14.dex */
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
            this.oCK = callback;
            this.mExecutor = executor;
            this.oEw = turbonetEngine;
            this.oFk = false;
            this.oDe = false;
            this.oDf = 0;
            this.oDg = 0;
            this.oDh = 0;
            this.oDi = 0;
            this.mTag = null;
            this.oDj = null;
            this.oDk = null;
        }

        public Builder Xx(String str) {
            if (str == null) {
                throw new NullPointerException("Method is required.");
            }
            this.dXK = str;
            return this;
        }

        public Builder gV(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("Invalid header name.");
            }
            if (str2 == null) {
                throw new NullPointerException("Invalid header value.");
            }
            if (Headers.ACCEPT_ENCODING.equalsIgnoreCase(str)) {
                Log.w("cronet", "It's not necessary to set Accept-Encoding on requests - cronet will do this automatically for you, and setting it yourself has no effect. See https://crbug.com/581399 for details.", new Exception());
            } else {
                this.oFh.add(Pair.create(str, str2));
            }
            return this;
        }

        public Builder ehZ() {
            this.oDa = true;
            return this;
        }

        public Builder eia() {
            this.oFk = true;
            return this;
        }

        public Builder eib() {
            this.oDc = true;
            return this;
        }

        public Builder Ot(int i) {
            this.oDf = i;
            return this;
        }

        public Builder Ou(int i) {
            this.oDg = i;
            return this;
        }

        public Builder Ov(int i) {
            this.oDh = i;
            return this;
        }

        public Builder Xy(String str) {
            this.oDj = str;
            return this;
        }

        public Builder Xz(String str) {
            this.oDk = str;
            return this;
        }

        public Builder b(UploadDataProvider uploadDataProvider, Executor executor) {
            if (uploadDataProvider == null) {
                throw new NullPointerException("Invalid UploadDataProvider.");
            }
            if (executor == null) {
                throw new NullPointerException("Invalid UploadDataProvider Executor.");
            }
            if (this.dXK == null) {
                this.dXK = "POST";
            }
            this.oFi = uploadDataProvider;
            this.oFj = executor;
            return this;
        }

        public UrlRequest eic() {
            UrlRequest a2 = this.oEw.a(this.mUrl, this.oCK, this.mExecutor, this.mPriority, this.oCZ, this.oDa, this.oDb, this.oDc);
            if (this.dXK != null) {
                a2.Xl(this.dXK);
            }
            Iterator<Pair<String, String>> it = this.oFh.iterator();
            while (it.hasNext()) {
                Pair<String, String> next = it.next();
                a2.addHeader((String) next.first, (String) next.second);
            }
            if (this.oFi != null) {
                a2.a(this.oFi, this.oFj);
            }
            if (this.oFk) {
                a2.ehh();
            }
            if (this.oDe) {
                a2.ehi();
            }
            if (this.oDf > 0) {
                a2.setTimeout(this.oDf);
            }
            if (this.oDg > 0) {
                a2.Oe(this.oDg);
            }
            if (this.oDh > 0) {
                a2.Of(this.oDh);
            }
            if (this.oDi > 0) {
                a2.Og(this.oDi);
            }
            if (this.mTag != null) {
                a2.setTag(this.mTag);
            }
            if (!TextUtils.isEmpty(this.oDj)) {
                a2.Xm(this.oDj);
            }
            if (!TextUtils.isEmpty(this.oDk)) {
                a2.Xn(this.oDk);
            }
            return a2;
        }
    }

    /* loaded from: classes14.dex */
    public static abstract class Callback {
        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) throws Exception;

        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException);

        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) throws Exception;

        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) throws Exception;

        public abstract void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo);

        public void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        }
    }

    /* loaded from: classes14.dex */
    public static class Status {
        static final /* synthetic */ boolean $assertionsDisabled;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes14.dex */
        public @interface StatusValues {
        }

        static {
            $assertionsDisabled = !UrlRequest.class.desiredAssertionStatus();
        }

        private Status() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int Ow(int i) {
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
