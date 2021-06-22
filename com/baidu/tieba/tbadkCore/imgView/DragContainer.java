package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Scroller;
/* loaded from: classes5.dex */
public class DragContainer extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Scroller f20948e;

    /* renamed from: f  reason: collision with root package name */
    public Rect f20949f;

    /* renamed from: g  reason: collision with root package name */
    public View f20950g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f20951h;

    public DragContainer(Context context) {
        super(context);
        this.f20949f = new Rect();
        f(context);
    }

    public void c(View view) {
        this.f20950g = view;
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache != null) {
            this.f20951h = Bitmap.createBitmap(drawingCache);
        }
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        view.getDrawingRect(this.f20949f);
        offsetDescendantRectToMyCoords(view, this.f20949f);
        int height = getHeight();
        Scroller scroller = this.f20948e;
        int i2 = this.f20949f.top;
        scroller.startScroll(i2, 0, height - i2, 0, 800);
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f20950g != null) {
            if (this.f20948e.computeScrollOffset() && this.f20951h != null) {
                canvas.save();
                canvas.drawBitmap(this.f20951h, this.f20949f.left, this.f20948e.getCurrX(), (Paint) null);
                canvas.restore();
                postInvalidateDelayed(16L);
                return;
            }
            Bitmap bitmap = this.f20951h;
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.f20951h = null;
            this.f20950g = null;
        }
    }

    public final void f(Context context) {
        this.f20948e = new Scroller(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f20948e.forceFinished(true);
        Bitmap bitmap = this.f20951h;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.f20951h = null;
        this.f20950g = null;
    }

    public DragContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20949f = new Rect();
        f(context);
    }
}
