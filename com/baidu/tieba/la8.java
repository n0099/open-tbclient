package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dd8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
/* loaded from: classes7.dex */
public class la8 implements bh9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dd8.c a;

    @Override // com.baidu.tieba.bh9
    public void c(long j, String str, Message message, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), str, message, Boolean.valueOf(z)}) == null) {
        }
    }

    public la8(dd8.c cVar) {
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

    @Override // com.baidu.tieba.bh9
    public void a(boolean z, Message message, boolean z2, long j, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), message, Boolean.valueOf(z2), Long.valueOf(j), str, Integer.valueOf(i)}) == null) {
            ma8 ma8Var = new ma8();
            ug9 ug9Var = new ug9();
            ug9Var.a = j;
            ug9Var.b = str;
            qg9 a = zg9.d().a(ug9Var);
            if (a != null) {
                a.b(z, message, z2, i);
            }
            ma8Var.b(a);
            dd8.c cVar = this.a;
            if (cVar != null) {
                cVar.d(z, ma8Var, z2, "", str, true);
            }
        }
    }

    @Override // com.baidu.tieba.bh9
    public void b(long j, String str, String str2, int i) {
        dd8.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), str, str2, Integer.valueOf(i)}) == null) && (cVar = this.a) != null) {
            cVar.b(str, str2, i, true, 1);
        }
    }
}
