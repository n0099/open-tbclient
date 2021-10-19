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
import c.a.e.a.f;
import c.a.e.a.j;
import c.a.e.e.p.l;
import c.a.r0.j1.c.i;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class HotTopicDetailPkLayout extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f54600e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<HotTopicDetailActivity> f54601f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f54602g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f54603h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f54604i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f54605j;
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

    /* loaded from: classes7.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailPkLayout f54606e;

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
            this.f54606e = hotTopicDetailPkLayout;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.f54606e.l.setAlpha(floatValue);
                this.f54606e.m.height = (int) (floatValue * this.f54606e.n);
                this.f54606e.l.setLayoutParams(this.f54606e.m);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f54607e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f54608f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailPkLayout f54609g;

        public b(HotTopicDetailPkLayout hotTopicDetailPkLayout, long j2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailPkLayout, Long.valueOf(j2), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54609g = hotTopicDetailPkLayout;
            this.f54607e = j2;
            this.f54608f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f54607e == 0) {
                    if (this.f54609g.v.k == 1) {
                        TextView textView = this.f54609g.s;
                        textView.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        this.f54609g.u.setText("");
                    } else if (this.f54609g.v.k == 2) {
                        this.f54609g.s.setText("");
                        TextView textView2 = this.f54609g.u;
                        textView2.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                    } else {
                        this.f54609g.s.setText("");
                        this.f54609g.u.setText("");
                    }
                    this.f54609g.v.k = 0;
                } else {
                    if (this.f54609g.v.k != 0) {
                        if (this.f54609g.v.k == 1) {
                            int i2 = this.f54608f;
                            if (i2 == 1) {
                                TextView textView3 = this.f54609g.s;
                                textView3.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                                this.f54609g.u.setText("");
                            } else if (i2 == 2) {
                                this.f54609g.s.setText("");
                                TextView textView4 = this.f54609g.u;
                                textView4.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            } else {
                                TextView textView5 = this.f54609g.s;
                                textView5.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                                this.f54609g.u.setText("");
                            }
                        } else {
                            int i3 = this.f54608f;
                            if (i3 == 1) {
                                TextView textView6 = this.f54609g.s;
                                textView6.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                                this.f54609g.u.setText("");
                            } else if (i3 == 2) {
                                this.f54609g.s.setText("");
                                TextView textView7 = this.f54609g.u;
                                textView7.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                            } else {
                                this.f54609g.s.setText("");
                                TextView textView8 = this.f54609g.u;
                                textView8.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            }
                        }
                    } else {
                        int i4 = this.f54608f;
                        if (i4 == 1) {
                            TextView textView9 = this.f54609g.s;
                            textView9.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            this.f54609g.u.setText("");
                        } else if (i4 == 2) {
                            this.f54609g.s.setText("");
                            TextView textView10 = this.f54609g.u;
                            textView10.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        } else {
                            this.f54609g.s.setText("");
                            this.f54609g.u.setText("");
                        }
                    }
                    this.f54609g.v.k = this.f54608f;
                }
                this.f54609g.v.m = this.f54607e;
                this.f54609g.s.setVisibility(0);
                this.f54609g.u.setVisibility(0);
                this.f54609g.n(true);
                HotTopicDetailPkLayout hotTopicDetailPkLayout = this.f54609g;
                hotTopicDetailPkLayout.removeCallbacks(hotTopicDetailPkLayout.y);
                HotTopicDetailPkLayout hotTopicDetailPkLayout2 = this.f54609g;
                hotTopicDetailPkLayout2.postDelayed(hotTopicDetailPkLayout2.y, 3000L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailPkLayout f54610e;

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
            this.f54610e = hotTopicDetailPkLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f54610e.s == null) {
                return;
            }
            this.f54610e.s.setVisibility(8);
            this.f54610e.u.setVisibility(8);
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
        this.f54600e = 3;
        this.n = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.o = 0;
        this.w = SkinManager.getColorList(R.color.CAM_X0308);
        this.x = SkinManager.getColorList(R.color.CAM_X0303);
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

    public void changePkView(long j2, long j3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2)}) == null) {
            ValueAnimator valueAnimator = this.p;
            postDelayed(new b(this, j3, i2), (valueAnimator == null || !valueAnimator.isRunning() || ((Float) this.p.getAnimatedValue()).floatValue() >= 1.0f) ? 0 : (int) ((1.0f - ((Float) this.p.getAnimatedValue()).floatValue()) * 300.0f));
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig(this.f54601f.getPageActivity(), true, 110435)));
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
                this.f54601f = (TbPageContext) a2;
            }
            LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_pk_layout, (ViewGroup) this, true);
            this.f54602g = (TextView) findViewById(R.id.tagView);
            this.f54603h = (TextView) findViewById(R.id.titleView);
            this.f54604i = (TextView) findViewById(R.id.descView);
            TextView textView = (TextView) findViewById(R.id.pkBtn1);
            this.f54605j = textView;
            textView.setOnClickListener(this);
            TextView textView2 = (TextView) findViewById(R.id.pkBtn2);
            this.k = textView2;
            textView2.setOnClickListener(this);
            View findViewById = findViewById(R.id.progressBottomLayout);
            this.l = findViewById;
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            this.m = layoutParams;
            layoutParams.height = this.o;
            this.l.setLayoutParams(layoutParams);
            this.l.setAlpha(0.0f);
            this.q = (HotTopicDetailPkProcess) findViewById(R.id.processView);
            this.r = (TextView) findViewById(R.id.pkText1);
            this.s = (TextView) findViewById(R.id.pkTextSubmit1);
            this.t = (TextView) findViewById(R.id.pkText2);
            this.u = (TextView) findViewById(R.id.pkTextSubmit2);
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
            TiebaStatic.log(new StatisticItem("c13818").param("uid", TbadkCoreApplication.getCurrentAccount()).param("topic_id", this.f54601f.getOrignalPage().getTopicId()));
        }
    }

    public final void n(boolean z) {
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            i iVar = this.v;
            long j3 = iVar.k == 1 ? 1 : 0;
            long j4 = iVar.n + iVar.o + j3 + (iVar.k == 2 ? 1 : 0);
            this.f54602g.setText(String.format(getContext().getString(R.string.hot_topic_pk_head_tag), StringHelper.numberUniformFormatExtra(j4)));
            this.f54604i.setText(iVar.f19475f);
            this.f54605j.setText(iVar.f19476g);
            this.k.setText(iVar.f19478i);
            this.r.setText("" + (iVar.n + j3));
            this.t.setText("" + (iVar.o + j2));
            if (j4 > 0) {
                int i2 = iVar.k;
                if (i2 == 1) {
                    if (j4 > 1) {
                        float f2 = (float) j4;
                        float f3 = 1.0f / f2;
                        this.q.setProcess(((((float) iVar.n) * 1.0f) / f2) + (f3 >= 0.02f ? f3 : 0.02f), z);
                    } else {
                        this.q.setProcess(1.0f, z);
                    }
                } else if (i2 != 2) {
                    this.q.setProcess((((float) iVar.n) * 1.0f) / ((float) j4), z);
                } else if (j4 > 1) {
                    float f4 = (float) j4;
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
            this.f54605j.setBackgroundResource(R.drawable.bg_pk_btn_select);
            this.k.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
            this.f54605j.setTextColor(SkinManager.getColor(R.color.CAM_X0101));
            this.k.setTextColor(SkinManager.getColor(R.color.CAM_X0302));
        } else if (i2 == 2) {
            this.f54605j.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
            this.k.setBackgroundResource(R.drawable.bg_pk_btn_select);
            this.f54605j.setTextColor(SkinManager.getColor(R.color.CAM_X0308));
            this.k.setTextColor(SkinManager.getColor(R.color.CAM_X0101));
        } else {
            this.f54605j.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
            this.k.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
            this.f54605j.setTextColor(SkinManager.getColor(R.color.CAM_X0308));
            this.k.setTextColor(SkinManager.getColor(R.color.CAM_X0302));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.f54605j.setBackgroundTintList(this.w);
            this.k.setBackgroundTintList(this.x);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || this.f54600e == i2) {
            return;
        }
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
        this.w = SkinManager.getColorList(R.color.CAM_X0308);
        this.x = SkinManager.getColorList(R.color.CAM_X0303);
        o();
        SkinManager.setViewTextColor(this.f54602g, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f54603h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f54604i, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.r, R.color.CAM_X0308);
        SkinManager.setViewTextColor(this.s, R.color.CAM_X0308);
        SkinManager.setViewTextColor(this.t, R.color.CAM_X0303);
        SkinManager.setViewTextColor(this.u, R.color.CAM_X0303);
        this.q.onChangeSkinType(i2);
        this.f54600e = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
            int id = view.getId();
            if (id == R.id.pkBtn1) {
                k();
            } else if (id == R.id.pkBtn2) {
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
            this.f54601f.getOrignalPage().sendPkData(this.v, i2);
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
        this.f54600e = 3;
        this.n = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.o = 0;
        this.w = SkinManager.getColorList(R.color.CAM_X0308);
        this.x = SkinManager.getColorList(R.color.CAM_X0303);
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
        this.f54600e = 3;
        this.n = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.o = 0;
        this.w = SkinManager.getColorList(R.color.CAM_X0308);
        this.x = SkinManager.getColorList(R.color.CAM_X0303);
        this.y = new c(this);
        j();
    }
}
