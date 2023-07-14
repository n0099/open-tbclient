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
/* loaded from: classes6.dex */
public class jib extends BaseAdRipper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jib(Ssp.Pid pid) {
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
                Object obj2 = ((xib) obj).a;
                Field declaredField = obj2.getClass().getDeclaredField("a");
                declaredField.setAccessible(true);
                Object obj3 = declaredField.get(obj2);
                if (obj3 == null) {
                    return null;
                }
                Field declaredField2 = obj3.getClass().getSuperclass().getSuperclass().getDeclaredField("a");
                declaredField2.setAccessible(true);
                Object obj4 = declaredField2.get(obj3);
                if (obj4 == null) {
                    return null;
                }
                Object field = ReflectionUtils.getField(obj4, "c", "c");
                Field declaredField3 = field.getClass().getSuperclass().getDeclaredField("k");
                declaredField3.setAccessible(true);
                Object field2 = ReflectionUtils.getField(declaredField3.get(field), "e", "e", "c");
                Field declaredField4 = field2.getClass().getSuperclass().getDeclaredField("d");
                declaredField4.setAccessible(true);
                Object obj5 = declaredField4.get(field2);
                Field declaredField5 = obj5.getClass().getSuperclass().getDeclaredField("M");
                declaredField5.setAccessible(true);
                return gib.a((JSONObject) declaredField5.get(obj5));
            } catch (Exception e) {
                LogPrinter.e(e);
                return null;
            }
        }
        return (RippedAd) invokeL.objValue;
    }
}
