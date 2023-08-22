package com.baidu.tieba;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.io.File;
/* loaded from: classes8.dex */
public class ul {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return "";
            }
            if (str.contains(".so")) {
                String[] split = str.split("\\.");
                StringBuilder sb = new StringBuilder();
                if (uh.a()) {
                    str3 = "so_64_cache";
                } else {
                    str3 = "so_cache";
                }
                sb.append(str3);
                sb.append(File.separator);
                sb.append(split[0]);
                str2 = sb.toString();
            } else if (str.contains(".mp3")) {
                str2 = "mp3_cache";
            } else if (str.contains(DefaultHlsExtractorFactory.MP4_FILE_EXTENSION)) {
                str2 = "mp4_cache";
            } else {
                str2 = "res_cache";
            }
            return BdBaseApplication.getInst().getFilesDir() + File.separator + str2;
        }
        return (String) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return "";
            }
            return a(str) + File.separator + str;
        }
        return (String) invokeL.objValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str != null && str.endsWith("libturbonet.so")) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
