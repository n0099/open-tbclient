package com.baidu.tieba.pb.pb.main.a;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class f {
    private View bAe;
    private Animation bIZ;
    private Animation bJa;
    private a eiw;
    private View eqC;
    private Context mContext;
    private boolean aoB = false;
    private int bAg = 0;
    private boolean eqD = false;
    private boolean eqE = false;
    private boolean bAh = false;
    private boolean bAi = true;
    private final Handler.Callback bAj = new g(this);
    private final Handler mHandler = new Handler(this.bAj);
    private boolean bAf = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes.dex */
    public interface a {
        void dm(boolean z);
    }

    public void a(a aVar) {
        this.eiw = aVar;
    }

    public void dk(boolean z) {
        this.bAh = z;
    }

    public void ja(boolean z) {
        this.aoB = z;
    }

    public f(Context context, View view, View view2) {
        this.mContext = context;
        this.eqC = view;
        this.bAe = view2;
        VO();
        dl(false);
    }

    private void VD() {
        this.bIZ = AnimationUtils.loadAnimation(this.mContext, r.a.bavigationbar_slide_out);
        this.bIZ.setAnimationListener(new h(this));
    }

    private void VE() {
        this.bJa = AnimationUtils.loadAnimation(this.mContext, r.a.bavigationbar_slide_in);
        this.bJa.setAnimationListener(new i(this));
    }

    public void VF() {
        m(false, false);
    }

    public void VG() {
        m(false, true);
    }

    public void m(boolean z, boolean z2) {
        if (this.eqC != null && this.eqC.getVisibility() == 0 && !VL()) {
            if (z2) {
                this.eqC.setVisibility(8);
                if (this.eqE) {
                    dl(false);
                    return;
                } else {
                    dl(true);
                    return;
                }
            }
            if (this.bIZ == null) {
                VD();
            }
            if (this.bJa != null) {
                this.bJa.cancel();
            }
            this.eqC.startAnimation(this.bIZ);
        }
    }

    public void VH() {
        if (this.eqC != null && this.eqC.getVisibility() != 0 && !VL()) {
            this.eqC.setVisibility(0);
            if (this.bJa == null) {
                VE();
            }
            if (this.bIZ != null) {
                this.bIZ.cancel();
            }
            this.eqC.startAnimation(this.bJa);
        }
    }

    public void VI() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void VJ() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void VK() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean VL() {
        return ah(this.eqC);
    }

    private boolean ah(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void VM() {
        if (this.bAi) {
            if (this.aoB) {
                dl(true);
            } else if (this.eqC != null && !this.eqD && this.eqC.getVisibility() != 8) {
                VJ();
            }
        }
    }

    public void VN() {
        if (this.bAi) {
            if (this.aoB) {
                dl(true);
            } else if (this.eqC != null && this.eqC.getVisibility() != 0) {
                VI();
            }
        }
    }

    public void jb(boolean z) {
        this.eqD = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.bAi && this.eqC != null && !this.eqD) {
            if (i > this.bAg && this.eqC.getVisibility() != 8) {
                VM();
            } else if (i < this.bAg && this.eqC.getVisibility() != 0) {
                VN();
            }
            this.bAg = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.bAi && !this.eqD) {
            if (this.aoB) {
                dl(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.bAg) {
                    VJ();
                } else if (firstVisiblePosition < this.bAg) {
                    VI();
                } else if (firstVisiblePosition == this.bAg) {
                    if (firstVisiblePosition == 0 || !this.bAh || b(absListView)) {
                        VI();
                    } else {
                        VJ();
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

    private void VO() {
        if (this.bAe != null) {
            if (this.bAf && this.bAe.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bAe.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bAe.setLayoutParams(layoutParams);
                dl(true);
                return;
            }
            dl(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl(boolean z) {
        if (this.bAe != null) {
            if (this.bAf && z && this.bAe.getVisibility() != 0) {
                this.bAe.setVisibility(0);
            } else if (!z && this.bAe.getVisibility() != 8) {
                this.bAe.setVisibility(8);
            }
        }
    }
}
