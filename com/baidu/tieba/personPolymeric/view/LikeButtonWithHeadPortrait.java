package com.baidu.tieba.personPolymeric.view;

import android.app.Activity;
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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class LikeButtonWithHeadPortrait extends FrameLayout implements com.baidu.tbadk.core.view.userLike.b {
    private HeadImageView cAv;
    private Animation.AnimationListener cgu;
    private TextView fXX;
    private View fXY;
    private View fXZ;
    private boolean fXo;

    public LikeButtonWithHeadPortrait(Context context) {
        super(context);
        this.cgu = new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.LikeButtonWithHeadPortrait.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LikeButtonWithHeadPortrait.this.bkG();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        init(context);
    }

    public LikeButtonWithHeadPortrait(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cgu = new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.LikeButtonWithHeadPortrait.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LikeButtonWithHeadPortrait.this.bkG();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        init(context);
    }

    public LikeButtonWithHeadPortrait(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cgu = new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.LikeButtonWithHeadPortrait.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LikeButtonWithHeadPortrait.this.bkG();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.i.view_like_button_with_head_portrait, this);
        this.cAv = (HeadImageView) findViewById(d.g.head_img);
        this.cAv.setIsRound(true);
        this.fXX = (TextView) findViewById(d.g.btn_like);
        this.fXY = findViewById(d.g.view_background);
        this.fXZ = findViewById(d.g.right_circular_view);
    }

    public void setPortraitUrl(String str) {
        this.cAv.startLoad(str, 12, false);
    }

    public void aU(boolean z) {
        this.fXo = z;
        if (getWidth() != 0 && this.cAv.getWidth() != 0) {
            if (z) {
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, (getWidth() / 2) - (this.cAv.getWidth() / 2), 0.0f, 0.0f);
                translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                translateAnimation.setDuration(300L);
                translateAnimation.setFillAfter(true);
                translateAnimation.setAnimationListener(this.cgu);
                translateAnimation.setStartOffset(150L);
                this.cAv.startAnimation(translateAnimation);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, -((getWidth() / 2) - (this.cAv.getWidth() / 2)), 0.0f, 0.0f);
                translateAnimation2.setInterpolator(new AccelerateDecelerateInterpolator());
                translateAnimation2.setDuration(300L);
                translateAnimation2.setFillAfter(true);
                translateAnimation2.setStartOffset(150L);
                this.fXZ.startAnimation(translateAnimation2);
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(150L);
                alphaAnimation.setFillAfter(true);
                this.fXX.startAnimation(alphaAnimation);
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, this.cAv.getWidth() / getWidth(), 1.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                scaleAnimation.setDuration(300L);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setStartOffset(150L);
                this.fXY.startAnimation(scaleAnimation);
                setClickable(false);
                return;
            }
            this.fXX.setVisibility(0);
            this.fXY.setVisibility(0);
            setClickable(true);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void d(boolean z, int i) {
        aU(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        d(z, i);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void dE(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void K(View view) {
        TiebaStatic.log(new am("c12503").ah("obj_locate", "4"));
        if (!this.fXo) {
            Context context = getContext();
            if ((context instanceof Activity) && (context instanceof com.baidu.tbadk.pageStayDuration.a)) {
                String stringExtra = ((Activity) context).getIntent().getStringExtra("thread_id");
                List<String> currentPageSourceKeyList = ((com.baidu.tbadk.pageStayDuration.a) context).getCurrentPageSourceKeyList();
                if (currentPageSourceKeyList != null && ao.equals((String) w.c(currentPageSourceKeyList, currentPageSourceKeyList.size() - 1), "a002") && !ao.isEmpty(stringExtra)) {
                    TiebaStatic.log(new am("c12613").r("obj_type", 1).ah("tid", stringExtra));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        al.i(this.fXY, d.f.shape_person_top_like_bg);
        al.i(this.fXZ, d.f.shape_person_top_like_bg);
        this.fXX.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_nav_follow), (Drawable) null, (Drawable) null, (Drawable) null);
        al.h(this.fXX, d.C0141d.cp_cont_f);
    }

    public void bkG() {
        this.cAv.clearAnimation();
        this.fXX.clearAnimation();
        this.fXY.clearAnimation();
        this.fXZ.clearAnimation();
        this.fXX.setVisibility(8);
        this.fXY.setVisibility(8);
        this.fXZ.setVisibility(8);
    }
}
