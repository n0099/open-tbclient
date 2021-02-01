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
    private float bqb;
    private float bqc;
    private View fSK;
    private float gaI;
    private Context mContext;
    public float nyt;
    private boolean pkA;
    private boolean pkB;
    private float pkC;
    private RotateAnimation pkD;
    private RotateAnimation pkE;
    private View pkF;
    private View pkG;
    private View pkH;
    private TextView pkI;
    private View pkJ;
    private View pkK;
    private View pkL;
    private View pkM;
    private TextView pkN;
    private View pkO;
    private int pkP;
    private boolean pkQ;
    private boolean pkR;
    Handler pkS;
    private b pku;
    public float pkv;
    private float pkw;
    private float pkx;
    private float pky;
    private a pkz;
    private int state;

    /* loaded from: classes11.dex */
    public interface b {
        void a(PTRLayoutView pTRLayoutView);

        void b(PTRLayoutView pTRLayoutView);
    }

    public void setOnRefreshListener(b bVar) {
        this.pku = bVar;
    }

    public PTRLayoutView(Context context) {
        super(context);
        this.state = 0;
        this.pkv = 0.0f;
        this.pkw = 0.0f;
        this.pkx = 200.0f;
        this.pky = 200.0f;
        this.nyt = 8.0f;
        this.pkA = false;
        this.pkB = false;
        this.pkC = 2.0f;
        this.pkQ = true;
        this.pkR = true;
        this.pkS = new Handler() { // from class: com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                PTRLayoutView.this.nyt = (float) (8.0d + (5.0d * Math.tan((1.5707963267948966d / PTRLayoutView.this.getMeasuredHeight()) * (PTRLayoutView.this.pkv + Math.abs(PTRLayoutView.this.pkw)))));
                if (!PTRLayoutView.this.pkB) {
                    if (PTRLayoutView.this.state != 2 || PTRLayoutView.this.pkv > PTRLayoutView.this.pkx) {
                        if (PTRLayoutView.this.state == 4 && (-PTRLayoutView.this.pkw) <= PTRLayoutView.this.pky) {
                            PTRLayoutView.this.pkw = -PTRLayoutView.this.pky;
                            PTRLayoutView.this.pkz.cancel();
                        }
                    } else {
                        PTRLayoutView.this.pkv = PTRLayoutView.this.pkx;
                        Log.i("heyn", "pullDownY: " + PTRLayoutView.this.pkv);
                        PTRLayoutView.this.pkz.cancel();
                    }
                }
                if (PTRLayoutView.this.pkv <= 0.0f) {
                    if (PTRLayoutView.this.pkw < 0.0f) {
                        PTRLayoutView.this.pkw += PTRLayoutView.this.nyt;
                    }
                } else {
                    PTRLayoutView.this.pkv -= PTRLayoutView.this.nyt;
                }
                if (PTRLayoutView.this.pkv < 0.0f) {
                    PTRLayoutView.this.pkv = 0.0f;
                    PTRLayoutView.this.pkF.clearAnimation();
                    if (PTRLayoutView.this.state != 2 && PTRLayoutView.this.state != 4) {
                        PTRLayoutView.this.iF(0);
                    }
                    PTRLayoutView.this.pkz.cancel();
                    PTRLayoutView.this.requestLayout();
                }
                if (PTRLayoutView.this.pkw > 0.0f) {
                    PTRLayoutView.this.pkw = 0.0f;
                    PTRLayoutView.this.pkK.clearAnimation();
                    if (PTRLayoutView.this.state != 2 && PTRLayoutView.this.state != 4) {
                        PTRLayoutView.this.iF(0);
                    }
                    PTRLayoutView.this.pkz.cancel();
                    PTRLayoutView.this.requestLayout();
                }
                Log.d("handle", "handle");
                PTRLayoutView.this.requestLayout();
                if (PTRLayoutView.this.pkv + Math.abs(PTRLayoutView.this.pkw) == 0.0f) {
                    PTRLayoutView.this.pkz.cancel();
                }
            }
        };
        initView(context);
    }

    public PTRLayoutView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.state = 0;
        this.pkv = 0.0f;
        this.pkw = 0.0f;
        this.pkx = 200.0f;
        this.pky = 200.0f;
        this.nyt = 8.0f;
        this.pkA = false;
        this.pkB = false;
        this.pkC = 2.0f;
        this.pkQ = true;
        this.pkR = true;
        this.pkS = new Handler() { // from class: com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                PTRLayoutView.this.nyt = (float) (8.0d + (5.0d * Math.tan((1.5707963267948966d / PTRLayoutView.this.getMeasuredHeight()) * (PTRLayoutView.this.pkv + Math.abs(PTRLayoutView.this.pkw)))));
                if (!PTRLayoutView.this.pkB) {
                    if (PTRLayoutView.this.state != 2 || PTRLayoutView.this.pkv > PTRLayoutView.this.pkx) {
                        if (PTRLayoutView.this.state == 4 && (-PTRLayoutView.this.pkw) <= PTRLayoutView.this.pky) {
                            PTRLayoutView.this.pkw = -PTRLayoutView.this.pky;
                            PTRLayoutView.this.pkz.cancel();
                        }
                    } else {
                        PTRLayoutView.this.pkv = PTRLayoutView.this.pkx;
                        Log.i("heyn", "pullDownY: " + PTRLayoutView.this.pkv);
                        PTRLayoutView.this.pkz.cancel();
                    }
                }
                if (PTRLayoutView.this.pkv <= 0.0f) {
                    if (PTRLayoutView.this.pkw < 0.0f) {
                        PTRLayoutView.this.pkw += PTRLayoutView.this.nyt;
                    }
                } else {
                    PTRLayoutView.this.pkv -= PTRLayoutView.this.nyt;
                }
                if (PTRLayoutView.this.pkv < 0.0f) {
                    PTRLayoutView.this.pkv = 0.0f;
                    PTRLayoutView.this.pkF.clearAnimation();
                    if (PTRLayoutView.this.state != 2 && PTRLayoutView.this.state != 4) {
                        PTRLayoutView.this.iF(0);
                    }
                    PTRLayoutView.this.pkz.cancel();
                    PTRLayoutView.this.requestLayout();
                }
                if (PTRLayoutView.this.pkw > 0.0f) {
                    PTRLayoutView.this.pkw = 0.0f;
                    PTRLayoutView.this.pkK.clearAnimation();
                    if (PTRLayoutView.this.state != 2 && PTRLayoutView.this.state != 4) {
                        PTRLayoutView.this.iF(0);
                    }
                    PTRLayoutView.this.pkz.cancel();
                    PTRLayoutView.this.requestLayout();
                }
                Log.d("handle", "handle");
                PTRLayoutView.this.requestLayout();
                if (PTRLayoutView.this.pkv + Math.abs(PTRLayoutView.this.pkw) == 0.0f) {
                    PTRLayoutView.this.pkz.cancel();
                }
            }
        };
        initView(context);
    }

    public PTRLayoutView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.state = 0;
        this.pkv = 0.0f;
        this.pkw = 0.0f;
        this.pkx = 200.0f;
        this.pky = 200.0f;
        this.nyt = 8.0f;
        this.pkA = false;
        this.pkB = false;
        this.pkC = 2.0f;
        this.pkQ = true;
        this.pkR = true;
        this.pkS = new Handler() { // from class: com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                PTRLayoutView.this.nyt = (float) (8.0d + (5.0d * Math.tan((1.5707963267948966d / PTRLayoutView.this.getMeasuredHeight()) * (PTRLayoutView.this.pkv + Math.abs(PTRLayoutView.this.pkw)))));
                if (!PTRLayoutView.this.pkB) {
                    if (PTRLayoutView.this.state != 2 || PTRLayoutView.this.pkv > PTRLayoutView.this.pkx) {
                        if (PTRLayoutView.this.state == 4 && (-PTRLayoutView.this.pkw) <= PTRLayoutView.this.pky) {
                            PTRLayoutView.this.pkw = -PTRLayoutView.this.pky;
                            PTRLayoutView.this.pkz.cancel();
                        }
                    } else {
                        PTRLayoutView.this.pkv = PTRLayoutView.this.pkx;
                        Log.i("heyn", "pullDownY: " + PTRLayoutView.this.pkv);
                        PTRLayoutView.this.pkz.cancel();
                    }
                }
                if (PTRLayoutView.this.pkv <= 0.0f) {
                    if (PTRLayoutView.this.pkw < 0.0f) {
                        PTRLayoutView.this.pkw += PTRLayoutView.this.nyt;
                    }
                } else {
                    PTRLayoutView.this.pkv -= PTRLayoutView.this.nyt;
                }
                if (PTRLayoutView.this.pkv < 0.0f) {
                    PTRLayoutView.this.pkv = 0.0f;
                    PTRLayoutView.this.pkF.clearAnimation();
                    if (PTRLayoutView.this.state != 2 && PTRLayoutView.this.state != 4) {
                        PTRLayoutView.this.iF(0);
                    }
                    PTRLayoutView.this.pkz.cancel();
                    PTRLayoutView.this.requestLayout();
                }
                if (PTRLayoutView.this.pkw > 0.0f) {
                    PTRLayoutView.this.pkw = 0.0f;
                    PTRLayoutView.this.pkK.clearAnimation();
                    if (PTRLayoutView.this.state != 2 && PTRLayoutView.this.state != 4) {
                        PTRLayoutView.this.iF(0);
                    }
                    PTRLayoutView.this.pkz.cancel();
                    PTRLayoutView.this.requestLayout();
                }
                Log.d("handle", "handle");
                PTRLayoutView.this.requestLayout();
                if (PTRLayoutView.this.pkv + Math.abs(PTRLayoutView.this.pkw) == 0.0f) {
                    PTRLayoutView.this.pkz.cancel();
                }
            }
        };
        initView(context);
    }

    private void initView(Context context) {
        this.mContext = context;
        this.pkz = new a(this.pkS);
        this.pkD = (RotateAnimation) AnimationUtils.loadAnimation(context, a.C0195a.reverse_anim);
        this.pkE = (RotateAnimation) AnimationUtils.loadAnimation(context, a.C0195a.rotating);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        this.pkD.setInterpolator(linearInterpolator);
        this.pkE.setInterpolator(linearInterpolator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        this.pkz.m51if(5L);
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView$2] */
    public void Oj(int i) {
        this.pkG.clearAnimation();
        this.pkG.setVisibility(8);
        switch (i) {
            case 0:
                this.pkH.setVisibility(0);
                this.pkI.setText(a.h.refresh_succeed);
                break;
            default:
                this.pkH.setVisibility(0);
                this.pkI.setText(a.h.refresh_fail);
                break;
        }
        if (this.pkv > 0.0f) {
            new Handler() { // from class: com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView.2
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    PTRLayoutView.this.iF(5);
                    PTRLayoutView.this.hide();
                }
            }.sendEmptyMessageDelayed(0, 500L);
            return;
        }
        iF(5);
        hide();
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView$3] */
    public void Ok(int i) {
        this.pkL.clearAnimation();
        this.pkL.setVisibility(8);
        switch (i) {
            case 0:
                this.pkM.setVisibility(0);
                this.pkN.setText(a.h.load_succeed);
                this.pkM.setBackgroundResource(a.e.load_succeed);
                break;
            case 1:
            default:
                this.pkM.setVisibility(0);
                this.pkN.setText(a.h.load_fail);
                this.pkM.setBackgroundResource(a.e.load_failed);
                break;
            case 2:
                this.pkM.setVisibility(0);
                this.pkN.setText("没有更多数据");
                this.pkM.setBackgroundResource(a.e.load_failed);
                break;
        }
        if (this.pkw < 0.0f) {
            new Handler() { // from class: com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView.3
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    PTRLayoutView.this.iF(5);
                    PTRLayoutView.this.hide();
                }
            }.sendEmptyMessageDelayed(0, 500L);
            return;
        }
        iF(5);
        hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iF(int i) {
        this.state = i;
        switch (this.state) {
            case 0:
                this.pkH.setVisibility(8);
                this.pkI.setText(a.h.pull_to_refresh);
                this.pkF.clearAnimation();
                this.pkF.setVisibility(0);
                this.pkM.setVisibility(8);
                this.pkN.setText(a.h.pullup_to_load);
                this.pkK.clearAnimation();
                this.pkK.setVisibility(0);
                return;
            case 1:
                this.pkI.setText(a.h.release_to_refresh);
                this.pkF.startAnimation(this.pkD);
                return;
            case 2:
                this.pkF.clearAnimation();
                this.pkG.setVisibility(0);
                this.pkF.setVisibility(4);
                this.pkG.startAnimation(this.pkE);
                this.pkI.setText(a.h.refreshing);
                return;
            case 3:
                this.pkN.setText(a.h.release_to_load);
                this.pkK.startAnimation(this.pkD);
                return;
            case 4:
                this.pkK.clearAnimation();
                this.pkL.setVisibility(0);
                this.pkK.setVisibility(4);
                this.pkL.startAnimation(this.pkE);
                this.pkN.setText(a.h.loading);
                return;
            default:
                return;
        }
    }

    private void emW() {
        this.pkQ = true;
        this.pkR = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.bqc = motionEvent.getY();
                this.bqb = motionEvent.getX();
                this.gaI = this.bqc;
                this.pkz.cancel();
                this.pkP = 0;
                emW();
                break;
            case 1:
                if (this.pkv > this.pkx || (-this.pkw) > this.pky) {
                    this.pkB = false;
                }
                if (this.state == 1) {
                    iF(2);
                    if (this.pku != null) {
                        this.pku.a(this);
                    }
                } else if (this.state == 3) {
                    iF(4);
                    if (this.pku != null) {
                        this.pku.b(this);
                    }
                }
                hide();
                break;
            case 2:
                float abs = Math.abs(motionEvent.getY() - this.bqc);
                float abs2 = Math.abs(motionEvent.getX() - this.bqb);
                if (this.pkP == 0 && Math.pow(abs2, 2.0d) / Math.pow(abs, 2.0d) <= 3.0d) {
                    if (this.pkv > 0.0f || (((com.baidu.yuyinala.privatemessage.session.view.smrlistview.a) this.pkO).emX() && this.pkQ && this.state != 4)) {
                        this.pkv += (motionEvent.getY() - this.gaI) / this.pkC;
                        if (this.pkv < 0.0f) {
                            this.pkv = 0.0f;
                            this.pkQ = false;
                            this.pkR = true;
                        }
                        if (this.pkv > getMeasuredHeight()) {
                            this.pkv = getMeasuredHeight();
                        }
                        if (this.state == 2) {
                            this.pkB = true;
                        }
                    } else if (this.pkw < 0.0f || (((com.baidu.yuyinala.privatemessage.session.view.smrlistview.a) this.pkO).emY() && this.pkR && this.state != 2)) {
                        this.pkw += (motionEvent.getY() - this.gaI) / this.pkC;
                        if (this.pkw > 0.0f) {
                            this.pkw = 0.0f;
                            this.pkQ = true;
                            this.pkR = false;
                        }
                        if (this.pkw < (-getMeasuredHeight())) {
                            this.pkw = -getMeasuredHeight();
                        }
                        if (this.state == 4) {
                            this.pkB = true;
                        }
                    } else {
                        emW();
                    }
                } else {
                    this.pkP = 0;
                }
                this.gaI = motionEvent.getY();
                this.pkC = (float) ((Math.tan((1.5707963267948966d / getMeasuredHeight()) * (this.pkv + Math.abs(this.pkw))) * 2.0d) + 2.0d);
                if (this.pkv > 0.0f || this.pkw < 0.0f) {
                    requestLayout();
                }
                if (this.pkv > 0.0f) {
                    if (this.pkv <= this.pkx && (this.state == 1 || this.state == 5)) {
                        iF(0);
                    }
                    if (this.pkv >= this.pkx && this.state == 0) {
                        iF(1);
                    }
                } else if (this.pkw < 0.0f) {
                    if ((-this.pkw) <= this.pky && (this.state == 3 || this.state == 5)) {
                        iF(0);
                    }
                    if ((-this.pkw) >= this.pky && this.state == 0) {
                        iF(3);
                    }
                }
                if (this.pkv + Math.abs(this.pkw) > 8.0f) {
                    motionEvent.setAction(3);
                    break;
                }
                break;
            case 5:
            case 6:
                this.pkP = -1;
                break;
        }
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    private void initView() {
        this.pkF = this.fSK.findViewById(a.f.pull_icon);
        this.pkI = (TextView) this.fSK.findViewById(a.f.state_tv);
        this.pkG = this.fSK.findViewById(a.f.refreshing_icon);
        this.pkH = this.fSK.findViewById(a.f.state_iv);
        this.pkK = this.pkJ.findViewById(a.f.pullup_icon);
        this.pkN = (TextView) this.pkJ.findViewById(a.f.loadstate_tv);
        this.pkL = this.pkJ.findViewById(a.f.loading_icon);
        this.pkM = this.pkJ.findViewById(a.f.loadstate_iv);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Log.d("Test", "Test");
        if (!this.pkA) {
            this.fSK = getChildAt(0);
            this.pkO = getChildAt(1);
            this.pkJ = getChildAt(2);
            this.pkA = true;
            initView();
            this.pkx = ((ViewGroup) this.fSK).getChildAt(0).getMeasuredHeight();
            this.pky = ((ViewGroup) this.pkJ).getChildAt(0).getMeasuredHeight();
        }
        this.fSK.layout(0, ((int) (this.pkv + this.pkw)) - this.fSK.getMeasuredHeight(), this.fSK.getMeasuredWidth(), (int) (this.pkv + this.pkw));
        this.pkO.layout(0, (int) (this.pkv + this.pkw), this.pkO.getMeasuredWidth(), ((int) (this.pkv + this.pkw)) + this.pkO.getMeasuredHeight());
        this.pkJ.layout(0, ((int) (this.pkv + this.pkw)) + this.pkO.getMeasuredHeight(), this.pkJ.getMeasuredWidth(), ((int) (this.pkv + this.pkw)) + this.pkO.getMeasuredHeight() + this.pkJ.getMeasuredHeight());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a {
        private Handler handler;
        private C0981a pkU;
        private Timer timer = new Timer();

        public a(Handler handler) {
            this.handler = handler;
        }

        /* renamed from: if  reason: not valid java name */
        public void m51if(long j) {
            if (this.pkU != null) {
                this.pkU.cancel();
                this.pkU = null;
            }
            this.pkU = new C0981a(this.handler);
            this.timer.schedule(this.pkU, 0L, j);
        }

        public void cancel() {
            if (this.pkU != null) {
                this.pkU.cancel();
                this.pkU = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public class C0981a extends TimerTask {
            private Handler handler;

            public C0981a(Handler handler) {
                this.handler = handler;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                this.handler.obtainMessage().sendToTarget();
            }
        }
    }
}
