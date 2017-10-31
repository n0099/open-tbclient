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
    private boolean fdA;
    private ImageView fdB;
    private List<ImageView> fdC;
    private TextView fdD;
    private List<TextView> fdE;
    private boolean fdF;
    private int fdG;
    private int fdH;
    private boolean fdI;
    private AnimatorSet fdJ;
    private AnimatorSet fdK;
    private AnimatorSet fdL;
    private Interpolator fdM;
    private Interpolator fdN;
    private int fdt;
    private int fdu;
    private int fdv;
    private int fdw;
    private float fdx;
    private float fdy;
    private int fdz;
    private int mRadius;
    private int mScreenWidth;

    public e(Context context) {
        super(context);
        this.fdv = 30;
        this.fdw = l.f(getContext(), d.e.ds112);
        this.fdx = 200.0f;
        this.fdy = 340.0f;
        this.fdA = false;
        this.fdM = new OvershootInterpolator();
        this.fdN = new DecelerateInterpolator();
        init();
    }

    private void init() {
        this.fdt = getResources().getDimensionPixelSize(d.e.ds132);
        this.fdu = getResources().getDimensionPixelSize(d.e.ds162);
        this.fdC = new ArrayList();
        for (int i = 0; i < 4; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            this.fdC.add(imageView);
            addView(imageView);
        }
        this.fdE = new ArrayList();
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
            this.fdE.add(textView);
            addView(textView);
        }
        this.mScreenWidth = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        this.fdG = l.f(getContext(), d.e.ds70);
        this.fdH = l.f(getContext(), d.e.ds52);
    }

    private static int a(float f, int i, int i2, int i3, int i4) {
        return i < 2 ? i4 : Math.max((int) (((i2 + i3) / 2) / Math.sin(Math.toRadians((f / (i - 1)) / 2.0f))), i4);
    }

    private static Rect a(int i, int i2, int i3, float f, int i4) {
        double cos = i + (i3 * Math.cos(Math.toRadians(f)));
        double sin = i2 + (i3 * Math.sin(Math.toRadians(f)));
        return new Rect((int) (cos - (i4 / 2)), (int) (sin - (i4 / 2)), (int) (cos + (i4 / 2)), (int) (sin + (i4 / 2)));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.mRadius = a(Math.abs(this.fdy - this.fdx), this.fdC.size(), this.fdt, this.fdv, 100);
        this.fdz = a(Math.abs(this.fdy - this.fdx), this.fdC.size(), this.fdu, this.fdv, 100);
        int i3 = (this.fdz * 2) + this.fdu + this.fdv + this.fdG;
        int i4 = this.fdz + this.fdu + this.fdw;
        if (i3 > this.mScreenWidth) {
            i3 = this.mScreenWidth;
        }
        setMeasuredDimension(i3, i4);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < this.fdC.size()) {
                int i7 = this.fdt;
                if (this.fdB != null && i6 == this.fdC.indexOf(this.fdB)) {
                    i7 = this.fdu;
                }
                int i8 = i7;
                this.fdC.get(i6).measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
                this.fdE.get(i6).measure(View.MeasureSpec.makeMeasureSpec(this.fdG, 1073741824), View.MeasureSpec.makeMeasureSpec(this.fdH, 1073741824));
                i5 = i6 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (!this.fdI) {
            int width = getWidth() / 2;
            int height = getHeight() - this.fdw;
            int i6 = this.fdA ? this.mRadius : 0;
            float size = (this.fdy - this.fdx) / (this.fdC.size() - 1);
            int i7 = 0;
            float f = this.fdx;
            while (true) {
                int i8 = i7;
                if (i8 < this.fdC.size()) {
                    Rect a = a(width, height, i6, f, this.fdt);
                    this.fdC.get(i8).layout(a.left, a.top, a.right, a.bottom);
                    int f2 = this.fdz + l.f(getContext(), d.e.ds106);
                    if (i8 == 0) {
                        i5 = 10;
                    } else if (i8 == 1) {
                        i5 = 5;
                    } else if (i8 == 2) {
                        i5 = -5;
                    } else if (i8 != 3) {
                        i5 = 0;
                    } else {
                        i5 = -10;
                    }
                    double cos = width + (f2 * Math.cos(Math.toRadians(i5 + f)));
                    double sin = (f2 * Math.sin(Math.toRadians(i5 + f))) + height;
                    TextView textView = this.fdE.get(i8);
                    textView.layout((int) (cos - (this.fdG / 2)), (int) (sin - (this.fdH / 2)), (int) (cos + (this.fdG / 2)), (int) (sin + (this.fdH / 2)));
                    textView.setRotation((i8 == 0 || i8 == 3) ? i5 * (-3) : -i5);
                    f += size;
                    i7 = i8 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void d(View view, int i, long j) {
        int width = getWidth() / 2;
        int height = getHeight() - this.fdw;
        float size = (this.fdy - this.fdx) / (this.fdC.size() - 1);
        Rect a = a(width, height, this.mRadius, this.fdx + (i * size), this.fdt);
        Rect a2 = a(width, height, 0, this.fdx + (i * size), this.fdt);
        this.fdJ = new AnimatorSet();
        float f = this.fdA ? 1.0f : 0.0f;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("alpha", f, 1.0f - f), PropertyValuesHolder.ofFloat("X", this.fdA ? a.left : a2.left, this.fdA ? a2.left : a.left), PropertyValuesHolder.ofFloat("Y", this.fdA ? a.top : a2.top, this.fdA ? a2.top : a.top));
        ofPropertyValuesHolder.setDuration(j);
        this.fdJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.fdI = true;
                if (!e.this.fdA) {
                    e.this.setVisibility(8);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < e.this.fdC.size()) {
                            ImageView imageView = (ImageView) e.this.fdC.get(i3);
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
                if (!e.this.fdA) {
                    e.this.setVisibility(8);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        Rect a3 = a(width, height, this.mRadius + l.f(getContext(), d.e.ds16), this.fdx + (i * size), this.fdt);
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("X", a.left, a3.left), PropertyValuesHolder.ofFloat("Y", a.top, a3.top));
        ofPropertyValuesHolder2.setDuration(2L);
        ObjectAnimator ofPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("X", a3.left, a.left), PropertyValuesHolder.ofFloat("Y", a3.top, a.top));
        ofPropertyValuesHolder3.setDuration(2L);
        if (!this.fdA) {
            this.fdJ.play(ofPropertyValuesHolder);
            this.fdJ.setInterpolator(this.fdM);
        } else {
            this.fdJ.playSequentially(ofPropertyValuesHolder2, ofPropertyValuesHolder3, ofPropertyValuesHolder);
            this.fdJ.setInterpolator(this.fdN);
            this.fdJ.setDuration(4 + j);
        }
        this.fdJ.start();
    }

    public boolean asI() {
        return this.fdA;
    }

    public void aXt() {
        int i;
        int i2 = 0;
        while (i2 < this.fdC.size()) {
            ImageView imageView = this.fdC.get(i2);
            imageView.setVisibility(0);
            if (!this.fdA) {
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
            d(imageView, i2, 200L);
            i2++;
        }
        this.fdA = this.fdA ? false : true;
        invalidate();
    }

    public void bz(int i, int i2) {
        if (!this.fdA) {
            aXv();
            return;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            aXu();
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < this.fdC.size()) {
                ImageView imageView = this.fdC.get(i4);
                imageView.getGlobalVisibleRect(rect);
                if (!rect.contains(i, i2) || this.fdF) {
                    i3 = i4 + 1;
                } else {
                    f(imageView);
                    return;
                }
            } else {
                aXu();
                return;
            }
        }
    }

    public void f(ImageView imageView) {
        if (imageView != null && this.fdB != imageView && !this.fdF) {
            aXv();
            this.fdB = imageView;
            float size = (this.fdy - this.fdx) / (this.fdC.size() - 1);
            Rect a = a(getWidth() / 2, getHeight() - this.fdw, this.mRadius, this.fdx + (this.fdC.indexOf(imageView) * size), this.fdt);
            Rect a2 = a(getWidth() / 2, getHeight() - this.fdw, this.fdz, (size * this.fdC.indexOf(imageView)) + this.fdx, this.fdt);
            this.fdK = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, 1.3f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, 1.3f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "X", a.left, a2.left);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "Y", a.top, a2.top);
            if (this.fdC.indexOf(this.fdB) > -1) {
                this.fdD = this.fdE.get(this.fdC.indexOf(this.fdB));
                this.fdD.setVisibility(0);
                this.fdD.setAlpha(0.0f);
            }
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fdD, "alpha", 0.0f, 1.0f);
            this.fdK.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.fdD, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.fdD, "scaleY", 0.0f, 1.0f));
            this.fdK.setInterpolator(this.fdN);
            this.fdK.setDuration(100L);
            this.fdK.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.fdF = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.fdF = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fdF = true;
            this.fdK.start();
        }
    }

    public void aXu() {
        if (this.fdB != null && !this.fdF) {
            float size = (this.fdy - this.fdx) / (this.fdC.size() - 1);
            Rect a = a(getWidth() / 2, getHeight() - this.fdw, this.mRadius, this.fdx + (this.fdC.indexOf(this.fdB) * size), this.fdt);
            Rect a2 = a(getWidth() / 2, getHeight() - this.fdw, this.fdz, (size * this.fdC.indexOf(this.fdB)) + this.fdx, this.fdu);
            this.fdL = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fdB, "scaleX", 1.3f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.fdB, "scaleY", 1.3f, 1.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.fdB, "X", a2.left, a.left);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.fdB, "Y", a2.top, a.top);
            if (this.fdD != null) {
                ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fdD, "alpha", 1.0f, 0.0f);
                this.fdL.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.fdD, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.fdD, "scaleY", 0.0f, 1.0f));
            } else {
                this.fdL.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
            }
            this.fdL.setInterpolator(this.fdN);
            this.fdL.setDuration(100L);
            this.fdL.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.fdF = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.fdF = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fdF = true;
            this.fdL.start();
            if (this.fdD != null) {
                this.fdD.setVisibility(4);
            }
            this.fdB = null;
            this.fdD = null;
        }
    }

    public int bA(int i, int i2) {
        if (!this.fdA) {
            aXv();
            return -1;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            aXu();
            return -1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.fdC.size()) {
                return -1;
            }
            this.fdC.get(i4).getGlobalVisibleRect(rect);
            if (!rect.contains(i, i2)) {
                i3 = i4 + 1;
            } else {
                aXu();
                return i4 + 1;
            }
        }
    }

    public void aXv() {
        if (this.fdJ != null && this.fdJ.isStarted()) {
            this.fdJ.cancel();
            this.fdJ = null;
        }
        if (this.fdK != null && this.fdK.isStarted()) {
            this.fdK.cancel();
            this.fdK = null;
        }
        if (this.fdL != null && this.fdL.isStarted()) {
            this.fdL.cancel();
            this.fdL = null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fdC.size()) {
                ImageView imageView = this.fdC.get(i2);
                Rect a = a(getWidth() / 2, getHeight() - this.fdw, this.mRadius, (((this.fdy - this.fdx) / (this.fdC.size() - 1)) * i2) + this.fdx, this.fdt);
                imageView.setX(a.left);
                imageView.setY(a.top);
                imageView.setScaleX(1.0f);
                imageView.setScaleY(1.0f);
                imageView.invalidate();
                TextView textView = this.fdE.get(i2);
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
}
