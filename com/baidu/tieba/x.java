package com.baidu.tieba;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cloudbase.download.exception.DownloadException;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class x {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<l10> a;
    public Context b;
    public Map<String, Integer> c;

    /* loaded from: classes6.dex */
    public class a extends c10 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l10 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ File c;
        public final /* synthetic */ File d;
        public final /* synthetic */ String e;
        public final /* synthetic */ x f;

        public a(x xVar, l10 l10Var, String str, File file, File file2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar, l10Var, str, file, file2, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = xVar;
            this.a = l10Var;
            this.b = str;
            this.c = file;
            this.d = file2;
            this.e = str2;
        }

        @Override // com.baidu.tieba.c10
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                try {
                    this.c.renameTo(this.d);
                    StringBuilder sb = new StringBuilder();
                    sb.append("unzip:");
                    sb.append(this.d);
                    sb.append("---");
                    sb.append(this.e);
                    Log.e("RtcDownSo", sb.toString());
                    m10.e(this.d, this.e);
                    m10.b(this.d.getAbsolutePath());
                    this.f.h(this.a, this.b, this.e);
                } catch (Exception e) {
                    e.printStackTrace();
                    m10.b(this.d.getAbsolutePath());
                    if (m10.c(this.e)) {
                        m10.a(new File(this.e));
                    }
                    this.f.e(this.a, this.b, 108, "unzip exception");
                }
            }
        }

        @Override // com.baidu.tieba.c10
        public void f(DownloadException downloadException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadException) == null) {
                downloadException.printStackTrace();
                m10.b(this.c.getAbsolutePath());
                this.f.e(this.a, this.b, downloadException.getErrorCode(), downloadException.getErrorMessage());
            }
        }

        @Override // com.baidu.tieba.c10
        public void g(long j, long j2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)}) == null) {
                this.f.f(this.a, this.b, i);
            }
        }

        @Override // com.baidu.tieba.c10
        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f.g(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static x a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948236435, "Lcom/baidu/tieba/x$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1948236435, "Lcom/baidu/tieba/x$b;");
                    return;
                }
            }
            a = new x();
        }
    }

    public x() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new HashMap();
    }

    public static x k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            b.a.b = context.getApplicationContext();
            return b.a;
        }
        return (x) invokeL.objValue;
    }

    public final void e(l10 l10Var, String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048576, this, l10Var, str, i, str2) == null) {
            this.c.put(str, 2);
            if (l10Var != null) {
                l10Var.onDownloadFail(str, i, str2);
            }
            if (this.a != null) {
                for (int i2 = 0; i2 < this.a.size(); i2++) {
                    this.a.get(i2).onDownloadFail(str, i, str2);
                }
            }
        }
    }

    public final void f(l10 l10Var, String str, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{l10Var, str, Float.valueOf(f)}) == null) {
            if (l10Var != null) {
                l10Var.onDownloadProgress(f);
            }
            if (this.a != null) {
                for (int i = 0; i < this.a.size(); i++) {
                    this.a.get(i).onDownloadProgress(f);
                }
            }
        }
    }

    public final void g(l10 l10Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, l10Var, str) == null) {
            if (l10Var != null) {
                l10Var.onDownloadStart(str);
            }
            if (this.a != null) {
                for (int i = 0; i < this.a.size(); i++) {
                    this.a.get(i).onDownloadStart(str);
                }
            }
        }
    }

    public final void h(l10 l10Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, l10Var, str, str2) == null) {
            this.c.put(str, 3);
            if (l10Var != null) {
                l10Var.onDownloadSuccess(str, str2);
            }
            if (this.a != null) {
                for (int i = 0; i < this.a.size(); i++) {
                    this.a.get(i).onDownloadSuccess(str, str2);
                }
            }
        }
    }

    public final void i(String str, String str2, Looper looper, l10 l10Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, str, str2, looper, l10Var) == null) {
            if (!m(str)) {
                m10.a(new File(str2));
            }
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.c.put(str, 1);
            String d = k10.d(this.b, str, str2);
            File file2 = new File(d + ".temp");
            File file3 = new File(d + ".zip");
            Log.d("RtcDownSo", "start down folder=" + str2 + "name=" + file2.getName());
            a10.i().h(str, str2, file2.getName(), looper, new a(this, l10Var, str, file2, file3, d));
        }
    }

    public void j(@NonNull String str, boolean z, l10 l10Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Boolean.valueOf(z), l10Var}) == null) {
            String b2 = k10.b(this.b);
            if (TextUtils.isEmpty(str)) {
                l10Var.onDownloadFail(str, 108, "download url is empty.");
            } else if (l(str, b2)) {
                if (l10Var != null) {
                    l10Var.onDownloadSuccess(str, k10.d(this.b, str, b2));
                }
            } else if (z) {
                if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                    Log.d("RtcDownSo", "start down so main thread");
                    i(str, b2, Looper.getMainLooper(), l10Var);
                    return;
                }
                Looper.prepare();
                Log.d("RtcDownSo", "start down so sub thread");
                i(str, b2, Looper.myLooper(), l10Var);
                Looper.loop();
            } else {
                i(str, b2, Looper.getMainLooper(), l10Var);
            }
        }
    }

    public boolean l(@NonNull String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) ? k10.m(this.b, str, str2) : invokeLL.booleanValue;
    }

    public final boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? a10.i().l(str) : invokeL.booleanValue;
    }

    public boolean n(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            File file = new File(str);
            if (file.exists()) {
                Context context = this.b;
                if (context == null ? false : t.a().a(context, file)) {
                    return true;
                }
                try {
                    t.a().b(this.b, file);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Context context2 = this.b;
                if (context2 == null) {
                    return false;
                }
                return t.a().a(context2, file);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void o() {
        List<l10> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (list = this.a) == null) {
            return;
        }
        list.clear();
        this.a = null;
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            k10.o(str);
        }
    }
}
