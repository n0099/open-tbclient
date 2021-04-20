package com.bytedance.sdk.openadsdk.core.d;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.a.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final int[] f27814a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f27815b;

    /* renamed from: c  reason: collision with root package name */
    public final int[] f27816c;

    /* renamed from: d  reason: collision with root package name */
    public final int[] f27817d;

    /* renamed from: e  reason: collision with root package name */
    public final int f27818e;

    /* renamed from: f  reason: collision with root package name */
    public final int f27819f;

    /* renamed from: g  reason: collision with root package name */
    public final int f27820g;

    /* renamed from: h  reason: collision with root package name */
    public final int f27821h;
    public final long i;
    public final long j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public SparseArray<c.a> o;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f27822a;

        /* renamed from: b  reason: collision with root package name */
        public long f27823b;

        /* renamed from: c  reason: collision with root package name */
        public int f27824c;

        /* renamed from: d  reason: collision with root package name */
        public int f27825d;

        /* renamed from: e  reason: collision with root package name */
        public int f27826e;

        /* renamed from: f  reason: collision with root package name */
        public int f27827f;

        /* renamed from: g  reason: collision with root package name */
        public int[] f27828g;

        /* renamed from: h  reason: collision with root package name */
        public int[] f27829h;
        public int[] i;
        public int[] j;
        public int k;
        public int l;
        public int m;
        public SparseArray<c.a> n;
        public int o;

        public a a(int i) {
            this.o = i;
            return this;
        }

        public a b(long j) {
            this.f27823b = j;
            return this;
        }

        public a c(int i) {
            this.f27825d = i;
            return this;
        }

        public a d(int i) {
            this.f27826e = i;
            return this;
        }

        public a e(int i) {
            this.f27827f = i;
            return this;
        }

        public a f(int i) {
            this.k = i;
            return this;
        }

        public a g(int i) {
            this.l = i;
            return this;
        }

        public a h(int i) {
            this.m = i;
            return this;
        }

        public a a(SparseArray<c.a> sparseArray) {
            this.n = sparseArray;
            return this;
        }

        public a b(int i) {
            this.f27824c = i;
            return this;
        }

        public a c(int[] iArr) {
            this.i = iArr;
            return this;
        }

        public a d(int[] iArr) {
            this.j = iArr;
            return this;
        }

        public a a(long j) {
            this.f27822a = j;
            return this;
        }

        public a b(int[] iArr) {
            this.f27829h = iArr;
            return this;
        }

        public a a(int[] iArr) {
            this.f27828g = iArr;
            return this;
        }

        public f a() {
            return new f(this);
        }
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f27814a != null && this.f27814a.length == 2) {
                jSONObject.putOpt("ad_x", Integer.valueOf(this.f27814a[0])).putOpt("ad_y", Integer.valueOf(this.f27814a[1]));
            }
            if (this.f27815b != null && this.f27815b.length == 2) {
                jSONObject.putOpt("width", Integer.valueOf(this.f27815b[0])).putOpt("height", Integer.valueOf(this.f27815b[1]));
            }
            if (this.f27816c != null && this.f27816c.length == 2) {
                jSONObject.putOpt("button_x", Integer.valueOf(this.f27816c[0])).putOpt("button_y", Integer.valueOf(this.f27816c[1]));
            }
            if (this.f27817d != null && this.f27817d.length == 2) {
                jSONObject.putOpt("button_width", Integer.valueOf(this.f27817d[0])).putOpt("button_height", Integer.valueOf(this.f27817d[1]));
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (this.o != null) {
                for (int i = 0; i < this.o.size(); i++) {
                    c.a valueAt = this.o.valueAt(i);
                    if (valueAt != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.putOpt("force", Double.valueOf(valueAt.f27716c)).putOpt("mr", Double.valueOf(valueAt.f27715b)).putOpt("phase", Integer.valueOf(valueAt.f27714a)).putOpt("ts", Long.valueOf(valueAt.f27717d));
                        jSONArray.put(jSONObject3);
                    }
                }
            }
            jSONObject2.putOpt("ftc", Integer.valueOf(this.n)).putOpt("info", jSONArray);
            jSONObject.putOpt("down_x", Integer.valueOf(this.f27818e)).putOpt("down_y", Integer.valueOf(this.f27819f)).putOpt("up_x", Integer.valueOf(this.f27820g)).putOpt("up_y", Integer.valueOf(this.f27821h)).putOpt("down_time", Long.valueOf(this.i)).putOpt("up_time", Long.valueOf(this.j)).putOpt("toolType", Integer.valueOf(this.k)).putOpt("deviceId", Integer.valueOf(this.l)).putOpt("source", Integer.valueOf(this.m)).putOpt("ft", jSONObject2);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public f(@NonNull a aVar) {
        this.f27814a = aVar.f27829h;
        this.f27815b = aVar.i;
        this.f27817d = aVar.j;
        this.f27816c = aVar.f27828g;
        this.f27818e = aVar.f27827f;
        this.f27819f = aVar.f27826e;
        this.f27820g = aVar.f27825d;
        this.f27821h = aVar.f27824c;
        this.i = aVar.f27823b;
        this.j = aVar.f27822a;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
        this.n = aVar.o;
        this.o = aVar.n;
    }
}
