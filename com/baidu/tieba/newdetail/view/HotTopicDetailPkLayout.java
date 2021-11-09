package com.baidu.tieba.newdetail.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.e.a.f;
import b.a.e.a.j;
import b.a.e.e.p.l;
import b.a.r0.j1.d;
import b.a.r0.j1.e;
import b.a.r0.j1.h;
import b.a.r0.j1.l.i;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class HotTopicDetailPkLayout extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f51778e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<HotTopicDetailActivity> f51779f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f51780g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f51781h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f51782i;
    public TextView j;
    public TextView k;
    public View l;
    public ViewGroup.LayoutParams m;
    public int n;
    public int o;
    public ValueAnimator p;
    public HotTopicDetailPkProcess q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public i v;
    public ColorStateList w;
    public ColorStateList x;
    public Runnable y;

    /* loaded from: classes9.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailPkLayout f51783e;

        public a(HotTopicDetailPkLayout hotTopicDetailPkLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailPkLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51783e = hotTopicDetailPkLayout;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.f51783e.l.setAlpha(floatValue);
                this.f51783e.m.height = (int) (floatValue * this.f51783e.n);
                this.f51783e.l.setLayoutParams(this.f51783e.m);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f51784e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f51785f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailPkLayout f51786g;

        public b(HotTopicDetailPkLayout hotTopicDetailPkLayout, long j, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailPkLayout, Long.valueOf(j), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51786g = hotTopicDetailPkLayout;
            this.f51784e = j;
            this.f51785f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f51784e == 0) {
                    if (this.f51786g.v.k == 1) {
                        TextView textView = this.f51786g.s;
                        textView.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        this.f51786g.u.setText("");
                    } else if (this.f51786g.v.k == 2) {
                        this.f51786g.s.setText("");
                        TextView textView2 = this.f51786g.u;
                        textView2.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                    } else {
                        this.f51786g.s.setText("");
                        this.f51786g.u.setText("");
                    }
                    this.f51786g.v.k = 0;
                } else {
                    if (this.f51786g.v.k != 0) {
                        if (this.f51786g.v.k == 1) {
                            int i2 = this.f51785f;
                            if (i2 == 1) {
                                TextView textView3 = this.f51786g.s;
                                textView3.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                                this.f51786g.u.setText("");
                            } else if (i2 == 2) {
                                this.f51786g.s.setText("");
                                TextView textView4 = this.f51786g.u;
                                textView4.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            } else {
                                TextView textView5 = this.f51786g.s;
                                textView5.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                                this.f51786g.u.setText("");
                            }
                        } else {
                            int i3 = this.f51785f;
                            if (i3 == 1) {
                                TextView textView6 = this.f51786g.s;
                                textView6.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                                this.f51786g.u.setText("");
                            } else if (i3 == 2) {
                                this.f51786g.s.setText("");
                                TextView textView7 = this.f51786g.u;
                                textView7.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                            } else {
                                this.f51786g.s.setText("");
                                TextView textView8 = this.f51786g.u;
                                textView8.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            }
                        }
                    } else {
                        int i4 = this.f51785f;
                        if (i4 == 1) {
                            TextView textView9 = this.f51786g.s;
                            textView9.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            this.f51786g.u.setText("");
                        } else if (i4 == 2) {
                            this.f51786g.s.setText("");
                            TextView textView10 = this.f51786g.u;
                            textView10.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        } else {
                            this.f51786g.s.setText("");
                            this.f51786g.u.setText("");
                        }
                    }
                    this.f51786g.v.k = this.f51785f;
                }
                this.f51786g.v.m = this.f51784e;
                this.f51786g.s.setVisibility(0);
                this.f51786g.u.setVisibility(0);
                this.f51786g.n(true);
                HotTopicDetailPkLayout hotTopicDetailPkLayout = this.f51786g;
                hotTopicDetailPkLayout.removeCallbacks(hotTopicDetailPkLayout.y);
                HotTopicDetailPkLayout hotTopicDetailPkLayout2 = this.f51786g;
                hotTopicDetailPkLayout2.postDelayed(hotTopicDetailPkLayout2.y, 3000L);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailPkLayout f51787e;

        public c(HotTopicDetailPkLayout hotTopicDetailPkLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailPkLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51787e = hotTopicDetailPkLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f51787e.s == null) {
                return;
            }
            this.f51787e.s.setVisibility(8);
            this.f51787e.u.setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicDetailPkLayout(Context context) {
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
        this.f51778e = 3;
        this.n = l.g(TbadkCoreApplication.getInst(), b.a.r0.j1.c.tbds107);
        this.o = 0;
        this.w = SkinManager.getColorList(b.a.r0.j1.b.CAM_X0308);
        this.x = SkinManager.getColorList(b.a.r0.j1.b.CAM_X0303);
        this.y = new c(this);
        j();
    }

    public void bindData(@NonNull i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
            this.v = iVar;
            n(false);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void changePkView(long j, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            ValueAnimator valueAnimator = this.p;
            postDelayed(new b(this, j2, i2), (valueAnimator == null || !valueAnimator.isRunning() || ((Float) this.p.getAnimatedValue()).floatValue() >= 1.0f) ? 0 : (int) ((1.0f - ((Float) this.p.getAnimatedValue()).floatValue()) * 300.0f));
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig(this.f51779f.getPageActivity(), true, 110435)));
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f<?> a2 = j.a(getContext());
            if (a2 instanceof TbPageContext) {
                this.f51779f = (TbPageContext) a2;
            }
            LayoutInflater.from(getContext()).inflate(b.a.r0.j1.f.hot_topic_detail_pk_layout, (ViewGroup) this, true);
            this.f51780g = (TextView) findViewById(e.tagView);
            this.f51781h = (TextView) findViewById(e.titleView);
            this.f51782i = (TextView) findViewById(e.descView);
            TextView textView = (TextView) findViewById(e.pkBtn1);
            this.j = textView;
            textView.setOnClickListener(this);
            TextView textView2 = (TextView) findViewById(e.pkBtn2);
            this.k = textView2;
            textView2.setOnClickListener(this);
            View findViewById = findViewById(e.progressBottomLayout);
            this.l = findViewById;
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            this.m = layoutParams;
            layoutParams.height = this.o;
            this.l.setLayoutParams(layoutParams);
            this.l.setAlpha(0.0f);
            this.q = (HotTopicDetailPkProcess) findViewById(e.processView);
            this.r = (TextView) findViewById(e.pkText1);
            this.s = (TextView) findViewById(e.pkTextSubmit1);
            this.t = (TextView) findViewById(e.pkText2);
            this.u = (TextView) findViewById(e.pkTextSubmit2);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || i()) {
            return;
        }
        m();
        if (this.l.getVisibility() != 0) {
            p(1);
            return;
        }
        ValueAnimator valueAnimator = this.p;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            q(1);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || i()) {
            return;
        }
        m();
        if (this.l.getVisibility() != 0) {
            p(2);
            return;
        }
        ValueAnimator valueAnimator = this.p;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            q(2);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            TiebaStatic.log(new StatisticItem("c13818").param("uid", TbadkCoreApplication.getCurrentAccount()).param("topic_id", this.f51779f.getOrignalPage().getTopicId()));
        }
    }

    public final void n(boolean z) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            i iVar = this.v;
            long j2 = iVar.k == 1 ? 1 : 0;
            long j3 = iVar.n + iVar.o + j2 + (iVar.k == 2 ? 1 : 0);
            this.f51780g.setText(String.format(getContext().getString(h.hot_topic_pk_head_tag), StringHelper.numberUniformFormatExtra(j3)));
            this.f51782i.setText(iVar.f18456f);
            this.j.setText(iVar.f18457g);
            this.k.setText(iVar.f18459i);
            this.r.setText("" + (iVar.n + j2));
            this.t.setText("" + (iVar.o + j));
            if (j3 > 0) {
                int i2 = iVar.k;
                if (i2 == 1) {
                    if (j3 > 1) {
                        float f2 = (float) j3;
                        float f3 = 1.0f / f2;
                        this.q.setProcess(((((float) iVar.n) * 1.0f) / f2) + (f3 >= 0.02f ? f3 : 0.02f), z);
                    } else {
                        this.q.setProcess(1.0f, z);
                    }
                } else if (i2 != 2) {
                    this.q.setProcess((((float) iVar.n) * 1.0f) / ((float) j3), z);
                } else if (j3 > 1) {
                    float f4 = (float) j3;
                    float f5 = 1.0f / f4;
                    this.q.setProcess(((((float) iVar.n) * 1.0f) / f4) - (f5 >= 0.02f ? f5 : 0.02f), z);
                } else {
                    this.q.setProcess(0.0f, z);
                }
            } else {
                this.q.setProcess(0.5f, z);
            }
            if (this.l.getVisibility() != 0) {
                if (iVar.k != 0) {
                    this.o = this.n;
                    ViewGroup.LayoutParams layoutParams = this.l.getLayoutParams();
                    this.m = layoutParams;
                    layoutParams.height = this.o;
                    this.l.setLayoutParams(layoutParams);
                    this.l.setAlpha(1.0f);
                    this.l.setVisibility(0);
                } else {
                    this.o = 0;
                    ViewGroup.LayoutParams layoutParams2 = this.l.getLayoutParams();
                    this.m = layoutParams2;
                    layoutParams2.height = this.o;
                    this.l.setLayoutParams(layoutParams2);
                    this.l.setAlpha(0.0f);
                }
            }
            o();
        }
    }

    public final void o() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (iVar = this.v) == null) {
            return;
        }
        int i2 = iVar.k;
        if (i2 == 1) {
            this.j.setBackgroundResource(d.bg_pk_btn_select);
            this.k.setBackgroundResource(d.bg_pk_btn_unselect);
            this.j.setTextColor(SkinManager.getColor(b.a.r0.j1.b.CAM_X0101));
            this.k.setTextColor(SkinManager.getColor(b.a.r0.j1.b.CAM_X0302));
        } else if (i2 == 2) {
            this.j.setBackgroundResource(d.bg_pk_btn_unselect);
            this.k.setBackgroundResource(d.bg_pk_btn_select);
            this.j.setTextColor(SkinManager.getColor(b.a.r0.j1.b.CAM_X0308));
            this.k.setTextColor(SkinManager.getColor(b.a.r0.j1.b.CAM_X0101));
        } else {
            this.j.setBackgroundResource(d.bg_pk_btn_unselect);
            this.k.setBackgroundResource(d.bg_pk_btn_unselect);
            this.j.setTextColor(SkinManager.getColor(b.a.r0.j1.b.CAM_X0308));
            this.k.setTextColor(SkinManager.getColor(b.a.r0.j1.b.CAM_X0302));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.j.setBackgroundTintList(this.w);
            this.k.setBackgroundTintList(this.x);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || this.f51778e == i2) {
            return;
        }
        SkinManager.setBackgroundColor(this, b.a.r0.j1.b.CAM_X0201);
        this.w = SkinManager.getColorList(b.a.r0.j1.b.CAM_X0308);
        this.x = SkinManager.getColorList(b.a.r0.j1.b.CAM_X0303);
        o();
        SkinManager.setViewTextColor(this.f51780g, b.a.r0.j1.b.CAM_X0109);
        SkinManager.setViewTextColor(this.f51781h, b.a.r0.j1.b.CAM_X0105);
        SkinManager.setViewTextColor(this.f51782i, b.a.r0.j1.b.CAM_X0105);
        SkinManager.setViewTextColor(this.r, b.a.r0.j1.b.CAM_X0308);
        SkinManager.setViewTextColor(this.s, b.a.r0.j1.b.CAM_X0308);
        SkinManager.setViewTextColor(this.t, b.a.r0.j1.b.CAM_X0303);
        SkinManager.setViewTextColor(this.u, b.a.r0.j1.b.CAM_X0303);
        this.q.onChangeSkinType(i2);
        this.f51778e = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
            int id = view.getId();
            if (id == e.pkBtn1) {
                k();
            } else if (id == e.pkBtn2) {
                l();
            }
        }
    }

    public final void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            ValueAnimator valueAnimator = this.p;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            this.l.setVisibility(0);
            ValueAnimator ofFloat = ValueAnimator.ofFloat((this.o * 1.0f) / this.n, 1.0f);
            this.p = ofFloat;
            int i3 = this.n;
            ofFloat.setDuration((((i3 - this.o) * 300) * 1.0f) / i3);
            this.p.setInterpolator(new AccelerateDecelerateInterpolator());
            this.p.addUpdateListener(new a(this));
            this.p.start();
            q(i2);
        }
    }

    public final void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f51779f.getOrignalPage().sendPkData(this.v, i2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet) {
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
        this.f51778e = 3;
        this.n = l.g(TbadkCoreApplication.getInst(), b.a.r0.j1.c.tbds107);
        this.o = 0;
        this.w = SkinManager.getColorList(b.a.r0.j1.b.CAM_X0308);
        this.x = SkinManager.getColorList(b.a.r0.j1.b.CAM_X0303);
        this.y = new c(this);
        j();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f51778e = 3;
        this.n = l.g(TbadkCoreApplication.getInst(), b.a.r0.j1.c.tbds107);
        this.o = 0;
        this.w = SkinManager.getColorList(b.a.r0.j1.b.CAM_X0308);
        this.x = SkinManager.getColorList(b.a.r0.j1.b.CAM_X0303);
        this.y = new c(this);
        j();
    }
}
