package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class PbLandscapeListView extends BdTypeListView {
    public final int N;
    public boolean O;
    public b P;
    public float Q;
    public float R;
    public c S;
    public Handler.Callback T;
    public Handler U;
    public boolean V;
    public boolean W;
    public boolean a0;

    /* loaded from: classes3.dex */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Object obj = message.obj;
            if (obj instanceof d) {
                d dVar = (d) obj;
                if (message.what != 0) {
                    return false;
                }
                if (PbLandscapeListView.this.S != null) {
                    PbLandscapeListView.this.S.a(dVar.f19858a, dVar.f19859b, dVar.f19860c, dVar.f19862e, dVar.f19861d, dVar.f19863f);
                    return true;
                }
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onLayout();
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(int i2, int i3, float f2, float f3, float f4, float f5);
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public int f19858a;

        /* renamed from: b  reason: collision with root package name */
        public int f19859b;

        /* renamed from: c  reason: collision with root package name */
        public float f19860c;

        /* renamed from: d  reason: collision with root package name */
        public float f19861d;

        /* renamed from: e  reason: collision with root package name */
        public float f19862e;

        /* renamed from: f  reason: collision with root package name */
        public float f19863f;
    }

    public PbLandscapeListView(Context context) {
        super(context);
        this.N = l.k(TbadkCoreApplication.getInst().getContext()) / 8;
        this.O = false;
        this.T = new a();
        this.U = new Handler(this.T);
        this.V = false;
        this.W = false;
        this.a0 = false;
    }

    public boolean J() {
        return this.a0;
    }

    public final void K(int i2, int i3, float f2, float f3, float f4, float f5) {
        this.U.removeMessages(0);
        if (this.U.hasMessages(0)) {
            return;
        }
        Message message = new Message();
        message.what = 0;
        d dVar = new d();
        dVar.f19858a = i2;
        dVar.f19859b = i3;
        dVar.f19860c = f2;
        dVar.f19861d = f3;
        dVar.f19862e = f4;
        dVar.f19863f = f5;
        message.obj = dVar;
        this.U.sendMessageDelayed(message, 60L);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.Q = motionEvent.getRawX();
            this.R = motionEvent.getRawY();
            this.W = false;
            this.a0 = false;
        } else if (action == 1) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            if (!this.W && this.S != null) {
                int i2 = (int) (rawX - this.Q);
                int i3 = (int) (rawY - this.R);
                int abs = Math.abs(i2);
                if (abs > this.N && abs > Math.abs(i3)) {
                    K(i2, i3, this.Q, this.R, rawX, rawY);
                    this.a0 = true;
                    return false;
                }
            }
            this.Q = 0.0f;
            this.R = 0.0f;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.O) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        b bVar = this.P;
        if (bVar != null) {
            bVar.onLayout();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.O) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForbidDragListener(boolean z) {
        this.W = z;
    }

    public void setIsLandscape(boolean z) {
        this.O = z;
    }

    public void setListViewDragListener(c cVar) {
        this.S = cVar;
    }

    public void setOnLayoutListener(b bVar) {
        this.P = bVar;
    }

    public void setTextViewAdded(boolean z) {
        this.V = z;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void y(View view) {
        if (this.V) {
            getAdapter2().h(view, null, false, 1);
        } else {
            getAdapter2().h(view, null, false, 0);
        }
    }

    public PbLandscapeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.N = l.k(TbadkCoreApplication.getInst().getContext()) / 8;
        this.O = false;
        this.T = new a();
        this.U = new Handler(this.T);
        this.V = false;
        this.W = false;
        this.a0 = false;
    }

    public PbLandscapeListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.N = l.k(TbadkCoreApplication.getInst().getContext()) / 8;
        this.O = false;
        this.T = new a();
        this.U = new Handler(this.T);
        this.V = false;
        this.W = false;
        this.a0 = false;
    }
}
