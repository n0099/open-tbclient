package com.baidu.tieba.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public class HeadImageView extends TbImageView {
    private String b;
    private String c;
    private final Paint d;
    private final Paint e;
    private final RectF f;
    private final RectF g;
    private int h;
    private int i;
    private float j;
    private boolean k;

    public HeadImageView(Context context) {
        this(context, null, 0);
    }

    public HeadImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = null;
        this.c = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.tieba.ad.HeadImageView);
        this.j = obtainStyledAttributes.getFloat(0, -1.0f);
        obtainStyledAttributes.recycle();
        this.i = UtilHelper.a(context, 5.0f);
        this.f = new RectF();
        this.g = new RectF();
        this.h = (int) ((getResources().getDisplayMetrics().density * 1.0f) + 0.5d);
        this.d = new Paint();
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setAntiAlias(true);
        this.d.setColor(637534208);
        this.d.setStrokeWidth(this.h);
        this.e = new Paint();
        this.e.setColor(1275068416);
        this.e.setAntiAlias(true);
        setRadius(this.i);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.j == -1.0f) {
            super.onMeasure(i, i2);
        } else {
            super.onMeasure(i, ((int) ((1073741823 & i) * this.j)) + 1073741824);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int i5 = this.h >> 1;
        this.g.set(0.0f, 0.0f, i3 - i, i4 - i2);
        this.f.set(i5, i5, (i3 - i) - i5, (i4 - i2) - i5);
    }

    public void setUserId(String str) {
        this.b = str;
    }

    public String getUserId() {
        return this.b;
    }

    public void setUserName(String str) {
        this.c = str;
    }

    public String getUserName() {
        return this.c;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
    }

    @Override // com.baidu.adp.widget.a.a, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (bitmap == null) {
            this.k = false;
            return;
        }
        setImageDrawable(new com.baidu.adp.widget.p(getResources(), null, this, bitmap, this.i));
        this.k = true;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.widget.a.a, android.view.View
    public void setTag(Object obj) {
        super.setTag(obj);
        if (obj != null) {
            setDrawRoundCover(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.widget.a.a, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.k) {
            canvas.drawRoundRect(this.f, this.i, this.i, this.d);
            if (TiebaApplication.g().an() == 1) {
                canvas.drawRoundRect(this.g, this.i, this.i, this.e);
            }
        }
    }
}
