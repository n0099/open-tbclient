package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class p extends ImageView {
    private Matrix a;
    private boolean b;
    private int c;
    private int d;
    private Paint e;
    private int f;
    private int g;
    private boolean h;
    private ViewGroup.LayoutParams i;

    public boolean a() {
        return this.h;
    }

    public void setIsThree(boolean z) {
    }

    public void setPicNum(int i) {
        this.g = i;
    }

    public p(Context context, int i) {
        super(context);
        this.a = new Matrix();
        this.b = false;
        this.c = 0;
        this.d = 0;
        this.e = new Paint();
        this.f = 0;
        this.g = 1;
        this.h = false;
        this.i = null;
        this.f = i;
        b();
    }

    private void b() {
        this.e = new Paint();
        this.e.setAntiAlias(true);
    }

    public void setType(int i) {
        this.f = i;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        float f;
        Bitmap a;
        super.onDraw(canvas);
        Bitmap c = com.baidu.tbadk.a.d.a().c(String.valueOf((String) getTag()) + "_small");
        if (c == null) {
            this.h = false;
            if (this.f == 5) {
                if (TiebaApplication.d().ai() == 1) {
                    a = com.baidu.tieba.d.e.a((int) R.drawable.pic_video_1);
                } else {
                    a = com.baidu.tieba.d.e.a((int) R.drawable.pic_video);
                }
                this.h = true;
                bitmap = a;
            } else if (TiebaApplication.d().ai() == 1) {
                bitmap = com.baidu.tieba.d.e.a((int) R.drawable.pic_image_h_not_1);
            } else {
                bitmap = com.baidu.tieba.d.e.a((int) R.drawable.pic_image_h_not);
            }
        } else {
            this.h = true;
            bitmap = c;
        }
        if (bitmap != null) {
            if (!this.h) {
                this.a.reset();
                if (TiebaApplication.d().ai() == 1) {
                    canvas.drawColor(-13815750);
                }
                this.c = (getWidth() - bitmap.getWidth()) >> 1;
                this.d = (getHeight() - bitmap.getHeight()) >> 1;
                this.a.postTranslate(this.c, this.d);
            } else if (!this.b) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int width2 = getWidth();
                int height2 = getHeight();
                if (width != 0 && height != 0 && width2 != 0 && height2 != 0) {
                    if (this.g == 1) {
                        f = ((double) width) < ((double) (width2 * 2)) / 10.0d ? 1.0f : width2 / width;
                    } else {
                        f = ((float) width) < ((float) (((double) (width2 * 2)) / 10.0d)) ? 1.0f : width2 / width;
                    }
                    this.a.setScale(f, f);
                    int round = Math.round(width * f);
                    int round2 = Math.round(f * height);
                    if (round2 <= 1.25d * height2) {
                        this.c = 0;
                        this.d = 0;
                    } else {
                        this.c = 0;
                        this.d = (int) ((0.5d * height2) - (0.4d * round2));
                        if (this.d > 0) {
                            this.d = 0;
                        }
                    }
                    this.a.postTranslate(this.c, this.d);
                    this.b = true;
                    if (round2 > height2) {
                        round2 = height2;
                    }
                    this.i = new LinearLayout.LayoutParams(round, round2);
                    setLayoutParams(this.i);
                } else {
                    return;
                }
            }
            canvas.drawBitmap(bitmap, this.a, this.e);
        }
    }
}
