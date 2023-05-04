package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tieba.pc2;
import com.baidu.tieba.sc2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebResourceResponse;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class nc2 extends lc2 implements gc2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dc2 b;
    public ac2 c;
    public File d;
    public b e;

    /* loaded from: classes5.dex */
    public interface b {
        void onError(String str, int i, String str2);
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "image" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class c implements pc2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ac2 a;
        public String b;

        /* loaded from: classes5.dex */
        public class a implements bc2 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ File a;

            public a(c cVar, File file) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, file};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = file;
            }

            @Override // com.baidu.tieba.bc2
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    bo4.L(this.a);
                }
            }
        }

        public c(nc2 nc2Var, ac2 ac2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nc2Var, ac2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ac2Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.pc2.a
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                try {
                    this.a.a(this.b, file, new a(this, file));
                } catch (Exception e) {
                    if (gc2.a) {
                        Log.d("HybridIntercept", Log.getStackTraceString(e));
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pc2.a
        public void b(File file) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file) == null) && gc2.a) {
                Log.e("HybridIntercept", "writer file fail, file = " + file);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ nc2 d;

        public a(nc2 nc2Var, String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nc2Var, str, Integer.valueOf(i), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = nc2Var;
            this.a = str;
            this.b = i;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.d.e.onError(this.a, this.b, this.c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nc2(@NonNull Context context, ac2 ac2Var) {
        super(context, ac2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, ac2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (ac2) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = cc2.a().f();
        this.d = new File(cc2.a().b(), "image_temp");
        this.c = ac2Var;
        if (ac2Var == null) {
            h(context);
        }
    }

    @Override // com.baidu.tieba.sc2
    public WebResourceResponse a(@NonNull sc2.a aVar) {
        InterceptResult invokeL;
        boolean z;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            String d = aVar.d();
            if (!i(aVar)) {
                return aVar.b(d, aVar.getRequestHeaders(), aVar.c());
            }
            String f = f(d);
            InputStream inputStream = null;
            ac2 ac2Var = this.c;
            if (ac2Var != null && !ac2Var.isClosed()) {
                inputStream = this.c.get(f);
            }
            if (inputStream != null) {
                if (gc2.a) {
                    Log.d("HybridIntercept", "adopt cached image, url = " + f);
                }
                return new WebResourceResponse(aVar.getMimeType(), "UTF-8", inputStream);
            }
            mc2 a2 = qc2.a(f, g(aVar));
            if (a2 != null && (i = a2.a) >= 400 && this.e != null) {
                d(f, i, a2.b);
            }
            WebResourceResponse c2 = c(a2);
            if (c2 != null && c2.getData() != null) {
                c2.setData(new rc2(c2.getData(), new pc2(new File(this.d, cc2.a().d().a(f)), new c(this, this.c, f))));
            }
            if (gc2.a) {
                StringBuilder sb = new StringBuilder();
                sb.append("download image, response = ");
                if (c2 != null) {
                    z = true;
                } else {
                    z = false;
                }
                sb.append(z);
                sb.append(" ; url = ");
                sb.append(f);
                Log.e("HybridIntercept", sb.toString());
            }
            return c2;
        }
        return (WebResourceResponse) invokeL.objValue;
    }

    public final WebResourceResponse c(mc2 mc2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mc2Var)) == null) {
            if (mc2Var == null) {
                return null;
            }
            String str = mc2Var.e;
            if (str != null && str.toLowerCase().contains("html")) {
                mc2Var.e = SapiWebView.DATA_MIME_TYPE;
                mc2Var.d = "UTF-8";
            }
            if (ek3.f()) {
                return new WebResourceResponse(mc2Var.e, mc2Var.d, mc2Var.a, mc2Var.b, mc2Var.c, mc2Var.f);
            }
            return new WebResourceResponse(mc2Var.e, "UTF-8", mc2Var.f);
        }
        return (WebResourceResponse) invokeL.objValue;
    }

    public String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (str.startsWith("intercept") && str.length() > 9) {
                str = str.substring(9);
            }
            if (gc2.a) {
                Log.d("HybridIntercept", "remote request url = " + str);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public Map<String, String> g(@NonNull sc2.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            Map<String, String> requestHeaders = aVar.getRequestHeaders();
            if (requestHeaders == null) {
                requestHeaders = new HashMap<>();
            }
            String f = tg3.l().f(f(aVar.d()), requestHeaders.get("Cookie"));
            if (!TextUtils.isEmpty(f)) {
                requestHeaders.put("Cookie", f);
                if (gc2.a) {
                    Log.d("HybridIntercept", "addCookiesToHeader cookie: " + f);
                }
            }
            return requestHeaders;
        }
        return (Map) invokeL.objValue;
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            File b2 = cc2.a().b();
            String e = e();
            if (!TextUtils.isEmpty(e)) {
                b2 = new File(b2, e);
            }
            if (gc2.a) {
                Log.d("HybridIntercept", "init default disk cache provider, path = " + b2);
            }
            bo4.l(b2);
            this.c = er2.U().b(context, b2, cc2.a().g());
        }
    }

    public final void d(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, str, i, str2) == null) {
            rl3.q().post(new a(this, str, i, str2));
        }
    }

    public boolean i(@NonNull sc2.a aVar) {
        InterceptResult invokeL;
        Map<String, String> requestHeaders;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, aVar)) == null) {
            if (!aVar.c()) {
                return true;
            }
            if (this.b.a(aVar) && (requestHeaders = aVar.getRequestHeaders()) != null && requestHeaders.containsKey("Accept") && (str = requestHeaders.get("Accept")) != null && str.startsWith("image")) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
