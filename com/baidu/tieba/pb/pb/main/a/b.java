package com.baidu.tieba.pb.pb.main.a;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b {
    private View cbq;
    private a eJY;
    private Animation eVK;
    private Animation eVL;
    private View eVM;
    private Context mContext;
    private boolean axq = false;
    private int aMR = 0;
    private boolean eVN = false;
    private boolean eVO = false;
    private boolean aMS = false;
    private boolean cbs = true;
    private final Handler.Callback cbt = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.a.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.acL()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.acK();
                    return true;
                case 2:
                    b.this.acI();
                    return true;
                case 3:
                    b.this.acJ();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.cbt);
    private boolean cbr = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes.dex */
    public interface a {
        void eq(boolean z);
    }

    public void a(a aVar) {
        this.eJY = aVar;
    }

    public void eo(boolean z) {
        this.aMS = z;
    }

    public b(Context context, View view, View view2) {
        this.mContext = context;
        this.eVM = view;
        this.cbq = view2;
        acM();
        ep(false);
    }

    private void acG() {
        this.eVK = AnimationUtils.loadAnimation(this.mContext, d.a.bavigationbar_slide_out);
        this.eVK.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (b.this.eVM != null) {
                    b.this.eVM.clearAnimation();
                    b.this.eVM.setVisibility(8);
                    if (b.this.eVO) {
                        b.this.ep(false);
                    } else {
                        b.this.ep(true);
                    }
                    if (b.this.eJY != null) {
                        b.this.eJY.eq(false);
                    }
                }
            }
        });
    }

    private void acH() {
        this.eVL = AnimationUtils.loadAnimation(this.mContext, d.a.bavigationbar_slide_in);
        this.eVL.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (b.this.eVM != null) {
                    b.this.eVM.clearAnimation();
                    b.this.eVM.setVisibility(0);
                    b.this.ep(false);
                    if (b.this.eJY != null) {
                        b.this.eJY.eq(true);
                    }
                }
            }
        });
    }

    public void acI() {
        q(false, false);
    }

    public void acJ() {
        q(false, true);
    }

    public void q(boolean z, boolean z2) {
        if (this.eVM != null && this.eVM.getVisibility() == 0 && !acL()) {
            if (z2) {
                this.eVM.setVisibility(8);
                if (this.eVO) {
                    ep(false);
                    return;
                } else {
                    ep(true);
                    return;
                }
            }
            if (this.eVK == null) {
                acG();
            }
            if (this.eVL != null) {
                this.eVL.cancel();
            }
            this.eVM.startAnimation(this.eVK);
        }
    }

    public void acK() {
        if (this.eVM != null && this.eVM.getVisibility() != 0 && !acL()) {
            this.eVM.setVisibility(0);
            if (this.eVL == null) {
                acH();
            }
            if (this.eVK != null) {
                this.eVK.cancel();
            }
            this.eVM.startAnimation(this.eVL);
        }
    }

    public void Hm() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Hn() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Ho() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean acL() {
        return ai(this.eVM);
    }

    private boolean ai(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void hideFloatingView() {
        if (this.cbs) {
            if (this.axq) {
                ep(true);
            } else if (this.eVM != null && !this.eVN && this.eVM.getVisibility() != 8) {
                Hn();
            }
        }
    }

    public void showFloatingView() {
        if (this.cbs) {
            if (this.axq) {
                ep(true);
            } else if (this.eVM != null && this.eVM.getVisibility() != 0) {
                Hm();
            }
        }
    }

    public void jU(boolean z) {
        this.eVN = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.cbs && this.eVM != null && !this.eVN) {
            if (i > this.aMR && this.eVM.getVisibility() != 8) {
                hideFloatingView();
            } else if (i < this.aMR && this.eVM.getVisibility() != 0) {
                showFloatingView();
            }
            this.aMR = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.cbs && !this.eVN) {
            if (this.axq) {
                ep(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.aMR) {
                    Hn();
                } else if (firstVisiblePosition < this.aMR) {
                    Hm();
                } else if (firstVisiblePosition == this.aMR) {
                    if (firstVisiblePosition == 0 || !this.aMS || a(absListView)) {
                        Hm();
                    } else {
                        Hn();
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

    private void acM() {
        if (this.cbq != null) {
            if (this.cbr && this.cbq.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.cbq.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.cbq.setLayoutParams(layoutParams);
                ep(true);
                return;
            }
            ep(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ep(boolean z) {
        if (this.cbq != null) {
            if (this.cbr && z && this.cbq.getVisibility() != 0) {
                this.cbq.setVisibility(0);
            } else if (!z && this.cbq.getVisibility() != 8) {
                this.cbq.setVisibility(8);
            }
        }
    }
}
