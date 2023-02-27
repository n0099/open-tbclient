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
public class r21 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile r21 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, o21> a;

    public r21() {
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

    public static r21 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (r21.class) {
                    if (b == null) {
                        b = new r21();
                    }
                }
            }
            return b;
        }
        return (r21) invokeV.objValue;
    }

    @NonNull
    public o21 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            o21 o21Var = (o21) g21.b(this.a, str);
            if (o21Var == null) {
                synchronized (r21.class) {
                    o21Var = (o21) g21.b(this.a, str);
                    if (o21Var == null) {
                        if (TextUtils.isEmpty(str)) {
                            o21Var = q21.a().a();
                        } else {
                            o21Var = q21.a().b(str);
                        }
                        g21.e(this.a, str, o21Var);
                    }
                }
            }
            return o21Var;
        }
        return (o21) invokeL.objValue;
    }
}
