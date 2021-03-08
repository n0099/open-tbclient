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
/* loaded from: classes10.dex */
public class IMListView extends ListView implements AbsListView.OnScrollListener {
    private static int phA = 60;
    @SuppressLint({"HandlerLeak"})
    private Handler mHandler;
    private Scroller mScroller;
    private int phB;
    private int phC;
    private IMChatHeader phD;
    private IMChatFooter phE;
    private a phF;
    private boolean phG;
    private boolean phH;
    private boolean phI;
    private boolean phJ;
    private boolean phK;
    private float phL;
    private float phM;
    private float phN;
    private int phO;
    private int totalCount;

    /* loaded from: classes10.dex */
    public interface a {
        void onRefresh();
    }

    public IMListView(Context context) {
        super(context);
        this.phG = true;
        this.phI = false;
        this.phJ = false;
        this.phK = false;
        this.phO = 2;
        this.mHandler = new Handler() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c.d("", "LOADHAED handleMessage  " + message.what);
                switch (message.what) {
                    case 1:
                        if (IMListView.this.phL >= IMListView.phA) {
                            IMListView.this.mHandler.removeMessages(1);
                            IMListView.this.phM = IMListView.this.phL;
                            IMListView.this.phL = 0.0f;
                            IMListView.this.mHandler.sendEmptyMessage(3);
                            break;
                        } else {
                            IMListView.this.phL = (IMListView.phA / 10) + IMListView.this.phL;
                            if (IMListView.this.phL > IMListView.phA) {
                                IMListView.this.phL = IMListView.phA;
                            }
                            IMListView.this.bE(IMListView.this.phL);
                            IMListView.this.mHandler.sendEmptyMessageDelayed(1, 20L);
                            break;
                        }
                    case 2:
                        IMListView.this.phF.onRefresh();
                        IMListView.this.phO = 2;
                        break;
                    case 3:
                        IMListView.this.mHandler.sendEmptyMessageDelayed(2, 1500L);
                        IMListView.this.phO = 3;
                        IMListView.this.phI = true;
                        break;
                    case 4:
                        IMListView.this.phM = 0.0f;
                        IMListView.this.phL = 0.0f;
                        IMListView.this.elR();
                        IMListView.this.phO = 2;
                        break;
                }
                IMListView.this.NS(message.what);
            }
        };
        hC(context);
    }

    public IMListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.phG = true;
        this.phI = false;
        this.phJ = false;
        this.phK = false;
        this.phO = 2;
        this.mHandler = new Handler() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c.d("", "LOADHAED handleMessage  " + message.what);
                switch (message.what) {
                    case 1:
                        if (IMListView.this.phL >= IMListView.phA) {
                            IMListView.this.mHandler.removeMessages(1);
                            IMListView.this.phM = IMListView.this.phL;
                            IMListView.this.phL = 0.0f;
                            IMListView.this.mHandler.sendEmptyMessage(3);
                            break;
                        } else {
                            IMListView.this.phL = (IMListView.phA / 10) + IMListView.this.phL;
                            if (IMListView.this.phL > IMListView.phA) {
                                IMListView.this.phL = IMListView.phA;
                            }
                            IMListView.this.bE(IMListView.this.phL);
                            IMListView.this.mHandler.sendEmptyMessageDelayed(1, 20L);
                            break;
                        }
                    case 2:
                        IMListView.this.phF.onRefresh();
                        IMListView.this.phO = 2;
                        break;
                    case 3:
                        IMListView.this.mHandler.sendEmptyMessageDelayed(2, 1500L);
                        IMListView.this.phO = 3;
                        IMListView.this.phI = true;
                        break;
                    case 4:
                        IMListView.this.phM = 0.0f;
                        IMListView.this.phL = 0.0f;
                        IMListView.this.elR();
                        IMListView.this.phO = 2;
                        break;
                }
                IMListView.this.NS(message.what);
            }
        };
        hC(context);
    }

    public IMListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.phG = true;
        this.phI = false;
        this.phJ = false;
        this.phK = false;
        this.phO = 2;
        this.mHandler = new Handler() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c.d("", "LOADHAED handleMessage  " + message.what);
                switch (message.what) {
                    case 1:
                        if (IMListView.this.phL >= IMListView.phA) {
                            IMListView.this.mHandler.removeMessages(1);
                            IMListView.this.phM = IMListView.this.phL;
                            IMListView.this.phL = 0.0f;
                            IMListView.this.mHandler.sendEmptyMessage(3);
                            break;
                        } else {
                            IMListView.this.phL = (IMListView.phA / 10) + IMListView.this.phL;
                            if (IMListView.this.phL > IMListView.phA) {
                                IMListView.this.phL = IMListView.phA;
                            }
                            IMListView.this.bE(IMListView.this.phL);
                            IMListView.this.mHandler.sendEmptyMessageDelayed(1, 20L);
                            break;
                        }
                    case 2:
                        IMListView.this.phF.onRefresh();
                        IMListView.this.phO = 2;
                        break;
                    case 3:
                        IMListView.this.mHandler.sendEmptyMessageDelayed(2, 1500L);
                        IMListView.this.phO = 3;
                        IMListView.this.phI = true;
                        break;
                    case 4:
                        IMListView.this.phM = 0.0f;
                        IMListView.this.phL = 0.0f;
                        IMListView.this.elR();
                        IMListView.this.phO = 2;
                        break;
                }
                IMListView.this.NS(message.what);
            }
        };
        hC(context);
    }

    private void hC(Context context) {
        this.mScroller = new Scroller(context, new DecelerateInterpolator());
        setOnScrollListener(this);
        this.phD = new IMChatHeader(context);
        this.phE = new IMChatFooter(context);
    }

    public boolean elO() {
        View childAt;
        if (this.totalCount == 0) {
            c.d("", "RECEIVETEST -> return true");
            return true;
        } else if (this.phB + this.phC != this.totalCount || (childAt = getChildAt(getChildCount() - 1)) == null || childAt.getBottom() > getHeight()) {
            c.d("", "RECEIVETEST -> return false  " + this.phB + " " + this.phC + " " + this.totalCount);
            return false;
        } else {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        addHeaderView(this.phD);
        addFooterView(this.phE);
        super.setAdapter(listAdapter);
    }

    public void setPullRefreshEnable(boolean z) {
        this.phG = z;
        if (!this.phG) {
            this.phD.setVisiableContent(4);
        } else {
            this.phD.setVisiableContent(0);
        }
    }

    public void setIMListViewListener(a aVar) {
        this.phF = aVar;
    }

    public void elP() {
        if (this.phI) {
            c.d("", "LOADHAED stopRefresh");
            this.phI = false;
            elR();
        }
    }

    public void elQ() {
        if (this.phH) {
            this.phH = false;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        try {
            switch (motionEvent.getAction()) {
                case 1:
                    if (this.phO == 1 && this.phL < phA) {
                        this.mHandler.sendEmptyMessageDelayed(4, 20L);
                        break;
                    }
                    break;
                case 2:
                    int y = (int) motionEvent.getY();
                    if (this.phO == 1) {
                        if (this.phN != 0.0f) {
                            this.phL += y - this.phN;
                        }
                        if (this.phL > phA) {
                            this.phL = phA;
                        }
                        if (this.phL <= 0.0f) {
                            this.phL = 0.0f;
                        }
                        bE(this.phL);
                        this.phN = y;
                        if (this.phL >= phA) {
                            this.mHandler.removeMessages(1);
                            this.phM = this.phL;
                            this.phL = 0.0f;
                            c.d("", "LOADHAED onTouchEvent HEAD_REFRESH");
                            this.mHandler.sendEmptyMessage(3);
                            this.phK = false;
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

    private void bD(float f) {
        this.phD.setVisiableHeight(((int) f) + this.phD.getVisiableHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bE(float f) {
        float f2 = f - this.phM;
        this.phM = f;
        if (getFirstVisiblePosition() == 0) {
            if (this.phD.getVisiableHeight() > 0 || f2 > 0.0f) {
                bD(f2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void elR() {
        int visiableHeight = this.phD.getVisiableHeight();
        if (visiableHeight != 0) {
            this.mScroller.startScroll(0, visiableHeight, 0, 0, 200);
            this.phD.setVisiableHeight(0);
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NS(int i) {
        if (this.phG) {
            switch (i) {
                case 1:
                    this.phD.setState(1);
                    return;
                case 2:
                    this.phD.setState(0);
                    return;
                case 3:
                    this.phD.setState(2);
                    return;
                default:
                    this.phD.setState(0);
                    return;
            }
        }
    }

    public void setRefreshTime() {
        this.phD.setRefreshTime();
    }

    public void setFooterHeight(int i) {
        this.phE.setFooterHeight(i);
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public void setSelection(int i) {
        super.setSelection(i + 1);
    }

    public void setSelectionMove(int i) {
        setSelectionFromTop(i + 2, this.phD.getVisiableHeight());
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2) {
            this.phJ = true;
            this.phK = false;
        } else if (i == 1) {
            this.phJ = false;
            this.phK = true;
        } else {
            this.phJ = false;
            this.phK = false;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.phB = i;
        this.phC = i2;
        this.totalCount = i3;
        if (i == 0 && this.phG) {
            if (this.phJ) {
                this.mHandler.removeMessages(1);
                this.phD.setVisiableHeight(0);
                this.phM = 0.0f;
                this.phL = 0.0f;
                this.mHandler.sendEmptyMessageDelayed(1, 20L);
                this.phJ = false;
                this.phK = false;
            }
            if (this.phK && this.phO == 2) {
                this.phO = 1;
            }
        }
    }
}
