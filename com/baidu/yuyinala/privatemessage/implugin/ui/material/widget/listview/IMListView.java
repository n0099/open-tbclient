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
    private static int oTc = 60;
    @SuppressLint({"HandlerLeak"})
    private Handler mHandler;
    private Scroller mScroller;
    private int oTd;
    private int oTe;
    private IMChatHeader oTf;
    private IMChatFooter oTg;
    private a oTh;
    private boolean oTi;
    private boolean oTj;
    private boolean oTk;
    private boolean oTl;
    private boolean oTm;
    private float oTn;
    private float oTo;
    private float oTp;
    private int oTq;
    private int totalCount;

    /* loaded from: classes4.dex */
    public interface a {
        void onRefresh();
    }

    public IMListView(Context context) {
        super(context);
        this.oTi = true;
        this.oTk = false;
        this.oTl = false;
        this.oTm = false;
        this.oTq = 2;
        this.mHandler = new Handler() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c.d("", "LOADHAED handleMessage  " + message.what);
                switch (message.what) {
                    case 1:
                        if (IMListView.this.oTn >= IMListView.oTc) {
                            IMListView.this.mHandler.removeMessages(1);
                            IMListView.this.oTo = IMListView.this.oTn;
                            IMListView.this.oTn = 0.0f;
                            IMListView.this.mHandler.sendEmptyMessage(3);
                            break;
                        } else {
                            IMListView.this.oTn = (IMListView.oTc / 10) + IMListView.this.oTn;
                            if (IMListView.this.oTn > IMListView.oTc) {
                                IMListView.this.oTn = IMListView.oTc;
                            }
                            IMListView.this.bm(IMListView.this.oTn);
                            IMListView.this.mHandler.sendEmptyMessageDelayed(1, 20L);
                            break;
                        }
                    case 2:
                        IMListView.this.oTh.onRefresh();
                        IMListView.this.oTq = 2;
                        break;
                    case 3:
                        IMListView.this.mHandler.sendEmptyMessageDelayed(2, 1500L);
                        IMListView.this.oTq = 3;
                        IMListView.this.oTk = true;
                        break;
                    case 4:
                        IMListView.this.oTo = 0.0f;
                        IMListView.this.oTn = 0.0f;
                        IMListView.this.emV();
                        IMListView.this.oTq = 2;
                        break;
                }
                IMListView.this.Pl(message.what);
            }
        };
        hp(context);
    }

    public IMListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oTi = true;
        this.oTk = false;
        this.oTl = false;
        this.oTm = false;
        this.oTq = 2;
        this.mHandler = new Handler() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c.d("", "LOADHAED handleMessage  " + message.what);
                switch (message.what) {
                    case 1:
                        if (IMListView.this.oTn >= IMListView.oTc) {
                            IMListView.this.mHandler.removeMessages(1);
                            IMListView.this.oTo = IMListView.this.oTn;
                            IMListView.this.oTn = 0.0f;
                            IMListView.this.mHandler.sendEmptyMessage(3);
                            break;
                        } else {
                            IMListView.this.oTn = (IMListView.oTc / 10) + IMListView.this.oTn;
                            if (IMListView.this.oTn > IMListView.oTc) {
                                IMListView.this.oTn = IMListView.oTc;
                            }
                            IMListView.this.bm(IMListView.this.oTn);
                            IMListView.this.mHandler.sendEmptyMessageDelayed(1, 20L);
                            break;
                        }
                    case 2:
                        IMListView.this.oTh.onRefresh();
                        IMListView.this.oTq = 2;
                        break;
                    case 3:
                        IMListView.this.mHandler.sendEmptyMessageDelayed(2, 1500L);
                        IMListView.this.oTq = 3;
                        IMListView.this.oTk = true;
                        break;
                    case 4:
                        IMListView.this.oTo = 0.0f;
                        IMListView.this.oTn = 0.0f;
                        IMListView.this.emV();
                        IMListView.this.oTq = 2;
                        break;
                }
                IMListView.this.Pl(message.what);
            }
        };
        hp(context);
    }

    public IMListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oTi = true;
        this.oTk = false;
        this.oTl = false;
        this.oTm = false;
        this.oTq = 2;
        this.mHandler = new Handler() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c.d("", "LOADHAED handleMessage  " + message.what);
                switch (message.what) {
                    case 1:
                        if (IMListView.this.oTn >= IMListView.oTc) {
                            IMListView.this.mHandler.removeMessages(1);
                            IMListView.this.oTo = IMListView.this.oTn;
                            IMListView.this.oTn = 0.0f;
                            IMListView.this.mHandler.sendEmptyMessage(3);
                            break;
                        } else {
                            IMListView.this.oTn = (IMListView.oTc / 10) + IMListView.this.oTn;
                            if (IMListView.this.oTn > IMListView.oTc) {
                                IMListView.this.oTn = IMListView.oTc;
                            }
                            IMListView.this.bm(IMListView.this.oTn);
                            IMListView.this.mHandler.sendEmptyMessageDelayed(1, 20L);
                            break;
                        }
                    case 2:
                        IMListView.this.oTh.onRefresh();
                        IMListView.this.oTq = 2;
                        break;
                    case 3:
                        IMListView.this.mHandler.sendEmptyMessageDelayed(2, 1500L);
                        IMListView.this.oTq = 3;
                        IMListView.this.oTk = true;
                        break;
                    case 4:
                        IMListView.this.oTo = 0.0f;
                        IMListView.this.oTn = 0.0f;
                        IMListView.this.emV();
                        IMListView.this.oTq = 2;
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
        this.oTf = new IMChatHeader(context);
        this.oTg = new IMChatFooter(context);
    }

    public boolean emS() {
        View childAt;
        if (this.totalCount == 0) {
            c.d("", "RECEIVETEST -> return true");
            return true;
        } else if (this.oTd + this.oTe != this.totalCount || (childAt = getChildAt(getChildCount() - 1)) == null || childAt.getBottom() > getHeight()) {
            c.d("", "RECEIVETEST -> return false  " + this.oTd + " " + this.oTe + " " + this.totalCount);
            return false;
        } else {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        addHeaderView(this.oTf);
        addFooterView(this.oTg);
        super.setAdapter(listAdapter);
    }

    public void setPullRefreshEnable(boolean z) {
        this.oTi = z;
        if (!this.oTi) {
            this.oTf.setVisiableContent(4);
        } else {
            this.oTf.setVisiableContent(0);
        }
    }

    public void setIMListViewListener(a aVar) {
        this.oTh = aVar;
    }

    public void emT() {
        if (this.oTk) {
            c.d("", "LOADHAED stopRefresh");
            this.oTk = false;
            emV();
        }
    }

    public void emU() {
        if (this.oTj) {
            this.oTj = false;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        try {
            switch (motionEvent.getAction()) {
                case 1:
                    if (this.oTq == 1 && this.oTn < oTc) {
                        this.mHandler.sendEmptyMessageDelayed(4, 20L);
                        break;
                    }
                    break;
                case 2:
                    int y = (int) motionEvent.getY();
                    if (this.oTq == 1) {
                        if (this.oTp != 0.0f) {
                            this.oTn += y - this.oTp;
                        }
                        if (this.oTn > oTc) {
                            this.oTn = oTc;
                        }
                        if (this.oTn <= 0.0f) {
                            this.oTn = 0.0f;
                        }
                        bm(this.oTn);
                        this.oTp = y;
                        if (this.oTn >= oTc) {
                            this.mHandler.removeMessages(1);
                            this.oTo = this.oTn;
                            this.oTn = 0.0f;
                            c.d("", "LOADHAED onTouchEvent HEAD_REFRESH");
                            this.mHandler.sendEmptyMessage(3);
                            this.oTm = false;
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
        this.oTf.setVisiableHeight(((int) f) + this.oTf.getVisiableHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bm(float f) {
        float f2 = f - this.oTo;
        this.oTo = f;
        if (getFirstVisiblePosition() == 0) {
            if (this.oTf.getVisiableHeight() > 0 || f2 > 0.0f) {
                bl(f2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emV() {
        int visiableHeight = this.oTf.getVisiableHeight();
        if (visiableHeight != 0) {
            this.mScroller.startScroll(0, visiableHeight, 0, 0, 200);
            this.oTf.setVisiableHeight(0);
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pl(int i) {
        if (this.oTi) {
            switch (i) {
                case 1:
                    this.oTf.setState(1);
                    return;
                case 2:
                    this.oTf.setState(0);
                    return;
                case 3:
                    this.oTf.setState(2);
                    return;
                default:
                    this.oTf.setState(0);
                    return;
            }
        }
    }

    public void setRefreshTime() {
        this.oTf.setRefreshTime();
    }

    public void setFooterHeight(int i) {
        this.oTg.setFooterHeight(i);
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public void setSelection(int i) {
        super.setSelection(i + 1);
    }

    public void setSelectionMove(int i) {
        setSelectionFromTop(i + 2, this.oTf.getVisiableHeight());
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2) {
            this.oTl = true;
            this.oTm = false;
        } else if (i == 1) {
            this.oTl = false;
            this.oTm = true;
        } else {
            this.oTl = false;
            this.oTm = false;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.oTd = i;
        this.oTe = i2;
        this.totalCount = i3;
        if (i == 0 && this.oTi) {
            if (this.oTl) {
                this.mHandler.removeMessages(1);
                this.oTf.setVisiableHeight(0);
                this.oTo = 0.0f;
                this.oTn = 0.0f;
                this.mHandler.sendEmptyMessageDelayed(1, 20L);
                this.oTl = false;
                this.oTm = false;
            }
            if (this.oTm && this.oTq == 2) {
                this.oTq = 1;
            }
        }
    }
}
