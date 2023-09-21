package com.baidu.tieba.pb.feedback;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.am9;
import com.baidu.tieba.pb.databinding.AigcFeedbackViewBinding;
import com.baidu.tieba.pb.feedback.AigcFeedbackView;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.ul9;
import com.baidu.tieba.zja;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tbclient.AigcFeedbackInfo;
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012JE\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152#\u0010\u0016\u001a\u001f\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00172\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dH\u0002R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/baidu/tieba/pb/feedback/AigcFeedbackView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/baidu/tieba/pb/databinding/AigcFeedbackViewBinding;", "getBinding", "()Lcom/baidu/tieba/pb/databinding/AigcFeedbackViewBinding;", "binding$delegate", "Lkotlin/Lazy;", "updateData", "", "postState", "Lcom/baidu/tieba/pb/feedback/AigcFeedbackPostState;", "updateState", "state", "Lcom/baidu/tieba/pb/feedback/AigcFeedbackViewState;", "onButtonClick", "Lkotlin/Function1;", "Lcom/baidu/tieba/pb/feedback/FeedbackButtonStateType;", "Lkotlin/ParameterName;", "name", "type", "onInterceptClick", "Lkotlin/Function0;", "", "pb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AigcFeedbackView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy a;

    /* loaded from: classes7.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1403439413, "Lcom/baidu/tieba/pb/feedback/AigcFeedbackView$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1403439413, "Lcom/baidu/tieba/pb/feedback/AigcFeedbackView$a;");
                    return;
                }
            }
            int[] iArr = new int[AigcFeedbackType.values().length];
            iArr[AigcFeedbackType.SELECT_POSITIVE_TYPE.ordinal()] = 1;
            iArr[AigcFeedbackType.SELECT_NEGATIVE_TYPE.ordinal()] = 2;
            iArr[AigcFeedbackType.UNSELECT_ALL_TYPE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AigcFeedbackView(Context context) {
        this(context, null, 0, 6, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AigcFeedbackView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AigcFeedbackView(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = LazyKt__LazyJVMKt.lazy(new Function0<AigcFeedbackViewBinding>(context, this) { // from class: com.baidu.tieba.pb.feedback.AigcFeedbackView$binding$2
            public static /* synthetic */ Interceptable $ic;
            public final /* synthetic */ Context $context;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AigcFeedbackView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {context, this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.$context = context;
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AigcFeedbackViewBinding invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return AigcFeedbackViewBinding.c(LayoutInflater.from(this.$context), this.this$0, true);
                }
                return (AigcFeedbackViewBinding) invokeV.objValue;
            }
        });
    }

    public /* synthetic */ AigcFeedbackView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static final void d(Function0 function0, AigcFeedbackView this$0, AigcFeedbackViewState state, Function1 function1, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65541, null, function0, this$0, state, function1, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(state, "$state");
            boolean z = true;
            if ((function0 == null || !((Boolean) function0.invoke()).booleanValue()) ? false : false) {
                return;
            }
            this$0.getBinding().c.a(state.g().c());
            this$0.getBinding().b.a(state.g().d());
            if (function1 != null) {
                function1.invoke(FeedbackButtonStateType.SELECT_POSITIVE_STATE);
            }
        }
    }

    public static final void e(Function0 function0, AigcFeedbackView this$0, AigcFeedbackViewState state, Function1 function1, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65542, null, function0, this$0, state, function1, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(state, "$state");
            boolean z = true;
            if ((function0 == null || !((Boolean) function0.invoke()).booleanValue()) ? false : false) {
                return;
            }
            this$0.getBinding().c.a(state.g().e());
            if (function1 != null) {
                function1.invoke(FeedbackButtonStateType.UNSELECT_POSITIVE_STATE);
            }
        }
    }

    public static final void f(Function0 function0, AigcFeedbackView this$0, AigcFeedbackViewState state, Function1 function1, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65543, null, function0, this$0, state, function1, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(state, "$state");
            boolean z = true;
            if ((function0 == null || !((Boolean) function0.invoke()).booleanValue()) ? false : false) {
                return;
            }
            this$0.getBinding().c.a(state.g().e());
            if (function1 != null) {
                function1.invoke(FeedbackButtonStateType.UNSELECT_POSITIVE_STATE);
            }
        }
    }

    public static final void g(Function0 function0, AigcFeedbackView this$0, AigcFeedbackViewState state, Function1 function1, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65544, null, function0, this$0, state, function1, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(state, "$state");
            boolean z = true;
            if ((function0 == null || !((Boolean) function0.invoke()).booleanValue()) ? false : false) {
                return;
            }
            this$0.getBinding().c.a(state.g().e());
            this$0.getBinding().b.a(state.g().a());
            if (function1 != null) {
                function1.invoke(FeedbackButtonStateType.SELECT_NEGATIVE_STATE);
            }
        }
    }

    public static final void h(Function0 function0, AigcFeedbackView this$0, AigcFeedbackViewState state, Function1 function1, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65546, null, function0, this$0, state, function1, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(state, "$state");
            boolean z = true;
            if ((function0 == null || !((Boolean) function0.invoke()).booleanValue()) ? false : false) {
                return;
            }
            this$0.getBinding().b.a(state.g().d());
            if (function1 != null) {
                function1.invoke(FeedbackButtonStateType.UNSELECT_NEGATIVE_STATE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AigcFeedbackViewBinding getBinding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            return (AigcFeedbackViewBinding) this.a.getValue();
        }
        return (AigcFeedbackViewBinding) invokeV.objValue;
    }

    public final void b(ul9 postState) {
        String str;
        String str2;
        String str3;
        boolean z;
        boolean z2;
        String str4;
        boolean z3;
        boolean z4;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, postState) == null) {
            Intrinsics.checkNotNullParameter(postState, "postState");
            zja c = postState.c();
            AigcFeedbackInfo s = c.s();
            String str5 = null;
            if (s != null) {
                str = s.positive_text;
            } else {
                str = null;
            }
            if (str == null) {
                str2 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str, "aigcFeedbackInfo?.positive_text ?: \"\"");
                str2 = str;
            }
            if (s != null) {
                str5 = s.negative_text;
            }
            if (str5 == null) {
                str3 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str5, "aigcFeedbackInfo?.negative_text ?: \"\"");
                str3 = str5;
            }
            if (str2.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                if (str3.length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    String U = c.U();
                    if (U == null) {
                        str4 = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(U, "it.id ?: \"\"");
                        str4 = U;
                    }
                    AgreeData p = c.p();
                    if (p != null) {
                        z3 = p.hasAgree;
                    } else {
                        z3 = false;
                    }
                    if (p != null && p.agreeType == 2) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    long j2 = 0;
                    if (p != null) {
                        j = p.agreeNum;
                    } else {
                        j = 0;
                    }
                    if (p != null) {
                        j2 = p.disAgreeNum;
                    }
                    c(new AigcFeedbackViewState(str2, str3, str4, z3, z4, j, j2, String.valueOf(postState.c().p0())), postState.a(), postState.b());
                }
            }
        }
    }

    public final void c(final AigcFeedbackViewState aigcFeedbackViewState, final Function1<? super FeedbackButtonStateType, Unit> function1, final Function0<Boolean> function0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aigcFeedbackViewState, function1, function0) == null) {
            aigcFeedbackViewState.g().c().k(new Function0<Unit>(this, aigcFeedbackViewState) { // from class: com.baidu.tieba.pb.feedback.AigcFeedbackView$updateState$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AigcFeedbackViewState $state;
                public final /* synthetic */ AigcFeedbackView this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aigcFeedbackViewState};
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
                    this.this$0 = this;
                    this.$state = aigcFeedbackViewState;
                }

                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AigcFeedbackViewBinding binding;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                        return;
                    }
                    binding = this.this$0.getBinding();
                    binding.c.a(this.$state.g().b());
                }
            });
            aigcFeedbackViewState.g().e().j(new View.OnClickListener() { // from class: com.baidu.tieba.nl9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        AigcFeedbackView.d(Function0.this, this, aigcFeedbackViewState, function1, view2);
                    }
                }
            });
            aigcFeedbackViewState.g().c().j(new View.OnClickListener() { // from class: com.baidu.tieba.ql9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        AigcFeedbackView.e(Function0.this, this, aigcFeedbackViewState, function1, view2);
                    }
                }
            });
            aigcFeedbackViewState.g().b().j(new View.OnClickListener() { // from class: com.baidu.tieba.ol9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        AigcFeedbackView.f(Function0.this, this, aigcFeedbackViewState, function1, view2);
                    }
                }
            });
            aigcFeedbackViewState.g().d().j(new View.OnClickListener() { // from class: com.baidu.tieba.pl9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        AigcFeedbackView.g(Function0.this, this, aigcFeedbackViewState, function1, view2);
                    }
                }
            });
            aigcFeedbackViewState.g().a().j(new View.OnClickListener() { // from class: com.baidu.tieba.sl9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        AigcFeedbackView.h(Function0.this, this, aigcFeedbackViewState, function1, view2);
                    }
                }
            });
            int i = a.$EnumSwitchMapping$0[aigcFeedbackViewState.f().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        getBinding().c.a(aigcFeedbackViewState.g().e());
                        getBinding().b.a(aigcFeedbackViewState.g().d());
                        am9.c(aigcFeedbackViewState.l(), aigcFeedbackViewState.k(), true, false);
                        am9.c(aigcFeedbackViewState.l(), aigcFeedbackViewState.k(), false, false);
                        return;
                    }
                    return;
                }
                getBinding().c.a(aigcFeedbackViewState.g().e());
                getBinding().b.a(aigcFeedbackViewState.g().a());
                am9.c(aigcFeedbackViewState.l(), aigcFeedbackViewState.k(), true, false);
                am9.c(aigcFeedbackViewState.l(), aigcFeedbackViewState.k(), false, true);
                return;
            }
            getBinding().c.a(aigcFeedbackViewState.g().b());
            getBinding().b.a(aigcFeedbackViewState.g().d());
            am9.c(aigcFeedbackViewState.l(), aigcFeedbackViewState.k(), true, true);
            am9.c(aigcFeedbackViewState.l(), aigcFeedbackViewState.k(), false, false);
        }
    }
}
