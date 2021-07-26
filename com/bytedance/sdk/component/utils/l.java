package com.bytedance.sdk.component.utils;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static long a(String str) {
        InterceptResult invokeL;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            long j = 0;
            try {
                if (!TextUtils.isEmpty(str)) {
                    StatFs statFs = new StatFs(str);
                    j = statFs.getAvailableBlocks() * statFs.getBlockSize();
                }
                sb = new StringBuilder();
            } catch (Throwable unused) {
                sb = new StringBuilder();
            }
            sb.append("getAvailableSize=");
            sb.append(j);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(String.valueOf(str));
            k.b("MemorySize", sb.toString());
            return j;
        }
        return invokeL.longValue;
    }

    public static long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            try {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                return statFs.getAvailableBlocks() * statFs.getBlockSize();
            } catch (Throwable unused) {
                return 0L;
            }
        }
        return invokeV.longValue;
    }
}
