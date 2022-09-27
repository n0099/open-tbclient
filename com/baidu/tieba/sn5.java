package com.baidu.tieba;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class sn5 {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean d = true;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public tn5 b;
    public BaseFragmentActivity c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948157199, "Lcom/baidu/tieba/sn5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948157199, "Lcom/baidu/tieba/sn5;");
        }
    }

    public sn5(BaseFragmentActivity baseFragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = -1L;
        this.c = baseFragmentActivity;
    }

    public final void a(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, intent) == null) || intent == null) {
            return;
        }
        if (intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) {
            Intent intent2 = new Intent();
            intent2.putExtra(DealIntentService.KEY_CLASS, 2);
            intent2.putExtra("fname", intent.getStringExtra("fname"));
            intent2.putExtra(FrsActivityConfig.FROM_SHORT_CUT, true);
            intent2.putExtra("back_special", true);
            intent2.putExtra("from", "short_cut");
            intent.putExtra(LogoActivityConfig.EXTRAINTENT, intent2);
        }
        TbadkCoreApplication.setIntent((Intent) intent.getParcelableExtra(LogoActivityConfig.EXTRAINTENT));
    }

    public final void b(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            if (oj8.a(this.c.getIntent())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016560));
            }
            if (bundle != null) {
                LogoActivityConfig.isFirst = bundle.getBoolean("is_first", true);
            } else {
                LogoActivityConfig.isFirst = true;
            }
        }
    }

    public void c(Configuration configuration) {
        tn5 tn5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, configuration) == null) || (tn5Var = this.b) == null) {
            return;
        }
        tn5Var.d(configuration);
    }

    public void d(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            this.a = System.currentTimeMillis();
            if ("MuMu".equals(gj.g()) && "6.0.1".equals(gj.k())) {
                this.c.finish();
                return;
            }
            b(bundle);
            if (!oj8.a(this.c.getIntent()) && (oj8.b(this.c.getIntent()) || this.c.isTaskRoot())) {
                a(this.c.getIntent());
            }
            ll8.g().i(this.c.getUniqueId());
            tn5 tn5Var = new tn5(this.c);
            this.b = tn5Var;
            tn5Var.i(d);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ll8.g().k(this.c.getUniqueId());
            d = false;
            tn5 tn5Var = this.b;
            if (tn5Var != null) {
                tn5Var.g();
            }
        }
    }

    public void f() {
        tn5 tn5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (tn5Var = this.b) == null) {
            return;
        }
        tn5Var.e();
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (LogoActivityConfig.isFirst && this.a >= 0) {
                sd5.b().v(System.currentTimeMillis() - this.a);
            }
            tn5 tn5Var = this.b;
            if (tn5Var != null) {
                tn5Var.f();
            }
        }
    }
}
