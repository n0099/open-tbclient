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
public abstract class we4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public we4() {
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

    public abstract we4 a(@IdRes int i, Fragment fragment);

    public abstract we4 b(@IdRes int i, Fragment fragment, @Nullable String str);

    public abstract we4 c(Fragment fragment, String str);

    public abstract we4 d(@Nullable String str);

    public abstract int e();

    public abstract int f();

    public abstract we4 g(Fragment fragment);

    public abstract we4 h(Fragment fragment);

    public abstract we4 i(@AnimRes int i, @AnimRes int i2);

    public abstract we4 j(Fragment fragment);
}
