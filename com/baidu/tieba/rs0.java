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
/* loaded from: classes7.dex */
public class rs0 {
    public static /* synthetic */ Interceptable $ic;
    public static at0 a;
    public static at0 b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948132058, "Lcom/baidu/tieba/rs0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948132058, "Lcom/baidu/tieba/rs0;");
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ys0 a;
        public ys0 b;

        /* loaded from: classes7.dex */
        public class a implements at0 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ys0 b;

            public a(b bVar, ys0 ys0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, ys0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = ys0Var;
            }

            @Override // com.baidu.tieba.at0
            public ys0 a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return this.b;
                }
                return (ys0) invokeV.objValue;
            }
        }

        /* renamed from: com.baidu.tieba.rs0$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static class C0469b {
            public static /* synthetic */ Interceptable $ic;
            public static final b a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(522594526, "Lcom/baidu/tieba/rs0$b$b;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(522594526, "Lcom/baidu/tieba/rs0$b$b;");
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
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                return C0469b.a;
            }
            return (b) invokeV.objValue;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public at0 a(String str) {
            InterceptResult invokeL;
            char c;
            ys0 ys0Var;
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
                if (c != 0) {
                    if (c == 1) {
                        if (this.b == null) {
                            synchronized (rs0.class) {
                                if (this.b == null) {
                                    this.b = ps0.a.b(str);
                                }
                            }
                        }
                        ys0Var = this.b;
                    } else {
                        throw new IllegalStateException("Unexpected type:" + str);
                    }
                } else {
                    if (this.a == null) {
                        synchronized (rs0.class) {
                            if (this.a == null) {
                                this.a = ps0.a.b(str);
                            }
                        }
                    }
                    ys0Var = this.a;
                }
                return new a(this, ys0Var);
            }
            return (at0) invokeL.objValue;
        }
    }

    public rs0() {
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

    public static at0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (rs0.class) {
                    if (b == null) {
                        if (a == null) {
                            a = (at0) ServiceManager.getService(at0.a);
                        }
                        b = a;
                    }
                    if (b != null) {
                        return b;
                    }
                    if (TextUtils.equals("okhttp", "mixed")) {
                        b = b.b().a("okhttp");
                    } else {
                        b = ps0.a;
                    }
                }
            }
            return b;
        }
        return (at0) invokeV.objValue;
    }
}
