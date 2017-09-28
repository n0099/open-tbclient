package com.baidu.tieba.keepLive.sync;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Service;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SyncResult;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tieba.keepLive.nativekeepalive.GuardServiceObserver;
/* loaded from: classes2.dex */
public class SyncService extends Service {
    private static final Object syncLock = new Object();
    private static a syncAdapter = null;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        TbadkCoreApplication.getInst();
        if (TbadkCoreApplication.getKeepLiveSwitch(this)) {
            try {
                if (Build.VERSION.SDK_INT >= 23) {
                    BdSocketLinkService.startService(false, "restart");
                } else {
                    GuardServiceObserver.startNativeServiceForUnder23(this);
                }
                synchronized (syncLock) {
                    if (syncAdapter == null) {
                        syncAdapter = new a(getApplicationContext(), true);
                    }
                }
                return;
            } catch (Throwable th) {
                BdSocketLinkService.startService(false, "restart");
                return;
            }
        }
        removeAccount(this);
        stopSelf();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (syncAdapter != null) {
            return syncAdapter.getSyncAdapterBinder();
        }
        return null;
    }

    /* loaded from: classes2.dex */
    class a extends AbstractThreadedSyncAdapter {
        public a(Context context, boolean z) {
            super(context, z);
        }

        @Override // android.content.AbstractThreadedSyncAdapter
        public void onPerformSync(Account account, Bundle bundle, String str, ContentProviderClient contentProviderClient, SyncResult syncResult) {
        }
    }

    public static void startAccountSync(Context context) {
        Account account = new Account("tiebaAccountSync", TbConfig.MAIN_PACKAGE_NAME);
        if (((AccountManager) context.getSystemService(LoginActivityConfig.ACCOUNT)).addAccountExplicitly(account, null, null)) {
            ContentResolver.setIsSyncable(account, TbConfig.MAIN_PACKAGE_NAME, 1);
            ContentResolver.setSyncAutomatically(account, TbConfig.MAIN_PACKAGE_NAME, true);
            ContentResolver.addPeriodicSync(account, TbConfig.MAIN_PACKAGE_NAME, new Bundle(), 900L);
        }
    }

    private static void removeAccountExplicitlyForLive(Context context, Account account) {
        if (account != null) {
            AccountManager.get(context).removeAccount(account, null, null);
        }
    }

    private void removeAccount(Context context) {
        ((AccountManager) context.getSystemService(LoginActivityConfig.ACCOUNT)).removeAccount(new Account("tiebaAccountSync", TbConfig.MAIN_PACKAGE_NAME), null, null);
    }
}
