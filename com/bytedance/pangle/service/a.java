package com.bytedance.pangle.service;

import android.content.Intent;
import android.os.IBinder;
import com.bytedance.pangle.plugin.Plugin;
/* loaded from: classes12.dex */
public interface a {
    void attach(Plugin plugin2);

    IBinder onBind(Intent intent);

    void onCreate();

    void onDestroy();

    int onStartCommand(Intent intent, int i2, int i3);

    boolean onUnbind(Intent intent);
}
