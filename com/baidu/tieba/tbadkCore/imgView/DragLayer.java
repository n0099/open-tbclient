package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private b gkE;
    private c glb;

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
        return this.gkE.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.gkE.onTouchEvent(motionEvent);
    }

    public b getDragController() {
        return this.gkE;
    }

    public void setDragController(b bVar) {
        this.gkE = bVar;
    }

    public void setDragObject(c cVar) {
        this.glb = cVar;
        invalidate();
    }

    public c getDragObject() {
        return this.glb;
    }

    public void bsZ() {
        if (this.glb != null) {
            if (this.glb.aNA != null) {
                this.glb.aNA.recycle();
                this.glb.aNA = null;
            }
            this.glb = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.glb != null && this.gkE.gku) {
            this.glb.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bsZ();
    }
}
