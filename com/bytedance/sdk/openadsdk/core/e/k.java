package com.bytedance.sdk.openadsdk.core.e;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f66792a;

    /* renamed from: b  reason: collision with root package name */
    public final int f66793b;

    /* renamed from: c  reason: collision with root package name */
    public final int f66794c;

    /* renamed from: d  reason: collision with root package name */
    public final int f66795d;

    /* renamed from: e  reason: collision with root package name */
    public final long f66796e;

    /* renamed from: f  reason: collision with root package name */
    public final long f66797f;

    /* renamed from: g  reason: collision with root package name */
    public final int f66798g;

    /* renamed from: h  reason: collision with root package name */
    public final int f66799h;

    /* renamed from: i  reason: collision with root package name */
    public final int f66800i;

    /* renamed from: j  reason: collision with root package name */
    public final int f66801j;
    public final String k;

    /* renamed from: com.bytedance.sdk.openadsdk.core.e.k$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f66802a;

        /* renamed from: b  reason: collision with root package name */
        public long f66803b;

        /* renamed from: c  reason: collision with root package name */
        public int f66804c;

        /* renamed from: d  reason: collision with root package name */
        public int f66805d;

        /* renamed from: e  reason: collision with root package name */
        public int f66806e;

        /* renamed from: f  reason: collision with root package name */
        public int f66807f;

        /* renamed from: g  reason: collision with root package name */
        public int f66808g;

        /* renamed from: h  reason: collision with root package name */
        public int f66809h;

        /* renamed from: i  reason: collision with root package name */
        public int f66810i;

        /* renamed from: j  reason: collision with root package name */
        public int f66811j;
        public String k;

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

        public a a(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                this.f66802a = j2;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a b(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
                this.f66803b = j2;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
                this.f66806e = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                this.f66807f = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
                this.f66808g = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a f(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
                this.f66809h = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a g(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
                this.f66810i = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a h(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
                this.f66811j = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f66804c = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                this.f66805d = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.k = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public k a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new k(this, null) : (k) invokeV.objValue;
        }
    }

    public /* synthetic */ k(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    public k(@NonNull a aVar) {
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
        this.f66792a = aVar.f66807f;
        this.f66793b = aVar.f66806e;
        this.f66794c = aVar.f66805d;
        this.f66795d = aVar.f66804c;
        this.f66796e = aVar.f66803b;
        this.f66797f = aVar.f66802a;
        this.f66798g = aVar.f66808g;
        this.f66799h = aVar.f66809h;
        this.f66800i = aVar.f66810i;
        this.f66801j = aVar.f66811j;
        this.k = aVar.k;
    }
}
