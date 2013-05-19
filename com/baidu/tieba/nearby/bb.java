package com.baidu.tieba.nearby;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements View.OnClickListener {
    final /* synthetic */ NewNearbyActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(NewNearbyActivity newNearbyActivity) {
        this.a = newNearbyActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        boolean r;
        ViewPager viewPager;
        ImageView imageView5;
        boolean z;
        RotateAnimation rotateAnimation;
        TranslateAnimation translateAnimation;
        ImageView imageView6;
        ImageView imageView7;
        Animation.AnimationListener animationListener;
        ImageView imageView8;
        ImageView imageView9;
        TranslateAnimation translateAnimation2;
        ImageView imageView10;
        ImageView imageView11;
        ImageView imageView12;
        ImageView imageView13;
        ImageView imageView14;
        ImageView imageView15;
        ImageView imageView16;
        ImageView imageView17;
        ImageView imageView18;
        ImageView imageView19;
        ImageView imageView20;
        ImageView imageView21;
        imageView = this.a.A;
        if (view != imageView) {
            imageView2 = this.a.B;
            if (view != imageView2) {
                imageView3 = this.a.C;
                if (view != imageView3) {
                    imageView4 = this.a.u;
                    if (view != imageView4) {
                        return;
                    }
                    r = this.a.r();
                    if (r) {
                        viewPager = this.a.k;
                        if (viewPager.getChildCount() == 0) {
                            this.a.o();
                            return;
                        } else {
                            this.a.s();
                            return;
                        }
                    }
                    return;
                }
                if (TiebaApplication.d().n()) {
                    StatService.onEvent(this.a, "lbs_post_text", "lbsclick", 1);
                }
                this.a.n();
                this.a.c(0);
                return;
            }
            if (TiebaApplication.d().n()) {
                StatService.onEvent(this.a, "lbs_post_pic", "lbsclick", 1);
            }
            this.a.n();
            this.a.c(1);
            return;
        }
        if (TiebaApplication.d().n()) {
            StatService.onEvent(this.a, "lbs_expend_post", "lbsclick", 1);
        }
        imageView5 = this.a.A;
        if (imageView5.getAnimation() != null) {
            imageView21 = this.a.A;
            if (!imageView21.getAnimation().hasEnded()) {
                return;
            }
        }
        z = this.a.F;
        if (z) {
            imageView13 = this.a.C;
            imageView13.setVisibility(0);
            imageView14 = this.a.B;
            imageView14.setVisibility(0);
            RotateAnimation rotateAnimation2 = new RotateAnimation(0.0f, 315.0f, 1, 0.5f, 1, 0.5f);
            imageView15 = this.a.C;
            imageView16 = this.a.A;
            TranslateAnimation translateAnimation3 = new TranslateAnimation((-imageView15.getLeft()) + imageView16.getLeft(), 0.0f, 0.0f, 0.0f);
            translateAnimation3.setInterpolator(new OvershootInterpolator(4.0f));
            imageView17 = this.a.C;
            imageView17.setVisibility(0);
            imageView18 = this.a.B;
            imageView19 = this.a.A;
            TranslateAnimation translateAnimation4 = new TranslateAnimation((-imageView18.getLeft()) + imageView19.getLeft(), 0.0f, 0.0f, 0.0f);
            translateAnimation4.setInterpolator(new OvershootInterpolator(3.0f));
            imageView20 = this.a.B;
            imageView20.setVisibility(0);
            this.a.F = false;
            translateAnimation2 = translateAnimation4;
            rotateAnimation = rotateAnimation2;
            translateAnimation = translateAnimation3;
        } else {
            rotateAnimation = new RotateAnimation(315.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            imageView6 = this.a.C;
            imageView7 = this.a.A;
            translateAnimation = new TranslateAnimation(0.0f, (-imageView6.getLeft()) + imageView7.getLeft(), 0.0f, 0.0f);
            translateAnimation.setInterpolator(new AnticipateInterpolator(4.0f));
            animationListener = this.a.E;
            translateAnimation.setAnimationListener(animationListener);
            imageView8 = this.a.B;
            imageView9 = this.a.A;
            TranslateAnimation translateAnimation5 = new TranslateAnimation(0.0f, (-imageView8.getLeft()) + imageView9.getLeft(), 0.0f, 0.0f);
            translateAnimation5.setInterpolator(new AnticipateInterpolator(3.0f));
            this.a.F = true;
            translateAnimation2 = translateAnimation5;
        }
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setDuration(400L);
        imageView10 = this.a.A;
        imageView10.startAnimation(rotateAnimation);
        translateAnimation.setDuration(400L);
        imageView11 = this.a.C;
        imageView11.startAnimation(translateAnimation);
        translateAnimation2.setDuration(400L);
        imageView12 = this.a.B;
        imageView12.startAnimation(translateAnimation2);
    }
}
