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
    public float noJ;
    private boolean paA;
    private boolean paB;
    Handler paC;
    private b pac;
    public float pae;
    private float paf;
    private float pag;
    private float pah;
    private a pai;
    private boolean paj;
    private boolean pak;
    private float pal;
    private RotateAnimation pam;
    private RotateAnimation pan;
    private View pao;
    private View pap;
    private View paq;
    private TextView par;
    private View pas;
    private View pat;
    private View pau;
    private View pav;
    private TextView paw;
    private View pax;
    private int paz;
    private int state;

    /* loaded from: classes10.dex */
    public interface b {
        void a(PTRLayoutView pTRLayoutView);

        void b(PTRLayoutView pTRLayoutView);
    }

    public void setOnRefreshListener(b bVar) {
        this.pac = bVar;
    }

    public PTRLayoutView(Context context) {
        super(context);
        this.state = 0;
        this.pae = 0.0f;
        this.paf = 0.0f;
        this.pag = 200.0f;
        this.pah = 200.0f;
        this.noJ = 8.0f;
        this.paj = false;
        this.pak = false;
        this.pal = 2.0f;
        this.paA = true;
        this.paB = true;
        this.paC = new Handler() { // from class: com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                PTRLayoutView.this.noJ = (float) (8.0d + (5.0d * Math.tan((1.5707963267948966d / PTRLayoutView.this.getMeasuredHeight()) * (PTRLayoutView.this.pae + Math.abs(PTRLayoutView.this.paf)))));
                if (!PTRLayoutView.this.pak) {
                    if (PTRLayoutView.this.state != 2 || PTRLayoutView.this.pae > PTRLayoutView.this.pag) {
                        if (PTRLayoutView.this.state == 4 && (-PTRLayoutView.this.paf) <= PTRLayoutView.this.pah) {
                            PTRLayoutView.this.paf = -PTRLayoutView.this.pah;
                            PTRLayoutView.this.pai.cancel();
                        }
                    } else {
                        PTRLayoutView.this.pae = PTRLayoutView.this.pag;
                        Log.i("heyn", "pullDownY: " + PTRLayoutView.this.pae);
                        PTRLayoutView.this.pai.cancel();
                    }
                }
                if (PTRLayoutView.this.pae <= 0.0f) {
                    if (PTRLayoutView.this.paf < 0.0f) {
                        PTRLayoutView.this.paf += PTRLayoutView.this.noJ;
                    }
                } else {
                    PTRLayoutView.this.pae -= PTRLayoutView.this.noJ;
                }
                if (PTRLayoutView.this.pae < 0.0f) {
                    PTRLayoutView.this.pae = 0.0f;
                    PTRLayoutView.this.pao.clearAnimation();
                    if (PTRLayoutView.this.state != 2 && PTRLayoutView.this.state != 4) {
                        PTRLayoutView.this.iC(0);
                    }
                    PTRLayoutView.this.pai.cancel();
                    PTRLayoutView.this.requestLayout();
                }
                if (PTRLayoutView.this.paf > 0.0f) {
                    PTRLayoutView.this.paf = 0.0f;
                    PTRLayoutView.this.pat.clearAnimation();
                    if (PTRLayoutView.this.state != 2 && PTRLayoutView.this.state != 4) {
                        PTRLayoutView.this.iC(0);
                    }
                    PTRLayoutView.this.pai.cancel();
                    PTRLayoutView.this.requestLayout();
                }
                Log.d("handle", "handle");
                PTRLayoutView.this.requestLayout();
                if (PTRLayoutView.this.pae + Math.abs(PTRLayoutView.this.paf) == 0.0f) {
                    PTRLayoutView.this.pai.cancel();
                }
            }
        };
        initView(context);
    }

    public PTRLayoutView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.state = 0;
        this.pae = 0.0f;
        this.paf = 0.0f;
        this.pag = 200.0f;
        this.pah = 200.0f;
        this.noJ = 8.0f;
        this.paj = false;
        this.pak = false;
        this.pal = 2.0f;
        this.paA = true;
        this.paB = true;
        this.paC = new Handler() { // from class: com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                PTRLayoutView.this.noJ = (float) (8.0d + (5.0d * Math.tan((1.5707963267948966d / PTRLayoutView.this.getMeasuredHeight()) * (PTRLayoutView.this.pae + Math.abs(PTRLayoutView.this.paf)))));
                if (!PTRLayoutView.this.pak) {
                    if (PTRLayoutView.this.state != 2 || PTRLayoutView.this.pae > PTRLayoutView.this.pag) {
                        if (PTRLayoutView.this.state == 4 && (-PTRLayoutView.this.paf) <= PTRLayoutView.this.pah) {
                            PTRLayoutView.this.paf = -PTRLayoutView.this.pah;
                            PTRLayoutView.this.pai.cancel();
                        }
                    } else {
                        PTRLayoutView.this.pae = PTRLayoutView.this.pag;
                        Log.i("heyn", "pullDownY: " + PTRLayoutView.this.pae);
                        PTRLayoutView.this.pai.cancel();
                    }
                }
                if (PTRLayoutView.this.pae <= 0.0f) {
                    if (PTRLayoutView.this.paf < 0.0f) {
                        PTRLayoutView.this.paf += PTRLayoutView.this.noJ;
                    }
                } else {
                    PTRLayoutView.this.pae -= PTRLayoutView.this.noJ;
                }
                if (PTRLayoutView.this.pae < 0.0f) {
                    PTRLayoutView.this.pae = 0.0f;
                    PTRLayoutView.this.pao.clearAnimation();
                    if (PTRLayoutView.this.state != 2 && PTRLayoutView.this.state != 4) {
                        PTRLayoutView.this.iC(0);
                    }
                    PTRLayoutView.this.pai.cancel();
                    PTRLayoutView.this.requestLayout();
                }
                if (PTRLayoutView.this.paf > 0.0f) {
                    PTRLayoutView.this.paf = 0.0f;
                    PTRLayoutView.this.pat.clearAnimation();
                    if (PTRLayoutView.this.state != 2 && PTRLayoutView.this.state != 4) {
                        PTRLayoutView.this.iC(0);
                    }
                    PTRLayoutView.this.pai.cancel();
                    PTRLayoutView.this.requestLayout();
                }
                Log.d("handle", "handle");
                PTRLayoutView.this.requestLayout();
                if (PTRLayoutView.this.pae + Math.abs(PTRLayoutView.this.paf) == 0.0f) {
                    PTRLayoutView.this.pai.cancel();
                }
            }
        };
        initView(context);
    }

    public PTRLayoutView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.state = 0;
        this.pae = 0.0f;
        this.paf = 0.0f;
        this.pag = 200.0f;
        this.pah = 200.0f;
        this.noJ = 8.0f;
        this.paj = false;
        this.pak = false;
        this.pal = 2.0f;
        this.paA = true;
        this.paB = true;
        this.paC = new Handler() { // from class: com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                PTRLayoutView.this.noJ = (float) (8.0d + (5.0d * Math.tan((1.5707963267948966d / PTRLayoutView.this.getMeasuredHeight()) * (PTRLayoutView.this.pae + Math.abs(PTRLayoutView.this.paf)))));
                if (!PTRLayoutView.this.pak) {
                    if (PTRLayoutView.this.state != 2 || PTRLayoutView.this.pae > PTRLayoutView.this.pag) {
                        if (PTRLayoutView.this.state == 4 && (-PTRLayoutView.this.paf) <= PTRLayoutView.this.pah) {
                            PTRLayoutView.this.paf = -PTRLayoutView.this.pah;
                            PTRLayoutView.this.pai.cancel();
                        }
                    } else {
                        PTRLayoutView.this.pae = PTRLayoutView.this.pag;
                        Log.i("heyn", "pullDownY: " + PTRLayoutView.this.pae);
                        PTRLayoutView.this.pai.cancel();
                    }
                }
                if (PTRLayoutView.this.pae <= 0.0f) {
                    if (PTRLayoutView.this.paf < 0.0f) {
                        PTRLayoutView.this.paf += PTRLayoutView.this.noJ;
                    }
                } else {
                    PTRLayoutView.this.pae -= PTRLayoutView.this.noJ;
                }
                if (PTRLayoutView.this.pae < 0.0f) {
                    PTRLayoutView.this.pae = 0.0f;
                    PTRLayoutView.this.pao.clearAnimation();
                    if (PTRLayoutView.this.state != 2 && PTRLayoutView.this.state != 4) {
                        PTRLayoutView.this.iC(0);
                    }
                    PTRLayoutView.this.pai.cancel();
                    PTRLayoutView.this.requestLayout();
                }
                if (PTRLayoutView.this.paf > 0.0f) {
                    PTRLayoutView.this.paf = 0.0f;
                    PTRLayoutView.this.pat.clearAnimation();
                    if (PTRLayoutView.this.state != 2 && PTRLayoutView.this.state != 4) {
                        PTRLayoutView.this.iC(0);
                    }
                    PTRLayoutView.this.pai.cancel();
                    PTRLayoutView.this.requestLayout();
                }
                Log.d("handle", "handle");
                PTRLayoutView.this.requestLayout();
                if (PTRLayoutView.this.pae + Math.abs(PTRLayoutView.this.paf) == 0.0f) {
                    PTRLayoutView.this.pai.cancel();
                }
            }
        };
        initView(context);
    }

    private void initView(Context context) {
        this.mContext = context;
        this.pai = new a(this.paC);
        this.pam = (RotateAnimation) AnimationUtils.loadAnimation(context, a.C0194a.reverse_anim);
        this.pan = (RotateAnimation) AnimationUtils.loadAnimation(context, a.C0194a.rotating);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        this.pam.setInterpolator(linearInterpolator);
        this.pan.setInterpolator(linearInterpolator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        this.pai.ic(5L);
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView$2] */
    public void NO(int i) {
        this.pap.clearAnimation();
        this.pap.setVisibility(8);
        switch (i) {
            case 0:
                this.paq.setVisibility(0);
                this.par.setText(a.h.refresh_succeed);
                break;
            default:
                this.paq.setVisibility(0);
                this.par.setText(a.h.refresh_fail);
                break;
        }
        if (this.pae > 0.0f) {
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
        this.pau.clearAnimation();
        this.pau.setVisibility(8);
        switch (i) {
            case 0:
                this.pav.setVisibility(0);
                this.paw.setText(a.h.load_succeed);
                this.pav.setBackgroundResource(a.e.load_succeed);
                break;
            case 1:
            default:
                this.pav.setVisibility(0);
                this.paw.setText(a.h.load_fail);
                this.pav.setBackgroundResource(a.e.load_failed);
                break;
            case 2:
                this.pav.setVisibility(0);
                this.paw.setText("没有更多数据");
                this.pav.setBackgroundResource(a.e.load_failed);
                break;
        }
        if (this.paf < 0.0f) {
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
                this.paq.setVisibility(8);
                this.par.setText(a.h.pull_to_refresh);
                this.pao.clearAnimation();
                this.pao.setVisibility(0);
                this.pav.setVisibility(8);
                this.paw.setText(a.h.pullup_to_load);
                this.pat.clearAnimation();
                this.pat.setVisibility(0);
                return;
            case 1:
                this.par.setText(a.h.release_to_refresh);
                this.pao.startAnimation(this.pam);
                return;
            case 2:
                this.pao.clearAnimation();
                this.pap.setVisibility(0);
                this.pao.setVisibility(4);
                this.pap.startAnimation(this.pan);
                this.par.setText(a.h.refreshing);
                return;
            case 3:
                this.paw.setText(a.h.release_to_load);
                this.pat.startAnimation(this.pam);
                return;
            case 4:
                this.pat.clearAnimation();
                this.pau.setVisibility(0);
                this.pat.setVisibility(4);
                this.pau.startAnimation(this.pan);
                this.paw.setText(a.h.loading);
                return;
            default:
                return;
        }
    }

    private void ekE() {
        this.paA = true;
        this.paB = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.bmB = motionEvent.getY();
                this.bmA = motionEvent.getX();
                this.fYr = this.bmB;
                this.pai.cancel();
                this.paz = 0;
                ekE();
                break;
            case 1:
                if (this.pae > this.pag || (-this.paf) > this.pah) {
                    this.pak = false;
                }
                if (this.state == 1) {
                    iC(2);
                    if (this.pac != null) {
                        this.pac.a(this);
                    }
                } else if (this.state == 3) {
                    iC(4);
                    if (this.pac != null) {
                        this.pac.b(this);
                    }
                }
                hide();
                break;
            case 2:
                float abs = Math.abs(motionEvent.getY() - this.bmB);
                float abs2 = Math.abs(motionEvent.getX() - this.bmA);
                if (this.paz == 0 && Math.pow(abs2, 2.0d) / Math.pow(abs, 2.0d) <= 3.0d) {
                    if (this.pae > 0.0f || (((com.baidu.yuyinala.privatemessage.session.view.smrlistview.a) this.pax).ekF() && this.paA && this.state != 4)) {
                        this.pae += (motionEvent.getY() - this.fYr) / this.pal;
                        if (this.pae < 0.0f) {
                            this.pae = 0.0f;
                            this.paA = false;
                            this.paB = true;
                        }
                        if (this.pae > getMeasuredHeight()) {
                            this.pae = getMeasuredHeight();
                        }
                        if (this.state == 2) {
                            this.pak = true;
                        }
                    } else if (this.paf < 0.0f || (((com.baidu.yuyinala.privatemessage.session.view.smrlistview.a) this.pax).ekG() && this.paB && this.state != 2)) {
                        this.paf += (motionEvent.getY() - this.fYr) / this.pal;
                        if (this.paf > 0.0f) {
                            this.paf = 0.0f;
                            this.paA = true;
                            this.paB = false;
                        }
                        if (this.paf < (-getMeasuredHeight())) {
                            this.paf = -getMeasuredHeight();
                        }
                        if (this.state == 4) {
                            this.pak = true;
                        }
                    } else {
                        ekE();
                    }
                } else {
                    this.paz = 0;
                }
                this.fYr = motionEvent.getY();
                this.pal = (float) ((Math.tan((1.5707963267948966d / getMeasuredHeight()) * (this.pae + Math.abs(this.paf))) * 2.0d) + 2.0d);
                if (this.pae > 0.0f || this.paf < 0.0f) {
                    requestLayout();
                }
                if (this.pae > 0.0f) {
                    if (this.pae <= this.pag && (this.state == 1 || this.state == 5)) {
                        iC(0);
                    }
                    if (this.pae >= this.pag && this.state == 0) {
                        iC(1);
                    }
                } else if (this.paf < 0.0f) {
                    if ((-this.paf) <= this.pah && (this.state == 3 || this.state == 5)) {
                        iC(0);
                    }
                    if ((-this.paf) >= this.pah && this.state == 0) {
                        iC(3);
                    }
                }
                if (this.pae + Math.abs(this.paf) > 8.0f) {
                    motionEvent.setAction(3);
                    break;
                }
                break;
            case 5:
            case 6:
                this.paz = -1;
                break;
        }
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    private void initView() {
        this.pao = this.fQx.findViewById(a.f.pull_icon);
        this.par = (TextView) this.fQx.findViewById(a.f.state_tv);
        this.pap = this.fQx.findViewById(a.f.refreshing_icon);
        this.paq = this.fQx.findViewById(a.f.state_iv);
        this.pat = this.pas.findViewById(a.f.pullup_icon);
        this.paw = (TextView) this.pas.findViewById(a.f.loadstate_tv);
        this.pau = this.pas.findViewById(a.f.loading_icon);
        this.pav = this.pas.findViewById(a.f.loadstate_iv);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Log.d("Test", "Test");
        if (!this.paj) {
            this.fQx = getChildAt(0);
            this.pax = getChildAt(1);
            this.pas = getChildAt(2);
            this.paj = true;
            initView();
            this.pag = ((ViewGroup) this.fQx).getChildAt(0).getMeasuredHeight();
            this.pah = ((ViewGroup) this.pas).getChildAt(0).getMeasuredHeight();
        }
        this.fQx.layout(0, ((int) (this.pae + this.paf)) - this.fQx.getMeasuredHeight(), this.fQx.getMeasuredWidth(), (int) (this.pae + this.paf));
        this.pax.layout(0, (int) (this.pae + this.paf), this.pax.getMeasuredWidth(), ((int) (this.pae + this.paf)) + this.pax.getMeasuredHeight());
        this.pas.layout(0, ((int) (this.pae + this.paf)) + this.pax.getMeasuredHeight(), this.pas.getMeasuredWidth(), ((int) (this.pae + this.paf)) + this.pax.getMeasuredHeight() + this.pas.getMeasuredHeight());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a {
        private Handler handler;
        private C0977a paE;
        private Timer timer = new Timer();

        public a(Handler handler) {
            this.handler = handler;
        }

        public void ic(long j) {
            if (this.paE != null) {
                this.paE.cancel();
                this.paE = null;
            }
            this.paE = new C0977a(this.handler);
            this.timer.schedule(this.paE, 0L, j);
        }

        public void cancel() {
            if (this.paE != null) {
                this.paE.cancel();
                this.paE = null;
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
