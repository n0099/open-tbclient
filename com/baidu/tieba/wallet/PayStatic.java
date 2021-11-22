package com.baidu.tieba.wallet;

import android.app.Activity;
import b.a.q0.e.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pay.PayCallBack;
import com.baidu.fsg.base.router.LocalRouter;
import com.baidu.fsg.base.utils.ResUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.wallet.pay.PayActivityStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduWallet;
import com.baidu.wallet.lightapp.base.LightAppWrapper;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IAlipayProxyCallback;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IAlipaySdkServiceProxy;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IDxmProxyCallback;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IDxmSdkServiceProxy;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IWechatProxyCallback;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IWechatSdkServiceProxy;
import tv.athena.revenue.payui.YYPayUIKit;
/* loaded from: classes9.dex */
public class PayStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-153579091, "Lcom/baidu/tieba/wallet/PayStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-153579091, "Lcom/baidu/tieba/wallet/PayStatic;");
                return;
            }
        }
        ResUtils.setApplicationContext(TbadkCoreApplication.getInst());
        YYPayUIKit.setAlipaySdkProxy(new IAlipaySdkServiceProxy() { // from class: com.baidu.tieba.wallet.PayStatic.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.yy.mobile.framework.revenuesdk.payapi.payproxy.IAlipaySdkServiceProxy
            public void sendPay(long j, Activity activity, String str, IAlipayProxyCallback iAlipayProxyCallback) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), activity, str, iAlipayProxyCallback}) == null) {
                    try {
                        a aVar = new a();
                        aVar.f12946a = activity;
                        aVar.f12947b = str;
                        aVar.f12948c = false;
                        iAlipayProxyCallback.onSuccess((String) MessageManager.getInstance().runTask(2921539, String.class, aVar).getData());
                    } catch (Exception e2) {
                        iAlipayProxyCallback.onFail(e2.getMessage());
                    }
                }
            }
        });
        YYPayUIKit.setWechatSdkProxy(new IWechatSdkServiceProxy() { // from class: com.baidu.tieba.wallet.PayStatic.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.yy.mobile.framework.revenuesdk.payapi.payproxy.IWechatSdkServiceProxy
            public void onWxPayResult(int i2, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                }
            }

            @Override // com.yy.mobile.framework.revenuesdk.payapi.payproxy.IWechatSdkServiceProxy
            public void sendPay(long j, Activity activity, String str, IWechatProxyCallback iWechatProxyCallback) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), activity, str, iWechatProxyCallback}) == null) {
                    PayActivityStatic.registerYYPayUIKitProxy(str, iWechatProxyCallback);
                }
            }
        });
        YYPayUIKit.setDxmPaySdkProxy(new IDxmSdkServiceProxy() { // from class: com.baidu.tieba.wallet.PayStatic.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.yy.mobile.framework.revenuesdk.payapi.payproxy.IDxmSdkServiceProxy
            public void sendPay(long j, Activity activity, String str, IDxmProxyCallback iDxmProxyCallback) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), activity, str, iDxmProxyCallback}) == null) {
                    PayActivityStatic.initBaiduWallet();
                    BaiduWallet.getInstance().doPay(TbadkCoreApplication.getInst(), str, new PayCallBack(this, iDxmProxyCallback) { // from class: com.baidu.tieba.wallet.PayStatic.3.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass3 this$0;
                        public final /* synthetic */ IDxmProxyCallback val$iDxmProxyCallback;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, iDxmProxyCallback};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$iDxmProxyCallback = iDxmProxyCallback;
                        }

                        @Override // com.baidu.android.pay.PayCallBack
                        public boolean isHideLoadingDialog() {
                            InterceptResult invokeV;
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || (invokeV = interceptable3.invokeV(1048576, this)) == null) {
                                return false;
                            }
                            return invokeV.booleanValue;
                        }

                        @Override // com.baidu.android.pay.PayCallBack
                        public void onPayResult(int i2, String str2) {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) {
                                this.val$iDxmProxyCallback.onSuccess(i2, str2);
                            }
                        }
                    });
                }
            }
        });
        LightAppWrapper.getInstance().initLightApp(new LightAppListenerImpl());
        try {
            LocalRouter.init(TbadkCoreApplication.getInst());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public PayStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
