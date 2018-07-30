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
    private int dkD;
    private int fOQ;
    private int fOR;
    private int fOS;
    private int fOT;
    private int fOU;
    private float fOV;
    private float fOW;
    private int fOX;
    private boolean fOY;
    private ImageView fOZ;
    private List<ImageView> fPa;
    private TextView fPb;
    private List<TextView> fPc;
    private boolean fPd;
    private int fPe;
    private int fPf;
    private AnimatorSet fPg;
    private AnimatorSet fPh;
    private AnimatorSet fPi;
    private Interpolator fPj;
    private Interpolator fPk;
    private int mScreenWidth;

    public PbMainFloorPraiseFloatingView(Context context) {
        super(context);
        this.fOT = 30;
        this.fOU = l.f(getContext(), d.e.ds112);
        this.fOV = 160.0f;
        this.fOW = 20.0f;
        this.fOY = false;
        this.fPj = new OvershootInterpolator();
        this.fPk = new DecelerateInterpolator();
        init();
    }

    public PbMainFloorPraiseFloatingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fOT = 30;
        this.fOU = l.f(getContext(), d.e.ds112);
        this.fOV = 160.0f;
        this.fOW = 20.0f;
        this.fOY = false;
        this.fPj = new OvershootInterpolator();
        this.fPk = new DecelerateInterpolator();
        init();
    }

    private void init() {
        this.fOR = getResources().getDimensionPixelSize(d.e.ds84);
        this.fOS = getResources().getDimensionPixelSize(d.e.ds120);
        this.fOQ = getResources().getDimensionPixelSize(d.e.ds36);
        this.fPa = new ArrayList();
        for (int i = 0; i < 4; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            this.fPa.add(imageView);
            addView(imageView);
        }
        this.fPc = new ArrayList();
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
            this.fPc.add(textView);
            addView(textView);
        }
        this.mScreenWidth = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        this.fPe = l.f(getContext(), d.e.ds70);
        this.fPf = l.f(getContext(), d.e.ds52);
    }

    private static Rect a(int i, int i2, int i3, float f, int i4) {
        double cos = i + (i3 * Math.cos(Math.toRadians(f)));
        double sin = i2 - (i3 * Math.sin(Math.toRadians(f)));
        return new Rect((int) (cos - (i4 / 2)), (int) (sin - (i4 / 2)), (int) (cos + (i4 / 2)), (int) (sin + (i4 / 2)));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.dkD = l.f(getContext(), d.e.ds156);
        this.fOX = this.dkD + ((this.fOS - this.fOR) / 2);
        int i3 = (this.fOX * 2) + this.fOS + this.fOT;
        int i4 = this.fOX + (this.fOS / 2) + this.fPf + this.fOU;
        if (i3 > this.mScreenWidth) {
            i3 = this.mScreenWidth;
        }
        setMeasuredDimension(i3, i4);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < this.fPa.size()) {
                int i7 = this.fOR;
                if (this.fOZ != null && i6 == this.fPa.indexOf(this.fOZ)) {
                    i7 = this.fOS;
                }
                int i8 = i7;
                this.fPa.get(i6).measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
                this.fPc.get(i6).measure(View.MeasureSpec.makeMeasureSpec(this.fPe, 1073741824), View.MeasureSpec.makeMeasureSpec(this.fPf, 1073741824));
                i5 = i6 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth() / 2;
        int height = getHeight() - this.fOU;
        int i5 = this.fOY ? this.dkD : 0;
        int f = l.f(getContext(), d.e.ds90);
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 < this.fPa.size()) {
                float rf = rf(i7);
                Rect a = a(width, height, i5, rf, this.fOR);
                this.fPa.get(i7).layout(a.left, a.top, a.right, a.bottom);
                Rect a2 = a(width, height, this.fOX, rf, this.fOS);
                float width2 = a2.left + (a2.width() / 2);
                float height2 = ((a2.height() / 2) + a2.top) - f;
                this.fPc.get(i7).layout((int) (width2 - (this.fPe / 2)), (int) (height2 - (this.fPf / 2)), (int) (width2 + (this.fPe / 2)), (int) (height2 + (this.fPf / 2)));
                i6 = i7 + 1;
            } else {
                return;
            }
        }
    }

    private float at(float f) {
        return (float) (Math.cos(Math.toRadians(f)) * 10.0d);
    }

    private float au(float f) {
        return (float) (Math.cos(Math.toRadians(f)) * (this.fOX - this.dkD));
    }

    private float av(float f) {
        return 0.0f;
    }

    private float aw(float f) {
        return (float) (Math.cos(Math.toRadians(f)) * (-this.dkD));
    }

    private float ax(float f) {
        return -((float) (Math.sin(Math.toRadians(f)) * 10.0d));
    }

    private float ay(float f) {
        return -((float) (Math.sin(Math.toRadians(f)) * (this.fOX - this.dkD)));
    }

    private float az(float f) {
        return 0.0f;
    }

    private float aA(float f) {
        return (float) (Math.sin(Math.toRadians(f)) * this.dkD);
    }

    private void c(View view, int i, long j) {
        float rf = rf(i);
        float au = au(rf);
        float ay = ay(rf);
        float aw = aw(rf);
        float aA = aA(rf);
        float at = at(rf);
        float ax = ax(rf);
        float av = av(rf);
        float az = az(rf);
        this.fPg = new AnimatorSet();
        float f = this.fOY ? 1.0f : 0.0f;
        float f2 = this.fOY ? av : aw;
        if (!this.fOY) {
            aw = av;
        }
        float f3 = this.fOY ? az : aA;
        if (!this.fOY) {
            aA = az;
        }
        float zoomOutScale = this.fOY ? 1.0f : getZoomOutScale();
        float zoomOutScale2 = this.fOY ? getZoomOutScale() : 1.0f;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("alpha", f, 1.0f - f), PropertyValuesHolder.ofFloat("translationX", f2, aw), PropertyValuesHolder.ofFloat("translationY", f3, aA), PropertyValuesHolder.ofFloat("scaleX", zoomOutScale, zoomOutScale2), PropertyValuesHolder.ofFloat("scaleY", zoomOutScale, zoomOutScale2));
        ofPropertyValuesHolder.setDuration(j);
        this.fPg.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.PbMainFloorPraiseFloatingView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!PbMainFloorPraiseFloatingView.this.fOY) {
                    PbMainFloorPraiseFloatingView.this.setVisibility(8);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < PbMainFloorPraiseFloatingView.this.fPa.size()) {
                            ImageView imageView = (ImageView) PbMainFloorPraiseFloatingView.this.fPa.get(i3);
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
                if (!PbMainFloorPraiseFloatingView.this.fOY) {
                    PbMainFloorPraiseFloatingView.this.setVisibility(8);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("translationX", au, at), PropertyValuesHolder.ofFloat("translationY", ay, ax));
        ofPropertyValuesHolder2.setDuration(2L);
        ObjectAnimator ofPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("translationX", at, au), PropertyValuesHolder.ofFloat("translationY", ax, ay));
        ofPropertyValuesHolder3.setDuration(2L);
        if (!this.fOY) {
            this.fPg.play(ofPropertyValuesHolder);
            this.fPg.setInterpolator(this.fPj);
        } else {
            this.fPg.playSequentially(ofPropertyValuesHolder2, ofPropertyValuesHolder3, ofPropertyValuesHolder);
            this.fPg.setInterpolator(this.fPk);
            this.fPg.setDuration(4 + j);
        }
        this.fPg.start();
    }

    public boolean arL() {
        return this.fOY;
    }

    private float getZoomInScale() {
        return this.fOS / this.fOR;
    }

    private float getZoomOutScale() {
        return this.fOQ / this.fOR;
    }

    public void bgD() {
        int i;
        int i2;
        int i3 = 0;
        while (i3 < this.fPa.size()) {
            ImageView imageView = this.fPa.get(i3);
            imageView.setVisibility(0);
            if (!this.fOY) {
                if (i3 == 0) {
                    i = d.b.big_praise;
                } else if (i3 == 1) {
                    com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
                    if (activitySwitch != null && activitySwitch.BM()) {
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
            c(imageView, i3, 200L);
            i3++;
        }
        this.fOY = this.fOY ? false : true;
        invalidate();
    }

    public void bt(int i, int i2) {
        if (!this.fOY) {
            bgF();
            return;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            bgE();
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < this.fPa.size()) {
                ImageView imageView = this.fPa.get(i4);
                imageView.getGlobalVisibleRect(rect);
                if (!rect.contains(i, i2) || this.fPd) {
                    i3 = i4 + 1;
                } else {
                    f(imageView);
                    return;
                }
            } else {
                bgE();
                return;
            }
        }
    }

    public void f(ImageView imageView) {
        if (imageView != null && this.fOZ != imageView && !this.fPd) {
            bgF();
            this.fOZ = imageView;
            float size = (((this.fOW - this.fOV) / (this.fPa.size() - 1)) * this.fPa.indexOf(imageView)) + this.fOV;
            float zoomInScale = getZoomInScale();
            this.fPh = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, zoomInScale);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, zoomInScale);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "translationX", imageView.getTranslationX(), au(size));
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "translationY", imageView.getTranslationY(), ay(size));
            if (this.fPa.indexOf(this.fOZ) > -1) {
                this.fPb = this.fPc.get(this.fPa.indexOf(this.fOZ));
                this.fPb.setVisibility(0);
                this.fPb.setAlpha(0.0f);
            }
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fPb, "alpha", 0.0f, 1.0f);
            this.fPh.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.fPb, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.fPb, "scaleY", 0.0f, 1.0f));
            this.fPh.setInterpolator(this.fPk);
            this.fPh.setDuration(100L);
            this.fPh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.PbMainFloorPraiseFloatingView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    PbMainFloorPraiseFloatingView.this.fPd = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PbMainFloorPraiseFloatingView.this.fPd = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fPd = true;
            this.fPh.start();
        }
    }

    public void bgE() {
        if (this.fOZ != null && !this.fPd) {
            ImageView imageView = this.fOZ;
            float zoomInScale = getZoomInScale();
            this.fPi = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", zoomInScale, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", zoomInScale, 1.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "translationX", imageView.getTranslationX(), 0.0f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "translationY", imageView.getTranslationY(), 0.0f);
            if (this.fPb != null) {
                ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fPb, "alpha", 1.0f, 0.0f);
                this.fPi.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.fPb, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.fPb, "scaleY", 0.0f, 1.0f));
            } else {
                this.fPi.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
            }
            this.fPi.setInterpolator(this.fPk);
            this.fPi.setDuration(100L);
            this.fPi.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.PbMainFloorPraiseFloatingView.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    PbMainFloorPraiseFloatingView.this.fPd = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PbMainFloorPraiseFloatingView.this.fPd = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fPd = true;
            this.fPi.start();
            if (this.fPb != null) {
                this.fPb.setVisibility(4);
            }
            this.fOZ = null;
            this.fPb = null;
        }
    }

    public int bu(int i, int i2) {
        if (!this.fOY) {
            bgF();
            return -1;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            bgE();
            return -1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.fPa.size()) {
                return -1;
            }
            this.fPa.get(i4).getGlobalVisibleRect(rect);
            if (!rect.contains(i, i2)) {
                i3 = i4 + 1;
            } else {
                bgE();
                return i4 + 1;
            }
        }
    }

    public void bgF() {
        if (this.fPg != null && this.fPg.isStarted()) {
            this.fPg.cancel();
            this.fPg = null;
        }
        if (this.fPh != null && this.fPh.isStarted()) {
            this.fPh.cancel();
            this.fPh = null;
        }
        if (this.fPi != null && this.fPi.isStarted()) {
            this.fPi.cancel();
            this.fPi = null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fPa.size()) {
                ImageView imageView = this.fPa.get(i2);
                float rf = rf(i2);
                imageView.setTranslationX(av(rf));
                imageView.setTranslationY(az(rf));
                imageView.setScaleX(1.0f);
                imageView.setScaleY(1.0f);
                imageView.invalidate();
                TextView textView = this.fPc.get(i2);
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
        return (((this.fOW - this.fOV) / (this.fPa.size() - 1)) * i) + this.fOV;
    }
}
