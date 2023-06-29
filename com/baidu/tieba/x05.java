package com.baidu.tieba;

import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class x05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public int c;
    public String d;
    public boolean e;
    public boolean f;
    public String g;

    public x05() {
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

    public static x05 b(AccountRealNameResult accountRealNameResult) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, accountRealNameResult)) == null) {
            x05 x05Var = new x05();
            x05Var.a = accountRealNameResult.getResultCode();
            x05Var.b = accountRealNameResult.getResultMsg();
            int i = accountRealNameResult.errorStep;
            x05Var.g = accountRealNameResult.callbackkey;
            x05Var.e = accountRealNameResult.juniorRealNameSuc;
            x05Var.f = accountRealNameResult.seniorRealNameSuc;
            x05Var.c = accountRealNameResult.subResultCode;
            x05Var.d = accountRealNameResult.subResultMsg;
            return x05Var;
        }
        return (x05) invokeL.objValue;
    }
}
