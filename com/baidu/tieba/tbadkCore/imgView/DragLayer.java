package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a iHB;
    private b iHW;

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
        return this.iHB.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.iHB.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.iHB;
    }

    public void setDragController(a aVar) {
        this.iHB = aVar;
    }

    public void setDragObject(b bVar) {
        this.iHW = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.iHW;
    }

    public void ceQ() {
        if (this.iHW != null) {
            if (this.iHW.cuX != null) {
                this.iHW.cuX.recycle();
                this.iHW.cuX = null;
            }
            this.iHW = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.iHW != null && this.iHB.iHs) {
            this.iHW.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ceQ();
    }
}
