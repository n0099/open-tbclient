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
    private float bmA;
    private float bmB;
    private View fQx;
    private float fYr;
    private Context mContext;
    public float noK;
    private int paA;
    private boolean paB;
    private boolean paC;
    Handler paD;
    private b pae;
    public float paf;
    private float pag;
    private float pah;
    private float pai;
    private a paj;
    private boolean pak;
    private boolean pal;
    private float pam;
    private RotateAnimation pan;
    private RotateAnimation pao;
    private View pap;
    private View paq;
    private View par;
    private TextView pas;
    private View pat;
    private View pau;
    private View pav;
    private View paw;
    private TextView pax;
    private View paz;
    private int state;

    /* loaded from: classes10.dex */
    public interface b {
        void a(PTRLayoutView pTRLayoutView);

        void b(PTRLayoutView pTRLayoutView);
    }

    public void setOnRefreshListener(b bVar) {
        this.pae = bVar;
    }

    public PTRLayoutView(Context context) {
        super(context);
        this.state = 0;
        this.paf = 0.0f;
        this.pag = 0.0f;
        this.pah = 200.0f;
        this.pai = 200.0f;
        this.noK = 8.0f;
        this.pak = false;
        this.pal = false;
        this.pam = 2.0f;
        this.paB = true;
        this.paC = true;
        this.paD = new Handler() { // from class: com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                PTRLayoutView.this.noK = (float) (8.0d + (5.0d * Math.tan((1.5707963267948966d / PTRLayoutView.this.getMeasuredHeight()) * (PTRLayoutView.this.paf + Math.abs(PTRLayoutView.this.pag)))));
                if (!PTRLayoutView.this.pal) {
                    if (PTRLayoutView.this.state != 2 || PTRLayoutView.this.paf > PTRLayoutView.this.pah) {
                        if (PTRLayoutView.this.state == 4 && (-PTRLayoutView.this.pag) <= PTRLayoutView.this.pai) {
                            PTRLayoutView.this.pag = -PTRLayoutView.this.pai;
                            PTRLayoutView.this.paj.cancel();
                        }
                    } else {
                        PTRLayoutView.this.paf = PTRLayoutView.this.pah;
                        Log.i("heyn", "pullDownY: " + PTRLayoutView.this.paf);
                        PTRLayoutView.this.paj.cancel();
                    }
                }
                if (PTRLayoutView.this.paf <= 0.0f) {
                    if (PTRLayoutView.this.pag < 0.0f) {
                        PTRLayoutView.this.pag += PTRLayoutView.this.noK;
                    }
                } else {
                    PTRLayoutView.this.paf -= PTRLayoutView.this.noK;
                }
                if (PTRLayoutView.this.paf < 0.0f) {
                    PTRLayoutView.this.paf = 0.0f;
                    PTRLayoutView.this.pap.clearAnimation();
                    if (PTRLayoutView.this.state != 2 && PTRLayoutView.this.state != 4) {
                        PTRLayoutView.this.iC(0);
                    }
                    PTRLayoutView.this.paj.cancel();
                    PTRLayoutView.this.requestLayout();
                }
                if (PTRLayoutView.this.pag > 0.0f) {
                    PTRLayoutView.this.pag = 0.0f;
                    PTRLayoutView.this.pau.clearAnimation();
                    if (PTRLayoutView.this.state != 2 && PTRLayoutView.this.state != 4) {
                        PTRLayoutView.this.iC(0);
                    }
                    PTRLayoutView.this.paj.cancel();
                    PTRLayoutView.this.requestLayout();
                }
                Log.d("handle", "handle");
                PTRLayoutView.this.requestLayout();
                if (PTRLayoutView.this.paf + Math.abs(PTRLayoutView.this.pag) == 0.0f) {
                    PTRLayoutView.this.paj.cancel();
                }
            }
        };
        initView(context);
    }

    public PTRLayoutView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.state = 0;
        this.paf = 0.0f;
        this.pag = 0.0f;
        this.pah = 200.0f;
        this.pai = 200.0f;
        this.noK = 8.0f;
        this.pak = false;
        this.pal = false;
        this.pam = 2.0f;
        this.paB = true;
        this.paC = true;
        this.paD = new Handler() { // from class: com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                PTRLayoutView.this.noK = (float) (8.0d + (5.0d * Math.tan((1.5707963267948966d / PTRLayoutView.this.getMeasuredHeight()) * (PTRLayoutView.this.paf + Math.abs(PTRLayoutView.this.pag)))));
                if (!PTRLayoutView.this.pal) {
                    if (PTRLayoutView.this.state != 2 || PTRLayoutView.this.paf > PTRLayoutView.this.pah) {
                        if (PTRLayoutView.this.state == 4 && (-PTRLayoutView.this.pag) <= PTRLayoutView.this.pai) {
                            PTRLayoutView.this.pag = -PTRLayoutView.this.pai;
                            PTRLayoutView.this.paj.cancel();
                        }
                    } else {
                        PTRLayoutView.this.paf = PTRLayoutView.this.pah;
                        Log.i("heyn", "pullDownY: " + PTRLayoutView.this.paf);
                        PTRLayoutView.this.paj.cancel();
                    }
                }
                if (PTRLayoutView.this.paf <= 0.0f) {
                    if (PTRLayoutView.this.pag < 0.0f) {
                        PTRLayoutView.this.pag += PTRLayoutView.this.noK;
                    }
                } else {
                    PTRLayoutView.this.paf -= PTRLayoutView.this.noK;
                }
                if (PTRLayoutView.this.paf < 0.0f) {
                    PTRLayoutView.this.paf = 0.0f;
                    PTRLayoutView.this.pap.clearAnimation();
                    if (PTRLayoutView.this.state != 2 && PTRLayoutView.this.state != 4) {
                        PTRLayoutView.this.iC(0);
                    }
                    PTRLayoutView.this.paj.cancel();
                    PTRLayoutView.this.requestLayout();
                }
                if (PTRLayoutView.this.pag > 0.0f) {
                    PTRLayoutView.this.pag = 0.0f;
                    PTRLayoutView.this.pau.clearAnimation();
                    if (PTRLayoutView.this.state != 2 && PTRLayoutView.this.state != 4) {
                        PTRLayoutView.this.iC(0);
                    }
                    PTRLayoutView.this.paj.cancel();
                    PTRLayoutView.this.requestLayout();
                }
                Log.d("handle", "handle");
                PTRLayoutView.this.requestLayout();
                if (PTRLayoutView.this.paf + Math.abs(PTRLayoutView.this.pag) == 0.0f) {
                    PTRLayoutView.this.paj.cancel();
                }
            }
        };
        initView(context);
    }

    public PTRLayoutView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.state = 0;
        this.paf = 0.0f;
        this.pag = 0.0f;
        this.pah = 200.0f;
        this.pai = 200.0f;
        this.noK = 8.0f;
        this.pak = false;
        this.pal = false;
        this.pam = 2.0f;
        this.paB = true;
        this.paC = true;
        this.paD = new Handler() { // from class: com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                PTRLayoutView.this.noK = (float) (8.0d + (5.0d * Math.tan((1.5707963267948966d / PTRLayoutView.this.getMeasuredHeight()) * (PTRLayoutView.this.paf + Math.abs(PTRLayoutView.this.pag)))));
                if (!PTRLayoutView.this.pal) {
                    if (PTRLayoutView.this.state != 2 || PTRLayoutView.this.paf > PTRLayoutView.this.pah) {
                        if (PTRLayoutView.this.state == 4 && (-PTRLayoutView.this.pag) <= PTRLayoutView.this.pai) {
                            PTRLayoutView.this.pag = -PTRLayoutView.this.pai;
                            PTRLayoutView.this.paj.cancel();
                        }
                    } else {
                        PTRLayoutView.this.paf = PTRLayoutView.this.pah;
                        Log.i("heyn", "pullDownY: " + PTRLayoutView.this.paf);
                        PTRLayoutView.this.paj.cancel();
                    }
                }
                if (PTRLayoutView.this.paf <= 0.0f) {
                    if (PTRLayoutView.this.pag < 0.0f) {
                        PTRLayoutView.this.pag += PTRLayoutView.this.noK;
                    }
                } else {
                    PTRLayoutView.this.paf -= PTRLayoutView.this.noK;
                }
                if (PTRLayoutView.this.paf < 0.0f) {
                    PTRLayoutView.this.paf = 0.0f;
                    PTRLayoutView.this.pap.clearAnimation();
                    if (PTRLayoutView.this.state != 2 && PTRLayoutView.this.state != 4) {
                        PTRLayoutView.this.iC(0);
                    }
                    PTRLayoutView.this.paj.cancel();
                    PTRLayoutView.this.requestLayout();
                }
                if (PTRLayoutView.this.pag > 0.0f) {
                    PTRLayoutView.this.pag = 0.0f;
                    PTRLayoutView.this.pau.clearAnimation();
                    if (PTRLayoutView.this.state != 2 && PTRLayoutView.this.state != 4) {
                        PTRLayoutView.this.iC(0);
                    }
                    PTRLayoutView.this.paj.cancel();
                    PTRLayoutView.this.requestLayout();
                }
                Log.d("handle", "handle");
                PTRLayoutView.this.requestLayout();
                if (PTRLayoutView.this.paf + Math.abs(PTRLayoutView.this.pag) == 0.0f) {
                    PTRLayoutView.this.paj.cancel();
                }
            }
        };
        initView(context);
    }

    private void initView(Context context) {
        this.mContext = context;
        this.paj = new a(this.paD);
        this.pan = (RotateAnimation) AnimationUtils.loadAnimation(context, a.C0194a.reverse_anim);
        this.pao = (RotateAnimation) AnimationUtils.loadAnimation(context, a.C0194a.rotating);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        this.pan.setInterpolator(linearInterpolator);
        this.pao.setInterpolator(linearInterpolator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        this.paj.ic(5L);
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView$2] */
    public void NO(int i) {
        this.paq.clearAnimation();
        this.paq.setVisibility(8);
        switch (i) {
            case 0:
                this.par.setVisibility(0);
                this.pas.setText(a.h.refresh_succeed);
                break;
            default:
                this.par.setVisibility(0);
                this.pas.setText(a.h.refresh_fail);
                break;
        }
        if (this.paf > 0.0f) {
            new Handler() { // from class: com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView.2
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    PTRLayoutView.this.iC(5);
                    PTRLayoutView.this.hide();
                }
            }.sendEmptyMessageDelayed(0, 500L);
            return;
        }
        iC(5);
        hide();
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView$3] */
    public void NP(int i) {
        this.pav.clearAnimation();
        this.pav.setVisibility(8);
        switch (i) {
            case 0:
                this.paw.setVisibility(0);
                this.pax.setText(a.h.load_succeed);
                this.paw.setBackgroundResource(a.e.load_succeed);
                break;
            case 1:
            default:
                this.paw.setVisibility(0);
                this.pax.setText(a.h.load_fail);
                this.paw.setBackgroundResource(a.e.load_failed);
                break;
            case 2:
                this.paw.setVisibility(0);
                this.pax.setText("没有更多数据");
                this.paw.setBackgroundResource(a.e.load_failed);
                break;
        }
        if (this.pag < 0.0f) {
            new Handler() { // from class: com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView.3
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    PTRLayoutView.this.iC(5);
                    PTRLayoutView.this.hide();
                }
            }.sendEmptyMessageDelayed(0, 500L);
            return;
        }
        iC(5);
        hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iC(int i) {
        this.state = i;
        switch (this.state) {
            case 0:
                this.par.setVisibility(8);
                this.pas.setText(a.h.pull_to_refresh);
                this.pap.clearAnimation();
                this.pap.setVisibility(0);
                this.paw.setVisibility(8);
                this.pax.setText(a.h.pullup_to_load);
                this.pau.clearAnimation();
                this.pau.setVisibility(0);
                return;
            case 1:
                this.pas.setText(a.h.release_to_refresh);
                this.pap.startAnimation(this.pan);
                return;
            case 2:
                this.pap.clearAnimation();
                this.paq.setVisibility(0);
                this.pap.setVisibility(4);
                this.paq.startAnimation(this.pao);
                this.pas.setText(a.h.refreshing);
                return;
            case 3:
                this.pax.setText(a.h.release_to_load);
                this.pau.startAnimation(this.pan);
                return;
            case 4:
                this.pau.clearAnimation();
                this.pav.setVisibility(0);
                this.pau.setVisibility(4);
                this.pav.startAnimation(this.pao);
                this.pax.setText(a.h.loading);
                return;
            default:
                return;
        }
    }

    private void ekE() {
        this.paB = true;
        this.paC = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.bmB = motionEvent.getY();
                this.bmA = motionEvent.getX();
                this.fYr = this.bmB;
                this.paj.cancel();
                this.paA = 0;
                ekE();
                break;
            case 1:
                if (this.paf > this.pah || (-this.pag) > this.pai) {
                    this.pal = false;
                }
                if (this.state == 1) {
                    iC(2);
                    if (this.pae != null) {
                        this.pae.a(this);
                    }
                } else if (this.state == 3) {
                    iC(4);
                    if (this.pae != null) {
                        this.pae.b(this);
                    }
                }
                hide();
                break;
            case 2:
                float abs = Math.abs(motionEvent.getY() - this.bmB);
                float abs2 = Math.abs(motionEvent.getX() - this.bmA);
                if (this.paA == 0 && Math.pow(abs2, 2.0d) / Math.pow(abs, 2.0d) <= 3.0d) {
                    if (this.paf > 0.0f || (((com.baidu.yuyinala.privatemessage.session.view.smrlistview.a) this.paz).ekF() && this.paB && this.state != 4)) {
                        this.paf += (motionEvent.getY() - this.fYr) / this.pam;
                        if (this.paf < 0.0f) {
                            this.paf = 0.0f;
                            this.paB = false;
                            this.paC = true;
                        }
                        if (this.paf > getMeasuredHeight()) {
                            this.paf = getMeasuredHeight();
                        }
                        if (this.state == 2) {
                            this.pal = true;
                        }
                    } else if (this.pag < 0.0f || (((com.baidu.yuyinala.privatemessage.session.view.smrlistview.a) this.paz).ekG() && this.paC && this.state != 2)) {
                        this.pag += (motionEvent.getY() - this.fYr) / this.pam;
                        if (this.pag > 0.0f) {
                            this.pag = 0.0f;
                            this.paB = true;
                            this.paC = false;
                        }
                        if (this.pag < (-getMeasuredHeight())) {
                            this.pag = -getMeasuredHeight();
                        }
                        if (this.state == 4) {
                            this.pal = true;
                        }
                    } else {
                        ekE();
                    }
                } else {
                    this.paA = 0;
                }
                this.fYr = motionEvent.getY();
                this.pam = (float) ((Math.tan((1.5707963267948966d / getMeasuredHeight()) * (this.paf + Math.abs(this.pag))) * 2.0d) + 2.0d);
                if (this.paf > 0.0f || this.pag < 0.0f) {
                    requestLayout();
                }
                if (this.paf > 0.0f) {
                    if (this.paf <= this.pah && (this.state == 1 || this.state == 5)) {
                        iC(0);
                    }
                    if (this.paf >= this.pah && this.state == 0) {
                        iC(1);
                    }
                } else if (this.pag < 0.0f) {
                    if ((-this.pag) <= this.pai && (this.state == 3 || this.state == 5)) {
                        iC(0);
                    }
                    if ((-this.pag) >= this.pai && this.state == 0) {
                        iC(3);
                    }
                }
                if (this.paf + Math.abs(this.pag) > 8.0f) {
                    motionEvent.setAction(3);
                    break;
                }
                break;
            case 5:
            case 6:
                this.paA = -1;
                break;
        }
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    private void initView() {
        this.pap = this.fQx.findViewById(a.f.pull_icon);
        this.pas = (TextView) this.fQx.findViewById(a.f.state_tv);
        this.paq = this.fQx.findViewById(a.f.refreshing_icon);
        this.par = this.fQx.findViewById(a.f.state_iv);
        this.pau = this.pat.findViewById(a.f.pullup_icon);
        this.pax = (TextView) this.pat.findViewById(a.f.loadstate_tv);
        this.pav = this.pat.findViewById(a.f.loading_icon);
        this.paw = this.pat.findViewById(a.f.loadstate_iv);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Log.d("Test", "Test");
        if (!this.pak) {
            this.fQx = getChildAt(0);
            this.paz = getChildAt(1);
            this.pat = getChildAt(2);
            this.pak = true;
            initView();
            this.pah = ((ViewGroup) this.fQx).getChildAt(0).getMeasuredHeight();
            this.pai = ((ViewGroup) this.pat).getChildAt(0).getMeasuredHeight();
        }
        this.fQx.layout(0, ((int) (this.paf + this.pag)) - this.fQx.getMeasuredHeight(), this.fQx.getMeasuredWidth(), (int) (this.paf + this.pag));
        this.paz.layout(0, (int) (this.paf + this.pag), this.paz.getMeasuredWidth(), ((int) (this.paf + this.pag)) + this.paz.getMeasuredHeight());
        this.pat.layout(0, ((int) (this.paf + this.pag)) + this.paz.getMeasuredHeight(), this.pat.getMeasuredWidth(), ((int) (this.paf + this.pag)) + this.paz.getMeasuredHeight() + this.pat.getMeasuredHeight());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a {
        private Handler handler;
        private C0977a paF;
        private Timer timer = new Timer();

        public a(Handler handler) {
            this.handler = handler;
        }

        public void ic(long j) {
            if (this.paF != null) {
                this.paF.cancel();
                this.paF = null;
            }
            this.paF = new C0977a(this.handler);
            this.timer.schedule(this.paF, 0L, j);
        }

        public void cancel() {
            if (this.paF != null) {
                this.paF.cancel();
                this.paF = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class C0977a extends TimerTask {
            private Handler handler;

            public C0977a(Handler handler) {
                this.handler = handler;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                this.handler.obtainMessage().sendToTarget();
            }
        }
    }
}
