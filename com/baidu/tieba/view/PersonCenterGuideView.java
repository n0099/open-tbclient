package com.baidu.tieba.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class PersonCenterGuideView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public boolean f21845e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f21846f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21847g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f21848h;
    public View i;
    public RotateAnimation j;
    public AlphaAnimation k;
    public AnimationSet l;
    public ObjectAnimator m;
    public ObjectAnimator n;
    public AnimatorSet o;
    public Animation.AnimationListener p;
    public final CustomMessageListener q;

    /* loaded from: classes5.dex */
    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            PersonCenterGuideView.this.k();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonCenterGuideView.this.f21845e) {
                return;
            }
            PersonCenterGuideView.this.f21845e = true;
            PersonCenterGuideView.this.setVisibility(0);
            PersonCenterGuideView.this.i.setVisibility(4);
            PersonCenterGuideView.this.f21846f.startAnimation(PersonCenterGuideView.this.l);
            d.b.i0.r.d0.b.j().t("has_shown_person_center_guide", PersonCenterGuideView.this.f21845e);
        }
    }

    public PersonCenterGuideView(Context context) {
        super(context);
        this.f21845e = false;
        this.p = new a();
        this.q = new b(2921423);
        i(context);
    }

    public final void g() {
        AnimatorSet animatorSet = this.o;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimationSet animationSet = this.l;
        if (animationSet != null) {
            animationSet.cancel();
        }
        RotateAnimation rotateAnimation = this.j;
        if (rotateAnimation != null) {
            rotateAnimation.cancel();
        }
        AlphaAnimation alphaAnimation = this.k;
        if (alphaAnimation != null) {
            alphaAnimation.cancel();
        }
    }

    public void h() {
        g();
        setVisibility(8);
    }

    public final void i(Context context) {
        LayoutInflater.from(context).inflate(R.layout.person_center_header_guide_layout, this);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.person_center_header_guide_circle);
        this.f21846f = tbImageView;
        tbImageView.setIsRound(true);
        this.i = findViewById(R.id.person_center_header_guide_tip_container);
        this.f21847g = (TextView) findViewById(R.id.person_center_header_guide_tip);
        this.f21848h = (ImageView) findViewById(R.id.person_center_header_guide_close);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.j = rotateAnimation;
        rotateAnimation.setDuration(660L);
        this.j.setAnimationListener(this.p);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.k = alphaAnimation;
        alphaAnimation.setDuration(660L);
        AnimationSet animationSet = new AnimationSet(true);
        this.l = animationSet;
        animationSet.addAnimation(this.j);
        this.l.addAnimation(this.k);
        this.f21845e = d.b.i0.r.d0.b.j().g("has_shown_person_center_guide", false);
    }

    public void j() {
        SkinManager.setImageResource(this.f21846f, R.drawable.person_center_head_guide_circle);
        SkinManager.setImageResource(this.f21848h, R.drawable.icon_topbar_close_white_n);
        SkinManager.setViewTextColor(this.f21847g, R.color.CAM_X0101, 1);
        SkinManager.setBackgroundResource(this.i, R.drawable.person_center_header_guide_tip_bg);
    }

    public final void k() {
        this.i.setVisibility(0);
        if (this.m == null) {
            this.m = ObjectAnimator.ofFloat(this.i, "translationX", -this.f21847g.getWidth(), 0.0f);
        }
        if (this.o == null) {
            this.n = ObjectAnimator.ofFloat(this.i, "alpha", 0.0f, 1.0f);
        }
        if (this.o == null) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.o = animatorSet;
            animatorSet.setDuration(500L);
        }
        this.o.play(this.m).with(this.n);
        this.o.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.q);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.q);
        g();
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21845e = false;
        this.p = new a();
        this.q = new b(2921423);
        i(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f21845e = false;
        this.p = new a();
        this.q = new b(2921423);
        i(context);
    }
}
