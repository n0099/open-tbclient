package com.bytedance.sdk.openadsdk.core.d;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.a.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final int[] f27942a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f27943b;

    /* renamed from: c  reason: collision with root package name */
    public final int[] f27944c;

    /* renamed from: d  reason: collision with root package name */
    public final int[] f27945d;

    /* renamed from: e  reason: collision with root package name */
    public final int f27946e;

    /* renamed from: f  reason: collision with root package name */
    public final int f27947f;

    /* renamed from: g  reason: collision with root package name */
    public final int f27948g;

    /* renamed from: h  reason: collision with root package name */
    public final int f27949h;

    /* renamed from: i  reason: collision with root package name */
    public final long f27950i;
    public final long j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public SparseArray<c.a> o;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f27951a;

        /* renamed from: b  reason: collision with root package name */
        public long f27952b;

        /* renamed from: c  reason: collision with root package name */
        public int f27953c;

        /* renamed from: d  reason: collision with root package name */
        public int f27954d;

        /* renamed from: e  reason: collision with root package name */
        public int f27955e;

        /* renamed from: f  reason: collision with root package name */
        public int f27956f;

        /* renamed from: g  reason: collision with root package name */
        public int[] f27957g;

        /* renamed from: h  reason: collision with root package name */
        public int[] f27958h;

        /* renamed from: i  reason: collision with root package name */
        public int[] f27959i;
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
            this.f27952b = j;
            return this;
        }

        public a c(int i2) {
            this.f27954d = i2;
            return this;
        }

        public a d(int i2) {
            this.f27955e = i2;
            return this;
        }

        public a e(int i2) {
            this.f27956f = i2;
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
            this.f27953c = i2;
            return this;
        }

        public a c(int[] iArr) {
            this.f27959i = iArr;
            return this;
        }

        public a d(int[] iArr) {
            this.j = iArr;
            return this;
        }

        public a a(long j) {
            this.f27951a = j;
            return this;
        }

        public a b(int[] iArr) {
            this.f27958h = iArr;
            return this;
        }

        public a a(int[] iArr) {
            this.f27957g = iArr;
            return this;
        }

        public f a() {
            return new f(this);
        }
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f27942a != null && this.f27942a.length == 2) {
                jSONObject.putOpt("ad_x", Integer.valueOf(this.f27942a[0])).putOpt("ad_y", Integer.valueOf(this.f27942a[1]));
            }
            if (this.f27943b != null && this.f27943b.length == 2) {
                jSONObject.putOpt("width", Integer.valueOf(this.f27943b[0])).putOpt("height", Integer.valueOf(this.f27943b[1]));
            }
            if (this.f27944c != null && this.f27944c.length == 2) {
                jSONObject.putOpt("button_x", Integer.valueOf(this.f27944c[0])).putOpt("button_y", Integer.valueOf(this.f27944c[1]));
            }
            if (this.f27945d != null && this.f27945d.length == 2) {
                jSONObject.putOpt("button_width", Integer.valueOf(this.f27945d[0])).putOpt("button_height", Integer.valueOf(this.f27945d[1]));
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (this.o != null) {
                for (int i2 = 0; i2 < this.o.size(); i2++) {
                    c.a valueAt = this.o.valueAt(i2);
                    if (valueAt != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.putOpt("force", Double.valueOf(valueAt.f27841c)).putOpt("mr", Double.valueOf(valueAt.f27840b)).putOpt("phase", Integer.valueOf(valueAt.f27839a)).putOpt("ts", Long.valueOf(valueAt.f27842d));
                        jSONArray.put(jSONObject3);
                    }
                }
            }
            jSONObject2.putOpt("ftc", Integer.valueOf(this.n)).putOpt("info", jSONArray);
            jSONObject.putOpt("down_x", Integer.valueOf(this.f27946e)).putOpt("down_y", Integer.valueOf(this.f27947f)).putOpt("up_x", Integer.valueOf(this.f27948g)).putOpt("up_y", Integer.valueOf(this.f27949h)).putOpt("down_time", Long.valueOf(this.f27950i)).putOpt("up_time", Long.valueOf(this.j)).putOpt("toolType", Integer.valueOf(this.k)).putOpt("deviceId", Integer.valueOf(this.l)).putOpt("source", Integer.valueOf(this.m)).putOpt("ft", jSONObject2);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public f(@NonNull a aVar) {
        this.f27942a = aVar.f27958h;
        this.f27943b = aVar.f27959i;
        this.f27945d = aVar.j;
        this.f27944c = aVar.f27957g;
        this.f27946e = aVar.f27956f;
        this.f27947f = aVar.f27955e;
        this.f27948g = aVar.f27954d;
        this.f27949h = aVar.f27953c;
        this.f27950i = aVar.f27952b;
        this.j = aVar.f27951a;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
        this.n = aVar.o;
        this.o = aVar.n;
    }
}
