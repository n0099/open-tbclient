package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageButton;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class HeartButton extends ImageButton {
    private Bitmap a;
    private float b;
    private Rect c;
    private Rect d;

    public HeartButton(Context context) {
        super(context);
        this.a = null;
        this.b = 0.0f;
        this.c = null;
        this.d = null;
        a();
    }

    public HeartButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
        this.b = 0.0f;
        this.c = null;
        this.d = null;
        a();
    }

    public HeartButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = null;
        this.b = 0.0f;
        this.c = null;
        this.d = null;
        a();
    }

    private void a() {
        this.c = new Rect();
        this.d = new Rect();
        this.a = BitmapFactory.decodeResource(getResources(), R.drawable.tag_heart_normal);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int height;
        super.onDraw(canvas);
        if (this.b != 0.0f) {
            if (this.b == 1.0f) {
                height = this.a.getHeight();
            } else {
                height = (int) (this.a.getHeight() * this.b);
            }
            this.c.left = 0;
            this.c.right = this.a.getWidth();
            this.c.top = this.a.getHeight() - height;
            this.c.bottom = this.a.getHeight();
            this.d.left = 0;
            this.d.right = this.a.getWidth();
            this.d.top = this.a.getHeight() - height;
            this.d.bottom = this.a.getHeight();
            canvas.drawBitmap(this.a, this.c, this.d, (Paint) null);
        }
    }

    public void setRatio(float f) {
        this.b = f;
        invalidate();
    }

    public float getRatio() {
        return this.b;
    }
}
