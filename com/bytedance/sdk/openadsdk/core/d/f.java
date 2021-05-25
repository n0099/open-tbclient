package com.bytedance.sdk.openadsdk.core.d;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.a.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final int[] f27839a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f27840b;

    /* renamed from: c  reason: collision with root package name */
    public final int[] f27841c;

    /* renamed from: d  reason: collision with root package name */
    public final int[] f27842d;

    /* renamed from: e  reason: collision with root package name */
    public final int f27843e;

    /* renamed from: f  reason: collision with root package name */
    public final int f27844f;

    /* renamed from: g  reason: collision with root package name */
    public final int f27845g;

    /* renamed from: h  reason: collision with root package name */
    public final int f27846h;

    /* renamed from: i  reason: collision with root package name */
    public final long f27847i;
    public final long j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public SparseArray<c.a> o;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f27848a;

        /* renamed from: b  reason: collision with root package name */
        public long f27849b;

        /* renamed from: c  reason: collision with root package name */
        public int f27850c;

        /* renamed from: d  reason: collision with root package name */
        public int f27851d;

        /* renamed from: e  reason: collision with root package name */
        public int f27852e;

        /* renamed from: f  reason: collision with root package name */
        public int f27853f;

        /* renamed from: g  reason: collision with root package name */
        public int[] f27854g;

        /* renamed from: h  reason: collision with root package name */
        public int[] f27855h;

        /* renamed from: i  reason: collision with root package name */
        public int[] f27856i;
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
            this.f27849b = j;
            return this;
        }

        public a c(int i2) {
            this.f27851d = i2;
            return this;
        }

        public a d(int i2) {
            this.f27852e = i2;
            return this;
        }

        public a e(int i2) {
            this.f27853f = i2;
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
            this.f27850c = i2;
            return this;
        }

        public a c(int[] iArr) {
            this.f27856i = iArr;
            return this;
        }

        public a d(int[] iArr) {
            this.j = iArr;
            return this;
        }

        public a a(long j) {
            this.f27848a = j;
            return this;
        }

        public a b(int[] iArr) {
            this.f27855h = iArr;
            return this;
        }

        public a a(int[] iArr) {
            this.f27854g = iArr;
            return this;
        }

        public f a() {
            return new f(this);
        }
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f27839a != null && this.f27839a.length == 2) {
                jSONObject.putOpt("ad_x", Integer.valueOf(this.f27839a[0])).putOpt("ad_y", Integer.valueOf(this.f27839a[1]));
            }
            if (this.f27840b != null && this.f27840b.length == 2) {
                jSONObject.putOpt("width", Integer.valueOf(this.f27840b[0])).putOpt("height", Integer.valueOf(this.f27840b[1]));
            }
            if (this.f27841c != null && this.f27841c.length == 2) {
                jSONObject.putOpt("button_x", Integer.valueOf(this.f27841c[0])).putOpt("button_y", Integer.valueOf(this.f27841c[1]));
            }
            if (this.f27842d != null && this.f27842d.length == 2) {
                jSONObject.putOpt("button_width", Integer.valueOf(this.f27842d[0])).putOpt("button_height", Integer.valueOf(this.f27842d[1]));
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (this.o != null) {
                for (int i2 = 0; i2 < this.o.size(); i2++) {
                    c.a valueAt = this.o.valueAt(i2);
                    if (valueAt != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.putOpt("force", Double.valueOf(valueAt.f27738c)).putOpt("mr", Double.valueOf(valueAt.f27737b)).putOpt("phase", Integer.valueOf(valueAt.f27736a)).putOpt("ts", Long.valueOf(valueAt.f27739d));
                        jSONArray.put(jSONObject3);
                    }
                }
            }
            jSONObject2.putOpt("ftc", Integer.valueOf(this.n)).putOpt("info", jSONArray);
            jSONObject.putOpt("down_x", Integer.valueOf(this.f27843e)).putOpt("down_y", Integer.valueOf(this.f27844f)).putOpt("up_x", Integer.valueOf(this.f27845g)).putOpt("up_y", Integer.valueOf(this.f27846h)).putOpt("down_time", Long.valueOf(this.f27847i)).putOpt("up_time", Long.valueOf(this.j)).putOpt("toolType", Integer.valueOf(this.k)).putOpt("deviceId", Integer.valueOf(this.l)).putOpt("source", Integer.valueOf(this.m)).putOpt("ft", jSONObject2);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public f(@NonNull a aVar) {
        this.f27839a = aVar.f27855h;
        this.f27840b = aVar.f27856i;
        this.f27842d = aVar.j;
        this.f27841c = aVar.f27854g;
        this.f27843e = aVar.f27853f;
        this.f27844f = aVar.f27852e;
        this.f27845g = aVar.f27851d;
        this.f27846h = aVar.f27850c;
        this.f27847i = aVar.f27849b;
        this.j = aVar.f27848a;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
        this.n = aVar.o;
        this.o = aVar.n;
    }
}
