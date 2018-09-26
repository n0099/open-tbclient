package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private b gXD;
    private a gXh;

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
        return this.gXh.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.gXh.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.gXh;
    }

    public void setDragController(a aVar) {
        this.gXh = aVar;
    }

    public void setDragObject(b bVar) {
        this.gXD = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.gXD;
    }

    public void bzm() {
        if (this.gXD != null) {
            if (this.gXD.bbh != null) {
                this.gXD.bbh.recycle();
                this.gXD.bbh = null;
            }
            this.gXD = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.gXD != null && this.gXh.gWY) {
            this.gXD.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bzm();
    }
}
