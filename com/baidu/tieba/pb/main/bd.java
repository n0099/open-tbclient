package com.baidu.tieba.pb.main;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public final class bd extends com.baidu.tbadk.widget.k {
    private static Paint j;
    private static PaintFlagsDrawFilter k;
    private static Rect l;
    int b;
    int c;
    int d;
    Runnable e;
    private boolean f;
    private String g;
    private Animation h;
    private int i;
    private int m;
    private boolean n;

    public bd(Context context) {
        super(context);
        this.f = false;
        this.g = null;
        this.i = 0;
        this.b = 8;
        this.c = 68;
        this.d = 68;
        this.m = -1;
        this.n = false;
        this.e = new be(this);
        this.f = false;
        this.i = 0;
        this.n = com.baidu.tbadk.core.h.a().f();
        if (k == null) {
            k = new PaintFlagsDrawFilter(0, 3);
        }
        this.b = com.baidu.adp.lib.util.i.a(getContext(), 8.0f);
        this.c = com.baidu.adp.lib.util.i.a(getContext(), 68.0f);
        this.d = com.baidu.adp.lib.util.i.a(getContext(), 68.0f);
        if (j == null) {
            Paint paint = new Paint();
            j = paint;
            paint.setTextSize(getResources().getDimension(com.baidu.tieba.a.f.pb_img_text_tip));
            j.setColor(getResources().getColor(com.baidu.tieba.a.e.pb_img_text_tip));
            j.setAntiAlias(true);
        }
        this.g = this.n ? null : getResources().getString(com.baidu.tieba.a.k.pb_img_click_tip);
    }

    protected final Animation getLoadingAnimation() {
        if (this.h != null) {
            return this.h;
        }
        this.h = AnimationUtils.loadAnimation(getContext(), com.baidu.tieba.a.b.loading_rotate);
        return this.h;
    }

    public final void e() {
        removeCallbacks(this.e);
        if (TbadkApplication.j().l() == 1) {
            setNightDefaultResource(com.baidu.tieba.a.g.img_loading_1);
            if (j != null) {
                j.setColor(getResources().getColor(com.baidu.tieba.a.e.gray_night_1));
            }
        } else {
            setDefaultResource(com.baidu.tieba.a.g.img_loading);
            if (j != null) {
                j.setColor(getResources().getColor(com.baidu.tieba.a.e.pb_img_text_tip));
            }
        }
        this.g = getResources().getString(com.baidu.tieba.a.k.pb_img_loading_tip);
        setBgColor(false);
        invalidate();
        post(this.e);
    }

    public final void a(boolean z) {
        h();
        this.i = 0;
        removeCallbacks(this.e);
        this.f = false;
        if (!z) {
            setNightDefaultResource(com.baidu.tieba.a.g.icon_click_1);
            setDefaultResource(com.baidu.tieba.a.g.icon_click);
            if (TbadkApplication.j().l() == 1) {
                if (j != null) {
                    j.setColor(getResources().getColor(com.baidu.tieba.a.e.gray_night_1));
                }
            } else if (j != null) {
                j.setColor(getResources().getColor(com.baidu.tieba.a.e.pb_img_text_tip));
            }
            setBgColor(false);
            this.g = getResources().getString(com.baidu.tieba.a.k.pb_img_click_tip);
        } else {
            this.g = null;
            setBgColor(true);
        }
        invalidate();
    }

    public final void setBgColor(boolean z) {
        if (z) {
            this.m = -1;
        } else if (TbadkApplication.j().l() == 1) {
            this.m = getResources().getColor(com.baidu.tieba.a.e.pb_default_image_bg_1);
        } else {
            this.m = getResources().getColor(com.baidu.tieba.a.e.pb_default_image_bg);
        }
    }

    public final void f() {
        h();
        removeCallbacks(this.e);
        setTag(null);
        this.f = false;
        this.i = 0;
        this.m = -1;
        int l2 = TbadkApplication.j().l();
        if (this.n) {
            setNightDefaultResource(com.baidu.tieba.a.g.pic_baidu_logo_d_1);
            setDefaultResource(com.baidu.tieba.a.g.pic_baidu_logo_d);
            this.g = null;
        } else {
            setNightDefaultResource(com.baidu.tieba.a.g.icon_click_1);
            setDefaultResource(com.baidu.tieba.a.g.icon_click);
            this.g = getResources().getString(com.baidu.tieba.a.k.pb_img_click_tip);
        }
        if (l2 == 1) {
            if (j != null) {
                j.setColor(getResources().getColor(com.baidu.tieba.a.e.gray_night_1));
            }
            this.m = getResources().getColor(com.baidu.tieba.a.e.pb_default_image_bg_1);
        } else {
            if (j != null) {
                j.setColor(getResources().getColor(com.baidu.tieba.a.e.pb_img_text_tip));
            }
            this.m = getResources().getColor(com.baidu.tieba.a.e.pb_default_image_bg);
        }
        if (this.n) {
            this.m = -1;
        }
    }

    public final void g() {
        h();
        removeCallbacks(this.e);
        this.f = false;
        this.i = 0;
        this.g = null;
        this.m = -1;
        setRealShowSize(null);
        setCurrShowSize(null);
        c();
    }

    @Override // com.baidu.tbadk.widget.k
    public final void c() {
        setTag(null);
        com.baidu.tbadk.widget.j listViewActivity = getListViewActivity();
        if (listViewActivity != null) {
            listViewActivity.a(this);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        removeCallbacks(this.e);
        if (!d()) {
            this.f = false;
            this.g = this.n ? null : getResources().getString(com.baidu.tieba.a.k.pb_img_click_tip);
            return;
        }
        this.m = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.k, com.baidu.tbadk.widget.TbImageView, android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.e);
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public final void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (com.baidu.adp.lib.util.i.b(getContext()) > layoutParams.width * 10 && layoutParams.height > 600) {
            layoutParams.height = 600;
        }
        super.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.widget.k, com.baidu.tbadk.widget.TbImageView, com.baidu.adp.widget.ImageView.BDImageView
    public final com.baidu.adp.widget.ImageView.b getImage() {
        com.baidu.adp.widget.ImageView.b image = super.getImage();
        if (image != null) {
            this.g = null;
            removeCallbacks(this.e);
            this.f = false;
            setBgColor(true);
        } else {
            setBgColor(false);
        }
        if (!this.n) {
            int[] size = getSize();
            int i = size[0];
            int i2 = size[1];
            if (i > 0 && i2 > 0 && i2 <= 10000) {
                if (image == null) {
                    int[] currShowSize = getCurrShowSize();
                    if (currShowSize != null && currShowSize.length == 2 && (i != currShowSize[0] || i2 != currShowSize[1])) {
                        a(currShowSize);
                    }
                } else {
                    int[] realShowSize = getRealShowSize();
                    if (realShowSize != null && (realShowSize[0] != i || realShowSize[1] != i2)) {
                        a(realShowSize);
                    }
                }
            }
        }
        return image;
    }

    @Override // com.baidu.adp.widget.ImageView.BDImageView
    public final int getRealWidth() {
        int width = getWidth();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            return layoutParams.width;
        }
        return width;
    }

    @Override // com.baidu.adp.widget.ImageView.BDImageView
    public final int getRealHeight() {
        int height = getHeight();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            return layoutParams.height;
        }
        return height;
    }

    public final Rect getRotateInvalidRect() {
        if (l != null) {
            return l;
        }
        l = new Rect();
        int realWidth = getRealWidth();
        int realHeight = getRealHeight();
        int i = ((realWidth - this.d) / 2) - 10;
        int i2 = ((realHeight - this.c) / 2) - 10;
        int i3 = this.d + i + 10;
        int i4 = this.c + i2 + 10;
        if (i < 0) {
            i = 0;
        }
        int i5 = i2 >= 0 ? i2 : 0;
        if (i3 <= realWidth) {
            realWidth = i3;
        }
        if (i4 <= realHeight) {
            realHeight = i4;
        }
        l.set(i, i5, realWidth, realHeight);
        return l;
    }

    private void a(int[] iArr) {
        ViewGroup.LayoutParams layoutParams;
        if (iArr != null && iArr.length == 2 && (layoutParams = getLayoutParams()) != null) {
            layoutParams.width = iArr[0];
            layoutParams.height = iArr[1];
            setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    private int[] getSize() {
        int[] iArr = {getWidth(), getHeight()};
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            iArr[0] = layoutParams.width;
            iArr[1] = layoutParams.height;
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ImageView.BDImageView, android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.k, com.baidu.tbadk.widget.TbImageView, com.baidu.adp.widget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.m != -1) {
            canvas.drawColor(this.m);
        }
        if (this.f) {
            a(canvas, this.i);
        } else if (this.i != 0) {
            this.i = 0;
            a(canvas, 0);
        } else {
            super.onDraw(canvas);
        }
        if (this.g == null || canvas == null || j == null) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        float measureText = j.measureText(this.g);
        if (measureText <= width) {
            canvas.drawText(this.g, ((int) (width - measureText)) / 2, ((height + this.c) / 2) + this.b, j);
        }
    }

    private void a(Canvas canvas, int i) {
        int save = canvas.save();
        canvas.setDrawFilter(k);
        canvas.rotate(i, getWidth() / 2.0f, getHeight() / 2.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(save);
    }

    private void h() {
        bm pbView = getPbView();
        if (pbView != null) {
            pbView.a(this);
        }
    }

    public final bm getPbView() {
        Context context = getContext();
        if (context instanceof PbActivity) {
            return ((PbActivity) context).k();
        }
        return null;
    }
}
