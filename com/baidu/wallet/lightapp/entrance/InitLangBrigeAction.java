package com.baidu.wallet.lightapp.entrance;

import android.content.Context;
import com.baidu.wallet.api.IWalletListener;
import com.baidu.wallet.lightapp.base.LightAppWrapper;
import com.baidu.wallet.lightapp.business.BaseLightAppImpl;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class InitLangBrigeAction implements RouterAction {
    @Override // com.baidu.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        IWalletListener iWalletListener;
        if (hashMap != null && (iWalletListener = (IWalletListener) hashMap.get("wallet_listener")) != null) {
            LightAppWrapper.getInstance().initLightApp(iWalletListener);
        } else {
            LightAppWrapper.getInstance().initLightApp(new BaseLightAppImpl());
        }
    }
}
