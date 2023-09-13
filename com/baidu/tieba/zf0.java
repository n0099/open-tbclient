package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class zf0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public File b;
    public File c;
    public List<c> d;
    public b e;
    public pf0 f;
    public long g;
    public int h;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public boolean i(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    /* loaded from: classes9.dex */
    public class b<T> implements pf0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public T a;
        public boolean b;
        public final /* synthetic */ zf0 c;

        /* loaded from: classes9.dex */
        public class a extends Thread {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ b b;

            public a(b bVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = str;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.c.s(this.a);
                    this.b.f(null);
                }
            }
        }

        /* renamed from: com.baidu.tieba.zf0$b$b  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC0541b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ boolean a;
            public final /* synthetic */ Exception b;
            public final /* synthetic */ b c;

            public RunnableC0541b(b bVar, boolean z, Exception exc) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Boolean.valueOf(z), exc};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
                this.a = z;
                this.b = exc;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v17, resolved type: com.baidu.tieba.zf0$c */
            /* JADX DEBUG: Multi-variable search result rejected for r0v32, resolved type: com.baidu.tieba.zf0$c */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i = 0;
                    if (this.a) {
                        while (i < this.c.c.d.size()) {
                            c cVar = (c) this.c.c.d.get(i);
                            if (cVar != 0) {
                                cVar.a(this.c.a, this.c.c.b.getAbsolutePath());
                            }
                            i++;
                        }
                        if (this.c.c.f != null) {
                            this.c.c.f.b(this.c.c.b.getAbsolutePath());
                            return;
                        }
                        return;
                    }
                    while (i < this.c.c.d.size()) {
                        c cVar2 = (c) this.c.c.d.get(i);
                        if (cVar2 != 0) {
                            cVar2.b(this.c.a, this.b);
                        }
                        i++;
                    }
                    if (this.c.c.f != null) {
                        this.c.c.f.onFailed(this.b);
                    }
                }
            }
        }

        public b(zf0 zf0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zf0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zf0Var;
        }

        public final void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                zf0.j("res:" + str);
            }
        }

        public void g(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, t) == null) {
                this.a = t;
            }
        }

        public /* synthetic */ b(zf0 zf0Var, a aVar) {
            this(zf0Var);
        }

        @Override // com.baidu.tieba.pf0
        public void a(long j, long j2, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)}) == null) && i != this.c.h) {
                this.c.g = j2;
                this.c.h = i;
                for (int i2 = 0; i2 < this.c.d.size(); i2++) {
                    c cVar = (c) this.c.d.get(i2);
                    if (cVar != null) {
                        cVar.c(this.a, j, j2, i);
                    }
                }
                if (this.c.f != null) {
                    this.c.f.a(j, j2, i);
                }
            }
        }

        @Override // com.baidu.tieba.pf0
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (this.c.p()) {
                    d("onCompleted(download): " + str);
                }
                new a(this, str).start();
                this.b = false;
            }
        }

        public void f(Exception exc) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, exc) == null) && this.c.d != null && !this.c.d.isEmpty()) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0541b(this, this.c.q(), exc));
            }
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.b;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.pf0
        public void onFailed(Exception exc) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, exc) == null) {
                if (this.c.p()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onFailed: ");
                    sb.append(this.c.a);
                    sb.append("\n");
                    if (exc != null) {
                        str = exc.getMessage();
                    } else {
                        str = "";
                    }
                    sb.append(str);
                    d(sb.toString());
                }
                if (this.c.c.exists()) {
                    this.c.c.delete();
                }
                for (int i = 0; i < this.c.d.size(); i++) {
                    c cVar = (c) this.c.d.get(i);
                    if (cVar != null) {
                        cVar.b(this.a, exc);
                    }
                }
                if (this.c.f != null) {
                    this.c.f.onFailed(exc);
                }
                this.b = false;
            }
        }

        @Override // com.baidu.tieba.pf0
        public void onStarted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.b = true;
                if (this.c.p()) {
                    d("onStarted");
                }
                for (int i = 0; i < this.c.d.size(); i++) {
                    c cVar = (c) this.c.d.get(i);
                    if (cVar != null) {
                        cVar.d(this.a);
                    }
                }
                if (this.c.f != null) {
                    this.c.f.onStarted();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public void a(T t, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, t, str) == null) {
            }
        }

        public void b(T t, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t, exc) == null) {
            }
        }

        public void c(T t, long j, long j2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{t, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)}) == null) {
            }
        }

        public void d(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
            }
        }

        public c() {
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
    }

    public zf0(String str, File file) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, file};
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
        this.b = file;
        this.d = new ArrayList();
        this.c = new File(this.b.getAbsolutePath() + ".loading");
    }

    public static void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            Log.d("DuAr_FileLoader", str);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || q() || r()) {
            return;
        }
        synchronized (this) {
            if (!q() && !r()) {
                if (this.e == null) {
                    b bVar = new b(this, null);
                    this.e = bVar;
                    bVar.g(this);
                }
                qf0 c2 = jf0.c();
                if (c2 != null) {
                    c2.a(this.a, this.c.getParent(), this.c.getName(), this.e);
                }
            }
        }
    }

    public void l(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            if (q()) {
                if (cVar != null) {
                    cVar.a(this, this.b.getAbsolutePath());
                    return;
                }
                return;
            }
            if (cVar != null && !this.d.contains(cVar)) {
                this.d.add(cVar);
            }
            k();
        }
    }

    public File m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (File) invokeV.objValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return jf0.m();
        }
        return invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            File file = this.b;
            if (file != null && file.exists()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            b bVar = this.e;
            if (bVar != null && bVar.e()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean s(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            File file = new File(str);
            boolean z2 = false;
            try {
                if (p()) {
                    j("onCompleted-unzip:" + str + "\nto " + this.b.getAbsolutePath());
                }
                File file2 = new File(this.b + ".ziping");
                if (file2.exists()) {
                    if (p()) {
                        j("delete older exists " + file2);
                    }
                    ig0.e(file2);
                }
                boolean z3 = true;
                try {
                    og0.a(file, file2);
                    z = true;
                } catch (Exception e) {
                    j("unzipFile Exception : " + e.getMessage() + " " + str);
                    z = false;
                }
                if (!z || !i(file2)) {
                    z3 = false;
                }
                if (!z3) {
                    if (p()) {
                        j("faild on afterUnziped " + file2);
                    }
                    ig0.e(file2);
                    z2 = z3;
                } else {
                    z2 = file2.renameTo(this.b) & z3;
                }
            } catch (Exception e2) {
                j("Exception on onFileLoaderCompledted " + e2.getMessage());
                e2.printStackTrace();
            }
            ig0.d(file);
            return z2;
        }
        return invokeL.booleanValue;
    }
}
