package com.bytedance.pangle.res.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
/* loaded from: classes4.dex */
public final class e extends j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(InputStream inputStream) {
        super(inputStream);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((InputStream) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.bytedance.pangle.res.a.j
    public final synchronized void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            synchronized (this) {
                if (i != -1) {
                    this.a += i;
                }
            }
        }
    }

    public final synchronized long b() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                j = this.a;
            }
            return j;
        }
        return invokeV.longValue;
    }

    @Override // com.bytedance.pangle.res.a.j, java.io.FilterInputStream, java.io.InputStream
    public final synchronized long skip(long j) {
        InterceptResult invokeJ;
        long skip;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
            synchronized (this) {
                skip = super.skip(j);
                this.a += skip;
            }
            return skip;
        }
        return invokeJ.longValue;
    }

    public final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long b = b();
            if (b <= 2147483647L) {
                return (int) b;
            }
            throw new ArithmeticException("The byte count " + b + " is too large to be converted to an int");
        }
        return invokeV.intValue;
    }
}
