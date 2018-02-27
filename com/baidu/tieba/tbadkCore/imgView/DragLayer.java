package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private c hcC;
    private b hcg;

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
        return this.hcg.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.hcg.onTouchEvent(motionEvent);
    }

    public b getDragController() {
        return this.hcg;
    }

    public void setDragController(b bVar) {
        this.hcg = bVar;
    }

    public void setDragObject(c cVar) {
        this.hcC = cVar;
        invalidate();
    }

    public c getDragObject() {
        return this.hcC;
    }

    public void bxt() {
        if (this.hcC != null) {
            if (this.hcC.bEq != null) {
                this.hcC.bEq.recycle();
                this.hcC.bEq = null;
            }
            this.hcC = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.hcC != null && this.hcg.hbW) {
            this.hcC.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bxt();
    }
}
