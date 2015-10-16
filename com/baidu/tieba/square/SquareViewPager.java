package com.baidu.tieba.square;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.widget.f;
import com.baidu.tbadk.widget.TbViewPager;
/* loaded from: classes.dex */
public class SquareViewPager extends TbViewPager {
    private boolean ado;
    private f.b adq;

    public SquareViewPager(Context context) {
        super(context);
        this.ado = true;
    }

    public SquareViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ado = true;
    }

    @Override // com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.ado) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            if (this.adq != null) {
                this.adq.ob();
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        switch (action) {
            case 0:
                if (this.adq != null) {
                    this.adq.oc();
                    break;
                }
                break;
            case 1:
            default:
                if (this.adq != null) {
                    this.adq.ob();
                    break;
                }
                break;
            case 2:
                if (this.adq != null) {
                    this.adq.oc();
                    break;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.ado) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (this.adq != null) {
                    this.adq.oc();
                    break;
                }
                break;
            case 1:
                if (this.adq != null) {
                    this.adq.ob();
                    break;
                }
                break;
            case 2:
                if (this.adq != null) {
                    this.adq.oc();
                    break;
                }
                break;
            default:
                if (this.adq != null) {
                    this.adq.ob();
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setSwipeControlInterface(f.b bVar) {
        this.adq = bVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.ado = z;
    }
}
