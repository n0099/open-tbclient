package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private b mGA;
    private a mGd;

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
        return this.mGd.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mGd.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.mGd;
    }

    public void setDragController(a aVar) {
        this.mGd = aVar;
    }

    public void setDragObject(b bVar) {
        this.mGA = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.mGA;
    }

    public void dEQ() {
        if (this.mGA != null) {
            if (this.mGA.bm != null) {
                this.mGA.bm.recycle();
                this.mGA.bm = null;
            }
            this.mGA = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mGA != null && this.mGd.mFU) {
            this.mGA.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dEQ();
    }
}
