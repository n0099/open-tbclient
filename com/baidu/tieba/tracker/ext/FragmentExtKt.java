package com.baidu.tieba.tracker.ext;

import androidx.fragment.app.Fragment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.i4b;
import com.baidu.tieba.l4b;
import com.baidu.tieba.tracker.Monitor;
import com.baidu.tieba.tracker.core.data.AbsEventNode;
import com.baidu.tieba.tracker.core.data.EventParams;
import com.baidu.tieba.z3b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u0001*\u00020\u00022*\u0010\u0003\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00050\u0004\"\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007\u001a?\u0010\b\u001a\u00020\u0001*\u00020\u00022.\u0010\u0003\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00050\u0004\"\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\u0002\u0010\u0007\u001a;\u0010\n\u001a\u00020\u0001*\u00020\u00022*\u0010\u0003\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00050\u0004\"\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007¨\u0006\u000b"}, d2 = {"errorMonitor", "", "Landroidx/fragment/app/Fragment;", "params", "", "Lkotlin/Pair;", "", "(Landroidx/fragment/app/Fragment;[Lkotlin/Pair;)V", "startMonitor", "", "stopMonitor", "tracker"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class FragmentExtKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(Fragment fragment, Pair<String, String>... params) {
        l4b l4bVar;
        i4b<l4b> d;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, fragment, params) == null) {
            Intrinsics.checkNotNullParameter(fragment, "<this>");
            Intrinsics.checkNotNullParameter(params, "params");
            if (fragment instanceof l4b) {
                l4bVar = (l4b) fragment;
            } else {
                l4bVar = null;
            }
            if (l4bVar != null && (d = Monitor.a.d(l4bVar)) != null) {
                d.b(MapsKt__MapsKt.mapOf((Pair[]) Arrays.copyOf(params, params.length)));
            }
        }
    }

    public static final void b(Fragment fragment, final Pair<String, ? extends Object>... params) {
        l4b l4bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, fragment, params) == null) {
            Intrinsics.checkNotNullParameter(fragment, "<this>");
            Intrinsics.checkNotNullParameter(params, "params");
            if (fragment instanceof l4b) {
                l4bVar = (l4b) fragment;
            } else {
                l4bVar = null;
            }
            if (l4bVar != null) {
                Monitor.a.a(fragment, l4bVar, z3b.c.a).h(20000L, new Function1<AbsEventNode, Unit>(params) { // from class: com.baidu.tieba.tracker.ext.FragmentExtKt$startMonitor$2$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Pair<String, Object>[] $params;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {params};
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
                        this.$params = params;
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(AbsEventNode absEventNode) {
                        invoke2(absEventNode);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(AbsEventNode node) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, node) == null) {
                            Intrinsics.checkNotNullParameter(node, "node");
                            Pair<String, Object>[] pairArr = this.$params;
                            node.fillTrackParams(new EventParams((Pair[]) Arrays.copyOf(pairArr, pairArr.length)));
                        }
                    }
                });
            }
        }
    }

    public static final void c(Fragment fragment, Pair<String, String>... params) {
        l4b l4bVar;
        i4b<l4b> d;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, fragment, params) == null) {
            Intrinsics.checkNotNullParameter(fragment, "<this>");
            Intrinsics.checkNotNullParameter(params, "params");
            if (fragment instanceof l4b) {
                l4bVar = (l4b) fragment;
            } else {
                l4bVar = null;
            }
            if (l4bVar != null && (d = Monitor.a.d(l4bVar)) != null) {
                d.l(MapsKt__MapsKt.mapOf((Pair[]) Arrays.copyOf(params, params.length)));
            }
        }
    }
}
