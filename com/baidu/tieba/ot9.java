package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.ripper.BaseAdRipper;
import com.fun.ad.sdk.internal.api.ripper.RippedAd;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.lang.reflect.Field;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ot9 extends BaseAdRipper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ot9(Ssp.Pid pid) {
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

    @Override // com.fun.ad.sdk.internal.api.ripper.BaseAdRipper
    public RippedAd getRippedAdInternal(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj == null) {
                return null;
            }
            try {
                Field declaredField = obj.getClass().getDeclaredField("a");
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                if (obj2 == null) {
                    return null;
                }
                Field declaredField2 = obj2.getClass().getSuperclass().getSuperclass().getDeclaredField("a");
                declaredField2.setAccessible(true);
                Object obj3 = declaredField2.get(obj2);
                if (obj3 == null) {
                    return null;
                }
                Field declaredField3 = obj3.getClass().getDeclaredField("b");
                declaredField3.setAccessible(true);
                Object obj4 = declaredField3.get(obj3);
                if (obj4 == null) {
                    return null;
                }
                Field declaredField4 = obj4.getClass().getDeclaredField("c");
                declaredField4.setAccessible(true);
                Object obj5 = declaredField4.get(obj4);
                if (obj5 == null) {
                    return null;
                }
                Field declaredField5 = obj5.getClass().getDeclaredField("d");
                declaredField5.setAccessible(true);
                Object obj6 = declaredField5.get(obj5);
                if (obj6 == null) {
                    return null;
                }
                Field declaredField6 = obj6.getClass().getDeclaredField("b");
                declaredField6.setAccessible(true);
                Object obj7 = declaredField6.get(obj6);
                if (obj7 == null) {
                    return null;
                }
                Field declaredField7 = obj7.getClass().getDeclaredField("a");
                declaredField7.setAccessible(true);
                Object obj8 = declaredField7.get(obj7);
                if (obj8 == null) {
                    return null;
                }
                Field declaredField8 = obj8.getClass().getDeclaredField("i");
                declaredField8.setAccessible(true);
                Object obj9 = declaredField8.get(obj8);
                if (obj9 == null) {
                    return null;
                }
                Field declaredField9 = obj9.getClass().getDeclaredField("L");
                declaredField9.setAccessible(true);
                JSONObject jSONObject = (JSONObject) declaredField9.get(obj9);
                if (jSONObject == null) {
                    return null;
                }
                return kt9.a(jSONObject);
            } catch (Exception e) {
                LogPrinter.e(e);
                return null;
            }
        }
        return (RippedAd) invokeL.objValue;
    }
}
