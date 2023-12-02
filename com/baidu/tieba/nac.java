package com.baidu.tieba;

import android.os.Looper;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.gac;
import com.baidu.tieba.kac;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.hihonor.push.framework.aidl.IPushInvoke;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class nac implements kac {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger a;
    public volatile IPushInvoke b;
    public final kac.a c;
    public qac d;

    public nac(kac.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new AtomicInteger(1);
        this.c = aVar;
    }

    public final void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            Log.i("PushConnectionClient", "notifyFailed result: " + i);
            kac.a aVar = this.c;
            if (aVar != null) {
                gac.a aVar2 = (gac.a) aVar;
                aVar2.getClass();
                if (Looper.myLooper() == aVar2.f.a.getLooper()) {
                    aVar2.b(HonorPushErrorEnum.fromCode(i));
                } else {
                    aVar2.f.a.post(new fac(aVar2, i));
                }
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.a.get() != 3 && this.a.get() != 4) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
