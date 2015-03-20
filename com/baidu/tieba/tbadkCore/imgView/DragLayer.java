package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a coL;
    private e cpi;

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
        return this.coL.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.coL.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.coL;
    }

    public void setDragController(a aVar) {
        this.coL = aVar;
    }

    public void setDragObject(e eVar) {
        this.cpi = eVar;
        invalidate();
    }

    public e getDragObject() {
        return this.cpi;
    }

    public void amT() {
        if (this.cpi != null) {
            if (this.cpi.art != null) {
                this.cpi.art.recycle();
                this.cpi.art = null;
            }
            this.cpi = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cpi != null && this.coL.coB) {
            this.cpi.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        amT();
    }
}
