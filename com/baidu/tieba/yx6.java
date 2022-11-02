package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.a07;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
/* loaded from: classes6.dex */
public class yx6 implements uj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a07.d a;

    @Override // com.baidu.tieba.uj7
    public void c(long j, String str, Message message, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), str, message, Boolean.valueOf(z)}) == null) {
        }
    }

    public yx6(a07.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = dVar;
    }

    @Override // com.baidu.tieba.uj7
    public void a(boolean z, Message message, boolean z2, long j, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), message, Boolean.valueOf(z2), Long.valueOf(j), str, Integer.valueOf(i)}) == null) {
            zx6 zx6Var = new zx6();
            nj7 nj7Var = new nj7();
            nj7Var.a = j;
            nj7Var.b = str;
            jj7 a = sj7.d().a(nj7Var);
            if (a != null) {
                a.c(z, message, z2, i);
            }
            zx6Var.b(a);
            a07.d dVar = this.a;
            if (dVar != null) {
                dVar.e(z, zx6Var, z2, "", str, true);
            }
        }
    }

    @Override // com.baidu.tieba.uj7
    public void b(long j, String str, String str2, int i) {
        a07.d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), str, str2, Integer.valueOf(i)}) == null) && (dVar = this.a) != null) {
            dVar.c(str, str2, i, true, 1);
        }
    }
}
