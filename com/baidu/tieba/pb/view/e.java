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
    private int gdV;
    private int gdW;
    private int gdX;
    private int gdY;
    private int gdZ;
    private float gea;
    private float geb;
    private int gec;
    private boolean ged;
    private ImageView gee;
    private List<ImageView> gef;
    private TextView geg;
    private List<TextView> geh;
    private boolean gei;
    private int gej;
    private int gek;
    private AnimatorSet gel;
    private AnimatorSet gem;
    private AnimatorSet gen;
    private Interpolator gep;
    private Interpolator geq;
    private int mRadius;
    private int mScreenWidth;

    public e(Context context) {
        super(context);
        this.gdY = 30;
        this.gdZ = l.t(getContext(), d.e.ds112);
        this.gea = 160.0f;
        this.geb = 20.0f;
        this.ged = false;
        this.gep = new OvershootInterpolator();
        this.geq = new DecelerateInterpolator();
        init();
    }

    private void init() {
        this.gdW = getResources().getDimensionPixelSize(d.e.ds84);
        this.gdX = getResources().getDimensionPixelSize(d.e.ds120);
        this.gdV = getResources().getDimensionPixelSize(d.e.ds36);
        this.gef = new ArrayList();
        for (int i = 0; i < 4; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            this.gef.add(imageView);
            addView(imageView);
        }
        this.geh = new ArrayList();
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
            this.geh.add(textView);
            addView(textView);
        }
        this.mScreenWidth = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        this.gej = l.t(getContext(), d.e.ds70);
        this.gek = l.t(getContext(), d.e.ds52);
    }

    private static Rect a(int i, int i2, int i3, float f, int i4) {
        double cos = i + (i3 * Math.cos(Math.toRadians(f)));
        double sin = i2 - (i3 * Math.sin(Math.toRadians(f)));
        return new Rect((int) (cos - (i4 / 2)), (int) (sin - (i4 / 2)), (int) (cos + (i4 / 2)), (int) (sin + (i4 / 2)));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.mRadius = l.t(getContext(), d.e.ds156);
        this.gec = this.mRadius + ((this.gdX - this.gdW) / 2);
        int i3 = (this.gec * 2) + this.gdX + this.gdY;
        int i4 = this.gec + (this.gdX / 2) + this.gek + this.gdZ;
        if (i3 > this.mScreenWidth) {
            i3 = this.mScreenWidth;
        }
        setMeasuredDimension(i3, i4);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < this.gef.size()) {
                int i7 = this.gdW;
                if (this.gee != null && i6 == this.gef.indexOf(this.gee)) {
                    i7 = this.gdX;
                }
                int i8 = i7;
                this.gef.get(i6).measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
                this.geh.get(i6).measure(View.MeasureSpec.makeMeasureSpec(this.gej, 1073741824), View.MeasureSpec.makeMeasureSpec(this.gek, 1073741824));
                i5 = i6 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth() / 2;
        int height = getHeight() - this.gdZ;
        int i5 = this.ged ? this.mRadius : 0;
        int t = l.t(getContext(), d.e.ds90);
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 < this.gef.size()) {
                float tt = tt(i7);
                Rect a = a(width, height, i5, tt, this.gdW);
                this.gef.get(i7).layout(a.left, a.top, a.right, a.bottom);
                Rect a2 = a(width, height, this.gec, tt, this.gdX);
                float width2 = a2.left + (a2.width() / 2);
                float height2 = ((a2.height() / 2) + a2.top) - t;
                this.geh.get(i7).layout((int) (width2 - (this.gej / 2)), (int) (height2 - (this.gek / 2)), (int) (width2 + (this.gej / 2)), (int) (height2 + (this.gek / 2)));
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
        return (float) (Math.cos(Math.toRadians(f)) * (this.gec - this.mRadius));
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
        return -((float) (Math.sin(Math.toRadians(f)) * (this.gec - this.mRadius)));
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
        this.gel = new AnimatorSet();
        float f = this.ged ? 1.0f : 0.0f;
        float f2 = this.ged ? aw : ax;
        if (!this.ged) {
            ax = aw;
        }
        float f3 = this.ged ? aA : aB;
        if (!this.ged) {
            aB = aA;
        }
        float zoomOutScale = this.ged ? 1.0f : getZoomOutScale();
        float zoomOutScale2 = this.ged ? getZoomOutScale() : 1.0f;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("alpha", f, 1.0f - f), PropertyValuesHolder.ofFloat("translationX", f2, ax), PropertyValuesHolder.ofFloat("translationY", f3, aB), PropertyValuesHolder.ofFloat("scaleX", zoomOutScale, zoomOutScale2), PropertyValuesHolder.ofFloat("scaleY", zoomOutScale, zoomOutScale2));
        ofPropertyValuesHolder.setDuration(j);
        this.gel.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!e.this.ged) {
                    e.this.setVisibility(8);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < e.this.gef.size()) {
                            ImageView imageView = (ImageView) e.this.gef.get(i3);
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
                if (!e.this.ged) {
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
        if (!this.ged) {
            this.gel.play(ofPropertyValuesHolder);
            this.gel.setInterpolator(this.gep);
        } else {
            this.gel.playSequentially(ofPropertyValuesHolder2, ofPropertyValuesHolder3, ofPropertyValuesHolder);
            this.gel.setInterpolator(this.geq);
            this.gel.setDuration(4 + j);
        }
        this.gel.start();
    }

    public boolean atx() {
        return this.ged;
    }

    private float getZoomInScale() {
        return this.gdX / this.gdW;
    }

    private float getZoomOutScale() {
        return this.gdV / this.gdW;
    }

    public void bhE() {
        int i;
        int i2;
        int i3 = 0;
        while (i3 < this.gef.size()) {
            ImageView imageView = this.gef.get(i3);
            imageView.setVisibility(0);
            if (!this.ged) {
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
        this.ged = this.ged ? false : true;
        invalidate();
    }

    public void cr(int i, int i2) {
        if (!this.ged) {
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
            if (i4 < this.gef.size()) {
                ImageView imageView = this.gef.get(i4);
                imageView.getGlobalVisibleRect(rect);
                if (!rect.contains(i, i2) || this.gei) {
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
        if (imageView != null && this.gee != imageView && !this.gei) {
            bhG();
            this.gee = imageView;
            float size = (((this.geb - this.gea) / (this.gef.size() - 1)) * this.gef.indexOf(imageView)) + this.gea;
            float zoomInScale = getZoomInScale();
            this.gem = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, zoomInScale);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, zoomInScale);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "translationX", imageView.getTranslationX(), av(size));
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "translationY", imageView.getTranslationY(), az(size));
            if (this.gef.indexOf(this.gee) > -1) {
                this.geg = this.geh.get(this.gef.indexOf(this.gee));
                this.geg.setVisibility(0);
                this.geg.setAlpha(0.0f);
            }
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.geg, "alpha", 0.0f, 1.0f);
            this.gem.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.geg, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.geg, "scaleY", 0.0f, 1.0f));
            this.gem.setInterpolator(this.geq);
            this.gem.setDuration(100L);
            this.gem.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.gei = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.gei = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.gei = true;
            this.gem.start();
        }
    }

    public void bhF() {
        if (this.gee != null && !this.gei) {
            ImageView imageView = this.gee;
            float zoomInScale = getZoomInScale();
            this.gen = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", zoomInScale, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", zoomInScale, 1.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "translationX", imageView.getTranslationX(), 0.0f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "translationY", imageView.getTranslationY(), 0.0f);
            if (this.geg != null) {
                ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.geg, "alpha", 1.0f, 0.0f);
                this.gen.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.geg, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.geg, "scaleY", 0.0f, 1.0f));
            } else {
                this.gen.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
            }
            this.gen.setInterpolator(this.geq);
            this.gen.setDuration(100L);
            this.gen.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.gei = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.gei = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.gei = true;
            this.gen.start();
            if (this.geg != null) {
                this.geg.setVisibility(4);
            }
            this.gee = null;
            this.geg = null;
        }
    }

    public int cs(int i, int i2) {
        if (!this.ged) {
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
            if (i4 >= this.gef.size()) {
                return -1;
            }
            this.gef.get(i4).getGlobalVisibleRect(rect);
            if (!rect.contains(i, i2)) {
                i3 = i4 + 1;
            } else {
                bhF();
                return i4 + 1;
            }
        }
    }

    public void bhG() {
        if (this.gel != null && this.gel.isStarted()) {
            this.gel.cancel();
            this.gel = null;
        }
        if (this.gem != null && this.gem.isStarted()) {
            this.gem.cancel();
            this.gem = null;
        }
        if (this.gen != null && this.gen.isStarted()) {
            this.gen.cancel();
            this.gen = null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gef.size()) {
                ImageView imageView = this.gef.get(i2);
                float tt = tt(i2);
                imageView.setTranslationX(aw(tt));
                imageView.setTranslationY(aA(tt));
                imageView.setScaleX(1.0f);
                imageView.setScaleY(1.0f);
                imageView.invalidate();
                TextView textView = this.geh.get(i2);
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
        return (((this.geb - this.gea) / (this.gef.size() - 1)) * i) + this.gea;
    }
}
