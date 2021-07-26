package com.baidu.wallet.api;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.pay.BindBack;
import com.baidu.android.pay.PayCallBack;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.BaiduWalletServiceController;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
import com.baidu.wallet.core.utils.ReflectUtils;
import com.baidu.wallet.rnauth.RNAuthCallBack;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterProvider;
import java.lang.reflect.Proxy;
import java.util.Map;
/* loaded from: classes5.dex */
public final class BaiduWallet implements IWalletFacade {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.wallet.api.BaiduWallet$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final IWalletFacade f24025a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(73660391, "Lcom/baidu/wallet/api/BaiduWallet$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(73660391, "Lcom/baidu/wallet/api/BaiduWallet$a;");
                    return;
                }
            }
            f24025a = (IWalletFacade) Proxy.newProxyInstance(BaiduWallet.class.getClassLoader(), new Class[]{IWalletFacade.class}, new WalletFacadeAOP(new BaiduWallet(null)));
        }
    }

    public /* synthetic */ BaiduWallet(AnonymousClass1 anonymousClass1) {
        this();
    }

    private void a(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, application) == null) {
            DxmPay.getInstance().initWallet(application);
            Object providerObject = ReflectUtils.getProviderObject("com.baidu.wallet.fastpay.entrance.FastPayProvider");
            if (providerObject != null && (providerObject instanceof RouterProvider)) {
                LocalRouter.getInstance(application).registerProvider(BaiduWalletServiceProviderMap.PLUGIN_FASTPAY, (RouterProvider) providerObject);
            }
            Object providerObject2 = ReflectUtils.getProviderObject("com.baidu.wallet.qrcodescanner.entrance.QrcodeScannerProvider");
            if (providerObject2 != null && (providerObject2 instanceof RouterProvider)) {
                LocalRouter.getInstance(application).registerProvider(BaiduWalletServiceProviderMap.PLUGIN_QRCODESCANNER, (RouterProvider) providerObject2);
            }
            Object providerObject3 = ReflectUtils.getProviderObject("com.baidu.wallet.home.entrance.EnterWalletHomeProvider");
            if (providerObject3 != null && (providerObject3 instanceof RouterProvider)) {
                LocalRouter.getInstance(application).registerProvider(BaiduWalletServiceProviderMap.PLUGIN_WALLETHOME, (RouterProvider) providerObject3);
            }
            Object providerObject4 = ReflectUtils.getProviderObject("com.baidu.wallet.personal.entrance.PersonalProvider");
            if (providerObject4 != null && (providerObject4 instanceof RouterProvider)) {
                LocalRouter.getInstance(application).registerProvider(BaiduWalletServiceProviderMap.PLUGIN_PERSONAL, (RouterProvider) providerObject4);
            }
            Object providerObject5 = ReflectUtils.getProviderObject("com.baidu.wallet.lightapp.entrance.LangbrigeProvider");
            if (providerObject5 == null || !(providerObject5 instanceof RouterProvider)) {
                return;
            }
            LocalRouter.getInstance(application).registerProvider(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE, (RouterProvider) providerObject5);
        }
    }

    public static IWalletFacade getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.f24025a : (IWalletFacade) invokeV.objValue;
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void accessWalletEntry(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, str) == null) {
            BaiduPayDelegate.getInstance().accessWalletEntry(context, str);
        }
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void callQRCodeScanner(Context context, IWalletQRScannerCallback iWalletQRScannerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, iWalletQRScannerCallback) == null) {
            BaiduWalletDelegate.getInstance().callQRCodeScanner(context, iWalletQRScannerCallback);
        }
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void changePayMethod(Activity activity, String str, @NonNull IPrecashierCallback iPrecashierCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, activity, str, iPrecashierCallback) == null) {
            BaiduPayDelegate.getInstance().changePayMethod(activity, str, iPrecashierCallback);
        }
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void checkPwd(Context context, CheckCallBack checkCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, checkCallBack) == null) {
            BaiduPayDelegate.getInstance().checkPwd(context, checkCallBack);
        }
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void doBind(Context context, BindBack bindBack, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, context, bindBack, map) == null) {
            BaiduPayDelegate.getInstance().doBind(context, bindBack, map);
        }
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void doBindCardIndependent(Context context, BindBack bindBack, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, context, bindBack, str) == null) {
            BaiduPayDelegate.getInstance().doBindCardIndependent(context, bindBack, str);
        }
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void doCheckPwd(Context context, Map<String, String> map, CheckCallBack checkCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, context, map, checkCallBack) == null) {
            BaiduPayDelegate.getInstance().doCheckPwd(context, map, checkCallBack);
        }
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void doPay(Context context, String str, PayCallBack payCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, context, str, payCallBack) == null) {
            BaiduPayDelegate.getInstance().doPay(context, str, payCallBack);
        }
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void doRNAuth(Context context, Map<String, String> map, RNAuthCallBack rNAuthCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, context, map, rNAuthCallBack) == null) {
            BaiduPayDelegate.getInstance().doRNAuth(context, map, rNAuthCallBack);
        }
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public String getBindUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) ? BaiduWalletDelegate.getInstance().getBindUrl(str) : (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void getPayMethod(Context context, String str, IPrecashierCallback iPrecashierCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, context, str, iPrecashierCallback) == null) {
            BaiduPayDelegate.getInstance().getPayMethod(context, str, iPrecashierCallback);
        }
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public String getWalletOuterInterface(Context context, IWalletOuterInterfaceListener iWalletOuterInterfaceListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, context, iWalletOuterInterfaceListener)) == null) ? BaiduPayDelegate.getInstance().getWalletOuterInterface(context, iWalletOuterInterfaceListener) : (String) invokeLL.objValue;
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void gotoWalletService(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, context, str, str2) == null) {
            BaiduWalletServiceController.getInstance().gotoWalletService(context, str, str2);
        }
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void initWallet(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, context) == null) {
            a((Application) context.getApplicationContext());
            BaiduWalletDelegate.getInstance().initWallet(context);
        }
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void logout(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, context) == null) {
            BaiduWalletDelegate.getInstance().logout(context);
        }
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void openH5Module(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048595, this, context, str, z) == null) {
            BaiduWalletDelegate.getInstance().openH5Module(context, str, z);
        }
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void preOrderPay(Context context, String str, IPrecashierCallback iPrecashierCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048597, this, context, str, iPrecashierCallback) == null) {
            BaiduPayDelegate.getInstance().preOrderPay(context, str, iPrecashierCallback);
        }
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void setDebugOn(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048598, this, context, z) == null) {
            BaiduWalletDelegate.getInstance().setDebugOn(context, z);
        }
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public boolean startWallet(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, context)) == null) ? BaiduWalletDelegate.getInstance().startWallet(context) : invokeL.booleanValue;
    }

    public BaiduWallet() {
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

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void doPay(Context context, String str, PayCallBack payCallBack, @NonNull Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, str, payCallBack, map) == null) {
            BaiduPayDelegate.getInstance().doPay(context, str, payCallBack, map);
        }
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void openH5Module(Context context, String str, boolean z, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{context, str, Boolean.valueOf(z), bundle}) == null) {
            BaiduWalletDelegate.getInstance().openH5Module(context, str, z, bundle);
        }
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void initWallet(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, context, str) == null) {
            a((Application) context.getApplicationContext());
            BaiduWalletDelegate.getInstance().initWallet(context, str);
        }
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void initWallet(IWalletListener iWalletListener, Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048592, this, iWalletListener, context, str) == null) {
            a((Application) context.getApplicationContext());
            BaiduWalletDelegate.getInstance().initWallet(iWalletListener, context, str);
        }
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void initWallet(IWalletListener iWalletListener, Context context, String str, ISecurityListener iSecurityListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048593, this, iWalletListener, context, str, iSecurityListener) == null) {
            a((Application) context.getApplicationContext());
            BaiduWalletDelegate.getInstance().initWallet(iWalletListener, context, str, iSecurityListener);
        }
    }
}
