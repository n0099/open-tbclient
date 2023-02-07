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
public class k21 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile k21 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, h21> a;

    public k21() {
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

    public static k21 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (k21.class) {
                    if (b == null) {
                        b = new k21();
                    }
                }
            }
            return b;
        }
        return (k21) invokeV.objValue;
    }

    @NonNull
    public h21 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            h21 h21Var = (h21) z11.b(this.a, str);
            if (h21Var == null) {
                synchronized (k21.class) {
                    h21Var = (h21) z11.b(this.a, str);
                    if (h21Var == null) {
                        if (TextUtils.isEmpty(str)) {
                            h21Var = j21.a().a();
                        } else {
                            h21Var = j21.a().b(str);
                        }
                        z11.e(this.a, str, h21Var);
                    }
                }
            }
            return h21Var;
        }
        return (h21) invokeL.objValue;
    }
}
