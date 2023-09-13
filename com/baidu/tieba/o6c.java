package com.baidu.tieba;

import android.opengl.GLES20;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class o6c extends p6c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int l;
    public n4c m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o6c(v6c v6cVar) {
        super(v6cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v6cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((v6c) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = -1;
        this.m = new n4c(0.7f, 0.9f, 0.95f, 0.75f);
    }

    @Override // com.baidu.tieba.p6c
    public void a(String str, String str2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048576, this, str, str2, i, i2) == null) {
            super.a(str, str2, i, i2);
            GLES20.glUseProgram(this.a);
            this.l = GLES20.glGetUniformLocation(this.a, "u_frontArea");
            w6c.c("PipUniform", this.j);
            int i3 = this.l;
            n4c n4cVar = this.m;
            GLES20.glUniform4f(i3, n4cVar.b, n4cVar.c, n4cVar.d, n4cVar.e);
            GLES20.glUseProgram(0);
        }
    }

    @Override // com.baidu.tieba.p6c
    public void i(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) && obj != null && this.l != -1) {
            n4c n4cVar = (n4c) obj;
            if (!n4cVar.equals(this.m)) {
                GLES20.glUniform4f(this.l, n4cVar.b, n4cVar.d, n4cVar.c, n4cVar.e);
                this.m = n4cVar;
            }
        }
    }
}
