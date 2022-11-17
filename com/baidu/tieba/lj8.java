package com.baidu.tieba;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes4.dex */
public class lj8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            int lastIndexOf = str.lastIndexOf(File.separator);
            if (lastIndexOf == -1) {
                return "";
            }
            return str.substring(0, lastIndexOf);
        }
        return (String) invokeL.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                return Environment.getExternalStorageDirectory() + File.separator + "tieba/Logs/";
            } catch (Exception e) {
                BdLog.e(Log.getStackTraceString(e));
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            String path = Environment.getExternalStorageDirectory().getPath();
            int length = path.length() - 1;
            if (length > 0 && !path.substring(length).equals(File.separator)) {
                return path + File.separator;
            }
            return path;
        }
        return (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return d() + "tieba/Logs/";
        }
        return (String) invokeV.objValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            String a = a(str);
            if (TextUtils.isEmpty(a)) {
                return false;
            }
            File file = new File(a);
            if ((!file.exists() || !file.isDirectory()) && !file.mkdirs()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
