package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.frs.profession.permission.FrsProfessionPermissionModel;
import com.baidu.tieba.lv4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class vt6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public FrsProfessionPermissionModel b;
    public tt6 c;
    public d d;
    public int e;

    /* loaded from: classes6.dex */
    public interface d {
        void a(boolean z, int i);

        void b(boolean z);

        void c(boolean z);
    }

    /* loaded from: classes6.dex */
    public class a implements lv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ lv4 b;
        public final /* synthetic */ vt6 c;

        public a(vt6 vt6Var, String str, lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vt6Var, str, lv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = vt6Var;
            this.a = str;
            this.b = lv4Var;
        }

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(this.c.a.getPageActivity());
                membercenterActivityConfig.setUrl("https://tieba.baidu.com/mo/q/prozone/view?fid=" + this.a);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, membercenterActivityConfig));
                this.b.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements lv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lv4 a;

        public b(vt6 vt6Var, lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vt6Var, lv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lv4Var;
        }

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements lv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lv4 a;

        public c(vt6 vt6Var, lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vt6Var, lv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lv4Var;
        }

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    public vt6(TbPageContext<?> tbPageContext) {
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
        this.a = tbPageContext;
        tt6 tt6Var = new tt6();
        this.c = tt6Var;
        FrsProfessionPermissionModel frsProfessionPermissionModel = new FrsProfessionPermissionModel(tbPageContext, tt6Var);
        this.b = frsProfessionPermissionModel;
        frsProfessionPermissionModel.i0(this);
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            lv4 lv4Var = new lv4(this.a.getPageActivity());
            lv4Var.setCanceledOnTouchOutside(false);
            lv4Var.setCancelable(false);
            lv4Var.setMessage(str);
            lv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0a07, new c(this, lv4Var));
            lv4Var.create(this.a);
            lv4Var.show();
        }
    }

    public final void b(ut6 ut6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, ut6Var) == null) && ut6Var != null && ut6Var.b == 0) {
            if (!ut6Var.a && ut6Var.d == 2) {
                l(ut6Var.e);
            }
            d dVar = this.d;
            if (dVar != null) {
                dVar.c(ut6Var.a);
            }
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            tt6 tt6Var = this.c;
            tt6Var.d = 1;
            tt6Var.c = str;
            e();
        }
    }

    public void i(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
            this.d = dVar;
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.e = i;
            this.c.e = i;
        }
    }

    public final void c(ut6 ut6Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ut6Var, str) != null) || ut6Var == null) {
            return;
        }
        if (ut6Var.b != 0) {
            if (StringUtils.isNull(ut6Var.c)) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f0cb8);
                return;
            } else {
                this.a.showToast(ut6Var.c);
                return;
            }
        }
        if (!ut6Var.a) {
            int i = ut6Var.d;
            if (i == 1) {
                k(ut6Var.e, str);
            } else if (i == 3) {
                l(ut6Var.e);
            }
        }
        d dVar = this.d;
        if (dVar != null) {
            dVar.b(ut6Var.a);
        }
    }

    public final void d(ut6 ut6Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, ut6Var, i) != null) || ut6Var == null) {
            return;
        }
        if (ut6Var.b != 0) {
            if (StringUtils.isNull(ut6Var.c)) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f0cb8);
                return;
            } else {
                this.a.showToast(ut6Var.c);
                return;
            }
        }
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(ut6Var.a, i);
        }
    }

    public final void k(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            lv4 lv4Var = new lv4(this.a.getPageActivity());
            lv4Var.setCanceledOnTouchOutside(false);
            lv4Var.setCancelable(false);
            lv4Var.setMessage(str);
            lv4Var.setPositiveButton(R.string.comfirm_imediate, new a(this, str2, lv4Var));
            lv4Var.setNegativeButton(R.string.comfirm_cancel, new b(this, lv4Var));
            lv4Var.create(this.a);
            lv4Var.show();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && !this.b.a0()) {
            this.b.loadData();
        }
    }

    public void g(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048581, this, str, j) == null) {
            if (UbsABTestHelper.isNotRequestProPermission()) {
                this.d.b(true);
                return;
            }
            tt6 tt6Var = this.c;
            tt6Var.c = str;
            tt6Var.b = j;
            tt6Var.d = 3;
            e();
        }
    }

    public void h(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i) == null) {
            if (UbsABTestHelper.isNotRequestProPermission()) {
                this.d.a(true, i);
                return;
            }
            tt6 tt6Var = this.c;
            tt6Var.a = i;
            tt6Var.c = str;
            tt6Var.d = 2;
            e();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void q(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048587, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof tt6) && mvcSocketResponsedMessage != null && (mvcSocketResponsedMessage.getData() instanceof ut6)) {
            tt6 tt6Var = (tt6) mvcNetMessage.getRequestData();
            ut6 ut6Var = (ut6) mvcSocketResponsedMessage.getData();
            if (tt6Var.e != this.e) {
                return;
            }
            int i = tt6Var.d;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        c(ut6Var, tt6Var.c);
                        return;
                    }
                    return;
                }
                d(ut6Var, tt6Var.a);
                return;
            }
            b(ut6Var);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void y(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048588, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof tt6) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof ut6)) {
            tt6 tt6Var = (tt6) mvcNetMessage.getRequestData();
            ut6 ut6Var = (ut6) mvcHttpResponsedMessage.getData();
            if (tt6Var.e != this.e) {
                return;
            }
            int i = tt6Var.d;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        c(ut6Var, tt6Var.c);
                        return;
                    }
                    return;
                }
                d(ut6Var, tt6Var.a);
                return;
            }
            b(ut6Var);
        }
    }
}
