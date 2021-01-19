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
/* loaded from: classes10.dex */
public class b implements Cloneable {
    private float djw;
    private Rect oWe;
    private Drawable oVT = null;
    private Drawable oVU = null;
    private Drawable mThumbDrawable = null;
    private int oVV = a.oWg;
    private int oVW = a.oWf;
    private int orU = a.oWh;
    private int oVX = a.oWi;
    private int oVY = 0;
    private int oVZ = 0;
    private int oWa = 0;
    private int oWb = 0;
    private int mThumbWidth = -1;
    private int oWc = -1;
    private int bFw = -1;
    private float mRadius = -1.0f;
    private float oWd = 0.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public static class a {
        static int oWf = Color.parseColor("#E3E3E3");
        static int oWg = Color.parseColor("#02BFE7");
        static int oWh = Color.parseColor("#FFFFFF");
        static int oWi = Color.parseColor("#fafafa");
        static int oWj = 2;
        static int DEFAULT_RADIUS = 999;
        static float oWk = 2.0f;
        static int oWl = 0;
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    static class C0970b {
        static int oWm = 24;
    }

    public static b by(float f) {
        b bVar = new b();
        bVar.djw = f;
        bVar.Nx(bVar.ejx());
        bVar.oWe = new Rect(a.oWl, a.oWl, a.oWl, a.oWl);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(Drawable drawable) {
        if (drawable == null) {
            c.e("SwitchButtonConfiguration", "off drawable can not be null");
        } else {
            this.oVU = drawable;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(Drawable drawable) {
        if (drawable == null) {
            c.e("SwitchButtonConfiguration", "onDrawable can not be null");
        } else {
            this.oVT = drawable;
        }
    }

    public Drawable ejv() {
        return this.oVT;
    }

    public Drawable ejw() {
        return this.oVU;
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
        this.oVY = i;
        this.oVZ = i2;
        this.oWa = i3;
        this.oWb = i4;
    }

    public void Nx(int i) {
        P(i, i, i, i);
    }

    public int ejx() {
        return (int) (a.oWj * this.djw);
    }

    public int ejy() {
        return this.oVY;
    }

    public int ejz() {
        return this.oVZ;
    }

    public int ejA() {
        return this.oWa;
    }

    public int ejB() {
        return this.oWb;
    }

    public float getDensity() {
        return this.djw;
    }

    public void setRadius(float f) {
        this.mRadius = f;
    }

    public float getRadius() {
        return this.mRadius < 0.0f ? a.DEFAULT_RADIUS : this.mRadius;
    }

    public void Nw(int i) {
        this.bFw = i;
    }

    public int ejC() {
        return this.bFw;
    }

    public void dT(int i, int i2) {
        if (i > 0) {
            this.mThumbWidth = i;
        }
        if (i2 > 0) {
            this.oWc = i2;
        }
    }

    public Drawable ejD() {
        return this.oVU != null ? this.oVU : NC(this.oVW);
    }

    public Drawable ejE() {
        return this.oVT != null ? this.oVT : NC(this.oVV);
    }

    public Drawable ejF() {
        int[] iArr;
        if (this.mThumbDrawable != null) {
            return this.mThumbDrawable;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable NC = NC(this.orU);
        Drawable NC2 = NC(this.oVX);
        try {
            Field declaredField = View.class.getDeclaredField("PRESSED_ENABLED_STATE_SET");
            declaredField.setAccessible(true);
            iArr = (int[]) declaredField.get(null);
        } catch (Exception e) {
            Log.e("Configuration", e.getMessage() + "");
            iArr = null;
        }
        if (iArr != null) {
            stateListDrawable.addState(iArr, NC2);
        }
        stateListDrawable.addState(new int[0], NC);
        return stateListDrawable;
    }

    public float ejG() {
        if (this.oWd <= 0.0f) {
            this.oWd = a.oWk;
        }
        return this.oWd;
    }

    public void bz(float f) {
        if (f <= 0.0f) {
            this.oWd = a.oWk;
        }
        this.oWd = f;
    }

    public Rect ejH() {
        return this.oWe;
    }

    public void Q(int i, int i2, int i3, int i4) {
        Ny(i);
        Nz(i2);
        NA(i3);
        NB(i4);
    }

    public void Ny(int i) {
        if (i > 0) {
            i = -i;
        }
        this.oWe.left = i;
    }

    public void Nz(int i) {
        if (i > 0) {
            i = -i;
        }
        this.oWe.top = i;
    }

    public void NA(int i) {
        if (i > 0) {
            i = -i;
        }
        this.oWe.right = i;
    }

    public void NB(int i) {
        if (i > 0) {
            i = -i;
        }
        this.oWe.bottom = i;
    }

    public int ejI() {
        return ejK() / 2;
    }

    public int ejJ() {
        return ejL() / 2;
    }

    public int ejK() {
        return this.oWe.left + this.oWe.right;
    }

    public int ejL() {
        return this.oWe.top + this.oWe.bottom;
    }

    public boolean ejM() {
        return ((this.oWe.left + this.oWe.right) + this.oWe.top) + this.oWe.bottom != 0;
    }

    private Drawable NC(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(getRadius());
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int ejN() {
        int i = this.mThumbWidth;
        if (i < 0) {
            if (this.mThumbDrawable == null || (i = this.mThumbDrawable.getIntrinsicWidth()) <= 0) {
                if (this.djw <= 0.0f) {
                    c.e("SwitchButtonConfiguration", "density must be a positive number");
                    return i;
                }
                return (int) (C0970b.oWm * this.djw);
            }
            return i;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int ejO() {
        int i = this.oWc;
        if (i < 0) {
            if (this.mThumbDrawable == null || (i = this.mThumbDrawable.getIntrinsicHeight()) <= 0) {
                if (this.djw <= 0.0f) {
                    c.e("SwitchButtonConfiguration", "density must be a positive number");
                    return i;
                }
                return (int) (C0970b.oWm * this.djw);
            }
            return i;
        }
        return i;
    }
}
