package com.baidu.wallet.passport;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.utils.LogUtil;
/* loaded from: classes5.dex */
public class PassLoginDialogUtil implements NoProguard {

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static PassLoginDialogUtil f25061a = new PassLoginDialogUtil();
    }

    public static PassLoginDialogUtil getInstance() {
        return a.f25061a;
    }

    public void showLoginTipDialog(Context context, final ILoginBackListener iLoginBackListener, final int i2, final String str) {
        if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
            final PromptDialog promptDialog = new PromptDialog(context);
            promptDialog.setMessage(ResUtils.getString(context, "wallet_base_open_bduss_system_error"));
            promptDialog.setNegativeBtn(ResUtils.getString(context, "wallet_base_open_bduss_system_error_retry"), new View.OnClickListener() { // from class: com.baidu.wallet.passport.PassLoginDialogUtil.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        promptDialog.dismiss();
                    } catch (Exception e2) {
                        LogUtil.e("PassLoginDialog", "dialog Exception", e2);
                    }
                    ILoginBackListener iLoginBackListener2 = iLoginBackListener;
                    if (!(iLoginBackListener2 instanceof LoginBackListenerProxy) || ((LoginBackListenerProxy) iLoginBackListener2).getLoginBackListener() == null) {
                        return;
                    }
                    ((LoginBackListenerProxy) iLoginBackListener).getLoginBackListener().onFail(i2, str);
                }
            });
            promptDialog.setPositiveBtn(ResUtils.getString(context, "wallet_base_open_bduss_system_error_login"), new View.OnClickListener() { // from class: com.baidu.wallet.passport.PassLoginDialogUtil.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        promptDialog.dismiss();
                    } catch (Exception e2) {
                        LogUtil.e("PassLoginDialog", "dialog Exception", e2);
                    }
                    WalletLoginHelper.getInstance().onlyLogin(iLoginBackListener);
                }
            });
            promptDialog.show();
            return;
        }
        if (context != null) {
            GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_open_bduss_network_resolve_error"));
        }
        if (iLoginBackListener instanceof LoginBackListenerProxy) {
            LoginBackListenerProxy loginBackListenerProxy = (LoginBackListenerProxy) iLoginBackListener;
            if (loginBackListenerProxy.getLoginBackListener() != null) {
                loginBackListenerProxy.getLoginBackListener().onFail(i2, str);
            }
        }
    }

    public PassLoginDialogUtil() {
    }
}
