package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private b fvJ;
    private e fwg;

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
        return this.fvJ.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.fvJ.onTouchEvent(motionEvent);
    }

    public b getDragController() {
        return this.fvJ;
    }

    public void setDragController(b bVar) {
        this.fvJ = bVar;
    }

    public void setDragObject(e eVar) {
        this.fwg = eVar;
        invalidate();
    }

    public e getDragObject() {
        return this.fwg;
    }

    public void bhm() {
        if (this.fwg != null) {
            if (this.fwg.aKu != null) {
                this.fwg.aKu.recycle();
                this.fwg.aKu = null;
            }
            this.fwg = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.fwg != null && this.fvJ.fvA) {
            this.fwg.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bhm();
    }
}
