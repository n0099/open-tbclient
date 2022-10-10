package com.baidu.tieba;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.qo4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class vm5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public qo4 b;
    public b c;
    public MarkData d;
    public final qo4.a e;

    /* loaded from: classes6.dex */
    public class a implements qo4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vm5 a;

        public a(vm5 vm5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vm5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vm5Var;
        }

        @Override // com.baidu.tieba.qo4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                if (z) {
                    if (z2) {
                        ej.N(this.a.a, this.a.a.getString(R.string.obfuscated_res_0x7f0f00d2));
                    } else {
                        ej.N(this.a.a, this.a.a.getString(R.string.obfuscated_res_0x7f0f0ff2));
                    }
                    if (this.a.c != null) {
                        this.a.c.a(z2);
                    }
                    if (this.a.d != null) {
                        gn8 gn8Var = new gn8();
                        gn8Var.a = this.a.d.getThreadId();
                        gn8Var.b = z2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921603, gn8Var));
                        return;
                    }
                    return;
                }
                ej.N(this.a.a, this.a.a.getString(R.string.obfuscated_res_0x7f0f14e6));
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(boolean z);
    }

    public vm5(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.e = new a(this);
        this.a = context;
        if (context instanceof BaseActivity) {
            this.b = qo4.b((BaseActivity) context);
        } else if (context instanceof BaseFragmentActivity) {
            this.b = qo4.c((BaseFragmentActivity) context);
        }
        qo4 qo4Var = this.b;
        if (qo4Var != null) {
            qo4Var.j(this.e);
        }
    }

    public void d() {
        qo4 qo4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (qo4Var = this.b) == null) {
            return;
        }
        qo4Var.a();
        this.b.h(true);
    }

    public void e() {
        qo4 qo4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (qo4Var = this.b) != null && qo4Var.e()) {
            this.b.d();
            this.b.h(false);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            qo4 qo4Var = this.b;
            if (qo4Var != null) {
                return qo4Var.e();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(boolean z) {
        qo4 qo4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (qo4Var = this.b) == null) {
            return;
        }
        qo4Var.h(z);
    }

    public void h(MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, markData) == null) {
            this.d = markData;
            qo4 qo4Var = this.b;
            if (qo4Var != null) {
                qo4Var.i(markData);
            }
        }
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.c = bVar;
        }
    }
}
