package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import dalvik.system.DexFile;
import java.io.File;
/* loaded from: classes6.dex */
public class w implements s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public w() {
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
            Object g = t.g(context.getClassLoader(), "pathList");
            if (c() != null) {
                for (Object obj : (Object[]) t.g(g, "nativeLibraryPathElements")) {
                    if (obj.toString().contains(file.toString())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.s
    public void b(Context context, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, file) == null) {
            Object g = t.g(context.getClassLoader(), "pathList");
            Class c = c();
            if (c != null) {
                Object[] objArr = (Object[]) t.g(g, "nativeLibraryPathElements");
                Object d = d(c, file);
                if (objArr == null || d == null) {
                    return;
                }
                t.e(g, "nativeLibraryPathElements", t.c(c, objArr, d));
            }
        }
    }

    public Class c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                return Class.forName("dalvik.system.DexPathList$Element");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (Class) invokeV.objValue;
    }

    public Object d(Class cls, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, cls, file)) == null) ? t.b(cls, new Class[]{File.class, Boolean.TYPE, File.class, DexFile.class}, new Object[]{file, Boolean.TRUE, null, null}) : invokeLL.objValue;
    }
}
