package com.baidu.tieba.recapp.adapter;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ec8;
import com.baidu.tieba.ej7;
import com.baidu.tieba.lf8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class CardAppLegoViewHolder extends TypeAdapter.ViewHolder implements ec8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lf8 a;

    @Override // com.baidu.tieba.ec8
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardAppLegoViewHolder(ej7<?> ej7Var) {
        super((View) ej7Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ej7Var};
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
        lf8 lf8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && (lf8Var = this.a) != null) {
            lf8Var.autoPlay(i);
        }
    }

    public void d(lf8 lf8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, lf8Var) == null) {
            this.a = lf8Var;
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            lf8 lf8Var = this.a;
            if (lf8Var != null && lf8Var.canPlay()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            lf8 lf8Var = this.a;
            if (lf8Var == null) {
                return -2;
            }
            return lf8Var.getPlayStatus();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ec8
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            lf8 lf8Var = this.a;
            if (lf8Var == null) {
                return 0;
            }
            return (int) lf8Var.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ec8
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            lf8 lf8Var = this.a;
            if (lf8Var == null) {
                return "";
            }
            return lf8Var.getPlayUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ec8
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            lf8 lf8Var = this.a;
            if (lf8Var == null) {
                return null;
            }
            return lf8Var.getVideoContainer();
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ec8
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            lf8 lf8Var = this.a;
            if (lf8Var == null) {
                return false;
            }
            return lf8Var.isPlayStarted();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ec8
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            lf8 lf8Var = this.a;
            if (lf8Var == null) {
                return false;
            }
            return lf8Var.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ec8
    public void startPlay() {
        lf8 lf8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (lf8Var = this.a) != null) {
            lf8Var.startPlay();
        }
    }

    @Override // com.baidu.tieba.ec8
    public void stopPlay() {
        lf8 lf8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (lf8Var = this.a) != null) {
            lf8Var.stopPlay();
        }
    }
}
