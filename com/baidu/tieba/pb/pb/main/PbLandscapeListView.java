package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes9.dex */
public class PbLandscapeListView extends BdTypeListView {
    private float aSn;
    private float aSo;
    private boolean isLandscape;
    private final int jvM;
    private a jvN;
    private b jvO;
    private boolean jvP;
    private Handler mHandler;
    private Handler.Callback mHandlerCallback;

    /* loaded from: classes9.dex */
    public interface a {
        void cys();
    }

    /* loaded from: classes9.dex */
    public interface b {
        void b(int i, int i2, float f, float f2, float f3, float f4);
    }

    /* loaded from: classes9.dex */
    public static class c {
        public int jvR;
        public int jvS;
        public float jvT;
        public float jvU;
        public float startX;
        public float startY;
    }

    public PbLandscapeListView(Context context) {
        super(context);
        this.jvM = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()) / 3;
        this.isLandscape = false;
        this.mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.jvO != null) {
                                PbLandscapeListView.this.jvO.b(cVar.jvR, cVar.jvS, cVar.startX, cVar.jvT, cVar.startY, cVar.jvU);
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
        this.jvP = false;
    }

    public PbLandscapeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jvM = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()) / 3;
        this.isLandscape = false;
        this.mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.jvO != null) {
                                PbLandscapeListView.this.jvO.b(cVar.jvR, cVar.jvS, cVar.startX, cVar.jvT, cVar.startY, cVar.jvU);
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
        this.jvP = false;
    }

    public PbLandscapeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jvM = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()) / 3;
        this.isLandscape = false;
        this.mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.jvO != null) {
                                PbLandscapeListView.this.jvO.b(cVar.jvR, cVar.jvS, cVar.startX, cVar.jvT, cVar.startY, cVar.jvU);
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
        this.jvP = false;
    }

    public void setIsLandscape(boolean z) {
        this.isLandscape = z;
    }

    public void setOnLayoutListener(a aVar) {
        this.jvN = aVar;
    }

    public void setListViewDragListener(b bVar) {
        this.jvO = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.aSn = motionEvent.getRawX();
                this.aSo = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (this.jvO != null) {
                    int i = (int) (rawX - this.aSn);
                    int i2 = (int) (rawY - this.aSo);
                    int abs = Math.abs(i);
                    if (abs > this.jvM && abs > Math.abs(i2)) {
                        a(i, i2, this.aSn, this.aSo, rawX, rawY);
                        return false;
                    }
                }
                this.aSn = 0.0f;
                this.aSo = 0.0f;
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
        if (this.jvN != null) {
            this.jvN.cys();
        }
    }

    private void a(int i, int i2, float f, float f2, float f3, float f4) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            c cVar = new c();
            cVar.jvR = i;
            cVar.jvS = i2;
            cVar.startX = f;
            cVar.startY = f2;
            cVar.jvT = f3;
            cVar.jvU = f4;
            message.obj = cVar;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void addPullRefreshView(View view) {
        if (this.jvP) {
            getAdapter().addHeaderView(view, null, false, 1);
        } else {
            getAdapter().addHeaderView(view, null, false, 0);
        }
    }

    public void setTextViewAdded(boolean z) {
        this.jvP = z;
    }
}
