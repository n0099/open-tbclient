package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private c glF;
    private b gli;

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
        return this.gli.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.gli.onTouchEvent(motionEvent);
    }

    public b getDragController() {
        return this.gli;
    }

    public void setDragController(b bVar) {
        this.gli = bVar;
    }

    public void setDragObject(c cVar) {
        this.glF = cVar;
        invalidate();
    }

    public c getDragObject() {
        return this.glF;
    }

    public void btz() {
        if (this.glF != null) {
            if (this.glF.aNU != null) {
                this.glF.aNU.recycle();
                this.glF.aNU = null;
            }
            this.glF = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.glF != null && this.gli.gkZ) {
            this.glF.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        btz();
    }
}
