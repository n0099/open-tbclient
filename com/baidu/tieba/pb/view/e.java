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
    private int gdF;
    private int gdG;
    private int gdH;
    private int gdI;
    private int gdJ;
    private float gdK;
    private float gdL;
    private int gdM;
    private boolean gdN;
    private ImageView gdO;
    private List<ImageView> gdP;
    private TextView gdQ;
    private List<TextView> gdR;
    private boolean gdS;
    private int gdT;
    private int gdU;
    private AnimatorSet gdV;
    private AnimatorSet gdW;
    private AnimatorSet gdX;
    private Interpolator gdY;
    private Interpolator gdZ;
    private int mRadius;
    private int mScreenWidth;

    public e(Context context) {
        super(context);
        this.gdI = 30;
        this.gdJ = l.t(getContext(), d.e.ds112);
        this.gdK = 160.0f;
        this.gdL = 20.0f;
        this.gdN = false;
        this.gdY = new OvershootInterpolator();
        this.gdZ = new DecelerateInterpolator();
        init();
    }

    private void init() {
        this.gdG = getResources().getDimensionPixelSize(d.e.ds84);
        this.gdH = getResources().getDimensionPixelSize(d.e.ds120);
        this.gdF = getResources().getDimensionPixelSize(d.e.ds36);
        this.gdP = new ArrayList();
        for (int i = 0; i < 4; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            this.gdP.add(imageView);
            addView(imageView);
        }
        this.gdR = new ArrayList();
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
            textView.setTextSize(0, l.t(getContext(), d.e.fontsize22));
            textView.setTextColor(-1);
            textView.setGravity(17);
            textView.setVisibility(4);
            this.gdR.add(textView);
            addView(textView);
        }
        this.mScreenWidth = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        this.gdT = l.t(getContext(), d.e.ds70);
        this.gdU = l.t(getContext(), d.e.ds52);
    }

    private static Rect a(int i, int i2, int i3, float f, int i4) {
        double cos = i + (i3 * Math.cos(Math.toRadians(f)));
        double sin = i2 - (i3 * Math.sin(Math.toRadians(f)));
        return new Rect((int) (cos - (i4 / 2)), (int) (sin - (i4 / 2)), (int) (cos + (i4 / 2)), (int) (sin + (i4 / 2)));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.mRadius = l.t(getContext(), d.e.ds156);
        this.gdM = this.mRadius + ((this.gdH - this.gdG) / 2);
        int i3 = (this.gdM * 2) + this.gdH + this.gdI;
        int i4 = this.gdM + (this.gdH / 2) + this.gdU + this.gdJ;
        if (i3 > this.mScreenWidth) {
            i3 = this.mScreenWidth;
        }
        setMeasuredDimension(i3, i4);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < this.gdP.size()) {
                int i7 = this.gdG;
                if (this.gdO != null && i6 == this.gdP.indexOf(this.gdO)) {
                    i7 = this.gdH;
                }
                int i8 = i7;
                this.gdP.get(i6).measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
                this.gdR.get(i6).measure(View.MeasureSpec.makeMeasureSpec(this.gdT, 1073741824), View.MeasureSpec.makeMeasureSpec(this.gdU, 1073741824));
                i5 = i6 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth() / 2;
        int height = getHeight() - this.gdJ;
        int i5 = this.gdN ? this.mRadius : 0;
        int t = l.t(getContext(), d.e.ds90);
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 < this.gdP.size()) {
                float tt = tt(i7);
                Rect a = a(width, height, i5, tt, this.gdG);
                this.gdP.get(i7).layout(a.left, a.top, a.right, a.bottom);
                Rect a2 = a(width, height, this.gdM, tt, this.gdH);
                float width2 = a2.left + (a2.width() / 2);
                float height2 = ((a2.height() / 2) + a2.top) - t;
                this.gdR.get(i7).layout((int) (width2 - (this.gdT / 2)), (int) (height2 - (this.gdU / 2)), (int) (width2 + (this.gdT / 2)), (int) (height2 + (this.gdU / 2)));
                i6 = i7 + 1;
            } else {
                return;
            }
        }
    }

    private float au(float f) {
        return (float) (Math.cos(Math.toRadians(f)) * 10.0d);
    }

    private float av(float f) {
        return (float) (Math.cos(Math.toRadians(f)) * (this.gdM - this.mRadius));
    }

    private float aw(float f) {
        return 0.0f;
    }

    private float ax(float f) {
        return (float) (Math.cos(Math.toRadians(f)) * (-this.mRadius));
    }

    private float ay(float f) {
        return -((float) (Math.sin(Math.toRadians(f)) * 10.0d));
    }

    private float az(float f) {
        return -((float) (Math.sin(Math.toRadians(f)) * (this.gdM - this.mRadius)));
    }

    private float aA(float f) {
        return 0.0f;
    }

    private float aB(float f) {
        return (float) (Math.sin(Math.toRadians(f)) * this.mRadius);
    }

    private void c(View view, int i, long j) {
        float tt = tt(i);
        float av = av(tt);
        float az = az(tt);
        float ax = ax(tt);
        float aB = aB(tt);
        float au = au(tt);
        float ay = ay(tt);
        float aw = aw(tt);
        float aA = aA(tt);
        this.gdV = new AnimatorSet();
        float f = this.gdN ? 1.0f : 0.0f;
        float f2 = this.gdN ? aw : ax;
        if (!this.gdN) {
            ax = aw;
        }
        float f3 = this.gdN ? aA : aB;
        if (!this.gdN) {
            aB = aA;
        }
        float zoomOutScale = this.gdN ? 1.0f : getZoomOutScale();
        float zoomOutScale2 = this.gdN ? getZoomOutScale() : 1.0f;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("alpha", f, 1.0f - f), PropertyValuesHolder.ofFloat("translationX", f2, ax), PropertyValuesHolder.ofFloat("translationY", f3, aB), PropertyValuesHolder.ofFloat("scaleX", zoomOutScale, zoomOutScale2), PropertyValuesHolder.ofFloat("scaleY", zoomOutScale, zoomOutScale2));
        ofPropertyValuesHolder.setDuration(j);
        this.gdV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!e.this.gdN) {
                    e.this.setVisibility(8);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < e.this.gdP.size()) {
                            ImageView imageView = (ImageView) e.this.gdP.get(i3);
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
                if (!e.this.gdN) {
                    e.this.setVisibility(8);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("translationX", av, au), PropertyValuesHolder.ofFloat("translationY", az, ay));
        ofPropertyValuesHolder2.setDuration(2L);
        ObjectAnimator ofPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("translationX", au, av), PropertyValuesHolder.ofFloat("translationY", ay, az));
        ofPropertyValuesHolder3.setDuration(2L);
        if (!this.gdN) {
            this.gdV.play(ofPropertyValuesHolder);
            this.gdV.setInterpolator(this.gdY);
        } else {
            this.gdV.playSequentially(ofPropertyValuesHolder2, ofPropertyValuesHolder3, ofPropertyValuesHolder);
            this.gdV.setInterpolator(this.gdZ);
            this.gdV.setDuration(4 + j);
        }
        this.gdV.start();
    }

    public boolean atw() {
        return this.gdN;
    }

    private float getZoomInScale() {
        return this.gdH / this.gdG;
    }

    private float getZoomOutScale() {
        return this.gdF / this.gdG;
    }

    public void bhD() {
        int i;
        int i2;
        int i3 = 0;
        while (i3 < this.gdP.size()) {
            ImageView imageView = this.gdP.get(i3);
            imageView.setVisibility(0);
            if (!this.gdN) {
                if (i3 == 0) {
                    i = d.b.big_praise;
                } else if (i3 == 1) {
                    com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
                    if (activitySwitch != null && activitySwitch.Fq()) {
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
        this.gdN = this.gdN ? false : true;
        invalidate();
    }

    public void cr(int i, int i2) {
        if (!this.gdN) {
            bhF();
            return;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            bhE();
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < this.gdP.size()) {
                ImageView imageView = this.gdP.get(i4);
                imageView.getGlobalVisibleRect(rect);
                if (!rect.contains(i, i2) || this.gdS) {
                    i3 = i4 + 1;
                } else {
                    f(imageView);
                    return;
                }
            } else {
                bhE();
                return;
            }
        }
    }

    public void f(ImageView imageView) {
        if (imageView != null && this.gdO != imageView && !this.gdS) {
            bhF();
            this.gdO = imageView;
            float size = (((this.gdL - this.gdK) / (this.gdP.size() - 1)) * this.gdP.indexOf(imageView)) + this.gdK;
            float zoomInScale = getZoomInScale();
            this.gdW = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, zoomInScale);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, zoomInScale);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "translationX", imageView.getTranslationX(), av(size));
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "translationY", imageView.getTranslationY(), az(size));
            if (this.gdP.indexOf(this.gdO) > -1) {
                this.gdQ = this.gdR.get(this.gdP.indexOf(this.gdO));
                this.gdQ.setVisibility(0);
                this.gdQ.setAlpha(0.0f);
            }
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.gdQ, "alpha", 0.0f, 1.0f);
            this.gdW.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.gdQ, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.gdQ, "scaleY", 0.0f, 1.0f));
            this.gdW.setInterpolator(this.gdZ);
            this.gdW.setDuration(100L);
            this.gdW.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.gdS = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.gdS = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.gdS = true;
            this.gdW.start();
        }
    }

    public void bhE() {
        if (this.gdO != null && !this.gdS) {
            ImageView imageView = this.gdO;
            float zoomInScale = getZoomInScale();
            this.gdX = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", zoomInScale, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", zoomInScale, 1.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "translationX", imageView.getTranslationX(), 0.0f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "translationY", imageView.getTranslationY(), 0.0f);
            if (this.gdQ != null) {
                ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.gdQ, "alpha", 1.0f, 0.0f);
                this.gdX.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.gdQ, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.gdQ, "scaleY", 0.0f, 1.0f));
            } else {
                this.gdX.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
            }
            this.gdX.setInterpolator(this.gdZ);
            this.gdX.setDuration(100L);
            this.gdX.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.gdS = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.gdS = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.gdS = true;
            this.gdX.start();
            if (this.gdQ != null) {
                this.gdQ.setVisibility(4);
            }
            this.gdO = null;
            this.gdQ = null;
        }
    }

    public int cs(int i, int i2) {
        if (!this.gdN) {
            bhF();
            return -1;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            bhE();
            return -1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.gdP.size()) {
                return -1;
            }
            this.gdP.get(i4).getGlobalVisibleRect(rect);
            if (!rect.contains(i, i2)) {
                i3 = i4 + 1;
            } else {
                bhE();
                return i4 + 1;
            }
        }
    }

    public void bhF() {
        if (this.gdV != null && this.gdV.isStarted()) {
            this.gdV.cancel();
            this.gdV = null;
        }
        if (this.gdW != null && this.gdW.isStarted()) {
            this.gdW.cancel();
            this.gdW = null;
        }
        if (this.gdX != null && this.gdX.isStarted()) {
            this.gdX.cancel();
            this.gdX = null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gdP.size()) {
                ImageView imageView = this.gdP.get(i2);
                float tt = tt(i2);
                imageView.setTranslationX(aw(tt));
                imageView.setTranslationY(aA(tt));
                imageView.setScaleX(1.0f);
                imageView.setScaleY(1.0f);
                imageView.invalidate();
                TextView textView = this.gdR.get(i2);
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

    private float tt(int i) {
        return (((this.gdL - this.gdK) / (this.gdP.size() - 1)) * i) + this.gdK;
    }
}
