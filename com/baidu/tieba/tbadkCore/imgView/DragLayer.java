package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private b nyQ;
    private a nyw;

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
        return this.nyw.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.nyw.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.nyw;
    }

    public void setDragController(a aVar) {
        this.nyw = aVar;
    }

    public void setDragObject(b bVar) {
        this.nyQ = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.nyQ;
    }

    public void dNY() {
        if (this.nyQ != null) {
            if (this.nyQ.bm != null) {
                this.nyQ.bm.recycle();
                this.nyQ.bm = null;
            }
            this.nyQ = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.nyQ != null && this.nyw.nyn) {
            this.nyQ.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dNY();
    }
}
