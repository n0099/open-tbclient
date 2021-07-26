package com.bytedance.sdk.component.image.c.a.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
/* loaded from: classes5.dex */
public class c implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final InputStream f28926a;

    /* renamed from: b  reason: collision with root package name */
    public final Charset f28927b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f28928c;

    /* renamed from: d  reason: collision with root package name */
    public int f28929d;

    /* renamed from: e  reason: collision with root package name */
    public int f28930e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, charset};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((InputStream) objArr2[0], ((Integer) objArr2[1]).intValue(), (Charset) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void c() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            InputStream inputStream = this.f28926a;
            byte[] bArr = this.f28928c;
            int read = inputStream.read(bArr, 0, bArr.length);
            if (read != -1) {
                this.f28929d = 0;
                this.f28930e = read;
                return;
            }
            throw new EOFException();
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28930e == -1 : invokeV.booleanValue;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this.f28926a) {
                if (this.f28928c != null) {
                    this.f28928c = null;
                    this.f28926a.close();
                }
            }
        }
    }

    public c(InputStream inputStream, int i2, Charset charset) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, Integer.valueOf(i2), charset};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i2 >= 0) {
            if (charset.equals(d.f28932a)) {
                this.f28926a = inputStream;
                this.f28927b = charset;
                this.f28928c = new byte[i2];
                return;
            }
            throw new IllegalArgumentException("Unsupported encoding");
        }
        throw new IllegalArgumentException("capacity <= 0");
    }

    public String a() throws IOException {
        InterceptResult invokeV;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this.f28926a) {
                if (this.f28928c != null) {
                    if (this.f28929d >= this.f28930e) {
                        c();
                    }
                    for (int i4 = this.f28929d; i4 != this.f28930e; i4++) {
                        if (this.f28928c[i4] == 10) {
                            if (i4 != this.f28929d) {
                                i3 = i4 - 1;
                                if (this.f28928c[i3] == 13) {
                                    String str = new String(this.f28928c, this.f28929d, i3 - this.f28929d, this.f28927b.name());
                                    this.f28929d = i4 + 1;
                                    return str;
                                }
                            }
                            i3 = i4;
                            String str2 = new String(this.f28928c, this.f28929d, i3 - this.f28929d, this.f28927b.name());
                            this.f28929d = i4 + 1;
                            return str2;
                        }
                    }
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(this, (this.f28930e - this.f28929d) + 80) { // from class: com.bytedance.sdk.component.image.c.a.a.c.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ c f28931a;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(r8);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(r8)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i5 = newInitContext.flag;
                                if ((i5 & 1) != 0) {
                                    int i6 = i5 & 2;
                                    super(((Integer) newInitContext.callArgs[0]).intValue());
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f28931a = this;
                        }

                        @Override // java.io.ByteArrayOutputStream
                        public String toString() {
                            InterceptResult invokeV2;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) {
                                int i5 = ((ByteArrayOutputStream) this).count;
                                try {
                                    return new String(((ByteArrayOutputStream) this).buf, 0, (i5 <= 0 || ((ByteArrayOutputStream) this).buf[i5 + (-1)] != 13) ? ((ByteArrayOutputStream) this).count : i5 - 1, this.f28931a.f28927b.name());
                                } catch (UnsupportedEncodingException e2) {
                                    throw new AssertionError(e2);
                                }
                            }
                            return (String) invokeV2.objValue;
                        }
                    };
                    loop1: while (true) {
                        byteArrayOutputStream.write(this.f28928c, this.f28929d, this.f28930e - this.f28929d);
                        this.f28930e = -1;
                        c();
                        i2 = this.f28929d;
                        while (i2 != this.f28930e) {
                            if (this.f28928c[i2] == 10) {
                                break loop1;
                            }
                            i2++;
                        }
                    }
                    if (i2 != this.f28929d) {
                        byteArrayOutputStream.write(this.f28928c, this.f28929d, i2 - this.f28929d);
                    }
                    this.f28929d = i2 + 1;
                    return byteArrayOutputStream.toString();
                }
                throw new IOException("LineReader is closed");
            }
        }
        return (String) invokeV.objValue;
    }
}
