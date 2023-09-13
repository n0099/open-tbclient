package com.baidu.tieba;

import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.inlinewidget.rtcroom.model.RtcStatus;
import com.baidu.tieba.ep2;
import com.baidu.tieba.rr2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ks4 implements rr2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ep2
    public void A(@NonNull ep2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
        }
    }

    @Override // com.baidu.tieba.rr2
    public void W(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
        }
    }

    @Override // com.baidu.tieba.ep2
    @Nullable
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rr2
    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.rr2
    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ep2
    @Nullable
    public String j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rr2
    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.rr2
    public void o(@NonNull rr2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
        }
    }

    @Override // com.baidu.tieba.tr2
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // com.baidu.tieba.rr2
    public void onSurfaceChanged(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i, i2) == null) {
        }
    }

    @Override // com.baidu.tieba.tr2
    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.rr2
    public void s(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048588, this, i, i2, i3, i4) == null) {
        }
    }

    @Override // com.baidu.tieba.rr2
    public void setSurface(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, surface) == null) {
        }
    }

    @Override // com.baidu.tieba.rr2
    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
        }
    }

    public ks4() {
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

    @Override // com.baidu.tieba.tr2
    public RtcStatus a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return RtcStatus.UNKNOWN;
        }
        return (RtcStatus) invokeV.objValue;
    }
}
