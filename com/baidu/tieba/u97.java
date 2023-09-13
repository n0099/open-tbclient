package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class u97 implements pb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public long b;
    public String c;
    public long d;
    public int e;
    public boolean f;
    public long g;
    public long h;
    public long i;
    public aa7 j;
    @Nullable
    public Object k;
    public f87 l;

    public u97() {
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
        this.j = new aa7();
    }

    @Override // com.baidu.tieba.pb7
    public void d(@NonNull Object obj) {
        aa7 aa7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (aa7Var = this.j) != null) {
            aa7Var.d(obj);
        }
    }
}
