package com.bun.miitmdid.provider.xiaomi;

import android.content.Context;
import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
@Keep
/* loaded from: classes7.dex */
public class IdentifierManager {
    public static /* synthetic */ Interceptable $ic;
    @Keep
    public static Class<?> sClass;
    @Keep
    public static Method sGetAAID;
    @Keep
    public static Method sGetOAID;
    @Keep
    public static Method sGetUDID;
    @Keep
    public static Method sGetVAID;
    @Keep
    public static Object sIdProivderImpl;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(935327733, "Lcom/bun/miitmdid/provider/xiaomi/IdentifierManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(935327733, "Lcom/bun/miitmdid/provider/xiaomi/IdentifierManager;");
                return;
            }
        }
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            sClass = cls;
            sIdProivderImpl = cls.newInstance();
            sGetUDID = sClass.getMethod("getUDID", Context.class);
            sGetOAID = sClass.getMethod("getOAID", Context.class);
            sGetVAID = sClass.getMethod("getVAID", Context.class);
            sGetAAID = sClass.getMethod("getAAID", Context.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public IdentifierManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Keep
    public static native String getAAID(Context context);

    @Keep
    public static native String getOAID(Context context);

    @Keep
    public static native String getUDID(Context context);

    @Keep
    public static native String getVAID(Context context);

    @Keep
    public static native String invokeMethod(Context context, Method method);

    @Keep
    public static native boolean isSupported();
}
