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
/* loaded from: classes11.dex */
public class PTRLayoutView extends RelativeLayout {
    private float brm;
    private float brn;
    private View fVe;
    private float gda;
    private Context mContext;
    public float nto;
    private b peH;
    public float peI;
    private float peJ;
    private float peK;
    private float peL;
    private a peM;
    private boolean peN;
    private boolean peO;
    private float peP;
    private RotateAnimation peQ;
    private RotateAnimation peR;
    private View peS;
    private View peT;
    private View peU;
    private TextView peV;
    private View peW;
    private View peX;
    private View peY;
    private View peZ;
    private TextView pfa;
    private View pfb;
    private int pfc;
    private boolean pfd;
    private boolean pfe;
    Handler pff;
    private int state;

    /* loaded from: classes11.dex */
    public interface b {
        void a(PTRLayoutView pTRLayoutView);

        void b(PTRLayoutView pTRLayoutView);
    }

    public void setOnRefreshListener(b bVar) {
        this.peH = bVar;
    }

    public PTRLayoutView(Context context) {
        super(context);
        this.state = 0;
        this.peI = 0.0f;
        this.peJ = 0.0f;
        this.peK = 200.0f;
        this.peL = 200.0f;
        this.nto = 8.0f;
        this.peN = false;
        this.peO = false;
        this.peP = 2.0f;
        this.pfd = true;
        this.pfe = true;
        this.pff = new Handler() { // from class: com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                PTRLayoutView.this.nto = (float) (8.0d + (5.0d * Math.tan((1.5707963267948966d / PTRLayoutView.this.getMeasuredHeight()) * (PTRLayoutView.this.peI + Math.abs(PTRLayoutView.this.peJ)))));
                if (!PTRLayoutView.this.peO) {
                    if (PTRLayoutView.this.state != 2 || PTRLayoutView.this.peI > PTRLayoutView.this.peK) {
                        if (PTRLayoutView.this.state == 4 && (-PTRLayoutView.this.peJ) <= PTRLayoutView.this.peL) {
                            PTRLayoutView.this.peJ = -PTRLayoutView.this.peL;
                            PTRLayoutView.this.peM.cancel();
                        }
                    } else {
                        PTRLayoutView.this.peI = PTRLayoutView.this.peK;
                        Log.i("heyn", "pullDownY: " + PTRLayoutView.this.peI);
                        PTRLayoutView.this.peM.cancel();
                    }
                }
                if (PTRLayoutView.this.peI <= 0.0f) {
                    if (PTRLayoutView.this.peJ < 0.0f) {
                        PTRLayoutView.this.peJ += PTRLayoutView.this.nto;
                    }
                } else {
                    PTRLayoutView.this.peI -= PTRLayoutView.this.nto;
                }
                if (PTRLayoutView.this.peI < 0.0f) {
                    PTRLayoutView.this.peI = 0.0f;
                    PTRLayoutView.this.peS.clearAnimation();
                    if (PTRLayoutView.this.state != 2 && PTRLayoutView.this.state != 4) {
                        PTRLayoutView.this.ki(0);
                    }
                    PTRLayoutView.this.peM.cancel();
                    PTRLayoutView.this.requestLayout();
                }
                if (PTRLayoutView.this.peJ > 0.0f) {
                    PTRLayoutView.this.peJ = 0.0f;
                    PTRLayoutView.this.peX.clearAnimation();
                    if (PTRLayoutView.this.state != 2 && PTRLayoutView.this.state != 4) {
                        PTRLayoutView.this.ki(0);
                    }
                    PTRLayoutView.this.peM.cancel();
                    PTRLayoutView.this.requestLayout();
                }
                Log.d("handle", "handle");
                PTRLayoutView.this.requestLayout();
                if (PTRLayoutView.this.peI + Math.abs(PTRLayoutView.this.peJ) == 0.0f) {
                    PTRLayoutView.this.peM.cancel();
                }
            }
        };
        eO(context);
    }

    public PTRLayoutView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.state = 0;
        this.peI = 0.0f;
        this.peJ = 0.0f;
        this.peK = 200.0f;
        this.peL = 200.0f;
        this.nto = 8.0f;
        this.peN = false;
        this.peO = false;
        this.peP = 2.0f;
        this.pfd = true;
        this.pfe = true;
        this.pff = new Handler() { // from class: com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                PTRLayoutView.this.nto = (float) (8.0d + (5.0d * Math.tan((1.5707963267948966d / PTRLayoutView.this.getMeasuredHeight()) * (PTRLayoutView.this.peI + Math.abs(PTRLayoutView.this.peJ)))));
                if (!PTRLayoutView.this.peO) {
                    if (PTRLayoutView.this.state != 2 || PTRLayoutView.this.peI > PTRLayoutView.this.peK) {
                        if (PTRLayoutView.this.state == 4 && (-PTRLayoutView.this.peJ) <= PTRLayoutView.this.peL) {
                            PTRLayoutView.this.peJ = -PTRLayoutView.this.peL;
                            PTRLayoutView.this.peM.cancel();
                        }
                    } else {
                        PTRLayoutView.this.peI = PTRLayoutView.this.peK;
                        Log.i("heyn", "pullDownY: " + PTRLayoutView.this.peI);
                        PTRLayoutView.this.peM.cancel();
                    }
                }
                if (PTRLayoutView.this.peI <= 0.0f) {
                    if (PTRLayoutView.this.peJ < 0.0f) {
                        PTRLayoutView.this.peJ += PTRLayoutView.this.nto;
                    }
                } else {
                    PTRLayoutView.this.peI -= PTRLayoutView.this.nto;
                }
                if (PTRLayoutView.this.peI < 0.0f) {
                    PTRLayoutView.this.peI = 0.0f;
                    PTRLayoutView.this.peS.clearAnimation();
                    if (PTRLayoutView.this.state != 2 && PTRLayoutView.this.state != 4) {
                        PTRLayoutView.this.ki(0);
                    }
                    PTRLayoutView.this.peM.cancel();
                    PTRLayoutView.this.requestLayout();
                }
                if (PTRLayoutView.this.peJ > 0.0f) {
                    PTRLayoutView.this.peJ = 0.0f;
                    PTRLayoutView.this.peX.clearAnimation();
                    if (PTRLayoutView.this.state != 2 && PTRLayoutView.this.state != 4) {
                        PTRLayoutView.this.ki(0);
                    }
                    PTRLayoutView.this.peM.cancel();
                    PTRLayoutView.this.requestLayout();
                }
                Log.d("handle", "handle");
                PTRLayoutView.this.requestLayout();
                if (PTRLayoutView.this.peI + Math.abs(PTRLayoutView.this.peJ) == 0.0f) {
                    PTRLayoutView.this.peM.cancel();
                }
            }
        };
        eO(context);
    }

    public PTRLayoutView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.state = 0;
        this.peI = 0.0f;
        this.peJ = 0.0f;
        this.peK = 200.0f;
        this.peL = 200.0f;
        this.nto = 8.0f;
        this.peN = false;
        this.peO = false;
        this.peP = 2.0f;
        this.pfd = true;
        this.pfe = true;
        this.pff = new Handler() { // from class: com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                PTRLayoutView.this.nto = (float) (8.0d + (5.0d * Math.tan((1.5707963267948966d / PTRLayoutView.this.getMeasuredHeight()) * (PTRLayoutView.this.peI + Math.abs(PTRLayoutView.this.peJ)))));
                if (!PTRLayoutView.this.peO) {
                    if (PTRLayoutView.this.state != 2 || PTRLayoutView.this.peI > PTRLayoutView.this.peK) {
                        if (PTRLayoutView.this.state == 4 && (-PTRLayoutView.this.peJ) <= PTRLayoutView.this.peL) {
                            PTRLayoutView.this.peJ = -PTRLayoutView.this.peL;
                            PTRLayoutView.this.peM.cancel();
                        }
                    } else {
                        PTRLayoutView.this.peI = PTRLayoutView.this.peK;
                        Log.i("heyn", "pullDownY: " + PTRLayoutView.this.peI);
                        PTRLayoutView.this.peM.cancel();
                    }
                }
                if (PTRLayoutView.this.peI <= 0.0f) {
                    if (PTRLayoutView.this.peJ < 0.0f) {
                        PTRLayoutView.this.peJ += PTRLayoutView.this.nto;
                    }
                } else {
                    PTRLayoutView.this.peI -= PTRLayoutView.this.nto;
                }
                if (PTRLayoutView.this.peI < 0.0f) {
                    PTRLayoutView.this.peI = 0.0f;
                    PTRLayoutView.this.peS.clearAnimation();
                    if (PTRLayoutView.this.state != 2 && PTRLayoutView.this.state != 4) {
                        PTRLayoutView.this.ki(0);
                    }
                    PTRLayoutView.this.peM.cancel();
                    PTRLayoutView.this.requestLayout();
                }
                if (PTRLayoutView.this.peJ > 0.0f) {
                    PTRLayoutView.this.peJ = 0.0f;
                    PTRLayoutView.this.peX.clearAnimation();
                    if (PTRLayoutView.this.state != 2 && PTRLayoutView.this.state != 4) {
                        PTRLayoutView.this.ki(0);
                    }
                    PTRLayoutView.this.peM.cancel();
                    PTRLayoutView.this.requestLayout();
                }
                Log.d("handle", "handle");
                PTRLayoutView.this.requestLayout();
                if (PTRLayoutView.this.peI + Math.abs(PTRLayoutView.this.peJ) == 0.0f) {
                    PTRLayoutView.this.peM.cancel();
                }
            }
        };
        eO(context);
    }

    private void eO(Context context) {
        this.mContext = context;
        this.peM = new a(this.pff);
        this.peQ = (RotateAnimation) AnimationUtils.loadAnimation(context, a.C0203a.reverse_anim);
        this.peR = (RotateAnimation) AnimationUtils.loadAnimation(context, a.C0203a.rotating);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        this.peQ.setInterpolator(linearInterpolator);
        this.peR.setInterpolator(linearInterpolator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        this.peM.ic(5L);
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView$2] */
    public void Pv(int i) {
        this.peT.clearAnimation();
        this.peT.setVisibility(8);
        switch (i) {
            case 0:
                this.peU.setVisibility(0);
                this.peV.setText(a.h.refresh_succeed);
                break;
            default:
                this.peU.setVisibility(0);
                this.peV.setText(a.h.refresh_fail);
                break;
        }
        if (this.peI > 0.0f) {
            new Handler() { // from class: com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView.2
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    PTRLayoutView.this.ki(5);
                    PTRLayoutView.this.hide();
                }
            }.sendEmptyMessageDelayed(0, 500L);
            return;
        }
        ki(5);
        hide();
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView$3] */
    public void Pw(int i) {
        this.peY.clearAnimation();
        this.peY.setVisibility(8);
        switch (i) {
            case 0:
                this.peZ.setVisibility(0);
                this.pfa.setText(a.h.load_succeed);
                this.peZ.setBackgroundResource(a.e.load_succeed);
                break;
            case 1:
            default:
                this.peZ.setVisibility(0);
                this.pfa.setText(a.h.load_fail);
                this.peZ.setBackgroundResource(a.e.load_failed);
                break;
            case 2:
                this.peZ.setVisibility(0);
                this.pfa.setText("没有更多数据");
                this.peZ.setBackgroundResource(a.e.load_failed);
                break;
        }
        if (this.peJ < 0.0f) {
            new Handler() { // from class: com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView.3
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    PTRLayoutView.this.ki(5);
                    PTRLayoutView.this.hide();
                }
            }.sendEmptyMessageDelayed(0, 500L);
            return;
        }
        ki(5);
        hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ki(int i) {
        this.state = i;
        switch (this.state) {
            case 0:
                this.peU.setVisibility(8);
                this.peV.setText(a.h.pull_to_refresh);
                this.peS.clearAnimation();
                this.peS.setVisibility(0);
                this.peZ.setVisibility(8);
                this.pfa.setText(a.h.pullup_to_load);
                this.peX.clearAnimation();
                this.peX.setVisibility(0);
                return;
            case 1:
                this.peV.setText(a.h.release_to_refresh);
                this.peS.startAnimation(this.peQ);
                return;
            case 2:
                this.peS.clearAnimation();
                this.peT.setVisibility(0);
                this.peS.setVisibility(4);
                this.peT.startAnimation(this.peR);
                this.peV.setText(a.h.refreshing);
                return;
            case 3:
                this.pfa.setText(a.h.release_to_load);
                this.peX.startAnimation(this.peQ);
                return;
            case 4:
                this.peX.clearAnimation();
                this.peY.setVisibility(0);
                this.peX.setVisibility(4);
                this.peY.startAnimation(this.peR);
                this.pfa.setText(a.h.loading);
                return;
            default:
                return;
        }
    }

    private void eoA() {
        this.pfd = true;
        this.pfe = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.brn = motionEvent.getY();
                this.brm = motionEvent.getX();
                this.gda = this.brn;
                this.peM.cancel();
                this.pfc = 0;
                eoA();
                break;
            case 1:
                if (this.peI > this.peK || (-this.peJ) > this.peL) {
                    this.peO = false;
                }
                if (this.state == 1) {
                    ki(2);
                    if (this.peH != null) {
                        this.peH.a(this);
                    }
                } else if (this.state == 3) {
                    ki(4);
                    if (this.peH != null) {
                        this.peH.b(this);
                    }
                }
                hide();
                break;
            case 2:
                float abs = Math.abs(motionEvent.getY() - this.brn);
                float abs2 = Math.abs(motionEvent.getX() - this.brm);
                if (this.pfc == 0 && Math.pow(abs2, 2.0d) / Math.pow(abs, 2.0d) <= 3.0d) {
                    if (this.peI > 0.0f || (((com.baidu.yuyinala.privatemessage.session.view.smrlistview.a) this.pfb).eoB() && this.pfd && this.state != 4)) {
                        this.peI += (motionEvent.getY() - this.gda) / this.peP;
                        if (this.peI < 0.0f) {
                            this.peI = 0.0f;
                            this.pfd = false;
                            this.pfe = true;
                        }
                        if (this.peI > getMeasuredHeight()) {
                            this.peI = getMeasuredHeight();
                        }
                        if (this.state == 2) {
                            this.peO = true;
                        }
                    } else if (this.peJ < 0.0f || (((com.baidu.yuyinala.privatemessage.session.view.smrlistview.a) this.pfb).eoC() && this.pfe && this.state != 2)) {
                        this.peJ += (motionEvent.getY() - this.gda) / this.peP;
                        if (this.peJ > 0.0f) {
                            this.peJ = 0.0f;
                            this.pfd = true;
                            this.pfe = false;
                        }
                        if (this.peJ < (-getMeasuredHeight())) {
                            this.peJ = -getMeasuredHeight();
                        }
                        if (this.state == 4) {
                            this.peO = true;
                        }
                    } else {
                        eoA();
                    }
                } else {
                    this.pfc = 0;
                }
                this.gda = motionEvent.getY();
                this.peP = (float) ((Math.tan((1.5707963267948966d / getMeasuredHeight()) * (this.peI + Math.abs(this.peJ))) * 2.0d) + 2.0d);
                if (this.peI > 0.0f || this.peJ < 0.0f) {
                    requestLayout();
                }
                if (this.peI > 0.0f) {
                    if (this.peI <= this.peK && (this.state == 1 || this.state == 5)) {
                        ki(0);
                    }
                    if (this.peI >= this.peK && this.state == 0) {
                        ki(1);
                    }
                } else if (this.peJ < 0.0f) {
                    if ((-this.peJ) <= this.peL && (this.state == 3 || this.state == 5)) {
                        ki(0);
                    }
                    if ((-this.peJ) >= this.peL && this.state == 0) {
                        ki(3);
                    }
                }
                if (this.peI + Math.abs(this.peJ) > 8.0f) {
                    motionEvent.setAction(3);
                    break;
                }
                break;
            case 5:
            case 6:
                this.pfc = -1;
                break;
        }
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    private void initView() {
        this.peS = this.fVe.findViewById(a.f.pull_icon);
        this.peV = (TextView) this.fVe.findViewById(a.f.state_tv);
        this.peT = this.fVe.findViewById(a.f.refreshing_icon);
        this.peU = this.fVe.findViewById(a.f.state_iv);
        this.peX = this.peW.findViewById(a.f.pullup_icon);
        this.pfa = (TextView) this.peW.findViewById(a.f.loadstate_tv);
        this.peY = this.peW.findViewById(a.f.loading_icon);
        this.peZ = this.peW.findViewById(a.f.loadstate_iv);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Log.d("Test", "Test");
        if (!this.peN) {
            this.fVe = getChildAt(0);
            this.pfb = getChildAt(1);
            this.peW = getChildAt(2);
            this.peN = true;
            initView();
            this.peK = ((ViewGroup) this.fVe).getChildAt(0).getMeasuredHeight();
            this.peL = ((ViewGroup) this.peW).getChildAt(0).getMeasuredHeight();
        }
        this.fVe.layout(0, ((int) (this.peI + this.peJ)) - this.fVe.getMeasuredHeight(), this.fVe.getMeasuredWidth(), (int) (this.peI + this.peJ));
        this.pfb.layout(0, (int) (this.peI + this.peJ), this.pfb.getMeasuredWidth(), ((int) (this.peI + this.peJ)) + this.pfb.getMeasuredHeight());
        this.peW.layout(0, ((int) (this.peI + this.peJ)) + this.pfb.getMeasuredHeight(), this.peW.getMeasuredWidth(), ((int) (this.peI + this.peJ)) + this.pfb.getMeasuredHeight() + this.peW.getMeasuredHeight());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a {
        private Handler handler;
        private C0994a pfh;
        private Timer timer = new Timer();

        public a(Handler handler) {
            this.handler = handler;
        }

        public void ic(long j) {
            if (this.pfh != null) {
                this.pfh.cancel();
                this.pfh = null;
            }
            this.pfh = new C0994a(this.handler);
            this.timer.schedule(this.pfh, 0L, j);
        }

        public void cancel() {
            if (this.pfh != null) {
                this.pfh.cancel();
                this.pfh = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public class C0994a extends TimerTask {
            private Handler handler;

            public C0994a(Handler handler) {
                this.handler = handler;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                this.handler.obtainMessage().sendToTarget();
            }
        }
    }
}
