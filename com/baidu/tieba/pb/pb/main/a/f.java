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
    private View bkp;
    private Animation bmG;
    private Animation bmH;
    private a djh;
    private View dpN;
    private Context mContext;
    private boolean akP = false;
    private int bmL = 0;
    private boolean bmP = false;
    private boolean bmO = true;
    private final Handler.Callback bmQ = new g(this);
    private final Handler mHandler = new Handler(this.bmQ);
    private boolean bmN = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes.dex */
    public interface a {
        void gA(boolean z);
    }

    public void a(a aVar) {
        this.djh = aVar;
    }

    public void cX(boolean z) {
        this.bmP = z;
    }

    public void hc(boolean z) {
        this.akP = z;
    }

    public f(Context context, View view, View view2) {
        this.mContext = context;
        this.dpN = view;
        this.bkp = view2;
        RT();
    }

    private void RI() {
        this.bmG = AnimationUtils.loadAnimation(this.mContext, t.a.bavigationbar_slide_out);
        this.bmG.setAnimationListener(new h(this));
    }

    private void RJ() {
        this.bmH = AnimationUtils.loadAnimation(this.mContext, t.a.bavigationbar_slide_in);
        this.bmH.setAnimationListener(new i(this));
    }

    public void RK() {
        j(false, false);
    }

    public void RL() {
        j(false, true);
    }

    public void j(boolean z, boolean z2) {
        if (this.dpN != null && this.dpN.getVisibility() == 0 && !RQ()) {
            if (z2) {
                this.dpN.setVisibility(8);
                return;
            }
            if (this.bmG == null) {
                RI();
            }
            this.dpN.startAnimation(this.bmG);
        }
    }

    public void RM() {
        if (this.dpN != null && this.dpN.getVisibility() != 0 && !RQ()) {
            this.dpN.setVisibility(0);
            if (this.bmH == null) {
                RJ();
            }
            this.dpN.startAnimation(this.bmH);
        }
    }

    public void RN() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void RO() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void RP() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean RQ() {
        return ac(this.dpN);
    }

    private boolean ac(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void RR() {
        if (this.bmO) {
            if (this.akP) {
                cZ(true);
            } else if (this.dpN != null && this.dpN.getVisibility() != 8) {
                RO();
                cZ(true);
            }
        }
    }

    public void RS() {
        if (this.bmO) {
            if (this.akP) {
                cZ(true);
            } else if (this.dpN != null && this.dpN.getVisibility() != 0) {
                RN();
                cZ(false);
            }
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.bmO && this.dpN != null) {
            if (i > this.bmL && this.dpN.getVisibility() != 8) {
                RR();
            } else if (i < this.bmL && this.dpN.getVisibility() != 0) {
                RS();
            }
            this.bmL = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.bmO) {
            if (this.akP) {
                cZ(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.bmL) {
                    RO();
                } else if (firstVisiblePosition < this.bmL) {
                    RN();
                } else if (firstVisiblePosition == this.bmL) {
                    if (firstVisiblePosition == 0 || !this.bmP || b(absListView)) {
                        RN();
                    } else {
                        RO();
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

    private void RT() {
        if (this.bkp != null) {
            if (this.bmN && this.bkp.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bkp.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bkp.setLayoutParams(layoutParams);
                cZ(true);
                return;
            }
            cZ(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZ(boolean z) {
        if (this.bkp != null) {
            if (this.bmN && z && this.bkp.getVisibility() != 0) {
                this.bkp.setVisibility(0);
            } else if (!z && this.bkp.getVisibility() != 8) {
                this.bkp.setVisibility(8);
            }
        }
    }
}
