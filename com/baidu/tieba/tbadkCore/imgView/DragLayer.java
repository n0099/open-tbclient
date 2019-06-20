package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a jaA;
    private b jaV;

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
        return this.jaA.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.jaA.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.jaA;
    }

    public void setDragController(a aVar) {
        this.jaA = aVar;
    }

    public void setDragObject(b bVar) {
        this.jaV = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.jaV;
    }

    public void cmY() {
        if (this.jaV != null) {
            if (this.jaV.cDh != null) {
                this.jaV.cDh.recycle();
                this.jaV.cDh = null;
            }
            this.jaV = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.jaV != null && this.jaA.jar) {
            this.jaV.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cmY();
    }
}
