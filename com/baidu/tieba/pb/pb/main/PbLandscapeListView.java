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
    private float bkM;
    private float bkN;
    private boolean isLandscape;
    private final int kGd;
    private a kGe;
    private b kGf;
    private boolean kGg;
    private boolean kGh;
    private boolean kGi;
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
        public int kGk;
        public int kGl;
        public float kGm;
        public float kGn;
        public float startX;
        public float startY;
    }

    public PbLandscapeListView(Context context) {
        super(context);
        this.kGd = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()) / 8;
        this.isLandscape = false;
        this.mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.kGf != null) {
                                PbLandscapeListView.this.kGf.b(cVar.kGk, cVar.kGl, cVar.startX, cVar.kGm, cVar.startY, cVar.kGn);
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
        this.kGg = false;
        this.kGh = false;
        this.kGi = false;
    }

    public PbLandscapeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kGd = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()) / 8;
        this.isLandscape = false;
        this.mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.kGf != null) {
                                PbLandscapeListView.this.kGf.b(cVar.kGk, cVar.kGl, cVar.startX, cVar.kGm, cVar.startY, cVar.kGn);
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
        this.kGg = false;
        this.kGh = false;
        this.kGi = false;
    }

    public PbLandscapeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kGd = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()) / 8;
        this.isLandscape = false;
        this.mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.kGf != null) {
                                PbLandscapeListView.this.kGf.b(cVar.kGk, cVar.kGl, cVar.startX, cVar.kGm, cVar.startY, cVar.kGn);
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
        this.kGg = false;
        this.kGh = false;
        this.kGi = false;
    }

    public void setIsLandscape(boolean z) {
        this.isLandscape = z;
    }

    public void setOnLayoutListener(a aVar) {
        this.kGe = aVar;
    }

    public void setListViewDragListener(b bVar) {
        this.kGf = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bkM = motionEvent.getRawX();
                this.bkN = motionEvent.getRawY();
                this.kGh = false;
                this.kGi = false;
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (!this.kGh && this.kGf != null) {
                    int i = (int) (rawX - this.bkM);
                    int i2 = (int) (rawY - this.bkN);
                    int abs = Math.abs(i);
                    if (abs > this.kGd && abs > Math.abs(i2)) {
                        a(i, i2, this.bkM, this.bkN, rawX, rawY);
                        this.kGi = true;
                        return false;
                    }
                }
                this.bkM = 0.0f;
                this.bkN = 0.0f;
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
        if (this.kGe != null) {
            this.kGe.onLayout();
        }
    }

    private void a(int i, int i2, float f, float f2, float f3, float f4) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            c cVar = new c();
            cVar.kGk = i;
            cVar.kGl = i2;
            cVar.startX = f;
            cVar.startY = f2;
            cVar.kGm = f3;
            cVar.kGn = f4;
            message.obj = cVar;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void addPullRefreshView(View view) {
        if (this.kGg) {
            getAdapter().addHeaderView(view, null, false, 1);
        } else {
            getAdapter().addHeaderView(view, null, false, 0);
        }
    }

    public void setTextViewAdded(boolean z) {
        this.kGg = z;
    }

    public void setForbidDragListener(boolean z) {
        this.kGh = z;
    }

    public boolean cYt() {
        return this.kGi;
    }
}
