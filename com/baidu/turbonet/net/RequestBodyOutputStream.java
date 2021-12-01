package com.baidu.turbonet.net;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
/* loaded from: classes11.dex */
public class RequestBodyOutputStream extends OutputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final PipedOutputStreamAndroid25 f51435e;

    /* renamed from: f  reason: collision with root package name */
    public final PipedInputStreamAndroid25 f51436f;

    /* renamed from: g  reason: collision with root package name */
    public String f51437g;

    /* renamed from: h  reason: collision with root package name */
    public int f51438h;

    /* renamed from: i  reason: collision with root package name */
    public int f51439i;

    /* renamed from: j  reason: collision with root package name */
    public byte[] f51440j;

    public int b(ByteBuffer byteBuffer) throws IOException {
        InterceptResult invokeL;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, byteBuffer)) == null) {
            int min = Math.min(byteBuffer.remaining(), this.f51438h);
            int i2 = 0;
            do {
                read = this.f51436f.read(this.f51440j, i2, min - i2);
                if (read > 0) {
                    i2 += read;
                }
                if (i2 >= this.f51439i) {
                    break;
                }
            } while (read >= 0);
            if (i2 > 0) {
                byteBuffer.put(this.f51440j, 0, i2);
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f51438h : invokeV.intValue;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!"".equals(this.f51437g)) {
                String str = "\r\n--" + this.f51437g + "--\r\n";
                write(str.getBytes(), 0, str.getBytes().length);
            }
            this.f51435e.close();
        }
    }

    public void e() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f51436f.close();
            this.f51435e.close();
        }
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f51435e.write(i2);
            this.f51435e.flush();
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, bArr, i2, i3) == null) {
            this.f51435e.write(bArr, i2, i3);
            this.f51435e.flush();
        }
    }
}
