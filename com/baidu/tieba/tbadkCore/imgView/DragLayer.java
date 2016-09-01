package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a ftZ;
    private d fuv;

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
        return this.ftZ.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.ftZ.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.ftZ;
    }

    public void setDragController(a aVar) {
        this.ftZ = aVar;
    }

    public void setDragObject(d dVar) {
        this.fuv = dVar;
        invalidate();
    }

    public d getDragObject() {
        return this.fuv;
    }

    public void bjH() {
        if (this.fuv != null) {
            if (this.fuv.aFY != null) {
                this.fuv.aFY.recycle();
                this.fuv.aFY = null;
            }
            this.fuv = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.fuv != null && this.ftZ.ftQ) {
            this.fuv.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bjH();
    }
}
