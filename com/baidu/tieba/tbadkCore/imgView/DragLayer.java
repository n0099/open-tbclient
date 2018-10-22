package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a heC;
    private b heX;

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
        return this.heC.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.heC.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.heC;
    }

    public void setDragController(a aVar) {
        this.heC = aVar;
    }

    public void setDragObject(b bVar) {
        this.heX = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.heX;
    }

    public void bCB() {
        if (this.heX != null) {
            if (this.heX.bfJ != null) {
                this.heX.bfJ.recycle();
                this.heX.bfJ = null;
            }
            this.heX = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.heX != null && this.heC.het) {
            this.heX.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bCB();
    }
}
