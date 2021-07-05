package com.bytedance.sdk.component.net.tnc;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.b.ab;
import com.bytedance.sdk.component.b.b.u;
import com.bytedance.sdk.component.b.b.z;
import java.io.IOException;
/* loaded from: classes6.dex */
public class TncHostInterceptor implements u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public TncHostInterceptor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.bytedance.sdk.component.b.b.u
    public ab intercept(u.a aVar) throws IOException {
        InterceptResult invokeL;
        ab abVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            z a2 = aVar.a();
            if (TNCManager.getInstance().getAppConfig() != null) {
                TNCManager.getInstance().getAppConfig().tryLodeConfigInSubThread();
            }
            String tVar = a2.a().toString();
            String handleHostMapping = TNCManager.getInstance().handleHostMapping(tVar);
            if (!tVar.equals(handleHostMapping)) {
                a2 = a2.f().a(handleHostMapping).d();
            }
            try {
                abVar = aVar.a(a2);
            } catch (Exception e2) {
                TNCManager.getInstance().onError(a2, e2);
                abVar = null;
            }
            TNCManager.getInstance().onResponse(a2, abVar);
            return abVar == null ? aVar.a(a2) : abVar;
        }
        return (ab) invokeL.objValue;
    }
}
