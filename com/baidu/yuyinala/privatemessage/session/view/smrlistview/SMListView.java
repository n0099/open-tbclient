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
    private float cFL;
    private int mDirection;
    private float mDownX;
    private Interpolator pnM;
    private Interpolator pnN;
    private int pnP;
    private int pnQ;
    private int pnR;
    private int pnS;
    private boolean pnT;
    private SMLayout pnU;
    private c pnV;
    private d pnW;
    private a pnX;
    private b pnY;

    /* loaded from: classes10.dex */
    public interface a {
        boolean a(int i, com.baidu.yuyinala.privatemessage.session.view.smrlistview.c cVar, int i2);
    }

    /* loaded from: classes10.dex */
    public interface b {
        void Or(int i);

        void Os(int i);
    }

    /* loaded from: classes10.dex */
    public interface c {
        void Ot(int i);

        void Ou(int i);
    }

    public SMListView(Context context) {
        super(context);
        this.mDirection = 1;
        this.pnP = 5;
        this.pnQ = 3;
        this.pnT = true;
        init();
    }

    public SMListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDirection = 1;
        this.pnP = 5;
        this.pnQ = 3;
        this.pnT = true;
        init();
    }

    public SMListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDirection = 1;
        this.pnP = 5;
        this.pnQ = 3;
        this.pnT = true;
        init();
    }

    private void init() {
        this.pnQ = vA(this.pnQ);
        this.pnP = vA(this.pnP);
        this.pnR = 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter((ListAdapter) new com.baidu.yuyinala.privatemessage.session.view.smrlistview.b(getContext(), listAdapter) { // from class: com.baidu.yuyinala.privatemessage.session.view.smrlistview.SMListView.1
            @Override // com.baidu.yuyinala.privatemessage.session.view.smrlistview.b
            public void b(com.baidu.yuyinala.privatemessage.session.view.smrlistview.c cVar) {
                if (SMListView.this.pnW != null) {
                    SMListView.this.pnW.a(cVar);
                }
            }

            @Override // com.baidu.yuyinala.privatemessage.session.view.smrlistview.b, com.baidu.yuyinala.privatemessage.session.view.smrlistview.SMView.a
            public void a(SMView sMView, com.baidu.yuyinala.privatemessage.session.view.smrlistview.c cVar, int i) {
                boolean z = false;
                if (SMListView.this.pnX != null) {
                    z = SMListView.this.pnX.a(sMView.getPosition(), cVar, i);
                }
                if (SMListView.this.pnU != null && !z) {
                    SMListView.this.pnU.ens();
                }
            }
        });
    }

    public void setCloseInterpolator(Interpolator interpolator) {
        this.pnM = interpolator;
    }

    public void setOpenInterpolator(Interpolator interpolator) {
        this.pnN = interpolator;
    }

    public Interpolator getOpenInterpolator() {
        return this.pnN;
    }

    public Interpolator getCloseInterpolator() {
        return this.pnM;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 && this.pnU == null) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                int i = this.pnS;
                this.pnT = env();
                this.mDownX = motionEvent.getX();
                this.cFL = motionEvent.getY();
                this.pnR = 0;
                this.pnS = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                if (this.pnS == i && this.pnU != null && this.pnU.isOpen()) {
                    this.pnR = 1;
                    this.pnU.at(motionEvent);
                    return true;
                }
                View childAt = getChildAt(this.pnS - getFirstVisiblePosition());
                if (this.pnU != null && this.pnU.isOpen()) {
                    this.pnU.ens();
                    this.pnU = null;
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.setAction(3);
                    onTouchEvent(obtain);
                    if (this.pnY != null) {
                        this.pnY.Os(i);
                    }
                    return true;
                }
                if (childAt instanceof SMLayout) {
                    this.pnU = (SMLayout) childAt;
                    this.pnU.setSwipeDirection(this.mDirection);
                }
                if (this.pnU != null) {
                    this.pnU.at(motionEvent);
                    break;
                }
                break;
            case 1:
                if (this.pnR == 1) {
                    if (this.pnU != null) {
                        boolean isOpen = this.pnU.isOpen();
                        if (this.pnT) {
                            this.pnU.at(motionEvent);
                        }
                        boolean isOpen2 = this.pnU.isOpen();
                        if (isOpen != isOpen2 && this.pnY != null) {
                            if (isOpen2) {
                                this.pnY.Or(this.pnS);
                            } else {
                                this.pnY.Os(this.pnS);
                            }
                        }
                        if (!isOpen2) {
                            this.pnS = -1;
                            this.pnU = null;
                        }
                    }
                    if (this.pnV != null) {
                        this.pnV.Ou(this.pnS);
                    }
                    motionEvent.setAction(3);
                    super.onTouchEvent(motionEvent);
                    return true;
                }
                break;
            case 2:
                float abs = Math.abs(motionEvent.getY() - this.cFL);
                float abs2 = Math.abs(motionEvent.getX() - this.mDownX);
                if (this.pnR == 1) {
                    if (this.pnU != null && this.pnT) {
                        this.pnU.at(motionEvent);
                    }
                    getSelector().setState(new int[]{0});
                    motionEvent.setAction(3);
                    super.onTouchEvent(motionEvent);
                    return true;
                } else if (this.pnR == 0) {
                    if (Math.abs(abs) > this.pnP) {
                        this.pnR = 2;
                        break;
                    } else if (abs2 > this.pnQ) {
                        this.pnR = 1;
                        if (this.pnV != null) {
                            this.pnV.Ot(this.pnS);
                            break;
                        }
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean env() {
        return this.pnT;
    }

    public void setSwipeEnable(boolean z) {
        this.pnT = z;
    }

    private int vA(int i) {
        return (int) TypedValue.applyDimension(1, i, getContext().getResources().getDisplayMetrics());
    }

    public void setMenuCreator(d dVar) {
        this.pnW = dVar;
    }

    public void setOnMenuItemClickListener(a aVar) {
        this.pnX = aVar;
    }

    public void setOnSwipeListener(c cVar) {
        this.pnV = cVar;
    }

    public void setOnMenuStateChangeListener(b bVar) {
        this.pnY = bVar;
    }

    public void setSwipeDirection(int i) {
        this.mDirection = i;
    }
}
