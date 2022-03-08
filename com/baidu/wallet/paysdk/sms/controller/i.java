package com.baidu.wallet.paysdk.sms.controller;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ISmsController a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i2)) == null) {
            if (i2 != 0) {
                if (i2 == 1) {
                    return new e();
                }
                if (i2 == 2) {
                    return new d();
                }
                if (i2 == 5) {
                    return new f();
                }
                if (i2 == 6) {
                    ISmsController[] iSmsControllerArr = {null};
                    LocalRouter.getInstance(null).route(null, new RouterRequest().provider("hce").action("getsmscontroller"), new RouterCallback(iSmsControllerArr) { // from class: com.baidu.wallet.paysdk.sms.controller.i.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ISmsController[] a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {iSmsControllerArr};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.a = iSmsControllerArr;
                        }

                        @Override // com.baidu.wallet.router.RouterCallback
                        public void onResult(int i3, HashMap hashMap) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, hashMap) == null) {
                                if (i3 == 0 || hashMap != null) {
                                    Object obj = hashMap.get("value");
                                    if (obj == null || !(obj instanceof ISmsController)) {
                                        return;
                                    }
                                    this.a[0] = (ISmsController) obj;
                                } else if (i3 == 5) {
                                    HashMap hashMap2 = new HashMap();
                                    hashMap2.put("provider", "hce");
                                    hashMap2.put("action", "getsmscontroller");
                                    StatisticManager.onEventEndWithValues("sdk_router_error", i3, hashMap2.values());
                                }
                            }
                        }
                    });
                    return iSmsControllerArr[0];
                } else if (i2 != 7) {
                    if (i2 == 8 || i2 == 10) {
                        return new b();
                    }
                    return null;
                }
            }
            return new c();
        }
        return (ISmsController) invokeI.objValue;
    }
}
