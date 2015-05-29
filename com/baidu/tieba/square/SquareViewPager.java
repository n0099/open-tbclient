package com.baidu.tieba.square;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.widget.t;
import com.baidu.tbadk.widget.TbViewPager;
/* loaded from: classes.dex */
public class SquareViewPager extends TbViewPager {
    private boolean YT;
    private t YV;

    public SquareViewPager(Context context) {
        super(context);
        this.YT = true;
    }

    public SquareViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.YT = true;
    }

    @Override // com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.YT) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            if (this.YV != null) {
                this.YV.nU();
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        switch (action) {
            case 0:
                if (this.YV != null) {
                    this.YV.nV();
                    break;
                }
                break;
            case 1:
            default:
                if (this.YV != null) {
                    this.YV.nU();
                    break;
                }
                break;
            case 2:
                if (this.YV != null) {
                    this.YV.nV();
                    break;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.YT) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (this.YV != null) {
                    this.YV.nV();
                    break;
                }
                break;
            case 1:
                if (this.YV != null) {
                    this.YV.nU();
                    break;
                }
                break;
            case 2:
                if (this.YV != null) {
                    this.YV.nV();
                    break;
                }
                break;
            default:
                if (this.YV != null) {
                    this.YV.nU();
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setSwipeControlInterface(t tVar) {
        this.YV = tVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.YT = z;
    }
}
