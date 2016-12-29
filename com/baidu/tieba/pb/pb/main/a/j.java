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
public class j {
    private Animation bBF;
    private Animation bBG;
    private View bst;
    private a dZJ;
    private View ehv;
    private Context mContext;
    private boolean apw = false;
    private int aSJ = 0;
    private boolean ehw = false;
    private boolean bsv = false;
    private boolean bsw = true;
    private final Handler.Callback bsx = new k(this);
    private final Handler mHandler = new Handler(this.bsx);
    private boolean bsu = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes.dex */
    public interface a {
        void df(boolean z);
    }

    public void a(a aVar) {
        this.dZJ = aVar;
    }

    public void dd(boolean z) {
        this.bsv = z;
    }

    public void iO(boolean z) {
        this.apw = z;
    }

    public void iP(boolean z) {
        this.ehw = z;
    }

    public j(Context context, View view, View view2) {
        this.mContext = context;
        this.ehv = view;
        this.bst = view2;
        Ut();
        de(false);
    }

    private void Ui() {
        this.bBF = AnimationUtils.loadAnimation(this.mContext, r.a.bavigationbar_slide_out);
        this.bBF.setAnimationListener(new l(this));
    }

    private void Uj() {
        this.bBG = AnimationUtils.loadAnimation(this.mContext, r.a.bavigationbar_slide_in);
        this.bBG.setAnimationListener(new m(this));
    }

    public void Uk() {
        m(false, false);
    }

    public void Ul() {
        m(false, true);
    }

    public void m(boolean z, boolean z2) {
        if (this.ehv != null && this.ehv.getVisibility() == 0 && !Uq()) {
            if (z2) {
                this.ehv.setVisibility(8);
                if (this.ehw) {
                    de(false);
                    return;
                } else {
                    de(true);
                    return;
                }
            }
            if (this.bBF == null) {
                Ui();
            }
            if (this.bBG != null) {
                this.bBG.cancel();
            }
            this.ehv.startAnimation(this.bBF);
        }
    }

    public void Um() {
        if (this.ehv != null && this.ehv.getVisibility() != 0 && !Uq()) {
            this.ehv.setVisibility(0);
            if (this.bBG == null) {
                Uj();
            }
            if (this.bBF != null) {
                this.bBF.cancel();
            }
            this.ehv.startAnimation(this.bBG);
        }
    }

    public void Un() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Uo() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Up() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean Uq() {
        return ac(this.ehv);
    }

    private boolean ac(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void Ur() {
        if (this.bsw) {
            if (this.apw) {
                de(true);
            } else if (this.ehv != null && this.ehv.getVisibility() != 8) {
                Uo();
            }
        }
    }

    public void Us() {
        if (this.bsw) {
            if (this.apw) {
                de(true);
            } else if (this.ehv != null && this.ehv.getVisibility() != 0) {
                Un();
            }
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.bsw && this.ehv != null) {
            if (i > this.aSJ && this.ehv.getVisibility() != 8) {
                Ur();
            } else if (i < this.aSJ && this.ehv.getVisibility() != 0) {
                Us();
            }
            this.aSJ = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.bsw) {
            if (this.apw) {
                de(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.aSJ) {
                    Uo();
                } else if (firstVisiblePosition < this.aSJ) {
                    Un();
                } else if (firstVisiblePosition == this.aSJ) {
                    if (firstVisiblePosition == 0 || !this.bsv || b(absListView)) {
                        Un();
                    } else {
                        Uo();
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

    private void Ut() {
        if (this.bst != null) {
            if (this.bsu && this.bst.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bst.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bst.setLayoutParams(layoutParams);
                de(true);
                return;
            }
            de(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void de(boolean z) {
        if (this.bst != null) {
            if (this.bsu && z && this.bst.getVisibility() != 0) {
                this.bst.setVisibility(0);
            } else if (!z && this.bst.getVisibility() != 8) {
                this.bst.setVisibility(8);
            }
        }
    }
}
