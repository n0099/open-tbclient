package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a nBb;
    private b nBv;

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
        return this.nBb.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.nBb.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.nBb;
    }

    public void setDragController(a aVar) {
        this.nBb = aVar;
    }

    public void setDragObject(b bVar) {
        this.nBv = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.nBv;
    }

    public void dOp() {
        if (this.nBv != null) {
            if (this.nBv.bm != null) {
                this.nBv.bm.recycle();
                this.nBv.bm = null;
            }
            this.nBv = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.nBv != null && this.nBb.nAS) {
            this.nBv.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dOp();
    }
}
