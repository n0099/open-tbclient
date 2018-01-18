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
    private List<TextView> gaA;
    private boolean gaB;
    private int gaC;
    private int gaD;
    private AnimatorSet gaE;
    private AnimatorSet gaF;
    private AnimatorSet gaG;
    private Interpolator gaH;
    private Interpolator gaI;
    private int gao;
    private int gap;
    private int gaq;
    private int gar;
    private int gas;
    private float gat;
    private float gau;
    private int gav;
    private boolean gaw;
    private ImageView gax;
    private List<ImageView> gay;
    private TextView gaz;
    private int mRadius;
    private int mScreenWidth;

    public e(Context context) {
        super(context);
        this.gar = 30;
        this.gas = l.s(getContext(), d.e.ds112);
        this.gat = 160.0f;
        this.gau = 20.0f;
        this.gaw = false;
        this.gaH = new OvershootInterpolator();
        this.gaI = new DecelerateInterpolator();
        init();
    }

    private void init() {
        this.gap = getResources().getDimensionPixelSize(d.e.ds84);
        this.gaq = getResources().getDimensionPixelSize(d.e.ds120);
        this.gao = getResources().getDimensionPixelSize(d.e.ds36);
        this.gay = new ArrayList();
        for (int i = 0; i < 4; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            this.gay.add(imageView);
            addView(imageView);
        }
        this.gaA = new ArrayList();
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
            this.gaA.add(textView);
            addView(textView);
        }
        this.mScreenWidth = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        this.gaC = l.s(getContext(), d.e.ds70);
        this.gaD = l.s(getContext(), d.e.ds52);
    }

    private static Rect a(int i, int i2, int i3, float f, int i4) {
        double cos = i + (i3 * Math.cos(Math.toRadians(f)));
        double sin = i2 - (i3 * Math.sin(Math.toRadians(f)));
        return new Rect((int) (cos - (i4 / 2)), (int) (sin - (i4 / 2)), (int) (cos + (i4 / 2)), (int) (sin + (i4 / 2)));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.mRadius = l.s(getContext(), d.e.ds156);
        this.gav = this.mRadius + ((this.gaq - this.gap) / 2);
        int i3 = (this.gav * 2) + this.gaq + this.gar;
        int i4 = this.gav + (this.gaq / 2) + this.gaD + this.gas;
        if (i3 > this.mScreenWidth) {
            i3 = this.mScreenWidth;
        }
        setMeasuredDimension(i3, i4);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < this.gay.size()) {
                int i7 = this.gap;
                if (this.gax != null && i6 == this.gay.indexOf(this.gax)) {
                    i7 = this.gaq;
                }
                int i8 = i7;
                this.gay.get(i6).measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
                this.gaA.get(i6).measure(View.MeasureSpec.makeMeasureSpec(this.gaC, 1073741824), View.MeasureSpec.makeMeasureSpec(this.gaD, 1073741824));
                i5 = i6 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth() / 2;
        int height = getHeight() - this.gas;
        int i5 = this.gaw ? this.mRadius : 0;
        int s = l.s(getContext(), d.e.ds90);
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 < this.gay.size()) {
                float f = to(i7);
                Rect a = a(width, height, i5, f, this.gap);
                this.gay.get(i7).layout(a.left, a.top, a.right, a.bottom);
                Rect a2 = a(width, height, this.gav, f, this.gaq);
                float width2 = a2.left + (a2.width() / 2);
                float height2 = ((a2.height() / 2) + a2.top) - s;
                this.gaA.get(i7).layout((int) (width2 - (this.gaC / 2)), (int) (height2 - (this.gaD / 2)), (int) (width2 + (this.gaC / 2)), (int) (height2 + (this.gaD / 2)));
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
        return (float) (Math.cos(Math.toRadians(f)) * (this.gav - this.mRadius));
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
        return -((float) (Math.sin(Math.toRadians(f)) * (this.gav - this.mRadius)));
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
        this.gaE = new AnimatorSet();
        float f2 = this.gaw ? 1.0f : 0.0f;
        float f3 = this.gaw ? aq : ar;
        if (!this.gaw) {
            ar = aq;
        }
        float f4 = this.gaw ? au : av;
        if (!this.gaw) {
            av = au;
        }
        float zoomOutScale = this.gaw ? 1.0f : getZoomOutScale();
        float zoomOutScale2 = this.gaw ? getZoomOutScale() : 1.0f;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("alpha", f2, 1.0f - f2), PropertyValuesHolder.ofFloat("translationX", f3, ar), PropertyValuesHolder.ofFloat("translationY", f4, av), PropertyValuesHolder.ofFloat("scaleX", zoomOutScale, zoomOutScale2), PropertyValuesHolder.ofFloat("scaleY", zoomOutScale, zoomOutScale2));
        ofPropertyValuesHolder.setDuration(j);
        this.gaE.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!e.this.gaw) {
                    e.this.setVisibility(8);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < e.this.gay.size()) {
                            ImageView imageView = (ImageView) e.this.gay.get(i3);
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
                if (!e.this.gaw) {
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
        if (!this.gaw) {
            this.gaE.play(ofPropertyValuesHolder);
            this.gaE.setInterpolator(this.gaH);
        } else {
            this.gaE.playSequentially(ofPropertyValuesHolder2, ofPropertyValuesHolder3, ofPropertyValuesHolder);
            this.gaE.setInterpolator(this.gaI);
            this.gaE.setDuration(4 + j);
        }
        this.gaE.start();
    }

    public boolean asC() {
        return this.gaw;
    }

    private float getZoomInScale() {
        return this.gaq / this.gap;
    }

    private float getZoomOutScale() {
        return this.gao / this.gap;
    }

    public void bfZ() {
        int i;
        int i2;
        int i3 = 0;
        while (i3 < this.gay.size()) {
            ImageView imageView = this.gay.get(i3);
            imageView.setVisibility(0);
            if (!this.gaw) {
                if (i3 == 0) {
                    i = d.b.big_praise;
                } else if (i3 == 1) {
                    com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
                    if (activitySwitch != null && activitySwitch.EU()) {
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
        this.gaw = this.gaw ? false : true;
        invalidate();
    }

    public void cv(int i, int i2) {
        if (!this.gaw) {
            bgb();
            return;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            bga();
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < this.gay.size()) {
                ImageView imageView = this.gay.get(i4);
                imageView.getGlobalVisibleRect(rect);
                if (!rect.contains(i, i2) || this.gaB) {
                    i3 = i4 + 1;
                } else {
                    f(imageView);
                    return;
                }
            } else {
                bga();
                return;
            }
        }
    }

    public void f(ImageView imageView) {
        if (imageView != null && this.gax != imageView && !this.gaB) {
            bgb();
            this.gax = imageView;
            float size = (((this.gau - this.gat) / (this.gay.size() - 1)) * this.gay.indexOf(imageView)) + this.gat;
            float zoomInScale = getZoomInScale();
            this.gaF = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, zoomInScale);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, zoomInScale);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "translationX", imageView.getTranslationX(), ap(size));
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "translationY", imageView.getTranslationY(), at(size));
            if (this.gay.indexOf(this.gax) > -1) {
                this.gaz = this.gaA.get(this.gay.indexOf(this.gax));
                this.gaz.setVisibility(0);
                this.gaz.setAlpha(0.0f);
            }
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.gaz, "alpha", 0.0f, 1.0f);
            this.gaF.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.gaz, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.gaz, "scaleY", 0.0f, 1.0f));
            this.gaF.setInterpolator(this.gaI);
            this.gaF.setDuration(100L);
            this.gaF.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.gaB = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.gaB = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.gaB = true;
            this.gaF.start();
        }
    }

    public void bga() {
        if (this.gax != null && !this.gaB) {
            ImageView imageView = this.gax;
            float zoomInScale = getZoomInScale();
            this.gaG = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", zoomInScale, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", zoomInScale, 1.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "translationX", imageView.getTranslationX(), 0.0f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "translationY", imageView.getTranslationY(), 0.0f);
            if (this.gaz != null) {
                ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.gaz, "alpha", 1.0f, 0.0f);
                this.gaG.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.gaz, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.gaz, "scaleY", 0.0f, 1.0f));
            } else {
                this.gaG.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
            }
            this.gaG.setInterpolator(this.gaI);
            this.gaG.setDuration(100L);
            this.gaG.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.gaB = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.gaB = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.gaB = true;
            this.gaG.start();
            if (this.gaz != null) {
                this.gaz.setVisibility(4);
            }
            this.gax = null;
            this.gaz = null;
        }
    }

    public int cw(int i, int i2) {
        if (!this.gaw) {
            bgb();
            return -1;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            bga();
            return -1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.gay.size()) {
                return -1;
            }
            this.gay.get(i4).getGlobalVisibleRect(rect);
            if (!rect.contains(i, i2)) {
                i3 = i4 + 1;
            } else {
                bga();
                return i4 + 1;
            }
        }
    }

    public void bgb() {
        if (this.gaE != null && this.gaE.isStarted()) {
            this.gaE.cancel();
            this.gaE = null;
        }
        if (this.gaF != null && this.gaF.isStarted()) {
            this.gaF.cancel();
            this.gaF = null;
        }
        if (this.gaG != null && this.gaG.isStarted()) {
            this.gaG.cancel();
            this.gaG = null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gay.size()) {
                ImageView imageView = this.gay.get(i2);
                float f = to(i2);
                imageView.setTranslationX(aq(f));
                imageView.setTranslationY(au(f));
                imageView.setScaleX(1.0f);
                imageView.setScaleY(1.0f);
                imageView.invalidate();
                TextView textView = this.gaA.get(i2);
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
        return (((this.gau - this.gat) / (this.gay.size() - 1)) * i) + this.gat;
    }
}
