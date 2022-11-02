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
import com.baidu.tieba.iv4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ns6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public FrsProfessionPermissionModel b;
    public ls6 c;
    public d d;
    public int e;

    /* loaded from: classes5.dex */
    public interface d {
        void a(boolean z, int i);

        void b(boolean z);

        void c(boolean z);
    }

    /* loaded from: classes5.dex */
    public class a implements iv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ iv4 b;
        public final /* synthetic */ ns6 c;

        public a(ns6 ns6Var, String str, iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ns6Var, str, iv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ns6Var;
            this.a = str;
            this.b = iv4Var;
        }

        @Override // com.baidu.tieba.iv4.e
        public void onClick(iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(this.c.a.getPageActivity());
                membercenterActivityConfig.setUrl("https://tieba.baidu.com/mo/q/prozone/view?fid=" + this.a);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, membercenterActivityConfig));
                this.b.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements iv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iv4 a;

        public b(ns6 ns6Var, iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ns6Var, iv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iv4Var;
        }

        @Override // com.baidu.tieba.iv4.e
        public void onClick(iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements iv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iv4 a;

        public c(ns6 ns6Var, iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ns6Var, iv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iv4Var;
        }

        @Override // com.baidu.tieba.iv4.e
        public void onClick(iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    public ns6(TbPageContext<?> tbPageContext) {
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
        ls6 ls6Var = new ls6();
        this.c = ls6Var;
        FrsProfessionPermissionModel frsProfessionPermissionModel = new FrsProfessionPermissionModel(tbPageContext, ls6Var);
        this.b = frsProfessionPermissionModel;
        frsProfessionPermissionModel.b0(this);
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            iv4 iv4Var = new iv4(this.a.getPageActivity());
            iv4Var.setCanceledOnTouchOutside(false);
            iv4Var.setCancelable(false);
            iv4Var.setMessage(str);
            iv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f09d2, new c(this, iv4Var));
            iv4Var.create(this.a);
            iv4Var.show();
        }
    }

    public final void b(ms6 ms6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, ms6Var) == null) && ms6Var != null && ms6Var.b == 0) {
            if (!ms6Var.a && ms6Var.d == 2) {
                l(ms6Var.e);
            }
            d dVar = this.d;
            if (dVar != null) {
                dVar.c(ms6Var.a);
            }
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            ls6 ls6Var = this.c;
            ls6Var.d = 1;
            ls6Var.c = str;
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

    public final void c(ms6 ms6Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ms6Var, str) != null) || ms6Var == null) {
            return;
        }
        if (ms6Var.b != 0) {
            if (StringUtils.isNull(ms6Var.c)) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f0c7f);
                return;
            } else {
                this.a.showToast(ms6Var.c);
                return;
            }
        }
        if (!ms6Var.a) {
            int i = ms6Var.d;
            if (i == 1) {
                k(ms6Var.e, str);
            } else if (i == 3) {
                l(ms6Var.e);
            }
        }
        d dVar = this.d;
        if (dVar != null) {
            dVar.b(ms6Var.a);
        }
    }

    public final void d(ms6 ms6Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, ms6Var, i) != null) || ms6Var == null) {
            return;
        }
        if (ms6Var.b != 0) {
            if (StringUtils.isNull(ms6Var.c)) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f0c7f);
                return;
            } else {
                this.a.showToast(ms6Var.c);
                return;
            }
        }
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(ms6Var.a, i);
        }
    }

    public final void k(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            iv4 iv4Var = new iv4(this.a.getPageActivity());
            iv4Var.setCanceledOnTouchOutside(false);
            iv4Var.setCancelable(false);
            iv4Var.setMessage(str);
            iv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0413, new a(this, str2, iv4Var));
            iv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0412, new b(this, iv4Var));
            iv4Var.create(this.a);
            iv4Var.show();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && !this.b.T()) {
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
            ls6 ls6Var = this.c;
            ls6Var.c = str;
            ls6Var.b = j;
            ls6Var.d = 3;
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
            ls6 ls6Var = this.c;
            ls6Var.a = i;
            ls6Var.c = str;
            ls6Var.d = 2;
            e();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void n(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048587, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof ls6) && mvcSocketResponsedMessage != null && (mvcSocketResponsedMessage.getData() instanceof ms6)) {
            ls6 ls6Var = (ls6) mvcNetMessage.getRequestData();
            ms6 ms6Var = (ms6) mvcSocketResponsedMessage.getData();
            if (ls6Var.e != this.e) {
                return;
            }
            int i = ls6Var.d;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        c(ms6Var, ls6Var.c);
                        return;
                    }
                    return;
                }
                d(ms6Var, ls6Var.a);
                return;
            }
            b(ms6Var);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void s(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048588, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof ls6) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof ms6)) {
            ls6 ls6Var = (ls6) mvcNetMessage.getRequestData();
            ms6 ms6Var = (ms6) mvcHttpResponsedMessage.getData();
            if (ls6Var.e != this.e) {
                return;
            }
            int i = ls6Var.d;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        c(ms6Var, ls6Var.c);
                        return;
                    }
                    return;
                }
                d(ms6Var, ls6Var.a);
                return;
            }
            b(ms6Var);
        }
    }
}
