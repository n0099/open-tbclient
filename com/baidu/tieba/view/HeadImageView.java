package com.baidu.tieba.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public class HeadImageView extends TbImageView {
    private int b;
    private String c;
    private String d;
    private final Paint e;
    private final Paint f;
    private final RectF g;
    private final RectF h;
    private int i;
    private int j;
    private float k;
    private boolean l;
    private boolean m;
    private boolean n;

    public HeadImageView(Context context) {
        this(context, null, 0);
        this.m = true;
    }

    public HeadImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.m = true;
    }

    public HeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = null;
        this.d = null;
        this.m = true;
        this.n = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.tieba.al.HeadImageView);
        this.k = obtainStyledAttributes.getFloat(0, -1.0f);
        obtainStyledAttributes.recycle();
        this.g = new RectF();
        this.h = new RectF();
        this.i = (int) ((getResources().getDisplayMetrics().density * 1.0f) + 0.5d);
        this.e = new Paint();
        this.e.setStyle(Paint.Style.STROKE);
        this.e.setAntiAlias(true);
        this.e.setColor(637534208);
        this.e.setStrokeWidth(this.i);
        this.f = new Paint();
        this.f.setColor(1275068416);
        this.f.setAntiAlias(true);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, com.baidu.tieba.al.HeadImageView);
        if (obtainStyledAttributes2.getBoolean(1, true)) {
            this.j = UtilHelper.a(context, 5.0f);
            setRadius(this.j);
        }
        setIsShowGifTag(obtainStyledAttributes2.getBoolean(2, true));
        obtainStyledAttributes2.recycle();
        this.m = true;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.k == -1.0f || Build.VERSION.SDK_INT < 11) {
            super.onMeasure(i, i2);
        } else {
            super.onMeasure(i, ((int) ((1073741823 & i) * this.k)) + 1073741824);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int i5 = this.i >> 1;
        this.h.set(0.0f, 0.0f, i3 - i, i4 - i2);
        this.g.set(i5, i5, (i3 - i) - i5, (i4 - i2) - i5);
    }

    public void setAutoChangeStyle(boolean z) {
        this.n = z;
    }

    public void setUserId(String str) {
        this.c = str;
    }

    public String getUserId() {
        return this.c;
    }

    public void setUserName(String str) {
        this.d = str;
    }

    public String getUserName() {
        return this.d;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // com.baidu.adp.widget.ImageView.a, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (bitmap == null) {
            this.l = false;
            return;
        }
        setImageDrawable(new com.baidu.adp.widget.r(getResources(), null, this, bitmap, this.j));
        this.l = true;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.widget.ImageView.a, android.view.View
    public void setTag(Object obj) {
        super.setTag(obj);
        if (obj != null) {
            setDrawRoundCover(true);
        }
    }

    public void b() {
        if (this.l) {
            if (this.b != TiebaApplication.g().as()) {
                invalidate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.widget.ImageView.a, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.l) {
            int as = TiebaApplication.g().as();
            if (c()) {
                canvas.drawRoundRect(this.g, this.j, this.j, this.e);
                if (this.n && as == 1) {
                    canvas.drawRoundRect(this.h, this.j, this.j, this.f);
                }
            }
            this.b = as;
        }
    }

    public boolean c() {
        return this.m;
    }

    public void setDrawBorder(boolean z) {
        this.m = z;
    }
}
