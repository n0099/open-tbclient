package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a kiC;
    private b kiX;

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
        return this.kiC.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.kiC.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.kiC;
    }

    public void setDragController(a aVar) {
        this.kiC = aVar;
    }

    public void setDragObject(b bVar) {
        this.kiX = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.kiX;
    }

    public void cLD() {
        if (this.kiX != null) {
            if (this.kiX.bm != null) {
                this.kiX.bm.recycle();
                this.kiX.bm = null;
            }
            this.kiX = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.kiX != null && this.kiC.kit) {
            this.kiX.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cLD();
    }
}
