package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class BdTopToast extends LinearLayout {
    private Animation bNq;
    private Animation bNr;
    private TextView cRq;
    private int mDuration;
    private Runnable mHideRunnable;
    private ImageView mIconView;
    private View mStatusBarView;
    private BottomShadowLinearLayout nMB;
    private boolean nMC;

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
        this.nMB = (BottomShadowLinearLayout) findViewById(R.id.bd_top_toast_group);
        this.mIconView = (ImageView) findViewById(R.id.bd_top_toast_icon);
        this.cRq = (TextView) findViewById(R.id.bd_top_toast_content);
        initAnimation();
    }

    private void initAnimation() {
        this.bNq = AnimationUtils.loadAnimation(getContext(), R.anim.in_from_top);
        this.bNr = AnimationUtils.loadAnimation(getContext(), R.anim.out_to_top);
        this.bNr.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.view.BdTopToast.1
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

    public BdTopToast yS(boolean z) {
        this.nMC = z;
        return this;
    }

    public BdTopToast TQ(String str) {
        this.cRq.setText(str);
        return this;
    }

    public void aR(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            release();
            viewGroup.addView(this, -1, -2);
            onChangeSkinType();
            startAnimation(this.bNq);
            if (this.mDuration >= 0) {
                com.baidu.adp.lib.f.e.mB().postDelayed(this.mHideRunnable, this.mDuration);
            } else {
                com.baidu.adp.lib.f.e.mB().postDelayed(this.mHideRunnable, 5000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        release();
        startAnimation(this.bNr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mHideRunnable);
        clearAnimation();
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this.mStatusBarView, R.color.CAM_X0207);
        if (this.nMC) {
            SvgManager.bsx().a(this.mIconView, R.drawable.ic_icon_pure_succeed_use_n, R.color.CAM_X0302, (SvgManager.SvgResourceStateType) null);
            ao.setViewTextColor(this.cRq, R.color.CAM_X0302);
        } else {
            SvgManager.bsx().a(this.mIconView, R.drawable.ic_icon_pure_defeated_use_n, R.color.CAM_X0301, (SvgManager.SvgResourceStateType) null);
            ao.setViewTextColor(this.cRq, R.color.CAM_X0301);
        }
        this.nMB.onChangeSkinType();
    }
}
