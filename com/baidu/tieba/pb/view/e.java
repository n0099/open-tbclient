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
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e extends ViewGroup {
    private int eVd;
    private int eVe;
    private int eVf;
    private int eVg;
    private float eVh;
    private float eVi;
    private int eVj;
    private boolean eVk;
    private ImageView eVl;
    private List<ImageView> eVm;
    private TextView eVn;
    private List<TextView> eVo;
    private boolean eVp;
    private int eVq;
    private int eVr;
    private boolean eVs;
    private AnimatorSet eVt;
    private AnimatorSet eVu;
    private AnimatorSet eVv;
    private Interpolator eVw;
    private Interpolator eVx;
    private Interpolator eVy;
    private int mRadius;
    private int mScreenWidth;

    public e(Context context) {
        super(context);
        this.eVf = 30;
        this.eVg = l.f(getContext(), d.f.ds112);
        this.eVh = 200.0f;
        this.eVi = 340.0f;
        this.eVk = false;
        this.eVw = new OvershootInterpolator();
        this.eVx = new DecelerateInterpolator();
        this.eVy = new AccelerateDecelerateInterpolator();
        init();
    }

    private void init() {
        this.eVd = getResources().getDimensionPixelSize(d.f.ds132);
        this.eVe = getResources().getDimensionPixelSize(d.f.ds162);
        this.eVm = new ArrayList();
        for (int i = 0; i < 4; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            this.eVm.add(imageView);
            addView(imageView);
        }
        this.eVo = new ArrayList();
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
            textView.setTextSize(0, l.f(getContext(), d.f.fontsize22));
            textView.setTextColor(-1);
            textView.setGravity(17);
            textView.setVisibility(4);
            this.eVo.add(textView);
            addView(textView);
        }
        this.mScreenWidth = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        this.eVq = l.f(getContext(), d.f.ds70);
        this.eVr = l.f(getContext(), d.f.ds52);
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
        this.mRadius = a(Math.abs(this.eVi - this.eVh), this.eVm.size(), this.eVd, this.eVf, 100);
        this.eVj = a(Math.abs(this.eVi - this.eVh), this.eVm.size(), this.eVe, this.eVf, 100);
        int i3 = (this.eVj * 2) + this.eVe + this.eVf + this.eVq;
        int i4 = this.eVj + this.eVe + this.eVg;
        if (i3 > this.mScreenWidth) {
            i3 = this.mScreenWidth;
        }
        setMeasuredDimension(i3, i4);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < this.eVm.size()) {
                int i7 = this.eVd;
                if (this.eVl != null && i6 == this.eVm.indexOf(this.eVl)) {
                    i7 = this.eVe;
                }
                int i8 = i7;
                this.eVm.get(i6).measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
                this.eVo.get(i6).measure(View.MeasureSpec.makeMeasureSpec(this.eVq, 1073741824), View.MeasureSpec.makeMeasureSpec(this.eVr, 1073741824));
                i5 = i6 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (!this.eVs) {
            int width = getWidth() / 2;
            int height = getHeight() - this.eVg;
            int i6 = this.eVk ? this.mRadius : 0;
            float size = (this.eVi - this.eVh) / (this.eVm.size() - 1);
            int i7 = 0;
            float f = this.eVh;
            while (true) {
                int i8 = i7;
                if (i8 < this.eVm.size()) {
                    Rect a = a(width, height, i6, f, this.eVd);
                    this.eVm.get(i8).layout(a.left, a.top, a.right, a.bottom);
                    int f2 = this.eVj + l.f(getContext(), d.f.ds106);
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
                    TextView textView = this.eVo.get(i8);
                    textView.layout((int) (cos - (this.eVq / 2)), (int) (sin - (this.eVr / 2)), (int) (cos + (this.eVq / 2)), (int) (sin + (this.eVr / 2)));
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
        int height = getHeight() - this.eVg;
        float size = (this.eVi - this.eVh) / (this.eVm.size() - 1);
        Rect a = a(width, height, this.mRadius, this.eVh + (i * size), this.eVd);
        Rect a2 = a(width, height, 0, this.eVh + (i * size), this.eVd);
        this.eVt = new AnimatorSet();
        float f = this.eVk ? 1.0f : 0.0f;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("alpha", f, 1.0f - f), PropertyValuesHolder.ofFloat("X", this.eVk ? a.left : a2.left, this.eVk ? a2.left : a.left), PropertyValuesHolder.ofFloat("Y", this.eVk ? a.top : a2.top, this.eVk ? a2.top : a.top));
        ofPropertyValuesHolder.setDuration(j);
        this.eVt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.eVs = true;
                if (!e.this.eVk) {
                    e.this.setVisibility(8);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < e.this.eVm.size()) {
                            ImageView imageView = (ImageView) e.this.eVm.get(i3);
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
                if (!e.this.eVk) {
                    e.this.setVisibility(8);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        Rect a3 = a(width, height, this.mRadius + l.f(getContext(), d.f.ds16), this.eVh + (i * size), this.eVd);
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("X", a.left, a3.left), PropertyValuesHolder.ofFloat("Y", a.top, a3.top));
        ofPropertyValuesHolder2.setDuration(2L);
        ObjectAnimator ofPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("X", a3.left, a.left), PropertyValuesHolder.ofFloat("Y", a3.top, a.top));
        ofPropertyValuesHolder3.setDuration(2L);
        if (!this.eVk) {
            this.eVt.play(ofPropertyValuesHolder);
            this.eVt.setInterpolator(this.eVw);
        } else {
            this.eVt.playSequentially(ofPropertyValuesHolder2, ofPropertyValuesHolder3, ofPropertyValuesHolder);
            this.eVt.setInterpolator(this.eVx);
            this.eVt.setDuration(4 + j);
        }
        this.eVt.start();
    }

    public boolean aqm() {
        return this.eVk;
    }

    public void aUr() {
        int i;
        int i2 = 0;
        while (i2 < this.eVm.size()) {
            ImageView imageView = this.eVm.get(i2);
            imageView.setVisibility(0);
            if (!this.eVk) {
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
        this.eVk = this.eVk ? false : true;
        invalidate();
    }

    public void bx(int i, int i2) {
        if (!this.eVk) {
            aUt();
            return;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            aUs();
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < this.eVm.size()) {
                ImageView imageView = this.eVm.get(i4);
                imageView.getGlobalVisibleRect(rect);
                if (!rect.contains(i, i2) || this.eVp) {
                    i3 = i4 + 1;
                } else {
                    f(imageView);
                    return;
                }
            } else {
                aUs();
                return;
            }
        }
    }

    public void f(ImageView imageView) {
        if (imageView != null && this.eVl != imageView && !this.eVp) {
            aUt();
            this.eVl = imageView;
            float size = (this.eVi - this.eVh) / (this.eVm.size() - 1);
            Rect a = a(getWidth() / 2, getHeight() - this.eVg, this.mRadius, this.eVh + (this.eVm.indexOf(imageView) * size), this.eVd);
            Rect a2 = a(getWidth() / 2, getHeight() - this.eVg, this.eVj, (size * this.eVm.indexOf(imageView)) + this.eVh, this.eVd);
            this.eVu = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, 1.3f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, 1.3f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "X", a.left, a2.left);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "Y", a.top, a2.top);
            if (this.eVm.indexOf(this.eVl) > -1) {
                this.eVn = this.eVo.get(this.eVm.indexOf(this.eVl));
                this.eVn.setVisibility(0);
                this.eVn.setAlpha(0.0f);
            }
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.eVn, "alpha", 0.0f, 1.0f);
            this.eVu.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.eVn, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.eVn, "scaleY", 0.0f, 1.0f));
            this.eVu.setInterpolator(this.eVx);
            this.eVu.setDuration(100L);
            this.eVu.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.eVp = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.eVp = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.eVp = true;
            this.eVu.start();
        }
    }

    public void aUs() {
        if (this.eVl != null && !this.eVp) {
            float size = (this.eVi - this.eVh) / (this.eVm.size() - 1);
            Rect a = a(getWidth() / 2, getHeight() - this.eVg, this.mRadius, this.eVh + (this.eVm.indexOf(this.eVl) * size), this.eVd);
            Rect a2 = a(getWidth() / 2, getHeight() - this.eVg, this.eVj, (size * this.eVm.indexOf(this.eVl)) + this.eVh, this.eVe);
            this.eVv = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.eVl, "scaleX", 1.3f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.eVl, "scaleY", 1.3f, 1.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.eVl, "X", a2.left, a.left);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.eVl, "Y", a2.top, a.top);
            if (this.eVn != null) {
                ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.eVn, "alpha", 1.0f, 0.0f);
                this.eVv.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.eVn, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.eVn, "scaleY", 0.0f, 1.0f));
            } else {
                this.eVv.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
            }
            this.eVv.setInterpolator(this.eVx);
            this.eVv.setDuration(100L);
            this.eVv.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.eVp = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.eVp = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.eVp = true;
            this.eVv.start();
            if (this.eVn != null) {
                this.eVn.setVisibility(4);
            }
            this.eVl = null;
            this.eVn = null;
        }
    }

    public int by(int i, int i2) {
        if (!this.eVk) {
            aUt();
            return -1;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            aUs();
            return -1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.eVm.size()) {
                return -1;
            }
            this.eVm.get(i4).getGlobalVisibleRect(rect);
            if (!rect.contains(i, i2)) {
                i3 = i4 + 1;
            } else {
                aUs();
                return i4 + 1;
            }
        }
    }

    public void aUt() {
        if (this.eVt != null && this.eVt.isStarted()) {
            this.eVt.cancel();
            this.eVt = null;
        }
        if (this.eVu != null && this.eVu.isStarted()) {
            this.eVu.cancel();
            this.eVu = null;
        }
        if (this.eVv != null && this.eVv.isStarted()) {
            this.eVv.cancel();
            this.eVv = null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.eVm.size()) {
                ImageView imageView = this.eVm.get(i2);
                Rect a = a(getWidth() / 2, getHeight() - this.eVg, this.mRadius, (((this.eVi - this.eVh) / (this.eVm.size() - 1)) * i2) + this.eVh, this.eVd);
                imageView.setX(a.left);
                imageView.setY(a.top);
                imageView.setScaleX(1.0f);
                imageView.setScaleY(1.0f);
                imageView.invalidate();
                TextView textView = this.eVo.get(i2);
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
