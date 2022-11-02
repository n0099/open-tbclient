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
public class w01 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile w01 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, t01> a;

    public w01() {
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

    public static w01 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (w01.class) {
                    if (b == null) {
                        b = new w01();
                    }
                }
            }
            return b;
        }
        return (w01) invokeV.objValue;
    }

    @NonNull
    public t01 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            t01 t01Var = (t01) q01.b(this.a, str);
            if (t01Var == null) {
                synchronized (w01.class) {
                    t01Var = (t01) q01.b(this.a, str);
                    if (t01Var == null) {
                        if (TextUtils.isEmpty(str)) {
                            t01Var = v01.a().a();
                        } else {
                            t01Var = v01.a().b(str);
                        }
                        q01.e(this.a, str, t01Var);
                    }
                }
            }
            return t01Var;
        }
        return (t01) invokeL.objValue;
    }
}
