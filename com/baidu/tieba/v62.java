package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class v62 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized u62 a(@NonNull String str) {
        InterceptResult invokeL;
        u62 z62Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            synchronized (v62.class) {
                char c = 65535;
                switch (str.hashCode()) {
                    case 48:
                        if (str.equals("0")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 49:
                        if (str.equals("1")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 50:
                        if (str.equals("2")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 51:
                        if (str.equals("3")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 52:
                        if (str.equals("4")) {
                            c = 4;
                            break;
                        }
                        break;
                }
                if (c != 0) {
                    if (c != 1) {
                        if (c != 2) {
                            if (c != 3) {
                                if (c != 4) {
                                    z62Var = new t62();
                                } else {
                                    z62Var = new x62();
                                }
                            } else {
                                z62Var = new w62();
                            }
                        } else {
                            z62Var = new y62();
                        }
                    } else {
                        z62Var = new s62();
                    }
                } else {
                    z62Var = new z62();
                }
            }
            return z62Var;
        }
        return (u62) invokeL.objValue;
    }
}
