package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private d dIH;
    private a dIl;

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
        return this.dIl.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.dIl.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.dIl;
    }

    public void setDragController(a aVar) {
        this.dIl = aVar;
    }

    public void setDragObject(d dVar) {
        this.dIH = dVar;
        invalidate();
    }

    public d getDragObject() {
        return this.dIH;
    }

    public void aFR() {
        if (this.dIH != null) {
            if (this.dIH.aDl != null) {
                this.dIH.aDl.recycle();
                this.dIH.aDl = null;
            }
            this.dIH = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.dIH != null && this.dIl.dIc) {
            this.dIH.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aFR();
    }
}
