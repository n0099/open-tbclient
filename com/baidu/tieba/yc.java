package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes7.dex */
public class yc implements ed {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    public yc(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = z;
    }

    @Override // com.baidu.tieba.ed
    public Object a(ud udVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, udVar)) == null) {
            Class<?> a = udVar.a();
            if (a != Boolean.class && a != Boolean.TYPE) {
                if (a != Short.class && a != Short.TYPE) {
                    if (a != Integer.class && a != Integer.TYPE) {
                        if (a != Long.class && a != Long.TYPE) {
                            if (a != Float.class && a != Float.TYPE) {
                                if (a != Double.class && a != Double.TYPE) {
                                    if (a != Character.class && a != Character.TYPE) {
                                        if (a == String.class) {
                                            return String.valueOf(this.a);
                                        }
                                        if (a == char[].class) {
                                            return String.valueOf(this.a).toCharArray();
                                        }
                                        if (a == byte[].class) {
                                            try {
                                                return zh.e(String.valueOf(this.a), 0);
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                                return null;
                                            }
                                        }
                                        return null;
                                    }
                                    return Character.valueOf((char) (!this.a ? 1 : 0));
                                }
                                return Double.valueOf(!this.a ? 1 : 0);
                            }
                            return Float.valueOf(!this.a ? 1 : 0);
                        }
                        return Long.valueOf(!this.a ? 1 : 0);
                    }
                    return Integer.valueOf(!this.a ? 1 : 0);
                }
                return Short.valueOf((short) (!this.a ? 1 : 0));
            }
            return Boolean.valueOf(this.a);
        }
        return invokeL.objValue;
    }
}
