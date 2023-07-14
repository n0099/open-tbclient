package com.baidu.tieba.newdetail.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.bb8;
import com.baidu.tieba.d85;
import com.baidu.tieba.l9;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import com.baidu.tieba.r9;
import com.baidu.tieba.wa8;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class HotTopicDetailHeadView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbPageContext<HotTopicDetailActivity> b;
    public TbImageView c;
    public View d;
    public View e;
    public View f;
    public BarImageView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public View n;
    public TBLottieAnimationView o;
    public TextView p;
    public wa8 q;
    public ValueAnimator r;

    @StringRes
    public final int e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? i == 1 ? R.string.obfuscated_res_0x7f0f09fc : i == 2 ? R.string.obfuscated_res_0x7f0f09fb : R.string.obfuscated_res_0x7f0f09fa : invokeI.intValue;
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicDetailHeadView a;

        public a(HotTopicDetailHeadView hotTopicDetailHeadView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailHeadView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicDetailHeadView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ((HotTopicDetailActivity) this.a.b.getOrignalPage()).z1();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicDetailHeadView a;

        public b(HotTopicDetailHeadView hotTopicDetailHeadView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailHeadView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicDetailHeadView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.q == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13819").param("obj_type", this.a.q.e).param("topic_id", ((HotTopicDetailActivity) this.a.b.getOrignalPage()).w1()));
            ((HotTopicDetailActivity) this.a.b.getOrignalPage()).F1(this.a.q);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ HotTopicDetailHeadView b;

        public c(HotTopicDetailHeadView hotTopicDetailHeadView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailHeadView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hotTopicDetailHeadView;
            this.a = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.b.p.setTranslationX(this.a * ((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicDetailHeadView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 3;
        g();
    }

    public void d(long j, long j2) {
        wa8 wa8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) && (wa8Var = this.q) != null && wa8Var.b != 1) {
            this.o.playAnimation();
            i();
            wa8 wa8Var2 = this.q;
            wa8Var2.b = 1;
            wa8Var2.d = j2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 3;
        g();
    }

    public void setBgCoverViewColor(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048582, this, i) == null) && (view2 = this.d) != null) {
            view2.setBackgroundColor(i);
        }
    }

    public final void f(int i) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (tBLottieAnimationView = this.o) != null && tBLottieAnimationView.getVisibility() == 0) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != 0 && skinType != 3) {
                if (i == 1) {
                    this.o.setImageAssetsFolder("lottie_watch_2/");
                    SkinManager.setLottieAnimation(this.o, R.raw.obfuscated_res_0x7f11006b);
                } else if (i == 2) {
                    this.o.setImageAssetsFolder("lottie_candle_2/");
                    SkinManager.setLottieAnimation(this.o, R.raw.obfuscated_res_0x7f110028);
                } else {
                    this.o.setImageAssetsFolder("lottie_bless_2/");
                    SkinManager.setLottieAnimation(this.o, R.raw.obfuscated_res_0x7f110025);
                }
            } else if (i == 1) {
                this.o.setImageAssetsFolder("lottie_watch/");
                SkinManager.setLottieAnimation(this.o, R.raw.obfuscated_res_0x7f11006a);
            } else if (i == 2) {
                this.o.setImageAssetsFolder("lottie_candle/");
                SkinManager.setLottieAnimation(this.o, R.raw.obfuscated_res_0x7f110027);
            } else {
                this.o.setImageAssetsFolder("lottie_bless/");
                SkinManager.setLottieAnimation(this.o, R.raw.obfuscated_res_0x7f110024);
            }
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && this.a != i) {
            d85 d = d85.d(this.f);
            d.n(1);
            d.o(R.string.J_X14);
            d.f(R.color.CAM_X0201);
            this.e.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0302));
            SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0101);
            wa8 wa8Var = this.q;
            if (wa8Var != null) {
                f(wa8Var.e);
            }
            this.a = i;
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            l9<?> a2 = r9.a(getContext());
            if (a2 instanceof TbPageContext) {
                this.b = (TbPageContext) a2;
            }
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0408, (ViewGroup) this, true);
            this.c = (TbImageView) findViewById(R.id.obfuscated_res_0x7f0903d3);
            this.e = findViewById(R.id.obfuscated_res_0x7f0903d2);
            this.d = findViewById(R.id.obfuscated_res_0x7f0903d6);
            this.f = findViewById(R.id.obfuscated_res_0x7f090f0b);
            this.g = (BarImageView) findViewById(R.id.obfuscated_res_0x7f090fe0);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f092548);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f092546);
            this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f092545);
            this.k = (TextView) findViewById(R.id.obfuscated_res_0x7f092351);
            this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f090875);
            this.m = (TextView) findViewById(R.id.obfuscated_res_0x7f090876);
            this.n = findViewById(R.id.obfuscated_res_0x7f090874);
            this.o = (TBLottieAnimationView) findViewById(R.id.obfuscated_res_0x7f090409);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f09040a);
            this.p = textView;
            textView.setAlpha(0.66f);
            this.e.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0302));
            this.g.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.g.setStrokeWith(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.g.setPlaceHolder(1);
            this.k.setAlpha(0.66f);
            this.n.setOnClickListener(new a(this));
            this.o.setOnClickListener(new b(this));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ValueAnimator valueAnimator = this.r;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            int width = this.p.getWidth();
            if (width > 0) {
                this.p.setTranslationX(width);
                this.p.setVisibility(0);
                ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.r = ofFloat;
                ofFloat.setDuration(200L);
                this.r.setStartDelay(1000L);
                this.r.setInterpolator(new AccelerateDecelerateInterpolator());
                this.r.addUpdateListener(new c(this, width));
                this.r.start();
            }
        }
    }

    public void setBlessInfo(wa8 wa8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, wa8Var) == null) {
            this.q = wa8Var;
            if (wa8Var == null) {
                this.o.setVisibility(8);
                this.p.setVisibility(4);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.h.getLayoutParams();
                layoutParams.rightMargin = yi.g(this.h.getContext(), R.dimen.tbds84);
                this.h.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
                layoutParams2.leftMargin = -layoutParams.rightMargin;
                this.j.setLayoutParams(layoutParams2);
                return;
            }
            this.p.setText(getContext().getResources().getString(e(wa8Var.e), StringHelper.numberUniformFormatExtraWithRoundInt(wa8Var.a)));
            if (wa8Var.b == 1) {
                this.o.setVisibility(8);
                this.p.setVisibility(0);
                this.p.setTranslationX(0.0f);
            } else {
                this.o.setVisibility(0);
                this.p.setVisibility(4);
                f(wa8Var.e);
                this.o.cancelAnimation();
            }
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.h.getLayoutParams();
            layoutParams3.rightMargin = yi.g(this.h.getContext(), R.dimen.tbds280);
            this.h.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
            layoutParams4.leftMargin = -layoutParams3.rightMargin;
            this.j.setLayoutParams(layoutParams4);
        }
    }

    public void setTopicInfo(bb8 bb8Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bb8Var) != null) || bb8Var == null) {
            return;
        }
        View view2 = this.e;
        if (TextUtils.isEmpty(bb8Var.f)) {
            i = 0;
        } else {
            i = 8;
        }
        view2.setVisibility(i);
        this.g.N(bb8Var.e, 10, false);
        this.c.N(bb8Var.f, 39, false);
        this.h.setText(bb8Var.b);
        if (bb8Var.i > 0) {
            TextView textView = this.l;
            String string = getContext().getString(R.string.obfuscated_res_0x7f0f0a14);
            textView.setText(String.format(string, "" + bb8Var.i));
            this.l.setVisibility(0);
        } else {
            this.l.setVisibility(8);
        }
        this.k.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f0a12), StringHelper.numberUniformFormatExtraWithRoundInt(bb8Var.d)));
    }
}
