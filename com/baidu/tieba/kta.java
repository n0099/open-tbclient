package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.write.editor.EditorInfoContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class kta extends xh5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kta(Context context, String str) {
        super(context, (String) null, 15);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = false;
        this.t = context;
        this.n = 3;
        this.m = new EditorInfoContainer(context, str);
        this.p = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54, 57, 65};
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            yh5 yh5Var = this.m;
            if (yh5Var instanceof EditorInfoContainer) {
                ((EditorInfoContainer) yh5Var).o();
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            yh5 yh5Var = this.m;
            if (yh5Var instanceof EditorInfoContainer) {
                ((EditorInfoContainer) yh5Var).p();
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            yh5 yh5Var = this.m;
            if (yh5Var instanceof EditorInfoContainer) {
                ((EditorInfoContainer) yh5Var).q();
            }
        }
    }

    public void j(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, str, i) == null) {
            yh5 yh5Var = this.m;
            if (yh5Var instanceof EditorInfoContainer) {
                ((EditorInfoContainer) yh5Var).v(str, i);
            }
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            yh5 yh5Var = this.m;
            if (yh5Var instanceof EditorInfoContainer) {
                ((EditorInfoContainer) yh5Var).w(i);
            }
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            yh5 yh5Var = this.m;
            if (yh5Var instanceof EditorInfoContainer) {
                ((EditorInfoContainer) yh5Var).y(z);
            }
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            yh5 yh5Var = this.m;
            if (yh5Var instanceof EditorInfoContainer) {
                ((EditorInfoContainer) yh5Var).setFrom(str);
            }
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            yh5 yh5Var = this.m;
            if (yh5Var instanceof EditorInfoContainer) {
                ((EditorInfoContainer) yh5Var).D(z);
            }
        }
    }
}
