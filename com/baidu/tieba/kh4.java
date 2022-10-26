package com.baidu.tieba;

import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class kh4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract kh4 a(int i, Fragment fragment);

    public abstract kh4 b(int i, Fragment fragment, String str);

    public abstract kh4 c(Fragment fragment, String str);

    public abstract kh4 d(String str);

    public abstract int e();

    public abstract int f();

    public abstract kh4 g(Fragment fragment);

    public abstract kh4 h(Fragment fragment);

    public abstract kh4 i(int i, int i2);

    public abstract kh4 j(Fragment fragment);

    public kh4() {
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
}
