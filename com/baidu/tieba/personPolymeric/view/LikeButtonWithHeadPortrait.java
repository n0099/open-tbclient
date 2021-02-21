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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes8.dex */
public class LikeButtonWithHeadPortrait extends FrameLayout implements com.baidu.tbadk.core.view.userLike.b {
    private Animation.AnimationListener bMD;
    private TextView mFf;
    private HeadPendantView mFg;
    private View mFh;
    private View mFi;
    private boolean moi;

    public LikeButtonWithHeadPortrait(Context context) {
        super(context);
        this.bMD = new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.LikeButtonWithHeadPortrait.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LikeButtonWithHeadPortrait.this.dzw();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        init(context);
    }

    public LikeButtonWithHeadPortrait(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bMD = new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.LikeButtonWithHeadPortrait.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LikeButtonWithHeadPortrait.this.dzw();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        init(context);
    }

    public LikeButtonWithHeadPortrait(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bMD = new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.LikeButtonWithHeadPortrait.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LikeButtonWithHeadPortrait.this.dzw();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_like_button_with_head_portrait, this);
        this.mFg = (HeadPendantView) findViewById(R.id.head_img);
        this.mFg.getHeadView().setIsRound(true);
        this.mFf = (TextView) findViewById(R.id.btn_like);
        this.mFh = findViewById(R.id.view_background);
        this.mFi = findViewById(R.id.right_circular_view);
    }

    public void aM(boolean z) {
        this.moi = z;
        if (getWidth() != 0 && this.mFg.getWidth() != 0) {
            if (z) {
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, (getWidth() / 2) - (this.mFg.getWidth() / 2), 0.0f, 0.0f);
                translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                translateAnimation.setDuration(300L);
                translateAnimation.setFillAfter(true);
                translateAnimation.setAnimationListener(this.bMD);
                translateAnimation.setStartOffset(150L);
                this.mFg.startAnimation(translateAnimation);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, -((getWidth() / 2) - (this.mFg.getWidth() / 2)), 0.0f, 0.0f);
                translateAnimation2.setInterpolator(new AccelerateDecelerateInterpolator());
                translateAnimation2.setDuration(300L);
                translateAnimation2.setFillAfter(true);
                translateAnimation2.setStartOffset(150L);
                this.mFi.startAnimation(translateAnimation2);
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(150L);
                alphaAnimation.setFillAfter(true);
                this.mFf.startAnimation(alphaAnimation);
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, this.mFg.getWidth() / getWidth(), 1.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                scaleAnimation.setDuration(300L);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setStartOffset(150L);
                this.mFh.startAnimation(scaleAnimation);
                setClickable(false);
                return;
            }
            this.mFf.setVisibility(0);
            this.mFh.setVisibility(0);
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
    public void qb(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void bG(View view) {
        TiebaStatic.log(new ar("c12503").dR("obj_locate", "4"));
        if (!this.moi) {
            Context context = getContext();
            if ((context instanceof Activity) && (context instanceof com.baidu.tbadk.m.a)) {
                String stringExtra = ((Activity) context).getIntent().getStringExtra("thread_id");
                List<String> currentPageSourceKeyList = ((com.baidu.tbadk.m.a) context).getCurrentPageSourceKeyList();
                if (currentPageSourceKeyList != null && au.equals((String) y.getItem(currentPageSourceKeyList, currentPageSourceKeyList.size() - 1), PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE) && !au.isEmpty(stringExtra)) {
                    TiebaStatic.log(new ar("c12613").ap("obj_type", 1).dR("tid", stringExtra));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void i(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void dzw() {
        this.mFg.clearAnimation();
        this.mFf.clearAnimation();
        this.mFh.clearAnimation();
        this.mFi.clearAnimation();
        this.mFf.setVisibility(8);
        this.mFh.setVisibility(8);
        this.mFi.setVisibility(8);
    }
}
