package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.UiUtils;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.a4b;
import com.baidu.tieba.m4b;
import com.baidu.tieba.tracker.core.data.AbsEventNode;
import com.baidu.tieba.tracker.core.data.ErrCode;
import com.baidu.tieba.tracker.core.data.TraceEventNode;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public abstract class j4b<R extends m4b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final R a;
    public final a4b b;
    public AbsEventNode c;
    public final Handler d;
    public Map<String, String> e;
    public a f;
    public final Runnable g;

    /* loaded from: classes6.dex */
    public interface a {
        void onError();
    }

    @MainThread
    public abstract AbsEventNode a(R r, a4b a4bVar);

    @MainThread
    public abstract x3b d(R r);

    public j4b(R thisRef, a4b traceType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {thisRef, traceType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(traceType, "traceType");
        this.a = thisRef;
        this.b = traceType;
        this.d = new Handler(Looper.getMainLooper());
        this.g = new Runnable() { // from class: com.baidu.tieba.b4b
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    j4b.e(j4b.this);
                }
            }
        };
    }

    public static final void c(j4b this$0, Map params) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, params) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(params, "$params");
            this$0.d.removeCallbacks(this$0.g);
            R r = this$0.a;
            if (!w3b.a.a(r.getTraceId())) {
                r = null;
            }
            if (r != null) {
                TraceEventNode traceEventNode = new TraceEventNode(r.z2(), r.l2(), a4b.a.a);
                traceEventNode.getTrackParams().putAll(params);
                this$0.d(r).c(traceEventNode);
                a aVar = this$0.f;
                if (aVar != null) {
                    aVar.onError();
                }
                k4b.a(this$0, r.getTraceId());
            }
        }
    }

    public static final void m(j4b this$0, Map params) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, params) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(params, "$params");
            this$0.d.removeCallbacks(this$0.g);
            R r = this$0.a;
            if (!w3b.a.a(r.getTraceId())) {
                r = null;
            }
            if (r != null) {
                TraceEventNode traceEventNode = new TraceEventNode(r.z2(), r.l2(), a4b.b.a);
                traceEventNode.getTrackParams().putAll(params);
                this$0.d(r).c(traceEventNode);
                k4b.a(this$0, r.getTraceId());
            }
        }
    }

    public static final void e(j4b this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(PushMessageHelper.ERROR_TYPE, ErrCode.TIME_OUT.getValue());
            linkedHashMap.put("error_info", "超时未抵达");
            Map<String, String> map = this$0.e;
            if (map != null) {
                if (map != null) {
                    linkedHashMap.putAll(map);
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }
            this$0.b(linkedHashMap);
        }
    }

    public static final void i(j4b this$0, long j, Function1 function1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{this$0, Long.valueOf(j), function1}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            AbsEventNode j2 = this$0.j(j);
            if (function1 != null) {
                function1.invoke(j2);
            }
        }
    }

    @MainThread
    public final void b(final Map<String, String> params) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, params) == null) {
            Intrinsics.checkNotNullParameter(params, "params");
            UiUtils.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.c4b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        j4b.c(j4b.this, params);
                    }
                }
            });
        }
    }

    public final j4b<R> f(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, map)) == null) {
            this.e = map;
            return this;
        }
        return (j4b) invokeL.objValue;
    }

    @MainThread
    public final void l(final Map<String, String> params) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, params) == null) {
            Intrinsics.checkNotNullParameter(params, "params");
            UiUtils.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.e4b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        j4b.m(j4b.this, params);
                    }
                }
            });
        }
    }

    @MainThread
    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            h(20000L, null);
        }
    }

    @MainThread
    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            l(MapsKt__MapsKt.emptyMap());
        }
    }

    @MainThread
    public final void h(final long j, final Function1<? super AbsEventNode, Unit> function1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048581, this, j, function1) == null) {
            if (!BdUtilHelper.isMainThread()) {
                UiUtils.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.d4b
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            j4b.i(j4b.this, j, function1);
                        }
                    }
                });
                return;
            }
            AbsEventNode j2 = j(j);
            if (function1 != null) {
                function1.invoke(j2);
            }
        }
    }

    @MainThread
    public final AbsEventNode j(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
            AbsEventNode absEventNode = this.c;
            if (absEventNode != null) {
                return absEventNode;
            }
            if (j > 0) {
                this.d.removeCallbacks(this.g);
                this.d.postDelayed(this.g, j);
            }
            AbsEventNode a2 = a(this.a, this.b);
            d(this.a).c(a2);
            this.c = a2;
            return a2;
        }
        return (AbsEventNode) invokeJ.objValue;
    }
}
