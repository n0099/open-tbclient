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
    private View bMp;
    private Animation bVx;
    private Animation bVy;
    private View eDt;
    private a evn;
    private Context mContext;
    private boolean apU = false;
    private int aTs = 0;
    private boolean eDu = false;
    private boolean eDv = false;
    private boolean bMr = false;
    private boolean bMs = true;
    private final Handler.Callback bMt = new k(this);
    private final Handler mHandler = new Handler(this.bMt);
    private boolean bMq = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes.dex */
    public interface a {
        void dx(boolean z);
    }

    public void a(a aVar) {
        this.evn = aVar;
    }

    public void dv(boolean z) {
        this.bMr = z;
    }

    public void jc(boolean z) {
        this.apU = z;
    }

    public void jd(boolean z) {
        this.eDv = z;
    }

    public j(Context context, View view, View view2) {
        this.mContext = context;
        this.eDt = view;
        this.bMp = view2;
        aag();
        dw(false);
    }

    private void ZV() {
        this.bVx = AnimationUtils.loadAnimation(this.mContext, r.a.bavigationbar_slide_out);
        this.bVx.setAnimationListener(new l(this));
    }

    private void ZW() {
        this.bVy = AnimationUtils.loadAnimation(this.mContext, r.a.bavigationbar_slide_in);
        this.bVy.setAnimationListener(new m(this));
    }

    public void ZX() {
        l(false, false);
    }

    public void ZY() {
        l(false, true);
    }

    public void l(boolean z, boolean z2) {
        if (this.eDt != null && this.eDt.getVisibility() == 0 && !aad()) {
            if (z2) {
                this.eDt.setVisibility(8);
                if (this.eDv) {
                    dw(false);
                    return;
                } else {
                    dw(true);
                    return;
                }
            }
            if (this.bVx == null) {
                ZV();
            }
            if (this.bVy != null) {
                this.bVy.cancel();
            }
            this.eDt.startAnimation(this.bVx);
        }
    }

    public void ZZ() {
        if (this.eDt != null && this.eDt.getVisibility() != 0 && !aad()) {
            this.eDt.setVisibility(0);
            if (this.bVy == null) {
                ZW();
            }
            if (this.bVx != null) {
                this.bVx.cancel();
            }
            this.eDt.startAnimation(this.bVy);
        }
    }

    public void aaa() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void aab() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void aac() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean aad() {
        return ac(this.eDt);
    }

    private boolean ac(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void aae() {
        if (this.bMs) {
            if (this.apU) {
                dw(true);
            } else if (this.eDt != null && this.eDt.getVisibility() != 8) {
                if (this.eDu) {
                    dw(false);
                } else {
                    aab();
                }
            }
        }
    }

    public void aaf() {
        if (this.bMs) {
            if (this.apU) {
                dw(true);
            } else if (this.eDt != null && this.eDt.getVisibility() != 0) {
                aaa();
            }
        }
    }

    public void je(boolean z) {
        this.eDu = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.bMs && this.eDt != null) {
            if ((this.eDu || i > this.aTs) && this.eDt.getVisibility() != 8) {
                aae();
            } else if ((this.eDu || i < this.aTs) && this.eDt.getVisibility() != 0) {
                aaf();
            }
            this.aTs = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.bMs) {
            if (this.apU) {
                dw(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.aTs) {
                    aab();
                } else if (firstVisiblePosition < this.aTs) {
                    aaa();
                } else if (firstVisiblePosition == this.aTs) {
                    if (firstVisiblePosition == 0 || !this.bMr || b(absListView)) {
                        aaa();
                    } else {
                        aab();
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

    private void aag() {
        if (this.bMp != null) {
            if (this.bMq && this.bMp.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bMp.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bMp.setLayoutParams(layoutParams);
                dw(true);
                return;
            }
            dw(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dw(boolean z) {
        if (this.bMp != null) {
            if (this.bMq && z && this.bMp.getVisibility() != 0) {
                this.bMp.setVisibility(0);
            } else if (!z && this.bMp.getVisibility() != 8) {
                this.bMp.setVisibility(8);
            }
        }
    }
}
