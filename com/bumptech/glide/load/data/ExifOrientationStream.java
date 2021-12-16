package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public final class ExifOrientationStream extends FilterInputStream {
    public static /* synthetic */ Interceptable $ic = null;
    public static final byte[] EXIF_SEGMENT;
    public static final int ORIENTATION_POSITION;
    public static final int SEGMENT_LENGTH;
    public static final int SEGMENT_START_POSITION = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte orientation;
    public int position;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1049220074, "Lcom/bumptech/glide/load/data/ExifOrientationStream;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1049220074, "Lcom/bumptech/glide/load/data/ExifOrientationStream;");
                return;
            }
        }
        byte[] bArr = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        EXIF_SEGMENT = bArr;
        int length = bArr.length;
        SEGMENT_LENGTH = length;
        ORIENTATION_POSITION = length + 2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExifOrientationStream(InputStream inputStream, int i2) {
        super(inputStream);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, Integer.valueOf(i2)};
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
        if (i2 >= -1 && i2 <= 8) {
            this.orientation = (byte) i2;
            return;
        }
        throw new IllegalArgumentException("Cannot add invalid orientation: " + i2);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        InterceptResult invokeV;
        int read;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i3 = this.position;
            if (i3 < 2 || i3 > (i2 = ORIENTATION_POSITION)) {
                read = super.read();
            } else if (i3 == i2) {
                read = this.orientation;
            } else {
                read = EXIF_SEGMENT[i3 - 2] & 255;
            }
            if (read != -1) {
                this.position++;
            }
            return read;
        }
        return invokeV.intValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j2) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
            long skip = super.skip(j2);
            if (skip > 0) {
                this.position = (int) (this.position + skip);
            }
            return skip;
        }
        return invokeJ.longValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeLII;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i2, i3)) == null) {
            int i5 = this.position;
            int i6 = ORIENTATION_POSITION;
            if (i5 > i6) {
                i4 = super.read(bArr, i2, i3);
            } else if (i5 == i6) {
                bArr[i2] = this.orientation;
                i4 = 1;
            } else if (i5 < 2) {
                i4 = super.read(bArr, i2, 2 - i5);
            } else {
                int min = Math.min(i6 - i5, i3);
                System.arraycopy(EXIF_SEGMENT, this.position - 2, bArr, i2, min);
                i4 = min;
            }
            if (i4 > 0) {
                this.position += i4;
            }
            return i4;
        }
        return invokeLII.intValue;
    }
}
