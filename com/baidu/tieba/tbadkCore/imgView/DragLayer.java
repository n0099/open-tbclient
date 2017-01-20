package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private e frA;
    private b frd;

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
        return this.frd.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.frd.onTouchEvent(motionEvent);
    }

    public b getDragController() {
        return this.frd;
    }

    public void setDragController(b bVar) {
        this.frd = bVar;
    }

    public void setDragObject(e eVar) {
        this.frA = eVar;
        invalidate();
    }

    public e getDragObject() {
        return this.frA;
    }

    public void bin() {
        if (this.frA != null) {
            if (this.frA.aEw != null) {
                this.frA.aEw.recycle();
                this.frA.aEw = null;
            }
            this.frA = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.frA != null && this.frd.fqU) {
            this.frA.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bin();
    }
}
