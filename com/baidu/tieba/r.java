package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class r implements s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public r() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.s
    public boolean a(Context context, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, file)) == null) {
            Object g = t.g(t.g(context.getClassLoader(), "pathList"), "nativeLibraryDirectories");
            if (g instanceof File[]) {
                return t.f((File[]) g, file);
            }
            return ((ArrayList) g).contains(file);
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.s
    public void b(Context context, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, file) == null) {
            Object g = t.g(context.getClassLoader(), "pathList");
            Object g2 = t.g(g, "nativeLibraryDirectories");
            if (g2 instanceof File[]) {
                t.e(g, "nativeLibraryDirectories", t.c(File.class, (File[]) g2, file));
            } else {
                ((ArrayList) g2).add(file);
            }
        }
    }
}
