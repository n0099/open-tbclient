package com.baidu.tieba;

import android.view.View;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.pb.feedback.FeedbackButtonStateType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class yl9 {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948334147, "Lcom/baidu/tieba/yl9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948334147, "Lcom/baidu/tieba/yl9;");
                return;
            }
        }
        a = new a(null);
    }

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.yl9$a$a */
        /* loaded from: classes8.dex */
        public /* synthetic */ class C0528a {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1822560951, "Lcom/baidu/tieba/yl9$a$a;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-1822560951, "Lcom/baidu/tieba/yl9$a$a;");
                        return;
                    }
                }
                int[] iArr = new int[FeedbackButtonStateType.values().length];
                iArr[FeedbackButtonStateType.UNSELECT_POSITIVE_STATE.ordinal()] = 1;
                iArr[FeedbackButtonStateType.SELECT_POSITIVE_STATE.ordinal()] = 2;
                iArr[FeedbackButtonStateType.SELECTING_POSITIVE_STATE.ordinal()] = 3;
                iArr[FeedbackButtonStateType.UNSELECT_NEGATIVE_STATE.ordinal()] = 4;
                iArr[FeedbackButtonStateType.SELECT_NEGATIVE_STATE.ordinal()] = 5;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.yl9$a */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ xl9 b(a aVar, FeedbackButtonStateType feedbackButtonStateType, String str, Function0 function0, View.OnClickListener onClickListener, int i, Object obj) {
            if ((i & 4) != 0) {
                function0 = null;
            }
            if ((i & 8) != 0) {
                onClickListener = null;
            }
            return aVar.a(feedbackButtonStateType, str, function0, onClickListener);
        }

        public final xl9 a(FeedbackButtonStateType type, String text, Function0<Unit> function0, View.OnClickListener onClickListener) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, type, text, function0, onClickListener)) == null) {
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(text, "text");
                int i = C0528a.$EnumSwitchMapping$0[type.ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i == 5) {
                                    return new xl9(R.drawable.obfuscated_res_0x7f080c91, text, SkinManager.getColor(R.color.CAM_X0601), fia.a(SkinManager.getColor(R.color.CAM_X0107), 0.08f), R.color.CAM_X0107, false, false, null, onClickListener, 224, null);
                                }
                                throw new NoWhenBranchMatchedException();
                            }
                            return new xl9(R.drawable.obfuscated_res_0x7f080d2d, text, fia.a(SkinManager.getColor(R.color.CAM_X0109), 0.5f), SkinManager.getColor(R.color.CAM_X0601), R.color.CAM_X0109, false, false, null, onClickListener, 224, null);
                        }
                        return new xl9(R.drawable.obfuscated_res_0x7f0808a8, text, SkinManager.getColor(R.color.CAM_X0601), fia.a(SkinManager.getColor(R.color.CAM_X0301), 0.08f), R.color.CAM_X0301, true, false, function0, onClickListener);
                    }
                    return new xl9(R.drawable.obfuscated_res_0x7f080c92, text, SkinManager.getColor(R.color.CAM_X0601), fia.a(SkinManager.getColor(R.color.CAM_X0301), 0.08f), R.color.CAM_X0301, false, false, null, onClickListener, 224, null);
                }
                return new xl9(R.drawable.obfuscated_res_0x7f080d2e, text, fia.a(SkinManager.getColor(R.color.CAM_X0109), 0.5f), SkinManager.getColor(R.color.CAM_X0601), R.color.CAM_X0109, false, false, null, onClickListener, 224, null);
            }
            return (xl9) invokeLLLL.objValue;
        }
    }
}
