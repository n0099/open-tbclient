package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.helios.common.cc.n;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes8.dex */
public final class vz extends uz {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b d;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Class<?> a;
        public Method b;
        public Method c;

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
            d();
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public final long b(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                try {
                    return ((Long) this.c.invoke(obj, new Object[0])).longValue();
                } catch (Exception unused) {
                    throw new n.a("");
                }
            }
            return invokeL.longValue;
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    this.a = Class.forName(com.baidu.helios.common.cc.n.a(yz.a()), true, Object.class.getClassLoader());
                    this.b = com.baidu.helios.common.cc.n.b(this.a, com.baidu.helios.common.cc.n.a(yz.b()), new Class[]{byte[].class, Integer.TYPE, Integer.TYPE});
                    this.c = com.baidu.helios.common.cc.n.b(this.a, com.baidu.helios.common.cc.n.a(yz.c()), null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public final void f(Object obj, byte[] bArr, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLII(Constants.METHOD_SEND_USER_MSG, this, obj, bArr, i, i2) == null) {
                try {
                    this.b.invoke(obj, bArr, Integer.valueOf(i), Integer.valueOf(i2));
                } catch (Exception unused) {
                    throw new n.a("");
                }
            }
        }

        public final Object g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.newInstance() : invokeV.objValue;
        }
    }

    public vz(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 32;
        this.b = i;
        this.c = i2;
        this.d = new b(null);
    }

    @Override // com.baidu.tieba.uz
    public com.baidu.helios.common.cc.a b(byte[] bArr, int i, int i2) {
        long j;
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bArr, i, i2)) == null) {
            try {
                Object g = this.d.g();
                this.d.f(g, bArr, i, i2);
                j = this.d.b(g);
            } catch (Exception unused) {
                j = 4294967295L;
            }
            return com.baidu.helios.common.cc.a.a(new long[]{j});
        }
        return (com.baidu.helios.common.cc.a) invokeLII.objValue;
    }
}
