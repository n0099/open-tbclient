package com.baidu.tieba;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class o46 extends ActivityDelegation {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements n46 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o46 a;

        public a(o46 o46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o46Var;
        }

        @Override // com.baidu.tieba.n46
        public void a(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
                this.a.mResult.putInt("status_code", bundle.getInt("result_code"));
                this.a.mResult.putString("params", bundle.getString("result_msg"));
                this.a.finish();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947982328, "Lcom/baidu/tieba/o46;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947982328, "Lcom/baidu/tieba/o46;");
                return;
            }
        }
        a = am1.a;
    }

    public o46() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Bundle d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("order_info", str);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.mParams.isEmpty()) {
                if (a) {
                    Log.d("BaiFuBaoPayDelegation", "onExec params is null.");
                }
                return false;
            }
            if (a) {
                Log.d("BaiFuBaoPayDelegation", "PAYMENT onExec");
            }
            Log.d("BaiFuBaoPayDelegation", "PAYMENT onExec");
            if (!dn5.c().d()) {
                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), (int) R.string.plugin_pay_wallet_not_found);
                return false;
            } else if (!(getAgent() instanceof Activity)) {
                return false;
            } else {
                k46 k46Var = new k46();
                k46Var.mParams.putInt("type", 1);
                k46Var.mParams.putString("orderInfo", this.mParams.getString("order_info"));
                k46Var.d(getAgent());
                k46Var.e(new a(this));
                k46Var.onExec();
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
