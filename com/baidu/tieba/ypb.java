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
import com.kwad.sdk.core.response.model.AdInfo;
/* loaded from: classes8.dex */
public class ypb extends BaseAdRipper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ypb(Ssp.Pid pid) {
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
            try {
                sqb sqbVar = (sqb) obj;
                if (sqbVar == null || (findField = ReflectionUtils.findField("com.kwad.sdk.core.response.model.AdInfo", sqbVar.a)) == null) {
                    return null;
                }
                return fqb.a((AdInfo) findField);
            } catch (Exception e) {
                LogPrinter.e(e);
                return null;
            }
        }
        return (RippedAd) invokeL.objValue;
    }
}
