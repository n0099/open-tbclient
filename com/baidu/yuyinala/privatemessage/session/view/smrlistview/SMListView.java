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
    private Interpolator paS;
    private Interpolator paT;
    private int paV;
    private int paW;
    private int paX;
    private int paY;
    private boolean paZ;
    private SMLayout pba;
    private c pbb;
    private d pbc;
    private a pbd;
    private b pbe;

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
        this.paV = 5;
        this.paW = 3;
        this.paZ = true;
        init();
    }

    public SMListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDirection = 1;
        this.paV = 5;
        this.paW = 3;
        this.paZ = true;
        init();
    }

    public SMListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDirection = 1;
        this.paV = 5;
        this.paW = 3;
        this.paZ = true;
        init();
    }

    private void init() {
        this.paW = vn(this.paW);
        this.paV = vn(this.paV);
        this.paX = 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter((ListAdapter) new com.baidu.yuyinala.privatemessage.session.view.smrlistview.b(getContext(), listAdapter) { // from class: com.baidu.yuyinala.privatemessage.session.view.smrlistview.SMListView.1
            @Override // com.baidu.yuyinala.privatemessage.session.view.smrlistview.b
            public void b(com.baidu.yuyinala.privatemessage.session.view.smrlistview.c cVar) {
                if (SMListView.this.pbc != null) {
                    SMListView.this.pbc.a(cVar);
                }
            }

            @Override // com.baidu.yuyinala.privatemessage.session.view.smrlistview.b, com.baidu.yuyinala.privatemessage.session.view.smrlistview.SMView.a
            public void a(SMView sMView, com.baidu.yuyinala.privatemessage.session.view.smrlistview.c cVar, int i) {
                boolean z = false;
                if (SMListView.this.pbd != null) {
                    z = SMListView.this.pbd.a(sMView.getPosition(), cVar, i);
                }
                if (SMListView.this.pba != null && !z) {
                    SMListView.this.pba.ekH();
                }
            }
        });
    }

    public void setCloseInterpolator(Interpolator interpolator) {
        this.paS = interpolator;
    }

    public void setOpenInterpolator(Interpolator interpolator) {
        this.paT = interpolator;
    }

    public Interpolator getOpenInterpolator() {
        return this.paT;
    }

    public Interpolator getCloseInterpolator() {
        return this.paS;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 && this.pba == null) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                int i = this.paY;
                this.paZ = ekK();
                this.mDownX = motionEvent.getX();
                this.cBP = motionEvent.getY();
                this.paX = 0;
                this.paY = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                if (this.paY == i && this.pba != null && this.pba.isOpen()) {
                    this.paX = 1;
                    this.pba.at(motionEvent);
                    return true;
                }
                View childAt = getChildAt(this.paY - getFirstVisiblePosition());
                if (this.pba != null && this.pba.isOpen()) {
                    this.pba.ekH();
                    this.pba = null;
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.setAction(3);
                    onTouchEvent(obtain);
                    if (this.pbe != null) {
                        this.pbe.NS(i);
                    }
                    return true;
                }
                if (childAt instanceof SMLayout) {
                    this.pba = (SMLayout) childAt;
                    this.pba.setSwipeDirection(this.mDirection);
                }
                if (this.pba != null) {
                    this.pba.at(motionEvent);
                    break;
                }
                break;
            case 1:
                if (this.paX == 1) {
                    if (this.pba != null) {
                        boolean isOpen = this.pba.isOpen();
                        if (this.paZ) {
                            this.pba.at(motionEvent);
                        }
                        boolean isOpen2 = this.pba.isOpen();
                        if (isOpen != isOpen2 && this.pbe != null) {
                            if (isOpen2) {
                                this.pbe.NR(this.paY);
                            } else {
                                this.pbe.NS(this.paY);
                            }
                        }
                        if (!isOpen2) {
                            this.paY = -1;
                            this.pba = null;
                        }
                    }
                    if (this.pbb != null) {
                        this.pbb.NU(this.paY);
                    }
                    motionEvent.setAction(3);
                    super.onTouchEvent(motionEvent);
                    return true;
                }
                break;
            case 2:
                float abs = Math.abs(motionEvent.getY() - this.cBP);
                float abs2 = Math.abs(motionEvent.getX() - this.mDownX);
                if (this.paX == 1) {
                    if (this.pba != null && this.paZ) {
                        this.pba.at(motionEvent);
                    }
                    getSelector().setState(new int[]{0});
                    motionEvent.setAction(3);
                    super.onTouchEvent(motionEvent);
                    return true;
                } else if (this.paX == 0) {
                    if (Math.abs(abs) > this.paV) {
                        this.paX = 2;
                        break;
                    } else if (abs2 > this.paW) {
                        this.paX = 1;
                        if (this.pbb != null) {
                            this.pbb.NT(this.paY);
                            break;
                        }
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean ekK() {
        return this.paZ;
    }

    public void setSwipeEnable(boolean z) {
        this.paZ = z;
    }

    private int vn(int i) {
        return (int) TypedValue.applyDimension(1, i, getContext().getResources().getDisplayMetrics());
    }

    public void setMenuCreator(d dVar) {
        this.pbc = dVar;
    }

    public void setOnMenuItemClickListener(a aVar) {
        this.pbd = aVar;
    }

    public void setOnSwipeListener(c cVar) {
        this.pbb = cVar;
    }

    public void setOnMenuStateChangeListener(b bVar) {
        this.pbe = bVar;
    }

    public void setSwipeDirection(int i) {
        this.mDirection = i;
    }
}
