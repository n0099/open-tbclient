package com.baidu.yuyinala.privatemessage.session.view.smrlistview;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes10.dex */
public class PTRLayoutView extends RelativeLayout {
    private float brB;
    private float brC;
    private View fUk;
    private float gci;
    private Context mContext;
    public float nAY;
    private b pmZ;
    public float pna;
    private float pnb;
    private float pnc;
    private float pnd;
    private a pne;
    private boolean pnf;
    private boolean png;
    private float pnh;
    private RotateAnimation pni;
    private RotateAnimation pnj;
    private View pnk;
    private View pnl;
    private View pnm;
    private TextView pnn;
    private View pno;
    private View pnp;
    private View pnq;
    private View pnr;
    private TextView pns;
    private View pnt;
    private int pnu;
    private boolean pnv;
    private boolean pnw;
    Handler pnx;
    private int state;

    /* loaded from: classes10.dex */
    public interface b {
        void a(PTRLayoutView pTRLayoutView);

        void b(PTRLayoutView pTRLayoutView);
    }

    public void setOnRefreshListener(b bVar) {
        this.pmZ = bVar;
    }

    public PTRLayoutView(Context context) {
        super(context);
        this.state = 0;
        this.pna = 0.0f;
        this.pnb = 0.0f;
        this.pnc = 200.0f;
        this.pnd = 200.0f;
        this.nAY = 8.0f;
        this.pnf = false;
        this.png = false;
        this.pnh = 2.0f;
        this.pnv = true;
        this.pnw = true;
        this.pnx = new Handler() { // from class: com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                PTRLayoutView.this.nAY = (float) (8.0d + (5.0d * Math.tan((1.5707963267948966d / PTRLayoutView.this.getMeasuredHeight()) * (PTRLayoutView.this.pna + Math.abs(PTRLayoutView.this.pnb)))));
                if (!PTRLayoutView.this.png) {
                    if (PTRLayoutView.this.state != 2 || PTRLayoutView.this.pna > PTRLayoutView.this.pnc) {
                        if (PTRLayoutView.this.state == 4 && (-PTRLayoutView.this.pnb) <= PTRLayoutView.this.pnd) {
                            PTRLayoutView.this.pnb = -PTRLayoutView.this.pnd;
                            PTRLayoutView.this.pne.cancel();
                        }
                    } else {
                        PTRLayoutView.this.pna = PTRLayoutView.this.pnc;
                        Log.i("heyn", "pullDownY: " + PTRLayoutView.this.pna);
                        PTRLayoutView.this.pne.cancel();
                    }
                }
                if (PTRLayoutView.this.pna <= 0.0f) {
                    if (PTRLayoutView.this.pnb < 0.0f) {
                        PTRLayoutView.this.pnb += PTRLayoutView.this.nAY;
                    }
                } else {
                    PTRLayoutView.this.pna -= PTRLayoutView.this.nAY;
                }
                if (PTRLayoutView.this.pna < 0.0f) {
                    PTRLayoutView.this.pna = 0.0f;
                    PTRLayoutView.this.pnk.clearAnimation();
                    if (PTRLayoutView.this.state != 2 && PTRLayoutView.this.state != 4) {
                        PTRLayoutView.this.iG(0);
                    }
                    PTRLayoutView.this.pne.cancel();
                    PTRLayoutView.this.requestLayout();
                }
                if (PTRLayoutView.this.pnb > 0.0f) {
                    PTRLayoutView.this.pnb = 0.0f;
                    PTRLayoutView.this.pnp.clearAnimation();
                    if (PTRLayoutView.this.state != 2 && PTRLayoutView.this.state != 4) {
                        PTRLayoutView.this.iG(0);
                    }
                    PTRLayoutView.this.pne.cancel();
                    PTRLayoutView.this.requestLayout();
                }
                Log.d("handle", "handle");
                PTRLayoutView.this.requestLayout();
                if (PTRLayoutView.this.pna + Math.abs(PTRLayoutView.this.pnb) == 0.0f) {
                    PTRLayoutView.this.pne.cancel();
                }
            }
        };
        initView(context);
    }

    public PTRLayoutView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.state = 0;
        this.pna = 0.0f;
        this.pnb = 0.0f;
        this.pnc = 200.0f;
        this.pnd = 200.0f;
        this.nAY = 8.0f;
        this.pnf = false;
        this.png = false;
        this.pnh = 2.0f;
        this.pnv = true;
        this.pnw = true;
        this.pnx = new Handler() { // from class: com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                PTRLayoutView.this.nAY = (float) (8.0d + (5.0d * Math.tan((1.5707963267948966d / PTRLayoutView.this.getMeasuredHeight()) * (PTRLayoutView.this.pna + Math.abs(PTRLayoutView.this.pnb)))));
                if (!PTRLayoutView.this.png) {
                    if (PTRLayoutView.this.state != 2 || PTRLayoutView.this.pna > PTRLayoutView.this.pnc) {
                        if (PTRLayoutView.this.state == 4 && (-PTRLayoutView.this.pnb) <= PTRLayoutView.this.pnd) {
                            PTRLayoutView.this.pnb = -PTRLayoutView.this.pnd;
                            PTRLayoutView.this.pne.cancel();
                        }
                    } else {
                        PTRLayoutView.this.pna = PTRLayoutView.this.pnc;
                        Log.i("heyn", "pullDownY: " + PTRLayoutView.this.pna);
                        PTRLayoutView.this.pne.cancel();
                    }
                }
                if (PTRLayoutView.this.pna <= 0.0f) {
                    if (PTRLayoutView.this.pnb < 0.0f) {
                        PTRLayoutView.this.pnb += PTRLayoutView.this.nAY;
                    }
                } else {
                    PTRLayoutView.this.pna -= PTRLayoutView.this.nAY;
                }
                if (PTRLayoutView.this.pna < 0.0f) {
                    PTRLayoutView.this.pna = 0.0f;
                    PTRLayoutView.this.pnk.clearAnimation();
                    if (PTRLayoutView.this.state != 2 && PTRLayoutView.this.state != 4) {
                        PTRLayoutView.this.iG(0);
                    }
                    PTRLayoutView.this.pne.cancel();
                    PTRLayoutView.this.requestLayout();
                }
                if (PTRLayoutView.this.pnb > 0.0f) {
                    PTRLayoutView.this.pnb = 0.0f;
                    PTRLayoutView.this.pnp.clearAnimation();
                    if (PTRLayoutView.this.state != 2 && PTRLayoutView.this.state != 4) {
                        PTRLayoutView.this.iG(0);
                    }
                    PTRLayoutView.this.pne.cancel();
                    PTRLayoutView.this.requestLayout();
                }
                Log.d("handle", "handle");
                PTRLayoutView.this.requestLayout();
                if (PTRLayoutView.this.pna + Math.abs(PTRLayoutView.this.pnb) == 0.0f) {
                    PTRLayoutView.this.pne.cancel();
                }
            }
        };
        initView(context);
    }

    public PTRLayoutView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.state = 0;
        this.pna = 0.0f;
        this.pnb = 0.0f;
        this.pnc = 200.0f;
        this.pnd = 200.0f;
        this.nAY = 8.0f;
        this.pnf = false;
        this.png = false;
        this.pnh = 2.0f;
        this.pnv = true;
        this.pnw = true;
        this.pnx = new Handler() { // from class: com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                PTRLayoutView.this.nAY = (float) (8.0d + (5.0d * Math.tan((1.5707963267948966d / PTRLayoutView.this.getMeasuredHeight()) * (PTRLayoutView.this.pna + Math.abs(PTRLayoutView.this.pnb)))));
                if (!PTRLayoutView.this.png) {
                    if (PTRLayoutView.this.state != 2 || PTRLayoutView.this.pna > PTRLayoutView.this.pnc) {
                        if (PTRLayoutView.this.state == 4 && (-PTRLayoutView.this.pnb) <= PTRLayoutView.this.pnd) {
                            PTRLayoutView.this.pnb = -PTRLayoutView.this.pnd;
                            PTRLayoutView.this.pne.cancel();
                        }
                    } else {
                        PTRLayoutView.this.pna = PTRLayoutView.this.pnc;
                        Log.i("heyn", "pullDownY: " + PTRLayoutView.this.pna);
                        PTRLayoutView.this.pne.cancel();
                    }
                }
                if (PTRLayoutView.this.pna <= 0.0f) {
                    if (PTRLayoutView.this.pnb < 0.0f) {
                        PTRLayoutView.this.pnb += PTRLayoutView.this.nAY;
                    }
                } else {
                    PTRLayoutView.this.pna -= PTRLayoutView.this.nAY;
                }
                if (PTRLayoutView.this.pna < 0.0f) {
                    PTRLayoutView.this.pna = 0.0f;
                    PTRLayoutView.this.pnk.clearAnimation();
                    if (PTRLayoutView.this.state != 2 && PTRLayoutView.this.state != 4) {
                        PTRLayoutView.this.iG(0);
                    }
                    PTRLayoutView.this.pne.cancel();
                    PTRLayoutView.this.requestLayout();
                }
                if (PTRLayoutView.this.pnb > 0.0f) {
                    PTRLayoutView.this.pnb = 0.0f;
                    PTRLayoutView.this.pnp.clearAnimation();
                    if (PTRLayoutView.this.state != 2 && PTRLayoutView.this.state != 4) {
                        PTRLayoutView.this.iG(0);
                    }
                    PTRLayoutView.this.pne.cancel();
                    PTRLayoutView.this.requestLayout();
                }
                Log.d("handle", "handle");
                PTRLayoutView.this.requestLayout();
                if (PTRLayoutView.this.pna + Math.abs(PTRLayoutView.this.pnb) == 0.0f) {
                    PTRLayoutView.this.pne.cancel();
                }
            }
        };
        initView(context);
    }

    private void initView(Context context) {
        this.mContext = context;
        this.pne = new a(this.pnx);
        this.pni = (RotateAnimation) AnimationUtils.loadAnimation(context, a.C0201a.reverse_anim);
        this.pnj = (RotateAnimation) AnimationUtils.loadAnimation(context, a.C0201a.rotating);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        this.pni.setInterpolator(linearInterpolator);
        this.pnj.setInterpolator(linearInterpolator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        this.pne.m51if(5L);
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView$2] */
    public void Oo(int i) {
        this.pnl.clearAnimation();
        this.pnl.setVisibility(8);
        switch (i) {
            case 0:
                this.pnm.setVisibility(0);
                this.pnn.setText(a.h.refresh_succeed);
                break;
            default:
                this.pnm.setVisibility(0);
                this.pnn.setText(a.h.refresh_fail);
                break;
        }
        if (this.pna > 0.0f) {
            new Handler() { // from class: com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView.2
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    PTRLayoutView.this.iG(5);
                    PTRLayoutView.this.hide();
                }
            }.sendEmptyMessageDelayed(0, 500L);
            return;
        }
        iG(5);
        hide();
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView$3] */
    public void Op(int i) {
        this.pnq.clearAnimation();
        this.pnq.setVisibility(8);
        switch (i) {
            case 0:
                this.pnr.setVisibility(0);
                this.pns.setText(a.h.load_succeed);
                this.pnr.setBackgroundResource(a.e.load_succeed);
                break;
            case 1:
            default:
                this.pnr.setVisibility(0);
                this.pns.setText(a.h.load_fail);
                this.pnr.setBackgroundResource(a.e.load_failed);
                break;
            case 2:
                this.pnr.setVisibility(0);
                this.pns.setText("没有更多数据");
                this.pnr.setBackgroundResource(a.e.load_failed);
                break;
        }
        if (this.pnb < 0.0f) {
            new Handler() { // from class: com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView.3
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    PTRLayoutView.this.iG(5);
                    PTRLayoutView.this.hide();
                }
            }.sendEmptyMessageDelayed(0, 500L);
            return;
        }
        iG(5);
        hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iG(int i) {
        this.state = i;
        switch (this.state) {
            case 0:
                this.pnm.setVisibility(8);
                this.pnn.setText(a.h.pull_to_refresh);
                this.pnk.clearAnimation();
                this.pnk.setVisibility(0);
                this.pnr.setVisibility(8);
                this.pns.setText(a.h.pullup_to_load);
                this.pnp.clearAnimation();
                this.pnp.setVisibility(0);
                return;
            case 1:
                this.pnn.setText(a.h.release_to_refresh);
                this.pnk.startAnimation(this.pni);
                return;
            case 2:
                this.pnk.clearAnimation();
                this.pnl.setVisibility(0);
                this.pnk.setVisibility(4);
                this.pnl.startAnimation(this.pnj);
                this.pnn.setText(a.h.refreshing);
                return;
            case 3:
                this.pns.setText(a.h.release_to_load);
                this.pnp.startAnimation(this.pni);
                return;
            case 4:
                this.pnp.clearAnimation();
                this.pnq.setVisibility(0);
                this.pnp.setVisibility(4);
                this.pnq.startAnimation(this.pnj);
                this.pns.setText(a.h.loading);
                return;
            default:
                return;
        }
    }

    private void enp() {
        this.pnv = true;
        this.pnw = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.brC = motionEvent.getY();
                this.brB = motionEvent.getX();
                this.gci = this.brC;
                this.pne.cancel();
                this.pnu = 0;
                enp();
                break;
            case 1:
                if (this.pna > this.pnc || (-this.pnb) > this.pnd) {
                    this.png = false;
                }
                if (this.state == 1) {
                    iG(2);
                    if (this.pmZ != null) {
                        this.pmZ.a(this);
                    }
                } else if (this.state == 3) {
                    iG(4);
                    if (this.pmZ != null) {
                        this.pmZ.b(this);
                    }
                }
                hide();
                break;
            case 2:
                float abs = Math.abs(motionEvent.getY() - this.brC);
                float abs2 = Math.abs(motionEvent.getX() - this.brB);
                if (this.pnu == 0 && Math.pow(abs2, 2.0d) / Math.pow(abs, 2.0d) <= 3.0d) {
                    if (this.pna > 0.0f || (((com.baidu.yuyinala.privatemessage.session.view.smrlistview.a) this.pnt).enq() && this.pnv && this.state != 4)) {
                        this.pna += (motionEvent.getY() - this.gci) / this.pnh;
                        if (this.pna < 0.0f) {
                            this.pna = 0.0f;
                            this.pnv = false;
                            this.pnw = true;
                        }
                        if (this.pna > getMeasuredHeight()) {
                            this.pna = getMeasuredHeight();
                        }
                        if (this.state == 2) {
                            this.png = true;
                        }
                    } else if (this.pnb < 0.0f || (((com.baidu.yuyinala.privatemessage.session.view.smrlistview.a) this.pnt).enr() && this.pnw && this.state != 2)) {
                        this.pnb += (motionEvent.getY() - this.gci) / this.pnh;
                        if (this.pnb > 0.0f) {
                            this.pnb = 0.0f;
                            this.pnv = true;
                            this.pnw = false;
                        }
                        if (this.pnb < (-getMeasuredHeight())) {
                            this.pnb = -getMeasuredHeight();
                        }
                        if (this.state == 4) {
                            this.png = true;
                        }
                    } else {
                        enp();
                    }
                } else {
                    this.pnu = 0;
                }
                this.gci = motionEvent.getY();
                this.pnh = (float) ((Math.tan((1.5707963267948966d / getMeasuredHeight()) * (this.pna + Math.abs(this.pnb))) * 2.0d) + 2.0d);
                if (this.pna > 0.0f || this.pnb < 0.0f) {
                    requestLayout();
                }
                if (this.pna > 0.0f) {
                    if (this.pna <= this.pnc && (this.state == 1 || this.state == 5)) {
                        iG(0);
                    }
                    if (this.pna >= this.pnc && this.state == 0) {
                        iG(1);
                    }
                } else if (this.pnb < 0.0f) {
                    if ((-this.pnb) <= this.pnd && (this.state == 3 || this.state == 5)) {
                        iG(0);
                    }
                    if ((-this.pnb) >= this.pnd && this.state == 0) {
                        iG(3);
                    }
                }
                if (this.pna + Math.abs(this.pnb) > 8.0f) {
                    motionEvent.setAction(3);
                    break;
                }
                break;
            case 5:
            case 6:
                this.pnu = -1;
                break;
        }
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    private void initView() {
        this.pnk = this.fUk.findViewById(a.f.pull_icon);
        this.pnn = (TextView) this.fUk.findViewById(a.f.state_tv);
        this.pnl = this.fUk.findViewById(a.f.refreshing_icon);
        this.pnm = this.fUk.findViewById(a.f.state_iv);
        this.pnp = this.pno.findViewById(a.f.pullup_icon);
        this.pns = (TextView) this.pno.findViewById(a.f.loadstate_tv);
        this.pnq = this.pno.findViewById(a.f.loading_icon);
        this.pnr = this.pno.findViewById(a.f.loadstate_iv);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Log.d("Test", "Test");
        if (!this.pnf) {
            this.fUk = getChildAt(0);
            this.pnt = getChildAt(1);
            this.pno = getChildAt(2);
            this.pnf = true;
            initView();
            this.pnc = ((ViewGroup) this.fUk).getChildAt(0).getMeasuredHeight();
            this.pnd = ((ViewGroup) this.pno).getChildAt(0).getMeasuredHeight();
        }
        this.fUk.layout(0, ((int) (this.pna + this.pnb)) - this.fUk.getMeasuredHeight(), this.fUk.getMeasuredWidth(), (int) (this.pna + this.pnb));
        this.pnt.layout(0, (int) (this.pna + this.pnb), this.pnt.getMeasuredWidth(), ((int) (this.pna + this.pnb)) + this.pnt.getMeasuredHeight());
        this.pno.layout(0, ((int) (this.pna + this.pnb)) + this.pnt.getMeasuredHeight(), this.pno.getMeasuredWidth(), ((int) (this.pna + this.pnb)) + this.pnt.getMeasuredHeight() + this.pno.getMeasuredHeight());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a {
        private Handler handler;
        private C0989a pnz;
        private Timer timer = new Timer();

        public a(Handler handler) {
            this.handler = handler;
        }

        /* renamed from: if  reason: not valid java name */
        public void m51if(long j) {
            if (this.pnz != null) {
                this.pnz.cancel();
                this.pnz = null;
            }
            this.pnz = new C0989a(this.handler);
            this.timer.schedule(this.pnz, 0L, j);
        }

        public void cancel() {
            if (this.pnz != null) {
                this.pnz.cancel();
                this.pnz = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class C0989a extends TimerTask {
            private Handler handler;

            public C0989a(Handler handler) {
                this.handler = handler;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                this.handler.obtainMessage().sendToTarget();
            }
        }
    }
}
