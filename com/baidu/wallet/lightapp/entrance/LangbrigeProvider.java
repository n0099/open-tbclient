package com.baidu.wallet.lightapp.entrance;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.router.RouterProvider;
/* loaded from: classes8.dex */
public class LangbrigeProvider extends RouterProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public LangbrigeProvider() {
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

    @Override // com.baidu.wallet.router.RouterProvider
    public void registerActions() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            registerAction("langbrige_init", new InitLangBrigeAction());
            registerAction("langbrige_start", new StartLangbrigeAction());
            registerAction("langbrige_getMethodList", new GetMethodListAction());
            registerAction("langbrige_invoke", new LangbrigeInvokeAction());
            registerAction("langbrige_setJsNameVerfiy", new SetJsNameVerifyAction());
            registerAction("langbrige_getStartIntent", new GetStartIntentAction());
            registerAction("langbrige_initWebView", new InitWebViewAction());
            registerAction("langbrige_initWebViewPool", new InitWebviewPoolAction());
            registerAction("langbrige_offlineCacheConfig", new OfflineCacheConfigAction());
            registerAction("langbrige_updateSettings", new LangbridgeSettingAction());
            registerAction("langbrige_removeLifeCycleCb", new RemoveH5LifeCycleCbAction());
            registerAction("langbrige_getToImapctJsFiles", new ConfigImapctJsAction());
            registerAction("langbridge_openPoll", new LangbridgeOpenPollAction());
            registerAction("langbrige_invokeNativeAbility", new InvokeNativeAbilityAction());
        }
    }
}
