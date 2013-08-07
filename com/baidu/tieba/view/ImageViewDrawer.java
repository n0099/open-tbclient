package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.Util;
/* loaded from: classes.dex */
public class ImageViewDrawer extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private Bitmap f1799a;
    private int b;
    private String c;
    private int d;
    private int e;
    private Paint f;
    private Handler g;

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        setDefaultId(i);
    }

    public ImageViewDrawer(Context context) {
        super(context);
        this.f1799a = com.baidu.tieba.util.e.a((int) R.drawable.icon_gif);
        this.b = -1;
        this.c = null;
        this.d = R.drawable.pic_image_h_not;
        this.e = R.drawable.pic_image_h_not_1;
        this.f = new Paint();
        this.g = new ah(this);
        c();
    }

    public ImageViewDrawer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1799a = com.baidu.tieba.util.e.a((int) R.drawable.icon_gif);
        this.b = -1;
        this.c = null;
        this.d = R.drawable.pic_image_h_not;
        this.e = R.drawable.pic_image_h_not_1;
        this.f = new Paint();
        this.g = new ah(this);
        c();
    }

    public ImageViewDrawer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1799a = com.baidu.tieba.util.e.a((int) R.drawable.icon_gif);
        this.b = -1;
        this.c = null;
        this.d = R.drawable.pic_image_h_not;
        this.e = R.drawable.pic_image_h_not_1;
        this.f = new Paint();
        this.g = new ah(this);
        c();
    }

    private void c() {
        this.f.setAntiAlias(true);
        this.f.setFilterBitmap(true);
        this.f.setDither(true);
        this.f.setColor(-1973533);
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
        boolean z2 = false;
        if (this.c != null) {
            str = this.c;
        } else {
            str = (String) getTag();
        }
        com.baidu.adp.widget.a.b d = com.baidu.tbadk.a.e.a().d(str);
        if (d == null || !d.g()) {
            z = false;
        } else {
            z2 = d.c();
            z = true;
        }
        if (this.b <= 0) {
            if (d == null) {
                d = getDefalutBitmap();
            }
            if (d != null) {
                if (getScaleType() == ImageView.ScaleType.FIT_XY) {
                    d.a(canvas, getWidth(), getHeight(), (Paint) null);
                } else {
                    d.a(canvas, (getWidth() - d.a()) >> 1, (getHeight() - d.b()) >> 1, (Paint) null);
                }
                if (z2) {
                    canvas.drawBitmap(this.f1799a, 0.0f, 0.0f, (Paint) null);
                }
            }
        } else if (d != null) {
            int i = (this.b * Util.MASK_8BIT) / 10;
            com.baidu.adp.widget.a.b defalutBitmap = getDefalutBitmap();
            if (defalutBitmap != null) {
                this.f.setAlpha(i);
                if (getScaleType() == ImageView.ScaleType.FIT_XY) {
                    defalutBitmap.a(canvas, getWidth(), getHeight(), this.f);
                } else {
                    defalutBitmap.a(canvas, (getWidth() - defalutBitmap.a()) >> 1, (getHeight() - defalutBitmap.b()) >> 1, this.f);
                }
            }
            this.f.setAlpha(255 - i);
            if (getScaleType() == ImageView.ScaleType.FIT_XY) {
                d.a(canvas, getWidth(), getHeight(), this.f);
            } else {
                d.a(canvas, (getWidth() - d.a()) >> 1, (getHeight() - d.b()) >> 1, this.f);
            }
            if (z2) {
                canvas.drawBitmap(this.f1799a, 0.0f, 0.0f, (Paint) null);
            }
        } else {
            com.baidu.adp.widget.a.b defalutBitmap2 = getDefalutBitmap();
            if (defalutBitmap2 != null) {
                defalutBitmap2.a(canvas, (getWidth() - defalutBitmap2.a()) >> 1, (getHeight() - defalutBitmap2.b()) >> 1, (Paint) null);
            }
        }
        if (TiebaApplication.f().au() == 1 && z) {
            canvas.drawColor(1275068416);
        }
    }

    private com.baidu.adp.widget.a.b getDefalutBitmap() {
        return TiebaApplication.f().au() == 1 ? new com.baidu.adp.widget.a.b(com.baidu.tieba.util.e.a(this.e), false, null) : new com.baidu.adp.widget.a.b(com.baidu.tieba.util.e.a(this.d), false, null);
    }
}
