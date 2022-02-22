package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class MarkEnforcingInputStream extends FilterInputStream {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int END_OF_STREAM = -1;
    public static final int UNSET = Integer.MIN_VALUE;
    public transient /* synthetic */ FieldHolder $fh;
    public int availableBytes;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarkEnforcingInputStream(@NonNull InputStream inputStream) {
        super(inputStream);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((InputStream) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.availableBytes = Integer.MIN_VALUE;
    }

    private long getBytesToRead(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65537, this, j2)) == null) {
            int i2 = this.availableBytes;
            if (i2 == 0) {
                return -1L;
            }
            return (i2 == Integer.MIN_VALUE || j2 <= ((long) i2)) ? j2 : i2;
        }
        return invokeJ.longValue;
    }

    private void updateAvailableBytesAfterRead(long j2) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(65538, this, j2) == null) || (i2 = this.availableBytes) == Integer.MIN_VALUE || j2 == -1) {
            return;
        }
        this.availableBytes = (int) (i2 - j2);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = this.availableBytes;
            return i2 == Integer.MIN_VALUE ? super.available() : Math.min(i2, super.available());
        }
        return invokeV.intValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            synchronized (this) {
                super.mark(i2);
                this.availableBytes = i2;
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (getBytesToRead(1L) == -1) {
                return -1;
            }
            int read = super.read();
            updateAvailableBytesAfterRead(1L);
            return read;
        }
        return invokeV.intValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                super.reset();
                this.availableBytes = Integer.MIN_VALUE;
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j2) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
            long bytesToRead = getBytesToRead(j2);
            if (bytesToRead == -1) {
                return 0L;
            }
            long skip = super.skip(bytesToRead);
            updateAvailableBytesAfterRead(skip);
            return skip;
        }
        return invokeJ.longValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i2, i3)) == null) {
            int bytesToRead = (int) getBytesToRead(i3);
            if (bytesToRead == -1) {
                return -1;
            }
            int read = super.read(bArr, i2, bytesToRead);
            updateAvailableBytesAfterRead(read);
            return read;
        }
        return invokeLII.intValue;
    }
}
