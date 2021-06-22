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
        public final TurbonetEngine f22605a;

        /* renamed from: b  reason: collision with root package name */
        public final String f22606b;

        /* renamed from: c  reason: collision with root package name */
        public final Callback f22607c;

        /* renamed from: d  reason: collision with root package name */
        public final Executor f22608d;

        /* renamed from: e  reason: collision with root package name */
        public String f22609e;

        /* renamed from: g  reason: collision with root package name */
        public boolean f22611g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f22612h;
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
        public final ArrayList<Pair<String, String>> f22610f = new ArrayList<>();

        /* renamed from: i  reason: collision with root package name */
        public int f22613i = 3;
        public Collection<Object> j = Collections.emptyList();

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
            if (turbonetEngine != null) {
                this.f22606b = str;
                this.f22607c = callback;
                this.f22608d = executor;
                this.f22605a = turbonetEngine;
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
                    this.f22610f.add(Pair.create(str, str2));
                    return this;
                }
                throw new NullPointerException("Invalid header value.");
            }
            throw new NullPointerException("Invalid header name.");
        }

        public UrlRequest b() {
            UrlRequest b2 = this.f22605a.b(this.f22606b, this.f22607c, this.f22608d, this.f22613i, this.j, this.f22611g, this.f22612h, this.n);
            String str = this.f22609e;
            if (str != null) {
                b2.e(str);
            }
            Iterator<Pair<String, String>> it = this.f22610f.iterator();
            while (it.hasNext()) {
                Pair<String, String> next = it.next();
                b2.addHeader((String) next.first, (String) next.second);
            }
            UploadDataProvider uploadDataProvider = this.k;
            if (uploadDataProvider != null) {
                b2.i(uploadDataProvider, this.l);
            }
            if (this.m) {
                b2.h();
            }
            if (this.o) {
                b2.g();
            }
            int i2 = this.p;
            if (i2 > 0) {
                b2.b(i2);
            }
            int i3 = this.q;
            if (i3 > 0) {
                b2.l(i3);
            }
            int i4 = this.r;
            if (i4 > 0) {
                b2.c(i4);
            }
            int i5 = this.s;
            if (i5 > 0) {
                b2.a(i5);
            }
            Object obj = this.t;
            if (obj != null) {
                b2.f(obj);
            }
            if (!TextUtils.isEmpty(this.u)) {
                b2.k(this.u);
            }
            if (!TextUtils.isEmpty(this.v)) {
                b2.j(this.v);
            }
            return b2;
        }

        public Builder c() {
            this.f22611g = true;
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
                this.f22609e = str;
                return this;
            }
            throw new NullPointerException("Method is required.");
        }

        public Builder g(String str) {
            this.v = str;
            return this;
        }

        public Builder h(int i2) {
            this.r = i2;
            return this;
        }

        public Builder i(int i2) {
            this.q = i2;
            return this;
        }

        public Builder j(int i2) {
            this.p = i2;
            return this;
        }

        public Builder k(UploadDataProvider uploadDataProvider, Executor executor) {
            if (uploadDataProvider != null) {
                if (executor != null) {
                    if (this.f22609e == null) {
                        this.f22609e = "POST";
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
        /* loaded from: classes5.dex */
        public @interface StatusValues {
        }

        public static int a(int i2) {
            switch (i2) {
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
        public abstract void a(int i2);
    }

    void a(int i2);

    void addHeader(String str, String str2);

    void b(int i2);

    void c(int i2);

    void cancel();

    void d();

    void e(String str);

    void f(Object obj);

    void g();

    Object getTag();

    void h();

    void i(UploadDataProvider uploadDataProvider, Executor executor);

    void j(String str);

    void k(String str);

    void l(int i2);

    void read(ByteBuffer byteBuffer);

    void start();
}
