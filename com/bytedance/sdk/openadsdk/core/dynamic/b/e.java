package com.bytedance.sdk.openadsdk.core.dynamic.b;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.flutter.base.util.OpenFlutter;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public int f28187a;

    /* renamed from: b  reason: collision with root package name */
    public String f28188b;

    /* renamed from: c  reason: collision with root package name */
    public d f28189c;

    public e(@NonNull c cVar) {
        this.f28187a = cVar.a();
        this.f28188b = cVar.b();
        this.f28189c = cVar.c();
    }

    public int a() {
        return (int) this.f28189c.c();
    }

    public int b() {
        return (int) this.f28189c.f();
    }

    public int c() {
        return (int) this.f28189c.d();
    }

    public int d() {
        return (int) this.f28189c.e();
    }

    public float e() {
        return this.f28189c.g();
    }

    public String f() {
        return this.f28187a == 0 ? this.f28188b : "";
    }

    public int g() {
        return a(this.f28189c.j());
    }

    public int h() {
        String i2 = this.f28189c.i();
        if (CustomDialogData.POS_LEFT.equals(i2)) {
            return 2;
        }
        if ("center".equals(i2)) {
            return 4;
        }
        return "right".equals(i2) ? 3 : 2;
    }

    public String i() {
        return this.f28187a == 2 ? this.f28188b : "";
    }

    public String j() {
        return this.f28187a == 1 ? this.f28188b : "";
    }

    public int k() {
        return this.f28189c.h();
    }

    public float l() {
        return this.f28189c.a();
    }

    public int m() {
        return a(this.f28189c.l());
    }

    public float n() {
        return this.f28189c.b();
    }

    public boolean o() {
        return this.f28189c.o();
    }

    public int p() {
        String m = this.f28189c.m();
        if (!TextUtils.isEmpty(m) && !m.equals("none")) {
            if (m.equals("normal")) {
                return 1;
            }
            if (m.equals("creative")) {
                return 2;
            }
            if (m.equals("video")) {
                return 4;
            }
            if ("slide".equals(this.f28189c.n())) {
                return 2;
            }
        }
        return 0;
    }

    public int q() {
        return a(this.f28189c.k());
    }

    private int a(String str) {
        String[] split;
        if (TextUtils.isEmpty(str)) {
            return -16777216;
        }
        if (str.equals(OpenFlutter.EXTRA_TRANSPARANT)) {
            return 0;
        }
        if (str.charAt(0) == '#' && str.length() == 7) {
            return Color.parseColor(str);
        }
        if (str.startsWith("rgba") && (split = str.substring(str.indexOf("(") + 1, str.indexOf(SmallTailInfo.EMOTION_SUFFIX)).split(",")) != null && split.length == 4) {
            return (((int) ((Float.parseFloat(split[3]) * 255.0f) + 0.5f)) << 24) | (((int) Float.parseFloat(split[0])) << 16) | (((int) Float.parseFloat(split[1])) << 8) | ((int) Float.parseFloat(split[2])) | 0;
        }
        return -16777216;
    }
}
