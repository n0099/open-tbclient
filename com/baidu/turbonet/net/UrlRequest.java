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
/* loaded from: classes17.dex */
public interface UrlRequest {

    /* loaded from: classes17.dex */
    public static abstract class StatusListener {
        public abstract void Nc(int i);
    }

    void MJ(int i);

    void MK(int i);

    void ML(int i);

    void Wl(String str);

    void Wm(String str);

    void Wn(String str);

    void a(UploadDataProvider uploadDataProvider, Executor executor);

    void addHeader(String str, String str2);

    void cancel();

    void ebC();

    void ebD();

    void ebE();

    Object getTag();

    void n(ByteBuffer byteBuffer);

    void setTag(Object obj);

    void setTimeout(int i);

    void start();

    /* loaded from: classes17.dex */
    public static final class Builder {
        String dSu;
        final Executor mExecutor;
        Object mTag;
        final String mUrl;
        boolean omA;
        boolean omC;
        int omD;
        int omE;
        int omF;
        int omG;
        String omH;
        String omI;
        final Callback omi;
        boolean omy;
        boolean omz;
        final TurbonetEngine onV;
        UploadDataProvider ooI;
        Executor ooJ;
        boolean ooK;
        final ArrayList<Pair<String, String>> ooH = new ArrayList<>();
        int mPriority = 3;
        Collection<Object> omx = Collections.emptyList();

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes17.dex */
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
            this.omi = callback;
            this.mExecutor = executor;
            this.onV = turbonetEngine;
            this.ooK = false;
            this.omC = false;
            this.omD = 0;
            this.omE = 0;
            this.omF = 0;
            this.omG = 0;
            this.mTag = null;
            this.omH = null;
            this.omI = null;
        }

        public Builder Wx(String str) {
            if (str == null) {
                throw new NullPointerException("Method is required.");
            }
            this.dSu = str;
            return this;
        }

        public Builder gQ(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("Invalid header name.");
            }
            if (str2 == null) {
                throw new NullPointerException("Invalid header value.");
            }
            if (Headers.ACCEPT_ENCODING.equalsIgnoreCase(str)) {
                Log.w("cronet", "It's not necessary to set Accept-Encoding on requests - cronet will do this automatically for you, and setting it yourself has no effect. See https://crbug.com/581399 for details.", new Exception());
            } else {
                this.ooH.add(Pair.create(str, str2));
            }
            return this;
        }

        public Builder ecv() {
            this.omy = true;
            return this;
        }

        public Builder ecw() {
            this.ooK = true;
            return this;
        }

        public Builder ecx() {
            this.omA = true;
            return this;
        }

        public Builder MY(int i) {
            this.omD = i;
            return this;
        }

        public Builder MZ(int i) {
            this.omE = i;
            return this;
        }

        public Builder Na(int i) {
            this.omF = i;
            return this;
        }

        public Builder Wy(String str) {
            this.omH = str;
            return this;
        }

        public Builder Wz(String str) {
            this.omI = str;
            return this;
        }

        public Builder b(UploadDataProvider uploadDataProvider, Executor executor) {
            if (uploadDataProvider == null) {
                throw new NullPointerException("Invalid UploadDataProvider.");
            }
            if (executor == null) {
                throw new NullPointerException("Invalid UploadDataProvider Executor.");
            }
            if (this.dSu == null) {
                this.dSu = "POST";
            }
            this.ooI = uploadDataProvider;
            this.ooJ = executor;
            return this;
        }

        public UrlRequest ecy() {
            UrlRequest a2 = this.onV.a(this.mUrl, this.omi, this.mExecutor, this.mPriority, this.omx, this.omy, this.omz, this.omA);
            if (this.dSu != null) {
                a2.Wl(this.dSu);
            }
            Iterator<Pair<String, String>> it = this.ooH.iterator();
            while (it.hasNext()) {
                Pair<String, String> next = it.next();
                a2.addHeader((String) next.first, (String) next.second);
            }
            if (this.ooI != null) {
                a2.a(this.ooI, this.ooJ);
            }
            if (this.ooK) {
                a2.ebD();
            }
            if (this.omC) {
                a2.ebE();
            }
            if (this.omD > 0) {
                a2.setTimeout(this.omD);
            }
            if (this.omE > 0) {
                a2.MJ(this.omE);
            }
            if (this.omF > 0) {
                a2.MK(this.omF);
            }
            if (this.omG > 0) {
                a2.ML(this.omG);
            }
            if (this.mTag != null) {
                a2.setTag(this.mTag);
            }
            if (!TextUtils.isEmpty(this.omH)) {
                a2.Wm(this.omH);
            }
            if (!TextUtils.isEmpty(this.omI)) {
                a2.Wn(this.omI);
            }
            return a2;
        }
    }

    /* loaded from: classes17.dex */
    public static abstract class Callback {
        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) throws Exception;

        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException);

        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) throws Exception;

        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) throws Exception;

        public abstract void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo);

        public void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        }
    }

    /* loaded from: classes17.dex */
    public static class Status {
        static final /* synthetic */ boolean $assertionsDisabled;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes17.dex */
        public @interface StatusValues {
        }

        static {
            $assertionsDisabled = !UrlRequest.class.desiredAssertionStatus();
        }

        private Status() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int Nb(int i) {
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
