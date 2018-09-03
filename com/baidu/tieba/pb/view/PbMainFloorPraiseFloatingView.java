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
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class PbMainFloorPraiseFloatingView extends ViewGroup {
    private int dkB;
    private int fOJ;
    private int fOK;
    private int fOL;
    private int fOM;
    private int fON;
    private float fOO;
    private float fOP;
    private int fOQ;
    private boolean fOR;
    private ImageView fOS;
    private List<ImageView> fOT;
    private TextView fOU;
    private List<TextView> fOV;
    private boolean fOW;
    private int fOX;
    private AnimatorSet fOY;
    private AnimatorSet fOZ;
    private AnimatorSet fPa;
    private Interpolator fPb;
    private Interpolator fPc;
    private int mScreenWidth;
    private int textViewHeight;

    public PbMainFloorPraiseFloatingView(Context context) {
        super(context);
        this.fOM = 30;
        this.fON = l.f(getContext(), f.e.ds112);
        this.fOO = 160.0f;
        this.fOP = 20.0f;
        this.fOR = false;
        this.fPb = new OvershootInterpolator();
        this.fPc = new DecelerateInterpolator();
        init();
    }

    public PbMainFloorPraiseFloatingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fOM = 30;
        this.fON = l.f(getContext(), f.e.ds112);
        this.fOO = 160.0f;
        this.fOP = 20.0f;
        this.fOR = false;
        this.fPb = new OvershootInterpolator();
        this.fPc = new DecelerateInterpolator();
        init();
    }

    private void init() {
        this.fOK = getResources().getDimensionPixelSize(f.e.ds84);
        this.fOL = getResources().getDimensionPixelSize(f.e.ds120);
        this.fOJ = getResources().getDimensionPixelSize(f.e.ds36);
        this.fOT = new ArrayList();
        for (int i = 0; i < 4; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            this.fOT.add(imageView);
            addView(imageView);
        }
        this.fOV = new ArrayList();
        for (int i2 = 0; i2 < 4; i2++) {
            TextView textView = new TextView(getContext());
            switch (i2) {
                case 0:
                    textView.setText(f.j.pb_big_praise);
                    break;
                case 1:
                    textView.setText(f.j.pb_normal_praise);
                    break;
                case 2:
                    textView.setText(f.j.pb_normal_trample);
                    break;
                case 3:
                    textView.setText(f.j.pb_big_trample);
                    break;
            }
            textView.setBackgroundResource(f.C0146f.praise_text_bg);
            textView.setTextSize(0, l.f(getContext(), f.e.fontsize22));
            textView.setTextColor(-1);
            textView.setGravity(17);
            textView.setVisibility(4);
            this.fOV.add(textView);
            addView(textView);
        }
        this.mScreenWidth = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        this.fOX = l.f(getContext(), f.e.ds70);
        this.textViewHeight = l.f(getContext(), f.e.ds52);
    }

    private static Rect a(int i, int i2, int i3, float f, int i4) {
        double cos = i + (i3 * Math.cos(Math.toRadians(f)));
        double sin = i2 - (i3 * Math.sin(Math.toRadians(f)));
        return new Rect((int) (cos - (i4 / 2)), (int) (sin - (i4 / 2)), (int) (cos + (i4 / 2)), (int) (sin + (i4 / 2)));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.dkB = l.f(getContext(), f.e.ds156);
        this.fOQ = this.dkB + ((this.fOL - this.fOK) / 2);
        int i3 = (this.fOQ * 2) + this.fOL + this.fOM;
        int i4 = this.fOQ + (this.fOL / 2) + this.textViewHeight + this.fON;
        if (i3 > this.mScreenWidth) {
            i3 = this.mScreenWidth;
        }
        setMeasuredDimension(i3, i4);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < this.fOT.size()) {
                int i7 = this.fOK;
                if (this.fOS != null && i6 == this.fOT.indexOf(this.fOS)) {
                    i7 = this.fOL;
                }
                int i8 = i7;
                this.fOT.get(i6).measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
                this.fOV.get(i6).measure(View.MeasureSpec.makeMeasureSpec(this.fOX, 1073741824), View.MeasureSpec.makeMeasureSpec(this.textViewHeight, 1073741824));
                i5 = i6 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth() / 2;
        int height = getHeight() - this.fON;
        int i5 = this.fOR ? this.dkB : 0;
        int f = l.f(getContext(), f.e.ds90);
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 < this.fOT.size()) {
                float rf = rf(i7);
                Rect a = a(width, height, i5, rf, this.fOK);
                this.fOT.get(i7).layout(a.left, a.top, a.right, a.bottom);
                Rect a2 = a(width, height, this.fOQ, rf, this.fOL);
                float width2 = a2.left + (a2.width() / 2);
                float height2 = ((a2.height() / 2) + a2.top) - f;
                this.fOV.get(i7).layout((int) (width2 - (this.fOX / 2)), (int) (height2 - (this.textViewHeight / 2)), (int) (width2 + (this.fOX / 2)), (int) (height2 + (this.textViewHeight / 2)));
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
        return (float) (Math.cos(Math.toRadians(f)) * (this.fOQ - this.dkB));
    }

    private float au(float f) {
        return 0.0f;
    }

    private float av(float f) {
        return (float) (Math.cos(Math.toRadians(f)) * (-this.dkB));
    }

    private float aw(float f) {
        return -((float) (Math.sin(Math.toRadians(f)) * 10.0d));
    }

    private float ax(float f) {
        return -((float) (Math.sin(Math.toRadians(f)) * (this.fOQ - this.dkB)));
    }

    private float ay(float f) {
        return 0.0f;
    }

    private float az(float f) {
        return (float) (Math.sin(Math.toRadians(f)) * this.dkB);
    }

    private void c(View view, int i, long j) {
        float rf = rf(i);
        float at = at(rf);
        float ax = ax(rf);
        float av = av(rf);
        float az = az(rf);
        float as = as(rf);
        float aw = aw(rf);
        float au = au(rf);
        float ay = ay(rf);
        this.fOY = new AnimatorSet();
        float f = this.fOR ? 1.0f : 0.0f;
        float f2 = this.fOR ? au : av;
        if (!this.fOR) {
            av = au;
        }
        float f3 = this.fOR ? ay : az;
        if (!this.fOR) {
            az = ay;
        }
        float zoomOutScale = this.fOR ? 1.0f : getZoomOutScale();
        float zoomOutScale2 = this.fOR ? getZoomOutScale() : 1.0f;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("alpha", f, 1.0f - f), PropertyValuesHolder.ofFloat("translationX", f2, av), PropertyValuesHolder.ofFloat("translationY", f3, az), PropertyValuesHolder.ofFloat("scaleX", zoomOutScale, zoomOutScale2), PropertyValuesHolder.ofFloat("scaleY", zoomOutScale, zoomOutScale2));
        ofPropertyValuesHolder.setDuration(j);
        this.fOY.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.PbMainFloorPraiseFloatingView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!PbMainFloorPraiseFloatingView.this.fOR) {
                    PbMainFloorPraiseFloatingView.this.setVisibility(8);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < PbMainFloorPraiseFloatingView.this.fOT.size()) {
                            ImageView imageView = (ImageView) PbMainFloorPraiseFloatingView.this.fOT.get(i3);
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
                if (!PbMainFloorPraiseFloatingView.this.fOR) {
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
        if (!this.fOR) {
            this.fOY.play(ofPropertyValuesHolder);
            this.fOY.setInterpolator(this.fPb);
        } else {
            this.fOY.playSequentially(ofPropertyValuesHolder2, ofPropertyValuesHolder3, ofPropertyValuesHolder);
            this.fOY.setInterpolator(this.fPc);
            this.fOY.setDuration(4 + j);
        }
        this.fOY.start();
    }

    public boolean arL() {
        return this.fOR;
    }

    private float getZoomInScale() {
        return this.fOL / this.fOK;
    }

    private float getZoomOutScale() {
        return this.fOJ / this.fOK;
    }

    public void bgy() {
        int i;
        int i2;
        int i3 = 0;
        while (i3 < this.fOT.size()) {
            ImageView imageView = this.fOT.get(i3);
            imageView.setVisibility(0);
            if (!this.fOR) {
                if (i3 == 0) {
                    i = f.b.big_praise;
                } else if (i3 == 1) {
                    com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
                    if (activitySwitch != null && activitySwitch.BJ()) {
                        i2 = f.b.normal_praise_xmas;
                    } else {
                        i2 = f.b.normal_praise;
                    }
                    i = i2;
                } else if (i3 == 2) {
                    i = f.b.normal_trample;
                } else {
                    i = i3 == 3 ? f.b.big_trample : 0;
                }
                if (imageView.getTag() != null && (imageView.getTag() instanceof m)) {
                    ((m) imageView.getTag()).stop();
                    imageView.setTag(null);
                }
                m a = m.a(imageView, i, 20, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                a.b(imageView);
                imageView.setTag(a);
            }
            c(imageView, i3, 200L);
            i3++;
        }
        this.fOR = this.fOR ? false : true;
        invalidate();
    }

    public void bt(int i, int i2) {
        if (!this.fOR) {
            bgA();
            return;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            bgz();
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < this.fOT.size()) {
                ImageView imageView = this.fOT.get(i4);
                imageView.getGlobalVisibleRect(rect);
                if (!rect.contains(i, i2) || this.fOW) {
                    i3 = i4 + 1;
                } else {
                    f(imageView);
                    return;
                }
            } else {
                bgz();
                return;
            }
        }
    }

    public void f(ImageView imageView) {
        if (imageView != null && this.fOS != imageView && !this.fOW) {
            bgA();
            this.fOS = imageView;
            float size = (((this.fOP - this.fOO) / (this.fOT.size() - 1)) * this.fOT.indexOf(imageView)) + this.fOO;
            float zoomInScale = getZoomInScale();
            this.fOZ = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, zoomInScale);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, zoomInScale);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "translationX", imageView.getTranslationX(), at(size));
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "translationY", imageView.getTranslationY(), ax(size));
            if (this.fOT.indexOf(this.fOS) > -1) {
                this.fOU = this.fOV.get(this.fOT.indexOf(this.fOS));
                this.fOU.setVisibility(0);
                this.fOU.setAlpha(0.0f);
            }
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fOU, "alpha", 0.0f, 1.0f);
            this.fOZ.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.fOU, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.fOU, "scaleY", 0.0f, 1.0f));
            this.fOZ.setInterpolator(this.fPc);
            this.fOZ.setDuration(100L);
            this.fOZ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.PbMainFloorPraiseFloatingView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    PbMainFloorPraiseFloatingView.this.fOW = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PbMainFloorPraiseFloatingView.this.fOW = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fOW = true;
            this.fOZ.start();
        }
    }

    public void bgz() {
        if (this.fOS != null && !this.fOW) {
            ImageView imageView = this.fOS;
            float zoomInScale = getZoomInScale();
            this.fPa = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", zoomInScale, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", zoomInScale, 1.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "translationX", imageView.getTranslationX(), 0.0f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "translationY", imageView.getTranslationY(), 0.0f);
            if (this.fOU != null) {
                ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fOU, "alpha", 1.0f, 0.0f);
                this.fPa.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.fOU, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.fOU, "scaleY", 0.0f, 1.0f));
            } else {
                this.fPa.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
            }
            this.fPa.setInterpolator(this.fPc);
            this.fPa.setDuration(100L);
            this.fPa.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.PbMainFloorPraiseFloatingView.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    PbMainFloorPraiseFloatingView.this.fOW = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PbMainFloorPraiseFloatingView.this.fOW = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fOW = true;
            this.fPa.start();
            if (this.fOU != null) {
                this.fOU.setVisibility(4);
            }
            this.fOS = null;
            this.fOU = null;
        }
    }

    public int bu(int i, int i2) {
        if (!this.fOR) {
            bgA();
            return -1;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            bgz();
            return -1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.fOT.size()) {
                return -1;
            }
            this.fOT.get(i4).getGlobalVisibleRect(rect);
            if (!rect.contains(i, i2)) {
                i3 = i4 + 1;
            } else {
                bgz();
                return i4 + 1;
            }
        }
    }

    public void bgA() {
        if (this.fOY != null && this.fOY.isStarted()) {
            this.fOY.cancel();
            this.fOY = null;
        }
        if (this.fOZ != null && this.fOZ.isStarted()) {
            this.fOZ.cancel();
            this.fOZ = null;
        }
        if (this.fPa != null && this.fPa.isStarted()) {
            this.fPa.cancel();
            this.fPa = null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fOT.size()) {
                ImageView imageView = this.fOT.get(i2);
                float rf = rf(i2);
                imageView.setTranslationX(au(rf));
                imageView.setTranslationY(ay(rf));
                imageView.setScaleX(1.0f);
                imageView.setScaleY(1.0f);
                imageView.invalidate();
                TextView textView = this.fOV.get(i2);
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

    private float rf(int i) {
        return (((this.fOP - this.fOO) / (this.fOT.size() - 1)) * i) + this.fOO;
    }
}
