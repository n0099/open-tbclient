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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes6.dex */
public class LikeButtonWithHeadPortrait extends FrameLayout implements com.baidu.tbadk.core.view.userLike.b {
    private Animation.AnimationListener ecH;
    private TextView ilT;
    private HeadPendantView ilU;
    private View ilV;
    private View ilW;
    private boolean ill;

    public LikeButtonWithHeadPortrait(Context context) {
        super(context);
        this.ecH = new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.LikeButtonWithHeadPortrait.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LikeButtonWithHeadPortrait.this.cav();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        init(context);
    }

    public LikeButtonWithHeadPortrait(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ecH = new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.LikeButtonWithHeadPortrait.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LikeButtonWithHeadPortrait.this.cav();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        init(context);
    }

    public LikeButtonWithHeadPortrait(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ecH = new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.LikeButtonWithHeadPortrait.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LikeButtonWithHeadPortrait.this.cav();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_like_button_with_head_portrait, this);
        this.ilU = (HeadPendantView) findViewById(R.id.head_img);
        this.ilU.getHeadView().setIsRound(true);
        this.ilT = (TextView) findViewById(R.id.btn_like);
        this.ilV = findViewById(R.id.view_background);
        this.ilW = findViewById(R.id.right_circular_view);
    }

    public void e(MetaData metaData) {
        this.ilU.a(metaData, R.dimen.tbds42, R.dimen.tbds24);
    }

    public void er(boolean z) {
        this.ill = z;
        if (getWidth() != 0 && this.ilU.getWidth() != 0) {
            if (z) {
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, (getWidth() / 2) - (this.ilU.getWidth() / 2), 0.0f, 0.0f);
                translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                translateAnimation.setDuration(300L);
                translateAnimation.setFillAfter(true);
                translateAnimation.setAnimationListener(this.ecH);
                translateAnimation.setStartOffset(150L);
                this.ilU.startAnimation(translateAnimation);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, -((getWidth() / 2) - (this.ilU.getWidth() / 2)), 0.0f, 0.0f);
                translateAnimation2.setInterpolator(new AccelerateDecelerateInterpolator());
                translateAnimation2.setDuration(300L);
                translateAnimation2.setFillAfter(true);
                translateAnimation2.setStartOffset(150L);
                this.ilW.startAnimation(translateAnimation2);
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(150L);
                alphaAnimation.setFillAfter(true);
                this.ilT.startAnimation(alphaAnimation);
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, this.ilU.getWidth() / getWidth(), 1.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                scaleAnimation.setDuration(300L);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setStartOffset(150L);
                this.ilV.startAnimation(scaleAnimation);
                setClickable(false);
                return;
            }
            this.ilT.setVisibility(0);
            this.ilV.setVisibility(0);
            setClickable(true);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void f(boolean z, int i) {
        er(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void d(boolean z, int i, boolean z2) {
        f(z, i);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void iY(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void aX(View view) {
        TiebaStatic.log(new am("c12503").bT("obj_locate", "4"));
        if (!this.ill) {
            Context context = getContext();
            if ((context instanceof Activity) && (context instanceof com.baidu.tbadk.o.a)) {
                String stringExtra = ((Activity) context).getIntent().getStringExtra("thread_id");
                List<String> currentPageSourceKeyList = ((com.baidu.tbadk.o.a) context).getCurrentPageSourceKeyList();
                if (currentPageSourceKeyList != null && ap.equals((String) v.c(currentPageSourceKeyList, currentPageSourceKeyList.size() - 1), "a002") && !ap.isEmpty(stringExtra)) {
                    TiebaStatic.log(new am("c12613").P("obj_type", 1).bT("tid", stringExtra));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void e(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        al.k(this.ilV, R.drawable.shape_person_top_like_bg);
        al.k(this.ilW, R.drawable.shape_person_top_like_bg);
        this.ilT.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_nav_follow), (Drawable) null, (Drawable) null, (Drawable) null);
        al.j(this.ilT, R.color.cp_cont_f);
    }

    public void cav() {
        this.ilU.clearAnimation();
        this.ilT.clearAnimation();
        this.ilV.clearAnimation();
        this.ilW.clearAnimation();
        this.ilT.setVisibility(8);
        this.ilV.setVisibility(8);
        this.ilW.setVisibility(8);
    }
}
