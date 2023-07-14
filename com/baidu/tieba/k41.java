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
public class k41 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile k41 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, h41> a;

    public k41() {
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

    public static k41 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (k41.class) {
                    if (b == null) {
                        b = new k41();
                    }
                }
            }
            return b;
        }
        return (k41) invokeV.objValue;
    }

    @NonNull
    public h41 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            h41 h41Var = (h41) z31.b(this.a, str);
            if (h41Var == null) {
                synchronized (k41.class) {
                    h41Var = (h41) z31.b(this.a, str);
                    if (h41Var == null) {
                        if (TextUtils.isEmpty(str)) {
                            h41Var = j41.a().a();
                        } else {
                            h41Var = j41.a().b(str);
                        }
                        z31.e(this.a, str, h41Var);
                    }
                }
            }
            return h41Var;
        }
        return (h41) invokeL.objValue;
    }
}
