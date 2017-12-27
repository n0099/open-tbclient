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
    private int fYN;
    private int fYO;
    private int fYP;
    private int fYQ;
    private int fYR;
    private float fYS;
    private float fYT;
    private int fYU;
    private boolean fYV;
    private ImageView fYW;
    private List<ImageView> fYX;
    private TextView fYY;
    private List<TextView> fYZ;
    private boolean fZa;
    private int fZb;
    private int fZc;
    private AnimatorSet fZd;
    private AnimatorSet fZe;
    private AnimatorSet fZf;
    private Interpolator fZg;
    private Interpolator fZh;
    private int mRadius;
    private int mScreenWidth;

    public e(Context context) {
        super(context);
        this.fYQ = 30;
        this.fYR = l.s(getContext(), d.e.ds112);
        this.fYS = 160.0f;
        this.fYT = 20.0f;
        this.fYV = false;
        this.fZg = new OvershootInterpolator();
        this.fZh = new DecelerateInterpolator();
        init();
    }

    private void init() {
        this.fYO = getResources().getDimensionPixelSize(d.e.ds84);
        this.fYP = getResources().getDimensionPixelSize(d.e.ds120);
        this.fYN = getResources().getDimensionPixelSize(d.e.ds36);
        this.fYX = new ArrayList();
        for (int i = 0; i < 4; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            this.fYX.add(imageView);
            addView(imageView);
        }
        this.fYZ = new ArrayList();
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
            this.fYZ.add(textView);
            addView(textView);
        }
        this.mScreenWidth = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        this.fZb = l.s(getContext(), d.e.ds70);
        this.fZc = l.s(getContext(), d.e.ds52);
    }

    private static Rect a(int i, int i2, int i3, float f, int i4) {
        double cos = i + (i3 * Math.cos(Math.toRadians(f)));
        double sin = i2 - (i3 * Math.sin(Math.toRadians(f)));
        return new Rect((int) (cos - (i4 / 2)), (int) (sin - (i4 / 2)), (int) (cos + (i4 / 2)), (int) (sin + (i4 / 2)));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.mRadius = l.s(getContext(), d.e.ds156);
        this.fYU = this.mRadius + ((this.fYP - this.fYO) / 2);
        int i3 = (this.fYU * 2) + this.fYP + this.fYQ;
        int i4 = this.fYU + (this.fYP / 2) + this.fZc + this.fYR;
        if (i3 > this.mScreenWidth) {
            i3 = this.mScreenWidth;
        }
        setMeasuredDimension(i3, i4);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < this.fYX.size()) {
                int i7 = this.fYO;
                if (this.fYW != null && i6 == this.fYX.indexOf(this.fYW)) {
                    i7 = this.fYP;
                }
                int i8 = i7;
                this.fYX.get(i6).measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
                this.fYZ.get(i6).measure(View.MeasureSpec.makeMeasureSpec(this.fZb, 1073741824), View.MeasureSpec.makeMeasureSpec(this.fZc, 1073741824));
                i5 = i6 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth() / 2;
        int height = getHeight() - this.fYR;
        int i5 = this.fYV ? this.mRadius : 0;
        int s = l.s(getContext(), d.e.ds90);
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 < this.fYX.size()) {
                float tw = tw(i7);
                Rect a = a(width, height, i5, tw, this.fYO);
                this.fYX.get(i7).layout(a.left, a.top, a.right, a.bottom);
                Rect a2 = a(width, height, this.fYU, tw, this.fYP);
                float width2 = a2.left + (a2.width() / 2);
                float height2 = ((a2.height() / 2) + a2.top) - s;
                this.fYZ.get(i7).layout((int) (width2 - (this.fZb / 2)), (int) (height2 - (this.fZc / 2)), (int) (width2 + (this.fZb / 2)), (int) (height2 + (this.fZc / 2)));
                i6 = i7 + 1;
            } else {
                return;
            }
        }
    }

    private float ap(float f) {
        return (float) (Math.cos(Math.toRadians(f)) * 10.0d);
    }

    private float aq(float f) {
        return (float) (Math.cos(Math.toRadians(f)) * (this.fYU - this.mRadius));
    }

    private float ar(float f) {
        return 0.0f;
    }

    private float as(float f) {
        return (float) (Math.cos(Math.toRadians(f)) * (-this.mRadius));
    }

    private float at(float f) {
        return -((float) (Math.sin(Math.toRadians(f)) * 10.0d));
    }

    private float au(float f) {
        return -((float) (Math.sin(Math.toRadians(f)) * (this.fYU - this.mRadius)));
    }

    private float av(float f) {
        return 0.0f;
    }

    private float aw(float f) {
        return (float) (Math.sin(Math.toRadians(f)) * this.mRadius);
    }

    private void c(View view, int i, long j) {
        float tw = tw(i);
        float aq = aq(tw);
        float au = au(tw);
        float as = as(tw);
        float aw = aw(tw);
        float ap = ap(tw);
        float at = at(tw);
        float ar = ar(tw);
        float av = av(tw);
        this.fZd = new AnimatorSet();
        float f = this.fYV ? 1.0f : 0.0f;
        float f2 = this.fYV ? ar : as;
        if (!this.fYV) {
            as = ar;
        }
        float f3 = this.fYV ? av : aw;
        if (!this.fYV) {
            aw = av;
        }
        float zoomOutScale = this.fYV ? 1.0f : getZoomOutScale();
        float zoomOutScale2 = this.fYV ? getZoomOutScale() : 1.0f;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("alpha", f, 1.0f - f), PropertyValuesHolder.ofFloat("translationX", f2, as), PropertyValuesHolder.ofFloat("translationY", f3, aw), PropertyValuesHolder.ofFloat("scaleX", zoomOutScale, zoomOutScale2), PropertyValuesHolder.ofFloat("scaleY", zoomOutScale, zoomOutScale2));
        ofPropertyValuesHolder.setDuration(j);
        this.fZd.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!e.this.fYV) {
                    e.this.setVisibility(8);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < e.this.fYX.size()) {
                            ImageView imageView = (ImageView) e.this.fYX.get(i3);
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
                if (!e.this.fYV) {
                    e.this.setVisibility(8);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("translationX", aq, ap), PropertyValuesHolder.ofFloat("translationY", au, at));
        ofPropertyValuesHolder2.setDuration(2L);
        ObjectAnimator ofPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("translationX", ap, aq), PropertyValuesHolder.ofFloat("translationY", at, au));
        ofPropertyValuesHolder3.setDuration(2L);
        if (!this.fYV) {
            this.fZd.play(ofPropertyValuesHolder);
            this.fZd.setInterpolator(this.fZg);
        } else {
            this.fZd.playSequentially(ofPropertyValuesHolder2, ofPropertyValuesHolder3, ofPropertyValuesHolder);
            this.fZd.setInterpolator(this.fZh);
            this.fZd.setDuration(4 + j);
        }
        this.fZd.start();
    }

    public boolean arz() {
        return this.fYV;
    }

    private float getZoomInScale() {
        return this.fYP / this.fYO;
    }

    private float getZoomOutScale() {
        return this.fYN / this.fYO;
    }

    public void bfY() {
        int i;
        int i2;
        int i3 = 0;
        while (i3 < this.fYX.size()) {
            ImageView imageView = this.fYX.get(i3);
            imageView.setVisibility(0);
            if (!this.fYV) {
                if (i3 == 0) {
                    i = d.b.big_praise;
                } else if (i3 == 1) {
                    com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
                    if (activitySwitch != null && activitySwitch.Fd()) {
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
        this.fYV = this.fYV ? false : true;
        invalidate();
    }

    public void cv(int i, int i2) {
        if (!this.fYV) {
            bga();
            return;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            bfZ();
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < this.fYX.size()) {
                ImageView imageView = this.fYX.get(i4);
                imageView.getGlobalVisibleRect(rect);
                if (!rect.contains(i, i2) || this.fZa) {
                    i3 = i4 + 1;
                } else {
                    f(imageView);
                    return;
                }
            } else {
                bfZ();
                return;
            }
        }
    }

    public void f(ImageView imageView) {
        if (imageView != null && this.fYW != imageView && !this.fZa) {
            bga();
            this.fYW = imageView;
            float size = (((this.fYT - this.fYS) / (this.fYX.size() - 1)) * this.fYX.indexOf(imageView)) + this.fYS;
            float zoomInScale = getZoomInScale();
            this.fZe = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, zoomInScale);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, zoomInScale);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "translationX", imageView.getTranslationX(), aq(size));
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "translationY", imageView.getTranslationY(), au(size));
            if (this.fYX.indexOf(this.fYW) > -1) {
                this.fYY = this.fYZ.get(this.fYX.indexOf(this.fYW));
                this.fYY.setVisibility(0);
                this.fYY.setAlpha(0.0f);
            }
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fYY, "alpha", 0.0f, 1.0f);
            this.fZe.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.fYY, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.fYY, "scaleY", 0.0f, 1.0f));
            this.fZe.setInterpolator(this.fZh);
            this.fZe.setDuration(100L);
            this.fZe.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.fZa = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.fZa = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fZa = true;
            this.fZe.start();
        }
    }

    public void bfZ() {
        if (this.fYW != null && !this.fZa) {
            ImageView imageView = this.fYW;
            float zoomInScale = getZoomInScale();
            this.fZf = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", zoomInScale, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", zoomInScale, 1.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "translationX", imageView.getTranslationX(), 0.0f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "translationY", imageView.getTranslationY(), 0.0f);
            if (this.fYY != null) {
                ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fYY, "alpha", 1.0f, 0.0f);
                this.fZf.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.fYY, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.fYY, "scaleY", 0.0f, 1.0f));
            } else {
                this.fZf.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
            }
            this.fZf.setInterpolator(this.fZh);
            this.fZf.setDuration(100L);
            this.fZf.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.fZa = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.fZa = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fZa = true;
            this.fZf.start();
            if (this.fYY != null) {
                this.fYY.setVisibility(4);
            }
            this.fYW = null;
            this.fYY = null;
        }
    }

    public int cw(int i, int i2) {
        if (!this.fYV) {
            bga();
            return -1;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            bfZ();
            return -1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.fYX.size()) {
                return -1;
            }
            this.fYX.get(i4).getGlobalVisibleRect(rect);
            if (!rect.contains(i, i2)) {
                i3 = i4 + 1;
            } else {
                bfZ();
                return i4 + 1;
            }
        }
    }

    public void bga() {
        if (this.fZd != null && this.fZd.isStarted()) {
            this.fZd.cancel();
            this.fZd = null;
        }
        if (this.fZe != null && this.fZe.isStarted()) {
            this.fZe.cancel();
            this.fZe = null;
        }
        if (this.fZf != null && this.fZf.isStarted()) {
            this.fZf.cancel();
            this.fZf = null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fYX.size()) {
                ImageView imageView = this.fYX.get(i2);
                float tw = tw(i2);
                imageView.setTranslationX(ar(tw));
                imageView.setTranslationY(av(tw));
                imageView.setScaleX(1.0f);
                imageView.setScaleY(1.0f);
                imageView.invalidate();
                TextView textView = this.fYZ.get(i2);
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

    private float tw(int i) {
        return (((this.fYT - this.fYS) / (this.fYX.size() - 1)) * i) + this.fYS;
    }
}
