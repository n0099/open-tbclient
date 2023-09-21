package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class t31 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile t31 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, q31> a;

    public t31() {
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

    public static t31 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (t31.class) {
                    if (b == null) {
                        b = new t31();
                    }
                }
            }
            return b;
        }
        return (t31) invokeV.objValue;
    }

    @NonNull
    public q31 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            q31 q31Var = (q31) i31.b(this.a, str);
            if (q31Var == null) {
                synchronized (t31.class) {
                    q31Var = (q31) i31.b(this.a, str);
                    if (q31Var == null) {
                        if (TextUtils.isEmpty(str)) {
                            q31Var = s31.a().a();
                        } else {
                            q31Var = s31.a().b(str);
                        }
                        i31.e(this.a, str, q31Var);
                    }
                }
            }
            return q31Var;
        }
        return (q31) invokeL.objValue;
    }
}
