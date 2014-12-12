package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a bXP;
    private e bYn;

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
        return this.bXP.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.bXP.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.bXP;
    }

    public void setDragController(a aVar) {
        this.bXP = aVar;
    }

    public void setDragObject(e eVar) {
        this.bYn = eVar;
        invalidate();
    }

    public e getDragObject() {
        return this.bYn;
    }

    public void aht() {
        if (this.bYn != null) {
            if (this.bYn.air != null) {
                this.bYn.air.recycle();
                this.bYn.air = null;
            }
            this.bYn = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bYn != null && this.bXP.bXF) {
            this.bYn.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aht();
    }
}
