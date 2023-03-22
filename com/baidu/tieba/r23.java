package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.x23;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class r23 implements x23.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final w23 b;

    public r23(int i, @NonNull w23 w23Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), w23Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i;
        this.b = w23Var;
    }

    @Override // com.baidu.tieba.x23.a
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i, strArr, iArr) == null) {
            if (i != this.a) {
                this.b.b(2, "request permission fail");
                return;
            }
            for (int i2 : iArr) {
                if (i2 == -1) {
                    this.b.b(1, "user denied");
                    return;
                }
            }
            this.b.a("permission granted successful");
        }
    }
}
