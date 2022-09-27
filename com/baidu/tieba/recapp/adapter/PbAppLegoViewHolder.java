package com.baidu.tieba.recapp.adapter;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.jh7;
import com.baidu.tieba.ka8;
import com.baidu.tieba.rd8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PbAppLegoViewHolder extends TypeAdapter.ViewHolder implements ka8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jh7<?> a;
    public rd8 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbAppLegoViewHolder(jh7<?> jh7Var) {
        super((View) jh7Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jh7Var};
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
        this.a = jh7Var;
    }

    public void a(int i) {
        rd8 rd8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || (rd8Var = this.b) == null) {
            return;
        }
        rd8Var.autoPlay(i);
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            rd8 rd8Var = this.b;
            if (rd8Var == null) {
                return false;
            }
            return rd8Var.canPlay();
        }
        return invokeV.booleanValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            rd8 rd8Var = this.b;
            if (rd8Var != null) {
                return rd8Var.getPlayStatus();
            }
            return -2;
        }
        return invokeV.intValue;
    }

    public void d() {
        rd8 rd8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (rd8Var = this.b) == null) {
            return;
        }
        rd8Var.release();
    }

    public void e(rd8 rd8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, rd8Var) == null) {
            this.b = rd8Var;
        }
    }

    public void f() {
        jh7<?> jh7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (jh7Var = this.a) == null) {
            return;
        }
        jh7Var.f();
    }

    @Override // com.baidu.tieba.ka8
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            rd8 rd8Var = this.b;
            if (rd8Var == null) {
                return 0;
            }
            return (int) rd8Var.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ka8
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            rd8 rd8Var = this.b;
            return rd8Var == null ? "" : rd8Var.getPlayUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ka8
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            rd8 rd8Var = this.b;
            if (rd8Var == null) {
                return null;
            }
            return rd8Var.getVideoContainer();
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ka8
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ka8
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            rd8 rd8Var = this.b;
            if (rd8Var == null) {
                return false;
            }
            return rd8Var.isPlayStarted();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ka8
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            rd8 rd8Var = this.b;
            if (rd8Var == null) {
                return false;
            }
            return rd8Var.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ka8
    public void startPlay() {
        rd8 rd8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (rd8Var = this.b) == null) {
            return;
        }
        rd8Var.startPlay();
    }

    @Override // com.baidu.tieba.ka8
    public void stopPlay() {
        rd8 rd8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (rd8Var = this.b) == null) {
            return;
        }
        rd8Var.stopPlay();
    }
}
