package com.baidu.tieba.tracker.core.monitors;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.fja;
import com.baidu.tieba.jja;
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
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\n\b\u0000\u0010\u0001 \u0000*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H\u0017¢\u0006\u0002\u0010\bJ\u0017\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00028\u0000H$¢\u0006\u0002\u0010\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00028\u0000H$¢\u0006\u0002\u0010\u000eJ9\u0010\u000f\u001a\u00020\u00102*\u0010\u0011\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u00130\u0012\"\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u0013H$¢\u0006\u0002\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/baidu/tieba/tracker/core/monitors/PageTraceMonitor;", "R", "Lcom/baidu/tieba/tracker/interfaces/ITraceable;", "Lcom/baidu/tieba/tracker/core/monitors/TraceMonitor;", "()V", "createTrackNode", "Lcom/baidu/tieba/tracker/core/data/AbsEventNode;", "thisRef", "(Lcom/baidu/tieba/tracker/interfaces/ITraceable;)Lcom/baidu/tieba/tracker/core/data/AbsEventNode;", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "(Lcom/baidu/tieba/tracker/interfaces/ITraceable;)Landroidx/lifecycle/Lifecycle;", "getParentPage", "", "(Lcom/baidu/tieba/tracker/interfaces/ITraceable;)Ljava/lang/String;", GameAssistConstKt.TYPE_CALLBACK_ERROR, "", "params", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)V", "RecycleLifecycleObserver", "tracker"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public abstract class PageTraceMonitor<R extends jja> extends fja<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract Lifecycle g(R r);

    public abstract String h(R r);

    public abstract void i(Pair<String, String>... pairArr);

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

        public static final void c(RecycleLifecycleObserver this$0) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, null, this$0) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                this$0.a.i(TuplesKt.to(StatConstants.KEY_EXT_ERR_CODE, ErrCode.ON_DESTROY.getValue()));
            }
        }

        @MainThread
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public final void onDestroy(LifecycleOwner owner) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, owner) == null) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                b.post(new Runnable() { // from class: com.baidu.tieba.dja
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            PageTraceMonitor.RecycleLifecycleObserver.c(PageTraceMonitor.RecycleLifecycleObserver.this);
                        }
                    }
                });
            }
        }
    }

    public PageTraceMonitor() {
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

    @Override // com.baidu.tieba.fja
    @MainThread
    public AbsEventNode a(R thisRef) {
        InterceptResult invokeL;
        Lifecycle.State state;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, thisRef)) == null) {
            Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            TraceEventNode traceEventNode = new TraceEventNode(thisRef.getFrom(), h(thisRef), NotificationCompat.CATEGORY_NAVIGATION, thisRef.getScene());
            Lifecycle g = g(thisRef);
            if (g != null) {
                state = g.getCurrentState();
            } else {
                state = null;
            }
            if (state != Lifecycle.State.DESTROYED && g != null) {
                g.addObserver(new RecycleLifecycleObserver(this));
            }
            return traceEventNode;
        }
        return (AbsEventNode) invokeL.objValue;
    }
}
