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
import com.fun.ad.sdk.internal.api.utils.ReflectionUtils;
import java.lang.reflect.Field;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class ynb extends BaseAdRipper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ynb(Ssp.Pid pid) {
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
        Object findField;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj == null) {
                return null;
            }
            try {
                Object obj2 = ((sob) obj).a;
                Field declaredField = obj2.getClass().getSuperclass().getSuperclass().getDeclaredField("a");
                declaredField.setAccessible(true);
                Object obj3 = declaredField.get(obj2);
                if (obj3 == null) {
                    return null;
                }
                Field declaredField2 = obj3.getClass().getDeclaredField("c");
                declaredField2.setAccessible(true);
                Object obj4 = declaredField2.get(obj3);
                if (obj4 == null || (findField = ReflectionUtils.findField("com.qq.e.comm.plugin.A.E", obj4)) == null) {
                    return null;
                }
                Field declaredField3 = findField.getClass().getSuperclass().getDeclaredField("M");
                declaredField3.setAccessible(true);
                JSONObject jSONObject = (JSONObject) declaredField3.get(findField);
                if (jSONObject == null) {
                    return null;
                }
                return bob.a(jSONObject);
            } catch (Exception e) {
                LogPrinter.e(e);
                return null;
            }
        }
        return (RippedAd) invokeL.objValue;
    }
}
