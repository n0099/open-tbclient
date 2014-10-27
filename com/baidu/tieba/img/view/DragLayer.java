package com.baidu.tieba.img.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private e blA;
    private a blb;

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
        return this.blb.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.blb.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.blb;
    }

    public void setDragController(a aVar) {
        this.blb = aVar;
    }

    public void setDragObject(e eVar) {
        this.blA = eVar;
        invalidate();
    }

    public e getDragObject() {
        return this.blA;
    }

    public void Sk() {
        if (this.blA != null) {
            if (this.blA.bkN != null) {
                this.blA.bkN.recycle();
                this.blA.bkN = null;
            }
            this.blA = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.blA != null && this.blb.bkR) {
            this.blA.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Sk();
    }
}
