package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private b fDL;
    private e fEh;

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
        return this.fDL.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.fDL.onTouchEvent(motionEvent);
    }

    public b getDragController() {
        return this.fDL;
    }

    public void setDragController(b bVar) {
        this.fDL = bVar;
    }

    public void setDragObject(e eVar) {
        this.fEh = eVar;
        invalidate();
    }

    public e getDragObject() {
        return this.fEh;
    }

    public void bmJ() {
        if (this.fEh != null) {
            if (this.fEh.aGn != null) {
                this.fEh.aGn.recycle();
                this.fEh.aGn = null;
            }
            this.fEh = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.fEh != null && this.fDL.fDC) {
            this.fEh.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bmJ();
    }
}
