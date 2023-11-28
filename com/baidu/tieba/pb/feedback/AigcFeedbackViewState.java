package com.baidu.tieba.pb.feedback;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.cx9;
import com.baidu.tieba.fx9;
import com.baidu.tieba.gx9;
import com.baidu.tieba.hx9;
import com.baidu.tieba.ix9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\u0018\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\nH\u0002J\b\u0010%\u001a\u00020\u0018H\u0002J\u0006\u0010&\u001a\u00020'R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001e¨\u0006("}, d2 = {"Lcom/baidu/tieba/pb/feedback/AigcFeedbackViewState;", "", "positiveText", "", "negativeText", "postId", "isSelected", "", "isPositive", "agreeNum", "", "disAgreeNum", "tid", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZJJLjava/lang/String;)V", "getAgreeNum", "()J", "getDisAgreeNum", "feedbackButtonTypes", "Lcom/baidu/tieba/pb/feedback/AigcFeedbackTypesState;", "getFeedbackButtonTypes", "()Lcom/baidu/tieba/pb/feedback/AigcFeedbackTypesState;", "feedbackButtonTypes$delegate", "Lkotlin/Lazy;", "feedbackNumState", "Lcom/baidu/tieba/pb/feedback/AigcFeedbackNumState;", "getFeedbackNumState", "()Lcom/baidu/tieba/pb/feedback/AigcFeedbackNumState;", "feedbackNumState$delegate", "()Z", "getNegativeText", "()Ljava/lang/String;", "getPositiveText", "getPostId", "getTid", "buttonText", "text", "num", "feedbackNum", "feedbackType", "Lcom/baidu/tieba/pb/feedback/AigcFeedbackType;", "pb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AigcFeedbackViewState {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;
    public final boolean e;
    public final long f;
    public final long g;
    public final String h;
    public final Lazy i;
    public final Lazy j;

    /* loaded from: classes7.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1552507562, "Lcom/baidu/tieba/pb/feedback/AigcFeedbackViewState$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1552507562, "Lcom/baidu/tieba/pb/feedback/AigcFeedbackViewState$a;");
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

    public AigcFeedbackViewState(String positiveText, String negativeText, String postId, boolean z, boolean z2, long j, long j2, String tid) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {positiveText, negativeText, postId, Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j), Long.valueOf(j2), tid};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(positiveText, "positiveText");
        Intrinsics.checkNotNullParameter(negativeText, "negativeText");
        Intrinsics.checkNotNullParameter(postId, "postId");
        Intrinsics.checkNotNullParameter(tid, "tid");
        this.a = positiveText;
        this.b = negativeText;
        this.c = postId;
        this.d = z;
        this.e = z2;
        this.f = j;
        this.g = j2;
        this.h = tid;
        this.i = LazyKt__LazyJVMKt.lazy(new Function0<cx9>(this) { // from class: com.baidu.tieba.pb.feedback.AigcFeedbackViewState$feedbackNumState$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AigcFeedbackViewState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
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
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final cx9 invoke() {
                InterceptResult invokeV;
                cx9 e;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (cx9) invokeV.objValue;
                }
                e = this.this$0.e();
                return e;
            }
        });
        this.j = LazyKt__LazyJVMKt.lazy(new Function0<fx9>(this) { // from class: com.baidu.tieba.pb.feedback.AigcFeedbackViewState$feedbackButtonTypes$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AigcFeedbackViewState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
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
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final fx9 invoke() {
                InterceptResult invokeV;
                cx9 h;
                String d;
                cx9 h2;
                String d2;
                cx9 h3;
                String d3;
                cx9 h4;
                String d4;
                cx9 h5;
                String d5;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    hx9.a aVar = hx9.a;
                    FeedbackButtonStateType feedbackButtonStateType = FeedbackButtonStateType.SELECT_POSITIVE_STATE;
                    AigcFeedbackViewState aigcFeedbackViewState = this.this$0;
                    String j3 = aigcFeedbackViewState.j();
                    h = this.this$0.h();
                    d = aigcFeedbackViewState.d(j3, h.b().a());
                    gx9 b = hx9.a.b(aVar, feedbackButtonStateType, d, null, null, 12, null);
                    hx9.a aVar2 = hx9.a;
                    FeedbackButtonStateType feedbackButtonStateType2 = FeedbackButtonStateType.SELECTING_POSITIVE_STATE;
                    AigcFeedbackViewState aigcFeedbackViewState2 = this.this$0;
                    String j4 = aigcFeedbackViewState2.j();
                    h2 = this.this$0.h();
                    d2 = aigcFeedbackViewState2.d(j4, h2.b().a());
                    gx9 b2 = hx9.a.b(aVar2, feedbackButtonStateType2, d2, null, null, 12, null);
                    hx9.a aVar3 = hx9.a;
                    FeedbackButtonStateType feedbackButtonStateType3 = FeedbackButtonStateType.SELECT_NEGATIVE_STATE;
                    AigcFeedbackViewState aigcFeedbackViewState3 = this.this$0;
                    String i3 = aigcFeedbackViewState3.i();
                    h3 = this.this$0.h();
                    d3 = aigcFeedbackViewState3.d(i3, h3.a().a());
                    gx9 b3 = hx9.a.b(aVar3, feedbackButtonStateType3, d3, null, null, 12, null);
                    hx9.a aVar4 = hx9.a;
                    FeedbackButtonStateType feedbackButtonStateType4 = FeedbackButtonStateType.UNSELECT_POSITIVE_STATE;
                    AigcFeedbackViewState aigcFeedbackViewState4 = this.this$0;
                    String j5 = aigcFeedbackViewState4.j();
                    h4 = this.this$0.h();
                    d4 = aigcFeedbackViewState4.d(j5, h4.b().b());
                    gx9 b4 = hx9.a.b(aVar4, feedbackButtonStateType4, d4, null, null, 12, null);
                    hx9.a aVar5 = hx9.a;
                    FeedbackButtonStateType feedbackButtonStateType5 = FeedbackButtonStateType.UNSELECT_NEGATIVE_STATE;
                    AigcFeedbackViewState aigcFeedbackViewState5 = this.this$0;
                    String i4 = aigcFeedbackViewState5.i();
                    h5 = this.this$0.h();
                    d5 = aigcFeedbackViewState5.d(i4, h5.a().b());
                    return new fx9(b, b2, b3, b4, hx9.a.b(aVar5, feedbackButtonStateType5, d5, null, null, 12, null));
                }
                return (fx9) invokeV.objValue;
            }
        });
    }

    public final String d(String str, long j) {
        InterceptResult invokeLJ;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, str, j)) == null) {
            if (j < 0) {
                return str;
            }
            String numText = StringHelper.numberUniformFormatExtraWithRound(j);
            Intrinsics.checkNotNullExpressionValue(numText, "numText");
            if (numText.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z && !Intrinsics.areEqual(numText, "0")) {
                return str + WebvttCueParser.CHAR_SPACE + numText;
            }
            return str;
        }
        return (String) invokeLJ.objValue;
    }

    public final cx9 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i = a.$EnumSwitchMapping$0[f().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        long j = this.f;
                        ix9 ix9Var = new ix9(j + 1, j);
                        long j2 = this.g;
                        return new cx9(ix9Var, new ix9(1 + j2, j2));
                    }
                    throw new NoWhenBranchMatchedException();
                }
                long j3 = this.f;
                ix9 ix9Var2 = new ix9(j3 + 1, j3);
                long j4 = this.g;
                return new cx9(ix9Var2, new ix9(j4, j4 - 1));
            }
            long j5 = this.f;
            ix9 ix9Var3 = new ix9(j5, j5 - 1);
            long j6 = this.g;
            return new cx9(ix9Var3, new ix9(1 + j6, j6));
        }
        return (cx9) invokeV.objValue;
    }

    public final AigcFeedbackType f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.d) {
                if (this.e) {
                    return AigcFeedbackType.SELECT_POSITIVE_TYPE;
                }
                return AigcFeedbackType.SELECT_NEGATIVE_TYPE;
            }
            return AigcFeedbackType.UNSELECT_ALL_TYPE;
        }
        return (AigcFeedbackType) invokeV.objValue;
    }

    public final fx9 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return (fx9) this.j.getValue();
        }
        return (fx9) invokeV.objValue;
    }

    public final cx9 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return (cx9) this.i.getValue();
        }
        return (cx9) invokeV.objValue;
    }

    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public final String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public final String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public final String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }
}
