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
    public Scroller f21625e;

    /* renamed from: f  reason: collision with root package name */
    public Rect f21626f;

    /* renamed from: g  reason: collision with root package name */
    public View f21627g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f21628h;

    public DragContainer(Context context) {
        super(context);
        this.f21626f = new Rect();
        f(context);
    }

    public void c(View view) {
        this.f21627g = view;
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache != null) {
            this.f21628h = Bitmap.createBitmap(drawingCache);
        }
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        view.getDrawingRect(this.f21626f);
        offsetDescendantRectToMyCoords(view, this.f21626f);
        int height = getHeight();
        Scroller scroller = this.f21625e;
        int i2 = this.f21626f.top;
        scroller.startScroll(i2, 0, height - i2, 0, 800);
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f21627g != null) {
            if (this.f21625e.computeScrollOffset() && this.f21628h != null) {
                canvas.save();
                canvas.drawBitmap(this.f21628h, this.f21626f.left, this.f21625e.getCurrX(), (Paint) null);
                canvas.restore();
                postInvalidateDelayed(16L);
                return;
            }
            Bitmap bitmap = this.f21628h;
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.f21628h = null;
            this.f21627g = null;
        }
    }

    public final void f(Context context) {
        this.f21625e = new Scroller(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f21625e.forceFinished(true);
        Bitmap bitmap = this.f21628h;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.f21628h = null;
        this.f21627g = null;
    }

    public DragContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21626f = new Rect();
        f(context);
    }
}
