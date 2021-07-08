package com.bytedance.sdk.component.video.d;

import com.baidu.mobads.container.util.XAdSimpleImageLoader;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static File a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, str2)) == null) {
            File file = new File(str);
            if (file.isFile()) {
                file.delete();
            }
            if (!file.exists()) {
                file.mkdirs();
            }
            return new File(file, str2 + XAdSimpleImageLoader.TEMP_SUFFIX);
        }
        return (File) invokeLL.objValue;
    }

    public static File b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            File file = new File(str);
            if (file.isFile()) {
                file.delete();
            }
            if (!file.exists()) {
                file.mkdirs();
            }
            return new File(file, str2);
        }
        return (File) invokeLL.objValue;
    }

    public static void a(RandomAccessFile randomAccessFile, byte[] bArr, int i2, int i3, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{randomAccessFile, bArr, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) {
            try {
                randomAccessFile.seek(i2);
                randomAccessFile.write(bArr, 0, i3);
                c.b("VideoFilesUtils", "append:  pisition =", Integer.valueOf(i2), "  length =", Integer.valueOf(i3), " completed length=", Integer.valueOf(i2 + i3), " ", " hash =", str);
            } catch (Throwable th) {
                th.printStackTrace();
                c.b("VideoFilesUtils", "append:  pisition =", Integer.valueOf(i2), "  length =", Integer.valueOf(i3), " ", " hash =", str, th.getMessage());
            }
        }
    }
}
