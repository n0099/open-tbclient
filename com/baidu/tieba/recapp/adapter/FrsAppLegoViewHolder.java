package com.baidu.tieba.recapp.adapter;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.iu9;
import com.baidu.tieba.jy9;
import com.baidu.tieba.p09;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class FrsAppLegoViewHolder extends TypeAdapter.ViewHolder implements iu9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jy9 a;

    @Override // com.baidu.tieba.iu9
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsAppLegoViewHolder(p09<?> p09Var) {
        super((View) p09Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {p09Var};
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

    public void b() {
        jy9 jy9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (jy9Var = this.a) != null) {
            jy9Var.release();
        }
    }

    @Override // com.baidu.tieba.iu9
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            jy9 jy9Var = this.a;
            if (jy9Var == null) {
                return 0;
            }
            return (int) jy9Var.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.iu9
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            jy9 jy9Var = this.a;
            if (jy9Var == null) {
                return "";
            }
            return jy9Var.getPlayUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.iu9
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            jy9 jy9Var = this.a;
            if (jy9Var == null) {
                return null;
            }
            return jy9Var.getVideoContainer();
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.iu9
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            jy9 jy9Var = this.a;
            if (jy9Var == null) {
                return false;
            }
            return jy9Var.isPlayStarted();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.iu9
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            jy9 jy9Var = this.a;
            if (jy9Var == null) {
                return false;
            }
            return jy9Var.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.iu9
    public void startPlay() {
        jy9 jy9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (jy9Var = this.a) != null) {
            jy9Var.startPlay();
        }
    }

    @Override // com.baidu.tieba.iu9
    public void stopPlay() {
        jy9 jy9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (jy9Var = this.a) != null) {
            jy9Var.stopPlay();
        }
    }

    public void c(jy9 jy9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jy9Var) == null) {
            this.a = jy9Var;
        }
    }
}
