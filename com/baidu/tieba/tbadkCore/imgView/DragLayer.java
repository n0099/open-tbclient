package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private b gqK;
    private c grh;

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
        return this.gqK.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.gqK.onTouchEvent(motionEvent);
    }

    public b getDragController() {
        return this.gqK;
    }

    public void setDragController(b bVar) {
        this.gqK = bVar;
    }

    public void setDragObject(c cVar) {
        this.grh = cVar;
        invalidate();
    }

    public c getDragObject() {
        return this.grh;
    }

    public void buU() {
        if (this.grh != null) {
            if (this.grh.aNG != null) {
                this.grh.aNG.recycle();
                this.grh.aNG = null;
            }
            this.grh = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.grh != null && this.gqK.gqB) {
            this.grh.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        buU();
    }
}
