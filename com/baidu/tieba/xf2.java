package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tieba.cg2;
import com.baidu.tieba.zf2;
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
/* loaded from: classes8.dex */
public class xf2 extends vf2 implements qf2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nf2 b;
    public kf2 c;
    public File d;
    public b e;

    /* loaded from: classes8.dex */
    public interface b {
        void onError(String str, int i, String str2);
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "image" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class c implements zf2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public kf2 a;
        public String b;

        /* loaded from: classes8.dex */
        public class a implements lf2 {
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

            @Override // com.baidu.tieba.lf2
            public void onFinished() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    lr4.L(this.a);
                }
            }
        }

        public c(xf2 xf2Var, kf2 kf2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf2Var, kf2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kf2Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.zf2.a
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                try {
                    this.a.a(this.b, file, new a(this, file));
                } catch (Exception e) {
                    if (qf2.a) {
                        Log.d("HybridIntercept", Log.getStackTraceString(e));
                    }
                }
            }
        }

        @Override // com.baidu.tieba.zf2.a
        public void b(File file) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file) == null) && qf2.a) {
                Log.e("HybridIntercept", "writer file fail, file = " + file);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ xf2 d;

        public a(xf2 xf2Var, String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf2Var, str, Integer.valueOf(i), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = xf2Var;
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
    public xf2(@NonNull Context context, kf2 kf2Var) {
        super(context, kf2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, kf2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (kf2) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = mf2.a().f();
        this.d = new File(mf2.a().b(), "image_temp");
        this.c = kf2Var;
        if (kf2Var == null) {
            h(context);
        }
    }

    @Override // com.baidu.tieba.cg2
    public WebResourceResponse a(@NonNull cg2.a aVar) {
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
            kf2 kf2Var = this.c;
            if (kf2Var != null && !kf2Var.isClosed()) {
                inputStream = this.c.get(f);
            }
            if (inputStream != null) {
                if (qf2.a) {
                    Log.d("HybridIntercept", "adopt cached image, url = " + f);
                }
                return new WebResourceResponse(aVar.getMimeType(), "UTF-8", inputStream);
            }
            wf2 a2 = ag2.a(f, g(aVar));
            if (a2 != null && (i = a2.a) >= 400 && this.e != null) {
                d(f, i, a2.b);
            }
            WebResourceResponse c2 = c(a2);
            if (c2 != null && c2.getData() != null) {
                c2.setData(new bg2(c2.getData(), new zf2(new File(this.d, mf2.a().d().a(f)), new c(this, this.c, f))));
            }
            if (qf2.a) {
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

    public final WebResourceResponse c(wf2 wf2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wf2Var)) == null) {
            if (wf2Var == null) {
                return null;
            }
            String str = wf2Var.e;
            if (str != null && str.toLowerCase().contains(IMConstants.IM_RECEIVE_SERVER_COMMON_TYPE_HTML)) {
                wf2Var.e = SapiWebView.DATA_MIME_TYPE;
                wf2Var.d = "UTF-8";
            }
            if (on3.f()) {
                return new WebResourceResponse(wf2Var.e, wf2Var.d, wf2Var.a, wf2Var.b, wf2Var.c, wf2Var.f);
            }
            return new WebResourceResponse(wf2Var.e, "UTF-8", wf2Var.f);
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
            if (qf2.a) {
                Log.d("HybridIntercept", "remote request url = " + str);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public Map<String, String> g(@NonNull cg2.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            Map<String, String> requestHeaders = aVar.getRequestHeaders();
            if (requestHeaders == null) {
                requestHeaders = new HashMap<>();
            }
            String f = dk3.l().f(f(aVar.d()), requestHeaders.get("Cookie"));
            if (!TextUtils.isEmpty(f)) {
                requestHeaders.put("Cookie", f);
                if (qf2.a) {
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
            File b2 = mf2.a().b();
            String e = e();
            if (!TextUtils.isEmpty(e)) {
                b2 = new File(b2, e);
            }
            if (qf2.a) {
                Log.d("HybridIntercept", "init default disk cache provider, path = " + b2);
            }
            lr4.l(b2);
            this.c = ou2.U().b(context, b2, mf2.a().g());
        }
    }

    public final void d(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, str, i, str2) == null) {
            bp3.q().post(new a(this, str, i, str2));
        }
    }

    public boolean i(@NonNull cg2.a aVar) {
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
