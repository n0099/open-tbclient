package com.baidu.tieba.pb.pb.main.a;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b {
    private View caD;
    private a eIc;
    private Animation eTP;
    private Animation eTQ;
    private View eTR;
    private Context mContext;
    private boolean axo = false;
    private int aMP = 0;
    private boolean eTS = false;
    private boolean eTT = false;
    private boolean aMQ = false;
    private boolean caF = true;
    private final Handler.Callback caG = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.a.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.acu()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.act();
                    return true;
                case 2:
                    b.this.acr();
                    return true;
                case 3:
                    b.this.acs();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.caG);
    private boolean caE = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes.dex */
    public interface a {
        void ep(boolean z);
    }

    public void a(a aVar) {
        this.eIc = aVar;
    }

    public void en(boolean z) {
        this.aMQ = z;
    }

    public b(Context context, View view, View view2) {
        this.mContext = context;
        this.eTR = view;
        this.caD = view2;
        acv();
        eo(false);
    }

    private void acp() {
        this.eTP = AnimationUtils.loadAnimation(this.mContext, d.a.bavigationbar_slide_out);
        this.eTP.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (b.this.eTR != null) {
                    b.this.eTR.clearAnimation();
                    b.this.eTR.setVisibility(8);
                    if (b.this.eTT) {
                        b.this.eo(false);
                    } else {
                        b.this.eo(true);
                    }
                    if (b.this.eIc != null) {
                        b.this.eIc.ep(false);
                    }
                }
            }
        });
    }

    private void acq() {
        this.eTQ = AnimationUtils.loadAnimation(this.mContext, d.a.bavigationbar_slide_in);
        this.eTQ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (b.this.eTR != null) {
                    b.this.eTR.clearAnimation();
                    b.this.eTR.setVisibility(0);
                    b.this.eo(false);
                    if (b.this.eIc != null) {
                        b.this.eIc.ep(true);
                    }
                }
            }
        });
    }

    public void acr() {
        p(false, false);
    }

    public void acs() {
        p(false, true);
    }

    public void p(boolean z, boolean z2) {
        if (this.eTR != null && this.eTR.getVisibility() == 0 && !acu()) {
            if (z2) {
                this.eTR.setVisibility(8);
                if (this.eTT) {
                    eo(false);
                    return;
                } else {
                    eo(true);
                    return;
                }
            }
            if (this.eTP == null) {
                acp();
            }
            if (this.eTQ != null) {
                this.eTQ.cancel();
            }
            this.eTR.startAnimation(this.eTP);
        }
    }

    public void act() {
        if (this.eTR != null && this.eTR.getVisibility() != 0 && !acu()) {
            this.eTR.setVisibility(0);
            if (this.eTQ == null) {
                acq();
            }
            if (this.eTP != null) {
                this.eTP.cancel();
            }
            this.eTR.startAnimation(this.eTQ);
        }
    }

    public void Hm() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Hn() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Ho() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean acu() {
        return aj(this.eTR);
    }

    private boolean aj(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void hideFloatingView() {
        if (this.caF) {
            if (this.axo) {
                eo(true);
            } else if (this.eTR != null && !this.eTS && this.eTR.getVisibility() != 8) {
                Hn();
            }
        }
    }

    public void showFloatingView() {
        if (this.caF) {
            if (this.axo) {
                eo(true);
            } else if (this.eTR != null && this.eTR.getVisibility() != 0) {
                Hm();
            }
        }
    }

    public void jR(boolean z) {
        this.eTS = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.caF && this.eTR != null && !this.eTS) {
            if (i > this.aMP && this.eTR.getVisibility() != 8) {
                hideFloatingView();
            } else if (i < this.aMP && this.eTR.getVisibility() != 0) {
                showFloatingView();
            }
            this.aMP = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.caF && !this.eTS) {
            if (this.axo) {
                eo(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.aMP) {
                    Hn();
                } else if (firstVisiblePosition < this.aMP) {
                    Hm();
                } else if (firstVisiblePosition == this.aMP) {
                    if (firstVisiblePosition == 0 || !this.aMQ || a(absListView)) {
                        Hm();
                    } else {
                        Hn();
                    }
                }
            }
        }
    }

    public boolean a(AbsListView absListView) {
        if (absListView != null) {
            return (absListView.getChildCount() == 0 && absListView.getChildAt(0) == null) || absListView.getChildAt(0).getTop() == 0;
        }
        return true;
    }

    private void acv() {
        if (this.caD != null) {
            if (this.caE && this.caD.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.caD.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.caD.setLayoutParams(layoutParams);
                eo(true);
                return;
            }
            eo(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eo(boolean z) {
        if (this.caD != null) {
            if (this.caE && z && this.caD.getVisibility() != 0) {
                this.caD.setVisibility(0);
            } else if (!z && this.caD.getVisibility() != 8) {
                this.caD.setVisibility(8);
            }
        }
    }
}
