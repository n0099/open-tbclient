package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.ValueCallback;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class od2 implements nd2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public static volatile od2 g;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, pd2> a;
    public HashMap<String, ArrayList<ValueCallback<String>>> b;
    public String c;
    public HttpManager d;
    public final Object e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948028332, "Lcom/baidu/tieba/od2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948028332, "Lcom/baidu/tieba/od2;");
                return;
            }
        }
        f = am1.a;
    }

    public static od2 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (g == null) {
                synchronized (od2.class) {
                    if (g == null) {
                        g = new od2();
                    }
                }
            }
            return g;
        }
        return (od2) invokeV.objValue;
    }

    public od2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
        this.b = new HashMap<>();
        this.e = new Object();
        this.d = xo2.l().b();
        this.c = xo2.f().a();
    }

    @Override // com.baidu.tieba.nd2
    public void a(String str, String str2) {
        ArrayList<ValueCallback<String>> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            synchronized (this.e) {
                if (g(str) && (arrayList = this.b.get(str)) != null) {
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        arrayList.get(i).onReceiveValue(str2);
                        if (f) {
                            Log.e("ImageDownloadManager", i + " load success url = " + str + " path = " + str2);
                        }
                    }
                    this.a.remove(str);
                }
            }
        }
    }

    public void h(String str, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, valueCallback) == null) {
            if (TextUtils.isEmpty(str)) {
                valueCallback.onReceiveValue(null);
                return;
            }
            try {
                String e = e(str);
                if (TextUtils.isEmpty(e)) {
                    return;
                }
                File file = new File(e(str));
                if (file.exists() && !file.isDirectory()) {
                    if (valueCallback != null) {
                        valueCallback.onReceiveValue(e);
                        return;
                    }
                    return;
                }
                synchronized (this.e) {
                    if (!g(str)) {
                        d(str);
                    }
                    c(str, valueCallback);
                }
            } catch (Exception e2) {
                if (f) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.tieba.nd2
    public void b(int i, String str) {
        ArrayList<ValueCallback<String>> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            synchronized (this.e) {
                if (g(str) && (arrayList = this.b.get(str)) != null) {
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.get(i2).onReceiveValue("");
                    }
                    this.a.remove(str);
                }
            }
        }
    }

    public final void c(String str, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, valueCallback) == null) {
            if (this.b.containsKey(str)) {
                this.b.get(str).add(valueCallback);
                return;
            }
            ArrayList<ValueCallback<String>> arrayList = new ArrayList<>();
            arrayList.add(valueCallback);
            this.b.put(str, arrayList);
        }
    }

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (f) {
                Log.d("ImageDownloadManager", "ImageDownloadManager SwanGamePreloadManager url:" + str);
            }
            pd2 pd2Var = new pd2(this.d, this.c, str, this);
            this.a.put(str, pd2Var);
            pd2Var.e();
        }
    }

    public final String e(String str) throws MalformedURLException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return this.c + xo2.f().c(str);
        }
        return (String) invokeL.objValue;
    }

    public final boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return this.a.containsKey(str);
        }
        return invokeL.booleanValue;
    }
}
