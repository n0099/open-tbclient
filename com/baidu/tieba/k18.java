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
import com.baidu.tieba.l45;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class k18 extends nh implements BigdaySwipeRefreshLayout.k, PersonalizePageView.b1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView g;
    public LottieAnimationView h;
    public ImageView i;
    public TextView j;
    public cv4 k;
    public String l;
    public String m;
    public String n;
    public String o;
    public l45.g p;
    public l45.f q;
    public l45.h r;
    public l45.e s;

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements TbImageView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k18 a;

        @Override // com.baidu.tbadk.widget.TbImageView.h
        public void a(TbImageView tbImageView, Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, tbImageView, canvas) == null) {
            }
        }

        public a(k18 k18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k18Var;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.h
        public void b(TbImageView tbImageView, Canvas canvas) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbImageView, canvas) == null) && this.a.g.getBdImage() == null && this.a.k != null && !ad.isEmpty(this.a.k.a)) {
                this.a.g.startLoad(this.a.k.a, 41, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k18(Context context) {
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
            this.m = context.getText(R.string.obfuscated_res_0x7f0f0358).toString();
            this.n = context.getText(R.string.obfuscated_res_0x7f0f035a).toString();
            this.o = context.getText(R.string.obfuscated_res_0x7f0f0359).toString();
        }
    }

    public void E(cv4 cv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cv4Var) == null) {
            if (cv4Var.a()) {
                this.k = cv4Var;
            }
            if (cv4Var.c == 1) {
                this.j.setTextColor(h().getResources().getColor(R.color.CAM_X0101));
                this.i.setBackgroundResource(R.drawable.obfuscated_res_0x7f080387);
                this.h.setAnimation(R.raw.obfuscated_res_0x7f110053);
            } else {
                this.j.setTextColor(h().getResources().getColor(R.color.cp_cont_b_alpha40));
                this.i.setBackgroundResource(R.drawable.obfuscated_res_0x7f080388);
                this.h.setAnimation(R.raw.obfuscated_res_0x7f110052);
            }
            this.h.setFrame(0);
            this.g.startLoad(cv4Var.a, 41, false);
            this.g.setOnDrawListener(new a(this));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.b1
    public void a(l45.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, gVar) == null) {
            this.p = gVar;
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.b1
    public void b(l45.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hVar) == null) {
            this.r = hVar;
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.b1
    public void d(l45.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            this.s = eVar;
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.b1
    public void e(l45.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            this.q = fVar;
        }
    }

    @Override // com.baidu.tieba.nh
    public void q(boolean z) {
        l45.g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048592, this, z) == null) && (gVar = this.p) != null) {
            gVar.e(z);
        }
    }

    @Override // com.baidu.tieba.nh
    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            D(1.0f);
            this.j.setText(this.l);
            l45.h hVar = this.r;
            if (hVar != null) {
                hVar.a(z);
            }
        }
    }

    public cv4 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.k;
        }
        return (cv4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.k
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.j.setText(this.o);
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.k
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return (int) (BdUtilHelper.getEquipmentHeight(h()) * 0.3d);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.nh
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.j.setText("");
            this.h.animate().alpha(0.0f).setDuration(200L).start();
        }
    }

    @Override // com.baidu.tieba.nh
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.j.setText(this.n);
        }
    }

    public final void D(float f) {
        cv4 cv4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f) == null) {
            this.j.setAlpha(f);
            this.i.setAlpha(f);
            if (this.i.getBackground() == null && (cv4Var = this.k) != null) {
                if (cv4Var.c == 1) {
                    this.i.setBackgroundResource(R.drawable.obfuscated_res_0x7f080387);
                } else {
                    this.i.setBackgroundResource(R.drawable.obfuscated_res_0x7f080388);
                }
            }
        }
    }

    @Override // com.baidu.tieba.nh
    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            D(1.0f);
            this.h.setAlpha(1.0f);
            this.j.setText(this.l);
            l45.e eVar = this.s;
            if (eVar != null) {
                eVar.a();
            }
            l45.f fVar = this.q;
            if (fVar != null) {
                fVar.a(getView(), z);
            }
            this.h.cancelAnimation();
        }
    }

    @Override // com.baidu.tieba.nh
    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            View inflate = LayoutInflater.from(h()).inflate(R.layout.obfuscated_res_0x7f0d017a, (ViewGroup) null, false);
            this.g = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091dd6);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0903f4);
            this.h = (LottieAnimationView) inflate.findViewById(R.id.obfuscated_res_0x7f0903f6);
            this.i = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0924c4);
            this.j = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0922ed);
            if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f0703a5));
            }
            this.g.setAutoChangeStyle(false);
            this.j.setText(this.l);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.k
    public void j() {
        cv4 cv4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (cv4Var = this.k) != null && cv4Var.a()) {
            MessageManager messageManager = MessageManager.getInstance();
            Context h = h();
            cv4 cv4Var2 = this.k;
            messageManager.sendMessage(new CustomMessage(2002001, new BigdayActivityConfig(h, cv4Var2.a, cv4Var2.b, cv4Var2.d)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.k
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, Boolean.FALSE));
            this.j.animate().alpha(0.0f).setDuration(200L).start();
            this.i.animate().alpha(0.0f).setDuration(200L).start();
        }
    }

    @Override // com.baidu.tieba.nh
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            D(1.0f);
            this.j.setText(this.m);
            this.h.setAlpha(1.0f);
            this.h.setMinAndMaxFrame(8, 58);
            this.h.loop(true);
            this.h.playAnimation();
        }
    }

    @Override // com.baidu.tieba.nh, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void onPullPercentChange(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
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
            this.h.setAlpha(1.0f - ((f3 - dimension2) / (k() - dimension2)));
        }
    }
}
