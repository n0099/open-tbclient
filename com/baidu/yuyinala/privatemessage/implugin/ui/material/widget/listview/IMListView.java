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
    private static int oUI = 60;
    @SuppressLint({"HandlerLeak"})
    private Handler mHandler;
    private Scroller mScroller;
    private int oUJ;
    private int oUK;
    private IMChatHeader oUL;
    private IMChatFooter oUM;
    private a oUN;
    private boolean oUO;
    private boolean oUP;
    private boolean oUQ;
    private boolean oUR;
    private boolean oUS;
    private float oUT;
    private float oUU;
    private float oUV;
    private int oUW;
    private int totalCount;

    /* loaded from: classes10.dex */
    public interface a {
        void onRefresh();
    }

    public IMListView(Context context) {
        super(context);
        this.oUO = true;
        this.oUQ = false;
        this.oUR = false;
        this.oUS = false;
        this.oUW = 2;
        this.mHandler = new Handler() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c.d("", "LOADHAED handleMessage  " + message.what);
                switch (message.what) {
                    case 1:
                        if (IMListView.this.oUT >= IMListView.oUI) {
                            IMListView.this.mHandler.removeMessages(1);
                            IMListView.this.oUU = IMListView.this.oUT;
                            IMListView.this.oUT = 0.0f;
                            IMListView.this.mHandler.sendEmptyMessage(3);
                            break;
                        } else {
                            IMListView.this.oUT = (IMListView.oUI / 10) + IMListView.this.oUT;
                            if (IMListView.this.oUT > IMListView.oUI) {
                                IMListView.this.oUT = IMListView.oUI;
                            }
                            IMListView.this.bx(IMListView.this.oUT);
                            IMListView.this.mHandler.sendEmptyMessageDelayed(1, 20L);
                            break;
                        }
                    case 2:
                        IMListView.this.oUN.onRefresh();
                        IMListView.this.oUW = 2;
                        break;
                    case 3:
                        IMListView.this.mHandler.sendEmptyMessageDelayed(2, 1500L);
                        IMListView.this.oUW = 3;
                        IMListView.this.oUQ = true;
                        break;
                    case 4:
                        IMListView.this.oUU = 0.0f;
                        IMListView.this.oUT = 0.0f;
                        IMListView.this.ejf();
                        IMListView.this.oUW = 2;
                        break;
                }
                IMListView.this.Ns(message.what);
            }
        };
        hA(context);
    }

    public IMListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oUO = true;
        this.oUQ = false;
        this.oUR = false;
        this.oUS = false;
        this.oUW = 2;
        this.mHandler = new Handler() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c.d("", "LOADHAED handleMessage  " + message.what);
                switch (message.what) {
                    case 1:
                        if (IMListView.this.oUT >= IMListView.oUI) {
                            IMListView.this.mHandler.removeMessages(1);
                            IMListView.this.oUU = IMListView.this.oUT;
                            IMListView.this.oUT = 0.0f;
                            IMListView.this.mHandler.sendEmptyMessage(3);
                            break;
                        } else {
                            IMListView.this.oUT = (IMListView.oUI / 10) + IMListView.this.oUT;
                            if (IMListView.this.oUT > IMListView.oUI) {
                                IMListView.this.oUT = IMListView.oUI;
                            }
                            IMListView.this.bx(IMListView.this.oUT);
                            IMListView.this.mHandler.sendEmptyMessageDelayed(1, 20L);
                            break;
                        }
                    case 2:
                        IMListView.this.oUN.onRefresh();
                        IMListView.this.oUW = 2;
                        break;
                    case 3:
                        IMListView.this.mHandler.sendEmptyMessageDelayed(2, 1500L);
                        IMListView.this.oUW = 3;
                        IMListView.this.oUQ = true;
                        break;
                    case 4:
                        IMListView.this.oUU = 0.0f;
                        IMListView.this.oUT = 0.0f;
                        IMListView.this.ejf();
                        IMListView.this.oUW = 2;
                        break;
                }
                IMListView.this.Ns(message.what);
            }
        };
        hA(context);
    }

    public IMListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oUO = true;
        this.oUQ = false;
        this.oUR = false;
        this.oUS = false;
        this.oUW = 2;
        this.mHandler = new Handler() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c.d("", "LOADHAED handleMessage  " + message.what);
                switch (message.what) {
                    case 1:
                        if (IMListView.this.oUT >= IMListView.oUI) {
                            IMListView.this.mHandler.removeMessages(1);
                            IMListView.this.oUU = IMListView.this.oUT;
                            IMListView.this.oUT = 0.0f;
                            IMListView.this.mHandler.sendEmptyMessage(3);
                            break;
                        } else {
                            IMListView.this.oUT = (IMListView.oUI / 10) + IMListView.this.oUT;
                            if (IMListView.this.oUT > IMListView.oUI) {
                                IMListView.this.oUT = IMListView.oUI;
                            }
                            IMListView.this.bx(IMListView.this.oUT);
                            IMListView.this.mHandler.sendEmptyMessageDelayed(1, 20L);
                            break;
                        }
                    case 2:
                        IMListView.this.oUN.onRefresh();
                        IMListView.this.oUW = 2;
                        break;
                    case 3:
                        IMListView.this.mHandler.sendEmptyMessageDelayed(2, 1500L);
                        IMListView.this.oUW = 3;
                        IMListView.this.oUQ = true;
                        break;
                    case 4:
                        IMListView.this.oUU = 0.0f;
                        IMListView.this.oUT = 0.0f;
                        IMListView.this.ejf();
                        IMListView.this.oUW = 2;
                        break;
                }
                IMListView.this.Ns(message.what);
            }
        };
        hA(context);
    }

    private void hA(Context context) {
        this.mScroller = new Scroller(context, new DecelerateInterpolator());
        setOnScrollListener(this);
        this.oUL = new IMChatHeader(context);
        this.oUM = new IMChatFooter(context);
    }

    public boolean ejc() {
        View childAt;
        if (this.totalCount == 0) {
            c.d("", "RECEIVETEST -> return true");
            return true;
        } else if (this.oUJ + this.oUK != this.totalCount || (childAt = getChildAt(getChildCount() - 1)) == null || childAt.getBottom() > getHeight()) {
            c.d("", "RECEIVETEST -> return false  " + this.oUJ + " " + this.oUK + " " + this.totalCount);
            return false;
        } else {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        addHeaderView(this.oUL);
        addFooterView(this.oUM);
        super.setAdapter(listAdapter);
    }

    public void setPullRefreshEnable(boolean z) {
        this.oUO = z;
        if (!this.oUO) {
            this.oUL.setVisiableContent(4);
        } else {
            this.oUL.setVisiableContent(0);
        }
    }

    public void setIMListViewListener(a aVar) {
        this.oUN = aVar;
    }

    public void ejd() {
        if (this.oUQ) {
            c.d("", "LOADHAED stopRefresh");
            this.oUQ = false;
            ejf();
        }
    }

    public void eje() {
        if (this.oUP) {
            this.oUP = false;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        try {
            switch (motionEvent.getAction()) {
                case 1:
                    if (this.oUW == 1 && this.oUT < oUI) {
                        this.mHandler.sendEmptyMessageDelayed(4, 20L);
                        break;
                    }
                    break;
                case 2:
                    int y = (int) motionEvent.getY();
                    if (this.oUW == 1) {
                        if (this.oUV != 0.0f) {
                            this.oUT += y - this.oUV;
                        }
                        if (this.oUT > oUI) {
                            this.oUT = oUI;
                        }
                        if (this.oUT <= 0.0f) {
                            this.oUT = 0.0f;
                        }
                        bx(this.oUT);
                        this.oUV = y;
                        if (this.oUT >= oUI) {
                            this.mHandler.removeMessages(1);
                            this.oUU = this.oUT;
                            this.oUT = 0.0f;
                            c.d("", "LOADHAED onTouchEvent HEAD_REFRESH");
                            this.mHandler.sendEmptyMessage(3);
                            this.oUS = false;
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
        this.oUL.setVisiableHeight(((int) f) + this.oUL.getVisiableHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bx(float f) {
        float f2 = f - this.oUU;
        this.oUU = f;
        if (getFirstVisiblePosition() == 0) {
            if (this.oUL.getVisiableHeight() > 0 || f2 > 0.0f) {
                bw(f2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ejf() {
        int visiableHeight = this.oUL.getVisiableHeight();
        if (visiableHeight != 0) {
            this.mScroller.startScroll(0, visiableHeight, 0, 0, 200);
            this.oUL.setVisiableHeight(0);
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ns(int i) {
        if (this.oUO) {
            switch (i) {
                case 1:
                    this.oUL.setState(1);
                    return;
                case 2:
                    this.oUL.setState(0);
                    return;
                case 3:
                    this.oUL.setState(2);
                    return;
                default:
                    this.oUL.setState(0);
                    return;
            }
        }
    }

    public void setRefreshTime() {
        this.oUL.setRefreshTime();
    }

    public void setFooterHeight(int i) {
        this.oUM.setFooterHeight(i);
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public void setSelection(int i) {
        super.setSelection(i + 1);
    }

    public void setSelectionMove(int i) {
        setSelectionFromTop(i + 2, this.oUL.getVisiableHeight());
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2) {
            this.oUR = true;
            this.oUS = false;
        } else if (i == 1) {
            this.oUR = false;
            this.oUS = true;
        } else {
            this.oUR = false;
            this.oUS = false;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.oUJ = i;
        this.oUK = i2;
        this.totalCount = i3;
        if (i == 0 && this.oUO) {
            if (this.oUR) {
                this.mHandler.removeMessages(1);
                this.oUL.setVisiableHeight(0);
                this.oUU = 0.0f;
                this.oUT = 0.0f;
                this.mHandler.sendEmptyMessageDelayed(1, 20L);
                this.oUR = false;
                this.oUS = false;
            }
            if (this.oUS && this.oUW == 2) {
                this.oUW = 1;
            }
        }
    }
}
