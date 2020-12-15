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
/* loaded from: classes4.dex */
public class IMListView extends ListView implements AbsListView.OnScrollListener {
    private static int oTe = 60;
    @SuppressLint({"HandlerLeak"})
    private Handler mHandler;
    private Scroller mScroller;
    private int oTf;
    private int oTg;
    private IMChatHeader oTh;
    private IMChatFooter oTi;
    private a oTj;
    private boolean oTk;
    private boolean oTl;
    private boolean oTm;
    private boolean oTn;
    private boolean oTo;
    private float oTp;
    private float oTq;
    private float oTr;
    private int oTs;
    private int totalCount;

    /* loaded from: classes4.dex */
    public interface a {
        void onRefresh();
    }

    public IMListView(Context context) {
        super(context);
        this.oTk = true;
        this.oTm = false;
        this.oTn = false;
        this.oTo = false;
        this.oTs = 2;
        this.mHandler = new Handler() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c.d("", "LOADHAED handleMessage  " + message.what);
                switch (message.what) {
                    case 1:
                        if (IMListView.this.oTp >= IMListView.oTe) {
                            IMListView.this.mHandler.removeMessages(1);
                            IMListView.this.oTq = IMListView.this.oTp;
                            IMListView.this.oTp = 0.0f;
                            IMListView.this.mHandler.sendEmptyMessage(3);
                            break;
                        } else {
                            IMListView.this.oTp = (IMListView.oTe / 10) + IMListView.this.oTp;
                            if (IMListView.this.oTp > IMListView.oTe) {
                                IMListView.this.oTp = IMListView.oTe;
                            }
                            IMListView.this.bm(IMListView.this.oTp);
                            IMListView.this.mHandler.sendEmptyMessageDelayed(1, 20L);
                            break;
                        }
                    case 2:
                        IMListView.this.oTj.onRefresh();
                        IMListView.this.oTs = 2;
                        break;
                    case 3:
                        IMListView.this.mHandler.sendEmptyMessageDelayed(2, 1500L);
                        IMListView.this.oTs = 3;
                        IMListView.this.oTm = true;
                        break;
                    case 4:
                        IMListView.this.oTq = 0.0f;
                        IMListView.this.oTp = 0.0f;
                        IMListView.this.emW();
                        IMListView.this.oTs = 2;
                        break;
                }
                IMListView.this.Pl(message.what);
            }
        };
        hp(context);
    }

    public IMListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oTk = true;
        this.oTm = false;
        this.oTn = false;
        this.oTo = false;
        this.oTs = 2;
        this.mHandler = new Handler() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c.d("", "LOADHAED handleMessage  " + message.what);
                switch (message.what) {
                    case 1:
                        if (IMListView.this.oTp >= IMListView.oTe) {
                            IMListView.this.mHandler.removeMessages(1);
                            IMListView.this.oTq = IMListView.this.oTp;
                            IMListView.this.oTp = 0.0f;
                            IMListView.this.mHandler.sendEmptyMessage(3);
                            break;
                        } else {
                            IMListView.this.oTp = (IMListView.oTe / 10) + IMListView.this.oTp;
                            if (IMListView.this.oTp > IMListView.oTe) {
                                IMListView.this.oTp = IMListView.oTe;
                            }
                            IMListView.this.bm(IMListView.this.oTp);
                            IMListView.this.mHandler.sendEmptyMessageDelayed(1, 20L);
                            break;
                        }
                    case 2:
                        IMListView.this.oTj.onRefresh();
                        IMListView.this.oTs = 2;
                        break;
                    case 3:
                        IMListView.this.mHandler.sendEmptyMessageDelayed(2, 1500L);
                        IMListView.this.oTs = 3;
                        IMListView.this.oTm = true;
                        break;
                    case 4:
                        IMListView.this.oTq = 0.0f;
                        IMListView.this.oTp = 0.0f;
                        IMListView.this.emW();
                        IMListView.this.oTs = 2;
                        break;
                }
                IMListView.this.Pl(message.what);
            }
        };
        hp(context);
    }

    public IMListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oTk = true;
        this.oTm = false;
        this.oTn = false;
        this.oTo = false;
        this.oTs = 2;
        this.mHandler = new Handler() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c.d("", "LOADHAED handleMessage  " + message.what);
                switch (message.what) {
                    case 1:
                        if (IMListView.this.oTp >= IMListView.oTe) {
                            IMListView.this.mHandler.removeMessages(1);
                            IMListView.this.oTq = IMListView.this.oTp;
                            IMListView.this.oTp = 0.0f;
                            IMListView.this.mHandler.sendEmptyMessage(3);
                            break;
                        } else {
                            IMListView.this.oTp = (IMListView.oTe / 10) + IMListView.this.oTp;
                            if (IMListView.this.oTp > IMListView.oTe) {
                                IMListView.this.oTp = IMListView.oTe;
                            }
                            IMListView.this.bm(IMListView.this.oTp);
                            IMListView.this.mHandler.sendEmptyMessageDelayed(1, 20L);
                            break;
                        }
                    case 2:
                        IMListView.this.oTj.onRefresh();
                        IMListView.this.oTs = 2;
                        break;
                    case 3:
                        IMListView.this.mHandler.sendEmptyMessageDelayed(2, 1500L);
                        IMListView.this.oTs = 3;
                        IMListView.this.oTm = true;
                        break;
                    case 4:
                        IMListView.this.oTq = 0.0f;
                        IMListView.this.oTp = 0.0f;
                        IMListView.this.emW();
                        IMListView.this.oTs = 2;
                        break;
                }
                IMListView.this.Pl(message.what);
            }
        };
        hp(context);
    }

    private void hp(Context context) {
        this.mScroller = new Scroller(context, new DecelerateInterpolator());
        setOnScrollListener(this);
        this.oTh = new IMChatHeader(context);
        this.oTi = new IMChatFooter(context);
    }

    public boolean emT() {
        View childAt;
        if (this.totalCount == 0) {
            c.d("", "RECEIVETEST -> return true");
            return true;
        } else if (this.oTf + this.oTg != this.totalCount || (childAt = getChildAt(getChildCount() - 1)) == null || childAt.getBottom() > getHeight()) {
            c.d("", "RECEIVETEST -> return false  " + this.oTf + " " + this.oTg + " " + this.totalCount);
            return false;
        } else {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        addHeaderView(this.oTh);
        addFooterView(this.oTi);
        super.setAdapter(listAdapter);
    }

    public void setPullRefreshEnable(boolean z) {
        this.oTk = z;
        if (!this.oTk) {
            this.oTh.setVisiableContent(4);
        } else {
            this.oTh.setVisiableContent(0);
        }
    }

    public void setIMListViewListener(a aVar) {
        this.oTj = aVar;
    }

    public void emU() {
        if (this.oTm) {
            c.d("", "LOADHAED stopRefresh");
            this.oTm = false;
            emW();
        }
    }

    public void emV() {
        if (this.oTl) {
            this.oTl = false;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        try {
            switch (motionEvent.getAction()) {
                case 1:
                    if (this.oTs == 1 && this.oTp < oTe) {
                        this.mHandler.sendEmptyMessageDelayed(4, 20L);
                        break;
                    }
                    break;
                case 2:
                    int y = (int) motionEvent.getY();
                    if (this.oTs == 1) {
                        if (this.oTr != 0.0f) {
                            this.oTp += y - this.oTr;
                        }
                        if (this.oTp > oTe) {
                            this.oTp = oTe;
                        }
                        if (this.oTp <= 0.0f) {
                            this.oTp = 0.0f;
                        }
                        bm(this.oTp);
                        this.oTr = y;
                        if (this.oTp >= oTe) {
                            this.mHandler.removeMessages(1);
                            this.oTq = this.oTp;
                            this.oTp = 0.0f;
                            c.d("", "LOADHAED onTouchEvent HEAD_REFRESH");
                            this.mHandler.sendEmptyMessage(3);
                            this.oTo = false;
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

    private void bl(float f) {
        this.oTh.setVisiableHeight(((int) f) + this.oTh.getVisiableHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bm(float f) {
        float f2 = f - this.oTq;
        this.oTq = f;
        if (getFirstVisiblePosition() == 0) {
            if (this.oTh.getVisiableHeight() > 0 || f2 > 0.0f) {
                bl(f2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emW() {
        int visiableHeight = this.oTh.getVisiableHeight();
        if (visiableHeight != 0) {
            this.mScroller.startScroll(0, visiableHeight, 0, 0, 200);
            this.oTh.setVisiableHeight(0);
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pl(int i) {
        if (this.oTk) {
            switch (i) {
                case 1:
                    this.oTh.setState(1);
                    return;
                case 2:
                    this.oTh.setState(0);
                    return;
                case 3:
                    this.oTh.setState(2);
                    return;
                default:
                    this.oTh.setState(0);
                    return;
            }
        }
    }

    public void setRefreshTime() {
        this.oTh.setRefreshTime();
    }

    public void setFooterHeight(int i) {
        this.oTi.setFooterHeight(i);
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public void setSelection(int i) {
        super.setSelection(i + 1);
    }

    public void setSelectionMove(int i) {
        setSelectionFromTop(i + 2, this.oTh.getVisiableHeight());
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2) {
            this.oTn = true;
            this.oTo = false;
        } else if (i == 1) {
            this.oTn = false;
            this.oTo = true;
        } else {
            this.oTn = false;
            this.oTo = false;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.oTf = i;
        this.oTg = i2;
        this.totalCount = i3;
        if (i == 0 && this.oTk) {
            if (this.oTn) {
                this.mHandler.removeMessages(1);
                this.oTh.setVisiableHeight(0);
                this.oTq = 0.0f;
                this.oTp = 0.0f;
                this.mHandler.sendEmptyMessageDelayed(1, 20L);
                this.oTn = false;
                this.oTo = false;
            }
            if (this.oTo && this.oTs == 2) {
                this.oTs = 1;
            }
        }
    }
}
