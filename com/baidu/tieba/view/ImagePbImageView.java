package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class ImagePbImageView extends ImageView {
    private boolean a;
    private int b;
    private Matrix c;
    private Paint d;
    private Paint e;
    private RectF f;
    private boolean g;
    private boolean h;
    private Bitmap i;
    private int j;
    private Handler k;

    public void setScale(int i) {
        this.b = i;
    }

    public void setIsScale(boolean z) {
        this.a = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    public void a() {
        this.j = 10;
        this.k.sendMessageDelayed(this.k.obtainMessage(1), 20L);
        invalidate();
    }

    public void b() {
        this.j = 0;
        this.k.removeMessages(1);
    }

    public void setFirst(boolean z) {
        this.h = z;
    }

    public ImagePbImageView(Context context) {
        super(context);
        this.a = false;
        this.b = 0;
        this.c = new Matrix();
        this.d = new Paint();
        this.e = new Paint();
        this.f = new RectF();
        this.g = false;
        this.h = false;
        this.i = com.baidu.tieba.c.e.a((int) R.drawable.image_pb_next);
        this.j = -1;
        this.k = new t(this);
        c();
    }

    public ImagePbImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = false;
        this.b = 0;
        this.c = new Matrix();
        this.d = new Paint();
        this.e = new Paint();
        this.f = new RectF();
        this.g = false;
        this.h = false;
        this.i = com.baidu.tieba.c.e.a((int) R.drawable.image_pb_next);
        this.j = -1;
        this.k = new t(this);
        c();
    }

    public ImagePbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = false;
        this.b = 0;
        this.c = new Matrix();
        this.d = new Paint();
        this.e = new Paint();
        this.f = new RectF();
        this.g = false;
        this.h = false;
        this.i = com.baidu.tieba.c.e.a((int) R.drawable.image_pb_next);
        this.j = -1;
        this.k = new t(this);
        c();
    }

    private void c() {
        this.e.setColor(1275068416);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        super.onDraw(canvas);
        String str = String.valueOf((String) getTag()) + "_big";
        Bitmap bitmap2 = null;
        com.baidu.tieba.c.ac an = TiebaApplication.b().an();
        if (an != null) {
            bitmap2 = an.c(str);
        }
        if (bitmap2 == null) {
            this.g = false;
            if (TiebaApplication.b().ah() == 1) {
                bitmap = com.baidu.tieba.c.e.a((int) R.drawable.image_default_1);
            } else {
                bitmap = com.baidu.tieba.c.e.a((int) R.drawable.image_default);
            }
        } else {
            this.g = true;
            bitmap = bitmap2;
        }
        if (bitmap != null) {
            this.d.setAlpha(255);
            if (this.j >= 0) {
                this.d.setAlpha(255 - ((this.j * 255) / 10));
            }
            int a = com.baidu.tieba.c.ai.a(getContext(), 8.0f);
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = getWidth() - a;
            int height2 = getHeight();
            this.c.reset();
            if (this.g && this.a) {
                float min = Math.min(width2 / width, height2 / height);
                width = (int) (width * min);
                height = (int) (height * min);
                this.c.setScale(min, min);
            }
            float f = ((width2 + a) - width) >> 1;
            float f2 = 0.0f;
            if (!this.g || this.b == 0) {
                f2 = (height2 - height) >> 1;
            }
            this.c.postTranslate(f, f2);
            canvas.drawBitmap(bitmap, this.c, this.d);
            if (this.g && TiebaApplication.b().ah() == 1) {
                this.f.set(f, f2, width + f, height + f2);
                canvas.drawRect(this.f, this.e);
            }
            if (this.h && this.i != null && this.g) {
                this.c.reset();
                this.c.postTranslate((width2 + a) - this.i.getWidth(), (height2 - this.i.getHeight()) >> 1);
                canvas.drawBitmap(this.i, this.c, this.d);
            }
        }
    }
}
