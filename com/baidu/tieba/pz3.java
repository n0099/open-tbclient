package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class pz3 implements oz3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, qz3> a;
    public HashMap<String, ArrayList<oz3>> b;
    public String c;
    public w34 d;
    public final Object e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948079296, "Lcom/baidu/tieba/pz3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948079296, "Lcom/baidu/tieba/pz3;");
                return;
            }
        }
        f = am1.a;
    }

    public pz3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
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
        this.c = str;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (f) {
                Log.d("AudioDownloadManager", "AudioDownloader SwanGamePreloadManager url:" + str);
            }
            if (this.d == null) {
                this.d = w34.d();
            }
            qz3 qz3Var = new qz3(this.d, this.c, str, this);
            this.a.put(str, qz3Var);
            qz3Var.e();
        }
    }

    @Override // com.baidu.tieba.oz3
    public void a(String str, String str2) {
        ArrayList<oz3> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            synchronized (this.e) {
                if (e(str) && (arrayList = this.b.get(str)) != null) {
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        arrayList.get(i).a(str, str2);
                        if (f) {
                            Log.e("AudioDownloadManager", i + " load success url = " + str + " path = " + str2);
                        }
                    }
                    this.a.remove(str);
                }
            }
        }
    }

    public void f(String str, oz3 oz3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, oz3Var) == null) {
            synchronized (this.e) {
                if (!e(str)) {
                    if (f) {
                        Log.e("AudioDownloadManager", "start load url = " + str);
                    }
                    d(str);
                } else if (f) {
                    Log.e("AudioDownloadManager", "re load url = " + str);
                }
                c(str, oz3Var);
            }
        }
    }

    @Override // com.baidu.tieba.oz3
    public void b(int i, String str) {
        ArrayList<oz3> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            synchronized (this.e) {
                if (e(str) && (arrayList = this.b.get(str)) != null) {
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.get(i2).b(i, str);
                    }
                    this.a.remove(str);
                }
            }
        }
    }

    public final void c(String str, oz3 oz3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, oz3Var) == null) {
            if (this.b.containsKey(str)) {
                this.b.get(str).add(oz3Var);
                return;
            }
            ArrayList<oz3> arrayList = new ArrayList<>();
            arrayList.add(oz3Var);
            this.b.put(str, arrayList);
        }
    }

    public final boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return this.a.containsKey(str);
        }
        return invokeL.booleanValue;
    }
}
