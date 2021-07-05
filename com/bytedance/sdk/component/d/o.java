package com.bytedance.sdk.component.d;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ExecutorService;
/* loaded from: classes6.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f28713a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f28714b;

    /* renamed from: c  reason: collision with root package name */
    public c f28715c;

    /* renamed from: d  reason: collision with root package name */
    public i f28716d;

    /* renamed from: e  reason: collision with root package name */
    public j f28717e;

    /* renamed from: f  reason: collision with root package name */
    public b f28718f;

    /* renamed from: g  reason: collision with root package name */
    public h f28719g;

    /* renamed from: h  reason: collision with root package name */
    public com.bytedance.sdk.component.d.a f28720h;

    /* renamed from: com.bytedance.sdk.component.d.o$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public f f28721a;

        /* renamed from: b  reason: collision with root package name */
        public ExecutorService f28722b;

        /* renamed from: c  reason: collision with root package name */
        public c f28723c;

        /* renamed from: d  reason: collision with root package name */
        public i f28724d;

        /* renamed from: e  reason: collision with root package name */
        public j f28725e;

        /* renamed from: f  reason: collision with root package name */
        public b f28726f;

        /* renamed from: g  reason: collision with root package name */
        public h f28727g;

        /* renamed from: h  reason: collision with root package name */
        public com.bytedance.sdk.component.d.a f28728h;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public a a(ExecutorService executorService) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, executorService)) == null) {
                this.f28722b = executorService;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                this.f28723c = cVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public o a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new o(this, null) : (o) invokeV.objValue;
        }
    }

    public /* synthetic */ o(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    public f a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28713a : (f) invokeV.objValue;
    }

    public ExecutorService b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28714b : (ExecutorService) invokeV.objValue;
    }

    public c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28715c : (c) invokeV.objValue;
    }

    public i d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f28716d : (i) invokeV.objValue;
    }

    public j e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f28717e : (j) invokeV.objValue;
    }

    public b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f28718f : (b) invokeV.objValue;
    }

    public h g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f28719g : (h) invokeV.objValue;
    }

    public com.bytedance.sdk.component.d.a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f28720h : (com.bytedance.sdk.component.d.a) invokeV.objValue;
    }

    public o(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28713a = aVar.f28721a;
        this.f28714b = aVar.f28722b;
        this.f28715c = aVar.f28723c;
        this.f28716d = aVar.f28724d;
        this.f28717e = aVar.f28725e;
        this.f28718f = aVar.f28726f;
        this.f28720h = aVar.f28728h;
        this.f28719g = aVar.f28727g;
    }

    public static o a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? new a().a() : (o) invokeL.objValue;
    }
}
