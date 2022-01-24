package com.baidu.turbonet.net;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
/* loaded from: classes13.dex */
public class RequestBodyOutputStream extends OutputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final PipedOutputStreamAndroid25 f50266e;

    /* renamed from: f  reason: collision with root package name */
    public final PipedInputStreamAndroid25 f50267f;

    /* renamed from: g  reason: collision with root package name */
    public String f50268g;

    /* renamed from: h  reason: collision with root package name */
    public int f50269h;

    /* renamed from: i  reason: collision with root package name */
    public int f50270i;

    /* renamed from: j  reason: collision with root package name */
    public byte[] f50271j;

    public int b(ByteBuffer byteBuffer) throws IOException {
        InterceptResult invokeL;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, byteBuffer)) == null) {
            int min = Math.min(byteBuffer.remaining(), this.f50269h);
            int i2 = 0;
            do {
                read = this.f50267f.read(this.f50271j, i2, min - i2);
                if (read > 0) {
                    i2 += read;
                }
                if (i2 >= this.f50270i) {
                    break;
                }
            } while (read >= 0);
            if (i2 > 0) {
                byteBuffer.put(this.f50271j, 0, i2);
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f50269h : invokeV.intValue;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!"".equals(this.f50268g)) {
                String str = "\r\n--" + this.f50268g + "--\r\n";
                write(str.getBytes(), 0, str.getBytes().length);
            }
            this.f50266e.close();
        }
    }

    public void e() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f50267f.close();
            this.f50266e.close();
        }
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f50266e.write(i2);
            this.f50266e.flush();
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, bArr, i2, i3) == null) {
            this.f50266e.write(bArr, i2, i3);
            this.f50266e.flush();
        }
    }
}
