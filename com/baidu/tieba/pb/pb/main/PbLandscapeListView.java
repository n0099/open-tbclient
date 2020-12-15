package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes22.dex */
public class PbLandscapeListView extends BdTypeListView {
    private float bDk;
    private float bDl;
    private boolean isLandscape;
    private final int lKA;
    private a lKB;
    private b lKC;
    private boolean lKD;
    private boolean lKE;
    private boolean lKF;
    private Handler mHandler;
    private Handler.Callback mHandlerCallback;

    /* loaded from: classes22.dex */
    public interface a {
        void onLayout();
    }

    /* loaded from: classes22.dex */
    public interface b {
        void b(int i, int i2, float f, float f2, float f3, float f4);
    }

    /* loaded from: classes22.dex */
    public static class c {
        public int lKH;
        public int lKI;
        public float lKJ;
        public float lKK;
        public float startX;
        public float startY;
    }

    public PbLandscapeListView(Context context) {
        super(context);
        this.lKA = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()) / 8;
        this.isLandscape = false;
        this.mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.lKC != null) {
                                PbLandscapeListView.this.lKC.b(cVar.lKH, cVar.lKI, cVar.startX, cVar.lKJ, cVar.startY, cVar.lKK);
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
        this.lKD = false;
        this.lKE = false;
        this.lKF = false;
    }

    public PbLandscapeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lKA = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()) / 8;
        this.isLandscape = false;
        this.mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.lKC != null) {
                                PbLandscapeListView.this.lKC.b(cVar.lKH, cVar.lKI, cVar.startX, cVar.lKJ, cVar.startY, cVar.lKK);
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
        this.lKD = false;
        this.lKE = false;
        this.lKF = false;
    }

    public PbLandscapeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lKA = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()) / 8;
        this.isLandscape = false;
        this.mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.lKC != null) {
                                PbLandscapeListView.this.lKC.b(cVar.lKH, cVar.lKI, cVar.startX, cVar.lKJ, cVar.startY, cVar.lKK);
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
        this.lKD = false;
        this.lKE = false;
        this.lKF = false;
    }

    public void setIsLandscape(boolean z) {
        this.isLandscape = z;
    }

    public void setOnLayoutListener(a aVar) {
        this.lKB = aVar;
    }

    public void setListViewDragListener(b bVar) {
        this.lKC = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bDk = motionEvent.getRawX();
                this.bDl = motionEvent.getRawY();
                this.lKE = false;
                this.lKF = false;
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (!this.lKE && this.lKC != null) {
                    int i = (int) (rawX - this.bDk);
                    int i2 = (int) (rawY - this.bDl);
                    int abs = Math.abs(i);
                    if (abs > this.lKA && abs > Math.abs(i2)) {
                        a(i, i2, this.bDk, this.bDl, rawX, rawY);
                        this.lKF = true;
                        return false;
                    }
                }
                this.bDk = 0.0f;
                this.bDl = 0.0f;
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
        if (this.lKB != null) {
            this.lKB.onLayout();
        }
    }

    private void a(int i, int i2, float f, float f2, float f3, float f4) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            c cVar = new c();
            cVar.lKH = i;
            cVar.lKI = i2;
            cVar.startX = f;
            cVar.startY = f2;
            cVar.lKJ = f3;
            cVar.lKK = f4;
            message.obj = cVar;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void addPullRefreshView(View view) {
        if (this.lKD) {
            getAdapter().addHeaderView(view, null, false, 1);
        } else {
            getAdapter().addHeaderView(view, null, false, 0);
        }
    }

    public void setTextViewAdded(boolean z) {
        this.lKD = z;
    }

    public void setForbidDragListener(boolean z) {
        this.lKE = z;
    }

    public boolean dqc() {
        return this.lKF;
    }
}
