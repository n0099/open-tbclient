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
import com.baidu.tieba.da;
import com.baidu.tieba.ej;
import com.baidu.tieba.mi7;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import com.baidu.tieba.x9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class HotTopicDetailPkLayout extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbPageContext<HotTopicDetailActivity> b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public View h;
    public ViewGroup.LayoutParams i;
    public int j;
    public int k;
    public ValueAnimator l;
    public HotTopicDetailPkProcess m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public mi7 r;
    public ColorStateList s;
    public ColorStateList t;
    public Runnable u;

    /* loaded from: classes5.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicDetailPkLayout a;

        public a(HotTopicDetailPkLayout hotTopicDetailPkLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailPkLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicDetailPkLayout;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.a.h.setAlpha(floatValue);
                this.a.i.height = (int) (floatValue * this.a.j);
                this.a.h.setLayoutParams(this.a.i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ int b;
        public final /* synthetic */ HotTopicDetailPkLayout c;

        public b(HotTopicDetailPkLayout hotTopicDetailPkLayout, long j, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailPkLayout, Long.valueOf(j), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = hotTopicDetailPkLayout;
            this.a = j;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a == 0) {
                    if (this.c.r.f != 1) {
                        if (this.c.r.f == 2) {
                            this.c.o.setText("");
                            TextView textView = this.c.q;
                            textView.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        } else {
                            this.c.o.setText("");
                            this.c.q.setText("");
                        }
                    } else {
                        TextView textView2 = this.c.o;
                        textView2.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        this.c.q.setText("");
                    }
                    this.c.r.f = 0;
                } else {
                    if (this.c.r.f == 0) {
                        int i = this.b;
                        if (i != 1) {
                            if (i == 2) {
                                this.c.o.setText("");
                                TextView textView3 = this.c.q;
                                textView3.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            } else {
                                this.c.o.setText("");
                                this.c.q.setText("");
                            }
                        } else {
                            TextView textView4 = this.c.o;
                            textView4.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            this.c.q.setText("");
                        }
                    } else if (this.c.r.f == 1) {
                        int i2 = this.b;
                        if (i2 != 1) {
                            if (i2 == 2) {
                                this.c.o.setText("");
                                TextView textView5 = this.c.q;
                                textView5.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            } else {
                                TextView textView6 = this.c.o;
                                textView6.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                                this.c.q.setText("");
                            }
                        } else {
                            TextView textView7 = this.c.o;
                            textView7.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                            this.c.q.setText("");
                        }
                    } else {
                        int i3 = this.b;
                        if (i3 != 1) {
                            if (i3 == 2) {
                                this.c.o.setText("");
                                TextView textView8 = this.c.q;
                                textView8.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                            } else {
                                this.c.o.setText("");
                                TextView textView9 = this.c.q;
                                textView9.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            }
                        } else {
                            TextView textView10 = this.c.o;
                            textView10.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            this.c.q.setText("");
                        }
                    }
                    this.c.r.f = this.b;
                }
                this.c.r.h = this.a;
                this.c.o.setVisibility(0);
                this.c.q.setVisibility(0);
                this.c.q(true);
                HotTopicDetailPkLayout hotTopicDetailPkLayout = this.c;
                hotTopicDetailPkLayout.removeCallbacks(hotTopicDetailPkLayout.u);
                HotTopicDetailPkLayout hotTopicDetailPkLayout2 = this.c;
                hotTopicDetailPkLayout2.postDelayed(hotTopicDetailPkLayout2.u, 3000L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicDetailPkLayout a;

        public c(HotTopicDetailPkLayout hotTopicDetailPkLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailPkLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicDetailPkLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.o != null) {
                this.a.o.setVisibility(8);
                this.a.q.setVisibility(8);
            }
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
        this.j = ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.k = 0;
        this.s = SkinManager.getColorList(R.color.CAM_X0308);
        this.t = SkinManager.getColorList(R.color.CAM_X0303);
        this.u = new c(this);
        l();
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && this.a != i) {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            this.s = SkinManager.getColorList(R.color.CAM_X0308);
            this.t = SkinManager.getColorList(R.color.CAM_X0303);
            r();
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0308);
            SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0308);
            SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0303);
            SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0303);
            this.m.g(i);
            this.a = i;
        }
    }

    public final void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            ValueAnimator valueAnimator = this.l;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            this.h.setVisibility(0);
            ValueAnimator ofFloat = ValueAnimator.ofFloat((this.k * 1.0f) / this.j, 1.0f);
            this.l = ofFloat;
            int i2 = this.j;
            ofFloat.setDuration((((i2 - this.k) * 300) * 1.0f) / i2);
            this.l.setInterpolator(new AccelerateDecelerateInterpolator());
            this.l.addUpdateListener(new a(this));
            this.l.start();
            t(i);
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
        this.j = ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.k = 0;
        this.s = SkinManager.getColorList(R.color.CAM_X0308);
        this.t = SkinManager.getColorList(R.color.CAM_X0303);
        this.u = new c(this);
        l();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.j = ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.k = 0;
        this.s = SkinManager.getColorList(R.color.CAM_X0308);
        this.t = SkinManager.getColorList(R.color.CAM_X0303);
        this.u = new c(this);
        l();
    }

    public void j(long j, long j2, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)}) == null) {
            ValueAnimator valueAnimator = this.l;
            if (valueAnimator != null && valueAnimator.isRunning() && ((Float) this.l.getAnimatedValue()).floatValue() < 1.0f) {
                i2 = (int) ((1.0f - ((Float) this.l.getAnimatedValue()).floatValue()) * 300.0f);
            } else {
                i2 = 0;
            }
            postDelayed(new b(this, j2, i), i2);
        }
    }

    public void i(@NonNull mi7 mi7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mi7Var) == null) {
            this.r = mi7Var;
            q(false);
            m(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f091af3) {
                n();
            } else if (id == R.id.obfuscated_res_0x7f091af4) {
                o();
            }
        }
    }

    public final void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.b.getOrignalPage().I1(this.r, i);
        }
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig(this.b.getPageActivity(), true, 110435)));
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || k()) {
            return;
        }
        p();
        if (this.h.getVisibility() != 0) {
            s(1);
            return;
        }
        ValueAnimator valueAnimator = this.l;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            t(1);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || k()) {
            return;
        }
        p();
        if (this.h.getVisibility() != 0) {
            s(2);
            return;
        }
        ValueAnimator valueAnimator = this.l;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            t(2);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TiebaStatic.log(new StatisticItem("c13818").param("uid", TbadkCoreApplication.getCurrentAccount()).param("topic_id", this.b.getOrignalPage().y1()));
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            x9<?> a2 = da.a(getContext());
            if (a2 instanceof TbPageContext) {
                this.b = (TbPageContext) a2;
            }
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d03b9, (ViewGroup) this, true);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f09217d);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f092361);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f0907eb);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091af3);
            this.f = textView;
            textView.setOnClickListener(this);
            TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f091af4);
            this.g = textView2;
            textView2.setOnClickListener(this);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f091bd6);
            this.h = findViewById;
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            this.i = layoutParams;
            layoutParams.height = this.k;
            this.h.setLayoutParams(layoutParams);
            this.h.setAlpha(0.0f);
            this.m = (HotTopicDetailPkProcess) findViewById(R.id.obfuscated_res_0x7f091bc1);
            this.n = (TextView) findViewById(R.id.obfuscated_res_0x7f091af6);
            this.o = (TextView) findViewById(R.id.obfuscated_res_0x7f091af8);
            this.p = (TextView) findViewById(R.id.obfuscated_res_0x7f091af7);
            this.q = (TextView) findViewById(R.id.obfuscated_res_0x7f091af9);
        }
    }

    public final void q(boolean z) {
        int i;
        int i2;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            mi7 mi7Var = this.r;
            if (mi7Var.f == 1) {
                i = 1;
            } else {
                i = 0;
            }
            if (mi7Var.f == 2) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            long j2 = i2;
            long j3 = mi7Var.i + mi7Var.j + i + j2;
            this.c.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f092b), StringHelper.numberUniformFormatExtra(j3)));
            this.e.setText(mi7Var.a);
            this.f.setText(mi7Var.b);
            this.g.setText(mi7Var.d);
            this.n.setText("" + (mi7Var.i + j));
            this.p.setText("" + (mi7Var.j + j2));
            if (j3 > 0) {
                int i3 = mi7Var.f;
                float f = 0.02f;
                if (i3 == 1) {
                    if (j3 > 1) {
                        float f2 = (float) j3;
                        float f3 = 1.0f / f2;
                        if (f3 >= 0.02f) {
                            f = f3;
                        }
                        this.m.setProcess(((((float) mi7Var.i) * 1.0f) / f2) + f, z);
                    } else {
                        this.m.setProcess(1.0f, z);
                    }
                } else if (i3 == 2) {
                    if (j3 > 1) {
                        float f4 = (float) j3;
                        float f5 = 1.0f / f4;
                        if (f5 >= 0.02f) {
                            f = f5;
                        }
                        this.m.setProcess(((((float) mi7Var.i) * 1.0f) / f4) - f, z);
                    } else {
                        this.m.setProcess(0.0f, z);
                    }
                } else {
                    this.m.setProcess((((float) mi7Var.i) * 1.0f) / ((float) j3), z);
                }
            } else {
                this.m.setProcess(0.5f, z);
            }
            if (this.h.getVisibility() != 0) {
                if (mi7Var.f != 0) {
                    this.k = this.j;
                    ViewGroup.LayoutParams layoutParams = this.h.getLayoutParams();
                    this.i = layoutParams;
                    layoutParams.height = this.k;
                    this.h.setLayoutParams(layoutParams);
                    this.h.setAlpha(1.0f);
                    this.h.setVisibility(0);
                } else {
                    this.k = 0;
                    ViewGroup.LayoutParams layoutParams2 = this.h.getLayoutParams();
                    this.i = layoutParams2;
                    layoutParams2.height = this.k;
                    this.h.setLayoutParams(layoutParams2);
                    this.h.setAlpha(0.0f);
                }
            }
            r();
        }
    }

    public final void r() {
        mi7 mi7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || (mi7Var = this.r) == null) {
            return;
        }
        int i = mi7Var.f;
        if (i == 1) {
            this.f.setBackgroundResource(R.drawable.obfuscated_res_0x7f0802da);
            this.g.setBackgroundResource(R.drawable.obfuscated_res_0x7f0802db);
            this.f.setTextColor(SkinManager.getColor(R.color.CAM_X0101));
            this.g.setTextColor(SkinManager.getColor(R.color.CAM_X0302));
        } else if (i == 2) {
            this.f.setBackgroundResource(R.drawable.obfuscated_res_0x7f0802db);
            this.g.setBackgroundResource(R.drawable.obfuscated_res_0x7f0802da);
            this.f.setTextColor(SkinManager.getColor(R.color.CAM_X0308));
            this.g.setTextColor(SkinManager.getColor(R.color.CAM_X0101));
        } else {
            this.f.setBackgroundResource(R.drawable.obfuscated_res_0x7f0802db);
            this.g.setBackgroundResource(R.drawable.obfuscated_res_0x7f0802db);
            this.f.setTextColor(SkinManager.getColor(R.color.CAM_X0308));
            this.g.setTextColor(SkinManager.getColor(R.color.CAM_X0302));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.f.setBackgroundTintList(this.s);
            this.g.setBackgroundTintList(this.t);
        }
    }
}
