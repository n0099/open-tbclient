package com.baidu.tieba;

import android.content.Intent;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class t96 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            return ku2.M().a();
        }
        return invokeV.booleanValue;
    }

    public static void b() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            int defaultNightMode = AppCompatDelegate.getDefaultNightMode();
            if (a()) {
                i = 2;
            } else {
                i = 1;
            }
            if (defaultNightMode != i) {
                AppCompatDelegate.setDefaultNightMode(i);
            }
        }
    }

    public static void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65538, null, z) == null) {
            Intent intent = new Intent("com.baidu.swan.skin.nightmodechanged");
            intent.putExtra("key_night_mode", z);
            LocalBroadcastManager.getInstance(AppRuntime.getAppContext()).sendBroadcast(intent);
        }
    }
}
