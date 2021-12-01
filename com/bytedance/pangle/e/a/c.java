package com.bytedance.pangle.e.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.EOFException;
import java.io.InputStream;
/* loaded from: classes12.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public InputStream a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f54571b;

    /* renamed from: c  reason: collision with root package name */
    public int f54572c;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final void a(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, inputStream) == null) {
            this.a = inputStream;
            this.f54571b = false;
            this.f54572c = 0;
        }
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i2 = 0;
            if (this.f54571b) {
                for (int i3 = 24; i3 >= 0; i3 -= 8) {
                    int read = this.a.read();
                    if (read == -1) {
                        throw new EOFException();
                    }
                    this.f54572c++;
                    i2 |= read << i3;
                }
                return i2;
            }
            int i4 = 0;
            while (i2 != 32) {
                int read2 = this.a.read();
                if (read2 == -1) {
                    throw new EOFException();
                }
                this.f54572c++;
                i4 |= read2 << i2;
                i2 += 8;
            }
            return i4;
        }
        return invokeV.intValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            long skip = this.a.skip(4L);
            this.f54572c = (int) (this.f54572c + skip);
            if (skip != 4) {
                throw new EOFException();
            }
        }
    }

    public c(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a(inputStream);
    }

    public final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? b() : invokeV.intValue;
    }

    public final int[] a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            int[] iArr = new int[i2];
            a(iArr, 0, i2);
            return iArr;
        }
        return (int[]) invokeI.objValue;
    }

    private void a(int[] iArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, this, iArr, i2, i3) == null) {
            while (i3 > 0) {
                iArr[i2] = b();
                i3--;
                i2++;
            }
        }
    }
}
