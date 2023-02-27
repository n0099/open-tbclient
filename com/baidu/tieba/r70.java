package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class r70 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public r70() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                Method declaredMethod = Class.forName("com.baidu.browser.sailor.util.BdZeusUtil", true, r70.class.getClassLoader()).getDeclaredMethod("isWebkitLoaded", new Class[0]);
                declaredMethod.setAccessible(true);
                boolean booleanValue = ((Boolean) declaredMethod.invoke(null, new Object[0])).booleanValue();
                Method declaredMethod2 = Class.forName("com.baidu.webkit.internal.blink.WebSettingsGlobalBlink", true, r70.class.getClassLoader()).getDeclaredMethod("getChromiunNetInit", new Class[0]);
                declaredMethod2.setAccessible(true);
                if (!booleanValue) {
                    return false;
                }
                if (!((Boolean) declaredMethod2.invoke(null, new Object[0])).booleanValue()) {
                    return false;
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
