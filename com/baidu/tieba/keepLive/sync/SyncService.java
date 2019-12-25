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
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.keepLive.nativekeepalive.GuardServiceObserver;
/* loaded from: classes5.dex */
public class SyncService extends Service {
    private static final Object syncLock = new Object();
    private static a syncAdapter = null;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            TiebaStatic.log(CommonStatisticKey.KEY_KEEP_LIVE);
        } catch (Throwable th) {
        }
        TbadkCoreApplication.getInst();
        if (TbadkCoreApplication.getKeepLiveSwitch(this)) {
            try {
                if (Build.VERSION.SDK_INT >= 23) {
                    com.baidu.tbadk.lcs.a.d(0, 0, 0, 1, 5);
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
            } catch (Throwable th2) {
                com.baidu.tbadk.lcs.a.d(0, 0, 0, 1, 5);
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

    /* loaded from: classes5.dex */
    class a extends AbstractThreadedSyncAdapter {
        public a(Context context, boolean z) {
            super(context, z);
        }

        @Override // android.content.AbstractThreadedSyncAdapter
        public void onPerformSync(Account account, Bundle bundle, String str, ContentProviderClient contentProviderClient, SyncResult syncResult) {
        }
    }

    public static void startAccountSync(Context context) {
        Account account = new Account("tiebaAccountSync", "com.baidu.tieba");
        if (((AccountManager) context.getSystemService("account")).addAccountExplicitly(account, null, null)) {
            ContentResolver.setIsSyncable(account, "com.baidu.tieba", 1);
            ContentResolver.setSyncAutomatically(account, "com.baidu.tieba", true);
            ContentResolver.addPeriodicSync(account, "com.baidu.tieba", new Bundle(), 900L);
        }
    }

    private static void removeAccountExplicitlyForLive(Context context, Account account) {
        if (account != null) {
            AccountManager.get(context).removeAccount(account, null, null);
        }
    }

    private void removeAccount(Context context) {
        ((AccountManager) context.getSystemService("account")).removeAccount(new Account("tiebaAccountSync", "com.baidu.tieba"), null, null);
    }
}
