package com.baidu.yuyinala.privatemessage.session.view.smrlistview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.ListAdapter;
import android.widget.ListView;
/* loaded from: classes11.dex */
public class SMListView extends ListView {
    private float cEl;
    private int mDirection;
    private float mDownX;
    private Interpolator plH;
    private Interpolator plI;
    private int plK;
    private int plL;
    private int plM;
    private int plN;
    private boolean plO;
    private SMLayout plP;
    private c plQ;
    private d plR;
    private a plS;
    private b plT;

    /* loaded from: classes11.dex */
    public interface a {
        boolean a(int i, com.baidu.yuyinala.privatemessage.session.view.smrlistview.c cVar, int i2);
    }

    /* loaded from: classes11.dex */
    public interface b {
        void On(int i);

        void Oo(int i);
    }

    /* loaded from: classes11.dex */
    public interface c {
        void Op(int i);

        void Oq(int i);
    }

    public SMListView(Context context) {
        super(context);
        this.mDirection = 1;
        this.plK = 5;
        this.plL = 3;
        this.plO = true;
        init();
    }

    public SMListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDirection = 1;
        this.plK = 5;
        this.plL = 3;
        this.plO = true;
        init();
    }

    public SMListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDirection = 1;
        this.plK = 5;
        this.plL = 3;
        this.plO = true;
        init();
    }

    private void init() {
        this.plL = vy(this.plL);
        this.plK = vy(this.plK);
        this.plM = 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter((ListAdapter) new com.baidu.yuyinala.privatemessage.session.view.smrlistview.b(getContext(), listAdapter) { // from class: com.baidu.yuyinala.privatemessage.session.view.smrlistview.SMListView.1
            @Override // com.baidu.yuyinala.privatemessage.session.view.smrlistview.b
            public void b(com.baidu.yuyinala.privatemessage.session.view.smrlistview.c cVar) {
                if (SMListView.this.plR != null) {
                    SMListView.this.plR.a(cVar);
                }
            }

            @Override // com.baidu.yuyinala.privatemessage.session.view.smrlistview.b, com.baidu.yuyinala.privatemessage.session.view.smrlistview.SMView.a
            public void a(SMView sMView, com.baidu.yuyinala.privatemessage.session.view.smrlistview.c cVar, int i) {
                boolean z = false;
                if (SMListView.this.plS != null) {
                    z = SMListView.this.plS.a(sMView.getPosition(), cVar, i);
                }
                if (SMListView.this.plP != null && !z) {
                    SMListView.this.plP.eni();
                }
            }
        });
    }

    public void setCloseInterpolator(Interpolator interpolator) {
        this.plH = interpolator;
    }

    public void setOpenInterpolator(Interpolator interpolator) {
        this.plI = interpolator;
    }

    public Interpolator getOpenInterpolator() {
        return this.plI;
    }

    public Interpolator getCloseInterpolator() {
        return this.plH;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 && this.plP == null) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                int i = this.plN;
                this.plO = enl();
                this.mDownX = motionEvent.getX();
                this.cEl = motionEvent.getY();
                this.plM = 0;
                this.plN = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                if (this.plN == i && this.plP != null && this.plP.isOpen()) {
                    this.plM = 1;
                    this.plP.at(motionEvent);
                    return true;
                }
                View childAt = getChildAt(this.plN - getFirstVisiblePosition());
                if (this.plP != null && this.plP.isOpen()) {
                    this.plP.eni();
                    this.plP = null;
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.setAction(3);
                    onTouchEvent(obtain);
                    if (this.plT != null) {
                        this.plT.Oo(i);
                    }
                    return true;
                }
                if (childAt instanceof SMLayout) {
                    this.plP = (SMLayout) childAt;
                    this.plP.setSwipeDirection(this.mDirection);
                }
                if (this.plP != null) {
                    this.plP.at(motionEvent);
                    break;
                }
                break;
            case 1:
                if (this.plM == 1) {
                    if (this.plP != null) {
                        boolean isOpen = this.plP.isOpen();
                        if (this.plO) {
                            this.plP.at(motionEvent);
                        }
                        boolean isOpen2 = this.plP.isOpen();
                        if (isOpen != isOpen2 && this.plT != null) {
                            if (isOpen2) {
                                this.plT.On(this.plN);
                            } else {
                                this.plT.Oo(this.plN);
                            }
                        }
                        if (!isOpen2) {
                            this.plN = -1;
                            this.plP = null;
                        }
                    }
                    if (this.plQ != null) {
                        this.plQ.Oq(this.plN);
                    }
                    motionEvent.setAction(3);
                    super.onTouchEvent(motionEvent);
                    return true;
                }
                break;
            case 2:
                float abs = Math.abs(motionEvent.getY() - this.cEl);
                float abs2 = Math.abs(motionEvent.getX() - this.mDownX);
                if (this.plM == 1) {
                    if (this.plP != null && this.plO) {
                        this.plP.at(motionEvent);
                    }
                    getSelector().setState(new int[]{0});
                    motionEvent.setAction(3);
                    super.onTouchEvent(motionEvent);
                    return true;
                } else if (this.plM == 0) {
                    if (Math.abs(abs) > this.plK) {
                        this.plM = 2;
                        break;
                    } else if (abs2 > this.plL) {
                        this.plM = 1;
                        if (this.plQ != null) {
                            this.plQ.Op(this.plN);
                            break;
                        }
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean enl() {
        return this.plO;
    }

    public void setSwipeEnable(boolean z) {
        this.plO = z;
    }

    private int vy(int i) {
        return (int) TypedValue.applyDimension(1, i, getContext().getResources().getDisplayMetrics());
    }

    public void setMenuCreator(d dVar) {
        this.plR = dVar;
    }

    public void setOnMenuItemClickListener(a aVar) {
        this.plS = aVar;
    }

    public void setOnSwipeListener(c cVar) {
        this.plQ = cVar;
    }

    public void setOnMenuStateChangeListener(b bVar) {
        this.plT = bVar;
    }

    public void setSwipeDirection(int i) {
        this.mDirection = i;
    }
}
