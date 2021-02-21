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
    public float nyT;
    private b pkU;
    public float pkV;
    private float pkW;
    private float pkX;
    private float pkY;
    private a pkZ;
    private boolean pla;
    private boolean plb;
    private float plc;
    private RotateAnimation pld;
    private RotateAnimation ple;
    private View plf;
    private View plg;
    private View plh;
    private TextView pli;
    private View plj;
    private View plk;
    private View pll;
    private View plm;
    private TextView pln;
    private View plo;
    private int plp;
    private boolean plq;
    private boolean plr;
    Handler pls;
    private int state;

    /* loaded from: classes11.dex */
    public interface b {
        void a(PTRLayoutView pTRLayoutView);

        void b(PTRLayoutView pTRLayoutView);
    }

    public void setOnRefreshListener(b bVar) {
        this.pkU = bVar;
    }

    public PTRLayoutView(Context context) {
        super(context);
        this.state = 0;
        this.pkV = 0.0f;
        this.pkW = 0.0f;
        this.pkX = 200.0f;
        this.pkY = 200.0f;
        this.nyT = 8.0f;
        this.pla = false;
        this.plb = false;
        this.plc = 2.0f;
        this.plq = true;
        this.plr = true;
        this.pls = new Handler() { // from class: com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                PTRLayoutView.this.nyT = (float) (8.0d + (5.0d * Math.tan((1.5707963267948966d / PTRLayoutView.this.getMeasuredHeight()) * (PTRLayoutView.this.pkV + Math.abs(PTRLayoutView.this.pkW)))));
                if (!PTRLayoutView.this.plb) {
                    if (PTRLayoutView.this.state != 2 || PTRLayoutView.this.pkV > PTRLayoutView.this.pkX) {
                        if (PTRLayoutView.this.state == 4 && (-PTRLayoutView.this.pkW) <= PTRLayoutView.this.pkY) {
                            PTRLayoutView.this.pkW = -PTRLayoutView.this.pkY;
                            PTRLayoutView.this.pkZ.cancel();
                        }
                    } else {
                        PTRLayoutView.this.pkV = PTRLayoutView.this.pkX;
                        Log.i("heyn", "pullDownY: " + PTRLayoutView.this.pkV);
                        PTRLayoutView.this.pkZ.cancel();
                    }
                }
                if (PTRLayoutView.this.pkV <= 0.0f) {
                    if (PTRLayoutView.this.pkW < 0.0f) {
                        PTRLayoutView.this.pkW += PTRLayoutView.this.nyT;
                    }
                } else {
                    PTRLayoutView.this.pkV -= PTRLayoutView.this.nyT;
                }
                if (PTRLayoutView.this.pkV < 0.0f) {
                    PTRLayoutView.this.pkV = 0.0f;
                    PTRLayoutView.this.plf.clearAnimation();
                    if (PTRLayoutView.this.state != 2 && PTRLayoutView.this.state != 4) {
                        PTRLayoutView.this.iF(0);
                    }
                    PTRLayoutView.this.pkZ.cancel();
                    PTRLayoutView.this.requestLayout();
                }
                if (PTRLayoutView.this.pkW > 0.0f) {
                    PTRLayoutView.this.pkW = 0.0f;
                    PTRLayoutView.this.plk.clearAnimation();
                    if (PTRLayoutView.this.state != 2 && PTRLayoutView.this.state != 4) {
                        PTRLayoutView.this.iF(0);
                    }
                    PTRLayoutView.this.pkZ.cancel();
                    PTRLayoutView.this.requestLayout();
                }
                Log.d("handle", "handle");
                PTRLayoutView.this.requestLayout();
                if (PTRLayoutView.this.pkV + Math.abs(PTRLayoutView.this.pkW) == 0.0f) {
                    PTRLayoutView.this.pkZ.cancel();
                }
            }
        };
        initView(context);
    }

    public PTRLayoutView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.state = 0;
        this.pkV = 0.0f;
        this.pkW = 0.0f;
        this.pkX = 200.0f;
        this.pkY = 200.0f;
        this.nyT = 8.0f;
        this.pla = false;
        this.plb = false;
        this.plc = 2.0f;
        this.plq = true;
        this.plr = true;
        this.pls = new Handler() { // from class: com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                PTRLayoutView.this.nyT = (float) (8.0d + (5.0d * Math.tan((1.5707963267948966d / PTRLayoutView.this.getMeasuredHeight()) * (PTRLayoutView.this.pkV + Math.abs(PTRLayoutView.this.pkW)))));
                if (!PTRLayoutView.this.plb) {
                    if (PTRLayoutView.this.state != 2 || PTRLayoutView.this.pkV > PTRLayoutView.this.pkX) {
                        if (PTRLayoutView.this.state == 4 && (-PTRLayoutView.this.pkW) <= PTRLayoutView.this.pkY) {
                            PTRLayoutView.this.pkW = -PTRLayoutView.this.pkY;
                            PTRLayoutView.this.pkZ.cancel();
                        }
                    } else {
                        PTRLayoutView.this.pkV = PTRLayoutView.this.pkX;
                        Log.i("heyn", "pullDownY: " + PTRLayoutView.this.pkV);
                        PTRLayoutView.this.pkZ.cancel();
                    }
                }
                if (PTRLayoutView.this.pkV <= 0.0f) {
                    if (PTRLayoutView.this.pkW < 0.0f) {
                        PTRLayoutView.this.pkW += PTRLayoutView.this.nyT;
                    }
                } else {
                    PTRLayoutView.this.pkV -= PTRLayoutView.this.nyT;
                }
                if (PTRLayoutView.this.pkV < 0.0f) {
                    PTRLayoutView.this.pkV = 0.0f;
                    PTRLayoutView.this.plf.clearAnimation();
                    if (PTRLayoutView.this.state != 2 && PTRLayoutView.this.state != 4) {
                        PTRLayoutView.this.iF(0);
                    }
                    PTRLayoutView.this.pkZ.cancel();
                    PTRLayoutView.this.requestLayout();
                }
                if (PTRLayoutView.this.pkW > 0.0f) {
                    PTRLayoutView.this.pkW = 0.0f;
                    PTRLayoutView.this.plk.clearAnimation();
                    if (PTRLayoutView.this.state != 2 && PTRLayoutView.this.state != 4) {
                        PTRLayoutView.this.iF(0);
                    }
                    PTRLayoutView.this.pkZ.cancel();
                    PTRLayoutView.this.requestLayout();
                }
                Log.d("handle", "handle");
                PTRLayoutView.this.requestLayout();
                if (PTRLayoutView.this.pkV + Math.abs(PTRLayoutView.this.pkW) == 0.0f) {
                    PTRLayoutView.this.pkZ.cancel();
                }
            }
        };
        initView(context);
    }

    public PTRLayoutView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.state = 0;
        this.pkV = 0.0f;
        this.pkW = 0.0f;
        this.pkX = 200.0f;
        this.pkY = 200.0f;
        this.nyT = 8.0f;
        this.pla = false;
        this.plb = false;
        this.plc = 2.0f;
        this.plq = true;
        this.plr = true;
        this.pls = new Handler() { // from class: com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                PTRLayoutView.this.nyT = (float) (8.0d + (5.0d * Math.tan((1.5707963267948966d / PTRLayoutView.this.getMeasuredHeight()) * (PTRLayoutView.this.pkV + Math.abs(PTRLayoutView.this.pkW)))));
                if (!PTRLayoutView.this.plb) {
                    if (PTRLayoutView.this.state != 2 || PTRLayoutView.this.pkV > PTRLayoutView.this.pkX) {
                        if (PTRLayoutView.this.state == 4 && (-PTRLayoutView.this.pkW) <= PTRLayoutView.this.pkY) {
                            PTRLayoutView.this.pkW = -PTRLayoutView.this.pkY;
                            PTRLayoutView.this.pkZ.cancel();
                        }
                    } else {
                        PTRLayoutView.this.pkV = PTRLayoutView.this.pkX;
                        Log.i("heyn", "pullDownY: " + PTRLayoutView.this.pkV);
                        PTRLayoutView.this.pkZ.cancel();
                    }
                }
                if (PTRLayoutView.this.pkV <= 0.0f) {
                    if (PTRLayoutView.this.pkW < 0.0f) {
                        PTRLayoutView.this.pkW += PTRLayoutView.this.nyT;
                    }
                } else {
                    PTRLayoutView.this.pkV -= PTRLayoutView.this.nyT;
                }
                if (PTRLayoutView.this.pkV < 0.0f) {
                    PTRLayoutView.this.pkV = 0.0f;
                    PTRLayoutView.this.plf.clearAnimation();
                    if (PTRLayoutView.this.state != 2 && PTRLayoutView.this.state != 4) {
                        PTRLayoutView.this.iF(0);
                    }
                    PTRLayoutView.this.pkZ.cancel();
                    PTRLayoutView.this.requestLayout();
                }
                if (PTRLayoutView.this.pkW > 0.0f) {
                    PTRLayoutView.this.pkW = 0.0f;
                    PTRLayoutView.this.plk.clearAnimation();
                    if (PTRLayoutView.this.state != 2 && PTRLayoutView.this.state != 4) {
                        PTRLayoutView.this.iF(0);
                    }
                    PTRLayoutView.this.pkZ.cancel();
                    PTRLayoutView.this.requestLayout();
                }
                Log.d("handle", "handle");
                PTRLayoutView.this.requestLayout();
                if (PTRLayoutView.this.pkV + Math.abs(PTRLayoutView.this.pkW) == 0.0f) {
                    PTRLayoutView.this.pkZ.cancel();
                }
            }
        };
        initView(context);
    }

    private void initView(Context context) {
        this.mContext = context;
        this.pkZ = new a(this.pls);
        this.pld = (RotateAnimation) AnimationUtils.loadAnimation(context, a.C0195a.reverse_anim);
        this.ple = (RotateAnimation) AnimationUtils.loadAnimation(context, a.C0195a.rotating);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        this.pld.setInterpolator(linearInterpolator);
        this.ple.setInterpolator(linearInterpolator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        this.pkZ.m50if(5L);
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView$2] */
    public void Ok(int i) {
        this.plg.clearAnimation();
        this.plg.setVisibility(8);
        switch (i) {
            case 0:
                this.plh.setVisibility(0);
                this.pli.setText(a.h.refresh_succeed);
                break;
            default:
                this.plh.setVisibility(0);
                this.pli.setText(a.h.refresh_fail);
                break;
        }
        if (this.pkV > 0.0f) {
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
    public void Ol(int i) {
        this.pll.clearAnimation();
        this.pll.setVisibility(8);
        switch (i) {
            case 0:
                this.plm.setVisibility(0);
                this.pln.setText(a.h.load_succeed);
                this.plm.setBackgroundResource(a.e.load_succeed);
                break;
            case 1:
            default:
                this.plm.setVisibility(0);
                this.pln.setText(a.h.load_fail);
                this.plm.setBackgroundResource(a.e.load_failed);
                break;
            case 2:
                this.plm.setVisibility(0);
                this.pln.setText("没有更多数据");
                this.plm.setBackgroundResource(a.e.load_failed);
                break;
        }
        if (this.pkW < 0.0f) {
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
                this.plh.setVisibility(8);
                this.pli.setText(a.h.pull_to_refresh);
                this.plf.clearAnimation();
                this.plf.setVisibility(0);
                this.plm.setVisibility(8);
                this.pln.setText(a.h.pullup_to_load);
                this.plk.clearAnimation();
                this.plk.setVisibility(0);
                return;
            case 1:
                this.pli.setText(a.h.release_to_refresh);
                this.plf.startAnimation(this.pld);
                return;
            case 2:
                this.plf.clearAnimation();
                this.plg.setVisibility(0);
                this.plf.setVisibility(4);
                this.plg.startAnimation(this.ple);
                this.pli.setText(a.h.refreshing);
                return;
            case 3:
                this.pln.setText(a.h.release_to_load);
                this.plk.startAnimation(this.pld);
                return;
            case 4:
                this.plk.clearAnimation();
                this.pll.setVisibility(0);
                this.plk.setVisibility(4);
                this.pll.startAnimation(this.ple);
                this.pln.setText(a.h.loading);
                return;
            default:
                return;
        }
    }

    private void enf() {
        this.plq = true;
        this.plr = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.bqc = motionEvent.getY();
                this.bqb = motionEvent.getX();
                this.gaI = this.bqc;
                this.pkZ.cancel();
                this.plp = 0;
                enf();
                break;
            case 1:
                if (this.pkV > this.pkX || (-this.pkW) > this.pkY) {
                    this.plb = false;
                }
                if (this.state == 1) {
                    iF(2);
                    if (this.pkU != null) {
                        this.pkU.a(this);
                    }
                } else if (this.state == 3) {
                    iF(4);
                    if (this.pkU != null) {
                        this.pkU.b(this);
                    }
                }
                hide();
                break;
            case 2:
                float abs = Math.abs(motionEvent.getY() - this.bqc);
                float abs2 = Math.abs(motionEvent.getX() - this.bqb);
                if (this.plp == 0 && Math.pow(abs2, 2.0d) / Math.pow(abs, 2.0d) <= 3.0d) {
                    if (this.pkV > 0.0f || (((com.baidu.yuyinala.privatemessage.session.view.smrlistview.a) this.plo).eng() && this.plq && this.state != 4)) {
                        this.pkV += (motionEvent.getY() - this.gaI) / this.plc;
                        if (this.pkV < 0.0f) {
                            this.pkV = 0.0f;
                            this.plq = false;
                            this.plr = true;
                        }
                        if (this.pkV > getMeasuredHeight()) {
                            this.pkV = getMeasuredHeight();
                        }
                        if (this.state == 2) {
                            this.plb = true;
                        }
                    } else if (this.pkW < 0.0f || (((com.baidu.yuyinala.privatemessage.session.view.smrlistview.a) this.plo).enh() && this.plr && this.state != 2)) {
                        this.pkW += (motionEvent.getY() - this.gaI) / this.plc;
                        if (this.pkW > 0.0f) {
                            this.pkW = 0.0f;
                            this.plq = true;
                            this.plr = false;
                        }
                        if (this.pkW < (-getMeasuredHeight())) {
                            this.pkW = -getMeasuredHeight();
                        }
                        if (this.state == 4) {
                            this.plb = true;
                        }
                    } else {
                        enf();
                    }
                } else {
                    this.plp = 0;
                }
                this.gaI = motionEvent.getY();
                this.plc = (float) ((Math.tan((1.5707963267948966d / getMeasuredHeight()) * (this.pkV + Math.abs(this.pkW))) * 2.0d) + 2.0d);
                if (this.pkV > 0.0f || this.pkW < 0.0f) {
                    requestLayout();
                }
                if (this.pkV > 0.0f) {
                    if (this.pkV <= this.pkX && (this.state == 1 || this.state == 5)) {
                        iF(0);
                    }
                    if (this.pkV >= this.pkX && this.state == 0) {
                        iF(1);
                    }
                } else if (this.pkW < 0.0f) {
                    if ((-this.pkW) <= this.pkY && (this.state == 3 || this.state == 5)) {
                        iF(0);
                    }
                    if ((-this.pkW) >= this.pkY && this.state == 0) {
                        iF(3);
                    }
                }
                if (this.pkV + Math.abs(this.pkW) > 8.0f) {
                    motionEvent.setAction(3);
                    break;
                }
                break;
            case 5:
            case 6:
                this.plp = -1;
                break;
        }
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    private void initView() {
        this.plf = this.fSK.findViewById(a.f.pull_icon);
        this.pli = (TextView) this.fSK.findViewById(a.f.state_tv);
        this.plg = this.fSK.findViewById(a.f.refreshing_icon);
        this.plh = this.fSK.findViewById(a.f.state_iv);
        this.plk = this.plj.findViewById(a.f.pullup_icon);
        this.pln = (TextView) this.plj.findViewById(a.f.loadstate_tv);
        this.pll = this.plj.findViewById(a.f.loading_icon);
        this.plm = this.plj.findViewById(a.f.loadstate_iv);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Log.d("Test", "Test");
        if (!this.pla) {
            this.fSK = getChildAt(0);
            this.plo = getChildAt(1);
            this.plj = getChildAt(2);
            this.pla = true;
            initView();
            this.pkX = ((ViewGroup) this.fSK).getChildAt(0).getMeasuredHeight();
            this.pkY = ((ViewGroup) this.plj).getChildAt(0).getMeasuredHeight();
        }
        this.fSK.layout(0, ((int) (this.pkV + this.pkW)) - this.fSK.getMeasuredHeight(), this.fSK.getMeasuredWidth(), (int) (this.pkV + this.pkW));
        this.plo.layout(0, (int) (this.pkV + this.pkW), this.plo.getMeasuredWidth(), ((int) (this.pkV + this.pkW)) + this.plo.getMeasuredHeight());
        this.plj.layout(0, ((int) (this.pkV + this.pkW)) + this.plo.getMeasuredHeight(), this.plj.getMeasuredWidth(), ((int) (this.pkV + this.pkW)) + this.plo.getMeasuredHeight() + this.plj.getMeasuredHeight());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a {
        private Handler handler;
        private C0983a plu;
        private Timer timer = new Timer();

        public a(Handler handler) {
            this.handler = handler;
        }

        /* renamed from: if  reason: not valid java name */
        public void m50if(long j) {
            if (this.plu != null) {
                this.plu.cancel();
                this.plu = null;
            }
            this.plu = new C0983a(this.handler);
            this.timer.schedule(this.plu, 0L, j);
        }

        public void cancel() {
            if (this.plu != null) {
                this.plu.cancel();
                this.plu = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public class C0983a extends TimerTask {
            private Handler handler;

            public C0983a(Handler handler) {
                this.handler = handler;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                this.handler.obtainMessage().sendToTarget();
            }
        }
    }
}
