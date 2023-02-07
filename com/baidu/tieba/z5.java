package com.baidu.tieba;

import com.badlogic.gdx.utils.BufferUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
/* loaded from: classes7.dex */
public class z5 implements a6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ShortBuffer a;
    public final ByteBuffer b;
    public final boolean c;
    public int d;
    public final boolean e;

    public z5(boolean z, int i) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (i == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.e = z2;
        ByteBuffer e = BufferUtils.e((z2 ? 1 : i) * 2);
        this.b = e;
        ShortBuffer asShortBuffer = e.asShortBuffer();
        this.a = asShortBuffer;
        this.c = true;
        asShortBuffer.flip();
        this.b.flip();
        this.d = l1.f.n();
    }

    @Override // com.baidu.tieba.a6, com.baidu.tieba.o7
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            l1.f.E(34963, 0);
            l1.f.b(this.d);
            this.d = 0;
            if (this.c) {
                BufferUtils.b(this.b);
            }
        }
    }

    @Override // com.baidu.tieba.a6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.e) {
                return 0;
            }
            return this.a.limit();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.a6
    public ShortBuffer getBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (ShortBuffer) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a6
    public void invalidate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.d = l1.f.n();
        }
    }
}
