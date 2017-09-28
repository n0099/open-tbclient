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
    private List<ImageView> eVA;
    private TextView eVB;
    private List<TextView> eVC;
    private boolean eVD;
    private int eVE;
    private int eVF;
    private boolean eVG;
    private AnimatorSet eVH;
    private AnimatorSet eVI;
    private AnimatorSet eVJ;
    private Interpolator eVK;
    private Interpolator eVL;
    private Interpolator eVM;
    private int eVr;
    private int eVs;
    private int eVt;
    private int eVu;
    private float eVv;
    private float eVw;
    private int eVx;
    private boolean eVy;
    private ImageView eVz;
    private int mRadius;
    private int mScreenWidth;

    public e(Context context) {
        super(context);
        this.eVt = 30;
        this.eVu = l.f(getContext(), d.f.ds112);
        this.eVv = 200.0f;
        this.eVw = 340.0f;
        this.eVy = false;
        this.eVK = new OvershootInterpolator();
        this.eVL = new DecelerateInterpolator();
        this.eVM = new AccelerateDecelerateInterpolator();
        init();
    }

    private void init() {
        this.eVr = getResources().getDimensionPixelSize(d.f.ds132);
        this.eVs = getResources().getDimensionPixelSize(d.f.ds162);
        this.eVA = new ArrayList();
        for (int i = 0; i < 4; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            this.eVA.add(imageView);
            addView(imageView);
        }
        this.eVC = new ArrayList();
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
            this.eVC.add(textView);
            addView(textView);
        }
        this.mScreenWidth = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        this.eVE = l.f(getContext(), d.f.ds70);
        this.eVF = l.f(getContext(), d.f.ds52);
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
        this.mRadius = a(Math.abs(this.eVw - this.eVv), this.eVA.size(), this.eVr, this.eVt, 100);
        this.eVx = a(Math.abs(this.eVw - this.eVv), this.eVA.size(), this.eVs, this.eVt, 100);
        int i3 = (this.eVx * 2) + this.eVs + this.eVt + this.eVE;
        int i4 = this.eVx + this.eVs + this.eVu;
        if (i3 > this.mScreenWidth) {
            i3 = this.mScreenWidth;
        }
        setMeasuredDimension(i3, i4);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < this.eVA.size()) {
                int i7 = this.eVr;
                if (this.eVz != null && i6 == this.eVA.indexOf(this.eVz)) {
                    i7 = this.eVs;
                }
                int i8 = i7;
                this.eVA.get(i6).measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
                this.eVC.get(i6).measure(View.MeasureSpec.makeMeasureSpec(this.eVE, 1073741824), View.MeasureSpec.makeMeasureSpec(this.eVF, 1073741824));
                i5 = i6 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (!this.eVG) {
            int width = getWidth() / 2;
            int height = getHeight() - this.eVu;
            int i6 = this.eVy ? this.mRadius : 0;
            float size = (this.eVw - this.eVv) / (this.eVA.size() - 1);
            int i7 = 0;
            float f = this.eVv;
            while (true) {
                int i8 = i7;
                if (i8 < this.eVA.size()) {
                    Rect a = a(width, height, i6, f, this.eVr);
                    this.eVA.get(i8).layout(a.left, a.top, a.right, a.bottom);
                    int f2 = this.eVx + l.f(getContext(), d.f.ds106);
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
                    TextView textView = this.eVC.get(i8);
                    textView.layout((int) (cos - (this.eVE / 2)), (int) (sin - (this.eVF / 2)), (int) (cos + (this.eVE / 2)), (int) (sin + (this.eVF / 2)));
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
        int height = getHeight() - this.eVu;
        float size = (this.eVw - this.eVv) / (this.eVA.size() - 1);
        Rect a = a(width, height, this.mRadius, this.eVv + (i * size), this.eVr);
        Rect a2 = a(width, height, 0, this.eVv + (i * size), this.eVr);
        this.eVH = new AnimatorSet();
        float f = this.eVy ? 1.0f : 0.0f;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("alpha", f, 1.0f - f), PropertyValuesHolder.ofFloat("X", this.eVy ? a.left : a2.left, this.eVy ? a2.left : a.left), PropertyValuesHolder.ofFloat("Y", this.eVy ? a.top : a2.top, this.eVy ? a2.top : a.top));
        ofPropertyValuesHolder.setDuration(j);
        this.eVH.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.eVG = true;
                if (!e.this.eVy) {
                    e.this.setVisibility(8);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < e.this.eVA.size()) {
                            ImageView imageView = (ImageView) e.this.eVA.get(i3);
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
                if (!e.this.eVy) {
                    e.this.setVisibility(8);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        Rect a3 = a(width, height, this.mRadius + l.f(getContext(), d.f.ds16), this.eVv + (i * size), this.eVr);
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("X", a.left, a3.left), PropertyValuesHolder.ofFloat("Y", a.top, a3.top));
        ofPropertyValuesHolder2.setDuration(2L);
        ObjectAnimator ofPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("X", a3.left, a.left), PropertyValuesHolder.ofFloat("Y", a3.top, a.top));
        ofPropertyValuesHolder3.setDuration(2L);
        if (!this.eVy) {
            this.eVH.play(ofPropertyValuesHolder);
            this.eVH.setInterpolator(this.eVK);
        } else {
            this.eVH.playSequentially(ofPropertyValuesHolder2, ofPropertyValuesHolder3, ofPropertyValuesHolder);
            this.eVH.setInterpolator(this.eVL);
            this.eVH.setDuration(4 + j);
        }
        this.eVH.start();
    }

    public boolean aqr() {
        return this.eVy;
    }

    public void aUw() {
        int i;
        int i2 = 0;
        while (i2 < this.eVA.size()) {
            ImageView imageView = this.eVA.get(i2);
            imageView.setVisibility(0);
            if (!this.eVy) {
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
        this.eVy = this.eVy ? false : true;
        invalidate();
    }

    public void bx(int i, int i2) {
        if (!this.eVy) {
            aUy();
            return;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            aUx();
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < this.eVA.size()) {
                ImageView imageView = this.eVA.get(i4);
                imageView.getGlobalVisibleRect(rect);
                if (!rect.contains(i, i2) || this.eVD) {
                    i3 = i4 + 1;
                } else {
                    f(imageView);
                    return;
                }
            } else {
                aUx();
                return;
            }
        }
    }

    public void f(ImageView imageView) {
        if (imageView != null && this.eVz != imageView && !this.eVD) {
            aUy();
            this.eVz = imageView;
            float size = (this.eVw - this.eVv) / (this.eVA.size() - 1);
            Rect a = a(getWidth() / 2, getHeight() - this.eVu, this.mRadius, this.eVv + (this.eVA.indexOf(imageView) * size), this.eVr);
            Rect a2 = a(getWidth() / 2, getHeight() - this.eVu, this.eVx, (size * this.eVA.indexOf(imageView)) + this.eVv, this.eVr);
            this.eVI = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, 1.3f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, 1.3f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "X", a.left, a2.left);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "Y", a.top, a2.top);
            if (this.eVA.indexOf(this.eVz) > -1) {
                this.eVB = this.eVC.get(this.eVA.indexOf(this.eVz));
                this.eVB.setVisibility(0);
                this.eVB.setAlpha(0.0f);
            }
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.eVB, "alpha", 0.0f, 1.0f);
            this.eVI.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.eVB, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.eVB, "scaleY", 0.0f, 1.0f));
            this.eVI.setInterpolator(this.eVL);
            this.eVI.setDuration(100L);
            this.eVI.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.eVD = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.eVD = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.eVD = true;
            this.eVI.start();
        }
    }

    public void aUx() {
        if (this.eVz != null && !this.eVD) {
            float size = (this.eVw - this.eVv) / (this.eVA.size() - 1);
            Rect a = a(getWidth() / 2, getHeight() - this.eVu, this.mRadius, this.eVv + (this.eVA.indexOf(this.eVz) * size), this.eVr);
            Rect a2 = a(getWidth() / 2, getHeight() - this.eVu, this.eVx, (size * this.eVA.indexOf(this.eVz)) + this.eVv, this.eVs);
            this.eVJ = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.eVz, "scaleX", 1.3f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.eVz, "scaleY", 1.3f, 1.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.eVz, "X", a2.left, a.left);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.eVz, "Y", a2.top, a.top);
            if (this.eVB != null) {
                ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.eVB, "alpha", 1.0f, 0.0f);
                this.eVJ.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.eVB, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.eVB, "scaleY", 0.0f, 1.0f));
            } else {
                this.eVJ.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
            }
            this.eVJ.setInterpolator(this.eVL);
            this.eVJ.setDuration(100L);
            this.eVJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.eVD = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.eVD = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.eVD = true;
            this.eVJ.start();
            if (this.eVB != null) {
                this.eVB.setVisibility(4);
            }
            this.eVz = null;
            this.eVB = null;
        }
    }

    public int by(int i, int i2) {
        if (!this.eVy) {
            aUy();
            return -1;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            aUx();
            return -1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.eVA.size()) {
                return -1;
            }
            this.eVA.get(i4).getGlobalVisibleRect(rect);
            if (!rect.contains(i, i2)) {
                i3 = i4 + 1;
            } else {
                aUx();
                return i4 + 1;
            }
        }
    }

    public void aUy() {
        if (this.eVH != null && this.eVH.isStarted()) {
            this.eVH.cancel();
            this.eVH = null;
        }
        if (this.eVI != null && this.eVI.isStarted()) {
            this.eVI.cancel();
            this.eVI = null;
        }
        if (this.eVJ != null && this.eVJ.isStarted()) {
            this.eVJ.cancel();
            this.eVJ = null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.eVA.size()) {
                ImageView imageView = this.eVA.get(i2);
                Rect a = a(getWidth() / 2, getHeight() - this.eVu, this.mRadius, (((this.eVw - this.eVv) / (this.eVA.size() - 1)) * i2) + this.eVv, this.eVr);
                imageView.setX(a.left);
                imageView.setY(a.top);
                imageView.setScaleX(1.0f);
                imageView.setScaleY(1.0f);
                imageView.invalidate();
                TextView textView = this.eVC.get(i2);
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
