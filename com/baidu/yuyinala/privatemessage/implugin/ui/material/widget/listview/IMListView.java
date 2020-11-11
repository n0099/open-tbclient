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
    private static int oCs = 60;
    @SuppressLint({"HandlerLeak"})
    private Handler mHandler;
    private Scroller mScroller;
    private boolean oCA;
    private boolean oCB;
    private boolean oCC;
    private float oCD;
    private float oCE;
    private float oCF;
    private int oCG;
    private int oCt;
    private int oCu;
    private IMChatHeader oCv;
    private IMChatFooter oCw;
    private a oCx;
    private boolean oCy;
    private boolean oCz;
    private int totalCount;

    /* loaded from: classes4.dex */
    public interface a {
        void onRefresh();
    }

    public IMListView(Context context) {
        super(context);
        this.oCy = true;
        this.oCA = false;
        this.oCB = false;
        this.oCC = false;
        this.oCG = 2;
        this.mHandler = new Handler() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c.d("", "LOADHAED handleMessage  " + message.what);
                switch (message.what) {
                    case 1:
                        if (IMListView.this.oCD >= IMListView.oCs) {
                            IMListView.this.mHandler.removeMessages(1);
                            IMListView.this.oCE = IMListView.this.oCD;
                            IMListView.this.oCD = 0.0f;
                            IMListView.this.mHandler.sendEmptyMessage(3);
                            break;
                        } else {
                            IMListView.this.oCD = (IMListView.oCs / 10) + IMListView.this.oCD;
                            if (IMListView.this.oCD > IMListView.oCs) {
                                IMListView.this.oCD = IMListView.oCs;
                            }
                            IMListView.this.be(IMListView.this.oCD);
                            IMListView.this.mHandler.sendEmptyMessageDelayed(1, 20L);
                            break;
                        }
                    case 2:
                        IMListView.this.oCx.onRefresh();
                        IMListView.this.oCG = 2;
                        break;
                    case 3:
                        IMListView.this.mHandler.sendEmptyMessageDelayed(2, 1500L);
                        IMListView.this.oCG = 3;
                        IMListView.this.oCA = true;
                        break;
                    case 4:
                        IMListView.this.oCE = 0.0f;
                        IMListView.this.oCD = 0.0f;
                        IMListView.this.ehj();
                        IMListView.this.oCG = 2;
                        break;
                }
                IMListView.this.NK(message.what);
            }
        };
        gI(context);
    }

    public IMListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oCy = true;
        this.oCA = false;
        this.oCB = false;
        this.oCC = false;
        this.oCG = 2;
        this.mHandler = new Handler() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c.d("", "LOADHAED handleMessage  " + message.what);
                switch (message.what) {
                    case 1:
                        if (IMListView.this.oCD >= IMListView.oCs) {
                            IMListView.this.mHandler.removeMessages(1);
                            IMListView.this.oCE = IMListView.this.oCD;
                            IMListView.this.oCD = 0.0f;
                            IMListView.this.mHandler.sendEmptyMessage(3);
                            break;
                        } else {
                            IMListView.this.oCD = (IMListView.oCs / 10) + IMListView.this.oCD;
                            if (IMListView.this.oCD > IMListView.oCs) {
                                IMListView.this.oCD = IMListView.oCs;
                            }
                            IMListView.this.be(IMListView.this.oCD);
                            IMListView.this.mHandler.sendEmptyMessageDelayed(1, 20L);
                            break;
                        }
                    case 2:
                        IMListView.this.oCx.onRefresh();
                        IMListView.this.oCG = 2;
                        break;
                    case 3:
                        IMListView.this.mHandler.sendEmptyMessageDelayed(2, 1500L);
                        IMListView.this.oCG = 3;
                        IMListView.this.oCA = true;
                        break;
                    case 4:
                        IMListView.this.oCE = 0.0f;
                        IMListView.this.oCD = 0.0f;
                        IMListView.this.ehj();
                        IMListView.this.oCG = 2;
                        break;
                }
                IMListView.this.NK(message.what);
            }
        };
        gI(context);
    }

    public IMListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oCy = true;
        this.oCA = false;
        this.oCB = false;
        this.oCC = false;
        this.oCG = 2;
        this.mHandler = new Handler() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c.d("", "LOADHAED handleMessage  " + message.what);
                switch (message.what) {
                    case 1:
                        if (IMListView.this.oCD >= IMListView.oCs) {
                            IMListView.this.mHandler.removeMessages(1);
                            IMListView.this.oCE = IMListView.this.oCD;
                            IMListView.this.oCD = 0.0f;
                            IMListView.this.mHandler.sendEmptyMessage(3);
                            break;
                        } else {
                            IMListView.this.oCD = (IMListView.oCs / 10) + IMListView.this.oCD;
                            if (IMListView.this.oCD > IMListView.oCs) {
                                IMListView.this.oCD = IMListView.oCs;
                            }
                            IMListView.this.be(IMListView.this.oCD);
                            IMListView.this.mHandler.sendEmptyMessageDelayed(1, 20L);
                            break;
                        }
                    case 2:
                        IMListView.this.oCx.onRefresh();
                        IMListView.this.oCG = 2;
                        break;
                    case 3:
                        IMListView.this.mHandler.sendEmptyMessageDelayed(2, 1500L);
                        IMListView.this.oCG = 3;
                        IMListView.this.oCA = true;
                        break;
                    case 4:
                        IMListView.this.oCE = 0.0f;
                        IMListView.this.oCD = 0.0f;
                        IMListView.this.ehj();
                        IMListView.this.oCG = 2;
                        break;
                }
                IMListView.this.NK(message.what);
            }
        };
        gI(context);
    }

    private void gI(Context context) {
        this.mScroller = new Scroller(context, new DecelerateInterpolator());
        setOnScrollListener(this);
        this.oCv = new IMChatHeader(context);
        this.oCw = new IMChatFooter(context);
    }

    public boolean ehg() {
        View childAt;
        if (this.totalCount == 0) {
            c.d("", "RECEIVETEST -> return true");
            return true;
        } else if (this.oCt + this.oCu != this.totalCount || (childAt = getChildAt(getChildCount() - 1)) == null || childAt.getBottom() > getHeight()) {
            c.d("", "RECEIVETEST -> return false  " + this.oCt + " " + this.oCu + " " + this.totalCount);
            return false;
        } else {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        addHeaderView(this.oCv);
        addFooterView(this.oCw);
        super.setAdapter(listAdapter);
    }

    public void setPullRefreshEnable(boolean z) {
        this.oCy = z;
        if (!this.oCy) {
            this.oCv.setVisiableContent(4);
        } else {
            this.oCv.setVisiableContent(0);
        }
    }

    public void setIMListViewListener(a aVar) {
        this.oCx = aVar;
    }

    public void ehh() {
        if (this.oCA) {
            c.d("", "LOADHAED stopRefresh");
            this.oCA = false;
            ehj();
        }
    }

    public void ehi() {
        if (this.oCz) {
            this.oCz = false;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        try {
            switch (motionEvent.getAction()) {
                case 1:
                    if (this.oCG == 1 && this.oCD < oCs) {
                        this.mHandler.sendEmptyMessageDelayed(4, 20L);
                        break;
                    }
                    break;
                case 2:
                    int y = (int) motionEvent.getY();
                    if (this.oCG == 1) {
                        if (this.oCF != 0.0f) {
                            this.oCD += y - this.oCF;
                        }
                        if (this.oCD > oCs) {
                            this.oCD = oCs;
                        }
                        if (this.oCD <= 0.0f) {
                            this.oCD = 0.0f;
                        }
                        be(this.oCD);
                        this.oCF = y;
                        if (this.oCD >= oCs) {
                            this.mHandler.removeMessages(1);
                            this.oCE = this.oCD;
                            this.oCD = 0.0f;
                            c.d("", "LOADHAED onTouchEvent HEAD_REFRESH");
                            this.mHandler.sendEmptyMessage(3);
                            this.oCC = false;
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

    private void bd(float f) {
        this.oCv.setVisiableHeight(((int) f) + this.oCv.getVisiableHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(float f) {
        float f2 = f - this.oCE;
        this.oCE = f;
        if (getFirstVisiblePosition() == 0) {
            if (this.oCv.getVisiableHeight() > 0 || f2 > 0.0f) {
                bd(f2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ehj() {
        int visiableHeight = this.oCv.getVisiableHeight();
        if (visiableHeight != 0) {
            this.mScroller.startScroll(0, visiableHeight, 0, 0, 200);
            this.oCv.setVisiableHeight(0);
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NK(int i) {
        if (this.oCy) {
            switch (i) {
                case 1:
                    this.oCv.setState(1);
                    return;
                case 2:
                    this.oCv.setState(0);
                    return;
                case 3:
                    this.oCv.setState(2);
                    return;
                default:
                    this.oCv.setState(0);
                    return;
            }
        }
    }

    public void setRefreshTime() {
        this.oCv.setRefreshTime();
    }

    public void setFooterHeight(int i) {
        this.oCw.setFooterHeight(i);
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public void setSelection(int i) {
        super.setSelection(i + 1);
    }

    public void setSelectionMove(int i) {
        setSelectionFromTop(i + 2, this.oCv.getVisiableHeight());
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2) {
            this.oCB = true;
            this.oCC = false;
        } else if (i == 1) {
            this.oCB = false;
            this.oCC = true;
        } else {
            this.oCB = false;
            this.oCC = false;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.oCt = i;
        this.oCu = i2;
        this.totalCount = i3;
        if (i == 0 && this.oCy) {
            if (this.oCB) {
                this.mHandler.removeMessages(1);
                this.oCv.setVisiableHeight(0);
                this.oCE = 0.0f;
                this.oCD = 0.0f;
                this.mHandler.sendEmptyMessageDelayed(1, 20L);
                this.oCB = false;
                this.oCC = false;
            }
            if (this.oCC && this.oCG == 2) {
                this.oCG = 1;
            }
        }
    }
}
