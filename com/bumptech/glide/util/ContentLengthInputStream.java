package com.bumptech.glide.util;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes7.dex */
public final class ContentLengthInputStream extends FilterInputStream {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ContentLengthStream";
    public static final int UNKNOWN = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public final long contentLength;
    public int readSoFar;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentLengthInputStream(InputStream inputStream, long j) {
        super(inputStream);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((InputStream) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.contentLength = j;
    }

    private int checkReadSoFarOrThrow(int i) throws IOException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i)) == null) {
            if (i >= 0) {
                this.readSoFar += i;
            } else if (this.contentLength - this.readSoFar > 0) {
                throw new IOException("Failed to read all expected data, expected: " + this.contentLength + ", but read: " + this.readSoFar);
            }
            return i;
        }
        return invokeI.intValue;
    }

    public static InputStream obtain(InputStream inputStream, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, null, inputStream, j)) == null) {
            return new ContentLengthInputStream(inputStream, j);
        }
        return (InputStream) invokeLJ.objValue;
    }

    public static InputStream obtain(InputStream inputStream, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, inputStream, str)) == null) {
            return obtain(inputStream, parseContentLength(str));
        }
        return (InputStream) invokeLL.objValue;
    }

    public static int parseContentLength(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return Integer.parseInt(str);
                } catch (NumberFormatException e) {
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "failed to parse content length header: " + str, e);
                    }
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InterceptResult invokeV;
        int max;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                max = (int) Math.max(this.contentLength - this.readSoFar, ((FilterInputStream) this).in.available());
            }
            return max;
        }
        return invokeV.intValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        InterceptResult invokeV;
        int read;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                read = super.read();
                if (read >= 0) {
                    i = 1;
                } else {
                    i = -1;
                }
                checkReadSoFarOrThrow(i);
            }
            return read;
        }
        return invokeV.intValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr)) == null) {
            return read(bArr, 0, bArr.length);
        }
        return invokeL.intValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        InterceptResult invokeLII;
        int checkReadSoFarOrThrow;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i, i2)) == null) {
            synchronized (this) {
                checkReadSoFarOrThrow = checkReadSoFarOrThrow(super.read(bArr, i, i2));
            }
            return checkReadSoFarOrThrow;
        }
        return invokeLII.intValue;
    }
}
