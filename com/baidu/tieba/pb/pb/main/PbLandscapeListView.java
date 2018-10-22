package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes6.dex */
public class PbLandscapeListView extends BdTypeListView {
    private float dea;
    private float deb;
    private final int fPE;
    private a fPF;
    private b fPG;
    private boolean isLandscape;
    private Handler mHandler;
    private Handler.Callback mHandlerCallback;

    /* loaded from: classes6.dex */
    public interface a {
        void bhM();
    }

    /* loaded from: classes6.dex */
    public interface b {
        void b(int i, int i2, float f, float f2, float f3, float f4);
    }

    /* loaded from: classes6.dex */
    public static class c {
        public float Om;
        public float Oq;
        public float cZC;
        public float cZD;
        public int fPI;
        public int fPJ;
    }

    public PbLandscapeListView(Context context) {
        super(context);
        this.fPE = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst().getContext()) / 3;
        this.isLandscape = false;
        this.mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.fPG != null) {
                                PbLandscapeListView.this.fPG.b(cVar.fPI, cVar.fPJ, cVar.Oq, cVar.cZC, cVar.Om, cVar.cZD);
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
        this.fPE = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst().getContext()) / 3;
        this.isLandscape = false;
        this.mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.fPG != null) {
                                PbLandscapeListView.this.fPG.b(cVar.fPI, cVar.fPJ, cVar.Oq, cVar.cZC, cVar.Om, cVar.cZD);
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
        this.fPE = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst().getContext()) / 3;
        this.isLandscape = false;
        this.mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.fPG != null) {
                                PbLandscapeListView.this.fPG.b(cVar.fPI, cVar.fPJ, cVar.Oq, cVar.cZC, cVar.Om, cVar.cZD);
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
        this.fPF = aVar;
    }

    public void setListViewDragListener(b bVar) {
        this.fPG = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.dea = motionEvent.getRawX();
                this.deb = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (this.fPG != null) {
                    int i = (int) (rawX - this.dea);
                    int i2 = (int) (rawY - this.deb);
                    int abs = Math.abs(i);
                    if (abs > this.fPE && abs > Math.abs(i2)) {
                        a(i, i2, this.dea, this.deb, rawX, rawY);
                        return false;
                    }
                }
                this.dea = 0.0f;
                this.deb = 0.0f;
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
        if (this.fPF != null) {
            this.fPF.bhM();
        }
    }

    private void a(int i, int i2, float f, float f2, float f3, float f4) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            c cVar = new c();
            cVar.fPI = i;
            cVar.fPJ = i2;
            cVar.Oq = f;
            cVar.Om = f2;
            cVar.cZC = f3;
            cVar.cZD = f4;
            message.obj = cVar;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }
}
