package com.baidu.tieba.yuyinala.liveroom.tippop;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tieba.d.a;
import com.baidu.live.tieba.d.b;
/* loaded from: classes10.dex */
public class AlaTopTipView extends TextView {
    private a.InterfaceC0209a bDm;
    private Animation bQC;
    private Runnable bQE;
    private boolean ekU;
    private Animation hKc;
    private b hKe;
    private int mDuration;
    private int mType;
    private a osj;

    /* loaded from: classes10.dex */
    public interface a {
        void cC(View view);
    }

    public AlaTopTipView(Context context) {
        super(context);
        this.mDuration = 2000;
        this.bQE = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.tippop.AlaTopTipView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaTopTipView.this.hideTip();
            }
        };
        this.bDm = new a.InterfaceC0209a() { // from class: com.baidu.tieba.yuyinala.liveroom.tippop.AlaTopTipView.2
            @Override // com.baidu.live.tieba.d.a.InterfaceC0209a
            public void G(int i, int i2) {
            }

            @Override // com.baidu.live.tieba.d.a.InterfaceC0209a
            public void H(int i, int i2) {
                if (aA(i2) && AlaTopTipView.this.ekU) {
                    AlaTopTipView.this.hideTip();
                }
            }

            @Override // com.baidu.live.tieba.d.a.InterfaceC0209a
            public void I(int i, int i2) {
            }

            private boolean aA(float f) {
                return Math.abs(f) >= 2.0f;
            }
        };
        init();
    }

    public AlaTopTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDuration = 2000;
        this.bQE = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.tippop.AlaTopTipView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaTopTipView.this.hideTip();
            }
        };
        this.bDm = new a.InterfaceC0209a() { // from class: com.baidu.tieba.yuyinala.liveroom.tippop.AlaTopTipView.2
            @Override // com.baidu.live.tieba.d.a.InterfaceC0209a
            public void G(int i, int i2) {
            }

            @Override // com.baidu.live.tieba.d.a.InterfaceC0209a
            public void H(int i, int i2) {
                if (aA(i2) && AlaTopTipView.this.ekU) {
                    AlaTopTipView.this.hideTip();
                }
            }

            @Override // com.baidu.live.tieba.d.a.InterfaceC0209a
            public void I(int i, int i2) {
            }

            private boolean aA(float f) {
                return Math.abs(f) >= 2.0f;
            }
        };
        init();
    }

    public AlaTopTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDuration = 2000;
        this.bQE = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.tippop.AlaTopTipView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaTopTipView.this.hideTip();
            }
        };
        this.bDm = new a.InterfaceC0209a() { // from class: com.baidu.tieba.yuyinala.liveroom.tippop.AlaTopTipView.2
            @Override // com.baidu.live.tieba.d.a.InterfaceC0209a
            public void G(int i2, int i22) {
            }

            @Override // com.baidu.live.tieba.d.a.InterfaceC0209a
            public void H(int i2, int i22) {
                if (aA(i22) && AlaTopTipView.this.ekU) {
                    AlaTopTipView.this.hideTip();
                }
            }

            @Override // com.baidu.live.tieba.d.a.InterfaceC0209a
            public void I(int i2, int i22) {
            }

            private boolean aA(float f) {
                return Math.abs(f) >= 2.0f;
            }
        };
        init();
    }

    private void init() {
        this.hKe = new b(getContext());
        this.hKe.a(this.bDm);
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.yuyinala.liveroom.tippop.AlaTopTipView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                }
                return AlaTopTipView.this.hKe.onTouchEvent(motionEvent);
            }
        });
        setupPaddings();
        this.hKc = AnimationUtils.loadAnimation(getContext(), a.C0194a.sdk_push_top_in);
        this.bQC = AnimationUtils.loadAnimation(getContext(), a.C0194a.sdk_push_top_out);
        setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds28));
        this.bQC.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.yuyinala.liveroom.tippop.AlaTopTipView.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaTopTipView.this.onDestroy();
                ViewGroup viewGroup = (ViewGroup) AlaTopTipView.this.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(AlaTopTipView.this);
                }
                if (AlaTopTipView.this.osj != null) {
                    AlaTopTipView.this.osj.cC(AlaTopTipView.this);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.hKc.setDuration(400L);
        this.hKc.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.yuyinala.liveroom.tippop.AlaTopTipView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (AlaTopTipView.this.mDuration > 0) {
                    AlaTopTipView.this.postDelayed(AlaTopTipView.this.bQE, AlaTopTipView.this.mDuration);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    private void setupPaddings() {
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds30);
        int statusBarHeight = (UtilHelper.canUseStyleImmersiveSticky() && UtilHelper.getRealScreenOrientation(getContext()) == 1) ? UtilHelper.getStatusBarHeight() + dimensionPixelOffset : dimensionPixelOffset;
        int dimensionPixelOffset2 = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds34);
        setPadding(dimensionPixelOffset2, statusBarHeight, dimensionPixelOffset2, dimensionPixelOffset);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setupPaddings();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = getRealWidth();
        setLayoutParams(layoutParams);
    }

    public void setDuration(int i) {
        this.mDuration = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        this.ekU = false;
        removeCallbacks(this.bQE);
        if (this != null && getParent() != null) {
            clearAnimation();
            startAnimation(this.bQC);
        }
    }

    private int getRealWidth() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        if (screenDimensions.length != 2 || screenDimensions[0] <= 0) {
            return -1;
        }
        return screenDimensions[0];
    }

    public void v(ViewGroup viewGroup, int i) {
        if (viewGroup instanceof RelativeLayout) {
            a((RelativeLayout) viewGroup, i);
        } else if (viewGroup instanceof FrameLayout) {
            b((FrameLayout) viewGroup, i);
        } else if (viewGroup instanceof LinearLayout) {
            c((LinearLayout) viewGroup, i);
        }
    }

    public void c(LinearLayout linearLayout, int i) {
        if (linearLayout != null) {
            if (getParent() != null) {
                clearAnimation();
                ((ViewGroup) getParent()).removeView(this);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getRealWidth(), -2);
            layoutParams.gravity = 48;
            linearLayout.addView(this, layoutParams);
            onChangeSkinType(i);
            startAnimation(this.hKc);
            this.ekU = true;
        }
    }

    public void a(RelativeLayout relativeLayout, int i) {
        if (relativeLayout != null) {
            if (getParent() != null) {
                clearAnimation();
                ((ViewGroup) getParent()).removeView(this);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(getRealWidth(), -2);
            layoutParams.addRule(10);
            relativeLayout.addView(this, layoutParams);
            onChangeSkinType(i);
            startAnimation(this.hKc);
            this.ekU = true;
        }
    }

    public void b(FrameLayout frameLayout, int i) {
        if (frameLayout != null) {
            if (getParent() != null) {
                clearAnimation();
                ((ViewGroup) getParent()).removeView(this);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getRealWidth(), -2);
            layoutParams.setMargins(0, 0, 0, 0);
            frameLayout.addView(this, layoutParams);
            onChangeSkinType(i);
            startAnimation(this.hKc);
            this.ekU = true;
        }
    }

    public void gE(boolean z) {
        this.ekU = false;
        onDestroy();
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        if (z && this.osj != null) {
            this.osj.cC(this);
        }
    }

    public void setTipDuration(int i) {
        if (i > 0) {
            this.mDuration = i;
        }
    }

    public void onChangeSkinType(int i) {
        SkinManager.setBackgroundResource(this, a.c.sdk_white_alpha95, i);
        SkinManager.setViewTextColor(this, a.c.sdk_cp_cont_f, 1, i);
    }

    public void onDestroy() {
        removeCallbacks(this.bQE);
        clearAnimation();
    }

    public void setOnTipCompletedCallback(a aVar) {
        this.osj = aVar;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
