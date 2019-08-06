package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a jhY;
    private b jiu;

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
        return this.jhY.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.jhY.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.jhY;
    }

    public void setDragController(a aVar) {
        this.jhY = aVar;
    }

    public void setDragObject(b bVar) {
        this.jiu = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.jiu;
    }

    public void cqn() {
        if (this.jiu != null) {
            if (this.jiu.cEF != null) {
                this.jiu.cEF.recycle();
                this.jiu.cEF = null;
            }
            this.jiu = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.jiu != null && this.jhY.jhP) {
            this.jiu.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cqn();
    }
}
