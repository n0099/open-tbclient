package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private b fvB;
    private e fvX;

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
        return this.fvB.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.fvB.onTouchEvent(motionEvent);
    }

    public b getDragController() {
        return this.fvB;
    }

    public void setDragController(b bVar) {
        this.fvB = bVar;
    }

    public void setDragObject(e eVar) {
        this.fvX = eVar;
        invalidate();
    }

    public e getDragObject() {
        return this.fvX;
    }

    public void bid() {
        if (this.fvX != null) {
            if (this.fvX.aJT != null) {
                this.fvX.aJT.recycle();
                this.fvX.aJT = null;
            }
            this.fvX = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.fvX != null && this.fvB.fvs) {
            this.fvX.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bid();
    }
}
