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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class BdTopToast extends LinearLayout {
    private TextView cbI;
    private Animation hZD;
    private Animation hZE;
    private Runnable mHideRunnable;
    private ImageView mIconView;
    private View mStatusBarView;
    private BottomShadowLinearLayout mhp;
    private boolean mhq;

    public BdTopToast(Context context) {
        this(context, null);
    }

    public BdTopToast(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BdTopToast(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setOrientation(1);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.mStatusBarView = new View(getContext());
            addView(this.mStatusBarView, 0, new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
        }
        LayoutInflater.from(getContext()).inflate(R.layout.bd_top_toast_layout, this);
        this.mhp = (BottomShadowLinearLayout) findViewById(R.id.bd_top_toast_group);
        this.mIconView = (ImageView) findViewById(R.id.bd_top_toast_icon);
        this.cbI = (TextView) findViewById(R.id.bd_top_toast_content);
        initAnimation();
    }

    private void initAnimation() {
        this.hZD = AnimationUtils.loadAnimation(getContext(), R.anim.in_from_top);
        this.hZE = AnimationUtils.loadAnimation(getContext(), R.anim.out_to_top);
        this.hZE.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.view.BdTopToast.1
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

    public BdTopToast vz(boolean z) {
        this.mhq = z;
        return this;
    }

    public BdTopToast OJ(String str) {
        this.cbI.setText(str);
        return this;
    }

    public void aE(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            release();
            viewGroup.addView(this, -1, -2);
            onChangeSkinType();
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
        an.setBackgroundColor(this.mStatusBarView, R.color.cp_bg_line_h);
        if (this.mhq) {
            SvgManager.aWQ().a(this.mIconView, R.drawable.ic_icon_pure_succeed_use_n, (SvgManager.SvgResourceStateType) null);
            an.setViewTextColor(this.cbI, (int) R.color.cp_link_tip_a);
        } else {
            SvgManager.aWQ().a(this.mIconView, R.drawable.ic_icon_pure_defeated_use_n, (SvgManager.SvgResourceStateType) null);
            an.setViewTextColor(this.cbI, (int) R.color.cp_cont_h);
        }
        this.mhp.onChangeSkinType();
    }
}
