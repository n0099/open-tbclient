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
/* loaded from: classes6.dex */
public class lhb extends BaseAdRipper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lhb(Ssp.Pid pid) {
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
        Object obj2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj == null) {
                return null;
            }
            try {
                Object obj3 = ((bib) obj).a;
                Field declaredField = obj3.getClass().getSuperclass().getSuperclass().getDeclaredField("a");
                declaredField.setAccessible(true);
                obj2 = declaredField.get(obj3);
            } catch (Exception e) {
                LogPrinter.e(e);
            }
            if (obj2 == null) {
                return null;
            }
            Field declaredField2 = obj2.getClass().getDeclaredField("c");
            declaredField2.setAccessible(true);
            Object obj4 = declaredField2.get(obj2);
            if (obj4 == null) {
                return null;
            }
            Field declaredField3 = obj4.getClass().getDeclaredField("c");
            declaredField3.setAccessible(true);
            Object obj5 = declaredField3.get(obj4);
            if (obj5 == null) {
                return null;
            }
            Field declaredField4 = obj5.getClass().getDeclaredField("v");
            declaredField4.setAccessible(true);
            Object obj6 = declaredField4.get(obj5);
            if (obj6 == null) {
                return null;
            }
            Field declaredField5 = obj6.getClass().getSuperclass().getDeclaredField("M");
            declaredField5.setAccessible(true);
            JSONObject jSONObject = (JSONObject) declaredField5.get(obj6);
            if (jSONObject != null) {
                return khb.a(jSONObject);
            }
            return null;
        }
        return (RippedAd) invokeL.objValue;
    }
}
