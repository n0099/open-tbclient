package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import tv.athena.revenue.payui.model.NativeOperationParams;
import tv.athena.revenue.payui.webview.UrlPageParams;
/* loaded from: classes8.dex */
public class ykc {
    public static /* synthetic */ Interceptable $ic;
    public static Gson c;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;
    public Handler b;

    /* loaded from: classes8.dex */
    public interface c {
        void b(NativeOperationParams nativeOperationParams);

        void c(UrlPageParams urlPageParams);

        void e(UrlPageParams urlPageParams);

        String getToken();
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ UrlPageParams b;
        public final /* synthetic */ ykc c;

        public a(ykc ykcVar, int i, UrlPageParams urlPageParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ykcVar, Integer.valueOf(i), urlPageParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ykcVar;
            this.a = i;
            this.b = urlPageParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.c.a != null) {
                if (this.a == 1) {
                    this.c.a.e(this.b);
                }
                if (this.a == 3) {
                    this.c.a.c(this.b);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ykc c;

        public b(ykc ykcVar, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ykcVar, Integer.valueOf(i), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ykcVar;
            this.a = i;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.c.a != null) {
                this.c.a.b(new NativeOperationParams(this.a, this.b));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948334488, "Lcom/baidu/tieba/ykc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948334488, "Lcom/baidu/tieba/ykc;");
                return;
            }
        }
        c = new Gson();
    }

    @JavascriptInterface
    public String getToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c cVar = this.a;
            if (cVar != null) {
                return cVar.getToken();
            }
            RLog.error("YYPaySdkJsInterface", "getToken() mOnJsCallInterface null", new Object[0]);
            return "";
        }
        return (String) invokeV.objValue;
    }

    public ykc(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new Handler(Looper.getMainLooper());
        this.a = cVar;
    }

    public final void b(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                this.b.post(runnable);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    @JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void callAndroid(int i, String str) {
        String str2;
        UrlPageParams urlPageParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            RLog.info("YYPaySdkJsInterface", "callAndroid: code=" + i);
            switch (i) {
                case 1:
                case 3:
                    if (i == 1) {
                        str2 = "CODE_OPEN_URL_PAGE";
                    } else {
                        str2 = "CODE_UPFATE_TOP_INFO";
                    }
                    UrlPageParams urlPageParams2 = null;
                    try {
                        urlPageParams = (UrlPageParams) c.fromJson(str, (Class<Object>) UrlPageParams.class);
                        try {
                            RLog.info("YYPaySdkJsInterface", "%s params: %s", str2, urlPageParams);
                        } catch (Throwable th) {
                            th = th;
                            urlPageParams2 = urlPageParams;
                            RLog.error("YYPaySdkJsInterface", str2 + " error,", th);
                            urlPageParams = urlPageParams2;
                            if (this.a == null) {
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    if (this.a == null) {
                        b(new a(this, i, urlPageParams));
                        return;
                    }
                    return;
                case 2:
                default:
                    return;
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    if (this.a != null) {
                        b(new b(this, i, str));
                        return;
                    }
                    return;
            }
        }
    }
}
