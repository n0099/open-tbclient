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
public class k31 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile k31 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, h31> a;

    public k31() {
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

    public static k31 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (k31.class) {
                    if (b == null) {
                        b = new k31();
                    }
                }
            }
            return b;
        }
        return (k31) invokeV.objValue;
    }

    @NonNull
    public h31 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            h31 h31Var = (h31) z21.b(this.a, str);
            if (h31Var == null) {
                synchronized (k31.class) {
                    h31Var = (h31) z21.b(this.a, str);
                    if (h31Var == null) {
                        if (TextUtils.isEmpty(str)) {
                            h31Var = j31.a().a();
                        } else {
                            h31Var = j31.a().b(str);
                        }
                        z21.e(this.a, str, h31Var);
                    }
                }
            }
            return h31Var;
        }
        return (h31) invokeL.objValue;
    }
}
