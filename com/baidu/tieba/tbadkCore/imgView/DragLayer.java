package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes2.dex */
public class DragLayer extends FrameLayout {
    private a mgH;
    private b mhd;

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
        return this.mgH.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mgH.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.mgH;
    }

    public void setDragController(a aVar) {
        this.mgH = aVar;
    }

    public void setDragObject(b bVar) {
        this.mhd = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.mhd;
    }

    public void dxg() {
        if (this.mhd != null) {
            if (this.mhd.bm != null) {
                this.mhd.bm.recycle();
                this.mhd.bm = null;
            }
            this.mhd = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mhd != null && this.mgH.mgy) {
            this.mhd.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dxg();
    }
}
