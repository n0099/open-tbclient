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
/* loaded from: classes2.dex */
public class e extends ViewGroup {
    private int gaJ;
    private int gaK;
    private int gaL;
    private int gaM;
    private int gaN;
    private float gaO;
    private float gaP;
    private int gaQ;
    private boolean gaR;
    private ImageView gaS;
    private List<ImageView> gaT;
    private TextView gaU;
    private List<TextView> gaV;
    private boolean gaW;
    private int gaX;
    private int gaY;
    private AnimatorSet gaZ;
    private AnimatorSet gba;
    private AnimatorSet gbb;
    private Interpolator gbc;
    private Interpolator gbd;
    private int mRadius;
    private int mScreenWidth;

    public e(Context context) {
        super(context);
        this.gaM = 30;
        this.gaN = l.s(getContext(), d.e.ds112);
        this.gaO = 160.0f;
        this.gaP = 20.0f;
        this.gaR = false;
        this.gbc = new OvershootInterpolator();
        this.gbd = new DecelerateInterpolator();
        init();
    }

    private void init() {
        this.gaK = getResources().getDimensionPixelSize(d.e.ds84);
        this.gaL = getResources().getDimensionPixelSize(d.e.ds120);
        this.gaJ = getResources().getDimensionPixelSize(d.e.ds36);
        this.gaT = new ArrayList();
        for (int i = 0; i < 4; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            this.gaT.add(imageView);
            addView(imageView);
        }
        this.gaV = new ArrayList();
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
            textView.setTextSize(0, l.s(getContext(), d.e.fontsize22));
            textView.setTextColor(-1);
            textView.setGravity(17);
            textView.setVisibility(4);
            this.gaV.add(textView);
            addView(textView);
        }
        this.mScreenWidth = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        this.gaX = l.s(getContext(), d.e.ds70);
        this.gaY = l.s(getContext(), d.e.ds52);
    }

    private static Rect a(int i, int i2, int i3, float f, int i4) {
        double cos = i + (i3 * Math.cos(Math.toRadians(f)));
        double sin = i2 - (i3 * Math.sin(Math.toRadians(f)));
        return new Rect((int) (cos - (i4 / 2)), (int) (sin - (i4 / 2)), (int) (cos + (i4 / 2)), (int) (sin + (i4 / 2)));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.mRadius = l.s(getContext(), d.e.ds156);
        this.gaQ = this.mRadius + ((this.gaL - this.gaK) / 2);
        int i3 = (this.gaQ * 2) + this.gaL + this.gaM;
        int i4 = this.gaQ + (this.gaL / 2) + this.gaY + this.gaN;
        if (i3 > this.mScreenWidth) {
            i3 = this.mScreenWidth;
        }
        setMeasuredDimension(i3, i4);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < this.gaT.size()) {
                int i7 = this.gaK;
                if (this.gaS != null && i6 == this.gaT.indexOf(this.gaS)) {
                    i7 = this.gaL;
                }
                int i8 = i7;
                this.gaT.get(i6).measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
                this.gaV.get(i6).measure(View.MeasureSpec.makeMeasureSpec(this.gaX, 1073741824), View.MeasureSpec.makeMeasureSpec(this.gaY, 1073741824));
                i5 = i6 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth() / 2;
        int height = getHeight() - this.gaN;
        int i5 = this.gaR ? this.mRadius : 0;
        int s = l.s(getContext(), d.e.ds90);
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 < this.gaT.size()) {
                float f = to(i7);
                Rect a = a(width, height, i5, f, this.gaK);
                this.gaT.get(i7).layout(a.left, a.top, a.right, a.bottom);
                Rect a2 = a(width, height, this.gaQ, f, this.gaL);
                float width2 = a2.left + (a2.width() / 2);
                float height2 = ((a2.height() / 2) + a2.top) - s;
                this.gaV.get(i7).layout((int) (width2 - (this.gaX / 2)), (int) (height2 - (this.gaY / 2)), (int) (width2 + (this.gaX / 2)), (int) (height2 + (this.gaY / 2)));
                i6 = i7 + 1;
            } else {
                return;
            }
        }
    }

    private float ao(float f) {
        return (float) (Math.cos(Math.toRadians(f)) * 10.0d);
    }

    private float ap(float f) {
        return (float) (Math.cos(Math.toRadians(f)) * (this.gaQ - this.mRadius));
    }

    private float aq(float f) {
        return 0.0f;
    }

    private float ar(float f) {
        return (float) (Math.cos(Math.toRadians(f)) * (-this.mRadius));
    }

    private float as(float f) {
        return -((float) (Math.sin(Math.toRadians(f)) * 10.0d));
    }

    private float at(float f) {
        return -((float) (Math.sin(Math.toRadians(f)) * (this.gaQ - this.mRadius)));
    }

    private float au(float f) {
        return 0.0f;
    }

    private float av(float f) {
        return (float) (Math.sin(Math.toRadians(f)) * this.mRadius);
    }

    private void c(View view, int i, long j) {
        float f = to(i);
        float ap = ap(f);
        float at = at(f);
        float ar = ar(f);
        float av = av(f);
        float ao = ao(f);
        float as = as(f);
        float aq = aq(f);
        float au = au(f);
        this.gaZ = new AnimatorSet();
        float f2 = this.gaR ? 1.0f : 0.0f;
        float f3 = this.gaR ? aq : ar;
        if (!this.gaR) {
            ar = aq;
        }
        float f4 = this.gaR ? au : av;
        if (!this.gaR) {
            av = au;
        }
        float zoomOutScale = this.gaR ? 1.0f : getZoomOutScale();
        float zoomOutScale2 = this.gaR ? getZoomOutScale() : 1.0f;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("alpha", f2, 1.0f - f2), PropertyValuesHolder.ofFloat("translationX", f3, ar), PropertyValuesHolder.ofFloat("translationY", f4, av), PropertyValuesHolder.ofFloat("scaleX", zoomOutScale, zoomOutScale2), PropertyValuesHolder.ofFloat("scaleY", zoomOutScale, zoomOutScale2));
        ofPropertyValuesHolder.setDuration(j);
        this.gaZ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!e.this.gaR) {
                    e.this.setVisibility(8);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < e.this.gaT.size()) {
                            ImageView imageView = (ImageView) e.this.gaT.get(i3);
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
                if (!e.this.gaR) {
                    e.this.setVisibility(8);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("translationX", ap, ao), PropertyValuesHolder.ofFloat("translationY", at, as));
        ofPropertyValuesHolder2.setDuration(2L);
        ObjectAnimator ofPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("translationX", ao, ap), PropertyValuesHolder.ofFloat("translationY", as, at));
        ofPropertyValuesHolder3.setDuration(2L);
        if (!this.gaR) {
            this.gaZ.play(ofPropertyValuesHolder);
            this.gaZ.setInterpolator(this.gbc);
        } else {
            this.gaZ.playSequentially(ofPropertyValuesHolder2, ofPropertyValuesHolder3, ofPropertyValuesHolder);
            this.gaZ.setInterpolator(this.gbd);
            this.gaZ.setDuration(4 + j);
        }
        this.gaZ.start();
    }

    public boolean asH() {
        return this.gaR;
    }

    private float getZoomInScale() {
        return this.gaL / this.gaK;
    }

    private float getZoomOutScale() {
        return this.gaJ / this.gaK;
    }

    public void bge() {
        int i;
        int i2;
        int i3 = 0;
        while (i3 < this.gaT.size()) {
            ImageView imageView = this.gaT.get(i3);
            imageView.setVisibility(0);
            if (!this.gaR) {
                if (i3 == 0) {
                    i = d.b.big_praise;
                } else if (i3 == 1) {
                    com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
                    if (activitySwitch != null && activitySwitch.EW()) {
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
        this.gaR = this.gaR ? false : true;
        invalidate();
    }

    public void cv(int i, int i2) {
        if (!this.gaR) {
            bgg();
            return;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            bgf();
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < this.gaT.size()) {
                ImageView imageView = this.gaT.get(i4);
                imageView.getGlobalVisibleRect(rect);
                if (!rect.contains(i, i2) || this.gaW) {
                    i3 = i4 + 1;
                } else {
                    f(imageView);
                    return;
                }
            } else {
                bgf();
                return;
            }
        }
    }

    public void f(ImageView imageView) {
        if (imageView != null && this.gaS != imageView && !this.gaW) {
            bgg();
            this.gaS = imageView;
            float size = (((this.gaP - this.gaO) / (this.gaT.size() - 1)) * this.gaT.indexOf(imageView)) + this.gaO;
            float zoomInScale = getZoomInScale();
            this.gba = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, zoomInScale);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, zoomInScale);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "translationX", imageView.getTranslationX(), ap(size));
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "translationY", imageView.getTranslationY(), at(size));
            if (this.gaT.indexOf(this.gaS) > -1) {
                this.gaU = this.gaV.get(this.gaT.indexOf(this.gaS));
                this.gaU.setVisibility(0);
                this.gaU.setAlpha(0.0f);
            }
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.gaU, "alpha", 0.0f, 1.0f);
            this.gba.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.gaU, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.gaU, "scaleY", 0.0f, 1.0f));
            this.gba.setInterpolator(this.gbd);
            this.gba.setDuration(100L);
            this.gba.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.gaW = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.gaW = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.gaW = true;
            this.gba.start();
        }
    }

    public void bgf() {
        if (this.gaS != null && !this.gaW) {
            ImageView imageView = this.gaS;
            float zoomInScale = getZoomInScale();
            this.gbb = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", zoomInScale, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", zoomInScale, 1.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "translationX", imageView.getTranslationX(), 0.0f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "translationY", imageView.getTranslationY(), 0.0f);
            if (this.gaU != null) {
                ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.gaU, "alpha", 1.0f, 0.0f);
                this.gbb.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.gaU, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.gaU, "scaleY", 0.0f, 1.0f));
            } else {
                this.gbb.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
            }
            this.gbb.setInterpolator(this.gbd);
            this.gbb.setDuration(100L);
            this.gbb.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.gaW = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.gaW = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.gaW = true;
            this.gbb.start();
            if (this.gaU != null) {
                this.gaU.setVisibility(4);
            }
            this.gaS = null;
            this.gaU = null;
        }
    }

    public int cw(int i, int i2) {
        if (!this.gaR) {
            bgg();
            return -1;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            bgf();
            return -1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.gaT.size()) {
                return -1;
            }
            this.gaT.get(i4).getGlobalVisibleRect(rect);
            if (!rect.contains(i, i2)) {
                i3 = i4 + 1;
            } else {
                bgf();
                return i4 + 1;
            }
        }
    }

    public void bgg() {
        if (this.gaZ != null && this.gaZ.isStarted()) {
            this.gaZ.cancel();
            this.gaZ = null;
        }
        if (this.gba != null && this.gba.isStarted()) {
            this.gba.cancel();
            this.gba = null;
        }
        if (this.gbb != null && this.gbb.isStarted()) {
            this.gbb.cancel();
            this.gbb = null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gaT.size()) {
                ImageView imageView = this.gaT.get(i2);
                float f = to(i2);
                imageView.setTranslationX(aq(f));
                imageView.setTranslationY(au(f));
                imageView.setScaleX(1.0f);
                imageView.setScaleY(1.0f);
                imageView.invalidate();
                TextView textView = this.gaV.get(i2);
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

    private float to(int i) {
        return (((this.gaP - this.gaO) / (this.gaT.size() - 1)) * i) + this.gaO;
    }
}
