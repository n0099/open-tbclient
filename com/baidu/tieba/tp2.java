package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
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
public final class tp2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public static final Set e;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final Object b;
    public final int c;

    /* loaded from: classes6.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public Object b;
        public int c;
        public RuntimeException d;

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

        public Exception c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.d;
            }
            return (Exception) invokeV.objValue;
        }

        public tp2 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.d != null) {
                    if (!tp2.d) {
                        return null;
                    }
                    throw this.d;
                } else if (this.a == null) {
                    this.d = new IllegalStateException("key == null");
                    if (!tp2.d) {
                        return null;
                    }
                    throw this.d;
                } else {
                    synchronized (a.class) {
                        if (tp2.e.contains(this.a)) {
                            this.d = new IllegalStateException("the key of switch has been occupied");
                            if (!tp2.d) {
                                return null;
                            }
                            throw this.d;
                        } else if (this.b == null) {
                            this.d = new IllegalStateException("defaultValue == null");
                            if (!tp2.d) {
                                return null;
                            }
                            throw this.d;
                        } else if (!tp2.c(this.c, this.b)) {
                            this.d = new IllegalStateException("valueType error");
                            if (!tp2.d) {
                                return null;
                            }
                            throw this.d;
                        } else {
                            tp2.e.add(this.a);
                            return new tp2(this);
                        }
                    }
                }
            }
            return (tp2) invokeV.objValue;
        }

        public a b(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                this.b = obj;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a e(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                this.c = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    this.d = new IllegalArgumentException("the key of switch must not be empty");
                    if (!tp2.d) {
                        this.a = null;
                        return this;
                    }
                    throw this.d;
                } else if (TextUtils.equals(Config.SID, str)) {
                    this.d = new IllegalArgumentException("sid must not equal \"sids\"");
                    if (!tp2.d) {
                        this.a = null;
                        return this;
                    }
                    throw this.d;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948188819, "Lcom/baidu/tieba/tp2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948188819, "Lcom/baidu/tieba/tp2;");
                return;
            }
        }
        d = wj1.a;
        e = new HashSet();
    }

    public Object d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public tp2(a aVar) {
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
    }

    public static boolean c(int i, Object obj) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, obj)) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                return false;
                            }
                            return obj instanceof String;
                        }
                        return obj instanceof Long;
                    }
                    return obj instanceof Integer;
                }
                return obj instanceof Double;
            }
            return obj instanceof Boolean;
        }
        return invokeIL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (d) {
                return "SwanLocalABTestSwitch{key='" + this.a + "', defaultValue=" + this.b + ", valueType=" + this.c + '}';
            }
            return super.toString();
        }
        return (String) invokeV.objValue;
    }
}
