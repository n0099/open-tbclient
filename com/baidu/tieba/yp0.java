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
public class yp0 {
    public static /* synthetic */ Interceptable $ic;
    public static gq0 a;
    public static gq0 b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948337712, "Lcom/baidu/tieba/yp0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948337712, "Lcom/baidu/tieba/yp0;");
        }
    }

    /* loaded from: classes6.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public eq0 a;
        public eq0 b;

        /* loaded from: classes6.dex */
        public class a implements gq0 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ eq0 b;

            public a(b bVar, eq0 eq0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, eq0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = eq0Var;
            }

            @Override // com.baidu.tieba.gq0
            public eq0 a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return this.b;
                }
                return (eq0) invokeV.objValue;
            }
        }

        /* renamed from: com.baidu.tieba.yp0$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0463b {
            public static /* synthetic */ Interceptable $ic;
            public static final b a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1469821236, "Lcom/baidu/tieba/yp0$b$b;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(1469821236, "Lcom/baidu/tieba/yp0$b$b;");
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
                return C0463b.a;
            }
            return (b) invokeV.objValue;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public gq0 a(String str) {
            InterceptResult invokeL;
            char c;
            eq0 eq0Var;
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
                            synchronized (yp0.class) {
                                if (this.b == null) {
                                    this.b = wp0.a.b(str);
                                }
                            }
                        }
                        eq0Var = this.b;
                    } else {
                        throw new IllegalStateException("Unexpected type:" + str);
                    }
                } else {
                    if (this.a == null) {
                        synchronized (yp0.class) {
                            if (this.a == null) {
                                this.a = wp0.a.b(str);
                            }
                        }
                    }
                    eq0Var = this.a;
                }
                return new a(this, eq0Var);
            }
            return (gq0) invokeL.objValue;
        }
    }

    public yp0() {
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

    public static gq0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (yp0.class) {
                    if (b == null) {
                        if (a == null) {
                            a = (gq0) ServiceManager.getService(gq0.a);
                        }
                        b = a;
                    }
                    if (b != null) {
                        return b;
                    }
                    if (TextUtils.equals("okhttp", "mixed")) {
                        b = b.b().a("okhttp");
                    } else {
                        b = wp0.a;
                    }
                }
            }
            return b;
        }
        return (gq0) invokeV.objValue;
    }
}
