package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
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
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public final class jx2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public static final Set<String> g;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final int b;
    public final int c;
    public final String d;
    public final Object e;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public int b;
        public int c;
        public String d;
        public Object e;
        public RuntimeException f;

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

        public Exception d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.f;
            }
            return (Exception) invokeV.objValue;
        }

        @Nullable
        @SuppressLint({"BDThrowableCheck"})
        public jx2 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f != null) {
                    if (!jx2.f) {
                        return null;
                    }
                    throw this.f;
                } else if (this.a == null) {
                    this.f = new IllegalStateException("sid == null");
                    if (!jx2.f) {
                        return null;
                    }
                    throw this.f;
                } else {
                    synchronized (a.class) {
                        if (jx2.g.contains(this.a)) {
                            this.f = new IllegalStateException("sid has been occupied");
                            if (!jx2.f) {
                                return null;
                            }
                            throw this.f;
                        } else if (this.e == null) {
                            this.f = new IllegalStateException("switchValue == null");
                            if (!jx2.f) {
                                return null;
                            }
                            throw this.f;
                        } else {
                            jx2.g.add(this.a);
                            return new jx2(this);
                        }
                    }
                }
            }
            return (jx2) invokeV.objValue;
        }

        public a b(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.d = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a f(@NonNull Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                this.e = obj;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a g(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
                this.b = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        @SuppressLint({"BDThrowableCheck"})
        public a c(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                if (i >= 0 && i <= 100) {
                    this.c = i;
                    return this;
                }
                this.f = new IllegalArgumentException("flow must in [0, 100]");
                if (!jx2.f) {
                    this.c = 0;
                    return this;
                }
                throw this.f;
            }
            return (a) invokeI.objValue;
        }

        @SuppressLint({"BDThrowableCheck"})
        public a e(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    this.f = new IllegalArgumentException("sid must not be empty");
                    if (!jx2.f) {
                        this.a = null;
                        return this;
                    }
                    throw this.f;
                } else if (str.contains("-")) {
                    this.f = new IllegalArgumentException("sid must not contain '-'");
                    if (!jx2.f) {
                        this.a = null;
                        return this;
                    }
                    throw this.f;
                } else {
                    this.a = str;
                    return this;
                }
            }
            return (a) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947898597, "Lcom/baidu/tieba/jx2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947898597, "Lcom/baidu/tieba/jx2;");
                return;
            }
        }
        f = nr1.a;
        g = new HashSet();
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public Object e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return invokeV.objValue;
    }

    public jx2(a aVar) {
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
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (f) {
                return "SwanLocalABTestBranch{mGroupType=" + this.b + ", mFlow=" + this.c + ", mBranchDescription='" + this.d + "', mSwitchValue=" + this.e + '}';
            }
            return super.toString();
        }
        return (String) invokeV.objValue;
    }
}
