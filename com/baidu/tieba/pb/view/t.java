package com.baidu.tieba.pb.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t extends ViewGroup {
    private int eCA;
    private int eCB;
    private int eCC;
    private int eCD;
    private float eCE;
    private float eCF;
    private int eCG;
    private boolean eCH;
    private ImageView eCI;
    private List<ImageView> eCJ;
    private TextView eCK;
    private List<TextView> eCL;
    private boolean eCM;
    private int eCN;
    private int eCO;
    private boolean eCP;
    private AnimatorSet eCQ;
    private AnimatorSet eCR;
    private AnimatorSet eCS;
    private Interpolator eCT;
    private Interpolator eCU;
    private Interpolator eCV;
    private int mRadius;
    private int mScreenWidth;

    public t(Context context) {
        super(context);
        this.eCC = 30;
        this.eCD = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds112);
        this.eCE = 200.0f;
        this.eCF = 340.0f;
        this.eCH = false;
        this.eCT = new OvershootInterpolator();
        this.eCU = new DecelerateInterpolator();
        this.eCV = new AccelerateDecelerateInterpolator();
        init();
    }

    private void init() {
        this.eCA = getResources().getDimensionPixelSize(w.f.ds132);
        this.eCB = getResources().getDimensionPixelSize(w.f.ds162);
        this.eCJ = new ArrayList();
        for (int i = 0; i < 4; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            this.eCJ.add(imageView);
            addView(imageView);
        }
        this.eCL = new ArrayList();
        for (int i2 = 0; i2 < 4; i2++) {
            TextView textView = new TextView(getContext());
            switch (i2) {
                case 0:
                    textView.setText(w.l.pb_big_praise);
                    break;
                case 1:
                    textView.setText(w.l.pb_normal_praise);
                    break;
                case 2:
                    textView.setText(w.l.pb_normal_trample);
                    break;
                case 3:
                    textView.setText(w.l.pb_big_trample);
                    break;
            }
            textView.setBackgroundResource(w.g.praise_text_bg);
            textView.setTextSize(0, com.baidu.adp.lib.util.k.g(getContext(), w.f.fontsize22));
            textView.setTextColor(-1);
            textView.setGravity(17);
            textView.setVisibility(4);
            this.eCL.add(textView);
            addView(textView);
        }
        this.mScreenWidth = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        this.eCN = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds70);
        this.eCO = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds52);
    }

    private static int a(float f, int i, int i2, int i3, int i4) {
        return i < 2 ? i4 : Math.max((int) (((i2 + i3) / 2) / Math.sin(Math.toRadians((f / (i - 1)) / 2.0f))), i4);
    }

    private static Rect a(int i, int i2, int i3, float f, int i4) {
        double cos = i + (i3 * Math.cos(Math.toRadians(f)));
        double sin = i2 + (i3 * Math.sin(Math.toRadians(f)));
        return new Rect((int) (cos - (i4 / 2)), (int) (sin - (i4 / 2)), (int) (cos + (i4 / 2)), (int) (sin + (i4 / 2)));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.mRadius = a(Math.abs(this.eCF - this.eCE), this.eCJ.size(), this.eCA, this.eCC, 100);
        this.eCG = a(Math.abs(this.eCF - this.eCE), this.eCJ.size(), this.eCB, this.eCC, 100);
        int i3 = (this.eCG * 2) + this.eCB + this.eCC + this.eCN;
        int i4 = this.eCG + this.eCB + this.eCD;
        if (i3 > this.mScreenWidth) {
            i3 = this.mScreenWidth;
        }
        setMeasuredDimension(i3, i4);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < this.eCJ.size()) {
                int i7 = this.eCA;
                if (this.eCI != null && i6 == this.eCJ.indexOf(this.eCI)) {
                    i7 = this.eCB;
                }
                int i8 = i7;
                this.eCJ.get(i6).measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
                this.eCL.get(i6).measure(View.MeasureSpec.makeMeasureSpec(this.eCN, 1073741824), View.MeasureSpec.makeMeasureSpec(this.eCO, 1073741824));
                i5 = i6 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (!this.eCP) {
            int width = getWidth() / 2;
            int height = getHeight() - this.eCD;
            int i6 = this.eCH ? this.mRadius : 0;
            float size = (this.eCF - this.eCE) / (this.eCJ.size() - 1);
            int i7 = 0;
            float f = this.eCE;
            while (true) {
                int i8 = i7;
                if (i8 < this.eCJ.size()) {
                    Rect a = a(width, height, i6, f, this.eCA);
                    this.eCJ.get(i8).layout(a.left, a.top, a.right, a.bottom);
                    int g = this.eCG + com.baidu.adp.lib.util.k.g(getContext(), w.f.ds106);
                    if (i8 == 0) {
                        i5 = 10;
                    } else if (i8 == 1) {
                        i5 = 5;
                    } else if (i8 == 2) {
                        i5 = -5;
                    } else if (i8 != 3) {
                        i5 = 0;
                    } else {
                        i5 = -10;
                    }
                    double cos = width + (g * Math.cos(Math.toRadians(i5 + f)));
                    double sin = height + (g * Math.sin(Math.toRadians(i5 + f)));
                    TextView textView = this.eCL.get(i8);
                    textView.layout((int) (cos - (this.eCN / 2)), (int) (sin - (this.eCO / 2)), (int) (cos + (this.eCN / 2)), (int) (sin + (this.eCO / 2)));
                    textView.setRotation((i8 == 0 || i8 == 3) ? i5 * (-3) : -i5);
                    f += size;
                    i7 = i8 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void d(View view, int i, long j) {
        int width = getWidth() / 2;
        int height = getHeight() - this.eCD;
        float size = (this.eCF - this.eCE) / (this.eCJ.size() - 1);
        Rect a = a(width, height, this.mRadius, this.eCE + (i * size), this.eCA);
        Rect a2 = a(width, height, 0, this.eCE + (i * size), this.eCA);
        this.eCQ = new AnimatorSet();
        float f = this.eCH ? 1.0f : 0.0f;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("alpha", f, 1.0f - f), PropertyValuesHolder.ofFloat("X", this.eCH ? a.left : a2.left, this.eCH ? a2.left : a.left), PropertyValuesHolder.ofFloat("Y", this.eCH ? a.top : a2.top, this.eCH ? a2.top : a.top));
        ofPropertyValuesHolder.setDuration(j);
        this.eCQ.addListener(new u(this));
        Rect a3 = a(width, height, this.mRadius + com.baidu.adp.lib.util.k.g(getContext(), w.f.ds16), (size * i) + this.eCE, this.eCA);
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("X", a.left, a3.left), PropertyValuesHolder.ofFloat("Y", a.top, a3.top));
        ofPropertyValuesHolder2.setDuration(2L);
        ObjectAnimator ofPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("X", a3.left, a.left), PropertyValuesHolder.ofFloat("Y", a3.top, a.top));
        ofPropertyValuesHolder3.setDuration(2L);
        if (!this.eCH) {
            this.eCQ.play(ofPropertyValuesHolder);
            this.eCQ.setInterpolator(this.eCT);
        } else {
            this.eCQ.playSequentially(ofPropertyValuesHolder2, ofPropertyValuesHolder3, ofPropertyValuesHolder);
            this.eCQ.setInterpolator(this.eCU);
            this.eCQ.setDuration(4 + j);
        }
        this.eCQ.start();
    }

    public boolean ajM() {
        return this.eCH;
    }

    public void aPh() {
        int i;
        int i2 = 0;
        while (i2 < this.eCJ.size()) {
            ImageView imageView = this.eCJ.get(i2);
            imageView.setVisibility(0);
            if (!this.eCH) {
                if (i2 == 0) {
                    i = w.b.big_praise;
                } else if (i2 == 1) {
                    i = w.b.normal_praise;
                } else if (i2 == 2) {
                    i = w.b.normal_trample;
                } else {
                    i = i2 == 3 ? w.b.big_trample : 0;
                }
                if (imageView.getTag() != null && (imageView.getTag() instanceof com.baidu.tieba.pb.pb.main.view.c)) {
                    ((com.baidu.tieba.pb.pb.main.view.c) imageView.getTag()).stop();
                    imageView.setTag(null);
                }
                com.baidu.tieba.pb.pb.main.view.c b = com.baidu.tieba.pb.pb.main.view.c.b(imageView, i, 20, Integer.MAX_VALUE);
                b.start();
                imageView.setTag(b);
            }
            d(imageView, i2, 200L);
            i2++;
        }
        this.eCH = this.eCH ? false : true;
        invalidate();
    }

    public void aV(int i, int i2) {
        if (!this.eCH) {
            aPj();
            return;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            aPi();
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < this.eCJ.size()) {
                ImageView imageView = this.eCJ.get(i4);
                imageView.getGlobalVisibleRect(rect);
                if (!rect.contains(i, i2) || this.eCM) {
                    i3 = i4 + 1;
                } else {
                    i(imageView);
                    return;
                }
            } else {
                aPi();
                return;
            }
        }
    }

    public void i(ImageView imageView) {
        if (imageView != null && this.eCI != imageView && !this.eCM) {
            aPj();
            this.eCI = imageView;
            float size = (this.eCF - this.eCE) / (this.eCJ.size() - 1);
            Rect a = a(getWidth() / 2, getHeight() - this.eCD, this.mRadius, this.eCE + (this.eCJ.indexOf(imageView) * size), this.eCA);
            Rect a2 = a(getWidth() / 2, getHeight() - this.eCD, this.eCG, (size * this.eCJ.indexOf(imageView)) + this.eCE, this.eCA);
            this.eCR = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, 1.3f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, 1.3f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "X", a.left, a2.left);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "Y", a.top, a2.top);
            if (this.eCJ.indexOf(this.eCI) > -1) {
                this.eCK = this.eCL.get(this.eCJ.indexOf(this.eCI));
                this.eCK.setVisibility(0);
                this.eCK.setAlpha(0.0f);
            }
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.eCK, "alpha", 0.0f, 1.0f);
            this.eCR.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.eCK, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.eCK, "scaleY", 0.0f, 1.0f));
            this.eCR.setInterpolator(this.eCU);
            this.eCR.setDuration(100L);
            this.eCR.addListener(new v(this));
            this.eCM = true;
            this.eCR.start();
        }
    }

    public void aPi() {
        if (this.eCI != null && !this.eCM) {
            float size = (this.eCF - this.eCE) / (this.eCJ.size() - 1);
            Rect a = a(getWidth() / 2, getHeight() - this.eCD, this.mRadius, this.eCE + (this.eCJ.indexOf(this.eCI) * size), this.eCA);
            Rect a2 = a(getWidth() / 2, getHeight() - this.eCD, this.eCG, (size * this.eCJ.indexOf(this.eCI)) + this.eCE, this.eCB);
            this.eCS = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.eCI, "scaleX", 1.3f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.eCI, "scaleY", 1.3f, 1.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.eCI, "X", a2.left, a.left);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.eCI, "Y", a2.top, a.top);
            if (this.eCK != null) {
                ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.eCK, "alpha", 1.0f, 0.0f);
                this.eCS.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.eCK, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.eCK, "scaleY", 0.0f, 1.0f));
            } else {
                this.eCS.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
            }
            this.eCS.setInterpolator(this.eCU);
            this.eCS.setDuration(100L);
            this.eCS.addListener(new w(this));
            this.eCM = true;
            this.eCS.start();
            if (this.eCK != null) {
                this.eCK.setVisibility(4);
            }
            this.eCI = null;
            this.eCK = null;
        }
    }

    public int aW(int i, int i2) {
        if (!this.eCH) {
            aPj();
            return -1;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            aPi();
            return -1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.eCJ.size()) {
                return -1;
            }
            this.eCJ.get(i4).getGlobalVisibleRect(rect);
            if (!rect.contains(i, i2)) {
                i3 = i4 + 1;
            } else {
                aPi();
                return i4 + 1;
            }
        }
    }

    public void aPj() {
        if (this.eCQ != null && this.eCQ.isStarted()) {
            this.eCQ.cancel();
            this.eCQ = null;
        }
        if (this.eCR != null && this.eCR.isStarted()) {
            this.eCR.cancel();
            this.eCR = null;
        }
        if (this.eCS != null && this.eCS.isStarted()) {
            this.eCS.cancel();
            this.eCS = null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.eCJ.size()) {
                ImageView imageView = this.eCJ.get(i2);
                Rect a = a(getWidth() / 2, getHeight() - this.eCD, this.mRadius, (((this.eCF - this.eCE) / (this.eCJ.size() - 1)) * i2) + this.eCE, this.eCA);
                imageView.setX(a.left);
                imageView.setY(a.top);
                imageView.setScaleX(1.0f);
                imageView.setScaleY(1.0f);
                imageView.invalidate();
                TextView textView = this.eCL.get(i2);
                textView.setAlpha(0.0f);
                textView.setScaleX(1.0f);
                textView.setScaleY(1.0f);
                textView.invalidate();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
