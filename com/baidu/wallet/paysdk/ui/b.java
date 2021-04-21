package com.baidu.wallet.paysdk.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.widget.BdActionBar;
import com.baidu.wallet.passport.LoginBackListenerProxy;
/* loaded from: classes5.dex */
public class b {
    public static void a(final Context context, BdActionBar bdActionBar, final String str, String str2, final String str3, final String str4) {
        if (bdActionBar == null || TextUtils.isEmpty(str2)) {
            return;
        }
        bdActionBar.setRightImgZone2Visibility(0);
        bdActionBar.setRightImgZone2Enable(true);
        bdActionBar.setRightImgZone2Src(str2);
        bdActionBar.setRightImgZone2OnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.b.1

            /* renamed from: e  reason: collision with root package name */
            public LoginBackListenerProxy f26023e;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CheckUtils.isFastDoubleClick()) {
                    return;
                }
                if (!TextUtils.isEmpty(str4)) {
                    PayStatisticsUtil.onEvent(str4);
                }
                this.f26023e = new LoginBackListenerProxy(context, new ILoginBackListener() { // from class: com.baidu.wallet.paysdk.ui.b.1.1
                    @Override // com.baidu.wallet.api.ILoginBackListener
                    public void onFail(int i, String str5) {
                        if (i == 603) {
                            WalletLoginHelper.getInstance().onlyLogin(AnonymousClass1.this.f26023e);
                        }
                    }

                    @Override // com.baidu.wallet.api.ILoginBackListener
                    public void onSuccess(int i, String str5) {
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        BaiduWalletDelegate baiduWalletDelegate = BaiduWalletDelegate.getInstance();
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        baiduWalletDelegate.openH5Module(context, str, str3, true, false);
                    }
                });
                WalletLoginHelper.getInstance().login(this.f26023e);
            }
        });
    }
}
