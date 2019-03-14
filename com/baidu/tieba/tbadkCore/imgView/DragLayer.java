package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a iHP;
    private b iIk;

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
        return this.iHP.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.iHP.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.iHP;
    }

    public void setDragController(a aVar) {
        this.iHP = aVar;
    }

    public void setDragObject(b bVar) {
        this.iIk = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.iIk;
    }

    public void ceU() {
        if (this.iIk != null) {
            if (this.iIk.cuU != null) {
                this.iIk.cuU.recycle();
                this.iIk.cuU = null;
            }
            this.iIk = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.iIk != null && this.iHP.iHG) {
            this.iIk.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ceU();
    }
}
