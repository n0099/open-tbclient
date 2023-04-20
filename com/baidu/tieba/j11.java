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
public class j11 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile j11 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, g11> a;

    public j11() {
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

    public static j11 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (j11.class) {
                    if (b == null) {
                        b = new j11();
                    }
                }
            }
            return b;
        }
        return (j11) invokeV.objValue;
    }

    @NonNull
    public g11 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            g11 g11Var = (g11) y01.b(this.a, str);
            if (g11Var == null) {
                synchronized (j11.class) {
                    g11Var = (g11) y01.b(this.a, str);
                    if (g11Var == null) {
                        if (TextUtils.isEmpty(str)) {
                            g11Var = i11.a().a();
                        } else {
                            g11Var = i11.a().b(str);
                        }
                        y01.e(this.a, str, g11Var);
                    }
                }
            }
            return g11Var;
        }
        return (g11) invokeL.objValue;
    }
}
