package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private b hrI;
    private a hrn;

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
        return this.hrn.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.hrn.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.hrn;
    }

    public void setDragController(a aVar) {
        this.hrn = aVar;
    }

    public void setDragObject(b bVar) {
        this.hrI = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.hrI;
    }

    public void bFs() {
        if (this.hrI != null) {
            if (this.hrI.bkM != null) {
                this.hrI.bkM.recycle();
                this.hrI.bkM = null;
            }
            this.hrI = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.hrI != null && this.hrn.hre) {
            this.hrI.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bFs();
    }
}
