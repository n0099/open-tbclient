package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private b gAJ;
    private c gBg;

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
        return this.gAJ.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.gAJ.onTouchEvent(motionEvent);
    }

    public b getDragController() {
        return this.gAJ;
    }

    public void setDragController(b bVar) {
        this.gAJ = bVar;
    }

    public void setDragObject(c cVar) {
        this.gBg = cVar;
        invalidate();
    }

    public c getDragObject() {
        return this.gBg;
    }

    public void bwQ() {
        if (this.gBg != null) {
            if (this.gBg.aOp != null) {
                this.gBg.aOp.recycle();
                this.gBg.aOp = null;
            }
            this.gBg = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.gBg != null && this.gAJ.gAA) {
            this.gBg.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bwQ();
    }
}
