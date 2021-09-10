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
    public final int f66446a;

    /* renamed from: b  reason: collision with root package name */
    public final int f66447b;

    /* renamed from: c  reason: collision with root package name */
    public final int f66448c;

    /* renamed from: d  reason: collision with root package name */
    public final int f66449d;

    /* renamed from: e  reason: collision with root package name */
    public final long f66450e;

    /* renamed from: f  reason: collision with root package name */
    public final long f66451f;

    /* renamed from: g  reason: collision with root package name */
    public final int f66452g;

    /* renamed from: h  reason: collision with root package name */
    public final int f66453h;

    /* renamed from: i  reason: collision with root package name */
    public final int f66454i;

    /* renamed from: j  reason: collision with root package name */
    public final int f66455j;
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
        public long f66456a;

        /* renamed from: b  reason: collision with root package name */
        public long f66457b;

        /* renamed from: c  reason: collision with root package name */
        public int f66458c;

        /* renamed from: d  reason: collision with root package name */
        public int f66459d;

        /* renamed from: e  reason: collision with root package name */
        public int f66460e;

        /* renamed from: f  reason: collision with root package name */
        public int f66461f;

        /* renamed from: g  reason: collision with root package name */
        public int f66462g;

        /* renamed from: h  reason: collision with root package name */
        public int f66463h;

        /* renamed from: i  reason: collision with root package name */
        public int f66464i;

        /* renamed from: j  reason: collision with root package name */
        public int f66465j;
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
                this.f66456a = j2;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a b(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
                this.f66457b = j2;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
                this.f66460e = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                this.f66461f = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
                this.f66462g = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a f(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
                this.f66463h = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a g(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
                this.f66464i = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a h(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
                this.f66465j = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f66458c = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                this.f66459d = i2;
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
        this.f66446a = aVar.f66461f;
        this.f66447b = aVar.f66460e;
        this.f66448c = aVar.f66459d;
        this.f66449d = aVar.f66458c;
        this.f66450e = aVar.f66457b;
        this.f66451f = aVar.f66456a;
        this.f66452g = aVar.f66462g;
        this.f66453h = aVar.f66463h;
        this.f66454i = aVar.f66464i;
        this.f66455j = aVar.f66465j;
        this.k = aVar.k;
    }
}
