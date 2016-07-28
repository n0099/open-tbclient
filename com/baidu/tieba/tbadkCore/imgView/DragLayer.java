package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private d fmB;
    private a fmf;

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
        return this.fmf.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.fmf.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.fmf;
    }

    public void setDragController(a aVar) {
        this.fmf = aVar;
    }

    public void setDragObject(d dVar) {
        this.fmB = dVar;
        invalidate();
    }

    public d getDragObject() {
        return this.fmB;
    }

    public void bgg() {
        if (this.fmB != null) {
            if (this.fmB.aCR != null) {
                this.fmB.aCR.recycle();
                this.fmB.aCR = null;
            }
            this.fmB = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.fmB != null && this.fmf.flW) {
            this.fmB.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bgg();
    }
}
