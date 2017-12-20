package com.baidu.tieba.pb.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e extends ViewGroup {
    private int flN;
    private int flO;
    private int flP;
    private int flQ;
    private int flR;
    private float flS;
    private float flT;
    private int flU;
    private boolean flV;
    private ImageView flW;
    private List<ImageView> flX;
    private TextView flY;
    private List<TextView> flZ;
    private boolean fma;
    private int fmb;
    private int fmc;
    private AnimatorSet fmd;
    private AnimatorSet fme;
    private AnimatorSet fmf;
    private Interpolator fmg;
    private Interpolator fmh;
    private int mRadius;
    private int mScreenWidth;

    public e(Context context) {
        super(context);
        this.flQ = 30;
        this.flR = l.f(getContext(), d.e.ds112);
        this.flS = 160.0f;
        this.flT = 20.0f;
        this.flV = false;
        this.fmg = new OvershootInterpolator();
        this.fmh = new DecelerateInterpolator();
        init();
    }

    private void init() {
        this.flO = getResources().getDimensionPixelSize(d.e.ds84);
        this.flP = getResources().getDimensionPixelSize(d.e.ds120);
        this.flN = getResources().getDimensionPixelSize(d.e.ds36);
        this.flX = new ArrayList();
        for (int i = 0; i < 4; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            this.flX.add(imageView);
            addView(imageView);
        }
        this.flZ = new ArrayList();
        for (int i2 = 0; i2 < 4; i2++) {
            TextView textView = new TextView(getContext());
            switch (i2) {
                case 0:
                    textView.setText(d.j.pb_big_praise);
                    break;
                case 1:
                    textView.setText(d.j.pb_normal_praise);
                    break;
                case 2:
                    textView.setText(d.j.pb_normal_trample);
                    break;
                case 3:
                    textView.setText(d.j.pb_big_trample);
                    break;
            }
            textView.setBackgroundResource(d.f.praise_text_bg);
            textView.setTextSize(0, l.f(getContext(), d.e.fontsize22));
            textView.setTextColor(-1);
            textView.setGravity(17);
            textView.setVisibility(4);
            this.flZ.add(textView);
            addView(textView);
        }
        this.mScreenWidth = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        this.fmb = l.f(getContext(), d.e.ds70);
        this.fmc = l.f(getContext(), d.e.ds52);
    }

    private static Rect a(int i, int i2, int i3, float f, int i4) {
        double cos = i + (i3 * Math.cos(Math.toRadians(f)));
        double sin = i2 - (i3 * Math.sin(Math.toRadians(f)));
        return new Rect((int) (cos - (i4 / 2)), (int) (sin - (i4 / 2)), (int) (cos + (i4 / 2)), (int) (sin + (i4 / 2)));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.mRadius = l.f(getContext(), d.e.ds156);
        this.flU = this.mRadius + ((this.flP - this.flO) / 2);
        int i3 = (this.flU * 2) + this.flP + this.flQ;
        int i4 = this.flU + (this.flP / 2) + this.fmc + this.flR;
        if (i3 > this.mScreenWidth) {
            i3 = this.mScreenWidth;
        }
        setMeasuredDimension(i3, i4);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < this.flX.size()) {
                int i7 = this.flO;
                if (this.flW != null && i6 == this.flX.indexOf(this.flW)) {
                    i7 = this.flP;
                }
                int i8 = i7;
                this.flX.get(i6).measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
                this.flZ.get(i6).measure(View.MeasureSpec.makeMeasureSpec(this.fmb, 1073741824), View.MeasureSpec.makeMeasureSpec(this.fmc, 1073741824));
                i5 = i6 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth() / 2;
        int height = getHeight() - this.flR;
        int i5 = this.flV ? this.mRadius : 0;
        int f = l.f(getContext(), d.e.ds90);
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 < this.flX.size()) {
                float qC = qC(i7);
                Rect a = a(width, height, i5, qC, this.flO);
                this.flX.get(i7).layout(a.left, a.top, a.right, a.bottom);
                Rect a2 = a(width, height, this.flU, qC, this.flP);
                float width2 = a2.left + (a2.width() / 2);
                float height2 = ((a2.height() / 2) + a2.top) - f;
                this.flZ.get(i7).layout((int) (width2 - (this.fmb / 2)), (int) (height2 - (this.fmc / 2)), (int) (width2 + (this.fmb / 2)), (int) (height2 + (this.fmc / 2)));
                i6 = i7 + 1;
            } else {
                return;
            }
        }
    }

    private float Z(float f) {
        return (float) (Math.cos(Math.toRadians(f)) * 10.0d);
    }

    private float aa(float f) {
        return (float) (Math.cos(Math.toRadians(f)) * (this.flU - this.mRadius));
    }

    private float ab(float f) {
        return 0.0f;
    }

    private float ac(float f) {
        return (float) (Math.cos(Math.toRadians(f)) * (-this.mRadius));
    }

    private float ad(float f) {
        return -((float) (Math.sin(Math.toRadians(f)) * 10.0d));
    }

    private float ae(float f) {
        return -((float) (Math.sin(Math.toRadians(f)) * (this.flU - this.mRadius)));
    }

    private float af(float f) {
        return 0.0f;
    }

    private float ag(float f) {
        return (float) (Math.sin(Math.toRadians(f)) * this.mRadius);
    }

    private void c(View view, int i, long j) {
        float qC = qC(i);
        float aa = aa(qC);
        float ae = ae(qC);
        float ac = ac(qC);
        float ag = ag(qC);
        float Z = Z(qC);
        float ad = ad(qC);
        float ab = ab(qC);
        float af = af(qC);
        this.fmd = new AnimatorSet();
        float f = this.flV ? 1.0f : 0.0f;
        float f2 = this.flV ? ab : ac;
        if (!this.flV) {
            ac = ab;
        }
        float f3 = this.flV ? af : ag;
        if (!this.flV) {
            ag = af;
        }
        float zoomOutScale = this.flV ? 1.0f : getZoomOutScale();
        float zoomOutScale2 = this.flV ? getZoomOutScale() : 1.0f;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("alpha", f, 1.0f - f), PropertyValuesHolder.ofFloat("translationX", f2, ac), PropertyValuesHolder.ofFloat("translationY", f3, ag), PropertyValuesHolder.ofFloat("scaleX", zoomOutScale, zoomOutScale2), PropertyValuesHolder.ofFloat("scaleY", zoomOutScale, zoomOutScale2));
        ofPropertyValuesHolder.setDuration(j);
        this.fmd.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!e.this.flV) {
                    e.this.setVisibility(8);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < e.this.flX.size()) {
                            ImageView imageView = (ImageView) e.this.flX.get(i3);
                            if (imageView.getTag() != null) {
                                ((com.baidu.tbadk.core.util.l) imageView.getTag()).stop();
                            }
                            imageView.setTag(null);
                            i2 = i3 + 1;
                        } else {
                            return;
                        }
                    }
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (!e.this.flV) {
                    e.this.setVisibility(8);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("translationX", aa, Z), PropertyValuesHolder.ofFloat("translationY", ae, ad));
        ofPropertyValuesHolder2.setDuration(2L);
        ObjectAnimator ofPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("translationX", Z, aa), PropertyValuesHolder.ofFloat("translationY", ad, ae));
        ofPropertyValuesHolder3.setDuration(2L);
        if (!this.flV) {
            this.fmd.play(ofPropertyValuesHolder);
            this.fmd.setInterpolator(this.fmg);
        } else {
            this.fmd.playSequentially(ofPropertyValuesHolder2, ofPropertyValuesHolder3, ofPropertyValuesHolder);
            this.fmd.setInterpolator(this.fmh);
            this.fmd.setDuration(4 + j);
        }
        this.fmd.start();
    }

    public boolean auK() {
        return this.flV;
    }

    private float getZoomInScale() {
        return this.flP / this.flO;
    }

    private float getZoomOutScale() {
        return this.flN / this.flO;
    }

    public void aYH() {
        int i;
        int i2;
        int i3 = 0;
        while (i3 < this.flX.size()) {
            ImageView imageView = this.flX.get(i3);
            imageView.setVisibility(0);
            if (!this.flV) {
                if (i3 == 0) {
                    i = d.b.big_praise;
                } else if (i3 == 1) {
                    com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
                    if (activitySwitch != null && activitySwitch.xE()) {
                        i2 = d.b.normal_praise_xmas;
                    } else {
                        i2 = d.b.normal_praise;
                    }
                    i = i2;
                } else if (i3 == 2) {
                    i = d.b.normal_trample;
                } else {
                    i = i3 == 3 ? d.b.big_trample : 0;
                }
                if (imageView.getTag() != null && (imageView.getTag() instanceof com.baidu.tbadk.core.util.l)) {
                    ((com.baidu.tbadk.core.util.l) imageView.getTag()).stop();
                    imageView.setTag(null);
                }
                com.baidu.tbadk.core.util.l a = com.baidu.tbadk.core.util.l.a(imageView, i, 20, Integer.MAX_VALUE);
                a.b(imageView);
                imageView.setTag(a);
            }
            c(imageView, i3, 200L);
            i3++;
        }
        this.flV = this.flV ? false : true;
        invalidate();
    }

    public void bx(int i, int i2) {
        if (!this.flV) {
            aYJ();
            return;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            aYI();
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < this.flX.size()) {
                ImageView imageView = this.flX.get(i4);
                imageView.getGlobalVisibleRect(rect);
                if (!rect.contains(i, i2) || this.fma) {
                    i3 = i4 + 1;
                } else {
                    f(imageView);
                    return;
                }
            } else {
                aYI();
                return;
            }
        }
    }

    public void f(ImageView imageView) {
        if (imageView != null && this.flW != imageView && !this.fma) {
            aYJ();
            this.flW = imageView;
            float size = (((this.flT - this.flS) / (this.flX.size() - 1)) * this.flX.indexOf(imageView)) + this.flS;
            float zoomInScale = getZoomInScale();
            this.fme = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, zoomInScale);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, zoomInScale);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "translationX", imageView.getTranslationX(), aa(size));
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "translationY", imageView.getTranslationY(), ae(size));
            if (this.flX.indexOf(this.flW) > -1) {
                this.flY = this.flZ.get(this.flX.indexOf(this.flW));
                this.flY.setVisibility(0);
                this.flY.setAlpha(0.0f);
            }
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.flY, "alpha", 0.0f, 1.0f);
            this.fme.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.flY, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.flY, "scaleY", 0.0f, 1.0f));
            this.fme.setInterpolator(this.fmh);
            this.fme.setDuration(100L);
            this.fme.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.fma = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.fma = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fma = true;
            this.fme.start();
        }
    }

    public void aYI() {
        if (this.flW != null && !this.fma) {
            ImageView imageView = this.flW;
            float zoomInScale = getZoomInScale();
            this.fmf = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", zoomInScale, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", zoomInScale, 1.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "translationX", imageView.getTranslationX(), 0.0f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "translationY", imageView.getTranslationY(), 0.0f);
            if (this.flY != null) {
                ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.flY, "alpha", 1.0f, 0.0f);
                this.fmf.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.flY, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.flY, "scaleY", 0.0f, 1.0f));
            } else {
                this.fmf.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
            }
            this.fmf.setInterpolator(this.fmh);
            this.fmf.setDuration(100L);
            this.fmf.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.fma = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.fma = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fma = true;
            this.fmf.start();
            if (this.flY != null) {
                this.flY.setVisibility(4);
            }
            this.flW = null;
            this.flY = null;
        }
    }

    public int by(int i, int i2) {
        if (!this.flV) {
            aYJ();
            return -1;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            aYI();
            return -1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.flX.size()) {
                return -1;
            }
            this.flX.get(i4).getGlobalVisibleRect(rect);
            if (!rect.contains(i, i2)) {
                i3 = i4 + 1;
            } else {
                aYI();
                return i4 + 1;
            }
        }
    }

    public void aYJ() {
        if (this.fmd != null && this.fmd.isStarted()) {
            this.fmd.cancel();
            this.fmd = null;
        }
        if (this.fme != null && this.fme.isStarted()) {
            this.fme.cancel();
            this.fme = null;
        }
        if (this.fmf != null && this.fmf.isStarted()) {
            this.fmf.cancel();
            this.fmf = null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.flX.size()) {
                ImageView imageView = this.flX.get(i2);
                float qC = qC(i2);
                imageView.setTranslationX(ab(qC));
                imageView.setTranslationY(af(qC));
                imageView.setScaleX(1.0f);
                imageView.setScaleY(1.0f);
                imageView.invalidate();
                TextView textView = this.flZ.get(i2);
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

    private float qC(int i) {
        return (((this.flT - this.flS) / (this.flX.size() - 1)) * i) + this.flS;
    }
}
