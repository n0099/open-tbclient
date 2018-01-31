package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private c haD;
    private b hah;

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
        return this.hah.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.hah.onTouchEvent(motionEvent);
    }

    public b getDragController() {
        return this.hah;
    }

    public void setDragController(b bVar) {
        this.hah = bVar;
    }

    public void setDragObject(c cVar) {
        this.haD = cVar;
        invalidate();
    }

    public c getDragObject() {
        return this.haD;
    }

    public void bwl() {
        if (this.haD != null) {
            if (this.haD.bCz != null) {
                this.haD.bCz.recycle();
                this.haD.bCz = null;
            }
            this.haD = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.haD != null && this.hah.gZX) {
            this.haD.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bwl();
    }
}
