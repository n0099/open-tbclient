package com.baidu.tieba.pb.pb.main.a;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class f {
    private View bJv;
    private Animation bTy;
    private Animation bTz;
    private a enD;
    private View euU;
    private Context mContext;
    private boolean aps = false;
    private int aQi = 0;
    private boolean euV = false;
    private boolean bJx = false;
    private boolean bJy = true;
    private final Handler.Callback bJz = new g(this);
    private final Handler mHandler = new Handler(this.bJz);
    private boolean bJw = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes.dex */
    public interface a {
        void dr(boolean z);
    }

    public void a(a aVar) {
        this.enD = aVar;
    }

    public void dp(boolean z) {
        this.bJx = z;
    }

    public void iC(boolean z) {
        this.aps = z;
    }

    public f(Context context, View view, View view2) {
        this.mContext = context;
        this.euU = view;
        this.bJv = view2;
        YP();
        dq(false);
    }

    private void YF() {
        this.bTy = AnimationUtils.loadAnimation(this.mContext, t.a.bavigationbar_slide_out);
        this.bTy.setAnimationListener(new h(this));
    }

    private void YG() {
        this.bTz = AnimationUtils.loadAnimation(this.mContext, t.a.bavigationbar_slide_in);
        this.bTz.setAnimationListener(new i(this));
    }

    public void YH() {
        m(false, false);
    }

    public void YI() {
        m(false, true);
    }

    public void m(boolean z, boolean z2) {
        if (this.euU != null && this.euU.getVisibility() == 0 && !YM()) {
            if (z2) {
                this.euU.setVisibility(8);
                return;
            }
            if (this.bTy == null) {
                YF();
            }
            if (this.bTz != null) {
                this.bTz.cancel();
            }
            this.euU.startAnimation(this.bTy);
        }
    }

    public void YJ() {
        if (this.euU != null && this.euU.getVisibility() != 0 && !YM()) {
            this.euU.setVisibility(0);
            if (this.bTz == null) {
                YG();
            }
            if (this.bTy != null) {
                this.bTy.cancel();
            }
            this.euU.startAnimation(this.bTz);
        }
    }

    public void YK() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void YL() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void aco() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean YM() {
        return ac(this.euU);
    }

    private boolean ac(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void YN() {
        if (this.bJy) {
            if (this.aps) {
                dq(true);
            } else if (this.euU != null && this.euU.getVisibility() != 8) {
                if (this.euV) {
                    dq(false);
                } else {
                    YL();
                }
            }
        }
    }

    public void YO() {
        if (this.bJy) {
            if (this.aps) {
                dq(true);
            } else if (this.euU != null && this.euU.getVisibility() != 0) {
                YK();
            }
        }
    }

    public void iD(boolean z) {
        this.euV = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.bJy && this.euU != null) {
            if ((this.euV || i > this.aQi) && this.euU.getVisibility() != 8) {
                YN();
            } else if ((this.euV || i < this.aQi) && this.euU.getVisibility() != 0) {
                YO();
            }
            this.aQi = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.bJy) {
            if (this.aps) {
                dq(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.aQi) {
                    YL();
                } else if (firstVisiblePosition < this.aQi) {
                    YK();
                } else if (firstVisiblePosition == this.aQi) {
                    if (firstVisiblePosition == 0 || !this.bJx || b(absListView)) {
                        YK();
                    } else {
                        YL();
                    }
                }
            }
        }
    }

    public boolean b(AbsListView absListView) {
        if (absListView != null) {
            return (absListView.getChildCount() == 0 && absListView.getChildAt(0) == null) || absListView.getChildAt(0).getTop() == 0;
        }
        return true;
    }

    private void YP() {
        if (this.bJv != null) {
            if (this.bJw && this.bJv.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bJv.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bJv.setLayoutParams(layoutParams);
                dq(true);
                return;
            }
            dq(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dq(boolean z) {
        if (this.bJv != null) {
            if (this.bJw && z && this.bJv.getVisibility() != 0) {
                this.bJv.setVisibility(0);
            } else if (!z && this.bJv.getVisibility() != 8) {
                this.bJv.setVisibility(8);
            }
        }
    }
}
