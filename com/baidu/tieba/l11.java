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
public class l11 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile l11 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, i11> a;

    public l11() {
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

    public static l11 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (l11.class) {
                    if (b == null) {
                        b = new l11();
                    }
                }
            }
            return b;
        }
        return (l11) invokeV.objValue;
    }

    @NonNull
    public i11 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            i11 i11Var = (i11) a11.b(this.a, str);
            if (i11Var == null) {
                synchronized (l11.class) {
                    i11Var = (i11) a11.b(this.a, str);
                    if (i11Var == null) {
                        if (TextUtils.isEmpty(str)) {
                            i11Var = k11.a().a();
                        } else {
                            i11Var = k11.a().b(str);
                        }
                        a11.e(this.a, str, i11Var);
                    }
                }
            }
            return i11Var;
        }
        return (i11) invokeL.objValue;
    }
}
