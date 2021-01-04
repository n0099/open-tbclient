package com.baidu.tieba.personPolymeric.view;

import android.app.Activity;
import android.content.Context;
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
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes8.dex */
public class LikeButtonWithHeadPortrait extends FrameLayout implements com.baidu.tbadk.core.view.userLike.b {
    private Animation.AnimationListener bNF;
    private TextView mAr;
    private HeadPendantView mAs;
    private View mAt;
    private View mAu;
    private boolean mjy;

    public LikeButtonWithHeadPortrait(Context context) {
        super(context);
        this.bNF = new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.LikeButtonWithHeadPortrait.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LikeButtonWithHeadPortrait.this.dAX();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        init(context);
    }

    public LikeButtonWithHeadPortrait(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bNF = new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.LikeButtonWithHeadPortrait.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LikeButtonWithHeadPortrait.this.dAX();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        init(context);
    }

    public LikeButtonWithHeadPortrait(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bNF = new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.LikeButtonWithHeadPortrait.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LikeButtonWithHeadPortrait.this.dAX();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_like_button_with_head_portrait, this);
        this.mAs = (HeadPendantView) findViewById(R.id.head_img);
        this.mAs.getHeadView().setIsRound(true);
        this.mAr = (TextView) findViewById(R.id.btn_like);
        this.mAt = findViewById(R.id.view_background);
        this.mAu = findViewById(R.id.right_circular_view);
    }

    public void aM(boolean z) {
        this.mjy = z;
        if (getWidth() != 0 && this.mAs.getWidth() != 0) {
            if (z) {
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, (getWidth() / 2) - (this.mAs.getWidth() / 2), 0.0f, 0.0f);
                translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                translateAnimation.setDuration(300L);
                translateAnimation.setFillAfter(true);
                translateAnimation.setAnimationListener(this.bNF);
                translateAnimation.setStartOffset(150L);
                this.mAs.startAnimation(translateAnimation);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, -((getWidth() / 2) - (this.mAs.getWidth() / 2)), 0.0f, 0.0f);
                translateAnimation2.setInterpolator(new AccelerateDecelerateInterpolator());
                translateAnimation2.setDuration(300L);
                translateAnimation2.setFillAfter(true);
                translateAnimation2.setStartOffset(150L);
                this.mAu.startAnimation(translateAnimation2);
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(150L);
                alphaAnimation.setFillAfter(true);
                this.mAr.startAnimation(alphaAnimation);
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, this.mAs.getWidth() / getWidth(), 1.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                scaleAnimation.setDuration(300L);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setStartOffset(150L);
                this.mAt.startAnimation(scaleAnimation);
                setClickable(false);
                return;
            }
            this.mAr.setVisibility(0);
            this.mAt.setVisibility(0);
            setClickable(true);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void r(boolean z, int i) {
        aM(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void c(boolean z, int i, boolean z2) {
        r(z, i);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void rC(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void bK(View view) {
        TiebaStatic.log(new aq("c12503").dX("obj_locate", "4"));
        if (!this.mjy) {
            Context context = getContext();
            if ((context instanceof Activity) && (context instanceof com.baidu.tbadk.m.a)) {
                String stringExtra = ((Activity) context).getIntent().getStringExtra("thread_id");
                List<String> currentPageSourceKeyList = ((com.baidu.tbadk.m.a) context).getCurrentPageSourceKeyList();
                if (currentPageSourceKeyList != null && at.equals((String) x.getItem(currentPageSourceKeyList, currentPageSourceKeyList.size() - 1), PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE) && !at.isEmpty(stringExtra)) {
                    TiebaStatic.log(new aq("c12613").an("obj_type", 1).dX("tid", stringExtra));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void i(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void dAX() {
        this.mAs.clearAnimation();
        this.mAr.clearAnimation();
        this.mAt.clearAnimation();
        this.mAu.clearAnimation();
        this.mAr.setVisibility(8);
        this.mAt.setVisibility(8);
        this.mAu.setVisibility(8);
    }
}
