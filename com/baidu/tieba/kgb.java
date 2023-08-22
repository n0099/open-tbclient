package com.baidu.tieba;

import com.baidu.searchbox.aideviceperformance.utils.HardwareInfoUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class kgb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static float a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            long[] b = b();
            if (b[0] <= 0) {
                return 0.0f;
            }
            return 1.0f - (((float) ((b[1] + b[2]) + b[3])) / ((float) b[0]));
        }
        return invokeV.floatValue;
    }

    public static long[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            long[] jArr = new long[4];
            try {
                Method method = Class.forName("android.os.Process").getMethod("readProcLines", String.class, String[].class, long[].class);
                long[] jArr2 = {30, -30};
                Object[] objArr = {new String(HardwareInfoUtils.MEM_INFO_FILE), new String[]{"MemTotal:", "MemFree:", "Buffers:", "Cached:"}, jArr2};
                if (method != null) {
                    method.invoke(null, objArr);
                    for (int i = 0; i < 4; i++) {
                        jArr[i] = jArr2[i] / 1024;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return jArr;
        }
        return (long[]) invokeV.objValue;
    }
}
