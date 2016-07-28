package com.baidu.tieba.pb.pb.main.a;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class f {
    private View bGN;
    private Animation bIs;
    private Animation bIt;
    private a ebv;
    private View eiN;
    private Context mContext;
    private boolean aml = false;
    private int aLv = 0;
    private boolean eiO = false;
    private boolean bIA = false;
    private boolean bIz = true;
    private final Handler.Callback bIB = new g(this);
    private final Handler mHandler = new Handler(this.bIB);
    private boolean bIy = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes.dex */
    public interface a {
        void hE(boolean z);
    }

    public void a(a aVar) {
        this.ebv = aVar;
    }

    public void dq(boolean z) {
        this.bIA = z;
    }

    public void ih(boolean z) {
        this.aml = z;
    }

    public f(Context context, View view, View view2) {
        this.mContext = context;
        this.eiN = view;
        this.bGN = view2;
        XD();
        ds(false);
    }

    private void Xs() {
        this.bIs = AnimationUtils.loadAnimation(this.mContext, u.a.bavigationbar_slide_out);
        this.bIs.setAnimationListener(new h(this));
    }

    private void Xt() {
        this.bIt = AnimationUtils.loadAnimation(this.mContext, u.a.bavigationbar_slide_in);
        this.bIt.setAnimationListener(new i(this));
    }

    public void Xu() {
        k(false, false);
    }

    public void Xv() {
        k(false, true);
    }

    public void k(boolean z, boolean z2) {
        if (this.eiN != null && this.eiN.getVisibility() == 0 && !XA()) {
            if (z2) {
                this.eiN.setVisibility(8);
                return;
            }
            if (this.bIs == null) {
                Xs();
            }
            if (this.bIt != null) {
                this.bIt.cancel();
            }
            this.eiN.startAnimation(this.bIs);
        }
    }

    public void Xw() {
        if (this.eiN != null && this.eiN.getVisibility() != 0 && !XA()) {
            this.eiN.setVisibility(0);
            if (this.bIt == null) {
                Xt();
            }
            if (this.bIs != null) {
                this.bIs.cancel();
            }
            this.eiN.startAnimation(this.bIt);
        }
    }

    public void Xx() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Xy() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Xz() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean XA() {
        return ac(this.eiN);
    }

    private boolean ac(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void XB() {
        if (this.bIz) {
            if (this.aml) {
                ds(true);
            } else if (this.eiN != null && this.eiN.getVisibility() != 8) {
                if (this.eiO) {
                    ds(false);
                } else {
                    Xy();
                }
            }
        }
    }

    public void XC() {
        if (this.bIz) {
            if (this.aml) {
                ds(true);
            } else if (this.eiN != null && this.eiN.getVisibility() != 0) {
                Xx();
            }
        }
    }

    public void ii(boolean z) {
        this.eiO = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.bIz && this.eiN != null) {
            if ((this.eiO || i > this.aLv) && this.eiN.getVisibility() != 8) {
                XB();
            } else if ((this.eiO || i < this.aLv) && this.eiN.getVisibility() != 0) {
                XC();
            }
            this.aLv = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.bIz) {
            if (this.aml) {
                ds(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.aLv) {
                    Xy();
                } else if (firstVisiblePosition < this.aLv) {
                    Xx();
                } else if (firstVisiblePosition == this.aLv) {
                    if (firstVisiblePosition == 0 || !this.bIA || b(absListView)) {
                        Xx();
                    } else {
                        Xy();
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

    private void XD() {
        if (this.bGN != null) {
            if (this.bIy && this.bGN.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bGN.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bGN.setLayoutParams(layoutParams);
                ds(true);
                return;
            }
            ds(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ds(boolean z) {
        if (this.bGN != null) {
            if (this.bIy && z && this.bGN.getVisibility() != 0) {
                this.bGN.setVisibility(0);
            } else if (!z && this.bGN.getVisibility() != 8) {
                this.bGN.setVisibility(8);
            }
        }
    }
}
