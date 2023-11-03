package com.baidu.tieba;

import android.util.LruCache;
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
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
/* loaded from: classes7.dex */
public class kg1 extends LruCache<String, jg1<File>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<e> a;
    public final String b;
    public HashMap<jg1<File>, byte[]> c;
    public long d;
    public volatile boolean e;
    public int f;
    public long g;

    /* loaded from: classes7.dex */
    public interface e {
        void a(String str, jg1<File> jg1Var);

        void b(String str, jg1<File> jg1Var);

        void c(String str, jg1<File> jg1Var);
    }

    public final void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a extends kh1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String c;
        public final /* synthetic */ kg1 d;

        public a(String str, kg1 kg1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, kg1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = str;
            this.d = kg1Var;
        }

        @Override // com.baidu.tieba.kh1
        public Object b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    File file = new File(this.c);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    this.d.r(file.listFiles(), currentTimeMillis);
                    return null;
                } catch (Exception unused) {
                    this.d.e = true;
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends kh1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ byte[] c;
        public final /* synthetic */ jg1 d;
        public final /* synthetic */ kg1 e;

        public b(kg1 kg1Var, byte[] bArr, jg1 jg1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg1Var, bArr, jg1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = kg1Var;
            this.c = bArr;
            this.d = jg1Var;
        }

        @Override // com.baidu.tieba.kh1
        public Object b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    x11.i(this.c, (File) this.d.a());
                    this.e.put(((File) this.d.a()).getName(), this.d);
                    kg1.b(this.e);
                    if (!this.e.a.isEmpty()) {
                        for (e eVar : this.e.a) {
                            eVar.c(((File) this.d.a()).getName(), this.d);
                        }
                    }
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    kg1 kg1Var = this.e;
                    kg1Var.m("File saved using " + currentTimeMillis2 + "ms: " + ((File) this.d.a()).getName() + "\nStatus:" + this.e.t());
                    this.e.g();
                    return null;
                } catch (Throwable unused) {
                    if (!this.e.a.isEmpty()) {
                        for (e eVar2 : this.e.a) {
                            eVar2.b(((File) this.d.a()).getName(), this.d);
                        }
                        return null;
                    }
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends kh1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jg1 c;
        public final /* synthetic */ kg1 d;

        public c(kg1 kg1Var, jg1 jg1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg1Var, jg1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = kg1Var;
            this.c = jg1Var;
        }

        @Override // com.baidu.tieba.kh1
        public Object b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    if (this.c != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        String name = ((File) this.c.a()).getName();
                        kg1.c(this.d);
                        this.c.e();
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        kg1 kg1Var = this.d;
                        kg1Var.m("File deleted using " + currentTimeMillis2 + "ms: " + name);
                    }
                    this.d.g();
                    return null;
                } catch (Throwable unused) {
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Comparator<File> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(kg1 kg1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg1Var};
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
                return Long.valueOf(file.lastModified()).compareTo(Long.valueOf(file2.lastModified()));
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947912020, "Lcom/baidu/tieba/kg1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947912020, "Lcom/baidu/tieba/kg1;");
            }
        }
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return super.maxSize();
        }
        return invokeV.longValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kg1(int i, String str) {
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

    public static /* synthetic */ int b(kg1 kg1Var) {
        int i = kg1Var.f;
        kg1Var.f = i + 1;
        return i;
    }

    public static /* synthetic */ int c(kg1 kg1Var) {
        int i = kg1Var.f;
        kg1Var.f = i - 1;
        return i;
    }

    public void f(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            this.a.add(eVar);
        }
    }

    public final void h(jg1<File> jg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jg1Var) == null) {
            lh1.a().c(new c(this, jg1Var));
        }
    }

    public void q(e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) && this.a.contains(eVar)) {
            this.a.remove(eVar);
        }
    }

    @Override // android.util.LruCache
    public synchronized void trimToSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            synchronized (this) {
                super.trimToSize(i);
            }
        }
    }

    public static kg1 o(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, str, i)) == null) {
            kg1 kg1Var = new kg1(i, str);
            kg1Var.e = false;
            lh1.a().c(new a(str, kg1Var));
            return kg1Var;
        }
        return (kg1) invokeLI.objValue;
    }

    public final void p(String str, File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, str, file) == null) && file.exists()) {
            super.put(str, new jg1(file));
            this.f++;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.LruCache
    /* renamed from: s */
    public int sizeOf(String str, jg1<File> jg1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, jg1Var)) == null) {
            if (jg1Var == null) {
                return super.sizeOf(null, null);
            }
            return jg1Var.f();
        }
        return invokeLL.intValue;
    }

    public void u(byte[] bArr, jg1<File> jg1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, bArr, jg1Var) == null) && jg1Var != null) {
            if (this.e) {
                v(jg1Var, bArr);
            } else {
                this.c.put(jg1Var, bArr);
            }
        }
    }

    public final void v(jg1<File> jg1Var, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, jg1Var, bArr) == null) {
            lh1.a().c(new b(this, bArr, jg1Var));
        }
    }

    public synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (System.currentTimeMillis() - this.d < this.g) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                Map snapshot = super.snapshot();
                this.d = System.currentTimeMillis();
                for (String str : snapshot.keySet()) {
                    jg1 jg1Var = (jg1) snapshot.get(str);
                    if (jg1Var.d(this.g)) {
                        ((File) ((jg1) super.remove(str)).a()).delete();
                        this.f--;
                    } else if (((File) jg1Var.a()).lastModified() < this.d) {
                        this.d = ((File) jg1Var.a()).lastModified();
                    }
                }
                m("Clear cache using " + (System.currentTimeMillis() - currentTimeMillis) + "ms: ");
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.LruCache
    /* renamed from: i */
    public void entryRemoved(boolean z, String str, jg1<File> jg1Var, jg1<File> jg1Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), str, jg1Var, jg1Var2}) == null) {
            super.entryRemoved(z, str, jg1Var, jg1Var2);
            if (z && jg1Var != null) {
                h(jg1Var);
            }
            if (z && !this.a.isEmpty()) {
                for (e eVar : this.a) {
                    eVar.a(str, jg1Var);
                }
            }
        }
    }

    public jg1<File> j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            jg1<File> jg1Var = (jg1) super.get(str);
            if (jg1Var != null) {
                try {
                    jg1Var.a().setLastModified(System.currentTimeMillis());
                    m("Fetch resource for " + str + ",\nStatus:" + t());
                } catch (Throwable unused) {
                }
            }
            return jg1Var;
        }
        return (jg1) invokeL.objValue;
    }

    public final synchronized void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this) {
                this.e = true;
                if (this.c != null) {
                    for (jg1<File> jg1Var : this.c.keySet()) {
                        v(jg1Var, this.c.get(jg1Var));
                    }
                    this.c.clear();
                    this.c = null;
                }
            }
        }
    }

    public final void r(File[] fileArr, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048588, this, fileArr, j) == null) {
            if (fileArr != null && fileArr.length > 0) {
                PriorityQueue priorityQueue = new PriorityQueue(11, new d(this));
                if (priorityQueue.size() > 0) {
                    this.d = ((File) priorityQueue.peek()).lastModified();
                } else {
                    this.d = System.currentTimeMillis();
                }
                priorityQueue.addAll(Arrays.asList(fileArr));
                while (!priorityQueue.isEmpty()) {
                    File file = (File) priorityQueue.poll();
                    p(file.getName(), file);
                }
            }
            m("Complete restore cache using " + (System.currentTimeMillis() - j) + "ms: ");
            n();
        }
    }

    public String t() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            int hitCount = hitCount() + missCount();
            if (hitCount != 0) {
                i = (hitCount() * 100) / hitCount;
            } else {
                i = 0;
            }
            return String.format(Locale.CHINA, "LruDiskCache[count=%d,size=%d/%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f), Integer.valueOf(size()), Integer.valueOf(maxSize()), Integer.valueOf(hitCount()), Integer.valueOf(missCount()), Integer.valueOf(i));
        }
        return (String) invokeV.objValue;
    }
}
