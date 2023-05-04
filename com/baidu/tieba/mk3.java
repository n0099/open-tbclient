package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.tieba.ll3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
/* loaded from: classes5.dex */
public class mk3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static File a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            List<ll3.a> d = ps2.d();
            if (d != null && d.size() > 0) {
                File file = new File(d.get(0).a, "/debug/");
                if (!file.exists()) {
                    file.mkdirs();
                }
                return file;
            }
            return null;
        }
        return (File) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return new File(ps2.d().get(0).a, "/debug/").getAbsolutePath();
        }
        return (String) invokeV.objValue;
    }
}
