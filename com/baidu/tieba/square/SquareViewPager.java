package com.baidu.tieba.square;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.widget.f;
import com.baidu.tbadk.widget.TbViewPager;
/* loaded from: classes.dex */
public class SquareViewPager extends TbViewPager {
    private boolean afK;
    private f.b afM;
    private float x;
    private float y;

    public SquareViewPager(Context context) {
        super(context);
        this.afK = true;
    }

    public SquareViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afK = true;
    }

    @Override // com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.afK) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            if (this.afM != null) {
                this.afM.oa();
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        switch (action) {
            case 0:
                this.x = getX();
                this.y = getY();
                if (this.afM != null) {
                    this.afM.ob();
                    break;
                }
                break;
            case 1:
            default:
                if (this.afM != null) {
                    this.afM.oa();
                    break;
                }
                break;
            case 2:
                if (Math.abs(this.x - getX()) > Math.abs(this.y - getY())) {
                    aA(true);
                } else {
                    aA(false);
                }
                if (this.afM != null) {
                    this.afM.ob();
                    break;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.afK) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (this.afM != null) {
                    this.afM.ob();
                    break;
                }
                break;
            case 1:
                if (this.afM != null) {
                    this.afM.oa();
                    break;
                }
                break;
            case 2:
                if (this.afM != null) {
                    this.afM.ob();
                    break;
                }
                break;
            default:
                if (this.afM != null) {
                    this.afM.oa();
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setSwipeControlInterface(f.b bVar) {
        this.afM = bVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.afK = z;
    }

    private void aA(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
