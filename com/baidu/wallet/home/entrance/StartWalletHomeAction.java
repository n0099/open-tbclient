package com.baidu.wallet.home.entrance;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.home.WalletNewHomeActivity;
import com.baidu.wallet.home.beans.HomeCfgBean;
import com.baidu.wallet.passport.LoginBackListenerProxy;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class StartWalletHomeAction implements RouterAction {
    public static final String BEAN_TAG = "StartWalletHomeAction";

    private void a(final Context context, final boolean z, boolean z2) {
        final Intent intent = new Intent();
        intent.setClass(context, WalletNewHomeActivity.class);
        if (context instanceof Activity) {
            LogUtil.d(BEAN_TAG, "context is activity!");
        } else {
            intent.setFlags(268435456);
        }
        intent.putExtra("pageType", z2 ? HomeCfgBean.PAGE_CREDIT : HomeCfgBean.PAGE_HOME);
        intent.putExtra("with_anim", z);
        WalletLoginHelper.getInstance().verifyPassLogin(true, new LoginBackListenerProxy(context, new ILoginBackListener() { // from class: com.baidu.wallet.home.entrance.StartWalletHomeAction.1
            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i, String str) {
                Context context2;
                if (i == 603 && (context2 = context) != null) {
                    GlobalUtils.toast(context2, ResUtils.getString(context2, "wallet_home_login_invalid_dialog_tips"));
                }
                context.startActivity(intent);
                Context context3 = context;
                if (context3 instanceof Activity) {
                    if (z) {
                        BaiduWalletUtils.startActivityAnim(context3);
                    } else {
                        BaiduWalletUtils.overridePendingTransitionNoAnim((Activity) context3);
                    }
                }
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i, String str) {
                context.startActivity(intent);
                Context context2 = context;
                if (context2 instanceof Activity) {
                    if (z) {
                        BaiduWalletUtils.startActivityAnim(context2);
                    } else {
                        BaiduWalletUtils.overridePendingTransitionNoAnim((Activity) context2);
                    }
                }
            }
        }));
    }

    @Override // com.baidu.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        if (a(context, hashMap, routerCallback)) {
            return;
        }
        a(context, Boolean.parseBoolean((String) hashMap.get("withAnim")), Boolean.parseBoolean((String) hashMap.get("pageType")));
        if (routerCallback != null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("desc", "success");
            routerCallback.onResult(0, hashMap2);
        }
    }

    private boolean a(Context context, HashMap hashMap, RouterCallback routerCallback) {
        if (context == null || hashMap == null || !hashMap.containsKey("withAnim")) {
            if (routerCallback != null) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("errorMsg", "params-error");
                routerCallback.onResult(3, hashMap2);
                return true;
            }
            return true;
        }
        return false;
    }
}
