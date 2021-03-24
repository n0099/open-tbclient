package com.baidu.turbonet.net;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
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
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public final TurbonetEngine f22853a;

        /* renamed from: b  reason: collision with root package name */
        public final String f22854b;

        /* renamed from: c  reason: collision with root package name */
        public final Callback f22855c;

        /* renamed from: d  reason: collision with root package name */
        public final Executor f22856d;

        /* renamed from: e  reason: collision with root package name */
        public String f22857e;

        /* renamed from: g  reason: collision with root package name */
        public boolean f22859g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f22860h;
        public UploadDataProvider k;
        public Executor l;
        public boolean m;
        public boolean n;
        public boolean o;
        public int p;
        public int q;
        public int r;
        public int s;
        public Object t;
        public String u;
        public String v;

        /* renamed from: f  reason: collision with root package name */
        public final ArrayList<Pair<String, String>> f22858f = new ArrayList<>();
        public int i = 3;
        public Collection<Object> j = Collections.emptyList();

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
            if (turbonetEngine != null) {
                this.f22854b = str;
                this.f22855c = callback;
                this.f22856d = executor;
                this.f22853a = turbonetEngine;
                this.m = false;
                this.o = false;
                this.p = 0;
                this.q = 0;
                this.r = 0;
                this.s = 0;
                this.t = null;
                this.u = null;
                this.v = null;
                return;
            }
            throw new NullPointerException("TurbonetEngine is required.");
        }

        public Builder a(String str, String str2) {
            if (str != null) {
                if (str2 != null) {
                    if ("Accept-Encoding".equalsIgnoreCase(str)) {
                        Log.w("cronet", "It's not necessary to set Accept-Encoding on requests - cronet will do this automatically for you, and setting it yourself has no effect. See https://crbug.com/581399 for details.", new Exception());
                        return this;
                    }
                    this.f22858f.add(Pair.create(str, str2));
                    return this;
                }
                throw new NullPointerException("Invalid header value.");
            }
            throw new NullPointerException("Invalid header name.");
        }

        public UrlRequest b() {
            UrlRequest b2 = this.f22853a.b(this.f22854b, this.f22855c, this.f22856d, this.i, this.j, this.f22859g, this.f22860h, this.n);
            String str = this.f22857e;
            if (str != null) {
                b2.g(str);
            }
            Iterator<Pair<String, String>> it = this.f22858f.iterator();
            while (it.hasNext()) {
                Pair<String, String> next = it.next();
                b2.addHeader((String) next.first, (String) next.second);
            }
            UploadDataProvider uploadDataProvider = this.k;
            if (uploadDataProvider != null) {
                b2.l(uploadDataProvider, this.l);
            }
            if (this.m) {
                b2.k();
            }
            if (this.o) {
                b2.j();
            }
            int i = this.p;
            if (i > 0) {
                b2.c(i);
            }
            int i2 = this.q;
            if (i2 > 0) {
                b2.h(i2);
            }
            int i3 = this.r;
            if (i3 > 0) {
                b2.e(i3);
            }
            int i4 = this.s;
            if (i4 > 0) {
                b2.b(i4);
            }
            Object obj = this.t;
            if (obj != null) {
                b2.i(obj);
            }
            if (!TextUtils.isEmpty(this.u)) {
                b2.d(this.u);
            }
            if (!TextUtils.isEmpty(this.v)) {
                b2.a(this.v);
            }
            return b2;
        }

        public Builder c() {
            this.f22859g = true;
            return this;
        }

        public Builder d() {
            this.m = true;
            return this;
        }

        public Builder e(String str) {
            this.u = str;
            return this;
        }

        public Builder f(String str) {
            if (str != null) {
                this.f22857e = str;
                return this;
            }
            throw new NullPointerException("Method is required.");
        }

        public Builder g(String str) {
            this.v = str;
            return this;
        }

        public Builder h(int i) {
            this.r = i;
            return this;
        }

        public Builder i(int i) {
            this.q = i;
            return this;
        }

        public Builder j(int i) {
            this.p = i;
            return this;
        }

        public Builder k(UploadDataProvider uploadDataProvider, Executor executor) {
            if (uploadDataProvider != null) {
                if (executor != null) {
                    if (this.f22857e == null) {
                        this.f22857e = "POST";
                    }
                    this.k = uploadDataProvider;
                    this.l = executor;
                    return this;
                }
                throw new NullPointerException("Invalid UploadDataProvider Executor.");
            }
            throw new NullPointerException("Invalid UploadDataProvider.");
        }

        public Builder l() {
            this.n = true;
            return this;
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class Callback {
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        }

        public abstract void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException);

        public abstract void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) throws Exception;

        public abstract void d(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) throws Exception;

        public abstract void e(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) throws Exception;

        public abstract void f(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo);
    }

    /* loaded from: classes5.dex */
    public static class Status {

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        public @interface StatusValues {
        }

        public static int a(int i) {
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
    }

    /* loaded from: classes5.dex */
    public static abstract class StatusListener {
        public abstract void a(int i);
    }

    void a(String str);

    void addHeader(String str, String str2);

    void b(int i);

    void c(int i);

    void cancel();

    void d(String str);

    void e(int i);

    void f();

    void g(String str);

    Object getTag();

    void h(int i);

    void i(Object obj);

    void j();

    void k();

    void l(UploadDataProvider uploadDataProvider, Executor executor);

    void read(ByteBuffer byteBuffer);

    void start();
}
