package com.baidu.tieba.recommendfrs.control;

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
public class m {
    private View bkp;
    private Animation bmG;
    private Animation bmH;
    private View dZa;
    private Context mContext;
    private int bmL = 0;
    private boolean bmP = false;
    private final Handler.Callback bmQ = new n(this);
    private final Handler mHandler = new Handler(this.bmQ);
    private boolean bmN = UtilHelper.canUseStyleImmersiveSticky();

    public void cX(boolean z) {
        this.bmP = z;
    }

    public m(Context context, View view, View view2) {
        this.mContext = context;
        this.dZa = view;
        this.bkp = view2;
        RT();
    }

    private void RI() {
        this.bmG = AnimationUtils.loadAnimation(this.mContext, t.a.bavigationbar_slide_out);
        this.bmG.setAnimationListener(new o(this));
    }

    private void RJ() {
        this.bmH = AnimationUtils.loadAnimation(this.mContext, t.a.bavigationbar_slide_in);
        this.bmH.setAnimationListener(new p(this));
    }

    public void RK() {
        j(false, false);
    }

    public void RL() {
        j(false, true);
    }

    public void j(boolean z, boolean z2) {
        if (this.dZa != null && this.dZa.getVisibility() == 0 && !RQ()) {
            if (z2) {
                this.dZa.setVisibility(8);
                return;
            }
            if (this.bmG == null) {
                RI();
            }
            this.dZa.startAnimation(this.bmG);
        }
    }

    public void RM() {
        if (this.dZa != null && this.dZa.getVisibility() != 0 && !RQ()) {
            this.dZa.setVisibility(0);
            if (this.bmH == null) {
                RJ();
            }
            this.dZa.startAnimation(this.bmH);
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
        return ac(this.dZa);
    }

    private boolean ac(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void iM(boolean z) {
        if (this.dZa != null) {
            if (z || this.dZa.getVisibility() != 8) {
                RO();
                cZ(true);
            }
        }
    }

    public void iN(boolean z) {
        if (this.dZa != null) {
            if (z || this.dZa.getVisibility() != 0) {
                RN();
                cZ(false);
            }
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
        if (this.dZa != null) {
            if (i2 > i && this.dZa.getVisibility() != 8) {
                iM(false);
            } else if (i2 < i && this.dZa.getVisibility() != 0) {
                iN(false);
            }
            this.bmL = i2;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > this.bmL) {
                iM(true);
            } else if (firstVisiblePosition < this.bmL) {
                iN(true);
            } else if (firstVisiblePosition == this.bmL) {
                if (firstVisiblePosition == 0 || !this.bmP || b(absListView)) {
                    iN(true);
                } else {
                    iM(true);
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
