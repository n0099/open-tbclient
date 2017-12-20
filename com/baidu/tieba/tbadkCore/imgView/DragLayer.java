package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private c gDP;
    private b gDs;

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
        return this.gDs.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.gDs.onTouchEvent(motionEvent);
    }

    public b getDragController() {
        return this.gDs;
    }

    public void setDragController(b bVar) {
        this.gDs = bVar;
    }

    public void setDragObject(c cVar) {
        this.gDP = cVar;
        invalidate();
    }

    public c getDragObject() {
        return this.gDP;
    }

    public void bxw() {
        if (this.gDP != null) {
            if (this.gDP.aOs != null) {
                this.gDP.aOs.recycle();
                this.gDP.aOs = null;
            }
            this.gDP = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.gDP != null && this.gDs.gDj) {
            this.gDP.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bxw();
    }
}
