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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class PbNavbarUserConcernView extends TextView implements com.baidu.tbadk.core.view.userLike.b {
    private TranslateAnimation gjK;
    private ObjectAnimator gjL;

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
    public void d(boolean z, int i) {
        clearAnimation();
        if (z) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void eF(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void X(View view) {
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
            if (this.gjK == null) {
                this.gjK = new TranslateAnimation(0.0f, -getMeasuredWidth(), 0.0f, 0.0f);
                this.gjK.setDuration(300L);
                this.gjK.setFillAfter(true);
                this.gjK.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.view.PbNavbarUserConcernView.1
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
            startAnimation(this.gjK);
        } else {
            if (this.gjL == null) {
                this.gjL = ObjectAnimator.ofFloat(this, "translationX", 0.0f, -30.0f);
                this.gjL.setDuration(200L);
                this.gjL.setRepeatCount(1);
                this.gjL.setRepeatMode(2);
            }
            this.gjL.start();
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void d(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        al.i(this, e.f.bg_concern_host_nav);
        setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_nav_follow), (Drawable) null, (Drawable) null, (Drawable) null);
        al.h(this, e.d.cp_cont_f);
    }
}
