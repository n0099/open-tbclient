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
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e extends ViewGroup {
    private int fkP;
    private int fkQ;
    private int fkR;
    private int fkS;
    private int fkT;
    private float fkU;
    private float fkV;
    private int fkW;
    private boolean fkX;
    private ImageView fkY;
    private List<ImageView> fkZ;
    private TextView fla;
    private List<TextView> flb;
    private boolean flc;
    private int fld;
    private int fle;
    private AnimatorSet flf;
    private AnimatorSet flg;
    private AnimatorSet flh;
    private Interpolator fli;
    private Interpolator flj;
    private int mRadius;
    private int mScreenWidth;

    public e(Context context) {
        super(context);
        this.fkS = 30;
        this.fkT = l.f(getContext(), d.e.ds112);
        this.fkU = 160.0f;
        this.fkV = 20.0f;
        this.fkX = false;
        this.fli = new OvershootInterpolator();
        this.flj = new DecelerateInterpolator();
        init();
    }

    private void init() {
        this.fkQ = getResources().getDimensionPixelSize(d.e.ds84);
        this.fkR = getResources().getDimensionPixelSize(d.e.ds120);
        this.fkP = getResources().getDimensionPixelSize(d.e.ds36);
        this.fkZ = new ArrayList();
        for (int i = 0; i < 4; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            this.fkZ.add(imageView);
            addView(imageView);
        }
        this.flb = new ArrayList();
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
            this.flb.add(textView);
            addView(textView);
        }
        this.mScreenWidth = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        this.fld = l.f(getContext(), d.e.ds70);
        this.fle = l.f(getContext(), d.e.ds52);
    }

    private static Rect a(int i, int i2, int i3, float f, int i4) {
        double cos = i + (i3 * Math.cos(Math.toRadians(f)));
        double sin = i2 - (i3 * Math.sin(Math.toRadians(f)));
        return new Rect((int) (cos - (i4 / 2)), (int) (sin - (i4 / 2)), (int) (cos + (i4 / 2)), (int) (sin + (i4 / 2)));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.mRadius = l.f(getContext(), d.e.ds156);
        this.fkW = this.mRadius + ((this.fkR - this.fkQ) / 2);
        int i3 = (this.fkW * 2) + this.fkR + this.fkS;
        int i4 = this.fkW + (this.fkR / 2) + this.fle + this.fkT;
        if (i3 > this.mScreenWidth) {
            i3 = this.mScreenWidth;
        }
        setMeasuredDimension(i3, i4);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < this.fkZ.size()) {
                int i7 = this.fkQ;
                if (this.fkY != null && i6 == this.fkZ.indexOf(this.fkY)) {
                    i7 = this.fkR;
                }
                int i8 = i7;
                this.fkZ.get(i6).measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
                this.flb.get(i6).measure(View.MeasureSpec.makeMeasureSpec(this.fld, 1073741824), View.MeasureSpec.makeMeasureSpec(this.fle, 1073741824));
                i5 = i6 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth() / 2;
        int height = getHeight() - this.fkT;
        int i5 = this.fkX ? this.mRadius : 0;
        int f = l.f(getContext(), d.e.ds90);
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 < this.fkZ.size()) {
                float qv = qv(i7);
                Rect a = a(width, height, i5, qv, this.fkQ);
                this.fkZ.get(i7).layout(a.left, a.top, a.right, a.bottom);
                Rect a2 = a(width, height, this.fkW, qv, this.fkR);
                float width2 = a2.left + (a2.width() / 2);
                float height2 = ((a2.height() / 2) + a2.top) - f;
                this.flb.get(i7).layout((int) (width2 - (this.fld / 2)), (int) (height2 - (this.fle / 2)), (int) (width2 + (this.fld / 2)), (int) (height2 + (this.fle / 2)));
                i6 = i7 + 1;
            } else {
                return;
            }
        }
    }

    private float Z(float f) {
        return (float) (Math.cos(Math.toRadians(f)) * 10.0d);
    }

    private float aa(float f) {
        return (float) (Math.cos(Math.toRadians(f)) * (this.fkW - this.mRadius));
    }

    private float ab(float f) {
        return 0.0f;
    }

    private float ac(float f) {
        return (float) (Math.cos(Math.toRadians(f)) * (-this.mRadius));
    }

    private float ad(float f) {
        return -((float) (Math.sin(Math.toRadians(f)) * 10.0d));
    }

    private float ae(float f) {
        return -((float) (Math.sin(Math.toRadians(f)) * (this.fkW - this.mRadius)));
    }

    private float af(float f) {
        return 0.0f;
    }

    private float ag(float f) {
        return (float) (Math.sin(Math.toRadians(f)) * this.mRadius);
    }

    private void c(View view, int i, long j) {
        float qv = qv(i);
        float aa = aa(qv);
        float ae = ae(qv);
        float ac = ac(qv);
        float ag = ag(qv);
        float Z = Z(qv);
        float ad = ad(qv);
        float ab = ab(qv);
        float af = af(qv);
        this.flf = new AnimatorSet();
        float f = this.fkX ? 1.0f : 0.0f;
        float f2 = this.fkX ? ab : ac;
        if (!this.fkX) {
            ac = ab;
        }
        float f3 = this.fkX ? af : ag;
        if (!this.fkX) {
            ag = af;
        }
        float zoomOutScale = this.fkX ? 1.0f : getZoomOutScale();
        float zoomOutScale2 = this.fkX ? getZoomOutScale() : 1.0f;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("alpha", f, 1.0f - f), PropertyValuesHolder.ofFloat("translationX", f2, ac), PropertyValuesHolder.ofFloat("translationY", f3, ag), PropertyValuesHolder.ofFloat("scaleX", zoomOutScale, zoomOutScale2), PropertyValuesHolder.ofFloat("scaleY", zoomOutScale, zoomOutScale2));
        ofPropertyValuesHolder.setDuration(j);
        this.flf.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!e.this.fkX) {
                    e.this.setVisibility(8);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < e.this.fkZ.size()) {
                            ImageView imageView = (ImageView) e.this.fkZ.get(i3);
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
                if (!e.this.fkX) {
                    e.this.setVisibility(8);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("translationX", aa, Z), PropertyValuesHolder.ofFloat("translationY", ae, ad));
        ofPropertyValuesHolder2.setDuration(2L);
        ObjectAnimator ofPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("translationX", Z, aa), PropertyValuesHolder.ofFloat("translationY", ad, ae));
        ofPropertyValuesHolder3.setDuration(2L);
        if (!this.fkX) {
            this.flf.play(ofPropertyValuesHolder);
            this.flf.setInterpolator(this.fli);
        } else {
            this.flf.playSequentially(ofPropertyValuesHolder2, ofPropertyValuesHolder3, ofPropertyValuesHolder);
            this.flf.setInterpolator(this.flj);
            this.flf.setDuration(4 + j);
        }
        this.flf.start();
    }

    public boolean auC() {
        return this.fkX;
    }

    private float getZoomInScale() {
        return this.fkR / this.fkQ;
    }

    private float getZoomOutScale() {
        return this.fkP / this.fkQ;
    }

    public void aYA() {
        int i;
        int i2 = 0;
        while (i2 < this.fkZ.size()) {
            ImageView imageView = this.fkZ.get(i2);
            imageView.setVisibility(0);
            if (!this.fkX) {
                if (i2 == 0) {
                    i = d.b.big_praise;
                } else if (i2 == 1) {
                    i = d.b.normal_praise;
                } else if (i2 == 2) {
                    i = d.b.normal_trample;
                } else {
                    i = i2 == 3 ? d.b.big_trample : 0;
                }
                if (imageView.getTag() != null && (imageView.getTag() instanceof com.baidu.tbadk.core.util.l)) {
                    ((com.baidu.tbadk.core.util.l) imageView.getTag()).stop();
                    imageView.setTag(null);
                }
                com.baidu.tbadk.core.util.l a = com.baidu.tbadk.core.util.l.a(imageView, i, 20, Integer.MAX_VALUE);
                a.b(imageView);
                imageView.setTag(a);
            }
            c(imageView, i2, 200L);
            i2++;
        }
        this.fkX = this.fkX ? false : true;
        invalidate();
    }

    public void bw(int i, int i2) {
        if (!this.fkX) {
            aYC();
            return;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            aYB();
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < this.fkZ.size()) {
                ImageView imageView = this.fkZ.get(i4);
                imageView.getGlobalVisibleRect(rect);
                if (!rect.contains(i, i2) || this.flc) {
                    i3 = i4 + 1;
                } else {
                    f(imageView);
                    return;
                }
            } else {
                aYB();
                return;
            }
        }
    }

    public void f(ImageView imageView) {
        if (imageView != null && this.fkY != imageView && !this.flc) {
            aYC();
            this.fkY = imageView;
            float size = (((this.fkV - this.fkU) / (this.fkZ.size() - 1)) * this.fkZ.indexOf(imageView)) + this.fkU;
            float zoomInScale = getZoomInScale();
            this.flg = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, zoomInScale);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, zoomInScale);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "translationX", imageView.getTranslationX(), aa(size));
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "translationY", imageView.getTranslationY(), ae(size));
            if (this.fkZ.indexOf(this.fkY) > -1) {
                this.fla = this.flb.get(this.fkZ.indexOf(this.fkY));
                this.fla.setVisibility(0);
                this.fla.setAlpha(0.0f);
            }
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fla, "alpha", 0.0f, 1.0f);
            this.flg.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.fla, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.fla, "scaleY", 0.0f, 1.0f));
            this.flg.setInterpolator(this.flj);
            this.flg.setDuration(100L);
            this.flg.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.flc = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.flc = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.flc = true;
            this.flg.start();
        }
    }

    public void aYB() {
        if (this.fkY != null && !this.flc) {
            ImageView imageView = this.fkY;
            float zoomInScale = getZoomInScale();
            this.flh = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", zoomInScale, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", zoomInScale, 1.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "translationX", imageView.getTranslationX(), 0.0f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "translationY", imageView.getTranslationY(), 0.0f);
            if (this.fla != null) {
                ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fla, "alpha", 1.0f, 0.0f);
                this.flh.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.fla, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.fla, "scaleY", 0.0f, 1.0f));
            } else {
                this.flh.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
            }
            this.flh.setInterpolator(this.flj);
            this.flh.setDuration(100L);
            this.flh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.flc = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.flc = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.flc = true;
            this.flh.start();
            if (this.fla != null) {
                this.fla.setVisibility(4);
            }
            this.fkY = null;
            this.fla = null;
        }
    }

    public int bx(int i, int i2) {
        if (!this.fkX) {
            aYC();
            return -1;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            aYB();
            return -1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.fkZ.size()) {
                return -1;
            }
            this.fkZ.get(i4).getGlobalVisibleRect(rect);
            if (!rect.contains(i, i2)) {
                i3 = i4 + 1;
            } else {
                aYB();
                return i4 + 1;
            }
        }
    }

    public void aYC() {
        if (this.flf != null && this.flf.isStarted()) {
            this.flf.cancel();
            this.flf = null;
        }
        if (this.flg != null && this.flg.isStarted()) {
            this.flg.cancel();
            this.flg = null;
        }
        if (this.flh != null && this.flh.isStarted()) {
            this.flh.cancel();
            this.flh = null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fkZ.size()) {
                ImageView imageView = this.fkZ.get(i2);
                float qv = qv(i2);
                imageView.setTranslationX(ab(qv));
                imageView.setTranslationY(af(qv));
                imageView.setScaleX(1.0f);
                imageView.setScaleY(1.0f);
                imageView.invalidate();
                TextView textView = this.flb.get(i2);
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

    private float qv(int i) {
        return (((this.fkV - this.fkU) / (this.fkZ.size() - 1)) * i) + this.fkU;
    }
}
