package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private b kUJ;
    private a kUo;

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
        return this.kUo.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.kUo.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.kUo;
    }

    public void setDragController(a aVar) {
        this.kUo = aVar;
    }

    public void setDragObject(b bVar) {
        this.kUJ = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.kUJ;
    }

    public void cWR() {
        if (this.kUJ != null) {
            if (this.kUJ.bm != null) {
                this.kUJ.bm.recycle();
                this.kUJ.bm = null;
            }
            this.kUJ = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.kUJ != null && this.kUo.kUf) {
            this.kUJ.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cWR();
    }
}
