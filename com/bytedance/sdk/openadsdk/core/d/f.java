package com.bytedance.sdk.openadsdk.core.d;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.a.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final int[] f28665a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f28666b;

    /* renamed from: c  reason: collision with root package name */
    public final int[] f28667c;

    /* renamed from: d  reason: collision with root package name */
    public final int[] f28668d;

    /* renamed from: e  reason: collision with root package name */
    public final int f28669e;

    /* renamed from: f  reason: collision with root package name */
    public final int f28670f;

    /* renamed from: g  reason: collision with root package name */
    public final int f28671g;

    /* renamed from: h  reason: collision with root package name */
    public final int f28672h;

    /* renamed from: i  reason: collision with root package name */
    public final long f28673i;
    public final long j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public SparseArray<c.a> o;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f28674a;

        /* renamed from: b  reason: collision with root package name */
        public long f28675b;

        /* renamed from: c  reason: collision with root package name */
        public int f28676c;

        /* renamed from: d  reason: collision with root package name */
        public int f28677d;

        /* renamed from: e  reason: collision with root package name */
        public int f28678e;

        /* renamed from: f  reason: collision with root package name */
        public int f28679f;

        /* renamed from: g  reason: collision with root package name */
        public int[] f28680g;

        /* renamed from: h  reason: collision with root package name */
        public int[] f28681h;

        /* renamed from: i  reason: collision with root package name */
        public int[] f28682i;
        public int[] j;
        public int k;
        public int l;
        public int m;
        public SparseArray<c.a> n;
        public int o;

        public a a(int i2) {
            this.o = i2;
            return this;
        }

        public a b(long j) {
            this.f28675b = j;
            return this;
        }

        public a c(int i2) {
            this.f28677d = i2;
            return this;
        }

        public a d(int i2) {
            this.f28678e = i2;
            return this;
        }

        public a e(int i2) {
            this.f28679f = i2;
            return this;
        }

        public a f(int i2) {
            this.k = i2;
            return this;
        }

        public a g(int i2) {
            this.l = i2;
            return this;
        }

        public a h(int i2) {
            this.m = i2;
            return this;
        }

        public a a(SparseArray<c.a> sparseArray) {
            this.n = sparseArray;
            return this;
        }

        public a b(int i2) {
            this.f28676c = i2;
            return this;
        }

        public a c(int[] iArr) {
            this.f28682i = iArr;
            return this;
        }

        public a d(int[] iArr) {
            this.j = iArr;
            return this;
        }

        public a a(long j) {
            this.f28674a = j;
            return this;
        }

        public a b(int[] iArr) {
            this.f28681h = iArr;
            return this;
        }

        public a a(int[] iArr) {
            this.f28680g = iArr;
            return this;
        }

        public f a() {
            return new f(this);
        }
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f28665a != null && this.f28665a.length == 2) {
                jSONObject.putOpt("ad_x", Integer.valueOf(this.f28665a[0])).putOpt("ad_y", Integer.valueOf(this.f28665a[1]));
            }
            if (this.f28666b != null && this.f28666b.length == 2) {
                jSONObject.putOpt("width", Integer.valueOf(this.f28666b[0])).putOpt("height", Integer.valueOf(this.f28666b[1]));
            }
            if (this.f28667c != null && this.f28667c.length == 2) {
                jSONObject.putOpt("button_x", Integer.valueOf(this.f28667c[0])).putOpt("button_y", Integer.valueOf(this.f28667c[1]));
            }
            if (this.f28668d != null && this.f28668d.length == 2) {
                jSONObject.putOpt("button_width", Integer.valueOf(this.f28668d[0])).putOpt("button_height", Integer.valueOf(this.f28668d[1]));
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (this.o != null) {
                for (int i2 = 0; i2 < this.o.size(); i2++) {
                    c.a valueAt = this.o.valueAt(i2);
                    if (valueAt != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.putOpt("force", Double.valueOf(valueAt.f28564c)).putOpt("mr", Double.valueOf(valueAt.f28563b)).putOpt("phase", Integer.valueOf(valueAt.f28562a)).putOpt("ts", Long.valueOf(valueAt.f28565d));
                        jSONArray.put(jSONObject3);
                    }
                }
            }
            jSONObject2.putOpt("ftc", Integer.valueOf(this.n)).putOpt("info", jSONArray);
            jSONObject.putOpt("down_x", Integer.valueOf(this.f28669e)).putOpt("down_y", Integer.valueOf(this.f28670f)).putOpt("up_x", Integer.valueOf(this.f28671g)).putOpt("up_y", Integer.valueOf(this.f28672h)).putOpt("down_time", Long.valueOf(this.f28673i)).putOpt("up_time", Long.valueOf(this.j)).putOpt("toolType", Integer.valueOf(this.k)).putOpt("deviceId", Integer.valueOf(this.l)).putOpt("source", Integer.valueOf(this.m)).putOpt("ft", jSONObject2);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public f(@NonNull a aVar) {
        this.f28665a = aVar.f28681h;
        this.f28666b = aVar.f28682i;
        this.f28668d = aVar.j;
        this.f28667c = aVar.f28680g;
        this.f28669e = aVar.f28679f;
        this.f28670f = aVar.f28678e;
        this.f28671g = aVar.f28677d;
        this.f28672h = aVar.f28676c;
        this.f28673i = aVar.f28675b;
        this.j = aVar.f28674a;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
        this.n = aVar.o;
        this.o = aVar.n;
    }
}
