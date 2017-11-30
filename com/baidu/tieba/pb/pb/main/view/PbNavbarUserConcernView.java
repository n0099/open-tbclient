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
    private TranslateAnimation ffA;
    private ObjectAnimator ffB;

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
    public void aM(boolean z) {
        clearAnimation();
        if (z) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void dG(int i) {
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
            if (this.ffA == null) {
                this.ffA = new TranslateAnimation(0.0f, -getMeasuredWidth(), 0.0f, 0.0f);
                this.ffA.setDuration(300L);
                this.ffA.setFillAfter(true);
                this.ffA.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.view.PbNavbarUserConcernView.1
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
            startAnimation(this.ffA);
        } else {
            if (this.ffB == null) {
                this.ffB = ObjectAnimator.ofFloat(this, "translationX", 0.0f, -30.0f);
                this.ffB.setDuration(200L);
                this.ffB.setRepeatCount(1);
                this.ffB.setRepeatMode(2);
            }
            this.ffB.start();
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        aj.j(this, d.f.bg_concern_host_nav);
        setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_nav_follow), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.i(this, d.C0082d.cp_cont_f);
    }
}
