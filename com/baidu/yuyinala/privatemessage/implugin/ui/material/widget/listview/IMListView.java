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
    private static int pfv = 60;
    @SuppressLint({"HandlerLeak"})
    private Handler mHandler;
    private Scroller mScroller;
    private a pfA;
    private boolean pfB;
    private boolean pfC;
    private boolean pfD;
    private boolean pfE;
    private boolean pfF;
    private float pfG;
    private float pfH;
    private float pfI;
    private int pfJ;
    private int pfw;
    private int pfx;
    private IMChatHeader pfy;
    private IMChatFooter pfz;
    private int totalCount;

    /* loaded from: classes11.dex */
    public interface a {
        void onRefresh();
    }

    public IMListView(Context context) {
        super(context);
        this.pfB = true;
        this.pfD = false;
        this.pfE = false;
        this.pfF = false;
        this.pfJ = 2;
        this.mHandler = new Handler() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c.d("", "LOADHAED handleMessage  " + message.what);
                switch (message.what) {
                    case 1:
                        if (IMListView.this.pfG >= IMListView.pfv) {
                            IMListView.this.mHandler.removeMessages(1);
                            IMListView.this.pfH = IMListView.this.pfG;
                            IMListView.this.pfG = 0.0f;
                            IMListView.this.mHandler.sendEmptyMessage(3);
                            break;
                        } else {
                            IMListView.this.pfG = (IMListView.pfv / 10) + IMListView.this.pfG;
                            if (IMListView.this.pfG > IMListView.pfv) {
                                IMListView.this.pfG = IMListView.pfv;
                            }
                            IMListView.this.bA(IMListView.this.pfG);
                            IMListView.this.mHandler.sendEmptyMessageDelayed(1, 20L);
                            break;
                        }
                    case 2:
                        IMListView.this.pfA.onRefresh();
                        IMListView.this.pfJ = 2;
                        break;
                    case 3:
                        IMListView.this.mHandler.sendEmptyMessageDelayed(2, 1500L);
                        IMListView.this.pfJ = 3;
                        IMListView.this.pfD = true;
                        break;
                    case 4:
                        IMListView.this.pfH = 0.0f;
                        IMListView.this.pfG = 0.0f;
                        IMListView.this.elH();
                        IMListView.this.pfJ = 2;
                        break;
                }
                IMListView.this.NO(message.what);
            }
        };
        hD(context);
    }

    public IMListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pfB = true;
        this.pfD = false;
        this.pfE = false;
        this.pfF = false;
        this.pfJ = 2;
        this.mHandler = new Handler() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c.d("", "LOADHAED handleMessage  " + message.what);
                switch (message.what) {
                    case 1:
                        if (IMListView.this.pfG >= IMListView.pfv) {
                            IMListView.this.mHandler.removeMessages(1);
                            IMListView.this.pfH = IMListView.this.pfG;
                            IMListView.this.pfG = 0.0f;
                            IMListView.this.mHandler.sendEmptyMessage(3);
                            break;
                        } else {
                            IMListView.this.pfG = (IMListView.pfv / 10) + IMListView.this.pfG;
                            if (IMListView.this.pfG > IMListView.pfv) {
                                IMListView.this.pfG = IMListView.pfv;
                            }
                            IMListView.this.bA(IMListView.this.pfG);
                            IMListView.this.mHandler.sendEmptyMessageDelayed(1, 20L);
                            break;
                        }
                    case 2:
                        IMListView.this.pfA.onRefresh();
                        IMListView.this.pfJ = 2;
                        break;
                    case 3:
                        IMListView.this.mHandler.sendEmptyMessageDelayed(2, 1500L);
                        IMListView.this.pfJ = 3;
                        IMListView.this.pfD = true;
                        break;
                    case 4:
                        IMListView.this.pfH = 0.0f;
                        IMListView.this.pfG = 0.0f;
                        IMListView.this.elH();
                        IMListView.this.pfJ = 2;
                        break;
                }
                IMListView.this.NO(message.what);
            }
        };
        hD(context);
    }

    public IMListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pfB = true;
        this.pfD = false;
        this.pfE = false;
        this.pfF = false;
        this.pfJ = 2;
        this.mHandler = new Handler() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c.d("", "LOADHAED handleMessage  " + message.what);
                switch (message.what) {
                    case 1:
                        if (IMListView.this.pfG >= IMListView.pfv) {
                            IMListView.this.mHandler.removeMessages(1);
                            IMListView.this.pfH = IMListView.this.pfG;
                            IMListView.this.pfG = 0.0f;
                            IMListView.this.mHandler.sendEmptyMessage(3);
                            break;
                        } else {
                            IMListView.this.pfG = (IMListView.pfv / 10) + IMListView.this.pfG;
                            if (IMListView.this.pfG > IMListView.pfv) {
                                IMListView.this.pfG = IMListView.pfv;
                            }
                            IMListView.this.bA(IMListView.this.pfG);
                            IMListView.this.mHandler.sendEmptyMessageDelayed(1, 20L);
                            break;
                        }
                    case 2:
                        IMListView.this.pfA.onRefresh();
                        IMListView.this.pfJ = 2;
                        break;
                    case 3:
                        IMListView.this.mHandler.sendEmptyMessageDelayed(2, 1500L);
                        IMListView.this.pfJ = 3;
                        IMListView.this.pfD = true;
                        break;
                    case 4:
                        IMListView.this.pfH = 0.0f;
                        IMListView.this.pfG = 0.0f;
                        IMListView.this.elH();
                        IMListView.this.pfJ = 2;
                        break;
                }
                IMListView.this.NO(message.what);
            }
        };
        hD(context);
    }

    private void hD(Context context) {
        this.mScroller = new Scroller(context, new DecelerateInterpolator());
        setOnScrollListener(this);
        this.pfy = new IMChatHeader(context);
        this.pfz = new IMChatFooter(context);
    }

    public boolean elE() {
        View childAt;
        if (this.totalCount == 0) {
            c.d("", "RECEIVETEST -> return true");
            return true;
        } else if (this.pfw + this.pfx != this.totalCount || (childAt = getChildAt(getChildCount() - 1)) == null || childAt.getBottom() > getHeight()) {
            c.d("", "RECEIVETEST -> return false  " + this.pfw + " " + this.pfx + " " + this.totalCount);
            return false;
        } else {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        addHeaderView(this.pfy);
        addFooterView(this.pfz);
        super.setAdapter(listAdapter);
    }

    public void setPullRefreshEnable(boolean z) {
        this.pfB = z;
        if (!this.pfB) {
            this.pfy.setVisiableContent(4);
        } else {
            this.pfy.setVisiableContent(0);
        }
    }

    public void setIMListViewListener(a aVar) {
        this.pfA = aVar;
    }

    public void elF() {
        if (this.pfD) {
            c.d("", "LOADHAED stopRefresh");
            this.pfD = false;
            elH();
        }
    }

    public void elG() {
        if (this.pfC) {
            this.pfC = false;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        try {
            switch (motionEvent.getAction()) {
                case 1:
                    if (this.pfJ == 1 && this.pfG < pfv) {
                        this.mHandler.sendEmptyMessageDelayed(4, 20L);
                        break;
                    }
                    break;
                case 2:
                    int y = (int) motionEvent.getY();
                    if (this.pfJ == 1) {
                        if (this.pfI != 0.0f) {
                            this.pfG += y - this.pfI;
                        }
                        if (this.pfG > pfv) {
                            this.pfG = pfv;
                        }
                        if (this.pfG <= 0.0f) {
                            this.pfG = 0.0f;
                        }
                        bA(this.pfG);
                        this.pfI = y;
                        if (this.pfG >= pfv) {
                            this.mHandler.removeMessages(1);
                            this.pfH = this.pfG;
                            this.pfG = 0.0f;
                            c.d("", "LOADHAED onTouchEvent HEAD_REFRESH");
                            this.mHandler.sendEmptyMessage(3);
                            this.pfF = false;
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
        this.pfy.setVisiableHeight(((int) f) + this.pfy.getVisiableHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bA(float f) {
        float f2 = f - this.pfH;
        this.pfH = f;
        if (getFirstVisiblePosition() == 0) {
            if (this.pfy.getVisiableHeight() > 0 || f2 > 0.0f) {
                bz(f2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void elH() {
        int visiableHeight = this.pfy.getVisiableHeight();
        if (visiableHeight != 0) {
            this.mScroller.startScroll(0, visiableHeight, 0, 0, 200);
            this.pfy.setVisiableHeight(0);
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NO(int i) {
        if (this.pfB) {
            switch (i) {
                case 1:
                    this.pfy.setState(1);
                    return;
                case 2:
                    this.pfy.setState(0);
                    return;
                case 3:
                    this.pfy.setState(2);
                    return;
                default:
                    this.pfy.setState(0);
                    return;
            }
        }
    }

    public void setRefreshTime() {
        this.pfy.setRefreshTime();
    }

    public void setFooterHeight(int i) {
        this.pfz.setFooterHeight(i);
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public void setSelection(int i) {
        super.setSelection(i + 1);
    }

    public void setSelectionMove(int i) {
        setSelectionFromTop(i + 2, this.pfy.getVisiableHeight());
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2) {
            this.pfE = true;
            this.pfF = false;
        } else if (i == 1) {
            this.pfE = false;
            this.pfF = true;
        } else {
            this.pfE = false;
            this.pfF = false;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.pfw = i;
        this.pfx = i2;
        this.totalCount = i3;
        if (i == 0 && this.pfB) {
            if (this.pfE) {
                this.mHandler.removeMessages(1);
                this.pfy.setVisiableHeight(0);
                this.pfH = 0.0f;
                this.pfG = 0.0f;
                this.mHandler.sendEmptyMessageDelayed(1, 20L);
                this.pfE = false;
                this.pfF = false;
            }
            if (this.pfF && this.pfJ == 2) {
                this.pfJ = 1;
            }
        }
    }
}
