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
/* loaded from: classes11.dex */
public class b implements Cloneable {
    private float dok;
    private Rect paH;
    private Drawable pav = null;
    private Drawable paw = null;
    private Drawable mThumbDrawable = null;
    private int pax = a.paJ;
    private int paz = a.paI;
    private int owz = a.paK;
    private int paA = a.paL;
    private int paB = 0;
    private int paC = 0;
    private int paD = 0;
    private int paE = 0;
    private int mThumbWidth = -1;
    private int paF = -1;
    private int bKi = -1;
    private float mRadius = -1.0f;
    private float paG = 0.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class a {
        static int paI = Color.parseColor("#E3E3E3");
        static int paJ = Color.parseColor("#02BFE7");
        static int paK = Color.parseColor("#FFFFFF");
        static int paL = Color.parseColor("#fafafa");
        static int paM = 2;
        static int DEFAULT_RADIUS = 999;
        static float paN = 2.0f;
        static int paO = 0;
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    static class C0987b {
        static int paP = 24;
    }

    public static b by(float f) {
        b bVar = new b();
        bVar.dok = f;
        bVar.Pe(bVar.ens());
        bVar.paH = new Rect(a.paO, a.paO, a.paO, a.paO);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(Drawable drawable) {
        if (drawable == null) {
            c.e("SwitchButtonConfiguration", "off drawable can not be null");
        } else {
            this.paw = drawable;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(Drawable drawable) {
        if (drawable == null) {
            c.e("SwitchButtonConfiguration", "onDrawable can not be null");
        } else {
            this.pav = drawable;
        }
    }

    public Drawable enq() {
        return this.pav;
    }

    public Drawable enr() {
        return this.paw;
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
        this.paB = i;
        this.paC = i2;
        this.paD = i3;
        this.paE = i4;
    }

    public void Pe(int i) {
        P(i, i, i, i);
    }

    public int ens() {
        return (int) (a.paM * this.dok);
    }

    public int ent() {
        return this.paB;
    }

    public int enu() {
        return this.paC;
    }

    public int env() {
        return this.paD;
    }

    public int enw() {
        return this.paE;
    }

    public float getDensity() {
        return this.dok;
    }

    public void setRadius(float f) {
        this.mRadius = f;
    }

    public float getRadius() {
        return this.mRadius < 0.0f ? a.DEFAULT_RADIUS : this.mRadius;
    }

    public void Pd(int i) {
        this.bKi = i;
    }

    public int enx() {
        return this.bKi;
    }

    public void dT(int i, int i2) {
        if (i > 0) {
            this.mThumbWidth = i;
        }
        if (i2 > 0) {
            this.paF = i2;
        }
    }

    public Drawable eny() {
        return this.paw != null ? this.paw : Pj(this.paz);
    }

    public Drawable enz() {
        return this.pav != null ? this.pav : Pj(this.pax);
    }

    public Drawable enA() {
        int[] iArr;
        if (this.mThumbDrawable != null) {
            return this.mThumbDrawable;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable Pj = Pj(this.owz);
        Drawable Pj2 = Pj(this.paA);
        try {
            Field declaredField = View.class.getDeclaredField("PRESSED_ENABLED_STATE_SET");
            declaredField.setAccessible(true);
            iArr = (int[]) declaredField.get(null);
        } catch (Exception e) {
            Log.e("Configuration", e.getMessage() + "");
            iArr = null;
        }
        if (iArr != null) {
            stateListDrawable.addState(iArr, Pj2);
        }
        stateListDrawable.addState(new int[0], Pj);
        return stateListDrawable;
    }

    public float enB() {
        if (this.paG <= 0.0f) {
            this.paG = a.paN;
        }
        return this.paG;
    }

    public void bz(float f) {
        if (f <= 0.0f) {
            this.paG = a.paN;
        }
        this.paG = f;
    }

    public Rect enC() {
        return this.paH;
    }

    public void Q(int i, int i2, int i3, int i4) {
        Pf(i);
        Pg(i2);
        Ph(i3);
        Pi(i4);
    }

    public void Pf(int i) {
        if (i > 0) {
            i = -i;
        }
        this.paH.left = i;
    }

    public void Pg(int i) {
        if (i > 0) {
            i = -i;
        }
        this.paH.top = i;
    }

    public void Ph(int i) {
        if (i > 0) {
            i = -i;
        }
        this.paH.right = i;
    }

    public void Pi(int i) {
        if (i > 0) {
            i = -i;
        }
        this.paH.bottom = i;
    }

    public int enD() {
        return enF() / 2;
    }

    public int enE() {
        return enG() / 2;
    }

    public int enF() {
        return this.paH.left + this.paH.right;
    }

    public int enG() {
        return this.paH.top + this.paH.bottom;
    }

    public boolean enH() {
        return ((this.paH.left + this.paH.right) + this.paH.top) + this.paH.bottom != 0;
    }

    private Drawable Pj(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(getRadius());
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int enI() {
        int i = this.mThumbWidth;
        if (i < 0) {
            if (this.mThumbDrawable == null || (i = this.mThumbDrawable.getIntrinsicWidth()) <= 0) {
                if (this.dok <= 0.0f) {
                    c.e("SwitchButtonConfiguration", "density must be a positive number");
                    return i;
                }
                return (int) (C0987b.paP * this.dok);
            }
            return i;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int enJ() {
        int i = this.paF;
        if (i < 0) {
            if (this.mThumbDrawable == null || (i = this.mThumbDrawable.getIntrinsicHeight()) <= 0) {
                if (this.dok <= 0.0f) {
                    c.e("SwitchButtonConfiguration", "density must be a positive number");
                    return i;
                }
                return (int) (C0987b.paP * this.dok);
            }
            return i;
        }
        return i;
    }
}
