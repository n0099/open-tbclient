package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.cn3;
import com.baidu.tieba.x74;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
@Singleton
@Service
/* loaded from: classes6.dex */
public class lc4 implements ws1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public SharedPreferences a;
    public File b;

    public long s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? Config.FULL_TRACE_LOG_LIMIT : invokeV.longValue;
    }

    /* loaded from: classes6.dex */
    public class a implements cn3.a<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lc4 a;

        public a(lc4 lc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lc4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.cn3.a
        public Long update() throws IllegalStateException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return Long.valueOf(this.a.m());
            }
            return (Long) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947938060, "Lcom/baidu/tieba/lc4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947938060, "Lcom/baidu/tieba/lc4;");
                return;
            }
        }
        c = rr1.a;
    }

    @NonNull
    public static File q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, vqa.c);
        }
        return (File) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ws1
    public qj2 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new jc4();
        }
        return (qj2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ws1
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            rn2.c();
        }
    }

    @Override // com.baidu.tieba.ws1
    public File[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return q().listFiles();
        }
        return (File[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ws1
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return rn2.p();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ws1
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            String J = lr4.J(x74.d());
            String J2 = lr4.J(x74.d.g());
            g();
            c();
            lr4.k(J);
            lr4.k(J2);
        }
    }

    @Override // com.baidu.tieba.ws1
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            l("aigame_storage_");
        }
    }

    @Override // com.baidu.tieba.ws1
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            on2.c();
        }
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (r() && this.a.edit().clear().commit()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public long m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            File file = this.b;
            if (file != null) {
                return file.length();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public String[] n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (!r()) {
                return new String[0];
            }
            Set<String> keySet = this.a.getAll().keySet();
            String[] strArr = new String[keySet.size()];
            keySet.toArray(strArr);
            return strArr;
        }
        return (String[]) invokeV.objValue;
    }

    @Nullable
    public final String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            String g0 = hb3.g0();
            if (TextUtils.isEmpty(g0)) {
                return null;
            }
            return String.format("aigame_storage_%s_anonymous", g0);
        }
        return (String) invokeV.objValue;
    }

    public final boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.a != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public lc4() {
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
        String o = o();
        if (c) {
            Log.i("SwanGameStorageManager", "preferencesName:" + o);
        }
        if (o != null) {
            this.a = ou2.c().getSharedPreferences(o, 0);
            File q = q();
            this.b = new File(q, o + ActivityChooserModel.HISTORY_FILE_EXTENSION);
        }
        dn3.h.b(new a(this));
    }

    public static void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            l(String.format("aigame_storage_%s_anonymous", str, ""));
        }
    }

    @Override // com.baidu.tieba.ws1
    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return rn2.Y(str);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ws1
    public String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            return rn2.Z(str);
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            if (r() && this.a.edit().remove(str).commit()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void l(String str) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, str) != null) || str == null || !str.startsWith("aigame_storage_") || (listFiles = q().listFiles()) == null) {
            return;
        }
        for (File file : listFiles) {
            if (file.getName().startsWith(str)) {
                lr4.L(file);
            }
        }
    }

    public String p(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, str2)) == null) {
            if (r()) {
                return this.a.getString(str, str2);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean t(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, str, str2)) == null) {
            if (r() && this.a.edit().putString(str, str2).commit()) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
