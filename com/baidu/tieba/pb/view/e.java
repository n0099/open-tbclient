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
    private int flS;
    private int flT;
    private int flU;
    private int flV;
    private int flW;
    private float flX;
    private float flY;
    private int flZ;
    private boolean fma;
    private ImageView fmb;
    private List<ImageView> fmc;
    private TextView fmd;
    private List<TextView> fme;
    private boolean fmf;
    private int fmg;
    private int fmh;
    private AnimatorSet fmi;
    private AnimatorSet fmj;
    private AnimatorSet fmk;
    private Interpolator fml;
    private Interpolator fmm;
    private int mRadius;
    private int mScreenWidth;

    public e(Context context) {
        super(context);
        this.flV = 30;
        this.flW = l.f(getContext(), d.e.ds112);
        this.flX = 160.0f;
        this.flY = 20.0f;
        this.fma = false;
        this.fml = new OvershootInterpolator();
        this.fmm = new DecelerateInterpolator();
        init();
    }

    private void init() {
        this.flT = getResources().getDimensionPixelSize(d.e.ds84);
        this.flU = getResources().getDimensionPixelSize(d.e.ds120);
        this.flS = getResources().getDimensionPixelSize(d.e.ds36);
        this.fmc = new ArrayList();
        for (int i = 0; i < 4; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            this.fmc.add(imageView);
            addView(imageView);
        }
        this.fme = new ArrayList();
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
            this.fme.add(textView);
            addView(textView);
        }
        this.mScreenWidth = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        this.fmg = l.f(getContext(), d.e.ds70);
        this.fmh = l.f(getContext(), d.e.ds52);
    }

    private static Rect a(int i, int i2, int i3, float f, int i4) {
        double cos = i + (i3 * Math.cos(Math.toRadians(f)));
        double sin = i2 - (i3 * Math.sin(Math.toRadians(f)));
        return new Rect((int) (cos - (i4 / 2)), (int) (sin - (i4 / 2)), (int) (cos + (i4 / 2)), (int) (sin + (i4 / 2)));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.mRadius = l.f(getContext(), d.e.ds156);
        this.flZ = this.mRadius + ((this.flU - this.flT) / 2);
        int i3 = (this.flZ * 2) + this.flU + this.flV;
        int i4 = this.flZ + (this.flU / 2) + this.fmh + this.flW;
        if (i3 > this.mScreenWidth) {
            i3 = this.mScreenWidth;
        }
        setMeasuredDimension(i3, i4);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < this.fmc.size()) {
                int i7 = this.flT;
                if (this.fmb != null && i6 == this.fmc.indexOf(this.fmb)) {
                    i7 = this.flU;
                }
                int i8 = i7;
                this.fmc.get(i6).measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
                this.fme.get(i6).measure(View.MeasureSpec.makeMeasureSpec(this.fmg, 1073741824), View.MeasureSpec.makeMeasureSpec(this.fmh, 1073741824));
                i5 = i6 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth() / 2;
        int height = getHeight() - this.flW;
        int i5 = this.fma ? this.mRadius : 0;
        int f = l.f(getContext(), d.e.ds90);
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 < this.fmc.size()) {
                float qC = qC(i7);
                Rect a = a(width, height, i5, qC, this.flT);
                this.fmc.get(i7).layout(a.left, a.top, a.right, a.bottom);
                Rect a2 = a(width, height, this.flZ, qC, this.flU);
                float width2 = a2.left + (a2.width() / 2);
                float height2 = ((a2.height() / 2) + a2.top) - f;
                this.fme.get(i7).layout((int) (width2 - (this.fmg / 2)), (int) (height2 - (this.fmh / 2)), (int) (width2 + (this.fmg / 2)), (int) (height2 + (this.fmh / 2)));
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
        return (float) (Math.cos(Math.toRadians(f)) * (this.flZ - this.mRadius));
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
        return -((float) (Math.sin(Math.toRadians(f)) * (this.flZ - this.mRadius)));
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
        this.fmi = new AnimatorSet();
        float f = this.fma ? 1.0f : 0.0f;
        float f2 = this.fma ? ab : ac;
        if (!this.fma) {
            ac = ab;
        }
        float f3 = this.fma ? af : ag;
        if (!this.fma) {
            ag = af;
        }
        float zoomOutScale = this.fma ? 1.0f : getZoomOutScale();
        float zoomOutScale2 = this.fma ? getZoomOutScale() : 1.0f;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("alpha", f, 1.0f - f), PropertyValuesHolder.ofFloat("translationX", f2, ac), PropertyValuesHolder.ofFloat("translationY", f3, ag), PropertyValuesHolder.ofFloat("scaleX", zoomOutScale, zoomOutScale2), PropertyValuesHolder.ofFloat("scaleY", zoomOutScale, zoomOutScale2));
        ofPropertyValuesHolder.setDuration(j);
        this.fmi.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!e.this.fma) {
                    e.this.setVisibility(8);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < e.this.fmc.size()) {
                            ImageView imageView = (ImageView) e.this.fmc.get(i3);
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
                if (!e.this.fma) {
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
        if (!this.fma) {
            this.fmi.play(ofPropertyValuesHolder);
            this.fmi.setInterpolator(this.fml);
        } else {
            this.fmi.playSequentially(ofPropertyValuesHolder2, ofPropertyValuesHolder3, ofPropertyValuesHolder);
            this.fmi.setInterpolator(this.fmm);
            this.fmi.setDuration(4 + j);
        }
        this.fmi.start();
    }

    public boolean auL() {
        return this.fma;
    }

    private float getZoomInScale() {
        return this.flU / this.flT;
    }

    private float getZoomOutScale() {
        return this.flS / this.flT;
    }

    public void aYI() {
        int i;
        int i2;
        int i3 = 0;
        while (i3 < this.fmc.size()) {
            ImageView imageView = this.fmc.get(i3);
            imageView.setVisibility(0);
            if (!this.fma) {
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
        this.fma = this.fma ? false : true;
        invalidate();
    }

    public void bx(int i, int i2) {
        if (!this.fma) {
            aYK();
            return;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            aYJ();
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < this.fmc.size()) {
                ImageView imageView = this.fmc.get(i4);
                imageView.getGlobalVisibleRect(rect);
                if (!rect.contains(i, i2) || this.fmf) {
                    i3 = i4 + 1;
                } else {
                    f(imageView);
                    return;
                }
            } else {
                aYJ();
                return;
            }
        }
    }

    public void f(ImageView imageView) {
        if (imageView != null && this.fmb != imageView && !this.fmf) {
            aYK();
            this.fmb = imageView;
            float size = (((this.flY - this.flX) / (this.fmc.size() - 1)) * this.fmc.indexOf(imageView)) + this.flX;
            float zoomInScale = getZoomInScale();
            this.fmj = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, zoomInScale);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, zoomInScale);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "translationX", imageView.getTranslationX(), aa(size));
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "translationY", imageView.getTranslationY(), ae(size));
            if (this.fmc.indexOf(this.fmb) > -1) {
                this.fmd = this.fme.get(this.fmc.indexOf(this.fmb));
                this.fmd.setVisibility(0);
                this.fmd.setAlpha(0.0f);
            }
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fmd, "alpha", 0.0f, 1.0f);
            this.fmj.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.fmd, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.fmd, "scaleY", 0.0f, 1.0f));
            this.fmj.setInterpolator(this.fmm);
            this.fmj.setDuration(100L);
            this.fmj.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.fmf = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.fmf = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fmf = true;
            this.fmj.start();
        }
    }

    public void aYJ() {
        if (this.fmb != null && !this.fmf) {
            ImageView imageView = this.fmb;
            float zoomInScale = getZoomInScale();
            this.fmk = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", zoomInScale, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", zoomInScale, 1.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "translationX", imageView.getTranslationX(), 0.0f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "translationY", imageView.getTranslationY(), 0.0f);
            if (this.fmd != null) {
                ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fmd, "alpha", 1.0f, 0.0f);
                this.fmk.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.fmd, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.fmd, "scaleY", 0.0f, 1.0f));
            } else {
                this.fmk.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
            }
            this.fmk.setInterpolator(this.fmm);
            this.fmk.setDuration(100L);
            this.fmk.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.fmf = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.fmf = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fmf = true;
            this.fmk.start();
            if (this.fmd != null) {
                this.fmd.setVisibility(4);
            }
            this.fmb = null;
            this.fmd = null;
        }
    }

    public int by(int i, int i2) {
        if (!this.fma) {
            aYK();
            return -1;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            aYJ();
            return -1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.fmc.size()) {
                return -1;
            }
            this.fmc.get(i4).getGlobalVisibleRect(rect);
            if (!rect.contains(i, i2)) {
                i3 = i4 + 1;
            } else {
                aYJ();
                return i4 + 1;
            }
        }
    }

    public void aYK() {
        if (this.fmi != null && this.fmi.isStarted()) {
            this.fmi.cancel();
            this.fmi = null;
        }
        if (this.fmj != null && this.fmj.isStarted()) {
            this.fmj.cancel();
            this.fmj = null;
        }
        if (this.fmk != null && this.fmk.isStarted()) {
            this.fmk.cancel();
            this.fmk = null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fmc.size()) {
                ImageView imageView = this.fmc.get(i2);
                float qC = qC(i2);
                imageView.setTranslationX(ab(qC));
                imageView.setTranslationY(af(qC));
                imageView.setScaleX(1.0f);
                imageView.setScaleY(1.0f);
                imageView.invalidate();
                TextView textView = this.fme.get(i2);
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
        return (((this.flY - this.flX) / (this.fmc.size() - 1)) * i) + this.flX;
    }
}
