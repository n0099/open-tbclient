package com.baidu.tieba.square;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.widget.t;
/* loaded from: classes.dex */
public class SquareViewPager extends ViewPager {
    private boolean Yg;
    private t Yi;

    public SquareViewPager(Context context) {
        super(context);
        this.Yg = true;
    }

    public SquareViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Yg = true;
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Yg) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            if (this.Yi != null) {
                this.Yi.nD();
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        switch (action) {
            case 0:
                if (this.Yi != null) {
                    this.Yi.nE();
                    break;
                }
                break;
            case 1:
            default:
                if (this.Yi != null) {
                    this.Yi.nD();
                    break;
                }
                break;
            case 2:
                if (this.Yi != null) {
                    this.Yi.nE();
                    break;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Yg) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (this.Yi != null) {
                    this.Yi.nE();
                    break;
                }
                break;
            case 1:
                if (this.Yi != null) {
                    this.Yi.nD();
                    break;
                }
                break;
            case 2:
                if (this.Yi != null) {
                    this.Yi.nE();
                    break;
                }
                break;
            default:
                if (this.Yi != null) {
                    this.Yi.nD();
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setSwipeControlInterface(t tVar) {
        this.Yi = tVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.Yg = z;
    }
}
