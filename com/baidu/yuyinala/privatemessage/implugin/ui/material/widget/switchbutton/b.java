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
    private Rect oUB;
    private Drawable oUp = null;
    private Drawable oUq = null;
    private Drawable mThumbDrawable = null;
    private int oUr = a.oUD;
    private int oUs = a.oUC;
    private int oUt = a.oUE;
    private int oUu = a.oUF;
    private int oUv = 0;
    private int oUw = 0;
    private int oUx = 0;
    private int oUy = 0;
    private int mThumbWidth = -1;
    private int oUz = -1;
    private int bFu = -1;
    private float mRadius = -1.0f;
    private float oUA = 0.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a {
        static int oUC = Color.parseColor("#E3E3E3");
        static int oUD = Color.parseColor("#02BFE7");
        static int oUE = Color.parseColor("#FFFFFF");
        static int oUF = Color.parseColor("#fafafa");
        static int oUG = 2;
        static int DEFAULT_RADIUS = 999;
        static float oUH = 2.0f;
        static int oUI = 0;
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static class C0973b {
        static int oUJ = 24;
    }

    public static b bn(float f) {
        b bVar = new b();
        bVar.djm = f;
        bVar.Pq(bVar.enp());
        bVar.oUB = new Rect(a.oUI, a.oUI, a.oUI, a.oUI);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(Drawable drawable) {
        if (drawable == null) {
            c.e("SwitchButtonConfiguration", "off drawable can not be null");
        } else {
            this.oUq = drawable;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(Drawable drawable) {
        if (drawable == null) {
            c.e("SwitchButtonConfiguration", "onDrawable can not be null");
        } else {
            this.oUp = drawable;
        }
    }

    public Drawable enn() {
        return this.oUp;
    }

    public Drawable eno() {
        return this.oUq;
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
        this.oUv = i;
        this.oUw = i2;
        this.oUx = i3;
        this.oUy = i4;
    }

    public void Pq(int i) {
        P(i, i, i, i);
    }

    public int enp() {
        return (int) (a.oUG * this.djm);
    }

    public int enq() {
        return this.oUv;
    }

    public int enr() {
        return this.oUw;
    }

    public int ens() {
        return this.oUx;
    }

    public int ent() {
        return this.oUy;
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

    public int enu() {
        return this.bFu;
    }

    public void dV(int i, int i2) {
        if (i > 0) {
            this.mThumbWidth = i;
        }
        if (i2 > 0) {
            this.oUz = i2;
        }
    }

    public Drawable env() {
        return this.oUq != null ? this.oUq : Pv(this.oUs);
    }

    public Drawable enw() {
        return this.oUp != null ? this.oUp : Pv(this.oUr);
    }

    public Drawable enx() {
        int[] iArr;
        if (this.mThumbDrawable != null) {
            return this.mThumbDrawable;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable Pv = Pv(this.oUt);
        Drawable Pv2 = Pv(this.oUu);
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

    public float eny() {
        if (this.oUA <= 0.0f) {
            this.oUA = a.oUH;
        }
        return this.oUA;
    }

    public void bo(float f) {
        if (f <= 0.0f) {
            this.oUA = a.oUH;
        }
        this.oUA = f;
    }

    public Rect enz() {
        return this.oUB;
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
        this.oUB.left = i;
    }

    public void Ps(int i) {
        if (i > 0) {
            i = -i;
        }
        this.oUB.top = i;
    }

    public void Pt(int i) {
        if (i > 0) {
            i = -i;
        }
        this.oUB.right = i;
    }

    public void Pu(int i) {
        if (i > 0) {
            i = -i;
        }
        this.oUB.bottom = i;
    }

    public int enA() {
        return enC() / 2;
    }

    public int enB() {
        return enD() / 2;
    }

    public int enC() {
        return this.oUB.left + this.oUB.right;
    }

    public int enD() {
        return this.oUB.top + this.oUB.bottom;
    }

    public boolean enE() {
        return ((this.oUB.left + this.oUB.right) + this.oUB.top) + this.oUB.bottom != 0;
    }

    private Drawable Pv(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(getRadius());
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int enF() {
        int i = this.mThumbWidth;
        if (i < 0) {
            if (this.mThumbDrawable == null || (i = this.mThumbDrawable.getIntrinsicWidth()) <= 0) {
                if (this.djm <= 0.0f) {
                    c.e("SwitchButtonConfiguration", "density must be a positive number");
                    return i;
                }
                return (int) (C0973b.oUJ * this.djm);
            }
            return i;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int enG() {
        int i = this.oUz;
        if (i < 0) {
            if (this.mThumbDrawable == null || (i = this.mThumbDrawable.getIntrinsicHeight()) <= 0) {
                if (this.djm <= 0.0f) {
                    c.e("SwitchButtonConfiguration", "density must be a positive number");
                    return i;
                }
                return (int) (C0973b.oUJ * this.djm);
            }
            return i;
        }
        return i;
    }
}
