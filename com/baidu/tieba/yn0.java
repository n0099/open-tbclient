package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class yn0 {
    public static /* synthetic */ Interceptable $ic;
    public static go0 a;
    public static go0 b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948335790, "Lcom/baidu/tieba/yn0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948335790, "Lcom/baidu/tieba/yn0;");
        }
    }

    public yn0() {
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

    public static go0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (yn0.class) {
                    if (b == null) {
                        if (a == null) {
                            a = (go0) ServiceManager.getService(go0.a);
                        }
                        b = a;
                    }
                    if (b != null) {
                        return b;
                    }
                    if (TextUtils.equals("okhttp", "mixed")) {
                        b = b.b().a("okhttp");
                    } else {
                        b = wn0.a;
                    }
                }
            }
            return b;
        }
        return (go0) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public eo0 a;
        public eo0 b;

        /* loaded from: classes6.dex */
        public class a implements go0 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ eo0 b;

            public a(b bVar, eo0 eo0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, eo0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = eo0Var;
            }

            @Override // com.baidu.tieba.go0
            public eo0 a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (eo0) invokeV.objValue;
            }
        }

        /* renamed from: com.baidu.tieba.yn0$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C0462b {
            public static /* synthetic */ Interceptable $ic;
            public static final b a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-305186126, "Lcom/baidu/tieba/yn0$b$b;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-305186126, "Lcom/baidu/tieba/yn0$b$b;");
                        return;
                    }
                }
                a = new b(null);
            }
        }

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
            this.a = null;
            this.b = null;
        }

        public static b b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? C0462b.a : (b) invokeV.objValue;
        }

        public go0 a(String str) {
            InterceptResult invokeL;
            char c;
            eo0 eo0Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                int hashCode = str.hashCode();
                if (hashCode != -1015101340) {
                    if (hashCode == 1544803905 && str.equals("default")) {
                        c = 0;
                    }
                    c = 65535;
                } else {
                    if (str.equals("okhttp")) {
                        c = 1;
                    }
                    c = 65535;
                }
                if (c == 0) {
                    if (this.a == null) {
                        synchronized (yn0.class) {
                            if (this.a == null) {
                                this.a = wn0.a.b(str);
                            }
                        }
                    }
                    eo0Var = this.a;
                } else if (c == 1) {
                    if (this.b == null) {
                        synchronized (yn0.class) {
                            if (this.b == null) {
                                this.b = wn0.a.b(str);
                            }
                        }
                    }
                    eo0Var = this.b;
                } else {
                    throw new IllegalStateException("Unexpected type:" + str);
                }
                return new a(this, eo0Var);
            }
            return (go0) invokeL.objValue;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }
}
