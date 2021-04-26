package com.baidu.wallet.api;

import android.app.Activity;
import android.content.Context;
import java.util.Map;
/* loaded from: classes5.dex */
public interface WalletApiExtListener {

    /* loaded from: classes5.dex */
    public interface LoginstatuSyncListener {
        void onHandleWalletError(int i2);

        void onWebViewLogout(Context context);

        void syncLoginStatus(Context context, String str, SyncLoginStatusCb syncLoginStatusCb);
    }

    /* loaded from: classes5.dex */
    public interface SensorsAdapter {
        void sendPerformanceInfo(Map<String, String> map);
    }

    /* loaded from: classes5.dex */
    public interface SyncLoginStatusCb {

        /* loaded from: classes5.dex */
        public enum SyncResult {
            SUCCESS(0),
            FAIL(1),
            BDUSSEMPTY(2),
            BDUSSEXPIRED(3);
            
            public int val;

            SyncResult(int i2) {
                this.val = i2;
            }

            public int getVal() {
                return this.val;
            }
        }

        void onResult(SyncResult syncResult);
    }

    /* loaded from: classes5.dex */
    public interface ThirdPartyLoginInterface {
        void callBindPhone(Activity activity, ThirdPartyLoginListener thirdPartyLoginListener);

        void callTuristNormalize(Activity activity, ThirdPartyLoginListener thirdPartyLoginListener);
    }

    /* loaded from: classes5.dex */
    public interface ThirdPartyLoginListener {
        void onCallFail(int i2, String str);

        void onCallSuccess(int i2, String str);
    }
}
