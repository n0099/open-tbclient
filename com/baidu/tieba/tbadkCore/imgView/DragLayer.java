package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a gKC;
    private b gKY;

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
        return this.gKC.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.gKC.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.gKC;
    }

    public void setDragController(a aVar) {
        this.gKC = aVar;
    }

    public void setDragObject(b bVar) {
        this.gKY = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.gKY;
    }

    public void bxB() {
        if (this.gKY != null) {
            if (this.gKY.aWN != null) {
                this.gKY.aWN.recycle();
                this.gKY.aWN = null;
            }
            this.gKY = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.gKY != null && this.gKC.gKt) {
            this.gKY.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bxB();
    }
}
