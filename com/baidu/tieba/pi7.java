package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.pay.IPayCallback;
import com.baidu.searchbox.live.interfaces.pay.IPayChannel;
import com.baidu.searchbox.live.interfaces.pay.PayChannelType;
import com.baidu.searchbox.live.interfaces.pay.YYPayResultService;
import com.baidu.searchbox.live.interfaces.service.PayChannelService;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.wallet.ITiebaPay;
import com.baidu.tieba.wallet.ITiebaPayCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class pi7 implements PayChannelService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ITiebaPay a;

    /* loaded from: classes5.dex */
    public class a implements IPayChannel {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pi7 a;

        /* renamed from: com.baidu.tieba.pi7$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0371a implements ITiebaPayCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ IPayCallback a;

            public C0371a(a aVar, IPayCallback iPayCallback) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, iPayCallback};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = iPayCallback;
            }

            @Override // com.baidu.tieba.wallet.ITiebaPayCallback
            public void onPayResult(int i, String str) {
                IPayCallback iPayCallback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) || (iPayCallback = this.a) == null) {
                    return;
                }
                iPayCallback.onPayResult(i, str);
            }
        }

        public a(pi7 pi7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pi7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pi7Var;
        }

        @Override // com.baidu.searchbox.live.interfaces.pay.IPayChannel
        public PayChannelType getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? PayChannelType.WALLET : (PayChannelType) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.live.interfaces.pay.IPayChannel
        public String getUaForFrontPay() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return yf5.b() + " (Baidu; P1 " + Build.VERSION.RELEASE + SmallTailInfo.EMOTION_SUFFIX;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.live.interfaces.pay.IPayChannel
        public void onPayResult(String str, String str2, String str3, Context context, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, str3, context, Boolean.valueOf(z)}) == null) {
            }
        }

        @Override // com.baidu.searchbox.live.interfaces.pay.IPayChannel
        public void pay(Activity activity, HashMap<String, String> hashMap, IPayCallback iPayCallback) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048579, this, activity, hashMap, iPayCallback) == null) || hashMap == null || hashMap.isEmpty()) {
                return;
            }
            this.a.c();
            if (this.a.a != null) {
                this.a.a.pay(hashMap.remove("channel"), hashMap, new C0371a(this, iPayCallback));
            } else if (iPayCallback != null) {
                iPayCallback.onPayResult(2, null);
            }
        }

        @Override // com.baidu.searchbox.live.interfaces.pay.IPayChannel
        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }
    }

    public pi7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.PayChannelService
    public IPayChannel buildPayChannel(PayChannelType payChannelType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, payChannelType)) == null) {
            if (payChannelType == PayChannelType.WALLET) {
                return new a(this);
            }
            return null;
        }
        return (IPayChannel) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.PayChannelService
    public YYPayResultService buildYYPayResChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (YYPayResultService) invokeV.objValue;
    }

    public final void c() {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a == null && (runTask = MessageManager.getInstance().runTask(2921432, ITiebaPay.class)) != null) {
            this.a = (ITiebaPay) runTask.getData();
        }
    }
}
