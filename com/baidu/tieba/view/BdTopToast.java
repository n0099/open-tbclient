package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class BdTopToast extends LinearLayout {
    private Animation bJS;
    private Animation bJT;
    private TextView cLW;
    private int mDuration;
    private Runnable mHideRunnable;
    private ImageView mIconView;
    private View mStatusBarView;
    private boolean nyA;
    private BottomShadowLinearLayout nyz;

    public BdTopToast(Context context, int i) {
        this(context);
        this.mDuration = i;
    }

    public BdTopToast(Context context) {
        this(context, (AttributeSet) null);
    }

    public BdTopToast(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BdTopToast(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDuration = -1;
        init();
    }

    private void init() {
        setOrientation(1);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.mStatusBarView = new View(getContext());
            addView(this.mStatusBarView, 0, new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
        }
        LayoutInflater.from(getContext()).inflate(R.layout.bd_top_toast_layout, this);
        this.nyz = (BottomShadowLinearLayout) findViewById(R.id.bd_top_toast_group);
        this.mIconView = (ImageView) findViewById(R.id.bd_top_toast_icon);
        this.cLW = (TextView) findViewById(R.id.bd_top_toast_content);
        initAnimation();
    }

    private void initAnimation() {
        this.bJS = AnimationUtils.loadAnimation(getContext(), R.anim.in_from_top);
        this.bJT = AnimationUtils.loadAnimation(getContext(), R.anim.out_to_top);
        this.bJT.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.view.BdTopToast.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                BdTopToast.this.release();
                if (BdTopToast.this.getParent() != null) {
                    ((ViewGroup) BdTopToast.this.getParent()).removeView(BdTopToast.this);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.view.BdTopToast.2
            @Override // java.lang.Runnable
            public void run() {
                BdTopToast.this.hide();
            }
        };
    }

    public BdTopToast yk(boolean z) {
        this.nyA = z;
        return this;
    }

    public BdTopToast Ut(String str) {
        this.cLW.setText(str);
        return this;
    }

    public void aJ(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            release();
            viewGroup.addView(this, -1, -2);
            onChangeSkinType();
            startAnimation(this.bJS);
            if (this.mDuration >= 0) {
                com.baidu.adp.lib.f.e.mY().postDelayed(this.mHideRunnable, this.mDuration);
            } else {
                com.baidu.adp.lib.f.e.mY().postDelayed(this.mHideRunnable, 5000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        release();
        startAnimation(this.bJT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mHideRunnable);
        clearAnimation();
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mStatusBarView, R.color.cp_bg_line_h);
        if (this.nyA) {
            SvgManager.brn().a(this.mIconView, R.drawable.ic_icon_pure_succeed_use_n, (SvgManager.SvgResourceStateType) null);
            ap.setViewTextColor(this.cLW, R.color.cp_link_tip_a);
        } else {
            SvgManager.brn().a(this.mIconView, R.drawable.ic_icon_pure_defeated_use_n, (SvgManager.SvgResourceStateType) null);
            ap.setViewTextColor(this.cLW, R.color.cp_cont_h);
        }
        this.nyz.onChangeSkinType();
    }
}
