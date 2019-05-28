package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private b jaR;
    private a jaw;

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
        return this.jaw.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.jaw.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.jaw;
    }

    public void setDragController(a aVar) {
        this.jaw = aVar;
    }

    public void setDragObject(b bVar) {
        this.jaR = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.jaR;
    }

    public void cmX() {
        if (this.jaR != null) {
            if (this.jaR.cDg != null) {
                this.jaR.cDg.recycle();
                this.jaR.cDg = null;
            }
            this.jaR = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.jaR != null && this.jaw.jan) {
            this.jaR.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cmX();
    }
}
