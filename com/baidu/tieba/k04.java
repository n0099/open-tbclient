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
/* loaded from: classes6.dex */
public class k04 implements j04 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, l04> a;
    public HashMap<String, ArrayList<j04>> b;
    public String c;
    public r44 d;
    public final Object e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947859258, "Lcom/baidu/tieba/k04;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947859258, "Lcom/baidu/tieba/k04;");
                return;
            }
        }
        f = vm1.a;
    }

    public k04(String str) {
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
                this.d = r44.d();
            }
            l04 l04Var = new l04(this.d, this.c, str, this);
            this.a.put(str, l04Var);
            l04Var.e();
        }
    }

    @Override // com.baidu.tieba.j04
    public void a(String str, String str2) {
        ArrayList<j04> arrayList;
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

    public void f(String str, j04 j04Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, j04Var) == null) {
            synchronized (this.e) {
                if (!e(str)) {
                    if (f) {
                        Log.e("AudioDownloadManager", "start load url = " + str);
                    }
                    d(str);
                } else if (f) {
                    Log.e("AudioDownloadManager", "re load url = " + str);
                }
                c(str, j04Var);
            }
        }
    }

    @Override // com.baidu.tieba.j04
    public void b(int i, String str) {
        ArrayList<j04> arrayList;
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

    public final void c(String str, j04 j04Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, j04Var) == null) {
            if (this.b.containsKey(str)) {
                this.b.get(str).add(j04Var);
                return;
            }
            ArrayList<j04> arrayList = new ArrayList<>();
            arrayList.add(j04Var);
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
