package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Scroller;
import com.baidu.yuyinala.privatemessage.implugin.util.c;
/* loaded from: classes11.dex */
public class IMListView extends ListView implements AbsListView.OnScrollListener {
    private static int peV = 60;
    @SuppressLint({"HandlerLeak"})
    private Handler mHandler;
    private Scroller mScroller;
    private int peW;
    private int peX;
    private IMChatHeader peY;
    private IMChatFooter peZ;
    private a pfa;
    private boolean pfb;
    private boolean pfc;
    private boolean pfd;
    private boolean pfe;
    private boolean pff;
    private float pfg;
    private float pfh;
    private float pfi;
    private int pfj;
    private int totalCount;

    /* loaded from: classes11.dex */
    public interface a {
        void onRefresh();
    }

    public IMListView(Context context) {
        super(context);
        this.pfb = true;
        this.pfd = false;
        this.pfe = false;
        this.pff = false;
        this.pfj = 2;
        this.mHandler = new Handler() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c.d("", "LOADHAED handleMessage  " + message.what);
                switch (message.what) {
                    case 1:
                        if (IMListView.this.pfg >= IMListView.peV) {
                            IMListView.this.mHandler.removeMessages(1);
                            IMListView.this.pfh = IMListView.this.pfg;
                            IMListView.this.pfg = 0.0f;
                            IMListView.this.mHandler.sendEmptyMessage(3);
                            break;
                        } else {
                            IMListView.this.pfg = (IMListView.peV / 10) + IMListView.this.pfg;
                            if (IMListView.this.pfg > IMListView.peV) {
                                IMListView.this.pfg = IMListView.peV;
                            }
                            IMListView.this.bA(IMListView.this.pfg);
                            IMListView.this.mHandler.sendEmptyMessageDelayed(1, 20L);
                            break;
                        }
                    case 2:
                        IMListView.this.pfa.onRefresh();
                        IMListView.this.pfj = 2;
                        break;
                    case 3:
                        IMListView.this.mHandler.sendEmptyMessageDelayed(2, 1500L);
                        IMListView.this.pfj = 3;
                        IMListView.this.pfd = true;
                        break;
                    case 4:
                        IMListView.this.pfh = 0.0f;
                        IMListView.this.pfg = 0.0f;
                        IMListView.this.elz();
                        IMListView.this.pfj = 2;
                        break;
                }
                IMListView.this.NN(message.what);
            }
        };
        hD(context);
    }

    public IMListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pfb = true;
        this.pfd = false;
        this.pfe = false;
        this.pff = false;
        this.pfj = 2;
        this.mHandler = new Handler() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c.d("", "LOADHAED handleMessage  " + message.what);
                switch (message.what) {
                    case 1:
                        if (IMListView.this.pfg >= IMListView.peV) {
                            IMListView.this.mHandler.removeMessages(1);
                            IMListView.this.pfh = IMListView.this.pfg;
                            IMListView.this.pfg = 0.0f;
                            IMListView.this.mHandler.sendEmptyMessage(3);
                            break;
                        } else {
                            IMListView.this.pfg = (IMListView.peV / 10) + IMListView.this.pfg;
                            if (IMListView.this.pfg > IMListView.peV) {
                                IMListView.this.pfg = IMListView.peV;
                            }
                            IMListView.this.bA(IMListView.this.pfg);
                            IMListView.this.mHandler.sendEmptyMessageDelayed(1, 20L);
                            break;
                        }
                    case 2:
                        IMListView.this.pfa.onRefresh();
                        IMListView.this.pfj = 2;
                        break;
                    case 3:
                        IMListView.this.mHandler.sendEmptyMessageDelayed(2, 1500L);
                        IMListView.this.pfj = 3;
                        IMListView.this.pfd = true;
                        break;
                    case 4:
                        IMListView.this.pfh = 0.0f;
                        IMListView.this.pfg = 0.0f;
                        IMListView.this.elz();
                        IMListView.this.pfj = 2;
                        break;
                }
                IMListView.this.NN(message.what);
            }
        };
        hD(context);
    }

    public IMListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pfb = true;
        this.pfd = false;
        this.pfe = false;
        this.pff = false;
        this.pfj = 2;
        this.mHandler = new Handler() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c.d("", "LOADHAED handleMessage  " + message.what);
                switch (message.what) {
                    case 1:
                        if (IMListView.this.pfg >= IMListView.peV) {
                            IMListView.this.mHandler.removeMessages(1);
                            IMListView.this.pfh = IMListView.this.pfg;
                            IMListView.this.pfg = 0.0f;
                            IMListView.this.mHandler.sendEmptyMessage(3);
                            break;
                        } else {
                            IMListView.this.pfg = (IMListView.peV / 10) + IMListView.this.pfg;
                            if (IMListView.this.pfg > IMListView.peV) {
                                IMListView.this.pfg = IMListView.peV;
                            }
                            IMListView.this.bA(IMListView.this.pfg);
                            IMListView.this.mHandler.sendEmptyMessageDelayed(1, 20L);
                            break;
                        }
                    case 2:
                        IMListView.this.pfa.onRefresh();
                        IMListView.this.pfj = 2;
                        break;
                    case 3:
                        IMListView.this.mHandler.sendEmptyMessageDelayed(2, 1500L);
                        IMListView.this.pfj = 3;
                        IMListView.this.pfd = true;
                        break;
                    case 4:
                        IMListView.this.pfh = 0.0f;
                        IMListView.this.pfg = 0.0f;
                        IMListView.this.elz();
                        IMListView.this.pfj = 2;
                        break;
                }
                IMListView.this.NN(message.what);
            }
        };
        hD(context);
    }

    private void hD(Context context) {
        this.mScroller = new Scroller(context, new DecelerateInterpolator());
        setOnScrollListener(this);
        this.peY = new IMChatHeader(context);
        this.peZ = new IMChatFooter(context);
    }

    public boolean elw() {
        View childAt;
        if (this.totalCount == 0) {
            c.d("", "RECEIVETEST -> return true");
            return true;
        } else if (this.peW + this.peX != this.totalCount || (childAt = getChildAt(getChildCount() - 1)) == null || childAt.getBottom() > getHeight()) {
            c.d("", "RECEIVETEST -> return false  " + this.peW + " " + this.peX + " " + this.totalCount);
            return false;
        } else {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        addHeaderView(this.peY);
        addFooterView(this.peZ);
        super.setAdapter(listAdapter);
    }

    public void setPullRefreshEnable(boolean z) {
        this.pfb = z;
        if (!this.pfb) {
            this.peY.setVisiableContent(4);
        } else {
            this.peY.setVisiableContent(0);
        }
    }

    public void setIMListViewListener(a aVar) {
        this.pfa = aVar;
    }

    public void elx() {
        if (this.pfd) {
            c.d("", "LOADHAED stopRefresh");
            this.pfd = false;
            elz();
        }
    }

    public void ely() {
        if (this.pfc) {
            this.pfc = false;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        try {
            switch (motionEvent.getAction()) {
                case 1:
                    if (this.pfj == 1 && this.pfg < peV) {
                        this.mHandler.sendEmptyMessageDelayed(4, 20L);
                        break;
                    }
                    break;
                case 2:
                    int y = (int) motionEvent.getY();
                    if (this.pfj == 1) {
                        if (this.pfi != 0.0f) {
                            this.pfg += y - this.pfi;
                        }
                        if (this.pfg > peV) {
                            this.pfg = peV;
                        }
                        if (this.pfg <= 0.0f) {
                            this.pfg = 0.0f;
                        }
                        bA(this.pfg);
                        this.pfi = y;
                        if (this.pfg >= peV) {
                            this.mHandler.removeMessages(1);
                            this.pfh = this.pfg;
                            this.pfg = 0.0f;
                            c.d("", "LOADHAED onTouchEvent HEAD_REFRESH");
                            this.mHandler.sendEmptyMessage(3);
                            this.pff = false;
                            break;
                        }
                    }
                    break;
            }
            z = super.onTouchEvent(motionEvent);
            return z;
        } catch (Exception e) {
            e.printStackTrace();
            return z;
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    private void bz(float f) {
        this.peY.setVisiableHeight(((int) f) + this.peY.getVisiableHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bA(float f) {
        float f2 = f - this.pfh;
        this.pfh = f;
        if (getFirstVisiblePosition() == 0) {
            if (this.peY.getVisiableHeight() > 0 || f2 > 0.0f) {
                bz(f2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void elz() {
        int visiableHeight = this.peY.getVisiableHeight();
        if (visiableHeight != 0) {
            this.mScroller.startScroll(0, visiableHeight, 0, 0, 200);
            this.peY.setVisiableHeight(0);
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NN(int i) {
        if (this.pfb) {
            switch (i) {
                case 1:
                    this.peY.setState(1);
                    return;
                case 2:
                    this.peY.setState(0);
                    return;
                case 3:
                    this.peY.setState(2);
                    return;
                default:
                    this.peY.setState(0);
                    return;
            }
        }
    }

    public void setRefreshTime() {
        this.peY.setRefreshTime();
    }

    public void setFooterHeight(int i) {
        this.peZ.setFooterHeight(i);
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public void setSelection(int i) {
        super.setSelection(i + 1);
    }

    public void setSelectionMove(int i) {
        setSelectionFromTop(i + 2, this.peY.getVisiableHeight());
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2) {
            this.pfe = true;
            this.pff = false;
        } else if (i == 1) {
            this.pfe = false;
            this.pff = true;
        } else {
            this.pfe = false;
            this.pff = false;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.peW = i;
        this.peX = i2;
        this.totalCount = i3;
        if (i == 0 && this.pfb) {
            if (this.pfe) {
                this.mHandler.removeMessages(1);
                this.peY.setVisiableHeight(0);
                this.pfh = 0.0f;
                this.pfg = 0.0f;
                this.mHandler.sendEmptyMessageDelayed(1, 20L);
                this.pfe = false;
                this.pff = false;
            }
            if (this.pff && this.pfj == 2) {
                this.pfj = 1;
            }
        }
    }
}
