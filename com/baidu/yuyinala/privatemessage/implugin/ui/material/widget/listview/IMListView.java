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
    private static int osZ = 60;
    @SuppressLint({"HandlerLeak"})
    private Handler mHandler;
    private Scroller mScroller;
    private int ota;
    private int otb;
    private IMChatHeader otc;
    private IMChatFooter otd;
    private a ote;
    private boolean otf;
    private boolean otg;
    private boolean oth;
    private boolean oti;
    private boolean otj;
    private float otk;
    private float otl;
    private float otm;
    private int otn;
    private int totalCount;

    /* loaded from: classes4.dex */
    public interface a {
        void onRefresh();
    }

    public IMListView(Context context) {
        super(context);
        this.otf = true;
        this.oth = false;
        this.oti = false;
        this.otj = false;
        this.otn = 2;
        this.mHandler = new Handler() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c.d("", "LOADHAED handleMessage  " + message.what);
                switch (message.what) {
                    case 1:
                        if (IMListView.this.otk >= IMListView.osZ) {
                            IMListView.this.mHandler.removeMessages(1);
                            IMListView.this.otl = IMListView.this.otk;
                            IMListView.this.otk = 0.0f;
                            IMListView.this.mHandler.sendEmptyMessage(3);
                            break;
                        } else {
                            IMListView.this.otk = (IMListView.osZ / 10) + IMListView.this.otk;
                            if (IMListView.this.otk > IMListView.osZ) {
                                IMListView.this.otk = IMListView.osZ;
                            }
                            IMListView.this.bc(IMListView.this.otk);
                            IMListView.this.mHandler.sendEmptyMessageDelayed(1, 20L);
                            break;
                        }
                    case 2:
                        IMListView.this.ote.onRefresh();
                        IMListView.this.otn = 2;
                        break;
                    case 3:
                        IMListView.this.mHandler.sendEmptyMessageDelayed(2, 1500L);
                        IMListView.this.otn = 3;
                        IMListView.this.oth = true;
                        break;
                    case 4:
                        IMListView.this.otl = 0.0f;
                        IMListView.this.otk = 0.0f;
                        IMListView.this.edu();
                        IMListView.this.otn = 2;
                        break;
                }
                IMListView.this.Np(message.what);
            }
        };
        gI(context);
    }

    public IMListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.otf = true;
        this.oth = false;
        this.oti = false;
        this.otj = false;
        this.otn = 2;
        this.mHandler = new Handler() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c.d("", "LOADHAED handleMessage  " + message.what);
                switch (message.what) {
                    case 1:
                        if (IMListView.this.otk >= IMListView.osZ) {
                            IMListView.this.mHandler.removeMessages(1);
                            IMListView.this.otl = IMListView.this.otk;
                            IMListView.this.otk = 0.0f;
                            IMListView.this.mHandler.sendEmptyMessage(3);
                            break;
                        } else {
                            IMListView.this.otk = (IMListView.osZ / 10) + IMListView.this.otk;
                            if (IMListView.this.otk > IMListView.osZ) {
                                IMListView.this.otk = IMListView.osZ;
                            }
                            IMListView.this.bc(IMListView.this.otk);
                            IMListView.this.mHandler.sendEmptyMessageDelayed(1, 20L);
                            break;
                        }
                    case 2:
                        IMListView.this.ote.onRefresh();
                        IMListView.this.otn = 2;
                        break;
                    case 3:
                        IMListView.this.mHandler.sendEmptyMessageDelayed(2, 1500L);
                        IMListView.this.otn = 3;
                        IMListView.this.oth = true;
                        break;
                    case 4:
                        IMListView.this.otl = 0.0f;
                        IMListView.this.otk = 0.0f;
                        IMListView.this.edu();
                        IMListView.this.otn = 2;
                        break;
                }
                IMListView.this.Np(message.what);
            }
        };
        gI(context);
    }

    public IMListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.otf = true;
        this.oth = false;
        this.oti = false;
        this.otj = false;
        this.otn = 2;
        this.mHandler = new Handler() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c.d("", "LOADHAED handleMessage  " + message.what);
                switch (message.what) {
                    case 1:
                        if (IMListView.this.otk >= IMListView.osZ) {
                            IMListView.this.mHandler.removeMessages(1);
                            IMListView.this.otl = IMListView.this.otk;
                            IMListView.this.otk = 0.0f;
                            IMListView.this.mHandler.sendEmptyMessage(3);
                            break;
                        } else {
                            IMListView.this.otk = (IMListView.osZ / 10) + IMListView.this.otk;
                            if (IMListView.this.otk > IMListView.osZ) {
                                IMListView.this.otk = IMListView.osZ;
                            }
                            IMListView.this.bc(IMListView.this.otk);
                            IMListView.this.mHandler.sendEmptyMessageDelayed(1, 20L);
                            break;
                        }
                    case 2:
                        IMListView.this.ote.onRefresh();
                        IMListView.this.otn = 2;
                        break;
                    case 3:
                        IMListView.this.mHandler.sendEmptyMessageDelayed(2, 1500L);
                        IMListView.this.otn = 3;
                        IMListView.this.oth = true;
                        break;
                    case 4:
                        IMListView.this.otl = 0.0f;
                        IMListView.this.otk = 0.0f;
                        IMListView.this.edu();
                        IMListView.this.otn = 2;
                        break;
                }
                IMListView.this.Np(message.what);
            }
        };
        gI(context);
    }

    private void gI(Context context) {
        this.mScroller = new Scroller(context, new DecelerateInterpolator());
        setOnScrollListener(this);
        this.otc = new IMChatHeader(context);
        this.otd = new IMChatFooter(context);
    }

    public boolean edr() {
        View childAt;
        if (this.totalCount == 0) {
            c.d("", "RECEIVETEST -> return true");
            return true;
        } else if (this.ota + this.otb != this.totalCount || (childAt = getChildAt(getChildCount() - 1)) == null || childAt.getBottom() > getHeight()) {
            c.d("", "RECEIVETEST -> return false  " + this.ota + " " + this.otb + " " + this.totalCount);
            return false;
        } else {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        addHeaderView(this.otc);
        addFooterView(this.otd);
        super.setAdapter(listAdapter);
    }

    public void setPullRefreshEnable(boolean z) {
        this.otf = z;
        if (!this.otf) {
            this.otc.setVisiableContent(4);
        } else {
            this.otc.setVisiableContent(0);
        }
    }

    public void setIMListViewListener(a aVar) {
        this.ote = aVar;
    }

    public void eds() {
        if (this.oth) {
            c.d("", "LOADHAED stopRefresh");
            this.oth = false;
            edu();
        }
    }

    public void edt() {
        if (this.otg) {
            this.otg = false;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        try {
            switch (motionEvent.getAction()) {
                case 1:
                    if (this.otn == 1 && this.otk < osZ) {
                        this.mHandler.sendEmptyMessageDelayed(4, 20L);
                        break;
                    }
                    break;
                case 2:
                    int y = (int) motionEvent.getY();
                    if (this.otn == 1) {
                        if (this.otm != 0.0f) {
                            this.otk += y - this.otm;
                        }
                        if (this.otk > osZ) {
                            this.otk = osZ;
                        }
                        if (this.otk <= 0.0f) {
                            this.otk = 0.0f;
                        }
                        bc(this.otk);
                        this.otm = y;
                        if (this.otk >= osZ) {
                            this.mHandler.removeMessages(1);
                            this.otl = this.otk;
                            this.otk = 0.0f;
                            c.d("", "LOADHAED onTouchEvent HEAD_REFRESH");
                            this.mHandler.sendEmptyMessage(3);
                            this.otj = false;
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

    private void bb(float f) {
        this.otc.setVisiableHeight(((int) f) + this.otc.getVisiableHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bc(float f) {
        float f2 = f - this.otl;
        this.otl = f;
        if (getFirstVisiblePosition() == 0) {
            if (this.otc.getVisiableHeight() > 0 || f2 > 0.0f) {
                bb(f2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edu() {
        int visiableHeight = this.otc.getVisiableHeight();
        if (visiableHeight != 0) {
            this.mScroller.startScroll(0, visiableHeight, 0, 0, 200);
            this.otc.setVisiableHeight(0);
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Np(int i) {
        if (this.otf) {
            switch (i) {
                case 1:
                    this.otc.setState(1);
                    return;
                case 2:
                    this.otc.setState(0);
                    return;
                case 3:
                    this.otc.setState(2);
                    return;
                default:
                    this.otc.setState(0);
                    return;
            }
        }
    }

    public void setRefreshTime() {
        this.otc.setRefreshTime();
    }

    public void setFooterHeight(int i) {
        this.otd.setFooterHeight(i);
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public void setSelection(int i) {
        super.setSelection(i + 1);
    }

    public void setSelectionMove(int i) {
        setSelectionFromTop(i + 2, this.otc.getVisiableHeight());
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2) {
            this.oti = true;
            this.otj = false;
        } else if (i == 1) {
            this.oti = false;
            this.otj = true;
        } else {
            this.oti = false;
            this.otj = false;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.ota = i;
        this.otb = i2;
        this.totalCount = i3;
        if (i == 0 && this.otf) {
            if (this.oti) {
                this.mHandler.removeMessages(1);
                this.otc.setVisiableHeight(0);
                this.otl = 0.0f;
                this.otk = 0.0f;
                this.mHandler.sendEmptyMessageDelayed(1, 20L);
                this.oti = false;
                this.otj = false;
            }
            if (this.otj && this.otn == 2) {
                this.otn = 1;
            }
        }
    }
}
