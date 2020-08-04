package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes16.dex */
public class PbLandscapeListView extends BdTypeListView {
    private float bfc;
    private float bfd;
    private boolean isLandscape;
    private final int kqL;
    private a kqM;
    private b kqN;
    private boolean kqO;
    private boolean kqP;
    private boolean kqQ;
    private Handler mHandler;
    private Handler.Callback mHandlerCallback;

    /* loaded from: classes16.dex */
    public interface a {
        void cNF();
    }

    /* loaded from: classes16.dex */
    public interface b {
        void b(int i, int i2, float f, float f2, float f3, float f4);
    }

    /* loaded from: classes16.dex */
    public static class c {
        public int kqS;
        public int kqT;
        public float kqU;
        public float kqV;
        public float startX;
        public float startY;
    }

    public PbLandscapeListView(Context context) {
        super(context);
        this.kqL = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()) / 10;
        this.isLandscape = false;
        this.mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.kqN != null) {
                                PbLandscapeListView.this.kqN.b(cVar.kqS, cVar.kqT, cVar.startX, cVar.kqU, cVar.startY, cVar.kqV);
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
        this.kqO = false;
        this.kqP = false;
        this.kqQ = false;
    }

    public PbLandscapeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kqL = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()) / 10;
        this.isLandscape = false;
        this.mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.kqN != null) {
                                PbLandscapeListView.this.kqN.b(cVar.kqS, cVar.kqT, cVar.startX, cVar.kqU, cVar.startY, cVar.kqV);
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
        this.kqO = false;
        this.kqP = false;
        this.kqQ = false;
    }

    public PbLandscapeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kqL = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()) / 10;
        this.isLandscape = false;
        this.mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.kqN != null) {
                                PbLandscapeListView.this.kqN.b(cVar.kqS, cVar.kqT, cVar.startX, cVar.kqU, cVar.startY, cVar.kqV);
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
        this.kqO = false;
        this.kqP = false;
        this.kqQ = false;
    }

    public void setIsLandscape(boolean z) {
        this.isLandscape = z;
    }

    public void setOnLayoutListener(a aVar) {
        this.kqM = aVar;
    }

    public void setListViewDragListener(b bVar) {
        this.kqN = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bfc = motionEvent.getRawX();
                this.bfd = motionEvent.getRawY();
                this.kqP = false;
                this.kqQ = false;
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (!this.kqP && this.kqN != null) {
                    int i = (int) (rawX - this.bfc);
                    int i2 = (int) (rawY - this.bfd);
                    int abs = Math.abs(i);
                    if (abs > this.kqL && abs > Math.abs(i2)) {
                        a(i, i2, this.bfc, this.bfd, rawX, rawY);
                        this.kqQ = true;
                        return false;
                    }
                }
                this.bfc = 0.0f;
                this.bfd = 0.0f;
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
        if (this.kqM != null) {
            this.kqM.cNF();
        }
    }

    private void a(int i, int i2, float f, float f2, float f3, float f4) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            c cVar = new c();
            cVar.kqS = i;
            cVar.kqT = i2;
            cVar.startX = f;
            cVar.startY = f2;
            cVar.kqU = f3;
            cVar.kqV = f4;
            message.obj = cVar;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void addPullRefreshView(View view) {
        if (this.kqO) {
            getAdapter().addHeaderView(view, null, false, 1);
        } else {
            getAdapter().addHeaderView(view, null, false, 0);
        }
    }

    public void setTextViewAdded(boolean z) {
        this.kqO = z;
    }

    public void setForbidDragListener(boolean z) {
        this.kqP = z;
    }

    public boolean cNE() {
        return this.kqQ;
    }
}
