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
import com.repackage.aa8;
import com.repackage.sd7;
import com.repackage.w68;
/* loaded from: classes3.dex */
public class CardAppLegoViewHolder extends TypeAdapter.ViewHolder implements w68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public aa8 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardAppLegoViewHolder(sd7<?> sd7Var) {
        super((View) sd7Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sd7Var};
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
        aa8 aa8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || (aa8Var = this.a) == null) {
            return;
        }
        aa8Var.autoPlay(i);
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            aa8 aa8Var = this.a;
            return aa8Var != null && aa8Var.canPlay();
        }
        return invokeV.booleanValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            aa8 aa8Var = this.a;
            if (aa8Var == null) {
                return -2;
            }
            return aa8Var.getPlayStatus();
        }
        return invokeV.intValue;
    }

    public void f(aa8 aa8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aa8Var) == null) {
            this.a = aa8Var;
        }
    }

    @Override // com.repackage.w68
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            aa8 aa8Var = this.a;
            if (aa8Var == null) {
                return 0;
            }
            return (int) aa8Var.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.w68
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            aa8 aa8Var = this.a;
            return aa8Var == null ? "" : aa8Var.getPlayUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.w68
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            aa8 aa8Var = this.a;
            if (aa8Var == null) {
                return null;
            }
            return aa8Var.getVideoContainer();
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
            aa8 aa8Var = this.a;
            if (aa8Var == null) {
                return false;
            }
            return aa8Var.isPlayStarted();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.w68
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            aa8 aa8Var = this.a;
            if (aa8Var == null) {
                return false;
            }
            return aa8Var.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.w68
    public void startPlay() {
        aa8 aa8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (aa8Var = this.a) == null) {
            return;
        }
        aa8Var.startPlay();
    }

    @Override // com.repackage.w68
    public void stopPlay() {
        aa8 aa8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (aa8Var = this.a) == null) {
            return;
        }
        aa8Var.stopPlay();
    }
}
