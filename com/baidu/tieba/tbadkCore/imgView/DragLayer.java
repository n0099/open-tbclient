package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private b khC;
    private a khh;

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
        return this.khh.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.khh.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.khh;
    }

    public void setDragController(a aVar) {
        this.khh = aVar;
    }

    public void setDragObject(b bVar) {
        this.khC = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.khC;
    }

    public void cKa() {
        if (this.khC != null) {
            if (this.khC.bm != null) {
                this.khC.bm.recycle();
                this.khC.bm = null;
            }
            this.khC = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.khC != null && this.khh.kgY) {
            this.khC.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cKa();
    }
}
