package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private b fzB;
    private e fzX;

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
        return this.fzB.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.fzB.onTouchEvent(motionEvent);
    }

    public b getDragController() {
        return this.fzB;
    }

    public void setDragController(b bVar) {
        this.fzB = bVar;
    }

    public void setDragObject(e eVar) {
        this.fzX = eVar;
        invalidate();
    }

    public e getDragObject() {
        return this.fzX;
    }

    public void bjP() {
        if (this.fzX != null) {
            if (this.fzX.aKl != null) {
                this.fzX.aKl.recycle();
                this.fzX.aKl = null;
            }
            this.fzX = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.fzX != null && this.fzB.fzs) {
            this.fzX.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bjP();
    }
}
