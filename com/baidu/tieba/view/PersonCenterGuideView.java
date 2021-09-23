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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PersonCenterGuideView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f58409e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f58410f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f58411g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f58412h;

    /* renamed from: i  reason: collision with root package name */
    public View f58413i;

    /* renamed from: j  reason: collision with root package name */
    public RotateAnimation f58414j;
    public AlphaAnimation k;
    public AnimationSet l;
    public ObjectAnimator m;
    public ObjectAnimator n;
    public AnimatorSet o;
    public Animation.AnimationListener p;
    public final CustomMessageListener q;

    /* loaded from: classes7.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonCenterGuideView f58415a;

        public a(PersonCenterGuideView personCenterGuideView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personCenterGuideView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58415a = personCenterGuideView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f58415a.i();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonCenterGuideView f58416a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PersonCenterGuideView personCenterGuideView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personCenterGuideView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58416a = personCenterGuideView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f58416a.f58409e) {
                return;
            }
            this.f58416a.f58409e = true;
            this.f58416a.setVisibility(0);
            this.f58416a.f58413i.setVisibility(4);
            this.f58416a.f58410f.startAnimation(this.f58416a.l);
            c.a.q0.s.d0.b.j().t("has_shown_person_center_guide", this.f58416a.f58409e);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonCenterGuideView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58409e = false;
        this.p = new a(this);
        this.q = new b(this, 2921423);
        h(context);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            AnimatorSet animatorSet = this.o;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimationSet animationSet = this.l;
            if (animationSet != null) {
                animationSet.cancel();
            }
            RotateAnimation rotateAnimation = this.f58414j;
            if (rotateAnimation != null) {
                rotateAnimation.cancel();
            }
            AlphaAnimation alphaAnimation = this.k;
            if (alphaAnimation != null) {
                alphaAnimation.cancel();
            }
        }
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.person_center_header_guide_layout, this);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.person_center_header_guide_circle);
            this.f58410f = tbImageView;
            tbImageView.setIsRound(true);
            this.f58413i = findViewById(R.id.person_center_header_guide_tip_container);
            this.f58411g = (TextView) findViewById(R.id.person_center_header_guide_tip);
            this.f58412h = (ImageView) findViewById(R.id.person_center_header_guide_close);
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
            this.f58414j = rotateAnimation;
            rotateAnimation.setDuration(660L);
            this.f58414j.setAnimationListener(this.p);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.k = alphaAnimation;
            alphaAnimation.setDuration(660L);
            AnimationSet animationSet = new AnimationSet(true);
            this.l = animationSet;
            animationSet.addAnimation(this.f58414j);
            this.l.addAnimation(this.k);
            this.f58409e = c.a.q0.s.d0.b.j().g("has_shown_person_center_guide", false);
        }
    }

    public void hideAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            g();
            setVisibility(8);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f58413i.setVisibility(0);
            if (this.m == null) {
                this.m = ObjectAnimator.ofFloat(this.f58413i, "translationX", -this.f58411g.getWidth(), 0.0f);
            }
            if (this.o == null) {
                this.n = ObjectAnimator.ofFloat(this.f58413i, "alpha", 0.0f, 1.0f);
            }
            if (this.o == null) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.o = animatorSet;
                animatorSet.setDuration(500L);
            }
            this.o.play(this.m).with(this.n);
            this.o.start();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.q);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SkinManager.setImageResource(this.f58410f, R.drawable.person_center_head_guide_circle);
            SkinManager.setImageResource(this.f58412h, R.drawable.icon_topbar_close_white_n);
            SkinManager.setViewTextColor(this.f58411g, R.color.CAM_X0101, 1);
            SkinManager.setBackgroundResource(this.f58413i, R.drawable.person_center_header_guide_tip_bg);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.q);
            g();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonCenterGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f58409e = false;
        this.p = new a(this);
        this.q = new b(this, 2921423);
        h(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonCenterGuideView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f58409e = false;
        this.p = new a(this);
        this.q = new b(this, 2921423);
        h(context);
    }
}
