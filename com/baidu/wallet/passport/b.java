package com.baidu.wallet.passport;

import android.content.Context;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.wallet.api.WalletApiExtListener;
/* loaded from: classes5.dex */
public class b implements WalletApiExtListener.LoginstatuSyncListener {
    @Override // com.baidu.wallet.api.WalletApiExtListener.LoginstatuSyncListener
    public void onHandleWalletError(int i) {
    }

    @Override // com.baidu.wallet.api.WalletApiExtListener.LoginstatuSyncListener
    public void onWebViewLogout(Context context) {
    }

    @Override // com.baidu.wallet.api.WalletApiExtListener.LoginstatuSyncListener
    public void syncLoginStatus(Context context, String str, final WalletApiExtListener.SyncLoginStatusCb syncLoginStatusCb) {
        SapiAccountManager.getInstance().getAccountService().web2NativeLogin(new Web2NativeLoginCallback() { // from class: com.baidu.wallet.passport.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.LoginStatusAware
            /* renamed from: a */
            public void onBdussExpired(Web2NativeLoginResult web2NativeLoginResult) {
                WalletApiExtListener.SyncLoginStatusCb syncLoginStatusCb2 = syncLoginStatusCb;
                if (syncLoginStatusCb2 != null) {
                    syncLoginStatusCb2.onResult(WalletApiExtListener.SyncLoginStatusCb.SyncResult.BDUSSEXPIRED);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            /* renamed from: b */
            public void onSuccess(Web2NativeLoginResult web2NativeLoginResult) {
                WalletApiExtListener.SyncLoginStatusCb syncLoginStatusCb2 = syncLoginStatusCb;
                if (syncLoginStatusCb2 != null) {
                    syncLoginStatusCb2.onResult(WalletApiExtListener.SyncLoginStatusCb.SyncResult.SUCCESS);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            /* renamed from: c */
            public void onFailure(Web2NativeLoginResult web2NativeLoginResult) {
                WalletApiExtListener.SyncLoginStatusCb syncLoginStatusCb2 = syncLoginStatusCb;
                if (syncLoginStatusCb2 != null) {
                    syncLoginStatusCb2.onResult(WalletApiExtListener.SyncLoginStatusCb.SyncResult.FAIL);
                }
            }

            @Override // com.baidu.sapi2.callback.Web2NativeLoginCallback
            public void onBdussEmpty(Web2NativeLoginResult web2NativeLoginResult) {
                WalletApiExtListener.SyncLoginStatusCb syncLoginStatusCb2 = syncLoginStatusCb;
                if (syncLoginStatusCb2 != null) {
                    syncLoginStatusCb2.onResult(WalletApiExtListener.SyncLoginStatusCb.SyncResult.BDUSSEMPTY);
                }
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onStart() {
            }
        }, true);
    }
}
