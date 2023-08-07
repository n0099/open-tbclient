package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class n31 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile n31 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, k31> a;

    public n31() {
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
        this.a = new ConcurrentHashMap<>();
    }

    public static n31 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (n31.class) {
                    if (b == null) {
                        b = new n31();
                    }
                }
            }
            return b;
        }
        return (n31) invokeV.objValue;
    }

    @NonNull
    public k31 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            k31 k31Var = (k31) c31.b(this.a, str);
            if (k31Var == null) {
                synchronized (n31.class) {
                    k31Var = (k31) c31.b(this.a, str);
                    if (k31Var == null) {
                        if (TextUtils.isEmpty(str)) {
                            k31Var = m31.a().a();
                        } else {
                            k31Var = m31.a().b(str);
                        }
                        c31.e(this.a, str, k31Var);
                    }
                }
            }
            return k31Var;
        }
        return (k31) invokeL.objValue;
    }
}
