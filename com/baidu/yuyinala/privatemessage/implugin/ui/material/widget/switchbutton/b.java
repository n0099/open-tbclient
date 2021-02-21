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
    private Rect pgR;
    private Drawable pgG = null;
    private Drawable pgH = null;
    private Drawable mThumbDrawable = null;
    private int pgI = a.pgT;
    private int pgJ = a.pgS;
    private int oCj = a.pgU;
    private int pgK = a.pgV;
    private int pgL = 0;
    private int pgM = 0;
    private int pgN = 0;
    private int pgO = 0;
    private int mThumbWidth = -1;
    private int pgP = -1;
    private int bJg = -1;
    private float mRadius = -1.0f;
    private float pgQ = 0.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class a {
        static int pgS = Color.parseColor("#E3E3E3");
        static int pgT = Color.parseColor("#02BFE7");
        static int pgU = Color.parseColor("#FFFFFF");
        static int pgV = Color.parseColor("#fafafa");
        static int pgW = 2;
        static int DEFAULT_RADIUS = 999;
        static float pgX = 2.0f;
        static int pgY = 0;
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    static class C0976b {
        static int pgZ = 24;
    }

    public static b bB(float f) {
        b bVar = new b();
        bVar.dlH = f;
        bVar.NT(bVar.elZ());
        bVar.pgR = new Rect(a.pgY, a.pgY, a.pgY, a.pgY);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(Drawable drawable) {
        if (drawable == null) {
            c.e("SwitchButtonConfiguration", "off drawable can not be null");
        } else {
            this.pgH = drawable;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(Drawable drawable) {
        if (drawable == null) {
            c.e("SwitchButtonConfiguration", "onDrawable can not be null");
        } else {
            this.pgG = drawable;
        }
    }

    public Drawable elX() {
        return this.pgG;
    }

    public Drawable elY() {
        return this.pgH;
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
        this.pgL = i;
        this.pgM = i2;
        this.pgN = i3;
        this.pgO = i4;
    }

    public void NT(int i) {
        N(i, i, i, i);
    }

    public int elZ() {
        return (int) (a.pgW * this.dlH);
    }

    public int ema() {
        return this.pgL;
    }

    public int emb() {
        return this.pgM;
    }

    public int emc() {
        return this.pgN;
    }

    public int emd() {
        return this.pgO;
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

    public void NS(int i) {
        this.bJg = i;
    }

    public int eme() {
        return this.bJg;
    }

    public void dR(int i, int i2) {
        if (i > 0) {
            this.mThumbWidth = i;
        }
        if (i2 > 0) {
            this.pgP = i2;
        }
    }

    public Drawable emf() {
        return this.pgH != null ? this.pgH : NY(this.pgJ);
    }

    public Drawable emg() {
        return this.pgG != null ? this.pgG : NY(this.pgI);
    }

    public Drawable emh() {
        int[] iArr;
        if (this.mThumbDrawable != null) {
            return this.mThumbDrawable;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable NY = NY(this.oCj);
        Drawable NY2 = NY(this.pgK);
        try {
            Field declaredField = View.class.getDeclaredField("PRESSED_ENABLED_STATE_SET");
            declaredField.setAccessible(true);
            iArr = (int[]) declaredField.get(null);
        } catch (Exception e) {
            Log.e("Configuration", e.getMessage() + "");
            iArr = null;
        }
        if (iArr != null) {
            stateListDrawable.addState(iArr, NY2);
        }
        stateListDrawable.addState(new int[0], NY);
        return stateListDrawable;
    }

    public float emi() {
        if (this.pgQ <= 0.0f) {
            this.pgQ = a.pgX;
        }
        return this.pgQ;
    }

    public void bC(float f) {
        if (f <= 0.0f) {
            this.pgQ = a.pgX;
        }
        this.pgQ = f;
    }

    public Rect emj() {
        return this.pgR;
    }

    public void O(int i, int i2, int i3, int i4) {
        NU(i);
        NV(i2);
        NW(i3);
        NX(i4);
    }

    public void NU(int i) {
        if (i > 0) {
            i = -i;
        }
        this.pgR.left = i;
    }

    public void NV(int i) {
        if (i > 0) {
            i = -i;
        }
        this.pgR.top = i;
    }

    public void NW(int i) {
        if (i > 0) {
            i = -i;
        }
        this.pgR.right = i;
    }

    public void NX(int i) {
        if (i > 0) {
            i = -i;
        }
        this.pgR.bottom = i;
    }

    public int emk() {
        return emm() / 2;
    }

    public int eml() {
        return emn() / 2;
    }

    public int emm() {
        return this.pgR.left + this.pgR.right;
    }

    public int emn() {
        return this.pgR.top + this.pgR.bottom;
    }

    public boolean emo() {
        return ((this.pgR.left + this.pgR.right) + this.pgR.top) + this.pgR.bottom != 0;
    }

    private Drawable NY(int i) {
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
                return (int) (C0976b.pgZ * this.dlH);
            }
            return i;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getThumbHeight() {
        int i = this.pgP;
        if (i < 0) {
            if (this.mThumbDrawable == null || (i = this.mThumbDrawable.getIntrinsicHeight()) <= 0) {
                if (this.dlH <= 0.0f) {
                    c.e("SwitchButtonConfiguration", "density must be a positive number");
                    return i;
                }
                return (int) (C0976b.pgZ * this.dlH);
            }
            return i;
        }
        return i;
    }
}
