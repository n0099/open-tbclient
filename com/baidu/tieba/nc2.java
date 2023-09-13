package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class nc2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mc2 a(@NonNull String str) {
        InterceptResult invokeL;
        mc2 rc2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            synchronized (nc2.class) {
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
                                    rc2Var = new lc2();
                                } else {
                                    rc2Var = new pc2();
                                }
                            } else {
                                rc2Var = new oc2();
                            }
                        } else {
                            rc2Var = new qc2();
                        }
                    } else {
                        rc2Var = new kc2();
                    }
                } else {
                    rc2Var = new rc2();
                }
            }
            return rc2Var;
        }
        return (mc2) invokeL.objValue;
    }
}
