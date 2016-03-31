package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a erc;
    private d ery;

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
        return this.erc.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.erc.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.erc;
    }

    public void setDragController(a aVar) {
        this.erc = aVar;
    }

    public void setDragObject(d dVar) {
        this.ery = dVar;
        invalidate();
    }

    public d getDragObject() {
        return this.ery;
    }

    public void aTX() {
        if (this.ery != null) {
            if (this.ery.aFr != null) {
                this.ery.aFr.recycle();
                this.ery.aFr = null;
            }
            this.ery = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.ery != null && this.erc.eqT) {
            this.ery.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aTX();
    }
}
