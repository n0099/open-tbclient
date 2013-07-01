package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ADImageViewDrawer extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private Bitmap f1476a;
    private int b;
    private int c;
    private Paint d;

    public ADImageViewDrawer(Context context) {
        super(context);
        this.f1476a = com.baidu.tieba.util.d.a((int) R.drawable.icon_gif);
        this.b = R.drawable.pic_image_h_not;
        this.c = R.drawable.pic_image_h_not_1;
        this.d = new Paint();
        a();
    }

    public ADImageViewDrawer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1476a = com.baidu.tieba.util.d.a((int) R.drawable.icon_gif);
        this.b = R.drawable.pic_image_h_not;
        this.c = R.drawable.pic_image_h_not_1;
        this.d = new Paint();
        a();
    }

    public ADImageViewDrawer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1476a = com.baidu.tieba.util.d.a((int) R.drawable.icon_gif);
        this.b = R.drawable.pic_image_h_not;
        this.c = R.drawable.pic_image_h_not_1;
        this.d = new Paint();
        a();
    }

    private void a() {
        this.d.setAntiAlias(true);
        this.d.setFilterBitmap(true);
        this.d.setDither(true);
    }

    public void setDefaultId(int i) {
        this.b = i;
        this.c = i;
    }

    public void setNightDefaultId(int i) {
        this.c = i;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z;
        com.baidu.adp.widget.a.b defalutBitmap;
        boolean z2 = false;
        super.onDraw(canvas);
        com.baidu.adp.widget.a.b d = com.baidu.tbadk.a.e.a().d((String) getTag());
        if (d == null || !d.g()) {
            z = false;
        } else {
            z2 = d.c();
            z = true;
        }
        if (d == null) {
            getDefalutBitmap().a(canvas, (getWidth() - defalutBitmap.a()) >> 1, (getHeight() - defalutBitmap.b()) >> 1, (Paint) null);
        } else {
            d.a(canvas, getWidth(), getHeight(), this.d);
            if (z2) {
                canvas.drawBitmap(this.f1476a, 0.0f, 0.0f, (Paint) null);
            }
        }
        if (TiebaApplication.f().at() == 1 && z) {
            canvas.drawColor(1275068416);
        }
    }

    private com.baidu.adp.widget.a.b getDefalutBitmap() {
        return TiebaApplication.f().at() == 1 ? new com.baidu.adp.widget.a.b(com.baidu.tieba.util.d.a(this.c), false, null) : new com.baidu.adp.widget.a.b(com.baidu.tieba.util.d.a(this.b), false, null);
    }
}
