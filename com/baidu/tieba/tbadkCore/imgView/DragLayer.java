package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private b hqA;
    private a hqf;

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
        return this.hqf.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.hqf.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.hqf;
    }

    public void setDragController(a aVar) {
        this.hqf = aVar;
    }

    public void setDragObject(b bVar) {
        this.hqA = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.hqA;
    }

    public void bEJ() {
        if (this.hqA != null) {
            if (this.hqA.bjY != null) {
                this.hqA.bjY.recycle();
                this.hqA.bjY = null;
            }
            this.hqA = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.hqA != null && this.hqf.hpW) {
            this.hqA.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bEJ();
    }
}
