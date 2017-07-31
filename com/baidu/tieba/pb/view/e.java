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
    private int eZK;
    private int eZL;
    private int eZM;
    private int eZN;
    private float eZO;
    private float eZP;
    private int eZQ;
    private boolean eZR;
    private ImageView eZS;
    private List<ImageView> eZT;
    private TextView eZU;
    private List<TextView> eZV;
    private boolean eZW;
    private int eZX;
    private int eZY;
    private boolean eZZ;
    private AnimatorSet faa;
    private AnimatorSet fab;
    private AnimatorSet fac;
    private Interpolator fad;
    private Interpolator fae;
    private Interpolator faf;
    private int mRadius;
    private int mScreenWidth;

    public e(Context context) {
        super(context);
        this.eZM = 30;
        this.eZN = k.g(getContext(), d.f.ds112);
        this.eZO = 200.0f;
        this.eZP = 340.0f;
        this.eZR = false;
        this.fad = new OvershootInterpolator();
        this.fae = new DecelerateInterpolator();
        this.faf = new AccelerateDecelerateInterpolator();
        init();
    }

    private void init() {
        this.eZK = getResources().getDimensionPixelSize(d.f.ds132);
        this.eZL = getResources().getDimensionPixelSize(d.f.ds162);
        this.eZT = new ArrayList();
        for (int i = 0; i < 4; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            this.eZT.add(imageView);
            addView(imageView);
        }
        this.eZV = new ArrayList();
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
            this.eZV.add(textView);
            addView(textView);
        }
        this.mScreenWidth = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        this.eZX = k.g(getContext(), d.f.ds70);
        this.eZY = k.g(getContext(), d.f.ds52);
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
        this.mRadius = a(Math.abs(this.eZP - this.eZO), this.eZT.size(), this.eZK, this.eZM, 100);
        this.eZQ = a(Math.abs(this.eZP - this.eZO), this.eZT.size(), this.eZL, this.eZM, 100);
        int i3 = (this.eZQ * 2) + this.eZL + this.eZM + this.eZX;
        int i4 = this.eZQ + this.eZL + this.eZN;
        if (i3 > this.mScreenWidth) {
            i3 = this.mScreenWidth;
        }
        setMeasuredDimension(i3, i4);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < this.eZT.size()) {
                int i7 = this.eZK;
                if (this.eZS != null && i6 == this.eZT.indexOf(this.eZS)) {
                    i7 = this.eZL;
                }
                int i8 = i7;
                this.eZT.get(i6).measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
                this.eZV.get(i6).measure(View.MeasureSpec.makeMeasureSpec(this.eZX, 1073741824), View.MeasureSpec.makeMeasureSpec(this.eZY, 1073741824));
                i5 = i6 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (!this.eZZ) {
            int width = getWidth() / 2;
            int height = getHeight() - this.eZN;
            int i6 = this.eZR ? this.mRadius : 0;
            float size = (this.eZP - this.eZO) / (this.eZT.size() - 1);
            int i7 = 0;
            float f = this.eZO;
            while (true) {
                int i8 = i7;
                if (i8 < this.eZT.size()) {
                    Rect a = a(width, height, i6, f, this.eZK);
                    this.eZT.get(i8).layout(a.left, a.top, a.right, a.bottom);
                    int g = this.eZQ + k.g(getContext(), d.f.ds106);
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
                    TextView textView = this.eZV.get(i8);
                    textView.layout((int) (cos - (this.eZX / 2)), (int) (sin - (this.eZY / 2)), (int) (cos + (this.eZX / 2)), (int) (sin + (this.eZY / 2)));
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
        int height = getHeight() - this.eZN;
        float size = (this.eZP - this.eZO) / (this.eZT.size() - 1);
        Rect a = a(width, height, this.mRadius, this.eZO + (i * size), this.eZK);
        Rect a2 = a(width, height, 0, this.eZO + (i * size), this.eZK);
        this.faa = new AnimatorSet();
        float f = this.eZR ? 1.0f : 0.0f;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("alpha", f, 1.0f - f), PropertyValuesHolder.ofFloat("X", this.eZR ? a.left : a2.left, this.eZR ? a2.left : a.left), PropertyValuesHolder.ofFloat("Y", this.eZR ? a.top : a2.top, this.eZR ? a2.top : a.top));
        ofPropertyValuesHolder.setDuration(j);
        this.faa.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.eZZ = true;
                if (!e.this.eZR) {
                    e.this.setVisibility(8);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < e.this.eZT.size()) {
                            ImageView imageView = (ImageView) e.this.eZT.get(i3);
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
                if (!e.this.eZR) {
                    e.this.setVisibility(8);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        Rect a3 = a(width, height, this.mRadius + k.g(getContext(), d.f.ds16), this.eZO + (i * size), this.eZK);
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("X", a.left, a3.left), PropertyValuesHolder.ofFloat("Y", a.top, a3.top));
        ofPropertyValuesHolder2.setDuration(2L);
        ObjectAnimator ofPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("X", a3.left, a.left), PropertyValuesHolder.ofFloat("Y", a3.top, a.top));
        ofPropertyValuesHolder3.setDuration(2L);
        if (!this.eZR) {
            this.faa.play(ofPropertyValuesHolder);
            this.faa.setInterpolator(this.fad);
        } else {
            this.faa.playSequentially(ofPropertyValuesHolder2, ofPropertyValuesHolder3, ofPropertyValuesHolder);
            this.faa.setInterpolator(this.fae);
            this.faa.setDuration(4 + j);
        }
        this.faa.start();
    }

    public boolean app() {
        return this.eZR;
    }

    public void aWo() {
        int i;
        int i2 = 0;
        while (i2 < this.eZT.size()) {
            ImageView imageView = this.eZT.get(i2);
            imageView.setVisibility(0);
            if (!this.eZR) {
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
        this.eZR = this.eZR ? false : true;
        invalidate();
    }

    public void bf(int i, int i2) {
        if (!this.eZR) {
            aWq();
            return;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            aWp();
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < this.eZT.size()) {
                ImageView imageView = this.eZT.get(i4);
                imageView.getGlobalVisibleRect(rect);
                if (!rect.contains(i, i2) || this.eZW) {
                    i3 = i4 + 1;
                } else {
                    i(imageView);
                    return;
                }
            } else {
                aWp();
                return;
            }
        }
    }

    public void i(ImageView imageView) {
        if (imageView != null && this.eZS != imageView && !this.eZW) {
            aWq();
            this.eZS = imageView;
            float size = (this.eZP - this.eZO) / (this.eZT.size() - 1);
            Rect a = a(getWidth() / 2, getHeight() - this.eZN, this.mRadius, this.eZO + (this.eZT.indexOf(imageView) * size), this.eZK);
            Rect a2 = a(getWidth() / 2, getHeight() - this.eZN, this.eZQ, (size * this.eZT.indexOf(imageView)) + this.eZO, this.eZK);
            this.fab = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, 1.3f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, 1.3f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "X", a.left, a2.left);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "Y", a.top, a2.top);
            if (this.eZT.indexOf(this.eZS) > -1) {
                this.eZU = this.eZV.get(this.eZT.indexOf(this.eZS));
                this.eZU.setVisibility(0);
                this.eZU.setAlpha(0.0f);
            }
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.eZU, "alpha", 0.0f, 1.0f);
            this.fab.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.eZU, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.eZU, "scaleY", 0.0f, 1.0f));
            this.fab.setInterpolator(this.fae);
            this.fab.setDuration(100L);
            this.fab.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.eZW = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.eZW = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.eZW = true;
            this.fab.start();
        }
    }

    public void aWp() {
        if (this.eZS != null && !this.eZW) {
            float size = (this.eZP - this.eZO) / (this.eZT.size() - 1);
            Rect a = a(getWidth() / 2, getHeight() - this.eZN, this.mRadius, this.eZO + (this.eZT.indexOf(this.eZS) * size), this.eZK);
            Rect a2 = a(getWidth() / 2, getHeight() - this.eZN, this.eZQ, (size * this.eZT.indexOf(this.eZS)) + this.eZO, this.eZL);
            this.fac = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.eZS, "scaleX", 1.3f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.eZS, "scaleY", 1.3f, 1.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.eZS, "X", a2.left, a.left);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.eZS, "Y", a2.top, a.top);
            if (this.eZU != null) {
                ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.eZU, "alpha", 1.0f, 0.0f);
                this.fac.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.eZU, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.eZU, "scaleY", 0.0f, 1.0f));
            } else {
                this.fac.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
            }
            this.fac.setInterpolator(this.fae);
            this.fac.setDuration(100L);
            this.fac.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.eZW = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.eZW = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.eZW = true;
            this.fac.start();
            if (this.eZU != null) {
                this.eZU.setVisibility(4);
            }
            this.eZS = null;
            this.eZU = null;
        }
    }

    public int bg(int i, int i2) {
        if (!this.eZR) {
            aWq();
            return -1;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            aWp();
            return -1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.eZT.size()) {
                return -1;
            }
            this.eZT.get(i4).getGlobalVisibleRect(rect);
            if (!rect.contains(i, i2)) {
                i3 = i4 + 1;
            } else {
                aWp();
                return i4 + 1;
            }
        }
    }

    public void aWq() {
        if (this.faa != null && this.faa.isStarted()) {
            this.faa.cancel();
            this.faa = null;
        }
        if (this.fab != null && this.fab.isStarted()) {
            this.fab.cancel();
            this.fab = null;
        }
        if (this.fac != null && this.fac.isStarted()) {
            this.fac.cancel();
            this.fac = null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.eZT.size()) {
                ImageView imageView = this.eZT.get(i2);
                Rect a = a(getWidth() / 2, getHeight() - this.eZN, this.mRadius, (((this.eZP - this.eZO) / (this.eZT.size() - 1)) * i2) + this.eZO, this.eZK);
                imageView.setX(a.left);
                imageView.setY(a.top);
                imageView.setScaleX(1.0f);
                imageView.setScaleY(1.0f);
                imageView.invalidate();
                TextView textView = this.eZV.get(i2);
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
