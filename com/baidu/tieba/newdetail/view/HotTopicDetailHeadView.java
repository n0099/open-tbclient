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
import c.a.d.a.j;
import c.a.d.f.p.n;
import c.a.u0.r1.d;
import c.a.u0.r1.e;
import c.a.u0.r1.f;
import c.a.u0.r1.g;
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
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class HotTopicDetailHeadView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f46270e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<HotTopicDetailActivity> f46271f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f46272g;

    /* renamed from: h  reason: collision with root package name */
    public View f46273h;

    /* renamed from: i  reason: collision with root package name */
    public View f46274i;

    /* renamed from: j  reason: collision with root package name */
    public View f46275j;
    public BarImageView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public View r;
    public TBLottieAnimationView s;
    public TextView t;
    public c.a.u0.r1.i.a u;
    public ValueAnimator v;

    /* loaded from: classes13.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailHeadView f46276e;

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
            this.f46276e = hotTopicDetailHeadView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ((HotTopicDetailActivity) this.f46276e.f46271f.getOrignalPage()).jumpToRankList();
            }
        }
    }

    /* loaded from: classes13.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailHeadView f46277e;

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
            this.f46277e = hotTopicDetailHeadView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f46277e.u == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13819").param("obj_type", this.f46277e.u.f21741i).param("topic_id", ((HotTopicDetailActivity) this.f46277e.f46271f.getOrignalPage()).getTopicId()));
            ((HotTopicDetailActivity) this.f46277e.f46271f.getOrignalPage()).sendBlessData(this.f46277e.u);
        }
    }

    /* loaded from: classes13.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f46278e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailHeadView f46279f;

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
            this.f46279f = hotTopicDetailHeadView;
            this.f46278e = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f46279f.t.setTranslationX(this.f46278e * ((Float) valueAnimator.getAnimatedValue()).floatValue());
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
        this.f46270e = 3;
        f();
    }

    public void changeBlessView(long j2, long j3) {
        c.a.u0.r1.i.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) || (aVar = this.u) == null || aVar.f21738f == 1) {
            return;
        }
        this.s.playAnimation();
        g();
        c.a.u0.r1.i.a aVar2 = this.u;
        aVar2.f21738f = 1;
        aVar2.f21740h = j3;
    }

    @StringRes
    public final int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (i2 == 1) {
                return g.hot_topic_bless_tag_watch;
            }
            if (i2 == 2) {
                return g.hot_topic_bless_tag_candle;
            }
            return g.hot_topic_bless_tag_bless;
        }
        return invokeI.intValue;
    }

    public final void e(int i2) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && (tBLottieAnimationView = this.s) != null && tBLottieAnimationView.getVisibility() == 0) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 0 || skinType == 3) {
                if (i2 == 1) {
                    this.s.setImageAssetsFolder("lottie_watch/");
                    SkinManager.setLottieAnimation(this.s, f.lottie_watch);
                } else if (i2 == 2) {
                    this.s.setImageAssetsFolder("lottie_candle/");
                    SkinManager.setLottieAnimation(this.s, f.lottie_candle);
                } else {
                    this.s.setImageAssetsFolder("lottie_bless/");
                    SkinManager.setLottieAnimation(this.s, f.lottie_bless);
                }
            } else if (i2 == 1) {
                this.s.setImageAssetsFolder("lottie_watch_1/");
                SkinManager.setLottieAnimation(this.s, f.lottie_watch_1);
            } else if (i2 == 2) {
                this.s.setImageAssetsFolder("lottie_candle_1/");
                SkinManager.setLottieAnimation(this.s, f.lottie_candle_1);
            } else {
                this.s.setImageAssetsFolder("lottie_bless_1/");
                SkinManager.setLottieAnimation(this.s, f.lottie_bless_1);
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.d.a.f<?> a2 = j.a(getContext());
            if (a2 instanceof TbPageContext) {
                this.f46271f = (TbPageContext) a2;
            }
            LayoutInflater.from(getContext()).inflate(e.hot_topic_detail_head_item, (ViewGroup) this, true);
            this.f46272g = (TbImageView) findViewById(d.bgView);
            this.f46274i = findViewById(d.bgDefaultView);
            this.f46273h = findViewById(d.bg_cover_view);
            this.f46275j = findViewById(d.header_round_corner_layout);
            this.k = (BarImageView) findViewById(d.iconView);
            this.l = (TextView) findViewById(d.titleView);
            this.m = (TextView) findViewById(d.titlePreView);
            this.n = (TextView) findViewById(d.titleNextView);
            this.o = (TextView) findViewById(d.tagView);
            this.p = (TextView) findViewById(d.descView);
            this.q = (TextView) findViewById(d.descView1);
            this.r = findViewById(d.descLayout);
            this.s = (TBLottieAnimationView) findViewById(d.blessLayout);
            TextView textView = (TextView) findViewById(d.blessView);
            this.t = textView;
            textView.setAlpha(0.66f);
            this.f46274i.setBackgroundColor(SkinManager.getColor(c.a.u0.r1.a.CAM_X0302));
            this.k.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.k.setStrokeWith(n.f(TbadkCoreApplication.getInst(), c.a.u0.r1.b.tbds4));
            this.k.setPlaceHolder(1);
            this.o.setAlpha(0.66f);
            this.r.setOnClickListener(new a(this));
            this.s.setOnClickListener(new b(this));
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ValueAnimator valueAnimator = this.v;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            int width = this.t.getWidth();
            if (width > 0) {
                this.t.setTranslationX(width);
                this.t.setVisibility(0);
                ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.v = ofFloat;
                ofFloat.setDuration(200L);
                this.v.setStartDelay(1000L);
                this.v.setInterpolator(new AccelerateDecelerateInterpolator());
                this.v.addUpdateListener(new c(this, width));
                this.v.start();
            }
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || this.f46270e == i2) {
            return;
        }
        c.a.t0.s.v.c d2 = c.a.t0.s.v.c.d(this.f46275j);
        d2.m(1);
        d2.n(g.J_X14);
        d2.f(c.a.u0.r1.a.CAM_X0201);
        this.f46274i.setBackgroundColor(SkinManager.getColor(c.a.u0.r1.a.CAM_X0302));
        SkinManager.setViewTextColor(this.l, c.a.u0.r1.a.CAM_X0101);
        SkinManager.setViewTextColor(this.m, c.a.u0.r1.a.CAM_X0101);
        SkinManager.setViewTextColor(this.n, c.a.u0.r1.a.CAM_X0101);
        SkinManager.setViewTextColor(this.o, c.a.u0.r1.a.CAM_X0101);
        SkinManager.setViewTextColor(this.p, c.a.u0.r1.a.CAM_X0101);
        SkinManager.setViewTextColor(this.q, c.a.u0.r1.a.CAM_X0101);
        SkinManager.setViewTextColor(this.t, c.a.u0.r1.a.CAM_X0101);
        c.a.u0.r1.i.a aVar = this.u;
        if (aVar != null) {
            e(aVar.f21741i);
        }
        this.f46270e = i2;
    }

    public void setBgCoverViewColor(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (view = this.f46273h) == null) {
            return;
        }
        view.setBackgroundColor(i2);
    }

    public void setBlessInfo(c.a.u0.r1.i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.u = aVar;
            if (aVar == null) {
                this.s.setVisibility(8);
                this.t.setVisibility(4);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.l.getLayoutParams();
                layoutParams.rightMargin = n.f(this.l.getContext(), c.a.u0.r1.b.tbds84);
                this.l.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.n.getLayoutParams();
                layoutParams2.leftMargin = -layoutParams.rightMargin;
                this.n.setLayoutParams(layoutParams2);
                return;
            }
            this.t.setText(getContext().getResources().getString(d(aVar.f21741i), StringHelper.numberUniformFormatExtraWithRoundInt(aVar.f21737e)));
            if (aVar.f21738f == 1) {
                this.s.setVisibility(8);
                this.t.setVisibility(0);
                this.t.setTranslationX(0.0f);
            } else {
                this.s.setVisibility(0);
                this.t.setVisibility(4);
                e(aVar.f21741i);
                this.s.cancelAnimation();
            }
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.l.getLayoutParams();
            layoutParams3.rightMargin = n.f(this.l.getContext(), c.a.u0.r1.b.tbds280);
            this.l.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.n.getLayoutParams();
            layoutParams4.leftMargin = -layoutParams3.rightMargin;
            this.n.setLayoutParams(layoutParams4);
        }
    }

    public void setTopicInfo(c.a.u0.r1.i.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) || fVar == null) {
            return;
        }
        this.f46274i.setVisibility(TextUtils.isEmpty(fVar.f21758j) ? 0 : 8);
        this.k.startLoad(fVar.f21757i, 10, false);
        this.f46272g.startLoad(fVar.f21758j, 39, false);
        this.l.setText(fVar.f21754f);
        if (fVar.m > 0) {
            TextView textView = this.p;
            String string = getContext().getString(g.hot_topic_rank_list_head_desc);
            textView.setText(String.format(string, "" + fVar.m));
            this.p.setVisibility(0);
        } else {
            this.p.setVisibility(8);
        }
        this.o.setText(String.format(getContext().getString(g.hot_topic_rank_item_tag), StringHelper.numberUniformFormatExtraWithRoundInt(fVar.f21756h)));
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
        this.f46270e = 3;
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
        this.f46270e = 3;
        f();
    }
}
