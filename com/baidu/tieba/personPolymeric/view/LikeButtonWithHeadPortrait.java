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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes9.dex */
public class LikeButtonWithHeadPortrait extends FrameLayout implements com.baidu.tbadk.core.view.userLike.b {
    private Animation.AnimationListener ayY;
    private boolean jae;
    private TextView jqF;
    private HeadPendantView jqG;
    private View jqH;
    private View jqI;

    public LikeButtonWithHeadPortrait(Context context) {
        super(context);
        this.ayY = new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.LikeButtonWithHeadPortrait.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LikeButtonWithHeadPortrait.this.cwn();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        init(context);
    }

    public LikeButtonWithHeadPortrait(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ayY = new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.LikeButtonWithHeadPortrait.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LikeButtonWithHeadPortrait.this.cwn();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        init(context);
    }

    public LikeButtonWithHeadPortrait(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ayY = new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.LikeButtonWithHeadPortrait.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LikeButtonWithHeadPortrait.this.cwn();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_like_button_with_head_portrait, this);
        this.jqG = (HeadPendantView) findViewById(R.id.head_img);
        this.jqG.getHeadView().setIsRound(true);
        this.jqF = (TextView) findViewById(R.id.btn_like);
        this.jqH = findViewById(R.id.view_background);
        this.jqI = findViewById(R.id.right_circular_view);
    }

    public void fN(boolean z) {
        this.jae = z;
        if (getWidth() != 0 && this.jqG.getWidth() != 0) {
            if (z) {
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, (getWidth() / 2) - (this.jqG.getWidth() / 2), 0.0f, 0.0f);
                translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                translateAnimation.setDuration(300L);
                translateAnimation.setFillAfter(true);
                translateAnimation.setAnimationListener(this.ayY);
                translateAnimation.setStartOffset(150L);
                this.jqG.startAnimation(translateAnimation);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, -((getWidth() / 2) - (this.jqG.getWidth() / 2)), 0.0f, 0.0f);
                translateAnimation2.setInterpolator(new AccelerateDecelerateInterpolator());
                translateAnimation2.setDuration(300L);
                translateAnimation2.setFillAfter(true);
                translateAnimation2.setStartOffset(150L);
                this.jqI.startAnimation(translateAnimation2);
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(150L);
                alphaAnimation.setFillAfter(true);
                this.jqF.startAnimation(alphaAnimation);
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, this.jqG.getWidth() / getWidth(), 1.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                scaleAnimation.setDuration(300L);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setStartOffset(150L);
                this.jqH.startAnimation(scaleAnimation);
                setClickable(false);
                return;
            }
            this.jqF.setVisibility(0);
            this.jqH.setVisibility(0);
            setClickable(true);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void l(boolean z, int i) {
        fN(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void b(boolean z, int i, boolean z2) {
        l(z, i);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void lg(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void ba(View view) {
        TiebaStatic.log(new an("c12503").cp("obj_locate", "4"));
        if (!this.jae) {
            Context context = getContext();
            if ((context instanceof Activity) && (context instanceof com.baidu.tbadk.m.a)) {
                String stringExtra = ((Activity) context).getIntent().getStringExtra("thread_id");
                List<String> currentPageSourceKeyList = ((com.baidu.tbadk.m.a) context).getCurrentPageSourceKeyList();
                if (currentPageSourceKeyList != null && aq.equals((String) v.getItem(currentPageSourceKeyList, currentPageSourceKeyList.size() - 1), PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE) && !aq.isEmpty(stringExtra)) {
                    TiebaStatic.log(new an("c12613").Z("obj_type", 1).cp("tid", stringExtra));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void cwn() {
        this.jqG.clearAnimation();
        this.jqF.clearAnimation();
        this.jqH.clearAnimation();
        this.jqI.clearAnimation();
        this.jqF.setVisibility(8);
        this.jqH.setVisibility(8);
        this.jqI.setVisibility(8);
    }
}
