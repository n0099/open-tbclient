package com.bytedance.sdk.openadsdk.core.dynamic.b;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.flutter.base.util.OpenFlutter;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public int f27965a;

    /* renamed from: b  reason: collision with root package name */
    public String f27966b;

    /* renamed from: c  reason: collision with root package name */
    public d f27967c;

    public e(@NonNull c cVar) {
        this.f27965a = cVar.a();
        this.f27966b = cVar.b();
        this.f27967c = cVar.c();
    }

    public int a() {
        return (int) this.f27967c.c();
    }

    public int b() {
        return (int) this.f27967c.f();
    }

    public int c() {
        return (int) this.f27967c.d();
    }

    public int d() {
        return (int) this.f27967c.e();
    }

    public float e() {
        return this.f27967c.g();
    }

    public String f() {
        return this.f27965a == 0 ? this.f27966b : "";
    }

    public int g() {
        return a(this.f27967c.j());
    }

    public int h() {
        String i = this.f27967c.i();
        if (CustomDialogData.POS_LEFT.equals(i)) {
            return 2;
        }
        if ("center".equals(i)) {
            return 4;
        }
        return "right".equals(i) ? 3 : 2;
    }

    public String i() {
        return this.f27965a == 2 ? this.f27966b : "";
    }

    public String j() {
        return this.f27965a == 1 ? this.f27966b : "";
    }

    public int k() {
        return this.f27967c.h();
    }

    public float l() {
        return this.f27967c.a();
    }

    public int m() {
        return a(this.f27967c.l());
    }

    public float n() {
        return this.f27967c.b();
    }

    public boolean o() {
        return this.f27967c.o();
    }

    public int p() {
        String m = this.f27967c.m();
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
            if ("slide".equals(this.f27967c.n())) {
                return 2;
            }
        }
        return 0;
    }

    public int q() {
        return a(this.f27967c.k());
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
