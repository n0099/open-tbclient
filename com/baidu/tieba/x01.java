package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class x01 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile x01 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, u01> a;

    public x01() {
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

    public static x01 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (x01.class) {
                    if (b == null) {
                        b = new x01();
                    }
                }
            }
            return b;
        }
        return (x01) invokeV.objValue;
    }

    @NonNull
    public u01 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            u01 u01Var = (u01) r01.b(this.a, str);
            if (u01Var == null) {
                synchronized (x01.class) {
                    u01Var = (u01) r01.b(this.a, str);
                    if (u01Var == null) {
                        if (TextUtils.isEmpty(str)) {
                            u01Var = w01.a().a();
                        } else {
                            u01Var = w01.a().b(str);
                        }
                        r01.e(this.a, str, u01Var);
                    }
                }
            }
            return u01Var;
        }
        return (u01) invokeL.objValue;
    }
}
