package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class q72 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized p72 a(@NonNull String str) {
        InterceptResult invokeL;
        p72 u72Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            synchronized (q72.class) {
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
                                    u72Var = new o72();
                                } else {
                                    u72Var = new s72();
                                }
                            } else {
                                u72Var = new r72();
                            }
                        } else {
                            u72Var = new t72();
                        }
                    } else {
                        u72Var = new n72();
                    }
                } else {
                    u72Var = new u72();
                }
            }
            return u72Var;
        }
        return (p72) invokeL.objValue;
    }
}
