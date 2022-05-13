package com.baidu.tieba.recapp.adapter;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.w68;
import com.repackage.yd7;
import com.repackage.z98;
/* loaded from: classes3.dex */
public class CardAppLegoViewHolder extends TypeAdapter.ViewHolder implements w68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public z98 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardAppLegoViewHolder(yd7<?> yd7Var) {
        super((View) yd7Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yd7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void c(int i) {
        z98 z98Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || (z98Var = this.a) == null) {
            return;
        }
        z98Var.autoPlay(i);
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            z98 z98Var = this.a;
            return z98Var != null && z98Var.canPlay();
        }
        return invokeV.booleanValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            z98 z98Var = this.a;
            if (z98Var == null) {
                return -2;
            }
            return z98Var.getPlayStatus();
        }
        return invokeV.intValue;
    }

    public void f(z98 z98Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, z98Var) == null) {
            this.a = z98Var;
        }
    }

    @Override // com.repackage.w68
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            z98 z98Var = this.a;
            if (z98Var == null) {
                return 0;
            }
            return (int) z98Var.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.w68
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            z98 z98Var = this.a;
            return z98Var == null ? "" : z98Var.getPlayUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.w68
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            z98 z98Var = this.a;
            if (z98Var == null) {
                return null;
            }
            return z98Var.getVideoContainer();
        }
        return (View) invokeV.objValue;
    }

    @Override // com.repackage.w68
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.w68
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            z98 z98Var = this.a;
            if (z98Var == null) {
                return false;
            }
            return z98Var.isPlayStarted();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.w68
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            z98 z98Var = this.a;
            if (z98Var == null) {
                return false;
            }
            return z98Var.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.w68
    public void startPlay() {
        z98 z98Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (z98Var = this.a) == null) {
            return;
        }
        z98Var.startPlay();
    }

    @Override // com.repackage.w68
    public void stopPlay() {
        z98 z98Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (z98Var = this.a) == null) {
            return;
        }
        z98Var.stopPlay();
    }
}
