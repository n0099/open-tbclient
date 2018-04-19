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
    private Interpolator fyA;
    private Interpolator fyB;
    private int fyh;
    private int fyi;
    private int fyj;
    private int fyk;
    private int fyl;
    private float fym;
    private float fyn;
    private int fyo;
    private boolean fyp;
    private ImageView fyq;
    private List<ImageView> fyr;
    private TextView fys;
    private List<TextView> fyt;
    private boolean fyu;
    private int fyv;
    private int fyw;
    private AnimatorSet fyx;
    private AnimatorSet fyy;
    private AnimatorSet fyz;
    private int mRadius;
    private int mScreenWidth;

    public PbMainFloorPraiseFloatingView(Context context) {
        super(context);
        this.fyk = 30;
        this.fyl = l.e(getContext(), d.e.ds112);
        this.fym = 160.0f;
        this.fyn = 20.0f;
        this.fyp = false;
        this.fyA = new OvershootInterpolator();
        this.fyB = new DecelerateInterpolator();
        init();
    }

    public PbMainFloorPraiseFloatingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fyk = 30;
        this.fyl = l.e(getContext(), d.e.ds112);
        this.fym = 160.0f;
        this.fyn = 20.0f;
        this.fyp = false;
        this.fyA = new OvershootInterpolator();
        this.fyB = new DecelerateInterpolator();
        init();
    }

    private void init() {
        this.fyi = getResources().getDimensionPixelSize(d.e.ds84);
        this.fyj = getResources().getDimensionPixelSize(d.e.ds120);
        this.fyh = getResources().getDimensionPixelSize(d.e.ds36);
        this.fyr = new ArrayList();
        for (int i = 0; i < 4; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            this.fyr.add(imageView);
            addView(imageView);
        }
        this.fyt = new ArrayList();
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
            this.fyt.add(textView);
            addView(textView);
        }
        this.mScreenWidth = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        this.fyv = l.e(getContext(), d.e.ds70);
        this.fyw = l.e(getContext(), d.e.ds52);
    }

    private static Rect a(int i, int i2, int i3, float f, int i4) {
        double cos = i + (i3 * Math.cos(Math.toRadians(f)));
        double sin = i2 - (i3 * Math.sin(Math.toRadians(f)));
        return new Rect((int) (cos - (i4 / 2)), (int) (sin - (i4 / 2)), (int) (cos + (i4 / 2)), (int) (sin + (i4 / 2)));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.mRadius = l.e(getContext(), d.e.ds156);
        this.fyo = this.mRadius + ((this.fyj - this.fyi) / 2);
        int i3 = (this.fyo * 2) + this.fyj + this.fyk;
        int i4 = this.fyo + (this.fyj / 2) + this.fyw + this.fyl;
        if (i3 > this.mScreenWidth) {
            i3 = this.mScreenWidth;
        }
        setMeasuredDimension(i3, i4);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < this.fyr.size()) {
                int i7 = this.fyi;
                if (this.fyq != null && i6 == this.fyr.indexOf(this.fyq)) {
                    i7 = this.fyj;
                }
                int i8 = i7;
                this.fyr.get(i6).measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
                this.fyt.get(i6).measure(View.MeasureSpec.makeMeasureSpec(this.fyv, 1073741824), View.MeasureSpec.makeMeasureSpec(this.fyw, 1073741824));
                i5 = i6 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth() / 2;
        int height = getHeight() - this.fyl;
        int i5 = this.fyp ? this.mRadius : 0;
        int e = l.e(getContext(), d.e.ds90);
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 < this.fyr.size()) {
                float qP = qP(i7);
                Rect a = a(width, height, i5, qP, this.fyi);
                this.fyr.get(i7).layout(a.left, a.top, a.right, a.bottom);
                Rect a2 = a(width, height, this.fyo, qP, this.fyj);
                float width2 = a2.left + (a2.width() / 2);
                float height2 = ((a2.height() / 2) + a2.top) - e;
                this.fyt.get(i7).layout((int) (width2 - (this.fyv / 2)), (int) (height2 - (this.fyw / 2)), (int) (width2 + (this.fyv / 2)), (int) (height2 + (this.fyw / 2)));
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
        return (float) (Math.cos(Math.toRadians(f)) * (this.fyo - this.mRadius));
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
        return -((float) (Math.sin(Math.toRadians(f)) * (this.fyo - this.mRadius)));
    }

    private float ao(float f) {
        return 0.0f;
    }

    private float ap(float f) {
        return (float) (Math.sin(Math.toRadians(f)) * this.mRadius);
    }

    private void f(View view2, int i, long j) {
        float qP = qP(i);
        float aj = aj(qP);
        float an = an(qP);
        float al = al(qP);
        float ap = ap(qP);
        float ai = ai(qP);
        float am = am(qP);
        float ak = ak(qP);
        float ao = ao(qP);
        this.fyx = new AnimatorSet();
        float f = this.fyp ? 1.0f : 0.0f;
        float f2 = this.fyp ? ak : al;
        if (!this.fyp) {
            al = ak;
        }
        float f3 = this.fyp ? ao : ap;
        if (!this.fyp) {
            ap = ao;
        }
        float zoomOutScale = this.fyp ? 1.0f : getZoomOutScale();
        float zoomOutScale2 = this.fyp ? getZoomOutScale() : 1.0f;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view2, PropertyValuesHolder.ofFloat("alpha", f, 1.0f - f), PropertyValuesHolder.ofFloat("translationX", f2, al), PropertyValuesHolder.ofFloat("translationY", f3, ap), PropertyValuesHolder.ofFloat("scaleX", zoomOutScale, zoomOutScale2), PropertyValuesHolder.ofFloat("scaleY", zoomOutScale, zoomOutScale2));
        ofPropertyValuesHolder.setDuration(j);
        this.fyx.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.PbMainFloorPraiseFloatingView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!PbMainFloorPraiseFloatingView.this.fyp) {
                    PbMainFloorPraiseFloatingView.this.setVisibility(8);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < PbMainFloorPraiseFloatingView.this.fyr.size()) {
                            ImageView imageView = (ImageView) PbMainFloorPraiseFloatingView.this.fyr.get(i3);
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
                if (!PbMainFloorPraiseFloatingView.this.fyp) {
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
        if (!this.fyp) {
            this.fyx.play(ofPropertyValuesHolder);
            this.fyx.setInterpolator(this.fyA);
        } else {
            this.fyx.playSequentially(ofPropertyValuesHolder2, ofPropertyValuesHolder3, ofPropertyValuesHolder);
            this.fyx.setInterpolator(this.fyB);
            this.fyx.setDuration(4 + j);
        }
        this.fyx.start();
    }

    public boolean anM() {
        return this.fyp;
    }

    private float getZoomInScale() {
        return this.fyj / this.fyi;
    }

    private float getZoomOutScale() {
        return this.fyh / this.fyi;
    }

    public void bcE() {
        int i;
        int i2;
        int i3 = 0;
        while (i3 < this.fyr.size()) {
            ImageView imageView = this.fyr.get(i3);
            imageView.setVisibility(0);
            if (!this.fyp) {
                if (i3 == 0) {
                    i = d.b.big_praise;
                } else if (i3 == 1) {
                    com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
                    if (activitySwitch != null && activitySwitch.ye()) {
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
        this.fyp = this.fyp ? false : true;
        invalidate();
    }

    public void bs(int i, int i2) {
        if (!this.fyp) {
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
            if (i4 < this.fyr.size()) {
                ImageView imageView = this.fyr.get(i4);
                imageView.getGlobalVisibleRect(rect);
                if (!rect.contains(i, i2) || this.fyu) {
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
        if (imageView != null && this.fyq != imageView && !this.fyu) {
            bcG();
            this.fyq = imageView;
            float size = (((this.fyn - this.fym) / (this.fyr.size() - 1)) * this.fyr.indexOf(imageView)) + this.fym;
            float zoomInScale = getZoomInScale();
            this.fyy = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, zoomInScale);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, zoomInScale);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "translationX", imageView.getTranslationX(), aj(size));
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "translationY", imageView.getTranslationY(), an(size));
            if (this.fyr.indexOf(this.fyq) > -1) {
                this.fys = this.fyt.get(this.fyr.indexOf(this.fyq));
                this.fys.setVisibility(0);
                this.fys.setAlpha(0.0f);
            }
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fys, "alpha", 0.0f, 1.0f);
            this.fyy.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.fys, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.fys, "scaleY", 0.0f, 1.0f));
            this.fyy.setInterpolator(this.fyB);
            this.fyy.setDuration(100L);
            this.fyy.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.PbMainFloorPraiseFloatingView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    PbMainFloorPraiseFloatingView.this.fyu = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PbMainFloorPraiseFloatingView.this.fyu = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fyu = true;
            this.fyy.start();
        }
    }

    public void bcF() {
        if (this.fyq != null && !this.fyu) {
            ImageView imageView = this.fyq;
            float zoomInScale = getZoomInScale();
            this.fyz = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", zoomInScale, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", zoomInScale, 1.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "translationX", imageView.getTranslationX(), 0.0f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "translationY", imageView.getTranslationY(), 0.0f);
            if (this.fys != null) {
                ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fys, "alpha", 1.0f, 0.0f);
                this.fyz.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.fys, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.fys, "scaleY", 0.0f, 1.0f));
            } else {
                this.fyz.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
            }
            this.fyz.setInterpolator(this.fyB);
            this.fyz.setDuration(100L);
            this.fyz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.PbMainFloorPraiseFloatingView.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    PbMainFloorPraiseFloatingView.this.fyu = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PbMainFloorPraiseFloatingView.this.fyu = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fyu = true;
            this.fyz.start();
            if (this.fys != null) {
                this.fys.setVisibility(4);
            }
            this.fyq = null;
            this.fys = null;
        }
    }

    public int bt(int i, int i2) {
        if (!this.fyp) {
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
            if (i4 >= this.fyr.size()) {
                return -1;
            }
            this.fyr.get(i4).getGlobalVisibleRect(rect);
            if (!rect.contains(i, i2)) {
                i3 = i4 + 1;
            } else {
                bcF();
                return i4 + 1;
            }
        }
    }

    public void bcG() {
        if (this.fyx != null && this.fyx.isStarted()) {
            this.fyx.cancel();
            this.fyx = null;
        }
        if (this.fyy != null && this.fyy.isStarted()) {
            this.fyy.cancel();
            this.fyy = null;
        }
        if (this.fyz != null && this.fyz.isStarted()) {
            this.fyz.cancel();
            this.fyz = null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fyr.size()) {
                ImageView imageView = this.fyr.get(i2);
                float qP = qP(i2);
                imageView.setTranslationX(ak(qP));
                imageView.setTranslationY(ao(qP));
                imageView.setScaleX(1.0f);
                imageView.setScaleY(1.0f);
                imageView.invalidate();
                TextView textView = this.fyt.get(i2);
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

    private float qP(int i) {
        return (((this.fyn - this.fym) / (this.fyr.size() - 1)) * i) + this.fym;
    }
}
