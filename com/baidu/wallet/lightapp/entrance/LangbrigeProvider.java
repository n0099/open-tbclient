package com.baidu.wallet.lightapp.entrance;

import com.baidu.wallet.router.RouterProvider;
/* loaded from: classes5.dex */
public class LangbrigeProvider extends RouterProvider {
    @Override // com.baidu.wallet.router.RouterProvider
    public void registerActions() {
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
    }
}
