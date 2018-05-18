package com.baidu.tieba.pb.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.ActivityChooserView;
import android.util.AttributeSet;
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
/* loaded from: classes2.dex */
public class PbMainFloorPraiseFloatingView extends ViewGroup {
    private AnimatorSet fzA;
    private AnimatorSet fzB;
    private AnimatorSet fzC;
    private Interpolator fzD;
    private Interpolator fzE;
    private int fzk;
    private int fzl;
    private int fzm;
    private int fzn;
    private int fzo;
    private float fzp;
    private float fzq;
    private int fzr;
    private boolean fzs;
    private ImageView fzt;
    private List<ImageView> fzu;
    private TextView fzv;
    private List<TextView> fzw;
    private boolean fzx;
    private int fzy;
    private int fzz;
    private int mRadius;
    private int mScreenWidth;

    public PbMainFloorPraiseFloatingView(Context context) {
        super(context);
        this.fzn = 30;
        this.fzo = l.e(getContext(), d.e.ds112);
        this.fzp = 160.0f;
        this.fzq = 20.0f;
        this.fzs = false;
        this.fzD = new OvershootInterpolator();
        this.fzE = new DecelerateInterpolator();
        init();
    }

    public PbMainFloorPraiseFloatingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fzn = 30;
        this.fzo = l.e(getContext(), d.e.ds112);
        this.fzp = 160.0f;
        this.fzq = 20.0f;
        this.fzs = false;
        this.fzD = new OvershootInterpolator();
        this.fzE = new DecelerateInterpolator();
        init();
    }

    private void init() {
        this.fzl = getResources().getDimensionPixelSize(d.e.ds84);
        this.fzm = getResources().getDimensionPixelSize(d.e.ds120);
        this.fzk = getResources().getDimensionPixelSize(d.e.ds36);
        this.fzu = new ArrayList();
        for (int i = 0; i < 4; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            this.fzu.add(imageView);
            addView(imageView);
        }
        this.fzw = new ArrayList();
        for (int i2 = 0; i2 < 4; i2++) {
            TextView textView = new TextView(getContext());
            switch (i2) {
                case 0:
                    textView.setText(d.k.pb_big_praise);
                    break;
                case 1:
                    textView.setText(d.k.pb_normal_praise);
                    break;
                case 2:
                    textView.setText(d.k.pb_normal_trample);
                    break;
                case 3:
                    textView.setText(d.k.pb_big_trample);
                    break;
            }
            textView.setBackgroundResource(d.f.praise_text_bg);
            textView.setTextSize(0, l.e(getContext(), d.e.fontsize22));
            textView.setTextColor(-1);
            textView.setGravity(17);
            textView.setVisibility(4);
            this.fzw.add(textView);
            addView(textView);
        }
        this.mScreenWidth = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        this.fzy = l.e(getContext(), d.e.ds70);
        this.fzz = l.e(getContext(), d.e.ds52);
    }

    private static Rect a(int i, int i2, int i3, float f, int i4) {
        double cos = i + (i3 * Math.cos(Math.toRadians(f)));
        double sin = i2 - (i3 * Math.sin(Math.toRadians(f)));
        return new Rect((int) (cos - (i4 / 2)), (int) (sin - (i4 / 2)), (int) (cos + (i4 / 2)), (int) (sin + (i4 / 2)));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.mRadius = l.e(getContext(), d.e.ds156);
        this.fzr = this.mRadius + ((this.fzm - this.fzl) / 2);
        int i3 = (this.fzr * 2) + this.fzm + this.fzn;
        int i4 = this.fzr + (this.fzm / 2) + this.fzz + this.fzo;
        if (i3 > this.mScreenWidth) {
            i3 = this.mScreenWidth;
        }
        setMeasuredDimension(i3, i4);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < this.fzu.size()) {
                int i7 = this.fzl;
                if (this.fzt != null && i6 == this.fzu.indexOf(this.fzt)) {
                    i7 = this.fzm;
                }
                int i8 = i7;
                this.fzu.get(i6).measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
                this.fzw.get(i6).measure(View.MeasureSpec.makeMeasureSpec(this.fzy, 1073741824), View.MeasureSpec.makeMeasureSpec(this.fzz, 1073741824));
                i5 = i6 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth() / 2;
        int height = getHeight() - this.fzo;
        int i5 = this.fzs ? this.mRadius : 0;
        int e = l.e(getContext(), d.e.ds90);
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 < this.fzu.size()) {
                float qO = qO(i7);
                Rect a = a(width, height, i5, qO, this.fzl);
                this.fzu.get(i7).layout(a.left, a.top, a.right, a.bottom);
                Rect a2 = a(width, height, this.fzr, qO, this.fzm);
                float width2 = a2.left + (a2.width() / 2);
                float height2 = ((a2.height() / 2) + a2.top) - e;
                this.fzw.get(i7).layout((int) (width2 - (this.fzy / 2)), (int) (height2 - (this.fzz / 2)), (int) (width2 + (this.fzy / 2)), (int) (height2 + (this.fzz / 2)));
                i6 = i7 + 1;
            } else {
                return;
            }
        }
    }

    private float ai(float f) {
        return (float) (Math.cos(Math.toRadians(f)) * 10.0d);
    }

    private float aj(float f) {
        return (float) (Math.cos(Math.toRadians(f)) * (this.fzr - this.mRadius));
    }

    private float ak(float f) {
        return 0.0f;
    }

    private float al(float f) {
        return (float) (Math.cos(Math.toRadians(f)) * (-this.mRadius));
    }

    private float am(float f) {
        return -((float) (Math.sin(Math.toRadians(f)) * 10.0d));
    }

    private float an(float f) {
        return -((float) (Math.sin(Math.toRadians(f)) * (this.fzr - this.mRadius)));
    }

    private float ao(float f) {
        return 0.0f;
    }

    private float ap(float f) {
        return (float) (Math.sin(Math.toRadians(f)) * this.mRadius);
    }

    private void f(View view2, int i, long j) {
        float qO = qO(i);
        float aj = aj(qO);
        float an = an(qO);
        float al = al(qO);
        float ap = ap(qO);
        float ai = ai(qO);
        float am = am(qO);
        float ak = ak(qO);
        float ao = ao(qO);
        this.fzA = new AnimatorSet();
        float f = this.fzs ? 1.0f : 0.0f;
        float f2 = this.fzs ? ak : al;
        if (!this.fzs) {
            al = ak;
        }
        float f3 = this.fzs ? ao : ap;
        if (!this.fzs) {
            ap = ao;
        }
        float zoomOutScale = this.fzs ? 1.0f : getZoomOutScale();
        float zoomOutScale2 = this.fzs ? getZoomOutScale() : 1.0f;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view2, PropertyValuesHolder.ofFloat("alpha", f, 1.0f - f), PropertyValuesHolder.ofFloat("translationX", f2, al), PropertyValuesHolder.ofFloat("translationY", f3, ap), PropertyValuesHolder.ofFloat("scaleX", zoomOutScale, zoomOutScale2), PropertyValuesHolder.ofFloat("scaleY", zoomOutScale, zoomOutScale2));
        ofPropertyValuesHolder.setDuration(j);
        this.fzA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.PbMainFloorPraiseFloatingView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!PbMainFloorPraiseFloatingView.this.fzs) {
                    PbMainFloorPraiseFloatingView.this.setVisibility(8);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < PbMainFloorPraiseFloatingView.this.fzu.size()) {
                            ImageView imageView = (ImageView) PbMainFloorPraiseFloatingView.this.fzu.get(i3);
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
                if (!PbMainFloorPraiseFloatingView.this.fzs) {
                    PbMainFloorPraiseFloatingView.this.setVisibility(8);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view2, PropertyValuesHolder.ofFloat("translationX", aj, ai), PropertyValuesHolder.ofFloat("translationY", an, am));
        ofPropertyValuesHolder2.setDuration(2L);
        ObjectAnimator ofPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(view2, PropertyValuesHolder.ofFloat("translationX", ai, aj), PropertyValuesHolder.ofFloat("translationY", am, an));
        ofPropertyValuesHolder3.setDuration(2L);
        if (!this.fzs) {
            this.fzA.play(ofPropertyValuesHolder);
            this.fzA.setInterpolator(this.fzD);
        } else {
            this.fzA.playSequentially(ofPropertyValuesHolder2, ofPropertyValuesHolder3, ofPropertyValuesHolder);
            this.fzA.setInterpolator(this.fzE);
            this.fzA.setDuration(4 + j);
        }
        this.fzA.start();
    }

    public boolean anL() {
        return this.fzs;
    }

    private float getZoomInScale() {
        return this.fzm / this.fzl;
    }

    private float getZoomOutScale() {
        return this.fzk / this.fzl;
    }

    public void bcE() {
        int i;
        int i2;
        int i3 = 0;
        while (i3 < this.fzu.size()) {
            ImageView imageView = this.fzu.get(i3);
            imageView.setVisibility(0);
            if (!this.fzs) {
                if (i3 == 0) {
                    i = d.b.big_praise;
                } else if (i3 == 1) {
                    com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
                    if (activitySwitch != null && activitySwitch.yd()) {
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
                com.baidu.tbadk.core.util.l a = com.baidu.tbadk.core.util.l.a(imageView, i, 20, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                a.b(imageView);
                imageView.setTag(a);
            }
            f(imageView, i3, 200L);
            i3++;
        }
        this.fzs = this.fzs ? false : true;
        invalidate();
    }

    public void br(int i, int i2) {
        if (!this.fzs) {
            bcG();
            return;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            bcF();
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < this.fzu.size()) {
                ImageView imageView = this.fzu.get(i4);
                imageView.getGlobalVisibleRect(rect);
                if (!rect.contains(i, i2) || this.fzx) {
                    i3 = i4 + 1;
                } else {
                    f(imageView);
                    return;
                }
            } else {
                bcF();
                return;
            }
        }
    }

    public void f(ImageView imageView) {
        if (imageView != null && this.fzt != imageView && !this.fzx) {
            bcG();
            this.fzt = imageView;
            float size = (((this.fzq - this.fzp) / (this.fzu.size() - 1)) * this.fzu.indexOf(imageView)) + this.fzp;
            float zoomInScale = getZoomInScale();
            this.fzB = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, zoomInScale);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, zoomInScale);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "translationX", imageView.getTranslationX(), aj(size));
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "translationY", imageView.getTranslationY(), an(size));
            if (this.fzu.indexOf(this.fzt) > -1) {
                this.fzv = this.fzw.get(this.fzu.indexOf(this.fzt));
                this.fzv.setVisibility(0);
                this.fzv.setAlpha(0.0f);
            }
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fzv, "alpha", 0.0f, 1.0f);
            this.fzB.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.fzv, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.fzv, "scaleY", 0.0f, 1.0f));
            this.fzB.setInterpolator(this.fzE);
            this.fzB.setDuration(100L);
            this.fzB.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.PbMainFloorPraiseFloatingView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    PbMainFloorPraiseFloatingView.this.fzx = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PbMainFloorPraiseFloatingView.this.fzx = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fzx = true;
            this.fzB.start();
        }
    }

    public void bcF() {
        if (this.fzt != null && !this.fzx) {
            ImageView imageView = this.fzt;
            float zoomInScale = getZoomInScale();
            this.fzC = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", zoomInScale, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", zoomInScale, 1.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "translationX", imageView.getTranslationX(), 0.0f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "translationY", imageView.getTranslationY(), 0.0f);
            if (this.fzv != null) {
                ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fzv, "alpha", 1.0f, 0.0f);
                this.fzC.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.fzv, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.fzv, "scaleY", 0.0f, 1.0f));
            } else {
                this.fzC.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
            }
            this.fzC.setInterpolator(this.fzE);
            this.fzC.setDuration(100L);
            this.fzC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.PbMainFloorPraiseFloatingView.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    PbMainFloorPraiseFloatingView.this.fzx = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PbMainFloorPraiseFloatingView.this.fzx = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fzx = true;
            this.fzC.start();
            if (this.fzv != null) {
                this.fzv.setVisibility(4);
            }
            this.fzt = null;
            this.fzv = null;
        }
    }

    public int bs(int i, int i2) {
        if (!this.fzs) {
            bcG();
            return -1;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            bcF();
            return -1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.fzu.size()) {
                return -1;
            }
            this.fzu.get(i4).getGlobalVisibleRect(rect);
            if (!rect.contains(i, i2)) {
                i3 = i4 + 1;
            } else {
                bcF();
                return i4 + 1;
            }
        }
    }

    public void bcG() {
        if (this.fzA != null && this.fzA.isStarted()) {
            this.fzA.cancel();
            this.fzA = null;
        }
        if (this.fzB != null && this.fzB.isStarted()) {
            this.fzB.cancel();
            this.fzB = null;
        }
        if (this.fzC != null && this.fzC.isStarted()) {
            this.fzC.cancel();
            this.fzC = null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fzu.size()) {
                ImageView imageView = this.fzu.get(i2);
                float qO = qO(i2);
                imageView.setTranslationX(ak(qO));
                imageView.setTranslationY(ao(qO));
                imageView.setScaleX(1.0f);
                imageView.setScaleY(1.0f);
                imageView.invalidate();
                TextView textView = this.fzw.get(i2);
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

    private float qO(int i) {
        return (((this.fzq - this.fzp) / (this.fzu.size() - 1)) * i) + this.fzp;
    }
}
