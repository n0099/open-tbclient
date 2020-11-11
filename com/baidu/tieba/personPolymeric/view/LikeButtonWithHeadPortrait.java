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
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes24.dex */
public class LikeButtonWithHeadPortrait extends FrameLayout implements com.baidu.tbadk.core.view.userLike.b {
    private Animation.AnimationListener bFu;
    private boolean lPQ;
    private TextView mgD;
    private HeadPendantView mgE;
    private View mgF;
    private View mgG;

    public LikeButtonWithHeadPortrait(Context context) {
        super(context);
        this.bFu = new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.LikeButtonWithHeadPortrait.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LikeButtonWithHeadPortrait.this.dwp();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        init(context);
    }

    public LikeButtonWithHeadPortrait(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bFu = new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.LikeButtonWithHeadPortrait.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LikeButtonWithHeadPortrait.this.dwp();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        init(context);
    }

    public LikeButtonWithHeadPortrait(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bFu = new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.LikeButtonWithHeadPortrait.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LikeButtonWithHeadPortrait.this.dwp();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_like_button_with_head_portrait, this);
        this.mgE = (HeadPendantView) findViewById(R.id.head_img);
        this.mgE.getHeadView().setIsRound(true);
        this.mgD = (TextView) findViewById(R.id.btn_like);
        this.mgF = findViewById(R.id.view_background);
        this.mgG = findViewById(R.id.right_circular_view);
    }

    public void aN(boolean z) {
        this.lPQ = z;
        if (getWidth() != 0 && this.mgE.getWidth() != 0) {
            if (z) {
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, (getWidth() / 2) - (this.mgE.getWidth() / 2), 0.0f, 0.0f);
                translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                translateAnimation.setDuration(300L);
                translateAnimation.setFillAfter(true);
                translateAnimation.setAnimationListener(this.bFu);
                translateAnimation.setStartOffset(150L);
                this.mgE.startAnimation(translateAnimation);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, -((getWidth() / 2) - (this.mgE.getWidth() / 2)), 0.0f, 0.0f);
                translateAnimation2.setInterpolator(new AccelerateDecelerateInterpolator());
                translateAnimation2.setDuration(300L);
                translateAnimation2.setFillAfter(true);
                translateAnimation2.setStartOffset(150L);
                this.mgG.startAnimation(translateAnimation2);
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(150L);
                alphaAnimation.setFillAfter(true);
                this.mgD.startAnimation(alphaAnimation);
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, this.mgE.getWidth() / getWidth(), 1.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                scaleAnimation.setDuration(300L);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setStartOffset(150L);
                this.mgF.startAnimation(scaleAnimation);
                setClickable(false);
                return;
            }
            this.mgD.setVisibility(0);
            this.mgF.setVisibility(0);
            setClickable(true);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void s(boolean z, int i) {
        aN(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        s(z, i);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void qr(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void bv(View view) {
        TiebaStatic.log(new aq("c12503").dR("obj_locate", "4"));
        if (!this.lPQ) {
            Context context = getContext();
            if ((context instanceof Activity) && (context instanceof com.baidu.tbadk.m.a)) {
                String stringExtra = ((Activity) context).getIntent().getStringExtra("thread_id");
                List<String> currentPageSourceKeyList = ((com.baidu.tbadk.m.a) context).getCurrentPageSourceKeyList();
                if (currentPageSourceKeyList != null && at.equals((String) y.getItem(currentPageSourceKeyList, currentPageSourceKeyList.size() - 1), PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE) && !at.isEmpty(stringExtra)) {
                    TiebaStatic.log(new aq("c12613").al("obj_type", 1).dR("tid", stringExtra));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void h(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void dwp() {
        this.mgE.clearAnimation();
        this.mgD.clearAnimation();
        this.mgF.clearAnimation();
        this.mgG.clearAnimation();
        this.mgD.setVisibility(8);
        this.mgF.setVisibility(8);
        this.mgG.setVisibility(8);
    }
}
