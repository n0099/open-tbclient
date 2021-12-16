package com.bumptech.glide.util;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
/* loaded from: classes2.dex */
public final class ContentLengthInputStream extends FilterInputStream {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ContentLengthStream";
    public static final int UNKNOWN = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public final long contentLength;
    public int readSoFar;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentLengthInputStream(@NonNull InputStream inputStream, long j2) {
        super(inputStream);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, Long.valueOf(j2)};
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
        this.contentLength = j2;
    }

    private int checkReadSoFarOrThrow(int i2) throws IOException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) {
            if (i2 >= 0) {
                this.readSoFar += i2;
            } else if (this.contentLength - this.readSoFar > 0) {
                throw new IOException("Failed to read all expected data, expected: " + this.contentLength + ", but read: " + this.readSoFar);
            }
            return i2;
        }
        return invokeI.intValue;
    }

    @NonNull
    public static InputStream obtain(@NonNull InputStream inputStream, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, inputStream, str)) == null) ? obtain(inputStream, parseContentLength(str)) : (InputStream) invokeLL.objValue;
    }

    public static int parseContentLength(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return Integer.parseInt(str);
                } catch (NumberFormatException unused) {
                    if (Log.isLoggable(TAG, 3)) {
                        String str2 = "failed to parse content length header: " + str;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                read = super.read();
                checkReadSoFarOrThrow(read >= 0 ? 1 : -1);
            }
            return read;
        }
        return invokeV.intValue;
    }

    @NonNull
    public static InputStream obtain(@NonNull InputStream inputStream, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, null, inputStream, j2)) == null) ? new ContentLengthInputStream(inputStream, j2) : (InputStream) invokeLJ.objValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr)) == null) ? read(bArr, 0, bArr.length) : invokeL.intValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeLII;
        int checkReadSoFarOrThrow;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i2, i3)) == null) {
            synchronized (this) {
                checkReadSoFarOrThrow = checkReadSoFarOrThrow(super.read(bArr, i2, i3));
            }
            return checkReadSoFarOrThrow;
        }
        return invokeLII.intValue;
    }
}
