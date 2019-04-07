package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a iHA;
    private b iHV;

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
        return this.iHA.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.iHA.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.iHA;
    }

    public void setDragController(a aVar) {
        this.iHA = aVar;
    }

    public void setDragObject(b bVar) {
        this.iHV = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.iHV;
    }

    public void ceQ() {
        if (this.iHV != null) {
            if (this.iHV.cuW != null) {
                this.iHV.cuW.recycle();
                this.iHV.cuW = null;
            }
            this.iHV = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.iHV != null && this.iHA.iHr) {
            this.iHV.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ceQ();
    }
}
