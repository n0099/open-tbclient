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
/* loaded from: classes11.dex */
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

    public ArrowDirection(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.value = i3;
    }

    public static ArrowDirection fromInt(int i2) {
        InterceptResult invokeI;
        ArrowDirection[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            for (ArrowDirection arrowDirection : values()) {
                if (i2 == arrowDirection.getValue()) {
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (ArrowDirection) Enum.valueOf(ArrowDirection.class, str) : (ArrowDirection) invokeL.objValue;
    }

    public static ArrowDirection[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (ArrowDirection[]) $VALUES.clone() : (ArrowDirection[]) invokeV.objValue;
    }

    public int getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : invokeV.intValue;
    }
}
