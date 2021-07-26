package com.bytedance.sdk.component.b.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public final class q extends aa {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final v f28694a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final List<String> f28695b;

    /* renamed from: c  reason: collision with root package name */
    public final List<String> f28696c;

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final List<String> f28697a;

        /* renamed from: b  reason: collision with root package name */
        public final List<String> f28698b;

        /* renamed from: c  reason: collision with root package name */
        public final Charset f28699c;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a() {
            this(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    this((Charset) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public a a(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                this.f28697a.add(t.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.f28699c));
                this.f28698b.add(t.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.f28699c));
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a(Charset charset) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {charset};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f28697a = new ArrayList();
            this.f28698b = new ArrayList();
            this.f28699c = charset;
        }

        public q a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new q(this.f28697a, this.f28698b) : (q) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(731369033, "Lcom/bytedance/sdk/component/b/b/q;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(731369033, "Lcom/bytedance/sdk/component/b/b/q;");
                return;
            }
        }
        f28694a = v.a("application/x-www-form-urlencoded");
    }

    public q(List<String> list, List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, list2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f28695b = com.bytedance.sdk.component.b.b.a.c.a(list);
        this.f28696c = com.bytedance.sdk.component.b.b.a.c.a(list2);
    }

    @Override // com.bytedance.sdk.component.b.b.aa
    public v a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f28694a : (v) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.b.b.aa
    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? a((com.bytedance.sdk.component.b.a.d) null, true) : invokeV.longValue;
    }

    @Override // com.bytedance.sdk.component.b.b.aa
    public void a(com.bytedance.sdk.component.b.a.d dVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            a(dVar, false);
        }
    }

    private long a(com.bytedance.sdk.component.b.a.d dVar, boolean z) {
        InterceptResult invokeLZ;
        com.bytedance.sdk.component.b.a.c c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, this, dVar, z)) == null) {
            if (z) {
                c2 = new com.bytedance.sdk.component.b.a.c();
            } else {
                c2 = dVar.c();
            }
            int size = this.f28695b.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 > 0) {
                    c2.i(38);
                }
                c2.b(this.f28695b.get(i2));
                c2.i(61);
                c2.b(this.f28696c.get(i2));
            }
            if (z) {
                long b2 = c2.b();
                c2.r();
                return b2;
            }
            return 0L;
        }
        return invokeLZ.longValue;
    }
}
