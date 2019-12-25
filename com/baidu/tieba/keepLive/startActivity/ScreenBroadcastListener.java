package com.baidu.tieba.keepLive.startActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
/* loaded from: classes5.dex */
public class ScreenBroadcastListener {
    private Context mContext;
    private ScreenStateListener mListener;
    private ScreenBroadcastReceiver mScreenReceiver = new ScreenBroadcastReceiver();

    /* loaded from: classes5.dex */
    public interface ScreenStateListener {
        void onScreenOff();

        void onScreenOn();
    }

    public ScreenBroadcastListener(Context context) {
        this.mContext = context.getApplicationContext();
    }

    /* loaded from: classes5.dex */
    public class ScreenBroadcastReceiver extends BroadcastReceiver {
        private String action = null;

        public ScreenBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (ScreenBroadcastListener.this.mListener != null) {
                this.action = intent.getAction();
                if ("android.intent.action.SCREEN_ON".equals(this.action)) {
                    ScreenBroadcastListener.this.mListener.onScreenOn();
                } else if ("android.intent.action.SCREEN_OFF".equals(this.action)) {
                    ScreenBroadcastListener.this.mListener.onScreenOff();
                }
            }
        }
    }

    public void registerListener(ScreenStateListener screenStateListener) {
        this.mListener = screenStateListener;
        registerListener();
    }

    private void registerListener() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        this.mContext.registerReceiver(this.mScreenReceiver, intentFilter);
    }
}
