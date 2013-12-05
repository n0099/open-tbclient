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
import java.lang.ref.SoftReference;
/* loaded from: classes.dex */
public class ImagePbImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private boolean f2635a;
    private int b;
    private Matrix c;
    private Paint d;
    private Paint e;
    private RectF f;
    private boolean g;
    private boolean h;
    private Bitmap i;
    private com.baidu.adp.widget.ImageView.e j;
    private SoftReference<com.baidu.adp.widget.ImageView.e> k;
    private com.baidu.adp.widget.ImageView.e l;
    private SoftReference<com.baidu.adp.widget.ImageView.e> m;
    private int n;
    private Handler o;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int a(ImagePbImageView imagePbImageView) {
        int i = imagePbImageView.n;
        imagePbImageView.n = i - 1;
        return i;
    }

    public void setScale(int i) {
        this.b = i;
    }

    public void setIsScale(boolean z) {
        this.f2635a = z;
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
        this.f2635a = false;
        this.b = 0;
        this.c = new Matrix();
        this.d = new Paint();
        this.e = new Paint();
        this.f = new RectF();
        this.g = false;
        this.h = false;
        this.i = com.baidu.tieba.util.m.a((int) R.drawable.image_pb_next);
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = -1;
        this.o = new aj(this);
        c();
    }

    public ImagePbImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2635a = false;
        this.b = 0;
        this.c = new Matrix();
        this.d = new Paint();
        this.e = new Paint();
        this.f = new RectF();
        this.g = false;
        this.h = false;
        this.i = com.baidu.tieba.util.m.a((int) R.drawable.image_pb_next);
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = -1;
        this.o = new aj(this);
        c();
    }

    public ImagePbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2635a = false;
        this.b = 0;
        this.c = new Matrix();
        this.d = new Paint();
        this.e = new Paint();
        this.f = new RectF();
        this.g = false;
        this.h = false;
        this.i = com.baidu.tieba.util.m.a((int) R.drawable.image_pb_next);
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = -1;
        this.o = new aj(this);
        c();
    }

    private void c() {
        this.e.setColor(1275068416);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.widget.ImageView.e eVar;
        super.onDraw(canvas);
        com.baidu.adp.widget.ImageView.e c = com.baidu.tbadk.imageManager.d.a().c(((String) getTag()) + "_big");
        if (c == null) {
            this.g = false;
            if (TiebaApplication.h().an() == 1) {
                if (this.m == null) {
                    this.l = new com.baidu.adp.widget.ImageView.e(com.baidu.tieba.util.m.a((int) R.drawable.image_default_1), false, null);
                    this.m = new SoftReference<>(this.l);
                }
                eVar = this.m.get();
            } else {
                if (this.k == null) {
                    this.j = new com.baidu.adp.widget.ImageView.e(com.baidu.tieba.util.m.a((int) R.drawable.image_default), false, null);
                    this.k = new SoftReference<>(this.j);
                }
                eVar = this.k.get();
            }
        } else {
            this.g = true;
            eVar = c;
        }
        if (eVar != null) {
            this.d.setAlpha(Util.MASK_8BIT);
            if (this.n >= 0) {
                this.d.setAlpha(255 - ((this.n * Util.MASK_8BIT) / 10));
            }
            int a2 = com.baidu.adp.lib.h.g.a(getContext(), 8.0f);
            int a3 = eVar.a();
            int b = eVar.b();
            int width = getWidth() - a2;
            int height = getHeight();
            this.c.reset();
            if (this.g && this.f2635a) {
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
            eVar.a(canvas, this.c, this.d);
            if (this.g && TiebaApplication.h().an() == 1) {
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
