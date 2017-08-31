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
import com.baidu.tbadk.core.util.l;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e extends ViewGroup {
    private int faA;
    private int faB;
    private boolean faC;
    private AnimatorSet faD;
    private AnimatorSet faE;
    private AnimatorSet faF;
    private Interpolator faG;
    private Interpolator faH;
    private Interpolator faI;
    private int fan;
    private int fao;
    private int fap;
    private int faq;
    private float far;
    private float fas;
    private int fat;
    private boolean fau;
    private ImageView fav;
    private List<ImageView> faw;
    private TextView fax;
    private List<TextView> fay;
    private boolean faz;
    private int mRadius;
    private int mScreenWidth;

    public e(Context context) {
        super(context);
        this.fap = 30;
        this.faq = k.g(getContext(), d.f.ds112);
        this.far = 200.0f;
        this.fas = 340.0f;
        this.fau = false;
        this.faG = new OvershootInterpolator();
        this.faH = new DecelerateInterpolator();
        this.faI = new AccelerateDecelerateInterpolator();
        init();
    }

    private void init() {
        this.fan = getResources().getDimensionPixelSize(d.f.ds132);
        this.fao = getResources().getDimensionPixelSize(d.f.ds162);
        this.faw = new ArrayList();
        for (int i = 0; i < 4; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            this.faw.add(imageView);
            addView(imageView);
        }
        this.fay = new ArrayList();
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
            this.fay.add(textView);
            addView(textView);
        }
        this.mScreenWidth = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        this.faA = k.g(getContext(), d.f.ds70);
        this.faB = k.g(getContext(), d.f.ds52);
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
        this.mRadius = a(Math.abs(this.fas - this.far), this.faw.size(), this.fan, this.fap, 100);
        this.fat = a(Math.abs(this.fas - this.far), this.faw.size(), this.fao, this.fap, 100);
        int i3 = (this.fat * 2) + this.fao + this.fap + this.faA;
        int i4 = this.fat + this.fao + this.faq;
        if (i3 > this.mScreenWidth) {
            i3 = this.mScreenWidth;
        }
        setMeasuredDimension(i3, i4);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < this.faw.size()) {
                int i7 = this.fan;
                if (this.fav != null && i6 == this.faw.indexOf(this.fav)) {
                    i7 = this.fao;
                }
                int i8 = i7;
                this.faw.get(i6).measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
                this.fay.get(i6).measure(View.MeasureSpec.makeMeasureSpec(this.faA, 1073741824), View.MeasureSpec.makeMeasureSpec(this.faB, 1073741824));
                i5 = i6 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (!this.faC) {
            int width = getWidth() / 2;
            int height = getHeight() - this.faq;
            int i6 = this.fau ? this.mRadius : 0;
            float size = (this.fas - this.far) / (this.faw.size() - 1);
            int i7 = 0;
            float f = this.far;
            while (true) {
                int i8 = i7;
                if (i8 < this.faw.size()) {
                    Rect a = a(width, height, i6, f, this.fan);
                    this.faw.get(i8).layout(a.left, a.top, a.right, a.bottom);
                    int g = this.fat + k.g(getContext(), d.f.ds106);
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
                    TextView textView = this.fay.get(i8);
                    textView.layout((int) (cos - (this.faA / 2)), (int) (sin - (this.faB / 2)), (int) (cos + (this.faA / 2)), (int) (sin + (this.faB / 2)));
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
        int height = getHeight() - this.faq;
        float size = (this.fas - this.far) / (this.faw.size() - 1);
        Rect a = a(width, height, this.mRadius, this.far + (i * size), this.fan);
        Rect a2 = a(width, height, 0, this.far + (i * size), this.fan);
        this.faD = new AnimatorSet();
        float f = this.fau ? 1.0f : 0.0f;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("alpha", f, 1.0f - f), PropertyValuesHolder.ofFloat("X", this.fau ? a.left : a2.left, this.fau ? a2.left : a.left), PropertyValuesHolder.ofFloat("Y", this.fau ? a.top : a2.top, this.fau ? a2.top : a.top));
        ofPropertyValuesHolder.setDuration(j);
        this.faD.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.faC = true;
                if (!e.this.fau) {
                    e.this.setVisibility(8);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < e.this.faw.size()) {
                            ImageView imageView = (ImageView) e.this.faw.get(i3);
                            if (imageView.getTag() != null) {
                                ((l) imageView.getTag()).stop();
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
                if (!e.this.fau) {
                    e.this.setVisibility(8);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        Rect a3 = a(width, height, this.mRadius + k.g(getContext(), d.f.ds16), this.far + (i * size), this.fan);
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("X", a.left, a3.left), PropertyValuesHolder.ofFloat("Y", a.top, a3.top));
        ofPropertyValuesHolder2.setDuration(2L);
        ObjectAnimator ofPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("X", a3.left, a.left), PropertyValuesHolder.ofFloat("Y", a3.top, a.top));
        ofPropertyValuesHolder3.setDuration(2L);
        if (!this.fau) {
            this.faD.play(ofPropertyValuesHolder);
            this.faD.setInterpolator(this.faG);
        } else {
            this.faD.playSequentially(ofPropertyValuesHolder2, ofPropertyValuesHolder3, ofPropertyValuesHolder);
            this.faD.setInterpolator(this.faH);
            this.faD.setDuration(4 + j);
        }
        this.faD.start();
    }

    public boolean arA() {
        return this.fau;
    }

    public void aWc() {
        int i;
        int i2 = 0;
        while (i2 < this.faw.size()) {
            ImageView imageView = this.faw.get(i2);
            imageView.setVisibility(0);
            if (!this.fau) {
                if (i2 == 0) {
                    i = d.b.big_praise;
                } else if (i2 == 1) {
                    i = d.b.normal_praise;
                } else if (i2 == 2) {
                    i = d.b.normal_trample;
                } else {
                    i = i2 == 3 ? d.b.big_trample : 0;
                }
                if (imageView.getTag() != null && (imageView.getTag() instanceof l)) {
                    ((l) imageView.getTag()).stop();
                    imageView.setTag(null);
                }
                l a = l.a(imageView, i, 20, Integer.MAX_VALUE);
                a.b(imageView);
                imageView.setTag(a);
            }
            d(imageView, i2, 200L);
            i2++;
        }
        this.fau = this.fau ? false : true;
        invalidate();
    }

    public void bm(int i, int i2) {
        if (!this.fau) {
            aWe();
            return;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            aWd();
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < this.faw.size()) {
                ImageView imageView = this.faw.get(i4);
                imageView.getGlobalVisibleRect(rect);
                if (!rect.contains(i, i2) || this.faz) {
                    i3 = i4 + 1;
                } else {
                    f(imageView);
                    return;
                }
            } else {
                aWd();
                return;
            }
        }
    }

    public void f(ImageView imageView) {
        if (imageView != null && this.fav != imageView && !this.faz) {
            aWe();
            this.fav = imageView;
            float size = (this.fas - this.far) / (this.faw.size() - 1);
            Rect a = a(getWidth() / 2, getHeight() - this.faq, this.mRadius, this.far + (this.faw.indexOf(imageView) * size), this.fan);
            Rect a2 = a(getWidth() / 2, getHeight() - this.faq, this.fat, (size * this.faw.indexOf(imageView)) + this.far, this.fan);
            this.faE = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, 1.3f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, 1.3f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "X", a.left, a2.left);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "Y", a.top, a2.top);
            if (this.faw.indexOf(this.fav) > -1) {
                this.fax = this.fay.get(this.faw.indexOf(this.fav));
                this.fax.setVisibility(0);
                this.fax.setAlpha(0.0f);
            }
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fax, "alpha", 0.0f, 1.0f);
            this.faE.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.fax, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.fax, "scaleY", 0.0f, 1.0f));
            this.faE.setInterpolator(this.faH);
            this.faE.setDuration(100L);
            this.faE.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.faz = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.faz = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.faz = true;
            this.faE.start();
        }
    }

    public void aWd() {
        if (this.fav != null && !this.faz) {
            float size = (this.fas - this.far) / (this.faw.size() - 1);
            Rect a = a(getWidth() / 2, getHeight() - this.faq, this.mRadius, this.far + (this.faw.indexOf(this.fav) * size), this.fan);
            Rect a2 = a(getWidth() / 2, getHeight() - this.faq, this.fat, (size * this.faw.indexOf(this.fav)) + this.far, this.fao);
            this.faF = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fav, "scaleX", 1.3f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.fav, "scaleY", 1.3f, 1.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.fav, "X", a2.left, a.left);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.fav, "Y", a2.top, a.top);
            if (this.fax != null) {
                ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fax, "alpha", 1.0f, 0.0f);
                this.faF.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.fax, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.fax, "scaleY", 0.0f, 1.0f));
            } else {
                this.faF.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
            }
            this.faF.setInterpolator(this.faH);
            this.faF.setDuration(100L);
            this.faF.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.faz = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.faz = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.faz = true;
            this.faF.start();
            if (this.fax != null) {
                this.fax.setVisibility(4);
            }
            this.fav = null;
            this.fax = null;
        }
    }

    public int bn(int i, int i2) {
        if (!this.fau) {
            aWe();
            return -1;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            aWd();
            return -1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.faw.size()) {
                return -1;
            }
            this.faw.get(i4).getGlobalVisibleRect(rect);
            if (!rect.contains(i, i2)) {
                i3 = i4 + 1;
            } else {
                aWd();
                return i4 + 1;
            }
        }
    }

    public void aWe() {
        if (this.faD != null && this.faD.isStarted()) {
            this.faD.cancel();
            this.faD = null;
        }
        if (this.faE != null && this.faE.isStarted()) {
            this.faE.cancel();
            this.faE = null;
        }
        if (this.faF != null && this.faF.isStarted()) {
            this.faF.cancel();
            this.faF = null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.faw.size()) {
                ImageView imageView = this.faw.get(i2);
                Rect a = a(getWidth() / 2, getHeight() - this.faq, this.mRadius, (((this.fas - this.far) / (this.faw.size() - 1)) * i2) + this.far, this.fan);
                imageView.setX(a.left);
                imageView.setY(a.top);
                imageView.setScaleX(1.0f);
                imageView.setScaleY(1.0f);
                imageView.invalidate();
                TextView textView = this.fay.get(i2);
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
