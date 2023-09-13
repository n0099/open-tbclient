package com.baidu.tieba.pb.feedback;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/baidu/tieba/pb/feedback/FeedbackButtonStateType;", "", "(Ljava/lang/String;I)V", "UNSELECT_POSITIVE_STATE", "SELECT_POSITIVE_STATE", "SELECTING_POSITIVE_STATE", "UNSELECT_NEGATIVE_STATE", "SELECT_NEGATIVE_STATE", "pb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class FeedbackButtonStateType {
    public static final /* synthetic */ FeedbackButtonStateType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final FeedbackButtonStateType SELECTING_POSITIVE_STATE;
    public static final FeedbackButtonStateType SELECT_NEGATIVE_STATE;
    public static final FeedbackButtonStateType SELECT_POSITIVE_STATE;
    public static final FeedbackButtonStateType UNSELECT_NEGATIVE_STATE;
    public static final FeedbackButtonStateType UNSELECT_POSITIVE_STATE;
    public transient /* synthetic */ FieldHolder $fh;

    public static final /* synthetic */ FeedbackButtonStateType[] $values() {
        return new FeedbackButtonStateType[]{UNSELECT_POSITIVE_STATE, SELECT_POSITIVE_STATE, SELECTING_POSITIVE_STATE, UNSELECT_NEGATIVE_STATE, SELECT_NEGATIVE_STATE};
    }

    public static FeedbackButtonStateType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (FeedbackButtonStateType) Enum.valueOf(FeedbackButtonStateType.class, str) : (FeedbackButtonStateType) invokeL.objValue;
    }

    public static FeedbackButtonStateType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (FeedbackButtonStateType[]) $VALUES.clone() : (FeedbackButtonStateType[]) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-665622014, "Lcom/baidu/tieba/pb/feedback/FeedbackButtonStateType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-665622014, "Lcom/baidu/tieba/pb/feedback/FeedbackButtonStateType;");
                return;
            }
        }
        UNSELECT_POSITIVE_STATE = new FeedbackButtonStateType("UNSELECT_POSITIVE_STATE", 0);
        SELECT_POSITIVE_STATE = new FeedbackButtonStateType("SELECT_POSITIVE_STATE", 1);
        SELECTING_POSITIVE_STATE = new FeedbackButtonStateType("SELECTING_POSITIVE_STATE", 2);
        UNSELECT_NEGATIVE_STATE = new FeedbackButtonStateType("UNSELECT_NEGATIVE_STATE", 3);
        SELECT_NEGATIVE_STATE = new FeedbackButtonStateType("SELECT_NEGATIVE_STATE", 4);
        $VALUES = $values();
    }

    public FeedbackButtonStateType(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
            }
        }
    }
}
