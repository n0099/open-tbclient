package com.baidu.tieba.view.bubbleView;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes6.dex */
public final class ArrowDirection {
    public static final /* synthetic */ ArrowDirection[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ArrowDirection BOTTOM;
    public static final ArrowDirection LEFT;
    public static final ArrowDirection RIGHT;
    public static final ArrowDirection TOP;
    public transient /* synthetic */ FieldHolder $fh;
    public int value;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1796153661, "Lcom/baidu/tieba/view/bubbleView/ArrowDirection;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1796153661, "Lcom/baidu/tieba/view/bubbleView/ArrowDirection;");
                return;
            }
        }
        LEFT = new ArrowDirection("LEFT", 0, 0);
        RIGHT = new ArrowDirection("RIGHT", 1, 1);
        TOP = new ArrowDirection("TOP", 2, 2);
        ArrowDirection arrowDirection = new ArrowDirection("BOTTOM", 3, 3);
        BOTTOM = arrowDirection;
        $VALUES = new ArrowDirection[]{LEFT, RIGHT, TOP, arrowDirection};
    }

    public ArrowDirection(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.value = i2;
    }

    public static ArrowDirection fromInt(int i) {
        InterceptResult invokeI;
        ArrowDirection[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            for (ArrowDirection arrowDirection : values()) {
                if (i == arrowDirection.getValue()) {
                    return arrowDirection;
                }
            }
            return LEFT;
        }
        return (ArrowDirection) invokeI.objValue;
    }

    public static ArrowDirection valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return (ArrowDirection) Enum.valueOf(ArrowDirection.class, str);
        }
        return (ArrowDirection) invokeL.objValue;
    }

    public static ArrowDirection[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return (ArrowDirection[]) $VALUES.clone();
        }
        return (ArrowDirection[]) invokeV.objValue;
    }

    public int getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.value;
        }
        return invokeV.intValue;
    }
}
