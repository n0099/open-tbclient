package com.baidu.tieba;

import android.content.Context;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.homepage.personalize.PersonalizePageView;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.p95;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class m58 extends qm implements BigdaySwipeRefreshLayout.k, PersonalizePageView.a1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView g;
    public LottieAnimationView h;
    public ImageView i;
    public TextView j;
    public p05 k;
    public String l;
    public String m;
    public String n;
    public String o;
    public p95.g p;
    public p95.f q;
    public p95.h r;
    public p95.e s;

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements TbImageView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m58 a;

        @Override // com.baidu.tbadk.widget.TbImageView.h
        public void a(TbImageView tbImageView, Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, tbImageView, canvas) == null) {
            }
        }

        public a(m58 m58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m58Var;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.h
        public void b(TbImageView tbImageView, Canvas canvas) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbImageView, canvas) == null) && this.a.g.getBdImage() == null && this.a.k != null && !di.isEmpty(this.a.k.a)) {
                this.a.g.startLoad(this.a.k.a, 41, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m58(Context context) {
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
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        if (context != null) {
            this.l = context.getText(R.string.obfuscated_res_0x7f0f0108).toString();
            this.m = context.getText(R.string.obfuscated_res_0x7f0f0355).toString();
            this.n = context.getText(R.string.obfuscated_res_0x7f0f0357).toString();
            this.o = context.getText(R.string.obfuscated_res_0x7f0f0356).toString();
        }
    }

    public void D(p05 p05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, p05Var) == null) {
            if (p05Var.a()) {
                this.k = p05Var;
            }
            if (p05Var.c == 1) {
                this.j.setTextColor(getContext().getResources().getColor(R.color.CAM_X0101));
                this.i.setBackgroundResource(R.drawable.obfuscated_res_0x7f08037f);
                this.h.setAnimation(R.raw.obfuscated_res_0x7f110053);
            } else {
                this.j.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b_alpha40));
                this.i.setBackgroundResource(R.drawable.obfuscated_res_0x7f080380);
                this.h.setAnimation(R.raw.obfuscated_res_0x7f110052);
            }
            this.h.setFrame(0);
            this.g.startLoad(p05Var.a, 41, false);
            this.g.setOnDrawListener(new a(this));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a1
    public void a(p95.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, gVar) == null) {
            this.p = gVar;
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a1
    public void b(p95.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hVar) == null) {
            this.r = hVar;
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a1
    public void d(p95.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            this.s = eVar;
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a1
    public void g(p95.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
            this.q = fVar;
        }
    }

    @Override // com.baidu.tieba.qm
    public void p(boolean z) {
        p95.g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048592, this, z) == null) && (gVar = this.p) != null) {
            gVar.e(z);
        }
    }

    @Override // com.baidu.tieba.qm
    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            C(1.0f);
            this.j.setText(this.l);
            p95.h hVar = this.r;
            if (hVar != null) {
                hVar.a(z);
            }
        }
    }

    public p05 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.k;
        }
        return (p05) invokeV.objValue;
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.k
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.j.setText(this.o);
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.k
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return (int) (BdUtilHelper.getEquipmentHeight(getContext()) * 0.3d);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.qm
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.j.setText("");
            this.h.animate().alpha(0.0f).setDuration(200L).start();
        }
    }

    @Override // com.baidu.tieba.qm
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.j.setText(this.n);
        }
    }

    public final void C(float f) {
        p05 p05Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f) == null) {
            this.j.setAlpha(f);
            this.i.setAlpha(f);
            if (this.i.getBackground() == null && (p05Var = this.k) != null) {
                if (p05Var.c == 1) {
                    this.i.setBackgroundResource(R.drawable.obfuscated_res_0x7f08037f);
                } else {
                    this.i.setBackgroundResource(R.drawable.obfuscated_res_0x7f080380);
                }
            }
        }
    }

    @Override // com.baidu.tieba.qm
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            C(1.0f);
            this.h.setAlpha(1.0f);
            this.j.setText(this.l);
            p95.e eVar = this.s;
            if (eVar != null) {
                eVar.a();
            }
            p95.f fVar = this.q;
            if (fVar != null) {
                fVar.a(getView(), z);
            }
            this.h.cancelAnimation();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.k
    public void e() {
        p05 p05Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (p05Var = this.k) != null && p05Var.a()) {
            MessageManager messageManager = MessageManager.getInstance();
            Context context = getContext();
            p05 p05Var2 = this.k;
            messageManager.sendMessage(new CustomMessage(2002001, new BigdayActivityConfig(context, p05Var2.a, p05Var2.b, p05Var2.d)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.k
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, Boolean.FALSE));
            this.j.animate().alpha(0.0f).setDuration(200L).start();
            this.i.animate().alpha(0.0f).setDuration(200L).start();
        }
    }

    @Override // com.baidu.tieba.qm
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            C(1.0f);
            this.j.setText(this.m);
            this.h.setAlpha(1.0f);
            this.h.setMinAndMaxFrame(8, 58);
            this.h.loop(true);
            this.h.playAnimation();
        }
    }

    @Override // com.baidu.tieba.qm
    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0177, (ViewGroup) null, false);
            this.g = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091dc1);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0903f2);
            this.h = (LottieAnimationView) inflate.findViewById(R.id.obfuscated_res_0x7f0903f4);
            this.i = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0924ae);
            this.j = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0922d8);
            if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f0703a5));
            }
            this.g.setAutoChangeStyle(false);
            this.j.setText(this.l);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qm, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void onPullPercentChange(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            super.onPullPercentChange(f, f2);
            float dimension = getView().getResources().getDimension(R.dimen.tbds120);
            float dimension2 = getView().getResources().getDimension(R.dimen.tbds236);
            float f3 = f * dimension2;
            if (f3 < dimension2) {
                float f4 = 0.09090909f;
                float f5 = ((f3 - dimension) / (dimension2 - dimension)) * 0.09090909f;
                if (f5 < 0.0f) {
                    f4 = 0.0f;
                } else if (f5 <= 0.09090909f) {
                    f4 = f5;
                }
                this.h.setProgress(f4);
                return;
            }
            this.h.setAlpha(1.0f - ((f3 - dimension2) / (f() - dimension2)));
        }
    }
}
