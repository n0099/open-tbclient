package com.baidu.turbonet.net;

import com.android.internal.http.multipart.Part;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class RequestBodyOutputStream extends OutputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final PipedOutputStreamAndroid25 f59456e;

    /* renamed from: f  reason: collision with root package name */
    public final PipedInputStreamAndroid25 f59457f;

    /* renamed from: g  reason: collision with root package name */
    public String f59458g;

    /* renamed from: h  reason: collision with root package name */
    public int f59459h;

    /* renamed from: i  reason: collision with root package name */
    public int f59460i;

    /* renamed from: j  reason: collision with root package name */
    public byte[] f59461j;

    public int b(ByteBuffer byteBuffer) throws IOException {
        InterceptResult invokeL;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, byteBuffer)) == null) {
            int min = Math.min(byteBuffer.remaining(), this.f59459h);
            int i2 = 0;
            do {
                read = this.f59457f.read(this.f59461j, i2, min - i2);
                if (read > 0) {
                    i2 += read;
                }
                if (i2 >= this.f59460i) {
                    break;
                }
            } while (read >= 0);
            if (i2 > 0) {
                byteBuffer.put(this.f59461j, 0, i2);
            }
            return i2;
        }
        return invokeL.intValue;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!"".equals(this.f59458g)) {
                String str = "\r\n--" + this.f59458g + "--" + Part.CRLF;
                write(str.getBytes(), 0, str.getBytes().length);
            }
            this.f59456e.close();
        }
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f59459h : invokeV.intValue;
    }

    public void n() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f59457f.close();
            this.f59456e.close();
        }
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f59456e.write(i2);
            this.f59456e.flush();
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, bArr, i2, i3) == null) {
            this.f59456e.write(bArr, i2, i3);
            this.f59456e.flush();
        }
    }
}
