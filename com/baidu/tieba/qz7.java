package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.c28;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
/* loaded from: classes7.dex */
public class qz7 implements f19 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c28.c a;

    @Override // com.baidu.tieba.f19
    public void c(long j, String str, Message message, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), str, message, Boolean.valueOf(z)}) == null) {
        }
    }

    public qz7(c28.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cVar;
    }

    @Override // com.baidu.tieba.f19
    public void a(boolean z, Message message, boolean z2, long j, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), message, Boolean.valueOf(z2), Long.valueOf(j), str, Integer.valueOf(i)}) == null) {
            rz7 rz7Var = new rz7();
            y09 y09Var = new y09();
            y09Var.a = j;
            y09Var.b = str;
            u09 a = d19.d().a(y09Var);
            if (a != null) {
                a.b(z, message, z2, i);
            }
            rz7Var.b(a);
            c28.c cVar = this.a;
            if (cVar != null) {
                cVar.d(z, rz7Var, z2, "", str, true);
            }
        }
    }

    @Override // com.baidu.tieba.f19
    public void b(long j, String str, String str2, int i) {
        c28.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), str, str2, Integer.valueOf(i)}) == null) && (cVar = this.a) != null) {
            cVar.b(str, str2, i, true, 1);
        }
    }
}
