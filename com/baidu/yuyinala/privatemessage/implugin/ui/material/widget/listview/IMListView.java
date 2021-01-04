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
    private static int oZj = 60;
    @SuppressLint({"HandlerLeak"})
    private Handler mHandler;
    private Scroller mScroller;
    private int oZk;
    private int oZl;
    private IMChatHeader oZm;
    private IMChatFooter oZn;
    private a oZo;
    private boolean oZp;
    private boolean oZq;
    private boolean oZr;
    private boolean oZs;
    private boolean oZt;
    private float oZu;
    private float oZv;
    private float oZw;
    private int oZx;
    private int totalCount;

    /* loaded from: classes11.dex */
    public interface a {
        void onRefresh();
    }

    public IMListView(Context context) {
        super(context);
        this.oZp = true;
        this.oZr = false;
        this.oZs = false;
        this.oZt = false;
        this.oZx = 2;
        this.mHandler = new Handler() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c.d("", "LOADHAED handleMessage  " + message.what);
                switch (message.what) {
                    case 1:
                        if (IMListView.this.oZu >= IMListView.oZj) {
                            IMListView.this.mHandler.removeMessages(1);
                            IMListView.this.oZv = IMListView.this.oZu;
                            IMListView.this.oZu = 0.0f;
                            IMListView.this.mHandler.sendEmptyMessage(3);
                            break;
                        } else {
                            IMListView.this.oZu = (IMListView.oZj / 10) + IMListView.this.oZu;
                            if (IMListView.this.oZu > IMListView.oZj) {
                                IMListView.this.oZu = IMListView.oZj;
                            }
                            IMListView.this.bx(IMListView.this.oZu);
                            IMListView.this.mHandler.sendEmptyMessageDelayed(1, 20L);
                            break;
                        }
                    case 2:
                        IMListView.this.oZo.onRefresh();
                        IMListView.this.oZx = 2;
                        break;
                    case 3:
                        IMListView.this.mHandler.sendEmptyMessageDelayed(2, 1500L);
                        IMListView.this.oZx = 3;
                        IMListView.this.oZr = true;
                        break;
                    case 4:
                        IMListView.this.oZv = 0.0f;
                        IMListView.this.oZu = 0.0f;
                        IMListView.this.emY();
                        IMListView.this.oZx = 2;
                        break;
                }
                IMListView.this.OZ(message.what);
            }
        };
        hC(context);
    }

    public IMListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oZp = true;
        this.oZr = false;
        this.oZs = false;
        this.oZt = false;
        this.oZx = 2;
        this.mHandler = new Handler() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c.d("", "LOADHAED handleMessage  " + message.what);
                switch (message.what) {
                    case 1:
                        if (IMListView.this.oZu >= IMListView.oZj) {
                            IMListView.this.mHandler.removeMessages(1);
                            IMListView.this.oZv = IMListView.this.oZu;
                            IMListView.this.oZu = 0.0f;
                            IMListView.this.mHandler.sendEmptyMessage(3);
                            break;
                        } else {
                            IMListView.this.oZu = (IMListView.oZj / 10) + IMListView.this.oZu;
                            if (IMListView.this.oZu > IMListView.oZj) {
                                IMListView.this.oZu = IMListView.oZj;
                            }
                            IMListView.this.bx(IMListView.this.oZu);
                            IMListView.this.mHandler.sendEmptyMessageDelayed(1, 20L);
                            break;
                        }
                    case 2:
                        IMListView.this.oZo.onRefresh();
                        IMListView.this.oZx = 2;
                        break;
                    case 3:
                        IMListView.this.mHandler.sendEmptyMessageDelayed(2, 1500L);
                        IMListView.this.oZx = 3;
                        IMListView.this.oZr = true;
                        break;
                    case 4:
                        IMListView.this.oZv = 0.0f;
                        IMListView.this.oZu = 0.0f;
                        IMListView.this.emY();
                        IMListView.this.oZx = 2;
                        break;
                }
                IMListView.this.OZ(message.what);
            }
        };
        hC(context);
    }

    public IMListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oZp = true;
        this.oZr = false;
        this.oZs = false;
        this.oZt = false;
        this.oZx = 2;
        this.mHandler = new Handler() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c.d("", "LOADHAED handleMessage  " + message.what);
                switch (message.what) {
                    case 1:
                        if (IMListView.this.oZu >= IMListView.oZj) {
                            IMListView.this.mHandler.removeMessages(1);
                            IMListView.this.oZv = IMListView.this.oZu;
                            IMListView.this.oZu = 0.0f;
                            IMListView.this.mHandler.sendEmptyMessage(3);
                            break;
                        } else {
                            IMListView.this.oZu = (IMListView.oZj / 10) + IMListView.this.oZu;
                            if (IMListView.this.oZu > IMListView.oZj) {
                                IMListView.this.oZu = IMListView.oZj;
                            }
                            IMListView.this.bx(IMListView.this.oZu);
                            IMListView.this.mHandler.sendEmptyMessageDelayed(1, 20L);
                            break;
                        }
                    case 2:
                        IMListView.this.oZo.onRefresh();
                        IMListView.this.oZx = 2;
                        break;
                    case 3:
                        IMListView.this.mHandler.sendEmptyMessageDelayed(2, 1500L);
                        IMListView.this.oZx = 3;
                        IMListView.this.oZr = true;
                        break;
                    case 4:
                        IMListView.this.oZv = 0.0f;
                        IMListView.this.oZu = 0.0f;
                        IMListView.this.emY();
                        IMListView.this.oZx = 2;
                        break;
                }
                IMListView.this.OZ(message.what);
            }
        };
        hC(context);
    }

    private void hC(Context context) {
        this.mScroller = new Scroller(context, new DecelerateInterpolator());
        setOnScrollListener(this);
        this.oZm = new IMChatHeader(context);
        this.oZn = new IMChatFooter(context);
    }

    public boolean emV() {
        View childAt;
        if (this.totalCount == 0) {
            c.d("", "RECEIVETEST -> return true");
            return true;
        } else if (this.oZk + this.oZl != this.totalCount || (childAt = getChildAt(getChildCount() - 1)) == null || childAt.getBottom() > getHeight()) {
            c.d("", "RECEIVETEST -> return false  " + this.oZk + " " + this.oZl + " " + this.totalCount);
            return false;
        } else {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        addHeaderView(this.oZm);
        addFooterView(this.oZn);
        super.setAdapter(listAdapter);
    }

    public void setPullRefreshEnable(boolean z) {
        this.oZp = z;
        if (!this.oZp) {
            this.oZm.setVisiableContent(4);
        } else {
            this.oZm.setVisiableContent(0);
        }
    }

    public void setIMListViewListener(a aVar) {
        this.oZo = aVar;
    }

    public void emW() {
        if (this.oZr) {
            c.d("", "LOADHAED stopRefresh");
            this.oZr = false;
            emY();
        }
    }

    public void emX() {
        if (this.oZq) {
            this.oZq = false;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        try {
            switch (motionEvent.getAction()) {
                case 1:
                    if (this.oZx == 1 && this.oZu < oZj) {
                        this.mHandler.sendEmptyMessageDelayed(4, 20L);
                        break;
                    }
                    break;
                case 2:
                    int y = (int) motionEvent.getY();
                    if (this.oZx == 1) {
                        if (this.oZw != 0.0f) {
                            this.oZu += y - this.oZw;
                        }
                        if (this.oZu > oZj) {
                            this.oZu = oZj;
                        }
                        if (this.oZu <= 0.0f) {
                            this.oZu = 0.0f;
                        }
                        bx(this.oZu);
                        this.oZw = y;
                        if (this.oZu >= oZj) {
                            this.mHandler.removeMessages(1);
                            this.oZv = this.oZu;
                            this.oZu = 0.0f;
                            c.d("", "LOADHAED onTouchEvent HEAD_REFRESH");
                            this.mHandler.sendEmptyMessage(3);
                            this.oZt = false;
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

    private void bw(float f) {
        this.oZm.setVisiableHeight(((int) f) + this.oZm.getVisiableHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bx(float f) {
        float f2 = f - this.oZv;
        this.oZv = f;
        if (getFirstVisiblePosition() == 0) {
            if (this.oZm.getVisiableHeight() > 0 || f2 > 0.0f) {
                bw(f2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emY() {
        int visiableHeight = this.oZm.getVisiableHeight();
        if (visiableHeight != 0) {
            this.mScroller.startScroll(0, visiableHeight, 0, 0, 200);
            this.oZm.setVisiableHeight(0);
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OZ(int i) {
        if (this.oZp) {
            switch (i) {
                case 1:
                    this.oZm.setState(1);
                    return;
                case 2:
                    this.oZm.setState(0);
                    return;
                case 3:
                    this.oZm.setState(2);
                    return;
                default:
                    this.oZm.setState(0);
                    return;
            }
        }
    }

    public void setRefreshTime() {
        this.oZm.setRefreshTime();
    }

    public void setFooterHeight(int i) {
        this.oZn.setFooterHeight(i);
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public void setSelection(int i) {
        super.setSelection(i + 1);
    }

    public void setSelectionMove(int i) {
        setSelectionFromTop(i + 2, this.oZm.getVisiableHeight());
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2) {
            this.oZs = true;
            this.oZt = false;
        } else if (i == 1) {
            this.oZs = false;
            this.oZt = true;
        } else {
            this.oZs = false;
            this.oZt = false;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.oZk = i;
        this.oZl = i2;
        this.totalCount = i3;
        if (i == 0 && this.oZp) {
            if (this.oZs) {
                this.mHandler.removeMessages(1);
                this.oZm.setVisiableHeight(0);
                this.oZv = 0.0f;
                this.oZu = 0.0f;
                this.mHandler.sendEmptyMessageDelayed(1, 20L);
                this.oZs = false;
                this.oZt = false;
            }
            if (this.oZt && this.oZx == 2) {
                this.oZx = 1;
            }
        }
    }
}
