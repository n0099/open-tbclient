package com.bytedance.pangle.util;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
/* loaded from: classes7.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(InputStream inputStream, OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, inputStream, outputStream) == null) || inputStream == null) {
            return;
        }
        ReadableByteChannel newChannel = Channels.newChannel(inputStream);
        WritableByteChannel newChannel2 = Channels.newChannel(outputStream);
        a(newChannel, newChannel2);
        newChannel.close();
        newChannel2.close();
    }

    public static boolean a(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, file)) == null) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                FileChannel channel = fileOutputStream.getChannel();
                channel.write(ByteBuffer.wrap(str.getBytes()));
                channel.close();
                fileOutputStream.close();
                return true;
            } catch (IOException unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static void a(ReadableByteChannel readableByteChannel, WritableByteChannel writableByteChannel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, readableByteChannel, writableByteChannel) == null) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(4096);
            while (readableByteChannel.read(allocateDirect) != -1) {
                allocateDirect.flip();
                while (allocateDirect.hasRemaining()) {
                    writableByteChannel.write(allocateDirect);
                }
                allocateDirect.clear();
            }
        }
    }
}
