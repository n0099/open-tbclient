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
    private float dni;
    private Rect piZ;
    private Drawable piO = null;
    private Drawable piP = null;
    private Drawable mThumbDrawable = null;
    private int piQ = a.pjb;
    private int piR = a.pja;
    private int oEo = a.pjc;
    private int piS = a.pjd;
    private int piT = 0;
    private int piU = 0;
    private int piV = 0;
    private int piW = 0;
    private int mThumbWidth = -1;
    private int piX = -1;
    private int bKG = -1;
    private float mRadius = -1.0f;
    private float piY = 0.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public static class a {
        static int pja = Color.parseColor("#E3E3E3");
        static int pjb = Color.parseColor("#02BFE7");
        static int pjc = Color.parseColor("#FFFFFF");
        static int pjd = Color.parseColor("#fafafa");
        static int pje = 2;
        static int DEFAULT_RADIUS = 999;
        static float pjf = 2.0f;
        static int pjg = 0;
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    static class C0982b {
        static int pjh = 24;
    }

    public static b bF(float f) {
        b bVar = new b();
        bVar.dni = f;
        bVar.NX(bVar.emj());
        bVar.piZ = new Rect(a.pjg, a.pjg, a.pjg, a.pjg);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(Drawable drawable) {
        if (drawable == null) {
            c.e("SwitchButtonConfiguration", "off drawable can not be null");
        } else {
            this.piP = drawable;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(Drawable drawable) {
        if (drawable == null) {
            c.e("SwitchButtonConfiguration", "onDrawable can not be null");
        } else {
            this.piO = drawable;
        }
    }

    public Drawable emh() {
        return this.piO;
    }

    public Drawable emi() {
        return this.piP;
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

    public void N(int i, int i2, int i3, int i4) {
        this.piT = i;
        this.piU = i2;
        this.piV = i3;
        this.piW = i4;
    }

    public void NX(int i) {
        N(i, i, i, i);
    }

    public int emj() {
        return (int) (a.pje * this.dni);
    }

    public int emk() {
        return this.piT;
    }

    public int eml() {
        return this.piU;
    }

    public int emm() {
        return this.piV;
    }

    public int emn() {
        return this.piW;
    }

    public float getDensity() {
        return this.dni;
    }

    public void setRadius(float f) {
        this.mRadius = f;
    }

    public float getRadius() {
        return this.mRadius < 0.0f ? a.DEFAULT_RADIUS : this.mRadius;
    }

    public void NW(int i) {
        this.bKG = i;
    }

    public int emo() {
        return this.bKG;
    }

    public void dR(int i, int i2) {
        if (i > 0) {
            this.mThumbWidth = i;
        }
        if (i2 > 0) {
            this.piX = i2;
        }
    }

    public Drawable emp() {
        return this.piP != null ? this.piP : Oc(this.piR);
    }

    public Drawable emq() {
        return this.piO != null ? this.piO : Oc(this.piQ);
    }

    public Drawable emr() {
        int[] iArr;
        if (this.mThumbDrawable != null) {
            return this.mThumbDrawable;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable Oc = Oc(this.oEo);
        Drawable Oc2 = Oc(this.piS);
        try {
            Field declaredField = View.class.getDeclaredField("PRESSED_ENABLED_STATE_SET");
            declaredField.setAccessible(true);
            iArr = (int[]) declaredField.get(null);
        } catch (Exception e) {
            Log.e("Configuration", e.getMessage() + "");
            iArr = null;
        }
        if (iArr != null) {
            stateListDrawable.addState(iArr, Oc2);
        }
        stateListDrawable.addState(new int[0], Oc);
        return stateListDrawable;
    }

    public float ems() {
        if (this.piY <= 0.0f) {
            this.piY = a.pjf;
        }
        return this.piY;
    }

    public void bG(float f) {
        if (f <= 0.0f) {
            this.piY = a.pjf;
        }
        this.piY = f;
    }

    public Rect emt() {
        return this.piZ;
    }

    public void O(int i, int i2, int i3, int i4) {
        NY(i);
        NZ(i2);
        Oa(i3);
        Ob(i4);
    }

    public void NY(int i) {
        if (i > 0) {
            i = -i;
        }
        this.piZ.left = i;
    }

    public void NZ(int i) {
        if (i > 0) {
            i = -i;
        }
        this.piZ.top = i;
    }

    public void Oa(int i) {
        if (i > 0) {
            i = -i;
        }
        this.piZ.right = i;
    }

    public void Ob(int i) {
        if (i > 0) {
            i = -i;
        }
        this.piZ.bottom = i;
    }

    public int emu() {
        return emw() / 2;
    }

    public int emv() {
        return emx() / 2;
    }

    public int emw() {
        return this.piZ.left + this.piZ.right;
    }

    public int emx() {
        return this.piZ.top + this.piZ.bottom;
    }

    public boolean emy() {
        return ((this.piZ.left + this.piZ.right) + this.piZ.top) + this.piZ.bottom != 0;
    }

    private Drawable Oc(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(getRadius());
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getThumbWidth() {
        int i = this.mThumbWidth;
        if (i < 0) {
            if (this.mThumbDrawable == null || (i = this.mThumbDrawable.getIntrinsicWidth()) <= 0) {
                if (this.dni <= 0.0f) {
                    c.e("SwitchButtonConfiguration", "density must be a positive number");
                    return i;
                }
                return (int) (C0982b.pjh * this.dni);
            }
            return i;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getThumbHeight() {
        int i = this.piX;
        if (i < 0) {
            if (this.mThumbDrawable == null || (i = this.mThumbDrawable.getIntrinsicHeight()) <= 0) {
                if (this.dni <= 0.0f) {
                    c.e("SwitchButtonConfiguration", "density must be a positive number");
                    return i;
                }
                return (int) (C0982b.pjh * this.dni);
            }
            return i;
        }
        return i;
    }
}
