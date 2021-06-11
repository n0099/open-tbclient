package com.baidu.wallet.base.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.BaiduWalletServiceController;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.passport.LoginBackListenerProxy;
/* loaded from: classes5.dex */
public class SDKJumpManager {

    /* renamed from: a  reason: collision with root package name */
    public LoginBackListenerProxy f23613a;

    /* loaded from: classes5.dex */
    public interface OnJumpListener {
        void beforeJump(Context context, String str, String str2, String str3, boolean z);
    }

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static SDKJumpManager f23618a = new SDKJumpManager();
    }

    public static SDKJumpManager getInstance() {
        return a.f23618a;
    }

    public void doSDKJump(final Context context, String str, String str2, final String str3, boolean z, OnJumpListener onJumpListener) {
        if (onJumpListener != null) {
            onJumpListener.beforeJump(context, str, str2, str3, z);
        }
        if ("3".equals(str2) && !TextUtils.isEmpty(str3)) {
            BaiduWalletServiceController.getInstance().gotoWalletService(context, str3, "");
        } else if ("1".equals(str2) && !TextUtils.isEmpty(str3)) {
            if (!NetworkUtils.isNetworkAvailable(context)) {
                GlobalUtils.toast(context, ResUtils.getString(context, "ebpay_no_network"));
            } else if (z) {
                this.f23613a = new LoginBackListenerProxy(context, new ILoginBackListener() { // from class: com.baidu.wallet.base.widget.SDKJumpManager.1
                    @Override // com.baidu.wallet.api.ILoginBackListener
                    public void onFail(int i2, String str4) {
                        if (i2 == 603) {
                            WalletLoginHelper.getInstance().onlyLogin(SDKJumpManager.this.f23613a);
                        }
                    }

                    @Override // com.baidu.wallet.api.ILoginBackListener
                    public void onSuccess(int i2, String str4) {
                        BaiduWalletDelegate.getInstance().openH5Module(context, str3, true);
                    }
                });
                WalletLoginHelper.getInstance().login(this.f23613a);
            } else {
                BaiduWalletDelegate.getInstance().openH5Module(context, str3, true);
            }
        } else if ("2".equals(str2) && !TextUtils.isEmpty(str3)) {
            if (!NetworkUtils.isNetworkAvailable(context)) {
                GlobalUtils.toast(context, ResUtils.getString(context, "ebpay_no_network"));
            } else {
                WalletLoginHelper.getInstance().startPage(str3);
            }
        } else if ("4".equals(str2) && !TextUtils.isEmpty(str3)) {
            BaiduWalletDelegate.getInstance().invokeHostNative(str3, "");
        } else if ("5".equals(str2)) {
            this.f23613a = new LoginBackListenerProxy(context, new ILoginBackListener() { // from class: com.baidu.wallet.base.widget.SDKJumpManager.2
                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str4) {
                    if (i2 == 603) {
                        WalletLoginHelper.getInstance().onlyLogin(SDKJumpManager.this.f23613a);
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str4) {
                }
            });
            WalletLoginHelper.getInstance().login(this.f23613a);
        } else if (!"6".equals(str2) || a(context, str3)) {
        } else {
            GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_string_service_forbidden"));
        }
    }

    public SDKJumpManager() {
    }

    private boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        if (intent.resolveActivity(context.getPackageManager()) == null) {
            return false;
        }
        if (!(context instanceof Activity)) {
            intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        context.startActivity(intent);
        return true;
    }
}
