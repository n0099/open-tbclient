package com.baidu.tieba;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.InputStream;
import okio.Okio;
/* loaded from: classes7.dex */
public class vf6 implements uf6<String, Pair<InputStream, Long>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public vf6() {
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

    public final File c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            File file = new File(Uri.parse(str).getPath());
            if (file.exists() && file.isFile()) {
                return file;
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.uf6
    @Nullable
    /* renamed from: d */
    public Pair<InputStream, Long> a(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            File c = c(str);
            if (c != null) {
                return Pair.create(Okio.buffer(Okio.source(c)).inputStream(), Long.valueOf(c.length()));
            }
            return null;
        }
        return (Pair) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.uf6
    /* renamed from: e */
    public void b(String str, x7b<Pair<InputStream, Long>, Exception> x7bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, x7bVar) == null) {
            try {
                File c = c(str);
                if (c != null) {
                    x7bVar.call(Pair.create(Okio.buffer(Okio.source(c)).inputStream(), Long.valueOf(c.length())), null);
                } else {
                    x7bVar.call(null, new IllegalArgumentException(str + "file not exist !"));
                }
            } catch (Exception e) {
                x7bVar.call(null, e);
            }
        }
    }
}
