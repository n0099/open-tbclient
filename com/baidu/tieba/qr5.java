package com.baidu.tieba;

import android.content.Context;
import android.media.AudioManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.switchs.FrsHeadVideoAutoPlaySwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class qr5 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948101461, "Lcom/baidu/tieba/qr5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948101461, "Lcom/baidu/tieba/qr5;");
        }
    }

    public static boolean a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            if (i != 3 && i != 4) {
                if (i != 5) {
                    int autoPlaySwitch = TbadkCoreApplication.getInst().getAutoPlaySwitch();
                    if ((autoPlaySwitch == 3 || !BdNetTypeUtil.isWifiNet()) && (autoPlaySwitch != 2 || !BdNetTypeUtil.isMobileNet())) {
                        return false;
                    }
                } else if (TbadkCoreApplication.getInst().getVideoAutoPlayReal() != 2 && (!FrsHeadVideoAutoPlaySwitch.getIsOn() || !BdNetTypeUtil.isWifiNet() || TbadkCoreApplication.getInst().getVideoAutoPlayReal() != 1)) {
                    return false;
                }
                return true;
            }
            return BdNetTypeUtil.isWifiNet();
        }
        return invokeI.booleanValue;
    }

    public static boolean b(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i, str)) == null) {
            return a(i);
        }
        return invokeIL.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a;
        }
        return invokeV.booleanValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if ((BdNetTypeUtil.isWifiNet() && TbadkCoreApplication.getInst().getVideoAutoPlayReal() != 3) || (BdNetTypeUtil.isMobileNet() && TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 2)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean e(WeakReference<Context> weakReference, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65541, null, weakReference, z)) == null) {
            if (weakReference == null || weakReference.get() == null) {
                return false;
            }
            AudioManager audioManager = (AudioManager) weakReference.get().getSystemService("audio");
            if (z) {
                if (audioManager.requestAudioFocus(null, 3, 2) != 1) {
                    return false;
                }
            } else if (audioManager.abandonAudioFocus(null) != 1) {
                return false;
            }
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public static void f(WeakReference<Context> weakReference) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, weakReference) == null) && weakReference != null && weakReference.get() != null) {
            a = ((AudioManager) weakReference.get().getSystemService("audio")).isMusicActive();
        }
    }
}
