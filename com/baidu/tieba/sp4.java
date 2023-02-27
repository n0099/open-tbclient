package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes6.dex */
public class sp4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(byte[] bArr, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65536, null, bArr, str, z)) == null) {
            StringBuilder sb = new StringBuilder();
            for (byte b : bArr) {
                String hexString = Integer.toHexString(b & 255);
                if (z) {
                    hexString = hexString.toUpperCase();
                }
                if (hexString.length() == 1) {
                    sb.append("0");
                }
                sb.append(hexString);
                sb.append(str);
            }
            return sb.toString();
        }
        return (String) invokeLLZ.objValue;
    }

    public static String b(File file, boolean z) {
        InterceptResult invokeLZ;
        ReadableByteChannel readableByteChannel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, file, z)) == null) {
            ReadableByteChannel readableByteChannel2 = null;
            try {
                readableByteChannel = Channels.newChannel(new FileInputStream(file));
            } catch (IOException unused) {
                readableByteChannel = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                String c = c(z, readableByteChannel);
                if (readableByteChannel != null && readableByteChannel.isOpen()) {
                    qp4.d(readableByteChannel);
                }
                return c;
            } catch (IOException unused2) {
                if (readableByteChannel != null && readableByteChannel.isOpen()) {
                    qp4.d(readableByteChannel);
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                readableByteChannel2 = readableByteChannel;
                if (readableByteChannel2 != null && readableByteChannel2.isOpen()) {
                    qp4.d(readableByteChannel2);
                }
                throw th;
            }
        }
        return (String) invokeLZ.objValue;
    }

    public static String c(boolean z, ReadableByteChannel readableByteChannel) throws IOException {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65538, null, z, readableByteChannel)) == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.reset();
                ByteBuffer allocate = ByteBuffer.allocate(8192);
                while (readableByteChannel.read(allocate) != -1) {
                    allocate.flip();
                    messageDigest.update(allocate);
                    allocate.clear();
                }
                return a(messageDigest.digest(), "", z);
            } catch (NoSuchAlgorithmException unused) {
                return null;
            }
        }
        return (String) invokeZL.objValue;
    }

    public static String d(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, bArr, z)) == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.reset();
                messageDigest.update(bArr);
                return a(messageDigest.digest(), "", z);
            } catch (NoSuchAlgorithmException unused) {
                return null;
            }
        }
        return (String) invokeLZ.objValue;
    }
}
