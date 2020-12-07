package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.Log;
import android.view.View;
import com.baidu.yuyinala.privatemessage.implugin.util.c;
import java.lang.reflect.Field;
/* loaded from: classes4.dex */
public class b implements Cloneable {
    private float djm;
    private Rect oUz;
    private Drawable oUn = null;
    private Drawable oUo = null;
    private Drawable mThumbDrawable = null;
    private int oUp = a.oUB;
    private int oUq = a.oUA;
    private int oUr = a.oUC;
    private int oUs = a.oUD;
    private int oUt = 0;
    private int oUu = 0;
    private int oUv = 0;
    private int oUw = 0;
    private int mThumbWidth = -1;
    private int oUx = -1;
    private int bFu = -1;
    private float mRadius = -1.0f;
    private float oUy = 0.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a {
        static int oUA = Color.parseColor("#E3E3E3");
        static int oUB = Color.parseColor("#02BFE7");
        static int oUC = Color.parseColor("#FFFFFF");
        static int oUD = Color.parseColor("#fafafa");
        static int oUE = 2;
        static int DEFAULT_RADIUS = 999;
        static float oUF = 2.0f;
        static int oUG = 0;
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static class C0973b {
        static int oUH = 24;
    }

    public static b bn(float f) {
        b bVar = new b();
        bVar.djm = f;
        bVar.Pq(bVar.eno());
        bVar.oUz = new Rect(a.oUG, a.oUG, a.oUG, a.oUG);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(Drawable drawable) {
        if (drawable == null) {
            c.e("SwitchButtonConfiguration", "off drawable can not be null");
        } else {
            this.oUo = drawable;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(Drawable drawable) {
        if (drawable == null) {
            c.e("SwitchButtonConfiguration", "onDrawable can not be null");
        } else {
            this.oUn = drawable;
        }
    }

    public Drawable enm() {
        return this.oUn;
    }

    public Drawable enn() {
        return this.oUo;
    }

    public void setThumbDrawable(Drawable drawable) {
        if (drawable == null) {
            c.e("SwitchButtonConfiguration", "thumb drawable can not be null");
        } else {
            this.mThumbDrawable = drawable;
        }
    }

    public Drawable getThumbDrawable() {
        return this.mThumbDrawable;
    }

    public void P(int i, int i2, int i3, int i4) {
        this.oUt = i;
        this.oUu = i2;
        this.oUv = i3;
        this.oUw = i4;
    }

    public void Pq(int i) {
        P(i, i, i, i);
    }

    public int eno() {
        return (int) (a.oUE * this.djm);
    }

    public int enp() {
        return this.oUt;
    }

    public int enq() {
        return this.oUu;
    }

    public int enr() {
        return this.oUv;
    }

    public int ens() {
        return this.oUw;
    }

    public float getDensity() {
        return this.djm;
    }

    public void setRadius(float f) {
        this.mRadius = f;
    }

    public float getRadius() {
        return this.mRadius < 0.0f ? a.DEFAULT_RADIUS : this.mRadius;
    }

    public void Pp(int i) {
        this.bFu = i;
    }

    public int ent() {
        return this.bFu;
    }

    public void dV(int i, int i2) {
        if (i > 0) {
            this.mThumbWidth = i;
        }
        if (i2 > 0) {
            this.oUx = i2;
        }
    }

    public Drawable enu() {
        return this.oUo != null ? this.oUo : Pv(this.oUq);
    }

    public Drawable env() {
        return this.oUn != null ? this.oUn : Pv(this.oUp);
    }

    public Drawable enw() {
        int[] iArr;
        if (this.mThumbDrawable != null) {
            return this.mThumbDrawable;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable Pv = Pv(this.oUr);
        Drawable Pv2 = Pv(this.oUs);
        try {
            Field declaredField = View.class.getDeclaredField("PRESSED_ENABLED_STATE_SET");
            declaredField.setAccessible(true);
            iArr = (int[]) declaredField.get(null);
        } catch (Exception e) {
            Log.e("Configuration", e.getMessage() + "");
            iArr = null;
        }
        if (iArr != null) {
            stateListDrawable.addState(iArr, Pv2);
        }
        stateListDrawable.addState(new int[0], Pv);
        return stateListDrawable;
    }

    public float enx() {
        if (this.oUy <= 0.0f) {
            this.oUy = a.oUF;
        }
        return this.oUy;
    }

    public void bo(float f) {
        if (f <= 0.0f) {
            this.oUy = a.oUF;
        }
        this.oUy = f;
    }

    public Rect eny() {
        return this.oUz;
    }

    public void Q(int i, int i2, int i3, int i4) {
        Pr(i);
        Ps(i2);
        Pt(i3);
        Pu(i4);
    }

    public void Pr(int i) {
        if (i > 0) {
            i = -i;
        }
        this.oUz.left = i;
    }

    public void Ps(int i) {
        if (i > 0) {
            i = -i;
        }
        this.oUz.top = i;
    }

    public void Pt(int i) {
        if (i > 0) {
            i = -i;
        }
        this.oUz.right = i;
    }

    public void Pu(int i) {
        if (i > 0) {
            i = -i;
        }
        this.oUz.bottom = i;
    }

    public int enz() {
        return enB() / 2;
    }

    public int enA() {
        return enC() / 2;
    }

    public int enB() {
        return this.oUz.left + this.oUz.right;
    }

    public int enC() {
        return this.oUz.top + this.oUz.bottom;
    }

    public boolean enD() {
        return ((this.oUz.left + this.oUz.right) + this.oUz.top) + this.oUz.bottom != 0;
    }

    private Drawable Pv(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(getRadius());
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int enE() {
        int i = this.mThumbWidth;
        if (i < 0) {
            if (this.mThumbDrawable == null || (i = this.mThumbDrawable.getIntrinsicWidth()) <= 0) {
                if (this.djm <= 0.0f) {
                    c.e("SwitchButtonConfiguration", "density must be a positive number");
                    return i;
                }
                return (int) (C0973b.oUH * this.djm);
            }
            return i;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int enF() {
        int i = this.oUx;
        if (i < 0) {
            if (this.mThumbDrawable == null || (i = this.mThumbDrawable.getIntrinsicHeight()) <= 0) {
                if (this.djm <= 0.0f) {
                    c.e("SwitchButtonConfiguration", "density must be a positive number");
                    return i;
                }
                return (int) (C0973b.oUH * this.djm);
            }
            return i;
        }
        return i;
    }
}
