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
    private View bOo;
    private a emC;
    private Animation ewE;
    private Animation ewF;
    private View ewG;
    private Context mContext;
    private boolean auc = false;
    private int aJd = 0;
    private boolean ewH = false;
    private boolean ewI = false;
    private boolean aJe = false;
    private boolean bOq = true;
    private final Handler.Callback bOr = new g(this);
    private final Handler mHandler = new Handler(this.bOr);
    private boolean bOp = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes.dex */
    public interface a {
        void dQ(boolean z);
    }

    public void a(a aVar) {
        this.emC = aVar;
    }

    public void dO(boolean z) {
        this.aJe = z;
    }

    public f(Context context, View view, View view2) {
        this.mContext = context;
        this.ewG = view;
        this.bOo = view2;
        Yf();
        dP(false);
    }

    private void XX() {
        this.ewE = AnimationUtils.loadAnimation(this.mContext, w.a.bavigationbar_slide_out);
        this.ewE.setAnimationListener(new h(this));
    }

    private void XY() {
        this.ewF = AnimationUtils.loadAnimation(this.mContext, w.a.bavigationbar_slide_in);
        this.ewF.setAnimationListener(new i(this));
    }

    public void XZ() {
        n(false, false);
    }

    public void Ya() {
        n(false, true);
    }

    public void n(boolean z, boolean z2) {
        if (this.ewG != null && this.ewG.getVisibility() == 0 && !Yc()) {
            if (z2) {
                this.ewG.setVisibility(8);
                if (this.ewI) {
                    dP(false);
                    return;
                } else {
                    dP(true);
                    return;
                }
            }
            if (this.ewE == null) {
                XX();
            }
            if (this.ewF != null) {
                this.ewF.cancel();
            }
            this.ewG.startAnimation(this.ewE);
        }
    }

    public void Yb() {
        if (this.ewG != null && this.ewG.getVisibility() != 0 && !Yc()) {
            this.ewG.setVisibility(0);
            if (this.ewF == null) {
                XY();
            }
            if (this.ewE != null) {
                this.ewE.cancel();
            }
            this.ewG.startAnimation(this.ewF);
        }
    }

    public void Gs() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Gt() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Gu() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean Yc() {
        return ad(this.ewG);
    }

    private boolean ad(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void Yd() {
        if (this.bOq) {
            if (this.auc) {
                dP(true);
            } else if (this.ewG != null && !this.ewH && this.ewG.getVisibility() != 8) {
                Gt();
            }
        }
    }

    public void Ye() {
        if (this.bOq) {
            if (this.auc) {
                dP(true);
            } else if (this.ewG != null && this.ewG.getVisibility() != 0) {
                Gs();
            }
        }
    }

    public void iY(boolean z) {
        this.ewH = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.bOq && this.ewG != null && !this.ewH) {
            if (i > this.aJd && this.ewG.getVisibility() != 8) {
                Yd();
            } else if (i < this.aJd && this.ewG.getVisibility() != 0) {
                Ye();
            }
            this.aJd = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.bOq && !this.ewH) {
            if (this.auc) {
                dP(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.aJd) {
                    Gt();
                } else if (firstVisiblePosition < this.aJd) {
                    Gs();
                } else if (firstVisiblePosition == this.aJd) {
                    if (firstVisiblePosition == 0 || !this.aJe || a(absListView)) {
                        Gs();
                    } else {
                        Gt();
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

    private void Yf() {
        if (this.bOo != null) {
            if (this.bOp && this.bOo.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bOo.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bOo.setLayoutParams(layoutParams);
                dP(true);
                return;
            }
            dP(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dP(boolean z) {
        if (this.bOo != null) {
            if (this.bOp && z && this.bOo.getVisibility() != 0) {
                this.bOo.setVisibility(0);
            } else if (!z && this.bOo.getVisibility() != 8) {
                this.bOo.setVisibility(8);
            }
        }
    }
}
