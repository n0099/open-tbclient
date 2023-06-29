package com.baidu.tieba.immessagecenter.arch.vm;

import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tieba.htb;
import com.baidu.tieba.immessagecenter.arch.vm.IUiIntent;
import com.baidu.tieba.immessagecenter.arch.vm.IUiState;
import com.baidu.tieba.jd8;
import com.baidu.tieba.sxb;
import com.baidu.tieba.xsb;
import com.baidu.tieba.xxb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u00052\u00020\u0006B\u0005¢\u0006\u0002\u0010\u0007J!\u0010\u0016\u001a\u00020\u00172\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0019¢\u0006\u0002\b\u001aH\u0004J\u000f\u0010\u001b\u001a\u0004\u0018\u00018\u0000H\u0004¢\u0006\u0002\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00028\u0001H$¢\u0006\u0002\u0010\u001fJ\r\u0010 \u001a\u00028\u0000H$¢\u0006\u0002\u0010\u001cJ\b\u0010!\u001a\u00020\u0017H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0016J\u0013\u0010#\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00028\u0001¢\u0006\u0002\u0010\u001fJ\n\u0010$\u001a\u0004\u0018\u00010\u0011H$R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006%"}, d2 = {"Lcom/baidu/tieba/immessagecenter/arch/vm/BaseViewModel;", "UiState", "Lcom/baidu/tieba/immessagecenter/arch/vm/IUiState;", "UiIntent", "Lcom/baidu/tieba/immessagecenter/arch/vm/IUiIntent;", "Landroidx/lifecycle/ViewModel;", "Lcom/baidu/tieba/immessagecenter/arch/base/IUiLifeCycle;", "()V", "_uiIntentChannel", "Lkotlinx/coroutines/channels/Channel;", "_uiStateBs", "Lrx/subjects/BehaviorSubject;", "get_uiStateBs", "()Lrx/subjects/BehaviorSubject;", "_uiStateBs$delegate", "Lkotlin/Lazy;", "mSubscriptions", "Lrx/subscriptions/CompositeSubscription;", "uiStateSubject", "Lrx/Observable;", "getUiStateSubject", "()Lrx/Observable;", "emitUiState", "", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "getCacheUiState", "()Lcom/baidu/tieba/immessagecenter/arch/vm/IUiState;", "handleUiIntent", "intent", "(Lcom/baidu/tieba/immessagecenter/arch/vm/IUiIntent;)V", "initUiState", "onAttachedUi", "onDetachedUi", "publishUiIntent", "registerSubscribe", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class BaseViewModel<UiState extends IUiState, UiIntent extends IUiIntent> extends ViewModel implements jd8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xxb a;
    public final Lazy b;
    public final Channel<UiIntent> c;

    public abstract void i(UiIntent uiintent);

    public abstract UiState j();

    public abstract xxb l();

    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0005*\u00020\u0006H\u008a@"}, d2 = {"<anonymous>", "", "UiState", "Lcom/baidu/tieba/immessagecenter/arch/vm/IUiState;", "UiIntent", "Lcom/baidu/tieba/immessagecenter/arch/vm/IUiIntent;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.baidu.tieba.immessagecenter.arch.vm.BaseViewModel$1", f = "BaseViewModel.kt", i = {}, l = {111}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.baidu.tieba.immessagecenter.arch.vm.BaseViewModel$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int label;
        public final /* synthetic */ BaseViewModel<UiState, UiIntent> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(BaseViewModel<UiState, UiIntent> baseViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseViewModel, continuation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (Continuation) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = baseViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, continuation)) == null) ? new AnonymousClass1(this.this$0, continuation) : (Continuation) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, coroutineScope, continuation)) == null) ? ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : invokeLL.objValue;
        }

        /* renamed from: com.baidu.tieba.immessagecenter.arch.vm.BaseViewModel$1$a */
        /* loaded from: classes6.dex */
        public static final class a implements FlowCollector<UiIntent> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;
            public final /* synthetic */ BaseViewModel b;

            public a(BaseViewModel baseViewModel) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {baseViewModel};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = baseViewModel;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public Object emit(UiIntent uiintent, Continuation<? super Unit> continuation) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, uiintent, continuation)) == null) {
                    int i = this.a;
                    this.a = i + 1;
                    if (i >= 0) {
                        this.b.i(uiintent);
                        return Unit.INSTANCE;
                    }
                    throw new ArithmeticException("Index overflow has happened");
                }
                return invokeLL.objValue;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i != 0) {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Flow consumeAsFlow = FlowKt.consumeAsFlow(this.this$0.c);
                    a aVar = new a(this.this$0);
                    this.label = 1;
                    if (consumeAsFlow.collect(aVar, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            return invokeL.objValue;
        }
    }

    public BaseViewModel() {
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
        this.b = LazyKt__LazyJVMKt.lazy(new Function0<sxb<UiState>>(this) { // from class: com.baidu.tieba.immessagecenter.arch.vm.BaseViewModel$_uiStateBs$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BaseViewModel<UiState, UiIntent> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final sxb<UiState> invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return sxb.P(this.this$0.j());
                }
                return (sxb) invokeV.objValue;
            }
        });
        this.c = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public final void c(Function1<? super UiState, ? extends UiState> copy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, copy) == null) {
            Intrinsics.checkNotNullParameter(copy, "copy");
            sxb<UiState> h = h();
            UiState R = h().R();
            Intrinsics.checkNotNullExpressionValue(R, "_uiStateBs.value");
            h.onNext(copy.invoke(R));
        }
    }

    public final void k(UiIntent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, intent) == null) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$publishUiIntent$1(this, intent, null), 3, null);
        }
    }

    @Override // com.baidu.tieba.jd8
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            xxb xxbVar = new xxb();
            xxb l = l();
            if (l != null) {
                xxbVar.b(l);
            }
            this.a = xxbVar;
        }
    }

    public final UiState e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return h().R();
        }
        return (UiState) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jd8
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            xxb xxbVar = this.a;
            if (xxbVar != null) {
                xxbVar.unsubscribe();
            }
            xxb xxbVar2 = this.a;
            if (xxbVar2 != null) {
                xxbVar2.c();
            }
            this.a = null;
        }
    }

    public final xsb<UiState> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            xsb<UiState> s = h().a().w().s(htb.b());
            Intrinsics.checkNotNullExpressionValue(s, "_uiStateBs\n             …dSchedulers.mainThread())");
            return s;
        }
        return (xsb) invokeV.objValue;
    }

    public final sxb<UiState> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Object value = this.b.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-_uiStateBs>(...)");
            return (sxb) value;
        }
        return (sxb) invokeV.objValue;
    }
}
