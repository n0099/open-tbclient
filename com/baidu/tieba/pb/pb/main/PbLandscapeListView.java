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
    private float bGU;
    private float bGV;
    private boolean isLandscape;
    private boolean lUA;
    private final int lUv;
    private a lUw;
    private b lUx;
    private boolean lUy;
    private boolean lUz;
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
        public int lUC;
        public int lUD;
        public float startX;
        public float startY;
    }

    public PbLandscapeListView(Context context) {
        super(context);
        this.lUv = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()) / 8;
        this.isLandscape = false;
        this.mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.lUx != null) {
                                PbLandscapeListView.this.lUx.b(cVar.lUC, cVar.lUD, cVar.startX, cVar.endX, cVar.startY, cVar.endY);
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
        this.lUy = false;
        this.lUz = false;
        this.lUA = false;
    }

    public PbLandscapeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lUv = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()) / 8;
        this.isLandscape = false;
        this.mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.lUx != null) {
                                PbLandscapeListView.this.lUx.b(cVar.lUC, cVar.lUD, cVar.startX, cVar.endX, cVar.startY, cVar.endY);
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
        this.lUy = false;
        this.lUz = false;
        this.lUA = false;
    }

    public PbLandscapeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lUv = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()) / 8;
        this.isLandscape = false;
        this.mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.lUx != null) {
                                PbLandscapeListView.this.lUx.b(cVar.lUC, cVar.lUD, cVar.startX, cVar.endX, cVar.startY, cVar.endY);
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
        this.lUy = false;
        this.lUz = false;
        this.lUA = false;
    }

    public void setIsLandscape(boolean z) {
        this.isLandscape = z;
    }

    public void setOnLayoutListener(a aVar) {
        this.lUw = aVar;
    }

    public void setListViewDragListener(b bVar) {
        this.lUx = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bGU = motionEvent.getRawX();
                this.bGV = motionEvent.getRawY();
                this.lUz = false;
                this.lUA = false;
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (!this.lUz && this.lUx != null) {
                    int i = (int) (rawX - this.bGU);
                    int i2 = (int) (rawY - this.bGV);
                    int abs = Math.abs(i);
                    if (abs > this.lUv && abs > Math.abs(i2)) {
                        a(i, i2, this.bGU, this.bGV, rawX, rawY);
                        this.lUA = true;
                        return false;
                    }
                }
                this.bGU = 0.0f;
                this.bGV = 0.0f;
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
        if (this.lUw != null) {
            this.lUw.onLayout();
        }
    }

    private void a(int i, int i2, float f, float f2, float f3, float f4) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            c cVar = new c();
            cVar.lUC = i;
            cVar.lUD = i2;
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
        if (this.lUy) {
            getAdapter().addHeaderView(view, null, false, 1);
        } else {
            getAdapter().addHeaderView(view, null, false, 0);
        }
    }

    public void setTextViewAdded(boolean z) {
        this.lUy = z;
    }

    public void setForbidDragListener(boolean z) {
        this.lUz = z;
    }

    public boolean dos() {
        return this.lUA;
    }
}
