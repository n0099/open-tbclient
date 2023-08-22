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
public class q31 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile q31 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, n31> a;

    public q31() {
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

    public static q31 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (q31.class) {
                    if (b == null) {
                        b = new q31();
                    }
                }
            }
            return b;
        }
        return (q31) invokeV.objValue;
    }

    @NonNull
    public n31 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            n31 n31Var = (n31) f31.b(this.a, str);
            if (n31Var == null) {
                synchronized (q31.class) {
                    n31Var = (n31) f31.b(this.a, str);
                    if (n31Var == null) {
                        if (TextUtils.isEmpty(str)) {
                            n31Var = p31.a().a();
                        } else {
                            n31Var = p31.a().b(str);
                        }
                        f31.e(this.a, str, n31Var);
                    }
                }
            }
            return n31Var;
        }
        return (n31) invokeL.objValue;
    }
}
