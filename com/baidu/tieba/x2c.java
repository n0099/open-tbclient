package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.lang.reflect.Field;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class x2c extends k3c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x2c(Ssp.Pid pid) {
        super(pid);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pid};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Ssp.Pid) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.k3c
    public JSONObject c(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            try {
                if (obj instanceof q2c) {
                    Field declaredField = obj.getClass().getSuperclass().getDeclaredField("mNativeInterstitialAdProd");
                    declaredField.setAccessible(true);
                    Object obj2 = declaredField.get(obj);
                    if (obj2 == null) {
                        return null;
                    }
                    Field declaredField2 = obj2.getClass().getSuperclass().getDeclaredField("k");
                    declaredField2.setAccessible(true);
                    Object obj3 = declaredField2.get(obj2);
                    if (obj3 == null) {
                        return null;
                    }
                    Field declaredField3 = obj3.getClass().getDeclaredField("adProdTemplate");
                    declaredField3.setAccessible(true);
                    Object obj4 = declaredField3.get(obj3);
                    if (obj4 == null) {
                        return null;
                    }
                    Field declaredField4 = obj4.getClass().getDeclaredField("f");
                    declaredField4.setAccessible(true);
                    Object obj5 = declaredField4.get(obj4);
                    if (obj5 == null) {
                        return null;
                    }
                    Field declaredField5 = obj5.getClass().getDeclaredField("p");
                    declaredField5.setAccessible(true);
                    Object obj6 = declaredField5.get(obj5);
                    if (obj6 instanceof JSONObject) {
                        return (JSONObject) obj6;
                    }
                    return null;
                }
                return null;
            } catch (Exception unused) {
                LogPrinter.d();
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }
}
