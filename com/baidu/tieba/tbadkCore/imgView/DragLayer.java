package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private b fDB;
    private e fDY;

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
        return this.fDB.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.fDB.onTouchEvent(motionEvent);
    }

    public b getDragController() {
        return this.fDB;
    }

    public void setDragController(b bVar) {
        this.fDB = bVar;
    }

    public void setDragObject(e eVar) {
        this.fDY = eVar;
        invalidate();
    }

    public e getDragObject() {
        return this.fDY;
    }

    public void biG() {
        if (this.fDY != null) {
            if (this.fDY.aKh != null) {
                this.fDY.aKh.recycle();
                this.fDY.aKh = null;
            }
            this.fDY = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.fDY != null && this.fDB.fDs) {
            this.fDY.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        biG();
    }
}
