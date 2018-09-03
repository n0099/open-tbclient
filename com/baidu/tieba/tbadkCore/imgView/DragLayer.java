package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a gPC;
    private b gPY;

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
        return this.gPC.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.gPC.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.gPC;
    }

    public void setDragController(a aVar) {
        this.gPC = aVar;
    }

    public void setDragObject(b bVar) {
        this.gPY = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.gPY;
    }

    public void bwI() {
        if (this.gPY != null) {
            if (this.gPY.aXO != null) {
                this.gPY.aXO.recycle();
                this.gPY.aXO = null;
            }
            this.gPY = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.gPY != null && this.gPC.gPt) {
            this.gPY.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bwI();
    }
}
