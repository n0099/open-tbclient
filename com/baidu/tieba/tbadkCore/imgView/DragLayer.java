package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private b fNG;
    private e fOd;

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
        return this.fNG.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.fNG.onTouchEvent(motionEvent);
    }

    public b getDragController() {
        return this.fNG;
    }

    public void setDragController(b bVar) {
        this.fNG = bVar;
    }

    public void setDragObject(e eVar) {
        this.fOd = eVar;
        invalidate();
    }

    public e getDragObject() {
        return this.fOd;
    }

    public void bmU() {
        if (this.fOd != null) {
            if (this.fOd.aLw != null) {
                this.fOd.aLw.recycle();
                this.fOd.aLw = null;
            }
            this.fOd = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.fOd != null && this.fNG.fNx) {
            this.fOd.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bmU();
    }
}
