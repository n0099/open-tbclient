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
    private float cGB;
    private int mDirection;
    private float mDownX;
    private int pfA;
    private boolean pfB;
    private SMLayout pfC;
    private c pfD;
    private d pfE;
    private a pfF;
    private b pfG;
    private Interpolator pfu;
    private Interpolator pfv;
    private int pfx;
    private int pfy;
    private int pfz;

    /* loaded from: classes11.dex */
    public interface a {
        boolean a(int i, com.baidu.yuyinala.privatemessage.session.view.smrlistview.c cVar, int i2);
    }

    /* loaded from: classes11.dex */
    public interface b {
        void Py(int i);

        void Pz(int i);
    }

    /* loaded from: classes11.dex */
    public interface c {
        void PA(int i);

        void PB(int i);
    }

    public SMListView(Context context) {
        super(context);
        this.mDirection = 1;
        this.pfx = 5;
        this.pfy = 3;
        this.pfB = true;
        init();
    }

    public SMListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDirection = 1;
        this.pfx = 5;
        this.pfy = 3;
        this.pfB = true;
        init();
    }

    public SMListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDirection = 1;
        this.pfx = 5;
        this.pfy = 3;
        this.pfB = true;
        init();
    }

    private void init() {
        this.pfy = wT(this.pfy);
        this.pfx = wT(this.pfx);
        this.pfz = 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter((ListAdapter) new com.baidu.yuyinala.privatemessage.session.view.smrlistview.b(getContext(), listAdapter) { // from class: com.baidu.yuyinala.privatemessage.session.view.smrlistview.SMListView.1
            @Override // com.baidu.yuyinala.privatemessage.session.view.smrlistview.b
            public void b(com.baidu.yuyinala.privatemessage.session.view.smrlistview.c cVar) {
                if (SMListView.this.pfE != null) {
                    SMListView.this.pfE.a(cVar);
                }
            }

            @Override // com.baidu.yuyinala.privatemessage.session.view.smrlistview.b, com.baidu.yuyinala.privatemessage.session.view.smrlistview.SMView.a
            public void a(SMView sMView, com.baidu.yuyinala.privatemessage.session.view.smrlistview.c cVar, int i) {
                boolean z = false;
                if (SMListView.this.pfF != null) {
                    z = SMListView.this.pfF.a(sMView.getPosition(), cVar, i);
                }
                if (SMListView.this.pfC != null && !z) {
                    SMListView.this.pfC.eoD();
                }
            }
        });
    }

    public void setCloseInterpolator(Interpolator interpolator) {
        this.pfu = interpolator;
    }

    public void setOpenInterpolator(Interpolator interpolator) {
        this.pfv = interpolator;
    }

    public Interpolator getOpenInterpolator() {
        return this.pfv;
    }

    public Interpolator getCloseInterpolator() {
        return this.pfu;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 && this.pfC == null) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                int i = this.pfA;
                this.pfB = eoG();
                this.mDownX = motionEvent.getX();
                this.cGB = motionEvent.getY();
                this.pfz = 0;
                this.pfA = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                if (this.pfA == i && this.pfC != null && this.pfC.isOpen()) {
                    this.pfz = 1;
                    this.pfC.at(motionEvent);
                    return true;
                }
                View childAt = getChildAt(this.pfA - getFirstVisiblePosition());
                if (this.pfC != null && this.pfC.isOpen()) {
                    this.pfC.eoD();
                    this.pfC = null;
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.setAction(3);
                    onTouchEvent(obtain);
                    if (this.pfG != null) {
                        this.pfG.Pz(i);
                    }
                    return true;
                }
                if (childAt instanceof SMLayout) {
                    this.pfC = (SMLayout) childAt;
                    this.pfC.setSwipeDirection(this.mDirection);
                }
                if (this.pfC != null) {
                    this.pfC.at(motionEvent);
                    break;
                }
                break;
            case 1:
                if (this.pfz == 1) {
                    if (this.pfC != null) {
                        boolean isOpen = this.pfC.isOpen();
                        if (this.pfB) {
                            this.pfC.at(motionEvent);
                        }
                        boolean isOpen2 = this.pfC.isOpen();
                        if (isOpen != isOpen2 && this.pfG != null) {
                            if (isOpen2) {
                                this.pfG.Py(this.pfA);
                            } else {
                                this.pfG.Pz(this.pfA);
                            }
                        }
                        if (!isOpen2) {
                            this.pfA = -1;
                            this.pfC = null;
                        }
                    }
                    if (this.pfD != null) {
                        this.pfD.PB(this.pfA);
                    }
                    motionEvent.setAction(3);
                    super.onTouchEvent(motionEvent);
                    return true;
                }
                break;
            case 2:
                float abs = Math.abs(motionEvent.getY() - this.cGB);
                float abs2 = Math.abs(motionEvent.getX() - this.mDownX);
                if (this.pfz == 1) {
                    if (this.pfC != null && this.pfB) {
                        this.pfC.at(motionEvent);
                    }
                    getSelector().setState(new int[]{0});
                    motionEvent.setAction(3);
                    super.onTouchEvent(motionEvent);
                    return true;
                } else if (this.pfz == 0) {
                    if (Math.abs(abs) > this.pfx) {
                        this.pfz = 2;
                        break;
                    } else if (abs2 > this.pfy) {
                        this.pfz = 1;
                        if (this.pfD != null) {
                            this.pfD.PA(this.pfA);
                            break;
                        }
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean eoG() {
        return this.pfB;
    }

    public void setSwipeEnable(boolean z) {
        this.pfB = z;
    }

    private int wT(int i) {
        return (int) TypedValue.applyDimension(1, i, getContext().getResources().getDisplayMetrics());
    }

    public void setMenuCreator(d dVar) {
        this.pfE = dVar;
    }

    public void setOnMenuItemClickListener(a aVar) {
        this.pfF = aVar;
    }

    public void setOnSwipeListener(c cVar) {
        this.pfD = cVar;
    }

    public void setOnMenuStateChangeListener(b bVar) {
        this.pfG = bVar;
    }

    public void setSwipeDirection(int i) {
        this.mDirection = i;
    }
}
