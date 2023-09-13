package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.helper.NetUtils;
import com.baidu.searchbox.ui.animview.praise.NetworkMonitor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class yw0 extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_VOLUME_CHANGED = "android.media.VOLUME_CHANGED_ACTION";
    public static final String TAG = "BdVideoReceiver";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mHeadsetConnected;
    public NetUtils.NetStatus mLastStatus;
    public int mLastVolume;
    public final a mListener;

    /* loaded from: classes9.dex */
    public interface a {
        void a(NetUtils.NetStatus netStatus, NetUtils.NetStatus netStatus2);

        void onBatteryChanged(int i);

        void onBluetoothHeadsetChanged(boolean z);

        void onConfigurationChanged();

        void onHeadsetPlug(boolean z);

        void onScreenStatusChanged(boolean z);

        void onVolumeChanged(int i);
    }

    public yw0(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLastStatus = NetUtils.NetStatus.NET_DOWN;
        this.mLastVolume = -1;
        this.mListener = aVar;
    }

    private void onVolumeChanged(@NonNull Context context) {
        AudioManager audioManager;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, this, context) != null) || (audioManager = (AudioManager) context.getApplicationContext().getSystemService("audio")) == null) {
            return;
        }
        int i = this.mLastVolume;
        try {
            i = audioManager.getStreamVolume(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (i != this.mLastVolume) {
            this.mLastVolume = i;
            this.mListener.onVolumeChanged(i);
        }
    }

    private void onConnectChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            f21.a("connectivity action");
            if (isInitialStickyBroadcast()) {
                f21.a("NetChanged: StickBroadcast");
                return;
            }
            NetUtils.NetStatus a2 = NetUtils.a();
            f21.a("onConnectChanged(), Net status " + a2);
            this.mListener.a(this.mLastStatus, a2);
            this.mLastStatus = a2;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, context, intent) != null) || intent == null || this.mListener == null || (action = intent.getAction()) == null) {
            return;
        }
        char c = 65535;
        switch (action.hashCode()) {
            case -2128145023:
                if (action.equals("android.intent.action.SCREEN_OFF")) {
                    c = 1;
                    break;
                }
                break;
            case -1940635523:
                if (action.equals("android.media.VOLUME_CHANGED_ACTION")) {
                    c = '\b';
                    break;
                }
                break;
            case -1676458352:
                if (action.equals("android.intent.action.HEADSET_PLUG")) {
                    c = 4;
                    break;
                }
                break;
            case -1538406691:
                if (action.equals("android.intent.action.BATTERY_CHANGED")) {
                    c = 7;
                    break;
                }
                break;
            case -1454123155:
                if (action.equals("android.intent.action.SCREEN_ON")) {
                    c = 2;
                    break;
                }
                break;
            case -1172645946:
                if (action.equals(NetworkMonitor.NET_CHANGE_ACTION)) {
                    c = 0;
                    break;
                }
                break;
            case -549244379:
                if (action.equals("android.media.AUDIO_BECOMING_NOISY")) {
                    c = 5;
                    break;
                }
                break;
            case -403228793:
                if (action.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
                    c = 3;
                    break;
                }
                break;
            case 158859398:
                if (action.equals("android.intent.action.CONFIGURATION_CHANGED")) {
                    c = '\t';
                    break;
                }
                break;
            case 545516589:
                if (action.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
                    c = 6;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                onConnectChanged();
                return;
            case 1:
                f21.a("screen off");
                this.mListener.onScreenStatusChanged(true);
                return;
            case 2:
                f21.a("screen on");
                this.mListener.onScreenStatusChanged(false);
                return;
            case 3:
                f21.a("ACTION_CLOSE_SYSTEM_DIALOGS");
                return;
            case 4:
                if (intent.hasExtra("state")) {
                    f21.a("headset " + intent.getIntExtra("state", 0));
                    if (this.mHeadsetConnected && intent.getIntExtra("state", 0) == 0) {
                        f21.a("headset plugout");
                        this.mHeadsetConnected = false;
                    } else if (!this.mHeadsetConnected && intent.getIntExtra("state", 0) == 1) {
                        this.mHeadsetConnected = true;
                    }
                    this.mListener.onHeadsetPlug(this.mHeadsetConnected);
                    return;
                }
                return;
            case 5:
                f21.a("headset quick ACTION_AUDIO_BECOMING_NOISY");
                this.mListener.onHeadsetPlug(false);
                return;
            case 6:
                int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
                if (intExtra == 2) {
                    this.mListener.onBluetoothHeadsetChanged(true);
                    return;
                } else if (intExtra == 0) {
                    this.mListener.onBluetoothHeadsetChanged(false);
                    return;
                } else {
                    return;
                }
            case 7:
                int intExtra2 = (intent.getIntExtra("level", 0) * 100) / intent.getIntExtra("scale", 1);
                y11.a = intExtra2;
                this.mListener.onBatteryChanged(intExtra2);
                return;
            case '\b':
                onVolumeChanged(context);
                return;
            case '\t':
                this.mListener.onConfigurationChanged();
                return;
            default:
                return;
        }
    }

    public void registerReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(NetworkMonitor.NET_CHANGE_ACTION);
            intentFilter.addAction("android.intent.action.DATE_CHANGED");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            intentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
            intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            intentFilter.addAction("android.intent.action.CONFIGURATION_CHANGED");
            bu0.b().registerReceiver(this, intentFilter);
            this.mLastStatus = NetUtils.a();
        }
    }

    public void unregisterReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            bu0.b().unregisterReceiver(this);
        }
    }
}
