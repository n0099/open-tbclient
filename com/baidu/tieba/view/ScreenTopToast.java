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
/* loaded from: classes.dex */
public class ScreenTopToast extends LinearLayout {
    private TextView clp;
    private TBSpecificationBtn hGc;
    private Animation iBn;
    private Animation iBo;
    private boolean isShow;
    private Runnable mHideRunnable;
    private ShadowLinearLayout mTS;
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
        this.mTS = (ShadowLinearLayout) findViewById(R.id.screen_top_toast_group);
        this.mTitleView = (TextView) findViewById(R.id.screen_top_toast_title);
        this.clp = (TextView) findViewById(R.id.screen_top_toast_content);
        this.hGc = (TBSpecificationBtn) findViewById(R.id.screen_top_toast_btn);
        this.hGc.setConfig(new com.baidu.tbadk.core.view.commonBtn.a());
        initAnimation();
        onChangeSkinType();
    }

    private void initAnimation() {
        this.iBn = AnimationUtils.loadAnimation(getContext(), R.anim.in_from_top);
        this.iBo = AnimationUtils.loadAnimation(getContext(), R.anim.out_to_top);
        this.iBo.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.view.ScreenTopToast.1
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

    public ScreenTopToast ST(String str) {
        this.mTitleView.setText(str);
        return this;
    }

    public ScreenTopToast SU(String str) {
        this.clp.setText(str);
        return this;
    }

    public ScreenTopToast SV(String str) {
        this.hGc.setText(str);
        return this;
    }

    public ScreenTopToast ak(View.OnClickListener onClickListener) {
        this.hGc.setOnClickListener(onClickListener);
        return this;
    }

    public void aF(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            release();
            if (TextUtils.isEmpty(this.clp.getText())) {
                this.clp.setVisibility(8);
            }
            viewGroup.addView(this, -1, -2);
            this.isShow = true;
            startAnimation(this.iBn);
            com.baidu.adp.lib.f.e.mX().postDelayed(this.mHideRunnable, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        release();
        startAnimation(this.iBo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.mHideRunnable);
        clearAnimation();
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mTitleView, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.clp, R.color.cp_link_tip_a);
        this.hGc.blA();
        this.mTS.onChangeSkinType();
    }

    public boolean isShow() {
        return this.isShow;
    }
}
