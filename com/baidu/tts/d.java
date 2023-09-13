package com.baidu.tts;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.client.ITtsError;
/* loaded from: classes9.dex */
public class d implements ITtsError {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Throwable a;
    public int b;
    public String c;
    public y0 d;

    public d() {
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

    public u0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            y0 y0Var = this.d;
            if (y0Var == null) {
                return null;
            }
            return y0Var.a;
        }
        return (u0) invokeV.objValue;
    }

    @Override // com.baidu.tts.client.ITtsError
    public int getDetailCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            y0 y0Var = this.d;
            if (y0Var != null) {
                return y0Var.a.a;
            }
            return this.b;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tts.client.ITtsError
    public String getDetailMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            y0 y0Var = this.d;
            if (y0Var != null) {
                y0Var.getClass();
                int i = this.b;
                String str = this.c;
                Throwable th = this.a;
                u0 u0Var = y0Var.a;
                String str2 = "(" + u0Var.a + SmallTailInfo.EMOTION_SUFFIX + u0Var.b;
                if (str != null) {
                    str2 = str2 + "[(" + i + SmallTailInfo.EMOTION_SUFFIX + str + PreferencesUtil.RIGHT_MOUNT;
                } else if (i != 0) {
                    str2 = str2 + "[(" + i + ")]";
                }
                if (th != null) {
                    return str2 + "[(cause)" + th.toString() + PreferencesUtil.RIGHT_MOUNT;
                }
                return str2;
            }
            String str3 = this.c;
            if (str3 == null) {
                return "";
            }
            return str3;
        }
        return (String) invokeV.objValue;
    }
}
