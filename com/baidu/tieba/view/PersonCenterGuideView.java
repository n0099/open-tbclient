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
import androidx.constraintlayout.motion.widget.Key;
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
/* loaded from: classes9.dex */
public class PersonCenterGuideView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f55351e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f55352f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f55353g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f55354h;

    /* renamed from: i  reason: collision with root package name */
    public View f55355i;
    public RotateAnimation j;
    public AlphaAnimation k;
    public AnimationSet l;
    public ObjectAnimator m;
    public ObjectAnimator n;
    public AnimatorSet o;
    public Animation.AnimationListener p;
    public final CustomMessageListener q;

    /* loaded from: classes9.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonCenterGuideView f55356a;

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
            this.f55356a = personCenterGuideView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f55356a.i();
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

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonCenterGuideView f55357a;

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
            this.f55357a = personCenterGuideView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f55357a.f55351e) {
                return;
            }
            this.f55357a.f55351e = true;
            this.f55357a.setVisibility(0);
            this.f55357a.f55355i.setVisibility(4);
            this.f55357a.f55352f.startAnimation(this.f55357a.l);
            b.a.q0.s.e0.b.j().t("has_shown_person_center_guide", this.f55357a.f55351e);
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
        this.f55351e = false;
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
            RotateAnimation rotateAnimation = this.j;
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
            this.f55352f = tbImageView;
            tbImageView.setIsRound(true);
            this.f55355i = findViewById(R.id.person_center_header_guide_tip_container);
            this.f55353g = (TextView) findViewById(R.id.person_center_header_guide_tip);
            this.f55354h = (ImageView) findViewById(R.id.person_center_header_guide_close);
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
            this.f55351e = b.a.q0.s.e0.b.j().g("has_shown_person_center_guide", false);
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
            this.f55355i.setVisibility(0);
            if (this.m == null) {
                this.m = ObjectAnimator.ofFloat(this.f55355i, Key.TRANSLATION_X, -this.f55353g.getWidth(), 0.0f);
            }
            if (this.o == null) {
                this.n = ObjectAnimator.ofFloat(this.f55355i, Key.ALPHA, 0.0f, 1.0f);
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
            SkinManager.setImageResource(this.f55352f, R.drawable.person_center_head_guide_circle);
            SkinManager.setImageResource(this.f55354h, R.drawable.icon_topbar_close_white_n);
            SkinManager.setViewTextColor(this.f55353g, R.color.CAM_X0101, 1);
            SkinManager.setBackgroundResource(this.f55355i, R.drawable.person_center_header_guide_tip_bg);
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
        this.f55351e = false;
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
        this.f55351e = false;
        this.p = new a(this);
        this.q = new b(this, 2921423);
        h(context);
    }
}
