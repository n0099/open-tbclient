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
import com.repackage.h58;
import com.repackage.n88;
import com.repackage.xc7;
/* loaded from: classes3.dex */
public class PbAppLegoViewHolder extends TypeAdapter.ViewHolder implements h58 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xc7<?> a;
    public n88 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbAppLegoViewHolder(xc7<?> xc7Var) {
        super((View) xc7Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xc7Var};
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
        this.a = xc7Var;
    }

    public void c(int i) {
        n88 n88Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || (n88Var = this.b) == null) {
            return;
        }
        n88Var.autoPlay(i);
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            n88 n88Var = this.b;
            if (n88Var == null) {
                return false;
            }
            return n88Var.canPlay();
        }
        return invokeV.booleanValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            n88 n88Var = this.b;
            if (n88Var != null) {
                return n88Var.getPlayStatus();
            }
            return -2;
        }
        return invokeV.intValue;
    }

    public void f() {
        n88 n88Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (n88Var = this.b) == null) {
            return;
        }
        n88Var.release();
    }

    public void g(n88 n88Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, n88Var) == null) {
            this.b = n88Var;
        }
    }

    @Override // com.repackage.h58
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            n88 n88Var = this.b;
            if (n88Var == null) {
                return 0;
            }
            return (int) n88Var.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.h58
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            n88 n88Var = this.b;
            return n88Var == null ? "" : n88Var.getPlayUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.h58
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            n88 n88Var = this.b;
            if (n88Var == null) {
                return null;
            }
            return n88Var.getVideoContainer();
        }
        return (View) invokeV.objValue;
    }

    public void h() {
        xc7<?> xc7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (xc7Var = this.a) == null) {
            return;
        }
        xc7Var.e();
    }

    @Override // com.repackage.h58
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.h58
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            n88 n88Var = this.b;
            if (n88Var == null) {
                return false;
            }
            return n88Var.isPlayStarted();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.h58
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            n88 n88Var = this.b;
            if (n88Var == null) {
                return false;
            }
            return n88Var.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.h58
    public void startPlay() {
        n88 n88Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (n88Var = this.b) == null) {
            return;
        }
        n88Var.startPlay();
    }

    @Override // com.repackage.h58
    public void stopPlay() {
        n88 n88Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (n88Var = this.b) == null) {
            return;
        }
        n88Var.stopPlay();
    }
}
