package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.pb.cr;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ba extends com.baidu.tbadk.widget.b {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int a(ba baVar, int i) {
        int i2 = baVar.i + i;
        baVar.i = i2;
        return i2;
    }

    public ba(Context context) {
        super(context);
        this.f = false;
        this.g = null;
        this.i = 0;
        this.b = 8;
        this.c = 68;
        this.d = 68;
        this.m = -1;
        this.n = false;
        this.e = new bb(this);
        i();
    }

    private void i() {
        this.f = false;
        this.i = 0;
        this.n = com.baidu.tieba.d.a.a().f();
        if (k == null) {
            k = new PaintFlagsDrawFilter(0, 3);
        }
        this.b = UtilHelper.a(getContext(), 8.0f);
        this.c = UtilHelper.a(getContext(), 68.0f);
        this.d = UtilHelper.a(getContext(), 68.0f);
        if (j == null) {
            j = new Paint();
            j.setTextSize(getResources().getDimension(R.dimen.pb_img_text_tip));
            j.setColor(getResources().getColor(R.color.pb_img_text_tip));
            j.setAntiAlias(true);
        }
        this.g = this.n ? null : getResources().getString(R.string.pb_img_click_tip);
    }

    private Animation getLoadingAnimation() {
        if (this.h != null) {
            return this.h;
        }
        this.h = AnimationUtils.loadAnimation(getContext(), R.anim.loading_rotate);
        return this.h;
    }

    public void e() {
        removeCallbacks(this.e);
        if (TiebaApplication.g().ap() == 1) {
            setNightDefaultResource(R.drawable.img_loading_1);
            if (j != null) {
                j.setColor(getResources().getColor(R.color.gray_night_1));
            }
        } else {
            setDefaultResource(R.drawable.img_loading);
            if (j != null) {
                j.setColor(getResources().getColor(R.color.pb_img_text_tip));
            }
        }
        this.g = getResources().getString(R.string.pb_img_loading_tip);
        setBgColor(false);
        invalidate();
        post(this.e);
    }

    public void a(boolean z) {
        h();
        this.i = 0;
        removeCallbacks(this.e);
        this.f = false;
        if (!z) {
            setNightDefaultResource(R.drawable.icon_click_1);
            setDefaultResource(R.drawable.icon_click);
            if (TiebaApplication.g().ap() == 1) {
                if (j != null) {
                    j.setColor(getResources().getColor(R.color.gray_night_1));
                }
            } else if (j != null) {
                j.setColor(getResources().getColor(R.color.pb_img_text_tip));
            }
            setBgColor(false);
            this.g = getResources().getString(R.string.pb_img_click_tip);
        } else {
            this.g = null;
            setBgColor(true);
        }
        invalidate();
    }

    public void setBgColor(boolean z) {
        if (z) {
            this.m = -1;
        } else if (TiebaApplication.g().ap() == 1) {
            this.m = getResources().getColor(R.color.pb_default_image_bg_1);
        } else {
            this.m = getResources().getColor(R.color.pb_default_image_bg);
        }
    }

    public void f() {
        h();
        removeCallbacks(this.e);
        setTag(null);
        this.f = false;
        this.i = 0;
        this.m = -1;
        int ap = TiebaApplication.g().ap();
        if (this.n) {
            setNightDefaultResource(R.drawable.pic_baidu_logo_d_1);
            setDefaultResource(R.drawable.pic_baidu_logo_d);
            this.g = null;
        } else {
            setNightDefaultResource(R.drawable.icon_click_1);
            setDefaultResource(R.drawable.icon_click);
            this.g = getResources().getString(R.string.pb_img_click_tip);
        }
        if (ap == 1) {
            if (j != null) {
                j.setColor(getResources().getColor(R.color.gray_night_1));
            }
            this.m = getResources().getColor(R.color.pb_default_image_bg_1);
        } else {
            if (j != null) {
                j.setColor(getResources().getColor(R.color.pb_img_text_tip));
            }
            this.m = getResources().getColor(R.color.pb_default_image_bg);
        }
        if (this.n) {
            this.m = -1;
        }
    }

    public void g() {
        h();
        removeCallbacks(this.e);
        this.f = false;
        this.i = 0;
        this.g = null;
        this.m = -1;
        setRealShowSize(null);
        setCurrShowSize(null);
        d();
    }

    @Override // com.baidu.tbadk.widget.b
    public void d() {
        setTag(null);
        com.baidu.tbadk.widget.a listViewActivity = getListViewActivity();
        if (listViewActivity != null) {
            listViewActivity.a(this);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        removeCallbacks(this.e);
        if (!c()) {
            this.f = false;
            this.g = this.n ? null : getResources().getString(R.string.pb_img_click_tip);
            return;
        }
        this.m = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.b, com.baidu.tbadk.widget.TbImageView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.e);
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (UtilHelper.a(getContext()) > layoutParams.width * 10 && layoutParams.height > 600) {
            layoutParams.height = 600;
        }
        super.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.widget.b, com.baidu.tbadk.widget.TbImageView, com.baidu.adp.widget.ImageView.a
    public com.baidu.adp.widget.ImageView.e getImage() {
        com.baidu.adp.widget.ImageView.e image = super.getImage();
        if (image != null) {
            this.g = null;
            removeCallbacks(this.e);
            this.f = false;
            setBgColor(true);
        } else {
            setBgColor(false);
        }
        c(image);
        return image;
    }

    public void c(com.baidu.adp.widget.ImageView.e eVar) {
        if (!this.n) {
            int[] size = getSize();
            int i = size[0];
            int i2 = size[1];
            if (i > 0 && i2 > 0 && i2 <= 10000) {
                if (eVar == null) {
                    int[] currShowSize = getCurrShowSize();
                    if (currShowSize != null && currShowSize.length == 2) {
                        if (i != currShowSize[0] || i2 != currShowSize[1]) {
                            a(currShowSize);
                            return;
                        }
                        return;
                    }
                    return;
                }
                int[] realShowSize = getRealShowSize();
                if (realShowSize != null) {
                    if (realShowSize[0] != i || realShowSize[1] != i2) {
                        a(realShowSize);
                    }
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ImageView.a
    public int getRealWidth() {
        int width = getWidth();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            return layoutParams.width;
        }
        return width;
    }

    @Override // com.baidu.adp.widget.ImageView.a
    public int getRealHeight() {
        int height = getHeight();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            return layoutParams.height;
        }
        return height;
    }

    public Rect getRotateInvalidRect() {
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

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.b, com.baidu.tbadk.widget.TbImageView, com.baidu.adp.widget.ImageView.a, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
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
        a(canvas);
    }

    private void a(Canvas canvas, int i) {
        int save = canvas.save();
        canvas.setDrawFilter(k);
        canvas.rotate(i, getWidth() / 2.0f, getHeight() / 2.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(save);
    }

    private void a(Canvas canvas) {
        if (this.g != null && canvas != null && j != null) {
            int width = getWidth();
            int height = getHeight();
            float measureText = j.measureText(this.g);
            if (measureText <= width) {
                canvas.drawText(this.g, ((int) (width - measureText)) / 2, ((height + this.c) / 2) + this.b, j);
            }
        }
    }

    public void h() {
        cr pbView = getPbView();
        if (pbView != null) {
            pbView.b(this);
        }
    }

    public cr getPbView() {
        Context context = getContext();
        if (context instanceof NewPbActivity) {
            return ((NewPbActivity) context).b();
        }
        return null;
    }
}
