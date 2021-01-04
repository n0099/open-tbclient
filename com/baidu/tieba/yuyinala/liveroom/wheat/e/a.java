package com.baidu.tieba.yuyinala.liveroom.wheat.e;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.media.AudioManager;
/* loaded from: classes11.dex */
public class a {
    @SuppressLint({"MissingPermission"})
    public static boolean hi(Context context) {
        if (context == null) {
            return false;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (audioManager == null || !audioManager.isWiredHeadsetOn()) {
            return defaultAdapter != null && defaultAdapter.getProfileConnectionState(1) == 2;
        }
        return true;
    }
}
