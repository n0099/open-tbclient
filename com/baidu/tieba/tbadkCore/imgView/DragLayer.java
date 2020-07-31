package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a lOV;
    private b lPr;

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
        return this.lOV.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.lOV.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.lOV;
    }

    public void setDragController(a aVar) {
        this.lOV = aVar;
    }

    public void setDragObject(b bVar) {
        this.lPr = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.lPr;
    }

    public void dlI() {
        if (this.lPr != null) {
            if (this.lPr.bm != null) {
                this.lPr.bm.recycle();
                this.lPr.bm = null;
            }
            this.lPr = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.lPr != null && this.lOV.lOM) {
            this.lPr.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dlI();
    }
}
