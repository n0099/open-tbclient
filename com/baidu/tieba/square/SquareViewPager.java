package com.baidu.tieba.square;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.widget.f;
import com.baidu.tbadk.widget.TbViewPager;
/* loaded from: classes.dex */
public class SquareViewPager extends TbViewPager {
    private boolean aeY;
    private f.b afa;

    public SquareViewPager(Context context) {
        super(context);
        this.aeY = true;
    }

    public SquareViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeY = true;
    }

    @Override // com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.aeY) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            if (this.afa != null) {
                this.afa.nG();
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        switch (action) {
            case 0:
                if (this.afa != null) {
                    this.afa.nH();
                    break;
                }
                break;
            case 1:
            default:
                if (this.afa != null) {
                    this.afa.nG();
                    break;
                }
                break;
            case 2:
                if (this.afa != null) {
                    this.afa.nH();
                    break;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aeY) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (this.afa != null) {
                    this.afa.nH();
                    break;
                }
                break;
            case 1:
                if (this.afa != null) {
                    this.afa.nG();
                    break;
                }
                break;
            case 2:
                if (this.afa != null) {
                    this.afa.nH();
                    break;
                }
                break;
            default:
                if (this.afa != null) {
                    this.afa.nG();
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setSwipeControlInterface(f.b bVar) {
        this.afa = bVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.aeY = z;
    }
}
