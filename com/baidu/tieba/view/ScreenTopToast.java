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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class ScreenTopToast extends LinearLayout {
    private TextView cjk;
    private TBSpecificationBtn hyU;
    private boolean isShow;
    private Animation itL;
    private Animation itM;
    private Runnable mHideRunnable;
    private ShadowLinearLayout mJK;
    private TextView mTitleView;

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
        this.mJK = (ShadowLinearLayout) findViewById(R.id.screen_top_toast_group);
        this.mTitleView = (TextView) findViewById(R.id.screen_top_toast_title);
        this.cjk = (TextView) findViewById(R.id.screen_top_toast_content);
        this.hyU = (TBSpecificationBtn) findViewById(R.id.screen_top_toast_btn);
        this.hyU.setConfig(new com.baidu.tbadk.core.view.commonBtn.a());
        initAnimation();
        onChangeSkinType();
    }

    private void initAnimation() {
        this.itL = AnimationUtils.loadAnimation(getContext(), R.anim.in_from_top);
        this.itM = AnimationUtils.loadAnimation(getContext(), R.anim.out_to_top);
        this.itM.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.view.ScreenTopToast.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ScreenTopToast.this.release();
                if (ScreenTopToast.this.getParent() != null) {
                    ((ViewGroup) ScreenTopToast.this.getParent()).removeView(ScreenTopToast.this);
                    ScreenTopToast.this.isShow = false;
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

    public ScreenTopToast St(String str) {
        this.mTitleView.setText(str);
        return this;
    }

    public ScreenTopToast Su(String str) {
        this.cjk.setText(str);
        return this;
    }

    public ScreenTopToast Sv(String str) {
        this.hyU.setText(str);
        return this;
    }

    public ScreenTopToast ak(View.OnClickListener onClickListener) {
        this.hyU.setOnClickListener(onClickListener);
        return this;
    }

    public void aE(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            release();
            if (TextUtils.isEmpty(this.cjk.getText())) {
                this.cjk.setVisibility(8);
            }
            viewGroup.addView(this, -1, -2);
            this.isShow = true;
            startAnimation(this.itL);
            com.baidu.adp.lib.f.e.mS().postDelayed(this.mHideRunnable, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        release();
        startAnimation(this.itM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.mHideRunnable);
        clearAnimation();
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mTitleView, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.cjk, R.color.cp_link_tip_a);
        this.hyU.bkF();
        this.mJK.onChangeSkinType();
    }

    public boolean isShow() {
        return this.isShow;
    }
}
