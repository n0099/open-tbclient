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

    /* renamed from: a  reason: collision with root package name */
    private Bitmap f1500a;
    private Bitmap b;
    private Matrix c;
    private Matrix d;
    private Paint e;
    private RectF f;
    private Rect g;
    private int h;

    public PbImageView(Context context) {
        super(context);
        this.f1500a = com.baidu.tieba.util.d.a((int) R.drawable.icon_gif);
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
        this.f1500a = com.baidu.tieba.util.d.a((int) R.drawable.icon_gif);
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
        this.f1500a = com.baidu.tieba.util.d.a((int) R.drawable.icon_gif);
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
        this.d.postTranslate((layoutParams.width - this.b.getWidth()) / 2.0f, (layoutParams.height - this.b.getHeight()) / 2.0f);
        if (com.baidu.tieba.util.ab.a(getContext()) > layoutParams.width * 10 && layoutParams.height > this.h) {
            layoutParams.height = this.h;
        }
        super.setLayoutParams(layoutParams);
    }

    private void a() {
        this.e.setColor(1275068416);
        if (TiebaApplication.f().at() == 1) {
            this.b = com.baidu.tieba.util.d.a((int) R.drawable.pic_image_h_not_1);
        } else {
            this.b = com.baidu.tieba.util.d.a((int) R.drawable.pic_image_h_not);
        }
        this.h = com.baidu.tieba.util.ab.a(getContext(), 600.0f);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.widget.a.b bVar;
        boolean z;
        super.onDraw(canvas);
        com.baidu.adp.widget.a.b d = com.baidu.tbadk.a.e.a().d((String) getTag());
        boolean c = (d == null || !d.g()) ? false : d.c();
        if (d != null) {
            bVar = d;
            z = true;
        } else if (TiebaApplication.f().at() == 1) {
            bVar = new com.baidu.adp.widget.a.b(com.baidu.tieba.util.d.a((int) R.drawable.pic_image_h_not_1), false, null);
            z = false;
        } else {
            bVar = new com.baidu.adp.widget.a.b(com.baidu.tieba.util.d.a((int) R.drawable.pic_image_h_not), false, null);
            z = false;
        }
        if (bVar != null) {
            if (z) {
                canvas.drawColor(-1);
                float min = Math.min(getWidth() / bVar.a(), getHeight() / bVar.b());
                this.c.reset();
                if (bVar.a() < getWidth() / 10) {
                    min = 1.0f;
                    this.g.set(0, 0, bVar.a(), getHeight());
                    bVar.a(canvas, this.g, this.g, (Paint) null);
                } else {
                    this.c.setScale(min, min);
                    bVar.a(canvas, this.c, null);
                }
                this.c.reset();
                if (c && bVar.b() > this.f1500a.getHeight() && bVar.a() > this.f1500a.getWidth()) {
                    canvas.drawBitmap(this.f1500a, this.c, null);
                }
                if (TiebaApplication.f().at() == 1) {
                    this.f.set(0.0f, 0.0f, bVar.a() * min, min * bVar.b());
                    canvas.drawRect(this.f, this.e);
                    return;
                }
                return;
            }
            bVar.a(canvas, this.d, null);
        }
    }
}
