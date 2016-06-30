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
    private View bFz;
    private Animation bGW;
    private Animation bGX;
    private a dPh;
    private View dWk;
    private Context mContext;
    private boolean alw = false;
    private int aKC = 0;
    private boolean dWl = false;
    private boolean bHe = false;
    private boolean bHd = true;
    private final Handler.Callback bHf = new g(this);
    private final Handler mHandler = new Handler(this.bHf);
    private boolean bHc = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes.dex */
    public interface a {
        void ht(boolean z);
    }

    public void a(a aVar) {
        this.dPh = aVar;
    }

    public void dt(boolean z) {
        this.bHe = z;
    }

    public void hV(boolean z) {
        this.alw = z;
    }

    public f(Context context, View view, View view2) {
        this.mContext = context;
        this.dWk = view;
        this.bFz = view2;
        Xl();
        dv(false);
    }

    private void Xa() {
        this.bGW = AnimationUtils.loadAnimation(this.mContext, u.a.bavigationbar_slide_out);
        this.bGW.setAnimationListener(new h(this));
    }

    private void Xb() {
        this.bGX = AnimationUtils.loadAnimation(this.mContext, u.a.bavigationbar_slide_in);
        this.bGX.setAnimationListener(new i(this));
    }

    public void Xc() {
        k(false, false);
    }

    public void Xd() {
        k(false, true);
    }

    public void k(boolean z, boolean z2) {
        if (this.dWk != null && this.dWk.getVisibility() == 0 && !Xi()) {
            if (z2) {
                this.dWk.setVisibility(8);
                return;
            }
            if (this.bGW == null) {
                Xa();
            }
            if (this.bGX != null) {
                this.bGX.cancel();
            }
            this.dWk.startAnimation(this.bGW);
        }
    }

    public void Xe() {
        if (this.dWk != null && this.dWk.getVisibility() != 0 && !Xi()) {
            this.dWk.setVisibility(0);
            if (this.bGX == null) {
                Xb();
            }
            if (this.bGW != null) {
                this.bGW.cancel();
            }
            this.dWk.startAnimation(this.bGX);
        }
    }

    public void Xf() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Xg() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Xh() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean Xi() {
        return ae(this.dWk);
    }

    private boolean ae(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void Xj() {
        if (this.bHd) {
            if (this.alw) {
                dv(true);
            } else if (this.dWk != null && this.dWk.getVisibility() != 8) {
                if (this.dWl) {
                    dv(false);
                } else {
                    Xg();
                }
            }
        }
    }

    public void Xk() {
        if (this.bHd) {
            if (this.alw) {
                dv(true);
            } else if (this.dWk != null && this.dWk.getVisibility() != 0) {
                Xf();
            }
        }
    }

    public void hW(boolean z) {
        this.dWl = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.bHd && this.dWk != null) {
            if ((this.dWl || i > this.aKC) && this.dWk.getVisibility() != 8) {
                Xj();
            } else if ((this.dWl || i < this.aKC) && this.dWk.getVisibility() != 0) {
                Xk();
            }
            this.aKC = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.bHd) {
            if (this.alw) {
                dv(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.aKC) {
                    Xg();
                } else if (firstVisiblePosition < this.aKC) {
                    Xf();
                } else if (firstVisiblePosition == this.aKC) {
                    if (firstVisiblePosition == 0 || !this.bHe || b(absListView)) {
                        Xf();
                    } else {
                        Xg();
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

    private void Xl() {
        if (this.bFz != null) {
            if (this.bHc && this.bFz.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bFz.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bFz.setLayoutParams(layoutParams);
                dv(true);
                return;
            }
            dv(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dv(boolean z) {
        if (this.bFz != null) {
            if (this.bHc && z && this.bFz.getVisibility() != 0) {
                this.bFz.setVisibility(0);
            } else if (!z && this.bFz.getVisibility() != 8) {
                this.bFz.setVisibility(8);
            }
        }
    }
}
