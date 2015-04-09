package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a cpb;
    private e cpy;

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
        return this.cpb.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.cpb.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.cpb;
    }

    public void setDragController(a aVar) {
        this.cpb = aVar;
    }

    public void setDragObject(e eVar) {
        this.cpy = eVar;
        invalidate();
    }

    public e getDragObject() {
        return this.cpy;
    }

    public void ani() {
        if (this.cpy != null) {
            if (this.cpy.arB != null) {
                this.cpy.arB.recycle();
                this.cpy.arB = null;
            }
            this.cpy = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cpy != null && this.cpb.coR) {
            this.cpy.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ani();
    }
}
