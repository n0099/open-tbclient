package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private b ntM;
    private a nts;

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
        return this.nts.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.nts.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.nts;
    }

    public void setDragController(a aVar) {
        this.nts = aVar;
    }

    public void setDragObject(b bVar) {
        this.ntM = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.ntM;
    }

    public void dPE() {
        if (this.ntM != null) {
            if (this.ntM.bm != null) {
                this.ntM.bm.recycle();
                this.ntM.bm = null;
            }
            this.ntM = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.ntM != null && this.nts.ntj) {
            this.ntM.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dPE();
    }
}
