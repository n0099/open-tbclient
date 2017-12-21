package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private c gDU;
    private b gDx;

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
        return this.gDx.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.gDx.onTouchEvent(motionEvent);
    }

    public b getDragController() {
        return this.gDx;
    }

    public void setDragController(b bVar) {
        this.gDx = bVar;
    }

    public void setDragObject(c cVar) {
        this.gDU = cVar;
        invalidate();
    }

    public c getDragObject() {
        return this.gDU;
    }

    public void bxx() {
        if (this.gDU != null) {
            if (this.gDU.aOv != null) {
                this.gDU.aOv.recycle();
                this.gDU.aOv = null;
            }
            this.gDU = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.gDU != null && this.gDx.gDo) {
            this.gDU.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bxx();
    }
}
