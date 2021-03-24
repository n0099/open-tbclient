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
    public final int[] f28128a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f28129b;

    /* renamed from: c  reason: collision with root package name */
    public final int[] f28130c;

    /* renamed from: d  reason: collision with root package name */
    public final int[] f28131d;

    /* renamed from: e  reason: collision with root package name */
    public final int f28132e;

    /* renamed from: f  reason: collision with root package name */
    public final int f28133f;

    /* renamed from: g  reason: collision with root package name */
    public final int f28134g;

    /* renamed from: h  reason: collision with root package name */
    public final int f28135h;
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
        public long f28136a;

        /* renamed from: b  reason: collision with root package name */
        public long f28137b;

        /* renamed from: c  reason: collision with root package name */
        public int f28138c;

        /* renamed from: d  reason: collision with root package name */
        public int f28139d;

        /* renamed from: e  reason: collision with root package name */
        public int f28140e;

        /* renamed from: f  reason: collision with root package name */
        public int f28141f;

        /* renamed from: g  reason: collision with root package name */
        public int[] f28142g;

        /* renamed from: h  reason: collision with root package name */
        public int[] f28143h;
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
            this.f28137b = j;
            return this;
        }

        public a c(int i) {
            this.f28139d = i;
            return this;
        }

        public a d(int i) {
            this.f28140e = i;
            return this;
        }

        public a e(int i) {
            this.f28141f = i;
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
            this.f28138c = i;
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
            this.f28136a = j;
            return this;
        }

        public a b(int[] iArr) {
            this.f28143h = iArr;
            return this;
        }

        public a a(int[] iArr) {
            this.f28142g = iArr;
            return this;
        }

        public f a() {
            return new f(this);
        }
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f28128a != null && this.f28128a.length == 2) {
                jSONObject.putOpt("ad_x", Integer.valueOf(this.f28128a[0])).putOpt("ad_y", Integer.valueOf(this.f28128a[1]));
            }
            if (this.f28129b != null && this.f28129b.length == 2) {
                jSONObject.putOpt("width", Integer.valueOf(this.f28129b[0])).putOpt("height", Integer.valueOf(this.f28129b[1]));
            }
            if (this.f28130c != null && this.f28130c.length == 2) {
                jSONObject.putOpt("button_x", Integer.valueOf(this.f28130c[0])).putOpt("button_y", Integer.valueOf(this.f28130c[1]));
            }
            if (this.f28131d != null && this.f28131d.length == 2) {
                jSONObject.putOpt("button_width", Integer.valueOf(this.f28131d[0])).putOpt("button_height", Integer.valueOf(this.f28131d[1]));
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (this.o != null) {
                for (int i = 0; i < this.o.size(); i++) {
                    c.a valueAt = this.o.valueAt(i);
                    if (valueAt != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.putOpt("force", Double.valueOf(valueAt.f28030c)).putOpt("mr", Double.valueOf(valueAt.f28029b)).putOpt("phase", Integer.valueOf(valueAt.f28028a)).putOpt(TimeDisplaySetting.TIME_DISPLAY_SETTING, Long.valueOf(valueAt.f28031d));
                        jSONArray.put(jSONObject3);
                    }
                }
            }
            jSONObject2.putOpt("ftc", Integer.valueOf(this.n)).putOpt("info", jSONArray);
            jSONObject.putOpt("down_x", Integer.valueOf(this.f28132e)).putOpt("down_y", Integer.valueOf(this.f28133f)).putOpt("up_x", Integer.valueOf(this.f28134g)).putOpt("up_y", Integer.valueOf(this.f28135h)).putOpt("down_time", Long.valueOf(this.i)).putOpt("up_time", Long.valueOf(this.j)).putOpt("toolType", Integer.valueOf(this.k)).putOpt("deviceId", Integer.valueOf(this.l)).putOpt("source", Integer.valueOf(this.m)).putOpt("ft", jSONObject2);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public f(@NonNull a aVar) {
        this.f28128a = aVar.f28143h;
        this.f28129b = aVar.i;
        this.f28131d = aVar.j;
        this.f28130c = aVar.f28142g;
        this.f28132e = aVar.f28141f;
        this.f28133f = aVar.f28140e;
        this.f28134g = aVar.f28139d;
        this.f28135h = aVar.f28138c;
        this.i = aVar.f28137b;
        this.j = aVar.f28136a;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
        this.n = aVar.o;
        this.o = aVar.n;
    }
}
