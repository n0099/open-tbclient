package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a mgW;
    private b mhs;

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
        return this.mgW.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mgW.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.mgW;
    }

    public void setDragController(a aVar) {
        this.mgW = aVar;
    }

    public void setDragObject(b bVar) {
        this.mhs = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.mhs;
    }

    public void dxl() {
        if (this.mhs != null) {
            if (this.mhs.bm != null) {
                this.mhs.bm.recycle();
                this.mhs.bm = null;
            }
            this.mhs = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mhs != null && this.mgW.mgN) {
            this.mhs.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dxl();
    }
}
