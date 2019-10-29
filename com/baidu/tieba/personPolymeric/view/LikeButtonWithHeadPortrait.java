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
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes6.dex */
public class LikeButtonWithHeadPortrait extends FrameLayout implements com.baidu.tbadk.core.view.userLike.b {
    private Animation.AnimationListener aqS;
    private boolean ifh;
    private TextView itP;
    private HeadPendantView itQ;
    private View itR;
    private View itS;

    public LikeButtonWithHeadPortrait(Context context) {
        super(context);
        this.aqS = new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.LikeButtonWithHeadPortrait.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LikeButtonWithHeadPortrait.this.cbs();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        init(context);
    }

    public LikeButtonWithHeadPortrait(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aqS = new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.LikeButtonWithHeadPortrait.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LikeButtonWithHeadPortrait.this.cbs();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        init(context);
    }

    public LikeButtonWithHeadPortrait(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aqS = new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.LikeButtonWithHeadPortrait.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LikeButtonWithHeadPortrait.this.cbs();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_like_button_with_head_portrait, this);
        this.itQ = (HeadPendantView) findViewById(R.id.head_img);
        this.itQ.getHeadView().setIsRound(true);
        this.itP = (TextView) findViewById(R.id.btn_like);
        this.itR = findViewById(R.id.view_background);
        this.itS = findViewById(R.id.right_circular_view);
    }

    public void e(MetaData metaData) {
        this.itQ.a(metaData, R.dimen.tbds42, R.dimen.tbds24);
    }

    public void ew(boolean z) {
        this.ifh = z;
        if (getWidth() != 0 && this.itQ.getWidth() != 0) {
            if (z) {
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, (getWidth() / 2) - (this.itQ.getWidth() / 2), 0.0f, 0.0f);
                translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                translateAnimation.setDuration(300L);
                translateAnimation.setFillAfter(true);
                translateAnimation.setAnimationListener(this.aqS);
                translateAnimation.setStartOffset(150L);
                this.itQ.startAnimation(translateAnimation);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, -((getWidth() / 2) - (this.itQ.getWidth() / 2)), 0.0f, 0.0f);
                translateAnimation2.setInterpolator(new AccelerateDecelerateInterpolator());
                translateAnimation2.setDuration(300L);
                translateAnimation2.setFillAfter(true);
                translateAnimation2.setStartOffset(150L);
                this.itS.startAnimation(translateAnimation2);
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(150L);
                alphaAnimation.setFillAfter(true);
                this.itP.startAnimation(alphaAnimation);
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, this.itQ.getWidth() / getWidth(), 1.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                scaleAnimation.setDuration(300L);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setStartOffset(150L);
                this.itR.startAnimation(scaleAnimation);
                setClickable(false);
                return;
            }
            this.itP.setVisibility(0);
            this.itR.setVisibility(0);
            setClickable(true);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void g(boolean z, int i) {
        ew(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void d(boolean z, int i, boolean z2) {
        g(z, i);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void iU(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void aZ(View view) {
        TiebaStatic.log(new an("c12503").bS("obj_locate", "4"));
        if (!this.ifh) {
            Context context = getContext();
            if ((context instanceof Activity) && (context instanceof com.baidu.tbadk.o.a)) {
                String stringExtra = ((Activity) context).getIntent().getStringExtra("thread_id");
                List<String> currentPageSourceKeyList = ((com.baidu.tbadk.o.a) context).getCurrentPageSourceKeyList();
                if (currentPageSourceKeyList != null && aq.equals((String) v.getItem(currentPageSourceKeyList, currentPageSourceKeyList.size() - 1), PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE) && !aq.isEmpty(stringExtra)) {
                    TiebaStatic.log(new an("c12613").O("obj_type", 1).bS("tid", stringExtra));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void f(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundResource(this.itR, R.drawable.shape_person_top_like_bg);
        am.setBackgroundResource(this.itS, R.drawable.shape_person_top_like_bg);
        this.itP.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_nav_follow), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(this.itP, (int) R.color.cp_cont_f);
    }

    public void cbs() {
        this.itQ.clearAnimation();
        this.itP.clearAnimation();
        this.itR.clearAnimation();
        this.itS.clearAnimation();
        this.itP.setVisibility(8);
        this.itR.setVisibility(8);
        this.itS.setVisibility(8);
    }
}
