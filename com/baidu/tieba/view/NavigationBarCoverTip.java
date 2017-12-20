package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class NavigationBarCoverTip extends LinearLayout {
    private Runnable cUU;
    private Animation daI;
    private Animation daJ;
    private a hbl;
    private Activity mActivity;
    private int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void bEK();

        void bEL();
    }

    public NavigationBarCoverTip(Context context) {
        super(context);
        this.mSkinType = 3;
        init(context);
    }

    public NavigationBarCoverTip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationBarCoverTip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        }
        setGravity(17);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.NavigationBarCoverTip.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.e.fP().removeCallbacks(NavigationBarCoverTip.this.cUU);
                NavigationBarCoverTip.this.hideTip();
            }
        });
        bmL();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bmL() {
        this.daI = AnimationUtils.loadAnimation(getContext(), d.a.in_from_top);
        this.daI.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.view.NavigationBarCoverTip.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (NavigationBarCoverTip.this.hbl != null) {
                    NavigationBarCoverTip.this.hbl.bEK();
                }
                if (NavigationBarCoverTip.this.mActivity != null) {
                    UtilHelper.changeStatusBarIconAndTextColor(true, NavigationBarCoverTip.this.mActivity);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.daJ = AnimationUtils.loadAnimation(getContext(), d.a.out_to_top);
        this.daJ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.view.NavigationBarCoverTip.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (NavigationBarCoverTip.this.hbl != null) {
                    NavigationBarCoverTip.this.hbl.bEL();
                }
                NavigationBarCoverTip.this.release();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.cUU = new Runnable() { // from class: com.baidu.tieba.view.NavigationBarCoverTip.4
            @Override // java.lang.Runnable
            public void run() {
                NavigationBarCoverTip.this.hideTip();
            }
        };
    }

    public void j(Activity activity, int i) {
        this.mActivity = activity;
        if (i < 0) {
            i = 5000;
        }
        setVisibility(0);
        clearAnimation();
        startAnimation(this.daI);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.cUU);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.cUU, i);
    }

    public void hideTip() {
        clearAnimation();
        startAnimation(this.daJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.cUU);
        clearAnimation();
        setVisibility(8);
        if (this.mActivity != null) {
            UtilHelper.changeStatusBarIconAndTextColor(false, this.mActivity);
            this.mActivity = null;
        }
    }

    public void onDestory() {
        release();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.k(this, d.C0096d.cp_link_tip_a_alpha95);
            this.mSkinType = i;
        }
    }

    public void setCoverTipListener(a aVar) {
        this.hbl = aVar;
    }
}
