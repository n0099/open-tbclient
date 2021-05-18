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
    public Scroller f20869e;

    /* renamed from: f  reason: collision with root package name */
    public Rect f20870f;

    /* renamed from: g  reason: collision with root package name */
    public View f20871g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f20872h;

    public DragContainer(Context context) {
        super(context);
        this.f20870f = new Rect();
        f(context);
    }

    public void c(View view) {
        this.f20871g = view;
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache != null) {
            this.f20872h = Bitmap.createBitmap(drawingCache);
        }
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        view.getDrawingRect(this.f20870f);
        offsetDescendantRectToMyCoords(view, this.f20870f);
        int height = getHeight();
        Scroller scroller = this.f20869e;
        int i2 = this.f20870f.top;
        scroller.startScroll(i2, 0, height - i2, 0, 800);
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f20871g != null) {
            if (this.f20869e.computeScrollOffset() && this.f20872h != null) {
                canvas.save();
                canvas.drawBitmap(this.f20872h, this.f20870f.left, this.f20869e.getCurrX(), (Paint) null);
                canvas.restore();
                postInvalidateDelayed(16L);
                return;
            }
            Bitmap bitmap = this.f20872h;
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.f20872h = null;
            this.f20871g = null;
        }
    }

    public final void f(Context context) {
        this.f20869e = new Scroller(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f20869e.forceFinished(true);
        Bitmap bitmap = this.f20872h;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.f20872h = null;
        this.f20871g = null;
    }

    public DragContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20870f = new Rect();
        f(context);
    }
}
