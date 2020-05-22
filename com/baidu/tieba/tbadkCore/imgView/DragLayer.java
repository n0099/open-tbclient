package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a lmI;
    private b lne;

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
        return this.lmI.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.lmI.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.lmI;
    }

    public void setDragController(a aVar) {
        this.lmI = aVar;
    }

    public void setDragObject(b bVar) {
        this.lne = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.lne;
    }

    public void ddY() {
        if (this.lne != null) {
            if (this.lne.bm != null) {
                this.lne.bm.recycle();
                this.lne.bm = null;
            }
            this.lne = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.lne != null && this.lmI.lmz) {
            this.lne.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ddY();
    }
}
