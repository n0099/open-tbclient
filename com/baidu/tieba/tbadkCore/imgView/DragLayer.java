package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a iHW;
    private b iIr;

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
        return this.iHW.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.iHW.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.iHW;
    }

    public void setDragController(a aVar) {
        this.iHW = aVar;
    }

    public void setDragObject(b bVar) {
        this.iIr = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.iIr;
    }

    public void ceR() {
        if (this.iIr != null) {
            if (this.iIr.cuX != null) {
                this.iIr.cuX.recycle();
                this.iIr.cuX = null;
            }
            this.iIr = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.iIr != null && this.iHW.iHN) {
            this.iIr.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ceR();
    }
}
