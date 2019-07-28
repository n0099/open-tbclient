package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
/* loaded from: classes4.dex */
public class PbTopTipView extends TextView {
    private boolean bmF;
    private Animation eaa;
    private com.baidu.tieba.f.b eab;
    private a.InterfaceC0305a eac;
    private int mDuration;
    private Runnable mHideTipRunnable;
    private Runnable mRunnable;
    private Animation mTipOutAnimation;

    public PbTopTipView(Context context) {
        super(context);
        this.mDuration = 3000;
        this.mHideTipRunnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.PbTopTipView.1
            @Override // java.lang.Runnable
            public void run() {
                PbTopTipView.this.hideTip();
            }
        };
        this.eac = new a.InterfaceC0305a() { // from class: com.baidu.tieba.pb.pb.main.view.PbTopTipView.2
            @Override // com.baidu.tieba.f.a.InterfaceC0305a
            public void aY(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0305a
            public void aZ(int i, int i2) {
                if (ax(i2) && PbTopTipView.this.bmF) {
                    PbTopTipView.this.hideTip();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0305a
            public void ba(int i, int i2) {
            }

            private boolean ax(float f) {
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

    public PbTopTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDuration = 3000;
        this.mHideTipRunnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.PbTopTipView.1
            @Override // java.lang.Runnable
            public void run() {
                PbTopTipView.this.hideTip();
            }
        };
        this.eac = new a.InterfaceC0305a() { // from class: com.baidu.tieba.pb.pb.main.view.PbTopTipView.2
            @Override // com.baidu.tieba.f.a.InterfaceC0305a
            public void aY(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0305a
            public void aZ(int i, int i2) {
                if (ax(i2) && PbTopTipView.this.bmF) {
                    PbTopTipView.this.hideTip();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0305a
            public void ba(int i, int i2) {
            }

            private boolean ax(float f) {
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

    public PbTopTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDuration = 3000;
        this.mHideTipRunnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.PbTopTipView.1
            @Override // java.lang.Runnable
            public void run() {
                PbTopTipView.this.hideTip();
            }
        };
        this.eac = new a.InterfaceC0305a() { // from class: com.baidu.tieba.pb.pb.main.view.PbTopTipView.2
            @Override // com.baidu.tieba.f.a.InterfaceC0305a
            public void aY(int i2, int i22) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0305a
            public void aZ(int i2, int i22) {
                if (ax(i22) && PbTopTipView.this.bmF) {
                    PbTopTipView.this.hideTip();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0305a
            public void ba(int i2, int i22) {
            }

            private boolean ax(float f) {
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
        this.eab = new com.baidu.tieba.f.b(getContext());
        this.eab.a(this.eac);
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.view.PbTopTipView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return PbTopTipView.this.eab.onTouchEvent(motionEvent);
            }
        });
        setupPaddings();
        this.eaa = AnimationUtils.loadAnimation(getContext(), R.anim.push_top_in);
        this.mTipOutAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.push_top_out);
        setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.fontsize30));
        this.mTipOutAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.view.PbTopTipView.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PbTopTipView.this.onDestroy();
                PbTopTipView.this.setVisibility(8);
                e.iK().postDelayed(PbTopTipView.this.mRunnable, 600L);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.eaa.setDuration(400L);
        this.eaa.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.view.PbTopTipView.5
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

    public void setupPaddings() {
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(R.dimen.ds30);
        int statusBarHeight = (UtilHelper.canUseStyleImmersiveSticky() && UtilHelper.getRealScreenOrientation(getContext()) == 1) ? UtilHelper.getStatusBarHeight() + dimensionPixelOffset : dimensionPixelOffset;
        int dimensionPixelOffset2 = getContext().getResources().getDimensionPixelOffset(R.dimen.ds34);
        setPadding(dimensionPixelOffset2, statusBarHeight, dimensionPixelOffset2, dimensionPixelOffset);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setupPaddings();
    }

    public void setDuration(int i) {
        this.mDuration = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        this.bmF = false;
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
            startAnimation(this.eaa);
            this.bmF = true;
        }
    }

    public void hide() {
        this.bmF = false;
        onDestroy();
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
    }

    public void onChangeSkinType(int i) {
        am.g(this, R.color.cp_link_tip_a_alpha95, i);
        am.d(this, R.color.cp_btn_a, 1, i);
    }

    public void onDestroy() {
        removeCallbacks(this.mHideTipRunnable);
        clearAnimation();
        e.iK().removeCallbacks(this.mRunnable);
    }
}
