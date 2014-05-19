package com.baidu.tieba.pb.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tbadk.TbadkApplication;
import java.lang.ref.SoftReference;
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
    private com.baidu.adp.widget.a.a j;
    private SoftReference<com.baidu.adp.widget.a.a> k;
    private com.baidu.adp.widget.a.a l;
    private SoftReference<com.baidu.adp.widget.a.a> m;
    private int n;
    private Handler o;

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
        this.n = 10;
        this.o.sendMessageDelayed(this.o.obtainMessage(1), 20L);
        invalidate();
    }

    public void b() {
        this.n = 0;
        this.o.removeMessages(1);
    }

    public void setFirst(boolean z) {
        this.h = z;
        invalidate();
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
        this.i = com.baidu.tbadk.core.util.g.a(com.baidu.tieba.q.image_pb_next);
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = -1;
        this.o = new ab(this);
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
        this.i = com.baidu.tbadk.core.util.g.a(com.baidu.tieba.q.image_pb_next);
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = -1;
        this.o = new ab(this);
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
        this.i = com.baidu.tbadk.core.util.g.a(com.baidu.tieba.q.image_pb_next);
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = -1;
        this.o = new ab(this);
        c();
    }

    private void c() {
        this.e.setColor(1275068416);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.widget.a.a aVar;
        super.onDraw(canvas);
        com.baidu.adp.widget.a.a c = com.baidu.tbadk.imageManager.e.a().c(String.valueOf((String) getTag()) + "_big");
        if (c == null) {
            this.g = false;
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                if (this.m == null) {
                    this.l = new com.baidu.adp.widget.a.a(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.q.image_default_1), false, null);
                    this.m = new SoftReference<>(this.l);
                }
                aVar = this.m.get();
            } else {
                if (this.k == null) {
                    this.j = new com.baidu.adp.widget.a.a(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.q.image_default), false, null);
                    this.k = new SoftReference<>(this.j);
                }
                aVar = this.k.get();
            }
        } else {
            this.g = true;
            aVar = c;
        }
        if (aVar != null) {
            this.d.setAlpha(MotionEventCompat.ACTION_MASK);
            if (this.n >= 0) {
                this.d.setAlpha(255 - ((this.n * MotionEventCompat.ACTION_MASK) / 10));
            }
            int a = com.baidu.adp.lib.util.h.a(getContext(), 8.0f);
            int c2 = aVar.c();
            int d = aVar.d();
            int width = getWidth() - a;
            int height = getHeight();
            this.c.reset();
            if (this.g && this.a) {
                float min = Math.min(width / c2, height / d);
                c2 = (int) (c2 * min);
                d = (int) (d * min);
                this.c.setScale(min, min);
            }
            float f = ((width + a) - c2) >> 1;
            float f2 = 0.0f;
            if (!this.g || this.b == 0) {
                f2 = (height - d) >> 1;
            }
            this.c.postTranslate(f, f2);
            aVar.a(canvas, this.c, this.d);
            if (this.g && TbadkApplication.m252getInst().getSkinType() == 1) {
                this.f.set(f, f2, c2 + f, d + f2);
                canvas.drawRect(this.f, this.e);
            }
            if (this.h && this.i != null && this.g) {
                this.c.reset();
                this.c.postTranslate((width + a) - this.i.getWidth(), (height - this.i.getHeight()) >> 1);
                canvas.drawBitmap(this.i, this.c, this.d);
            }
        }
    }
}
