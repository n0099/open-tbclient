package com.baidu.tieba;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class zp9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public int c;
    public String d;
    public long e;

    public zp9() {
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
        this.a = false;
        this.b = false;
        this.c = 0;
        this.d = "";
        this.e = 0L;
    }

    public static zp9 a(ResponsedMessage responsedMessage) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, responsedMessage)) == null) {
            zp9 zp9Var = new zp9();
            if (BdNetTypeUtil.isNetWorkAvailable() && (responsedMessage.getError() < -13 || responsedMessage.getError() > -10)) {
                z = true;
            } else {
                z = false;
            }
            zp9Var.a = z;
            zp9Var.b = !responsedMessage.hasError();
            zp9Var.c = responsedMessage.getError();
            zp9Var.d = responsedMessage.getErrorString();
            zp9Var.e = responsedMessage.getDownSize();
            return zp9Var;
        }
        return (zp9) invokeL.objValue;
    }
}
