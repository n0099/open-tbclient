package com.baidu.tieba.tracker.core.monitors;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.hma;
import com.baidu.tieba.mma;
import com.baidu.tieba.pma;
import com.baidu.tieba.tracker.core.data.AbsEventNode;
import com.baidu.tieba.tracker.core.data.ErrCode;
import com.baidu.tieba.tracker.core.data.TraceEventNode;
import com.baidu.tieba.tracker.core.monitors.PageTraceMonitor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\n\b\u0000\u0010\u0001 \u0000*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u0018B\u0015\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001d\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0006H\u0017¢\u0006\u0002\u0010\u000bJ\u0017\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0004\u001a\u00028\u0000H$¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00028\u0000H$¢\u0006\u0002\u0010\u0011J9\u0010\u0012\u001a\u00020\u00132*\u0010\u0014\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u00160\u0015\"\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u0016H$¢\u0006\u0002\u0010\u0017R\u0010\u0010\u0004\u001a\u00028\u0000X\u0088\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/baidu/tieba/tracker/core/monitors/PageTraceMonitor;", "R", "Lcom/baidu/tieba/tracker/interfaces/ITraceable;", "Lcom/baidu/tieba/tracker/core/monitors/TraceMonitor;", "thisRef", "traceType", "Lcom/baidu/tieba/tracker/core/data/TraceType;", "(Lcom/baidu/tieba/tracker/interfaces/ITraceable;Lcom/baidu/tieba/tracker/core/data/TraceType;)V", "Lcom/baidu/tieba/tracker/interfaces/ITraceable;", "createTrackNode", "Lcom/baidu/tieba/tracker/core/data/AbsEventNode;", "(Lcom/baidu/tieba/tracker/interfaces/ITraceable;Lcom/baidu/tieba/tracker/core/data/TraceType;)Lcom/baidu/tieba/tracker/core/data/AbsEventNode;", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "(Lcom/baidu/tieba/tracker/interfaces/ITraceable;)Landroidx/lifecycle/Lifecycle;", "getParentPage", "", "(Lcom/baidu/tieba/tracker/interfaces/ITraceable;)Ljava/lang/String;", GameAssistConstKt.TYPE_CALLBACK_ERROR, "", "params", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)V", "RecycleLifecycleObserver", "tracker"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public abstract class PageTraceMonitor<R extends pma> extends mma<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract Lifecycle h(R r);

    public abstract String i(R r);

    public abstract void j(Pair<String, String>... pairArr);

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/baidu/tieba/tracker/core/monitors/PageTraceMonitor$RecycleLifecycleObserver;", "Landroidx/lifecycle/LifecycleObserver;", "monitor", "Lcom/baidu/tieba/tracker/core/monitors/PageTraceMonitor;", "(Lcom/baidu/tieba/tracker/core/monitors/PageTraceMonitor;)V", MissionEvent.MESSAGE_DESTROY, "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "Companion", "tracker"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class RecycleLifecycleObserver implements LifecycleObserver {
        public static /* synthetic */ Interceptable $ic;
        @Deprecated
        public static final Handler b;
        public transient /* synthetic */ FieldHolder $fh;
        public final PageTraceMonitor<?> a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1036379271, "Lcom/baidu/tieba/tracker/core/monitors/PageTraceMonitor$RecycleLifecycleObserver;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1036379271, "Lcom/baidu/tieba/tracker/core/monitors/PageTraceMonitor$RecycleLifecycleObserver;");
                    return;
                }
            }
            b = new Handler(Looper.getMainLooper());
        }

        public RecycleLifecycleObserver(PageTraceMonitor<?> monitor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {monitor};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(monitor, "monitor");
            this.a = monitor;
        }

        public static final void b(RecycleLifecycleObserver this$0) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, null, this$0) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                this$0.a.j(TuplesKt.to(PushMessageHelper.ERROR_TYPE, ErrCode.ON_DESTROY.getValue()), TuplesKt.to("error_info", "未抵达前手动结束页面"));
            }
        }

        @MainThread
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public final void onDestroy(LifecycleOwner owner) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, owner) == null) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                b.post(new Runnable() { // from class: com.baidu.tieba.jma
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            PageTraceMonitor.RecycleLifecycleObserver.b(PageTraceMonitor.RecycleLifecycleObserver.this);
                        }
                    }
                });
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageTraceMonitor(R thisRef, hma traceType) {
        super(thisRef, traceType);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {thisRef, traceType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((pma) objArr2[0], (hma) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(traceType, "traceType");
    }

    @Override // com.baidu.tieba.mma
    @MainThread
    public AbsEventNode a(R thisRef, hma traceType) {
        InterceptResult invokeLL;
        Lifecycle.State state;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, thisRef, traceType)) == null) {
            Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            Intrinsics.checkNotNullParameter(traceType, "traceType");
            TraceEventNode traceEventNode = new TraceEventNode(i(thisRef), thisRef.I1(), hma.c.a);
            Lifecycle h = h(thisRef);
            if (h != null) {
                state = h.getCurrentState();
            } else {
                state = null;
            }
            if (state != Lifecycle.State.DESTROYED && h != null) {
                h.addObserver(new RecycleLifecycleObserver(this));
            }
            return traceEventNode;
        }
        return (AbsEventNode) invokeLL.objValue;
    }
}
