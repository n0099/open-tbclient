package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class LikeButtonWithHeadPortrait extends FrameLayout implements com.baidu.tbadk.core.view.userLike.b {
    private Animation.AnimationListener bAa;
    private HeadImageView ekP;
    private TextView fhZ;
    private View fia;
    private View fib;

    public LikeButtonWithHeadPortrait(Context context) {
        super(context);
        this.bAa = new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.LikeButtonWithHeadPortrait.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LikeButtonWithHeadPortrait.this.aXa();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        init(context);
    }

    public LikeButtonWithHeadPortrait(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bAa = new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.LikeButtonWithHeadPortrait.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LikeButtonWithHeadPortrait.this.aXa();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        init(context);
    }

    public LikeButtonWithHeadPortrait(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bAa = new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.LikeButtonWithHeadPortrait.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LikeButtonWithHeadPortrait.this.aXa();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.j.view_like_button_with_head_portrait, this);
        this.ekP = (HeadImageView) findViewById(d.h.head_img);
        this.ekP.setIsRound(true);
        this.fhZ = (TextView) findViewById(d.h.btn_like);
        this.fia = findViewById(d.h.view_background);
        this.fib = findViewById(d.h.right_circular_view);
    }

    public void setPortraitUrl(String str) {
        this.ekP.c(str, 12, false);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void aO(boolean z) {
        if (getWidth() != 0 && this.ekP.getWidth() != 0) {
            if (z) {
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, (getWidth() / 2) - (this.ekP.getWidth() / 2), 0.0f, 0.0f);
                translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                translateAnimation.setDuration(300L);
                translateAnimation.setFillAfter(true);
                translateAnimation.setAnimationListener(this.bAa);
                translateAnimation.setStartOffset(150L);
                this.ekP.startAnimation(translateAnimation);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, -((getWidth() / 2) - (this.ekP.getWidth() / 2)), 0.0f, 0.0f);
                translateAnimation2.setInterpolator(new AccelerateDecelerateInterpolator());
                translateAnimation2.setDuration(300L);
                translateAnimation2.setFillAfter(true);
                translateAnimation2.setStartOffset(150L);
                this.fib.startAnimation(translateAnimation2);
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(150L);
                alphaAnimation.setFillAfter(true);
                this.fhZ.startAnimation(alphaAnimation);
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, this.ekP.getWidth() / getWidth(), 1.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                scaleAnimation.setDuration(300L);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setStartOffset(150L);
                this.fia.startAnimation(scaleAnimation);
                setClickable(false);
                return;
            }
            this.fhZ.setVisibility(0);
            this.fia.setVisibility(0);
            setClickable(true);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void i(boolean z, boolean z2) {
        aO(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void dF(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void I(View view) {
        TiebaStatic.log(new ak("c12503").ac("obj_locate", "4"));
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        aj.j(this.fia, d.g.shape_person_top_like_bg);
        aj.j(this.fib, d.g.shape_person_top_like_bg);
        this.fhZ.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.icon_nav_follow), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.i(this.fhZ, d.e.cp_cont_f);
    }

    public void aXa() {
        this.ekP.clearAnimation();
        this.fhZ.clearAnimation();
        this.fia.clearAnimation();
        this.fib.clearAnimation();
        this.fhZ.setVisibility(8);
        this.fia.setVisibility(8);
        this.fib.setVisibility(8);
    }
}
