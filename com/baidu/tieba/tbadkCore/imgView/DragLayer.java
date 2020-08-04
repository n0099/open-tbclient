package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a lOX;
    private b lPt;

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
        return this.lOX.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.lOX.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.lOX;
    }

    public void setDragController(a aVar) {
        this.lOX = aVar;
    }

    public void setDragObject(b bVar) {
        this.lPt = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.lPt;
    }

    public void dlJ() {
        if (this.lPt != null) {
            if (this.lPt.bm != null) {
                this.lPt.bm.recycle();
                this.lPt.bm = null;
            }
            this.lPt = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.lPt != null && this.lOX.lOO) {
            this.lPt.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dlJ();
    }
}
