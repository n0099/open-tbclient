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
public class l31 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile l31 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, i31> a;

    public l31() {
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

    public static l31 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (l31.class) {
                    if (b == null) {
                        b = new l31();
                    }
                }
            }
            return b;
        }
        return (l31) invokeV.objValue;
    }

    @NonNull
    public i31 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            i31 i31Var = (i31) a31.b(this.a, str);
            if (i31Var == null) {
                synchronized (l31.class) {
                    i31Var = (i31) a31.b(this.a, str);
                    if (i31Var == null) {
                        if (TextUtils.isEmpty(str)) {
                            i31Var = k31.a().a();
                        } else {
                            i31Var = k31.a().b(str);
                        }
                        a31.e(this.a, str, i31Var);
                    }
                }
            }
            return i31Var;
        }
        return (i31) invokeL.objValue;
    }
}
