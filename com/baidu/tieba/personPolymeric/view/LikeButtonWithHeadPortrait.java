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
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.R;
import d.a.c.e.p.k;
import d.a.m0.r.f0.q.b;
import java.util.List;
/* loaded from: classes5.dex */
public class LikeButtonWithHeadPortrait extends FrameLayout implements b {

    /* renamed from: e  reason: collision with root package name */
    public TextView f19967e;

    /* renamed from: f  reason: collision with root package name */
    public HeadPendantView f19968f;

    /* renamed from: g  reason: collision with root package name */
    public View f19969g;

    /* renamed from: h  reason: collision with root package name */
    public View f19970h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f19971i;
    public Animation.AnimationListener j;

    /* loaded from: classes5.dex */
    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            LikeButtonWithHeadPortrait.this.g();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public LikeButtonWithHeadPortrait(Context context) {
        super(context);
        this.j = new a();
        f(context);
    }

    @Override // d.a.m0.r.f0.q.b
    public void a(View view) {
        TiebaStatic.log(new StatisticItem("c12503").param("obj_locate", "4"));
        if (this.f19971i) {
            return;
        }
        Context context = getContext();
        if ((context instanceof Activity) && (context instanceof d.a.m0.k0.a)) {
            String stringExtra = ((Activity) context).getIntent().getStringExtra("thread_id");
            List<String> currentPageSourceKeyList = ((d.a.m0.k0.a) context).getCurrentPageSourceKeyList();
            if (currentPageSourceKeyList == null || !StringHelper.equals((String) ListUtils.getItem(currentPageSourceKeyList, currentPageSourceKeyList.size() - 1), "a002") || k.isEmpty(stringExtra)) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c12613").param("obj_type", 1).param("tid", stringExtra));
        }
    }

    @Override // d.a.m0.r.f0.q.b
    public void b(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    @Override // d.a.m0.r.f0.q.b
    public void c(boolean z, int i2, boolean z2) {
        e(z, i2);
    }

    @Override // d.a.m0.r.f0.q.b
    public void d(int i2) {
    }

    @Override // d.a.m0.r.f0.q.b
    public void e(boolean z, int i2) {
        h(z);
    }

    public final void f(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_like_button_with_head_portrait, this);
        HeadPendantView headPendantView = (HeadPendantView) findViewById(R.id.head_img);
        this.f19968f = headPendantView;
        headPendantView.getHeadView().setIsRound(true);
        this.f19967e = (TextView) findViewById(R.id.btn_like);
        this.f19969g = findViewById(R.id.view_background);
        this.f19970h = findViewById(R.id.right_circular_view);
    }

    public void g() {
        this.f19968f.clearAnimation();
        this.f19967e.clearAnimation();
        this.f19969g.clearAnimation();
        this.f19970h.clearAnimation();
        this.f19967e.setVisibility(8);
        this.f19969g.setVisibility(8);
        this.f19970h.setVisibility(8);
    }

    public void h(boolean z) {
        this.f19971i = z;
        if (getWidth() == 0 || this.f19968f.getWidth() == 0) {
            return;
        }
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, (getWidth() / 2) - (this.f19968f.getWidth() / 2), 0.0f, 0.0f);
            translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
            translateAnimation.setDuration(300L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setAnimationListener(this.j);
            translateAnimation.setStartOffset(150L);
            this.f19968f.startAnimation(translateAnimation);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, -((getWidth() / 2) - (this.f19968f.getWidth() / 2)), 0.0f, 0.0f);
            translateAnimation2.setInterpolator(new AccelerateDecelerateInterpolator());
            translateAnimation2.setDuration(300L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setStartOffset(150L);
            this.f19970h.startAnimation(translateAnimation2);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(150L);
            alphaAnimation.setFillAfter(true);
            this.f19967e.startAnimation(alphaAnimation);
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, this.f19968f.getWidth() / getWidth(), 1.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
            scaleAnimation.setDuration(300L);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setStartOffset(150L);
            this.f19969g.startAnimation(scaleAnimation);
            setClickable(false);
            return;
        }
        this.f19967e.setVisibility(0);
        this.f19969g.setVisibility(0);
        setClickable(true);
    }

    public LikeButtonWithHeadPortrait(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = new a();
        f(context);
    }

    public LikeButtonWithHeadPortrait(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.j = new a();
        f(context);
    }
}
