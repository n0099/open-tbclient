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
/* loaded from: classes12.dex */
public interface UrlRequest {

    /* loaded from: classes12.dex */
    public static abstract class StatusListener {
        public abstract void NF(int i);
    }

    void Nm(int i);

    void Nn(int i);

    void No(int i);

    void VW(String str);

    void VX(String str);

    void VY(String str);

    void a(UploadDataProvider uploadDataProvider, Executor executor);

    void addHeader(String str, String str2);

    void cancel();

    void ebB();

    void ebC();

    void ebD();

    Object getTag();

    void n(ByteBuffer byteBuffer);

    void setTag(Object obj);

    void setTimeout(int i);

    void start();

    /* loaded from: classes12.dex */
    public static final class Builder {
        String dQM;
        final Executor mExecutor;
        Object mTag;
        final String mUrl;
        final Callback onM;
        boolean ooc;
        boolean ood;
        boolean ooe;
        boolean oog;
        int ooh;
        int ooi;
        int ooj;
        int ook;
        String ool;
        String oom;
        final TurbonetEngine opz;
        UploadDataProvider oqm;
        Executor oqn;
        boolean oqo;
        final ArrayList<Pair<String, String>> oql = new ArrayList<>();
        int mPriority = 3;
        Collection<Object> oob = Collections.emptyList();

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes12.dex */
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
            this.onM = callback;
            this.mExecutor = executor;
            this.opz = turbonetEngine;
            this.oqo = false;
            this.oog = false;
            this.ooh = 0;
            this.ooi = 0;
            this.ooj = 0;
            this.ook = 0;
            this.mTag = null;
            this.ool = null;
            this.oom = null;
        }

        public Builder Wi(String str) {
            if (str == null) {
                throw new NullPointerException("Method is required.");
            }
            this.dQM = str;
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
                this.oql.add(Pair.create(str, str2));
            }
            return this;
        }

        public Builder ecu() {
            this.ooc = true;
            return this;
        }

        public Builder ecv() {
            this.oqo = true;
            return this;
        }

        public Builder ecw() {
            this.ooe = true;
            return this;
        }

        public Builder NB(int i) {
            this.ooh = i;
            return this;
        }

        public Builder NC(int i) {
            this.ooi = i;
            return this;
        }

        public Builder ND(int i) {
            this.ooj = i;
            return this;
        }

        public Builder Wj(String str) {
            this.ool = str;
            return this;
        }

        public Builder Wk(String str) {
            this.oom = str;
            return this;
        }

        public Builder b(UploadDataProvider uploadDataProvider, Executor executor) {
            if (uploadDataProvider == null) {
                throw new NullPointerException("Invalid UploadDataProvider.");
            }
            if (executor == null) {
                throw new NullPointerException("Invalid UploadDataProvider Executor.");
            }
            if (this.dQM == null) {
                this.dQM = "POST";
            }
            this.oqm = uploadDataProvider;
            this.oqn = executor;
            return this;
        }

        public UrlRequest ecx() {
            UrlRequest a2 = this.opz.a(this.mUrl, this.onM, this.mExecutor, this.mPriority, this.oob, this.ooc, this.ood, this.ooe);
            if (this.dQM != null) {
                a2.VW(this.dQM);
            }
            Iterator<Pair<String, String>> it = this.oql.iterator();
            while (it.hasNext()) {
                Pair<String, String> next = it.next();
                a2.addHeader((String) next.first, (String) next.second);
            }
            if (this.oqm != null) {
                a2.a(this.oqm, this.oqn);
            }
            if (this.oqo) {
                a2.ebC();
            }
            if (this.oog) {
                a2.ebD();
            }
            if (this.ooh > 0) {
                a2.setTimeout(this.ooh);
            }
            if (this.ooi > 0) {
                a2.Nm(this.ooi);
            }
            if (this.ooj > 0) {
                a2.Nn(this.ooj);
            }
            if (this.ook > 0) {
                a2.No(this.ook);
            }
            if (this.mTag != null) {
                a2.setTag(this.mTag);
            }
            if (!TextUtils.isEmpty(this.ool)) {
                a2.VX(this.ool);
            }
            if (!TextUtils.isEmpty(this.oom)) {
                a2.VY(this.oom);
            }
            return a2;
        }
    }

    /* loaded from: classes12.dex */
    public static abstract class Callback {
        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) throws Exception;

        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException);

        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) throws Exception;

        public abstract void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) throws Exception;

        public abstract void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo);

        public void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        }
    }

    /* loaded from: classes12.dex */
    public static class Status {
        static final /* synthetic */ boolean $assertionsDisabled;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes12.dex */
        public @interface StatusValues {
        }

        static {
            $assertionsDisabled = !UrlRequest.class.desiredAssertionStatus();
        }

        private Status() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int NE(int i) {
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
