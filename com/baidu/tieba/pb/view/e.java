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
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e extends ViewGroup {
    private int eYA;
    private int eYB;
    private float eYC;
    private float eYD;
    private int eYE;
    private boolean eYF;
    private ImageView eYG;
    private List<ImageView> eYH;
    private TextView eYI;
    private List<TextView> eYJ;
    private boolean eYK;
    private int eYL;
    private int eYM;
    private boolean eYN;
    private AnimatorSet eYO;
    private AnimatorSet eYP;
    private AnimatorSet eYQ;
    private Interpolator eYR;
    private Interpolator eYS;
    private Interpolator eYT;
    private int eYy;
    private int eYz;
    private int mRadius;
    private int mScreenWidth;

    public e(Context context) {
        super(context);
        this.eYA = 30;
        this.eYB = k.g(getContext(), d.f.ds112);
        this.eYC = 200.0f;
        this.eYD = 340.0f;
        this.eYF = false;
        this.eYR = new OvershootInterpolator();
        this.eYS = new DecelerateInterpolator();
        this.eYT = new AccelerateDecelerateInterpolator();
        init();
    }

    private void init() {
        this.eYy = getResources().getDimensionPixelSize(d.f.ds132);
        this.eYz = getResources().getDimensionPixelSize(d.f.ds162);
        this.eYH = new ArrayList();
        for (int i = 0; i < 4; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            this.eYH.add(imageView);
            addView(imageView);
        }
        this.eYJ = new ArrayList();
        for (int i2 = 0; i2 < 4; i2++) {
            TextView textView = new TextView(getContext());
            switch (i2) {
                case 0:
                    textView.setText(d.l.pb_big_praise);
                    break;
                case 1:
                    textView.setText(d.l.pb_normal_praise);
                    break;
                case 2:
                    textView.setText(d.l.pb_normal_trample);
                    break;
                case 3:
                    textView.setText(d.l.pb_big_trample);
                    break;
            }
            textView.setBackgroundResource(d.g.praise_text_bg);
            textView.setTextSize(0, k.g(getContext(), d.f.fontsize22));
            textView.setTextColor(-1);
            textView.setGravity(17);
            textView.setVisibility(4);
            this.eYJ.add(textView);
            addView(textView);
        }
        this.mScreenWidth = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        this.eYL = k.g(getContext(), d.f.ds70);
        this.eYM = k.g(getContext(), d.f.ds52);
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
        this.mRadius = a(Math.abs(this.eYD - this.eYC), this.eYH.size(), this.eYy, this.eYA, 100);
        this.eYE = a(Math.abs(this.eYD - this.eYC), this.eYH.size(), this.eYz, this.eYA, 100);
        int i3 = (this.eYE * 2) + this.eYz + this.eYA + this.eYL;
        int i4 = this.eYE + this.eYz + this.eYB;
        if (i3 > this.mScreenWidth) {
            i3 = this.mScreenWidth;
        }
        setMeasuredDimension(i3, i4);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < this.eYH.size()) {
                int i7 = this.eYy;
                if (this.eYG != null && i6 == this.eYH.indexOf(this.eYG)) {
                    i7 = this.eYz;
                }
                int i8 = i7;
                this.eYH.get(i6).measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
                this.eYJ.get(i6).measure(View.MeasureSpec.makeMeasureSpec(this.eYL, 1073741824), View.MeasureSpec.makeMeasureSpec(this.eYM, 1073741824));
                i5 = i6 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (!this.eYN) {
            int width = getWidth() / 2;
            int height = getHeight() - this.eYB;
            int i6 = this.eYF ? this.mRadius : 0;
            float size = (this.eYD - this.eYC) / (this.eYH.size() - 1);
            int i7 = 0;
            float f = this.eYC;
            while (true) {
                int i8 = i7;
                if (i8 < this.eYH.size()) {
                    Rect a = a(width, height, i6, f, this.eYy);
                    this.eYH.get(i8).layout(a.left, a.top, a.right, a.bottom);
                    int g = this.eYE + k.g(getContext(), d.f.ds106);
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
                    double cos = width + (g * Math.cos(Math.toRadians(i5 + f)));
                    double sin = (g * Math.sin(Math.toRadians(i5 + f))) + height;
                    TextView textView = this.eYJ.get(i8);
                    textView.layout((int) (cos - (this.eYL / 2)), (int) (sin - (this.eYM / 2)), (int) (cos + (this.eYL / 2)), (int) (sin + (this.eYM / 2)));
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
        int height = getHeight() - this.eYB;
        float size = (this.eYD - this.eYC) / (this.eYH.size() - 1);
        Rect a = a(width, height, this.mRadius, this.eYC + (i * size), this.eYy);
        Rect a2 = a(width, height, 0, this.eYC + (i * size), this.eYy);
        this.eYO = new AnimatorSet();
        float f = this.eYF ? 1.0f : 0.0f;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("alpha", f, 1.0f - f), PropertyValuesHolder.ofFloat("X", this.eYF ? a.left : a2.left, this.eYF ? a2.left : a.left), PropertyValuesHolder.ofFloat("Y", this.eYF ? a.top : a2.top, this.eYF ? a2.top : a.top));
        ofPropertyValuesHolder.setDuration(j);
        this.eYO.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.eYN = true;
                if (!e.this.eYF) {
                    e.this.setVisibility(8);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < e.this.eYH.size()) {
                            ImageView imageView = (ImageView) e.this.eYH.get(i3);
                            if (imageView.getTag() != null) {
                                ((com.baidu.tieba.pb.pb.main.view.b) imageView.getTag()).stop();
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
                if (!e.this.eYF) {
                    e.this.setVisibility(8);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        Rect a3 = a(width, height, this.mRadius + k.g(getContext(), d.f.ds16), this.eYC + (i * size), this.eYy);
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("X", a.left, a3.left), PropertyValuesHolder.ofFloat("Y", a.top, a3.top));
        ofPropertyValuesHolder2.setDuration(2L);
        ObjectAnimator ofPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("X", a3.left, a.left), PropertyValuesHolder.ofFloat("Y", a3.top, a.top));
        ofPropertyValuesHolder3.setDuration(2L);
        if (!this.eYF) {
            this.eYO.play(ofPropertyValuesHolder);
            this.eYO.setInterpolator(this.eYR);
        } else {
            this.eYO.playSequentially(ofPropertyValuesHolder2, ofPropertyValuesHolder3, ofPropertyValuesHolder);
            this.eYO.setInterpolator(this.eYS);
            this.eYO.setDuration(4 + j);
        }
        this.eYO.start();
    }

    public boolean apd() {
        return this.eYF;
    }

    public void aWd() {
        int i;
        int i2 = 0;
        while (i2 < this.eYH.size()) {
            ImageView imageView = this.eYH.get(i2);
            imageView.setVisibility(0);
            if (!this.eYF) {
                if (i2 == 0) {
                    i = d.b.big_praise;
                } else if (i2 == 1) {
                    i = d.b.normal_praise;
                } else if (i2 == 2) {
                    i = d.b.normal_trample;
                } else {
                    i = i2 == 3 ? d.b.big_trample : 0;
                }
                if (imageView.getTag() != null && (imageView.getTag() instanceof com.baidu.tieba.pb.pb.main.view.b)) {
                    ((com.baidu.tieba.pb.pb.main.view.b) imageView.getTag()).stop();
                    imageView.setTag(null);
                }
                com.baidu.tieba.pb.pb.main.view.b b = com.baidu.tieba.pb.pb.main.view.b.b(imageView, i, 20, Integer.MAX_VALUE);
                b.start();
                imageView.setTag(b);
            }
            d(imageView, i2, 200L);
            i2++;
        }
        this.eYF = this.eYF ? false : true;
        invalidate();
    }

    public void be(int i, int i2) {
        if (!this.eYF) {
            aWf();
            return;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            aWe();
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < this.eYH.size()) {
                ImageView imageView = this.eYH.get(i4);
                imageView.getGlobalVisibleRect(rect);
                if (!rect.contains(i, i2) || this.eYK) {
                    i3 = i4 + 1;
                } else {
                    i(imageView);
                    return;
                }
            } else {
                aWe();
                return;
            }
        }
    }

    public void i(ImageView imageView) {
        if (imageView != null && this.eYG != imageView && !this.eYK) {
            aWf();
            this.eYG = imageView;
            float size = (this.eYD - this.eYC) / (this.eYH.size() - 1);
            Rect a = a(getWidth() / 2, getHeight() - this.eYB, this.mRadius, this.eYC + (this.eYH.indexOf(imageView) * size), this.eYy);
            Rect a2 = a(getWidth() / 2, getHeight() - this.eYB, this.eYE, (size * this.eYH.indexOf(imageView)) + this.eYC, this.eYy);
            this.eYP = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, 1.3f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, 1.3f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "X", a.left, a2.left);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "Y", a.top, a2.top);
            if (this.eYH.indexOf(this.eYG) > -1) {
                this.eYI = this.eYJ.get(this.eYH.indexOf(this.eYG));
                this.eYI.setVisibility(0);
                this.eYI.setAlpha(0.0f);
            }
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.eYI, "alpha", 0.0f, 1.0f);
            this.eYP.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.eYI, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.eYI, "scaleY", 0.0f, 1.0f));
            this.eYP.setInterpolator(this.eYS);
            this.eYP.setDuration(100L);
            this.eYP.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.eYK = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.eYK = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.eYK = true;
            this.eYP.start();
        }
    }

    public void aWe() {
        if (this.eYG != null && !this.eYK) {
            float size = (this.eYD - this.eYC) / (this.eYH.size() - 1);
            Rect a = a(getWidth() / 2, getHeight() - this.eYB, this.mRadius, this.eYC + (this.eYH.indexOf(this.eYG) * size), this.eYy);
            Rect a2 = a(getWidth() / 2, getHeight() - this.eYB, this.eYE, (size * this.eYH.indexOf(this.eYG)) + this.eYC, this.eYz);
            this.eYQ = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.eYG, "scaleX", 1.3f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.eYG, "scaleY", 1.3f, 1.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.eYG, "X", a2.left, a.left);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.eYG, "Y", a2.top, a.top);
            if (this.eYI != null) {
                ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.eYI, "alpha", 1.0f, 0.0f);
                this.eYQ.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.eYI, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.eYI, "scaleY", 0.0f, 1.0f));
            } else {
                this.eYQ.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
            }
            this.eYQ.setInterpolator(this.eYS);
            this.eYQ.setDuration(100L);
            this.eYQ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.eYK = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.eYK = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.eYK = true;
            this.eYQ.start();
            if (this.eYI != null) {
                this.eYI.setVisibility(4);
            }
            this.eYG = null;
            this.eYI = null;
        }
    }

    public int bf(int i, int i2) {
        if (!this.eYF) {
            aWf();
            return -1;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            aWe();
            return -1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.eYH.size()) {
                return -1;
            }
            this.eYH.get(i4).getGlobalVisibleRect(rect);
            if (!rect.contains(i, i2)) {
                i3 = i4 + 1;
            } else {
                aWe();
                return i4 + 1;
            }
        }
    }

    public void aWf() {
        if (this.eYO != null && this.eYO.isStarted()) {
            this.eYO.cancel();
            this.eYO = null;
        }
        if (this.eYP != null && this.eYP.isStarted()) {
            this.eYP.cancel();
            this.eYP = null;
        }
        if (this.eYQ != null && this.eYQ.isStarted()) {
            this.eYQ.cancel();
            this.eYQ = null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.eYH.size()) {
                ImageView imageView = this.eYH.get(i2);
                Rect a = a(getWidth() / 2, getHeight() - this.eYB, this.mRadius, (((this.eYD - this.eYC) / (this.eYH.size() - 1)) * i2) + this.eYC, this.eYy);
                imageView.setX(a.left);
                imageView.setY(a.top);
                imageView.setScaleX(1.0f);
                imageView.setScaleY(1.0f);
                imageView.invalidate();
                TextView textView = this.eYJ.get(i2);
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
