package com.baidu.tieba.yuyinala.liveroom.wheat.d;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.media.AudioManager;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes4.dex */
public class a {
    @SuppressLint({"MissingPermission"})
    public static boolean gh(Context context) {
        if (context == null) {
            return false;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (audioManager == null || !audioManager.isWiredHeadsetOn()) {
            return defaultAdapter != null && defaultAdapter.getProfileConnectionState(1) == 2;
        }
        return true;
    }
}
