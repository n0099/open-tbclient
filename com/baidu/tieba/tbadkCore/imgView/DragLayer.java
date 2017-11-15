package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private b grN;
    private c gsk;

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
        return this.grN.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.grN.onTouchEvent(motionEvent);
    }

    public b getDragController() {
        return this.grN;
    }

    public void setDragController(b bVar) {
        this.grN = bVar;
    }

    public void setDragObject(c cVar) {
        this.gsk = cVar;
        invalidate();
    }

    public c getDragObject() {
        return this.gsk;
    }

    public void bvg() {
        if (this.gsk != null) {
            if (this.gsk.aNO != null) {
                this.gsk.aNO.recycle();
                this.gsk.aNO = null;
            }
            this.gsk = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.gsk != null && this.grN.grE) {
            this.gsk.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bvg();
    }
}
