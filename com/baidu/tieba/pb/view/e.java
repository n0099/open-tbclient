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
    private Interpolator fbA;
    private Interpolator fbB;
    private Interpolator fbC;
    private int fbh;
    private int fbi;
    private int fbj;
    private int fbk;
    private float fbl;
    private float fbm;
    private int fbn;
    private boolean fbo;
    private ImageView fbp;
    private List<ImageView> fbq;
    private TextView fbr;
    private List<TextView> fbs;
    private boolean fbt;
    private int fbu;
    private int fbv;
    private boolean fbw;
    private AnimatorSet fbx;
    private AnimatorSet fby;
    private AnimatorSet fbz;
    private int mRadius;
    private int mScreenWidth;

    public e(Context context) {
        super(context);
        this.fbj = 30;
        this.fbk = k.f(getContext(), d.f.ds112);
        this.fbl = 200.0f;
        this.fbm = 340.0f;
        this.fbo = false;
        this.fbA = new OvershootInterpolator();
        this.fbB = new DecelerateInterpolator();
        this.fbC = new AccelerateDecelerateInterpolator();
        init();
    }

    private void init() {
        this.fbh = getResources().getDimensionPixelSize(d.f.ds132);
        this.fbi = getResources().getDimensionPixelSize(d.f.ds162);
        this.fbq = new ArrayList();
        for (int i = 0; i < 4; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            this.fbq.add(imageView);
            addView(imageView);
        }
        this.fbs = new ArrayList();
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
            textView.setTextSize(0, k.f(getContext(), d.f.fontsize22));
            textView.setTextColor(-1);
            textView.setGravity(17);
            textView.setVisibility(4);
            this.fbs.add(textView);
            addView(textView);
        }
        this.mScreenWidth = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        this.fbu = k.f(getContext(), d.f.ds70);
        this.fbv = k.f(getContext(), d.f.ds52);
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
        this.mRadius = a(Math.abs(this.fbm - this.fbl), this.fbq.size(), this.fbh, this.fbj, 100);
        this.fbn = a(Math.abs(this.fbm - this.fbl), this.fbq.size(), this.fbi, this.fbj, 100);
        int i3 = (this.fbn * 2) + this.fbi + this.fbj + this.fbu;
        int i4 = this.fbn + this.fbi + this.fbk;
        if (i3 > this.mScreenWidth) {
            i3 = this.mScreenWidth;
        }
        setMeasuredDimension(i3, i4);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < this.fbq.size()) {
                int i7 = this.fbh;
                if (this.fbp != null && i6 == this.fbq.indexOf(this.fbp)) {
                    i7 = this.fbi;
                }
                int i8 = i7;
                this.fbq.get(i6).measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
                this.fbs.get(i6).measure(View.MeasureSpec.makeMeasureSpec(this.fbu, 1073741824), View.MeasureSpec.makeMeasureSpec(this.fbv, 1073741824));
                i5 = i6 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (!this.fbw) {
            int width = getWidth() / 2;
            int height = getHeight() - this.fbk;
            int i6 = this.fbo ? this.mRadius : 0;
            float size = (this.fbm - this.fbl) / (this.fbq.size() - 1);
            int i7 = 0;
            float f = this.fbl;
            while (true) {
                int i8 = i7;
                if (i8 < this.fbq.size()) {
                    Rect a = a(width, height, i6, f, this.fbh);
                    this.fbq.get(i8).layout(a.left, a.top, a.right, a.bottom);
                    int f2 = this.fbn + k.f(getContext(), d.f.ds106);
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
                    TextView textView = this.fbs.get(i8);
                    textView.layout((int) (cos - (this.fbu / 2)), (int) (sin - (this.fbv / 2)), (int) (cos + (this.fbu / 2)), (int) (sin + (this.fbv / 2)));
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
        int height = getHeight() - this.fbk;
        float size = (this.fbm - this.fbl) / (this.fbq.size() - 1);
        Rect a = a(width, height, this.mRadius, this.fbl + (i * size), this.fbh);
        Rect a2 = a(width, height, 0, this.fbl + (i * size), this.fbh);
        this.fbx = new AnimatorSet();
        float f = this.fbo ? 1.0f : 0.0f;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("alpha", f, 1.0f - f), PropertyValuesHolder.ofFloat("X", this.fbo ? a.left : a2.left, this.fbo ? a2.left : a.left), PropertyValuesHolder.ofFloat("Y", this.fbo ? a.top : a2.top, this.fbo ? a2.top : a.top));
        ofPropertyValuesHolder.setDuration(j);
        this.fbx.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.fbw = true;
                if (!e.this.fbo) {
                    e.this.setVisibility(8);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < e.this.fbq.size()) {
                            ImageView imageView = (ImageView) e.this.fbq.get(i3);
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
                if (!e.this.fbo) {
                    e.this.setVisibility(8);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        Rect a3 = a(width, height, this.mRadius + k.f(getContext(), d.f.ds16), this.fbl + (i * size), this.fbh);
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("X", a.left, a3.left), PropertyValuesHolder.ofFloat("Y", a.top, a3.top));
        ofPropertyValuesHolder2.setDuration(2L);
        ObjectAnimator ofPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("X", a3.left, a.left), PropertyValuesHolder.ofFloat("Y", a3.top, a.top));
        ofPropertyValuesHolder3.setDuration(2L);
        if (!this.fbo) {
            this.fbx.play(ofPropertyValuesHolder);
            this.fbx.setInterpolator(this.fbA);
        } else {
            this.fbx.playSequentially(ofPropertyValuesHolder2, ofPropertyValuesHolder3, ofPropertyValuesHolder);
            this.fbx.setInterpolator(this.fbB);
            this.fbx.setDuration(4 + j);
        }
        this.fbx.start();
    }

    public boolean arL() {
        return this.fbo;
    }

    public void aWn() {
        int i;
        int i2 = 0;
        while (i2 < this.fbq.size()) {
            ImageView imageView = this.fbq.get(i2);
            imageView.setVisibility(0);
            if (!this.fbo) {
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
        this.fbo = this.fbo ? false : true;
        invalidate();
    }

    public void bq(int i, int i2) {
        if (!this.fbo) {
            aWp();
            return;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            aWo();
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < this.fbq.size()) {
                ImageView imageView = this.fbq.get(i4);
                imageView.getGlobalVisibleRect(rect);
                if (!rect.contains(i, i2) || this.fbt) {
                    i3 = i4 + 1;
                } else {
                    f(imageView);
                    return;
                }
            } else {
                aWo();
                return;
            }
        }
    }

    public void f(ImageView imageView) {
        if (imageView != null && this.fbp != imageView && !this.fbt) {
            aWp();
            this.fbp = imageView;
            float size = (this.fbm - this.fbl) / (this.fbq.size() - 1);
            Rect a = a(getWidth() / 2, getHeight() - this.fbk, this.mRadius, this.fbl + (this.fbq.indexOf(imageView) * size), this.fbh);
            Rect a2 = a(getWidth() / 2, getHeight() - this.fbk, this.fbn, (size * this.fbq.indexOf(imageView)) + this.fbl, this.fbh);
            this.fby = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, 1.3f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, 1.3f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "X", a.left, a2.left);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "Y", a.top, a2.top);
            if (this.fbq.indexOf(this.fbp) > -1) {
                this.fbr = this.fbs.get(this.fbq.indexOf(this.fbp));
                this.fbr.setVisibility(0);
                this.fbr.setAlpha(0.0f);
            }
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fbr, "alpha", 0.0f, 1.0f);
            this.fby.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.fbr, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.fbr, "scaleY", 0.0f, 1.0f));
            this.fby.setInterpolator(this.fbB);
            this.fby.setDuration(100L);
            this.fby.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.fbt = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.fbt = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fbt = true;
            this.fby.start();
        }
    }

    public void aWo() {
        if (this.fbp != null && !this.fbt) {
            float size = (this.fbm - this.fbl) / (this.fbq.size() - 1);
            Rect a = a(getWidth() / 2, getHeight() - this.fbk, this.mRadius, this.fbl + (this.fbq.indexOf(this.fbp) * size), this.fbh);
            Rect a2 = a(getWidth() / 2, getHeight() - this.fbk, this.fbn, (size * this.fbq.indexOf(this.fbp)) + this.fbl, this.fbi);
            this.fbz = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fbp, "scaleX", 1.3f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.fbp, "scaleY", 1.3f, 1.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.fbp, "X", a2.left, a.left);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.fbp, "Y", a2.top, a.top);
            if (this.fbr != null) {
                ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fbr, "alpha", 1.0f, 0.0f);
                this.fbz.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.fbr, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.fbr, "scaleY", 0.0f, 1.0f));
            } else {
                this.fbz.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
            }
            this.fbz.setInterpolator(this.fbB);
            this.fbz.setDuration(100L);
            this.fbz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.view.e.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.fbt = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.fbt = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fbt = true;
            this.fbz.start();
            if (this.fbr != null) {
                this.fbr.setVisibility(4);
            }
            this.fbp = null;
            this.fbr = null;
        }
    }

    public int br(int i, int i2) {
        if (!this.fbo) {
            aWp();
            return -1;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            aWo();
            return -1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.fbq.size()) {
                return -1;
            }
            this.fbq.get(i4).getGlobalVisibleRect(rect);
            if (!rect.contains(i, i2)) {
                i3 = i4 + 1;
            } else {
                aWo();
                return i4 + 1;
            }
        }
    }

    public void aWp() {
        if (this.fbx != null && this.fbx.isStarted()) {
            this.fbx.cancel();
            this.fbx = null;
        }
        if (this.fby != null && this.fby.isStarted()) {
            this.fby.cancel();
            this.fby = null;
        }
        if (this.fbz != null && this.fbz.isStarted()) {
            this.fbz.cancel();
            this.fbz = null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fbq.size()) {
                ImageView imageView = this.fbq.get(i2);
                Rect a = a(getWidth() / 2, getHeight() - this.fbk, this.mRadius, (((this.fbm - this.fbl) / (this.fbq.size() - 1)) * i2) + this.fbl, this.fbh);
                imageView.setX(a.left);
                imageView.setY(a.top);
                imageView.setScaleX(1.0f);
                imageView.setScaleY(1.0f);
                imageView.invalidate();
                TextView textView = this.fbs.get(i2);
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
