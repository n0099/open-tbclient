package com.baidu.tieba;

import androidx.annotation.AnimRes;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class sl4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract sl4 a(@IdRes int i, Fragment fragment);

    public abstract sl4 b(@IdRes int i, Fragment fragment, @Nullable String str);

    public abstract sl4 c(Fragment fragment, String str);

    public abstract sl4 d(@Nullable String str);

    public abstract int e();

    public abstract int f();

    public abstract sl4 g(Fragment fragment);

    public abstract sl4 h(Fragment fragment);

    public abstract sl4 i(@AnimRes int i, @AnimRes int i2);

    public abstract sl4 j(Fragment fragment);

    public sl4() {
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
