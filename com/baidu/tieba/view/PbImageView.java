package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class PbImageView extends ImageView {
    private Bitmap a;
    private Bitmap b;
    private Matrix c;
    private Matrix d;
    private Paint e;
    private RectF f;
    private boolean g;

    public PbImageView(Context context) {
        super(context);
        this.a = com.baidu.tieba.c.e.a((int) R.drawable.icon_gif);
        this.b = null;
        this.c = new Matrix();
        this.d = new Matrix();
        this.e = new Paint();
        this.f = new RectF();
        this.g = false;
        a();
    }

    public PbImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = com.baidu.tieba.c.e.a((int) R.drawable.icon_gif);
        this.b = null;
        this.c = new Matrix();
        this.d = new Matrix();
        this.e = new Paint();
        this.f = new RectF();
        this.g = false;
        a();
    }

    public PbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = com.baidu.tieba.c.e.a((int) R.drawable.icon_gif);
        this.b = null;
        this.c = new Matrix();
        this.d = new Matrix();
        this.e = new Paint();
        this.f = new RectF();
        this.g = false;
        a();
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        float height = layoutParams.height / this.b.getHeight();
        float f = height <= 1.0f ? height : 1.0f;
        layoutParams.width = (int) (((float) layoutParams.width) > ((float) this.b.getWidth()) * f ? layoutParams.width : this.b.getWidth() * f);
        this.d.reset();
        this.d.setScale(f, f);
        this.d.postTranslate((layoutParams.width - (this.b.getWidth() * f)) / 2.0f, (layoutParams.height - (this.b.getHeight() * f)) / 2.0f);
        super.setLayoutParams(layoutParams);
    }

    public void setNearbyPbImage(boolean z) {
        this.g = z;
    }

    private void a() {
        this.e.setColor(1275068416);
        if (TiebaApplication.b().ah() == 1) {
            this.b = com.baidu.tieba.c.e.a((int) R.drawable.image_default_1);
        } else {
            this.b = com.baidu.tieba.c.e.a((int) R.drawable.image_default);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        boolean z;
        Bitmap bitmap2;
        boolean z2;
        super.onDraw(canvas);
        String str = (String) getTag();
        com.baidu.tieba.c.ac an = TiebaApplication.b().an();
        if (an != null) {
            Bitmap c = an.c(str);
            if (c != null) {
                z = an.d(str);
                bitmap = c;
            } else {
                bitmap = c;
                z = false;
            }
        } else {
            bitmap = null;
            z = false;
        }
        if (bitmap != null) {
            bitmap2 = bitmap;
            z2 = true;
        } else if (TiebaApplication.b().ah() == 1) {
            z2 = false;
            bitmap2 = com.baidu.tieba.c.e.a((int) R.drawable.image_default_1);
        } else {
            z2 = false;
            bitmap2 = com.baidu.tieba.c.e.a((int) R.drawable.image_default);
        }
        if (bitmap2 != null) {
            if (z2) {
                float height = !this.g ? (getHeight() - bitmap2.getHeight()) >> 1 : 0.0f;
                float width = getWidth() / bitmap2.getWidth();
                if (!this.g) {
                    canvas.drawBitmap(bitmap2, 0.0f, height, (Paint) null);
                } else {
                    this.c.reset();
                    this.c.setScale(width, width);
                    canvas.drawBitmap(bitmap2, this.c, null);
                }
                this.c.reset();
                this.c.setTranslate(0.0f, height);
                if (z && bitmap2.getHeight() > this.a.getHeight() && bitmap2.getWidth() > this.a.getWidth()) {
                    canvas.drawBitmap(this.a, this.c, null);
                }
                if (TiebaApplication.b().ah() == 1) {
                    this.f.set(0.0f, height, (bitmap2.getWidth() * width) + 0.0f, (bitmap2.getHeight() * width) + height);
                    canvas.drawRect(this.f, this.e);
                    return;
                }
                return;
            }
            canvas.drawBitmap(bitmap2, this.d, null);
        }
    }
}
