package com.baidu.tieba.keepLive.startActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes2.dex */
public class ScreenBroadcastListener {
    private Context mContext;
    private ScreenStateListener mListener;
    private ScreenBroadcastReceiver mScreenReceiver = new ScreenBroadcastReceiver();

    /* loaded from: classes2.dex */
    public interface ScreenStateListener {
        void onScreenOff();

        void onScreenOn();
    }

    public ScreenBroadcastListener(Context context) {
        this.mContext = context.getApplicationContext();
    }

    /* loaded from: classes2.dex */
    public class ScreenBroadcastReceiver extends BroadcastReceiver {
        private String action = null;

        public ScreenBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
        }
    }

    public void registerListener(ScreenStateListener screenStateListener) {
        this.mListener = screenStateListener;
    }

    private void registerListener() {
    }
}
