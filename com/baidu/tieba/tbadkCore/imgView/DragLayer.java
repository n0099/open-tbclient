package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a gOD;
    private b gOZ;

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
        return this.gOD.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.gOD.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.gOD;
    }

    public void setDragController(a aVar) {
        this.gOD = aVar;
    }

    public void setDragObject(b bVar) {
        this.gOZ = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.gOZ;
    }

    public void bye() {
        if (this.gOZ != null) {
            if (this.gOZ.aXI != null) {
                this.gOZ.aXI.recycle();
                this.gOZ.aXI = null;
            }
            this.gOZ = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.gOZ != null && this.gOD.gOu) {
            this.gOZ.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bye();
    }
}
