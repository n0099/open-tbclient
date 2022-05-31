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
import com.repackage.d48;
import com.repackage.g78;
import com.repackage.mb7;
/* loaded from: classes3.dex */
public class PbAppLegoViewHolder extends TypeAdapter.ViewHolder implements d48 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mb7<?> a;
    public g78 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbAppLegoViewHolder(mb7<?> mb7Var) {
        super((View) mb7Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mb7Var};
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
        this.a = mb7Var;
    }

    public void c(int i) {
        g78 g78Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || (g78Var = this.b) == null) {
            return;
        }
        g78Var.autoPlay(i);
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            g78 g78Var = this.b;
            if (g78Var == null) {
                return false;
            }
            return g78Var.canPlay();
        }
        return invokeV.booleanValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            g78 g78Var = this.b;
            if (g78Var != null) {
                return g78Var.getPlayStatus();
            }
            return -2;
        }
        return invokeV.intValue;
    }

    public void f() {
        g78 g78Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (g78Var = this.b) == null) {
            return;
        }
        g78Var.release();
    }

    public void g(g78 g78Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, g78Var) == null) {
            this.b = g78Var;
        }
    }

    @Override // com.repackage.d48
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            g78 g78Var = this.b;
            if (g78Var == null) {
                return 0;
            }
            return (int) g78Var.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.d48
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            g78 g78Var = this.b;
            return g78Var == null ? "" : g78Var.getPlayUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.d48
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            g78 g78Var = this.b;
            if (g78Var == null) {
                return null;
            }
            return g78Var.getVideoContainer();
        }
        return (View) invokeV.objValue;
    }

    public void h() {
        mb7<?> mb7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (mb7Var = this.a) == null) {
            return;
        }
        mb7Var.e();
    }

    @Override // com.repackage.d48
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.d48
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            g78 g78Var = this.b;
            if (g78Var == null) {
                return false;
            }
            return g78Var.isPlayStarted();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.d48
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            g78 g78Var = this.b;
            if (g78Var == null) {
                return false;
            }
            return g78Var.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.d48
    public void startPlay() {
        g78 g78Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (g78Var = this.b) == null) {
            return;
        }
        g78Var.startPlay();
    }

    @Override // com.repackage.d48
    public void stopPlay() {
        g78 g78Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (g78Var = this.b) == null) {
            return;
        }
        g78Var.stopPlay();
    }
}
