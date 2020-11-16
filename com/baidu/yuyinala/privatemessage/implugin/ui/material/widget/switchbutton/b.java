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
    private float dcl;
    private Rect oFt;
    private Drawable oFh = null;
    private Drawable oFi = null;
    private Drawable mThumbDrawable = null;
    private int oFj = a.oFv;
    private int oFk = a.oFu;
    private int oFl = a.oFw;
    private int oFm = a.oFx;
    private int oFn = 0;
    private int oFo = 0;
    private int oFp = 0;
    private int oFq = 0;
    private int mThumbWidth = -1;
    private int oFr = -1;
    private int bAm = -1;
    private float mRadius = -1.0f;
    private float oFs = 0.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a {
        static int oFu = Color.parseColor("#E3E3E3");
        static int oFv = Color.parseColor("#02BFE7");
        static int oFw = Color.parseColor("#FFFFFF");
        static int oFx = Color.parseColor("#fafafa");
        static int oFy = 2;
        static int DEFAULT_RADIUS = 999;
        static float oFz = 2.0f;
        static int oFA = 0;
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static class C0956b {
        static int oFB = 24;
    }

    public static b bm(float f) {
        b bVar = new b();
        bVar.dcl = f;
        bVar.Os(bVar.ehz());
        bVar.oFt = new Rect(a.oFA, a.oFA, a.oFA, a.oFA);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(Drawable drawable) {
        if (drawable == null) {
            c.e("SwitchButtonConfiguration", "off drawable can not be null");
        } else {
            this.oFi = drawable;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(Drawable drawable) {
        if (drawable == null) {
            c.e("SwitchButtonConfiguration", "onDrawable can not be null");
        } else {
            this.oFh = drawable;
        }
    }

    public Drawable ehx() {
        return this.oFh;
    }

    public Drawable ehy() {
        return this.oFi;
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

    public void L(int i, int i2, int i3, int i4) {
        this.oFn = i;
        this.oFo = i2;
        this.oFp = i3;
        this.oFq = i4;
    }

    public void Os(int i) {
        L(i, i, i, i);
    }

    public int ehz() {
        return (int) (a.oFy * this.dcl);
    }

    public int ehA() {
        return this.oFn;
    }

    public int ehB() {
        return this.oFo;
    }

    public int ehC() {
        return this.oFp;
    }

    public int ehD() {
        return this.oFq;
    }

    public float getDensity() {
        return this.dcl;
    }

    public void setRadius(float f) {
        this.mRadius = f;
    }

    public float getRadius() {
        return this.mRadius < 0.0f ? a.DEFAULT_RADIUS : this.mRadius;
    }

    public void Or(int i) {
        this.bAm = i;
    }

    public int ehE() {
        return this.bAm;
    }

    public void dQ(int i, int i2) {
        if (i > 0) {
            this.mThumbWidth = i;
        }
        if (i2 > 0) {
            this.oFr = i2;
        }
    }

    public Drawable ehF() {
        return this.oFi != null ? this.oFi : Ox(this.oFk);
    }

    public Drawable ehG() {
        return this.oFh != null ? this.oFh : Ox(this.oFj);
    }

    public Drawable ehH() {
        int[] iArr;
        if (this.mThumbDrawable != null) {
            return this.mThumbDrawable;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable Ox = Ox(this.oFl);
        Drawable Ox2 = Ox(this.oFm);
        try {
            Field declaredField = View.class.getDeclaredField("PRESSED_ENABLED_STATE_SET");
            declaredField.setAccessible(true);
            iArr = (int[]) declaredField.get(null);
        } catch (Exception e) {
            Log.e("Configuration", e.getMessage() + "");
            iArr = null;
        }
        if (iArr != null) {
            stateListDrawable.addState(iArr, Ox2);
        }
        stateListDrawable.addState(new int[0], Ox);
        return stateListDrawable;
    }

    public float ehI() {
        if (this.oFs <= 0.0f) {
            this.oFs = a.oFz;
        }
        return this.oFs;
    }

    public void bn(float f) {
        if (f <= 0.0f) {
            this.oFs = a.oFz;
        }
        this.oFs = f;
    }

    public Rect ehJ() {
        return this.oFt;
    }

    public void M(int i, int i2, int i3, int i4) {
        Ot(i);
        Ou(i2);
        Ov(i3);
        Ow(i4);
    }

    public void Ot(int i) {
        if (i > 0) {
            i = -i;
        }
        this.oFt.left = i;
    }

    public void Ou(int i) {
        if (i > 0) {
            i = -i;
        }
        this.oFt.top = i;
    }

    public void Ov(int i) {
        if (i > 0) {
            i = -i;
        }
        this.oFt.right = i;
    }

    public void Ow(int i) {
        if (i > 0) {
            i = -i;
        }
        this.oFt.bottom = i;
    }

    public int ehK() {
        return ehM() / 2;
    }

    public int ehL() {
        return ehN() / 2;
    }

    public int ehM() {
        return this.oFt.left + this.oFt.right;
    }

    public int ehN() {
        return this.oFt.top + this.oFt.bottom;
    }

    public boolean ehO() {
        return ((this.oFt.left + this.oFt.right) + this.oFt.top) + this.oFt.bottom != 0;
    }

    private Drawable Ox(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(getRadius());
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int ehP() {
        int i = this.mThumbWidth;
        if (i < 0) {
            if (this.mThumbDrawable == null || (i = this.mThumbDrawable.getIntrinsicWidth()) <= 0) {
                if (this.dcl <= 0.0f) {
                    c.e("SwitchButtonConfiguration", "density must be a positive number");
                    return i;
                }
                return (int) (C0956b.oFB * this.dcl);
            }
            return i;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int ehQ() {
        int i = this.oFr;
        if (i < 0) {
            if (this.mThumbDrawable == null || (i = this.mThumbDrawable.getIntrinsicHeight()) <= 0) {
                if (this.dcl <= 0.0f) {
                    c.e("SwitchButtonConfiguration", "density must be a positive number");
                    return i;
                }
                return (int) (C0956b.oFB * this.dcl);
            }
            return i;
        }
        return i;
    }
}
