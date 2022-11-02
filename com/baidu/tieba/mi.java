package com.baidu.tieba;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Process;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.FileReader;
@TargetApi(21)
/* loaded from: classes5.dex */
public class mi {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return Process.is64Bit();
            }
            String[] strArr = Build.SUPPORTED_64_BIT_ABIS;
            if (strArr == null || strArr.length <= 0 || (str = Build.CPU_ABI) == null) {
                return false;
            }
            return str.equals(strArr[0]);
        }
        return invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            boolean z = false;
            if (Build.VERSION.SDK_INT >= 21) {
                String[] strArr = Build.SUPPORTED_64_BIT_ABIS;
                if (strArr == null) {
                    return false;
                }
                for (String str : strArr) {
                    if ("arm64-v8a".equals(str)) {
                        return true;
                    }
                }
                return false;
            }
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(com.kuaishou.weapon.p0.k1.a));
                z = bufferedReader.readLine().contains("aarch64");
                bufferedReader.close();
                return z;
            } catch (Exception e) {
                e.printStackTrace();
                return z;
            }
        }
        return invokeV.booleanValue;
    }
}
