package com.baidu.tieba.pb.pb.main.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PbNavbarUserConcernView extends TextView implements com.baidu.tbadk.core.view.userLike.b {
    private TranslateAnimation ePw;
    private ObjectAnimator ePx;

    public PbNavbarUserConcernView(Context context) {
        super(context);
    }

    public PbNavbarUserConcernView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PbNavbarUserConcernView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void aO(boolean z) {
        clearAnimation();
        if (z) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void dF(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void I(View view) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void i(boolean z, boolean z2) {
        clearAnimation();
        if (!z2) {
            if (z) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        } else if (z) {
            if (this.ePw == null) {
                this.ePw = new TranslateAnimation(0.0f, getMeasuredWidth(), 0.0f, 0.0f);
                this.ePw.setDuration(300L);
                this.ePw.setFillAfter(true);
                this.ePw.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.view.PbNavbarUserConcernView.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        PbNavbarUserConcernView.this.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            startAnimation(this.ePw);
        } else {
            if (this.ePx == null) {
                this.ePx = ObjectAnimator.ofFloat(this, "translationX", 0.0f, 30.0f);
                this.ePx.setDuration(200L);
                this.ePx.setRepeatCount(1);
                this.ePx.setRepeatMode(2);
            }
            this.ePx.start();
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        aj.j(this, d.g.bg_concern_host_nav);
        setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.icon_nav_follow), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.i(this, d.e.cp_cont_f);
    }
}
