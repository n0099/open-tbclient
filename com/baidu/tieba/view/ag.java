package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class ag extends ImageView {
    private Bitmap a;
    private Bitmap b;
    private Matrix c;
    private Matrix d;
    private Paint e;

    public ag(Context context) {
        super(context);
        this.a = com.baidu.tieba.c.e.a((int) R.drawable.icon_gif);
        this.b = com.baidu.tieba.c.e.a((int) R.drawable.image_default);
        this.c = new Matrix();
        this.d = new Matrix();
        this.e = new Paint();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        boolean z;
        boolean z2 = false;
        super.onDraw(canvas);
        String str = (String) getTag();
        com.baidu.tieba.c.ab ah = TiebaApplication.a().ah();
        if (ah != null) {
            Bitmap c = ah.c(str);
            if (c != null) {
                z = ah.d(str);
                bitmap = c;
            } else {
                bitmap = c;
                z = false;
            }
        } else {
            bitmap = null;
            z = false;
        }
        if (bitmap == null) {
            bitmap = this.b;
        } else {
            z2 = true;
        }
        if (bitmap != null) {
            if (!z2) {
                canvas.drawBitmap(bitmap, this.d, this.e);
                return;
            }
            float height = (getHeight() - bitmap.getHeight()) >> 1;
            canvas.drawBitmap(bitmap, 0.0f, height, this.e);
            this.c.reset();
            this.c.setTranslate(0.0f, height);
            if (!z || bitmap.getHeight() <= this.a.getHeight() || bitmap.getWidth() <= this.a.getWidth()) {
                return;
            }
            canvas.drawBitmap(this.a, this.c, this.e);
        }
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
}
