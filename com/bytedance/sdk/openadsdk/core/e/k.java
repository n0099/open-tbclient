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
    public final int f66266a;

    /* renamed from: b  reason: collision with root package name */
    public final int f66267b;

    /* renamed from: c  reason: collision with root package name */
    public final int f66268c;

    /* renamed from: d  reason: collision with root package name */
    public final int f66269d;

    /* renamed from: e  reason: collision with root package name */
    public final long f66270e;

    /* renamed from: f  reason: collision with root package name */
    public final long f66271f;

    /* renamed from: g  reason: collision with root package name */
    public final int f66272g;

    /* renamed from: h  reason: collision with root package name */
    public final int f66273h;

    /* renamed from: i  reason: collision with root package name */
    public final int f66274i;

    /* renamed from: j  reason: collision with root package name */
    public final int f66275j;
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
        public long f66276a;

        /* renamed from: b  reason: collision with root package name */
        public long f66277b;

        /* renamed from: c  reason: collision with root package name */
        public int f66278c;

        /* renamed from: d  reason: collision with root package name */
        public int f66279d;

        /* renamed from: e  reason: collision with root package name */
        public int f66280e;

        /* renamed from: f  reason: collision with root package name */
        public int f66281f;

        /* renamed from: g  reason: collision with root package name */
        public int f66282g;

        /* renamed from: h  reason: collision with root package name */
        public int f66283h;

        /* renamed from: i  reason: collision with root package name */
        public int f66284i;

        /* renamed from: j  reason: collision with root package name */
        public int f66285j;
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
                this.f66276a = j2;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a b(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
                this.f66277b = j2;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
                this.f66280e = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                this.f66281f = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
                this.f66282g = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a f(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
                this.f66283h = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a g(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
                this.f66284i = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a h(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
                this.f66285j = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f66278c = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                this.f66279d = i2;
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
        this.f66266a = aVar.f66281f;
        this.f66267b = aVar.f66280e;
        this.f66268c = aVar.f66279d;
        this.f66269d = aVar.f66278c;
        this.f66270e = aVar.f66277b;
        this.f66271f = aVar.f66276a;
        this.f66272g = aVar.f66282g;
        this.f66273h = aVar.f66283h;
        this.f66274i = aVar.f66284i;
        this.f66275j = aVar.f66285j;
        this.k = aVar.k;
    }
}
