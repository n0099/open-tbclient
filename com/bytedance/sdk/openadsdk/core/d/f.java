package com.bytedance.sdk.openadsdk.core.d;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.a.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final int[] f27822a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f27823b;

    /* renamed from: c  reason: collision with root package name */
    public final int[] f27824c;

    /* renamed from: d  reason: collision with root package name */
    public final int[] f27825d;

    /* renamed from: e  reason: collision with root package name */
    public final int f27826e;

    /* renamed from: f  reason: collision with root package name */
    public final int f27827f;

    /* renamed from: g  reason: collision with root package name */
    public final int f27828g;

    /* renamed from: h  reason: collision with root package name */
    public final int f27829h;
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
        public long f27830a;

        /* renamed from: b  reason: collision with root package name */
        public long f27831b;

        /* renamed from: c  reason: collision with root package name */
        public int f27832c;

        /* renamed from: d  reason: collision with root package name */
        public int f27833d;

        /* renamed from: e  reason: collision with root package name */
        public int f27834e;

        /* renamed from: f  reason: collision with root package name */
        public int f27835f;

        /* renamed from: g  reason: collision with root package name */
        public int[] f27836g;

        /* renamed from: h  reason: collision with root package name */
        public int[] f27837h;
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
            this.f27831b = j;
            return this;
        }

        public a c(int i) {
            this.f27833d = i;
            return this;
        }

        public a d(int i) {
            this.f27834e = i;
            return this;
        }

        public a e(int i) {
            this.f27835f = i;
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
            this.f27832c = i;
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
            this.f27830a = j;
            return this;
        }

        public a b(int[] iArr) {
            this.f27837h = iArr;
            return this;
        }

        public a a(int[] iArr) {
            this.f27836g = iArr;
            return this;
        }

        public f a() {
            return new f(this);
        }
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f27822a != null && this.f27822a.length == 2) {
                jSONObject.putOpt("ad_x", Integer.valueOf(this.f27822a[0])).putOpt("ad_y", Integer.valueOf(this.f27822a[1]));
            }
            if (this.f27823b != null && this.f27823b.length == 2) {
                jSONObject.putOpt("width", Integer.valueOf(this.f27823b[0])).putOpt("height", Integer.valueOf(this.f27823b[1]));
            }
            if (this.f27824c != null && this.f27824c.length == 2) {
                jSONObject.putOpt("button_x", Integer.valueOf(this.f27824c[0])).putOpt("button_y", Integer.valueOf(this.f27824c[1]));
            }
            if (this.f27825d != null && this.f27825d.length == 2) {
                jSONObject.putOpt("button_width", Integer.valueOf(this.f27825d[0])).putOpt("button_height", Integer.valueOf(this.f27825d[1]));
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (this.o != null) {
                for (int i = 0; i < this.o.size(); i++) {
                    c.a valueAt = this.o.valueAt(i);
                    if (valueAt != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.putOpt("force", Double.valueOf(valueAt.f27724c)).putOpt("mr", Double.valueOf(valueAt.f27723b)).putOpt("phase", Integer.valueOf(valueAt.f27722a)).putOpt("ts", Long.valueOf(valueAt.f27725d));
                        jSONArray.put(jSONObject3);
                    }
                }
            }
            jSONObject2.putOpt("ftc", Integer.valueOf(this.n)).putOpt("info", jSONArray);
            jSONObject.putOpt("down_x", Integer.valueOf(this.f27826e)).putOpt("down_y", Integer.valueOf(this.f27827f)).putOpt("up_x", Integer.valueOf(this.f27828g)).putOpt("up_y", Integer.valueOf(this.f27829h)).putOpt("down_time", Long.valueOf(this.i)).putOpt("up_time", Long.valueOf(this.j)).putOpt("toolType", Integer.valueOf(this.k)).putOpt("deviceId", Integer.valueOf(this.l)).putOpt("source", Integer.valueOf(this.m)).putOpt("ft", jSONObject2);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public f(@NonNull a aVar) {
        this.f27822a = aVar.f27837h;
        this.f27823b = aVar.i;
        this.f27825d = aVar.j;
        this.f27824c = aVar.f27836g;
        this.f27826e = aVar.f27835f;
        this.f27827f = aVar.f27834e;
        this.f27828g = aVar.f27833d;
        this.f27829h = aVar.f27832c;
        this.i = aVar.f27831b;
        this.j = aVar.f27830a;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
        this.n = aVar.o;
        this.o = aVar.n;
    }
}
