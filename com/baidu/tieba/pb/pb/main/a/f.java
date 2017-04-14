package com.baidu.tieba.pb.pb.main.a;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class f {
    private View bHd;
    private Animation bPX;
    private Animation bPY;
    private a ejv;
    private View erM;
    private Context mContext;
    private boolean aum = false;
    private int bHf = 0;
    private boolean erN = false;
    private boolean erO = false;
    private boolean bHg = false;
    private boolean bHh = true;
    private final Handler.Callback bHi = new g(this);
    private final Handler mHandler = new Handler(this.bHi);
    private boolean bHe = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes.dex */
    public interface a {
        /* renamed from: do  reason: not valid java name */
        void mo23do(boolean z);
    }

    public void a(a aVar) {
        this.ejv = aVar;
    }

    public void dm(boolean z) {
        this.bHg = z;
    }

    public void iT(boolean z) {
        this.aum = z;
    }

    public f(Context context, View view, View view2) {
        this.mContext = context;
        this.erM = view;
        this.bHd = view2;
        Xk();
        dn(false);
    }

    private void WZ() {
        this.bPX = AnimationUtils.loadAnimation(this.mContext, w.a.bavigationbar_slide_out);
        this.bPX.setAnimationListener(new h(this));
    }

    private void Xa() {
        this.bPY = AnimationUtils.loadAnimation(this.mContext, w.a.bavigationbar_slide_in);
        this.bPY.setAnimationListener(new i(this));
    }

    public void Xb() {
        l(false, false);
    }

    public void Xc() {
        l(false, true);
    }

    public void l(boolean z, boolean z2) {
        if (this.erM != null && this.erM.getVisibility() == 0 && !Xh()) {
            if (z2) {
                this.erM.setVisibility(8);
                if (this.erO) {
                    dn(false);
                    return;
                } else {
                    dn(true);
                    return;
                }
            }
            if (this.bPX == null) {
                WZ();
            }
            if (this.bPY != null) {
                this.bPY.cancel();
            }
            this.erM.startAnimation(this.bPX);
        }
    }

    public void Xd() {
        if (this.erM != null && this.erM.getVisibility() != 0 && !Xh()) {
            this.erM.setVisibility(0);
            if (this.bPY == null) {
                Xa();
            }
            if (this.bPX != null) {
                this.bPX.cancel();
            }
            this.erM.startAnimation(this.bPY);
        }
    }

    public void Xe() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Xf() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Xg() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean Xh() {
        return af(this.erM);
    }

    private boolean af(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void Xi() {
        if (this.bHh) {
            if (this.aum) {
                dn(true);
            } else if (this.erM != null && !this.erN && this.erM.getVisibility() != 8) {
                Xf();
            }
        }
    }

    public void Xj() {
        if (this.bHh) {
            if (this.aum) {
                dn(true);
            } else if (this.erM != null && this.erM.getVisibility() != 0) {
                Xe();
            }
        }
    }

    public void iU(boolean z) {
        this.erN = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.bHh && this.erM != null && !this.erN) {
            if (i > this.bHf && this.erM.getVisibility() != 8) {
                Xi();
            } else if (i < this.bHf && this.erM.getVisibility() != 0) {
                Xj();
            }
            this.bHf = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.bHh && !this.erN) {
            if (this.aum) {
                dn(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.bHf) {
                    Xf();
                } else if (firstVisiblePosition < this.bHf) {
                    Xe();
                } else if (firstVisiblePosition == this.bHf) {
                    if (firstVisiblePosition == 0 || !this.bHg || b(absListView)) {
                        Xe();
                    } else {
                        Xf();
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

    private void Xk() {
        if (this.bHd != null) {
            if (this.bHe && this.bHd.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bHd.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bHd.setLayoutParams(layoutParams);
                dn(true);
                return;
            }
            dn(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dn(boolean z) {
        if (this.bHd != null) {
            if (this.bHe && z && this.bHd.getVisibility() != 0) {
                this.bHd.setVisibility(0);
            } else if (!z && this.bHd.getVisibility() != 8) {
                this.bHd.setVisibility(8);
            }
        }
    }
}
