package com.baidu.tieba;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public final class m43 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Message a;
    public final Set<SwanAppProcessInfo> b;
    public final Set<String> c;
    public boolean d;
    public boolean e;
    public long f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public m43(int i) {
        this(Message.obtain((Handler) null, i));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((Message) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public m43 e(int... iArr) {
        InterceptResult invokeL;
        SwanAppProcessInfo[] indices;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, iArr)) == null) {
            for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indices()) {
                if (swanAppProcessInfo.isSwanAppProcess() && !g(iArr, swanAppProcessInfo.index)) {
                    b(swanAppProcessInfo);
                }
            }
            return this;
        }
        return (m43) invokeL.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public m43(int i, Object obj) {
        this(Message.obtain(null, i, obj));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), obj};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((Message) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public m43(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {message};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.b = new HashSet();
        this.c = new HashSet();
        this.d = false;
        this.e = false;
        this.f = 0L;
        this.a = message == null ? Message.obtain() : message;
    }

    public m43 a(int... iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iArr)) == null) {
            if (iArr != null) {
                for (int i : iArr) {
                    if (SwanAppProcessInfo.checkProcessId(i)) {
                        b(SwanAppProcessInfo.indexOf(i));
                    }
                }
            }
            return this;
        }
        return (m43) invokeL.objValue;
    }

    public m43 b(SwanAppProcessInfo... swanAppProcessInfoArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanAppProcessInfoArr)) == null) {
            if (swanAppProcessInfoArr != null) {
                this.b.addAll(Arrays.asList(swanAppProcessInfoArr));
            }
            return this;
        }
        return (m43) invokeL.objValue;
    }

    public m43 c(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
            if (strArr != null) {
                this.c.addAll(Arrays.asList(strArr));
            }
            return this;
        }
        return (m43) invokeL.objValue;
    }

    public m43 f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            this.d = z;
            return this;
        }
        return (m43) invokeZ.objValue;
    }

    public m43 j(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
            if (j < 0) {
                j = 0;
            }
            this.f = j;
            return this;
        }
        return (m43) invokeJ.objValue;
    }

    public m43 o(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, obj)) == null) {
            this.a.obj = obj;
            return this;
        }
        return (m43) invokeL.objValue;
    }

    public m43 p(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
            this.e = z;
            return this;
        }
        return (m43) invokeZ.objValue;
    }

    public m43 d() {
        InterceptResult invokeV;
        SwanAppProcessInfo[] indices;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indices()) {
                if (swanAppProcessInfo.isSwanAppProcess()) {
                    b(swanAppProcessInfo);
                }
            }
            return this;
        }
        return (m43) invokeV.objValue;
    }

    @NonNull
    public Message h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.a.obj == null) {
                o(new Bundle());
            }
            return this.a;
        }
        return (Message) invokeV.objValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            long j = this.f;
            if (j < 0) {
                return 0L;
            }
            return j;
        }
        return invokeV.longValue;
    }

    public Set<String> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return new HashSet(this.c);
        }
        return (Set) invokeV.objValue;
    }

    public Set<SwanAppProcessInfo> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return new HashSet(this.b);
        }
        return (Set) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public final boolean g(int[] iArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, iArr, i)) == null) {
            if (iArr != null) {
                for (int i2 : iArr) {
                    if (i2 == i) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }
}
