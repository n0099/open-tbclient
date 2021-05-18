package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseService;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.VersionData;
import d.a.k0.l;
/* loaded from: classes5.dex */
public class AsInstallService extends BdBaseService {
    public static final int AS_INSTALL_RECEIVING_DURATION_MILLS = 120000;
    public static final String SCHEME_PACKAGE_ADDED = "package";
    public static boolean sIsReceiving;
    public Handler mHandler;
    public b mReceiver;
    public Runnable mStopReceivingRunnable;
    public VersionData mVersionData;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AsInstallService.this.stopSelf();
        }
    }

    /* loaded from: classes5.dex */
    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(PackageChangedReceiver.ACTION_INSTALL)) {
                String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                if (TextUtils.isEmpty(schemeSpecificPart) || !"com.baidu.appsearch".equals(schemeSpecificPart) || AsInstallService.this.mVersionData == null) {
                    return;
                }
                l.b(context, AsInstallService.this.mVersionData);
                TiebaStatic.log(TbadkCoreStatisticKey.INVOKE_AS);
            }
        }

        public /* synthetic */ b(AsInstallService asInstallService, a aVar) {
            this();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mReceiver = new b(this, null);
        this.mHandler = new Handler();
        this.mStopReceivingRunnable = new a();
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
    public void onStart(Intent intent, int i2) {
        super.onStart(intent, i2);
        if (sIsReceiving) {
            return;
        }
        sIsReceiving = true;
        if (intent != null) {
            this.mVersionData = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
        }
        this.mReceiver = new b(this, null);
        IntentFilter intentFilter = new IntentFilter(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter.addDataScheme(SCHEME_PACKAGE_ADDED);
        registerReceiver(this.mReceiver, intentFilter);
        Handler handler = new Handler();
        this.mHandler = handler;
        handler.postDelayed(this.mStopReceivingRunnable, AppConfig.TIMESTAMP_AVAILABLE_DURATION);
    }
}
