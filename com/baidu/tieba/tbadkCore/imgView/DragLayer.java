package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a hfZ;
    private b hgu;

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
        return this.hfZ.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.hfZ.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.hfZ;
    }

    public void setDragController(a aVar) {
        this.hfZ = aVar;
    }

    public void setDragObject(b bVar) {
        this.hgu = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.hgu;
    }

    public void bBX() {
        if (this.hgu != null) {
            if (this.hgu.bgw != null) {
                this.hgu.bgw.recycle();
                this.hgu.bgw = null;
            }
            this.hgu = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.hgu != null && this.hfZ.hfQ) {
            this.hgu.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bBX();
    }
}
