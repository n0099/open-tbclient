package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private c gjN;
    private b gjq;

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
        return this.gjq.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.gjq.onTouchEvent(motionEvent);
    }

    public b getDragController() {
        return this.gjq;
    }

    public void setDragController(b bVar) {
        this.gjq = bVar;
    }

    public void setDragObject(c cVar) {
        this.gjN = cVar;
        invalidate();
    }

    public c getDragObject() {
        return this.gjN;
    }

    public void bsY() {
        if (this.gjN != null) {
            if (this.gjN.aNS != null) {
                this.gjN.aNS.recycle();
                this.gjN.aNS = null;
            }
            this.gjN = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.gjN != null && this.gjq.gjh) {
            this.gjN.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bsY();
    }
}
