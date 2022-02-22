package com.bytedance.pangle.flipped;

import android.util.Log;
import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.ZeusConstants;
import java.lang.reflect.Method;
@Keep
/* loaded from: classes3.dex */
public class FlippedV2Impl implements c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FlippedV2Impl";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1514093784, "Lcom/bytedance/pangle/flipped/FlippedV2Impl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1514093784, "Lcom/bytedance/pangle/flipped/FlippedV2Impl;");
                return;
            }
        }
        System.loadLibrary(ZeusConstants.BASE_LIB_NAME + "flipped");
    }

    public FlippedV2Impl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private native Method getDeclaredMethod(Object obj, String str, Class<?>[] clsArr);

    @Override // com.bytedance.pangle.flipped.c
    public void invokeHiddenApiRestrictions() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                Class<?> cls = Class.forName("dalvik.system.VMRuntime");
                Method declaredMethod = getDeclaredMethod(cls, "getRuntime", new Class[0]);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(null, new Object[0]);
                Method declaredMethod2 = getDeclaredMethod(cls, "setHiddenApiExemptions", new Class[]{String[].class});
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(invoke, new String[]{"L"});
            } catch (Exception e2) {
                String str = "V2 invokeHiddenApiRestrictions fail: " + Log.getStackTraceString(e2);
            }
        }
    }
}
