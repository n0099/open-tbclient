package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.PointF;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class GalleryViewPager extends ViewPager {
    private PointF last;
    private DragImageView mCurrentView;
    private DragImageView mSelectedView;

    public GalleryViewPager(Context context) {
        super(context);
    }

    public GalleryViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setCurrentView(DragImageView view) {
        this.mCurrentView = view;
    }

    public DragImageView getCurrentView() {
        return this.mCurrentView;
    }

    private float[] handleMotionEvent(MotionEvent event) {
        switch (event.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF curr = new PointF(event.getX(), event.getY());
                return new float[]{curr.x - this.last.x, curr.y - this.last.y};
            case 0:
                this.last = new PointF(event.getX(), event.getY());
                break;
        }
        return null;
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if ((event.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(event);
            if (this.mCurrentView != null) {
                this.mCurrentView.actionUp();
            }
        }
        if (this.mCurrentView == null) {
            return onTouchEvent(event);
        }
        float[] difference = handleMotionEvent(event);
        if (this.mCurrentView.pagerCantScroll()) {
            return super.onTouchEvent(event);
        }
        if (difference != null && this.mCurrentView.onRightSide() && difference[0] < 0.0f) {
            return super.onTouchEvent(event);
        }
        if (difference != null && this.mCurrentView.onLeftSide() && difference[0] > 0.0f) {
            return super.onTouchEvent(event);
        }
        if (difference == null) {
            if (this.mCurrentView.onLeftSide() || this.mCurrentView.onRightSide()) {
                return super.onTouchEvent(event);
            }
            return false;
        }
        return false;
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if ((event.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onInterceptTouchEvent(event);
        }
        float[] difference = handleMotionEvent(event);
        if (this.mCurrentView == null) {
            return super.onInterceptTouchEvent(event);
        }
        if (this.mCurrentView.pagerCantScroll()) {
            return super.onInterceptTouchEvent(event);
        }
        if (difference != null && this.mCurrentView.onRightSide() && difference[0] < 0.0f) {
            return super.onInterceptTouchEvent(event);
        }
        if (difference != null && this.mCurrentView.onLeftSide() && difference[0] > 0.0f) {
            return super.onInterceptTouchEvent(event);
        }
        if (difference == null) {
            if (this.mCurrentView.onLeftSide() || this.mCurrentView.onRightSide()) {
                return super.onInterceptTouchEvent(event);
            }
            return false;
        }
        return false;
    }

    public void setSelectedView(DragImageView mSelectedView) {
        this.mSelectedView = mSelectedView;
    }

    public DragImageView getSelectedView() {
        return this.mSelectedView;
    }
}
