package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes5.dex */
public class k13 implements ys2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> c;
    public CopyOnWriteArrayList<j13> d;
    public boolean e;
    public q23 f;

    /* loaded from: classes5.dex */
    public class a implements q23 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k13 c;

        @Override // com.baidu.tieba.q23
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.q23
        public void c(@NonNull Runnable runnable, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, runnable, str) == null) {
            }
        }

        @Override // com.baidu.tieba.q23
        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "GlobalJsBridge" : (String) invokeV.objValue;
        }

        public a(k13 k13Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k13Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = k13Var;
        }

        @Override // com.baidu.tieba.q23
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048580, this, str) != null) {
                return;
            }
            this.c.e = true;
        }

        @Override // com.baidu.tieba.q23
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.c.e = false;
        }

        @Override // com.baidu.tieba.q23
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.c.e = false;
                if (this.c.d.isEmpty()) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                Iterator<j13> it = this.c.d.iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
                if (ys2.a) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    Log.d("SwanPerformance", "pending api dispatch cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms, listener count = " + this.c.d.size());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final k13 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-712119394, "Lcom/baidu/tieba/k13$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-712119394, "Lcom/baidu/tieba/k13$b;");
                    return;
                }
            }
            a = new k13(null);
        }
    }

    public k13() {
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
        this.c = new ArrayList();
        this.d = new CopyOnWriteArrayList<>();
        this.e = false;
        this.f = new a(this);
        this.c.clear();
        List<String> list = this.c;
        list.add(UnitedSchemeEntity.UNITED_SCHEME + "swanAPI/openStatisticEvent?");
    }

    public /* synthetic */ k13(a aVar) {
        this();
    }

    public void d(j13 j13Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j13Var) != null) || j13Var == null) {
            return;
        }
        this.d.add(j13Var);
        o23.g().i(this.f, 4000);
    }

    public static k13 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (k13) invokeV.objValue;
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str) || !this.e) {
                return false;
            }
            for (String str2 : this.c) {
                if (str.startsWith(str2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
