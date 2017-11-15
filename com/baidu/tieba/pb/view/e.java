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
    private int fdP;
    private int fdQ;
    private int fdR;
    private int fdS;
    private float fdT;
    private float fdU;
    private int fdV;
    private boolean fdW;
    private ImageView fdX;
    private List<ImageView> fdY;
    private TextView fdZ;
    private List<TextView> fea;
    private boolean feb;
    private int fec;
    private int fed;
    private boolean fee;
    private AnimatorSet fef;
    private AnimatorSet feg;
    private AnimatorSet feh;
    private Interpolator fei;
    private Interpolator fej;
    private int mRadius;
    private int mScreenWidth;

    public e(Context context) {
        super(context);
        this.fdR = 30;
        this.fdS = l.f(getContext(), d.e.ds112);
        this.fdT = 200.0f;
        this.fdU = 340.0f;
        this.fdW = false;
        this.fei = new OvershootInterpolator();
        this.fej = new DecelerateInterpolator();
        init();
    }

    private void init() {
        this.fdP = getResources().getDimensionPixelSize(d.e.ds132);
        this.fdQ = getResources().getDimensionPixelSize(d.e.ds162);
        this.fdY = new ArrayList();
        for (int i = 0; i < 4; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            this.fdY.add(imageView);
            addView(imageView);
        }
        this.fea = new ArrayList();
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
            this.fea.add(textView);
            addView(textView);
        }
        this.mScreenWidth = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        this.fec = l.f(getContext(), d.e.ds70);
        this.fed = l.f(getContext(), d.e.ds52);
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
        this.mRadius = a(Math.abs(this.fdU - this.fdT), this.fdY.size(), this.fdP, this.fdR, 100);
        this.fdV = a(Math.abs(this.fdU - this.fdT), this.fdY.size(), this.fdQ, this.fdR, 100);
        int i3 = (this.fdV * 2) + this.fdQ + this.fdR + this.fec;
        int i4 = this.fdV + this.fdQ + this.fdS;
        if (i3 > this.mScreenWidth) {
            i3 = this.mScreenWidth;
        }
        setMeasuredDimension(i3, i4);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < this.fdY.size()) {
                int i7 = this.fdP;
                if (this.fdX != null && i6 == this.fdY.indexOf(this.fdX)) {
                    i7 = this.fdQ;
                }
                int i8 = i7;
                this.fdY.get(i6).measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
                this.fea.get(i6).measure(View.MeasureSpec.makeMeasureSpec(this.fec, 1073741824), View.MeasureSpec.makeMeasureSpec(this.fed, 1073741824));
                i5 = i6 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (!this.fee) {
            int width = getWidth() / 2;
            int height = getHeight() - this.fdS;
            int i6 = this.fdW ? this.mRadius : 0;
            float size = (this.fdU - this.fdT) / (this.fdY.size() - 1);
            int i7 = 0;
            float f = this.fdT;
            while (true) {
                int i8 = i7;
                if (i8 < this.fdY.size()) {
                    Rect a = a(width, height, i6, f, this.fdP);
                    this.fdY.get(i8).layout(a.left, a.top, a.right, a.bottom);
                    int f2 = this.fdV + l.f(getContext(), d.e.ds106);
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
                    TextView textView = this.fea.get(i8);
                    textView.layout((int) (cos - (this.fec / 2)), (int) (sin - (this.fed / 2)), (int) (cos + (this.fec / 2)), (int) (sin + (this.fed / 2)));
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
        int height = getHeight() - this.fdS;
        float size = (this.fdU - this.fdT) / (this.fdY.size() - 1);
        Rect a = a(width, height, this.mRadius, this.fdT + (i * size), this.fdP);
        Rect a2 = a(width, height, 0, this.fdT + (i * size), this.fdP);
        this.fef = new AnimatorSet();
        float f = this.fdW ? 1.0f : 0.0f;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("alpha", f, 1.0f - f), PropertyValuesHolder.ofFloat("X", this.fdW ? a.left : a2.left, this.fdW ? a2.left : a.left), PropertyValuesHolder.ofFloat("Y", this.fdW ? a.top : a2.top, this.fdW ? a2.top : a.top));
        ofPropertyValuesHolder.setDuration(j);
        this.fef.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.fee = true;
                if (!e.this.fdW) {
                    e.this.setVisibility(8);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < e.this.fdY.size()) {
                            ImageView imageView = (ImageView) e.this.fdY.get(i3);
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
                if (!e.this.fdW) {
                    e.this.setVisibility(8);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        Rect a3 = a(width, height, this.mRadius + l.f(getContext(), d.e.ds16), this.fdT + (i * size), this.fdP);
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("X", a.left, a3.left), PropertyValuesHolder.ofFloat("Y", a.top, a3.top));
        ofPropertyValuesHolder2.setDuration(2L);
        ObjectAnimator ofPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("X", a3.left, a.left), PropertyValuesHolder.ofFloat("Y", a3.top, a.top));
        ofPropertyValuesHolder3.setDuration(2L);
        if (!this.fdW) {
            this.fef.play(ofPropertyValuesHolder);
            this.fef.setInterpolator(this.fei);
        } else {
            this.fef.playSequentially(ofPropertyValuesHolder2, ofPropertyValuesHolder3, ofPropertyValuesHolder);
            this.fef.setInterpolator(this.fej);
            this.fef.setDuration(4 + j);
        }
        this.fef.start();
    }

    public boolean asZ() {
        return this.fdW;
    }

    public void aXB() {
        int i;
        int i2 = 0;
        while (i2 < this.fdY.size()) {
            ImageView imageView = this.fdY.get(i2);
            imageView.setVisibility(0);
            if (!this.fdW) {
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
        this.fdW = this.fdW ? false : true;
        invalidate();
    }

    public void by(int i, int i2) {
        if (!this.fdW) {
            aXD();
            return;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            aXC();
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < this.fdY.size()) {
                ImageView imageView = this.fdY.get(i4);
                imageView.getGlobalVisibleRect(rect);
                if (!rect.contains(i, i2) || this.feb) {
                    i3 = i4 + 1;
                } else {
                    f(imageView);
                    return;
                }
            } else {
                aXC();
                return;
            }
        }
    }

    public void f(ImageView imageView) {
        if (imageView != null && this.fdX != imageView && !this.feb) {
            aXD();
            this.fdX = imageView;
            float size = (this.fdU - this.fdT) / (this.fdY.size() - 1);
            Rect a = a(getWidth() / 2, getHeight() - this.fdS, this.mRadius, this.fdT + (this.fdY.indexOf(imageView) * size), this.fdP);
            Rect a2 = a(getWidth() / 2, getHeight() - this.fdS, this.fdV, (size * this.fdY.indexOf(imageView)) + this.fdT, this.fdP);
            this.feg = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, 1.3f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, 1.3f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "X", a.left, a2.left);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "Y", a.top, a2.top);
            if (this.fdY.indexOf(this.fdX) > -1) {
                this.fdZ = this.fea.get(this.fdY.indexOf(this.fdX));
                this.fdZ.setVisibility(0);
                this.fdZ.setAlpha(0.0f);
            }
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fdZ, "alpha", 0.0f, 1.0f);
            this.feg.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.fdZ, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.fdZ, "scaleY", 0.0f, 1.0f));
            this.feg.setInterpolator(this.fej);
            this.feg.setDuration(100L);
            this.feg.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.feb = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.feb = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.feb = true;
            this.feg.start();
        }
    }

    public void aXC() {
        if (this.fdX != null && !this.feb) {
            float size = (this.fdU - this.fdT) / (this.fdY.size() - 1);
            Rect a = a(getWidth() / 2, getHeight() - this.fdS, this.mRadius, this.fdT + (this.fdY.indexOf(this.fdX) * size), this.fdP);
            Rect a2 = a(getWidth() / 2, getHeight() - this.fdS, this.fdV, (size * this.fdY.indexOf(this.fdX)) + this.fdT, this.fdQ);
            this.feh = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fdX, "scaleX", 1.3f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.fdX, "scaleY", 1.3f, 1.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.fdX, "X", a2.left, a.left);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.fdX, "Y", a2.top, a.top);
            if (this.fdZ != null) {
                ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fdZ, "alpha", 1.0f, 0.0f);
                this.feh.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.fdZ, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.fdZ, "scaleY", 0.0f, 1.0f));
            } else {
                this.feh.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
            }
            this.feh.setInterpolator(this.fej);
            this.feh.setDuration(100L);
            this.feh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.feb = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.feb = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.feb = true;
            this.feh.start();
            if (this.fdZ != null) {
                this.fdZ.setVisibility(4);
            }
            this.fdX = null;
            this.fdZ = null;
        }
    }

    public int bz(int i, int i2) {
        if (!this.fdW) {
            aXD();
            return -1;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            aXC();
            return -1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.fdY.size()) {
                return -1;
            }
            this.fdY.get(i4).getGlobalVisibleRect(rect);
            if (!rect.contains(i, i2)) {
                i3 = i4 + 1;
            } else {
                aXC();
                return i4 + 1;
            }
        }
    }

    public void aXD() {
        if (this.fef != null && this.fef.isStarted()) {
            this.fef.cancel();
            this.fef = null;
        }
        if (this.feg != null && this.feg.isStarted()) {
            this.feg.cancel();
            this.feg = null;
        }
        if (this.feh != null && this.feh.isStarted()) {
            this.feh.cancel();
            this.feh = null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fdY.size()) {
                ImageView imageView = this.fdY.get(i2);
                Rect a = a(getWidth() / 2, getHeight() - this.fdS, this.mRadius, (((this.fdU - this.fdT) / (this.fdY.size() - 1)) * i2) + this.fdT, this.fdP);
                imageView.setX(a.left);
                imageView.setY(a.top);
                imageView.setScaleX(1.0f);
                imageView.setScaleY(1.0f);
                imageView.invalidate();
                TextView textView = this.fea.get(i2);
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
