package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a fwF;
    private d fxb;

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
        return this.fwF.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.fwF.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.fwF;
    }

    public void setDragController(a aVar) {
        this.fwF = aVar;
    }

    public void setDragObject(d dVar) {
        this.fxb = dVar;
        invalidate();
    }

    public d getDragObject() {
        return this.fxb;
    }

    public void bkt() {
        if (this.fxb != null) {
            if (this.fxb.aFx != null) {
                this.fxb.aFx.recycle();
                this.fxb.aFx = null;
            }
            this.fxb = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.fxb != null && this.fwF.fww) {
            this.fxb.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bkt();
    }
}
