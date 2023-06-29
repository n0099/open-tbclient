package com.baidu.tieba;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.log.DefaultLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.vy5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class xy5 {
    public static /* synthetic */ Interceptable $ic;
    public static List<String> a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements vy5.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // com.baidu.tieba.vy5.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ew8 defaultLog = DefaultLog.getInstance();
                defaultLog.c("WebPreheat", "预热成功:" + this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements MessageQueue.IdleHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;
        public final /* synthetic */ vy5.b c;

        public b(Context context, String str, vy5.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = str;
            this.c = bVar;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                vy5 a = wy5.b().a(this.a.getApplicationContext(), this.b);
                if (a != null) {
                    a.b(this.c);
                    return false;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948316725, "Lcom/baidu/tieba/xy5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948316725, "Lcom/baidu/tieba/xy5;");
                return;
            }
        }
        a = new ArrayList();
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            for (String str2 : a) {
                if (str2 != null && str != null && str.startsWith(str2)) {
                    return str2;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static void c(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, jSONArray) != null) || jSONArray == null) {
            return;
        }
        a.clear();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                a.add((String) jSONArray.get(i));
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
    }

    public static void b(WebView webView) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, webView) != null) || webView == null) {
            return;
        }
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setDatabaseEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setTextZoom(100);
        webView.getSettings().setDatabasePath(webView.getContext().getApplicationContext().getDir("databases", 0).getAbsolutePath());
        webView.setHorizontalScrollBarEnabled(false);
        webView.setHorizontalScrollbarOverlay(false);
    }

    public static boolean d(Context context, String str, vy5.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, bVar)) == null) {
            if (!TextUtils.isEmpty(str) && !wy5.b().d(str)) {
                Looper.myQueue().addIdleHandler(new b(context, str, bVar));
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static void e(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, null, jSONArray) != null) || jSONArray == null) {
            return;
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            String optString = jSONArray.optString(i);
            d(TbadkCoreApplication.getInst(), optString, new a(optString));
        }
    }
}
