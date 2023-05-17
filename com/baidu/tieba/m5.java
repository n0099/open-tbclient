package com.baidu.tieba;

import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
/* loaded from: classes6.dex */
public class m5 implements o5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h3 a;
    public FloatBuffer b;
    public ByteBuffer c;
    public boolean d;
    public int e;
    public boolean f;

    public m5(boolean z, int i, h3 h3Var) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i), h3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = false;
        this.e = s0.f.n();
        ByteBuffer e = BufferUtils.e(h3Var.b * i);
        e.limit(0);
        a(e, true, h3Var);
        if (z) {
            i2 = 35044;
        } else {
            i2 = 35048;
        }
        f(i2);
    }

    public void a(Buffer buffer, boolean z, h3 h3Var) {
        ByteBuffer byteBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{buffer, Boolean.valueOf(z), h3Var}) == null) {
            if (!this.f) {
                if (this.d && (byteBuffer = this.c) != null) {
                    BufferUtils.b(byteBuffer);
                }
                this.a = h3Var;
                if (buffer instanceof ByteBuffer) {
                    ByteBuffer byteBuffer2 = (ByteBuffer) buffer;
                    this.c = byteBuffer2;
                    this.d = z;
                    int limit = byteBuffer2.limit();
                    ByteBuffer byteBuffer3 = this.c;
                    byteBuffer3.limit(byteBuffer3.capacity());
                    this.b = this.c.asFloatBuffer();
                    this.c.limit(limit);
                    this.b.limit(limit / 4);
                    return;
                }
                throw new GdxRuntimeException("Only ByteBuffer is currently supported");
            }
            throw new GdxRuntimeException("Cannot change attributes while VBO is bound");
        }
    }

    @Override // com.baidu.tieba.o5
    public h3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (h3) invokeV.objValue;
    }

    @Override // com.baidu.tieba.o5
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (this.b.limit() * 4) / this.a.b;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.o5, com.baidu.tieba.v6
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a3 a3Var = s0.f;
            a3Var.E(34962, 0);
            a3Var.b(this.e);
            this.e = 0;
            if (this.d) {
                BufferUtils.b(this.c);
            }
        }
    }

    @Override // com.baidu.tieba.o5
    public FloatBuffer getBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return (FloatBuffer) invokeV.objValue;
    }

    @Override // com.baidu.tieba.o5
    public void invalidate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.e = s0.f.n();
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048580, this, i) != null) || !this.f) {
            return;
        }
        throw new GdxRuntimeException("Cannot change usage while VBO is bound");
    }
}
