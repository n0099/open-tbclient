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
import com.baidu.tieba.jv4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class zs6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public FrsProfessionPermissionModel b;
    public xs6 c;
    public d d;
    public int e;

    /* loaded from: classes6.dex */
    public interface d {
        void a(boolean z, int i);

        void b(boolean z);

        void c(boolean z);
    }

    /* loaded from: classes6.dex */
    public class a implements jv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ jv4 b;
        public final /* synthetic */ zs6 c;

        public a(zs6 zs6Var, String str, jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zs6Var, str, jv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zs6Var;
            this.a = str;
            this.b = jv4Var;
        }

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(this.c.a.getPageActivity());
                membercenterActivityConfig.setUrl("https://tieba.baidu.com/mo/q/prozone/view?fid=" + this.a);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, membercenterActivityConfig));
                this.b.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements jv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jv4 a;

        public b(zs6 zs6Var, jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zs6Var, jv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jv4Var;
        }

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements jv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jv4 a;

        public c(zs6 zs6Var, jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zs6Var, jv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jv4Var;
        }

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    public zs6(TbPageContext<?> tbPageContext) {
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
        xs6 xs6Var = new xs6();
        this.c = xs6Var;
        FrsProfessionPermissionModel frsProfessionPermissionModel = new FrsProfessionPermissionModel(tbPageContext, xs6Var);
        this.b = frsProfessionPermissionModel;
        frsProfessionPermissionModel.b0(this);
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            jv4 jv4Var = new jv4(this.a.getPageActivity());
            jv4Var.setCanceledOnTouchOutside(false);
            jv4Var.setCancelable(false);
            jv4Var.setMessage(str);
            jv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f09d4, new c(this, jv4Var));
            jv4Var.create(this.a);
            jv4Var.show();
        }
    }

    public final void b(ys6 ys6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, ys6Var) == null) && ys6Var != null && ys6Var.b == 0) {
            if (!ys6Var.a && ys6Var.d == 2) {
                l(ys6Var.e);
            }
            d dVar = this.d;
            if (dVar != null) {
                dVar.c(ys6Var.a);
            }
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            xs6 xs6Var = this.c;
            xs6Var.d = 1;
            xs6Var.c = str;
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

    public final void c(ys6 ys6Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ys6Var, str) != null) || ys6Var == null) {
            return;
        }
        if (ys6Var.b != 0) {
            if (StringUtils.isNull(ys6Var.c)) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f0c81);
                return;
            } else {
                this.a.showToast(ys6Var.c);
                return;
            }
        }
        if (!ys6Var.a) {
            int i = ys6Var.d;
            if (i == 1) {
                k(ys6Var.e, str);
            } else if (i == 3) {
                l(ys6Var.e);
            }
        }
        d dVar = this.d;
        if (dVar != null) {
            dVar.b(ys6Var.a);
        }
    }

    public final void d(ys6 ys6Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, ys6Var, i) != null) || ys6Var == null) {
            return;
        }
        if (ys6Var.b != 0) {
            if (StringUtils.isNull(ys6Var.c)) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f0c81);
                return;
            } else {
                this.a.showToast(ys6Var.c);
                return;
            }
        }
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(ys6Var.a, i);
        }
    }

    public final void k(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            jv4 jv4Var = new jv4(this.a.getPageActivity());
            jv4Var.setCanceledOnTouchOutside(false);
            jv4Var.setCancelable(false);
            jv4Var.setMessage(str);
            jv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0414, new a(this, str2, jv4Var));
            jv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0413, new b(this, jv4Var));
            jv4Var.create(this.a);
            jv4Var.show();
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
            xs6 xs6Var = this.c;
            xs6Var.c = str;
            xs6Var.b = j;
            xs6Var.d = 3;
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
            xs6 xs6Var = this.c;
            xs6Var.a = i;
            xs6Var.c = str;
            xs6Var.d = 2;
            e();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void n(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048587, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof xs6) && mvcSocketResponsedMessage != null && (mvcSocketResponsedMessage.getData() instanceof ys6)) {
            xs6 xs6Var = (xs6) mvcNetMessage.getRequestData();
            ys6 ys6Var = (ys6) mvcSocketResponsedMessage.getData();
            if (xs6Var.e != this.e) {
                return;
            }
            int i = xs6Var.d;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        c(ys6Var, xs6Var.c);
                        return;
                    }
                    return;
                }
                d(ys6Var, xs6Var.a);
                return;
            }
            b(ys6Var);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void s(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048588, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof xs6) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof ys6)) {
            xs6 xs6Var = (xs6) mvcNetMessage.getRequestData();
            ys6 ys6Var = (ys6) mvcHttpResponsedMessage.getData();
            if (xs6Var.e != this.e) {
                return;
            }
            int i = xs6Var.d;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        c(ys6Var, xs6Var.c);
                        return;
                    }
                    return;
                }
                d(ys6Var, xs6Var.a);
                return;
            }
            b(ys6Var);
        }
    }
}
