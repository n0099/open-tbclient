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
    private View bJw;
    private Animation bTr;
    private Animation bTs;
    private a epC;
    private View exa;
    private Context mContext;
    private boolean aoZ = false;
    private int aRr = 0;
    private boolean exb = false;
    private boolean bJy = false;
    private boolean bJz = true;
    private final Handler.Callback bJA = new g(this);
    private final Handler mHandler = new Handler(this.bJA);
    private boolean bJx = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes.dex */
    public interface a {
        void ds(boolean z);
    }

    public void a(a aVar) {
        this.epC = aVar;
    }

    public void dq(boolean z) {
        this.bJy = z;
    }

    public void iF(boolean z) {
        this.aoZ = z;
    }

    public f(Context context, View view, View view2) {
        this.mContext = context;
        this.exa = view;
        this.bJw = view2;
        Ze();
        dr(false);
    }

    private void YT() {
        this.bTr = AnimationUtils.loadAnimation(this.mContext, r.a.bavigationbar_slide_out);
        this.bTr.setAnimationListener(new h(this));
    }

    private void YU() {
        this.bTs = AnimationUtils.loadAnimation(this.mContext, r.a.bavigationbar_slide_in);
        this.bTs.setAnimationListener(new i(this));
    }

    public void YV() {
        m(false, false);
    }

    public void YW() {
        m(false, true);
    }

    public void m(boolean z, boolean z2) {
        if (this.exa != null && this.exa.getVisibility() == 0 && !Zb()) {
            if (z2) {
                this.exa.setVisibility(8);
                return;
            }
            if (this.bTr == null) {
                YT();
            }
            if (this.bTs != null) {
                this.bTs.cancel();
            }
            this.exa.startAnimation(this.bTr);
        }
    }

    public void YX() {
        if (this.exa != null && this.exa.getVisibility() != 0 && !Zb()) {
            this.exa.setVisibility(0);
            if (this.bTs == null) {
                YU();
            }
            if (this.bTr != null) {
                this.bTr.cancel();
            }
            this.exa.startAnimation(this.bTs);
        }
    }

    public void YY() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void YZ() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Za() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean Zb() {
        return ab(this.exa);
    }

    private boolean ab(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void Zc() {
        if (this.bJz) {
            if (this.aoZ) {
                dr(true);
            } else if (this.exa != null && this.exa.getVisibility() != 8) {
                if (this.exb) {
                    dr(false);
                } else {
                    YZ();
                }
            }
        }
    }

    public void Zd() {
        if (this.bJz) {
            if (this.aoZ) {
                dr(true);
            } else if (this.exa != null && this.exa.getVisibility() != 0) {
                YY();
            }
        }
    }

    public void iG(boolean z) {
        this.exb = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.bJz && this.exa != null) {
            if ((this.exb || i > this.aRr) && this.exa.getVisibility() != 8) {
                Zc();
            } else if ((this.exb || i < this.aRr) && this.exa.getVisibility() != 0) {
                Zd();
            }
            this.aRr = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.bJz) {
            if (this.aoZ) {
                dr(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.aRr) {
                    YZ();
                } else if (firstVisiblePosition < this.aRr) {
                    YY();
                } else if (firstVisiblePosition == this.aRr) {
                    if (firstVisiblePosition == 0 || !this.bJy || b(absListView)) {
                        YY();
                    } else {
                        YZ();
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

    private void Ze() {
        if (this.bJw != null) {
            if (this.bJx && this.bJw.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bJw.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bJw.setLayoutParams(layoutParams);
                dr(true);
                return;
            }
            dr(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dr(boolean z) {
        if (this.bJw != null) {
            if (this.bJx && z && this.bJw.getVisibility() != 0) {
                this.bJw.setVisibility(0);
            } else if (!z && this.bJw.getVisibility() != 8) {
                this.bJw.setVisibility(8);
            }
        }
    }
}
