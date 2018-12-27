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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes3.dex */
public class LikeButtonWithHeadPortrait extends FrameLayout implements com.baidu.tbadk.core.view.userLike.b {
    private Animation.AnimationListener cEF;
    private boolean gBE;
    private TextView gCm;
    private HeadPendantView gCn;
    private View gCo;
    private View gCp;

    public LikeButtonWithHeadPortrait(Context context) {
        super(context);
        this.cEF = new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.LikeButtonWithHeadPortrait.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LikeButtonWithHeadPortrait.this.brn();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        init(context);
    }

    public LikeButtonWithHeadPortrait(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cEF = new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.LikeButtonWithHeadPortrait.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LikeButtonWithHeadPortrait.this.brn();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        init(context);
    }

    public LikeButtonWithHeadPortrait(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cEF = new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.LikeButtonWithHeadPortrait.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LikeButtonWithHeadPortrait.this.brn();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(e.h.view_like_button_with_head_portrait, this);
        this.gCn = (HeadPendantView) findViewById(e.g.head_img);
        this.gCn.getHeadView().setIsRound(true);
        this.gCm = (TextView) findViewById(e.g.btn_like);
        this.gCo = findViewById(e.g.view_background);
        this.gCp = findViewById(e.g.right_circular_view);
    }

    public void e(MetaData metaData) {
        this.gCn.a(metaData, e.C0210e.tbds42, e.C0210e.tbds24);
    }

    public void bK(boolean z) {
        this.gBE = z;
        if (getWidth() != 0 && this.gCn.getWidth() != 0) {
            if (z) {
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, (getWidth() / 2) - (this.gCn.getWidth() / 2), 0.0f, 0.0f);
                translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                translateAnimation.setDuration(300L);
                translateAnimation.setFillAfter(true);
                translateAnimation.setAnimationListener(this.cEF);
                translateAnimation.setStartOffset(150L);
                this.gCn.startAnimation(translateAnimation);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, -((getWidth() / 2) - (this.gCn.getWidth() / 2)), 0.0f, 0.0f);
                translateAnimation2.setInterpolator(new AccelerateDecelerateInterpolator());
                translateAnimation2.setDuration(300L);
                translateAnimation2.setFillAfter(true);
                translateAnimation2.setStartOffset(150L);
                this.gCp.startAnimation(translateAnimation2);
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(150L);
                alphaAnimation.setFillAfter(true);
                this.gCm.startAnimation(alphaAnimation);
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, this.gCn.getWidth() / getWidth(), 1.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                scaleAnimation.setDuration(300L);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setStartOffset(150L);
                this.gCo.startAnimation(scaleAnimation);
                setClickable(false);
                return;
            }
            this.gCm.setVisibility(0);
            this.gCo.setVisibility(0);
            setClickable(true);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void d(boolean z, int i) {
        bK(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        d(z, i);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void eF(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void X(View view) {
        TiebaStatic.log(new am("c12503").aA("obj_locate", "4"));
        if (!this.gBE) {
            Context context = getContext();
            if ((context instanceof Activity) && (context instanceof com.baidu.tbadk.pageStayDuration.a)) {
                String stringExtra = ((Activity) context).getIntent().getStringExtra("thread_id");
                List<String> currentPageSourceKeyList = ((com.baidu.tbadk.pageStayDuration.a) context).getCurrentPageSourceKeyList();
                if (currentPageSourceKeyList != null && ao.equals((String) v.d(currentPageSourceKeyList, currentPageSourceKeyList.size() - 1), "a002") && !ao.isEmpty(stringExtra)) {
                    TiebaStatic.log(new am("c12613").x("obj_type", 1).aA("tid", stringExtra));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void d(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        al.i(this.gCo, e.f.shape_person_top_like_bg);
        al.i(this.gCp, e.f.shape_person_top_like_bg);
        this.gCm.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_nav_follow), (Drawable) null, (Drawable) null, (Drawable) null);
        al.h(this.gCm, e.d.cp_cont_f);
    }

    public void brn() {
        this.gCn.clearAnimation();
        this.gCm.clearAnimation();
        this.gCo.clearAnimation();
        this.gCp.clearAnimation();
        this.gCm.setVisibility(8);
        this.gCo.setVisibility(8);
        this.gCp.setVisibility(8);
    }
}
