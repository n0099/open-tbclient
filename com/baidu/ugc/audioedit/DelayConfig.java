package com.baidu.ugc.audioedit;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes10.dex */
public class DelayConfig implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MODE_PART_SECTION = 2;
    public static final int MODE_WHOLE_SECTION = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public float decrease;
    public int delayMode;
    public int delayTime;
    public int newPosition;
    public int[] pairTimeArray;
    public int pairTimeLength;

    public DelayConfig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.delayMode = 1;
        this.delayTime = -1;
        this.decrease = -1.0f;
        this.newPosition = -1;
    }

    public boolean available() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.delayTime < 0) {
                float f2 = this.decrease;
                if ((f2 < 0.0f || f2 > 1.0f) && ((this.pairTimeLength <= 0 || this.pairTimeArray == null) && this.newPosition < 0)) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public float getDecrease() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.decrease : invokeV.floatValue;
    }

    public int getDelayMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.delayMode : invokeV.intValue;
    }

    public int getDelayTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.delayTime : invokeV.intValue;
    }

    public int getNewPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.newPosition : invokeV.intValue;
    }

    public int[] getPairTimeArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.pairTimeArray : (int[]) invokeV.objValue;
    }

    public int getPairTimeLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.pairTimeLength : invokeV.intValue;
    }

    public DelayConfig setDecrease(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048583, this, f2)) == null) {
            this.decrease = f2;
            return this;
        }
        return (DelayConfig) invokeF.objValue;
    }

    public DelayConfig setDelayInterval(int i2, int[] iArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, iArr)) == null) {
            this.pairTimeLength = i2;
            this.pairTimeArray = iArr;
            return this;
        }
        return (DelayConfig) invokeIL.objValue;
    }

    public DelayConfig setDelayTime(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            this.delayTime = i2;
            return this;
        }
        return (DelayConfig) invokeI.objValue;
    }

    public DelayConfig setNewPosition(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            this.newPosition = i2;
            return this;
        }
        return (DelayConfig) invokeI.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return "DelayConfig{delayMode=" + this.delayMode + ", delayTime=" + this.delayTime + ", decrease=" + this.decrease + ", pairTimeLength=" + this.pairTimeLength + ", pairTimeArray=" + Arrays.toString(this.pairTimeArray) + ", newPosition=" + this.newPosition + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
