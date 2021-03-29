package com.bytedance.sdk.openadsdk.core.d;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.a.c;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final int[] f28129a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f28130b;

    /* renamed from: c  reason: collision with root package name */
    public final int[] f28131c;

    /* renamed from: d  reason: collision with root package name */
    public final int[] f28132d;

    /* renamed from: e  reason: collision with root package name */
    public final int f28133e;

    /* renamed from: f  reason: collision with root package name */
    public final int f28134f;

    /* renamed from: g  reason: collision with root package name */
    public final int f28135g;

    /* renamed from: h  reason: collision with root package name */
    public final int f28136h;
    public final long i;
    public final long j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public SparseArray<c.a> o;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f28137a;

        /* renamed from: b  reason: collision with root package name */
        public long f28138b;

        /* renamed from: c  reason: collision with root package name */
        public int f28139c;

        /* renamed from: d  reason: collision with root package name */
        public int f28140d;

        /* renamed from: e  reason: collision with root package name */
        public int f28141e;

        /* renamed from: f  reason: collision with root package name */
        public int f28142f;

        /* renamed from: g  reason: collision with root package name */
        public int[] f28143g;

        /* renamed from: h  reason: collision with root package name */
        public int[] f28144h;
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
            this.f28138b = j;
            return this;
        }

        public a c(int i) {
            this.f28140d = i;
            return this;
        }

        public a d(int i) {
            this.f28141e = i;
            return this;
        }

        public a e(int i) {
            this.f28142f = i;
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
            this.f28139c = i;
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
            this.f28137a = j;
            return this;
        }

        public a b(int[] iArr) {
            this.f28144h = iArr;
            return this;
        }

        public a a(int[] iArr) {
            this.f28143g = iArr;
            return this;
        }

        public f a() {
            return new f(this);
        }
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f28129a != null && this.f28129a.length == 2) {
                jSONObject.putOpt("ad_x", Integer.valueOf(this.f28129a[0])).putOpt("ad_y", Integer.valueOf(this.f28129a[1]));
            }
            if (this.f28130b != null && this.f28130b.length == 2) {
                jSONObject.putOpt("width", Integer.valueOf(this.f28130b[0])).putOpt("height", Integer.valueOf(this.f28130b[1]));
            }
            if (this.f28131c != null && this.f28131c.length == 2) {
                jSONObject.putOpt("button_x", Integer.valueOf(this.f28131c[0])).putOpt("button_y", Integer.valueOf(this.f28131c[1]));
            }
            if (this.f28132d != null && this.f28132d.length == 2) {
                jSONObject.putOpt("button_width", Integer.valueOf(this.f28132d[0])).putOpt("button_height", Integer.valueOf(this.f28132d[1]));
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (this.o != null) {
                for (int i = 0; i < this.o.size(); i++) {
                    c.a valueAt = this.o.valueAt(i);
                    if (valueAt != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.putOpt("force", Double.valueOf(valueAt.f28031c)).putOpt("mr", Double.valueOf(valueAt.f28030b)).putOpt("phase", Integer.valueOf(valueAt.f28029a)).putOpt(TimeDisplaySetting.TIME_DISPLAY_SETTING, Long.valueOf(valueAt.f28032d));
                        jSONArray.put(jSONObject3);
                    }
                }
            }
            jSONObject2.putOpt("ftc", Integer.valueOf(this.n)).putOpt("info", jSONArray);
            jSONObject.putOpt("down_x", Integer.valueOf(this.f28133e)).putOpt("down_y", Integer.valueOf(this.f28134f)).putOpt("up_x", Integer.valueOf(this.f28135g)).putOpt("up_y", Integer.valueOf(this.f28136h)).putOpt("down_time", Long.valueOf(this.i)).putOpt("up_time", Long.valueOf(this.j)).putOpt("toolType", Integer.valueOf(this.k)).putOpt("deviceId", Integer.valueOf(this.l)).putOpt("source", Integer.valueOf(this.m)).putOpt("ft", jSONObject2);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public f(@NonNull a aVar) {
        this.f28129a = aVar.f28144h;
        this.f28130b = aVar.i;
        this.f28132d = aVar.j;
        this.f28131c = aVar.f28143g;
        this.f28133e = aVar.f28142f;
        this.f28134f = aVar.f28141e;
        this.f28135g = aVar.f28140d;
        this.f28136h = aVar.f28139c;
        this.i = aVar.f28138b;
        this.j = aVar.f28137a;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
        this.n = aVar.o;
        this.o = aVar.n;
    }
}
