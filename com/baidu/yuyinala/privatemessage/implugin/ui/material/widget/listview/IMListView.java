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
    private static int oUH = 60;
    @SuppressLint({"HandlerLeak"})
    private Handler mHandler;
    private Scroller mScroller;
    private int oUI;
    private int oUJ;
    private IMChatHeader oUK;
    private IMChatFooter oUL;
    private a oUM;
    private boolean oUN;
    private boolean oUO;
    private boolean oUP;
    private boolean oUQ;
    private boolean oUR;
    private float oUS;
    private float oUT;
    private float oUU;
    private int oUV;
    private int totalCount;

    /* loaded from: classes10.dex */
    public interface a {
        void onRefresh();
    }

    public IMListView(Context context) {
        super(context);
        this.oUN = true;
        this.oUP = false;
        this.oUQ = false;
        this.oUR = false;
        this.oUV = 2;
        this.mHandler = new Handler() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c.d("", "LOADHAED handleMessage  " + message.what);
                switch (message.what) {
                    case 1:
                        if (IMListView.this.oUS >= IMListView.oUH) {
                            IMListView.this.mHandler.removeMessages(1);
                            IMListView.this.oUT = IMListView.this.oUS;
                            IMListView.this.oUS = 0.0f;
                            IMListView.this.mHandler.sendEmptyMessage(3);
                            break;
                        } else {
                            IMListView.this.oUS = (IMListView.oUH / 10) + IMListView.this.oUS;
                            if (IMListView.this.oUS > IMListView.oUH) {
                                IMListView.this.oUS = IMListView.oUH;
                            }
                            IMListView.this.bx(IMListView.this.oUS);
                            IMListView.this.mHandler.sendEmptyMessageDelayed(1, 20L);
                            break;
                        }
                    case 2:
                        IMListView.this.oUM.onRefresh();
                        IMListView.this.oUV = 2;
                        break;
                    case 3:
                        IMListView.this.mHandler.sendEmptyMessageDelayed(2, 1500L);
                        IMListView.this.oUV = 3;
                        IMListView.this.oUP = true;
                        break;
                    case 4:
                        IMListView.this.oUT = 0.0f;
                        IMListView.this.oUS = 0.0f;
                        IMListView.this.ejf();
                        IMListView.this.oUV = 2;
                        break;
                }
                IMListView.this.Ns(message.what);
            }
        };
        hA(context);
    }

    public IMListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oUN = true;
        this.oUP = false;
        this.oUQ = false;
        this.oUR = false;
        this.oUV = 2;
        this.mHandler = new Handler() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c.d("", "LOADHAED handleMessage  " + message.what);
                switch (message.what) {
                    case 1:
                        if (IMListView.this.oUS >= IMListView.oUH) {
                            IMListView.this.mHandler.removeMessages(1);
                            IMListView.this.oUT = IMListView.this.oUS;
                            IMListView.this.oUS = 0.0f;
                            IMListView.this.mHandler.sendEmptyMessage(3);
                            break;
                        } else {
                            IMListView.this.oUS = (IMListView.oUH / 10) + IMListView.this.oUS;
                            if (IMListView.this.oUS > IMListView.oUH) {
                                IMListView.this.oUS = IMListView.oUH;
                            }
                            IMListView.this.bx(IMListView.this.oUS);
                            IMListView.this.mHandler.sendEmptyMessageDelayed(1, 20L);
                            break;
                        }
                    case 2:
                        IMListView.this.oUM.onRefresh();
                        IMListView.this.oUV = 2;
                        break;
                    case 3:
                        IMListView.this.mHandler.sendEmptyMessageDelayed(2, 1500L);
                        IMListView.this.oUV = 3;
                        IMListView.this.oUP = true;
                        break;
                    case 4:
                        IMListView.this.oUT = 0.0f;
                        IMListView.this.oUS = 0.0f;
                        IMListView.this.ejf();
                        IMListView.this.oUV = 2;
                        break;
                }
                IMListView.this.Ns(message.what);
            }
        };
        hA(context);
    }

    public IMListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oUN = true;
        this.oUP = false;
        this.oUQ = false;
        this.oUR = false;
        this.oUV = 2;
        this.mHandler = new Handler() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c.d("", "LOADHAED handleMessage  " + message.what);
                switch (message.what) {
                    case 1:
                        if (IMListView.this.oUS >= IMListView.oUH) {
                            IMListView.this.mHandler.removeMessages(1);
                            IMListView.this.oUT = IMListView.this.oUS;
                            IMListView.this.oUS = 0.0f;
                            IMListView.this.mHandler.sendEmptyMessage(3);
                            break;
                        } else {
                            IMListView.this.oUS = (IMListView.oUH / 10) + IMListView.this.oUS;
                            if (IMListView.this.oUS > IMListView.oUH) {
                                IMListView.this.oUS = IMListView.oUH;
                            }
                            IMListView.this.bx(IMListView.this.oUS);
                            IMListView.this.mHandler.sendEmptyMessageDelayed(1, 20L);
                            break;
                        }
                    case 2:
                        IMListView.this.oUM.onRefresh();
                        IMListView.this.oUV = 2;
                        break;
                    case 3:
                        IMListView.this.mHandler.sendEmptyMessageDelayed(2, 1500L);
                        IMListView.this.oUV = 3;
                        IMListView.this.oUP = true;
                        break;
                    case 4:
                        IMListView.this.oUT = 0.0f;
                        IMListView.this.oUS = 0.0f;
                        IMListView.this.ejf();
                        IMListView.this.oUV = 2;
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
        this.oUK = new IMChatHeader(context);
        this.oUL = new IMChatFooter(context);
    }

    public boolean ejc() {
        View childAt;
        if (this.totalCount == 0) {
            c.d("", "RECEIVETEST -> return true");
            return true;
        } else if (this.oUI + this.oUJ != this.totalCount || (childAt = getChildAt(getChildCount() - 1)) == null || childAt.getBottom() > getHeight()) {
            c.d("", "RECEIVETEST -> return false  " + this.oUI + " " + this.oUJ + " " + this.totalCount);
            return false;
        } else {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        addHeaderView(this.oUK);
        addFooterView(this.oUL);
        super.setAdapter(listAdapter);
    }

    public void setPullRefreshEnable(boolean z) {
        this.oUN = z;
        if (!this.oUN) {
            this.oUK.setVisiableContent(4);
        } else {
            this.oUK.setVisiableContent(0);
        }
    }

    public void setIMListViewListener(a aVar) {
        this.oUM = aVar;
    }

    public void ejd() {
        if (this.oUP) {
            c.d("", "LOADHAED stopRefresh");
            this.oUP = false;
            ejf();
        }
    }

    public void eje() {
        if (this.oUO) {
            this.oUO = false;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        try {
            switch (motionEvent.getAction()) {
                case 1:
                    if (this.oUV == 1 && this.oUS < oUH) {
                        this.mHandler.sendEmptyMessageDelayed(4, 20L);
                        break;
                    }
                    break;
                case 2:
                    int y = (int) motionEvent.getY();
                    if (this.oUV == 1) {
                        if (this.oUU != 0.0f) {
                            this.oUS += y - this.oUU;
                        }
                        if (this.oUS > oUH) {
                            this.oUS = oUH;
                        }
                        if (this.oUS <= 0.0f) {
                            this.oUS = 0.0f;
                        }
                        bx(this.oUS);
                        this.oUU = y;
                        if (this.oUS >= oUH) {
                            this.mHandler.removeMessages(1);
                            this.oUT = this.oUS;
                            this.oUS = 0.0f;
                            c.d("", "LOADHAED onTouchEvent HEAD_REFRESH");
                            this.mHandler.sendEmptyMessage(3);
                            this.oUR = false;
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
        this.oUK.setVisiableHeight(((int) f) + this.oUK.getVisiableHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bx(float f) {
        float f2 = f - this.oUT;
        this.oUT = f;
        if (getFirstVisiblePosition() == 0) {
            if (this.oUK.getVisiableHeight() > 0 || f2 > 0.0f) {
                bw(f2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ejf() {
        int visiableHeight = this.oUK.getVisiableHeight();
        if (visiableHeight != 0) {
            this.mScroller.startScroll(0, visiableHeight, 0, 0, 200);
            this.oUK.setVisiableHeight(0);
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ns(int i) {
        if (this.oUN) {
            switch (i) {
                case 1:
                    this.oUK.setState(1);
                    return;
                case 2:
                    this.oUK.setState(0);
                    return;
                case 3:
                    this.oUK.setState(2);
                    return;
                default:
                    this.oUK.setState(0);
                    return;
            }
        }
    }

    public void setRefreshTime() {
        this.oUK.setRefreshTime();
    }

    public void setFooterHeight(int i) {
        this.oUL.setFooterHeight(i);
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public void setSelection(int i) {
        super.setSelection(i + 1);
    }

    public void setSelectionMove(int i) {
        setSelectionFromTop(i + 2, this.oUK.getVisiableHeight());
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2) {
            this.oUQ = true;
            this.oUR = false;
        } else if (i == 1) {
            this.oUQ = false;
            this.oUR = true;
        } else {
            this.oUQ = false;
            this.oUR = false;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.oUI = i;
        this.oUJ = i2;
        this.totalCount = i3;
        if (i == 0 && this.oUN) {
            if (this.oUQ) {
                this.mHandler.removeMessages(1);
                this.oUK.setVisiableHeight(0);
                this.oUT = 0.0f;
                this.oUS = 0.0f;
                this.mHandler.sendEmptyMessageDelayed(1, 20L);
                this.oUQ = false;
                this.oUR = false;
            }
            if (this.oUR && this.oUV == 2) {
                this.oUV = 1;
            }
        }
    }
}
