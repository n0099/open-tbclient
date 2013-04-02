package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class q extends ImageView {
    private Matrix a;
    private Paint b;
    private int c;
    private boolean d;
    private boolean e;
    private RectF f;

    public boolean a() {
        return this.d;
    }

    public void setIsThree(boolean z) {
        this.e = z;
    }

    public q(Context context, int i) {
        super(context);
        this.a = new Matrix();
        this.b = new Paint();
        this.c = 0;
        this.d = false;
        this.e = false;
        this.f = new RectF();
        this.c = i;
        b();
    }

    private void b() {
        this.b.setColor(1275068416);
    }

    public void setType(int i) {
        this.c = i;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        boolean z;
        int i = 0;
        super.onDraw(canvas);
        String str = String.valueOf((String) getTag()) + "_small";
        com.baidu.tieba.c.ac an = TiebaApplication.b().an();
        Bitmap c = an != null ? an.c(str) : null;
        if (c == null) {
            boolean z2 = this.d;
            this.d = false;
            if (this.c == 5) {
                Bitmap a = com.baidu.tieba.c.e.a((int) R.drawable.video_pic);
                this.d = true;
                bitmap = a;
                z = z2;
            } else if (TiebaApplication.b().ah() == 1) {
                bitmap = com.baidu.tieba.c.e.a((int) R.drawable.image_default_1);
                z = z2;
            } else {
                bitmap = com.baidu.tieba.c.e.a((int) R.drawable.image_default);
                z = z2;
            }
        } else {
            boolean z3 = !this.d;
            this.d = true;
            bitmap = c;
            z = z3;
        }
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = getWidth();
            int height2 = getHeight();
            if (width != 0 && height != 0 && width2 != 0 && height2 != 0) {
                float min = Math.min(width2 / width, height2 / height);
                if (min > 1.0f) {
                    min = 1.0f;
                }
                this.a.setScale(min, min);
                if (!this.e) {
                    if (z) {
                        int i2 = ((int) (width * min)) + 1;
                        ViewGroup.LayoutParams layoutParams = getLayoutParams();
                        if (i2 > layoutParams.width) {
                            i2 = layoutParams.width;
                        }
                        layoutParams.width = i2;
                        setLayoutParams(layoutParams);
                    }
                } else {
                    i = ((int) (width2 - (width * min))) / 2;
                }
                int i3 = (int) (height2 - (min * height));
                this.a.postTranslate(i, i3);
                canvas.drawBitmap(bitmap, this.a, null);
                this.a.reset();
                if (this.d && TiebaApplication.b().ah() == 1) {
                    this.f.set(i, i3, i + bitmap.getWidth(), i3 + bitmap.getHeight());
                    canvas.drawRect(this.f, this.b);
                }
            }
        }
    }
}
