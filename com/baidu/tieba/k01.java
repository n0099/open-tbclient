package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class k01 implements n01 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final StringBuilder a;

    public k01() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new StringBuilder();
    }

    @Override // com.baidu.tieba.n01
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.tieba.n01
    public <T extends n01> T b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) ? (T) d(str, str2) : (T) invokeLL.objValue;
    }

    public <T extends n01> T c(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, obj)) == null) ? (T) d(str, obj) : (T) invokeLL.objValue;
    }

    public <T extends n01> T d(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, obj)) == null) {
            if (!TextUtils.isEmpty(str) && obj != null) {
                try {
                    if (!TextUtils.isEmpty(String.valueOf(obj))) {
                        if (this.a.length() > 0) {
                            this.a.append('&');
                        }
                        StringBuilder sb = this.a;
                        sb.append(str);
                        sb.append('=');
                        sb.append(obj);
                    }
                } catch (Exception unused) {
                }
            }
            return this;
        }
        return (T) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.n01
    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.toString() : (String) invokeV.objValue;
    }
}
