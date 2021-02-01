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
    private float dlH;
    private Rect pgr;
    private Drawable pgg = null;
    private Drawable pgh = null;
    private Drawable mThumbDrawable = null;
    private int pgi = a.pgt;
    private int pgj = a.pgs;
    private int oBJ = a.pgu;
    private int pgk = a.pgv;
    private int pgl = 0;
    private int pgm = 0;
    private int pgn = 0;
    private int pgo = 0;
    private int mThumbWidth = -1;
    private int pgp = -1;
    private int bJg = -1;
    private float mRadius = -1.0f;
    private float pgq = 0.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class a {
        static int pgs = Color.parseColor("#E3E3E3");
        static int pgt = Color.parseColor("#02BFE7");
        static int pgu = Color.parseColor("#FFFFFF");
        static int pgv = Color.parseColor("#fafafa");
        static int pgw = 2;
        static int DEFAULT_RADIUS = 999;
        static float pgx = 2.0f;
        static int pgy = 0;
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    static class C0974b {
        static int pgz = 24;
    }

    public static b bB(float f) {
        b bVar = new b();
        bVar.dlH = f;
        bVar.NS(bVar.elR());
        bVar.pgr = new Rect(a.pgy, a.pgy, a.pgy, a.pgy);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(Drawable drawable) {
        if (drawable == null) {
            c.e("SwitchButtonConfiguration", "off drawable can not be null");
        } else {
            this.pgh = drawable;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(Drawable drawable) {
        if (drawable == null) {
            c.e("SwitchButtonConfiguration", "onDrawable can not be null");
        } else {
            this.pgg = drawable;
        }
    }

    public Drawable elP() {
        return this.pgg;
    }

    public Drawable elQ() {
        return this.pgh;
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
        this.pgl = i;
        this.pgm = i2;
        this.pgn = i3;
        this.pgo = i4;
    }

    public void NS(int i) {
        N(i, i, i, i);
    }

    public int elR() {
        return (int) (a.pgw * this.dlH);
    }

    public int elS() {
        return this.pgl;
    }

    public int elT() {
        return this.pgm;
    }

    public int elU() {
        return this.pgn;
    }

    public int elV() {
        return this.pgo;
    }

    public float getDensity() {
        return this.dlH;
    }

    public void setRadius(float f) {
        this.mRadius = f;
    }

    public float getRadius() {
        return this.mRadius < 0.0f ? a.DEFAULT_RADIUS : this.mRadius;
    }

    public void NR(int i) {
        this.bJg = i;
    }

    public int elW() {
        return this.bJg;
    }

    public void dQ(int i, int i2) {
        if (i > 0) {
            this.mThumbWidth = i;
        }
        if (i2 > 0) {
            this.pgp = i2;
        }
    }

    public Drawable elX() {
        return this.pgh != null ? this.pgh : NX(this.pgj);
    }

    public Drawable elY() {
        return this.pgg != null ? this.pgg : NX(this.pgi);
    }

    public Drawable elZ() {
        int[] iArr;
        if (this.mThumbDrawable != null) {
            return this.mThumbDrawable;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable NX = NX(this.oBJ);
        Drawable NX2 = NX(this.pgk);
        try {
            Field declaredField = View.class.getDeclaredField("PRESSED_ENABLED_STATE_SET");
            declaredField.setAccessible(true);
            iArr = (int[]) declaredField.get(null);
        } catch (Exception e) {
            Log.e("Configuration", e.getMessage() + "");
            iArr = null;
        }
        if (iArr != null) {
            stateListDrawable.addState(iArr, NX2);
        }
        stateListDrawable.addState(new int[0], NX);
        return stateListDrawable;
    }

    public float ema() {
        if (this.pgq <= 0.0f) {
            this.pgq = a.pgx;
        }
        return this.pgq;
    }

    public void bC(float f) {
        if (f <= 0.0f) {
            this.pgq = a.pgx;
        }
        this.pgq = f;
    }

    public Rect emb() {
        return this.pgr;
    }

    public void O(int i, int i2, int i3, int i4) {
        NT(i);
        NU(i2);
        NV(i3);
        NW(i4);
    }

    public void NT(int i) {
        if (i > 0) {
            i = -i;
        }
        this.pgr.left = i;
    }

    public void NU(int i) {
        if (i > 0) {
            i = -i;
        }
        this.pgr.top = i;
    }

    public void NV(int i) {
        if (i > 0) {
            i = -i;
        }
        this.pgr.right = i;
    }

    public void NW(int i) {
        if (i > 0) {
            i = -i;
        }
        this.pgr.bottom = i;
    }

    public int emc() {
        return eme() / 2;
    }

    public int emd() {
        return emf() / 2;
    }

    public int eme() {
        return this.pgr.left + this.pgr.right;
    }

    public int emf() {
        return this.pgr.top + this.pgr.bottom;
    }

    public boolean emg() {
        return ((this.pgr.left + this.pgr.right) + this.pgr.top) + this.pgr.bottom != 0;
    }

    private Drawable NX(int i) {
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
                if (this.dlH <= 0.0f) {
                    c.e("SwitchButtonConfiguration", "density must be a positive number");
                    return i;
                }
                return (int) (C0974b.pgz * this.dlH);
            }
            return i;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getThumbHeight() {
        int i = this.pgp;
        if (i < 0) {
            if (this.mThumbDrawable == null || (i = this.mThumbDrawable.getIntrinsicHeight()) <= 0) {
                if (this.dlH <= 0.0f) {
                    c.e("SwitchButtonConfiguration", "density must be a positive number");
                    return i;
                }
                return (int) (C0974b.pgz * this.dlH);
            }
            return i;
        }
        return i;
    }
}
