package com.baidu.tieba;

import android.os.Environment;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dr9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public final class zq9 {
    public static /* synthetic */ Interceptable $ic;
    public static zq9 e;
    public static yq9 f;
    public transient /* synthetic */ FieldHolder $fh;
    public dr9 a;
    public fr9 b;
    public er9 c;
    public List<ar9> d;

    /* loaded from: classes6.dex */
    public class a implements dr9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zq9 a;

        public a(zq9 zq9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zq9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zq9Var;
        }

        @Override // com.baidu.tieba.dr9.b
        public void a(long j, long j2, long j3, long j4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
                ArrayList<String> e = this.a.b.e(j, j2);
                if (e.isEmpty()) {
                    return;
                }
                gr9 b = gr9.b();
                b.c(j, j2, j3, j4);
                b.d(this.a.c.e());
                b.e(e);
                b.a();
                if (zq9.getContext().displayNotification()) {
                    cr9.c(b.toString());
                }
                if (this.a.d.size() != 0) {
                    for (ar9 ar9Var : this.a.d) {
                        ar9Var.onBlock(zq9.getContext().provideContext(), b);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements FilenameFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        public b() {
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
            this.a = ".log";
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, str)) == null) ? str.endsWith(this.a) : invokeLL.booleanValue;
        }
    }

    public zq9() {
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
        this.d = new LinkedList();
        this.b = new fr9(Looper.getMainLooper().getThread(), f.provideDumpInterval());
        this.c = new er9(f.provideDumpInterval());
        l(new dr9(new a(this), getContext().provideBlockThreshold(), getContext().stopWhenDebugging()));
        cr9.b();
    }

    public static File c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            File file = new File(h());
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return (File) invokeV.objValue;
    }

    public static zq9 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (e == null) {
                synchronized (zq9.class) {
                    if (e == null) {
                        e = new zq9();
                    }
                }
            }
            return e;
        }
        return (zq9) invokeV.objValue;
    }

    public static File[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            File c = c();
            if (c.exists() && c.isDirectory()) {
                return c.listFiles(new b());
            }
            return null;
        }
        return (File[]) invokeV.objValue;
    }

    public static yq9 getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? f : (yq9) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            String externalStorageState = Environment.getExternalStorageState();
            String providePath = getContext() == null ? "" : getContext().providePath();
            if ("mounted".equals(externalStorageState) && Environment.getExternalStorageDirectory().canWrite()) {
                return Environment.getExternalStorageDirectory().getPath() + providePath;
            }
            return getContext().provideContext().getFilesDir() + getContext().providePath();
        }
        return (String) invokeV.objValue;
    }

    public static void k(yq9 yq9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, yq9Var) == null) {
            f = yq9Var;
        }
    }

    public void b(ar9 ar9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ar9Var) == null) {
            this.d.add(ar9Var);
        }
    }

    public er9 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : (er9) invokeV.objValue;
    }

    public dr9 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (dr9) invokeV.objValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? getContext().provideBlockThreshold() * 0.8f : invokeV.longValue;
    }

    public fr9 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : (fr9) invokeV.objValue;
    }

    public final void l(dr9 dr9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dr9Var) == null) {
            this.a = dr9Var;
        }
    }
}
