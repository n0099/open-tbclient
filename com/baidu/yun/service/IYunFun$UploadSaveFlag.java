package com.baidu.yun.service;

import com.baidu.browser.sailor.BdSailorConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class IYunFun$UploadSaveFlag {
    public static final /* synthetic */ IYunFun$UploadSaveFlag[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final IYunFun$UploadSaveFlag SAVE;
    public static final IYunFun$UploadSaveFlag UPLOAD;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-345138786, "Lcom/baidu/yun/service/IYunFun$UploadSaveFlag;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-345138786, "Lcom/baidu/yun/service/IYunFun$UploadSaveFlag;");
                return;
            }
        }
        UPLOAD = new IYunFun$UploadSaveFlag(BdSailorConfig.SAILOR_BASE_UPLOAD, 0);
        IYunFun$UploadSaveFlag iYunFun$UploadSaveFlag = new IYunFun$UploadSaveFlag("SAVE", 1);
        SAVE = iYunFun$UploadSaveFlag;
        $VALUES = new IYunFun$UploadSaveFlag[]{UPLOAD, iYunFun$UploadSaveFlag};
    }

    public IYunFun$UploadSaveFlag(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static IYunFun$UploadSaveFlag valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (IYunFun$UploadSaveFlag) Enum.valueOf(IYunFun$UploadSaveFlag.class, str);
        }
        return (IYunFun$UploadSaveFlag) invokeL.objValue;
    }

    public static IYunFun$UploadSaveFlag[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (IYunFun$UploadSaveFlag[]) $VALUES.clone();
        }
        return (IYunFun$UploadSaveFlag[]) invokeV.objValue;
    }
}
