package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a nnD;
    private b nnZ;

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
        return this.nnD.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.nnD.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.nnD;
    }

    public void setDragController(a aVar) {
        this.nnD = aVar;
    }

    public void setDragObject(b bVar) {
        this.nnZ = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.nnZ;
    }

    public void dPH() {
        if (this.nnZ != null) {
            if (this.nnZ.bm != null) {
                this.nnZ.bm.recycle();
                this.nnZ.bm = null;
            }
            this.nnZ = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.nnZ != null && this.nnD.nnu) {
            this.nnZ.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dPH();
    }
}
