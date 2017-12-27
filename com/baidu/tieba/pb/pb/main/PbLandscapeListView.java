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
    private float dfL;
    private float dfM;
    private final int fKG;
    private a fKH;
    private b fKI;
    private boolean isLandscape;
    private Handler mHandler;
    private Handler.Callback mHandlerCallback;

    /* loaded from: classes2.dex */
    public interface a {
        void bbx();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void b(int i, int i2, float f, float f2, float f3, float f4);
    }

    /* loaded from: classes2.dex */
    public static class c {
        public float auR;
        public float auV;
        public float dbF;
        public float dbG;
        public int fKK;
        public int fKL;
    }

    public PbLandscapeListView(Context context) {
        super(context);
        this.fKG = com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst().getContext()) / 3;
        this.isLandscape = false;
        this.mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.fKI != null) {
                                PbLandscapeListView.this.fKI.b(cVar.fKK, cVar.fKL, cVar.auV, cVar.dbF, cVar.auR, cVar.dbG);
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
        this.fKG = com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst().getContext()) / 3;
        this.isLandscape = false;
        this.mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.fKI != null) {
                                PbLandscapeListView.this.fKI.b(cVar.fKK, cVar.fKL, cVar.auV, cVar.dbF, cVar.auR, cVar.dbG);
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
        this.fKG = com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst().getContext()) / 3;
        this.isLandscape = false;
        this.mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbLandscapeListView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.obj instanceof c) {
                    c cVar = (c) message.obj;
                    switch (message.what) {
                        case 0:
                            if (PbLandscapeListView.this.fKI != null) {
                                PbLandscapeListView.this.fKI.b(cVar.fKK, cVar.fKL, cVar.auV, cVar.dbF, cVar.auR, cVar.dbG);
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
        this.fKH = aVar;
    }

    public void setListViewDragListener(b bVar) {
        this.fKI = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.dfL = motionEvent.getRawX();
                this.dfM = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (this.fKI != null) {
                    int i = (int) (rawX - this.dfL);
                    int i2 = (int) (rawY - this.dfM);
                    int abs = Math.abs(i);
                    if (abs > this.fKG && abs > Math.abs(i2)) {
                        a(i, i2, this.dfL, this.dfM, rawX, rawY);
                        return false;
                    }
                }
                this.dfL = 0.0f;
                this.dfM = 0.0f;
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
        if (this.fKH != null) {
            this.fKH.bbx();
        }
    }

    private void a(int i, int i2, float f, float f2, float f3, float f4) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            c cVar = new c();
            cVar.fKK = i;
            cVar.fKL = i2;
            cVar.auV = f;
            cVar.auR = f2;
            cVar.dbF = f3;
            cVar.dbG = f4;
            message.obj = cVar;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }
}
