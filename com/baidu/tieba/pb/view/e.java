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
    private int fbD;
    private int fbE;
    private int fbF;
    private int fbG;
    private float fbH;
    private float fbI;
    private int fbJ;
    private boolean fbK;
    private ImageView fbL;
    private List<ImageView> fbM;
    private TextView fbN;
    private List<TextView> fbO;
    private boolean fbP;
    private int fbQ;
    private int fbR;
    private boolean fbS;
    private AnimatorSet fbT;
    private AnimatorSet fbU;
    private AnimatorSet fbV;
    private Interpolator fbW;
    private Interpolator fbX;
    private Interpolator fbY;
    private int mRadius;
    private int mScreenWidth;

    public e(Context context) {
        super(context);
        this.fbF = 30;
        this.fbG = k.g(getContext(), d.f.ds112);
        this.fbH = 200.0f;
        this.fbI = 340.0f;
        this.fbK = false;
        this.fbW = new OvershootInterpolator();
        this.fbX = new DecelerateInterpolator();
        this.fbY = new AccelerateDecelerateInterpolator();
        init();
    }

    private void init() {
        this.fbD = getResources().getDimensionPixelSize(d.f.ds132);
        this.fbE = getResources().getDimensionPixelSize(d.f.ds162);
        this.fbM = new ArrayList();
        for (int i = 0; i < 4; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            this.fbM.add(imageView);
            addView(imageView);
        }
        this.fbO = new ArrayList();
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
            this.fbO.add(textView);
            addView(textView);
        }
        this.mScreenWidth = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        this.fbQ = k.g(getContext(), d.f.ds70);
        this.fbR = k.g(getContext(), d.f.ds52);
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
        this.mRadius = a(Math.abs(this.fbI - this.fbH), this.fbM.size(), this.fbD, this.fbF, 100);
        this.fbJ = a(Math.abs(this.fbI - this.fbH), this.fbM.size(), this.fbE, this.fbF, 100);
        int i3 = (this.fbJ * 2) + this.fbE + this.fbF + this.fbQ;
        int i4 = this.fbJ + this.fbE + this.fbG;
        if (i3 > this.mScreenWidth) {
            i3 = this.mScreenWidth;
        }
        setMeasuredDimension(i3, i4);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < this.fbM.size()) {
                int i7 = this.fbD;
                if (this.fbL != null && i6 == this.fbM.indexOf(this.fbL)) {
                    i7 = this.fbE;
                }
                int i8 = i7;
                this.fbM.get(i6).measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
                this.fbO.get(i6).measure(View.MeasureSpec.makeMeasureSpec(this.fbQ, 1073741824), View.MeasureSpec.makeMeasureSpec(this.fbR, 1073741824));
                i5 = i6 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (!this.fbS) {
            int width = getWidth() / 2;
            int height = getHeight() - this.fbG;
            int i6 = this.fbK ? this.mRadius : 0;
            float size = (this.fbI - this.fbH) / (this.fbM.size() - 1);
            int i7 = 0;
            float f = this.fbH;
            while (true) {
                int i8 = i7;
                if (i8 < this.fbM.size()) {
                    Rect a = a(width, height, i6, f, this.fbD);
                    this.fbM.get(i8).layout(a.left, a.top, a.right, a.bottom);
                    int g = this.fbJ + k.g(getContext(), d.f.ds106);
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
                    TextView textView = this.fbO.get(i8);
                    textView.layout((int) (cos - (this.fbQ / 2)), (int) (sin - (this.fbR / 2)), (int) (cos + (this.fbQ / 2)), (int) (sin + (this.fbR / 2)));
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
        int height = getHeight() - this.fbG;
        float size = (this.fbI - this.fbH) / (this.fbM.size() - 1);
        Rect a = a(width, height, this.mRadius, this.fbH + (i * size), this.fbD);
        Rect a2 = a(width, height, 0, this.fbH + (i * size), this.fbD);
        this.fbT = new AnimatorSet();
        float f = this.fbK ? 1.0f : 0.0f;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("alpha", f, 1.0f - f), PropertyValuesHolder.ofFloat("X", this.fbK ? a.left : a2.left, this.fbK ? a2.left : a.left), PropertyValuesHolder.ofFloat("Y", this.fbK ? a.top : a2.top, this.fbK ? a2.top : a.top));
        ofPropertyValuesHolder.setDuration(j);
        this.fbT.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.fbS = true;
                if (!e.this.fbK) {
                    e.this.setVisibility(8);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < e.this.fbM.size()) {
                            ImageView imageView = (ImageView) e.this.fbM.get(i3);
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
                if (!e.this.fbK) {
                    e.this.setVisibility(8);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        Rect a3 = a(width, height, this.mRadius + k.g(getContext(), d.f.ds16), this.fbH + (i * size), this.fbD);
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("X", a.left, a3.left), PropertyValuesHolder.ofFloat("Y", a.top, a3.top));
        ofPropertyValuesHolder2.setDuration(2L);
        ObjectAnimator ofPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("X", a3.left, a.left), PropertyValuesHolder.ofFloat("Y", a3.top, a.top));
        ofPropertyValuesHolder3.setDuration(2L);
        if (!this.fbK) {
            this.fbT.play(ofPropertyValuesHolder);
            this.fbT.setInterpolator(this.fbW);
        } else {
            this.fbT.playSequentially(ofPropertyValuesHolder2, ofPropertyValuesHolder3, ofPropertyValuesHolder);
            this.fbT.setInterpolator(this.fbX);
            this.fbT.setDuration(4 + j);
        }
        this.fbT.start();
    }

    public boolean apW() {
        return this.fbK;
    }

    public void aWV() {
        int i;
        int i2 = 0;
        while (i2 < this.fbM.size()) {
            ImageView imageView = this.fbM.get(i2);
            imageView.setVisibility(0);
            if (!this.fbK) {
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
        this.fbK = this.fbK ? false : true;
        invalidate();
    }

    public void bn(int i, int i2) {
        if (!this.fbK) {
            aWX();
            return;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            aWW();
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < this.fbM.size()) {
                ImageView imageView = this.fbM.get(i4);
                imageView.getGlobalVisibleRect(rect);
                if (!rect.contains(i, i2) || this.fbP) {
                    i3 = i4 + 1;
                } else {
                    i(imageView);
                    return;
                }
            } else {
                aWW();
                return;
            }
        }
    }

    public void i(ImageView imageView) {
        if (imageView != null && this.fbL != imageView && !this.fbP) {
            aWX();
            this.fbL = imageView;
            float size = (this.fbI - this.fbH) / (this.fbM.size() - 1);
            Rect a = a(getWidth() / 2, getHeight() - this.fbG, this.mRadius, this.fbH + (this.fbM.indexOf(imageView) * size), this.fbD);
            Rect a2 = a(getWidth() / 2, getHeight() - this.fbG, this.fbJ, (size * this.fbM.indexOf(imageView)) + this.fbH, this.fbD);
            this.fbU = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, 1.3f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, 1.3f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "X", a.left, a2.left);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "Y", a.top, a2.top);
            if (this.fbM.indexOf(this.fbL) > -1) {
                this.fbN = this.fbO.get(this.fbM.indexOf(this.fbL));
                this.fbN.setVisibility(0);
                this.fbN.setAlpha(0.0f);
            }
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fbN, "alpha", 0.0f, 1.0f);
            this.fbU.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.fbN, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.fbN, "scaleY", 0.0f, 1.0f));
            this.fbU.setInterpolator(this.fbX);
            this.fbU.setDuration(100L);
            this.fbU.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.fbP = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.fbP = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fbP = true;
            this.fbU.start();
        }
    }

    public void aWW() {
        if (this.fbL != null && !this.fbP) {
            float size = (this.fbI - this.fbH) / (this.fbM.size() - 1);
            Rect a = a(getWidth() / 2, getHeight() - this.fbG, this.mRadius, this.fbH + (this.fbM.indexOf(this.fbL) * size), this.fbD);
            Rect a2 = a(getWidth() / 2, getHeight() - this.fbG, this.fbJ, (size * this.fbM.indexOf(this.fbL)) + this.fbH, this.fbE);
            this.fbV = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fbL, "scaleX", 1.3f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.fbL, "scaleY", 1.3f, 1.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.fbL, "X", a2.left, a.left);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.fbL, "Y", a2.top, a.top);
            if (this.fbN != null) {
                ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fbN, "alpha", 1.0f, 0.0f);
                this.fbV.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.fbN, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.fbN, "scaleY", 0.0f, 1.0f));
            } else {
                this.fbV.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
            }
            this.fbV.setInterpolator(this.fbX);
            this.fbV.setDuration(100L);
            this.fbV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.fbP = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.fbP = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fbP = true;
            this.fbV.start();
            if (this.fbN != null) {
                this.fbN.setVisibility(4);
            }
            this.fbL = null;
            this.fbN = null;
        }
    }

    public int bo(int i, int i2) {
        if (!this.fbK) {
            aWX();
            return -1;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            aWW();
            return -1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.fbM.size()) {
                return -1;
            }
            this.fbM.get(i4).getGlobalVisibleRect(rect);
            if (!rect.contains(i, i2)) {
                i3 = i4 + 1;
            } else {
                aWW();
                return i4 + 1;
            }
        }
    }

    public void aWX() {
        if (this.fbT != null && this.fbT.isStarted()) {
            this.fbT.cancel();
            this.fbT = null;
        }
        if (this.fbU != null && this.fbU.isStarted()) {
            this.fbU.cancel();
            this.fbU = null;
        }
        if (this.fbV != null && this.fbV.isStarted()) {
            this.fbV.cancel();
            this.fbV = null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fbM.size()) {
                ImageView imageView = this.fbM.get(i2);
                Rect a = a(getWidth() / 2, getHeight() - this.fbG, this.mRadius, (((this.fbI - this.fbH) / (this.fbM.size() - 1)) * i2) + this.fbH, this.fbD);
                imageView.setX(a.left);
                imageView.setY(a.top);
                imageView.setScaleX(1.0f);
                imageView.setScaleY(1.0f);
                imageView.invalidate();
                TextView textView = this.fbO.get(i2);
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
