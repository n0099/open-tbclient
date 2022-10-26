package com.bumptech.glide.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ByteBufferUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final AtomicReference BUFFER_REF;
    public static final int BUFFER_SIZE = 16384;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class ByteBufferStream extends InputStream {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int UNSET = -1;
        public transient /* synthetic */ FieldHolder $fh;
        public final ByteBuffer byteBuffer;
        public int markPos;

        @Override // java.io.InputStream
        public boolean markSupported() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public ByteBufferStream(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {byteBuffer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.markPos = -1;
            this.byteBuffer = byteBuffer;
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                synchronized (this) {
                    this.markPos = this.byteBuffer.position();
                }
            }
        }

        @Override // java.io.InputStream
        public long skip(long j) throws IOException {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
                if (!this.byteBuffer.hasRemaining()) {
                    return -1L;
                }
                long min = Math.min(j, available());
                ByteBuffer byteBuffer = this.byteBuffer;
                byteBuffer.position((int) (byteBuffer.position() + min));
                return min;
            }
            return invokeJ.longValue;
        }

        @Override // java.io.InputStream
        public int available() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.byteBuffer.remaining();
            }
            return invokeV.intValue;
        }

        @Override // java.io.InputStream
        public int read() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (!this.byteBuffer.hasRemaining()) {
                    return -1;
                }
                return this.byteBuffer.get() & 255;
            }
            return invokeV.intValue;
        }

        @Override // java.io.InputStream
        public synchronized void reset() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                synchronized (this) {
                    if (this.markPos != -1) {
                        this.byteBuffer.position(this.markPos);
                    } else {
                        throw new IOException("Cannot reset to unset mark position");
                    }
                }
            }
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, bArr, i, i2)) == null) {
                if (!this.byteBuffer.hasRemaining()) {
                    return -1;
                }
                int min = Math.min(i2, available());
                this.byteBuffer.get(bArr, i, min);
                return min;
            }
            return invokeLII.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public final class SafeArray {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final byte[] data;
        public final int limit;
        public final int offset;

        public SafeArray(byte[] bArr, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bArr, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.data = bArr;
            this.offset = i;
            this.limit = i2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1750754889, "Lcom/bumptech/glide/util/ByteBufferUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1750754889, "Lcom/bumptech/glide/util/ByteBufferUtil;");
                return;
            }
        }
        BUFFER_REF = new AtomicReference();
    }

    public ByteBufferUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static ByteBuffer fromFile(File file) throws IOException {
        InterceptResult invokeL;
        RandomAccessFile randomAccessFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, file)) == null) {
            FileChannel fileChannel = null;
            try {
                long length = file.length();
                if (length <= 2147483647L) {
                    if (length != 0) {
                        randomAccessFile = new RandomAccessFile(file, "r");
                        try {
                            fileChannel = randomAccessFile.getChannel();
                            MappedByteBuffer load = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, length).load();
                            if (fileChannel != null) {
                                try {
                                    fileChannel.close();
                                } catch (IOException unused) {
                                }
                            }
                            try {
                                randomAccessFile.close();
                            } catch (IOException unused2) {
                            }
                            return load;
                        } catch (Throwable th) {
                            th = th;
                            if (fileChannel != null) {
                                try {
                                    fileChannel.close();
                                } catch (IOException unused3) {
                                }
                            }
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (IOException unused4) {
                                }
                            }
                            throw th;
                        }
                    }
                    throw new IOException("File unsuitable for memory mapping");
                }
                throw new IOException("File too large to map into memory");
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = null;
            }
        } else {
            return (ByteBuffer) invokeL.objValue;
        }
    }

    public static ByteBuffer fromStream(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, inputStream)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
            byte[] bArr = (byte[]) BUFFER_REF.getAndSet(null);
            if (bArr == null) {
                bArr = new byte[16384];
            }
            while (true) {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    BUFFER_REF.set(bArr);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    return (ByteBuffer) ByteBuffer.allocateDirect(byteArray.length).put(byteArray).position(0);
                }
            }
        } else {
            return (ByteBuffer) invokeL.objValue;
        }
    }

    public static SafeArray getSafeArray(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, byteBuffer)) == null) {
            if (!byteBuffer.isReadOnly() && byteBuffer.hasArray()) {
                return new SafeArray(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
            }
            return null;
        }
        return (SafeArray) invokeL.objValue;
    }

    public static byte[] toBytes(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, byteBuffer)) == null) {
            SafeArray safeArray = getSafeArray(byteBuffer);
            if (safeArray != null && safeArray.offset == 0 && safeArray.limit == safeArray.data.length) {
                return byteBuffer.array();
            }
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            byte[] bArr = new byte[asReadOnlyBuffer.limit()];
            asReadOnlyBuffer.position(0);
            asReadOnlyBuffer.get(bArr);
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public static void toFile(ByteBuffer byteBuffer, File file) throws IOException {
        RandomAccessFile randomAccessFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, byteBuffer, file) == null) {
            byteBuffer.position(0);
            FileChannel fileChannel = null;
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    fileChannel = randomAccessFile.getChannel();
                    fileChannel.write(byteBuffer);
                    fileChannel.force(false);
                    fileChannel.close();
                    randomAccessFile.close();
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException unused) {
                        }
                    }
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused2) {
                    }
                } catch (Throwable th) {
                    th = th;
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException unused3) {
                        }
                    }
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = null;
            }
        }
    }

    public static void toStream(ByteBuffer byteBuffer, OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, byteBuffer, outputStream) == null) {
            SafeArray safeArray = getSafeArray(byteBuffer);
            if (safeArray != null) {
                byte[] bArr = safeArray.data;
                int i = safeArray.offset;
                outputStream.write(bArr, i, safeArray.limit + i);
                return;
            }
            byte[] bArr2 = (byte[]) BUFFER_REF.getAndSet(null);
            if (bArr2 == null) {
                bArr2 = new byte[16384];
            }
            while (byteBuffer.remaining() > 0) {
                int min = Math.min(byteBuffer.remaining(), bArr2.length);
                byteBuffer.get(bArr2, 0, min);
                outputStream.write(bArr2, 0, min);
            }
            BUFFER_REF.set(bArr2);
        }
    }

    public static InputStream toStream(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, byteBuffer)) == null) {
            return new ByteBufferStream(byteBuffer);
        }
        return (InputStream) invokeL.objValue;
    }
}
