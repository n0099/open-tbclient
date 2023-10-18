package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.hma;
import com.baidu.tieba.pma;
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
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public abstract class mma<R extends pma> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final R a;
    public final hma b;
    public AbsEventNode c;
    public final Handler d;
    public final Runnable e;

    @MainThread
    public abstract AbsEventNode a(R r, hma hmaVar);

    @MainThread
    public abstract ema c(R r);

    public mma(R thisRef, hma traceType) {
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
        this.e = new Runnable() { // from class: com.baidu.tieba.ima
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    mma.d(mma.this);
                }
            }
        };
    }

    public static final void d(mma this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(PushMessageHelper.ERROR_TYPE, ErrCode.TIME_OUT.getValue());
            linkedHashMap.put("error_info", "超时未抵达");
            this$0.b(linkedHashMap);
        }
    }

    @MainThread
    public final void b(Map<String, String> params) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, params) == null) {
            Intrinsics.checkNotNullParameter(params, "params");
            this.d.removeCallbacks(this.e);
            R r = this.a;
            if (!dma.a.a(r.getTraceId())) {
                r = null;
            }
            if (r != null) {
                TraceEventNode traceEventNode = new TraceEventNode(r.V1(), r.I1(), hma.a.a);
                traceEventNode.getTrackParams().putAll(params);
                c(r).c(traceEventNode);
                nma.a(this, r.getTraceId());
            }
        }
    }

    @MainThread
    public final void g(Map<String, String> params) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, params) == null) {
            Intrinsics.checkNotNullParameter(params, "params");
            this.d.removeCallbacks(this.e);
            R r = this.a;
            if (!dma.a.a(r.getTraceId())) {
                r = null;
            }
            if (r != null) {
                TraceEventNode traceEventNode = new TraceEventNode(r.I1(), r.V1(), hma.b.a);
                traceEventNode.getTrackParams().putAll(params);
                c(r).c(traceEventNode);
                nma.a(this, r.getTraceId());
            }
        }
    }

    @MainThread
    public final AbsEventNode e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return f(20000L);
        }
        return (AbsEventNode) invokeV.objValue;
    }

    @MainThread
    public final AbsEventNode f(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
            AbsEventNode absEventNode = this.c;
            if (absEventNode != null) {
                return absEventNode;
            }
            if (j > 0) {
                this.d.removeCallbacks(this.e);
                this.d.postDelayed(this.e, j);
            }
            AbsEventNode a = a(this.a, this.b);
            c(this.a).c(a);
            this.c = a;
            return a;
        }
        return (AbsEventNode) invokeJ.objValue;
    }
}
