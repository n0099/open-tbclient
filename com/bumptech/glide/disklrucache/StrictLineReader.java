package com.bumptech.glide.disklrucache;

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
/* loaded from: classes11.dex */
public class StrictLineReader implements Closeable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final byte CR = 13;
    public static final byte LF = 10;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] buf;
    public final Charset charset;
    public int end;
    public final InputStream in;
    public int pos;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StrictLineReader(InputStream inputStream, Charset charset) {
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

    private void fillBuf() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            InputStream inputStream = this.in;
            byte[] bArr = this.buf;
            int read = inputStream.read(bArr, 0, bArr.length);
            if (read != -1) {
                this.pos = 0;
                this.end = read;
                return;
            }
            throw new EOFException();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this.in) {
                if (this.buf != null) {
                    this.buf = null;
                    this.in.close();
                }
            }
        }
    }

    public boolean hasUnterminatedLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.end == -1 : invokeV.booleanValue;
    }

    public String readLine() throws IOException {
        InterceptResult invokeV;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this.in) {
                if (this.buf != null) {
                    if (this.pos >= this.end) {
                        fillBuf();
                    }
                    for (int i4 = this.pos; i4 != this.end; i4++) {
                        if (this.buf[i4] == 10) {
                            if (i4 != this.pos) {
                                i3 = i4 - 1;
                                if (this.buf[i3] == 13) {
                                    String str = new String(this.buf, this.pos, i3 - this.pos, this.charset.name());
                                    this.pos = i4 + 1;
                                    return str;
                                }
                            }
                            i3 = i4;
                            String str2 = new String(this.buf, this.pos, i3 - this.pos, this.charset.name());
                            this.pos = i4 + 1;
                            return str2;
                        }
                    }
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(this, (this.end - this.pos) + 80) { // from class: com.bumptech.glide.disklrucache.StrictLineReader.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ StrictLineReader this$0;

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
                            this.this$0 = this;
                        }

                        @Override // java.io.ByteArrayOutputStream
                        public String toString() {
                            InterceptResult invokeV2;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) {
                                int i5 = ((ByteArrayOutputStream) this).count;
                                try {
                                    return new String(((ByteArrayOutputStream) this).buf, 0, (i5 <= 0 || ((ByteArrayOutputStream) this).buf[i5 + (-1)] != 13) ? ((ByteArrayOutputStream) this).count : i5 - 1, this.this$0.charset.name());
                                } catch (UnsupportedEncodingException e2) {
                                    throw new AssertionError(e2);
                                }
                            }
                            return (String) invokeV2.objValue;
                        }
                    };
                    loop1: while (true) {
                        byteArrayOutputStream.write(this.buf, this.pos, this.end - this.pos);
                        this.end = -1;
                        fillBuf();
                        i2 = this.pos;
                        while (i2 != this.end) {
                            if (this.buf[i2] == 10) {
                                break loop1;
                            }
                            i2++;
                        }
                    }
                    if (i2 != this.pos) {
                        byteArrayOutputStream.write(this.buf, this.pos, i2 - this.pos);
                    }
                    this.pos = i2 + 1;
                    return byteArrayOutputStream.toString();
                }
                throw new IOException("LineReader is closed");
            }
        }
        return (String) invokeV.objValue;
    }

    public StrictLineReader(InputStream inputStream, int i2, Charset charset) {
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
            if (charset.equals(Util.US_ASCII)) {
                this.in = inputStream;
                this.charset = charset;
                this.buf = new byte[i2];
                return;
            }
            throw new IllegalArgumentException("Unsupported encoding");
        }
        throw new IllegalArgumentException("capacity <= 0");
    }
}
