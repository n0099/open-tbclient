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
    private View cbp;
    private a eJW;
    private Animation eVI;
    private Animation eVJ;
    private View eVK;
    private Context mContext;
    private boolean axp = false;
    private int aMQ = 0;
    private boolean eVL = false;
    private boolean eVM = false;
    private boolean aMR = false;
    private boolean cbr = true;
    private final Handler.Callback cbs = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.a.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.acP()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.acO();
                    return true;
                case 2:
                    b.this.acM();
                    return true;
                case 3:
                    b.this.acN();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.cbs);
    private boolean cbq = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes.dex */
    public interface a {
        void eq(boolean z);
    }

    public void a(a aVar) {
        this.eJW = aVar;
    }

    public void eo(boolean z) {
        this.aMR = z;
    }

    public b(Context context, View view, View view2) {
        this.mContext = context;
        this.eVK = view;
        this.cbp = view2;
        acQ();
        ep(false);
    }

    private void acK() {
        this.eVI = AnimationUtils.loadAnimation(this.mContext, d.a.bavigationbar_slide_out);
        this.eVI.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (b.this.eVK != null) {
                    b.this.eVK.clearAnimation();
                    b.this.eVK.setVisibility(8);
                    if (b.this.eVM) {
                        b.this.ep(false);
                    } else {
                        b.this.ep(true);
                    }
                    if (b.this.eJW != null) {
                        b.this.eJW.eq(false);
                    }
                }
            }
        });
    }

    private void acL() {
        this.eVJ = AnimationUtils.loadAnimation(this.mContext, d.a.bavigationbar_slide_in);
        this.eVJ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (b.this.eVK != null) {
                    b.this.eVK.clearAnimation();
                    b.this.eVK.setVisibility(0);
                    b.this.ep(false);
                    if (b.this.eJW != null) {
                        b.this.eJW.eq(true);
                    }
                }
            }
        });
    }

    public void acM() {
        q(false, false);
    }

    public void acN() {
        q(false, true);
    }

    public void q(boolean z, boolean z2) {
        if (this.eVK != null && this.eVK.getVisibility() == 0 && !acP()) {
            if (z2) {
                this.eVK.setVisibility(8);
                if (this.eVM) {
                    ep(false);
                    return;
                } else {
                    ep(true);
                    return;
                }
            }
            if (this.eVI == null) {
                acK();
            }
            if (this.eVJ != null) {
                this.eVJ.cancel();
            }
            this.eVK.startAnimation(this.eVI);
        }
    }

    public void acO() {
        if (this.eVK != null && this.eVK.getVisibility() != 0 && !acP()) {
            this.eVK.setVisibility(0);
            if (this.eVJ == null) {
                acL();
            }
            if (this.eVI != null) {
                this.eVI.cancel();
            }
            this.eVK.startAnimation(this.eVJ);
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

    public boolean acP() {
        return aj(this.eVK);
    }

    private boolean aj(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void hideFloatingView() {
        if (this.cbr) {
            if (this.axp) {
                ep(true);
            } else if (this.eVK != null && !this.eVL && this.eVK.getVisibility() != 8) {
                Hn();
            }
        }
    }

    public void showFloatingView() {
        if (this.cbr) {
            if (this.axp) {
                ep(true);
            } else if (this.eVK != null && this.eVK.getVisibility() != 0) {
                Hm();
            }
        }
    }

    public void jU(boolean z) {
        this.eVL = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.cbr && this.eVK != null && !this.eVL) {
            if (i > this.aMQ && this.eVK.getVisibility() != 8) {
                hideFloatingView();
            } else if (i < this.aMQ && this.eVK.getVisibility() != 0) {
                showFloatingView();
            }
            this.aMQ = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.cbr && !this.eVL) {
            if (this.axp) {
                ep(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.aMQ) {
                    Hn();
                } else if (firstVisiblePosition < this.aMQ) {
                    Hm();
                } else if (firstVisiblePosition == this.aMQ) {
                    if (firstVisiblePosition == 0 || !this.aMR || a(absListView)) {
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

    private void acQ() {
        if (this.cbp != null) {
            if (this.cbq && this.cbp.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.cbp.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.cbp.setLayoutParams(layoutParams);
                ep(true);
                return;
            }
            ep(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ep(boolean z) {
        if (this.cbp != null) {
            if (this.cbq && z && this.cbp.getVisibility() != 0) {
                this.cbp.setVisibility(0);
            } else if (!z && this.cbp.getVisibility() != 8) {
                this.cbp.setVisibility(8);
            }
        }
    }
}
