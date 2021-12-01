package com.baidu.webkit.internal.brotli;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.internal.brotli.DecoderJNI;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes12.dex */
public class Decoder implements INoProGuard {
    public static /* synthetic */ Interceptable $ic;
    public static final ByteBuffer EMPTY_BUFER;
    public transient /* synthetic */ FieldHolder $fh;
    public ByteBuffer buffer;
    public boolean closed;
    public final DecoderJNI.Wrapper decoder;
    public boolean eager;
    public final ReadableByteChannel source;

    /* renamed from: com.baidu.webkit.internal.brotli.Decoder$1  reason: invalid class name */
    /* loaded from: classes12.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(488566132, "Lcom/baidu/webkit/internal/brotli/Decoder$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(488566132, "Lcom/baidu/webkit/internal/brotli/Decoder$1;");
                    return;
                }
            }
            int[] iArr = new int[DecoderJNI.a.values().length];
            a = iArr;
            try {
                iArr[DecoderJNI.a.f54268b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[DecoderJNI.a.f54271e.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[DecoderJNI.a.f54269c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[DecoderJNI.a.f54270d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-446418463, "Lcom/baidu/webkit/internal/brotli/Decoder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-446418463, "Lcom/baidu/webkit/internal/brotli/Decoder;");
                return;
            }
        }
        EMPTY_BUFER = ByteBuffer.allocate(0);
    }

    public Decoder(ReadableByteChannel readableByteChannel, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {readableByteChannel, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("buffer size must be positive");
        }
        if (readableByteChannel == null) {
            throw new NullPointerException("source can not be null");
        }
        this.source = readableByteChannel;
        this.decoder = new DecoderJNI.Wrapper(i2);
    }

    public static byte[] decompress(byte[] bArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            DecoderJNI.Wrapper wrapper = new DecoderJNI.Wrapper(bArr.length);
            ArrayList arrayList = new ArrayList();
            try {
                wrapper.getInputBuffer().put(bArr);
                wrapper.push(bArr.length);
                int i2 = 0;
                while (wrapper.getStatus() != DecoderJNI.a.f54268b) {
                    int i3 = AnonymousClass1.a[wrapper.getStatus().ordinal()];
                    if (i3 == 2) {
                        wrapper.push(0);
                    } else if (i3 != 4) {
                        throw new IOException("corrupted input");
                    } else {
                        ByteBuffer pull = wrapper.pull();
                        int remaining = pull.remaining();
                        byte[] bArr2 = new byte[remaining];
                        pull.get(bArr2);
                        arrayList.add(bArr2);
                        i2 += remaining;
                    }
                }
                wrapper.destroy();
                if (arrayList.size() == 1) {
                    return (byte[]) arrayList.get(0);
                }
                byte[] bArr3 = new byte[i2];
                Iterator it = arrayList.iterator();
                int i4 = 0;
                while (it.hasNext()) {
                    byte[] bArr4 = (byte[]) it.next();
                    System.arraycopy(bArr4, 0, bArr3, i4, bArr4.length);
                    i4 += bArr4.length;
                }
                return bArr3;
            } catch (Throwable th) {
                wrapper.destroy();
                throw th;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    private void fail(String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, str) == null) {
            try {
                close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            throw new IOException(str);
        }
    }

    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.closed) {
            return;
        }
        this.closed = true;
        this.decoder.destroy();
        this.source.close();
    }

    public int consume(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteBuffer)) == null) {
            ByteBuffer slice = this.buffer.slice();
            int min = Math.min(slice.remaining(), byteBuffer.remaining());
            slice.limit(min);
            byteBuffer.put(slice);
            discard(min);
            return min;
        }
        return invokeL.intValue;
    }

    public int decode() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) != null) {
            return invokeV.intValue;
        }
        while (true) {
            ByteBuffer byteBuffer = this.buffer;
            if (byteBuffer != null) {
                if (byteBuffer.hasRemaining()) {
                    return this.buffer.remaining();
                }
                this.buffer = null;
            }
            int i2 = AnonymousClass1.a[this.decoder.getStatus().ordinal()];
            if (i2 == 1) {
                return -1;
            }
            if (i2 == 2) {
                this.decoder.push(0);
            } else if (i2 != 3) {
                if (i2 != 4) {
                    fail("corrupted input");
                } else {
                    this.buffer = this.decoder.pull();
                }
            } else if (this.eager && this.decoder.hasOutput()) {
                this.buffer = this.decoder.pull();
            } else {
                ByteBuffer inputBuffer = this.decoder.getInputBuffer();
                inputBuffer.clear();
                int read = this.source.read(inputBuffer);
                if (read == -1) {
                    fail("unexpected end of input");
                }
                if (read == 0) {
                    this.buffer = EMPTY_BUFER;
                    return 0;
                }
                this.decoder.push(read);
            }
        }
    }

    public void discard(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            ByteBuffer byteBuffer = this.buffer;
            byteBuffer.position(byteBuffer.position() + i2);
            if (this.buffer.hasRemaining()) {
                return;
            }
            this.buffer = null;
        }
    }

    public void enableEagerOutput() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.eager = true;
        }
    }
}
