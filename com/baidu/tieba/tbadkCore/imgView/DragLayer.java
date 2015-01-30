package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a bZI;
    private e cag;

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
        return this.bZI.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.bZI.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.bZI;
    }

    public void setDragController(a aVar) {
        this.bZI = aVar;
    }

    public void setDragObject(e eVar) {
        this.cag = eVar;
        invalidate();
    }

    public e getDragObject() {
        return this.cag;
    }

    public void ahX() {
        if (this.cag != null) {
            if (this.cag.aiU != null) {
                this.cag.aiU.recycle();
                this.cag.aiU = null;
            }
            this.cag = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cag != null && this.bZI.bZy) {
            this.cag.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ahX();
    }
}
