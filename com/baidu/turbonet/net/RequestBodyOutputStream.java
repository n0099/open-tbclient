package com.baidu.turbonet.net;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class RequestBodyOutputStream extends OutputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final PipedOutputStreamAndroid25 a;

    /* renamed from: b  reason: collision with root package name */
    public final PipedInputStreamAndroid25 f37751b;

    /* renamed from: c  reason: collision with root package name */
    public String f37752c;

    /* renamed from: d  reason: collision with root package name */
    public int f37753d;

    /* renamed from: e  reason: collision with root package name */
    public int f37754e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f37755f;

    public int b(ByteBuffer byteBuffer) throws IOException {
        InterceptResult invokeL;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, byteBuffer)) == null) {
            int min = Math.min(byteBuffer.remaining(), this.f37753d);
            int i = 0;
            do {
                read = this.f37751b.read(this.f37755f, i, min - i);
                if (read > 0) {
                    i += read;
                }
                if (i >= this.f37754e) {
                    break;
                }
            } while (read >= 0);
            if (i > 0) {
                byteBuffer.put(this.f37755f, 0, i);
            }
            return i;
        }
        return invokeL.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f37753d : invokeV.intValue;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!"".equals(this.f37752c)) {
                String str = "\r\n--" + this.f37752c + "--\r\n";
                write(str.getBytes(), 0, str.getBytes().length);
            }
            this.a.close();
        }
    }

    public void e() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f37751b.close();
            this.a.close();
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.a.write(i);
            this.a.flush();
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, bArr, i, i2) == null) {
            this.a.write(bArr, i, i2);
            this.a.flush();
        }
    }
}
