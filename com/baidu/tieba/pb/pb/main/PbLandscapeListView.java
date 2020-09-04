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
    private float bkP;
    private float bkQ;
    private boolean isLandscape;
    private final int kGk;
    private a kGl;
    private b kGm;
    private boolean kGn;
    private boolean kGo;
    private boolean kGp;
    private Handler mHandler;
    private Handler.Callback mHandlerCallback;

    /* loaded from: classes16.dex */
    public interface a {
        void onLayout();
    }

    /* loaded from: classes16.dex */
    public interface b {
        void b(int i, int i2, float f, float f2, float f3, float f4);
    }

    /* loaded from: classes16.dex */
    public static class c {
        public int kGr;
        public int kGs;
        public float kGt;
        public float kGu;
        public float startX;
        public float startY;
    }

    public PbLandscapeListView(Context context) {
        super(context);
        this.kGk = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()) / 8;
        this.isLandscape = false;
        this.mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.kGm != null) {
                                PbLandscapeListView.this.kGm.b(cVar.kGr, cVar.kGs, cVar.startX, cVar.kGt, cVar.startY, cVar.kGu);
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
        this.kGn = false;
        this.kGo = false;
        this.kGp = false;
    }

    public PbLandscapeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kGk = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()) / 8;
        this.isLandscape = false;
        this.mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.kGm != null) {
                                PbLandscapeListView.this.kGm.b(cVar.kGr, cVar.kGs, cVar.startX, cVar.kGt, cVar.startY, cVar.kGu);
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
        this.kGn = false;
        this.kGo = false;
        this.kGp = false;
    }

    public PbLandscapeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kGk = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()) / 8;
        this.isLandscape = false;
        this.mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.kGm != null) {
                                PbLandscapeListView.this.kGm.b(cVar.kGr, cVar.kGs, cVar.startX, cVar.kGt, cVar.startY, cVar.kGu);
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
        this.kGn = false;
        this.kGo = false;
        this.kGp = false;
    }

    public void setIsLandscape(boolean z) {
        this.isLandscape = z;
    }

    public void setOnLayoutListener(a aVar) {
        this.kGl = aVar;
    }

    public void setListViewDragListener(b bVar) {
        this.kGm = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bkP = motionEvent.getRawX();
                this.bkQ = motionEvent.getRawY();
                this.kGo = false;
                this.kGp = false;
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (!this.kGo && this.kGm != null) {
                    int i = (int) (rawX - this.bkP);
                    int i2 = (int) (rawY - this.bkQ);
                    int abs = Math.abs(i);
                    if (abs > this.kGk && abs > Math.abs(i2)) {
                        a(i, i2, this.bkP, this.bkQ, rawX, rawY);
                        this.kGp = true;
                        return false;
                    }
                }
                this.bkP = 0.0f;
                this.bkQ = 0.0f;
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
        if (this.kGl != null) {
            this.kGl.onLayout();
        }
    }

    private void a(int i, int i2, float f, float f2, float f3, float f4) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            c cVar = new c();
            cVar.kGr = i;
            cVar.kGs = i2;
            cVar.startX = f;
            cVar.startY = f2;
            cVar.kGt = f3;
            cVar.kGu = f4;
            message.obj = cVar;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void addPullRefreshView(View view) {
        if (this.kGn) {
            getAdapter().addHeaderView(view, null, false, 1);
        } else {
            getAdapter().addHeaderView(view, null, false, 0);
        }
    }

    public void setTextViewAdded(boolean z) {
        this.kGn = z;
    }

    public void setForbidDragListener(boolean z) {
        this.kGo = z;
    }

    public boolean cYu() {
        return this.kGp;
    }
}
