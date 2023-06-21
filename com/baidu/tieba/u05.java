package com.baidu.tieba;

import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class u05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public int c;
    public String d;
    public boolean e;
    public boolean f;
    public String g;

    public u05() {
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

    public static u05 b(AccountRealNameResult accountRealNameResult) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, accountRealNameResult)) == null) {
            u05 u05Var = new u05();
            u05Var.a = accountRealNameResult.getResultCode();
            u05Var.b = accountRealNameResult.getResultMsg();
            int i = accountRealNameResult.errorStep;
            u05Var.g = accountRealNameResult.callbackkey;
            u05Var.e = accountRealNameResult.juniorRealNameSuc;
            u05Var.f = accountRealNameResult.seniorRealNameSuc;
            u05Var.c = accountRealNameResult.subResultCode;
            u05Var.d = accountRealNameResult.subResultMsg;
            return u05Var;
        }
        return (u05) invokeL.objValue;
    }
}
