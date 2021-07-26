package com.bytedance.sdk.component.net.tnc;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.b.ab;
import com.bytedance.sdk.component.b.b.u;
import com.bytedance.sdk.component.b.b.z;
import java.io.IOException;
/* loaded from: classes5.dex */
public class TncHostInterceptor implements u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mAid;

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
            if (TncInstanceManager.getInstance().getTNCManager(this.mAid).getAppConfig() != null) {
                TncInstanceManager.getInstance().getTNCManager(this.mAid).getAppConfig().tryLodeConfigInSubThread();
            }
            String tVar = a2.a().toString();
            String handleHostMapping = TncInstanceManager.getInstance().getTNCManager(this.mAid).handleHostMapping(tVar);
            if (!tVar.equals(handleHostMapping)) {
                a2 = a2.f().a(handleHostMapping).d();
            }
            try {
                abVar = aVar.a(a2);
            } catch (Exception e2) {
                TncInstanceManager.getInstance().getTNCManager(this.mAid).onError(a2, e2);
                abVar = null;
            }
            TncInstanceManager.getInstance().getTNCManager(this.mAid).onResponse(a2, abVar);
            return abVar == null ? aVar.a(a2) : abVar;
        }
        return (ab) invokeL.objValue;
    }

    public void setAid(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.mAid = i2;
        }
    }
}
