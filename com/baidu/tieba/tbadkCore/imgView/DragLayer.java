package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a nnF;
    private b nob;

    public DragLayer(Context context) {
        super(context);
        init();
    }

    public DragLayer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public DragLayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.nnF.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.nnF.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.nnF;
    }

    public void setDragController(a aVar) {
        this.nnF = aVar;
    }

    public void setDragObject(b bVar) {
        this.nob = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.nob;
    }

    public void dPI() {
        if (this.nob != null) {
            if (this.nob.bm != null) {
                this.nob.bm.recycle();
                this.nob.bm = null;
            }
            this.nob = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.nob != null && this.nnF.nnw) {
            this.nob.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dPI();
    }
}
