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
import c.a.e.a.f;
import c.a.e.a.j;
import c.a.e.e.p.l;
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
/* loaded from: classes7.dex */
public class HotTopicDetailHeadView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f54590e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<HotTopicDetailActivity> f54591f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f54592g;

    /* renamed from: h  reason: collision with root package name */
    public View f54593h;

    /* renamed from: i  reason: collision with root package name */
    public View f54594i;

    /* renamed from: j  reason: collision with root package name */
    public BarImageView f54595j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public View q;
    public TBLottieAnimationView r;
    public TextView s;
    public c.a.r0.j1.c.a t;
    public ValueAnimator u;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailHeadView f54596e;

        public a(HotTopicDetailHeadView hotTopicDetailHeadView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailHeadView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54596e = hotTopicDetailHeadView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ((HotTopicDetailActivity) this.f54596e.f54591f.getOrignalPage()).jumpToRankList();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailHeadView f54597e;

        public b(HotTopicDetailHeadView hotTopicDetailHeadView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailHeadView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54597e = hotTopicDetailHeadView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f54597e.t == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13819").param("obj_type", this.f54597e.t.f19442i).param("topic_id", ((HotTopicDetailActivity) this.f54597e.f54591f.getOrignalPage()).getTopicId()));
            ((HotTopicDetailActivity) this.f54597e.f54591f.getOrignalPage()).sendBlessData(this.f54597e.t);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f54598e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailHeadView f54599f;

        public c(HotTopicDetailHeadView hotTopicDetailHeadView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailHeadView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54599f = hotTopicDetailHeadView;
            this.f54598e = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f54599f.s.setTranslationX(this.f54598e * ((Float) valueAnimator.getAnimatedValue()).floatValue());
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f54590e = 3;
        f();
    }

    public void changeBlessView(long j2, long j3) {
        c.a.r0.j1.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) || (aVar = this.t) == null || aVar.f19439f == 1) {
            return;
        }
        this.r.playAnimation();
        g();
        c.a.r0.j1.c.a aVar2 = this.t;
        aVar2.f19439f = 1;
        aVar2.f19441h = j3;
    }

    @StringRes
    public final int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (i2 == 1) {
                return R.string.hot_topic_bless_tag_watch;
            }
            if (i2 == 2) {
                return R.string.hot_topic_bless_tag_candle;
            }
            return R.string.hot_topic_bless_tag_bless;
        }
        return invokeI.intValue;
    }

    public final void e(int i2) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && (tBLottieAnimationView = this.r) != null && tBLottieAnimationView.getVisibility() == 0) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 0 || skinType == 3) {
                if (i2 == 1) {
                    this.r.setImageAssetsFolder("lottie_watch/");
                    SkinManager.setLottieAnimation(this.r, R.raw.lottie_watch);
                } else if (i2 == 2) {
                    this.r.setImageAssetsFolder("lottie_candle/");
                    SkinManager.setLottieAnimation(this.r, R.raw.lottie_candle);
                } else {
                    this.r.setImageAssetsFolder("lottie_bless/");
                    SkinManager.setLottieAnimation(this.r, R.raw.lottie_bless);
                }
            } else if (i2 == 1) {
                this.r.setImageAssetsFolder("lottie_watch_1/");
                SkinManager.setLottieAnimation(this.r, R.raw.lottie_watch_1);
            } else if (i2 == 2) {
                this.r.setImageAssetsFolder("lottie_candle_1/");
                SkinManager.setLottieAnimation(this.r, R.raw.lottie_candle_1);
            } else {
                this.r.setImageAssetsFolder("lottie_bless_1/");
                SkinManager.setLottieAnimation(this.r, R.raw.lottie_bless_1);
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f<?> a2 = j.a(getContext());
            if (a2 instanceof TbPageContext) {
                this.f54591f = (TbPageContext) a2;
            }
            LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_head_item, (ViewGroup) this, true);
            this.f54592g = (TbImageView) findViewById(R.id.bgView);
            this.f54593h = findViewById(R.id.bgDefaultView);
            this.f54594i = findViewById(R.id.header_round_corner_layout);
            this.f54595j = (BarImageView) findViewById(R.id.iconView);
            this.k = (TextView) findViewById(R.id.titleView);
            this.l = (TextView) findViewById(R.id.titlePreView);
            this.m = (TextView) findViewById(R.id.titleNextView);
            this.n = (TextView) findViewById(R.id.tagView);
            this.o = (TextView) findViewById(R.id.descView);
            this.p = (TextView) findViewById(R.id.descView1);
            this.q = findViewById(R.id.descLayout);
            this.r = (TBLottieAnimationView) findViewById(R.id.blessLayout);
            TextView textView = (TextView) findViewById(R.id.blessView);
            this.s = textView;
            textView.setAlpha(0.66f);
            this.f54593h.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0302));
            this.f54595j.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f54595j.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.f54595j.setPlaceHolder(1);
            this.n.setAlpha(0.66f);
            this.q.setOnClickListener(new a(this));
            this.r.setOnClickListener(new b(this));
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ValueAnimator valueAnimator = this.u;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            int width = this.s.getWidth();
            if (width > 0) {
                this.s.setTranslationX(width);
                this.s.setVisibility(0);
                ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.u = ofFloat;
                ofFloat.setDuration(200L);
                this.u.setStartDelay(1000L);
                this.u.setInterpolator(new AccelerateDecelerateInterpolator());
                this.u.addUpdateListener(new c(this, width));
                this.u.start();
            }
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || this.f54590e == i2) {
            return;
        }
        c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.f54594i);
        d2.m(1);
        d2.n(R.string.J_X14);
        d2.f(R.color.CAM_X0201);
        this.f54593h.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0302));
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.s, R.color.CAM_X0101);
        c.a.r0.j1.c.a aVar = this.t;
        if (aVar != null) {
            e(aVar.f19442i);
        }
        this.f54590e = i2;
    }

    public void setBlessInfo(c.a.r0.j1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.t = aVar;
            if (aVar == null) {
                this.r.setVisibility(8);
                this.s.setVisibility(4);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
                layoutParams.rightMargin = l.g(this.k.getContext(), R.dimen.tbds84);
                this.k.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
                layoutParams2.leftMargin = -layoutParams.rightMargin;
                this.m.setLayoutParams(layoutParams2);
                return;
            }
            this.s.setText(getContext().getResources().getString(d(aVar.f19442i), StringHelper.numberUniformFormatExtraWithRoundInt(aVar.f19438e)));
            if (aVar.f19439f == 1) {
                this.r.setVisibility(8);
                this.s.setVisibility(0);
                this.s.setTranslationX(0.0f);
            } else {
                this.r.setVisibility(0);
                this.s.setVisibility(4);
                e(aVar.f19442i);
                this.r.cancelAnimation();
            }
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams3.rightMargin = l.g(this.k.getContext(), R.dimen.tbds280);
            this.k.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            layoutParams4.leftMargin = -layoutParams3.rightMargin;
            this.m.setLayoutParams(layoutParams4);
        }
    }

    public void setTopicInfo(c.a.r0.j1.c.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) || fVar == null) {
            return;
        }
        this.f54593h.setVisibility(TextUtils.isEmpty(fVar.f19469i) ? 0 : 8);
        this.f54595j.startLoad(fVar.f19469i, 10, false);
        this.f54592g.startLoad(fVar.f19469i, 39, false);
        this.k.setText(fVar.f19466f);
        if (fVar.l > 0) {
            TextView textView = this.o;
            String string = getContext().getString(R.string.hot_topic_rank_list_head_desc);
            textView.setText(String.format(string, "" + fVar.l));
            this.o.setVisibility(0);
        } else {
            this.o.setVisibility(8);
        }
        this.n.setText(String.format(getContext().getString(R.string.hot_topic_rank_item_tag), StringHelper.numberUniformFormatExtraWithRoundInt(fVar.f19468h)));
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
        this.f54590e = 3;
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f54590e = 3;
        f();
    }
}
