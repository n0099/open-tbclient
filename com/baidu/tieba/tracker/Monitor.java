package com.baidu.tieba.tracker;

import androidx.fragment.app.Fragment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tieba.gpa;
import com.baidu.tieba.hpa;
import com.baidu.tieba.ipa;
import com.baidu.tieba.lpa;
import com.baidu.tieba.mpa;
import com.baidu.tieba.npa;
import com.baidu.tieba.qpa;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0007J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u0005R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/baidu/tieba/tracker/Monitor;", "", "()V", "mMonitors", "", "", "Lcom/baidu/tieba/tracker/core/monitors/TraceMonitor;", "Lcom/baidu/tieba/tracker/interfaces/ITraceable;", CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, "fragment", "Landroidx/fragment/app/Fragment;", "ref", "activity", "Landroidx/fragment/app/FragmentActivity;", "event", "Lcom/baidu/tieba/tracker/core/data/TraceEvent;", "remove", "pid", "tracker"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class Monitor {
    public static /* synthetic */ Interceptable $ic;
    public static final Monitor a;
    public static Map<String, npa<qpa>> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1983622906, "Lcom/baidu/tieba/tracker/Monitor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1983622906, "Lcom/baidu/tieba/tracker/Monitor;");
                return;
            }
        }
        a = new Monitor();
        b = new LinkedHashMap();
    }

    public Monitor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final npa<qpa> a(Fragment fragment, qpa ref) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, fragment, ref)) == null) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(ref, "ref");
            final String traceId = ref.getTraceId();
            npa<qpa> npaVar = b.get(traceId);
            if (npaVar == null) {
                npaVar = new mpa<>(fragment, ref, new Function1<qpa, hpa>(traceId) { // from class: com.baidu.tieba.tracker.Monitor$get$monitor$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String $pid;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {traceId};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$pid = traceId;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function1
                    public final hpa invoke(qpa it) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, it)) == null) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            return gpa.a.b(this.$pid);
                        }
                        return (hpa) invokeL.objValue;
                    }
                });
            }
            b.put(traceId, npaVar);
            return npaVar;
        }
        return (npa) invokeLL.objValue;
    }

    public final npa<qpa> b(final ipa event) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event)) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            npa<qpa> npaVar = b.get(event.getTraceId());
            if (npaVar == null) {
                npaVar = new lpa<>(event, new Function1<qpa, hpa>(event) { // from class: com.baidu.tieba.tracker.Monitor$get$monitor$3
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ ipa $event;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {event};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$event = event;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function1
                    public final hpa invoke(qpa it) {
                        InterceptResult invokeL2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, it)) == null) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            return gpa.a.b(this.$event.getTraceId());
                        }
                        return (hpa) invokeL2.objValue;
                    }
                });
            }
            b.put(event.getTraceId(), npaVar);
            return npaVar;
        }
        return (npa) invokeL.objValue;
    }

    public final npa<qpa> c(String pid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pid)) == null) {
            Intrinsics.checkNotNullParameter(pid, "pid");
            return b.remove(pid);
        }
        return (npa) invokeL.objValue;
    }
}
