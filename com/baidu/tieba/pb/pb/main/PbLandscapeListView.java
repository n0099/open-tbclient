package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes21.dex */
public class PbLandscapeListView extends BdTypeListView {
    private float bnI;
    private float bnJ;
    private boolean isLandscape;
    private final int kOJ;
    private a kOK;
    private b kOL;
    private boolean kOM;
    private boolean kON;
    private boolean kOO;
    private Handler mHandler;
    private Handler.Callback mHandlerCallback;

    /* loaded from: classes21.dex */
    public interface a {
        void onLayout();
    }

    /* loaded from: classes21.dex */
    public interface b {
        void b(int i, int i2, float f, float f2, float f3, float f4);
    }

    /* loaded from: classes21.dex */
    public static class c {
        public int kOQ;
        public int kOR;
        public float kOS;
        public float kOT;
        public float startX;
        public float startY;
    }

    public PbLandscapeListView(Context context) {
        super(context);
        this.kOJ = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()) / 8;
        this.isLandscape = false;
        this.mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.kOL != null) {
                                PbLandscapeListView.this.kOL.b(cVar.kOQ, cVar.kOR, cVar.startX, cVar.kOS, cVar.startY, cVar.kOT);
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
        this.kOM = false;
        this.kON = false;
        this.kOO = false;
    }

    public PbLandscapeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kOJ = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()) / 8;
        this.isLandscape = false;
        this.mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.kOL != null) {
                                PbLandscapeListView.this.kOL.b(cVar.kOQ, cVar.kOR, cVar.startX, cVar.kOS, cVar.startY, cVar.kOT);
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
        this.kOM = false;
        this.kON = false;
        this.kOO = false;
    }

    public PbLandscapeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kOJ = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()) / 8;
        this.isLandscape = false;
        this.mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.kOL != null) {
                                PbLandscapeListView.this.kOL.b(cVar.kOQ, cVar.kOR, cVar.startX, cVar.kOS, cVar.startY, cVar.kOT);
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
        this.kOM = false;
        this.kON = false;
        this.kOO = false;
    }

    public void setIsLandscape(boolean z) {
        this.isLandscape = z;
    }

    public void setOnLayoutListener(a aVar) {
        this.kOK = aVar;
    }

    public void setListViewDragListener(b bVar) {
        this.kOL = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bnI = motionEvent.getRawX();
                this.bnJ = motionEvent.getRawY();
                this.kON = false;
                this.kOO = false;
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (!this.kON && this.kOL != null) {
                    int i = (int) (rawX - this.bnI);
                    int i2 = (int) (rawY - this.bnJ);
                    int abs = Math.abs(i);
                    if (abs > this.kOJ && abs > Math.abs(i2)) {
                        a(i, i2, this.bnI, this.bnJ, rawX, rawY);
                        this.kOO = true;
                        return false;
                    }
                }
                this.bnI = 0.0f;
                this.bnJ = 0.0f;
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
        if (this.kOK != null) {
            this.kOK.onLayout();
        }
    }

    private void a(int i, int i2, float f, float f2, float f3, float f4) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            c cVar = new c();
            cVar.kOQ = i;
            cVar.kOR = i2;
            cVar.startX = f;
            cVar.startY = f2;
            cVar.kOS = f3;
            cVar.kOT = f4;
            message.obj = cVar;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void addPullRefreshView(View view) {
        if (this.kOM) {
            getAdapter().addHeaderView(view, null, false, 1);
        } else {
            getAdapter().addHeaderView(view, null, false, 0);
        }
    }

    public void setTextViewAdded(boolean z) {
        this.kOM = z;
    }

    public void setForbidDragListener(boolean z) {
        this.kON = z;
    }

    public boolean dbX() {
        return this.kOO;
    }
}
