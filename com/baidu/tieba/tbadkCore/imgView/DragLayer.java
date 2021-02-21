package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a nyW;
    private b nzq;

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
        return this.nyW.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.nyW.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.nyW;
    }

    public void setDragController(a aVar) {
        this.nyW = aVar;
    }

    public void setDragObject(b bVar) {
        this.nzq = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.nzq;
    }

    public void dOg() {
        if (this.nzq != null) {
            if (this.nzq.bm != null) {
                this.nzq.bm.recycle();
                this.nzq.bm = null;
            }
            this.nzq = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.nzq != null && this.nyW.nyN) {
            this.nzq.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dOg();
    }
}
