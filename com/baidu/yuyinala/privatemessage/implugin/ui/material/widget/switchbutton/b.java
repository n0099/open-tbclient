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
    private Rect oWd;
    private Drawable oVS = null;
    private Drawable oVT = null;
    private Drawable mThumbDrawable = null;
    private int oVU = a.oWf;
    private int oVV = a.oWe;
    private int orT = a.oWg;
    private int oVW = a.oWh;
    private int oVX = 0;
    private int oVY = 0;
    private int oVZ = 0;
    private int oWa = 0;
    private int mThumbWidth = -1;
    private int oWb = -1;
    private int bFw = -1;
    private float mRadius = -1.0f;
    private float oWc = 0.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public static class a {
        static int oWe = Color.parseColor("#E3E3E3");
        static int oWf = Color.parseColor("#02BFE7");
        static int oWg = Color.parseColor("#FFFFFF");
        static int oWh = Color.parseColor("#fafafa");
        static int oWi = 2;
        static int DEFAULT_RADIUS = 999;
        static float oWj = 2.0f;
        static int oWk = 0;
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    static class C0970b {
        static int oWl = 24;
    }

    public static b by(float f) {
        b bVar = new b();
        bVar.djw = f;
        bVar.Nx(bVar.ejx());
        bVar.oWd = new Rect(a.oWk, a.oWk, a.oWk, a.oWk);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(Drawable drawable) {
        if (drawable == null) {
            c.e("SwitchButtonConfiguration", "off drawable can not be null");
        } else {
            this.oVT = drawable;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(Drawable drawable) {
        if (drawable == null) {
            c.e("SwitchButtonConfiguration", "onDrawable can not be null");
        } else {
            this.oVS = drawable;
        }
    }

    public Drawable ejv() {
        return this.oVS;
    }

    public Drawable ejw() {
        return this.oVT;
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
        this.oVX = i;
        this.oVY = i2;
        this.oVZ = i3;
        this.oWa = i4;
    }

    public void Nx(int i) {
        P(i, i, i, i);
    }

    public int ejx() {
        return (int) (a.oWi * this.djw);
    }

    public int ejy() {
        return this.oVX;
    }

    public int ejz() {
        return this.oVY;
    }

    public int ejA() {
        return this.oVZ;
    }

    public int ejB() {
        return this.oWa;
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
            this.oWb = i2;
        }
    }

    public Drawable ejD() {
        return this.oVT != null ? this.oVT : NC(this.oVV);
    }

    public Drawable ejE() {
        return this.oVS != null ? this.oVS : NC(this.oVU);
    }

    public Drawable ejF() {
        int[] iArr;
        if (this.mThumbDrawable != null) {
            return this.mThumbDrawable;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable NC = NC(this.orT);
        Drawable NC2 = NC(this.oVW);
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
        if (this.oWc <= 0.0f) {
            this.oWc = a.oWj;
        }
        return this.oWc;
    }

    public void bz(float f) {
        if (f <= 0.0f) {
            this.oWc = a.oWj;
        }
        this.oWc = f;
    }

    public Rect ejH() {
        return this.oWd;
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
        this.oWd.left = i;
    }

    public void Nz(int i) {
        if (i > 0) {
            i = -i;
        }
        this.oWd.top = i;
    }

    public void NA(int i) {
        if (i > 0) {
            i = -i;
        }
        this.oWd.right = i;
    }

    public void NB(int i) {
        if (i > 0) {
            i = -i;
        }
        this.oWd.bottom = i;
    }

    public int ejI() {
        return ejK() / 2;
    }

    public int ejJ() {
        return ejL() / 2;
    }

    public int ejK() {
        return this.oWd.left + this.oWd.right;
    }

    public int ejL() {
        return this.oWd.top + this.oWd.bottom;
    }

    public boolean ejM() {
        return ((this.oWd.left + this.oWd.right) + this.oWd.top) + this.oWd.bottom != 0;
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
                return (int) (C0970b.oWl * this.djw);
            }
            return i;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int ejO() {
        int i = this.oWb;
        if (i < 0) {
            if (this.mThumbDrawable == null || (i = this.mThumbDrawable.getIntrinsicHeight()) <= 0) {
                if (this.djw <= 0.0f) {
                    c.e("SwitchButtonConfiguration", "density must be a positive number");
                    return i;
                }
                return (int) (C0970b.oWl * this.djw);
            }
            return i;
        }
        return i;
    }
}
