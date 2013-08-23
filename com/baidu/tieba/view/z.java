package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class z extends TbImageView {
    private int b;
    private int c;
    private boolean d;
    private boolean e;
    private ViewGroup.LayoutParams f;
    private Rect g;

    public boolean d() {
        return this.d;
    }

    public void setIsWifi(boolean z) {
        this.e = z;
        if (this.e) {
            super.setSuffix("_small");
        } else {
            super.setSuffix("_mobile");
        }
    }

    public void setPicNum(int i) {
        this.c = i;
    }

    public z(Context context) {
        super(context);
        this.b = 0;
        this.c = 1;
        this.d = false;
        this.e = false;
        this.f = null;
        this.g = null;
        e();
    }

    public z(Context context, int i) {
        super(context);
        this.b = 0;
        this.c = 1;
        this.d = false;
        this.e = false;
        this.f = null;
        this.g = null;
        this.b = i;
        e();
    }

    private void e() {
        setType(this.b);
    }

    public void setType(int i) {
        this.b = i;
        if (i == 5) {
            setDefaultId(R.drawable.pic_video);
            setNightDefaultId(R.drawable.pic_video_1);
            setDefaultScaleType(ImageView.ScaleType.FIT_CENTER);
            return;
        }
        setDefaultId(R.drawable.pic_image_h_not);
        setNightDefaultId(R.drawable.pic_image_h_not_1);
        setDefaultScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }

    @Override // com.baidu.adp.widget.a.a
    public Rect getBitmapRect() {
        return this.g;
    }

    @Override // com.baidu.adp.widget.a.a
    protected Matrix b(com.baidu.adp.widget.a.b bVar) {
        float f;
        int i;
        int i2;
        int a2 = bVar.a();
        int b = bVar.b();
        int width = getWidth();
        int height = getHeight();
        if (a2 == 0 || b == 0 || width == 0 || height == 0) {
            return null;
        }
        if (this.c == 1) {
            if (a2 < (width * 3) / 10.0d || !this.e) {
                f = 1.0f;
            } else {
                f = width / a2;
            }
        } else if (a2 < ((float) ((width * 3) / 10.0d))) {
            f = 1.0f;
        } else {
            f = width / a2;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f, f);
        int i3 = ((int) (a2 * f)) - 1;
        int i4 = ((int) (f * b)) - 1;
        if (i4 <= 1.25d * height) {
            i = 0;
            i2 = 0;
        } else {
            i = 0;
            i2 = (int) ((0.5d * height) - (0.4d * i4));
            if (i2 > 0) {
                i2 = 0;
            }
        }
        matrix.postTranslate(i, i2);
        int i5 = width - i3;
        if (height - i4 > 3 || i5 > 3) {
            this.f = getLayoutParams();
            int i6 = i3 > this.f.width ? this.f.width : i3;
            int i7 = i4 > this.f.height ? this.f.height : i4;
            this.f.width = i6;
            this.f.height = i7;
            setLayoutParams(this.f);
        }
        if (this.g == null) {
            this.g = new Rect();
        }
        int i8 = i3 + 0;
        int i9 = i4 + i2;
        int i10 = i < 0 ? 0 : i;
        if (i8 > width) {
            i8 = width;
        }
        int i11 = i2 < 0 ? 0 : i2;
        int i12 = i9 > height ? height : i9;
        this.g.left = i10;
        this.g.right = i8;
        this.g.top = i11;
        this.g.bottom = i12;
        return matrix;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.widget.a.a, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
