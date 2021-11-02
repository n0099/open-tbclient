package com.bytedance.pangle.f;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes11.dex */
public final class h implements k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ByteBuffer f61402a;

    public h(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {byteBuffer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61402a = byteBuffer.slice();
    }

    @Override // com.bytedance.pangle.f.k
    public final long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f61402a.capacity() : invokeV.longValue;
    }

    @Override // com.bytedance.pangle.f.k
    public final void a(j jVar, long j, int i2) {
        ByteBuffer slice;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{jVar, Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            synchronized (this.f61402a) {
                this.f61402a.position(0);
                int i3 = (int) j;
                this.f61402a.limit(i2 + i3);
                this.f61402a.position(i3);
                slice = this.f61402a.slice();
            }
            jVar.a(slice);
        }
    }
}
