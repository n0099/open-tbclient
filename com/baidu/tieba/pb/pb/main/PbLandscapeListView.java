package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class PbLandscapeListView extends BdTypeListView {
    private Handler.Callback aZy;
    private float cqT;
    private float cqU;
    private final int eWH;
    private a eWI;
    private b eWJ;
    private boolean isLandscape;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void aUa();
    }

    /* loaded from: classes.dex */
    public interface b {
        void b(int i, int i2, float f, float f2, float f3, float f4);
    }

    /* loaded from: classes.dex */
    public static class c {
        public float GP;
        public float GT;
        public float cmN;
        public float cmO;
        public int eWL;
        public int eWM;
    }

    public PbLandscapeListView(Context context) {
        super(context);
        this.eWH = com.baidu.adp.lib.util.l.ac(TbadkCoreApplication.getInst().getContext()) / 3;
        this.isLandscape = false;
        this.aZy = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.eWJ != null) {
                                PbLandscapeListView.this.eWJ.b(cVar.eWL, cVar.eWM, cVar.GT, cVar.cmN, cVar.GP, cVar.cmO);
                            }
                            return true;
                        default:
                            return false;
                    }
                }
                return false;
            }
        };
        this.mHandler = new Handler(this.aZy);
    }

    public PbLandscapeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eWH = com.baidu.adp.lib.util.l.ac(TbadkCoreApplication.getInst().getContext()) / 3;
        this.isLandscape = false;
        this.aZy = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.eWJ != null) {
                                PbLandscapeListView.this.eWJ.b(cVar.eWL, cVar.eWM, cVar.GT, cVar.cmN, cVar.GP, cVar.cmO);
                            }
                            return true;
                        default:
                            return false;
                    }
                }
                return false;
            }
        };
        this.mHandler = new Handler(this.aZy);
    }

    public PbLandscapeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eWH = com.baidu.adp.lib.util.l.ac(TbadkCoreApplication.getInst().getContext()) / 3;
        this.isLandscape = false;
        this.aZy = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.eWJ != null) {
                                PbLandscapeListView.this.eWJ.b(cVar.eWL, cVar.eWM, cVar.GT, cVar.cmN, cVar.GP, cVar.cmO);
                            }
                            return true;
                        default:
                            return false;
                    }
                }
                return false;
            }
        };
        this.mHandler = new Handler(this.aZy);
    }

    public void setIsLandscape(boolean z) {
        this.isLandscape = z;
    }

    public void setOnLayoutListener(a aVar) {
        this.eWI = aVar;
    }

    public void setListViewDragListener(b bVar) {
        this.eWJ = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.cqT = motionEvent.getRawX();
                this.cqU = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (this.eWJ != null) {
                    int i = (int) (rawX - this.cqT);
                    int i2 = (int) (rawY - this.cqU);
                    int abs = Math.abs(i);
                    if (abs > this.eWH && abs > Math.abs(i2)) {
                        a(i, i2, this.cqT, this.cqU, rawX, rawY);
                        return false;
                    }
                }
                this.cqT = 0.0f;
                this.cqU = 0.0f;
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
        if (this.eWI != null) {
            this.eWI.aUa();
        }
    }

    private void a(int i, int i2, float f, float f2, float f3, float f4) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            c cVar = new c();
            cVar.eWL = i;
            cVar.eWM = i2;
            cVar.GT = f;
            cVar.GP = f2;
            cVar.cmN = f3;
            cVar.cmO = f4;
            message.obj = cVar;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }
}
