package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sdk.container.filedownloader.MaterialLoader;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes5.dex */
public class pg1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public pg1(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public final boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            File a = we1.a(str);
            if (a != null && a.exists() && a.isFile()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public Bitmap a(String str, wg1 wg1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, wg1Var)) == null) {
            try {
                File a = we1.a(str);
                if (a != null && a.exists() && a.isFile()) {
                    return BitmapFactory.decodeFile(a.getAbsolutePath());
                }
            } catch (OutOfMemoryError unused) {
            }
            return MaterialLoader.k(this.a).i(str, wg1Var);
        }
        return (Bitmap) invokeLL.objValue;
    }

    public String b(String str, MaterialLoader.MaterialCacheType materialCacheType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, materialCacheType)) == null) {
            try {
                File a = we1.a(str);
                if (a != null && a.exists() && a.isFile()) {
                    return a.getAbsolutePath();
                }
                return MaterialLoader.k(this.a).m(str, materialCacheType);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public boolean c(String str, MaterialLoader.MaterialCacheType materialCacheType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, materialCacheType)) == null) {
            if (!MaterialLoader.k(this.a).o(str, materialCacheType) && !d(str)) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
