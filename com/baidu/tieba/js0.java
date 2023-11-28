package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.helper.NetUtils;
import com.baidu.searchbox.player.event.SystemEvent;
import com.baidu.tieba.ms0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class js0 extends vr0 implements ms0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ms0 b;

    public js0() {
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
        this.b = new ms0(this);
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                this.b.registerReceiver();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.ms0.a
    public void onConfigurationChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c(is0.x(SystemEvent.ACTION_CONFIGURATION_CHANGED));
        }
    }

    @Override // com.baidu.tieba.ms0.a
    public void a(NetUtils.NetStatus netStatus, NetUtils.NetStatus netStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, netStatus, netStatus2) == null) {
            ks0 x = is0.x(SystemEvent.ACTION_CONNECT_CHANGED);
            x.o(1, netStatus2);
            c(x);
        }
    }

    @Override // com.baidu.tieba.ms0.a
    public void onBatteryChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            ks0 x = is0.x(SystemEvent.ACTION_BATTERY_CHANGED);
            x.s(1);
            x.o(4, Integer.valueOf(i));
            c(x);
        }
    }

    @Override // com.baidu.tieba.ms0.a
    public void onBluetoothHeadsetChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            ks0 x = is0.x(SystemEvent.ACTION_BLUETOOTH_HEADSET);
            x.o(6, Boolean.valueOf(z));
            c(x);
        }
    }

    @Override // com.baidu.tieba.ms0.a
    public void onHeadsetPlug(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            ks0 x = is0.x(SystemEvent.ACTION_HEADSET_PLUG);
            x.o(3, Boolean.valueOf(z));
            c(x);
        }
    }

    @Override // com.baidu.tieba.ms0.a
    public void onScreenStatusChanged(boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (z) {
                str = SystemEvent.ACTION_SCREEN_OFF;
            } else {
                str = SystemEvent.ACTION_SCREEN_ON;
            }
            ks0 x = is0.x(str);
            x.o(2, Boolean.valueOf(z));
            c(x);
        }
    }

    @Override // com.baidu.tieba.ms0.a
    public void onVolumeChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            ks0 x = is0.x(SystemEvent.ACTION_VOLUME_CHANGED);
            x.o(5, Integer.valueOf(i));
            c(x);
        }
    }
}
