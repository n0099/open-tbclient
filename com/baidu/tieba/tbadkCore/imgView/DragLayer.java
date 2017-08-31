package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private b gjK;
    private c gkh;

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
        return this.gjK.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.gjK.onTouchEvent(motionEvent);
    }

    public b getDragController() {
        return this.gjK;
    }

    public void setDragController(b bVar) {
        this.gjK = bVar;
    }

    public void setDragObject(c cVar) {
        this.gkh = cVar;
        invalidate();
    }

    public c getDragObject() {
        return this.gkh;
    }

    public void bsO() {
        if (this.gkh != null) {
            if (this.gkh.aND != null) {
                this.gkh.aND.recycle();
                this.gkh.aND = null;
            }
            this.gkh = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.gkh != null && this.gjK.gjA) {
            this.gkh.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bsO();
    }
}
