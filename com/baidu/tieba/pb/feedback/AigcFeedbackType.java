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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/baidu/tieba/pb/feedback/AigcFeedbackType;", "", "(Ljava/lang/String;I)V", "SELECT_POSITIVE_TYPE", "SELECT_NEGATIVE_TYPE", "UNSELECT_ALL_TYPE", "pb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AigcFeedbackType {
    public static final /* synthetic */ AigcFeedbackType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final AigcFeedbackType SELECT_NEGATIVE_TYPE;
    public static final AigcFeedbackType SELECT_POSITIVE_TYPE;
    public static final AigcFeedbackType UNSELECT_ALL_TYPE;
    public transient /* synthetic */ FieldHolder $fh;

    public static final /* synthetic */ AigcFeedbackType[] $values() {
        return new AigcFeedbackType[]{SELECT_POSITIVE_TYPE, SELECT_NEGATIVE_TYPE, UNSELECT_ALL_TYPE};
    }

    public static AigcFeedbackType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (AigcFeedbackType) Enum.valueOf(AigcFeedbackType.class, str) : (AigcFeedbackType) invokeL.objValue;
    }

    public static AigcFeedbackType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (AigcFeedbackType[]) $VALUES.clone() : (AigcFeedbackType[]) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1358557667, "Lcom/baidu/tieba/pb/feedback/AigcFeedbackType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1358557667, "Lcom/baidu/tieba/pb/feedback/AigcFeedbackType;");
                return;
            }
        }
        SELECT_POSITIVE_TYPE = new AigcFeedbackType("SELECT_POSITIVE_TYPE", 0);
        SELECT_NEGATIVE_TYPE = new AigcFeedbackType("SELECT_NEGATIVE_TYPE", 1);
        UNSELECT_ALL_TYPE = new AigcFeedbackType("UNSELECT_ALL_TYPE", 2);
        $VALUES = $values();
    }

    public AigcFeedbackType(String str, int i) {
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
