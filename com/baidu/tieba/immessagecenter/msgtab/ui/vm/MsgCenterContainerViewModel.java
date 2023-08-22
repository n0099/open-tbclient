package com.baidu.tieba.immessagecenter.msgtab.ui.vm;

import android.app.Activity;
import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b8c;
import com.baidu.tieba.hz4;
import com.baidu.tieba.immessagecenter.arch.vm.BaseViewModel;
import com.baidu.tieba.immessagecenter.msgtab.ui.model.MsgCenterContainerModel;
import com.baidu.tieba.immessagecenter.msgtab.ui.vm.MsgCenterContainerViewModel;
import com.baidu.tieba.lw8;
import com.baidu.tieba.mw8;
import com.baidu.tieba.occ;
import com.baidu.tieba.ot8;
import com.baidu.tieba.su8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0014J\b\u0010\u000f\u001a\u00020\u0002H\u0014J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\rH\u0002J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/vm/MsgCenterContainerViewModel;", "Lcom/baidu/tieba/immessagecenter/arch/vm/BaseViewModel;", "Lcom/baidu/tieba/immessagecenter/msgtab/uidata/MsgCenterNavigationUiState;", "Lcom/baidu/tieba/immessagecenter/msgtab/uidata/MsgCenterNavigationUiIntent;", "()V", "model", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/model/MsgCenterContainerModel;", "presenter", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/prenster/MsgCenterContainerPresenter;", "getLocateToTabId", "", "defaultValue", "handleUiIntent", "", "intent", "initUiState", "registerSubscribe", "Lrx/subscriptions/CompositeSubscription;", "resetSelectedItem", "startWebView", "context", "Landroid/content/Context;", "scheme", "", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgCenterContainerViewModel extends BaseViewModel<mw8, lw8> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MsgCenterContainerModel d;
    public final su8 e;

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
        this.e = new su8();
    }

    @Override // com.baidu.tieba.immessagecenter.arch.vm.BaseViewModel
    public occ l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            occ occVar = new occ();
            occVar.a(this.d.e().H(new b8c() { // from class: com.baidu.tieba.wv8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.b8c
                public final void call(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        MsgCenterContainerViewModel.p(MsgCenterContainerViewModel.this, (List) obj);
                    }
                }
            }));
            return occVar;
        }
        return (occ) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.arch.vm.BaseViewModel
    /* renamed from: o */
    public mw8 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return mw8.b.a;
        }
        return (mw8) invokeV.objValue;
    }

    public static final void p(MsgCenterContainerViewModel this$0, final List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, list) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.b(new Function1<mw8, mw8>(list) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.vm.MsgCenterContainerViewModel$registerSubscribe$1$1$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ List<ot8> $list;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {list};
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
                    this.$list = list;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function1
                public final mw8 invoke(mw8 emitUiState) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, emitUiState)) == null) {
                        Intrinsics.checkNotNullParameter(emitUiState, "$this$emitUiState");
                        List<ot8> list2 = this.$list;
                        Intrinsics.checkNotNullExpressionValue(list2, "list");
                        return new mw8.a(list2);
                    }
                    return (mw8) invokeL.objValue;
                }
            });
        }
    }

    public final void q(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, str) == null) {
            List<ot8> b = this.d.b();
            hz4 j = hz4.j(context, str);
            j.f(this.e.a(b));
            j.p();
        }
    }

    public final long m(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
            return this.e.c(j);
        }
        return invokeJ.longValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.arch.vm.BaseViewModel
    /* renamed from: n */
    public void h(lw8 intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, intent) == null) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (intent instanceof lw8.c) {
                lw8.c cVar = (lw8.c) intent;
                Activity pageActivity = cVar.getContext().getPageActivity();
                Intrinsics.checkNotNullExpressionValue(pageActivity, "intent.context.pageActivity");
                q(pageActivity, cVar.a());
            } else if (intent instanceof lw8.b) {
                this.d.h(((lw8.b) intent).getContext(), true);
            } else if (intent instanceof lw8.a) {
                this.d.h(((lw8.a) intent).getContext(), false);
            }
        }
    }
}
