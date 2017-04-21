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
    private View bJu;
    private Animation bSo;
    private Animation bSp;
    private a elL;
    private View eue;
    private Context mContext;
    private boolean auo = false;
    private int bJw = 0;
    private boolean euf = false;
    private boolean eug = false;
    private boolean bJx = false;
    private boolean bJy = true;
    private final Handler.Callback bJz = new g(this);
    private final Handler mHandler = new Handler(this.bJz);
    private boolean bJv = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes.dex */
    public interface a {
        void dy(boolean z);
    }

    public void a(a aVar) {
        this.elL = aVar;
    }

    public void dw(boolean z) {
        this.bJx = z;
    }

    public void jd(boolean z) {
        this.auo = z;
    }

    public f(Context context, View view, View view2) {
        this.mContext = context;
        this.eue = view;
        this.bJu = view2;
        Yl();
        dx(false);
    }

    private void Ya() {
        this.bSo = AnimationUtils.loadAnimation(this.mContext, w.a.bavigationbar_slide_out);
        this.bSo.setAnimationListener(new h(this));
    }

    private void Yb() {
        this.bSp = AnimationUtils.loadAnimation(this.mContext, w.a.bavigationbar_slide_in);
        this.bSp.setAnimationListener(new i(this));
    }

    public void Yc() {
        l(false, false);
    }

    public void Yd() {
        l(false, true);
    }

    public void l(boolean z, boolean z2) {
        if (this.eue != null && this.eue.getVisibility() == 0 && !Yi()) {
            if (z2) {
                this.eue.setVisibility(8);
                if (this.eug) {
                    dx(false);
                    return;
                } else {
                    dx(true);
                    return;
                }
            }
            if (this.bSo == null) {
                Ya();
            }
            if (this.bSp != null) {
                this.bSp.cancel();
            }
            this.eue.startAnimation(this.bSo);
        }
    }

    public void Ye() {
        if (this.eue != null && this.eue.getVisibility() != 0 && !Yi()) {
            this.eue.setVisibility(0);
            if (this.bSp == null) {
                Yb();
            }
            if (this.bSo != null) {
                this.bSo.cancel();
            }
            this.eue.startAnimation(this.bSp);
        }
    }

    public void Yf() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Yg() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Yh() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean Yi() {
        return af(this.eue);
    }

    private boolean af(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void Yj() {
        if (this.bJy) {
            if (this.auo) {
                dx(true);
            } else if (this.eue != null && !this.euf && this.eue.getVisibility() != 8) {
                Yg();
            }
        }
    }

    public void Yk() {
        if (this.bJy) {
            if (this.auo) {
                dx(true);
            } else if (this.eue != null && this.eue.getVisibility() != 0) {
                Yf();
            }
        }
    }

    public void je(boolean z) {
        this.euf = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.bJy && this.eue != null && !this.euf) {
            if (i > this.bJw && this.eue.getVisibility() != 8) {
                Yj();
            } else if (i < this.bJw && this.eue.getVisibility() != 0) {
                Yk();
            }
            this.bJw = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.bJy && !this.euf) {
            if (this.auo) {
                dx(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.bJw) {
                    Yg();
                } else if (firstVisiblePosition < this.bJw) {
                    Yf();
                } else if (firstVisiblePosition == this.bJw) {
                    if (firstVisiblePosition == 0 || !this.bJx || b(absListView)) {
                        Yf();
                    } else {
                        Yg();
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

    private void Yl() {
        if (this.bJu != null) {
            if (this.bJv && this.bJu.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bJu.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bJu.setLayoutParams(layoutParams);
                dx(true);
                return;
            }
            dx(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dx(boolean z) {
        if (this.bJu != null) {
            if (this.bJv && z && this.bJu.getVisibility() != 0) {
                this.bJu.setVisibility(0);
            } else if (!z && this.bJu.getVisibility() != 8) {
                this.bJu.setVisibility(8);
            }
        }
    }
}
