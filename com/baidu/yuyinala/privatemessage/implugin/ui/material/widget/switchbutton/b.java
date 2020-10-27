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
    private Rect oux;
    private Drawable ouk = null;
    private Drawable oul = null;
    private Drawable mThumbDrawable = null;
    private int oum = a.ouz;
    private int oun = a.ouy;
    private int ouo = a.ouA;
    private int oup = a.ouB;
    private int ouq = 0;
    private int our = 0;
    private int ous = 0;
    private int ouu = 0;
    private int mThumbWidth = -1;
    private int ouv = -1;
    private int bvM = -1;
    private float mRadius = -1.0f;
    private float ouw = 0.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a {
        static int ouy = Color.parseColor("#E3E3E3");
        static int ouz = Color.parseColor("#02BFE7");
        static int ouA = Color.parseColor("#FFFFFF");
        static int ouB = Color.parseColor("#fafafa");
        static int ouC = 2;
        static int DEFAULT_RADIUS = 999;
        static float ouD = 2.0f;
        static int ouE = 0;
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static class C0935b {
        static int ouF = 24;
    }

    public static b bd(float f) {
        b bVar = new b();
        bVar.auM = f;
        bVar.Nu(bVar.edM());
        bVar.oux = new Rect(a.ouE, a.ouE, a.ouE, a.ouE);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(Drawable drawable) {
        if (drawable == null) {
            c.e("SwitchButtonConfiguration", "off drawable can not be null");
        } else {
            this.oul = drawable;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(Drawable drawable) {
        if (drawable == null) {
            c.e("SwitchButtonConfiguration", "onDrawable can not be null");
        } else {
            this.ouk = drawable;
        }
    }

    public Drawable edK() {
        return this.ouk;
    }

    public Drawable edL() {
        return this.oul;
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
        this.ouq = i;
        this.our = i2;
        this.ous = i3;
        this.ouu = i4;
    }

    public void Nu(int i) {
        K(i, i, i, i);
    }

    public int edM() {
        return (int) (a.ouC * this.auM);
    }

    public int edN() {
        return this.ouq;
    }

    public int edO() {
        return this.our;
    }

    public int edP() {
        return this.ous;
    }

    public int edQ() {
        return this.ouu;
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

    public void Nt(int i) {
        this.bvM = i;
    }

    public int edR() {
        return this.bvM;
    }

    public void dM(int i, int i2) {
        if (i > 0) {
            this.mThumbWidth = i;
        }
        if (i2 > 0) {
            this.ouv = i2;
        }
    }

    public Drawable edS() {
        return this.oul != null ? this.oul : Nz(this.oun);
    }

    public Drawable edT() {
        return this.ouk != null ? this.ouk : Nz(this.oum);
    }

    public Drawable edU() {
        int[] iArr;
        if (this.mThumbDrawable != null) {
            return this.mThumbDrawable;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable Nz = Nz(this.ouo);
        Drawable Nz2 = Nz(this.oup);
        try {
            Field declaredField = View.class.getDeclaredField("PRESSED_ENABLED_STATE_SET");
            declaredField.setAccessible(true);
            iArr = (int[]) declaredField.get(null);
        } catch (Exception e) {
            Log.e("Configuration", e.getMessage() + "");
            iArr = null;
        }
        if (iArr != null) {
            stateListDrawable.addState(iArr, Nz2);
        }
        stateListDrawable.addState(new int[0], Nz);
        return stateListDrawable;
    }

    public float edV() {
        if (this.ouw <= 0.0f) {
            this.ouw = a.ouD;
        }
        return this.ouw;
    }

    public void be(float f) {
        if (f <= 0.0f) {
            this.ouw = a.ouD;
        }
        this.ouw = f;
    }

    public Rect edW() {
        return this.oux;
    }

    public void L(int i, int i2, int i3, int i4) {
        Nv(i);
        Nw(i2);
        Nx(i3);
        Ny(i4);
    }

    public void Nv(int i) {
        if (i > 0) {
            i = -i;
        }
        this.oux.left = i;
    }

    public void Nw(int i) {
        if (i > 0) {
            i = -i;
        }
        this.oux.top = i;
    }

    public void Nx(int i) {
        if (i > 0) {
            i = -i;
        }
        this.oux.right = i;
    }

    public void Ny(int i) {
        if (i > 0) {
            i = -i;
        }
        this.oux.bottom = i;
    }

    public int edX() {
        return edZ() / 2;
    }

    public int edY() {
        return eea() / 2;
    }

    public int edZ() {
        return this.oux.left + this.oux.right;
    }

    public int eea() {
        return this.oux.top + this.oux.bottom;
    }

    public boolean eeb() {
        return ((this.oux.left + this.oux.right) + this.oux.top) + this.oux.bottom != 0;
    }

    private Drawable Nz(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(getRadius());
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int eec() {
        int i = this.mThumbWidth;
        if (i < 0) {
            if (this.mThumbDrawable == null || (i = this.mThumbDrawable.getIntrinsicWidth()) <= 0) {
                if (this.auM <= 0.0f) {
                    c.e("SwitchButtonConfiguration", "density must be a positive number");
                    return i;
                }
                return (int) (C0935b.ouF * this.auM);
            }
            return i;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int eed() {
        int i = this.ouv;
        if (i < 0) {
            if (this.mThumbDrawable == null || (i = this.mThumbDrawable.getIntrinsicHeight()) <= 0) {
                if (this.auM <= 0.0f) {
                    c.e("SwitchButtonConfiguration", "density must be a positive number");
                    return i;
                }
                return (int) (C0935b.ouF * this.auM);
            }
            return i;
        }
        return i;
    }
}
