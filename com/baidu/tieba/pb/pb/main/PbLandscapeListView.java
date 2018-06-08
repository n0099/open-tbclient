package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class PbLandscapeListView extends BdTypeListView {
    private float cPr;
    private float cPs;
    private final int fwn;
    private a fwo;
    private b fwp;
    private boolean isLandscape;
    private Handler mHandler;
    private Handler.Callback mHandlerCallback;

    /* loaded from: classes2.dex */
    public interface a {
        void bdd();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void b(int i, int i2, float f, float f2, float f3, float f4);
    }

    /* loaded from: classes2.dex */
    public static class c {
        public float Lv;
        public float Lz;
        public float cKW;
        public float cKX;
        public int fwr;
        public int fws;
    }

    public PbLandscapeListView(Context context) {
        super(context);
        this.fwn = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getContext()) / 3;
        this.isLandscape = false;
        this.mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.fwp != null) {
                                PbLandscapeListView.this.fwp.b(cVar.fwr, cVar.fws, cVar.Lz, cVar.cKW, cVar.Lv, cVar.cKX);
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
    }

    public PbLandscapeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fwn = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getContext()) / 3;
        this.isLandscape = false;
        this.mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.fwp != null) {
                                PbLandscapeListView.this.fwp.b(cVar.fwr, cVar.fws, cVar.Lz, cVar.cKW, cVar.Lv, cVar.cKX);
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
    }

    public PbLandscapeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fwn = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getContext()) / 3;
        this.isLandscape = false;
        this.mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.fwp != null) {
                                PbLandscapeListView.this.fwp.b(cVar.fwr, cVar.fws, cVar.Lz, cVar.cKW, cVar.Lv, cVar.cKX);
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
    }

    public void setIsLandscape(boolean z) {
        this.isLandscape = z;
    }

    public void setOnLayoutListener(a aVar) {
        this.fwo = aVar;
    }

    public void setListViewDragListener(b bVar) {
        this.fwp = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.cPr = motionEvent.getRawX();
                this.cPs = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (this.fwp != null) {
                    int i = (int) (rawX - this.cPr);
                    int i2 = (int) (rawY - this.cPs);
                    int abs = Math.abs(i);
                    if (abs > this.fwn && abs > Math.abs(i2)) {
                        a(i, i2, this.cPr, this.cPs, rawX, rawY);
                        return false;
                    }
                }
                this.cPr = 0.0f;
                this.cPs = 0.0f;
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
        if (this.fwo != null) {
            this.fwo.bdd();
        }
    }

    private void a(int i, int i2, float f, float f2, float f3, float f4) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            c cVar = new c();
            cVar.fwr = i;
            cVar.fws = i2;
            cVar.Lz = f;
            cVar.Lv = f2;
            cVar.cKW = f3;
            cVar.cKX = f4;
            message.obj = cVar;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }
}
