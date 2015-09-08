package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private d cSC;
    private a cSe;

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
        return this.cSe.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.cSe.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.cSe;
    }

    public void setDragController(a aVar) {
        this.cSe = aVar;
    }

    public void setDragObject(d dVar) {
        this.cSC = dVar;
        invalidate();
    }

    public d getDragObject() {
        return this.cSC;
    }

    public void auI() {
        if (this.cSC != null) {
            if (this.cSC.aBV != null) {
                this.cSC.aBV.recycle();
                this.cSC.aBV = null;
            }
            this.cSC = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cSC != null && this.cSe.cRV) {
            this.cSC.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        auI();
    }
}
