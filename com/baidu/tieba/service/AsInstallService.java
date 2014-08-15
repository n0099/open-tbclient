package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.game.GameInstallReceiver;
/* loaded from: classes.dex */
public class AsInstallService extends Service {
    private static final int AS_INSTALL_RECEIVING_DURATION_MILLS = 120000;
    private static final String SCHEME_PACKAGE_ADDED = "package";
    private static boolean sIsReceiving;
    private Handler mHandler;
    private b mReceiver;
    private Runnable mStopReceivingRunnable;
    private VersionData mVersionData;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mReceiver = new b(this, null);
        this.mHandler = new Handler();
        this.mStopReceivingRunnable = new a(this);
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (!sIsReceiving) {
            sIsReceiving = true;
            if (intent != null) {
                this.mVersionData = (VersionData) intent.getSerializableExtra("tieba_apk_data");
            }
            this.mReceiver = new b(this, null);
            IntentFilter intentFilter = new IntentFilter(GameInstallReceiver.ACTION_INSTALL);
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
}
