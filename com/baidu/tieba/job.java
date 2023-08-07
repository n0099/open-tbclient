package com.baidu.tieba;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public final class job {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
            Log.e("Utils", "Exception when closing the 'Closeable'.");
        }
    }

    public static void b(Reader reader, Writer writer) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, reader, writer) == null) {
            c(reader, writer, new char[4096]);
        }
    }

    public static void c(Reader reader, Writer writer, char[] cArr) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLL(65538, null, reader, writer, cArr) != null) {
            return;
        }
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                return;
            }
            writer.write(cArr, 0, read);
        }
    }

    public static Map<String, String> d(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, map)) == null) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                hashMap.put(e(entry.getKey()), entry.getValue());
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            int i = 0;
            if (str.length() > 0) {
                while (str.charAt(i) == '/') {
                    i++;
                }
            }
            return "/" + str.substring(i);
        }
        return (String) invokeL.objValue;
    }

    public static aob f(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            if (str != null) {
                char c = 65535;
                int hashCode = str.hashCode();
                if (hashCode != 2155) {
                    if (hashCode != 2177) {
                        if (hashCode != 2627) {
                            if (hashCode == 2644 && str.equals("SG")) {
                                c = 3;
                            }
                        } else if (str.equals("RU")) {
                            c = 2;
                        }
                    } else if (str.equals("DE")) {
                        c = 1;
                    }
                } else if (str.equals("CN")) {
                    c = 0;
                }
                if (c == 0) {
                    return aob.c;
                }
                if (c == 1) {
                    return aob.d;
                }
                if (c == 2) {
                    return aob.e;
                }
                if (c == 3) {
                    return aob.f;
                }
            }
            if (str2 != null) {
                if (str2.contains("connect-drcn")) {
                    return aob.c;
                }
                if (str2.contains("connect-dre")) {
                    return aob.d;
                }
                if (str2.contains("connect-drru")) {
                    return aob.e;
                }
                if (str2.contains("connect-dra")) {
                    return aob.f;
                }
            }
            return aob.b;
        }
        return (aob) invokeLL.objValue;
    }

    public static String g(InputStream inputStream, String str) throws UnsupportedEncodingException, IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, inputStream, str)) == null) {
            StringWriter stringWriter = new StringWriter();
            b(new InputStreamReader(inputStream, str), stringWriter);
            return stringWriter.toString();
        }
        return (String) invokeLL.objValue;
    }
}
