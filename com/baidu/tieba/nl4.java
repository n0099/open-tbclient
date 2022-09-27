package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.kg4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebKitFactory;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public final class nl4 implements kg4 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean c;
    public static final Set<kg4.a> d;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;

    /* loaded from: classes5.dex */
    public class a implements WebKitFactory.WebkitInstallListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ File b;
        public final /* synthetic */ nl4 c;

        /* renamed from: com.baidu.tieba.nl4$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0348a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0348a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    nl4 nl4Var = this.a.c;
                    nl4Var.j(nl4Var.b);
                }
            }
        }

        public a(nl4 nl4Var, String str, File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nl4Var, str, file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = nl4Var;
            this.a = str;
            this.b = file;
        }

        @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
        public void onInstallFinish(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                boolean z = true;
                if (pj4.B(this.a, str)) {
                    synchronized (nl4.d) {
                        this.c.i(true);
                    }
                    return;
                }
                if (nl4.e(this.c) <= 2) {
                    if (8 == i) {
                        this.c.b = this.a;
                    } else {
                        nl4 nl4Var = this.c;
                        nl4Var.b = this.a + File.pathSeparator + this.c.a;
                        if (pj4.f(this.b, new File(this.c.b)) != this.b.length()) {
                            z = false;
                        }
                    }
                    if (z && k33.M().postDelayed(new RunnableC0348a(this), 1000L)) {
                        return;
                    }
                }
                if (8 == i) {
                    pj4.k(this.a);
                }
                synchronized (nl4.d) {
                    this.c.i(false);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
        public void onInstallStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948006291, "Lcom/baidu/tieba/nl4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948006291, "Lcom/baidu/tieba/nl4;");
                return;
            }
        }
        d = new HashSet();
    }

    public nl4() {
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
        this.a = 0;
    }

    public static /* synthetic */ int e(nl4 nl4Var) {
        int i = nl4Var.a + 1;
        nl4Var.a = i;
        return i;
    }

    @Override // com.baidu.tieba.kg4
    public void a(String str, kg4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, aVar) == null) {
            synchronized (d) {
                d.add(aVar);
                if (c) {
                    return;
                }
                c = true;
                j(str);
            }
        }
    }

    public final void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            synchronized (d) {
                for (kg4.a aVar : d) {
                    if (aVar != null) {
                        aVar.a(z);
                    }
                }
                d.clear();
                c = false;
                this.a = 0;
            }
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                synchronized (d) {
                    i(false);
                }
                return;
            }
            File file = new File(str);
            if (!file.isFile()) {
                synchronized (d) {
                    i(false);
                }
                return;
            }
            WebKitFactory.installAsync("file://" + str, new a(this, str, file));
        }
    }
}
