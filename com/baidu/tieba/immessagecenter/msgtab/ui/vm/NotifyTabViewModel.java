package com.baidu.tieba.immessagecenter.msgtab.ui.vm;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tieba.cm8;
import com.baidu.tieba.immessagecenter.arch.vm.BaseViewModel;
import com.baidu.tieba.immessagecenter.msgtab.obs.NotificationChangedMonitor;
import com.baidu.tieba.immessagecenter.msgtab.ui.model.MsgTabNotifyModel;
import com.baidu.tieba.immessagecenter.msgtab.ui.vm.NotifyTabViewModel;
import com.baidu.tieba.ltb;
import com.baidu.tieba.ptb;
import com.baidu.tieba.ro8;
import com.baidu.tieba.so8;
import com.baidu.tieba.vo8;
import com.baidu.tieba.xxb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H\u0014J\b\u0010\n\u001a\u00020\u0002H\u0014J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/vm/NotifyTabViewModel;", "Lcom/baidu/tieba/immessagecenter/arch/vm/BaseViewModel;", "Lcom/baidu/tieba/immessagecenter/msgtab/uidata/MsgCenterNotifyTabUiState;", "Lcom/baidu/tieba/immessagecenter/msgtab/uidata/MsgCenterNotifyTabUiIntent;", "()V", "model", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/model/MsgTabNotifyModel;", "handleUiIntent", "", "intent", "initUiState", "onAttachedUi", "onDetachedUi", "registerSubscribe", "Lrx/subscriptions/CompositeSubscription;", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class NotifyTabViewModel extends BaseViewModel<so8, ro8> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MsgTabNotifyModel d;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.arch.vm.BaseViewModel
    /* renamed from: m */
    public void i(ro8 intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, intent) == null) {
            Intrinsics.checkNotNullParameter(intent, "intent");
        }
    }

    public NotifyTabViewModel() {
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
        this.d = new MsgTabNotifyModel();
    }

    @Override // com.baidu.tieba.immessagecenter.arch.vm.BaseViewModel, com.baidu.tieba.jd8
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.b();
            this.d.b();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.vm.BaseViewModel, com.baidu.tieba.jd8
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.f();
            this.d.f();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.arch.vm.BaseViewModel
    /* renamed from: n */
    public so8 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return so8.b.a;
        }
        return (so8) invokeV.objValue;
    }

    public static final void o(NotifyTabViewModel this$0, final List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, list) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            final so8 e = this$0.e();
            if (e instanceof so8.d) {
                this$0.c(new Function1<so8, so8>(list, e) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.vm.NotifyTabViewModel$registerSubscribe$1$1$1
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ so8 $cache;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ List<cm8> $it;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {list, e};
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
                        this.$cache = e;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function1
                    public final so8 invoke(so8 emitUiState) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, emitUiState)) == null) {
                            Intrinsics.checkNotNullParameter(emitUiState, "$this$emitUiState");
                            List<cm8> it = this.$it;
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            return new so8.d(it, ((so8.d) this.$cache).b());
                        }
                        return (so8) invokeL.objValue;
                    }
                });
            } else {
                this$0.c(new Function1<so8, so8>(list) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.vm.NotifyTabViewModel$registerSubscribe$1$1$2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ List<cm8> $it;

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
                    public final so8 invoke(so8 emitUiState) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, emitUiState)) == null) {
                            Intrinsics.checkNotNullParameter(emitUiState, "$this$emitUiState");
                            List<cm8> it = this.$it;
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            return new so8.d(it, CollectionsKt__CollectionsKt.emptyList());
                        }
                        return (so8) invokeL.objValue;
                    }
                });
            }
        }
    }

    public static final void q(NotifyTabViewModel this$0, final List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, this$0, list) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            final so8 e = this$0.e();
            if (e instanceof so8.d) {
                this$0.c(new Function1<so8, so8>(e, list) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.vm.NotifyTabViewModel$registerSubscribe$1$3$1
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ so8 $cache;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ List<ImMessageCenterShowItemData> $it;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {e, list};
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
                        this.$cache = e;
                        this.$it = list;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function1
                    public final so8 invoke(so8 emitUiState) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, emitUiState)) == null) {
                            Intrinsics.checkNotNullParameter(emitUiState, "$this$emitUiState");
                            List<cm8> a = ((so8.d) this.$cache).a();
                            List<ImMessageCenterShowItemData> it = this.$it;
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            return new so8.d(a, it);
                        }
                        return (so8) invokeL.objValue;
                    }
                });
            } else {
                this$0.c(new Function1<so8, so8>(list) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.vm.NotifyTabViewModel$registerSubscribe$1$3$2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ List<ImMessageCenterShowItemData> $it;

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
                    public final so8 invoke(so8 emitUiState) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, emitUiState)) == null) {
                            Intrinsics.checkNotNullParameter(emitUiState, "$this$emitUiState");
                            List emptyList = CollectionsKt__CollectionsKt.emptyList();
                            List<ImMessageCenterShowItemData> it = this.$it;
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            return new so8.d(emptyList, it);
                        }
                        return (so8) invokeL.objValue;
                    }
                });
            }
        }
    }

    public static final void r(NotifyTabViewModel this$0, final Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, bool) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.c(new Function1<so8, so8>(bool) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.vm.NotifyTabViewModel$registerSubscribe$1$4$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Boolean $it;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bool};
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
                    this.$it = bool;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function1
                public final so8 invoke(so8 emitUiState) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, emitUiState)) == null) {
                        Intrinsics.checkNotNullParameter(emitUiState, "$this$emitUiState");
                        Boolean it = this.$it;
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        return new so8.a(it.booleanValue());
                    }
                    return (so8) invokeL.objValue;
                }
            });
        }
    }

    public static final void s(NotifyTabViewModel this$0, final Pair pair) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, this$0, pair) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            vo8.a.h(((Boolean) pair.getFirst()).booleanValue());
            this$0.c(new Function1<so8, so8>(pair) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.vm.NotifyTabViewModel$registerSubscribe$1$5$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Pair<Boolean, Boolean> $it;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {pair};
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
                    this.$it = pair;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function1
                public final so8 invoke(so8 emitUiState) {
                    InterceptResult invokeL;
                    boolean z;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, emitUiState)) == null) {
                        Intrinsics.checkNotNullParameter(emitUiState, "$this$emitUiState");
                        if (!this.$it.getFirst().booleanValue() && this.$it.getSecond().booleanValue()) {
                            z = true;
                        } else {
                            z = false;
                        }
                        return new so8.c(z);
                    }
                    return (so8) invokeL.objValue;
                }
            });
        }
    }

    public static final List p(List it) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, it)) == null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            return CollectionsKt___CollectionsKt.distinct(it);
        }
        return (List) invokeL.objValue;
    }

    @Override // com.baidu.tieba.immessagecenter.arch.vm.BaseViewModel
    public xxb l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            xxb xxbVar = new xxb();
            xxbVar.a(this.d.l().F(new ltb() { // from class: com.baidu.tieba.zn8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ltb
                public final void call(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        NotifyTabViewModel.o(NotifyTabViewModel.this, (List) obj);
                    }
                }
            }));
            xxbVar.a(this.d.n().p(new ptb() { // from class: com.baidu.tieba.ao8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ptb
                public final Object call(Object obj) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) ? NotifyTabViewModel.p((List) obj) : invokeL.objValue;
                }
            }).F(new ltb() { // from class: com.baidu.tieba.jo8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ltb
                public final void call(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        NotifyTabViewModel.q(NotifyTabViewModel.this, (List) obj);
                    }
                }
            }));
            xxbVar.a(this.d.j().F(new ltb() { // from class: com.baidu.tieba.io8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ltb
                public final void call(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        NotifyTabViewModel.r(NotifyTabViewModel.this, (Boolean) obj);
                    }
                }
            }));
            xxbVar.a(NotificationChangedMonitor.c.a().f().F(new ltb() { // from class: com.baidu.tieba.go8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ltb
                public final void call(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        NotifyTabViewModel.s(NotifyTabViewModel.this, (Pair) obj);
                    }
                }
            }));
            return xxbVar;
        }
        return (xxb) invokeV.objValue;
    }
}
