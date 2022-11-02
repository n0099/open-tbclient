package com.baidu.tieba;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public final class jq2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public final lq2 a;
    public final List<kq2> b;
    public Boolean c;
    public kq2 d;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public lq2 a;
        public List<kq2> b;
        public RuntimeException c;

        public a() {
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

        @SuppressLint({"BDThrowableCheck"})
        public a a(@NonNull List<kq2> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
                if (list.contains(null)) {
                    this.c = new IllegalArgumentException("branches contains null value");
                    if (!jq2.e) {
                        this.b = null;
                        return this;
                    }
                    throw this.c;
                }
                for (kq2 kq2Var : list) {
                    if (kq2Var.c() + 0 > 100) {
                        this.c = new IllegalArgumentException("The sum of all flow in the branch must be in [0,100]");
                        if (!jq2.e) {
                            this.b = null;
                            return this;
                        }
                        throw this.c;
                    }
                }
                this.b = Collections.unmodifiableList(list);
                return this;
            }
            return (a) invokeL.objValue;
        }

        @Nullable
        @SuppressLint({"BDThrowableCheck"})
        public jq2 b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.c != null) {
                    if (!jq2.e) {
                        return null;
                    }
                    throw this.c;
                } else if (this.a == null) {
                    this.c = new IllegalStateException("testSwitch == null");
                    if (!jq2.e) {
                        return null;
                    }
                    throw this.c;
                } else {
                    List<kq2> list = this.b;
                    if (list == null) {
                        this.c = new IllegalStateException("branches == null");
                        if (!jq2.e) {
                            return null;
                        }
                        throw this.c;
                    }
                    for (kq2 kq2Var : list) {
                        if (!lq2.c(this.a.f(), kq2Var.e)) {
                            this.c = new IllegalStateException("branch valueType error");
                            if (!jq2.e) {
                                return null;
                            }
                            throw this.c;
                        }
                    }
                    return new jq2(this);
                }
            }
            return (jq2) invokeV.objValue;
        }

        public a c(@NonNull lq2 lq2Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lq2Var)) == null) {
                this.a = lq2Var;
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947891870, "Lcom/baidu/tieba/jq2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947891870, "Lcom/baidu/tieba/jq2;");
                return;
            }
        }
        e = ok1.a;
    }

    @NonNull
    public lq2 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (lq2) invokeV.objValue;
    }

    public jq2(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = Boolean.FALSE;
        this.a = aVar.a;
        this.b = aVar.b;
    }

    @Nullable
    public synchronized kq2 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.c.booleanValue()) {
                    return this.d;
                }
                int currentTimeMillis = (int) (System.currentTimeMillis() % 100);
                this.c = Boolean.TRUE;
                for (int i = 0; i < this.b.size(); i++) {
                    kq2 kq2Var = this.b.get(i);
                    currentTimeMillis -= kq2Var.c();
                    if (currentTimeMillis < 0) {
                        this.d = kq2Var;
                        return kq2Var;
                    }
                }
                return null;
            }
        }
        return (kq2) invokeV.objValue;
    }
}
