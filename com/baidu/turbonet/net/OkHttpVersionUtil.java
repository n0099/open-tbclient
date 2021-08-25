package com.baidu.turbonet.net;

import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.util.NoSuchElementException;
/* loaded from: classes8.dex */
public class OkHttpVersionUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public OkHttpVersionUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b()) {
                try {
                    return (String) Class.forName("okhttp3.internal.Version").getMethod("userAgent", new Class[0]).invoke(null, new Object[0]);
                } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                Class.forName("okhttp3.OkHttpClient");
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean c() throws RuntimeException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            String a2 = a();
            if (!a2.isEmpty()) {
                String[] split = a2.split("/");
                if (split.length == 2) {
                    String[] split2 = split[1].split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                    if (split2.length == 3) {
                        try {
                            if (Integer.parseInt(split2[0]) == 3) {
                                if (Integer.parseInt(split2[1]) >= 9) {
                                    return true;
                                }
                            }
                            return false;
                        } catch (NumberFormatException unused) {
                            throw new IllegalArgumentException(String.format("okhttp version format(%s) is not valid", a2));
                        }
                    }
                    throw new IllegalArgumentException(String.format("okhttp version format(%s) is not valid", a2));
                }
                throw new IllegalArgumentException(String.format("okhttp version format(%s) is not valid", a2));
            }
            throw new NoSuchElementException();
        }
        return invokeV.booleanValue;
    }
}
