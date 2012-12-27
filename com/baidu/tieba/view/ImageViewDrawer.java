package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class ImageViewDrawer extends ImageView {
    private Bitmap a;
    private int b;
    private String c;
    private int d;
    private Paint e;
    private Handler f;

    public ImageViewDrawer(Context context) {
        super(context);
        this.a = com.baidu.tieba.c.e.a((int) R.drawable.icon_gif);
        this.b = -1;
        this.c = null;
        this.d = R.drawable.image_default;
        this.e = new Paint();
        this.f = new z(this);
    }

    public ImageViewDrawer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = com.baidu.tieba.c.e.a((int) R.drawable.icon_gif);
        this.b = -1;
        this.c = null;
        this.d = R.drawable.image_default;
        this.e = new Paint();
        this.f = new z(this);
    }

    public ImageViewDrawer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = com.baidu.tieba.c.e.a((int) R.drawable.icon_gif);
        this.b = -1;
        this.c = null;
        this.d = R.drawable.image_default;
        this.e = new Paint();
        this.f = new z(this);
    }

    public void a() {
        this.b = 10;
        this.f.sendMessageDelayed(this.f.obtainMessage(1), 15L);
        invalidate();
    }

    public void b() {
        this.b = 0;
        this.f.removeMessages(1);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        boolean z;
        super.onDraw(canvas);
        String str = this.c != null ? this.c : (String) getTag();
        com.baidu.tieba.c.ab ah = TiebaApplication.a().ah();
        if (ah == null || str == null) {
            bitmap = null;
            z = false;
        } else {
            Bitmap c = ah.c(str);
            if (c != null) {
                z = ah.d(str);
                bitmap = c;
            } else {
                bitmap = c;
                z = false;
            }
        }
        if (this.b <= 0) {
            if (bitmap == null) {
                bitmap = com.baidu.tieba.c.e.a(this.d);
            }
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, (getWidth() - bitmap.getWidth()) >> 1, (getHeight() - bitmap.getHeight()) >> 1, (Paint) null);
                if (z) {
                    canvas.drawBitmap(this.a, 0.0f, 0.0f, (Paint) null);
                }
            }
        } else if (bitmap == null) {
            Bitmap a = com.baidu.tieba.c.e.a(this.d);
            if (a != null) {
                canvas.drawBitmap(a, (getWidth() - a.getWidth()) >> 1, (getHeight() - a.getHeight()) >> 1, (Paint) null);
            }
        } else {
            int i = (this.b * 255) / 10;
            Bitmap a2 = com.baidu.tieba.c.e.a(this.d);
            if (a2 != null) {
                this.e.setAlpha(i);
                canvas.drawBitmap(a2, (getWidth() - a2.getWidth()) >> 1, (getHeight() - a2.getHeight()) >> 1, this.e);
            }
            this.e.setAlpha(255 - i);
            canvas.drawBitmap(bitmap, (getWidth() - bitmap.getWidth()) >> 1, (getHeight() - bitmap.getHeight()) >> 1, this.e);
            if (z) {
                canvas.drawBitmap(this.a, 0.0f, 0.0f, (Paint) null);
            }
        }
    }

    public void setDefaultId(int i) {
        this.d = i;
    }

    public void setImageSearchUrl(String str) {
        this.c = str;
    }
}
