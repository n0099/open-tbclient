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
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.Util;
/* loaded from: classes.dex */
public class ImagePbImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1797a;
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
        this.f1797a = z;
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
        this.f1797a = false;
        this.b = 0;
        this.c = new Matrix();
        this.d = new Paint();
        this.e = new Paint();
        this.f = new RectF();
        this.g = false;
        this.h = false;
        this.i = com.baidu.tieba.util.e.a((int) R.drawable.image_pb_next);
        this.j = -1;
        this.k = new ab(this);
        c();
    }

    public ImagePbImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1797a = false;
        this.b = 0;
        this.c = new Matrix();
        this.d = new Paint();
        this.e = new Paint();
        this.f = new RectF();
        this.g = false;
        this.h = false;
        this.i = com.baidu.tieba.util.e.a((int) R.drawable.image_pb_next);
        this.j = -1;
        this.k = new ab(this);
        c();
    }

    public ImagePbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1797a = false;
        this.b = 0;
        this.c = new Matrix();
        this.d = new Paint();
        this.e = new Paint();
        this.f = new RectF();
        this.g = false;
        this.h = false;
        this.i = com.baidu.tieba.util.e.a((int) R.drawable.image_pb_next);
        this.j = -1;
        this.k = new ab(this);
        c();
    }

    private void c() {
        this.e.setColor(1275068416);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.widget.a.b bVar;
        super.onDraw(canvas);
        com.baidu.adp.widget.a.b c = com.baidu.tbadk.a.e.a().c(String.valueOf((String) getTag()) + "_big");
        if (c == null) {
            this.g = false;
            if (TiebaApplication.f().au() == 1) {
                bVar = new com.baidu.adp.widget.a.b(com.baidu.tieba.util.e.a((int) R.drawable.image_default_1), false, null);
            } else {
                bVar = new com.baidu.adp.widget.a.b(com.baidu.tieba.util.e.a((int) R.drawable.image_default), false, null);
            }
        } else {
            this.g = true;
            bVar = c;
        }
        if (bVar != null) {
            this.d.setAlpha(Util.MASK_8BIT);
            if (this.j >= 0) {
                this.d.setAlpha(255 - ((this.j * Util.MASK_8BIT) / 10));
            }
            int a2 = com.baidu.tieba.util.am.a(getContext(), 8.0f);
            int a3 = bVar.a();
            int b = bVar.b();
            int width = getWidth() - a2;
            int height = getHeight();
            this.c.reset();
            if (this.g && this.f1797a) {
                float min = Math.min(width / a3, height / b);
                a3 = (int) (a3 * min);
                b = (int) (b * min);
                this.c.setScale(min, min);
            }
            float f = ((width + a2) - a3) >> 1;
            float f2 = 0.0f;
            if (!this.g || this.b == 0) {
                f2 = (height - b) >> 1;
            }
            this.c.postTranslate(f, f2);
            bVar.a(canvas, this.c, this.d);
            if (this.g && TiebaApplication.f().au() == 1) {
                this.f.set(f, f2, a3 + f, b + f2);
                canvas.drawRect(this.f, this.e);
            }
            if (this.h && this.i != null && this.g) {
                this.c.reset();
                this.c.postTranslate((width + a2) - this.i.getWidth(), (height - this.i.getHeight()) >> 1);
                canvas.drawBitmap(this.i, this.c, this.d);
            }
        }
    }
}
