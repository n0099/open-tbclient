package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.danmu.data.ItemState;
import com.baidu.tieba.danmu.data.state.DrawState;
import com.baidu.tieba.danmu.ui.DanmakuPlayer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public class kv6 implements Comparable<kv6> {
    public static /* synthetic */ Interceptable $ic;
    public static final a i;
    public static final kv6 j;
    public transient /* synthetic */ FieldHolder $fh;
    public lv6 a;
    public ItemState b;
    public long c;
    public nx6 d;
    public final u6<yv6> e;
    public final nv6 f;
    public final DrawState g;
    public int h;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final kv6 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
                return (kv6) invokeV.objValue;
            }
            return kv6.j;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947926590, "Lcom/baidu/tieba/kv6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947926590, "Lcom/baidu/tieba/kv6;");
                return;
            }
        }
        i = new a(null);
        j = new kv6(lv6.p.c(), null, 2, null);
    }

    public kv6(lv6 data, DanmakuPlayer danmakuPlayer) {
        nx6 f;
        qv6 m;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {data, danmakuPlayer};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(data, "data");
        this.a = data;
        this.b = ItemState.Uninitialized;
        this.d = (danmakuPlayer == null || (m = danmakuPlayer.m()) == null || (f = m.w()) == null) ? pv6.h.a().f() : f;
        this.e = new u6<>(0);
        this.f = new nv6(this.d);
        this.g = new DrawState();
        this.h = -1;
    }

    public /* synthetic */ kv6(lv6 lv6Var, DanmakuPlayer danmakuPlayer, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(lv6Var, (i2 & 2) != 0 ? null : danmakuPlayer);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.g.t();
            if (this.b.compareTo(ItemState.Measured) > 0) {
                this.b = ItemState.Measured;
            }
        }
    }

    public final u6<yv6> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (u6) invokeV.objValue;
    }

    public final lv6 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (lv6) invokeV.objValue;
    }

    public final DrawState f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.g;
        }
        return (DrawState) invokeV.objValue;
    }

    public final long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.c;
        }
        return invokeV.longValue;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public final ItemState i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.b;
        }
        return (ItemState) invokeV.objValue;
    }

    public final long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.a.k() + this.f.a();
        }
        return invokeV.longValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.f.b();
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: c */
    public int compareTo(kv6 other) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, other)) == null) {
            Intrinsics.checkNotNullParameter(other, "other");
            return this.a.compareTo(other.a);
        }
        return invokeL.intValue;
    }

    public final void m(lv6 lv6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, lv6Var) == null) {
            Intrinsics.checkNotNullParameter(lv6Var, "<set-?>");
            this.a = lv6Var;
        }
    }

    public final void n(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j2) == null) {
            this.c = j2;
        }
    }

    public final void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.h = i2;
        }
    }

    public final void p(ItemState itemState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, itemState) == null) {
            Intrinsics.checkNotNullParameter(itemState, "<set-?>");
            this.b = itemState;
        }
    }

    public final void q(nx6 nx6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, nx6Var) == null) {
            Intrinsics.checkNotNullParameter(nx6Var, "<set-?>");
            this.d = nx6Var;
        }
    }
}
