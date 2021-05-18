package com.bytedance.sdk.openadsdk.core.d;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.a.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final int[] f27910a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f27911b;

    /* renamed from: c  reason: collision with root package name */
    public final int[] f27912c;

    /* renamed from: d  reason: collision with root package name */
    public final int[] f27913d;

    /* renamed from: e  reason: collision with root package name */
    public final int f27914e;

    /* renamed from: f  reason: collision with root package name */
    public final int f27915f;

    /* renamed from: g  reason: collision with root package name */
    public final int f27916g;

    /* renamed from: h  reason: collision with root package name */
    public final int f27917h;

    /* renamed from: i  reason: collision with root package name */
    public final long f27918i;
    public final long j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public SparseArray<c.a> o;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f27919a;

        /* renamed from: b  reason: collision with root package name */
        public long f27920b;

        /* renamed from: c  reason: collision with root package name */
        public int f27921c;

        /* renamed from: d  reason: collision with root package name */
        public int f27922d;

        /* renamed from: e  reason: collision with root package name */
        public int f27923e;

        /* renamed from: f  reason: collision with root package name */
        public int f27924f;

        /* renamed from: g  reason: collision with root package name */
        public int[] f27925g;

        /* renamed from: h  reason: collision with root package name */
        public int[] f27926h;

        /* renamed from: i  reason: collision with root package name */
        public int[] f27927i;
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
            this.f27920b = j;
            return this;
        }

        public a c(int i2) {
            this.f27922d = i2;
            return this;
        }

        public a d(int i2) {
            this.f27923e = i2;
            return this;
        }

        public a e(int i2) {
            this.f27924f = i2;
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
            this.f27921c = i2;
            return this;
        }

        public a c(int[] iArr) {
            this.f27927i = iArr;
            return this;
        }

        public a d(int[] iArr) {
            this.j = iArr;
            return this;
        }

        public a a(long j) {
            this.f27919a = j;
            return this;
        }

        public a b(int[] iArr) {
            this.f27926h = iArr;
            return this;
        }

        public a a(int[] iArr) {
            this.f27925g = iArr;
            return this;
        }

        public f a() {
            return new f(this);
        }
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f27910a != null && this.f27910a.length == 2) {
                jSONObject.putOpt("ad_x", Integer.valueOf(this.f27910a[0])).putOpt("ad_y", Integer.valueOf(this.f27910a[1]));
            }
            if (this.f27911b != null && this.f27911b.length == 2) {
                jSONObject.putOpt("width", Integer.valueOf(this.f27911b[0])).putOpt("height", Integer.valueOf(this.f27911b[1]));
            }
            if (this.f27912c != null && this.f27912c.length == 2) {
                jSONObject.putOpt("button_x", Integer.valueOf(this.f27912c[0])).putOpt("button_y", Integer.valueOf(this.f27912c[1]));
            }
            if (this.f27913d != null && this.f27913d.length == 2) {
                jSONObject.putOpt("button_width", Integer.valueOf(this.f27913d[0])).putOpt("button_height", Integer.valueOf(this.f27913d[1]));
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (this.o != null) {
                for (int i2 = 0; i2 < this.o.size(); i2++) {
                    c.a valueAt = this.o.valueAt(i2);
                    if (valueAt != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.putOpt("force", Double.valueOf(valueAt.f27809c)).putOpt("mr", Double.valueOf(valueAt.f27808b)).putOpt("phase", Integer.valueOf(valueAt.f27807a)).putOpt("ts", Long.valueOf(valueAt.f27810d));
                        jSONArray.put(jSONObject3);
                    }
                }
            }
            jSONObject2.putOpt("ftc", Integer.valueOf(this.n)).putOpt("info", jSONArray);
            jSONObject.putOpt("down_x", Integer.valueOf(this.f27914e)).putOpt("down_y", Integer.valueOf(this.f27915f)).putOpt("up_x", Integer.valueOf(this.f27916g)).putOpt("up_y", Integer.valueOf(this.f27917h)).putOpt("down_time", Long.valueOf(this.f27918i)).putOpt("up_time", Long.valueOf(this.j)).putOpt("toolType", Integer.valueOf(this.k)).putOpt("deviceId", Integer.valueOf(this.l)).putOpt("source", Integer.valueOf(this.m)).putOpt("ft", jSONObject2);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public f(@NonNull a aVar) {
        this.f27910a = aVar.f27926h;
        this.f27911b = aVar.f27927i;
        this.f27913d = aVar.j;
        this.f27912c = aVar.f27925g;
        this.f27914e = aVar.f27924f;
        this.f27915f = aVar.f27923e;
        this.f27916g = aVar.f27922d;
        this.f27917h = aVar.f27921c;
        this.f27918i = aVar.f27920b;
        this.j = aVar.f27919a;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
        this.n = aVar.o;
        this.o = aVar.n;
    }
}
