package com.baidu.tts;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes9.dex */
public class x {
    public static /* synthetic */ Interceptable $ic;
    public static volatile x g;
    public transient /* synthetic */ FieldHolder $fh;
    public List<v> a;
    public ExecutorService b;
    public a0 c;
    public y d;
    public a e;
    public boolean f;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public static final a b;
        public static final /* synthetic */ a[] c;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1850803024, "Lcom/baidu/tts/x$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1850803024, "Lcom/baidu/tts/x$a;");
                    return;
                }
            }
            a aVar = new a("DEVELOP", 0);
            a = aVar;
            a aVar2 = new a("RELEASE", 1);
            b = aVar2;
            c = new a[]{aVar, aVar2};
        }

        public a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (a) Enum.valueOf(a.class, str);
            }
            return (a) invokeL.objValue;
        }

        public static a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (a[]) c.clone();
            }
            return (a[]) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public w a;
        public final /* synthetic */ x b;

        public b(x xVar, w wVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar, wVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xVar;
            this.a = wVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (v vVar : this.b.a) {
                    vVar.a(this.a, null, x.g);
                }
            }
        }
    }

    public x() {
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
        this.d = new y();
        this.e = a.b;
        this.f = false;
        this.a = a();
        a0 a0Var = new a0();
        this.c = a0Var;
        this.a.add(a0Var);
        this.b = Executors.newSingleThreadExecutor(new x0("", "bds-log"));
    }

    public final List<v> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<v> list = this.a;
            if (list == null) {
                return new CopyOnWriteArrayList();
            }
            return list;
        }
        return (List) invokeV.objValue;
    }

    public void a(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, str2) == null) {
            w wVar = new w();
            wVar.d = System.currentTimeMillis();
            wVar.a = i;
            wVar.b = str;
            wVar.c = str2;
            int ordinal = this.e.ordinal();
            if (ordinal != 0) {
                boolean z = true;
                if (ordinal == 1) {
                    int i2 = wVar.a;
                    if (!this.f && !Log.isLoggable("TTSLOG", i2)) {
                        z = false;
                    }
                    if (z) {
                        this.d.a(wVar);
                        return;
                    }
                    return;
                }
                return;
            }
            this.d.a(wVar);
            try {
                ExecutorService executorService = this.b;
                if (executorService != null && !executorService.isShutdown()) {
                    this.b.execute(new b(this, wVar));
                }
            } catch (Exception e) {
                Log.e("LoggerChain", "executeWork exception=" + e.toString());
            }
        }
    }
}
