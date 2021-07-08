package com.bytedance.sdk.component.d;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ExecutorService;
/* loaded from: classes5.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f28823a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f28824b;

    /* renamed from: c  reason: collision with root package name */
    public c f28825c;

    /* renamed from: d  reason: collision with root package name */
    public i f28826d;

    /* renamed from: e  reason: collision with root package name */
    public j f28827e;

    /* renamed from: f  reason: collision with root package name */
    public b f28828f;

    /* renamed from: g  reason: collision with root package name */
    public h f28829g;

    /* renamed from: h  reason: collision with root package name */
    public com.bytedance.sdk.component.d.a f28830h;

    /* renamed from: com.bytedance.sdk.component.d.o$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public f f28831a;

        /* renamed from: b  reason: collision with root package name */
        public ExecutorService f28832b;

        /* renamed from: c  reason: collision with root package name */
        public c f28833c;

        /* renamed from: d  reason: collision with root package name */
        public i f28834d;

        /* renamed from: e  reason: collision with root package name */
        public j f28835e;

        /* renamed from: f  reason: collision with root package name */
        public b f28836f;

        /* renamed from: g  reason: collision with root package name */
        public h f28837g;

        /* renamed from: h  reason: collision with root package name */
        public com.bytedance.sdk.component.d.a f28838h;

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
                this.f28832b = executorService;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                this.f28833c = cVar;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28823a : (f) invokeV.objValue;
    }

    public ExecutorService b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28824b : (ExecutorService) invokeV.objValue;
    }

    public c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28825c : (c) invokeV.objValue;
    }

    public i d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f28826d : (i) invokeV.objValue;
    }

    public j e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f28827e : (j) invokeV.objValue;
    }

    public b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f28828f : (b) invokeV.objValue;
    }

    public h g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f28829g : (h) invokeV.objValue;
    }

    public com.bytedance.sdk.component.d.a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f28830h : (com.bytedance.sdk.component.d.a) invokeV.objValue;
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
        this.f28823a = aVar.f28831a;
        this.f28824b = aVar.f28832b;
        this.f28825c = aVar.f28833c;
        this.f28826d = aVar.f28834d;
        this.f28827e = aVar.f28835e;
        this.f28828f = aVar.f28836f;
        this.f28830h = aVar.f28838h;
        this.f28829g = aVar.f28837g;
    }

    public static o a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? new a().a() : (o) invokeL.objValue;
    }
}
