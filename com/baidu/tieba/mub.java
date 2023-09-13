package com.baidu.tieba;

import android.os.Environment;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.qub;
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
/* loaded from: classes7.dex */
public final class mub {
    public static /* synthetic */ Interceptable $ic;
    public static mub e;
    public static lub f;
    public transient /* synthetic */ FieldHolder $fh;
    public qub a;
    public sub b;
    public rub c;
    public List<nub> d;

    /* loaded from: classes7.dex */
    public class a implements qub.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mub a;

        public a(mub mubVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mubVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mubVar;
        }

        @Override // com.baidu.tieba.qub.b
        public void a(long j, long j2, long j3, long j4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
                ArrayList<String> e = this.a.b.e(j, j2);
                if (!e.isEmpty()) {
                    tub b = tub.b();
                    b.c(j, j2, j3, j4);
                    b.d(this.a.c.e());
                    b.e(e);
                    b.a();
                    if (mub.getContext().displayNotification()) {
                        pub.c(b.toString());
                    }
                    if (this.a.d.size() != 0) {
                        for (nub nubVar : this.a.d) {
                            nubVar.onBlock(mub.getContext().provideContext(), b);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, str)) == null) {
                return str.endsWith(this.a);
            }
            return invokeLL.booleanValue;
        }
    }

    public mub() {
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
        this.b = new sub(Looper.getMainLooper().getThread(), f.provideDumpInterval());
        this.c = new rub(f.provideDumpInterval());
        l(new qub(new a(this), getContext().provideBlockThreshold(), getContext().stopWhenDebugging()));
        pub.b();
    }

    public static String h() {
        InterceptResult invokeV;
        String providePath;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            String externalStorageState = Environment.getExternalStorageState();
            if (getContext() == null) {
                providePath = "";
            } else {
                providePath = getContext().providePath();
            }
            if ("mounted".equals(externalStorageState) && Environment.getExternalStorageDirectory().canWrite()) {
                return Environment.getExternalStorageDirectory().getPath() + providePath;
            }
            return getContext().provideContext().getFilesDir() + getContext().providePath();
        }
        return (String) invokeV.objValue;
    }

    public static void k(lub lubVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, lubVar) == null) {
            f = lubVar;
        }
    }

    public void b(nub nubVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, nubVar) == null) {
            this.d.add(nubVar);
        }
    }

    public final void l(qub qubVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, qubVar) == null) {
            this.a = qubVar;
        }
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

    public static mub e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (e == null) {
                synchronized (mub.class) {
                    if (e == null) {
                        e = new mub();
                    }
                }
            }
            return e;
        }
        return (mub) invokeV.objValue;
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

    public static lub getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return f;
        }
        return (lub) invokeV.objValue;
    }

    public rub d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (rub) invokeV.objValue;
    }

    public qub g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (qub) invokeV.objValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return getContext().provideBlockThreshold() * 0.8f;
        }
        return invokeV.longValue;
    }

    public sub j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (sub) invokeV.objValue;
    }
}
