package com.bytedance.sdk.component.b.b.a.e;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final com.bytedance.sdk.component.b.a.f f28182a;

    /* renamed from: b  reason: collision with root package name */
    public static final com.bytedance.sdk.component.b.a.f f28183b;

    /* renamed from: c  reason: collision with root package name */
    public static final com.bytedance.sdk.component.b.a.f f28184c;

    /* renamed from: d  reason: collision with root package name */
    public static final com.bytedance.sdk.component.b.a.f f28185d;

    /* renamed from: e  reason: collision with root package name */
    public static final com.bytedance.sdk.component.b.a.f f28186e;

    /* renamed from: f  reason: collision with root package name */
    public static final com.bytedance.sdk.component.b.a.f f28187f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public final com.bytedance.sdk.component.b.a.f f28188g;

    /* renamed from: h  reason: collision with root package name */
    public final com.bytedance.sdk.component.b.a.f f28189h;

    /* renamed from: i  reason: collision with root package name */
    public final int f28190i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-952269841, "Lcom/bytedance/sdk/component/b/b/a/e/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-952269841, "Lcom/bytedance/sdk/component/b/b/a/e/c;");
                return;
            }
        }
        f28182a = com.bytedance.sdk.component.b.a.f.a(":");
        f28183b = com.bytedance.sdk.component.b.a.f.a(":status");
        f28184c = com.bytedance.sdk.component.b.a.f.a(":method");
        f28185d = com.bytedance.sdk.component.b.a.f.a(":path");
        f28186e = com.bytedance.sdk.component.b.a.f.a(":scheme");
        f28187f = com.bytedance.sdk.component.b.a.f.a(":authority");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(String str, String str2) {
        this(com.bytedance.sdk.component.b.a.f.a(str), com.bytedance.sdk.component.b.a.f.a(str2));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((com.bytedance.sdk.component.b.a.f) objArr2[0], (com.bytedance.sdk.component.b.a.f) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                return this.f28188g.equals(cVar.f28188g) && this.f28189h.equals(cVar.f28189h);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ((527 + this.f28188g.hashCode()) * 31) + this.f28189h.hashCode() : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? com.bytedance.sdk.component.b.b.a.c.a("%s: %s", this.f28188g.a(), this.f28189h.a()) : (String) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(com.bytedance.sdk.component.b.a.f fVar, String str) {
        this(fVar, com.bytedance.sdk.component.b.a.f.a(str));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((com.bytedance.sdk.component.b.a.f) objArr2[0], (com.bytedance.sdk.component.b.a.f) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public c(com.bytedance.sdk.component.b.a.f fVar, com.bytedance.sdk.component.b.a.f fVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, fVar2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f28188g = fVar;
        this.f28189h = fVar2;
        this.f28190i = fVar.g() + 32 + fVar2.g();
    }
}
