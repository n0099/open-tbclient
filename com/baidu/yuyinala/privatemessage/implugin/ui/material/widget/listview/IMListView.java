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
    private static int oDW = 60;
    @SuppressLint({"HandlerLeak"})
    private Handler mHandler;
    private Scroller mScroller;
    private int oDX;
    private int oDY;
    private IMChatHeader oDZ;
    private IMChatFooter oEa;
    private a oEb;
    private boolean oEc;
    private boolean oEd;
    private boolean oEe;
    private boolean oEf;
    private boolean oEg;
    private float oEh;
    private float oEi;
    private float oEj;
    private int oEk;
    private int totalCount;

    /* loaded from: classes4.dex */
    public interface a {
        void onRefresh();
    }

    public IMListView(Context context) {
        super(context);
        this.oEc = true;
        this.oEe = false;
        this.oEf = false;
        this.oEg = false;
        this.oEk = 2;
        this.mHandler = new Handler() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c.d("", "LOADHAED handleMessage  " + message.what);
                switch (message.what) {
                    case 1:
                        if (IMListView.this.oEh >= IMListView.oDW) {
                            IMListView.this.mHandler.removeMessages(1);
                            IMListView.this.oEi = IMListView.this.oEh;
                            IMListView.this.oEh = 0.0f;
                            IMListView.this.mHandler.sendEmptyMessage(3);
                            break;
                        } else {
                            IMListView.this.oEh = (IMListView.oDW / 10) + IMListView.this.oEh;
                            if (IMListView.this.oEh > IMListView.oDW) {
                                IMListView.this.oEh = IMListView.oDW;
                            }
                            IMListView.this.bl(IMListView.this.oEh);
                            IMListView.this.mHandler.sendEmptyMessageDelayed(1, 20L);
                            break;
                        }
                    case 2:
                        IMListView.this.oEb.onRefresh();
                        IMListView.this.oEk = 2;
                        break;
                    case 3:
                        IMListView.this.mHandler.sendEmptyMessageDelayed(2, 1500L);
                        IMListView.this.oEk = 3;
                        IMListView.this.oEe = true;
                        break;
                    case 4:
                        IMListView.this.oEi = 0.0f;
                        IMListView.this.oEh = 0.0f;
                        IMListView.this.ehh();
                        IMListView.this.oEk = 2;
                        break;
                }
                IMListView.this.On(message.what);
            }
        };
        gG(context);
    }

    public IMListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oEc = true;
        this.oEe = false;
        this.oEf = false;
        this.oEg = false;
        this.oEk = 2;
        this.mHandler = new Handler() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c.d("", "LOADHAED handleMessage  " + message.what);
                switch (message.what) {
                    case 1:
                        if (IMListView.this.oEh >= IMListView.oDW) {
                            IMListView.this.mHandler.removeMessages(1);
                            IMListView.this.oEi = IMListView.this.oEh;
                            IMListView.this.oEh = 0.0f;
                            IMListView.this.mHandler.sendEmptyMessage(3);
                            break;
                        } else {
                            IMListView.this.oEh = (IMListView.oDW / 10) + IMListView.this.oEh;
                            if (IMListView.this.oEh > IMListView.oDW) {
                                IMListView.this.oEh = IMListView.oDW;
                            }
                            IMListView.this.bl(IMListView.this.oEh);
                            IMListView.this.mHandler.sendEmptyMessageDelayed(1, 20L);
                            break;
                        }
                    case 2:
                        IMListView.this.oEb.onRefresh();
                        IMListView.this.oEk = 2;
                        break;
                    case 3:
                        IMListView.this.mHandler.sendEmptyMessageDelayed(2, 1500L);
                        IMListView.this.oEk = 3;
                        IMListView.this.oEe = true;
                        break;
                    case 4:
                        IMListView.this.oEi = 0.0f;
                        IMListView.this.oEh = 0.0f;
                        IMListView.this.ehh();
                        IMListView.this.oEk = 2;
                        break;
                }
                IMListView.this.On(message.what);
            }
        };
        gG(context);
    }

    public IMListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oEc = true;
        this.oEe = false;
        this.oEf = false;
        this.oEg = false;
        this.oEk = 2;
        this.mHandler = new Handler() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c.d("", "LOADHAED handleMessage  " + message.what);
                switch (message.what) {
                    case 1:
                        if (IMListView.this.oEh >= IMListView.oDW) {
                            IMListView.this.mHandler.removeMessages(1);
                            IMListView.this.oEi = IMListView.this.oEh;
                            IMListView.this.oEh = 0.0f;
                            IMListView.this.mHandler.sendEmptyMessage(3);
                            break;
                        } else {
                            IMListView.this.oEh = (IMListView.oDW / 10) + IMListView.this.oEh;
                            if (IMListView.this.oEh > IMListView.oDW) {
                                IMListView.this.oEh = IMListView.oDW;
                            }
                            IMListView.this.bl(IMListView.this.oEh);
                            IMListView.this.mHandler.sendEmptyMessageDelayed(1, 20L);
                            break;
                        }
                    case 2:
                        IMListView.this.oEb.onRefresh();
                        IMListView.this.oEk = 2;
                        break;
                    case 3:
                        IMListView.this.mHandler.sendEmptyMessageDelayed(2, 1500L);
                        IMListView.this.oEk = 3;
                        IMListView.this.oEe = true;
                        break;
                    case 4:
                        IMListView.this.oEi = 0.0f;
                        IMListView.this.oEh = 0.0f;
                        IMListView.this.ehh();
                        IMListView.this.oEk = 2;
                        break;
                }
                IMListView.this.On(message.what);
            }
        };
        gG(context);
    }

    private void gG(Context context) {
        this.mScroller = new Scroller(context, new DecelerateInterpolator());
        setOnScrollListener(this);
        this.oDZ = new IMChatHeader(context);
        this.oEa = new IMChatFooter(context);
    }

    public boolean ehe() {
        View childAt;
        if (this.totalCount == 0) {
            c.d("", "RECEIVETEST -> return true");
            return true;
        } else if (this.oDX + this.oDY != this.totalCount || (childAt = getChildAt(getChildCount() - 1)) == null || childAt.getBottom() > getHeight()) {
            c.d("", "RECEIVETEST -> return false  " + this.oDX + " " + this.oDY + " " + this.totalCount);
            return false;
        } else {
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        addHeaderView(this.oDZ);
        addFooterView(this.oEa);
        super.setAdapter(listAdapter);
    }

    public void setPullRefreshEnable(boolean z) {
        this.oEc = z;
        if (!this.oEc) {
            this.oDZ.setVisiableContent(4);
        } else {
            this.oDZ.setVisiableContent(0);
        }
    }

    public void setIMListViewListener(a aVar) {
        this.oEb = aVar;
    }

    public void ehf() {
        if (this.oEe) {
            c.d("", "LOADHAED stopRefresh");
            this.oEe = false;
            ehh();
        }
    }

    public void ehg() {
        if (this.oEd) {
            this.oEd = false;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        try {
            switch (motionEvent.getAction()) {
                case 1:
                    if (this.oEk == 1 && this.oEh < oDW) {
                        this.mHandler.sendEmptyMessageDelayed(4, 20L);
                        break;
                    }
                    break;
                case 2:
                    int y = (int) motionEvent.getY();
                    if (this.oEk == 1) {
                        if (this.oEj != 0.0f) {
                            this.oEh += y - this.oEj;
                        }
                        if (this.oEh > oDW) {
                            this.oEh = oDW;
                        }
                        if (this.oEh <= 0.0f) {
                            this.oEh = 0.0f;
                        }
                        bl(this.oEh);
                        this.oEj = y;
                        if (this.oEh >= oDW) {
                            this.mHandler.removeMessages(1);
                            this.oEi = this.oEh;
                            this.oEh = 0.0f;
                            c.d("", "LOADHAED onTouchEvent HEAD_REFRESH");
                            this.mHandler.sendEmptyMessage(3);
                            this.oEg = false;
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

    private void bk(float f) {
        this.oDZ.setVisiableHeight(((int) f) + this.oDZ.getVisiableHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bl(float f) {
        float f2 = f - this.oEi;
        this.oEi = f;
        if (getFirstVisiblePosition() == 0) {
            if (this.oDZ.getVisiableHeight() > 0 || f2 > 0.0f) {
                bk(f2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ehh() {
        int visiableHeight = this.oDZ.getVisiableHeight();
        if (visiableHeight != 0) {
            this.mScroller.startScroll(0, visiableHeight, 0, 0, 200);
            this.oDZ.setVisiableHeight(0);
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void On(int i) {
        if (this.oEc) {
            switch (i) {
                case 1:
                    this.oDZ.setState(1);
                    return;
                case 2:
                    this.oDZ.setState(0);
                    return;
                case 3:
                    this.oDZ.setState(2);
                    return;
                default:
                    this.oDZ.setState(0);
                    return;
            }
        }
    }

    public void setRefreshTime() {
        this.oDZ.setRefreshTime();
    }

    public void setFooterHeight(int i) {
        this.oEa.setFooterHeight(i);
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public void setSelection(int i) {
        super.setSelection(i + 1);
    }

    public void setSelectionMove(int i) {
        setSelectionFromTop(i + 2, this.oDZ.getVisiableHeight());
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2) {
            this.oEf = true;
            this.oEg = false;
        } else if (i == 1) {
            this.oEf = false;
            this.oEg = true;
        } else {
            this.oEf = false;
            this.oEg = false;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.oDX = i;
        this.oDY = i2;
        this.totalCount = i3;
        if (i == 0 && this.oEc) {
            if (this.oEf) {
                this.mHandler.removeMessages(1);
                this.oDZ.setVisiableHeight(0);
                this.oEi = 0.0f;
                this.oEh = 0.0f;
                this.mHandler.sendEmptyMessageDelayed(1, 20L);
                this.oEf = false;
                this.oEg = false;
            }
            if (this.oEg && this.oEk == 2) {
                this.oEk = 1;
            }
        }
    }
}
