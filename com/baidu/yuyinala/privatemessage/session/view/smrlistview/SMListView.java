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
    private Interpolator plh;
    private Interpolator pli;
    private int plk;
    private int pll;
    private int plm;
    private int pln;
    private boolean plo;
    private SMLayout plp;
    private c plq;
    private d plr;
    private a pls;
    private b plt;

    /* loaded from: classes11.dex */
    public interface a {
        boolean a(int i, com.baidu.yuyinala.privatemessage.session.view.smrlistview.c cVar, int i2);
    }

    /* loaded from: classes11.dex */
    public interface b {
        void Om(int i);

        void On(int i);
    }

    /* loaded from: classes11.dex */
    public interface c {
        void Oo(int i);

        void Op(int i);
    }

    public SMListView(Context context) {
        super(context);
        this.mDirection = 1;
        this.plk = 5;
        this.pll = 3;
        this.plo = true;
        init();
    }

    public SMListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDirection = 1;
        this.plk = 5;
        this.pll = 3;
        this.plo = true;
        init();
    }

    public SMListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDirection = 1;
        this.plk = 5;
        this.pll = 3;
        this.plo = true;
        init();
    }

    private void init() {
        this.pll = vy(this.pll);
        this.plk = vy(this.plk);
        this.plm = 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter((ListAdapter) new com.baidu.yuyinala.privatemessage.session.view.smrlistview.b(getContext(), listAdapter) { // from class: com.baidu.yuyinala.privatemessage.session.view.smrlistview.SMListView.1
            @Override // com.baidu.yuyinala.privatemessage.session.view.smrlistview.b
            public void b(com.baidu.yuyinala.privatemessage.session.view.smrlistview.c cVar) {
                if (SMListView.this.plr != null) {
                    SMListView.this.plr.a(cVar);
                }
            }

            @Override // com.baidu.yuyinala.privatemessage.session.view.smrlistview.b, com.baidu.yuyinala.privatemessage.session.view.smrlistview.SMView.a
            public void a(SMView sMView, com.baidu.yuyinala.privatemessage.session.view.smrlistview.c cVar, int i) {
                boolean z = false;
                if (SMListView.this.pls != null) {
                    z = SMListView.this.pls.a(sMView.getPosition(), cVar, i);
                }
                if (SMListView.this.plp != null && !z) {
                    SMListView.this.plp.emZ();
                }
            }
        });
    }

    public void setCloseInterpolator(Interpolator interpolator) {
        this.plh = interpolator;
    }

    public void setOpenInterpolator(Interpolator interpolator) {
        this.pli = interpolator;
    }

    public Interpolator getOpenInterpolator() {
        return this.pli;
    }

    public Interpolator getCloseInterpolator() {
        return this.plh;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 && this.plp == null) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                int i = this.pln;
                this.plo = enc();
                this.mDownX = motionEvent.getX();
                this.cEl = motionEvent.getY();
                this.plm = 0;
                this.pln = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                if (this.pln == i && this.plp != null && this.plp.isOpen()) {
                    this.plm = 1;
                    this.plp.at(motionEvent);
                    return true;
                }
                View childAt = getChildAt(this.pln - getFirstVisiblePosition());
                if (this.plp != null && this.plp.isOpen()) {
                    this.plp.emZ();
                    this.plp = null;
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.setAction(3);
                    onTouchEvent(obtain);
                    if (this.plt != null) {
                        this.plt.On(i);
                    }
                    return true;
                }
                if (childAt instanceof SMLayout) {
                    this.plp = (SMLayout) childAt;
                    this.plp.setSwipeDirection(this.mDirection);
                }
                if (this.plp != null) {
                    this.plp.at(motionEvent);
                    break;
                }
                break;
            case 1:
                if (this.plm == 1) {
                    if (this.plp != null) {
                        boolean isOpen = this.plp.isOpen();
                        if (this.plo) {
                            this.plp.at(motionEvent);
                        }
                        boolean isOpen2 = this.plp.isOpen();
                        if (isOpen != isOpen2 && this.plt != null) {
                            if (isOpen2) {
                                this.plt.Om(this.pln);
                            } else {
                                this.plt.On(this.pln);
                            }
                        }
                        if (!isOpen2) {
                            this.pln = -1;
                            this.plp = null;
                        }
                    }
                    if (this.plq != null) {
                        this.plq.Op(this.pln);
                    }
                    motionEvent.setAction(3);
                    super.onTouchEvent(motionEvent);
                    return true;
                }
                break;
            case 2:
                float abs = Math.abs(motionEvent.getY() - this.cEl);
                float abs2 = Math.abs(motionEvent.getX() - this.mDownX);
                if (this.plm == 1) {
                    if (this.plp != null && this.plo) {
                        this.plp.at(motionEvent);
                    }
                    getSelector().setState(new int[]{0});
                    motionEvent.setAction(3);
                    super.onTouchEvent(motionEvent);
                    return true;
                } else if (this.plm == 0) {
                    if (Math.abs(abs) > this.plk) {
                        this.plm = 2;
                        break;
                    } else if (abs2 > this.pll) {
                        this.plm = 1;
                        if (this.plq != null) {
                            this.plq.Oo(this.pln);
                            break;
                        }
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean enc() {
        return this.plo;
    }

    public void setSwipeEnable(boolean z) {
        this.plo = z;
    }

    private int vy(int i) {
        return (int) TypedValue.applyDimension(1, i, getContext().getResources().getDisplayMetrics());
    }

    public void setMenuCreator(d dVar) {
        this.plr = dVar;
    }

    public void setOnMenuItemClickListener(a aVar) {
        this.pls = aVar;
    }

    public void setOnSwipeListener(c cVar) {
        this.plq = cVar;
    }

    public void setOnMenuStateChangeListener(b bVar) {
        this.plt = bVar;
    }

    public void setSwipeDirection(int i) {
        this.mDirection = i;
    }
}
