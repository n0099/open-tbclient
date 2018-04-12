package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a gxZ;
    private b gyv;

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
        return this.gxZ.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.gxZ.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.gxZ;
    }

    public void setDragController(a aVar) {
        this.gxZ = aVar;
    }

    public void setDragObject(b bVar) {
        this.gyv = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.gyv;
    }

    public void bsy() {
        if (this.gyv != null) {
            if (this.gyv.aOQ != null) {
                this.gyv.aOQ.recycle();
                this.gyv.aOQ = null;
            }
            this.gyv = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.gyv != null && this.gxZ.gxQ) {
            this.gyv.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bsy();
    }
}
