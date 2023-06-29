package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
/* loaded from: classes8.dex */
public class vg0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public File a;
    public File b;
    public File c;
    public volatile boolean d;

    /* loaded from: classes8.dex */
    public class a extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vg0 a;

        public a(vg0 vg0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vg0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vg0Var;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.run();
                this.a.g();
                synchronized (this.a) {
                    this.a.d = false;
                    if (this.a.l()) {
                        this.a.j("cleanCacehAsync finish.");
                    }
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    public vg0(File file) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = false;
        this.a = (File) Objects.requireNonNull(file);
        if (l()) {
            j("create " + file.getAbsolutePath());
        }
        this.b = new File(this.a, ".property/lockers");
        this.c = new File(this.a, ".property/holders");
    }

    public String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String str2 = str + ".locker." + System.currentTimeMillis();
            File file = new File(this.b, str2);
            if (!file.exists()) {
                if (!this.b.exists()) {
                    this.b.mkdirs();
                }
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (l()) {
                j(file.exists() + " to addLocker , " + file.getAbsolutePath());
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public void h(String str) {
        String[] list;
        File file;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (list = this.b.list()) != null && list.length != 0) {
            String str2 = str + ".locker.";
            for (String str3 : list) {
                if (str3 != null && str3.startsWith(str2)) {
                    fh0.e(new File(this.b, str3));
                    if (l()) {
                        j("cleanLockerTag , " + file.getAbsolutePath());
                    }
                }
            }
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            Log.d("DuAr_sharedFM", str);
        }
    }

    public void d(String str, File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, file) == null) && !TextUtils.isEmpty(str) && file != null) {
            File file2 = new File(this.c, file.getName());
            if (!file2.exists()) {
                file2.mkdirs();
            }
            File file3 = new File(file2, str + ".holder");
            if (!file3.exists()) {
                try {
                    file3.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (l()) {
                j(file3.exists() + " addChildHolder , " + file3.getAbsolutePath());
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.d) {
                if (l()) {
                    j("cleanCacehAsync isCleaning... ");
                    return;
                }
                return;
            }
            synchronized (this) {
                if (this.d) {
                    if (l()) {
                        j("cleanCacehAsync isCleaning... ");
                    }
                    return;
                }
                this.d = true;
                new a(this).start();
            }
        }
    }

    public void g() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (listFiles = this.a.listFiles()) == null || listFiles.length == 0 || m()) {
            return;
        }
        for (File file : listFiles) {
            if (!TextUtils.equals(".property", file.getName()) && !k(file)) {
                fh0.e(file);
                if (l()) {
                    j("cleanCache , " + file.getAbsolutePath());
                }
            }
        }
    }

    public void i(String str, File file) {
        String str2;
        File file2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, file) == null) {
            File[] listFiles = this.c.listFiles();
            String str3 = str + ".holder";
            if (file != null) {
                str2 = file.getName();
                d(str, file);
            } else {
                str2 = null;
            }
            if (listFiles != null && listFiles.length != 0) {
                for (File file3 : listFiles) {
                    if (file3 != null && !TextUtils.equals(file3.getName(), str2)) {
                        if (!file3.isDirectory()) {
                            if (file3.getName().endsWith(str3)) {
                                fh0.e(file3);
                            }
                        } else {
                            String[] list = file3.list();
                            if (list != null && list.length != 0) {
                                for (String str4 : list) {
                                    if (str4 != null && str4.endsWith(str3)) {
                                        fh0.e(new File(file3, str4));
                                        if (l()) {
                                            j("clearChildHolderTo , " + file2.getAbsolutePath());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean k(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, file)) == null) {
            boolean z = false;
            if (file == null || !file.exists()) {
                return false;
            }
            File file2 = new File(this.c, file.getName());
            if (!file2.exists()) {
                return false;
            }
            if (file2.isDirectory()) {
                String[] list = file2.list();
                if (list != null && list.length > 0) {
                    z = true;
                }
                if (!z) {
                    fh0.e(file2);
                    return z;
                }
                return z;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return gg0.m();
        }
        return invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            String[] list = this.b.list();
            if (list != null && list.length > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(this.b, str);
        if (file.exists()) {
            fh0.e(file);
        }
        if (l()) {
            StringBuilder sb = new StringBuilder();
            sb.append(!file.exists());
            sb.append(" to removeLocker , ");
            sb.append(file.getAbsolutePath());
            j(sb.toString());
        }
    }
}
