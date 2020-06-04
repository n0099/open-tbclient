package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a lnS;
    private b lor;

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
        return this.lnS.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.lnS.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.lnS;
    }

    public void setDragController(a aVar) {
        this.lnS = aVar;
    }

    public void setDragObject(b bVar) {
        this.lor = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.lor;
    }

    public void den() {
        if (this.lor != null) {
            if (this.lor.bm != null) {
                this.lor.bm.recycle();
                this.lor.bm = null;
            }
            this.lor = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.lor != null && this.lnS.lnJ) {
            this.lor.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        den();
    }
}
