package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private e fxH;
    private b fxl;

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
        return this.fxl.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.fxl.onTouchEvent(motionEvent);
    }

    public b getDragController() {
        return this.fxl;
    }

    public void setDragController(b bVar) {
        this.fxl = bVar;
    }

    public void setDragObject(e eVar) {
        this.fxH = eVar;
        invalidate();
    }

    public e getDragObject() {
        return this.fxH;
    }

    public void biO() {
        if (this.fxH != null) {
            if (this.fxH.aKj != null) {
                this.fxH.aKj.recycle();
                this.fxH.aKj = null;
            }
            this.fxH = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.fxH != null && this.fxl.fxb) {
            this.fxH.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        biO();
    }
}
