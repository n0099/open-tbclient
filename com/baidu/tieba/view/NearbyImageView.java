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
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class NearbyImageView extends ImageView {
    private Bitmap a;
    private Bitmap b;
    private Matrix c;
    private Matrix d;
    private Paint e;
    private RectF f;

    public NearbyImageView(Context context) {
        super(context);
        this.a = com.baidu.tieba.d.e.a((int) R.drawable.icon_gif);
        this.b = null;
        this.c = new Matrix();
        this.d = new Matrix();
        this.e = new Paint();
        this.f = new RectF();
        a();
    }

    public NearbyImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = com.baidu.tieba.d.e.a((int) R.drawable.icon_gif);
        this.b = null;
        this.c = new Matrix();
        this.d = new Matrix();
        this.e = new Paint();
        this.f = new RectF();
        a();
    }

    public NearbyImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = com.baidu.tieba.d.e.a((int) R.drawable.icon_gif);
        this.b = null;
        this.c = new Matrix();
        this.d = new Matrix();
        this.e = new Paint();
        this.f = new RectF();
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

    private void a() {
        this.e.setColor(1275068416);
        if (TiebaApplication.d().ai() == 1) {
            this.b = com.baidu.tieba.d.e.a((int) R.drawable.image_default_1);
        } else {
            this.b = com.baidu.tieba.d.e.a((int) R.drawable.image_default);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        boolean z;
        boolean z2 = false;
        super.onDraw(canvas);
        com.baidu.tbadk.a.f d = com.baidu.tbadk.a.d.a().d((String) getTag());
        if (d != null) {
            bitmap = d.a();
            z = bitmap != null ? d.b() : false;
        } else {
            bitmap = null;
            z = false;
        }
        if (bitmap != null) {
            z2 = true;
        } else if (TiebaApplication.d().ai() == 1) {
            bitmap = com.baidu.tieba.d.e.a((int) R.drawable.image_default_1);
        } else {
            bitmap = com.baidu.tieba.d.e.a((int) R.drawable.image_default);
        }
        if (bitmap != null) {
            if (z2) {
                float width = getWidth() / bitmap.getWidth();
                this.c.reset();
                this.c.setScale(width, width);
                canvas.drawBitmap(bitmap, this.c, null);
                this.c.reset();
                this.c.setTranslate(0.0f, 0.0f);
                if (z && bitmap.getHeight() > this.a.getHeight() && bitmap.getWidth() > this.a.getWidth()) {
                    canvas.drawBitmap(this.a, this.c, null);
                }
                if (TiebaApplication.d().ai() == 1) {
                    this.f.set(0.0f, 0.0f, (bitmap.getWidth() * width) + 0.0f, (bitmap.getHeight() * width) + 0.0f);
                    canvas.drawRect(this.f, this.e);
                    return;
                }
                return;
            }
            canvas.drawBitmap(bitmap, this.d, null);
        }
    }
}
