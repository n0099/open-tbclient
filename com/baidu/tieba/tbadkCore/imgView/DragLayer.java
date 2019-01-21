package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private b hrJ;
    private a hro;

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
        return this.hro.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.hro.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.hro;
    }

    public void setDragController(a aVar) {
        this.hro = aVar;
    }

    public void setDragObject(b bVar) {
        this.hrJ = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.hrJ;
    }

    public void bFs() {
        if (this.hrJ != null) {
            if (this.hrJ.bkN != null) {
                this.hrJ.bkN.recycle();
                this.hrJ.bkN = null;
            }
            this.hrJ = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.hrJ != null && this.hro.hrf) {
            this.hrJ.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bFs();
    }
}
