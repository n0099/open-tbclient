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
    private int fbF;
    private int fbG;
    private int fbH;
    private int fbI;
    private float fbJ;
    private float fbK;
    private int fbL;
    private boolean fbM;
    private ImageView fbN;
    private List<ImageView> fbO;
    private TextView fbP;
    private List<TextView> fbQ;
    private boolean fbR;
    private int fbS;
    private int fbT;
    private boolean fbU;
    private AnimatorSet fbV;
    private AnimatorSet fbW;
    private AnimatorSet fbX;
    private Interpolator fbY;
    private Interpolator fbZ;
    private Interpolator fca;
    private int mRadius;
    private int mScreenWidth;

    public e(Context context) {
        super(context);
        this.fbH = 30;
        this.fbI = k.g(getContext(), d.f.ds112);
        this.fbJ = 200.0f;
        this.fbK = 340.0f;
        this.fbM = false;
        this.fbY = new OvershootInterpolator();
        this.fbZ = new DecelerateInterpolator();
        this.fca = new AccelerateDecelerateInterpolator();
        init();
    }

    private void init() {
        this.fbF = getResources().getDimensionPixelSize(d.f.ds132);
        this.fbG = getResources().getDimensionPixelSize(d.f.ds162);
        this.fbO = new ArrayList();
        for (int i = 0; i < 4; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            this.fbO.add(imageView);
            addView(imageView);
        }
        this.fbQ = new ArrayList();
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
            this.fbQ.add(textView);
            addView(textView);
        }
        this.mScreenWidth = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        this.fbS = k.g(getContext(), d.f.ds70);
        this.fbT = k.g(getContext(), d.f.ds52);
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
        this.mRadius = a(Math.abs(this.fbK - this.fbJ), this.fbO.size(), this.fbF, this.fbH, 100);
        this.fbL = a(Math.abs(this.fbK - this.fbJ), this.fbO.size(), this.fbG, this.fbH, 100);
        int i3 = (this.fbL * 2) + this.fbG + this.fbH + this.fbS;
        int i4 = this.fbL + this.fbG + this.fbI;
        if (i3 > this.mScreenWidth) {
            i3 = this.mScreenWidth;
        }
        setMeasuredDimension(i3, i4);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < this.fbO.size()) {
                int i7 = this.fbF;
                if (this.fbN != null && i6 == this.fbO.indexOf(this.fbN)) {
                    i7 = this.fbG;
                }
                int i8 = i7;
                this.fbO.get(i6).measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
                this.fbQ.get(i6).measure(View.MeasureSpec.makeMeasureSpec(this.fbS, 1073741824), View.MeasureSpec.makeMeasureSpec(this.fbT, 1073741824));
                i5 = i6 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (!this.fbU) {
            int width = getWidth() / 2;
            int height = getHeight() - this.fbI;
            int i6 = this.fbM ? this.mRadius : 0;
            float size = (this.fbK - this.fbJ) / (this.fbO.size() - 1);
            int i7 = 0;
            float f = this.fbJ;
            while (true) {
                int i8 = i7;
                if (i8 < this.fbO.size()) {
                    Rect a = a(width, height, i6, f, this.fbF);
                    this.fbO.get(i8).layout(a.left, a.top, a.right, a.bottom);
                    int g = this.fbL + k.g(getContext(), d.f.ds106);
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
                    TextView textView = this.fbQ.get(i8);
                    textView.layout((int) (cos - (this.fbS / 2)), (int) (sin - (this.fbT / 2)), (int) (cos + (this.fbS / 2)), (int) (sin + (this.fbT / 2)));
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
        int height = getHeight() - this.fbI;
        float size = (this.fbK - this.fbJ) / (this.fbO.size() - 1);
        Rect a = a(width, height, this.mRadius, this.fbJ + (i * size), this.fbF);
        Rect a2 = a(width, height, 0, this.fbJ + (i * size), this.fbF);
        this.fbV = new AnimatorSet();
        float f = this.fbM ? 1.0f : 0.0f;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("alpha", f, 1.0f - f), PropertyValuesHolder.ofFloat("X", this.fbM ? a.left : a2.left, this.fbM ? a2.left : a.left), PropertyValuesHolder.ofFloat("Y", this.fbM ? a.top : a2.top, this.fbM ? a2.top : a.top));
        ofPropertyValuesHolder.setDuration(j);
        this.fbV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.fbU = true;
                if (!e.this.fbM) {
                    e.this.setVisibility(8);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < e.this.fbO.size()) {
                            ImageView imageView = (ImageView) e.this.fbO.get(i3);
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
                if (!e.this.fbM) {
                    e.this.setVisibility(8);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        Rect a3 = a(width, height, this.mRadius + k.g(getContext(), d.f.ds16), this.fbJ + (i * size), this.fbF);
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("X", a.left, a3.left), PropertyValuesHolder.ofFloat("Y", a.top, a3.top));
        ofPropertyValuesHolder2.setDuration(2L);
        ObjectAnimator ofPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("X", a3.left, a.left), PropertyValuesHolder.ofFloat("Y", a3.top, a.top));
        ofPropertyValuesHolder3.setDuration(2L);
        if (!this.fbM) {
            this.fbV.play(ofPropertyValuesHolder);
            this.fbV.setInterpolator(this.fbY);
        } else {
            this.fbV.playSequentially(ofPropertyValuesHolder2, ofPropertyValuesHolder3, ofPropertyValuesHolder);
            this.fbV.setInterpolator(this.fbZ);
            this.fbV.setDuration(4 + j);
        }
        this.fbV.start();
    }

    public boolean apQ() {
        return this.fbM;
    }

    public void aWQ() {
        int i;
        int i2 = 0;
        while (i2 < this.fbO.size()) {
            ImageView imageView = this.fbO.get(i2);
            imageView.setVisibility(0);
            if (!this.fbM) {
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
        this.fbM = this.fbM ? false : true;
        invalidate();
    }

    public void bn(int i, int i2) {
        if (!this.fbM) {
            aWS();
            return;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            aWR();
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < this.fbO.size()) {
                ImageView imageView = this.fbO.get(i4);
                imageView.getGlobalVisibleRect(rect);
                if (!rect.contains(i, i2) || this.fbR) {
                    i3 = i4 + 1;
                } else {
                    i(imageView);
                    return;
                }
            } else {
                aWR();
                return;
            }
        }
    }

    public void i(ImageView imageView) {
        if (imageView != null && this.fbN != imageView && !this.fbR) {
            aWS();
            this.fbN = imageView;
            float size = (this.fbK - this.fbJ) / (this.fbO.size() - 1);
            Rect a = a(getWidth() / 2, getHeight() - this.fbI, this.mRadius, this.fbJ + (this.fbO.indexOf(imageView) * size), this.fbF);
            Rect a2 = a(getWidth() / 2, getHeight() - this.fbI, this.fbL, (size * this.fbO.indexOf(imageView)) + this.fbJ, this.fbF);
            this.fbW = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, 1.3f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, 1.3f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "X", a.left, a2.left);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "Y", a.top, a2.top);
            if (this.fbO.indexOf(this.fbN) > -1) {
                this.fbP = this.fbQ.get(this.fbO.indexOf(this.fbN));
                this.fbP.setVisibility(0);
                this.fbP.setAlpha(0.0f);
            }
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fbP, "alpha", 0.0f, 1.0f);
            this.fbW.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.fbP, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.fbP, "scaleY", 0.0f, 1.0f));
            this.fbW.setInterpolator(this.fbZ);
            this.fbW.setDuration(100L);
            this.fbW.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.fbR = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.fbR = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fbR = true;
            this.fbW.start();
        }
    }

    public void aWR() {
        if (this.fbN != null && !this.fbR) {
            float size = (this.fbK - this.fbJ) / (this.fbO.size() - 1);
            Rect a = a(getWidth() / 2, getHeight() - this.fbI, this.mRadius, this.fbJ + (this.fbO.indexOf(this.fbN) * size), this.fbF);
            Rect a2 = a(getWidth() / 2, getHeight() - this.fbI, this.fbL, (size * this.fbO.indexOf(this.fbN)) + this.fbJ, this.fbG);
            this.fbX = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fbN, "scaleX", 1.3f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.fbN, "scaleY", 1.3f, 1.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.fbN, "X", a2.left, a.left);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.fbN, "Y", a2.top, a.top);
            if (this.fbP != null) {
                ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fbP, "alpha", 1.0f, 0.0f);
                this.fbX.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.fbP, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.fbP, "scaleY", 0.0f, 1.0f));
            } else {
                this.fbX.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
            }
            this.fbX.setInterpolator(this.fbZ);
            this.fbX.setDuration(100L);
            this.fbX.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.fbR = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.fbR = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fbR = true;
            this.fbX.start();
            if (this.fbP != null) {
                this.fbP.setVisibility(4);
            }
            this.fbN = null;
            this.fbP = null;
        }
    }

    public int bo(int i, int i2) {
        if (!this.fbM) {
            aWS();
            return -1;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            aWR();
            return -1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.fbO.size()) {
                return -1;
            }
            this.fbO.get(i4).getGlobalVisibleRect(rect);
            if (!rect.contains(i, i2)) {
                i3 = i4 + 1;
            } else {
                aWR();
                return i4 + 1;
            }
        }
    }

    public void aWS() {
        if (this.fbV != null && this.fbV.isStarted()) {
            this.fbV.cancel();
            this.fbV = null;
        }
        if (this.fbW != null && this.fbW.isStarted()) {
            this.fbW.cancel();
            this.fbW = null;
        }
        if (this.fbX != null && this.fbX.isStarted()) {
            this.fbX.cancel();
            this.fbX = null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fbO.size()) {
                ImageView imageView = this.fbO.get(i2);
                Rect a = a(getWidth() / 2, getHeight() - this.fbI, this.mRadius, (((this.fbK - this.fbJ) / (this.fbO.size() - 1)) * i2) + this.fbJ, this.fbF);
                imageView.setX(a.left);
                imageView.setY(a.top);
                imageView.setScaleX(1.0f);
                imageView.setScaleY(1.0f);
                imageView.invalidate();
                TextView textView = this.fbQ.get(i2);
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
