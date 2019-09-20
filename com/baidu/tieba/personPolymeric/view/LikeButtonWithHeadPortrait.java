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
    private Animation.AnimationListener eiU;
    private boolean igx;
    private TextView ivn;
    private HeadPendantView ivo;
    private View ivp;
    private View ivq;

    public LikeButtonWithHeadPortrait(Context context) {
        super(context);
        this.eiU = new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.LikeButtonWithHeadPortrait.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LikeButtonWithHeadPortrait.this.ceq();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        init(context);
    }

    public LikeButtonWithHeadPortrait(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eiU = new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.LikeButtonWithHeadPortrait.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LikeButtonWithHeadPortrait.this.ceq();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        init(context);
    }

    public LikeButtonWithHeadPortrait(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eiU = new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.LikeButtonWithHeadPortrait.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LikeButtonWithHeadPortrait.this.ceq();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_like_button_with_head_portrait, this);
        this.ivo = (HeadPendantView) findViewById(R.id.head_img);
        this.ivo.getHeadView().setIsRound(true);
        this.ivn = (TextView) findViewById(R.id.btn_like);
        this.ivp = findViewById(R.id.view_background);
        this.ivq = findViewById(R.id.right_circular_view);
    }

    public void e(MetaData metaData) {
        this.ivo.a(metaData, R.dimen.tbds42, R.dimen.tbds24);
    }

    public void ey(boolean z) {
        this.igx = z;
        if (getWidth() != 0 && this.ivo.getWidth() != 0) {
            if (z) {
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, (getWidth() / 2) - (this.ivo.getWidth() / 2), 0.0f, 0.0f);
                translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                translateAnimation.setDuration(300L);
                translateAnimation.setFillAfter(true);
                translateAnimation.setAnimationListener(this.eiU);
                translateAnimation.setStartOffset(150L);
                this.ivo.startAnimation(translateAnimation);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, -((getWidth() / 2) - (this.ivo.getWidth() / 2)), 0.0f, 0.0f);
                translateAnimation2.setInterpolator(new AccelerateDecelerateInterpolator());
                translateAnimation2.setDuration(300L);
                translateAnimation2.setFillAfter(true);
                translateAnimation2.setStartOffset(150L);
                this.ivq.startAnimation(translateAnimation2);
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(150L);
                alphaAnimation.setFillAfter(true);
                this.ivn.startAnimation(alphaAnimation);
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, this.ivo.getWidth() / getWidth(), 1.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                scaleAnimation.setDuration(300L);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setStartOffset(150L);
                this.ivp.startAnimation(scaleAnimation);
                setClickable(false);
                return;
            }
            this.ivn.setVisibility(0);
            this.ivp.setVisibility(0);
            setClickable(true);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void f(boolean z, int i) {
        ey(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void d(boolean z, int i, boolean z2) {
        f(z, i);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void ji(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void aZ(View view) {
        TiebaStatic.log(new an("c12503").bT("obj_locate", "4"));
        if (!this.igx) {
            Context context = getContext();
            if ((context instanceof Activity) && (context instanceof com.baidu.tbadk.o.a)) {
                String stringExtra = ((Activity) context).getIntent().getStringExtra("thread_id");
                List<String> currentPageSourceKeyList = ((com.baidu.tbadk.o.a) context).getCurrentPageSourceKeyList();
                if (currentPageSourceKeyList != null && aq.bV((String) v.c(currentPageSourceKeyList, currentPageSourceKeyList.size() - 1), "a002") && !aq.isEmpty(stringExtra)) {
                    TiebaStatic.log(new an("c12613").P("obj_type", 1).bT("tid", stringExtra));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void e(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        am.k(this.ivp, R.drawable.shape_person_top_like_bg);
        am.k(this.ivq, R.drawable.shape_person_top_like_bg);
        this.ivn.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_nav_follow), (Drawable) null, (Drawable) null, (Drawable) null);
        am.j(this.ivn, R.color.cp_cont_f);
    }

    public void ceq() {
        this.ivo.clearAnimation();
        this.ivn.clearAnimation();
        this.ivp.clearAnimation();
        this.ivq.clearAnimation();
        this.ivn.setVisibility(8);
        this.ivp.setVisibility(8);
        this.ivq.setVisibility(8);
    }
}
