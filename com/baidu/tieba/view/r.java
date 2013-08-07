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
public class r extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private Matrix f1845a;
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

    public r(Context context, int i) {
        super(context);
        this.f1845a = new Matrix();
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
        Bitmap a2;
        super.onDraw(canvas);
        com.baidu.adp.widget.a.b c = com.baidu.tbadk.a.e.a().c(String.valueOf((String) getTag()) + this.i);
        if (!this.g) {
            this.f1845a.reset();
        }
        if (c == null) {
            this.g = false;
            if (this.e == 5) {
                if (TiebaApplication.f().au() == 1) {
                    a2 = com.baidu.tieba.util.e.a((int) R.drawable.pic_video_1);
                } else {
                    a2 = com.baidu.tieba.util.e.a((int) R.drawable.pic_video);
                }
                float min = Math.min(getWidth() / a2.getWidth(), getHeight() / a2.getHeight());
                this.f1845a.setScale(min, min);
                this.g = true;
            } else {
                if (TiebaApplication.f().au() == 1) {
                    a2 = com.baidu.tieba.util.e.a((int) R.drawable.pic_image_h_not_1);
                } else {
                    a2 = com.baidu.tieba.util.e.a((int) R.drawable.pic_image_h_not);
                }
                this.b = (getWidth() - a2.getWidth()) >> 1;
                this.c = (getHeight() - a2.getHeight()) >> 1;
                this.f1845a.postTranslate(this.b, this.c);
                if (TiebaApplication.f().au() == 1) {
                    canvas.drawColor(-13815750);
                }
            }
            canvas.drawBitmap(a2, this.f1845a, this.d);
        } else if (c != null) {
            if (!this.g) {
                int a3 = c.a();
                int b = c.b();
                int width = getWidth();
                int height = getHeight();
                if (a3 != 0 && b != 0 && width != 0 && height != 0) {
                    if (this.f == 1) {
                        f = (((double) a3) < ((double) (width * 3)) / 10.0d || !this.h) ? 1.0f : width / a3;
                    } else {
                        f = ((float) a3) < ((float) (((double) (width * 3)) / 10.0d)) ? 1.0f : width / a3;
                    }
                    this.f1845a.setScale(f, f);
                    int i = ((int) (a3 * f)) - 1;
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
                    this.f1845a.postTranslate(this.b, this.c);
                    if (height - i2 > 3) {
                        this.j = getLayoutParams();
                        this.j.width = i;
                        this.j.height = i2;
                        setLayoutParams(this.j);
                    }
                    this.g = true;
                } else {
                    return;
                }
            }
            c.a(canvas, this.f1845a, this.d);
        }
    }
}
