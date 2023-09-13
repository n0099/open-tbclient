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
public class u31 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile u31 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, r31> a;

    public u31() {
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

    public static u31 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (u31.class) {
                    if (b == null) {
                        b = new u31();
                    }
                }
            }
            return b;
        }
        return (u31) invokeV.objValue;
    }

    @NonNull
    public r31 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            r31 r31Var = (r31) j31.b(this.a, str);
            if (r31Var == null) {
                synchronized (u31.class) {
                    r31Var = (r31) j31.b(this.a, str);
                    if (r31Var == null) {
                        if (TextUtils.isEmpty(str)) {
                            r31Var = t31.a().a();
                        } else {
                            r31Var = t31.a().b(str);
                        }
                        j31.e(this.a, str, r31Var);
                    }
                }
            }
            return r31Var;
        }
        return (r31) invokeL.objValue;
    }
}
