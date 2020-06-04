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
        public abstract void Gu(int i);
    }

    void Gb(int i);

    void Gc(int i);

    void Gd(int i);

    void OK(String str);

    void OL(String str);

    void OM(String str);

    void a(UploadDataProvider uploadDataProvider, Executor executor);

    void addHeader(String str, String str2);

    void cancel();

    void dqA();

    void dqB();

    void dqz();

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
        final Callback mdR;
        boolean meh;
        boolean mei;
        boolean mej;
        boolean mel;
        int mem;
        int men;
        int meo;
        int mep;
        String meq;
        String mer;
        final TurbonetEngine mfD;
        UploadDataProvider mgq;
        Executor mgr;
        boolean mgs;
        final ArrayList<Pair<String, String>> mgp = new ArrayList<>();
        int mPriority = 3;
        Collection<Object> meg = Collections.emptyList();

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
            this.mdR = callback;
            this.mExecutor = executor;
            this.mfD = turbonetEngine;
            this.mgs = false;
            this.mel = false;
            this.mem = 0;
            this.men = 0;
            this.meo = 0;
            this.mep = 0;
            this.mTag = null;
            this.meq = null;
            this.mer = null;
        }

        public Builder OW(String str) {
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
                this.mgp.add(Pair.create(str, str2));
            }
            return this;
        }

        public Builder drt() {
            this.meh = true;
            return this;
        }

        public Builder dru() {
            this.mgs = true;
            return this;
        }

        public Builder drv() {
            this.mej = true;
            return this;
        }

        public Builder Gq(int i) {
            this.mem = i;
            return this;
        }

        public Builder Gr(int i) {
            this.men = i;
            return this;
        }

        public Builder Gs(int i) {
            this.meo = i;
            return this;
        }

        public Builder OX(String str) {
            this.meq = str;
            return this;
        }

        public Builder OY(String str) {
            this.mer = str;
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
            this.mgq = uploadDataProvider;
            this.mgr = executor;
            return this;
        }

        public UrlRequest drw() {
            UrlRequest a = this.mfD.a(this.mUrl, this.mdR, this.mExecutor, this.mPriority, this.meg, this.meh, this.mei, this.mej);
            if (this.cVs != null) {
                a.OK(this.cVs);
            }
            Iterator<Pair<String, String>> it = this.mgp.iterator();
            while (it.hasNext()) {
                Pair<String, String> next = it.next();
                a.addHeader((String) next.first, (String) next.second);
            }
            if (this.mgq != null) {
                a.a(this.mgq, this.mgr);
            }
            if (this.mgs) {
                a.dqA();
            }
            if (this.mel) {
                a.dqB();
            }
            if (this.mem > 0) {
                a.setTimeout(this.mem);
            }
            if (this.men > 0) {
                a.Gb(this.men);
            }
            if (this.meo > 0) {
                a.Gc(this.meo);
            }
            if (this.mep > 0) {
                a.Gd(this.mep);
            }
            if (this.mTag != null) {
                a.setTag(this.mTag);
            }
            if (!TextUtils.isEmpty(this.meq)) {
                a.OL(this.meq);
            }
            if (!TextUtils.isEmpty(this.mer)) {
                a.OM(this.mer);
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
        public static int Gt(int i) {
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
