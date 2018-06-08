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
    private int fKF;
    private int fKG;
    private int fKH;
    private int fKI;
    private int fKJ;
    private float fKK;
    private float fKL;
    private int fKM;
    private boolean fKN;
    private ImageView fKO;
    private List<ImageView> fKP;
    private TextView fKQ;
    private List<TextView> fKR;
    private boolean fKS;
    private int fKT;
    private int fKU;
    private AnimatorSet fKV;
    private AnimatorSet fKW;
    private AnimatorSet fKX;
    private Interpolator fKY;
    private Interpolator fKZ;
    private int mRadius;
    private int mScreenWidth;

    public PbMainFloorPraiseFloatingView(Context context) {
        super(context);
        this.fKI = 30;
        this.fKJ = l.e(getContext(), d.e.ds112);
        this.fKK = 160.0f;
        this.fKL = 20.0f;
        this.fKN = false;
        this.fKY = new OvershootInterpolator();
        this.fKZ = new DecelerateInterpolator();
        init();
    }

    public PbMainFloorPraiseFloatingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fKI = 30;
        this.fKJ = l.e(getContext(), d.e.ds112);
        this.fKK = 160.0f;
        this.fKL = 20.0f;
        this.fKN = false;
        this.fKY = new OvershootInterpolator();
        this.fKZ = new DecelerateInterpolator();
        init();
    }

    private void init() {
        this.fKG = getResources().getDimensionPixelSize(d.e.ds84);
        this.fKH = getResources().getDimensionPixelSize(d.e.ds120);
        this.fKF = getResources().getDimensionPixelSize(d.e.ds36);
        this.fKP = new ArrayList();
        for (int i = 0; i < 4; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            this.fKP.add(imageView);
            addView(imageView);
        }
        this.fKR = new ArrayList();
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
            this.fKR.add(textView);
            addView(textView);
        }
        this.mScreenWidth = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        this.fKT = l.e(getContext(), d.e.ds70);
        this.fKU = l.e(getContext(), d.e.ds52);
    }

    private static Rect a(int i, int i2, int i3, float f, int i4) {
        double cos = i + (i3 * Math.cos(Math.toRadians(f)));
        double sin = i2 - (i3 * Math.sin(Math.toRadians(f)));
        return new Rect((int) (cos - (i4 / 2)), (int) (sin - (i4 / 2)), (int) (cos + (i4 / 2)), (int) (sin + (i4 / 2)));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.mRadius = l.e(getContext(), d.e.ds156);
        this.fKM = this.mRadius + ((this.fKH - this.fKG) / 2);
        int i3 = (this.fKM * 2) + this.fKH + this.fKI;
        int i4 = this.fKM + (this.fKH / 2) + this.fKU + this.fKJ;
        if (i3 > this.mScreenWidth) {
            i3 = this.mScreenWidth;
        }
        setMeasuredDimension(i3, i4);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < this.fKP.size()) {
                int i7 = this.fKG;
                if (this.fKO != null && i6 == this.fKP.indexOf(this.fKO)) {
                    i7 = this.fKH;
                }
                int i8 = i7;
                this.fKP.get(i6).measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
                this.fKR.get(i6).measure(View.MeasureSpec.makeMeasureSpec(this.fKT, 1073741824), View.MeasureSpec.makeMeasureSpec(this.fKU, 1073741824));
                i5 = i6 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth() / 2;
        int height = getHeight() - this.fKJ;
        int i5 = this.fKN ? this.mRadius : 0;
        int e = l.e(getContext(), d.e.ds90);
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 < this.fKP.size()) {
                float ra = ra(i7);
                Rect a = a(width, height, i5, ra, this.fKG);
                this.fKP.get(i7).layout(a.left, a.top, a.right, a.bottom);
                Rect a2 = a(width, height, this.fKM, ra, this.fKH);
                float width2 = a2.left + (a2.width() / 2);
                float height2 = ((a2.height() / 2) + a2.top) - e;
                this.fKR.get(i7).layout((int) (width2 - (this.fKT / 2)), (int) (height2 - (this.fKU / 2)), (int) (width2 + (this.fKT / 2)), (int) (height2 + (this.fKU / 2)));
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
        return (float) (Math.cos(Math.toRadians(f)) * (this.fKM - this.mRadius));
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
        return -((float) (Math.sin(Math.toRadians(f)) * (this.fKM - this.mRadius)));
    }

    private float ay(float f) {
        return 0.0f;
    }

    private float az(float f) {
        return (float) (Math.sin(Math.toRadians(f)) * this.mRadius);
    }

    private void f(View view, int i, long j) {
        float ra = ra(i);
        float at = at(ra);
        float ax = ax(ra);
        float av = av(ra);
        float az = az(ra);
        float as = as(ra);
        float aw = aw(ra);
        float au = au(ra);
        float ay = ay(ra);
        this.fKV = new AnimatorSet();
        float f = this.fKN ? 1.0f : 0.0f;
        float f2 = this.fKN ? au : av;
        if (!this.fKN) {
            av = au;
        }
        float f3 = this.fKN ? ay : az;
        if (!this.fKN) {
            az = ay;
        }
        float zoomOutScale = this.fKN ? 1.0f : getZoomOutScale();
        float zoomOutScale2 = this.fKN ? getZoomOutScale() : 1.0f;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("alpha", f, 1.0f - f), PropertyValuesHolder.ofFloat("translationX", f2, av), PropertyValuesHolder.ofFloat("translationY", f3, az), PropertyValuesHolder.ofFloat("scaleX", zoomOutScale, zoomOutScale2), PropertyValuesHolder.ofFloat("scaleY", zoomOutScale, zoomOutScale2));
        ofPropertyValuesHolder.setDuration(j);
        this.fKV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.PbMainFloorPraiseFloatingView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!PbMainFloorPraiseFloatingView.this.fKN) {
                    PbMainFloorPraiseFloatingView.this.setVisibility(8);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < PbMainFloorPraiseFloatingView.this.fKP.size()) {
                            ImageView imageView = (ImageView) PbMainFloorPraiseFloatingView.this.fKP.get(i3);
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
                if (!PbMainFloorPraiseFloatingView.this.fKN) {
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
        if (!this.fKN) {
            this.fKV.play(ofPropertyValuesHolder);
            this.fKV.setInterpolator(this.fKY);
        } else {
            this.fKV.playSequentially(ofPropertyValuesHolder2, ofPropertyValuesHolder3, ofPropertyValuesHolder);
            this.fKV.setInterpolator(this.fKZ);
            this.fKV.setDuration(4 + j);
        }
        this.fKV.start();
    }

    public boolean arQ() {
        return this.fKN;
    }

    private float getZoomInScale() {
        return this.fKH / this.fKG;
    }

    private float getZoomOutScale() {
        return this.fKF / this.fKG;
    }

    public void bhE() {
        int i;
        int i2;
        int i3 = 0;
        while (i3 < this.fKP.size()) {
            ImageView imageView = this.fKP.get(i3);
            imageView.setVisibility(0);
            if (!this.fKN) {
                if (i3 == 0) {
                    i = d.b.big_praise;
                } else if (i3 == 1) {
                    com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
                    if (activitySwitch != null && activitySwitch.BD()) {
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
        this.fKN = this.fKN ? false : true;
        invalidate();
    }

    public void bt(int i, int i2) {
        if (!this.fKN) {
            bhG();
            return;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            bhF();
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < this.fKP.size()) {
                ImageView imageView = this.fKP.get(i4);
                imageView.getGlobalVisibleRect(rect);
                if (!rect.contains(i, i2) || this.fKS) {
                    i3 = i4 + 1;
                } else {
                    f(imageView);
                    return;
                }
            } else {
                bhF();
                return;
            }
        }
    }

    public void f(ImageView imageView) {
        if (imageView != null && this.fKO != imageView && !this.fKS) {
            bhG();
            this.fKO = imageView;
            float size = (((this.fKL - this.fKK) / (this.fKP.size() - 1)) * this.fKP.indexOf(imageView)) + this.fKK;
            float zoomInScale = getZoomInScale();
            this.fKW = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, zoomInScale);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, zoomInScale);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "translationX", imageView.getTranslationX(), at(size));
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "translationY", imageView.getTranslationY(), ax(size));
            if (this.fKP.indexOf(this.fKO) > -1) {
                this.fKQ = this.fKR.get(this.fKP.indexOf(this.fKO));
                this.fKQ.setVisibility(0);
                this.fKQ.setAlpha(0.0f);
            }
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fKQ, "alpha", 0.0f, 1.0f);
            this.fKW.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.fKQ, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.fKQ, "scaleY", 0.0f, 1.0f));
            this.fKW.setInterpolator(this.fKZ);
            this.fKW.setDuration(100L);
            this.fKW.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.PbMainFloorPraiseFloatingView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    PbMainFloorPraiseFloatingView.this.fKS = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PbMainFloorPraiseFloatingView.this.fKS = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fKS = true;
            this.fKW.start();
        }
    }

    public void bhF() {
        if (this.fKO != null && !this.fKS) {
            ImageView imageView = this.fKO;
            float zoomInScale = getZoomInScale();
            this.fKX = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", zoomInScale, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", zoomInScale, 1.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "translationX", imageView.getTranslationX(), 0.0f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "translationY", imageView.getTranslationY(), 0.0f);
            if (this.fKQ != null) {
                ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fKQ, "alpha", 1.0f, 0.0f);
                this.fKX.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.fKQ, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.fKQ, "scaleY", 0.0f, 1.0f));
            } else {
                this.fKX.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
            }
            this.fKX.setInterpolator(this.fKZ);
            this.fKX.setDuration(100L);
            this.fKX.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.PbMainFloorPraiseFloatingView.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    PbMainFloorPraiseFloatingView.this.fKS = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PbMainFloorPraiseFloatingView.this.fKS = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fKS = true;
            this.fKX.start();
            if (this.fKQ != null) {
                this.fKQ.setVisibility(4);
            }
            this.fKO = null;
            this.fKQ = null;
        }
    }

    public int bu(int i, int i2) {
        if (!this.fKN) {
            bhG();
            return -1;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            bhF();
            return -1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.fKP.size()) {
                return -1;
            }
            this.fKP.get(i4).getGlobalVisibleRect(rect);
            if (!rect.contains(i, i2)) {
                i3 = i4 + 1;
            } else {
                bhF();
                return i4 + 1;
            }
        }
    }

    public void bhG() {
        if (this.fKV != null && this.fKV.isStarted()) {
            this.fKV.cancel();
            this.fKV = null;
        }
        if (this.fKW != null && this.fKW.isStarted()) {
            this.fKW.cancel();
            this.fKW = null;
        }
        if (this.fKX != null && this.fKX.isStarted()) {
            this.fKX.cancel();
            this.fKX = null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fKP.size()) {
                ImageView imageView = this.fKP.get(i2);
                float ra = ra(i2);
                imageView.setTranslationX(au(ra));
                imageView.setTranslationY(ay(ra));
                imageView.setScaleX(1.0f);
                imageView.setScaleY(1.0f);
                imageView.invalidate();
                TextView textView = this.fKR.get(i2);
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

    private float ra(int i) {
        return (((this.fKL - this.fKK) / (this.fKP.size() - 1)) * i) + this.fKK;
    }
}
