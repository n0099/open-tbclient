package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class ImagePbImageView extends ImageView {
    private int a;
    private Matrix b;
    private Paint c;
    private boolean d;
    private boolean e;
    private Bitmap f;
    private int g;
    private Handler h;

    public ImagePbImageView(Context context) {
        super(context);
        this.a = 0;
        this.b = new Matrix();
        this.c = new Paint();
        this.d = false;
        this.e = false;
        this.f = com.baidu.tieba.c.e.a((int) R.drawable.image_pb_next);
        this.g = -1;
        this.h = new t(this);
    }

    public ImagePbImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
        this.b = new Matrix();
        this.c = new Paint();
        this.d = false;
        this.e = false;
        this.f = com.baidu.tieba.c.e.a((int) R.drawable.image_pb_next);
        this.g = -1;
        this.h = new t(this);
    }

    public ImagePbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0;
        this.b = new Matrix();
        this.c = new Paint();
        this.d = false;
        this.e = false;
        this.f = com.baidu.tieba.c.e.a((int) R.drawable.image_pb_next);
        this.g = -1;
        this.h = new t(this);
    }

    public void a() {
        this.g = 10;
        this.h.sendMessageDelayed(this.h.obtainMessage(1), 20L);
        invalidate();
    }

    public void b() {
        this.g = 0;
        this.h.removeMessages(1);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        super.onDraw(canvas);
        String str = String.valueOf((String) getTag()) + "_big";
        com.baidu.tieba.c.ab ah = TiebaApplication.a().ah();
        Bitmap c = ah != null ? ah.c(str) : null;
        if (c == null) {
            this.d = false;
            bitmap = com.baidu.tieba.c.e.a((int) R.drawable.image_default);
        } else {
            this.d = true;
            bitmap = c;
        }
        if (bitmap != null) {
            this.c.setAlpha(255);
            if (this.g >= 0) {
                this.c.setAlpha(255 - ((this.g * 255) / 10));
            }
            int a = com.baidu.tieba.c.ag.a(getContext(), 8.0f);
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = getWidth() - a;
            int height2 = getHeight();
            this.b.reset();
            float f = ((width2 + a) - width) >> 1;
            float f2 = 0.0f;
            if (!this.d || this.a == 0) {
                f2 = (height2 - height) >> 1;
            }
            this.b.postTranslate(f, f2);
            canvas.drawBitmap(bitmap, this.b, this.c);
            if (this.e && this.f != null && this.d) {
                this.b.reset();
                this.b.postTranslate((width2 + a) - this.f.getWidth(), (height2 - this.f.getHeight()) >> 1);
                canvas.drawBitmap(this.f, this.b, this.c);
            }
        }
    }

    public void setFirst(boolean z) {
        this.e = z;
    }

    public void setScale(int i) {
        this.a = i;
    }
}
