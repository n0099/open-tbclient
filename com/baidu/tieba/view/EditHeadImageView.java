package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class EditHeadImageView extends f {
    private Paint b;
    private int c;
    private int d;
    private float e;
    private int f;
    private Matrix g;

    public EditHeadImageView(Context context) {
        super(context);
        this.c = 0;
        this.d = 0;
        this.e = 0.42857143f;
        this.f = 0;
        r();
    }

    public EditHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 0;
        this.d = 0;
        this.e = 0.42857143f;
        this.f = 0;
        r();
    }

    public EditHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = 0;
        this.d = 0;
        this.e = 0.42857143f;
        this.f = 0;
        r();
    }

    private void r() {
        this.b = new Paint();
        this.b.setColor(-16777216);
        this.b.setAlpha(153);
        this.f = getResources().getColor(R.color.editimage_bg);
        setDrawingCacheEnabled(true);
        setImageMode(1);
        this.g = new Matrix();
    }

    public Bitmap getHeadBitmap() {
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            Bitmap createBitmap = Bitmap.createBitmap(drawingCache, 0, this.c, getWidth(), getWidth());
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, 110, 110, false);
            createBitmap.recycle();
            return createScaledBitmap;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.view.f, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawColor(this.f);
        super.onDraw(canvas);
        canvas.setMatrix(this.g);
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.c, this.b);
        canvas.drawRect(0.0f, getHeight() - this.d, getWidth(), getHeight(), this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.view.f, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.c = (int) (((i4 - i2) - (i3 - i)) * this.e);
        this.d = (int) (((i4 - i2) - (i3 - i)) * (1.0f - this.e));
        a(0, this.c, 0, this.d);
    }

    @Override // com.baidu.tieba.view.f, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
    }
}
