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
import c.a.d.a.f;
import c.a.d.a.j;
import c.a.d.f.p.n;
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
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class HotTopicDetailHeadView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<HotTopicDetailActivity> f34623b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f34624c;

    /* renamed from: d  reason: collision with root package name */
    public View f34625d;

    /* renamed from: e  reason: collision with root package name */
    public View f34626e;

    /* renamed from: f  reason: collision with root package name */
    public View f34627f;

    /* renamed from: g  reason: collision with root package name */
    public BarImageView f34628g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f34629h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public View n;
    public TBLottieAnimationView o;
    public TextView p;
    public c.a.p0.s1.b.a q;
    public ValueAnimator r;

    /* loaded from: classes5.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ((HotTopicDetailActivity) this.a.f34623b.getOrignalPage()).jumpToRankList();
            }
        }
    }

    /* loaded from: classes5.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.q == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13819").param("obj_type", this.a.q.f18144e).param("topic_id", ((HotTopicDetailActivity) this.a.f34623b.getOrignalPage()).getTopicId()));
            ((HotTopicDetailActivity) this.a.f34623b.getOrignalPage()).sendBlessData(this.a.q);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailHeadView f34630b;

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
            this.f34630b = hotTopicDetailHeadView;
            this.a = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f34630b.p.setTranslationX(this.a * ((Float) valueAnimator.getAnimatedValue()).floatValue());
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

    public void d(long j, long j2) {
        c.a.p0.s1.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || (aVar = this.q) == null || aVar.f18141b == 1) {
            return;
        }
        this.o.playAnimation();
        i();
        c.a.p0.s1.b.a aVar2 = this.q;
        aVar2.f18141b = 1;
        aVar2.f18143d = j2;
    }

    @StringRes
    public final int e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? i == 1 ? R.string.obfuscated_res_0x7f0f0862 : i == 2 ? R.string.obfuscated_res_0x7f0f0861 : R.string.obfuscated_res_0x7f0f0860 : invokeI.intValue;
    }

    public final void f(int i) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (tBLottieAnimationView = this.o) != null && tBLottieAnimationView.getVisibility() == 0) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 0 || skinType == 3) {
                if (i == 1) {
                    this.o.setImageAssetsFolder("lottie_watch/");
                    SkinManager.setLottieAnimation(this.o, R.raw.obfuscated_res_0x7f110048);
                } else if (i == 2) {
                    this.o.setImageAssetsFolder("lottie_candle/");
                    SkinManager.setLottieAnimation(this.o, R.raw.obfuscated_res_0x7f110020);
                } else {
                    this.o.setImageAssetsFolder("lottie_bless/");
                    SkinManager.setLottieAnimation(this.o, R.raw.obfuscated_res_0x7f11001e);
                }
            } else if (i == 1) {
                this.o.setImageAssetsFolder("lottie_watch_1/");
                SkinManager.setLottieAnimation(this.o, R.raw.obfuscated_res_0x7f110049);
            } else if (i == 2) {
                this.o.setImageAssetsFolder("lottie_candle_1/");
                SkinManager.setLottieAnimation(this.o, R.raw.obfuscated_res_0x7f110021);
            } else {
                this.o.setImageAssetsFolder("lottie_bless_1/");
                SkinManager.setLottieAnimation(this.o, R.raw.obfuscated_res_0x7f11001f);
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f<?> a2 = j.a(getContext());
            if (a2 instanceof TbPageContext) {
                this.f34623b = (TbPageContext) a2;
            }
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d03b2, (ViewGroup) this, true);
            this.f34624c = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090359);
            this.f34626e = findViewById(R.id.obfuscated_res_0x7f090357);
            this.f34625d = findViewById(R.id.obfuscated_res_0x7f09035c);
            this.f34627f = findViewById(R.id.obfuscated_res_0x7f090d3f);
            this.f34628g = (BarImageView) findViewById(R.id.obfuscated_res_0x7f090e09);
            this.f34629h = (TextView) findViewById(R.id.obfuscated_res_0x7f092032);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f092030);
            this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f09202e);
            this.k = (TextView) findViewById(R.id.obfuscated_res_0x7f091e60);
            this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f09077a);
            this.m = (TextView) findViewById(R.id.obfuscated_res_0x7f09077b);
            this.n = findViewById(R.id.obfuscated_res_0x7f090779);
            this.o = (TBLottieAnimationView) findViewById(R.id.obfuscated_res_0x7f090389);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f09038a);
            this.p = textView;
            textView.setAlpha(0.66f);
            this.f34626e.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0302));
            this.f34628g.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f34628g.setStrokeWith(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.f34628g.setPlaceHolder(1);
            this.k.setAlpha(0.66f);
            this.n.setOnClickListener(new a(this));
            this.o.setOnClickListener(new b(this));
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || this.a == i) {
            return;
        }
        c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.f34627f);
        d2.m(1);
        d2.n(R.string.J_X14);
        d2.f(R.color.CAM_X0201);
        this.f34626e.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0302));
        SkinManager.setViewTextColor(this.f34629h, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0101);
        c.a.p0.s1.b.a aVar = this.q;
        if (aVar != null) {
            f(aVar.f18144e);
        }
        this.a = i;
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

    public void setBgCoverViewColor(int i) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i) == null) || (view = this.f34625d) == null) {
            return;
        }
        view.setBackgroundColor(i);
    }

    public void setBlessInfo(c.a.p0.s1.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.q = aVar;
            if (aVar == null) {
                this.o.setVisibility(8);
                this.p.setVisibility(4);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f34629h.getLayoutParams();
                layoutParams.rightMargin = n.f(this.f34629h.getContext(), R.dimen.tbds84);
                this.f34629h.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
                layoutParams2.leftMargin = -layoutParams.rightMargin;
                this.j.setLayoutParams(layoutParams2);
                return;
            }
            this.p.setText(getContext().getResources().getString(e(aVar.f18144e), StringHelper.numberUniformFormatExtraWithRoundInt(aVar.a)));
            if (aVar.f18141b == 1) {
                this.o.setVisibility(8);
                this.p.setVisibility(0);
                this.p.setTranslationX(0.0f);
            } else {
                this.o.setVisibility(0);
                this.p.setVisibility(4);
                f(aVar.f18144e);
                this.o.cancelAnimation();
            }
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f34629h.getLayoutParams();
            layoutParams3.rightMargin = n.f(this.f34629h.getContext(), R.dimen.tbds280);
            this.f34629h.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
            layoutParams4.leftMargin = -layoutParams3.rightMargin;
            this.j.setLayoutParams(layoutParams4);
        }
    }

    public void setTopicInfo(c.a.p0.s1.b.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) || fVar == null) {
            return;
        }
        this.f34626e.setVisibility(TextUtils.isEmpty(fVar.f18161f) ? 0 : 8);
        this.f34628g.J(fVar.f18160e, 10, false);
        this.f34624c.J(fVar.f18161f, 39, false);
        this.f34629h.setText(fVar.f18157b);
        if (fVar.i > 0) {
            TextView textView = this.l;
            String string = getContext().getString(R.string.obfuscated_res_0x7f0f0879);
            textView.setText(String.format(string, "" + fVar.i));
            this.l.setVisibility(0);
        } else {
            this.l.setVisibility(8);
        }
        this.k.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f0877), StringHelper.numberUniformFormatExtraWithRoundInt(fVar.f18159d)));
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
}
