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
/* loaded from: classes2.dex */
public class PbNavbarUserConcernView extends TextView implements com.baidu.tbadk.core.view.userLike.b {
    private TranslateAnimation fYL;
    private ObjectAnimator fYM;

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
    public void f(boolean z, int i) {
        clearAnimation();
        if (z) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void gD(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void bc(View view) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        clearAnimation();
        if (!z2) {
            if (z) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        } else if (z) {
            if (this.fYL == null) {
                this.fYL = new TranslateAnimation(0.0f, -getMeasuredWidth(), 0.0f, 0.0f);
                this.fYL.setDuration(300L);
                this.fYL.setFillAfter(true);
                this.fYL.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.view.PbNavbarUserConcernView.1
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
            startAnimation(this.fYL);
        } else {
            if (this.fYM == null) {
                this.fYM = ObjectAnimator.ofFloat(this, "translationX", 0.0f, -30.0f);
                this.fYM.setDuration(200L);
                this.fYM.setRepeatCount(1);
                this.fYM.setRepeatMode(2);
            }
            this.fYM.start();
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        aj.s(this, d.f.bg_concern_host_nav);
        setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_nav_follow), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.r(this, d.C0141d.cp_cont_f);
    }
}
