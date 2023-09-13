package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.zxing.client.result.ResultParser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes7.dex */
public class pr4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a(InputStream inputStream) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, inputStream)) == null) {
            if (inputStream == null) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                try {
                    i = inputStream.read(bArr, 0, 1024);
                } catch (IOException unused) {
                    i = 0;
                }
                if (i != -1) {
                    byteArrayOutputStream.write(bArr, 0, i);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    lr4.d(byteArrayOutputStream);
                    return byteArray;
                }
            }
        } else {
            return (byte[]) invokeL.objValue;
        }
    }

    public static String c(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, inputStream)) == null) {
            try {
                byte[] a = a(inputStream);
                if (a != null) {
                    String str = new String(a);
                    if (str.startsWith(ResultParser.BYTE_ORDER_MARK)) {
                        str = str.substring(1);
                    }
                    lr4.d(inputStream);
                    return str;
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                lr4.d(inputStream);
                throw th;
            }
            lr4.d(inputStream);
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                return URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return str;
            }
        }
        return (String) invokeL.objValue;
    }
}
