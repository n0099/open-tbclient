package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.helper.NetUtils;
import com.baidu.searchbox.player.event.SystemEvent;
import com.baidu.tieba.vu0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class su0 extends eu0 implements vu0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final vu0 b;

    public su0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new vu0(this);
    }

    @Override // com.baidu.tieba.vu0.a
    public void onConfigurationChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c(ru0.w(SystemEvent.ACTION_CONFIGURATION_CHANGED));
        }
    }

    public void registerReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            try {
                this.b.registerReceiver();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void unregisterReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            try {
                this.b.unregisterReceiver();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.vu0.a
    public void a(NetUtils.NetStatus netStatus, NetUtils.NetStatus netStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, netStatus, netStatus2) == null) {
            tu0 w = ru0.w(SystemEvent.ACTION_CONNECT_CHANGED);
            w.n(1, netStatus2);
            c(w);
        }
    }

    @Override // com.baidu.tieba.vu0.a
    public void onBatteryChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            tu0 w = ru0.w(SystemEvent.ACTION_BATTERY_CHANGED);
            w.r(1);
            w.n(4, Integer.valueOf(i));
            c(w);
        }
    }

    @Override // com.baidu.tieba.vu0.a
    public void onBluetoothHeadsetChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            tu0 w = ru0.w(SystemEvent.ACTION_BLUETOOTH_HEADSET);
            w.n(6, Boolean.valueOf(z));
            c(w);
        }
    }

    @Override // com.baidu.tieba.vu0.a
    public void onHeadsetPlug(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            tu0 w = ru0.w(SystemEvent.ACTION_HEADSET_PLUG);
            w.n(3, Boolean.valueOf(z));
            c(w);
        }
    }

    @Override // com.baidu.tieba.vu0.a
    public void onScreenStatusChanged(boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                str = SystemEvent.ACTION_SCREEN_OFF;
            } else {
                str = SystemEvent.ACTION_SCREEN_ON;
            }
            tu0 w = ru0.w(str);
            w.n(2, Boolean.valueOf(z));
            c(w);
        }
    }

    @Override // com.baidu.tieba.vu0.a
    public void onVolumeChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            tu0 w = ru0.w(SystemEvent.ACTION_VOLUME_CHANGED);
            w.n(5, Integer.valueOf(i));
            c(w);
        }
    }
}
