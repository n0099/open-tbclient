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
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.reflect.Field;
import java.util.List;
/* loaded from: classes8.dex */
public class r1c extends BaseAdRipper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r1c(Ssp.Pid pid) {
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
        List<AdInfo> list;
        AdInfo adInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            try {
                h2c h2cVar = (h2c) obj;
                if (h2cVar != null) {
                    Object obj3 = h2cVar.a;
                    String[] strArr = {"mAdTemplate"};
                    Field field = null;
                    for (int i = 0; i < 1; i++) {
                        try {
                            field = obj3.getClass().getDeclaredField(strArr[i]);
                            field.setAccessible(true);
                            break;
                        } catch (NoSuchFieldException unused) {
                        }
                    }
                    if (field == null || (obj2 = field.get(obj3)) == null || !(obj2 instanceof AdTemplate) || (list = ((AdTemplate) obj2).adInfoList) == null || list.isEmpty() || (adInfo = list.get(0)) == null) {
                        return null;
                    }
                    return u1c.a(adInfo);
                }
                return null;
            } catch (Exception e) {
                LogPrinter.e(e);
                return null;
            }
        }
        return (RippedAd) invokeL.objValue;
    }
}
