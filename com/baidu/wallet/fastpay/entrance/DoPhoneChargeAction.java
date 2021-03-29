package com.baidu.wallet.fastpay.entrance;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.fastpay.ui.ChargeActivity;
import com.baidu.wallet.passport.LoginBackListenerProxy;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class DoPhoneChargeAction implements RouterAction {

    /* renamed from: a  reason: collision with root package name */
    public LoginBackListenerProxy f24365a;

    @Override // com.baidu.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        HashMap hashMap2 = new HashMap();
        if (context == null || hashMap == null) {
            if (routerCallback != null) {
                hashMap2.put("desc", "params_invalid");
                routerCallback.onResult(3, hashMap2);
                return;
            }
            return;
        }
        a(context, Boolean.parseBoolean((String) hashMap.get("withAnim")));
        if (routerCallback != null) {
            hashMap2.put("value", "success");
            routerCallback.onResult(0, hashMap2);
        }
    }

    private void a(final Context context, final boolean z) {
        if (!NetworkUtils.isNetworkAvailable(context)) {
            GlobalUtils.toast(context, ResUtils.getString(context, "ebpay_no_network"));
        } else if (LocalRouter.getInstance(context).isProviderExisted(BaiduWalletServiceProviderMap.PLUGIN_FASTPAY)) {
            final Intent intent = new Intent();
            intent.setClass(context, ChargeActivity.class);
            if (context instanceof Activity) {
                LogUtil.d("DoPhoneChargeAction", "context is activity!");
            } else {
                intent.setFlags(268435456);
            }
            this.f24365a = new LoginBackListenerProxy(context, new ILoginBackListener() { // from class: com.baidu.wallet.fastpay.entrance.DoPhoneChargeAction.1
                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i, String str) {
                    if (i == 603) {
                        WalletLoginHelper.getInstance().onlyLogin(DoPhoneChargeAction.this.f24365a);
                        return;
                    }
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
            });
            WalletLoginHelper.getInstance().verifyPassLogin(true, this.f24365a);
        }
    }
}
