package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a lHH;
    private b lId;

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
        return this.lHH.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.lHH.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.lHH;
    }

    public void setDragController(a aVar) {
        this.lHH = aVar;
    }

    public void setDragObject(b bVar) {
        this.lId = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.lId;
    }

    public void diA() {
        if (this.lId != null) {
            if (this.lId.bm != null) {
                this.lId.bm.recycle();
                this.lId.bm = null;
            }
            this.lId = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.lId != null && this.lHH.lHy) {
            this.lId.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        diA();
    }
}
