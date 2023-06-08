package com.baidu.tieba;

import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class t05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public int c;
    public String d;
    public boolean e;
    public boolean f;
    public String g;

    public t05() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = -202;
        this.c = -100000;
        this.d = "未触发任何实名操作返回或实名时放弃返回";
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.e && this.f) {
                return 3;
            }
            if (this.f) {
                return 2;
            }
            if (this.e) {
                return 1;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public static t05 b(AccountRealNameResult accountRealNameResult) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, accountRealNameResult)) == null) {
            t05 t05Var = new t05();
            t05Var.a = accountRealNameResult.getResultCode();
            t05Var.b = accountRealNameResult.getResultMsg();
            int i = accountRealNameResult.errorStep;
            t05Var.g = accountRealNameResult.callbackkey;
            t05Var.e = accountRealNameResult.juniorRealNameSuc;
            t05Var.f = accountRealNameResult.seniorRealNameSuc;
            t05Var.c = accountRealNameResult.subResultCode;
            t05Var.d = accountRealNameResult.subResultMsg;
            return t05Var;
        }
        return (t05) invokeL.objValue;
    }
}
