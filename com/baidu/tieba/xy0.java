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
public class xy0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xy0 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, uy0> a;

    public xy0() {
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

    public static xy0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (xy0.class) {
                    if (b == null) {
                        b = new xy0();
                    }
                }
            }
            return b;
        }
        return (xy0) invokeV.objValue;
    }

    @NonNull
    public uy0 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            uy0 uy0Var = (uy0) my0.b(this.a, str);
            if (uy0Var == null) {
                synchronized (xy0.class) {
                    uy0Var = (uy0) my0.b(this.a, str);
                    if (uy0Var == null) {
                        if (TextUtils.isEmpty(str)) {
                            uy0Var = wy0.a().a();
                        } else {
                            uy0Var = wy0.a().b(str);
                        }
                        my0.e(this.a, str, uy0Var);
                    }
                }
            }
            return uy0Var;
        }
        return (uy0) invokeL.objValue;
    }
}
