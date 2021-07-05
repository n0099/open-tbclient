package com.bytedance.sdk.openadsdk.core.e;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f29950a;

    /* renamed from: b  reason: collision with root package name */
    public final int f29951b;

    /* renamed from: c  reason: collision with root package name */
    public final int f29952c;

    /* renamed from: d  reason: collision with root package name */
    public final int f29953d;

    /* renamed from: e  reason: collision with root package name */
    public final long f29954e;

    /* renamed from: f  reason: collision with root package name */
    public final long f29955f;

    /* renamed from: g  reason: collision with root package name */
    public final int f29956g;

    /* renamed from: h  reason: collision with root package name */
    public final int f29957h;

    /* renamed from: i  reason: collision with root package name */
    public final int f29958i;
    public final int j;
    public final String k;

    /* renamed from: com.bytedance.sdk.openadsdk.core.e.k$1  reason: invalid class name */
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
        public long f29959a;

        /* renamed from: b  reason: collision with root package name */
        public long f29960b;

        /* renamed from: c  reason: collision with root package name */
        public int f29961c;

        /* renamed from: d  reason: collision with root package name */
        public int f29962d;

        /* renamed from: e  reason: collision with root package name */
        public int f29963e;

        /* renamed from: f  reason: collision with root package name */
        public int f29964f;

        /* renamed from: g  reason: collision with root package name */
        public int f29965g;

        /* renamed from: h  reason: collision with root package name */
        public int f29966h;

        /* renamed from: i  reason: collision with root package name */
        public int f29967i;
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
                this.f29959a = j;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a b(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
                this.f29960b = j;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
                this.f29963e = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                this.f29964f = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
                this.f29965g = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a f(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
                this.f29966h = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a g(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
                this.f29967i = i2;
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
                this.f29961c = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                this.f29962d = i2;
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
        this.f29950a = aVar.f29964f;
        this.f29951b = aVar.f29963e;
        this.f29952c = aVar.f29962d;
        this.f29953d = aVar.f29961c;
        this.f29954e = aVar.f29960b;
        this.f29955f = aVar.f29959a;
        this.f29956g = aVar.f29965g;
        this.f29957h = aVar.f29966h;
        this.f29958i = aVar.f29967i;
        this.j = aVar.j;
        this.k = aVar.k;
    }
}
