package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class PbLandscapeListView extends BdTypeListView {
    private float bHW;
    private float bHX;
    private boolean isLandscape;
    private final int lPP;
    private a lPQ;
    private b lPR;
    private boolean lPS;
    private boolean lPT;
    private boolean lPU;
    private Handler mHandler;
    private Handler.Callback mHandlerCallback;

    /* loaded from: classes2.dex */
    public interface a {
        void onLayout();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void b(int i, int i2, float f, float f2, float f3, float f4);
    }

    /* loaded from: classes2.dex */
    public static class c {
        public float endX;
        public float endY;
        public int lPW;
        public int lPX;
        public float startX;
        public float startY;
    }

    public PbLandscapeListView(Context context) {
        super(context);
        this.lPP = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()) / 8;
        this.isLandscape = false;
        this.mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.lPR != null) {
                                PbLandscapeListView.this.lPR.b(cVar.lPW, cVar.lPX, cVar.startX, cVar.endX, cVar.startY, cVar.endY);
                            }
                            return true;
                        default:
                            return false;
                    }
                }
                return false;
            }
        };
        this.mHandler = new Handler(this.mHandlerCallback);
        this.lPS = false;
        this.lPT = false;
        this.lPU = false;
    }

    public PbLandscapeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lPP = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()) / 8;
        this.isLandscape = false;
        this.mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.lPR != null) {
                                PbLandscapeListView.this.lPR.b(cVar.lPW, cVar.lPX, cVar.startX, cVar.endX, cVar.startY, cVar.endY);
                            }
                            return true;
                        default:
                            return false;
                    }
                }
                return false;
            }
        };
        this.mHandler = new Handler(this.mHandlerCallback);
        this.lPS = false;
        this.lPT = false;
        this.lPU = false;
    }

    public PbLandscapeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lPP = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()) / 8;
        this.isLandscape = false;
        this.mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.lPR != null) {
                                PbLandscapeListView.this.lPR.b(cVar.lPW, cVar.lPX, cVar.startX, cVar.endX, cVar.startY, cVar.endY);
                            }
                            return true;
                        default:
                            return false;
                    }
                }
                return false;
            }
        };
        this.mHandler = new Handler(this.mHandlerCallback);
        this.lPS = false;
        this.lPT = false;
        this.lPU = false;
    }

    public void setIsLandscape(boolean z) {
        this.isLandscape = z;
    }

    public void setOnLayoutListener(a aVar) {
        this.lPQ = aVar;
    }

    public void setListViewDragListener(b bVar) {
        this.lPR = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bHW = motionEvent.getRawX();
                this.bHX = motionEvent.getRawY();
                this.lPT = false;
                this.lPU = false;
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (!this.lPT && this.lPR != null) {
                    int i = (int) (rawX - this.bHW);
                    int i2 = (int) (rawY - this.bHX);
                    int abs = Math.abs(i);
                    if (abs > this.lPP && abs > Math.abs(i2)) {
                        a(i, i2, this.bHW, this.bHX, rawX, rawY);
                        this.lPU = true;
                        return false;
                    }
                }
                this.bHW = 0.0f;
                this.bHX = 0.0f;
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.isLandscape) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.isLandscape) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.lPQ != null) {
            this.lPQ.onLayout();
        }
    }

    private void a(int i, int i2, float f, float f2, float f3, float f4) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            c cVar = new c();
            cVar.lPW = i;
            cVar.lPX = i2;
            cVar.startX = f;
            cVar.startY = f2;
            cVar.endX = f3;
            cVar.endY = f4;
            message.obj = cVar;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void addPullRefreshView(View view) {
        if (this.lPS) {
            getAdapter().addHeaderView(view, null, false, 1);
        } else {
            getAdapter().addHeaderView(view, null, false, 0);
        }
    }

    public void setTextViewAdded(boolean z) {
        this.lPS = z;
    }

    public void setForbidDragListener(boolean z) {
        this.lPT = z;
    }

    public boolean dpO() {
        return this.lPU;
    }
}
