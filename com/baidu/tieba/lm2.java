package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.storage.swankv.SwanKV;
import com.baidu.tieba.kt1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class lm2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class a implements kt1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;
        public final /* synthetic */ lm2 b;

        public a(lm2 lm2Var, File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lm2Var, file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lm2Var;
            this.a = file;
        }

        @Override // com.baidu.tieba.kt1.a
        public void onResult(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (!gp1.a) {
                    ap4.L(this.a);
                }
                lm2 lm2Var = this.b;
                lm2Var.p("upload file: done. feedback data = " + str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final lm2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-628108774, "Lcom/baidu/tieba/lm2$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-628108774, "Lcom/baidu/tieba/lm2$b;");
                    return;
                }
            }
            a = new lm2(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947947608, "Lcom/baidu/tieba/lm2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947947608, "Lcom/baidu/tieba/lm2;");
                return;
            }
        }
        a = gp1.a;
    }

    public lm2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static lm2 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (lm2) invokeV.objValue;
    }

    public /* synthetic */ lm2(a aVar) {
        this();
    }

    public boolean l(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, file)) == null) {
            if (file == null) {
                return false;
            }
            ap4.j(file);
            return ap4.l(file);
        }
        return invokeL.booleanValue;
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, str) == null) && !TextUtils.isEmpty(str) && a) {
            Log.d("SwanAppCloneModule", str);
        }
    }

    public boolean b(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, file)) == null) {
            File q = q(str, file, om2.h);
            if (q == null) {
                return false;
            }
            File file2 = new File(om2.a, str);
            if (!file2.exists()) {
                return false;
            }
            File file3 = new File(q, str);
            ap4.l(file3);
            ap4.e(file2, file3);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean i(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, file)) == null) {
            File q = q(str, file, om2.g);
            if (q == null) {
                return false;
            }
            File file2 = new File(om2.a, str);
            if (!file2.exists()) {
                return false;
            }
            File file3 = new File(q, str);
            ap4.l(file3);
            ap4.e(file2, file3);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void j(String str, File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, file) == null) && !TextUtils.isEmpty(str) && file != null && file.exists()) {
            File databasePath = AppRuntime.getApplication().getDatabasePath(str);
            if (!databasePath.exists()) {
                return;
            }
            ap4.f(databasePath, new File(file, str));
        }
    }

    public final void o(File file, File file2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, file, file2) == null) {
            boolean X = ap4.X(file.getAbsolutePath(), file2.getAbsolutePath());
            if (X) {
                ap4.j(file);
            }
            p("zip file status = " + X);
        }
    }

    public boolean c(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, file)) == null) {
            File q = q(str, file, om2.k);
            if (q == null) {
                return false;
            }
            j("ai_apps.db", q);
            j("ai_apps_pms.db", q);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean d(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, file)) == null) {
            File q = q(str, new File(file, om2.i), "swan_plugin_workspace");
            if (q == null) {
                return false;
            }
            File q2 = sr2.q();
            if (!q2.exists()) {
                return false;
            }
            ap4.e(q2, q);
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void f(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, str) == null) {
            p("cloneSwanApp: start");
            r(h(context, str), str);
            p("cloneSwanApp: end");
        }
    }

    public boolean e(Context context, String str, File file) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, context, str, file)) == null) {
            File q = q(str, file, om2.j);
            if (context != null && q != null) {
                return m(context, str, q, new File(nh3.e()), SwanKV.PREFS_SUFFIX) | m(context, str, q, new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs/"), ActivityChooserModel.HISTORY_FILE_EXTENSION);
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public final void g(Context context, String str, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, context, str, file) == null) {
            boolean i = i(str, file);
            boolean b2 = b(om2.b, file);
            boolean b3 = b(om2.c, file);
            boolean e = e(context, str, file);
            boolean c = c(str, file);
            boolean a2 = a(str);
            boolean d = d(str, file);
            p("cloneSwanPkg = " + i + " ; cloneSwanCore = " + b2 + " ; cloneExtensionCore = " + b3 + " ; cloneSp = " + e + " ; cloneDb = " + c + " ; cloneAbTest = " + a2 + " ; cloneDynamicLib = " + d);
        }
    }

    public File h(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, context, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                p("appKey is empty");
                return null;
            }
            p("cloneFilesAndMakeZip start, appKey = " + str);
            File file = new File(om2.f + str);
            if (!l(file)) {
                p("delete old tmp dir failed");
                return null;
            }
            File a2 = om2.a();
            if (a2 == null) {
                p("dest zip dir is null");
                return null;
            }
            File file2 = new File(a2, om2.l);
            if (file2.exists()) {
                ap4.L(file2);
            }
            ap4.h(file2);
            g(context, str, file);
            o(file.getParentFile(), file2);
            p("cloneFilesAndMakeZip end, appKey = " + str);
            return file2;
        }
        return (File) invokeLL.objValue;
    }

    public final void k(String str, File file, File file2, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048586, this, str, file, file2, str2) == null) && !TextUtils.isEmpty(str) && file != null && file.exists() && file2 != null && file2.exists()) {
            String str3 = str + str2;
            File file3 = new File(file, str3);
            if (file3.exists()) {
                ap4.f(file3, new File(file2, str3));
            }
        }
    }

    public final boolean m(@NonNull Context context, @NonNull String str, @NonNull File file, @Nullable File file2, @NonNull String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048588, this, context, str, file, file2, str2)) == null) {
            if (file2 == null || !file2.exists() || !file2.isDirectory()) {
                return false;
            }
            String[] strArr = {"aiapp_" + str, "aiapp_setting_" + str, "searchbox_webapps_sp", "searchbox_sconsole_sp", "aiapp_open_stat", QuickPersistConfig.SP_FILE_STARTUP, "com.baidu.searchbox_aiapp_openstat", "aiapps_favorite", "aiapps_guide_dialog_sp", "key_pms_sp_name", context.getPackageName() + "_preferences", "abtesting"};
            for (int i = 0; i < 12; i++) {
                k(strArr[i], file2, file, str2);
            }
            return true;
        }
        return invokeLLLLL.booleanValue;
    }

    public File q(String str, File file, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, str, file, str2)) == null) {
            if (TextUtils.isEmpty(str) || file == null || TextUtils.isEmpty(str2)) {
                return null;
            }
            File file2 = new File(file, str2);
            if (!ap4.l(file2)) {
                return null;
            }
            return file2;
        }
        return (File) invokeLLL.objValue;
    }

    public boolean r(File file, String str) {
        InterceptResult invokeLL;
        String str2;
        String[] list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, file, str)) == null) {
            if (file != null && file.exists()) {
                File file2 = new File(om2.a, str);
                if (file2.exists() && (list = file2.list()) != null && list.length > 0) {
                    str2 = list[0];
                } else {
                    str2 = "-1";
                }
                p("upload file: ready");
                kt1 u = ds2.u();
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("aiappid", str);
                hashMap.put("aiappversion", str2);
                u.c(hashMap, file, new a(this, file));
                return true;
            }
            p("no zip file");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
