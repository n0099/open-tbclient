package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private b gZN;
    private c haj;

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
        return this.gZN.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.gZN.onTouchEvent(motionEvent);
    }

    public b getDragController() {
        return this.gZN;
    }

    public void setDragController(b bVar) {
        this.gZN = bVar;
    }

    public void setDragObject(c cVar) {
        this.haj = cVar;
        invalidate();
    }

    public c getDragObject() {
        return this.haj;
    }

    public void bwj() {
        if (this.haj != null) {
            if (this.haj.bCr != null) {
                this.haj.bCr.recycle();
                this.haj.bCr = null;
            }
            this.haj = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.haj != null && this.gZN.gZD) {
            this.haj.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bwj();
    }
}
