package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private b jkE;
    private a jkj;

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
        return this.jkj.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.jkj.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.jkj;
    }

    public void setDragController(a aVar) {
        this.jkj = aVar;
    }

    public void setDragObject(b bVar) {
        this.jkE = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.jkE;
    }

    public void coS() {
        if (this.jkE != null) {
            if (this.jkE.bm != null) {
                this.jkE.bm.recycle();
                this.jkE.bm = null;
            }
            this.jkE = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.jkE != null && this.jkj.jka) {
            this.jkE.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        coS();
    }
}
