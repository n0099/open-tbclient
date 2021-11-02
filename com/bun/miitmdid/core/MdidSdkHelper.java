package com.bun.miitmdid.core;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bun.miitmdid.supplier.IdSupplier;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
@Keep
/* loaded from: classes11.dex */
public class MdidSdkHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static String TAG = "MdidSdkHelper";
    @Keep
    public static boolean _OuterIsOk = true;
    public transient /* synthetic */ FieldHolder $fh;
    @Keep
    public String sdk_date;

    /* loaded from: classes11.dex */
    public static class a implements IdSupplier {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // com.bun.miitmdid.supplier.IdSupplier
        public String getAAID() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "" : (String) invokeV.objValue;
        }

        @Override // com.bun.miitmdid.supplier.IdSupplier
        public String getOAID() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "" : (String) invokeV.objValue;
        }

        @Override // com.bun.miitmdid.supplier.IdSupplier
        public String getVAID() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "" : (String) invokeV.objValue;
        }

        @Override // com.bun.miitmdid.supplier.IdSupplier
        public boolean isSupported() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1700383277, "Lcom/bun/miitmdid/core/MdidSdkHelper;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1700383277, "Lcom/bun/miitmdid/core/MdidSdkHelper;");
        }
    }

    public MdidSdkHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.sdk_date = "2019120111";
    }

    @Keep
    public static int InitSdk(Context context, boolean z, IIdentifierListener iIdentifierListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, Boolean.valueOf(z), iIdentifierListener})) == null) {
            try {
                if (!_OuterIsOk) {
                    if (iIdentifierListener != null) {
                        iIdentifierListener.OnSupport(false, new a());
                    }
                    return ErrorCode.INIT_HELPER_CALL_ERROR;
                }
                Class<?> cls = Class.forName("com.bun.miitmdid.core.MdidSdk");
                if (cls == null) {
                    logd(z, "not found class:com.bun.miitmdid.core.MdidSdk");
                    return ErrorCode.INIT_HELPER_CALL_ERROR;
                }
                Constructor<?> constructor = cls.getConstructor(Boolean.TYPE);
                if (constructor == null) {
                    logd(z, "not found MdidSdk Constructor");
                    return ErrorCode.INIT_HELPER_CALL_ERROR;
                }
                Object newInstance = constructor.newInstance(Boolean.valueOf(z));
                if (newInstance == null) {
                    logd(z, "Create MdidSdk Instance failed");
                    return ErrorCode.INIT_HELPER_CALL_ERROR;
                }
                Method declaredMethod = cls.getDeclaredMethod("InitSdk", Context.class, IIdentifierListener.class);
                if (declaredMethod == null) {
                    logd(z, "not found MdidSdk InitSdk function");
                    return ErrorCode.INIT_HELPER_CALL_ERROR;
                }
                int intValue = ((Integer) declaredMethod.invoke(newInstance, context, iIdentifierListener)).intValue();
                logd(z, "call and retvalue:" + intValue);
                return intValue;
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
                loge(z, e2);
                logd(z, "exception exit");
                return ErrorCode.INIT_HELPER_CALL_ERROR;
            }
        }
        return invokeCommon.intValue;
    }

    public static void logd(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65539, null, z, str) == null) {
        }
    }

    public static void loge(boolean z, Exception exc) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TRACKBALL, null, z, exc) == null) && z) {
            exc.getClass().getSimpleName();
        }
    }
}
