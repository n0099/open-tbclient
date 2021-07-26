package com.bytedance.sdk.component.image.c.a.a;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
/* loaded from: classes5.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f28932a;

    /* renamed from: b  reason: collision with root package name */
    public static final Charset f28933b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1668615144, "Lcom/bytedance/sdk/component/image/c/a/a/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1668615144, "Lcom/bytedance/sdk/component/image/c/a/a/d;");
                return;
            }
        }
        f28932a = Charset.forName("US-ASCII");
        f28933b = Charset.forName("UTF-8");
    }

    public static void a(File file) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, file) == null) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        a(file2);
                    }
                    if (!file2.delete()) {
                        throw new IOException("failed to delete file: " + file2);
                    }
                }
                return;
            }
            throw new IOException("not a readable directory: " + file);
        }
    }
}
