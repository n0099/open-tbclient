package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.widget.ListView.BdTypeListView;
/* loaded from: classes.dex */
public class PbLandscapeListView extends BdTypeListView {
    private Handler.Callback aWa;
    private float cas;
    private float cat;
    private a eFd;
    private b eFe;
    private boolean isLandscape;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void aPo();
    }

    /* loaded from: classes.dex */
    public interface b {
        void b(int i, int i2, float f, float f2, float f3, float f4);
    }

    /* loaded from: classes.dex */
    public static class c {
        public float Hu;
        public float Hy;
        public float bWo;
        public float bWp;
        public int eFg;
        public int eFh;
    }

    public PbLandscapeListView(Context context) {
        super(context);
        this.isLandscape = false;
        this.aWa = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.eFe != null) {
                                PbLandscapeListView.this.eFe.b(cVar.eFg, cVar.eFh, cVar.Hy, cVar.bWo, cVar.Hu, cVar.bWp);
                            }
                            return true;
                        default:
                            return false;
                    }
                }
                return false;
            }
        };
        this.mHandler = new Handler(this.aWa);
    }

    public PbLandscapeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isLandscape = false;
        this.aWa = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.eFe != null) {
                                PbLandscapeListView.this.eFe.b(cVar.eFg, cVar.eFh, cVar.Hy, cVar.bWo, cVar.Hu, cVar.bWp);
                            }
                            return true;
                        default:
                            return false;
                    }
                }
                return false;
            }
        };
        this.mHandler = new Handler(this.aWa);
    }

    public PbLandscapeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isLandscape = false;
        this.aWa = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.eFe != null) {
                                PbLandscapeListView.this.eFe.b(cVar.eFg, cVar.eFh, cVar.Hy, cVar.bWo, cVar.Hu, cVar.bWp);
                            }
                            return true;
                        default:
                            return false;
                    }
                }
                return false;
            }
        };
        this.mHandler = new Handler(this.aWa);
    }

    public void setIsLandscape(boolean z) {
        this.isLandscape = z;
    }

    public void setOnLayoutListener(a aVar) {
        this.eFd = aVar;
    }

    public void setListViewDragListener(b bVar) {
        this.eFe = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.cas = motionEvent.getRawX();
                this.cat = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (this.eFe != null) {
                    int i = (int) (rawX - this.cas);
                    int i2 = (int) (rawY - this.cat);
                    int abs = Math.abs(i);
                    if (abs > 20 && abs > Math.abs(i2)) {
                        a(i, i2, this.cas, this.cat, rawX, rawY);
                        return false;
                    }
                }
                this.cas = 0.0f;
                this.cat = 0.0f;
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
        if (this.eFd != null) {
            this.eFd.aPo();
        }
    }

    private void a(int i, int i2, float f, float f2, float f3, float f4) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            c cVar = new c();
            cVar.eFg = i;
            cVar.eFh = i2;
            cVar.Hy = f;
            cVar.Hu = f2;
            cVar.bWo = f3;
            cVar.bWp = f4;
            message.obj = cVar;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }
}
