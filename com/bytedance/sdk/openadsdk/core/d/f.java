package com.bytedance.sdk.openadsdk.core.d;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.a.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final int[] f28024a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f28025b;

    /* renamed from: c  reason: collision with root package name */
    public final int[] f28026c;

    /* renamed from: d  reason: collision with root package name */
    public final int[] f28027d;

    /* renamed from: e  reason: collision with root package name */
    public final int f28028e;

    /* renamed from: f  reason: collision with root package name */
    public final int f28029f;

    /* renamed from: g  reason: collision with root package name */
    public final int f28030g;

    /* renamed from: h  reason: collision with root package name */
    public final int f28031h;

    /* renamed from: i  reason: collision with root package name */
    public final long f28032i;
    public final long j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public SparseArray<c.a> o;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f28033a;

        /* renamed from: b  reason: collision with root package name */
        public long f28034b;

        /* renamed from: c  reason: collision with root package name */
        public int f28035c;

        /* renamed from: d  reason: collision with root package name */
        public int f28036d;

        /* renamed from: e  reason: collision with root package name */
        public int f28037e;

        /* renamed from: f  reason: collision with root package name */
        public int f28038f;

        /* renamed from: g  reason: collision with root package name */
        public int[] f28039g;

        /* renamed from: h  reason: collision with root package name */
        public int[] f28040h;

        /* renamed from: i  reason: collision with root package name */
        public int[] f28041i;
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
            this.f28034b = j;
            return this;
        }

        public a c(int i2) {
            this.f28036d = i2;
            return this;
        }

        public a d(int i2) {
            this.f28037e = i2;
            return this;
        }

        public a e(int i2) {
            this.f28038f = i2;
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
            this.f28035c = i2;
            return this;
        }

        public a c(int[] iArr) {
            this.f28041i = iArr;
            return this;
        }

        public a d(int[] iArr) {
            this.j = iArr;
            return this;
        }

        public a a(long j) {
            this.f28033a = j;
            return this;
        }

        public a b(int[] iArr) {
            this.f28040h = iArr;
            return this;
        }

        public a a(int[] iArr) {
            this.f28039g = iArr;
            return this;
        }

        public f a() {
            return new f(this);
        }
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f28024a != null && this.f28024a.length == 2) {
                jSONObject.putOpt("ad_x", Integer.valueOf(this.f28024a[0])).putOpt("ad_y", Integer.valueOf(this.f28024a[1]));
            }
            if (this.f28025b != null && this.f28025b.length == 2) {
                jSONObject.putOpt("width", Integer.valueOf(this.f28025b[0])).putOpt("height", Integer.valueOf(this.f28025b[1]));
            }
            if (this.f28026c != null && this.f28026c.length == 2) {
                jSONObject.putOpt("button_x", Integer.valueOf(this.f28026c[0])).putOpt("button_y", Integer.valueOf(this.f28026c[1]));
            }
            if (this.f28027d != null && this.f28027d.length == 2) {
                jSONObject.putOpt("button_width", Integer.valueOf(this.f28027d[0])).putOpt("button_height", Integer.valueOf(this.f28027d[1]));
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (this.o != null) {
                for (int i2 = 0; i2 < this.o.size(); i2++) {
                    c.a valueAt = this.o.valueAt(i2);
                    if (valueAt != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.putOpt("force", Double.valueOf(valueAt.f27923c)).putOpt("mr", Double.valueOf(valueAt.f27922b)).putOpt("phase", Integer.valueOf(valueAt.f27921a)).putOpt("ts", Long.valueOf(valueAt.f27924d));
                        jSONArray.put(jSONObject3);
                    }
                }
            }
            jSONObject2.putOpt("ftc", Integer.valueOf(this.n)).putOpt("info", jSONArray);
            jSONObject.putOpt("down_x", Integer.valueOf(this.f28028e)).putOpt("down_y", Integer.valueOf(this.f28029f)).putOpt("up_x", Integer.valueOf(this.f28030g)).putOpt("up_y", Integer.valueOf(this.f28031h)).putOpt("down_time", Long.valueOf(this.f28032i)).putOpt("up_time", Long.valueOf(this.j)).putOpt("toolType", Integer.valueOf(this.k)).putOpt("deviceId", Integer.valueOf(this.l)).putOpt("source", Integer.valueOf(this.m)).putOpt("ft", jSONObject2);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public f(@NonNull a aVar) {
        this.f28024a = aVar.f28040h;
        this.f28025b = aVar.f28041i;
        this.f28027d = aVar.j;
        this.f28026c = aVar.f28039g;
        this.f28028e = aVar.f28038f;
        this.f28029f = aVar.f28037e;
        this.f28030g = aVar.f28036d;
        this.f28031h = aVar.f28035c;
        this.f28032i = aVar.f28034b;
        this.j = aVar.f28033a;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
        this.n = aVar.o;
        this.o = aVar.n;
    }
}
