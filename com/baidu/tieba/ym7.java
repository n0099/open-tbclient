package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public class ym7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) ? c(d(str)) : (String) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? c(str).trim() : (String) invokeL.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            Pattern compile = Pattern.compile(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1368));
            boolean z = false;
            int i = 0;
            while (!z && i < 1000) {
                Matcher matcher = compile.matcher(str);
                if (matcher.find()) {
                    str = matcher.replaceAll(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1369));
                    i++;
                } else {
                    z = true;
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? str.trim() : (String) invokeL.objValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            Matcher matcher = Pattern.compile(TbFaceManager.d).matcher(str);
            while (matcher.find()) {
                if (!TbFaceManager.i().p(matcher.group())) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            String c = c(str);
            if (StringUtils.isNull(c)) {
                return TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1363);
            }
            return !e(c) ? TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1364) : "";
        }
        return (String) invokeL.objValue;
    }
}
