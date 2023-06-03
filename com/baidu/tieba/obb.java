package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
/* loaded from: classes7.dex */
public class obb {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "SecureX509SingleInstance";
    public static volatile pbb b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948027898, "Lcom/baidu/tieba/obb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948027898, "Lcom/baidu/tieba/obb;");
        }
    }

    public obb() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static pbb a(Context context) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (context != null) {
                vbb.b(context);
                if (b == null) {
                    synchronized (obb.class) {
                        if (b == null) {
                            InputStream n = tbb.n(context);
                            if (n == null) {
                                ybb.e(a, "get assets bks");
                                n = context.getAssets().open("hmsrootcas.bks");
                            } else {
                                ybb.e(a, "get files bks");
                            }
                            b = new pbb(n, "");
                            new wbb().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, context);
                        }
                    }
                }
                String str = a;
                ybb.b(str, "SecureX509TrustManager getInstance: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                return b;
            }
            throw new NullPointerException("context is null");
        }
        return (pbb) invokeL.objValue;
    }
}
