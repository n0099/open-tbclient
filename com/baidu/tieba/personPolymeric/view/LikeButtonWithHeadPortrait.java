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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class LikeButtonWithHeadPortrait extends FrameLayout implements com.baidu.tbadk.core.view.userLike.b {
    private Animation.AnimationListener bXG;
    private HeadImageView cqL;
    private boolean fKZ;
    private TextView fLI;
    private View fLJ;
    private View fLK;

    public LikeButtonWithHeadPortrait(Context context) {
        super(context);
        this.bXG = new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.LikeButtonWithHeadPortrait.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LikeButtonWithHeadPortrait.this.bfH();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        init(context);
    }

    public LikeButtonWithHeadPortrait(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bXG = new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.LikeButtonWithHeadPortrait.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LikeButtonWithHeadPortrait.this.bfH();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        init(context);
    }

    public LikeButtonWithHeadPortrait(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bXG = new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.LikeButtonWithHeadPortrait.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LikeButtonWithHeadPortrait.this.bfH();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.i.view_like_button_with_head_portrait, this);
        this.cqL = (HeadImageView) findViewById(d.g.head_img);
        this.cqL.setIsRound(true);
        this.fLI = (TextView) findViewById(d.g.btn_like);
        this.fLJ = findViewById(d.g.view_background);
        this.fLK = findViewById(d.g.right_circular_view);
    }

    public void setPortraitUrl(String str) {
        this.cqL.startLoad(str, 12, false);
    }

    public void aQ(boolean z) {
        this.fKZ = z;
        if (getWidth() != 0 && this.cqL.getWidth() != 0) {
            if (z) {
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, (getWidth() / 2) - (this.cqL.getWidth() / 2), 0.0f, 0.0f);
                translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                translateAnimation.setDuration(300L);
                translateAnimation.setFillAfter(true);
                translateAnimation.setAnimationListener(this.bXG);
                translateAnimation.setStartOffset(150L);
                this.cqL.startAnimation(translateAnimation);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, -((getWidth() / 2) - (this.cqL.getWidth() / 2)), 0.0f, 0.0f);
                translateAnimation2.setInterpolator(new AccelerateDecelerateInterpolator());
                translateAnimation2.setDuration(300L);
                translateAnimation2.setFillAfter(true);
                translateAnimation2.setStartOffset(150L);
                this.fLK.startAnimation(translateAnimation2);
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(150L);
                alphaAnimation.setFillAfter(true);
                this.fLI.startAnimation(alphaAnimation);
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, this.cqL.getWidth() / getWidth(), 1.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                scaleAnimation.setDuration(300L);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setStartOffset(150L);
                this.fLJ.startAnimation(scaleAnimation);
                setClickable(false);
                return;
            }
            this.fLI.setVisibility(0);
            this.fLJ.setVisibility(0);
            setClickable(true);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void d(boolean z, int i) {
        aQ(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        d(z, i);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void dB(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void K(View view2) {
        TiebaStatic.log(new al("c12503").ac("obj_locate", "4"));
        if (!this.fKZ) {
            Context context = getContext();
            if ((context instanceof Activity) && (context instanceof com.baidu.tbadk.pageStayDuration.a)) {
                String stringExtra = ((Activity) context).getIntent().getStringExtra("thread_id");
                List<String> currentPageSourceKeyList = ((com.baidu.tbadk.pageStayDuration.a) context).getCurrentPageSourceKeyList();
                if (currentPageSourceKeyList != null && an.equals((String) v.c(currentPageSourceKeyList, currentPageSourceKeyList.size() - 1), "a002") && !an.isEmpty(stringExtra)) {
                    TiebaStatic.log(new al("c12613").r("obj_type", 1).ac("tid", stringExtra));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        ak.i(this.fLJ, d.f.shape_person_top_like_bg);
        ak.i(this.fLK, d.f.shape_person_top_like_bg);
        this.fLI.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.icon_nav_follow), (Drawable) null, (Drawable) null, (Drawable) null);
        ak.h(this.fLI, d.C0126d.cp_cont_f);
    }

    public void bfH() {
        this.cqL.clearAnimation();
        this.fLI.clearAnimation();
        this.fLJ.clearAnimation();
        this.fLK.clearAnimation();
        this.fLI.setVisibility(8);
        this.fLJ.setVisibility(8);
        this.fLK.setVisibility(8);
    }
}
