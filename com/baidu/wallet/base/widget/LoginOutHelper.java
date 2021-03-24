package com.baidu.wallet.base.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.datamodel.AccountManager;
/* loaded from: classes5.dex */
public class LoginOutHelper {

    /* loaded from: classes5.dex */
    public interface IAfterDismissCallback {
        void onCancel();

        void onLogout();
    }

    public static void showLogoutDialog(final Context context, final IAfterDismissCallback iAfterDismissCallback) {
        final Dialog dialog = new Dialog(context, ResUtils.style(context, "EbpayPromptDialog"));
        dialog.setContentView(ResUtils.layout(context, "wallet_base_dialog_logout"));
        dialog.findViewById(ResUtils.id(context, "ebpay_logout")).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.LoginOutHelper.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dialog.dismiss();
                AccountManager.getInstance(context.getApplicationContext()).logout();
                WalletLoginHelper.getInstance().logout();
                IAfterDismissCallback iAfterDismissCallback2 = iAfterDismissCallback;
                if (iAfterDismissCallback2 != null) {
                    iAfterDismissCallback2.onLogout();
                }
            }
        });
        dialog.findViewById(ResUtils.id(context, "ebpay_cancel")).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.LoginOutHelper.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dialog.dismiss();
                IAfterDismissCallback iAfterDismissCallback2 = iAfterDismissCallback;
                if (iAfterDismissCallback2 != null) {
                    iAfterDismissCallback2.onCancel();
                }
            }
        });
        dialog.setCanceledOnTouchOutside(true);
        Window window = dialog.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = DisplayUtils.getDisplayWidth(context);
        attributes.y = (DisplayUtils.getDisplayHeight(context) - attributes.height) / 2;
        window.setAttributes(attributes);
        window.setWindowAnimations(ResUtils.style(context, "DialogWindowAnim"));
        dialog.show();
    }
}
