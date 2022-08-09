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
import com.repackage.j88;
import com.repackage.kf7;
import com.repackage.pb8;
/* loaded from: classes4.dex */
public class CardAppLegoViewHolder extends TypeAdapter.ViewHolder implements j88 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pb8 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardAppLegoViewHolder(kf7<?> kf7Var) {
        super((View) kf7Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kf7Var};
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

    public void a(int i) {
        pb8 pb8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || (pb8Var = this.a) == null) {
            return;
        }
        pb8Var.autoPlay(i);
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            pb8 pb8Var = this.a;
            return pb8Var != null && pb8Var.canPlay();
        }
        return invokeV.booleanValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            pb8 pb8Var = this.a;
            if (pb8Var == null) {
                return -2;
            }
            return pb8Var.getPlayStatus();
        }
        return invokeV.intValue;
    }

    public void d(pb8 pb8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pb8Var) == null) {
            this.a = pb8Var;
        }
    }

    @Override // com.repackage.j88
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            pb8 pb8Var = this.a;
            if (pb8Var == null) {
                return 0;
            }
            return (int) pb8Var.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.j88
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            pb8 pb8Var = this.a;
            return pb8Var == null ? "" : pb8Var.getPlayUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.j88
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            pb8 pb8Var = this.a;
            if (pb8Var == null) {
                return null;
            }
            return pb8Var.getVideoContainer();
        }
        return (View) invokeV.objValue;
    }

    @Override // com.repackage.j88
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.j88
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            pb8 pb8Var = this.a;
            if (pb8Var == null) {
                return false;
            }
            return pb8Var.isPlayStarted();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.j88
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            pb8 pb8Var = this.a;
            if (pb8Var == null) {
                return false;
            }
            return pb8Var.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.j88
    public void startPlay() {
        pb8 pb8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (pb8Var = this.a) == null) {
            return;
        }
        pb8Var.startPlay();
    }

    @Override // com.repackage.j88
    public void stopPlay() {
        pb8 pb8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (pb8Var = this.a) == null) {
            return;
        }
        pb8Var.stopPlay();
    }
}
