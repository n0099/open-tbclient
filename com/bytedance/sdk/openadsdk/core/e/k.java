package com.bytedance.sdk.openadsdk.core.e;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f30160a;

    /* renamed from: b  reason: collision with root package name */
    public final int f30161b;

    /* renamed from: c  reason: collision with root package name */
    public final int f30162c;

    /* renamed from: d  reason: collision with root package name */
    public final int f30163d;

    /* renamed from: e  reason: collision with root package name */
    public final long f30164e;

    /* renamed from: f  reason: collision with root package name */
    public final long f30165f;

    /* renamed from: g  reason: collision with root package name */
    public final int f30166g;

    /* renamed from: h  reason: collision with root package name */
    public final int f30167h;

    /* renamed from: i  reason: collision with root package name */
    public final int f30168i;
    public final int j;
    public final String k;

    /* renamed from: com.bytedance.sdk.openadsdk.core.e.k$1  reason: invalid class name */
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
        public long f30169a;

        /* renamed from: b  reason: collision with root package name */
        public long f30170b;

        /* renamed from: c  reason: collision with root package name */
        public int f30171c;

        /* renamed from: d  reason: collision with root package name */
        public int f30172d;

        /* renamed from: e  reason: collision with root package name */
        public int f30173e;

        /* renamed from: f  reason: collision with root package name */
        public int f30174f;

        /* renamed from: g  reason: collision with root package name */
        public int f30175g;

        /* renamed from: h  reason: collision with root package name */
        public int f30176h;

        /* renamed from: i  reason: collision with root package name */
        public int f30177i;
        public int j;
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

        public a a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                this.f30169a = j;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a b(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
                this.f30170b = j;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
                this.f30173e = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                this.f30174f = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
                this.f30175g = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a f(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
                this.f30176h = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a g(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
                this.f30177i = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a h(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
                this.j = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f30171c = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                this.f30172d = i2;
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
        this.f30160a = aVar.f30174f;
        this.f30161b = aVar.f30173e;
        this.f30162c = aVar.f30172d;
        this.f30163d = aVar.f30171c;
        this.f30164e = aVar.f30170b;
        this.f30165f = aVar.f30169a;
        this.f30166g = aVar.f30175g;
        this.f30167h = aVar.f30176h;
        this.f30168i = aVar.f30177i;
        this.j = aVar.j;
        this.k = aVar.k;
    }
}
