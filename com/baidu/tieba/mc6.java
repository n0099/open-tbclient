package com.baidu.tieba;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.IOUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import okio.BufferedSource;
import okio.Okio;
/* loaded from: classes5.dex */
public class mc6 implements lc6<String, byte[]> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public mc6() {
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

    public final File b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            File file = new File(Uri.parse(str).getPath());
            if (file.exists() && file.isFile()) {
                return file;
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lc6
    @Nullable
    /* renamed from: c */
    public byte[] a(String str) throws Exception {
        InterceptResult invokeL;
        File b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            BufferedSource bufferedSource = null;
            try {
                try {
                    b = b(str);
                } catch (Exception e) {
                    e.printStackTrace();
                    IOUtil.closeQuietly(bufferedSource);
                }
                if (b != null) {
                    bufferedSource = Okio.buffer(Okio.source(b));
                    byte[] readByteArray = bufferedSource.readByteArray();
                    IOUtil.closeQuietly(bufferedSource);
                    return readByteArray;
                }
                IOUtil.closeQuietly(null);
                return new byte[0];
            } catch (Throwable th) {
                IOUtil.closeQuietly(bufferedSource);
                throw th;
            }
        }
        return (byte[]) invokeL.objValue;
    }
}
