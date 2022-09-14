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
import com.baidu.tieba.au4;
import com.baidu.tieba.frs.profession.permission.FrsProfessionPermissionModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class kq6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public FrsProfessionPermissionModel b;
    public iq6 c;
    public d d;
    public int e;

    /* loaded from: classes4.dex */
    public class a implements au4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ au4 b;
        public final /* synthetic */ kq6 c;

        public a(kq6 kq6Var, String str, au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq6Var, str, au4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = kq6Var;
            this.a = str;
            this.b = au4Var;
        }

        @Override // com.baidu.tieba.au4.e
        public void onClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(this.c.a.getPageActivity());
                membercenterActivityConfig.setUrl("https://tieba.baidu.com/mo/q/prozone/view?fid=" + this.a);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, membercenterActivityConfig));
                this.b.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements au4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ au4 a;

        public b(kq6 kq6Var, au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq6Var, au4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = au4Var;
        }

        @Override // com.baidu.tieba.au4.e
        public void onClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements au4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ au4 a;

        public c(kq6 kq6Var, au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq6Var, au4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = au4Var;
        }

        @Override // com.baidu.tieba.au4.e
        public void onClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(boolean z, int i);

        void b(boolean z);

        void c(boolean z);
    }

    public kq6(TbPageContext<?> tbPageContext) {
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
        iq6 iq6Var = new iq6();
        this.c = iq6Var;
        FrsProfessionPermissionModel frsProfessionPermissionModel = new FrsProfessionPermissionModel(tbPageContext, iq6Var);
        this.b = frsProfessionPermissionModel;
        frsProfessionPermissionModel.b0(this);
    }

    public final void b(jq6 jq6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jq6Var) == null) && jq6Var != null && jq6Var.b == 0) {
            if (!jq6Var.a && jq6Var.d == 2) {
                l(jq6Var.e);
            }
            d dVar = this.d;
            if (dVar != null) {
                dVar.c(jq6Var.a);
            }
        }
    }

    public final void c(jq6 jq6Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jq6Var, str) == null) || jq6Var == null) {
            return;
        }
        if (jq6Var.b != 0) {
            if (StringUtils.isNull(jq6Var.c)) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f0c59);
                return;
            } else {
                this.a.showToast(jq6Var.c);
                return;
            }
        }
        if (!jq6Var.a) {
            int i = jq6Var.d;
            if (i == 1) {
                k(jq6Var.e, str);
            } else if (i == 3) {
                l(jq6Var.e);
            }
        }
        d dVar = this.d;
        if (dVar != null) {
            dVar.b(jq6Var.a);
        }
    }

    public final void d(jq6 jq6Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jq6Var, i) == null) || jq6Var == null) {
            return;
        }
        if (jq6Var.b != 0) {
            if (StringUtils.isNull(jq6Var.c)) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f0c59);
                return;
            } else {
                this.a.showToast(jq6Var.c);
                return;
            }
        }
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(jq6Var.a, i);
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
            iq6 iq6Var = this.c;
            iq6Var.d = 1;
            iq6Var.c = str;
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
            iq6 iq6Var = this.c;
            iq6Var.c = str;
            iq6Var.b = j;
            iq6Var.d = 3;
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
            iq6 iq6Var = this.c;
            iq6Var.a = i;
            iq6Var.c = str;
            iq6Var.d = 2;
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
            au4 au4Var = new au4(this.a.getPageActivity());
            au4Var.setCanceledOnTouchOutside(false);
            au4Var.setCancelable(false);
            au4Var.setMessage(str);
            au4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f040a, new a(this, str2, au4Var));
            au4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0409, new b(this, au4Var));
            au4Var.create(this.a);
            au4Var.show();
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            au4 au4Var = new au4(this.a.getPageActivity());
            au4Var.setCanceledOnTouchOutside(false);
            au4Var.setCancelable(false);
            au4Var.setMessage(str);
            au4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f09b7, new c(this, au4Var));
            au4Var.create(this.a);
            au4Var.show();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void n(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048587, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof iq6) && mvcSocketResponsedMessage != null && (mvcSocketResponsedMessage.getData() instanceof jq6)) {
            iq6 iq6Var = (iq6) mvcNetMessage.getRequestData();
            jq6 jq6Var = (jq6) mvcSocketResponsedMessage.getData();
            if (iq6Var.e != this.e) {
                return;
            }
            int i = iq6Var.d;
            if (i == 1) {
                b(jq6Var);
            } else if (i == 2) {
                d(jq6Var, iq6Var.a);
            } else if (i != 3) {
            } else {
                c(jq6Var, iq6Var.c);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void s(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048588, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof iq6) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof jq6)) {
            iq6 iq6Var = (iq6) mvcNetMessage.getRequestData();
            jq6 jq6Var = (jq6) mvcHttpResponsedMessage.getData();
            if (iq6Var.e != this.e) {
                return;
            }
            int i = iq6Var.d;
            if (i == 1) {
                b(jq6Var);
            } else if (i == 2) {
                d(jq6Var, iq6Var.a);
            } else if (i != 3) {
            } else {
                c(jq6Var, iq6Var.c);
            }
        }
    }
}
