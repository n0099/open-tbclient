package com.bytedance.sdk.openadsdk.core.dynamic.b;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public int f4415a;
    public String b;
    private d c;

    public e(@NonNull c cVar) {
        this.f4415a = cVar.a();
        this.b = cVar.b();
        this.c = cVar.c();
    }

    public int a() {
        return (int) this.c.c();
    }

    public int b() {
        return (int) this.c.f();
    }

    public int c() {
        return (int) this.c.d();
    }

    public int d() {
        return (int) this.c.e();
    }

    public float e() {
        return this.c.g();
    }

    public String f() {
        return this.f4415a == 0 ? this.b : "";
    }

    public int g() {
        return a(this.c.j());
    }

    public int h() {
        String i = this.c.i();
        if ("left".equals(i)) {
            return 2;
        }
        if ("center".equals(i)) {
            return 4;
        }
        return HorizontalTranslateLayout.DIRECTION_RIGHT.equals(i) ? 3 : 2;
    }

    public String i() {
        return this.f4415a == 2 ? this.b : "";
    }

    public String j() {
        return this.f4415a == 1 ? this.b : "";
    }

    public int k() {
        return this.c.h();
    }

    public float l() {
        return this.c.a();
    }

    public int m() {
        return a(this.c.l());
    }

    public float n() {
        return this.c.b();
    }

    public boolean o() {
        return this.c.o();
    }

    public int p() {
        String m = this.c.m();
        if (TextUtils.isEmpty(m) || m.equals("none")) {
            return 0;
        }
        if (m.equals("normal")) {
            return 1;
        }
        if (m.equals("creative")) {
            return 2;
        }
        if (m.equals("video")) {
            return 4;
        }
        return !"slide".equals(this.c.n()) ? 0 : 2;
    }

    public int q() {
        return a(this.c.k());
    }

    private int a(String str) {
        String[] split;
        if (TextUtils.isEmpty(str)) {
            return ViewCompat.MEASURED_STATE_MASK;
        }
        if (str.equals("transparent")) {
            return 0;
        }
        if (str.charAt(0) == '#' && str.length() == 7) {
            return Color.parseColor(str);
        }
        if (str.startsWith("rgba") && (split = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",")) != null && split.length == 4) {
            return (((int) Float.parseFloat(split[0])) << 16) | (((int) ((Float.parseFloat(split[3]) * 255.0f) + 0.5f)) << 24) | (((int) Float.parseFloat(split[1])) << 8) | ((int) Float.parseFloat(split[2])) | 0;
        }
        return ViewCompat.MEASURED_STATE_MASK;
    }
}
