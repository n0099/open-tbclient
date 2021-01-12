package com.baidu.yuyinala.privatemessage.session.view.smrlistview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.ListAdapter;
import android.widget.ListView;
/* loaded from: classes10.dex */
public class SMListView extends ListView {
    private float cBP;
    private int mDirection;
    private float mDownX;
    private Interpolator paR;
    private Interpolator paS;
    private int paU;
    private int paV;
    private int paW;
    private int paX;
    private boolean paY;
    private SMLayout paZ;
    private c pba;
    private d pbb;
    private a pbc;
    private b pbd;

    /* loaded from: classes10.dex */
    public interface a {
        boolean a(int i, com.baidu.yuyinala.privatemessage.session.view.smrlistview.c cVar, int i2);
    }

    /* loaded from: classes10.dex */
    public interface b {
        void NR(int i);

        void NS(int i);
    }

    /* loaded from: classes10.dex */
    public interface c {
        void NT(int i);

        void NU(int i);
    }

    public SMListView(Context context) {
        super(context);
        this.mDirection = 1;
        this.paU = 5;
        this.paV = 3;
        this.paY = true;
        init();
    }

    public SMListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDirection = 1;
        this.paU = 5;
        this.paV = 3;
        this.paY = true;
        init();
    }

    public SMListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDirection = 1;
        this.paU = 5;
        this.paV = 3;
        this.paY = true;
        init();
    }

    private void init() {
        this.paV = vn(this.paV);
        this.paU = vn(this.paU);
        this.paW = 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter((ListAdapter) new com.baidu.yuyinala.privatemessage.session.view.smrlistview.b(getContext(), listAdapter) { // from class: com.baidu.yuyinala.privatemessage.session.view.smrlistview.SMListView.1
            @Override // com.baidu.yuyinala.privatemessage.session.view.smrlistview.b
            public void b(com.baidu.yuyinala.privatemessage.session.view.smrlistview.c cVar) {
                if (SMListView.this.pbb != null) {
                    SMListView.this.pbb.a(cVar);
                }
            }

            @Override // com.baidu.yuyinala.privatemessage.session.view.smrlistview.b, com.baidu.yuyinala.privatemessage.session.view.smrlistview.SMView.a
            public void a(SMView sMView, com.baidu.yuyinala.privatemessage.session.view.smrlistview.c cVar, int i) {
                boolean z = false;
                if (SMListView.this.pbc != null) {
                    z = SMListView.this.pbc.a(sMView.getPosition(), cVar, i);
                }
                if (SMListView.this.paZ != null && !z) {
                    SMListView.this.paZ.ekH();
                }
            }
        });
    }

    public void setCloseInterpolator(Interpolator interpolator) {
        this.paR = interpolator;
    }

    public void setOpenInterpolator(Interpolator interpolator) {
        this.paS = interpolator;
    }

    public Interpolator getOpenInterpolator() {
        return this.paS;
    }

    public Interpolator getCloseInterpolator() {
        return this.paR;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 && this.paZ == null) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                int i = this.paX;
                this.paY = ekK();
                this.mDownX = motionEvent.getX();
                this.cBP = motionEvent.getY();
                this.paW = 0;
                this.paX = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                if (this.paX == i && this.paZ != null && this.paZ.isOpen()) {
                    this.paW = 1;
                    this.paZ.at(motionEvent);
                    return true;
                }
                View childAt = getChildAt(this.paX - getFirstVisiblePosition());
                if (this.paZ != null && this.paZ.isOpen()) {
                    this.paZ.ekH();
                    this.paZ = null;
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.setAction(3);
                    onTouchEvent(obtain);
                    if (this.pbd != null) {
                        this.pbd.NS(i);
                    }
                    return true;
                }
                if (childAt instanceof SMLayout) {
                    this.paZ = (SMLayout) childAt;
                    this.paZ.setSwipeDirection(this.mDirection);
                }
                if (this.paZ != null) {
                    this.paZ.at(motionEvent);
                    break;
                }
                break;
            case 1:
                if (this.paW == 1) {
                    if (this.paZ != null) {
                        boolean isOpen = this.paZ.isOpen();
                        if (this.paY) {
                            this.paZ.at(motionEvent);
                        }
                        boolean isOpen2 = this.paZ.isOpen();
                        if (isOpen != isOpen2 && this.pbd != null) {
                            if (isOpen2) {
                                this.pbd.NR(this.paX);
                            } else {
                                this.pbd.NS(this.paX);
                            }
                        }
                        if (!isOpen2) {
                            this.paX = -1;
                            this.paZ = null;
                        }
                    }
                    if (this.pba != null) {
                        this.pba.NU(this.paX);
                    }
                    motionEvent.setAction(3);
                    super.onTouchEvent(motionEvent);
                    return true;
                }
                break;
            case 2:
                float abs = Math.abs(motionEvent.getY() - this.cBP);
                float abs2 = Math.abs(motionEvent.getX() - this.mDownX);
                if (this.paW == 1) {
                    if (this.paZ != null && this.paY) {
                        this.paZ.at(motionEvent);
                    }
                    getSelector().setState(new int[]{0});
                    motionEvent.setAction(3);
                    super.onTouchEvent(motionEvent);
                    return true;
                } else if (this.paW == 0) {
                    if (Math.abs(abs) > this.paU) {
                        this.paW = 2;
                        break;
                    } else if (abs2 > this.paV) {
                        this.paW = 1;
                        if (this.pba != null) {
                            this.pba.NT(this.paX);
                            break;
                        }
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean ekK() {
        return this.paY;
    }

    public void setSwipeEnable(boolean z) {
        this.paY = z;
    }

    private int vn(int i) {
        return (int) TypedValue.applyDimension(1, i, getContext().getResources().getDisplayMetrics());
    }

    public void setMenuCreator(d dVar) {
        this.pbb = dVar;
    }

    public void setOnMenuItemClickListener(a aVar) {
        this.pbc = aVar;
    }

    public void setOnSwipeListener(c cVar) {
        this.pba = cVar;
    }

    public void setOnMenuStateChangeListener(b bVar) {
        this.pbd = bVar;
    }

    public void setSwipeDirection(int i) {
        this.mDirection = i;
    }
}
