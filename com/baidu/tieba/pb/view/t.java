package com.baidu.tieba.pb.view;

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
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t extends ViewGroup {
    private int eLX;
    private int eLY;
    private int eLZ;
    private int eMa;
    private float eMb;
    private float eMc;
    private int eMd;
    private boolean eMe;
    private ImageView eMf;
    private List<ImageView> eMg;
    private TextView eMh;
    private List<TextView> eMi;
    private boolean eMj;
    private int eMk;
    private int eMl;
    private boolean eMm;
    private AnimatorSet eMn;
    private AnimatorSet eMo;
    private AnimatorSet eMp;
    private Interpolator eMq;
    private Interpolator eMr;
    private Interpolator eMs;
    private int mRadius;
    private int mScreenWidth;

    public t(Context context) {
        super(context);
        this.eLZ = 30;
        this.eMa = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds112);
        this.eMb = 200.0f;
        this.eMc = 340.0f;
        this.eMe = false;
        this.eMq = new OvershootInterpolator();
        this.eMr = new DecelerateInterpolator();
        this.eMs = new AccelerateDecelerateInterpolator();
        init();
    }

    private void init() {
        this.eLX = getResources().getDimensionPixelSize(w.f.ds132);
        this.eLY = getResources().getDimensionPixelSize(w.f.ds162);
        this.eMg = new ArrayList();
        for (int i = 0; i < 4; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            this.eMg.add(imageView);
            addView(imageView);
        }
        this.eMi = new ArrayList();
        for (int i2 = 0; i2 < 4; i2++) {
            TextView textView = new TextView(getContext());
            switch (i2) {
                case 0:
                    textView.setText(w.l.pb_big_praise);
                    break;
                case 1:
                    textView.setText(w.l.pb_normal_praise);
                    break;
                case 2:
                    textView.setText(w.l.pb_normal_trample);
                    break;
                case 3:
                    textView.setText(w.l.pb_big_trample);
                    break;
            }
            textView.setBackgroundResource(w.g.praise_text_bg);
            textView.setTextSize(0, com.baidu.adp.lib.util.k.g(getContext(), w.f.fontsize22));
            textView.setTextColor(-1);
            textView.setGravity(17);
            textView.setVisibility(4);
            this.eMi.add(textView);
            addView(textView);
        }
        this.mScreenWidth = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        this.eMk = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds70);
        this.eMl = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds52);
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
        this.mRadius = a(Math.abs(this.eMc - this.eMb), this.eMg.size(), this.eLX, this.eLZ, 100);
        this.eMd = a(Math.abs(this.eMc - this.eMb), this.eMg.size(), this.eLY, this.eLZ, 100);
        int i3 = (this.eMd * 2) + this.eLY + this.eLZ + this.eMk;
        int i4 = this.eMd + this.eLY + this.eMa;
        if (i3 > this.mScreenWidth) {
            i3 = this.mScreenWidth;
        }
        setMeasuredDimension(i3, i4);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < this.eMg.size()) {
                int i7 = this.eLX;
                if (this.eMf != null && i6 == this.eMg.indexOf(this.eMf)) {
                    i7 = this.eLY;
                }
                int i8 = i7;
                this.eMg.get(i6).measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
                this.eMi.get(i6).measure(View.MeasureSpec.makeMeasureSpec(this.eMk, 1073741824), View.MeasureSpec.makeMeasureSpec(this.eMl, 1073741824));
                i5 = i6 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (!this.eMm) {
            int width = getWidth() / 2;
            int height = getHeight() - this.eMa;
            int i6 = this.eMe ? this.mRadius : 0;
            float size = (this.eMc - this.eMb) / (this.eMg.size() - 1);
            int i7 = 0;
            float f = this.eMb;
            while (true) {
                int i8 = i7;
                if (i8 < this.eMg.size()) {
                    Rect a = a(width, height, i6, f, this.eLX);
                    this.eMg.get(i8).layout(a.left, a.top, a.right, a.bottom);
                    int g = this.eMd + com.baidu.adp.lib.util.k.g(getContext(), w.f.ds106);
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
                    double sin = height + (g * Math.sin(Math.toRadians(i5 + f)));
                    TextView textView = this.eMi.get(i8);
                    textView.layout((int) (cos - (this.eMk / 2)), (int) (sin - (this.eMl / 2)), (int) (cos + (this.eMk / 2)), (int) (sin + (this.eMl / 2)));
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
        int height = getHeight() - this.eMa;
        float size = (this.eMc - this.eMb) / (this.eMg.size() - 1);
        Rect a = a(width, height, this.mRadius, this.eMb + (i * size), this.eLX);
        Rect a2 = a(width, height, 0, this.eMb + (i * size), this.eLX);
        this.eMn = new AnimatorSet();
        float f = this.eMe ? 1.0f : 0.0f;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("alpha", f, 1.0f - f), PropertyValuesHolder.ofFloat("X", this.eMe ? a.left : a2.left, this.eMe ? a2.left : a.left), PropertyValuesHolder.ofFloat("Y", this.eMe ? a.top : a2.top, this.eMe ? a2.top : a.top));
        ofPropertyValuesHolder.setDuration(j);
        this.eMn.addListener(new u(this));
        Rect a3 = a(width, height, this.mRadius + com.baidu.adp.lib.util.k.g(getContext(), w.f.ds16), (size * i) + this.eMb, this.eLX);
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("X", a.left, a3.left), PropertyValuesHolder.ofFloat("Y", a.top, a3.top));
        ofPropertyValuesHolder2.setDuration(2L);
        ObjectAnimator ofPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("X", a3.left, a.left), PropertyValuesHolder.ofFloat("Y", a3.top, a.top));
        ofPropertyValuesHolder3.setDuration(2L);
        if (!this.eMe) {
            this.eMn.play(ofPropertyValuesHolder);
            this.eMn.setInterpolator(this.eMq);
        } else {
            this.eMn.playSequentially(ofPropertyValuesHolder2, ofPropertyValuesHolder3, ofPropertyValuesHolder);
            this.eMn.setInterpolator(this.eMr);
            this.eMn.setDuration(4 + j);
        }
        this.eMn.start();
    }

    public boolean anx() {
        return this.eMe;
    }

    public void aTg() {
        int i;
        int i2 = 0;
        while (i2 < this.eMg.size()) {
            ImageView imageView = this.eMg.get(i2);
            imageView.setVisibility(0);
            if (!this.eMe) {
                if (i2 == 0) {
                    i = w.b.big_praise;
                } else if (i2 == 1) {
                    i = w.b.normal_praise;
                } else if (i2 == 2) {
                    i = w.b.normal_trample;
                } else {
                    i = i2 == 3 ? w.b.big_trample : 0;
                }
                if (imageView.getTag() != null && (imageView.getTag() instanceof com.baidu.tieba.pb.pb.main.view.c)) {
                    ((com.baidu.tieba.pb.pb.main.view.c) imageView.getTag()).stop();
                    imageView.setTag(null);
                }
                com.baidu.tieba.pb.pb.main.view.c b = com.baidu.tieba.pb.pb.main.view.c.b(imageView, i, 20, Integer.MAX_VALUE);
                b.start();
                imageView.setTag(b);
            }
            d(imageView, i2, 200L);
            i2++;
        }
        this.eMe = this.eMe ? false : true;
        invalidate();
    }

    public void be(int i, int i2) {
        if (!this.eMe) {
            aTi();
            return;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            aTh();
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < this.eMg.size()) {
                ImageView imageView = this.eMg.get(i4);
                imageView.getGlobalVisibleRect(rect);
                if (!rect.contains(i, i2) || this.eMj) {
                    i3 = i4 + 1;
                } else {
                    i(imageView);
                    return;
                }
            } else {
                aTh();
                return;
            }
        }
    }

    public void i(ImageView imageView) {
        if (imageView != null && this.eMf != imageView && !this.eMj) {
            aTi();
            this.eMf = imageView;
            float size = (this.eMc - this.eMb) / (this.eMg.size() - 1);
            Rect a = a(getWidth() / 2, getHeight() - this.eMa, this.mRadius, this.eMb + (this.eMg.indexOf(imageView) * size), this.eLX);
            Rect a2 = a(getWidth() / 2, getHeight() - this.eMa, this.eMd, (size * this.eMg.indexOf(imageView)) + this.eMb, this.eLX);
            this.eMo = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, 1.3f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, 1.3f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "X", a.left, a2.left);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, "Y", a.top, a2.top);
            if (this.eMg.indexOf(this.eMf) > -1) {
                this.eMh = this.eMi.get(this.eMg.indexOf(this.eMf));
                this.eMh.setVisibility(0);
                this.eMh.setAlpha(0.0f);
            }
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.eMh, "alpha", 0.0f, 1.0f);
            this.eMo.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.eMh, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.eMh, "scaleY", 0.0f, 1.0f));
            this.eMo.setInterpolator(this.eMr);
            this.eMo.setDuration(100L);
            this.eMo.addListener(new v(this));
            this.eMj = true;
            this.eMo.start();
        }
    }

    public void aTh() {
        if (this.eMf != null && !this.eMj) {
            float size = (this.eMc - this.eMb) / (this.eMg.size() - 1);
            Rect a = a(getWidth() / 2, getHeight() - this.eMa, this.mRadius, this.eMb + (this.eMg.indexOf(this.eMf) * size), this.eLX);
            Rect a2 = a(getWidth() / 2, getHeight() - this.eMa, this.eMd, (size * this.eMg.indexOf(this.eMf)) + this.eMb, this.eLY);
            this.eMp = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.eMf, "scaleX", 1.3f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.eMf, "scaleY", 1.3f, 1.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.eMf, "X", a2.left, a.left);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.eMf, "Y", a2.top, a.top);
            if (this.eMh != null) {
                ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.eMh, "alpha", 1.0f, 0.0f);
                this.eMp.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ObjectAnimator.ofFloat(this.eMh, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.eMh, "scaleY", 0.0f, 1.0f));
            } else {
                this.eMp.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
            }
            this.eMp.setInterpolator(this.eMr);
            this.eMp.setDuration(100L);
            this.eMp.addListener(new w(this));
            this.eMj = true;
            this.eMp.start();
            if (this.eMh != null) {
                this.eMh.setVisibility(4);
            }
            this.eMf = null;
            this.eMh = null;
        }
    }

    public int bf(int i, int i2) {
        if (!this.eMe) {
            aTi();
            return -1;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (!rect.contains(i, i2)) {
            aTh();
            return -1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.eMg.size()) {
                return -1;
            }
            this.eMg.get(i4).getGlobalVisibleRect(rect);
            if (!rect.contains(i, i2)) {
                i3 = i4 + 1;
            } else {
                aTh();
                return i4 + 1;
            }
        }
    }

    public void aTi() {
        if (this.eMn != null && this.eMn.isStarted()) {
            this.eMn.cancel();
            this.eMn = null;
        }
        if (this.eMo != null && this.eMo.isStarted()) {
            this.eMo.cancel();
            this.eMo = null;
        }
        if (this.eMp != null && this.eMp.isStarted()) {
            this.eMp.cancel();
            this.eMp = null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.eMg.size()) {
                ImageView imageView = this.eMg.get(i2);
                Rect a = a(getWidth() / 2, getHeight() - this.eMa, this.mRadius, (((this.eMc - this.eMb) / (this.eMg.size() - 1)) * i2) + this.eMb, this.eLX);
                imageView.setX(a.left);
                imageView.setY(a.top);
                imageView.setScaleX(1.0f);
                imageView.setScaleY(1.0f);
                imageView.invalidate();
                TextView textView = this.eMi.get(i2);
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
