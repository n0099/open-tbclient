package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.m83;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class l83 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static k83 b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class b implements xi3<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m83.d a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap decodeFile;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (lg3.a()) {
                        decodeFile = ch3.e(this.a.a.b);
                    } else {
                        decodeFile = BitmapFactory.decodeFile(this.a.a.a);
                    }
                    File k = ch3.k("screenshot.jpg");
                    if (decodeFile != null) {
                        ch3.o(decodeFile, k.getAbsolutePath(), 20);
                    }
                    String h = rp2.U().G().h(k.getAbsolutePath());
                    if (!k.exists()) {
                        h = "";
                    }
                    l83.f(h);
                    if (l83.a) {
                        Log.d("SwanAppScreenshot", "saveScreenshot:" + TextUtils.isEmpty(h) + ",path:" + k.getAbsolutePath());
                    }
                }
            }
        }

        public b(m83.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                if (bool.booleanValue()) {
                    yg3.k(new a(this), "dispatchCaptureScreenEvent");
                } else {
                    l83.f("");
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class a implements k83 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // com.baidu.tieba.k83
        public void a(m83.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
                l83.e(dVar);
                if (!i83.c()) {
                    l83.i(dVar);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947896706, "Lcom/baidu/tieba/l83;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947896706, "Lcom/baidu/tieba/l83;");
                return;
            }
        }
        a = ok1.a;
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            i83.d();
        }
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            if (a) {
                Log.d("SwanAppScreenshot", "unRegisterScreenshotEvent.");
            }
            k83 k83Var = b;
            if (k83Var != null) {
                m83.u(k83Var);
                b = null;
            }
        }
    }

    public static void e(m83.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, dVar) == null) {
            i83.b(new b(dVar));
        }
    }

    public static void i(m83.d dVar) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65545, null, dVar) != null) || (activity = rp2.U().getActivity()) == null) {
            return;
        }
        ln2.f0().b(activity, dVar.a, dVar.b);
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, str) == null) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                eh3.f(jSONObject, "imagePath", str);
            }
            hashMap.put("data", jSONObject.toString());
            rp2.U().u(new fe2("onUserCaptureScreen", hashMap));
        }
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            m83.s(ln2.c());
            if (a) {
                Log.d("SwanAppScreenshot", "registerScreenshotEvent.");
            }
            if (b == null) {
                b = new a();
            }
            m83.r(b);
        }
    }
}
