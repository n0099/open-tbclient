package com.baidu.tieba;

import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.danmu.cache.CacheManager;
import com.baidu.tieba.fn6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class kl6 {
    public static /* synthetic */ Interceptable $ic;
    public static final c h;
    public static final b i;
    public static final kl6 j;
    public transient /* synthetic */ FieldHolder $fh;
    public final bn6 a;
    public final in6 b;
    public final CacheManager c;
    public zk6 d;
    public final yl6 e;
    public List<fl6> f;
    public fn6 g;

    /* loaded from: classes5.dex */
    public final class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kl6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(kl6 kl6Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kl6Var, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(looper, "looper");
            this.a = kl6Var;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, msg) == null) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                if (msg.what == -1) {
                    BdLog.w("DanmakuEngine [Context] onCacheSign, updateRender");
                    this.a.c().H();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements bn6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.bn6
        public void b(fl6 item, Canvas canvas, fn6 displayer, zk6 config) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, item, canvas, displayer, config) == null) {
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(canvas, "canvas");
                Intrinsics.checkNotNullParameter(displayer, "displayer");
                Intrinsics.checkNotNullParameter(config, "config");
            }
        }

        public b() {
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

        @Override // com.baidu.tieba.bn6
        public nn6 a(fl6 item, fn6 displayer, zk6 config) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, item, displayer, config)) == null) {
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(displayer, "displayer");
                Intrinsics.checkNotNullParameter(config, "config");
                return new nn6(0, 0);
            }
            return (nn6) invokeLLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public c() {
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

        public final kl6 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
                return (kl6) invokeV.objValue;
            }
            return kl6.j;
        }
    }

    /* loaded from: classes5.dex */
    public static final class d implements fn6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public final int c;
        public final float d;
        public final float e;
        public final int f;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = 4;
            this.e = 1.0f;
            this.f = 200;
        }

        @Override // com.baidu.tieba.fn6
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.f;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.fn6
        public float b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.e;
            }
            return invokeV.floatValue;
        }

        @Override // com.baidu.tieba.fn6
        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.c;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.fn6
        public float d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return fn6.a.a(this);
            }
            return invokeV.floatValue;
        }

        @Override // com.baidu.tieba.fn6
        public float e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.d;
            }
            return invokeV.floatValue;
        }

        @Override // com.baidu.tieba.fn6
        public int getHeight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.a;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.fn6
        public int getWidth() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.b;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.fn6
        public void setHeight(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
                this.a = i;
            }
        }

        @Override // com.baidu.tieba.fn6
        public void setWidth(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
                this.b = i;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947916980, "Lcom/baidu/tieba/kl6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947916980, "Lcom/baidu/tieba/kl6;");
                return;
            }
        }
        h = new c(null);
        b bVar = new b();
        i = bVar;
        j = new kl6(bVar);
    }

    public kl6(bn6 renderer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {renderer};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(renderer, "renderer");
        this.a = renderer;
        this.b = new in6();
        Looper myLooper = Looper.myLooper();
        Intrinsics.checkNotNull(myLooper);
        this.c = new CacheManager(new a(this, myLooper), this.a);
        this.d = new zk6(0, 0L, 0L, 0L, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, false, false, 0, 0, 0, 0, 0, 0, 0, 0, null, null, 4194303, null);
        this.e = new yl6();
        new el6();
        this.f = new ArrayList();
        new el6();
        this.g = new d();
        this.f.iterator();
        new ArrayList();
        new ArrayList();
    }

    public final CacheManager b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (CacheManager) invokeV.objValue;
    }

    public final zk6 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (zk6) invokeV.objValue;
    }

    public final fn6 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return (fn6) invokeV.objValue;
    }

    public final yl6 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (yl6) invokeV.objValue;
    }

    public final in6 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (in6) invokeV.objValue;
    }

    public final void g(fn6 fn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fn6Var) == null) {
            Intrinsics.checkNotNullParameter(fn6Var, "<set-?>");
            this.g = fn6Var;
        }
    }

    public final void h(zk6 config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, config) == null) {
            Intrinsics.checkNotNullParameter(config, "config");
            this.d = config;
            if (this.e.b().size() != config.i().size()) {
                this.e.d(CollectionsKt___CollectionsKt.toList(config.i()));
            }
            if (this.e.c().size() != config.n().size()) {
                this.e.e(CollectionsKt___CollectionsKt.toList(config.n()));
            }
        }
    }
}
