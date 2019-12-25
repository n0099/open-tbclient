package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a kdE;
    private b kdZ;

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
        return this.kdE.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.kdE.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.kdE;
    }

    public void setDragController(a aVar) {
        this.kdE = aVar;
    }

    public void setDragObject(b bVar) {
        this.kdZ = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.kdZ;
    }

    public void cIW() {
        if (this.kdZ != null) {
            if (this.kdZ.bm != null) {
                this.kdZ.bm.recycle();
                this.kdZ.bm = null;
            }
            this.kdZ = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.kdZ != null && this.kdE.kdv) {
            this.kdZ.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cIW();
    }
}
