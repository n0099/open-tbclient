package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private b jjN;
    private a jjs;

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
        return this.jjs.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.jjs.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.jjs;
    }

    public void setDragController(a aVar) {
        this.jjs = aVar;
    }

    public void setDragObject(b bVar) {
        this.jjN = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.jjN;
    }

    public void coQ() {
        if (this.jjN != null) {
            if (this.jjN.bm != null) {
                this.jjN.bm.recycle();
                this.jjN.bm = null;
            }
            this.jjN = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.jjN != null && this.jjs.jjj) {
            this.jjN.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        coQ();
    }
}
