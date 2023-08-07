package com.baidu.tieba.immessagecenter.msgtab.ui.vm;

import android.app.Activity;
import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.cz4;
import com.baidu.tieba.immessagecenter.arch.vm.BaseViewModel;
import com.baidu.tieba.immessagecenter.msgtab.data.MsgTabFunctionData;
import com.baidu.tieba.immessagecenter.msgtab.obs.ForumChannelDataObs;
import com.baidu.tieba.immessagecenter.msgtab.ui.model.MsgCenterContainerModel;
import com.baidu.tieba.immessagecenter.msgtab.ui.vm.MsgCenterContainerViewModel;
import com.baidu.tieba.l1c;
import com.baidu.tieba.ms8;
import com.baidu.tieba.np8;
import com.baidu.tieba.ns8;
import com.baidu.tieba.rq8;
import com.baidu.tieba.x5c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0014J\b\u0010\u000f\u001a\u00020\u0002H\u0014J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\rH\u0002J\u0015\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0006H\u0002R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/vm/MsgCenterContainerViewModel;", "Lcom/baidu/tieba/immessagecenter/arch/vm/BaseViewModel;", "Lcom/baidu/tieba/immessagecenter/msgtab/uidata/MsgCenterNavigationUiState;", "Lcom/baidu/tieba/immessagecenter/msgtab/uidata/MsgCenterNavigationUiIntent;", "()V", "initSelectedTabId", "", "Ljava/lang/Long;", "model", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/model/MsgCenterContainerModel;", "presenter", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/prenster/MsgCenterContainerPresenter;", "handleUiIntent", "", "intent", "initUiState", "registerSubscribe", "Lrx/subscriptions/CompositeSubscription;", "resetSelectedItem", "setDefaultSelectedTab", "tabId", "", "(Ljava/lang/Integer;)V", "startWebView", "context", "Landroid/content/Context;", "dataId", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgCenterContainerViewModel extends BaseViewModel<ns8, ms8> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MsgCenterContainerModel d;
    public final rq8 e;
    public Long f;

    public MsgCenterContainerViewModel() {
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
        this.d = new MsgCenterContainerModel();
        this.e = new rq8();
    }

    @Override // com.baidu.tieba.immessagecenter.arch.vm.BaseViewModel
    public x5c l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            x5c x5cVar = new x5c();
            x5cVar.a(this.d.f().H(new l1c() { // from class: com.baidu.tieba.zr8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.l1c
                public final void call(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        MsgCenterContainerViewModel.o(MsgCenterContainerViewModel.this, (List) obj);
                    }
                }
            }));
            return x5cVar;
        }
        return (x5c) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.arch.vm.BaseViewModel
    /* renamed from: n */
    public ns8 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return ns8.c.a;
        }
        return (ns8) invokeV.objValue;
    }

    public static final void o(MsgCenterContainerViewModel this$0, final List list) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, list) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Iterator<np8> it = this$0.d.e().iterator();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                i = -1;
                if (it.hasNext()) {
                    if (it.next().d()) {
                        break;
                    }
                    i3++;
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 < 0) {
                Intrinsics.checkNotNullExpressionValue(list, "list");
                Iterator it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    } else if (((np8) it2.next()).d()) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i < 0) {
                    this$0.p();
                }
            }
            this$0.b(new Function1<ns8, ns8>(list) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.vm.MsgCenterContainerViewModel$registerSubscribe$1$1$3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ List<np8> $list;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {list};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$list = list;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function1
                public final ns8 invoke(ns8 emitUiState) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, emitUiState)) == null) {
                        Intrinsics.checkNotNullParameter(emitUiState, "$this$emitUiState");
                        List<np8> list2 = this.$list;
                        Intrinsics.checkNotNullExpressionValue(list2, "list");
                        return new ns8.a(list2);
                    }
                    return (ns8) invokeL.objValue;
                }
            });
        }
    }

    public final void q(Integer num) {
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, num) == null) {
            if (num == null || num.intValue() != 0) {
                if (num != null) {
                    l = Long.valueOf(num.intValue());
                } else {
                    l = null;
                }
                this.f = l;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.arch.vm.BaseViewModel
    /* renamed from: m */
    public void h(ms8 intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (intent instanceof ms8.d) {
                ms8.d dVar = (ms8.d) intent;
                Activity pageActivity = dVar.getContext().getPageActivity();
                Intrinsics.checkNotNullExpressionValue(pageActivity, "intent.context.pageActivity");
                r(pageActivity, dVar.a());
            } else if (intent instanceof ms8.b) {
                this.d.i(((ms8.b) intent).getContext(), true);
            } else if (intent instanceof ms8.a) {
                this.d.i(((ms8.a) intent).getContext(), false);
            } else if (intent instanceof ms8.c) {
                p();
            }
        }
    }

    public final void p() {
        long c;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            final List<np8> e = this.d.e();
            Long l = this.f;
            if (l != null) {
                c = l.longValue();
            } else {
                c = this.e.c(-2L);
            }
            for (np8 np8Var : e) {
                if (np8Var.c() == c) {
                    z = true;
                } else {
                    z = false;
                }
                np8Var.e(z);
            }
            b(new Function1<ns8, ns8>(e) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.vm.MsgCenterContainerViewModel$resetSelectedItem$1$2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ List<np8> $it;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {e};
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
                    this.$it = e;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function1
                public final ns8 invoke(ns8 emitUiState) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, emitUiState)) == null) {
                        Intrinsics.checkNotNullParameter(emitUiState, "$this$emitUiState");
                        return new ns8.b(this.$it);
                    }
                    return (ns8) invokeL.objValue;
                }
            });
        }
    }

    public final void r(Context context, long j) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048583, this, context, j) == null) {
            List<np8> b = this.d.b();
            MsgTabFunctionData f = ForumChannelDataObs.c.a().f(j);
            if (f != null) {
                if (b != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    f = null;
                }
                if (f != null) {
                    cz4 j2 = cz4.j(context, f.getScheme());
                    j2.f(this.e.a(b));
                    j2.p();
                }
            }
        }
    }
}
