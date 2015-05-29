package com.baidu.tieba.live;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
/* loaded from: classes.dex */
public class LiveGroupManagerServiceChecker extends Service {
    public static final String IS_LIVE_PLUGIN_LOADED = "isLivePluginLoaded";
    public static final String LIVE_GROUP_SERVICE_NAME = "LiveGroupServiceName";
    public static final String LIVE_SERVICE_BROADCAST_ACTION = "com.baidu.tieba.live.service";

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        boolean z = false;
        try {
            Class.forName(intent.getStringExtra("LiveGroupServiceName"));
            z = true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Intent intent2 = new Intent();
        intent2.setAction(LIVE_SERVICE_BROADCAST_ACTION);
        intent2.putExtra("isLivePluginLoaded", z);
        sendBroadcast(intent2);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }
}
