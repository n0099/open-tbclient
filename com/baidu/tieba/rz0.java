package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class rz0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rz0 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, oz0> a;

    public rz0() {
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

    public static rz0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (rz0.class) {
                    if (b == null) {
                        b = new rz0();
                    }
                }
            }
            return b;
        }
        return (rz0) invokeV.objValue;
    }

    @NonNull
    public oz0 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            oz0 oz0Var = (oz0) lz0.b(this.a, str);
            if (oz0Var == null) {
                synchronized (rz0.class) {
                    oz0Var = (oz0) lz0.b(this.a, str);
                    if (oz0Var == null) {
                        if (TextUtils.isEmpty(str)) {
                            oz0Var = qz0.a().a();
                        } else {
                            oz0Var = qz0.a().b(str);
                        }
                        lz0.e(this.a, str, oz0Var);
                    }
                }
            }
            return oz0Var;
        }
        return (oz0) invokeL.objValue;
    }
}
