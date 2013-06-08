package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class q extends ImageView {
    private Matrix a;
    private int b;
    private int c;
    private Paint d;
    private int e;
    private int f;
    private boolean g;
    private boolean h;
    private String i;
    private ViewGroup.LayoutParams j;

    public boolean a() {
        return this.g;
    }

    public void setIsThree(boolean z) {
    }

    public void setIsWifi(boolean z) {
        this.h = z;
        if (this.h) {
            this.i = "_small";
        } else {
            this.i = "_mobile";
        }
    }

    public void setPicNum(int i) {
        this.f = i;
    }

    public q(Context context, int i) {
        super(context);
        this.a = new Matrix();
        this.b = 0;
        this.c = 0;
        this.d = new Paint();
        this.e = 0;
        this.f = 1;
        this.g = false;
        this.h = false;
        this.i = null;
        this.j = null;
        this.e = i;
        b();
    }

    private void b() {
        this.d = new Paint();
        this.d.setAntiAlias(true);
    }

    public void setType(int i) {
        this.e = i;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        Bitmap a;
        super.onDraw(canvas);
        com.baidu.adp.widget.a.b c = com.baidu.tbadk.a.e.a().c(String.valueOf((String) getTag()) + this.i);
        this.a.reset();
        if (c == null) {
            this.g = false;
            if (this.e == 5) {
                if (TiebaApplication.d().ar() == 1) {
                    a = com.baidu.tieba.d.d.a((int) R.drawable.pic_video_1);
                } else {
                    a = com.baidu.tieba.d.d.a((int) R.drawable.pic_video);
                }
                float min = Math.min(getWidth() / a.getWidth(), getHeight() / a.getHeight());
                this.a.setScale(min, min);
                this.g = true;
            } else {
                if (TiebaApplication.d().ar() == 1) {
                    a = com.baidu.tieba.d.d.a((int) R.drawable.pic_image_h_not_1);
                } else {
                    a = com.baidu.tieba.d.d.a((int) R.drawable.pic_image_h_not);
                }
                this.b = (getWidth() - a.getWidth()) >> 1;
                this.c = (getHeight() - a.getHeight()) >> 1;
                this.a.postTranslate(this.b, this.c);
                if (TiebaApplication.d().ar() == 1) {
                    canvas.drawColor(-13815750);
                }
            }
            canvas.drawBitmap(a, this.a, this.d);
        } else if (c != null) {
            int a2 = c.a();
            int b = c.b();
            int width = getWidth();
            int height = getHeight();
            if (a2 != 0 && b != 0 && width != 0 && height != 0) {
                if (this.f == 1) {
                    f = (((double) a2) < ((double) (width * 3)) / 10.0d || !this.h) ? 1.0f : width / a2;
                } else {
                    f = ((float) a2) < ((float) (((double) (width * 3)) / 10.0d)) ? 1.0f : width / a2;
                }
                this.a.setScale(f, f);
                int i = ((int) (a2 * f)) - 1;
                int i2 = ((int) (f * b)) - 1;
                if (i2 <= 1.25d * height) {
                    this.b = 0;
                    this.c = 0;
                } else {
                    this.b = 0;
                    this.c = (int) ((0.5d * height) - (0.4d * i2));
                    if (this.c > 0) {
                        this.c = 0;
                    }
                }
                this.a.postTranslate(this.b, this.c);
                if (height - i2 > 3) {
                    this.j = getLayoutParams();
                    this.j.width = i;
                    this.j.height = i2;
                    setLayoutParams(this.j);
                }
                c.a(canvas, this.a, this.d);
            }
        }
    }
}
