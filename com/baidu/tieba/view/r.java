package com.baidu.tieba.view;

import android.content.Context;
import android.widget.LinearLayout;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f1876a;
    private s b;
    private u c;
    private t d;

    private r(p pVar) {
        this.f1876a = pVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ r(p pVar, r rVar) {
        this(pVar);
    }

    public LinearLayout a(Context context, int i, boolean z, float f, com.baidu.tieba.data.ai aiVar, int i2, int i3) {
        s a2;
        if (!a(aiVar) && (a2 = a(context, i, z, i2, i3)) != null) {
            LinearLayout a3 = a(context);
            z zVar = (z) a3.getChildAt(0);
            if (zVar == null) {
                return null;
            }
            a(a3, zVar, a2);
            a(zVar, aiVar, i2, z);
            return a3;
        }
        return null;
    }

    public void a(Context context, LinearLayout linearLayout, int i, boolean z, boolean z2, float f, com.baidu.tieba.data.ai aiVar, int i2, int i3) {
        z zVar;
        if (!a(aiVar) && (zVar = (z) linearLayout.getChildAt(0)) != null) {
            a(linearLayout, zVar, a(context, i, z, i2, i3));
            a(zVar, aiVar, i2, z);
        }
    }

    private void a(z zVar, com.baidu.tieba.data.ai aiVar, int i, boolean z) {
        zVar.setPicNum(i);
        zVar.setTag(aiVar.b());
        zVar.setIsWifi(z);
        zVar.setType(aiVar.a());
    }

    private void a(LinearLayout linearLayout, z zVar, s sVar) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(sVar.f1877a, sVar.b);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(sVar.f1877a, -2);
        layoutParams2.leftMargin = sVar.c;
        layoutParams2.rightMargin = sVar.d;
        layoutParams2.topMargin = 0;
        layoutParams2.bottomMargin = 0;
        zVar.setLayoutParams(layoutParams);
        linearLayout.setLayoutParams(layoutParams2);
    }

    private LinearLayout a(Context context) {
        z zVar = new z(context);
        LinearLayout linearLayout = new LinearLayout(context);
        zVar.setClickable(false);
        zVar.setFocusable(false);
        linearLayout.addView(zVar);
        return linearLayout;
    }

    private boolean a(com.baidu.tieba.data.ai aiVar) {
        return aiVar.c() != null && (aiVar.c().length() < 1 || aiVar.c().endsWith("swf"));
    }

    private s a(Context context, int i, boolean z, int i2, int i3) {
        int a2 = i - UtilHelper.a(context, 14.0f);
        if (i2 == 1) {
            if (this.b == null || this.b.e != z) {
                a(context, a2, z);
            }
            return this.b;
        } else if (i2 == 2) {
            if (this.c == null || this.c.c != z) {
                b(context, a2, z);
            }
            return i3 == 1 ? this.c.b : this.c.f1879a;
        } else if (i2 == 3) {
            if (this.d == null || this.d.d != z) {
                c(context, a2, z);
            }
            return i3 == 2 ? this.d.c : i3 == 1 ? this.d.b : this.d.f1878a;
        } else {
            return null;
        }
    }

    private void a(Context context, int i, boolean z) {
        float f;
        int i2;
        int a2;
        int i3 = 0;
        this.b = new s(this, null);
        if (!z) {
            f = this.f1876a.d;
            int i4 = (int) (i * f);
            i2 = (int) (i4 * 0.5d);
            a2 = UtilHelper.a(context, 6.0f);
            i3 = UtilHelper.a(context, 7.0f);
            i = (i4 - a2) - i3;
        } else {
            i2 = (int) (i * 0.5d);
            a2 = 0;
        }
        this.b.a(i, i2, a2, i3);
        this.b.e = z;
    }

    private void b(Context context, int i, boolean z) {
        this.c = new u(this, null);
        int i2 = i / 2;
        int i3 = (i2 * 2) / 3;
        int i4 = i2 - 0;
        this.c.f1879a.a(i / 2, i3, 0, 0);
        int a2 = UtilHelper.a(context, 6.0f);
        int a3 = UtilHelper.a(context, 0.0f);
        int i5 = ((i / 2) - a2) - a3;
        this.c.b.a(i / 2, i3, a2, a3);
        this.c.c = z;
    }

    private void c(Context context, int i, boolean z) {
        int i2 = ((i / 3) * 3) / 4;
        this.d = new t(this, null);
        int a2 = UtilHelper.a(context, 0.0f);
        this.d.f1878a.a((i / 3) - a2, i2, a2, 0);
        int a3 = UtilHelper.a(context, 6.0f);
        this.d.b.a((i / 3) - a3, i2, a3, 0);
        int a4 = UtilHelper.a(context, 6.0f);
        int a5 = UtilHelper.a(context, 0.0f);
        this.d.c.a(((i / 3) - a4) - a5, i2, a4, a5);
        this.d.d = z;
    }
}
