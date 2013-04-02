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
public class bc implements View.OnClickListener {
    final /* synthetic */ NewNearbyActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(NewNearbyActivity newNearbyActivity) {
        this.a = newNearbyActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        boolean q;
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
        imageView = this.a.z;
        if (view != imageView) {
            imageView2 = this.a.A;
            if (view != imageView2) {
                imageView3 = this.a.B;
                if (view != imageView3) {
                    imageView4 = this.a.t;
                    if (view != imageView4) {
                        return;
                    }
                    q = this.a.q();
                    if (q) {
                        viewPager = this.a.j;
                        if (viewPager.getChildCount() == 0) {
                            this.a.n();
                            return;
                        } else {
                            this.a.r();
                            return;
                        }
                    }
                    return;
                }
                if (TiebaApplication.b().l()) {
                    StatService.onEvent(this.a, "lbs_post_text", "lbsclick", 1);
                }
                this.a.m();
                this.a.c(0);
                return;
            }
            if (TiebaApplication.b().l()) {
                StatService.onEvent(this.a, "lbs_post_pic", "lbsclick", 1);
            }
            this.a.m();
            this.a.c(1);
            return;
        }
        if (TiebaApplication.b().l()) {
            StatService.onEvent(this.a, "lbs_expend_post", "lbsclick", 1);
        }
        imageView5 = this.a.z;
        if (imageView5.getAnimation() != null) {
            imageView21 = this.a.z;
            if (!imageView21.getAnimation().hasEnded()) {
                return;
            }
        }
        z = this.a.E;
        if (z) {
            imageView13 = this.a.B;
            imageView13.setVisibility(0);
            imageView14 = this.a.A;
            imageView14.setVisibility(0);
            RotateAnimation rotateAnimation2 = new RotateAnimation(0.0f, 315.0f, 1, 0.5f, 1, 0.5f);
            imageView15 = this.a.B;
            imageView16 = this.a.z;
            TranslateAnimation translateAnimation3 = new TranslateAnimation((-imageView15.getLeft()) + imageView16.getLeft(), 0.0f, 0.0f, 0.0f);
            translateAnimation3.setInterpolator(new OvershootInterpolator(4.0f));
            imageView17 = this.a.B;
            imageView17.setVisibility(0);
            imageView18 = this.a.A;
            imageView19 = this.a.z;
            TranslateAnimation translateAnimation4 = new TranslateAnimation((-imageView18.getLeft()) + imageView19.getLeft(), 0.0f, 0.0f, 0.0f);
            translateAnimation4.setInterpolator(new OvershootInterpolator(3.0f));
            imageView20 = this.a.A;
            imageView20.setVisibility(0);
            this.a.E = false;
            translateAnimation2 = translateAnimation4;
            rotateAnimation = rotateAnimation2;
            translateAnimation = translateAnimation3;
        } else {
            rotateAnimation = new RotateAnimation(315.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            imageView6 = this.a.B;
            imageView7 = this.a.z;
            translateAnimation = new TranslateAnimation(0.0f, (-imageView6.getLeft()) + imageView7.getLeft(), 0.0f, 0.0f);
            translateAnimation.setInterpolator(new AnticipateInterpolator(4.0f));
            animationListener = this.a.D;
            translateAnimation.setAnimationListener(animationListener);
            imageView8 = this.a.A;
            imageView9 = this.a.z;
            TranslateAnimation translateAnimation5 = new TranslateAnimation(0.0f, (-imageView8.getLeft()) + imageView9.getLeft(), 0.0f, 0.0f);
            translateAnimation5.setInterpolator(new AnticipateInterpolator(3.0f));
            this.a.E = true;
            translateAnimation2 = translateAnimation5;
        }
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setDuration(400L);
        imageView10 = this.a.z;
        imageView10.startAnimation(rotateAnimation);
        translateAnimation.setDuration(400L);
        imageView11 = this.a.B;
        imageView11.startAnimation(translateAnimation);
        translateAnimation2.setDuration(400L);
        imageView12 = this.a.A;
        imageView12.startAnimation(translateAnimation2);
    }
}
