package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PbImageView extends ImageView {
    private Bitmap a;
    private Bitmap b;
    private Matrix c;
    private Matrix d;
    private Paint e;
    private RectF f;
    private Rect g;
    private int h;

    public PbImageView(Context context) {
        super(context);
        this.a = com.baidu.tieba.d.e.a((int) R.drawable.icon_gif);
        this.b = null;
        this.c = new Matrix();
        this.d = new Matrix();
        this.e = new Paint();
        this.f = new RectF();
        this.g = new Rect();
        this.h = 600;
        a();
    }

    public PbImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = com.baidu.tieba.d.e.a((int) R.drawable.icon_gif);
        this.b = null;
        this.c = new Matrix();
        this.d = new Matrix();
        this.e = new Paint();
        this.f = new RectF();
        this.g = new Rect();
        this.h = 600;
        a();
    }

    public PbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = com.baidu.tieba.d.e.a((int) R.drawable.icon_gif);
        this.b = null;
        this.c = new Matrix();
        this.d = new Matrix();
        this.e = new Paint();
        this.f = new RectF();
        this.g = new Rect();
        this.h = 600;
        a();
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        this.d.reset();
        this.d.postTranslate((layoutParams.width - this.b.getWidth()) / 2, (layoutParams.height - this.b.getHeight()) / 2);
        if (com.baidu.tieba.d.ag.a(getContext()) > layoutParams.width * 10 && layoutParams.height > this.h) {
            layoutParams.height = this.h;
        }
        super.setLayoutParams(layoutParams);
    }

    private void a() {
        this.e.setColor(1275068416);
        if (TiebaApplication.d().ai() == 1) {
            this.b = com.baidu.tieba.d.e.a((int) R.drawable.pic_image_h_not_1);
        } else {
            this.b = com.baidu.tieba.d.e.a((int) R.drawable.pic_image_h_not);
        }
        this.h = com.baidu.tieba.d.ag.a(getContext(), 600.0f);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        boolean z;
        Bitmap bitmap2;
        boolean z2;
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
            bitmap2 = bitmap;
            z2 = true;
        } else if (TiebaApplication.d().ai() == 1) {
            bitmap2 = com.baidu.tieba.d.e.a((int) R.drawable.pic_image_h_not_1);
            z2 = false;
        } else {
            bitmap2 = com.baidu.tieba.d.e.a((int) R.drawable.pic_image_h_not);
            z2 = false;
        }
        if (bitmap2 != null) {
            if (z2) {
                float min = Math.min(getWidth() / bitmap2.getWidth(), getHeight() / bitmap2.getHeight());
                this.c.reset();
                if (bitmap2.getWidth() < getWidth() / 10) {
                    min = 1.0f;
                    this.g.set(0, 0, bitmap2.getWidth(), getHeight());
                    canvas.drawBitmap(bitmap2, this.g, this.g, (Paint) null);
                } else {
                    this.c.setScale(min, min);
                    canvas.drawBitmap(bitmap2, this.c, null);
                }
                this.c.reset();
                if (z && bitmap2.getHeight() > this.a.getHeight() && bitmap2.getWidth() > this.a.getWidth()) {
                    canvas.drawBitmap(this.a, this.c, null);
                }
                if (TiebaApplication.d().ai() == 1) {
                    this.f.set(0.0f, 0.0f, bitmap2.getWidth() * min, min * bitmap2.getHeight());
                    canvas.drawRect(this.f, this.e);
                    return;
                }
                return;
            }
            canvas.drawBitmap(bitmap2, this.d, null);
        }
    }
}
