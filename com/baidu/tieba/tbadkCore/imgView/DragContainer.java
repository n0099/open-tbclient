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
    public Scroller f21033e;

    /* renamed from: f  reason: collision with root package name */
    public Rect f21034f;

    /* renamed from: g  reason: collision with root package name */
    public View f21035g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f21036h;

    public DragContainer(Context context) {
        super(context);
        this.f21034f = new Rect();
        f(context);
    }

    public void c(View view) {
        this.f21035g = view;
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache != null) {
            this.f21036h = Bitmap.createBitmap(drawingCache);
        }
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        view.getDrawingRect(this.f21034f);
        offsetDescendantRectToMyCoords(view, this.f21034f);
        int height = getHeight();
        Scroller scroller = this.f21033e;
        int i = this.f21034f.top;
        scroller.startScroll(i, 0, height - i, 0, 800);
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f21035g != null) {
            if (this.f21033e.computeScrollOffset() && this.f21036h != null) {
                canvas.save();
                canvas.drawBitmap(this.f21036h, this.f21034f.left, this.f21033e.getCurrX(), (Paint) null);
                canvas.restore();
                postInvalidateDelayed(16L);
                return;
            }
            Bitmap bitmap = this.f21036h;
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.f21036h = null;
            this.f21035g = null;
        }
    }

    public final void f(Context context) {
        this.f21033e = new Scroller(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f21033e.forceFinished(true);
        Bitmap bitmap = this.f21036h;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.f21036h = null;
        this.f21035g = null;
    }

    public DragContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21034f = new Rect();
        f(context);
    }
}
