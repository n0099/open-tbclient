package com.baidu.tieba;

import android.opengl.GLES20;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class j3c extends k3c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int l;
    public i1c m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j3c(q3c q3cVar) {
        super(q3cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q3cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((q3c) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = -1;
        this.m = new i1c(0.7f, 0.9f, 0.95f, 0.75f);
    }

    @Override // com.baidu.tieba.k3c
    public void a(String str, String str2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048576, this, str, str2, i, i2) == null) {
            super.a(str, str2, i, i2);
            GLES20.glUseProgram(this.a);
            this.l = GLES20.glGetUniformLocation(this.a, "u_frontArea");
            r3c.c("PipUniform", this.j);
            int i3 = this.l;
            i1c i1cVar = this.m;
            GLES20.glUniform4f(i3, i1cVar.b, i1cVar.c, i1cVar.d, i1cVar.e);
            GLES20.glUseProgram(0);
        }
    }

    @Override // com.baidu.tieba.k3c
    public void i(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) && obj != null && this.l != -1) {
            i1c i1cVar = (i1c) obj;
            if (!i1cVar.equals(this.m)) {
                GLES20.glUniform4f(this.l, i1cVar.b, i1cVar.d, i1cVar.c, i1cVar.e);
                this.m = i1cVar;
            }
        }
    }
}
