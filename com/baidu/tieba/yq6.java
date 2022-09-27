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
import com.baidu.tieba.nu4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class yq6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public FrsProfessionPermissionModel b;
    public wq6 c;
    public d d;
    public int e;

    /* loaded from: classes6.dex */
    public class a implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ nu4 b;
        public final /* synthetic */ yq6 c;

        public a(yq6 yq6Var, String str, nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yq6Var, str, nu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = yq6Var;
            this.a = str;
            this.b = nu4Var;
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(this.c.a.getPageActivity());
                membercenterActivityConfig.setUrl("https://tieba.baidu.com/mo/q/prozone/view?fid=" + this.a);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, membercenterActivityConfig));
                this.b.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nu4 a;

        public b(yq6 yq6Var, nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yq6Var, nu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nu4Var;
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nu4 a;

        public c(yq6 yq6Var, nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yq6Var, nu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nu4Var;
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface d {
        void a(boolean z, int i);

        void b(boolean z);

        void c(boolean z);
    }

    public yq6(TbPageContext<?> tbPageContext) {
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
        wq6 wq6Var = new wq6();
        this.c = wq6Var;
        FrsProfessionPermissionModel frsProfessionPermissionModel = new FrsProfessionPermissionModel(tbPageContext, wq6Var);
        this.b = frsProfessionPermissionModel;
        frsProfessionPermissionModel.b0(this);
    }

    public final void b(xq6 xq6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, xq6Var) == null) && xq6Var != null && xq6Var.b == 0) {
            if (!xq6Var.a && xq6Var.d == 2) {
                l(xq6Var.e);
            }
            d dVar = this.d;
            if (dVar != null) {
                dVar.c(xq6Var.a);
            }
        }
    }

    public final void c(xq6 xq6Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xq6Var, str) == null) || xq6Var == null) {
            return;
        }
        if (xq6Var.b != 0) {
            if (StringUtils.isNull(xq6Var.c)) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f0c59);
                return;
            } else {
                this.a.showToast(xq6Var.c);
                return;
            }
        }
        if (!xq6Var.a) {
            int i = xq6Var.d;
            if (i == 1) {
                k(xq6Var.e, str);
            } else if (i == 3) {
                l(xq6Var.e);
            }
        }
        d dVar = this.d;
        if (dVar != null) {
            dVar.b(xq6Var.a);
        }
    }

    public final void d(xq6 xq6Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, xq6Var, i) == null) || xq6Var == null) {
            return;
        }
        if (xq6Var.b != 0) {
            if (StringUtils.isNull(xq6Var.c)) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f0c59);
                return;
            } else {
                this.a.showToast(xq6Var.c);
                return;
            }
        }
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(xq6Var.a, i);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.b.T()) {
            return;
        }
        this.b.loadData();
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            wq6 wq6Var = this.c;
            wq6Var.d = 1;
            wq6Var.c = str;
            e();
        }
    }

    public void g(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048581, this, str, j) == null) {
            if (UbsABTestHelper.isNotRequestProPermission()) {
                this.d.b(true);
                return;
            }
            wq6 wq6Var = this.c;
            wq6Var.c = str;
            wq6Var.b = j;
            wq6Var.d = 3;
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
            wq6 wq6Var = this.c;
            wq6Var.a = i;
            wq6Var.c = str;
            wq6Var.d = 2;
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

    public final void k(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            nu4 nu4Var = new nu4(this.a.getPageActivity());
            nu4Var.setCanceledOnTouchOutside(false);
            nu4Var.setCancelable(false);
            nu4Var.setMessage(str);
            nu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f040a, new a(this, str2, nu4Var));
            nu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0409, new b(this, nu4Var));
            nu4Var.create(this.a);
            nu4Var.show();
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            nu4 nu4Var = new nu4(this.a.getPageActivity());
            nu4Var.setCanceledOnTouchOutside(false);
            nu4Var.setCancelable(false);
            nu4Var.setMessage(str);
            nu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f09b7, new c(this, nu4Var));
            nu4Var.create(this.a);
            nu4Var.show();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void n(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048587, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof wq6) && mvcSocketResponsedMessage != null && (mvcSocketResponsedMessage.getData() instanceof xq6)) {
            wq6 wq6Var = (wq6) mvcNetMessage.getRequestData();
            xq6 xq6Var = (xq6) mvcSocketResponsedMessage.getData();
            if (wq6Var.e != this.e) {
                return;
            }
            int i = wq6Var.d;
            if (i == 1) {
                b(xq6Var);
            } else if (i == 2) {
                d(xq6Var, wq6Var.a);
            } else if (i != 3) {
            } else {
                c(xq6Var, wq6Var.c);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void s(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048588, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof wq6) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof xq6)) {
            wq6 wq6Var = (wq6) mvcNetMessage.getRequestData();
            xq6 xq6Var = (xq6) mvcHttpResponsedMessage.getData();
            if (wq6Var.e != this.e) {
                return;
            }
            int i = wq6Var.d;
            if (i == 1) {
                b(xq6Var);
            } else if (i == 2) {
                d(xq6Var, wq6Var.a);
            } else if (i != 3) {
            } else {
                c(xq6Var, wq6Var.c);
            }
        }
    }
}
