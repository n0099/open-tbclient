package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private b jkP;
    private a jku;

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
        return this.jku.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.jku.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.jku;
    }

    public void setDragController(a aVar) {
        this.jku = aVar;
    }

    public void setDragObject(b bVar) {
        this.jkP = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.jkP;
    }

    public void crb() {
        if (this.jkP != null) {
            if (this.jkP.cFw != null) {
                this.jkP.cFw.recycle();
                this.jkP.cFw = null;
            }
            this.jkP = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.jkP != null && this.jku.jkl) {
            this.jkP.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        crb();
    }
}
