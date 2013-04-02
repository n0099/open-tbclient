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
    private int e;
    private Paint f;
    private Handler g;

    public ImageViewDrawer(Context context) {
        super(context);
        this.a = com.baidu.tieba.c.e.a((int) R.drawable.icon_gif);
        this.b = -1;
        this.c = null;
        this.d = R.drawable.image_default;
        this.e = R.drawable.image_default_1;
        this.f = new Paint();
        this.g = new z(this);
    }

    public ImageViewDrawer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = com.baidu.tieba.c.e.a((int) R.drawable.icon_gif);
        this.b = -1;
        this.c = null;
        this.d = R.drawable.image_default;
        this.e = R.drawable.image_default_1;
        this.f = new Paint();
        this.g = new z(this);
    }

    public ImageViewDrawer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = com.baidu.tieba.c.e.a((int) R.drawable.icon_gif);
        this.b = -1;
        this.c = null;
        this.d = R.drawable.image_default;
        this.e = R.drawable.image_default_1;
        this.f = new Paint();
        this.g = new z(this);
    }

    public void a() {
        this.b = 10;
        this.g.sendMessageDelayed(this.g.obtainMessage(1), 15L);
        invalidate();
    }

    public void b() {
        this.b = 0;
        this.g.removeMessages(1);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    public void setImageSearchUrl(String str) {
        this.c = str;
    }

    public void setDefaultId(int i) {
        this.d = i;
        this.e = i;
    }

    public void setNightDefaultId(int i) {
        this.e = i;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        String str;
        boolean z;
        boolean z2;
        Bitmap bitmap;
        super.onDraw(canvas);
        if (this.c != null) {
            str = this.c;
        } else {
            str = (String) getTag();
        }
        com.baidu.tieba.c.ac an = TiebaApplication.b().an();
        if (an == null || str == null) {
            z = false;
            z2 = false;
            bitmap = null;
        } else {
            Bitmap c = an.c(str);
            if (c != null) {
                boolean d = an.d(str);
                z = true;
                z2 = d;
                bitmap = c;
            } else {
                z = false;
                z2 = false;
                bitmap = c;
            }
        }
        if (this.b <= 0) {
            if (bitmap == null) {
                bitmap = getDefalutBitmap();
            }
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, (getWidth() - bitmap.getWidth()) >> 1, (getHeight() - bitmap.getHeight()) >> 1, (Paint) null);
                if (z2) {
                    canvas.drawBitmap(this.a, 0.0f, 0.0f, (Paint) null);
                }
            }
        } else if (bitmap != null) {
            int i = (this.b * 255) / 10;
            Bitmap defalutBitmap = getDefalutBitmap();
            if (defalutBitmap != null) {
                this.f.setAlpha(i);
                canvas.drawBitmap(defalutBitmap, (getWidth() - defalutBitmap.getWidth()) >> 1, (getHeight() - defalutBitmap.getHeight()) >> 1, this.f);
            }
            this.f.setAlpha(255 - i);
            canvas.drawBitmap(bitmap, (getWidth() - bitmap.getWidth()) >> 1, (getHeight() - bitmap.getHeight()) >> 1, this.f);
            if (z2) {
                canvas.drawBitmap(this.a, 0.0f, 0.0f, (Paint) null);
            }
        } else {
            Bitmap defalutBitmap2 = getDefalutBitmap();
            if (defalutBitmap2 != null) {
                canvas.drawBitmap(defalutBitmap2, (getWidth() - defalutBitmap2.getWidth()) >> 1, (getHeight() - defalutBitmap2.getHeight()) >> 1, (Paint) null);
            }
        }
        if (TiebaApplication.b().ah() == 1 && z) {
            canvas.drawColor(1275068416);
        }
    }

    private Bitmap getDefalutBitmap() {
        return TiebaApplication.b().ah() == 1 ? com.baidu.tieba.c.e.a(this.e) : com.baidu.tieba.c.e.a(this.d);
    }
}
