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
public class o31 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile o31 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, l31> a;

    public o31() {
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

    public static o31 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (o31.class) {
                    if (b == null) {
                        b = new o31();
                    }
                }
            }
            return b;
        }
        return (o31) invokeV.objValue;
    }

    @NonNull
    public l31 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            l31 l31Var = (l31) d31.b(this.a, str);
            if (l31Var == null) {
                synchronized (o31.class) {
                    l31Var = (l31) d31.b(this.a, str);
                    if (l31Var == null) {
                        if (TextUtils.isEmpty(str)) {
                            l31Var = n31.a().a();
                        } else {
                            l31Var = n31.a().b(str);
                        }
                        d31.e(this.a, str, l31Var);
                    }
                }
            }
            return l31Var;
        }
        return (l31) invokeL.objValue;
    }
}
