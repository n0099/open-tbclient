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
import com.baidu.tbadk.core.util.m;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class PbMainFloorPraiseFloatingView extends ViewGroup {
    private int fOG;
    private int fOH;
    private int fOI;
    private int fOJ;
    private int fOK;
    private float fOL;
    private float fOM;
    private int fON;
    private boolean fOO;
    private ImageView fOP;
    private List<ImageView> fOQ;
    private TextView fOR;
    private List<TextView> fOS;
    private boolean fOT;
    private int fOU;
    private int fOV;
    private AnimatorSet fOW;
    private AnimatorSet fOX;
    private AnimatorSet fOY;
    private Interpolator fOZ;
    private Interpolator fPa;
    private int mRadius;
    private int mScreenWidth;

    public PbMainFloorPraiseFloatingView(Context context) {
        super(context);
        this.fOJ = 30;
        this.fOK = l.e(getContext(), d.e.ds112);
        this.fOL = 160.0f;
        this.fOM = 20.0f;
        this.fOO = false;
        this.fOZ = new OvershootInterpolator();
        this.fPa = new DecelerateInterpolator();
        init();
    }

    public PbMainFloorPraiseFloatingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fOJ = 30;
        this.fOK = l.e(getContext(), d.e.ds112);
        this.fOL = 160.0f;
        this.fOM = 20.0f;
        this.fOO = false;
        this.fOZ = new OvershootInterpolator();
        this.fPa = new DecelerateInterpolator();
        init();
    }

    private void init() {
        this.fOH = getResources().getDimensionPixelSize(d.e.ds84);
        this.fOI = getResources().getDimensionPixelSize(d.e.ds120);
        this.fOG = getResources().getDimensionPixelSize(d.e.ds36);
        this.fOQ = new ArrayList();
        for (int i = 0; i < 4; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            this.fOQ.add(imageView);
            addView(imageView);
        }
        this.fOS = new ArrayList();
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
            this.fOS.add(textView);
            addView(textView);
        }
        this.mScreenWidth = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        this.fOU = l.e(getContext(), d.e.ds70);
        this.fOV = l.e(getContext(), d.e.ds52);
    }

    private static Rect a(int i, int i2, int i3, float f, int i4) {
        double cos = i + (i3 * Math.cos(Math.toRadians(f)));
        double sin = i2 - (i3 * Math.sin(Math.toRadians(f)));
        return new Rect((int) (cos - (i4 / 2)), (int) (sin - (i4 / 2)), (int) (cos + (i4 / 2)), (int) (sin + (i4 / 2)));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.mRadius = l.e(getContext(), d.e.ds156);
        this.fON = this.mRadius + ((this.fOI - this.fOH) / 2);
        int i3 = (this.fON * 2) + this.fOI + this.fOJ;
        int i4 = this.fON + (this.fOI / 2) + this.fOV + this.fOK;
        if (i3 > this.mScreenWidth) {
            i3 = this.mScreenWidth;
        }
        setMeasuredDimension(i3, i4);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < this.fOQ.size()) {
                int i7 = this.fOH;
                if (this.fOP != null && i6 == this.fOQ.indexOf(this.fOP)) {
                    i7 = this.fOI;
                }
                int i8 = i7;
                this.fOQ.get(i6).measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
                this.fOS.get(i6).measure(View.MeasureSpec.makeMeasureSpec(this.fOU, 1073741824), View.MeasureSpec.makeMeasureSpec(this.fOV, 1073741824));
                i5 = i6 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth() / 2;
        int height = getHeight() - this.fOK;
        int i5 = this.fOO ? this.mRadius : 0;
        int e = l.e(getContext(), d.e.ds90);
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 < this.fOQ.size()) {
                float ri = ri(i7);
                Rect a = a(width, height, i5, ri, this.fOH);
                this.fOQ.get(i7).layout(a.left, a.top, a.right, a.bottom);
                Rect a2 = a(width, height, this.fON, ri, this.fOI);
                float width2 = a2.left + (a2.width() / 2);
                float height2 = ((a2.height() / 2) + a2.top) - e;
                this.fOS.get(i7).layout((int) (width2 - (this.fOU / 2)), (int) (height2 - (this.fOV / 2)), (int) (width2 + (this.fOU / 2)), (int) (height2 + (this.fOV / 2)));
                i6 = i7 + 1;
            } else {
                return;
            }
        }
    }

    private float as(float f) {
        return (float) (Math.cos(Math.toRadians(f)) * 10.0d);
    }

    private float at(float f) {
        return (float) (Math.cos(Math.toRadians(f)) * (this.fON - this.mRadius));
    }

    private float au(float f) {
        return 0.0f;
    }

    private float av(float f) {
        return (float) (Math.cos(Math.toRadians(f)) * (-this.mRadius));
    }

    private float aw(float f) {
        return -((float) (Math.sin(Math.toRadians(f)) * 10.0d));
    }

    private float ax(float f) {
        return -((float) (Math.sin(Math.toRadians(f)) * (this.fON - this.mRadius)));
    }

    private float ay(float f) {
        return 0.0f;
    }

    private float az(float f) {
        return (float) (Math.sin(Math.toRadians(f)) * this.mRadius);
    }

    private void f(View view, int i, long j) {
        float ri = ri(i);
        float at = at(ri);
        float ax = ax(ri);
        float av = av(ri);
        float az = az(ri);
        float as = as(ri);
        float aw = aw(ri);
        float au = au(ri);
        float ay = ay(ri);
        this.fOW = new AnimatorSet();
        float f = this.fOO ? 1.0f : 0.0f;
        float f2 = this.fOO ? au : av;
        if (!this.fOO) {
            av = au;
        }
        float f3 = this.fOO ? ay : az;
        if (!this.fOO) {
            az = ay;
        }
        float zoomOutScale = this.fOO ? 1.0f : getZoomOutScale();
        float zoomOutScale2 = this.fOO ? getZoomOutScale() : 1.0f;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("alpha", f, 1.0f - f), PropertyValuesHolder.ofFloat("translationX", f2, av), PropertyValuesHolder.ofFloat("translationY", f3, az), PropertyValuesHolder.ofFloat("scaleX", zoomOutScale, zoomOutScale2), PropertyValuesHolder.ofFloat("scaleY", zoomOutScale, zoomOutScale2));
        ofPropertyValuesHolder.setDuration(j);
        this.fOW.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.PbMainFloorPraiseFloatingView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!PbMainFloorPraiseFloatingView.this.fOO) {
                    PbMainFloorPraiseFloatingView.this.setVisibility(8);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < PbMainFloorPraiseFloatingView.this.fOQ.size()) {
                            ImageView imageView = (ImageView) PbMainFloorPraiseFloatingView.this.fOQ.get(i3);
                            if (imageView.getTag() != null) {
                                ((m) imageView.getTag()).stop();
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
                if (!PbMainFloorPraiseFloatingView.this.fOO) {
                    PbMainFloorPraiseFloatingView.this.setVisibility(8);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("translationX", at, as), PropertyValuesHolder.ofFloat("translationY", ax, aw));
        ofPropertyValuesHolder2.setDuration(2L);
        ObjectAnimator ofPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("translationX", as, at), PropertyValuesHolder.ofFloat("translationY", aw, ax));
        ofPropertyValuesHolder3.setDuration(2L);
        if (!this.fOO) {
            this.fOW.play(ofPropertyValuesHolder);
            this.fOW.setInterpolator(this.fOZ);
        } else {
            this.fOW.playSequentially(ofPropertyValuesHolder2, ofPropertyValuesHolder3, ofPropertyValuesHolder);
            this.fOW.setInterpolator(this.fPa);
            this.fOW.setDuration(4 + j);
        }
        this.fOW.start();
    }

    public boolean arl() {
        return this.fOO;
    }

    private float getZoomInScale() {
        return this.fOI / this.fOH;
    }

    private float getZoomOutScale() {
        return this.fOG / this.fOH;
    }

    public void bik() {
        int i;
        int i2;
        int i3 = 0;
        while (i3 < this.fOQ.size()) {
            ImageView imageView = this.fOQ.get(i3);
            imageView.setVisibility(0);
            if (!this.fOO) {
                if (i3 == 0) {
                    i = d.b.big_praise;
                } else if (i3 == 1) {
                    com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
                    if (activitySwitch != null && activitySwitch.BU()) {
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
                if (imageView.getTag() != null && (imageView.getTag() instanceof m)) {
                    ((m) imageView.getTag()).stop();
                    imageView.setTag(null);
                }
                m a = m.a(imageView, i, 20, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                a.b(imageView);
                imageView.setTag(a);
            }
            f(imageView, i3, 200L);
            i3++;
        }
        this.fOO = this.fOO ? false : true;
        invalidate();
    }

    public void bs(int i, int i2) {
        if (!this.fOO) {
            bim();
            return;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            bil();
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < this.fOQ.size()) {
                ImageView imageView = this.fOQ.get(i4);
                imageView.getGlobalVisibleRect(rect);
                if (!rect.contains(i, i2) || this.fOT) {
                    i3 = i4 + 1;
                } else {
                    f(imageView);
                    return;
                }
            } else {
                bil();
                return;
            }
        }
    }

    public void f(ImageView imageView) {
        if (imageView != null && this.fOP != imageView && !this.fOT) {
            bim();
            this.fOP = imageView;
            float size = (((this.fOM - this.fOL) / (this.fOQ.size() - 1)) * this.fOQ.indexOf(imageView)) + this.fOL;
            float zoomInScale = getZoomInScale();
            this.fOX = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, zoomInScale);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, zoomInScale);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "translationX", imageView.getTranslationX(), at(size));
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "translationY", imageView.getTranslationY(), ax(size));
            if (this.fOQ.indexOf(this.fOP) > -1) {
                this.fOR = this.fOS.get(this.fOQ.indexOf(this.fOP));
                this.fOR.setVisibility(0);
                this.fOR.setAlpha(0.0f);
            }
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fOR, "alpha", 0.0f, 1.0f);
            this.fOX.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.fOR, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.fOR, "scaleY", 0.0f, 1.0f));
            this.fOX.setInterpolator(this.fPa);
            this.fOX.setDuration(100L);
            this.fOX.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.PbMainFloorPraiseFloatingView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    PbMainFloorPraiseFloatingView.this.fOT = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PbMainFloorPraiseFloatingView.this.fOT = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fOT = true;
            this.fOX.start();
        }
    }

    public void bil() {
        if (this.fOP != null && !this.fOT) {
            ImageView imageView = this.fOP;
            float zoomInScale = getZoomInScale();
            this.fOY = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", zoomInScale, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", zoomInScale, 1.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "translationX", imageView.getTranslationX(), 0.0f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "translationY", imageView.getTranslationY(), 0.0f);
            if (this.fOR != null) {
                ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fOR, "alpha", 1.0f, 0.0f);
                this.fOY.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.fOR, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.fOR, "scaleY", 0.0f, 1.0f));
            } else {
                this.fOY.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
            }
            this.fOY.setInterpolator(this.fPa);
            this.fOY.setDuration(100L);
            this.fOY.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.PbMainFloorPraiseFloatingView.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    PbMainFloorPraiseFloatingView.this.fOT = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PbMainFloorPraiseFloatingView.this.fOT = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fOT = true;
            this.fOY.start();
            if (this.fOR != null) {
                this.fOR.setVisibility(4);
            }
            this.fOP = null;
            this.fOR = null;
        }
    }

    public int bt(int i, int i2) {
        if (!this.fOO) {
            bim();
            return -1;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            bil();
            return -1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.fOQ.size()) {
                return -1;
            }
            this.fOQ.get(i4).getGlobalVisibleRect(rect);
            if (!rect.contains(i, i2)) {
                i3 = i4 + 1;
            } else {
                bil();
                return i4 + 1;
            }
        }
    }

    public void bim() {
        if (this.fOW != null && this.fOW.isStarted()) {
            this.fOW.cancel();
            this.fOW = null;
        }
        if (this.fOX != null && this.fOX.isStarted()) {
            this.fOX.cancel();
            this.fOX = null;
        }
        if (this.fOY != null && this.fOY.isStarted()) {
            this.fOY.cancel();
            this.fOY = null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fOQ.size()) {
                ImageView imageView = this.fOQ.get(i2);
                float ri = ri(i2);
                imageView.setTranslationX(au(ri));
                imageView.setTranslationY(ay(ri));
                imageView.setScaleX(1.0f);
                imageView.setScaleY(1.0f);
                imageView.invalidate();
                TextView textView = this.fOS.get(i2);
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

    private float ri(int i) {
        return (((this.fOM - this.fOL) / (this.fOQ.size() - 1)) * i) + this.fOL;
    }
}
