package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private b ghY;
    private c giw;

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
        return this.ghY.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.ghY.onTouchEvent(motionEvent);
    }

    public b getDragController() {
        return this.ghY;
    }

    public void setDragController(b bVar) {
        this.ghY = bVar;
    }

    public void setDragObject(c cVar) {
        this.giw = cVar;
        invalidate();
    }

    public c getDragObject() {
        return this.giw;
    }

    public void brQ() {
        if (this.giw != null) {
            if (this.giw.aNc != null) {
                this.giw.aNc.recycle();
                this.giw.aNc = null;
            }
            this.giw = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.giw != null && this.ghY.ghP) {
            this.giw.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        brQ();
    }
}
