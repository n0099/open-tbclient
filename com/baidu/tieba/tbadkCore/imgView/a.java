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
public class a extends LinearLayout {
    private Bitmap aOs;
    private final int delay;
    private Scroller mScroller;
    private Rect mTempRect;
    private View view;

    public a(Context context) {
        super(context);
        this.mTempRect = new Rect();
        this.delay = 16;
        init(context);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTempRect = new Rect();
        this.delay = 16;
        init(context);
    }

    private void init(Context context) {
        this.mScroller = new Scroller(context);
    }

    public void bH(View view) {
        this.view = view;
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache != null) {
            this.aOs = Bitmap.createBitmap(drawingCache);
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
            if (this.mScroller.computeScrollOffset() && this.aOs != null) {
                canvas.save();
                canvas.drawBitmap(this.aOs, this.mTempRect.left, this.mScroller.getCurrX(), (Paint) null);
                canvas.restore();
                postInvalidateDelayed(16L);
                return;
            }
            if (this.aOs != null) {
                this.aOs.recycle();
            }
            this.aOs = null;
            this.view = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mScroller.forceFinished(true);
        if (this.aOs != null) {
            this.aOs.recycle();
        }
        this.aOs = null;
        this.view = null;
    }
}
