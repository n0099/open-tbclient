package com.baidu.tieba;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.service.YYPayService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class qt8 implements YYPayService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements bs5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYPayService.YYPayResultCallback a;

        public a(qt8 qt8Var, YYPayService.YYPayResultCallback yYPayResultCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qt8Var, yYPayResultCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yYPayResultCallback;
        }

        @Override // com.baidu.tieba.bs5
        public void onFail(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                this.a.onFail(i, str);
            }
        }

        @Override // com.baidu.tieba.bs5
        public void onSuccess(hs5 hs5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hs5Var) == null) {
                if (hs5Var != null) {
                    YYPayService.YYPayResultMessage yYPayResultMessage = new YYPayService.YYPayResultMessage();
                    yYPayResultMessage.setStatus(hs5Var.g);
                    yYPayResultMessage.setAppid(hs5Var.b);
                    yYPayResultMessage.setUid(hs5Var.h.longValue());
                    yYPayResultMessage.setUsedChannel(hs5Var.i);
                    yYPayResultMessage.setCurrencyType(hs5Var.d);
                    yYPayResultMessage.setAmount(hs5Var.a.longValue());
                    yYPayResultMessage.setCurrencyAmount(hs5Var.c.longValue());
                    yYPayResultMessage.setOrderId(hs5Var.f);
                    yYPayResultMessage.setExpand(hs5Var.e);
                    this.a.onSuccess(yYPayResultMessage);
                    return;
                }
                this.a.onSuccess(null);
            }
        }
    }

    public qt8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.YYPayService
    public void startPayment(Context context, YYPayService.YYPayResultCallback yYPayResultCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, yYPayResultCallback) == null) {
            startPayment(context, null, yYPayResultCallback);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.YYPayService
    public void startPayment(Context context, String str, YYPayService.YYPayResultCallback yYPayResultCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, yYPayResultCallback) == null) {
            startPayment(context, str, 0L, yYPayResultCallback);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.YYPayService
    public void startPayment(Context context, String str, Long l, YYPayService.YYPayResultCallback yYPayResultCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, l, yYPayResultCallback) == null) {
            MessageManager.getInstance().runTask(2921546, String.class, new gs5(context, 1, str, l, new a(this, yYPayResultCallback)));
        }
    }
}
