package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.storage.swankv.SwanKV;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes5.dex */
public class ll2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final ll2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-629032295, "Lcom/baidu/tieba/ll2$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-629032295, "Lcom/baidu/tieba/ll2$b;");
                    return;
                }
            }
            a = new ll2(null);
        }
    }

    public ll2() {
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

    public static ll2 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (ll2) invokeV.objValue;
    }

    public /* synthetic */ ll2(a aVar) {
        this();
    }

    public final boolean a(File file, File file2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, file2)) == null) {
            if (file != null && file.exists() && file2 != null) {
                if (!file2.exists()) {
                    yn4.l(file2);
                }
                String[] list = file.list();
                if (list != null && list.length != 0) {
                    for (String str : list) {
                        if (!TextUtils.isEmpty(str)) {
                            File file3 = new File(file, str);
                            if (file3.exists()) {
                                boolean isFile = file3.isFile();
                                File file4 = new File(file2, str);
                                if (file4.exists()) {
                                    yn4.j(file4);
                                }
                                if (isFile) {
                                    yn4.h(file4);
                                    yn4.f(file3, file4);
                                } else if (file3.isDirectory()) {
                                    yn4.e(file3, file4);
                                }
                            }
                        }
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean b(@NonNull File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file)) == null) {
            if (file.exists() && file.isDirectory()) {
                File file2 = new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs/");
                File file3 = new File(lg3.e());
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    yn4.l(file2);
                    yn4.l(file3);
                    File file4 = null;
                    for (File file5 : listFiles) {
                        String name = file5.getName();
                        if (!TextUtils.isEmpty(name)) {
                            if (name.endsWith(ActivityChooserModel.HISTORY_FILE_EXTENSION)) {
                                file4 = new File(file2, name);
                            } else if (name.endsWith(SwanKV.PREFS_SUFFIX)) {
                                file4 = new File(file3, name);
                            }
                            if (file4 != null) {
                                if (file4.exists()) {
                                    yn4.L(file4);
                                }
                                if (file5.isFile()) {
                                    yn4.h(file4);
                                    yn4.f(file5, file4);
                                } else {
                                    yn4.e(file5, file4);
                                }
                            }
                        }
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean e(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, file)) == null) {
            if (file != null && file.exists()) {
                return a(new File(file, ml2.h), ml2.a);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, file)) == null) {
            if (file != null && file.exists()) {
                return a(new File(file, ml2.i), AppRuntime.getAppContext().getFilesDir());
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean h(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, file)) == null) {
            if (!TextUtils.isEmpty(str) && file != null && file.exists()) {
                return b(new File(file, ml2.j));
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean j(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, file)) == null) {
            if (file != null && file.exists()) {
                return a(new File(file, ml2.g), ml2.a);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean f(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, file)) == null) {
            if (file != null && file.exists()) {
                boolean a2 = a(new File(file, ml2.k), new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "databases"));
                SwanAppDbControl.f(AppRuntime.getAppContext()).p();
                kg4.a().e();
                br2.g0().E();
                return a2;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean i(String str) {
        InterceptResult invokeL;
        boolean z;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            jl2.n().p("installSwanApp start, appKey = " + str);
            File a2 = ml2.a();
            if (a2 != null && a2.exists()) {
                File file = new File(a2, ml2.m);
                if (!file.exists()) {
                    jl2.n().p("installSwanApp clone_zipFiles file not exists");
                    return false;
                }
                File a3 = kl2.a(yn4.G(file), a2);
                if (a3 != null && a3.exists()) {
                    File file2 = new File(ml2.d);
                    if (file2.exists()) {
                        yn4.L(file2);
                    }
                    if (!yn4.l(file2)) {
                        jl2.n().p("installSwanApp root cache dir create fail");
                        return false;
                    }
                    if (yn4.W(a3.getAbsolutePath(), ml2.d) != null) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        yn4.j(file);
                        yn4.j(a3);
                    }
                    jl2.n().p("unzip file status = " + z);
                    File file3 = new File(ml2.d);
                    String[] list = file3.list();
                    if (list != null && list.length != 0) {
                        int length = list.length;
                        int i = 0;
                        while (true) {
                            str2 = null;
                            if (i < length) {
                                String str4 = list[i];
                                if (!TextUtils.isEmpty(str4) && str4.startsWith(ml2.e)) {
                                    str2 = str4.substring(ml2.e.length());
                                    str3 = str4;
                                    break;
                                }
                                i++;
                            } else {
                                str3 = null;
                                break;
                            }
                        }
                        if (TextUtils.equals(str, str2) && !TextUtils.isEmpty(str3)) {
                            File file4 = new File(ml2.d, str3);
                            boolean j = j(str, file4);
                            boolean e = e(str, file4);
                            boolean h = h(str, file4);
                            boolean f = f(str, file4);
                            boolean d = d(str);
                            boolean g = g(str, file4);
                            jl2.n().p("installSwanPkg = " + j + " ; installCore = " + e + " ; installSp = " + h + " ; installDb = " + f + " ; installAbTest = " + d + " ; installDynamicLib = " + g);
                            return yn4.j(file3);
                        }
                        jl2.n().p("installSwanApp install appKey not match zip file appKey");
                        return false;
                    }
                    jl2.n().p("installSwanApp unzip file length invalid");
                    return false;
                }
                jl2.n().p("installSwanApp cloneZip.zip file not exists");
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
