package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.content.res.Configuration;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.g.e;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.e.a;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes2.dex */
public class PbTopTipView extends TextView {
    private com.baidu.tieba.e.b ckL;
    private a.InterfaceC0108a ckM;
    private boolean cwF;
    private Animation cwG;
    private int mDuration;
    private Runnable mHideTipRunnable;
    private Runnable mRunnable;
    private Animation mTipOutAnimation;

    public PbTopTipView(Context context) {
        super(context);
        this.mDuration = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
        this.mHideTipRunnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.PbTopTipView.1
            @Override // java.lang.Runnable
            public void run() {
                PbTopTipView.this.hideTip();
            }
        };
        this.ckM = new a.InterfaceC0108a() { // from class: com.baidu.tieba.pb.pb.main.view.PbTopTipView.2
            @Override // com.baidu.tieba.e.a.InterfaceC0108a
            public void aY(int i, int i2) {
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0108a
            public void aZ(int i, int i2) {
                if (Z(i2) && PbTopTipView.this.cwF) {
                    PbTopTipView.this.hideTip();
                }
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0108a
            public void ba(int i, int i2) {
            }

            private boolean Z(float f) {
                return Math.abs(f) >= 5.0f;
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.PbTopTipView.6
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup viewGroup = (ViewGroup) PbTopTipView.this.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(PbTopTipView.this);
                }
            }
        };
        init();
    }

    private void init() {
        this.ckL = new com.baidu.tieba.e.b(getContext());
        this.ckL.a(this.ckM);
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.view.PbTopTipView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return PbTopTipView.this.ckL.onTouchEvent(motionEvent);
            }
        });
        afl();
        this.cwG = AnimationUtils.loadAnimation(getContext(), d.a.push_top_in);
        this.mTipOutAnimation = AnimationUtils.loadAnimation(getContext(), d.a.push_top_out);
        setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.fontsize30));
        this.mTipOutAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.view.PbTopTipView.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PbTopTipView.this.onDestroy();
                e.nr().postDelayed(PbTopTipView.this.mRunnable, 100L);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.cwG.setDuration(400L);
        this.cwG.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.view.PbTopTipView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (PbTopTipView.this.mDuration > 0) {
                    PbTopTipView.this.postDelayed(PbTopTipView.this.mHideTipRunnable, PbTopTipView.this.mDuration);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void afl() {
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(d.e.ds30);
        int statusBarHeight = (UtilHelper.canUseStyleImmersiveSticky() && UtilHelper.getRealScreenOrientation(getContext()) == 1) ? UtilHelper.getStatusBarHeight() + dimensionPixelOffset : dimensionPixelOffset;
        int dimensionPixelOffset2 = getContext().getResources().getDimensionPixelOffset(d.e.ds34);
        setPadding(dimensionPixelOffset2, statusBarHeight, dimensionPixelOffset2, dimensionPixelOffset);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        afl();
    }

    public void setDuration(int i) {
        this.mDuration = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        this.cwF = false;
        removeCallbacks(this.mHideTipRunnable);
        if (this != null && getParent() != null) {
            clearAnimation();
            startAnimation(this.mTipOutAnimation);
        }
    }

    public void show(RelativeLayout relativeLayout, int i) {
        if (relativeLayout != null) {
            if (getParent() != null) {
                clearAnimation();
                ((ViewGroup) getParent()).removeView(this);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(10);
            relativeLayout.addView(this, layoutParams);
            onChangeSkinType(i);
            startAnimation(this.cwG);
            this.cwF = true;
        }
    }

    public void hide() {
        this.cwF = false;
        onDestroy();
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
    }

    public void onChangeSkinType(int i) {
        aj.f(this, d.C0107d.cp_link_tip_a_alpha95, i);
        aj.b(this, d.C0107d.cp_cont_i, 1, i);
    }

    public void onDestroy() {
        removeCallbacks(this.mHideTipRunnable);
        clearAnimation();
        e.nr().removeCallbacks(this.mRunnable);
    }
}
