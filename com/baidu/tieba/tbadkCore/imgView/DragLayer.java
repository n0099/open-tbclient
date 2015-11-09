package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a dbS;
    private d dcq;

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
        return this.dbS.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.dbS.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.dbS;
    }

    public void setDragController(a aVar) {
        this.dbS = aVar;
    }

    public void setDragObject(d dVar) {
        this.dcq = dVar;
        invalidate();
    }

    public d getDragObject() {
        return this.dcq;
    }

    public void axT() {
        if (this.dcq != null) {
            if (this.dcq.azy != null) {
                this.dcq.azy.recycle();
                this.dcq.azy = null;
            }
            this.dcq = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.dcq != null && this.dbS.dbJ) {
            this.dcq.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        axT();
    }
}
