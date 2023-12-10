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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.dialog.RoundLinearLayout;
import com.baidu.tbadk.core.dialog.RoundRelativeLayout;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.gp4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes9.dex */
public class xu7 implements jt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public View b;
    public TbImageView c;
    public TextView d;
    public RoundLinearLayout e;
    public RoundRelativeLayout f;
    public TextView g;
    public f05 h;
    public zua i;
    public ForumData j;
    public View k;
    public LinearLayout l;
    public TBLottieAnimationView m;
    public gp4 n;
    public gp4.b o;
    public View.OnClickListener p;

    /* loaded from: classes9.dex */
    public class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(xu7 xu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xu7Var};
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
                YunDialogManager.unMarkShowingDialogName("frsAd");
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements gp4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xu7 a;

        public b(xu7 xu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xu7Var;
        }

        @Override // com.baidu.tieba.gp4.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.g();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xu7 a;

        public c(xu7 xu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xu7Var;
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

    public xu7(TbPageContext tbPageContext) {
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
        zua zuaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (zuaVar = this.i) != null && !StringUtils.isNull(zuaVar.q())) {
            if (!jy5.a(this.a.getPageActivity(), this.i.i())) {
                s68.b(this.a, this.i.k(), this.i.q(), this.i.j());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
            httpMessage.addParam("id", this.i.c());
            MessageManager.getInstance().sendMessage(httpMessage);
            this.h.dismiss();
            gp4 gp4Var = this.n;
            if (gp4Var != null) {
                gp4Var.c();
            }
            FrsFragment.B2 = true;
            q68.a("common_click", this.i, this.j, 1, null);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            gp4 gp4Var = new gp4(this.a.getPageActivity().getBaseContext(), this.o);
            this.n = gp4Var;
            gp4Var.k(1.5d);
            this.n.j(2.5d);
            this.n.f();
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d03c1, (ViewGroup) null);
            this.b = inflate;
            this.g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090e25);
            RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f09208f);
            this.f = roundRelativeLayout;
            roundRelativeLayout.setRoundCount(8);
            this.k = this.b.findViewById(R.id.obfuscated_res_0x7f0917be);
            LinearLayout linearLayout = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f0922d4);
            this.l = linearLayout;
            linearLayout.setOnClickListener(this.p);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.b.findViewById(R.id.obfuscated_res_0x7f09174c);
            this.m = tBLottieAnimationView;
            tBLottieAnimationView.setAnimation(R.raw.frs_ad_shark);
            this.m.setFrame(2);
            TbImageView tbImageView = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090cb3);
            this.c = tbImageView;
            tbImageView.setOnClickListener(this.p);
            this.c.setPlaceHolder(2);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
            int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.a.getPageActivity()) - (this.a.getResources().getDimensionPixelSize(R.dimen.tbds133) * 2);
            layoutParams.width = equipmentWidth;
            layoutParams.height = (int) (equipmentWidth * 1.3333333333333333d);
            this.c.setLayoutParams(layoutParams);
            this.k.setLayoutParams(layoutParams);
            TextView textView = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090cb1);
            this.d = textView;
            textView.setOnClickListener(this.p);
            zua zuaVar = this.i;
            if (zuaVar != null) {
                this.c.startLoad(zuaVar.e(), 10, false);
            }
            new hv7(this.f, this.m).g();
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            zua zuaVar = this.i;
            if (zuaVar != null && zuaVar.s()) {
                h();
            } else {
                i();
            }
            f05 f05Var = new f05(this.a.getPageActivity());
            this.h = f05Var;
            f05Var.setCancelable(true);
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
            zua zuaVar2 = this.i;
            if (zuaVar2 != null && zuaVar2.f()) {
                EMManager.from(this.g).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0602);
                EMManager.from(this.g).setTextColor(R.color.CAM_X0617);
                this.g.setVisibility(0);
            } else {
                this.g.setVisibility(8);
            }
            q68.k("common_exp", this.i, this.j, 1, null);
            YunDialogManager.markShowingDialogName("frsAd");
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0373, (ViewGroup) null);
            this.b = inflate;
            this.g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090e25);
            RoundLinearLayout roundLinearLayout = (RoundLinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f09208f);
            this.e = roundLinearLayout;
            roundLinearLayout.setRoundCount(8);
            TbImageView tbImageView = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090cb3);
            this.c = tbImageView;
            tbImageView.setOnClickListener(this.p);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.c.getLayoutParams();
            int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.a.getPageActivity()) - (this.a.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            layoutParams.width = equipmentWidth;
            layoutParams.height = (int) (equipmentWidth * 1.3306452f);
            this.c.setLayoutParams(layoutParams);
            TextView textView = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090cb1);
            this.d = textView;
            textView.setOnClickListener(this.p);
            zua zuaVar = this.i;
            if (zuaVar != null) {
                this.c.startLoad(zuaVar.e(), 10, false);
            }
        }
    }

    public boolean j(eva evaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, evaVar)) == null) {
            if (evaVar == null || evaVar.getForum() == null || evaVar.getBusinessPromot() == null || evaVar.getBusinessPromot().g()) {
                return false;
            }
            this.j = evaVar.getForum();
            this.i = evaVar.getBusinessPromot();
            String str = "key_frs_dialog_ad_last_show_time" + evaVar.getForum().getId();
            long j = SharedPrefHelper.getInstance().getLong(str, 0L);
            if (j >= 0 && TimeHelper.isSameDay(new Date(j), new Date(System.currentTimeMillis()))) {
                return false;
            }
            SharedPrefHelper.getInstance().putLong(str, System.currentTimeMillis());
            k();
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.jt
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i) == null) && (textView = this.g) != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0615, 1);
        }
    }
}
