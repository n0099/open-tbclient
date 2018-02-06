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
    private int gdQ;
    private int gdR;
    private int gdS;
    private int gdT;
    private int gdU;
    private float gdV;
    private float gdW;
    private int gdX;
    private boolean gdY;
    private ImageView gdZ;
    private List<ImageView> gea;
    private TextView geb;
    private List<TextView> gec;
    private boolean ged;
    private int gee;
    private int gef;
    private AnimatorSet geg;
    private AnimatorSet geh;
    private AnimatorSet gei;
    private Interpolator gej;
    private Interpolator gek;
    private int mRadius;
    private int mScreenWidth;

    public e(Context context) {
        super(context);
        this.gdT = 30;
        this.gdU = l.t(getContext(), d.e.ds112);
        this.gdV = 160.0f;
        this.gdW = 20.0f;
        this.gdY = false;
        this.gej = new OvershootInterpolator();
        this.gek = new DecelerateInterpolator();
        init();
    }

    private void init() {
        this.gdR = getResources().getDimensionPixelSize(d.e.ds84);
        this.gdS = getResources().getDimensionPixelSize(d.e.ds120);
        this.gdQ = getResources().getDimensionPixelSize(d.e.ds36);
        this.gea = new ArrayList();
        for (int i = 0; i < 4; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            this.gea.add(imageView);
            addView(imageView);
        }
        this.gec = new ArrayList();
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
            this.gec.add(textView);
            addView(textView);
        }
        this.mScreenWidth = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        this.gee = l.t(getContext(), d.e.ds70);
        this.gef = l.t(getContext(), d.e.ds52);
    }

    private static Rect a(int i, int i2, int i3, float f, int i4) {
        double cos = i + (i3 * Math.cos(Math.toRadians(f)));
        double sin = i2 - (i3 * Math.sin(Math.toRadians(f)));
        return new Rect((int) (cos - (i4 / 2)), (int) (sin - (i4 / 2)), (int) (cos + (i4 / 2)), (int) (sin + (i4 / 2)));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.mRadius = l.t(getContext(), d.e.ds156);
        this.gdX = this.mRadius + ((this.gdS - this.gdR) / 2);
        int i3 = (this.gdX * 2) + this.gdS + this.gdT;
        int i4 = this.gdX + (this.gdS / 2) + this.gef + this.gdU;
        if (i3 > this.mScreenWidth) {
            i3 = this.mScreenWidth;
        }
        setMeasuredDimension(i3, i4);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < this.gea.size()) {
                int i7 = this.gdR;
                if (this.gdZ != null && i6 == this.gea.indexOf(this.gdZ)) {
                    i7 = this.gdS;
                }
                int i8 = i7;
                this.gea.get(i6).measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
                this.gec.get(i6).measure(View.MeasureSpec.makeMeasureSpec(this.gee, 1073741824), View.MeasureSpec.makeMeasureSpec(this.gef, 1073741824));
                i5 = i6 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth() / 2;
        int height = getHeight() - this.gdU;
        int i5 = this.gdY ? this.mRadius : 0;
        int t = l.t(getContext(), d.e.ds90);
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 < this.gea.size()) {
                float ts = ts(i7);
                Rect a = a(width, height, i5, ts, this.gdR);
                this.gea.get(i7).layout(a.left, a.top, a.right, a.bottom);
                Rect a2 = a(width, height, this.gdX, ts, this.gdS);
                float width2 = a2.left + (a2.width() / 2);
                float height2 = ((a2.height() / 2) + a2.top) - t;
                this.gec.get(i7).layout((int) (width2 - (this.gee / 2)), (int) (height2 - (this.gef / 2)), (int) (width2 + (this.gee / 2)), (int) (height2 + (this.gef / 2)));
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
        return (float) (Math.cos(Math.toRadians(f)) * (this.gdX - this.mRadius));
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
        return -((float) (Math.sin(Math.toRadians(f)) * (this.gdX - this.mRadius)));
    }

    private float aA(float f) {
        return 0.0f;
    }

    private float aB(float f) {
        return (float) (Math.sin(Math.toRadians(f)) * this.mRadius);
    }

    private void c(View view, int i, long j) {
        float ts = ts(i);
        float av = av(ts);
        float az = az(ts);
        float ax = ax(ts);
        float aB = aB(ts);
        float au = au(ts);
        float ay = ay(ts);
        float aw = aw(ts);
        float aA = aA(ts);
        this.geg = new AnimatorSet();
        float f = this.gdY ? 1.0f : 0.0f;
        float f2 = this.gdY ? aw : ax;
        if (!this.gdY) {
            ax = aw;
        }
        float f3 = this.gdY ? aA : aB;
        if (!this.gdY) {
            aB = aA;
        }
        float zoomOutScale = this.gdY ? 1.0f : getZoomOutScale();
        float zoomOutScale2 = this.gdY ? getZoomOutScale() : 1.0f;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("alpha", f, 1.0f - f), PropertyValuesHolder.ofFloat("translationX", f2, ax), PropertyValuesHolder.ofFloat("translationY", f3, aB), PropertyValuesHolder.ofFloat("scaleX", zoomOutScale, zoomOutScale2), PropertyValuesHolder.ofFloat("scaleY", zoomOutScale, zoomOutScale2));
        ofPropertyValuesHolder.setDuration(j);
        this.geg.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!e.this.gdY) {
                    e.this.setVisibility(8);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < e.this.gea.size()) {
                            ImageView imageView = (ImageView) e.this.gea.get(i3);
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
                if (!e.this.gdY) {
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
        if (!this.gdY) {
            this.geg.play(ofPropertyValuesHolder);
            this.geg.setInterpolator(this.gej);
        } else {
            this.geg.playSequentially(ofPropertyValuesHolder2, ofPropertyValuesHolder3, ofPropertyValuesHolder);
            this.geg.setInterpolator(this.gek);
            this.geg.setDuration(4 + j);
        }
        this.geg.start();
    }

    public boolean atx() {
        return this.gdY;
    }

    private float getZoomInScale() {
        return this.gdS / this.gdR;
    }

    private float getZoomOutScale() {
        return this.gdQ / this.gdR;
    }

    public void bhE() {
        int i;
        int i2;
        int i3 = 0;
        while (i3 < this.gea.size()) {
            ImageView imageView = this.gea.get(i3);
            imageView.setVisibility(0);
            if (!this.gdY) {
                if (i3 == 0) {
                    i = d.b.big_praise;
                } else if (i3 == 1) {
                    com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
                    if (activitySwitch != null && activitySwitch.Fr()) {
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
        this.gdY = this.gdY ? false : true;
        invalidate();
    }

    public void cr(int i, int i2) {
        if (!this.gdY) {
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
            if (i4 < this.gea.size()) {
                ImageView imageView = this.gea.get(i4);
                imageView.getGlobalVisibleRect(rect);
                if (!rect.contains(i, i2) || this.ged) {
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
        if (imageView != null && this.gdZ != imageView && !this.ged) {
            bhG();
            this.gdZ = imageView;
            float size = (((this.gdW - this.gdV) / (this.gea.size() - 1)) * this.gea.indexOf(imageView)) + this.gdV;
            float zoomInScale = getZoomInScale();
            this.geh = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, zoomInScale);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, zoomInScale);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "translationX", imageView.getTranslationX(), av(size));
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "translationY", imageView.getTranslationY(), az(size));
            if (this.gea.indexOf(this.gdZ) > -1) {
                this.geb = this.gec.get(this.gea.indexOf(this.gdZ));
                this.geb.setVisibility(0);
                this.geb.setAlpha(0.0f);
            }
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.geb, "alpha", 0.0f, 1.0f);
            this.geh.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.geb, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.geb, "scaleY", 0.0f, 1.0f));
            this.geh.setInterpolator(this.gek);
            this.geh.setDuration(100L);
            this.geh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.ged = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.ged = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.ged = true;
            this.geh.start();
        }
    }

    public void bhF() {
        if (this.gdZ != null && !this.ged) {
            ImageView imageView = this.gdZ;
            float zoomInScale = getZoomInScale();
            this.gei = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", zoomInScale, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", zoomInScale, 1.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "translationX", imageView.getTranslationX(), 0.0f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "translationY", imageView.getTranslationY(), 0.0f);
            if (this.geb != null) {
                ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.geb, "alpha", 1.0f, 0.0f);
                this.gei.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.geb, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.geb, "scaleY", 0.0f, 1.0f));
            } else {
                this.gei.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
            }
            this.gei.setInterpolator(this.gek);
            this.gei.setDuration(100L);
            this.gei.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.ged = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.ged = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.ged = true;
            this.gei.start();
            if (this.geb != null) {
                this.geb.setVisibility(4);
            }
            this.gdZ = null;
            this.geb = null;
        }
    }

    public int cs(int i, int i2) {
        if (!this.gdY) {
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
            if (i4 >= this.gea.size()) {
                return -1;
            }
            this.gea.get(i4).getGlobalVisibleRect(rect);
            if (!rect.contains(i, i2)) {
                i3 = i4 + 1;
            } else {
                bhF();
                return i4 + 1;
            }
        }
    }

    public void bhG() {
        if (this.geg != null && this.geg.isStarted()) {
            this.geg.cancel();
            this.geg = null;
        }
        if (this.geh != null && this.geh.isStarted()) {
            this.geh.cancel();
            this.geh = null;
        }
        if (this.gei != null && this.gei.isStarted()) {
            this.gei.cancel();
            this.gei = null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gea.size()) {
                ImageView imageView = this.gea.get(i2);
                float ts = ts(i2);
                imageView.setTranslationX(aw(ts));
                imageView.setTranslationY(aA(ts));
                imageView.setScaleX(1.0f);
                imageView.setScaleY(1.0f);
                imageView.invalidate();
                TextView textView = this.gec.get(i2);
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

    private float ts(int i) {
        return (((this.gdW - this.gdV) / (this.gea.size() - 1)) * i) + this.gdV;
    }
}
