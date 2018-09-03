package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseService;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class AsInstallService extends BdBaseService {
    private static final int AS_INSTALL_RECEIVING_DURATION_MILLS = 120000;
    private static final String SCHEME_PACKAGE_ADDED = "package";
    private static boolean sIsReceiving;
    private Handler mHandler;
    private a mReceiver;
    private Runnable mStopReceivingRunnable;
    private VersionData mVersionData;

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mReceiver = new a();
        this.mHandler = new Handler();
        this.mStopReceivingRunnable = new Runnable() { // from class: com.baidu.tieba.service.AsInstallService.1
            @Override // java.lang.Runnable
            public void run() {
                AsInstallService.this.stopSelf();
            }
        };
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (!sIsReceiving) {
            sIsReceiving = true;
            if (intent != null) {
                this.mVersionData = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
            }
            this.mReceiver = new a();
            IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
            intentFilter.addDataScheme(SCHEME_PACKAGE_ADDED);
            registerReceiver(this.mReceiver, intentFilter);
            this.mHandler = new Handler();
            this.mHandler.postDelayed(this.mStopReceivingRunnable, 120000L);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.mReceiver);
        this.mHandler.removeCallbacks(this.mStopReceivingRunnable);
        this.mReceiver = null;
        this.mHandler = null;
        this.mStopReceivingRunnable = null;
        sIsReceiving = false;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    /* loaded from: classes.dex */
    private class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
                String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                if (!TextUtils.isEmpty(schemeSpecificPart) && "com.baidu.appsearch".equals(schemeSpecificPart) && AsInstallService.this.mVersionData != null) {
                    i.a(context, AsInstallService.this.mVersionData);
                    TiebaStatic.log("c10007");
                }
            }
        }
    }
}
