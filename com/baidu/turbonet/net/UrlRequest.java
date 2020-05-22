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
        public abstract void Gs(int i);
    }

    void FZ(int i);

    void Ga(int i);

    void Gb(int i);

    void OJ(String str);

    void OK(String str);

    void OL(String str);

    void a(UploadDataProvider uploadDataProvider, Executor executor);

    void addHeader(String str, String str2);

    void cancel();

    void dql();

    void dqm();

    void dqn();

    Object getTag();

    void m(ByteBuffer byteBuffer);

    void setTag(Object obj);

    void setTimeout(int i);

    void start();

    /* loaded from: classes.dex */
    public static final class Builder {
        String cVs;
        final Executor mExecutor;
        Object mTag;
        final String mUrl;
        final Callback mcH;
        boolean mcX;
        boolean mcY;
        boolean mcZ;
        boolean mdb;
        int mdc;
        int mdd;
        int mde;
        int mdf;
        String mdg;
        String mdh;
        final TurbonetEngine met;
        UploadDataProvider mfg;
        Executor mfh;
        boolean mfi;
        final ArrayList<Pair<String, String>> mff = new ArrayList<>();
        int mPriority = 3;
        Collection<Object> mcW = Collections.emptyList();

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
            this.mcH = callback;
            this.mExecutor = executor;
            this.met = turbonetEngine;
            this.mfi = false;
            this.mdb = false;
            this.mdc = 0;
            this.mdd = 0;
            this.mde = 0;
            this.mdf = 0;
            this.mTag = null;
            this.mdg = null;
            this.mdh = null;
        }

        public Builder OV(String str) {
            if (str == null) {
                throw new NullPointerException("Method is required.");
            }
            this.cVs = str;
            return this;
        }

        public Builder fF(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("Invalid header name.");
            }
            if (str2 == null) {
                throw new NullPointerException("Invalid header value.");
            }
            if (Headers.ACCEPT_ENCODING.equalsIgnoreCase(str)) {
                Log.w("cronet", "It's not necessary to set Accept-Encoding on requests - cronet will do this automatically for you, and setting it yourself has no effect. See https://crbug.com/581399 for details.", new Exception());
            } else {
                this.mff.add(Pair.create(str, str2));
            }
            return this;
        }

        public Builder drf() {
            this.mcX = true;
            return this;
        }

        public Builder drg() {
            this.mfi = true;
            return this;
        }

        public Builder drh() {
            this.mcZ = true;
            return this;
        }

        public Builder Go(int i) {
            this.mdc = i;
            return this;
        }

        public Builder Gp(int i) {
            this.mdd = i;
            return this;
        }

        public Builder Gq(int i) {
            this.mde = i;
            return this;
        }

        public Builder OW(String str) {
            this.mdg = str;
            return this;
        }

        public Builder OX(String str) {
            this.mdh = str;
            return this;
        }

        public Builder b(UploadDataProvider uploadDataProvider, Executor executor) {
            if (uploadDataProvider == null) {
                throw new NullPointerException("Invalid UploadDataProvider.");
            }
            if (executor == null) {
                throw new NullPointerException("Invalid UploadDataProvider Executor.");
            }
            if (this.cVs == null) {
                this.cVs = "POST";
            }
            this.mfg = uploadDataProvider;
            this.mfh = executor;
            return this;
        }

        public UrlRequest dri() {
            UrlRequest a = this.met.a(this.mUrl, this.mcH, this.mExecutor, this.mPriority, this.mcW, this.mcX, this.mcY, this.mcZ);
            if (this.cVs != null) {
                a.OJ(this.cVs);
            }
            Iterator<Pair<String, String>> it = this.mff.iterator();
            while (it.hasNext()) {
                Pair<String, String> next = it.next();
                a.addHeader((String) next.first, (String) next.second);
            }
            if (this.mfg != null) {
                a.a(this.mfg, this.mfh);
            }
            if (this.mfi) {
                a.dqm();
            }
            if (this.mdb) {
                a.dqn();
            }
            if (this.mdc > 0) {
                a.setTimeout(this.mdc);
            }
            if (this.mdd > 0) {
                a.FZ(this.mdd);
            }
            if (this.mde > 0) {
                a.Ga(this.mde);
            }
            if (this.mdf > 0) {
                a.Gb(this.mdf);
            }
            if (this.mTag != null) {
                a.setTag(this.mTag);
            }
            if (!TextUtils.isEmpty(this.mdg)) {
                a.OK(this.mdg);
            }
            if (!TextUtils.isEmpty(this.mdh)) {
                a.OL(this.mdh);
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
        public static int Gr(int i) {
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
