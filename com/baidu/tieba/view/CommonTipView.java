package com.baidu.tieba.view;

import android.content.Context;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class CommonTipView extends TextView {
    private int HD;
    private TranslateAnimation csr;
    private Runnable css;
    private Animation gvT;
    private a gvU;

    /* loaded from: classes.dex */
    public interface a {
        void bwu();
    }

    public CommonTipView(Context context) {
        super(context);
        this.HD = 4000;
        this.gvT = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_out);
        this.csr = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(d.f.ds56), 0.0f);
        this.css = new Runnable() { // from class: com.baidu.tieba.view.CommonTipView.1
            @Override // java.lang.Runnable
            public void run() {
                CommonTipView.this.hideTip();
            }
        };
        init();
    }

    private void init() {
        setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds24));
        setGravity(17);
        this.gvT.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.view.CommonTipView.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                CommonTipView.this.onDestroy();
                ViewGroup viewGroup = (ViewGroup) CommonTipView.this.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(CommonTipView.this);
                }
                if (CommonTipView.this.gvU != null) {
                    CommonTipView.this.gvU.bwu();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.csr.setDuration(400L);
        this.csr.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.view.CommonTipView.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                CommonTipView.this.postDelayed(CommonTipView.this.css, CommonTipView.this.HD);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        removeCallbacks(this.css);
        if (this != null && getParent() != null) {
            startAnimation(this.gvT);
        }
    }

    public void a(LinearLayout linearLayout, int i) {
        if (linearLayout != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds56));
            layoutParams.gravity = 48;
            linearLayout.addView(this, layoutParams);
            onChangeSkinType(i);
            startAnimation(this.csr);
        }
    }

    public void a(FrameLayout frameLayout, int i) {
        if (frameLayout != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds56));
            layoutParams.setMargins(0, 0, 0, 0);
            frameLayout.addView(this, layoutParams);
            onChangeSkinType(i);
            startAnimation(this.csr);
        }
    }

    public void setTipDuration(int i) {
        if (i > 0) {
            this.HD = i;
        }
    }

    public void onChangeSkinType(int i) {
        aj.d(this, d.e.common_color_10260, i);
        aj.b(this, d.e.cp_cont_g, 1, i);
    }

    public void onDestroy() {
        removeCallbacks(this.css);
    }
}
