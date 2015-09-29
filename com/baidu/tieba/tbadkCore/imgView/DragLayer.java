package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a cZI;
    private d dag;

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
        return this.cZI.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.cZI.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.cZI;
    }

    public void setDragController(a aVar) {
        this.cZI = aVar;
    }

    public void setDragObject(d dVar) {
        this.dag = dVar;
        invalidate();
    }

    public d getDragObject() {
        return this.dag;
    }

    public void awX() {
        if (this.dag != null) {
            if (this.dag.aAz != null) {
                this.dag.aAz.recycle();
                this.dag.aAz = null;
            }
            this.dag = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.dag != null && this.cZI.cZz) {
            this.dag.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        awX();
    }
}
