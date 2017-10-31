package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.widget.ListView.BdTypeListView;
/* loaded from: classes.dex */
public class PbLandscapeListView extends BdTypeListView {
    private Handler.Callback aWm;
    private float chZ;
    private float cia;
    private a eNN;
    private b eNO;
    private boolean isLandscape;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void aSv();
    }

    /* loaded from: classes.dex */
    public interface b {
        void b(int i, int i2, float f, float f2, float f3, float f4);
    }

    /* loaded from: classes.dex */
    public static class c {
        public float GP;
        public float GT;
        public float cdV;
        public float cdW;
        public int eNQ;
        public int eNR;
    }

    public PbLandscapeListView(Context context) {
        super(context);
        this.isLandscape = false;
        this.aWm = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.eNO != null) {
                                PbLandscapeListView.this.eNO.b(cVar.eNQ, cVar.eNR, cVar.GT, cVar.cdV, cVar.GP, cVar.cdW);
                            }
                            return true;
                        default:
                            return false;
                    }
                }
                return false;
            }
        };
        this.mHandler = new Handler(this.aWm);
    }

    public PbLandscapeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isLandscape = false;
        this.aWm = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.eNO != null) {
                                PbLandscapeListView.this.eNO.b(cVar.eNQ, cVar.eNR, cVar.GT, cVar.cdV, cVar.GP, cVar.cdW);
                            }
                            return true;
                        default:
                            return false;
                    }
                }
                return false;
            }
        };
        this.mHandler = new Handler(this.aWm);
    }

    public PbLandscapeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isLandscape = false;
        this.aWm = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.eNO != null) {
                                PbLandscapeListView.this.eNO.b(cVar.eNQ, cVar.eNR, cVar.GT, cVar.cdV, cVar.GP, cVar.cdW);
                            }
                            return true;
                        default:
                            return false;
                    }
                }
                return false;
            }
        };
        this.mHandler = new Handler(this.aWm);
    }

    public void setIsLandscape(boolean z) {
        this.isLandscape = z;
    }

    public void setOnLayoutListener(a aVar) {
        this.eNN = aVar;
    }

    public void setListViewDragListener(b bVar) {
        this.eNO = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.chZ = motionEvent.getRawX();
                this.cia = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (this.eNO != null) {
                    int i = (int) (rawX - this.chZ);
                    int i2 = (int) (rawY - this.cia);
                    int abs = Math.abs(i);
                    if (abs > 20 && abs > Math.abs(i2)) {
                        a(i, i2, this.chZ, this.cia, rawX, rawY);
                        return false;
                    }
                }
                this.chZ = 0.0f;
                this.cia = 0.0f;
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
        if (this.eNN != null) {
            this.eNN.aSv();
        }
    }

    private void a(int i, int i2, float f, float f2, float f3, float f4) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            c cVar = new c();
            cVar.eNQ = i;
            cVar.eNR = i2;
            cVar.GT = f;
            cVar.GP = f2;
            cVar.cdV = f3;
            cVar.cdW = f4;
            message.obj = cVar;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }
}
