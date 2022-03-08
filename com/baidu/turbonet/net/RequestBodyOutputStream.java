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

    /* renamed from: e  reason: collision with root package name */
    public final PipedOutputStreamAndroid25 f48852e;

    /* renamed from: f  reason: collision with root package name */
    public final PipedInputStreamAndroid25 f48853f;

    /* renamed from: g  reason: collision with root package name */
    public String f48854g;

    /* renamed from: h  reason: collision with root package name */
    public int f48855h;

    /* renamed from: i  reason: collision with root package name */
    public int f48856i;

    /* renamed from: j  reason: collision with root package name */
    public byte[] f48857j;

    public int b(ByteBuffer byteBuffer) throws IOException {
        InterceptResult invokeL;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, byteBuffer)) == null) {
            int min = Math.min(byteBuffer.remaining(), this.f48855h);
            int i2 = 0;
            do {
                read = this.f48853f.read(this.f48857j, i2, min - i2);
                if (read > 0) {
                    i2 += read;
                }
                if (i2 >= this.f48856i) {
                    break;
                }
            } while (read >= 0);
            if (i2 > 0) {
                byteBuffer.put(this.f48857j, 0, i2);
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f48855h : invokeV.intValue;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!"".equals(this.f48854g)) {
                String str = "\r\n--" + this.f48854g + "--\r\n";
                write(str.getBytes(), 0, str.getBytes().length);
            }
            this.f48852e.close();
        }
    }

    public void e() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f48853f.close();
            this.f48852e.close();
        }
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f48852e.write(i2);
            this.f48852e.flush();
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, bArr, i2, i3) == null) {
            this.f48852e.write(bArr, i2, i3);
            this.f48852e.flush();
        }
    }
}
