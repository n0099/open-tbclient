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
    private Bitmap bm;
    private final int delay;
    private Scroller mScroller;
    private Rect mTempRect;
    private View view;

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

    public void dm(View view) {
        this.view = view;
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache != null) {
            this.bm = Bitmap.createBitmap(drawingCache);
        }
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        this.mScroller.startScroll(this.mTempRect.top, 0, getHeight() - this.mTempRect.top, 0, 800);
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.view != null) {
            if (this.mScroller.computeScrollOffset() && this.bm != null) {
                canvas.save();
                canvas.drawBitmap(this.bm, this.mTempRect.left, this.mScroller.getCurrX(), (Paint) null);
                canvas.restore();
                postInvalidateDelayed(16L);
                return;
            }
            if (this.bm != null) {
                this.bm.recycle();
            }
            this.bm = null;
            this.view = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mScroller.forceFinished(true);
        if (this.bm != null) {
            this.bm.recycle();
        }
        this.bm = null;
        this.view = null;
    }
}
