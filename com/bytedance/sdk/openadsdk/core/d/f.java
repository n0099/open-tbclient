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
    private final int[] f6495a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f6496b;
    private final int[] c;
    private final int[] d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private final long i;
    private final long j;
    private final int k;
    private final int l;
    private final int m;
    private final int n;
    private SparseArray<c.a> o;

    private f(@NonNull a aVar) {
        this.f6495a = aVar.h;
        this.f6496b = aVar.i;
        this.d = aVar.j;
        this.c = aVar.g;
        this.e = aVar.f;
        this.f = aVar.e;
        this.g = aVar.d;
        this.h = aVar.c;
        this.i = aVar.f6498b;
        this.j = aVar.f6497a;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
        this.n = aVar.o;
        this.o = aVar.n;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f6495a != null && this.f6495a.length == 2) {
                jSONObject.putOpt("ad_x", Integer.valueOf(this.f6495a[0])).putOpt("ad_y", Integer.valueOf(this.f6495a[1]));
            }
            if (this.f6496b != null && this.f6496b.length == 2) {
                jSONObject.putOpt("width", Integer.valueOf(this.f6496b[0])).putOpt("height", Integer.valueOf(this.f6496b[1]));
            }
            if (this.c != null && this.c.length == 2) {
                jSONObject.putOpt("button_x", Integer.valueOf(this.c[0])).putOpt("button_y", Integer.valueOf(this.c[1]));
            }
            if (this.d != null && this.d.length == 2) {
                jSONObject.putOpt("button_width", Integer.valueOf(this.d[0])).putOpt("button_height", Integer.valueOf(this.d[1]));
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (this.o != null) {
                for (int i = 0; i < this.o.size(); i++) {
                    c.a valueAt = this.o.valueAt(i);
                    if (valueAt != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.putOpt("force", Double.valueOf(valueAt.c)).putOpt("mr", Double.valueOf(valueAt.f6448b)).putOpt("phase", Integer.valueOf(valueAt.f6447a)).putOpt(TimeDisplaySetting.TIME_DISPLAY_SETTING, Long.valueOf(valueAt.d));
                        jSONArray.put(jSONObject3);
                    }
                }
            }
            jSONObject2.putOpt("ftc", Integer.valueOf(this.n)).putOpt("info", jSONArray);
            jSONObject.putOpt("down_x", Integer.valueOf(this.e)).putOpt("down_y", Integer.valueOf(this.f)).putOpt("up_x", Integer.valueOf(this.g)).putOpt("up_y", Integer.valueOf(this.h)).putOpt("down_time", Long.valueOf(this.i)).putOpt("up_time", Long.valueOf(this.j)).putOpt("toolType", Integer.valueOf(this.k)).putOpt("deviceId", Integer.valueOf(this.l)).putOpt("source", Integer.valueOf(this.m)).putOpt("ft", jSONObject2);
        } catch (Exception e) {
        }
        return jSONObject;
    }

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private long f6497a;

        /* renamed from: b  reason: collision with root package name */
        private long f6498b;
        private int c;
        private int d;
        private int e;
        private int f;
        private int[] g;
        private int[] h;
        private int[] i;
        private int[] j;
        private int k;
        private int l;
        private int m;
        private SparseArray<c.a> n;
        private int o;

        public a a(int i) {
            this.o = i;
            return this;
        }

        public a a(SparseArray<c.a> sparseArray) {
            this.n = sparseArray;
            return this;
        }

        public a a(long j) {
            this.f6497a = j;
            return this;
        }

        public a b(long j) {
            this.f6498b = j;
            return this;
        }

        public a b(int i) {
            this.c = i;
            return this;
        }

        public a c(int i) {
            this.d = i;
            return this;
        }

        public a d(int i) {
            this.e = i;
            return this;
        }

        public a e(int i) {
            this.f = i;
            return this;
        }

        public a a(int[] iArr) {
            this.g = iArr;
            return this;
        }

        public a b(int[] iArr) {
            this.h = iArr;
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

        public f a() {
            return new f(this);
        }
    }
}
