package com.bytedance.pangle.util;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;
/* loaded from: classes2.dex */
public final class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public long f55234b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public static long a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, file)) == null) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            try {
                return a(randomAccessFile, a(randomAccessFile));
            } finally {
                randomAccessFile.close();
            }
        }
        return invokeL.longValue;
    }

    public static a a(RandomAccessFile randomAccessFile) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, randomAccessFile)) == null) {
            long length = randomAccessFile.length() - 22;
            if (length >= 0) {
                long j2 = length - 65536;
                long j3 = j2 >= 0 ? j2 : 0L;
                int reverseBytes = Integer.reverseBytes(101010256);
                do {
                    randomAccessFile.seek(length);
                    if (randomAccessFile.readInt() == reverseBytes) {
                        randomAccessFile.skipBytes(2);
                        randomAccessFile.skipBytes(2);
                        randomAccessFile.skipBytes(2);
                        randomAccessFile.skipBytes(2);
                        a aVar = new a();
                        aVar.f55234b = Integer.reverseBytes(randomAccessFile.readInt()) & 4294967295L;
                        aVar.a = Integer.reverseBytes(randomAccessFile.readInt()) & 4294967295L;
                        return aVar;
                    }
                    length--;
                } while (length >= j3);
                throw new ZipException("End Of Central Directory signature not found");
            }
            throw new ZipException("File too short to be a zip file: " + randomAccessFile.length());
        }
        return (a) invokeL.objValue;
    }

    public static long a(RandomAccessFile randomAccessFile, a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, randomAccessFile, aVar)) == null) {
            CRC32 crc32 = new CRC32();
            long j2 = aVar.f55234b;
            randomAccessFile.seek(aVar.a);
            int min = (int) Math.min(16384L, j2);
            byte[] bArr = new byte[16384];
            while (true) {
                int read = randomAccessFile.read(bArr, 0, min);
                if (read == -1) {
                    break;
                }
                crc32.update(bArr, 0, read);
                j2 -= read;
                if (j2 == 0) {
                    break;
                }
                min = (int) Math.min(16384L, j2);
            }
            return crc32.getValue();
        }
        return invokeLL.longValue;
    }
}
