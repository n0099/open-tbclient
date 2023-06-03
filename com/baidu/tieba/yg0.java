package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.arface.utils.ThreadPool;
import com.baidu.tieba.ch0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Objects;
/* loaded from: classes8.dex */
public class yg0 extends ah0 {
    public static /* synthetic */ Interceptable $ic;
    public static yg0 g;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public File d;
    public Context e;
    public Boolean f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948329063, "Lcom/baidu/tieba/yg0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948329063, "Lcom/baidu/tieba/yg0;");
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yg0 a;

        public a(yg0 yg0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yg0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yg0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                yg0 yg0Var = this.a;
                yg0Var.p(yg0Var.e);
            }
        }
    }

    public yg0() {
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
        this.c = "arsource";
    }

    public static synchronized void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            synchronized (yg0.class) {
                if (g == null) {
                    g = new yg0();
                }
            }
        }
    }

    public static final yg0 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (g == null) {
                h();
            }
            return g;
        }
        return (yg0) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ah0
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ThreadPool.b().e(new a(this));
        }
    }

    public final String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return cg0.m();
        }
        return invokeV.booleanValue;
    }

    public final void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            Log.d("DuAr_AssetsLoader", str);
        }
    }

    public final boolean i(Context context, String str, File file) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, file)) == null) {
            if (file.isDirectory()) {
                bh0.b(file);
            } else {
                bh0.d(file);
            }
            File file2 = new File(file + ".loading");
            boolean a2 = new zg0(context).a(str, file2);
            if (n()) {
                q(a2 + " assetsToSD " + file2.getAbsolutePath());
            }
            if (a2) {
                a2 = file2.renameTo(file);
            }
            if (n()) {
                q(a2 + " renameTo " + file);
            }
            if (!a2) {
                q("del temp ...");
                bh0.b(file2);
                if (file.exists()) {
                    q("del " + file);
                    bh0.b(file);
                }
            }
            return a2;
        }
        return invokeLLL.booleanValue;
    }

    public final File l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.d == null && cg0.g() != null && !TextUtils.isEmpty(dg0.a())) {
                this.d = new File(dg0.a());
            }
            return this.d;
        }
        return (File) invokeV.objValue;
    }

    @SuppressLint({"NewApi"})
    public void m(Context context, String str, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, context, str, file) == null) {
            this.e = ((Context) Objects.requireNonNull(context)).getApplicationContext();
            this.c = (String) Objects.requireNonNull(str);
            this.d = (File) Objects.requireNonNull(file);
            if (n()) {
                q("init " + str + " to " + file.getAbsolutePath());
            }
        }
    }

    public boolean o() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Boolean bool = this.f;
            if (bool != null) {
                return bool.booleanValue();
            }
            String j = j();
            File l = l();
            boolean z = false;
            if (n()) {
                q(String.format("from %s to %s ", j, l));
            }
            String str2 = null;
            if (l != null && l.exists() && l.isDirectory()) {
                str = bh0.h(new File(l, "version"));
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                str2 = bh0.g(this.e, j + "/version");
            }
            if (n()) {
                q("assets=" + str2 + ", sdcard=" + str);
            }
            z = (TextUtils.isEmpty(str) || !TextUtils.equals(str, str2)) ? true : true;
            this.f = Boolean.valueOf(!z);
            return !z;
        }
        return invokeV.booleanValue;
    }

    public final void p(Context context) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            if (!o()) {
                z = i(context, j(), l());
            } else {
                z = true;
            }
            if (z) {
                this.f = null;
                d(2);
            }
            if (n()) {
                q("arVersion=" + cg0.h() + ", arVersionName=" + cg0.i());
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void r(Context context, String str, File file, ch0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, context, str, file, aVar) == null) {
            this.e = ((Context) Objects.requireNonNull(context)).getApplicationContext();
            this.c = (String) Objects.requireNonNull(str);
            this.d = (File) Objects.requireNonNull(file);
            if (n()) {
                q("start " + str + " to " + file.getAbsolutePath());
            }
            super.e(aVar);
        }
    }
}
