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
/* loaded from: classes.dex */
public class DragContainer extends LinearLayout {
    private Bitmap aOR;
    private final int delay;
    private Scroller mScroller;
    private Rect mTempRect;

    /* renamed from: view  reason: collision with root package name */
    private View f17view;

    public DragContainer(Context context) {
        super(context);
        this.mTempRect = new Rect();
        this.delay = 16;
        init(context);
    }

    public DragContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTempRect = new Rect();
        this.delay = 16;
        init(context);
    }

    private void init(Context context) {
        this.mScroller = new Scroller(context);
    }

    public void bv(View view2) {
        this.f17view = view2;
        view2.setDrawingCacheEnabled(true);
        view2.buildDrawingCache();
        Bitmap drawingCache = view2.getDrawingCache();
        if (drawingCache != null) {
            this.aOR = Bitmap.createBitmap(drawingCache);
        }
        view2.destroyDrawingCache();
        view2.setDrawingCacheEnabled(false);
        view2.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view2, this.mTempRect);
        this.mScroller.startScroll(this.mTempRect.top, 0, getHeight() - this.mTempRect.top, 0, 800);
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f17view != null) {
            if (this.mScroller.computeScrollOffset() && this.aOR != null) {
                canvas.save();
                canvas.drawBitmap(this.aOR, this.mTempRect.left, this.mScroller.getCurrX(), (Paint) null);
                canvas.restore();
                postInvalidateDelayed(16L);
                return;
            }
            if (this.aOR != null) {
                this.aOR.recycle();
            }
            this.aOR = null;
            this.f17view = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mScroller.forceFinished(true);
        if (this.aOR != null) {
            this.aOR.recycle();
        }
        this.aOR = null;
        this.f17view = null;
    }
}
