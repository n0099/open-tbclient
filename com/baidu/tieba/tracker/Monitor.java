package com.baidu.tieba.tracker;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tieba.cza;
import com.baidu.tieba.dza;
import com.baidu.tieba.fza;
import com.baidu.tieba.gza;
import com.baidu.tieba.jza;
import com.baidu.tieba.kza;
import com.baidu.tieba.lza;
import com.baidu.tieba.mza;
import com.baidu.tieba.qza;
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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rJ\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0007J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rJ\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u0007J\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u0005R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/baidu/tieba/tracker/Monitor;", "", "()V", "mMonitors", "", "", "Lcom/baidu/tieba/tracker/core/monitors/TraceMonitor;", "Lcom/baidu/tieba/tracker/interfaces/ITraceable;", CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, "fragment", "Landroidx/fragment/app/Fragment;", "ref", "type", "Lcom/baidu/tieba/tracker/core/data/TraceType;", "activity", "Landroidx/fragment/app/FragmentActivity;", "event", "Lcom/baidu/tieba/tracker/core/data/TraceEvent;", "traceType", "remove", "pid", "tracker"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class Monitor {
    public static /* synthetic */ Interceptable $ic;
    public static final Monitor a;
    public static Map<String, mza<qza>> b;
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

    public final mza<qza> a(Fragment fragment, qza ref, gza type) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, fragment, ref, type)) == null) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(ref, "ref");
            Intrinsics.checkNotNullParameter(type, "type");
            final String traceId = ref.getTraceId();
            mza<qza> mzaVar = b.get(traceId);
            if (mzaVar == null) {
                mzaVar = new lza<>(fragment, ref, type, new Function1<qza, dza>(traceId) { // from class: com.baidu.tieba.tracker.Monitor$get$monitor$1
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
                    public final dza invoke(qza it) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, it)) == null) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            return cza.a.b(this.$pid);
                        }
                        return (dza) invokeL.objValue;
                    }
                });
            }
            b.put(traceId, mzaVar);
            return mzaVar;
        }
        return (mza) invokeLLL.objValue;
    }

    public final mza<qza> b(FragmentActivity activity, qza ref) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, ref)) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(ref, "ref");
            final String traceId = ref.getTraceId();
            mza<qza> mzaVar = b.get(traceId);
            if (mzaVar == null) {
                mzaVar = new jza<>(activity, ref, new Function1<qza, dza>(traceId) { // from class: com.baidu.tieba.tracker.Monitor$get$monitor$2
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
                    public final dza invoke(qza it) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, it)) == null) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            return cza.a.b(this.$pid);
                        }
                        return (dza) invokeL.objValue;
                    }
                });
            }
            b.put(traceId, mzaVar);
            return mzaVar;
        }
        return (mza) invokeLL.objValue;
    }

    public final mza<qza> c(final fza event, gza traceType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, event, traceType)) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(traceType, "traceType");
            mza<qza> mzaVar = b.get(event.getTraceId());
            if (mzaVar == null) {
                mzaVar = new kza<>(event, traceType, new Function1<qza, dza>(event) { // from class: com.baidu.tieba.tracker.Monitor$get$monitor$3
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ fza $event;
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
                    public final dza invoke(qza it) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, it)) == null) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            return cza.a.b(this.$event.getTraceId());
                        }
                        return (dza) invokeL.objValue;
                    }
                });
            }
            b.put(event.getTraceId(), mzaVar);
            return mzaVar;
        }
        return (mza) invokeLL.objValue;
    }

    public final mza<qza> d(qza ref) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ref)) == null) {
            Intrinsics.checkNotNullParameter(ref, "ref");
            String traceId = ref.getTraceId();
            if (b.containsKey(traceId)) {
                return b.get(traceId);
            }
            return null;
        }
        return (mza) invokeL.objValue;
    }

    public final mza<qza> e(String pid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, pid)) == null) {
            Intrinsics.checkNotNullParameter(pid, "pid");
            return b.remove(pid);
        }
        return (mza) invokeL.objValue;
    }
}
