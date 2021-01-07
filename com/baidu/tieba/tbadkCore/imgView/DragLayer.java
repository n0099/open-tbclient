package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private b ntL;
    private a ntr;

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
        return this.ntr.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.ntr.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.ntr;
    }

    public void setDragController(a aVar) {
        this.ntr = aVar;
    }

    public void setDragObject(b bVar) {
        this.ntL = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.ntL;
    }

    public void dPF() {
        if (this.ntL != null) {
            if (this.ntL.bm != null) {
                this.ntL.bm.recycle();
                this.ntL.bm = null;
            }
            this.ntL = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.ntL != null && this.ntr.nti) {
            this.ntL.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dPF();
    }
}
