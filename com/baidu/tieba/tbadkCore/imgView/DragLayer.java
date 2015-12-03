package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a dAG;
    private d dBe;

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
        return this.dAG.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.dAG.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.dAG;
    }

    public void setDragController(a aVar) {
        this.dAG = aVar;
    }

    public void setDragObject(d dVar) {
        this.dBe = dVar;
        invalidate();
    }

    public d getDragObject() {
        return this.dBe;
    }

    public void aDE() {
        if (this.dBe != null) {
            if (this.dBe.aBE != null) {
                this.dBe.aBE.recycle();
                this.dBe.aBE = null;
            }
            this.dBe = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.dBe != null && this.dAG.dAx) {
            this.dBe.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aDE();
    }
}
