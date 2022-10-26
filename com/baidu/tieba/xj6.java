package com.baidu.tieba;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.dialog.RoundLinearLayout;
import com.baidu.tbadk.core.dialog.RoundRelativeLayout;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.mm4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes6.dex */
public class xj6 implements yx {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public View b;
    public TbImageView c;
    public TextView d;
    public RoundLinearLayout e;
    public RoundRelativeLayout f;
    public TextView g;
    public pu4 h;
    public bm8 i;
    public ForumData j;
    public View k;
    public LinearLayout l;
    public TBLottieAnimationView m;
    public mm4 n;
    public mm4.b o;
    public View.OnClickListener p;

    /* loaded from: classes6.dex */
    public class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(xj6 xj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921682, 1));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements mm4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xj6 a;

        public b(xj6 xj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xj6Var;
        }

        @Override // com.baidu.tieba.mm4.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.g();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xj6 a;

        public c(xj6 xj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xj6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2 == this.a.d) {
                    if (this.a.h != null && this.a.h.isShowing()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
                        this.a.h.dismiss();
                        if (this.a.n != null) {
                            this.a.n.c();
                        }
                    }
                } else if (view2 == this.a.c || view2 == this.a.l) {
                    this.a.g();
                }
            }
        }
    }

    public xj6(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new b(this);
        this.p = new c(this);
        this.a = tbPageContext;
    }

    public final void g() {
        bm8 bm8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (bm8Var = this.i) != null && !StringUtils.isNull(bm8Var.p())) {
            if (!fl5.a(this.a.getPageActivity(), this.i.i())) {
                mt6.b(this.a, this.i.k(), this.i.p(), this.i.j());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
            httpMessage.addParam("id", this.i.c());
            MessageManager.getInstance().sendMessage(httpMessage);
            this.h.dismiss();
            mm4 mm4Var = this.n;
            if (mm4Var != null) {
                mm4Var.c();
            }
            FrsFragment.p2 = true;
            kt6.a("common_click", this.i, this.j, 1, null);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            mm4 mm4Var = new mm4(this.a.getPageActivity().getBaseContext(), this.o);
            this.n = mm4Var;
            mm4Var.k(1.5d);
            this.n.j(2.5d);
            this.n.f();
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d034a, (ViewGroup) null);
            this.b = inflate;
            this.g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c4b);
            RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091c8b);
            this.f = roundRelativeLayout;
            roundRelativeLayout.setRoundCount(8);
            this.k = this.b.findViewById(R.id.obfuscated_res_0x7f0914b5);
            LinearLayout linearLayout = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091ebc);
            this.l = linearLayout;
            linearLayout.setOnClickListener(this.p);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.b.findViewById(R.id.obfuscated_res_0x7f09144a);
            this.m = tBLottieAnimationView;
            tBLottieAnimationView.setAnimation(R.raw.obfuscated_res_0x7f11000f);
            this.m.setFrame(2);
            TbImageView tbImageView = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090aec);
            this.c = tbImageView;
            tbImageView.setOnClickListener(this.p);
            this.c.setPlaceHolder(2);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
            int k = fj.k(this.a.getPageActivity()) - (this.a.getResources().getDimensionPixelSize(R.dimen.tbds133) * 2);
            layoutParams.width = k;
            layoutParams.height = (int) (k * 1.3333333333333333d);
            this.c.setLayoutParams(layoutParams);
            this.k.setLayoutParams(layoutParams);
            TextView textView = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090aea);
            this.d = textView;
            textView.setOnClickListener(this.p);
            bm8 bm8Var = this.i;
            if (bm8Var != null) {
                this.c.L(bm8Var.e(), 10, false);
            }
            new ik6(this.f, this.m).g();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0301, (ViewGroup) null);
            this.b = inflate;
            this.g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c4b);
            RoundLinearLayout roundLinearLayout = (RoundLinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091c8b);
            this.e = roundLinearLayout;
            roundLinearLayout.setRoundCount(8);
            TbImageView tbImageView = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090aec);
            this.c = tbImageView;
            tbImageView.setOnClickListener(this.p);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.c.getLayoutParams();
            int k = fj.k(this.a.getPageActivity()) - (this.a.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            layoutParams.width = k;
            layoutParams.height = (int) (k * 1.3306452f);
            this.c.setLayoutParams(layoutParams);
            TextView textView = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090aea);
            this.d = textView;
            textView.setOnClickListener(this.p);
            bm8 bm8Var = this.i;
            if (bm8Var != null) {
                this.c.L(bm8Var.e(), 10, false);
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            bm8 bm8Var = this.i;
            if (bm8Var != null && bm8Var.r()) {
                h();
            } else {
                i();
            }
            pu4 pu4Var = new pu4(this.a.getPageActivity());
            this.h = pu4Var;
            pu4Var.setCancelable(true);
            this.h.setCanceledOnTouchOutside(true);
            this.h.setOnDismissListener(new a(this));
            this.h.create(this.a).show();
            View decorView = this.h.getWindow().getDecorView();
            WindowManager.LayoutParams attributes = this.h.getWindow().getAttributes();
            if (attributes != null) {
                attributes.width = -1;
                attributes.height = -2;
                attributes.gravity = 17;
                this.h.getWindow().setAttributes(attributes);
            }
            if (decorView instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) decorView;
                viewGroup.removeAllViews();
                viewGroup.addView(this.b);
            }
            bm8 bm8Var2 = this.i;
            if (bm8Var2 != null && bm8Var2.f()) {
                nv4 d = nv4.d(this.g);
                d.n(R.string.J_X01);
                d.f(R.color.CAM_X0602);
                nv4.d(this.g).v(R.color.CAM_X0617);
                this.g.setVisibility(0);
            } else {
                this.g.setVisibility(8);
            }
            kt6.k("common_exp", this.i, this.j, 1, null);
        }
    }

    public boolean j(gm8 gm8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, gm8Var)) == null) {
            if (gm8Var == null || gm8Var.getForum() == null || gm8Var.getBusinessPromot() == null || gm8Var.getBusinessPromot().g()) {
                return false;
            }
            this.j = gm8Var.getForum();
            this.i = gm8Var.getBusinessPromot();
            String str = "key_frs_dialog_ad_last_show_time" + gm8Var.getForum().getId();
            long m = ux4.k().m(str, 0L);
            if (m >= 0 && TimeHelper.isSameDay(new Date(m), new Date(System.currentTimeMillis()))) {
                return false;
            }
            ux4.k().x(str, System.currentTimeMillis());
            k();
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.yx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i) == null) && (textView = this.g) != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0615, 1);
        }
    }
}
