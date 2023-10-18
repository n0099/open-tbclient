package com.baidu.tieba;

import android.util.LruCache;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
/* loaded from: classes7.dex */
public class pd0 extends LruCache<String, od0<File>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<e> a;
    public final String b;
    public HashMap<od0<File>, byte[]> c;
    public long d;
    public volatile boolean e;
    public int f;
    public long g;

    /* loaded from: classes7.dex */
    public interface e {
        void a(String str, od0<File> od0Var);

        void b(String str, od0<File> od0Var);

        void c(String str, od0<File> od0Var);
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ pd0 b;

        public a(String str, pd0 pd0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, pd0Var};
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
            this.b = pd0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    File file = new File(this.a);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    this.b.o(file.listFiles(), currentTimeMillis);
                } catch (Exception unused) {
                    this.b.e = true;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ byte[] a;
        public final /* synthetic */ od0 b;
        public final /* synthetic */ pd0 c;

        public b(pd0 pd0Var, byte[] bArr, od0 od0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pd0Var, bArr, od0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pd0Var;
            this.a = bArr;
            this.b = od0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    System.currentTimeMillis();
                    g11.i(this.a, (File) this.b.a());
                    this.c.put(((File) this.b.a()).getName(), this.b);
                    pd0.b(this.c);
                    if (!this.c.a.isEmpty()) {
                        for (e eVar : this.c.a) {
                            eVar.c(((File) this.b.a()).getName(), this.b);
                        }
                    }
                    System.currentTimeMillis();
                    this.c.f();
                } catch (Throwable unused) {
                    if (!this.c.a.isEmpty()) {
                        for (e eVar2 : this.c.a) {
                            eVar2.a(((File) this.b.a()).getName(), this.b);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ od0 a;
        public final /* synthetic */ pd0 b;

        public c(pd0 pd0Var, od0 od0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pd0Var, od0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pd0Var;
            this.a = od0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.a != null) {
                        System.currentTimeMillis();
                        ((File) this.a.a()).getName();
                        pd0.c(this.b);
                        this.a.e();
                        System.currentTimeMillis();
                    }
                    this.b.f();
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Comparator<File> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(pd0 pd0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pd0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, file2)) == null) {
                return Long.compare(file.lastModified(), file2.lastModified());
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948058061, "Lcom/baidu/tieba/pd0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948058061, "Lcom/baidu/tieba/pd0;");
            }
        }
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pd0(int i, String str) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.e = false;
        this.f = 0;
        this.g = 2592000000L;
        this.b = str;
        this.c = new HashMap<>();
    }

    public final void o(File[] fileArr, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048586, this, fileArr, j) == null) {
            if (fileArr != null && fileArr.length > 0) {
                PriorityQueue priorityQueue = new PriorityQueue(11, new d(this));
                if (priorityQueue.size() > 0) {
                    File file = (File) priorityQueue.peek();
                    if (file != null) {
                        this.d = file.lastModified();
                    }
                } else {
                    this.d = System.currentTimeMillis();
                }
                priorityQueue.addAll(Arrays.asList(fileArr));
                while (!priorityQueue.isEmpty()) {
                    File file2 = (File) priorityQueue.poll();
                    if (file2 != null) {
                        m(file2.getName(), file2);
                    }
                }
            }
            System.currentTimeMillis();
            k();
        }
    }

    public static /* synthetic */ int b(pd0 pd0Var) {
        int i = pd0Var.f;
        pd0Var.f = i + 1;
        return i;
    }

    public static /* synthetic */ int c(pd0 pd0Var) {
        int i = pd0Var.f;
        pd0Var.f = i - 1;
        return i;
    }

    public void e(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            tx0.b(this.a, eVar);
        }
    }

    public final void g(od0<File> od0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, od0Var) == null) {
            kz0.c(new c(this, od0Var), "delete_disk_file_async", 3);
        }
    }

    @Nullable
    public od0<File> i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            od0<File> od0Var = (od0) super.get(str);
            if (od0Var != null) {
                try {
                    od0Var.a().setLastModified(System.currentTimeMillis());
                } catch (Throwable unused) {
                }
            }
            return od0Var;
        }
        return (od0) invokeL.objValue;
    }

    public void n(e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) && this.a.contains(eVar)) {
            this.a.remove(eVar);
        }
    }

    public static pd0 l(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            pd0 pd0Var = new pd0(i, str);
            pd0Var.e = false;
            kz0.c(new a(str, pd0Var), "restore_cache_from_disk", 3);
            return pd0Var;
        }
        return (pd0) invokeLI.objValue;
    }

    public final void m(String str, File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, file) == null) && file.exists()) {
            super.put(str, new od0(file));
            this.f++;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.LruCache
    /* renamed from: p */
    public int sizeOf(String str, od0<File> od0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, od0Var)) == null) {
            if (od0Var == null) {
                return super.sizeOf(null, null);
            }
            return od0Var.f();
        }
        return invokeLL.intValue;
    }

    public void q(byte[] bArr, od0<File> od0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, bArr, od0Var) == null) && od0Var != null) {
            if (this.e) {
                r(od0Var, bArr);
            } else {
                this.c.put(od0Var, bArr);
            }
        }
    }

    public final void r(od0<File> od0Var, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, od0Var, bArr) == null) {
            kz0.c(new b(this, bArr, od0Var), "store_cache_to_disk", 3);
        }
    }

    public synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (System.currentTimeMillis() - this.d < this.g) {
                    return;
                }
                System.currentTimeMillis();
                Map snapshot = super.snapshot();
                this.d = System.currentTimeMillis();
                for (String str : snapshot.keySet()) {
                    od0 od0Var = (od0) snapshot.get(str);
                    if (od0Var.d(this.g)) {
                        ((File) ((od0) super.remove(str)).a()).delete();
                        this.f--;
                    } else if (((File) od0Var.a()).lastModified() < this.d) {
                        this.d = ((File) od0Var.a()).lastModified();
                    }
                }
                System.currentTimeMillis();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.LruCache
    /* renamed from: h */
    public void entryRemoved(boolean z, String str, od0<File> od0Var, od0<File> od0Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), str, od0Var, od0Var2}) == null) {
            super.entryRemoved(z, str, od0Var, od0Var2);
            if (z && od0Var != null) {
                g(od0Var);
            }
            if (z && !this.a.isEmpty()) {
                for (e eVar : this.a) {
                    eVar.b(str, od0Var);
                }
            }
        }
    }

    public final synchronized void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                this.e = true;
                if (this.c != null) {
                    for (od0<File> od0Var : this.c.keySet()) {
                        r(od0Var, this.c.get(od0Var));
                    }
                    this.c.clear();
                    this.c = null;
                }
            }
        }
    }
}
