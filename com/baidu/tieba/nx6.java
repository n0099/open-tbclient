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
import com.baidu.tieba.wv4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class nx6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public FrsProfessionPermissionModel b;
    public lx6 c;
    public d d;
    public int e;

    /* loaded from: classes5.dex */
    public interface d {
        void a(boolean z, int i);

        void b(boolean z);

        void c(boolean z);
    }

    /* loaded from: classes5.dex */
    public class a implements wv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ wv4 b;
        public final /* synthetic */ nx6 c;

        public a(nx6 nx6Var, String str, wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nx6Var, str, wv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = nx6Var;
            this.a = str;
            this.b = wv4Var;
        }

        @Override // com.baidu.tieba.wv4.e
        public void onClick(wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wv4Var) == null) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(this.c.a.getPageActivity());
                membercenterActivityConfig.setUrl("https://tieba.baidu.com/mo/q/prozone/view?fid=" + this.a);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, membercenterActivityConfig));
                this.b.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements wv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wv4 a;

        public b(nx6 nx6Var, wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nx6Var, wv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wv4Var;
        }

        @Override // com.baidu.tieba.wv4.e
        public void onClick(wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wv4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements wv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wv4 a;

        public c(nx6 nx6Var, wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nx6Var, wv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wv4Var;
        }

        @Override // com.baidu.tieba.wv4.e
        public void onClick(wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wv4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    public nx6(TbPageContext<?> tbPageContext) {
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
        lx6 lx6Var = new lx6();
        this.c = lx6Var;
        FrsProfessionPermissionModel frsProfessionPermissionModel = new FrsProfessionPermissionModel(tbPageContext, lx6Var);
        this.b = frsProfessionPermissionModel;
        frsProfessionPermissionModel.i0(this);
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            wv4 wv4Var = new wv4(this.a.getPageActivity());
            wv4Var.setCanceledOnTouchOutside(false);
            wv4Var.setCancelable(false);
            wv4Var.setMessage(str);
            wv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0a21, new c(this, wv4Var));
            wv4Var.create(this.a);
            wv4Var.show();
        }
    }

    public final void b(mx6 mx6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, mx6Var) == null) && mx6Var != null && mx6Var.b == 0) {
            if (!mx6Var.a && mx6Var.d == 2) {
                l(mx6Var.e);
            }
            d dVar = this.d;
            if (dVar != null) {
                dVar.c(mx6Var.a);
            }
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            lx6 lx6Var = this.c;
            lx6Var.d = 1;
            lx6Var.c = str;
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

    public final void c(mx6 mx6Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mx6Var, str) != null) || mx6Var == null) {
            return;
        }
        if (mx6Var.b != 0) {
            if (StringUtils.isNull(mx6Var.c)) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f0cd1);
                return;
            } else {
                this.a.showToast(mx6Var.c);
                return;
            }
        }
        if (!mx6Var.a) {
            int i = mx6Var.d;
            if (i == 1) {
                k(mx6Var.e, str);
            } else if (i == 3) {
                l(mx6Var.e);
            }
        }
        d dVar = this.d;
        if (dVar != null) {
            dVar.b(mx6Var.a);
        }
    }

    public final void d(mx6 mx6Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, mx6Var, i) != null) || mx6Var == null) {
            return;
        }
        if (mx6Var.b != 0) {
            if (StringUtils.isNull(mx6Var.c)) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f0cd1);
                return;
            } else {
                this.a.showToast(mx6Var.c);
                return;
            }
        }
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(mx6Var.a, i);
        }
    }

    public final void k(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            wv4 wv4Var = new wv4(this.a.getPageActivity());
            wv4Var.setCanceledOnTouchOutside(false);
            wv4Var.setCancelable(false);
            wv4Var.setMessage(str);
            wv4Var.setPositiveButton(R.string.comfirm_imediate, new a(this, str2, wv4Var));
            wv4Var.setNegativeButton(R.string.comfirm_cancel, new b(this, wv4Var));
            wv4Var.create(this.a);
            wv4Var.show();
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
            lx6 lx6Var = this.c;
            lx6Var.c = str;
            lx6Var.b = j;
            lx6Var.d = 3;
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
            lx6 lx6Var = this.c;
            lx6Var.a = i;
            lx6Var.c = str;
            lx6Var.d = 2;
            e();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void q(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048587, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof lx6) && mvcSocketResponsedMessage != null && (mvcSocketResponsedMessage.getData() instanceof mx6)) {
            lx6 lx6Var = (lx6) mvcNetMessage.getRequestData();
            mx6 mx6Var = (mx6) mvcSocketResponsedMessage.getData();
            if (lx6Var.e != this.e) {
                return;
            }
            int i = lx6Var.d;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        c(mx6Var, lx6Var.c);
                        return;
                    }
                    return;
                }
                d(mx6Var, lx6Var.a);
                return;
            }
            b(mx6Var);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void y(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048588, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof lx6) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof mx6)) {
            lx6 lx6Var = (lx6) mvcNetMessage.getRequestData();
            mx6 mx6Var = (mx6) mvcHttpResponsedMessage.getData();
            if (lx6Var.e != this.e) {
                return;
            }
            int i = lx6Var.d;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        c(mx6Var, lx6Var.c);
                        return;
                    }
                    return;
                }
                d(mx6Var, lx6Var.a);
                return;
            }
            b(mx6Var);
        }
    }
}
