package com.bytedance.sdk.component.b.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public final class m implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c f64742a;

    /* renamed from: b  reason: collision with root package name */
    public final r f64743b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f64744c;

    public m(r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64742a = new c();
        if (rVar != null) {
            this.f64743b = rVar;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    @Override // com.bytedance.sdk.component.b.a.r
    public t a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64743b.a() : (t) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.r
    public void a_(c cVar, long j2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, j2) == null) {
            if (!this.f64744c) {
                this.f64742a.a_(cVar, j2);
                u();
                return;
            }
            throw new IllegalStateException("closed");
        }
    }

    @Override // com.bytedance.sdk.component.b.a.d
    public d b(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (!this.f64744c) {
                this.f64742a.b(str);
                return u();
            }
            throw new IllegalStateException("closed");
        }
        return (d) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.d, com.bytedance.sdk.component.b.a.e
    public c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f64742a : (c) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f64744c) {
            return;
        }
        Throwable th = null;
        try {
            if (this.f64742a.f64717b > 0) {
                this.f64743b.a_(this.f64742a, this.f64742a.f64717b);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f64743b.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f64744c = true;
        if (th != null) {
            u.a(th);
        }
    }

    @Override // com.bytedance.sdk.component.b.a.d, com.bytedance.sdk.component.b.a.r, java.io.Flushable
    public void flush() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (!this.f64744c) {
                c cVar = this.f64742a;
                long j2 = cVar.f64717b;
                if (j2 > 0) {
                    this.f64743b.a_(cVar, j2);
                }
                this.f64743b.flush();
                return;
            }
            throw new IllegalStateException("closed");
        }
    }

    @Override // com.bytedance.sdk.component.b.a.d
    public d g(int i2) throws IOException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            if (!this.f64744c) {
                this.f64742a.g(i2);
                return u();
            }
            throw new IllegalStateException("closed");
        }
        return (d) invokeI.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.d
    public d h(int i2) throws IOException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            if (!this.f64744c) {
                this.f64742a.h(i2);
                return u();
            }
            throw new IllegalStateException("closed");
        }
        return (d) invokeI.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.d
    public d i(int i2) throws IOException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            if (!this.f64744c) {
                this.f64742a.i(i2);
                return u();
            }
            throw new IllegalStateException("closed");
        }
        return (d) invokeI.objValue;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? !this.f64744c : invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.component.b.a.d
    public d k(long j2) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048588, this, j2)) == null) {
            if (!this.f64744c) {
                this.f64742a.k(j2);
                return u();
            }
            throw new IllegalStateException("closed");
        }
        return (d) invokeJ.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.d
    public d l(long j2) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048589, this, j2)) == null) {
            if (!this.f64744c) {
                this.f64742a.l(j2);
                return u();
            }
            throw new IllegalStateException("closed");
        }
        return (d) invokeJ.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return "buffer(" + this.f64743b + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.d
    public d u() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (!this.f64744c) {
                long g2 = this.f64742a.g();
                if (g2 > 0) {
                    this.f64743b.a_(this.f64742a, g2);
                }
                return this;
            }
            throw new IllegalStateException("closed");
        }
        return (d) invokeV.objValue;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, byteBuffer)) == null) {
            if (!this.f64744c) {
                int write = this.f64742a.write(byteBuffer);
                u();
                return write;
            }
            throw new IllegalStateException("closed");
        }
        return invokeL.intValue;
    }

    @Override // com.bytedance.sdk.component.b.a.d
    public d c(byte[] bArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bArr)) == null) {
            if (!this.f64744c) {
                this.f64742a.c(bArr);
                return u();
            }
            throw new IllegalStateException("closed");
        }
        return (d) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.d
    public d c(byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048581, this, bArr, i2, i3)) == null) {
            if (!this.f64744c) {
                this.f64742a.c(bArr, i2, i3);
                return u();
            }
            throw new IllegalStateException("closed");
        }
        return (d) invokeLII.objValue;
    }
}
