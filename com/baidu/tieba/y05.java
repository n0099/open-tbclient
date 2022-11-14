package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class y05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public int c;
    public String d;

    public y05() {
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
        this.a = null;
        this.b = null;
        this.c = 0;
        this.d = null;
    }

    public static String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            switch (i) {
                case 1:
                    return qj.a(R.string.obfuscated_res_0x7f0f15bd);
                case 2:
                    return qj.a(R.string.obfuscated_res_0x7f0f15c2);
                case 3:
                    return qj.a(R.string.obfuscated_res_0x7f0f0c81);
                case 4:
                    return qj.a(R.string.obfuscated_res_0x7f0f15c0);
                case 5:
                    return qj.a(R.string.obfuscated_res_0x7f0f15be);
                case 6:
                    return qj.a(R.string.obfuscated_res_0x7f0f15c1);
                case 7:
                    return qj.a(R.string.obfuscated_res_0x7f0f15bf);
                default:
                    return "";
            }
        }
        return (String) invokeI.objValue;
    }
}
