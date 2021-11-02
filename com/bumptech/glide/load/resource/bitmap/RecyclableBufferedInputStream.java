package com.bumptech.glide.load.resource.bitmap;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes11.dex */
public class RecyclableBufferedInputStream extends FilterInputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile byte[] buf;
    public final ArrayPool byteArrayPool;
    public int count;
    public int marklimit;
    public int markpos;
    public int pos;

    /* loaded from: classes11.dex */
    public static class InvalidMarkException extends IOException {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -4338378848813561757L;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidMarkException(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool) {
        this(inputStream, arrayPool, 65536);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, arrayPool};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((InputStream) objArr2[0], (ArrayPool) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private int fillbuf(InputStream inputStream, byte[] bArr) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, inputStream, bArr)) == null) {
            int i2 = this.markpos;
            if (i2 != -1) {
                int i3 = this.pos - i2;
                int i4 = this.marklimit;
                if (i3 < i4) {
                    if (i2 == 0 && i4 > bArr.length && this.count == bArr.length) {
                        int length = bArr.length * 2;
                        if (length <= i4) {
                            i4 = length;
                        }
                        byte[] bArr2 = (byte[]) this.byteArrayPool.get(i4, byte[].class);
                        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                        this.buf = bArr2;
                        this.byteArrayPool.put(bArr);
                        bArr = bArr2;
                    } else {
                        int i5 = this.markpos;
                        if (i5 > 0) {
                            System.arraycopy(bArr, i5, bArr, 0, bArr.length - i5);
                        }
                    }
                    int i6 = this.pos - this.markpos;
                    this.pos = i6;
                    this.markpos = 0;
                    this.count = 0;
                    int read = inputStream.read(bArr, i6, bArr.length - i6);
                    int i7 = this.pos;
                    if (read > 0) {
                        i7 += read;
                    }
                    this.count = i7;
                    return read;
                }
            }
            int read2 = inputStream.read(bArr);
            if (read2 > 0) {
                this.markpos = -1;
                this.pos = 0;
                this.count = read2;
            }
            return read2;
        }
        return invokeLL.intValue;
    }

    public static IOException streamClosed() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            throw new IOException("BufferedInputStream is closed");
        }
        return (IOException) invokeV.objValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InterceptResult invokeV;
        int available;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                InputStream inputStream = ((FilterInputStream) this).in;
                if (this.buf != null && inputStream != null) {
                    available = (this.count - this.pos) + inputStream.available();
                } else {
                    throw streamClosed();
                }
            }
            return available;
        }
        return invokeV.intValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.buf != null) {
                this.byteArrayPool.put(this.buf);
                this.buf = null;
            }
            InputStream inputStream = ((FilterInputStream) this).in;
            ((FilterInputStream) this).in = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public synchronized void fixMarkLimit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.marklimit = this.buf.length;
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            synchronized (this) {
                this.marklimit = Math.max(this.marklimit, i2);
                this.markpos = this.pos;
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                byte[] bArr = this.buf;
                InputStream inputStream = ((FilterInputStream) this).in;
                if (bArr != null && inputStream != null) {
                    if (this.pos < this.count || fillbuf(inputStream, bArr) != -1) {
                        if (bArr != this.buf && (bArr = this.buf) == null) {
                            throw streamClosed();
                        }
                        if (this.count - this.pos > 0) {
                            int i2 = this.pos;
                            this.pos = i2 + 1;
                            return bArr[i2] & 255;
                        }
                        return -1;
                    }
                    return -1;
                }
                throw streamClosed();
            }
        }
        return invokeV.intValue;
    }

    public synchronized void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                if (this.buf != null) {
                    this.byteArrayPool.put(this.buf);
                    this.buf = null;
                }
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this) {
                if (this.buf != null) {
                    if (-1 != this.markpos) {
                        this.pos = this.markpos;
                    } else {
                        throw new InvalidMarkException("Mark has been invalidated, pos: " + this.pos + " markLimit: " + this.marklimit);
                    }
                } else {
                    throw new IOException("Stream is closed");
                }
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
            synchronized (this) {
                if (j < 1) {
                    return 0L;
                }
                byte[] bArr = this.buf;
                if (bArr != null) {
                    InputStream inputStream = ((FilterInputStream) this).in;
                    if (inputStream != null) {
                        if (this.count - this.pos >= j) {
                            this.pos = (int) (this.pos + j);
                            return j;
                        }
                        long j2 = this.count - this.pos;
                        this.pos = this.count;
                        if (this.markpos != -1 && j <= this.marklimit) {
                            if (fillbuf(inputStream, bArr) == -1) {
                                return j2;
                            }
                            if (this.count - this.pos >= j - j2) {
                                this.pos = (int) ((this.pos + j) - j2);
                                return j;
                            }
                            long j3 = (j2 + this.count) - this.pos;
                            this.pos = this.count;
                            return j3;
                        }
                        return j2 + inputStream.skip(j - j2);
                    }
                    throw streamClosed();
                }
                throw streamClosed();
            }
        }
        return invokeJ.longValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @VisibleForTesting
    public RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool, int i2) {
        super(inputStream);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, arrayPool, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((InputStream) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.markpos = -1;
        this.byteArrayPool = arrayPool;
        this.buf = (byte[]) arrayPool.get(i2, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(@NonNull byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeLII;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLII = interceptable.invokeLII(1048582, this, bArr, i2, i3)) != null) {
            return invokeLII.intValue;
        }
        synchronized (this) {
            byte[] bArr2 = this.buf;
            if (bArr2 == null) {
                throw streamClosed();
            }
            if (i3 == 0) {
                return 0;
            }
            InputStream inputStream = ((FilterInputStream) this).in;
            if (inputStream != null) {
                if (this.pos < this.count) {
                    int i6 = this.count - this.pos >= i3 ? i3 : this.count - this.pos;
                    System.arraycopy(bArr2, this.pos, bArr, i2, i6);
                    this.pos += i6;
                    if (i6 == i3 || inputStream.available() == 0) {
                        return i6;
                    }
                    i2 += i6;
                    i4 = i3 - i6;
                } else {
                    i4 = i3;
                }
                while (true) {
                    if (this.markpos == -1 && i4 >= bArr2.length) {
                        i5 = inputStream.read(bArr, i2, i4);
                        if (i5 == -1) {
                            return i4 != i3 ? i3 - i4 : -1;
                        }
                    } else if (fillbuf(inputStream, bArr2) == -1) {
                        return i4 != i3 ? i3 - i4 : -1;
                    } else {
                        if (bArr2 != this.buf && (bArr2 = this.buf) == null) {
                            throw streamClosed();
                        }
                        i5 = this.count - this.pos >= i4 ? i4 : this.count - this.pos;
                        System.arraycopy(bArr2, this.pos, bArr, i2, i5);
                        this.pos += i5;
                    }
                    i4 -= i5;
                    if (i4 == 0) {
                        return i3;
                    }
                    if (inputStream.available() == 0) {
                        return i3 - i4;
                    }
                    i2 += i5;
                }
            } else {
                throw streamClosed();
            }
        }
    }
}
