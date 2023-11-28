package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class yy0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yy0 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, vy0> a;

    public yy0() {
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

    public static yy0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (yy0.class) {
                    if (b == null) {
                        b = new yy0();
                    }
                }
            }
            return b;
        }
        return (yy0) invokeV.objValue;
    }

    @NonNull
    public vy0 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            vy0 vy0Var = (vy0) ny0.b(this.a, str);
            if (vy0Var == null) {
                synchronized (yy0.class) {
                    vy0Var = (vy0) ny0.b(this.a, str);
                    if (vy0Var == null) {
                        if (TextUtils.isEmpty(str)) {
                            vy0Var = xy0.a().a();
                        } else {
                            vy0Var = xy0.a().b(str);
                        }
                        ny0.e(this.a, str, vy0Var);
                    }
                }
            }
            return vy0Var;
        }
        return (vy0) invokeL.objValue;
    }
}
