package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ww0 implements zw0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ww0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.zw0
    @NonNull
    public sw0 create(@NonNull String str) {
        InterceptResult invokeL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode != -812096555) {
                if (hashCode == 26276517 && str.equals("CyberNetPlayer")) {
                    c = 0;
                }
                c = 65535;
            } else {
                if (str.equals("CyberSysPlayer")) {
                    c = 1;
                }
                c = 65535;
            }
            if (c != 0) {
                return new cx0();
            }
            return new uw0();
        }
        return (sw0) invokeL.objValue;
    }
}
