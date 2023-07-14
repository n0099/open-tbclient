package com.baidu.tieba.immessagecenter.msgtab.ui.vm;

import android.app.Activity;
import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.i2c;
import com.baidu.tieba.immessagecenter.arch.vm.BaseViewModel;
import com.baidu.tieba.immessagecenter.msgtab.data.MsgTabFunctionData;
import com.baidu.tieba.immessagecenter.msgtab.obs.ForumChannelDataObs;
import com.baidu.tieba.immessagecenter.msgtab.ui.model.MsgCenterContainerModel;
import com.baidu.tieba.immessagecenter.msgtab.ui.vm.MsgCenterContainerViewModel;
import com.baidu.tieba.qu8;
import com.baidu.tieba.ru8;
import com.baidu.tieba.tr8;
import com.baidu.tieba.u6c;
import com.baidu.tieba.us8;
import com.baidu.tieba.yz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0014J\b\u0010\f\u001a\u00020\u0002H\u0014J\b\u0010\r\u001a\u00020\u000eH\u0014J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/vm/MsgCenterContainerViewModel;", "Lcom/baidu/tieba/immessagecenter/arch/vm/BaseViewModel;", "Lcom/baidu/tieba/immessagecenter/msgtab/uidata/MsgCenterNavigationUiState;", "Lcom/baidu/tieba/immessagecenter/msgtab/uidata/MsgCenterNavigationUiIntent;", "()V", "model", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/model/MsgCenterContainerModel;", "presenter", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/prenster/MsgCenterContainerPresenter;", "handleUiIntent", "", "intent", "initUiState", "registerSubscribe", "Lrx/subscriptions/CompositeSubscription;", "startWebView", "context", "Landroid/content/Context;", "dataId", "", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgCenterContainerViewModel extends BaseViewModel<ru8, qu8> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MsgCenterContainerModel d;
    public final us8 e;

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
        this.e = new us8();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.arch.vm.BaseViewModel
    /* renamed from: n */
    public ru8 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return ru8.c.a;
        }
        return (ru8) invokeV.objValue;
    }

    public static final void o(MsgCenterContainerViewModel this$0, final List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, list) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.c(new Function1<ru8, ru8>(list) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.vm.MsgCenterContainerViewModel$registerSubscribe$1$1$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ List<tr8> $it;

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
                    this.$it = list;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function1
                public final ru8 invoke(ru8 emitUiState) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, emitUiState)) == null) {
                        Intrinsics.checkNotNullParameter(emitUiState, "$this$emitUiState");
                        List<tr8> it = this.$it;
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        return new ru8.b(it);
                    }
                    return (ru8) invokeL.objValue;
                }
            });
        }
    }

    public static final void p(MsgCenterContainerViewModel this$0, final List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, this$0, list) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.c(new Function1<ru8, ru8>(list) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.vm.MsgCenterContainerViewModel$registerSubscribe$1$2$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ List<tr8> $it;

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
                    this.$it = list;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function1
                public final ru8 invoke(ru8 emitUiState) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, emitUiState)) == null) {
                        Intrinsics.checkNotNullParameter(emitUiState, "$this$emitUiState");
                        List<tr8> it = this.$it;
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        return new ru8.a(it);
                    }
                    return (ru8) invokeL.objValue;
                }
            });
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.vm.BaseViewModel
    public u6c l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            u6c u6cVar = new u6c();
            u6cVar.a(this.d.g().H(new i2c() { // from class: com.baidu.tieba.du8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.i2c
                public final void call(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        MsgCenterContainerViewModel.o(MsgCenterContainerViewModel.this, (List) obj);
                    }
                }
            }));
            u6cVar.a(this.d.f().H(new i2c() { // from class: com.baidu.tieba.fu8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.i2c
                public final void call(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        MsgCenterContainerViewModel.p(MsgCenterContainerViewModel.this, (List) obj);
                    }
                }
            }));
            return u6cVar;
        }
        return (u6c) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.arch.vm.BaseViewModel
    /* renamed from: m */
    public void h(qu8 intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (intent instanceof qu8.d) {
                qu8.d dVar = (qu8.d) intent;
                Activity pageActivity = dVar.getContext().getPageActivity();
                Intrinsics.checkNotNullExpressionValue(pageActivity, "intent.context.pageActivity");
                q(pageActivity, dVar.a());
            } else if (intent instanceof qu8.b) {
                this.d.k(((qu8.b) intent).getContext(), true);
            } else if (intent instanceof qu8.a) {
                this.d.k(((qu8.a) intent).getContext(), false);
            } else if (intent instanceof qu8.c) {
                this.d.l();
            }
        }
    }

    public final void q(Context context, long j) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048581, this, context, j) == null) {
            List<tr8> b = this.d.b();
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
                    yz4 j2 = yz4.j(context, f.getScheme());
                    j2.f(this.e.a(b));
                    j2.p();
                }
            }
        }
    }
}
