package com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputTool;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class ToolState {
    public static final /* synthetic */ ToolState[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ToolState TEXT;
    public static final ToolState VOICE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-941942883, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/inputTool/ToolState;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-941942883, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/inputTool/ToolState;");
                return;
            }
        }
        VOICE = new ToolState("VOICE", 0);
        ToolState toolState = new ToolState("TEXT", 1);
        TEXT = toolState;
        $VALUES = new ToolState[]{VOICE, toolState};
    }

    public ToolState(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static ToolState valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (ToolState) Enum.valueOf(ToolState.class, str);
        }
        return (ToolState) invokeL.objValue;
    }

    public static ToolState[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (ToolState[]) $VALUES.clone();
        }
        return (ToolState[]) invokeV.objValue;
    }
}
