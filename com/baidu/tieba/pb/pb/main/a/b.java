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
    private View bZx;
    private a eGP;
    private Animation eSC;
    private Animation eSD;
    private View eSE;
    private Context mContext;
    private boolean avX = false;
    private int aLA = 0;
    private boolean eSF = false;
    private boolean eSG = false;
    private boolean aLB = false;
    private boolean bZz = true;
    private final Handler.Callback bZA = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.a.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.acp()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.aco();
                    return true;
                case 2:
                    b.this.acm();
                    return true;
                case 3:
                    b.this.acn();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.bZA);
    private boolean bZy = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes.dex */
    public interface a {
        void ep(boolean z);
    }

    public void a(a aVar) {
        this.eGP = aVar;
    }

    public void en(boolean z) {
        this.aLB = z;
    }

    public b(Context context, View view, View view2) {
        this.mContext = context;
        this.eSE = view;
        this.bZx = view2;
        acq();
        eo(false);
    }

    private void ack() {
        this.eSC = AnimationUtils.loadAnimation(this.mContext, d.a.bavigationbar_slide_out);
        this.eSC.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (b.this.eSE != null) {
                    b.this.eSE.clearAnimation();
                    b.this.eSE.setVisibility(8);
                    if (b.this.eSG) {
                        b.this.eo(false);
                    } else {
                        b.this.eo(true);
                    }
                    if (b.this.eGP != null) {
                        b.this.eGP.ep(false);
                    }
                }
            }
        });
    }

    private void acl() {
        this.eSD = AnimationUtils.loadAnimation(this.mContext, d.a.bavigationbar_slide_in);
        this.eSD.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (b.this.eSE != null) {
                    b.this.eSE.clearAnimation();
                    b.this.eSE.setVisibility(0);
                    b.this.eo(false);
                    if (b.this.eGP != null) {
                        b.this.eGP.ep(true);
                    }
                }
            }
        });
    }

    public void acm() {
        p(false, false);
    }

    public void acn() {
        p(false, true);
    }

    public void p(boolean z, boolean z2) {
        if (this.eSE != null && this.eSE.getVisibility() == 0 && !acp()) {
            if (z2) {
                this.eSE.setVisibility(8);
                if (this.eSG) {
                    eo(false);
                    return;
                } else {
                    eo(true);
                    return;
                }
            }
            if (this.eSC == null) {
                ack();
            }
            if (this.eSD != null) {
                this.eSD.cancel();
            }
            this.eSE.startAnimation(this.eSC);
        }
    }

    public void aco() {
        if (this.eSE != null && this.eSE.getVisibility() != 0 && !acp()) {
            this.eSE.setVisibility(0);
            if (this.eSD == null) {
                acl();
            }
            if (this.eSC != null) {
                this.eSC.cancel();
            }
            this.eSE.startAnimation(this.eSD);
        }
    }

    public void He() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Hf() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Hg() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean acp() {
        return aj(this.eSE);
    }

    private boolean aj(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void hideFloatingView() {
        if (this.bZz) {
            if (this.avX) {
                eo(true);
            } else if (this.eSE != null && !this.eSF && this.eSE.getVisibility() != 8) {
                Hf();
            }
        }
    }

    public void showFloatingView() {
        if (this.bZz) {
            if (this.avX) {
                eo(true);
            } else if (this.eSE != null && this.eSE.getVisibility() != 0) {
                He();
            }
        }
    }

    public void jR(boolean z) {
        this.eSF = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.bZz && this.eSE != null && !this.eSF) {
            if (i > this.aLA && this.eSE.getVisibility() != 8) {
                hideFloatingView();
            } else if (i < this.aLA && this.eSE.getVisibility() != 0) {
                showFloatingView();
            }
            this.aLA = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.bZz && !this.eSF) {
            if (this.avX) {
                eo(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.aLA) {
                    Hf();
                } else if (firstVisiblePosition < this.aLA) {
                    He();
                } else if (firstVisiblePosition == this.aLA) {
                    if (firstVisiblePosition == 0 || !this.aLB || a(absListView)) {
                        He();
                    } else {
                        Hf();
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

    private void acq() {
        if (this.bZx != null) {
            if (this.bZy && this.bZx.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bZx.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bZx.setLayoutParams(layoutParams);
                eo(true);
                return;
            }
            eo(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eo(boolean z) {
        if (this.bZx != null) {
            if (this.bZy && z && this.bZx.getVisibility() != 0) {
                this.bZx.setVisibility(0);
            } else if (!z && this.bZx.getVisibility() != 8) {
                this.bZx.setVisibility(8);
            }
        }
    }
}
