package com.baidu.tieba;

import android.annotation.TargetApi;
import android.opengl.GLES30;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.Buffer;
import java.nio.IntBuffer;
@TargetApi(18)
/* loaded from: classes6.dex */
public class j2 extends i2 implements h3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public j2() {
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

    @Override // com.baidu.tieba.h3
    public void A(int i, IntBuffer intBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, intBuffer) == null) {
            GLES30.glDeleteVertexArrays(i, intBuffer);
        }
    }

    @Override // com.baidu.tieba.h3
    public void c(int i, IntBuffer intBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, intBuffer) == null) {
            GLES30.glDrawBuffers(i, intBuffer);
        }
    }

    @Override // com.baidu.tieba.h3
    public void v(int i, IntBuffer intBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, intBuffer) == null) {
            GLES30.glGenVertexArrays(i, intBuffer);
        }
    }

    @Override // com.baidu.tieba.h3
    public void O(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, Buffer buffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), buffer}) == null) {
            if (buffer == null) {
                GLES30.glTexImage3D(i, i2, i3, i4, i5, i6, i7, i8, i9, 0);
            } else {
                GLES30.glTexImage3D(i, i2, i3, i4, i5, i6, i7, i8, i9, buffer);
            }
        }
    }
}
