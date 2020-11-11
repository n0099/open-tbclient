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
    private float auM;
    private Rect oDP;
    private Drawable oDD = null;
    private Drawable oDE = null;
    private Drawable mThumbDrawable = null;
    private int oDF = a.oDR;
    private int oDG = a.oDQ;
    private int oDH = a.oDS;
    private int oDI = a.oDT;
    private int oDJ = 0;
    private int oDK = 0;
    private int oDL = 0;
    private int oDM = 0;
    private int mThumbWidth = -1;
    private int oDN = -1;
    private int bBX = -1;
    private float mRadius = -1.0f;
    private float oDO = 0.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a {
        static int oDQ = Color.parseColor("#E3E3E3");
        static int oDR = Color.parseColor("#02BFE7");
        static int oDS = Color.parseColor("#FFFFFF");
        static int oDT = Color.parseColor("#fafafa");
        static int oDU = 2;
        static int DEFAULT_RADIUS = 999;
        static float oDV = 2.0f;
        static int oDW = 0;
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static class C0953b {
        static int oDX = 24;
    }

    public static b bf(float f) {
        b bVar = new b();
        bVar.auM = f;
        bVar.NP(bVar.ehB());
        bVar.oDP = new Rect(a.oDW, a.oDW, a.oDW, a.oDW);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(Drawable drawable) {
        if (drawable == null) {
            c.e("SwitchButtonConfiguration", "off drawable can not be null");
        } else {
            this.oDE = drawable;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(Drawable drawable) {
        if (drawable == null) {
            c.e("SwitchButtonConfiguration", "onDrawable can not be null");
        } else {
            this.oDD = drawable;
        }
    }

    public Drawable ehz() {
        return this.oDD;
    }

    public Drawable ehA() {
        return this.oDE;
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

    public void K(int i, int i2, int i3, int i4) {
        this.oDJ = i;
        this.oDK = i2;
        this.oDL = i3;
        this.oDM = i4;
    }

    public void NP(int i) {
        K(i, i, i, i);
    }

    public int ehB() {
        return (int) (a.oDU * this.auM);
    }

    public int ehC() {
        return this.oDJ;
    }

    public int ehD() {
        return this.oDK;
    }

    public int ehE() {
        return this.oDL;
    }

    public int ehF() {
        return this.oDM;
    }

    public float getDensity() {
        return this.auM;
    }

    public void setRadius(float f) {
        this.mRadius = f;
    }

    public float getRadius() {
        return this.mRadius < 0.0f ? a.DEFAULT_RADIUS : this.mRadius;
    }

    public void NO(int i) {
        this.bBX = i;
    }

    public int ehG() {
        return this.bBX;
    }

    public void dP(int i, int i2) {
        if (i > 0) {
            this.mThumbWidth = i;
        }
        if (i2 > 0) {
            this.oDN = i2;
        }
    }

    public Drawable ehH() {
        return this.oDE != null ? this.oDE : NU(this.oDG);
    }

    public Drawable ehI() {
        return this.oDD != null ? this.oDD : NU(this.oDF);
    }

    public Drawable ehJ() {
        int[] iArr;
        if (this.mThumbDrawable != null) {
            return this.mThumbDrawable;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable NU = NU(this.oDH);
        Drawable NU2 = NU(this.oDI);
        try {
            Field declaredField = View.class.getDeclaredField("PRESSED_ENABLED_STATE_SET");
            declaredField.setAccessible(true);
            iArr = (int[]) declaredField.get(null);
        } catch (Exception e) {
            Log.e("Configuration", e.getMessage() + "");
            iArr = null;
        }
        if (iArr != null) {
            stateListDrawable.addState(iArr, NU2);
        }
        stateListDrawable.addState(new int[0], NU);
        return stateListDrawable;
    }

    public float ehK() {
        if (this.oDO <= 0.0f) {
            this.oDO = a.oDV;
        }
        return this.oDO;
    }

    public void bg(float f) {
        if (f <= 0.0f) {
            this.oDO = a.oDV;
        }
        this.oDO = f;
    }

    public Rect ehL() {
        return this.oDP;
    }

    public void L(int i, int i2, int i3, int i4) {
        NQ(i);
        NR(i2);
        NS(i3);
        NT(i4);
    }

    public void NQ(int i) {
        if (i > 0) {
            i = -i;
        }
        this.oDP.left = i;
    }

    public void NR(int i) {
        if (i > 0) {
            i = -i;
        }
        this.oDP.top = i;
    }

    public void NS(int i) {
        if (i > 0) {
            i = -i;
        }
        this.oDP.right = i;
    }

    public void NT(int i) {
        if (i > 0) {
            i = -i;
        }
        this.oDP.bottom = i;
    }

    public int ehM() {
        return ehO() / 2;
    }

    public int ehN() {
        return ehP() / 2;
    }

    public int ehO() {
        return this.oDP.left + this.oDP.right;
    }

    public int ehP() {
        return this.oDP.top + this.oDP.bottom;
    }

    public boolean ehQ() {
        return ((this.oDP.left + this.oDP.right) + this.oDP.top) + this.oDP.bottom != 0;
    }

    private Drawable NU(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(getRadius());
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int ehR() {
        int i = this.mThumbWidth;
        if (i < 0) {
            if (this.mThumbDrawable == null || (i = this.mThumbDrawable.getIntrinsicWidth()) <= 0) {
                if (this.auM <= 0.0f) {
                    c.e("SwitchButtonConfiguration", "density must be a positive number");
                    return i;
                }
                return (int) (C0953b.oDX * this.auM);
            }
            return i;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int ehS() {
        int i = this.oDN;
        if (i < 0) {
            if (this.mThumbDrawable == null || (i = this.mThumbDrawable.getIntrinsicHeight()) <= 0) {
                if (this.auM <= 0.0f) {
                    c.e("SwitchButtonConfiguration", "density must be a positive number");
                    return i;
                }
                return (int) (C0953b.oDX * this.auM);
            }
            return i;
        }
        return i;
    }
}
