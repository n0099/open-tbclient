package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private d dYH;
    private a dYl;

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
        return this.dYl.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.dYl.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.dYl;
    }

    public void setDragController(a aVar) {
        this.dYl = aVar;
    }

    public void setDragObject(d dVar) {
        this.dYH = dVar;
        invalidate();
    }

    public d getDragObject() {
        return this.dYH;
    }

    public void aMW() {
        if (this.dYH != null) {
            if (this.dYH.aEb != null) {
                this.dYH.aEb.recycle();
                this.dYH.aEb = null;
            }
            this.dYH = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.dYH != null && this.dYl.dYc) {
            this.dYH.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aMW();
    }
}
