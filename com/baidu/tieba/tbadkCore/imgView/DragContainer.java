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
    public Scroller f20789e;

    /* renamed from: f  reason: collision with root package name */
    public Rect f20790f;

    /* renamed from: g  reason: collision with root package name */
    public View f20791g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f20792h;

    public DragContainer(Context context) {
        super(context);
        this.f20790f = new Rect();
        f(context);
    }

    public void c(View view) {
        this.f20791g = view;
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache != null) {
            this.f20792h = Bitmap.createBitmap(drawingCache);
        }
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        view.getDrawingRect(this.f20790f);
        offsetDescendantRectToMyCoords(view, this.f20790f);
        int height = getHeight();
        Scroller scroller = this.f20789e;
        int i2 = this.f20790f.top;
        scroller.startScroll(i2, 0, height - i2, 0, 800);
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f20791g != null) {
            if (this.f20789e.computeScrollOffset() && this.f20792h != null) {
                canvas.save();
                canvas.drawBitmap(this.f20792h, this.f20790f.left, this.f20789e.getCurrX(), (Paint) null);
                canvas.restore();
                postInvalidateDelayed(16L);
                return;
            }
            Bitmap bitmap = this.f20792h;
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.f20792h = null;
            this.f20791g = null;
        }
    }

    public final void f(Context context) {
        this.f20789e = new Scroller(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f20789e.forceFinished(true);
        Bitmap bitmap = this.f20792h;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.f20792h = null;
        this.f20791g = null;
    }

    public DragContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20790f = new Rect();
        f(context);
    }
}
