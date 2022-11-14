package com.baidu.tieba;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class sn8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public int c;
    public String d;
    public long e;

    public sn8() {
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

    public static sn8 a(ResponsedMessage responsedMessage) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, responsedMessage)) == null) {
            sn8 sn8Var = new sn8();
            if (BdNetTypeUtil.isNetWorkAvailable() && (responsedMessage.getError() < -13 || responsedMessage.getError() > -10)) {
                z = true;
            } else {
                z = false;
            }
            sn8Var.a = z;
            sn8Var.b = !responsedMessage.hasError();
            sn8Var.c = responsedMessage.getError();
            sn8Var.d = responsedMessage.getErrorString();
            sn8Var.e = responsedMessage.getDownSize();
            return sn8Var;
        }
        return (sn8) invokeL.objValue;
    }
}
