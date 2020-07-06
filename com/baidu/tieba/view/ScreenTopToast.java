package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ScreenTopToast extends LinearLayout {
    private TextView cbI;
    private Animation hZD;
    private Animation hZE;
    private TBSpecificationBtn hgt;
    private Runnable mHideRunnable;
    private TextView mTitleView;
    private ShadowLinearLayout mjy;

    public ScreenTopToast(Context context) {
        this(context, null);
    }

    public ScreenTopToast(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScreenTopToast(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setOrientation(1);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        }
        LayoutInflater.from(getContext()).inflate(R.layout.screen_top_toast_layout, this);
        this.mjy = (ShadowLinearLayout) findViewById(R.id.screen_top_toast_group);
        this.mTitleView = (TextView) findViewById(R.id.screen_top_toast_title);
        this.cbI = (TextView) findViewById(R.id.screen_top_toast_content);
        this.hgt = (TBSpecificationBtn) findViewById(R.id.screen_top_toast_btn);
        this.hgt.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
        initAnimation();
        onChangeSkinType();
    }

    private void initAnimation() {
        this.hZD = AnimationUtils.loadAnimation(getContext(), R.anim.in_from_top);
        this.hZE = AnimationUtils.loadAnimation(getContext(), R.anim.out_to_top);
        this.hZE.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.view.ScreenTopToast.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ScreenTopToast.this.release();
                if (ScreenTopToast.this.getParent() != null) {
                    ((ViewGroup) ScreenTopToast.this.getParent()).removeView(ScreenTopToast.this);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.view.ScreenTopToast.2
            @Override // java.lang.Runnable
            public void run() {
                ScreenTopToast.this.hide();
            }
        };
    }

    public ScreenTopToast OK(String str) {
        this.mTitleView.setText(str);
        return this;
    }

    public ScreenTopToast OL(String str) {
        this.cbI.setText(str);
        return this;
    }

    public ScreenTopToast OM(String str) {
        this.hgt.setText(str);
        return this;
    }

    public ScreenTopToast ai(View.OnClickListener onClickListener) {
        this.hgt.setOnClickListener(onClickListener);
        return this;
    }

    public void aE(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            release();
            if (TextUtils.isEmpty(this.cbI.getText())) {
                this.cbI.setVisibility(8);
            }
            viewGroup.addView(this, -1, -2);
            startAnimation(this.hZD);
            com.baidu.adp.lib.f.e.lt().postDelayed(this.mHideRunnable, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        release();
        startAnimation(this.hZE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.mHideRunnable);
        clearAnimation();
    }

    public void onChangeSkinType() {
        an.setViewTextColor(this.mTitleView, (int) R.color.cp_link_tip_a);
        an.setViewTextColor(this.cbI, (int) R.color.cp_link_tip_a);
        this.hgt.aYj();
        this.mjy.onChangeSkinType();
    }
}
